package com.xalpol12.entity.ioentity;

import com.xalpol12.entity.ioentity.IOObjectBuilder;

public class IOObjectDirector {
    public void constructInputObject(IOObjectBuilder builder) {
        builder.setOpenDetails();
        builder.setText();
        builder.setStaticImage();
        builder.setDetails();
        builder.setActiveLink();
        builder.setWireframe();
        builder.setMainNode();
    }
}
