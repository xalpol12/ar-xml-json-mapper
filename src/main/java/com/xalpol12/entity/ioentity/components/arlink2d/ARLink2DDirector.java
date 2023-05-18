package com.xalpol12.entity.ioentity.components.arlink2d;

public class ARLink2DDirector {
    public void constructDatasheet(ARLink2DBuilder builder) {
        builder.setCollapse("");
        builder.setShow("");
        builder.setSx(30f);
        builder.setSy(1f);
        builder.setSz(30f);
        builder.setFile("planexy");
        builder.setTexture("images/docu_rounded_colored.png");
        builder.setW(0);
        builder.setH(0);
        builder.setD(1);
        builder.setLink();
        builder.setModel();
        builder.setSubNode();
        builder.setMainNode();
    }
}
