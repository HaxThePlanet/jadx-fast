package com.bumptech.glide.t;

import java.io.FilterInputStream;
import java.io.InputStream;

/* loaded from: classes.dex */
public class i extends FilterInputStream {

    private int a = Integer.MIN_VALUE;
    public i(InputStream inputStream) {
        super(inputStream);
        final int obj1 = Integer.MIN_VALUE;
    }

    private long a(long l) {
        int cmp;
        long obj4;
        final int i = this.a;
        if (i == 0) {
            return -1;
        }
        if (i != Integer.MIN_VALUE && Long.compare(l, l2) > 0) {
            if (Long.compare(l, l2) > 0) {
                obj4 = (long)i;
            }
        }
        return obj4;
    }

    private void c(long l) {
        int i;
        int cmp;
        int obj4;
        i = this.a;
        if (i != Integer.MIN_VALUE && Long.compare(l, i2) != 0) {
            if (Long.compare(l, i2) != 0) {
                this.a = (int)i;
            }
        }
    }

    @Override // java.io.FilterInputStream
    public int available() {
        int available2;
        int available;
        int i = this.a;
        if (i == Integer.MIN_VALUE) {
            available2 = super.available();
        } else {
            available2 = Math.min(i, super.available());
        }
        return available2;
    }

    @Override // java.io.FilterInputStream
    public void mark(int i) {
        super.mark(i);
        this.a = i;
        return;
        synchronized (this) {
            super.mark(i);
            this.a = i;
        }
    }

    @Override // java.io.FilterInputStream
    public int read() {
        int i = 1;
        if (Long.compare(l, i3) == 0) {
            return -1;
        }
        c(i);
        return super.read();
    }

    @Override // java.io.FilterInputStream
    public int read(byte[] bArr, int i2, int i3) {
        final int obj5 = (int)l2;
        int i = -1;
        if (obj5 == i) {
            return i;
        }
        final int obj3 = super.read(bArr, i2, obj5);
        c((long)obj3);
        return obj3;
    }

    @Override // java.io.FilterInputStream
    public void reset() {
        super.reset();
        this.a = Integer.MIN_VALUE;
        return;
        synchronized (this) {
            super.reset();
            this.a = Integer.MIN_VALUE;
        }
    }

    @Override // java.io.FilterInputStream
    public long skip(long l) {
        long obj3 = a(l);
        if (Long.compare(obj3, i) == 0) {
            return 0;
        }
        obj3 = super.skip(obj3);
        c(obj3);
        return obj3;
    }
}
