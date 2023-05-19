package com.xalpol12.entity.jsonentity;

import lombok.Data;

import java.util.List;

@Data
public class Scene {
    private List<String> viewList;
    private List<JSONObject> objects;
}
