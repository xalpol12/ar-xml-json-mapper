package com.xalpol12.ioentity.components.arlink2d;

import com.xalpol12.entity.ioentity.components.arlink2d.ARLink2DBuilder;
import com.xalpol12.entity.ioentity.components.arlink2d.ARLink2DDirector;
import com.xalpol12.parser.JAXBParser;
import com.xalpol12.helper.FilePathConstants;
import com.xalpol12.entity.xmlentity.Node;
import org.junit.jupiter.api.Test;

import javax.xml.bind.JAXBException;

import static org.junit.jupiter.api.Assertions.*;

class ARLink2DDirectorTest {
    private static final String AR_DATASHEET = FilePathConstants.DIRECTOR_UNIT_TEST_DIR + "/datasheet.xml";
    @Test
    void givenDatasheetFromFile_whenCreateDatasheetUsingBuilder_thenObjectsAreEqual() throws JAXBException {
        //given
        Node datasheet = JAXBParser.unmarshall(AR_DATASHEET, Node.class);

        String view = "joining_g1bg1Details_i";


        //when
        ARLink2DBuilder builder = new ARLink2DBuilder(view);
        ARLink2DDirector director = new ARLink2DDirector();
        director.constructDatasheet(builder);
        Node createdDatasheet = builder.getComponent();


        //then
        assertEquals(datasheet, createdDatasheet);
    }
}