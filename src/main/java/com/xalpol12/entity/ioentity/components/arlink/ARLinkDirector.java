package com.xalpol12.entity.ioentity.components.arlink;

public class ARLinkDirector {

    private void commonSetup(ARLinkBuilder builder) {
        builder.setRx(90f);
        builder.setW(30);
        builder.setH(30);
        builder.setD(30);
    }

    public void constructActiveLink(ARLinkBuilder builder) {
        commonSetup(builder);
        builder.setRgb("0091DC");
        builder.setLink();
        builder.setMainNode();
    }

    public void constructOpenDetails(ARLinkBuilder builder) {
        commonSetup(builder);
        builder.setRgb("FFFFFF");
        builder.setLink();
        builder.setMainNode();
    }
}
