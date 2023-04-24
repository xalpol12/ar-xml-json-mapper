package com.xalpol12.ioentity.components.arnode;

import com.xalpol12.entity.ioentity.components.arnode.ARNodeBuilder;
import com.xalpol12.entity.ioentity.components.arnode.ARNodeDirector;
import com.xalpol12.parser.JAXBParser;
import com.xalpol12.helper.FilePathConstants;
import com.xalpol12.entity.ioentity.components.arlink2d.ARLink2DBuilder;
import com.xalpol12.entity.ioentity.components.arlink2d.ARLink2DDirector;
import com.xalpol12.entity.ioentity.components.artext.ARTextBuilder;
import com.xalpol12.entity.ioentity.components.artext.ARTextDirector;
import com.xalpol12.entity.xmlentity.Node;
import org.junit.jupiter.api.Test;

import javax.xml.bind.JAXBException;

import static org.junit.jupiter.api.Assertions.*;

class ARNodeDirectorTest {

    private static final String AR_DETAILS = FilePathConstants.DIRECTOR_INTEGRATION_TEST_DIR + "/details.xml";
    @Test
    void givenDetailsFromFile_whenCreateDetailsUsingBuilder_thenObjectsAreEqual() throws JAXBException {
        //given
        Node details = JAXBParser.unmarshall(AR_DETAILS, Node.class);

        String view = "joining_g1bg1Details_i";
        String labelMenuName = "G1BG1";

        //when
        //menuName
        ARTextBuilder builderText = new ARTextBuilder(view, labelMenuName);
        ARTextDirector directorText = new ARTextDirector();
        directorText.constructMenuName(builderText);
        Node createdMenuName = builderText.getComponent();

        //datasheet
        ARLink2DBuilder builderLink = new ARLink2DBuilder(view);
        ARLink2DDirector directorLink = new ARLink2DDirector();
        directorLink.constructDatasheet(builderLink);
        Node createdDatasheet = builderLink.getComponent();

        //Details node
        ARNodeBuilder builder = new ARNodeBuilder(view);
        ARNodeDirector director = new ARNodeDirector();
        director.constructDetails(builder, createdMenuName, createdDatasheet);
        Node createdDetails = builder.getComponent();

        //then
        assertEquals(details, createdDetails);
    }
}