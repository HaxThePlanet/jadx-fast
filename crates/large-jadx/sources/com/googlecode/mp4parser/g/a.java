package com.googlecode.mp4parser.g;

/* loaded from: classes2.dex */
public class a {

    private char[] a;
    private int b;
    public a(int i) {
        super();
        this.a = new char[i];
    }

    public void a(char c) {
        int i;
        i = this.b;
        final char[] cArr = this.a;
        if (i < length--) {
            cArr[i] = c;
            this.b = i++;
        }
    }

    public void b() {
        this.b = 0;
    }

    public int c() {
        return this.b;
    }

    public String toString() {
        String string = new String(this.a, 0, this.b);
        return string;
    }
}
