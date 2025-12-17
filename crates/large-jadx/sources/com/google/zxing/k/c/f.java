package com.google.zxing.k.c;

import com.google.zxing.k.b.a;
import com.google.zxing.k.b.b;
import com.google.zxing.k.b.c;

/* loaded from: classes2.dex */
public final class f {

    private b a;
    private a b;
    private c c;
    private int d = -1;
    private com.google.zxing.k.c.b e;
    public f() {
        super();
        final int i = -1;
    }

    public static boolean b(int i) {
        int i2;
        if (i >= 0 && i < 8) {
            if (i < 8) {
                return 1;
            }
        }
        return 0;
    }

    public com.google.zxing.k.c.b a() {
        return this.e;
    }

    public void c(a a) {
        this.b = a;
    }

    public void d(int i) {
        this.d = i;
    }

    public void e(com.google.zxing.k.c.b b) {
        this.e = b;
    }

    public void f(b b) {
        this.a = b;
    }

    public void g(c c) {
        this.c = c;
    }

    public String toString() {
        Object str;
        StringBuilder stringBuilder = new StringBuilder(200);
        stringBuilder.append("<<\n");
        stringBuilder.append(" mode: ");
        stringBuilder.append(this.a);
        stringBuilder.append("\n ecLevel: ");
        stringBuilder.append(this.b);
        stringBuilder.append("\n version: ");
        stringBuilder.append(this.c);
        stringBuilder.append("\n maskPattern: ");
        stringBuilder.append(this.d);
        if (this.e == null) {
            stringBuilder.append("\n matrix: null\n");
        } else {
            stringBuilder.append("\n matrix:\n");
            stringBuilder.append(this.e);
        }
        stringBuilder.append(">>\n");
        return stringBuilder.toString();
    }
}
