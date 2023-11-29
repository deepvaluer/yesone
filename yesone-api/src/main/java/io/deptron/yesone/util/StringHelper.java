package io.deptron.yesone.util;

public class StringHelper {

    public static boolean isEmpty(String str) {
        return !(str != null && str.length() != 0);
    }

    public static boolean isEmptyTrimmed(String str) {
        if (str == null)
            return true;
        return isEmpty(str.trim());
    }

    public static String stringValueOf(Object object) {
        return stringValueOf(object, "");
    }

    public static String stringValueOf(Object object, String def) {
        if (object == null)
            return def;
        String str = String.valueOf(object);
        return str;
    }

    public static String stringValueOf(Object object, String def, boolean emptyStringChange) {
        if (emptyStringChange) {
            String returnString = stringValueOf(object, def);
            if (returnString.length() < 1)
                return String.valueOf(def);
            return returnString;
        }
        return stringValueOf(object, def);
    }

    public static String toCamelCase(String text) {
        return toCamelCase(text, '_');
    }

    public static String toCamelCase(String text, char delimiter) {
        StringBuilder builder = new StringBuilder();

        boolean shouldConvertNextCharToLower = true;
        for (int i = 0; i < text.length(); i++) {
            char currentChar = text.charAt(i);
            if (currentChar == delimiter) {
                shouldConvertNextCharToLower = false;
            } else if (shouldConvertNextCharToLower) {
                builder.append(Character.toLowerCase(currentChar));
            } else {
                builder.append(Character.toUpperCase(currentChar));
                shouldConvertNextCharToLower = true;
            }
        }
        return builder.toString();
    }

}
