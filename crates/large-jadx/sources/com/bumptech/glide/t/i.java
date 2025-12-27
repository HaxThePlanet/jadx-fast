package com.bumptech.glide.t;

import java.io.FilterInputStream;
import java.io.InputStream;

/* compiled from: MarkEnforcingInputStream.java */
/* loaded from: classes.dex */
public class i extends FilterInputStream {

    private int a = Integer.MIN_VALUE;
    public i(InputStream inputStream) {
        super(inputStream);
    }

    private long a(long j) {
        long l;
        if (this.a == 0) {
            return -1;
        }
        int cmp = Integer.MIN_VALUE;
        if (this.a != Integer.MIN_VALUE) {
            long l2 = (long)i;
            if (j > Integer.MIN_VALUE) {
                l = (long)i;
            }
        }
        return l;
    }

    private void c(long j) {
        int cmp = Integer.MIN_VALUE;
        if (this.a != Integer.MIN_VALUE) {
            if (j != -1) {
                i2 = (int)(long)i - j;
                this.a = i2;
            }
        }
    }

    @Override // java.io.FilterInputStream
    public int available() throws java.io.IOException {
        int available;
        int available2 = Integer.MIN_VALUE;
        if (this.a == Integer.MIN_VALUE) {
            available = super.available();
        } else {
            available = Math.min(this.a, super.available());
        }
        return available;
    }

    @Override // java.io.FilterInputStream
    public synchronized void mark(int i) {
        super.mark(i);
        this.a = i;
    }

    @Override // java.io.FilterInputStream
    public int read() throws java.io.IOException {
        long l = 1L;
        long l2 = a(l);
        if (l2 == -1) {
            return -1;
        }
        c(l);
        return super.read();
    }

    @Override // java.io.FilterInputStream
    public synchronized void reset() {
        super.reset();
        this.a = Integer.MIN_VALUE;
    }

    @Override // java.io.FilterInputStream
    public long skip(long j) throws java.io.IOException {
        long l = a(j);
        if (l == -1) {
            return 0;
        }
        long skip = super.skip(l);
        c(skip);
        return skip;
    }

    @Override // java.io.FilterInputStream
    public int read(byte[] bArr, int i, int i2) throws java.io.IOException {
        final int i4 = (int)a((long)i2);
        i = -1;
        if (i4 == i) {
            return i;
        }
        final int read = super.read(bArr, i, i4);
        c((long)read);
        return read;
    }
}
