package net.time4j.g1.a0;

/* loaded from: classes3.dex */
public class d {
    public static String a(String string) {
        boolean stringBuilder;
        int charAt3;
        int length;
        int i3;
        int charAt;
        char charAt2;
        int i;
        int i2;
        char charAt4;
        int obj9;
        StringBuilder stringBuilder2 = new StringBuilder();
        charAt3 = string.length();
        final int i4 = 0;
        charAt = i3;
        while (i3 < charAt3) {
            charAt2 = string.charAt(i3);
            i = 39;
            if (charAt2 == i) {
            } else {
            }
            if (charAt != 0) {
            } else {
            }
            if (charAt2 != 122 && charAt2 != 90 && charAt2 != 118 && charAt2 != 86 && charAt2 != 120 && charAt2 != 88) {
            }
            i3++;
            if (charAt2 != 90) {
            }
            if (charAt2 != 118) {
            }
            if (charAt2 != 86) {
            }
            if (charAt2 != 120) {
            }
            if (charAt2 != 88) {
            }
            stringBuilder2.append(charAt2);
            stringBuilder2.append(charAt2);
            i2 = i3 + 1;
            if (i2 < charAt3 && string.charAt(i2) == i) {
            } else {
            }
            charAt ^= 1;
            stringBuilder2.append(charAt2);
            if (string.charAt(i2) == i) {
            } else {
            }
            stringBuilder2.append(charAt2);
            i3 = i2;
        }
        obj9 = i4;
        while (obj9 < stringBuilder2.length()) {
            charAt3 = stringBuilder2.charAt(obj9);
            i3 = 32;
            charAt = obj9 + 1;
            if (charAt3 == i3 && charAt < stringBuilder2.length() && stringBuilder2.charAt(charAt) == i3) {
            } else {
            }
            if (charAt3 != 91 && charAt3 != 93 && charAt3 != 40) {
            } else {
            }
            stringBuilder2.deleteCharAt(obj9);
            obj9--;
            obj9++;
            if (charAt3 != 93) {
            } else {
            }
            if (charAt3 != 40) {
            } else {
            }
            if (charAt3 == 41) {
            }
            charAt = obj9 + 1;
            if (charAt < stringBuilder2.length()) {
            } else {
            }
            if (stringBuilder2.charAt(charAt) == i3) {
            } else {
            }
            stringBuilder2.deleteCharAt(obj9);
        }
        obj9 = stringBuilder2.toString().trim();
        if (obj9.endsWith(" '")) {
            stringBuilder = new StringBuilder();
            stringBuilder.append(obj9.substring(i4, length3 += -2));
            stringBuilder.append("'");
            obj9 = stringBuilder.toString();
        } else {
            if (obj9.endsWith(",")) {
                obj9 = obj9.substring(i4, length2--);
            }
        }
        return obj9;
    }
}
