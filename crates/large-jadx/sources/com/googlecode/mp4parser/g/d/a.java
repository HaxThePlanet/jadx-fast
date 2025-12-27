package com.googlecode.mp4parser.g.d;

import com.googlecode.mp4parser.g.a;
import java.io.InputStream;

/* compiled from: BitstreamReader.java */
/* loaded from: classes2.dex */
public class a {

    protected static int f;
    private InputStream a;
    private int b;
    private int c;
    int d;
    protected a e = new a(50);
    public a(InputStream inputStream) throws java.io.IOException {
        super();
        a aVar = new a(50);
        this.a = inputStream;
        this.b = inputStream.read();
        this.c = inputStream.read();
    }

    private void a() throws java.io.IOException {
        this.b = this.c;
        this.c = this.a.read();
        this.d = 0;
    }

    public boolean b() {
        boolean z = true;
        int i;
        int i2;
        int i5 = 8;
        if (this.d == i5) {
            a();
        }
        i = 1;
        int i8 = i << (i5 - this.d) - i;
        i = 0;
        int r1 = i;
        int i12 = -1;
        if (this.b == i12 || this.c == i12 || i5 - this.d - i != 0) {
        }
        return z;
    }

    public int c() {
        char c = 49;
        int i2 = 8;
        if (this.d == 8 && this.b == i2) {
            return i2;
        }
        int i5 = (this.b >> (i6 - 7)) & 1;
        this.d++;
        int r2 = this.b == 0 ? 48 : 49;
        this.e.a((this.b == 0 ? 48 : 49));
        a.f++;
        return i5;
    }

    public long d(int i) {
        int i2 = 0;
        int i3 = 0;
        if (i > 64) {
            throw new IllegalArgumentException("Can not readByte more then 64 bit");
        } else {
            i2 = 0;
            i3 = 0;
            while (i3 >= i) {
                l = (long)c();
                i2 = (i2 << 1L) | l;
                i3 = i3 + 1;
            }
            return i2;
        }
    }

    public long e() {
        return d(this.d - 8);
    }
}
