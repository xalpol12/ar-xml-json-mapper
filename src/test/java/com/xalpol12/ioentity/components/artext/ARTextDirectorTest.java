package com.xalpol12.ioentity.components.artext;

import com.xalpol12.entity.ioentity.components.artext.ARTextBuilder;
import com.xalpol12.entity.ioentity.components.artext.ARTextDirector;
import com.xalpol12.parser.JAXBParser;
import com.xalpol12.helper.StringManager;
import com.xalpol12.entity.xmlentity.Node;
import org.junit.jupiter.api.Test;

import javax.xml.bind.JAXBException;

import static org.junit.jupiter.api.Assertions.*;

class ARTextDirectorTest {
    private static final String AR_TEXT = StringManager.DIRECTOR_UNIT_TEST_DIR + "/text.xml";
    private static final String AR_MENU_NAME = StringManager.DIRECTOR_UNIT_TEST_DIR + "/menuname.xml";

    @Test
    void givenTextNodeFromFile_whenCreateTextNodeUsingBuilder_thenObjectsAreEqual() throws JAXBException {
        //given
        Node text = JAXBParser.unmarshall(AR_TEXT, Node.class);

        String view = "joining_inputs,joining_g1bg2Details_i," +
                "joining_g1bg3Details_i,joining_g1bg4Details_i," +
                "joining_g2bg1Details_i,joining_x1fk1Details_i," +
                "joining_g2bg2Details_i,joining_g2bg3Details_i," +
                "joining_x1xg2Details_i,joining_x1fk2Details_i," +
                "joining_g3bg1Details_i,joining_g3bg2Details_i," +
                "joining_g3bg3Details_i,joining_g3bp1Details_i";
        String label = "G1BG1";


        //when
        ARTextBuilder builder = new ARTextBuilder(view, label);
        ARTextDirector director = new ARTextDirector();
        director.constructTextNode(builder);
        Node createdText = builder.getComponent();


        //then
        assertEquals(text, createdText);
    }

    @Test
    void givenMenuNameNodeFromFile_whenCreateMenuNameNodeUsingBuilder_thenObjectsAreEqual() throws JAXBException {
        //given
        Node menuName = JAXBParser.unmarshall(AR_MENU_NAME, Node.class);

        String view = "joining_g1bg1Details_i";
        String label = "G1BG1";


        //when
        ARTextBuilder builder = new ARTextBuilder(view, label);
        ARTextDirector director = new ARTextDirector();
        director.constructMenuName(builder);
        Node createdMenuName = builder.getComponent();


        //then
        assertEquals(menuName, createdMenuName);
    }
}