package com.googlecode.mp4parser.h;

import java.util.Date;

/* compiled from: DateHelper.java */
/* loaded from: classes2.dex */
public class c {
    public static long a(Date date) {
        return (date.getTime() / 1000L) + 2082844800L;
    }

    public static Date b(long j) {
        return new Date((j - 2082844800L) * 1000L, r4);
    }
}
