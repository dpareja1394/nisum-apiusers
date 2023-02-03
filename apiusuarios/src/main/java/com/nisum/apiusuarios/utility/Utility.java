package com.nisum.apiusuarios.utility;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Utility {

    public static boolean validaPattern(String text, String patternString) {
        Pattern pattern = Pattern.compile(patternString);
        Matcher matcher = pattern.matcher(text);
        return matcher.find();
    }

}
