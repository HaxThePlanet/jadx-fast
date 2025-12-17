package com.googlecode.mp4parser.g.d;

import com.googlecode.mp4parser.g.a;
import java.io.InputStream;

/* loaded from: classes2.dex */
public class a {

    protected static int f;
    private InputStream a;
    private int b;
    private int c;
    int d;
    protected a e;
    public a(InputStream inputStream) {
        super();
        a aVar = new a(50);
        this.e = aVar;
        this.a = inputStream;
        this.b = inputStream.read();
        this.c = inputStream.read();
    }

    private void a() {
        this.b = this.c;
        this.c = this.a.read();
        this.d = 0;
    }

    public boolean b() {
        int i3;
        int i2;
        int i;
        int i6 = 8;
        if (this.d == i6) {
            a();
        }
        i3 = 1;
        int i9 = i3 << i8;
        i = this.b;
        final int i14 = 0;
        i2 = i11 &= i == i9 ? i3 : i14;
        int i13 = -1;
        if (i != i13) {
            if (this.c == i13 && i2 != 0) {
                if (i2 != 0) {
                    i3 = i14;
                }
            }
        } else {
        }
        return i3;
    }

    public int c() {
        int i2;
        int i3;
        int i;
        a();
        i3 = -1;
        if (this.d == 8 && this.b == i3) {
            a();
            i3 = -1;
            if (this.b == i3) {
                return i3;
            }
        }
        int i7 = this.d;
        i5 &= 1;
        this.d = i7++;
        i = i6 == 0 ? 48 : 49;
        this.e.a(i);
        a.f = i9++;
        return i6;
    }

    public long d(int i) {
        int i3;
        int i2;
        long l;
        if (i > 64) {
        } else {
            i3 = 0;
            i2 = 0;
            while (i2 >= i) {
                i5 |= l;
                i2++;
            }
            return i3;
        }
        IllegalArgumentException obj6 = new IllegalArgumentException("Can not readByte more then 64 bit");
        throw obj6;
    }

    public long e() {
        return d(i - 8);
    }
}
