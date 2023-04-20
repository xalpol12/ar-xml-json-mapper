package com.xalpol12.entity.ioentity.components.artext;

import com.xalpol12.entity.ioentity.components.IOComponentBuilder;
import com.xalpol12.entity.xmlentity.Node;
import com.xalpol12.entity.xmlentity.Text;

public class ARTextBuilder implements IOComponentBuilder {
    private final String view;
    private Float tx;
    private Float ty;
    private Float tz;
    private Float rx;
    private Float sxyz;
    private String collapse;
    private String show;
    private String rgba;
    private String backrgba;
    private final String label;
    private int width;
    private final Text text;
    private final Node mainNode;

    public ARTextBuilder(String view, String label) {
        this.view = view;
        this.label = label;

        mainNode = new Node();
        text = new Text();
    }

    public void setTx(Float tx) {
        this.tx = tx;
    }

    public void setTy(Float ty) {
        this.ty = ty;
    }

    public void setTz(Float tz) {
        this.tz = tz;
    }

    public void setRx(Float rx) {
        this.rx = rx;
    }

    public void setSxyz(Float sxyz) {
        this.sxyz = sxyz;
    }

    public void setCollapse(String collapse) {
        this.collapse = collapse;
    }

    public void setShow(String show) {
        this.show = show;
    }

    public void setRgba(String rgba) {
        this.rgba = rgba;
    }

    public void setBackrgba(String backrgba) {
        this.backrgba = backrgba;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setText() {
        text.setRgba(rgba);
        text.setLabel(label);
        text.setWidth(width);
        text.setBackrgba(backrgba);
    }

    @Override
    public void setMainNode() {
        mainNode.setTx(tx);
        mainNode.setTy(ty);
        mainNode.setTz(tz);
        mainNode.setRx(rx);
        mainNode.setSxyz(sxyz);
        mainNode.setView(view);
        mainNode.setCollapse(collapse);
        mainNode.setShow(show);
    }

    @Override
    public Node getComponent() {
        return new ARText(mainNode, text).getMainNode();
    }
}
