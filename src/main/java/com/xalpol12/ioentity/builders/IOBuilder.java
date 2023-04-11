package com.xalpol12.ioentity.builders;

import com.xalpol12.ioentity.IOObject;
import com.xalpol12.xmlentity.Node;

public interface IOBuilder {
    public void setOpenDetails();
    public void setText();
    public void setStaticImage();
    public void setDetails();
    public void setActiveLink();
    public void setWireframe();
    public void setMainNode();
    public Node getObject();
}
