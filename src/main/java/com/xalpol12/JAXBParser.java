package com.xalpol12;

import com.xalpol12.entity.Augmentation;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;

public class JAXBParser {
    public static <T> T unmarshall(String fileName, Class<T> type) throws JAXBException {
        File file = FileHandler.getFile(fileName);
        JAXBContext context = JAXBContext.newInstance(type);
        return (T) context.createUnmarshaller().unmarshal(file);
    }

    public static void marshall(Augmentation augmentation, String newFileName) throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(augmentation.getClass());
        Marshaller marshaller = jaxbContext.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        File file = new File(newFileName); // TODO: Check if filename ends with .xml
        marshaller.marshal(augmentation, file);
    }
}
