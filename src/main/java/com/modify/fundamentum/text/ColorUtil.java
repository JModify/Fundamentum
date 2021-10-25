package com.modify.fundamentum.text;

import net.md_5.bungee.api.ChatColor;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ColorUtil {

    /**
     * Formats text with support to HEX color codes.
     * Will also format traditional color codes.
     * @param message - message to format.
     * @return - copy of formatted text.
     */
    public static String format(String message) {
        final Pattern HEX_PATTERN = Pattern.compile("&#(\\w{5}[0-9a-f])");

        Matcher matcher = HEX_PATTERN.matcher(message);
        StringBuffer buffer = new StringBuffer();

        while(matcher.find()) {
            matcher.appendReplacement(buffer, ChatColor.of("#" + matcher.group(1)).toString());
        }

        return ChatColor.translateAlternateColorCodes('&', matcher.appendTail(buffer).toString());
    }

    /**
     * Formats a list with support to HEX color codes.
     * Will also format traditional color codes.
     * @param message - list to format.
     * @return - copy of formatted list.
     */
    public static List<String> formatList(List<String> message) {
        List<String> result = new ArrayList<>();
        for(String s : message){
            result.add(ColorUtil.format(s));
        }
        return result;
    }

}
