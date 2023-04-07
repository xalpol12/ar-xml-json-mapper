package com.xalpol12.entity;

import lombok.Data;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.util.List;

@Data
@XmlRootElement(name = "ANIMATION")
public class Animation {
    private List<KeyFrame> keyFrameList;
    private String attribute;

    @XmlElement(name = "KEYFRAME")
    public void setKeyFrameList(List<KeyFrame> keyFrameList) {
        this.keyFrameList = keyFrameList;
    }

    @XmlAttribute
    public void setAttribute(String attribute) {
        this.attribute = attribute;
    }
}
