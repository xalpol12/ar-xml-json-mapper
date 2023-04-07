package com.xalpol12.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@Data
@AllArgsConstructor
@NoArgsConstructor
@XmlRootElement(name = "KEYFRAME")
@XmlType(propOrder = {"time", "value", "lerp"})
public class KeyFrame {
    private int time;
    private double value;
    private String lerp;

    @XmlAttribute
    public void setTime(int time) {
        this.time = time;
    }

    @XmlAttribute
    public void setValue(double value) {
        this.value = value;
    }

    @XmlAttribute
    public void setLerp(String lerp) {
        this.lerp = lerp;
    }
}
