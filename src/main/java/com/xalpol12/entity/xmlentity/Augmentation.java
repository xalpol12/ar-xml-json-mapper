package com.xalpol12.entity.xmlentity;

import lombok.Data;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.util.List;

@Data
@XmlRootElement(name = "AUGMENTATION")
@XmlType(propOrder = {"viewDisplay", "viewList", "viewSwitch", "version",
        "valueServerList", "cameraList", "targetBase"})
public class Augmentation {

    private List<ValueServer> valueServerList;
    private List<Camera> cameraList;
    private TargetBase targetBase;
    private boolean viewDisplay;
    private boolean viewSwitch;
    private String viewList;
    private int version;

    @XmlElement(name = "VALUESERVER")
    public void setValueServerList(List<ValueServer> valueServerList) {
        this.valueServerList = valueServerList;
    }

    @XmlElement(name = "CAMERA")
    public void setCameraList(List<Camera> cameraList) {
        this.cameraList = cameraList;
    }

    @XmlElement(name = "TARGETBASE")
    public void setTargetBase(TargetBase targetBase) {
        this.targetBase = targetBase;
    }

    @XmlAttribute
    public void setViewDisplay(boolean viewDisplay) {
        this.viewDisplay = viewDisplay;
    }

    @XmlAttribute
    public void setViewSwitch(boolean viewSwitch) {
        this.viewSwitch = viewSwitch;
    }

    @XmlAttribute
    public void setViewList(String viewList) {
        this.viewList = viewList;
    }

    @XmlAttribute
    public void setVersion(int version) {
        this.version = version;
    }
}
