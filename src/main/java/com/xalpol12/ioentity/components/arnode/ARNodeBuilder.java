package com.xalpol12.ioentity.components.arnode;

import com.xalpol12.ioentity.components.IOComponentBuilder;
import com.xalpol12.ioentity.components.arlink2d.ARLink2D;
import com.xalpol12.ioentity.components.armodel.ARModel;
import com.xalpol12.ioentity.components.artext.ARText;
import com.xalpol12.xmlentity.Node;

import java.util.List;

public class ARNodeBuilder implements IOComponentBuilder {
    private Float tx;
    private Float ty;
    private Float tz;
    private Float rx;
    private String view;
    private String collapse;
    private String show;
    private Node inactive;
    private Node active;
    private Node menuName;
    private Node datasheet;
    private Node mainNode;

    public ARNodeBuilder(String view) {
        this.view = view;
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

    public void setInactive(Node inactive) {
        this.inactive = inactive;
    }

    public void setActive(Node active) {
        this.active = active;
    }

    public void setMenuName(Node menuName) {
        this.menuName = menuName;
    }

    public void setDatasheet(Node datasheet) {
        this.datasheet = datasheet;
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
        return new ARNode(mainNode, List.of(inactive, active, menuName, datasheet)).getMainNode();
    }
}
