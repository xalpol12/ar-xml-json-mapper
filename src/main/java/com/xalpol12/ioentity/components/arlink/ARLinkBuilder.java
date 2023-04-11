package com.xalpol12.ioentity.components.arlink;

import com.xalpol12.ioentity.components.IOComponentBuilder;
import com.xalpol12.xmlentity.Link;
import com.xalpol12.xmlentity.Node;

public class ARLinkBuilder implements IOComponentBuilder {
    private final String view;
    private Float rx;
    private int w;
    private int h;
    private int d;
    private final String refer;
    private String rgb;
    private final Link link;
    private final Node mainNode;

    public ARLinkBuilder(String view, String refer) {
        this.view = view;
        this.refer = refer;

        mainNode = new Node();
        link = new Link();
    }

    public void setRx(Float rx) {
        this.rx = rx;
    }

    public void setW(int w) {
        this.w = w;
    }

    public void setH(int h) {
        this.h = h;
    }

    public void setD(int d) {
        this.d = d;
    }

    public void setRgb(String rgb) {
        this.rgb = rgb;
    }

    public void setLink() {
        link.setW(w);
        link.setH(h);
        link.setD(d);
        link.setRefer(refer);
        link.setRgb(rgb);
    };

    @Override
    public void setMainNode() {
        mainNode.setRx(rx);
        mainNode.setView(view);
    }

    public Node getComponent() {
        return new ARLink(mainNode, link).getMainNode();
    }
}
