package com.google.android.exoplayer2.upstream;

import com.google.android.exoplayer2.util.g;
import java.io.InputStream;

/* loaded from: classes2.dex */
public final class m extends InputStream {

    private final com.google.android.exoplayer2.upstream.l a;
    private final com.google.android.exoplayer2.upstream.n b;
    private final byte[] c;
    private boolean v = false;
    private boolean w = false;
    private long x;
    public m(com.google.android.exoplayer2.upstream.l l, com.google.android.exoplayer2.upstream.n n2) {
        super();
        final int i = 0;
        this.a = l;
        this.b = n2;
        this.c = new byte[1];
    }

    private void a() {
        boolean z;
        com.google.android.exoplayer2.upstream.n nVar;
        if (!this.v) {
            this.a.c(this.b);
            this.v = true;
        }
    }

    @Override // java.io.InputStream
    public void c() {
        a();
    }

    @Override // java.io.InputStream
    public void close() {
        boolean z;
        if (!this.w) {
            this.a.close();
            this.w = true;
        }
    }

    @Override // java.io.InputStream
    public int read() {
        int read;
        int i;
        if (read(this.c) == -1) {
        } else {
            i = read & 255;
        }
        return i;
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr) {
        return read(bArr, 0, bArr.length);
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i2, int i3) {
        g.f(z ^= 1);
        a();
        final int obj3 = this.a.read(bArr, i2, i3);
        int obj4 = -1;
        if (obj3 == obj4) {
            return obj4;
        }
        this.x = obj4 += l;
        return obj3;
    }
}
