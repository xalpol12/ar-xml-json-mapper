package com.xalpol12.helper;

import org.junit.jupiter.api.Test;

import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.*;

class StringHelperTest {
    @Test
    void givenFilePath_extractTitleFromFilePath_EqualsTitleFromFilePath() {
        // given
        String root = Paths.get("").toAbsolutePath().toString();
        String filePath = root + "\\src\\main\\resources\\documents\\json\\imports\\my_scene.json";

        // when
        String title = StringHelper.extractTitleFromFilePath(filePath);

        // then
        assertEquals("my_scene.xml", title);
    }
}