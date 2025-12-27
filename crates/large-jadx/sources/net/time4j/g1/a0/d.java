package net.time4j.g1.a0;

/* compiled from: FormatUtils.java */
/* loaded from: classes3.dex */
public class d {
    public static String a(String str) {
        int i;
        char c = 91;
        char charAt;
        char charAt2;
        int length3;
        char c2 = 39;
        char charAt3;
        String substring;
        StringBuilder stringBuilder = new StringBuilder();
        int length = str.length();
        i = 0;
        while (i < length) {
            charAt2 = str.charAt(i);
            c2 = '\'';
            i = i + 1;
        }
        while (i < stringBuilder.length()) {
            char charAt4 = stringBuilder.charAt(i);
            c = ' ';
            i = i + 1;
        }
        substring = stringBuilder.toString().trim();
        if (substring.endsWith(" '")) {
            StringBuilder stringBuilder2 = new StringBuilder();
            length2 = substring.length() - 2;
            String substring2 = substring.substring(i, length2);
            String str5 = "'";
            substring = substring2 + str5;
        } else {
            if (substring.endsWith(",")) {
                substring = substring.substring(i, substring.length() - 1);
            }
        }
        return substring;
    }
}
