package com.googlecode.mp4parser.g.c;

/* compiled from: AspectRatio.java */
/* loaded from: classes2.dex */
public class a {

    public static final a b = new a(255);
    private int a;

    private a(int i) {
        super();
        this.a = i;
    }

    public static a a(int i) {
        com.googlecode.mp4parser.g.c.a aVar = a.b;
        if (i == aVar.a) {
            return a.b;
        }
        return new a(i);
    }

    public String toString() {
        String str2 = "AspectRatio{";
        StringBuilder stringBuilder = new StringBuilder(str2);
        String str3 = "value=";
        str = str2 + str3 + this.a + 125;
        return str;
    }
}
