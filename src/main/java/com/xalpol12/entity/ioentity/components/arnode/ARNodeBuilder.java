package com.xalpol12.entity.ioentity.components.arnode;

import com.xalpol12.entity.ioentity.components.IOComponentBuilder;
import com.xalpol12.entity.xmlentity.Node;

import java.util.ArrayList;
import java.util.List;

public class ARNodeBuilder implements IOComponentBuilder {
    private Float tx;
    private Float ty;
    private Float tz;
    private Float rx;
    private String view;
    private String collapse;
    private String show;
    private List<Node> subComponents;
    private Node mainNode;

    public ARNodeBuilder(String view) {
        this.view = view;
        this.mainNode = new Node();
        this.subComponents = new ArrayList<Node>();
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

    public void setCollapse(String collapse) {
        this.collapse = collapse;
    }

    public void setShow(String show) {
        this.show = show;
    }
    public void addSubComponent(Node node) {
        subComponents.add(node);
    }

    @Override
    public void setMainNode() {
        mainNode.setTx(tx);
        mainNode.setTy(ty);
        mainNode.setTz(tz);
        mainNode.setRx(rx);
        mainNode.setView(view);
        mainNode.setCollapse(collapse);
        mainNode.setShow(show);
    }

    @Override
    public Node getComponent() {
        return new ARNode(mainNode, subComponents).getMainNode();
    }
}
