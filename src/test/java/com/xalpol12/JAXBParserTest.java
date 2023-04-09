package com.xalpol12;

import com.xalpol12.xmlentity.*;
import org.junit.jupiter.api.Test;

import javax.xml.bind.JAXBException;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static com.xalpol12.StringManager.*;

class JAXBParserTest {

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

    private Animation createAnimation() {
        KeyFrame frame1 = new KeyFrame(0, 1, "linear");
        KeyFrame frame2 = new KeyFrame(1, 1.5, "linear");
        KeyFrame frame3 = new KeyFrame(2, 1, "linear");
        List<KeyFrame> frames = List.of(frame1, frame2, frame3);

        Animation animation = new Animation();
        animation.setKeyFrameList(frames);
        animation.setAttribute("sxyz");
        return animation;
    }

    private Node createNode() {
        Node node = new Node();
        node.setTz("0.03");
        node.setRx("90");
        node.setSxyz("0.001");
        return node;
    }

    private Target createTarget() {
        Target target = new Target();
        target.setMarker("ARCube_Joining");
        target.setExtended(true);
        return target;
    }

    private TargetBase createTargetBase() {
        TargetBase targetBase = new TargetBase();
        targetBase.setFile("ARCubeMPS403");
        targetBase.setTarget(createTarget());
        return targetBase;
    }

    private Camera createCamera() {
        Camera camera = new Camera();
        camera.setX(0);
        camera.setY(0);
        camera.setScaleto("w");
        camera.setDistance(0.1);

        Node node = new Node();
        node.setSxyz("0.001");

        camera.setNode(node);
        return camera;
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

    @Test
    void unmarshallKeyFrameXMLFILE_compareWithCreatedKeyFramePOJO() throws JAXBException {
        //given
        KeyFrame keyFrame = new KeyFrame(1, 1.5, "linear");

        //when
        KeyFrame parsedKeyFrame = JAXBParser.unmarshall(TEST_KEYFRAME, KeyFrame.class);

        //then
        System.out.println(parsedKeyFrame.toString());
        assertEquals(keyFrame, parsedKeyFrame);
    }

    @Test
    void unmarshallAnimationXMLFILE_compareWithCreatedAnimationPOJO() throws JAXBException {
        //given
        Animation animation = createAnimation();

        //when
        Animation parsedAnimation = JAXBParser.unmarshall(TEST_ANIMATION, Animation.class);

        //then
        System.out.println(parsedAnimation.toString());
        assertEquals(animation, parsedAnimation);
    }

    @Test
    void unmarshallTargetXMLFILE_compareWithCreatedTargetPOJO() throws JAXBException {
        //given
        Target target = createTarget();
        target.setNode(createNode());

        //when
        Target parsedTarget = JAXBParser.unmarshall(TEST_TARGET, Target.class);

        //then
        System.out.println(parsedTarget.toString());
        assertEquals(target, parsedTarget);
    }

    @Test
    void unmarshallTargetBaseXMLFILE_compareWithCreatedTargetBasePOJO() throws JAXBException {
        //given
        TargetBase targetBase = createTargetBase();

        //when
        TargetBase parsedTargetBase = JAXBParser.unmarshall(TEST_TARGETBASE, TargetBase.class);

        //then
        System.out.println(parsedTargetBase.toString());
        assertEquals(targetBase, parsedTargetBase);
    }

    @Test
    void unmarshallCameraXMLFILE_compareWithCreatedCameraPOJO() throws JAXBException {
        //given
        Camera camera = createCamera();

        //when
        Camera parsedCamera = JAXBParser.unmarshall(TEST_CAMERA, Camera.class);

        //then
        System.out.println(parsedCamera.toString());
        assertEquals(camera, parsedCamera);
    }
}