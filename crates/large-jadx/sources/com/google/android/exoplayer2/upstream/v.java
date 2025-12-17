package com.google.android.exoplayer2.upstream;

import android.text.TextUtils;
import com.google.android.exoplayer2.util.g;
import com.google.android.exoplayer2.util.v;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: classes2.dex */
public final class v {

    private static final Pattern a;
    private static final Pattern b;
    static {
        v.a = Pattern.compile("bytes (\\d+)-(\\d+)/(?:\\d+|\\*)");
        v.b = Pattern.compile("bytes (?:(?:\\d+-\\d+)|\\*)/(\\d+)");
    }

    public static String a(long l, long l2) {
        int cmp;
        int obj4;
        int obj6;
        int i2 = -1;
        if (Long.compare(l, i) == 0 && Long.compare(obj6, i2) == 0) {
            if (Long.compare(obj6, i2) == 0) {
                return null;
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("bytes=");
        stringBuilder.append(l);
        stringBuilder.append("-");
        if (Long.compare(obj6, i2) != 0) {
            stringBuilder.append(obj4 -= obj6);
        }
        return stringBuilder.toString();
    }

    public static long b(String string, String string2) {
        boolean empty;
        boolean matcher;
        StringBuilder stringBuilder;
        int long;
        boolean matches;
        int stringBuilder2;
        java.lang.CharSequence obj9;
        if (!TextUtils.isEmpty(string)) {
            long = Long.parseLong(string);
        } else {
            long = -1;
        }
        matcher = v.a.matcher(string2);
        if (!TextUtils.isEmpty(string2) && matcher.matches()) {
            matcher = v.a.matcher(string2);
            if (matcher.matches()) {
                String group2 = matcher.group(2);
                g.e(group2);
                String group = matcher.group(1);
                g.e(group);
                i4 += i6;
                if (Long.compare(long, stringBuilder2) < 0) {
                    long = matches;
                } else {
                    if (Long.compare(long, matches) != 0) {
                        stringBuilder2 = new StringBuilder(i += length2);
                        stringBuilder2.append("Inconsistent headers [");
                        stringBuilder2.append(string);
                        stringBuilder2.append("] [");
                        stringBuilder2.append(string2);
                        stringBuilder2.append("]");
                        v.h("HttpUtil", stringBuilder2.toString());
                        long = obj9;
                    }
                }
            }
        }
        return long;
    }

    public static long c(String string) {
        boolean matches;
        int long;
        Object obj3;
        if (TextUtils.isEmpty(string)) {
            return -1;
        }
        obj3 = v.b.matcher(string);
        if (obj3.matches()) {
            obj3 = obj3.group(1);
            g.e(obj3);
            long = Long.parseLong((String)obj3);
        }
        return long;
    }
}
