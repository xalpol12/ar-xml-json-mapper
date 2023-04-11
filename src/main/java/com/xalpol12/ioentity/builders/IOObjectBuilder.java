package com.xalpol12.ioentity.builders;

import com.xalpol12.ioentity.IOObject;
import com.xalpol12.ioentity.components.arlink.ARLinkBuilder;
import com.xalpol12.ioentity.components.arlink.ARLinkDirector;
import com.xalpol12.ioentity.components.arnode.ARNodeBuilder;
import com.xalpol12.ioentity.components.arnode.ARNodeDirector;
import com.xalpol12.xmlentity.Node;

public class IOObjectBuilder implements IOBuilder{
    private final Float tx;
    private final Float ty;
    private final Float tz;
    private final String label;
    private final String view;
    private String objectView;
    private Node openDetails;
    private Node arText;
    private Node staticImage;
    private Node details;
    private Node activeLink;
    private Node wireframe;

    public IOObjectBuilder(Float tx, Float ty, Float tz, String label, String view) {
        this.tx = tx;
        this.ty = ty;
        this.tz = tz;
        this.label = label.toUpperCase();
        this.view = view;
        objectView = "joining_" + label.toLowerCase() + "Details_i";
    }

    @Override
    public void setOpenDetails() {

    }

    @Override
    public void setText() {

    }

    @Override
    public void setStaticImage() {

    }

    @Override
    public void setDetails() {

    }

    @Override
    public void setMenuName() {

    }

    @Override
    public void setDatasheet() {

    }

    @Override
    public void setActiveLink() {
//        Float rx = 90f;
//        int w = 30;
//        int h = 30;
//        int d = 30;
//        String refer = "@view:joining_inputs";
//        String rgb = "0091DC";
//
//        ARLinkBuilder builder = new ARLinkBuilder(objectView, rx, w, h, d, refer, rgb);
//        ARLinkDirector director = new ARLinkDirector();
//        director.constructActiveLink(builder);
//        activeLink = builder.getComponent();
    }

    @Override
    public void setWireframe() {
//        ARNodeBuilder builder = new ARNodeBuilder();
//        ARNodeDirector director = new ARNodeDirector();
//        director.constructComponent(builder);
//        wireframe = builder.getComponent();
    }

    @Override
    public void setMainNode() {

    }

    @Override
    public IOObject getObject() {
        return null;
    }
}
