package com.google.android.exoplayer2.util;

import java.util.Arrays;

/* loaded from: classes2.dex */
public final class w {

    private int a;
    private long[] b;
    public w() {
        super(32);
    }

    public w(int i) {
        super();
        this.b = new long[i];
    }

    public void a(long l) {
        int copyOf;
        copyOf = this.a;
        long[] lArr2 = this.b;
        if (copyOf == lArr2.length) {
            this.b = Arrays.copyOf(lArr2, copyOf *= 2);
        }
        int i2 = this.a;
        this.a = i2 + 1;
        this.b[i2] = l;
    }

    public long b(int i) {
        int i2;
        if (i < 0) {
        } else {
            if (i >= this.a) {
            } else {
                return this.b[i];
            }
        }
        StringBuilder stringBuilder = new StringBuilder(46);
        stringBuilder.append("Invalid index ");
        stringBuilder.append(i);
        stringBuilder.append(", size is ");
        stringBuilder.append(this.a);
        IndexOutOfBoundsException indexOutOfBoundsException = new IndexOutOfBoundsException(stringBuilder.toString());
        throw indexOutOfBoundsException;
    }

    public int c() {
        return this.a;
    }

    public long[] d() {
        return Arrays.copyOf(this.b, this.a);
    }
}
