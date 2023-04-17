package com.xalpol12.helpers;

import com.xalpol12.xmlentity.Augmentation;
import com.xalpol12.xmlentity.Node;
import com.xalpol12.xmlentity.Target;
import com.xalpol12.xmlentity.TargetBase;

import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

public class AugmentationManager {
    private final TargetBase targetBase;
    private final Target target;
    private final Node targetMainNode;
    private final List<Node> targetSubNodes;
    private final Node ioMainNode;
    private final List<Node> ioSubNodes;

    public AugmentationManager(Augmentation augmentation) {
        targetBase = augmentation.getTargetBase();
        target = targetBase.getTarget();
        targetMainNode = target.getNode();
        targetSubNodes = targetMainNode.getNodeList();
        ioMainNode = findIONode(targetSubNodes);
        ioSubNodes = Objects.requireNonNull(ioMainNode).getNodeList();
    }

    // checks for first non-zero indexed node with empty "view", "collapse" and "show" - it is important
    // to maintain order of nodes between parsings
    private Node findIONode(List<Node> nodes) {
        for (Node node : nodes) {
            if (node.getView().equals("") && node.getCollapse().equals("")
                    && node.getShow().equals("") && node.getTx() == null
                    && nodes.indexOf(node) != 0) {
                return node;
            }
        }
        return null;
    }

    // checks for node with "view" containing _inputs
    private Node findInputNode(List<Node> nodes) {
        for (Node node : nodes) {
            if (node.getView().contains("_inputs") && !node.getView().contains("_IO")) return node;
        }
        return null;
    }

    public void insertInputObjects(Augmentation augmentation, List<Node> objects) {
        Node inputsMainNode = findInputNode(ioSubNodes);
        List<Node> newInputObjects;
        if (inputsMainNode != null) {
             newInputObjects = Stream.concat(inputsMainNode.getNodeList().stream(), objects.stream()).toList();
        } else {
            newInputObjects = objects;
        }

        // prevents node duplication upon insertion
        targetSubNodes.remove(ioMainNode);
        ioSubNodes.remove(inputsMainNode);

        // add new inputMainNode to the parent list at second to last index
        inputsMainNode.setNodeList(newInputObjects);
        ioSubNodes.add(ioSubNodes.size() - 2, inputsMainNode);

        // wrap remaining elements to their respective parent nodes
        ioMainNode.setNodeList(ioSubNodes);
        targetSubNodes.add(targetSubNodes.size() - 1, ioMainNode);
        targetMainNode.setNodeList(targetSubNodes);
        target.setNode(targetMainNode);
        targetBase.setTarget(target);
        augmentation.setTargetBase(targetBase);
    }

    public void deleteAllInputObjects(Augmentation augmentation) {
        Node inputsMainNode = findInputNode(ioSubNodes);
        inputsMainNode.getNodeList().clear();
    }
}