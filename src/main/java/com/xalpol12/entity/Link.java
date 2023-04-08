package com.xalpol12.entity;

import lombok.Data;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@Data
@XmlRootElement(name = "LINK")
@XmlType(propOrder = {"refer", "w", "h", "d", "rgb"})
public class Link {
    private String refer;
    private double w;
    private double h;
    private double d;
    private String rgb;

    @XmlAttribute
    public void setRefer(String refer) {
        this.refer = refer;
    }

    @XmlAttribute
    public void setW(double w) {
        this.w = w;
    }

    @XmlAttribute
    public void setH(double h) {
        this.h = h;
    }

    @XmlAttribute
    public void setD(double d) {
        this.d = d;
    }

    @XmlAttribute(required = true)
    public void setRgb(String rgb) {
        this.rgb = rgb;
    }
}
