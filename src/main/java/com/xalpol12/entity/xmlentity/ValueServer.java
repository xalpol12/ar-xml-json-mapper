package com.xalpol12.entity.xmlentity;

import lombok.Data;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@Data
@XmlRootElement(name = "VALUESERVER")
public class ValueServer {
    private WebSocket websocket;
    private String predefined;

    @XmlElement(name = "WEBSOCKET")
    public void setWebsocket(WebSocket websocket) {
        this.websocket = websocket;
    }

    @XmlAttribute
    public void setPredefined(String predefined) {
        this.predefined = predefined;
    }
}
