package com.google.gson;

import java.lang.reflect.Field;
import java.util.Locale;

/* loaded from: classes2.dex */
public enum FieldNamingPolicy implements com.google.gson.FieldNamingStrategy {

    IDENTITY,
    UPPER_CAMEL_CASE,
    UPPER_CAMEL_CASE_WITH_SPACES,
    LOWER_CASE_WITH_UNDERSCORES,
    LOWER_CASE_WITH_DASHES,
    LOWER_CASE_WITH_DOTS;
    static String separateCamelCase(String string, String string2) {
        int i;
        char charAt;
        boolean upperCase;
        StringBuilder stringBuilder = new StringBuilder();
        i = 0;
        while (i < string.length()) {
            charAt = string.charAt(i);
            if (Character.isUpperCase(charAt) && stringBuilder.length() != 0) {
            }
            stringBuilder.append(charAt);
            i++;
            if (stringBuilder.length() != 0) {
            }
            stringBuilder.append(string2);
        }
        return stringBuilder.toString();
    }

    static String upperCaseFirstLetter(String string) {
        int i;
        boolean letter;
        final int i3 = 1;
        int i4 = 0;
        i = i4;
        while (!Character.isLetter(string.charAt(i))) {
            if (i < length -= i3) {
            }
            i++;
        }
        char charAt = string.charAt(i);
        if (Character.isUpperCase(charAt)) {
            return string;
        }
        char upperCase = Character.toUpperCase(charAt);
        if (i == 0) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(upperCase);
            stringBuilder.append(string.substring(i3));
            return stringBuilder.toString();
        }
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append(string.substring(i4, i));
        stringBuilder2.append(upperCase);
        stringBuilder2.append(string.substring(i += i3));
        return stringBuilder2.toString();
    }
}
