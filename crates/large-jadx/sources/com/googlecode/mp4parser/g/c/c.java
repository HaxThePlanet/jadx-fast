package com.googlecode.mp4parser.g.c;

/* compiled from: ChromaFormat.java */
/* loaded from: classes2.dex */
public class c {

    public static c d;
    public static c e;
    public static c f;
    public static c g;
    private int a;
    private int b;
    private int c;
    static {
        int i = 0;
        c.d = new c(i, i, i);
        int i2 = 1;
        int i3 = 2;
        c.e = new c(i2, i3, i3);
        c.f = new c(i3, i3, i2);
        c.g = new c(3, i2, i2);
    }

    public c(int i, int i2, int i3) {
        super();
        this.a = i;
        this.b = i2;
        this.c = i3;
    }

    public static c a(int i) {
        com.googlecode.mp4parser.g.c.c cVar = c.d;
        if (i == cVar.a) {
            return c.d;
        }
        com.googlecode.mp4parser.g.c.c cVar2 = c.e;
        if (i == cVar2.a) {
            return c.e;
        }
        com.googlecode.mp4parser.g.c.c cVar3 = c.f;
        if (i == cVar3.a) {
            return c.f;
        }
        com.googlecode.mp4parser.g.c.c cVar4 = c.g;
        if (i == cVar4.a) {
            return c.g;
        }
        return null;
    }

    public String toString() {
        String str2 = "ChromaFormat{\nid=";
        StringBuilder stringBuilder = new StringBuilder(str2);
        String str3 = ",\n";
        String str5 = " subWidth=";
        String str4 = " subHeight=";
        str = str2 + this.a + str3 + str5 + this.b + str3 + str4 + this.c + 125;
        return str;
    }
}
