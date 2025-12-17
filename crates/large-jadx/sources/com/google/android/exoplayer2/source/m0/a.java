package com.google.android.exoplayer2.source.m0;

import java.util.NoSuchElementException;

/* loaded from: classes2.dex */
public abstract class a implements com.google.android.exoplayer2.source.m0.e {

    private final long b;
    private final long c;
    private long d;
    public a(long l, long l2) {
        super();
        this.b = l;
        this.c = obj3;
        f();
    }

    @Override // com.google.android.exoplayer2.source.m0.e
    protected final void c() {
        long cmp2;
        int cmp;
        cmp2 = this.d;
        if (Long.compare(cmp2, l) < 0) {
        } else {
            if (Long.compare(cmp2, cmp) > 0) {
            } else {
            }
        }
        NoSuchElementException noSuchElementException = new NoSuchElementException();
        throw noSuchElementException;
    }

    @Override // com.google.android.exoplayer2.source.m0.e
    protected final long d() {
        return this.d;
    }

    @Override // com.google.android.exoplayer2.source.m0.e
    public boolean e() {
        int i;
        i = Long.compare(l, l2) > 0 ? 1 : 0;
        return i;
    }

    @Override // com.google.android.exoplayer2.source.m0.e
    public void f() {
        this.d = l -= i2;
    }

    @Override // com.google.android.exoplayer2.source.m0.e
    public boolean next() {
        this.d = l += i3;
        return z ^= 1;
    }
}
