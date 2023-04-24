package com.xalpol12.parser;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.xalpol12.helper.FileHandler;
import com.xalpol12.entity.jsonentity.Scene;

import java.io.File;
import java.io.IOException;

public class JSONParser {
    public static Scene parse(String fileName) throws IOException {
        File file = FileHandler.getFile(fileName);
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(file, Scene.class);
    }
}
