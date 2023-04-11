package com.xalpol12.ioentity.components.armodel;

import com.xalpol12.ioentity.components.IOComponentBuilder;
import com.xalpol12.xmlentity.Model;
import com.xalpol12.xmlentity.Node;

public class ARModelBuilder implements IOComponentBuilder {
    private Float sx;
    private Float sy;
    private Float sz;
    private final String view;
    private String collapse;
    private String show;
    private String file;
    private String texture;
    private String tint;
    private final Model model;
    private final Node mainNode;

    public ARModelBuilder(String view) {
        this.view = view;

        model = new Model();
        mainNode = new Node();
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

    public void setCollapse(String collapse) {
        this.collapse = collapse;
    }

    public void setShow(String show) {
        this.show = show;
    }

    public void setFile(String file) {
        this.file = file;
    }

    public void setTexture(String texture) {
        this.texture = texture;
    }

    public void setTint(String tint) {
        this.tint = tint;
    }

    public void setModel() {
        model.setFile(file);
        model.setTexture(texture);
        model.setTint(tint);
    }

    @Override
    public void setMainNode() {
        mainNode.setSx(sx);
        mainNode.setSy(sy);
        mainNode.setSz(sz);
        mainNode.setView(view);
        mainNode.setCollapse(collapse);
        mainNode.setShow(show);
    }

    @Override
    public Node getComponent() {
        return new ARModel(mainNode, model).getMainNode();
    }
}
