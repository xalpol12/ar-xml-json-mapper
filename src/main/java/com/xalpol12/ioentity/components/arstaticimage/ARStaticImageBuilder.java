package com.xalpol12.ioentity.components.arstaticimage;

import com.xalpol12.ioentity.components.IOComponentBuilder;
import com.xalpol12.xmlentity.Model;
import com.xalpol12.xmlentity.Node;
import com.xalpol12.xmlentity.Text;

public class ARStaticImageBuilder implements IOComponentBuilder {
    private final String view;
    private Float tx;
    private Float ty;
    private Float tz;
    private Float sx;
    private Float sy;
    private Float sz;
    private String collapse;
    private String show;
    private String file;
    private String texture;
    private final Model model;
    private final Node mainNode;
    private final Node subNode;

    public ARStaticImageBuilder(String view) {
        this.view = view;

        model = new Model();
        mainNode = new Node();
        subNode = new Node();
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
        mainNode.setTx(tx);
        mainNode.setTy(ty);
        mainNode.setTz(tz);
        setCommonNodeFeatures(mainNode);
    }

    @Override
    public Node getComponent() {
        return new ARStaticImage(mainNode, subNode, model).getMainNode();
    }
}
