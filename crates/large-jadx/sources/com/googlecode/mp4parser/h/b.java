package com.googlecode.mp4parser.h;

/* compiled from: CastUtils.java */
/* loaded from: classes2.dex */
public class b {
    public static int a(long j) {
        if (j > 0x7fffffff /* Unknown resource */) {
            final String str = "A cast to int has gone wrong. Please contact the mp4parser discussion group (";
            final StringBuilder stringBuilder = new StringBuilder(str);
            String str2 = ")";
            j = str + j + str2;
            throw new RuntimeException(j);
        } else {
            if (j >= -2147483648) {
                return (int)j;
            }
        }
    }
}
