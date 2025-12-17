package com.google.android.exoplayer2.ui;

import android.graphics.Color;
import com.google.android.exoplayer2.util.p0;

/* loaded from: classes2.dex */
final class n {
    public static String a(String string) {
        StringBuilder stringBuilder = new StringBuilder(i += length2);
        stringBuilder.append(".");
        stringBuilder.append(string);
        stringBuilder.append(",.");
        stringBuilder.append(string);
        stringBuilder.append(" *");
        return stringBuilder.toString();
    }

    public static String b(int i) {
        Object[] arr = new Object[4];
        int i8 = 2;
        arr[i8] = Integer.valueOf(Color.blue(i));
        arr[3] = Double.valueOf(d /= l);
        return p0.z("rgba(%d,%d,%d,%.3f)", arr);
    }
}
