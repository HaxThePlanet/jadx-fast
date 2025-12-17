package com.google.android.exoplayer2;

import android.os.Build.VERSION;
import java.util.HashSet;

/* loaded from: classes.dex */
public final class h1 {

    private static final HashSet<String> a;
    private static String b;
    static {
        String rELEASE = Build.VERSION.RELEASE;
        StringBuilder stringBuilder = new StringBuilder(length += 57);
        stringBuilder.append("ExoPlayerLib/2.15.1 (Linux; Android ");
        stringBuilder.append(rELEASE);
        stringBuilder.append(") ");
        stringBuilder.append("ExoPlayerLib/2.15.1");
        stringBuilder.toString();
        HashSet hashSet = new HashSet();
        h1.a = hashSet;
        h1.b = "goog.exo.core";
    }

    public static void a(String string) {
        boolean str;
        int i;
        StringBuilder stringBuilder;
        Object obj4;
        final Class<com.google.android.exoplayer2.h1> obj = h1.class;
        synchronized (obj) {
            String str2 = h1.b;
            stringBuilder = new StringBuilder(i2 += length2);
            stringBuilder.append(str2);
            stringBuilder.append(", ");
            stringBuilder.append(string);
            h1.b = stringBuilder.toString();
        }
    }

    public static String b() {
        final Class<com.google.android.exoplayer2.h1> obj = h1.class;
        return h1.b;
        synchronized (obj) {
            obj = h1.class;
            return h1.b;
        }
    }
}
