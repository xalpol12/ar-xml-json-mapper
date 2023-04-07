package com.xalpol12;

import com.xalpol12.entity.Link;
import com.xalpol12.entity.Model;
import com.xalpol12.entity.ValueServer;
import com.xalpol12.entity.WebSocket;
import org.junit.jupiter.api.Test;

import javax.xml.bind.JAXBException;

import static org.junit.jupiter.api.Assertions.*;

class JAXBParserTest {

    private static final String TEST_FILES_PATH = "src/main/resources/documents/xml/testfiles";
    private static final String TEST_WEBSOCKET = TEST_FILES_PATH + "/test_websocket.xml";
    private static final String TEST_VALUESERVER = TEST_FILES_PATH + "/test_valueserver.xml";
    private static final String TEST_VALUESERVER_EMPTYELEMENT = TEST_FILES_PATH + "/test_valueserver_emptyelement.xml";
    private static final String TEST_LINK = TEST_FILES_PATH + "/test_link.xml";
    private static final String TEST_LINK_EMPTYRGB = TEST_FILES_PATH + "/test_link_emptyrgb.xml";
    private static final String TEST_MODEL = TEST_FILES_PATH + "/test_model.xml";
    private static final String TEST_MODEL_EMPTYELEMENT = TEST_FILES_PATH + "/test_model_emptyelement.xml";

    private WebSocket createWebSocket() {
        WebSocket webSocket = new WebSocket();
        webSocket.setUrl("ws://mes-pc.festo.systems:18802/ar/error-codes");
        webSocket.setPrefix("errors_2");
        webSocket.setTransmitter("constructed");
        return webSocket;
    }

    private ValueServer createValueServer() {
        ValueServer valueServer = new ValueServer();
        valueServer.setPredefined("{\"joining_db_HMI_Con_xHMIkey\":true,\"" +
                "joining_db_HMI_Con_xHMIstartLED\":true,\"" +
                "joining_db_HMI_Con_xHMIstartLED_Not\":true,\"" +
                "joining_db_HMI_Con_xHMIresetLED_Not\":true,\"" +
                "joining_indLightYe_Not\":true,\"joining_connected_belt_Not\":true}");
        return valueServer;
    }

    private Link createLink() {
        Link link = new Link();
        link.setRefer("@view:joining_g1bg1Details_i");
        link.setW(30);
        link.setH(30);
        link.setD(30);
        return link;
    }

    private Model createModel() {
        Model model = new Model();
        model.setFile("planexy");
        model.setTexture("images/docu_rounded_colored.png");
        return model;
    }


    @Test
    void unmarshallWebSocketXMLFile_compareWithCreatedWebSocketPOJO() throws JAXBException {
        //given
        WebSocket webSocket = createWebSocket();

        //when
        WebSocket parsedWebSocket = JAXBParser.unmarshallWebsocket(TEST_WEBSOCKET);

        //then
        assertEquals(webSocket, parsedWebSocket);
    }

    @Test
    void unmarshallValueServerXMLFile_compareWithCreatedValueServerPOJO() throws JAXBException {
        //given
        ValueServer valueServer = createValueServer();
        valueServer.setWebsocket(createWebSocket());

        //when
        ValueServer parsedValueServer = JAXBParser.unmarshallValueServer(TEST_VALUESERVER);

        //then
        assertEquals(valueServer, parsedValueServer);
    }

    @Test
    void unmarshallValueServerXMLFile_compareWithCreatedValueServerPOJO_webSocketNotPresent() throws JAXBException {
        //given
        ValueServer valueServer = createValueServer();

        //when
        ValueServer parsedValueServer = JAXBParser.unmarshallValueServer(TEST_VALUESERVER_EMPTYELEMENT);

        //then
        assertEquals(valueServer, parsedValueServer);
    }

    @Test
    void unmarshallLinkXMLFILE_compareWithCreatedLinkPOJO_rgbValuePresent() throws JAXBException {
        //given
        Link link = createLink();
        link.setRgb("FFFFFF");

        //when
        Link parsedLink = JAXBParser.unmarshallLink(TEST_LINK);

        //then
        assertEquals(link, parsedLink);
    }

    @Test
    void unmarshallLinkXMLFILE_compareWithCreatedLinkPOJO_rgbValueNotPresent() throws JAXBException {
        //given
        Link link = createLink();

        //when
        Link parsedLink = JAXBParser.unmarshallLink(TEST_LINK_EMPTYRGB);

        //then
        assertEquals(link, parsedLink);
    }

    @Test
    void unmarshallModelXMLFILE_compareWithCreatedModelPOJO_tintNotPresent() throws JAXBException {
        //given
        Model model = createModel();
        model.setLink(createLink());

        //when
        Model parsedModel = JAXBParser.unmarshallModel(TEST_MODEL);

        //then
        assertEquals(model, parsedModel);
    }

    @Test
    void unmarshallModelXMLFILE_compareWithCreatedModelPOJO_linkNotPresent() throws JAXBException {
        //given
        Model model = createModel();
        model.setTint("#B6BEC6");

        //when
        Model parsedModel = JAXBParser.unmarshallModel(TEST_MODEL_EMPTYELEMENT);

        //then
        assertEquals(model, parsedModel);
    }

}