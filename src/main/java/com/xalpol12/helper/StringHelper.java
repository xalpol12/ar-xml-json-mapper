package com.xalpol12.helper;

import java.util.HashSet;
import java.util.List;

public class StringHelper {
    public static boolean compareTwoStrings(String str1, String str2, String separator) {
        HashSet<String> wordList1  = new HashSet<String>(List.of(str1.split(separator)));
        HashSet<String> wordList2  = new HashSet<String>(List.of(str2.split(separator)));
        return wordList1.containsAll(wordList2) && wordList2.containsAll(wordList1);
    }
}
