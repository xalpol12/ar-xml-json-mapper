package com.xalpol12.entity;

import lombok.Data;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@Data
@XmlRootElement(name = "TARGETBASE")
public class TargetBase {
    private Target target;
    private String file;

    @XmlElement(name = "TARGET")
    public void setTarget(Target target) {
        this.target = target;
    }

    @XmlAttribute
    public void setFile(String file) {
        this.file = file;
    }
}
