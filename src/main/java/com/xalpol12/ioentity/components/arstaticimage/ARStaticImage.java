package com.xalpol12.ioentity.components.arstaticimage;

import com.xalpol12.ioentity.components.IOComponent;
import com.xalpol12.xmlentity.Model;
import com.xalpol12.xmlentity.Node;

import java.util.List;

public class ARStaticImage extends IOComponent {
    private Node subNode;
    private Model model;

    public ARStaticImage(Node mainNode, Node subNode, Model model) {
        super(mainNode);
        this.subNode = subNode;
        this.model = model;
        subNode.setModel(model);
        mainNode.setNodeList(List.of(subNode));
    }
}
