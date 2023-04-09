package com.xalpol12.ioentity.builders;

import com.xalpol12.ioentity.IOObject;

public interface IOBuilder {
    public void setOpenDetails();
    public void setText();
    public void setStaticImage();
    public void setDetails();
    public void setMenuName();
    public void setDatasheet();
    public void setActiveLink();
    public void setWireframe();
    public void setMainNode();
    public IOObject getObject();
}
