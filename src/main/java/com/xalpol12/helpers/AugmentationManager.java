package com.xalpol12.helpers;

import com.xalpol12.xmlentity.Augmentation;
import com.xalpol12.xmlentity.Node;
import com.xalpol12.xmlentity.Target;
import com.xalpol12.xmlentity.TargetBase;

import java.util.List;
import java.util.stream.Stream;

public class AugmentationManager {
    public static Augmentation insertObjects(Augmentation augmentation, List<Node> objects) {
        TargetBase targetBase = augmentation.getTargetBase(); // unwrap all parent elements
        Target target = targetBase.getTarget();
        Node targetNode = target.getNode();
        List<Node> nodes = targetNode.getNodeList();
        Node ioMainNode = nodes.get(3); // TODO: Replace with list searching for elements containing a keyword
        List<Node> ioSubNodes = ioMainNode.getNodeList();
        Node inputsMainNode = ioSubNodes.get(1); // index of Inputs [ar-node] in Joining_01
        List<Node> remainingInputObjects = inputsMainNode.getNodeList();

        // Hierarchy: Augmentation -> TargetBase -> Target -> targetNode -> nodes -> ioMainNode -> ioSubNodes -> inputsMainNode
        nodes.remove(ioMainNode);                   // remove old ioMainNode that will be replaced by ioMainNode with
                                                    // modified subNodes

        ioSubNodes.remove(inputsMainNode);          // firstly remove old inputMainNode from parent list

        // concatenate new objects with already written object:
        List<Node> newInputObjects = Stream.concat(remainingInputObjects.stream(), objects.stream()).toList();

        inputsMainNode.setNodeList(newInputObjects);        // set new inputMainNode which replaces the old one
        ioSubNodes.add(ioSubNodes.size() - 2, inputsMainNode);  // add new inputMainNode to the parent list at second to last index

        ioMainNode.setNodeList(ioSubNodes);         // wrap remaining elements to their respective parent nodes
        nodes.add(nodes.size() - 1, ioMainNode);
        targetNode.setNodeList(nodes);
        target.setNode(targetNode);
        targetBase.setTarget(target);
        augmentation.setTargetBase(targetBase);

        return augmentation;
    }
}
