package com.google.android.play.core.assetpacks;

import java.io.InputStream;

/* loaded from: classes2.dex */
final class h0 extends InputStream {

    private final InputStream a;
    private long b;
    h0(InputStream inputStream, long l2) {
        super();
        this.a = inputStream;
        this.b = l2;
    }

    @Override // java.io.InputStream
    public final void close() {
        super.close();
        this.a.close();
        this.b = 0;
    }

    @Override // java.io.InputStream
    public final int read() {
        long l = this.b;
        if (Long.compare(l, i3) <= 0) {
            return -1;
        }
        this.b = l += i4;
        return this.a.read();
    }

    @Override // java.io.InputStream
    public final int read(byte[] bArr, int i2, int i3) {
        int i;
        int obj8;
        long l = this.b;
        final int i5 = -1;
        if (Long.compare(l, i4) <= 0) {
            return i5;
        }
        final int obj7 = this.a.read(bArr, i2, (int)l2);
        if (obj7 != i5) {
            this.b = obj8 -= i;
        }
        return obj7;
    }
}
