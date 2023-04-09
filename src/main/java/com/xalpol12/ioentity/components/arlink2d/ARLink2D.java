package com.xalpol12.ioentity.components.arlink2d;

import com.xalpol12.ioentity.components.IOComponent;
import com.xalpol12.xmlentity.Link;
import com.xalpol12.xmlentity.Model;
import com.xalpol12.xmlentity.Node;

import java.util.List;

public class ARLink2D extends IOComponent {
    private Node subNode;
    private Model model;
    private Link link;

    public ARLink2D(Node mainNode, Node subNode, Model model, Link link) {
        super(mainNode);
        this.subNode = subNode;
        this.model = model;
        this.link = link;
        model.setLink(link);
        subNode.setModel(model);
        mainNode.setNodeList(List.of(subNode));
    }
}
