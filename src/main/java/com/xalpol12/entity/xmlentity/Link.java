package com.xalpol12.entity.xmlentity;

import lombok.Data;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@Data
@XmlRootElement(name = "LINK")
@XmlType(propOrder = {"w", "h", "d", "refer", "rgb"})
public class Link {
    private String refer;
    private int w;
    private int h;
    private int d;
    private String rgb;

    @XmlAttribute
    public void setRefer(String refer) {
        this.refer = refer;
    }

    @XmlAttribute
    public void setW(int w) {
        this.w = w;
    }

    @XmlAttribute
    public void setH(int h) {
        this.h = h;
    }

    @XmlAttribute
    public void setD(int d) {
        this.d = d;
    }

    @XmlAttribute(required = true)
    public void setRgb(String rgb) {
        this.rgb = rgb;
    }
}
