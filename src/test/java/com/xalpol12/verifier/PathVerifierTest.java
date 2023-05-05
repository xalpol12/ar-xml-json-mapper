package com.xalpol12.verifier;

import org.junit.jupiter.api.Test;

import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.*;

class PathVerifierTest {

    @Test
    void givenExistingDirectory_returnsTrue() {
        //given
        String relativePath = "src\\test\\java\\com\\xalpol12\\verifier";
        String absPath = Paths.get(relativePath).toAbsolutePath().toString();

        //when
        boolean isDirectory = PathVerifier.isValidDirectory(absPath);

        //then
        assertTrue(isDirectory);
    }

    @Test
    void givenNonExistingDirectory_returnsFalse() {
        //given
        String relativePath = "src\\test\\java\\com\\xalpol12\\totallyFakeDirectory";
        String absPath = Paths.get(relativePath).toAbsolutePath().toString();

        //when
        boolean isDirectory = PathVerifier.isValidDirectory(absPath);

        //then
        assertFalse(isDirectory);
    }

    @Test
    void givenNotDirectory_returnsFalse() {
        //given
        String relativePath = "src\\test\\java\\com\\xalpol12\\verifier\\PathVerifierTest.java";
        String absPath = Paths.get(relativePath).toAbsolutePath().toString();

        //when
        boolean isDirectory = PathVerifier.isValidDirectory(absPath);

        //then
        assertFalse(isDirectory);
    }

    @Test
    void givenExistingJSONFile_returnsTrue() {
        //given
        String relativePath = "src\\main\\resources\\documents\\xml\\testfiles\\pathverifier\\test.json";
        String absPath = Paths.get(relativePath).toAbsolutePath().toString();

        //when
        boolean isJSON = PathVerifier.isJSONFile(absPath);

        //then
        assertTrue(isJSON);
    }

    @Test
    void givenNonExistingJSONFile_returnsFalse() {
        //given
        String relativePath = "src\\main\\resources\\documents\\xml\\NotAFile.xml";
        String absPath = Paths.get(relativePath).toAbsolutePath().toString();

        //when
        boolean isJSON = PathVerifier.isJSONFile(absPath);

        //then
        assertFalse(isJSON);
    }

    @Test
    void givenFileWithAnotherExtension_returnsFalse() {
        //given
        String relativePath = "src\\main\\resources\\documents\\xml\\Joining_01.xml";
        String absPath = Paths.get(relativePath).toAbsolutePath().toString();

        //when
        boolean isJSON = PathVerifier.isJSONFile(absPath);

        //then
        assertFalse(isJSON);
    }

    @Test
    void givenDirectoryInsteadOfJSONFile_returnsFalse() {
        //given
        String relativePath = "src\\main\\resources\\documents\\xml";
        String absPath = Paths.get(relativePath).toAbsolutePath().toString();

        //when
        boolean isJSON = PathVerifier.isJSONFile(absPath);

        //then
        assertFalse(isJSON);
    }
}