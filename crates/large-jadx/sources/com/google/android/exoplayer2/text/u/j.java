package com.google.android.exoplayer2.text.u;

import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.util.d0;
import com.google.android.exoplayer2.util.p0;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: classes2.dex */
public final class j {

    private static final Pattern a;
    static {
        j.a = Pattern.compile("^NOTE([ \t].*)?$");
    }

    public static Matcher a(d0 d0) {
        Object matcher;
        boolean matches;
        matcher = d0.o();
        while (matcher != null) {
            matcher = h.a.matcher(matcher);
            matcher = d0.o();
            matcher = d0.o();
            while (matcher != null) {
                if (matcher.isEmpty() == null) {
                }
                matcher = d0.o();
            }
            if (matcher.isEmpty() == null) {
            }
        }
        return null;
    }

    public static boolean b(d0 d0) {
        String str;
        String obj1;
        obj1 = d0.o();
        if (obj1 != null && obj1.startsWith("WEBVTT")) {
            obj1 = obj1.startsWith("WEBVTT") ? 1 : 0;
        } else {
        }
        return obj1;
    }

    public static float c(String string) {
        if (!string.endsWith("%")) {
        } else {
            return obj2 /= i2;
        }
        NumberFormatException obj2 = new NumberFormatException("Percentages must end with %");
        throw obj2;
    }

    public static long d(String string) {
        int i2;
        int length;
        int i4;
        int i3;
        long long;
        int long2;
        int i;
        String[] obj8;
        obj8 = p0.D0(string, "\\.");
        String[] strArr = p0.C0(obj8[0], ":");
        i4 = 0;
        while (i2 < strArr.length) {
            i7 += long;
            i2++;
        }
        int i5 = 1000;
        if (obj8.length == 2) {
            i3 += long2;
        }
        return i3 *= i5;
    }

    public static void e(d0 d0) {
        String obj2;
        if (!j.b(d0)) {
            d0.I(d0.e());
            String str = "Expected WEBVTT. Got ";
            obj2 = String.valueOf(d0.o());
            if (obj2.length() != 0) {
                obj2 = str.concat(obj2);
            } else {
                obj2 = new String(str);
            }
            throw ParserException.a(obj2, 0);
        }
    }
}
