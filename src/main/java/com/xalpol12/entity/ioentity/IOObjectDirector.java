package com.xalpol12.entity.ioentity;

public class IOObjectDirector {
    public void constructIOObject(IOObjectBuilder builder) {
        builder.setOpenDetails();
        builder.setText();
        builder.setStaticImage();
        builder.setDetails();
        builder.setActiveLink();
        builder.setWireframe();
        builder.setMainNode();
    }
}
