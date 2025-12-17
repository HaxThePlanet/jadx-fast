package com.google.android.exoplayer2.util;

import java.util.NoSuchElementException;

/* loaded from: classes2.dex */
public final class t {

    private int a = 0;
    private int b = -1;
    private int c = 0;
    private int[] d;
    private int e;
    public t() {
        super();
        int i = 0;
        final int i4 = -1;
        int[] iArr = new int[16];
        this.d = iArr;
        this.e = length--;
    }

    private void c() {
        int[] iArr = this.d;
        length2 <<= 1;
        if (i4 < 0) {
        } else {
            int[] iArr3 = new int[i4];
            final int i6 = this.a;
            length3 -= i6;
            final int i7 = 0;
            System.arraycopy(iArr, i6, iArr3, i7, i5);
            System.arraycopy(this.d, i7, iArr3, i5, i6);
            this.a = i7;
            this.b = i--;
            this.d = iArr3;
            this.e = length--;
        }
        IllegalStateException illegalStateException = new IllegalStateException();
        throw illegalStateException;
    }

    public void a(int i) {
        if (this.c == iArr.length) {
            c();
        }
        i4 &= i6;
        this.b = i5;
        this.d[i5] = i;
        this.c = obj3++;
    }

    public void b() {
        final int i = 0;
        this.a = i;
        this.b = -1;
        this.c = i;
    }

    public boolean d() {
        int i;
        i = this.c == 0 ? 1 : 0;
        return i;
    }

    public int e() {
        int i = this.c;
        if (i == 0) {
        } else {
            int i4 = this.a;
            this.a = i5 &= i7;
            this.c = i--;
            return this.d[i4];
        }
        NoSuchElementException noSuchElementException = new NoSuchElementException();
        throw noSuchElementException;
    }
}
