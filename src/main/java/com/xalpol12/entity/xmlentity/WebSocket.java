package com.xalpol12.entity.xmlentity;

import lombok.Data;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@Data
@XmlRootElement(name = "WEBSOCKET")
@XmlType(propOrder = {"url", "prefix", "transmitter"})
public class WebSocket {
    private String url;
    private String prefix;
    private String transmitter;

    @XmlAttribute
    public void setUrl(String url) {
        this.url = url;
    }

    @XmlAttribute
    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    @XmlAttribute
    public void setTransmitter(String transmitter) {
        this.transmitter = transmitter;
    }
}
