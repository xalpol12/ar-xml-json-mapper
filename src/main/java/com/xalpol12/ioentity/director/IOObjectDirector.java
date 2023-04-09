package com.xalpol12.ioentity.director;

import com.xalpol12.ioentity.builders.IOBuilder;

public class IOObjectDirector {
    public void constructInputObject(IOBuilder builder) {
        builder.reset();
        builder.setMainNode();
        builder.setOpenDetails();
        builder.setText();
        builder.setStaticImage();
        builder.setDetails();
        builder.setMenuName();
        builder.setActiveLink();
        builder.setWireframe();
        builder.setInactive();
        builder.setActive();
    }

    public void constructOutputObject(IOBuilder builder) {
        builder.reset();
        builder.setMainNode();
        builder.setOpenDetails();
        builder.setText();
        builder.setStaticImage();
        builder.setDetails();
        builder.setMenuName();
        builder.setActiveLink();
        builder.setWireframe();
        builder.setInactive();
        builder.setActive();
    }

}
