package com.xalpol12.ioentity.director;

import com.xalpol12.ioentity.builders.IOObjectBuilder;

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
