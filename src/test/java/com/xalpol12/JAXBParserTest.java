package com.xalpol12;

import com.xalpol12.entity.*;
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
    private static final String TEST_TEXT = TEST_FILES_PATH + "/test_text.xml";
    private static final String TEST_TRANSMIT = TEST_FILES_PATH + "/test_transmit.xml";
    private static final String TEST_SWITCH = TEST_FILES_PATH + "/test_switch.xml";

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

    private Text createText() {
        Text text = new Text();
        text.setRgba("#FFFFFFFF");
        text.setLabel("Switch key to MANUAL mode, then press reset");
        text.setWidth(140);
        text.setBackrgba("#000000FF");
        return text;
    }

    private Transmit createTransmit() {
        Transmit transmit = new Transmit();
        transmit.setAttribute("pressed");
        transmit.setVariable("joining_Reset");
        transmit.setTransmitter("send_joining");
        transmit.setThreshold("");
        return transmit;
    }

    private Switch createSwitch() {
        Switch aSwitch = new Switch();
        aSwitch.setW(25);
        aSwitch.setH(25);
        aSwitch.setD(0);
        aSwitch.setOn(true);
        aSwitch.setOnvalue(true);
        aSwitch.setOffvalue(false);
        aSwitch.setTransmit(createTransmit());
        return aSwitch;
    }


    @Test
    void unmarshallWebSocketXMLFile_compareWithCreatedWebSocketPOJO() throws JAXBException {
        //given
        WebSocket webSocket = createWebSocket();

        //when
        WebSocket parsedWebSocket = JAXBParser.unmarshall(TEST_WEBSOCKET, WebSocket.class);

        //then
        System.out.println(parsedWebSocket.toString());
        assertEquals(webSocket, parsedWebSocket);
    }

    @Test
    void unmarshallValueServerXMLFile_compareWithCreatedValueServerPOJO() throws JAXBException {
        //given
        ValueServer valueServer = createValueServer();
        valueServer.setWebsocket(createWebSocket());

        //when
        ValueServer parsedValueServer = JAXBParser.unmarshall(TEST_VALUESERVER, ValueServer.class);

        //then
        System.out.println(parsedValueServer.toString());
        assertEquals(valueServer, parsedValueServer);
    }

    @Test
    void unmarshallValueServerXMLFile_compareWithCreatedValueServerPOJO_webSocketNotPresent() throws JAXBException {
        //given
        ValueServer valueServer = createValueServer();

        //when
        ValueServer parsedValueServer = JAXBParser.unmarshall(TEST_VALUESERVER_EMPTYELEMENT, ValueServer.class);

        //then
        System.out.println(parsedValueServer.toString());
        assertEquals(valueServer, parsedValueServer);
    }

    @Test
    void unmarshallLinkXMLFILE_compareWithCreatedLinkPOJO_rgbValuePresent() throws JAXBException {
        //given
        Link link = createLink();
        link.setRgb("FFFFFF");

        //when
        Link parsedLink = JAXBParser.unmarshall(TEST_LINK, Link.class);

        //then
        System.out.println(parsedLink.toString());
        assertEquals(link, parsedLink);
    }

    @Test
    void unmarshallLinkXMLFILE_compareWithCreatedLinkPOJO_rgbValueNotPresent() throws JAXBException {
        //given
        Link link = createLink();

        //when
        Link parsedLink = JAXBParser.unmarshall(TEST_LINK_EMPTYRGB, Link.class);

        //then
        System.out.println(parsedLink.toString());
        assertEquals(link, parsedLink);
    }

    @Test
    void unmarshallModelXMLFILE_compareWithCreatedModelPOJO_tintNotPresent() throws JAXBException {
        //given
        Model model = createModel();
        model.setLink(createLink());

        //when
        Model parsedModel = JAXBParser.unmarshall(TEST_MODEL, Model.class);

        //then
        System.out.println(parsedModel.toString());
        assertEquals(model, parsedModel);
    }

    @Test
    void unmarshallModelXMLFILE_compareWithCreatedModelPOJO_linkNotPresent() throws JAXBException {
        //given
        Model model = createModel();
        model.setTint("#B6BEC6");

        //when
        Model parsedModel = JAXBParser.unmarshall(TEST_MODEL_EMPTYELEMENT, Model.class);

        //then
        System.out.println(parsedModel.toString());
        assertEquals(model, parsedModel);
    }

    @Test
    void unmarshallTextXMLFILE_compareWithCreatedTextPOJO() throws JAXBException {
        //given
        Text text = createText();

        //when
        Text parsedText = JAXBParser.unmarshall(TEST_TEXT, Text.class);

        //then
        System.out.println(parsedText.toString());
        assertEquals(text, parsedText);
    }

    @Test
    void unmarshallTransmitXMLFILE_compareWithCreatedTransmitPOJO() throws JAXBException {
        //given
        Transmit transmit = createTransmit();

        //when
        Transmit parsedTransmit = JAXBParser.unmarshall(TEST_TRANSMIT, Transmit.class);

        //then
        System.out.println(parsedTransmit.toString());
        assertEquals(transmit, parsedTransmit);
    }

    @Test
    void unmarshallSwitchXMLFILE_compareWithCreatedSwitchPOJO() throws JAXBException {
        //given
        Switch aSwitch = createSwitch();

        //when
        Switch parsedSwitch = JAXBParser.unmarshall(TEST_SWITCH, Switch.class);

        //then
        System.out.println(parsedSwitch.toString());
        assertEquals(aSwitch, parsedSwitch);
    }

}