package com.xalpol12.entity;

import lombok.Data;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@Data
@XmlRootElement(name = "CAMERA")
@XmlType(propOrder = {"x", "y", "scaleto", "distance", "node"})
public class Camera {
    private Node node;
    private int x;
    private int y;
    private String scaleto;
    private double distance;

    @XmlElement(name = "NODE")
    public void setNode(Node node) {
        this.node = node;
    }

    @XmlAttribute
    public void setX(int x) {
        this.x = x;
    }

    @XmlAttribute
    public void setY(int y) {
        this.y = y;
    }

    @XmlAttribute
    public void setScaleto(String scaleto) {
        this.scaleto = scaleto;
    }

    @XmlAttribute
    public void setDistance(double distance) {
        this.distance = distance;
    }
}
