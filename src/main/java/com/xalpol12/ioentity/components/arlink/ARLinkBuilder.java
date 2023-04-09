package com.xalpol12.ioentity.components.arlink;

import com.xalpol12.ioentity.components.IOComponent;
import com.xalpol12.ioentity.components.IOComponentBuilder;
import com.xalpol12.xmlentity.Link;
import com.xalpol12.xmlentity.Node;

public class ARLinkBuilder implements IOComponentBuilder<ARLink> {
    private final String objectView;
    private final Float rx;
    private final int w;
    private final int h;
    private final int d;
    private final String refer;
    private final String rgb;
    private final Link link;
    private final Node mainNode;

    public ARLinkBuilder(String objectView, Float rx, int w, int h, int d, String refer, String rgb) {
        this.objectView = objectView;
        this.rx = rx;
        this.w = w;
        this.h = h;
        this.d = d;
        this.refer = refer;
        this.rgb = rgb;

        mainNode = new Node();
        link = new Link();
    }

    public void setLink() {
        link.setW(w);
        link.setD(h);
        link.setH(d);
        link.setRefer(refer);
        link.setRgb(rgb);
    };

    @Override
    public void setMainNode() {
        mainNode.setRx(rx);
        mainNode.setView(objectView);
    }

    public ARLink getComponent() {
        return new ARLink(mainNode, link);
    }
}
