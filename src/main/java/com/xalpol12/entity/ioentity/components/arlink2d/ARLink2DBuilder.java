package com.xalpol12.entity.ioentity.components.arlink2d;

import com.xalpol12.entity.ioentity.components.IOComponentBuilder;
import com.xalpol12.entity.xmlentity.Link;
import com.xalpol12.entity.xmlentity.Node;
import com.xalpol12.entity.xmlentity.Model;

public class ARLink2DBuilder implements IOComponentBuilder {
    private final String view;
    private String collapse;
    private String show;
    private Float sx;
    private Float sy;
    private Float sz;
    private String file;
    private String texture;
    private String refer;
    private int w;
    private int h;
    private int d;
    private final Link link;
    private final Model model;
    private final Node subNode;
    private final Node mainNode;

    public ARLink2DBuilder(String view) {
        this.view = view;

        link = new Link();
        model = new Model();
        subNode = new Node();
        mainNode = new Node();
    }

    public void setCollapse(String collapse) {
        this.collapse = collapse;
    }

    public void setShow(String show) {
        this.show = show;
    }

    public void setSx(Float sx) {
        this.sx = sx;
    }

    public void setSy(Float sy) {
        this.sy = sy;
    }

    public void setSz(Float sz) {
        this.sz = sz;
    }

    public void setFile(String file) {
        this.file = file;
    }

    public void setTexture(String texture) {
        this.texture = texture;
    }

    public void setRefer(String refer) {
        this.refer = refer;
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

    public void setLink() {
        link.setRefer(refer);
        link.setW(w);
        link.setH(h);
        link.setD(d);
    }

    public void setModel() {
        model.setFile(file);
        model.setTexture(texture);
    }

    private void setCommonNodeFeatures(Node node) {
        node.setView(view);
        node.setCollapse(collapse);
        node.setShow(show);
    }

    public void setSubNode() {
        subNode.setSx(sx);
        subNode.setSy(sy);
        subNode.setSz(sz);
        setCommonNodeFeatures(subNode);
    }

    @Override
    public void setMainNode() {
        setCommonNodeFeatures(mainNode);
    }

    @Override
    public Node getComponent() {
        return new ARLink2D(mainNode, subNode, model, link).getMainNode();
    }
}
