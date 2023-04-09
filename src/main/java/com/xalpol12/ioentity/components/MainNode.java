package com.xalpol12.ioentity.components;

import com.xalpol12.xmlentity.Node;

public class MainNode extends IOComponent{
    private Node componentMainNode;

    @Override
    public void setComponentMainNode(Node node) {
        this.componentMainNode = node;
    }
}
