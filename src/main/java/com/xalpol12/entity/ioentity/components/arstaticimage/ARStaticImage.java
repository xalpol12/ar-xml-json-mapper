package com.xalpol12.entity.ioentity.components.arstaticimage;

import com.xalpol12.entity.ioentity.components.IOComponent;
import com.xalpol12.entity.xmlentity.Model;
import com.xalpol12.entity.xmlentity.Node;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ARStaticImage extends IOComponent {
    private Node subNode;
    private Model model;

    public ARStaticImage(Node mainNode, Node subNode, Model model) {
        super(mainNode);
        this.subNode = subNode;
        this.model = model;
        subNode.setModel(model);
        mainNode.setNodeList(Stream.of(subNode).collect(Collectors.toList()));
    }
}
