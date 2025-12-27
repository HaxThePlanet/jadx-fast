package com.googlecode.mp4parser.g;

/* compiled from: CharCache.java */
/* loaded from: classes2.dex */
public class a {

    private char[] a;
    private int b;
    public a(int i) {
        super();
        this.a = new char[i];
    }

    public void a(char c) {
        if (this.b < cArr.length - 1) {
            this.a[this.b] = c;
            this.b++;
        }
    }

    public void b() {
        this.b = 0;
    }

    public int c() {
        return this.b;
    }

    public String toString() throws java.io.UnsupportedEncodingException {
        return new String(this.a, 0, this.b);
    }
}
