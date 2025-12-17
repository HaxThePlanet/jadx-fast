package net.time4j.g1.a0;

import net.time4j.g1.j;

/* loaded from: classes3.dex */
public class b {
    public static String a(j j, char c2, int i3) {
        int i;
        char c;
        c2 += -48;
        String obj3 = Integer.toString(i3);
        if (j.isDecimal() && obj4 == null) {
            c2 += -48;
            obj3 = Integer.toString(i3);
            if (obj4 == null) {
                return obj3;
            }
            StringBuilder obj5 = new StringBuilder();
            i = 0;
            while (i < obj3.length()) {
                obj5.append((char)i2);
                i++;
            }
            return obj5.toString();
        }
        return j.toNumeral(i3);
    }
}
