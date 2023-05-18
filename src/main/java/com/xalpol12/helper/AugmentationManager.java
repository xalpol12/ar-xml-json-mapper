package com.xalpol12.helper;

import com.xalpol12.entity.xmlentity.Augmentation;
import com.xalpol12.entity.xmlentity.Node;
import com.xalpol12.entity.xmlentity.Target;
import com.xalpol12.entity.xmlentity.TargetBase;

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

    public void insertInputObjects(Augmentation augmentation, List<Node> objects, List<String> viewList) {
        Node inputsMainNode = findInputNode(ioSubNodes);
        replaceNodeContent(objects, viewList, inputsMainNode);
        ioSubNodes.add(ioSubNodes.size() - 2, inputsMainNode);

        // wrap remaining elements to their respective parent nodes
        ioMainNode.setNodeList(ioSubNodes);
        targetSubNodes.add(targetSubNodes.size() - 1, ioMainNode);
        targetMainNode.setNodeList(targetSubNodes);
        target.setNode(targetMainNode);
        targetBase.setTarget(target);
        augmentation.setTargetBase(targetBase);
    }

    public void deleteAllInputObjects() {
        Node inputsMainNode = findInputNode(ioSubNodes);
        inputsMainNode.getNodeList().clear();
    }

    public void insertOutputObjects(Augmentation augmentation, List<Node> objects, List<String> viewList) {
        Node outputsMainNode = findOutputNode(ioSubNodes);
        replaceNodeContent(objects, viewList, outputsMainNode);
        ioSubNodes.add(ioSubNodes.size() - 1, outputsMainNode);


        ioMainNode.setNodeList(ioSubNodes);
        targetSubNodes.add(targetSubNodes.size() - 1, ioMainNode);
        targetMainNode.setNodeList(targetSubNodes);
        target.setNode(targetMainNode);
        targetBase.setTarget(target);
        augmentation.setTargetBase(targetBase);
    }

    public void deleteAllOutputObjects() {
        Node outputsMainNode = findOutputNode(ioSubNodes);
        outputsMainNode.getNodeList().clear();
    }

    private void replaceNodeContent(List<Node> objects, List<String> viewList, Node outputsMainNode) {
        List<Node> newOutputObjects;
        if (outputsMainNode.getNodeList() != null) {
            newOutputObjects = Stream.concat(outputsMainNode.getNodeList().stream(), objects.stream()).toList();
        } else {
            newOutputObjects = objects;
        }

        targetSubNodes.remove(ioMainNode);
        ioSubNodes.remove(outputsMainNode);

        outputsMainNode.setNodeList(newOutputObjects);
        outputsMainNode.setView(viewList.toString()
                .replace("[", "")
                .replace("]", ""));
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
    private Node findInputNode(List<Node> ioSubNodes) {
        for (Node node : ioSubNodes) {
            if (node.getView().contains("_inputs") && !node.getView().contains("_IO"))
                return node;
        }
        return null;
    }

    // checks for node with "view" containing _outputs
    private Node findOutputNode(List<Node> ioSubNodes) {
        for (Node node : ioSubNodes) {
            if (node.getView().contains("_outputs") && !node.getView().contains("_IO")) {
                return node;
            }
        }
        return null;
    }
}