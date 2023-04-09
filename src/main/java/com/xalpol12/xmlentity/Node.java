package com.xalpol12.xmlentity;

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
        "sxyz", "view", "collapse", "show", "text", "model",
        "aSwitch", "nodeList", "animation", "link"})
public class Node {
    private List<Node> nodeList;
    private String view;
    private String collapse;
    private String show;
    private Float tx;  // reason that all these attributes are String (could be float) is that annotating it using
    private Float ty;  // @XmlAttribute(required = true) as float still generates the attribute as 0.0 value in final xml file,
    private Float tz;  // so in order to omit this kind of behaviour i've decided to change their type to String, which resolves the problem
    private Float sxyz;
    private Float sx;
    private Float sy;
    private Float sz;
    private Float rx;
    private Float ry;
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
    public void setTx(Float tx) {
        this.tx = tx;
    }

    @XmlAttribute(required = true)
    public void setTy(Float ty) {
        this.ty = ty;
    }

    @XmlAttribute(required = true)
    public void setTz(Float tz) {
        this.tz = tz;
    }

    @XmlAttribute(required = true)
    public void setSxyz(Float sxyz) {
        this.sxyz = sxyz;
    }

    @XmlAttribute(required = true)
    public void setSx(Float sx) {
        this.sx = sx;
    }

    @XmlAttribute(required = true)
    public void setSy(Float sy) {
        this.sy = sy;
    }

    @XmlAttribute(required = true)
    public void setSz(Float sz) {
        this.sz = sz;
    }

    @XmlAttribute(required = true)
    public void setRx(Float rx) {
        this.rx = rx;
    }

    @XmlAttribute(required = true)
    public void setRy(Float ry) {
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
