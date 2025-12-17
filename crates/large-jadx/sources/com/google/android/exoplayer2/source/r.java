package com.google.android.exoplayer2.source;

import com.google.android.exoplayer2.g2;

/* loaded from: classes2.dex */
public abstract class r extends g2 {

    protected final g2 b;
    public r(g2 g2) {
        super();
        this.b = g2;
    }

    @Override // com.google.android.exoplayer2.g2
    public int a(boolean z) {
        return this.b.a(z);
    }

    @Override // com.google.android.exoplayer2.g2
    public int b(Object object) {
        return this.b.b(object);
    }

    @Override // com.google.android.exoplayer2.g2
    public int c(boolean z) {
        return this.b.c(z);
    }

    @Override // com.google.android.exoplayer2.g2
    public int e(int i, int i2, boolean z3) {
        return this.b.e(i, i2, z3);
    }

    @Override // com.google.android.exoplayer2.g2
    public int i() {
        return this.b.i();
    }

    @Override // com.google.android.exoplayer2.g2
    public int l(int i, int i2, boolean z3) {
        return this.b.l(i, i2, z3);
    }

    @Override // com.google.android.exoplayer2.g2
    public Object m(int i) {
        return this.b.m(i);
    }

    @Override // com.google.android.exoplayer2.g2
    public int p() {
        return this.b.p();
    }
}
