package com.xalpol12;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.xalpol12.helpers.FileHandler;
import com.xalpol12.jsonentity.Scene;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class JSONParser {


    public static Scene parse(String fileName) throws IOException {
        File file = FileHandler.getFile(fileName);
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(file, Scene.class);
    }
}
