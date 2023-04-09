package com.xalpol12.ioentity.components.arlink;

import com.xalpol12.ioentity.components.IOComponent;
import com.xalpol12.xmlentity.Link;
import com.xalpol12.xmlentity.Node;

public class ARLink extends IOComponent {
    private Link link;

    public ARLink(Node mainNode, Link link) {
        super(mainNode);
        this.link = link;
        mainNode.setLink(link);
    }
}
