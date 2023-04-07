package com.xalpol12;

import com.xalpol12.entity.Websocket;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import java.io.File;

public class JAXBParser {

    static public Websocket unmarshall(String fileName) throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(Websocket.class);
        File file = FileHandler.getFile(fileName);
        return (Websocket) context.createUnmarshaller().unmarshal(file);
    }
}
