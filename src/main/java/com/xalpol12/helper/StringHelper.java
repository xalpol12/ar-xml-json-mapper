package com.xalpol12.helper;

import java.util.HashSet;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StringHelper {
    private static final Pattern PATTERN = Pattern.compile("(.+\\\\)*(.+)\\.(.+)$");
    private static final String EXTENSION = ".xml";

    public static boolean compareTwoStrings(String str1, String str2, String separator) {
        HashSet<String> wordList1  = Stream.of(str1.split(separator)).collect(Collectors.toCollection(HashSet::new));
        HashSet<String> wordList2  = Stream.of(str2.split(separator)).collect(Collectors.toCollection(HashSet::new));
        return wordList1.containsAll(wordList2) && wordList2.containsAll(wordList1);
    }

    public static String extractTitleFromFilePath(String filePath) {
        Matcher m = PATTERN.matcher(filePath);
        String title =  m.find()? m.group(2) : null;
        return title + EXTENSION;
    }
}
