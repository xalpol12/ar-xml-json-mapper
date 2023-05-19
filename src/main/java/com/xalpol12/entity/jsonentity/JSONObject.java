package com.xalpol12.entity.jsonentity;

import lombok.Data;

import java.util.List;

@Data
public class JSONObject {
      private String label;
      private String url;
      private String type;
      private Vector3 position;
      private Vector3 rotation;
      private Vector3 scale;
      private List<String> views;
}
