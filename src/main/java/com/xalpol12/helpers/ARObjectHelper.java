package com.xalpol12.helpers;

import com.xalpol12.ioentity.builders.IOObjectBuilder;
import com.xalpol12.ioentity.director.IOObjectDirector;
import com.xalpol12.xmlentity.Node;

public class ARObjectHelper {
    public static Node create(String view, String label, Float tx, Float ty, Float tz) {
        IOObjectBuilder builder = new IOObjectBuilder(tx, ty, tz, label, view);
        IOObjectDirector director = new IOObjectDirector();
        director.constructInputObject(builder);
        return builder.getObject();
    }
}
