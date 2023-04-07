package com.xalpol12;

import com.xalpol12.entity.Link;
import com.xalpol12.entity.ValueServer;
import com.xalpol12.entity.WebSocket;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import java.io.File;

public class JAXBParser {

    static public WebSocket unmarshallWebsocket(String fileName) throws JAXBException {
        File file = FileHandler.getFile(fileName);
        JAXBContext context = JAXBContext.newInstance(WebSocket.class);
        return (WebSocket) context.createUnmarshaller().unmarshal(file);
    }

    static public ValueServer unmarshallValueServer(String fileName) throws JAXBException {
        File file = FileHandler.getFile(fileName);
        JAXBContext context = JAXBContext.newInstance(ValueServer.class);
        return (ValueServer) context.createUnmarshaller().unmarshal(file);
    }

    static public Link unmarshallLink(String fileName) throws JAXBException {
        File file = FileHandler.getFile(fileName);
        JAXBContext context = JAXBContext.newInstance(Link.class);
        return (Link) context.createUnmarshaller().unmarshal(file);
    }
}
