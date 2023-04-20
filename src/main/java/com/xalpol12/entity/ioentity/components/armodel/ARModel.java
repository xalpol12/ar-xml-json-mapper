package com.xalpol12.entity.ioentity.components.armodel;

import com.xalpol12.entity.ioentity.components.IOComponent;
import com.xalpol12.entity.xmlentity.Model;
import com.xalpol12.entity.xmlentity.Node;

public class ARModel extends IOComponent {
    Model model;

    public ARModel(Node mainNode, Model model) {
        super(mainNode);
        this.model = model;
        mainNode.setModel(model);
    }
}
