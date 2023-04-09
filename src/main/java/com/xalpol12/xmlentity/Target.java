package com.xalpol12.xmlentity;

import lombok.Data;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@Data
@XmlRootElement(name = "TARGET")
@XmlType(propOrder = {"marker", "extended", "node"})
public class Target {
    private Node node;
    private String marker;
    private boolean extended;

    @XmlElement(name = "NODE")
    public void setNode(Node node) {
        this.node = node;
    }

    @XmlAttribute
    public void setMarker(String marker) {
        this.marker = marker;
    }

    @XmlAttribute
    public void setExtended(boolean extended) {
        this.extended = extended;
    }
}
