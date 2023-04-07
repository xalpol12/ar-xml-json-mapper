package com.xalpol12.entity;

import lombok.Data;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.util.List;

//Node in xml has a couple of different variations, @required = true  ignores null attributes during marshalling
@Data
@XmlRootElement(name = "NODE")
@XmlType(propOrder = {"tx", "ty", "tz", "rx", "ry", "sx", "sy", "sz",
        "sxyz", "view", "collapse", "show", "nodeList", "text", "model",
        "aSwitch", "animation", "link"})
public class Node {
    private List<Node> nodeList;
    private String view;
    private String collapse;
    private String show;
    private double tx;
    private double ty;
    private double tz;
    private double sxyz;
    private int sx;
    private int sy;
    private int sz;
    private int rx;
    private int ry;
    private Text text;
    private Model model;
    private Switch aSwitch;
    private Animation animation;
    private Link link;

    @XmlElement(name = "NODE")
    public void setNodeList(List<Node> nodeList) {
        this.nodeList = nodeList;
    }

    @XmlAttribute(required = true)
    public void setView(String view) {
        this.view = view;
    }

    @XmlAttribute(required = true)
    public void setCollapse(String collapse) {
        this.collapse = collapse;
    }

    @XmlAttribute(required = true)
    public void setShow(String show) {
        this.show = show;
    }

    @XmlAttribute(required = true)
    public void setTx(double tx) {
        this.tx = tx;
    }

    //TODO: Figure out how to null not used values
    @XmlAttribute(required = true)
    public void setTy(double ty) {
        this.ty = ty;
    }

    @XmlAttribute(required = true)
    public void setTz(double tz) {
        this.tz = tz;
    }

    @XmlAttribute(required = true)
    public void setSxyz(double sxyz) {
        this.sxyz = sxyz;
    }

    @XmlAttribute(required = true)
    public void setSx(int sx) {
        this.sx = sx;
    }

    @XmlAttribute(required = true)
    public void setSy(int sy) {
        this.sy = sy;
    }

    @XmlAttribute(required = true)
    public void setSz(int sz) {
        this.sz = sz;
    }

    @XmlAttribute(required = true)
    public void setRx(int rx) {
        this.rx = rx;
    }

    @XmlAttribute(required = true)
    public void setRy(int ry) {
        this.ry = ry;
    }

    @XmlElement(name = "TEXT")
    public void setText(Text text) {
        this.text = text;
    }

    @XmlElement(name = "MODEL")
    public void setModel(Model model) {
        this.model = model;
    }

    @XmlElement(name = "SWITCH")
    public void setaSwitch(Switch aSwitch) {
        this.aSwitch = aSwitch;
    }

    @XmlElement(name = "ANIMATION")
    public void setAnimation(Animation animation) {
        this.animation = animation;
    }

    @XmlElement(name = "LINK")
    public void setLink(Link link) {
        this.link = link;
    }

    public Switch getaSwitch() {
        return aSwitch;
    }
}
