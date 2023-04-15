package com.xalpol12;

import com.xalpol12.helpers.FileHandler;
import com.xalpol12.xmlentity.Augmentation;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.transform.*;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.File;
import java.io.StringReader;
import java.io.StringWriter;

public class JAXBParser {

    private static Transformer getConfiguredTransformer() throws TransformerConfigurationException {
        Transformer transformer = TransformerFactory.newInstance().newTransformer();
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");
        return transformer;
    }

    private static Marshaller getConfiguredMarshaller() throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(Augmentation.class);
        Marshaller marshaller = jaxbContext.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.FALSE);
        return marshaller;
    }

    public static <T> T unmarshall(String fileName, Class<T> type) throws JAXBException {
        File file = FileHandler.getFile(fileName);
        JAXBContext context = JAXBContext.newInstance(type);
        return (T) context.createUnmarshaller().unmarshal(file);
    }

    public static void marshall(Object node, String newFileName) throws JAXBException, TransformerException {
        Marshaller marshaller = getConfiguredMarshaller();
        Transformer transformer = getConfiguredTransformer();
        StringWriter stringWriter = new StringWriter();
        marshaller.marshal(node, stringWriter); // TODO: Check if filename ends with .xml
        transformer.transform(new StreamSource(new StringReader(stringWriter.toString())), new StreamResult(new File(newFileName)));
    }
}
