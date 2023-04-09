package com.xalpol12.entity;

import com.xalpol12.adapter.MyFloatConverter;
import lombok.Data;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
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
    private String tx;  // reason that all these attributes are String (could be float) is that annotating it using
    private String ty;  // @XmlAttribute(required = true) as float still generates the attribute as 0.0 value in final xml file,
    private String tz;  // so in order to omit this kind of behaviour i've decided to change their type to String, which resolves the problem
    private String sxyz;
    private String sx;
    private String sy;
    private String sz;
    private String rx;
    private String ry;
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
    public void setTx(String tx) {
        this.tx = tx;
    }

    // TODO: Figure out how to null not used values
    @XmlAttribute(required = true)
    public void setTy(String ty) {
        this.ty = ty;
    }

    @XmlAttribute(required = true)
    public void setTz(String tz) {
        this.tz = tz;
    }

    @XmlAttribute(required = true)
    public void setSxyz(String sxyz) {
        this.sxyz = sxyz;
    }

    @XmlAttribute(required = true)
    public void setSx(String sx) {
        this.sx = sx;
    }

    @XmlAttribute(required = true)
    public void setSy(String sy) {
        this.sy = sy;
    }

    @XmlAttribute(required = true)
    public void setSz(String sz) {
        this.sz = sz;
    }

    @XmlAttribute(required = true)
    public void setRx(String rx) {
        this.rx = rx;
    }

    @XmlAttribute(required = true)
    public void setRy(String ry) {
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
