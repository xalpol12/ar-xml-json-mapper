package com.xalpol12.entity;

import lombok.Data;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@Data
@XmlRootElement(name = "TRANSMIT")
@XmlType(propOrder = {"attribute", "variable", "transmitter", "threshold"})
public class Transmit {
    private String attribute;
    private String variable;
    private String transmitter;
    private String threshold;

    @XmlAttribute
    public void setAttribute(String attribute) {
        this.attribute = attribute;
    }

    @XmlAttribute
    public void setVariable(String variable) {
        this.variable = variable;
    }

    @XmlAttribute
    public void setTransmitter(String transmitter) {
        this.transmitter = transmitter;
    }

    @XmlAttribute
    public void setThreshold(String threshold) {
        this.threshold = threshold;
    }
}
