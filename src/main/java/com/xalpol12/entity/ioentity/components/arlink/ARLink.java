package com.xalpol12.entity.ioentity.components.arlink;

import com.xalpol12.entity.ioentity.components.IOComponent;
import com.xalpol12.entity.xmlentity.Link;
import com.xalpol12.entity.xmlentity.Node;

public class ARLink extends IOComponent {
    private Link link;

    public ARLink(Node mainNode, Link link) {
        super(mainNode);
        this.link = link;
        mainNode.setLink(link);
    }
}
