package com.xalpol12.xmlentity;

import lombok.Data;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

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
