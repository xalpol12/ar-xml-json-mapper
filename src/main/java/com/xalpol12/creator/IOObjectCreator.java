package com.xalpol12.creator;

import com.xalpol12.entity.ioentity.IOObjectBuilder;
import com.xalpol12.entity.ioentity.IOObjectDirector;
import com.xalpol12.entity.jsonentity.JSONObject;
import com.xalpol12.entity.xmlentity.Node;

public class IOObjectCreator {
    public static Node create(JSONObject object) {
        IOObjectBuilder builder = new IOObjectBuilder(object.getPosition(),
                object.getRotation(), object.getScale(),
                object.getLabel(), object.getUrl(), object.getViews());
        IOObjectDirector director = new IOObjectDirector();
        director.constructIOObject(builder);
        return builder.getObject();
    }
}
