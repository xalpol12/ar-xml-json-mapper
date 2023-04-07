package com.xalpol12.entity;

import lombok.Data;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@Data
@XmlRootElement(name = "MODEL")
@XmlType(propOrder = {"file", "texture", "tint", "link"})
public class Model {
    private Link link;
    private String file;
    private String texture;
    private String tint;

    @XmlElement(name = "LINK")
    public void setLink(Link link) {
        this.link = link;
    }

    @XmlAttribute
    public void setFile(String file) {
        this.file = file;
    }

    @XmlAttribute
    public void setTexture(String texture) {
        this.texture = texture;
    }

    @XmlAttribute(required = true)
    public void setTint(String tint) {
        this.tint = tint;
    }
}
