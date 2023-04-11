package com.xalpol12.ioentity.components;

import com.xalpol12.xmlentity.Node;

import java.util.Objects;


public abstract class IOComponent {
    private final Node mainNode;

    public IOComponent(Node mainNode) {
        this.mainNode = mainNode;
    }

    public Node getMainNode() {
        return mainNode;
    }
}
