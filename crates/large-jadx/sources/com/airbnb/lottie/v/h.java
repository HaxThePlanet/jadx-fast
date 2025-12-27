package com.airbnb.lottie.v;

/* compiled from: Marker.java */
/* loaded from: classes.dex */
public class h {

    private static String d = "\r";
    private final String a;
    public final float b;
    public final float c;
    public h(String str, float f, float f2) {
        super();
        this.a = str;
        this.c = f2;
        this.b = f;
    }

    public boolean a(String str) {
        final int i2 = 1;
        if (this.a.equalsIgnoreCase(str)) {
            return true;
        }
        int i3 = 0;
        if (this.a.endsWith(h.d)) {
            i = this.a.length() - i2;
            return this.a.substring(i3, i).equalsIgnoreCase(str) ? i2 : i3;
        }
    }

}
