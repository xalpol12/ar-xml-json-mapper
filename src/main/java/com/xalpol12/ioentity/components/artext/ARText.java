package com.xalpol12.ioentity.components.artext;

import com.xalpol12.ioentity.components.IOComponent;
import com.xalpol12.xmlentity.Node;
import com.xalpol12.xmlentity.Text;

public class ARText extends IOComponent {
    private Text text;

    public ARText(Node mainNode, Text text) {
        super(mainNode);
        this.text = text;
        mainNode.setText(text);
    }
}
