package com.xalpol12.ioentity.components.arnode;

import com.xalpol12.ioentity.components.IOComponent;
import com.xalpol12.xmlentity.Node;

import java.util.List;

public class ARNode extends IOComponent {
    List<Node> subNodes;
    public ARNode(Node mainNode, List<Node> subNodes) {
        super(mainNode);
        this.subNodes = subNodes;
        mainNode.setNodeList(subNodes);
    }
}
