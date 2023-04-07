package com.xalpol12.entity;

import lombok.Data;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;

@Data
@XmlRootElement(name = "SWITCH")
@XmlType(propOrder = {"w", "h", "d", "on", "onvalue", "offvalue", "transmit"})
public class Switch {
    private Transmit transmit;
    private int w;
    private int h;
    private int d;
    private boolean on;
    private boolean onvalue;
    private boolean offvalue;

    @XmlElement(name = "TRANSMIT")
    public void setTransmit(Transmit transmit) {
        this.transmit = transmit;
    }

    @XmlAttribute
    public void setW(int w) {
        this.w = w;
    }

    @XmlAttribute
    public void setH(int h) {
        this.h = h;
    }

    @XmlAttribute
    public void setD(int d) {
        this.d = d;
    }

    @XmlAttribute
    public void setOn(boolean on) {
        this.on = on;
    }

    @XmlAttribute
    public void setOnvalue(boolean onvalue) {
        this.onvalue = onvalue;
    }

    @XmlAttribute
    public void setOffvalue(boolean offvalue) {
        this.offvalue = offvalue;
    }
}
