package com.xalpol12.ioentity.components;

import com.xalpol12.xmlentity.Node;

public abstract class IOComponent extends Node {
    public Node mainNode;

    public IOComponent(Node mainNode) {
        this.mainNode = mainNode;
    }

    public Node getMainNode() {
        return mainNode;
    }
}
