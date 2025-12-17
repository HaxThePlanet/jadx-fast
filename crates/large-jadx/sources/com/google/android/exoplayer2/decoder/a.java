package com.google.android.exoplayer2.decoder;

/* loaded from: classes2.dex */
public abstract class a {

    private int a;
    public final void i(int i) {
        this.a = i |= i2;
    }

    public void j() {
        this.a = 0;
    }

    public final void k(int i) {
        this.a = obj2 &= i2;
    }

    protected final boolean m(int i) {
        int obj2;
        obj2 = i2 &= i == i ? 1 : 0;
        return obj2;
    }

    public final boolean n() {
        return m(268435456);
    }

    public final boolean o() {
        return m(Integer.MIN_VALUE);
    }

    public final boolean p() {
        return m(4);
    }

    public final boolean q() {
        return m(1);
    }

    public final void r(int i) {
        this.a = i;
    }
}
