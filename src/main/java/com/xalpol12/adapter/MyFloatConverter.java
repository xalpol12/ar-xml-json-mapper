package com.xalpol12.adapter;

import javax.xml.bind.annotation.adapters.XmlAdapter;

/* adapter for Node class to marshal only attributes with values != 0
 */
public class MyFloatConverter extends XmlAdapter<String, Float> {
    @Override
    public String marshal(Float value) throws Exception {
        if (value == 0.f) return null;
        return value.toString();
    }

    @Override
    public Float unmarshal(String s) {
        if (s.equalsIgnoreCase("null")) return 0.f;
        return Float.valueOf(s);
    }
}
