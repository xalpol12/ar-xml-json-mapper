package com.xalpol12.entity.ioentity.director;

import com.xalpol12.entity.ioentity.builders.IOObjectBuilder;

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
