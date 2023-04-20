package com.xalpol12.ioentity.components.arstaticimage;

import com.xalpol12.entity.ioentity.components.arstaticimage.ARStaticImageBuilder;
import com.xalpol12.entity.ioentity.components.arstaticimage.ARStaticImageDirector;
import com.xalpol12.parser.JAXBParser;
import com.xalpol12.helper.StringManager;
import com.xalpol12.entity.xmlentity.Node;
import org.junit.jupiter.api.Test;

import javax.xml.bind.JAXBException;

import static org.junit.jupiter.api.Assertions.*;

class ARStaticImageDirectorTest {
    private static final String AR_STATIC_IMAGE = StringManager.DIRECTOR_UNIT_TEST_DIR + "/staticimage.xml";
    @Test
    void givenInactiveFromFile_whenCreateInactiveUsingBuilder_thenObjectsAreEqual() throws JAXBException {
        //given
        Node staticImage = JAXBParser.unmarshall(AR_STATIC_IMAGE, Node.class);

        String view = "joining_inputs,joining_g1bg1Details_i," +
                "joining_g1bg2Details_i,joining_g1bg3Details_i," +
                "joining_g1bg4Details_i,joining_g2bg1Details_i," +
                "joining_x1fk1Details_i,joining_g2bg2Details_i," +
                "joining_g2bg3Details_i,joining_x1xg2Details_i," +
                "joining_x1fk2Details_i,joining_g3bp1Details_i," +
                "joining_g3bg3Details_i,joining_g3bg2Details_i," +
                "joining_g3bg1Details_i";


        //when
        ARStaticImageBuilder builder = new ARStaticImageBuilder(view);
        ARStaticImageDirector director = new ARStaticImageDirector();
        director.constructStaticImage(builder);
        Node createdStaticImage = builder.getComponent();


        //then
        assertEquals(staticImage, createdStaticImage);
    }
}