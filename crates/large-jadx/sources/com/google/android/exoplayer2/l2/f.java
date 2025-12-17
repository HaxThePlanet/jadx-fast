package com.google.android.exoplayer2.l2;

import com.google.android.exoplayer2.upstream.i;
import com.google.android.exoplayer2.util.p0;
import java.io.EOFException;
import java.io.InterruptedIOException;
import java.util.Arrays;

/* loaded from: classes2.dex */
public final class f implements com.google.android.exoplayer2.l2.j {

    private final byte[] a;
    private final i b;
    private final long c;
    private long d;
    private byte[] e;
    private int f;
    private int g;
    public f(i i, long l2, long l3) {
        super();
        this.b = i;
        this.d = l2;
        this.c = obj4;
        this.e = new byte[65536];
        this.a = new byte[4096];
    }

    private void n(int i) {
        int i2;
        long l;
        if (i != -1) {
            this.d = l2 += l;
        }
    }

    private void o(int i) {
        int i3;
        int length;
        int i2;
        byte[] obj4;
        i4 += i;
        obj4 = this.e;
        if (i3 > obj4.length) {
            this.e = Arrays.copyOf(this.e, p0.p(obj4 *= 2, i6 += i3, i3 += i2));
        }
    }

    private int p(byte[] bArr, int i2, int i3) {
        int i = this.g;
        final int i4 = 0;
        if (i == 0) {
            return i4;
        }
        final int obj5 = Math.min(i, i3);
        System.arraycopy(this.e, i4, bArr, i2, obj5);
        t(obj5);
        return obj5;
    }

    private int q(byte[] bArr, int i2, int i3, int i4, boolean z5) {
        if (Thread.interrupted()) {
        } else {
            int obj2 = this.b.read(bArr, i2 += i4, i3 -= i4);
            int obj3 = -1;
            if (obj2 == obj3) {
                if (i4 != 0) {
                } else {
                    if (!z5) {
                    } else {
                        return obj3;
                    }
                }
                obj2 = new EOFException();
                throw obj2;
            }
            return i4 += obj2;
        }
        obj2 = new InterruptedIOException();
        throw obj2;
    }

    private int r(int i) {
        final int obj2 = Math.min(this.g, i);
        t(obj2);
        return obj2;
    }

    private void t(int i) {
        byte[] bArr;
        i2 -= i;
        this.g = i3;
        final int i4 = 0;
        this.f = i4;
        final byte[] bArr2 = this.e;
        if (i3 < length -= i8) {
            bArr = new byte[i6 += i3];
        } else {
            bArr = bArr2;
        }
        System.arraycopy(bArr2, i, bArr, i4, i3);
        this.e = bArr;
    }

    @Override // com.google.android.exoplayer2.l2.j
    public boolean a(byte[] bArr, int i2, int i3, boolean z4) {
        int i;
        Object obj;
        byte[] bArr2;
        int i6;
        int i4;
        int i5;
        boolean z;
        int obj8;
        i5 = i;
        i = -1;
        while (i5 < i3) {
            if (i5 != i) {
            }
            i5 = this.q(bArr, i2, i3, i5, z4);
            i = -1;
        }
        n(i5);
        obj8 = i5 != i ? 1 : 0;
        return obj8;
    }

    @Override // com.google.android.exoplayer2.l2.j
    public boolean e(byte[] bArr, int i2, int i3, boolean z4) {
        if (!k(i3, z4)) {
            return 0;
        }
        System.arraycopy(this.e, i -= i3, bArr, i2, i3);
        return 1;
    }

    @Override // com.google.android.exoplayer2.l2.j
    public long f() {
        return l += l2;
    }

    @Override // com.google.android.exoplayer2.l2.j
    public void g(int i) {
        k(i, false);
    }

    @Override // com.google.android.exoplayer2.l2.j
    public long getLength() {
        return this.c;
    }

    @Override // com.google.android.exoplayer2.l2.j
    public long getPosition() {
        return this.d;
    }

    @Override // com.google.android.exoplayer2.l2.j
    public void i() {
        this.f = 0;
    }

    @Override // com.google.android.exoplayer2.l2.j
    public void j(int i) {
        s(i, false);
    }

    @Override // com.google.android.exoplayer2.l2.j
    public boolean k(int i, boolean z2) {
        int i3;
        int i6;
        byte[] bArr;
        int i2;
        int i5;
        int i4;
        boolean z;
        o(i);
        i4 = i3;
        while (i4 < i) {
            i4 = this.q(this.e, this.f, i, i4, z2);
            this.g = i9 += i4;
        }
        this.f = obj9 += i;
        return 1;
    }

    @Override // com.google.android.exoplayer2.l2.j
    public void m(byte[] bArr, int i2, int i3) {
        e(bArr, i2, i3, false);
    }

    @Override // com.google.android.exoplayer2.l2.j
    public int read(byte[] bArr, int i2, int i3) {
        int i4;
        Object obj;
        byte[] bArr2;
        int i;
        int i5;
        int i6;
        int i7;
        if (p(bArr, i2, i3) == 0) {
            i4 = this.q(bArr, i2, i3, 0, true);
        }
        n(i4);
        return i4;
    }

    @Override // com.google.android.exoplayer2.l2.j
    public void readFully(byte[] bArr, int i2, int i3) {
        a(bArr, i2, i3, false);
    }

    @Override // com.google.android.exoplayer2.l2.j
    public boolean s(int i, boolean z2) {
        int i3;
        Object obj;
        byte[] bArr;
        int i2;
        int i4;
        int i5;
        boolean z;
        int obj8;
        i5 = i3;
        int i6 = -1;
        while (i5 < i) {
            if (i5 != i6) {
            }
            i5 = this.q(this.a, -i5, Math.min(i, length += i5), i5, z2);
            i6 = -1;
        }
        n(i5);
        obj8 = i5 != i6 ? 1 : 0;
        return obj8;
    }
}
