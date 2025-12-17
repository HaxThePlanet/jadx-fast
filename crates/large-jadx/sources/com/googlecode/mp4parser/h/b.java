package com.googlecode.mp4parser.h;

/* loaded from: classes2.dex */
public class b {
    public static int a(long l) {
        int cmp;
        if (Long.compare(l, i) > 0) {
        } else {
            if (Long.compare(l, i2) < 0) {
            } else {
                return (int)l;
            }
        }
        StringBuilder stringBuilder = new StringBuilder("A cast to int has gone wrong. Please contact the mp4parser discussion group (");
        stringBuilder.append(l);
        stringBuilder.append(")");
        RuntimeException runtimeException = new RuntimeException(stringBuilder.toString());
        throw runtimeException;
    }
}
