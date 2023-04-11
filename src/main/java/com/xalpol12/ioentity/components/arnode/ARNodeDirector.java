package com.xalpol12.ioentity.components.arnode;

import com.xalpol12.ioentity.components.IOComponentBuilder;
import com.xalpol12.xmlentity.Node;

public class ARNodeDirector {
    private void commonSetup(ARNodeBuilder builder) {
        builder.setCollapse("");
        builder.setShow("");
    }

    public void constructDetails(ARNodeBuilder builder, Node menuName, Node datasheet) {
        commonSetup(builder);
        builder.setTx(-39.1f);
        builder.setTy(24.5f);
        builder.setTz(2.7f);
        builder.setRx(-45f);
        builder.addSubComponent(menuName);
        builder.addSubComponent(datasheet);
        builder.setMainNode();
    }

    public void constructWireframe(ARNodeBuilder builder, Node inactive, Node active) {
        commonSetup(builder);
        builder.addSubComponent(inactive);
        builder.addSubComponent(active);
        builder.setMainNode();
    }
}
