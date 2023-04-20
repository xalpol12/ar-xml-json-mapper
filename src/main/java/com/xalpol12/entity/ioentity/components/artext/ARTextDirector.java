package com.xalpol12.entity.ioentity.components.artext;

public class ARTextDirector {
    private void commonSetup(ARTextBuilder builder) {
        builder.setRx(90f);
        builder.setCollapse("");
        builder.setShow("");
        builder.setWidth(100);

    }

    public void constructTextNode(ARTextBuilder builder) {
        commonSetup(builder);
        builder.setTx(-12f);
        builder.setTy(15.4f);
        builder.setTz(-7.1f);
        builder.setBackrgba("#FFFFFFFF");
        builder.setRgba("#000000FF");
        builder.setText();
        builder.setMainNode();
    }

    public void constructMenuName(ARTextBuilder builder) {
        commonSetup(builder);
        builder.setTx(-20f);
        builder.setTz(40f);
        builder.setRx(90f);
        builder.setSxyz(2f);
        builder.setBackrgba("#0091DCFF");
        builder.setRgba("#FFFFFFFF");
        builder.setText();
        builder.setMainNode();
    }
}
