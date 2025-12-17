package com.googlecode.mp4parser.g.c;

/* loaded from: classes2.dex */
public class c {

    public static com.googlecode.mp4parser.g.c.c d;
    public static com.googlecode.mp4parser.g.c.c e;
    public static com.googlecode.mp4parser.g.c.c f;
    public static com.googlecode.mp4parser.g.c.c g;
    private int a;
    private int b;
    private int c;
    static {
        int i = 0;
        c cVar = new c(i, i, i);
        c.d = cVar;
        int i2 = 1;
        int i3 = 2;
        c cVar2 = new c(i2, i3, i3);
        c.e = cVar2;
        c cVar3 = new c(i3, i3, i2);
        c.f = cVar3;
        c cVar4 = new c(3, i2, i2);
        c.g = cVar4;
    }

    public c(int i, int i2, int i3) {
        super();
        this.a = i;
        this.b = i2;
        this.c = i3;
    }

    public static com.googlecode.mp4parser.g.c.c a(int i) {
        com.googlecode.mp4parser.g.c.c cVar = c.d;
        if (i == cVar.a) {
            return cVar;
        }
        com.googlecode.mp4parser.g.c.c cVar2 = c.e;
        if (i == cVar2.a) {
            return cVar2;
        }
        com.googlecode.mp4parser.g.c.c cVar3 = c.f;
        if (i == cVar3.a) {
            return cVar3;
        }
        com.googlecode.mp4parser.g.c.c cVar4 = c.g;
        if (i == cVar4.a) {
            return cVar4;
        }
        return null;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("ChromaFormat{\nid=");
        stringBuilder.append(this.a);
        String str2 = ",\n";
        stringBuilder.append(str2);
        stringBuilder.append(" subWidth=");
        stringBuilder.append(this.b);
        stringBuilder.append(str2);
        stringBuilder.append(" subHeight=");
        stringBuilder.append(this.c);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
