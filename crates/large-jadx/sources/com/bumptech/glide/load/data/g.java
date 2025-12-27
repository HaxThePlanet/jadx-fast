package com.bumptech.glide.load.data;

import java.io.FilterInputStream;
import java.io.InputStream;

/* compiled from: ExifOrientationStream.java */
/* loaded from: classes.dex */
public final class g extends FilterInputStream {

    private static final byte[] c;
    private static final int v = 0;
    private static final int w = 0;
    private final byte a;
    private int b;
    static {
        byte[] bArr = new byte[] {-1, -31, 0, 28, 69, 120, 105, 102, 0, 0, 77, 77, 0, 0, 0, 0, 0, 8, 0, 1, 1, 18, 0, 2, 0, 0, 0, 1, 0};
        g.c = bArr;
        int length = bArr.length;
        g.v = length;
        g.w = length + 2;
    }

    public g(InputStream inputStream, int i) {
        super(inputStream);
        i = -1;
        if (i < -1) {
            final StringBuilder stringBuilder = new StringBuilder();
            final String str = "Cannot add invalid orientation: ";
            i = str + i;
            throw new IllegalArgumentException(i);
        } else {
            i = 8;
            if (i <= 8) {
                this.a = (byte)i;
                return;
            }
        }
    }

    @Override // java.io.FilterInputStream
    public void mark(int i) {
        throw new UnsupportedOperationException();
    }

    @Override // java.io.FilterInputStream
    public int read() throws java.io.IOException {
        int read;
        int i2;
        int i5 = 2;
        if (this.b < i5 || this.b > g.w) {
            read = super.read();
        }
        int i = -1;
        if (this.b != -1) {
            this.b++;
        }
        return read;
    }

    @Override // java.io.FilterInputStream
    public void reset() {
        throw new UnsupportedOperationException();
    }

    @Override // java.io.FilterInputStream
    public long skip(long j) throws java.io.IOException {
        final long skip = super.skip(j);
        if (skip > 0) {
            cmp = (int)(long)this.b + skip;
            this.b = cmp;
        }
        return skip;
    }

    @Override // java.io.FilterInputStream
    public int read(byte[] bArr, int i, int i2) throws java.io.IOException {
        int i32 = 1;
        i4 = g.w;
        if (this.b > g.w) {
            i32 = super.read(bArr, i, i2);
        } else {
            if (this.b == g.w) {
                bArr[i] = this.a;
                i32 = 1;
            } else {
                int i5 = 2;
                if (this.b < i5) {
                    i5 = i5 - i;
                    i32 = super.read(bArr, i, i5);
                } else {
                    i32 = Math.min(g.w - i, i2);
                    i4 = this.b - i5;
                    System.arraycopy(g.c, i4, bArr, i, i32);
                }
            }
        }
        if (i32 > 0) {
            this.b += i32;
        }
        return i32;
    }

    @Override // java.io.FilterInputStream
    public boolean markSupported() {
        return false;
    }
}
