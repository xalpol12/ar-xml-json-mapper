package com.xalpol12.entity.xmlentity;

import lombok.Data;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@Data
@XmlRootElement(name = "SWITCH")
@XmlType(propOrder = {"w", "h", "d", "on", "onvalue", "offvalue", "transmit"})
public class Switch {
    private Transmit transmit;
    private double w;
    private double h;
    private double d;
    private boolean on;
    private boolean onvalue;
    private boolean offvalue;

    @XmlElement(name = "TRANSMIT")
    public void setTransmit(Transmit transmit) {
        this.transmit = transmit;
    }

    @XmlAttribute
    public void setW(double w) {
        this.w = w;
    }

    @XmlAttribute
    public void setH(double h) {
        this.h = h;
    }

    @XmlAttribute
    public void setD(double d) {
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
