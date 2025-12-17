package com.googlecode.mp4parser.g.c;

/* loaded from: classes2.dex */
public class a {

    public static final com.googlecode.mp4parser.g.c.a b;
    private int a;
    static {
        a aVar = new a(255);
        a.b = aVar;
    }

    private a(int i) {
        super();
        this.a = i;
    }

    public static com.googlecode.mp4parser.g.c.a a(int i) {
        com.googlecode.mp4parser.g.c.a aVar = a.b;
        if (i == aVar.a) {
            return aVar;
        }
        a aVar2 = new a(i);
        return aVar2;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("AspectRatio{");
        stringBuilder.append("value=");
        stringBuilder.append(this.a);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
