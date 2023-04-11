package com.xalpol12.ioentity.components.arlink;

import com.xalpol12.JAXBParser;
import com.xalpol12.StringManager;
import com.xalpol12.xmlentity.Node;
import org.junit.jupiter.api.Test;

import javax.xml.bind.JAXBException;

import static org.junit.jupiter.api.Assertions.*;

class ARLinkDirectorTest {
    private static final String ACTIVE_LINK = StringManager.ROOT + "/buildertest/activelink.xml";
    private static final String OPEN_DETAILS = StringManager.ROOT + "/buildertest/opendetails.xml";

    @Test
    void givenActiveLinkFromFile_whenCreateActiveLinkUsingBuilder_thenObjectsAreEqual() throws JAXBException {
        //given
        Node activeLink = JAXBParser.unmarshall(ACTIVE_LINK, Node.class);

        String view = "joining_g1bg1Details_i";
        String refer = "@view:joining_inputs";

        //when
        ARLinkBuilder builder = new ARLinkBuilder(view, refer);
        ARLinkDirector director = new ARLinkDirector();
        director.constructActiveLink(builder);
        Node createdActiveLink = builder.getComponent();


        //then
        assertEquals(activeLink, createdActiveLink);
    }

    @Test
    void givenOpenDetailsFromFile_whenCreateOpenDetailsUsingBuilder_thenObjectsAreEqual() throws JAXBException {
        //given
        Node openDetails = JAXBParser.unmarshall(OPEN_DETAILS, Node.class);

        String view = "joining_inputs,joining_g1bg2Details_i," +
                "joining_g1bg3Details_i,joining_g1bg4Details_i," +
                "joining_g2bg1Details_i,joining_x1fk1Details_i," +
                "joining_g2bg2Details_i,joining_g2bg3Details_i," +
                "joining_x1xg2Details_i,joining_x1fk2Details_i," +
                "joining_g3bg1Details_i,joining_g3bg2Details_i," +
                "joining_g3bg3Details_i,joining_g3bp1Details_i";
        String refer = "@view:joining_g1bg1Details_i";

        //when
        ARLinkBuilder builder = new ARLinkBuilder(view, refer);
        ARLinkDirector director = new ARLinkDirector();
        director.constructOpenDetails(builder);
        Node createdOpenDetails = builder.getComponent();


        //then
        assertEquals(openDetails, createdOpenDetails);
    }


}