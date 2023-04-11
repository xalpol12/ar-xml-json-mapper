package com.xalpol12.ioentity.components.armodel;

import com.xalpol12.JAXBParser;
import com.xalpol12.StringManager;
import com.xalpol12.ioentity.components.arlink2d.ARLink2DBuilder;
import com.xalpol12.ioentity.components.arlink2d.ARLink2DDirector;
import com.xalpol12.xmlentity.Node;
import org.junit.jupiter.api.Test;

import javax.xml.bind.JAXBException;

import static org.junit.jupiter.api.Assertions.*;

class ARModelDirectorTest {

    private static final String AR_INACTIVE = StringManager.DIRECTOR_UNIT_TEST_DIR + "/inactive.xml";
    private static final String AR_ACTIVE = StringManager.DIRECTOR_UNIT_TEST_DIR + "/active.xml";

    @Test
    void givenInactiveFromFile_whenCreateInactiveUsingBuilder_thenObjectsAreEqual() throws JAXBException {
        //given
        Node inactive = JAXBParser.unmarshall(AR_INACTIVE, Node.class);

        String view = "joining_inputs,joining_g1bg2Details_i," +
                "joining_g1bg3Details_i,joining_g1bg4Details_i," +
                "joining_x1xg2Details_i,joining_g2bg1Details_i," +
                "joining_g2bg2Details_i,joining_g2bg3Details_i," +
                "joining_x1fk1Details_i,joining_x1fk2Details_i," +
                "joining_g3bg1Details_i,joining_g3bg2Details_i," +
                "joining_g3bg3Details_i,joining_g3bp1Details_i";


        //when
        ARModelBuilder builder = new ARModelBuilder(view);
        ARModelDirector director = new ARModelDirector();
        director.constructInactive(builder);
        Node createdInactive = builder.getComponent();


        //then
        assertEquals(inactive, createdInactive);
    }

    @Test
    void givenActiveFromFile_whenCreateActiveUsingBuilder_thenObjectsAreEqual() throws JAXBException {
        //given
        Node active = JAXBParser.unmarshall(AR_ACTIVE, Node.class);

        String view = "joining_g1bg1Details_i";


        //when
        ARModelBuilder builder = new ARModelBuilder(view);
        ARModelDirector director = new ARModelDirector();
        director.constructActive(builder);
        Node createdActive = builder.getComponent();


        //then
        assertEquals(active, createdActive);
    }
}