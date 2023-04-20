package com.xalpol12.ioentity.director;

import com.xalpol12.entity.ioentity.director.IOObjectDirector;
import com.xalpol12.parser.JAXBParser;
import com.xalpol12.helper.StringManager;
import com.xalpol12.entity.ioentity.builders.IOObjectBuilder;
import com.xalpol12.entity.xmlentity.Node;
import org.junit.jupiter.api.Test;

import javax.xml.bind.JAXBException;

import static org.junit.jupiter.api.Assertions.*;

class IOObjectDirectorTest {

    @Test
    void givenObjectLoadedFromXML_whenCreateObject_thenObjectsAreEqual() throws JAXBException {
        //given
        String OBJECT_PATH = StringManager.ROOT + "/objectdirectortest/g1bg1node.xml";
        Node object = JAXBParser.unmarshall(OBJECT_PATH, Node.class);
        String view = "joining_inputs,joining_g1bg1Details_i,joining_g1bg2Details_i," +
                "joining_g1bg3Details_i,joining_g1bg4Details_i,joining_g2bg1Details_i," +
                "joining_x1fk1Details_i,joining_g2bg2Details_i,joining_g2bg3Details_i," +
                "joining_x1xg2Details_i,joining_x1fk2Details_i,joining_g3bp1Details_i," +
                "joining_g3bg3Details_i,joining_g3bg2Details_i,joining_g3bg1Details_i";
        System.out.println(object);

        //when
        IOObjectBuilder builder = new IOObjectBuilder(-257.8f, -48f, 189.6f, "G1BG1", view);
        IOObjectDirector director = new IOObjectDirector();
        director.constructInputObject(builder);
        Node createdObject = builder.getObject();

        //then
        System.out.println(createdObject);
        assertEquals(object, createdObject);
    }
}