package com.xalpol12.helper;

import java.util.HashSet;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringHelper {
    private static final Pattern PATTERN = Pattern.compile("(.+\\\\)*(.+)\\.(.+)$");
    private static final String EXTENSION = ".xml";

    public static boolean compareTwoStrings(String str1, String str2, String separator) {
        HashSet<String> wordList1  = new HashSet<>(List.of(str1.split(separator)));
        HashSet<String> wordList2  = new HashSet<>(List.of(str2.split(separator)));
        return wordList1.containsAll(wordList2) && wordList2.containsAll(wordList1);
    }

    public static String extractTitleFromFilePath(String filePath) {
        Matcher m = PATTERN.matcher(filePath);
        String title =  m.find()? m.group(2) : null;
        return title + EXTENSION;
    }
}
