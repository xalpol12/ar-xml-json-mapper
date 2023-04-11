//package com.xalpol12.ioentity.components.arnode;
//
//import com.xalpol12.JAXBParser;
//import com.xalpol12.StringManager;
//import com.xalpol12.ioentity.components.arstaticimage.ARStaticImageBuilder;
//import com.xalpol12.ioentity.components.arstaticimage.ARStaticImageDirector;
//import com.xalpol12.xmlentity.Node;
//import org.junit.jupiter.api.Test;
//
//import javax.xml.bind.JAXBException;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//class ARNodeDirectorTest {
//
//    private static final String AR_DETAILS = StringManager.DIRECTOR_UNIT_TEST_DIR + "/details.xml";
//    @Test
//    void givenDetailsFromFile_whenCreateDetailsUsingBuilder_thenObjectsAreEqual() throws JAXBException {
//        //given
//        Node model = JAXBParser.unmarshall(AR_DETAILS, Node.class);
//
////        String view =
//
//
//        //when
//        ARStaticImageBuilder builder = new ARStaticImageBuilder(view);
//        ARStaticImageDirector director = new ARStaticImageDirector();
//        director.constructStaticImage(builder);
//        Node createdStaticImage = builder.getComponent();
//
//
//        //then
//        assertEquals(staticImage, createdStaticImage);
//    }
//}