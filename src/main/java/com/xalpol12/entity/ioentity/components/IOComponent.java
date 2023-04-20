package com.xalpol12.entity.ioentity.components;

import com.xalpol12.entity.xmlentity.Node;


public abstract class IOComponent {
    private final Node mainNode;

    public IOComponent(Node mainNode) {
        this.mainNode = mainNode;
    }

    public Node getMainNode() {
        return mainNode;
    }
}
