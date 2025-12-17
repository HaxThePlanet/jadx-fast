package com.bumptech.glide.t;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes.dex */
public final class c extends FilterInputStream {

    private final long a;
    private int b;
    private c(InputStream inputStream, long l2) {
        super(inputStream);
        this.a = l2;
    }

    private int a(int i) {
        int cmp;
        int i2;
        if (i >= 0) {
            this.b = i3 += i;
            return i;
        } else {
            i2 = 0;
            if (Long.compare(i4, i2) > 0) {
            } else {
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Failed to read all expected data, expected: ");
        stringBuilder.append(this.a);
        stringBuilder.append(", but read: ");
        stringBuilder.append(this.b);
        IOException obj5 = new IOException(stringBuilder.toString());
        throw obj5;
    }

    public static InputStream c(InputStream inputStream, long l2) {
        c cVar = new c(inputStream, l2, obj3);
        return cVar;
    }

    @Override // java.io.FilterInputStream
    public int available() {
        return (int)l2;
        synchronized (this) {
            return (int)l2;
        }
    }

    @Override // java.io.FilterInputStream
    public int read() {
        int i;
        final int read = super.read();
        synchronized (this) {
            try {
                i = 1;
                i = -1;
                a(i);
                return read;
                throw th;
            }
        }
    }

    @Override // java.io.FilterInputStream
    public int read(byte[] bArr) {
        return read(bArr, 0, bArr.length);
    }

    @Override // java.io.FilterInputStream
    public int read(byte[] bArr, int i2, int i3) {
        final int obj1 = super.read(bArr, i2, i3);
        a(obj1);
        return obj1;
        synchronized (this) {
            obj1 = super.read(bArr, i2, i3);
            a(obj1);
            return obj1;
        }
    }
}
