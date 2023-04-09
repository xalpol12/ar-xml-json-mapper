package com.xalpol12.xmlentity;

import lombok.Data;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@Data
@XmlRootElement(name = "TEXT")
@XmlType(propOrder = {"rgba", "label", "width", "backrgba"})
public class Text {
    private String rgba;
    private String label;
    private String backrgba;
    private int width;

    @XmlAttribute
    public void setRgba(String rgba) {
        this.rgba = rgba;
    }

    @XmlAttribute
    public void setLabel(String label) {
        this.label = label;
    }

    @XmlAttribute
    public void setBackrgba(String backrgba) {
        this.backrgba = backrgba;
    }

    @XmlAttribute
    public void setWidth(int width) {
        this.width = width;
    }
}
