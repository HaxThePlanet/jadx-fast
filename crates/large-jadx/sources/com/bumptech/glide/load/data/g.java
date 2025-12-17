package com.bumptech.glide.load.data;

import java.io.FilterInputStream;
import java.io.InputStream;

/* loaded from: classes.dex */
public final class g extends FilterInputStream {

    private static final byte[] c;
    private static final int v;
    private static final int w;
    private final byte a = 8;
    private int b;
    static {
        byte[] bArr = new byte[29];
        bArr = new byte[]{
            -1, -31, 0, 28, 69, 120, 105, 102, 0, 0,
            77, 77, 0, 0, 0, 0, 0, 8, 0, 1,
            1, 18, 0, 2, 0, 0, 0, 1, 0
        };
        g.c = bArr;
        int length = bArr.length;
        g.v = length;
        g.w = length += 2;
    }

    public g(InputStream inputStream, int i2) {
        int obj3;
        super(inputStream);
        if (i2 < -1) {
        } else {
            if (i2 > 8) {
            } else {
                obj3 = (byte)i2;
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Cannot add invalid orientation: ");
        stringBuilder.append(i2);
        obj3 = new IllegalArgumentException(stringBuilder.toString());
        throw obj3;
    }

    @Override // java.io.FilterInputStream
    public void mark(int i) {
        UnsupportedOperationException obj1 = new UnsupportedOperationException();
        throw obj1;
    }

    @Override // java.io.FilterInputStream
    public boolean markSupported() {
        return 0;
    }

    @Override // java.io.FilterInputStream
    public int read() {
        int read;
        int i2;
        int i;
        int i3 = this.b;
        int i5 = 2;
        if (i3 >= i5) {
            i = g.w;
            if (i3 > i) {
                read = super.read();
            } else {
                if (i3 == i) {
                    read = this.a;
                } else {
                    b &= 255;
                }
            }
        } else {
        }
        if (read != -1) {
            this.b = i6++;
        }
        return read;
    }

    @Override // java.io.FilterInputStream
    public int read(byte[] bArr, int i2, int i3) {
        int i;
        int i4;
        int i5;
        int obj4;
        int obj5;
        byte obj6;
        i = this.b;
        i4 = g.w;
        if (i > i4) {
            obj4 = super.read(bArr, i2, i3);
        } else {
            if (i == i4) {
                bArr[i2] = this.a;
                obj4 = 1;
            } else {
                i5 = 2;
                if (i < i5) {
                    obj4 = super.read(bArr, i2, i5 -= i);
                } else {
                    obj6 = Math.min(i4 -= i, i3);
                    System.arraycopy(g.c, i7 -= i5, bArr, i2, obj6);
                    obj4 = obj6;
                }
            }
        }
        if (obj4 > 0) {
            this.b = obj5 += obj4;
        }
        return obj4;
    }

    @Override // java.io.FilterInputStream
    public void reset() {
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
        throw unsupportedOperationException;
    }

    @Override // java.io.FilterInputStream
    public long skip(long l) {
        int cmp;
        final long obj3 = super.skip(l);
        if (Long.compare(obj3, i) > 0) {
            this.b = (int)i3;
        }
        return obj3;
    }
}
