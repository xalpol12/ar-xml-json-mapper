package com.xalpol12.creator;

import com.xalpol12.entity.ioentity.builders.IOObjectBuilder;
import com.xalpol12.entity.ioentity.director.IOObjectDirector;
import com.xalpol12.entity.xmlentity.Node;

public class IOObjectCreator {
    public static Node create(String view, String label, Float tx, Float ty, Float tz) {
        IOObjectBuilder builder = new IOObjectBuilder(tx, ty, tz, label, view);
        IOObjectDirector director = new IOObjectDirector();
        director.constructInputObject(builder);
        return builder.getObject();
    }
}
