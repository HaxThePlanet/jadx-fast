package net.time4j.g1.a0;

import net.time4j.g1.j;

/* compiled from: DualFormatHelper.java */
/* loaded from: classes3.dex */
public class b {
    public static String a(j jVar, char c, int i) {
        if (jVar.isDecimal()) {
            c -= 48;
            String integer = Integer.toString(i);
            if (i4 == 0) {
                return integer;
            }
            final StringBuilder stringBuilder = new StringBuilder();
            i = 0;
            while (i < integer.length()) {
                c = (char)(integer.charAt(i) + i4);
                stringBuilder.append(c);
                i = i + 1;
            }
            return stringBuilder.toString();
        }
        return jVar.toNumeral(i);
    }
}
