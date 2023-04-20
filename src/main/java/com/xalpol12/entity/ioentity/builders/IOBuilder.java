package com.xalpol12.entity.ioentity.builders;

import com.xalpol12.entity.xmlentity.Node;

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
