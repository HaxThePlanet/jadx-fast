package com.airbnb.lottie.v;

/* loaded from: classes.dex */
public class h {

    private static String d = "\r";
    private final String a;
    public final float b;
    public final float c;
    static {
    }

    public h(String string, float f2, float f3) {
        super();
        this.a = string;
        this.c = f3;
        this.b = f2;
    }

    public boolean a(String string) {
        boolean endsWith;
        int i;
        String obj5;
        final int i2 = 1;
        if (this.a.equalsIgnoreCase(string)) {
            return i2;
        }
        int i3 = 0;
        String str3 = this.a;
        if (this.a.endsWith(h.d) && str3.substring(i3, length -= i2).equalsIgnoreCase(string)) {
            str3 = this.a;
            if (str3.substring(i3, length -= i2).equalsIgnoreCase(string)) {
                return i2;
            }
        }
        return i3;
    }
}
