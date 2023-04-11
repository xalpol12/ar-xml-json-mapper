package com.xalpol12.ioentity.components.armodel;

import com.xalpol12.ioentity.components.IOComponentBuilder;

public class ARModelDirector {
    private void commonSetup(ARModelBuilder builder) {
        builder.setSx(30f);
        builder.setSy(30f);
        builder.setSz(30f);
        builder.setCollapse("");
        builder.setShow("");
        builder.setFile("cube");
        builder.setTexture("images/grid.png");
    }

    public void constructInactive(ARModelBuilder builder) {
        commonSetup(builder);
        builder.setTint("#B6BEC6");
        builder.setModel();
        builder.setMainNode();
    }

    public void constructActive(ARModelBuilder builder) {
        commonSetup(builder);
        builder.setTint("#0091DC");
        builder.setModel();
        builder.setMainNode();
    }
}
