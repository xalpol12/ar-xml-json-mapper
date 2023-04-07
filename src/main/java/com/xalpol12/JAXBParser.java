package com.xalpol12;

import com.xalpol12.entity.*;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import java.io.File;
import java.io.Serializable;

public class JAXBParser {
    static public <T> T unmarshall(String fileName, Class<T> type) throws JAXBException {
        File file = FileHandler.getFile(fileName);
        JAXBContext context = JAXBContext.newInstance(type);
        return (T) context.createUnmarshaller().unmarshal(file);
    }
}
