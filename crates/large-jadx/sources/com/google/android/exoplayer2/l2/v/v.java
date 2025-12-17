package com.google.android.exoplayer2.l2.v;

import com.google.android.exoplayer2.util.g;
import java.util.Arrays;

/* loaded from: classes2.dex */
final class v {

    private final int a;
    private boolean b;
    private boolean c;
    public byte[] d;
    public int e;
    public v(int i, int i2) {
        super();
        this.a = i;
        final byte[] obj2 = new byte[i2 += 3];
        this.d = obj2;
        obj2[2] = 1;
    }

    public void a(byte[] bArr, int i2, int i3) {
        byte[] copyOf;
        int i;
        if (!this.b) {
        }
        i3 -= i2;
        copyOf = this.d;
        i = this.e;
        if (copyOf.length < i + obj7) {
            this.d = Arrays.copyOf(copyOf, i5 *= 2);
        }
        System.arraycopy(bArr, i2, this.d, this.e, obj7);
        this.e = obj5 += obj7;
    }

    public boolean b(int i) {
        final int i4 = 0;
        if (!this.b) {
            return i4;
        }
        this.e = i2 -= i;
        this.b = i4;
        final int obj3 = 1;
        this.c = obj3;
        return obj3;
    }

    public boolean c() {
        return this.c;
    }

    public void d() {
        final int i = 0;
        this.b = i;
        this.c = i;
    }

    public void e(int i) {
        int i2;
        int obj4;
        g.f(z ^= i2);
        final int i5 = 0;
        if (i == this.a) {
        } else {
            i2 = i5;
        }
        this.b = i2;
        if (i2 != 0) {
            this.e = 3;
            this.c = i5;
        }
    }
}
