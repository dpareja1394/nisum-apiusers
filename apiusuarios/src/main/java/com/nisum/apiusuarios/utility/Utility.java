package com.nisum.apiusuarios.utility;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Utility {

    public static boolean validatePattern(String text, String patternString) {
        Pattern pattern = Pattern.compile(patternString);
        Matcher matcher = pattern.matcher(text);
        return matcher.find();
    }

    public static boolean validateEmptyOrNull(String text) {
        return text == null || text.trim().isEmpty();
    }

    public static boolean validateListNullOrSizeZero(List list) {
        return list==null || list.size() == 0;
    }

}
