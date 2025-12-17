package com.google.android.exoplayer2;

/* loaded from: classes.dex */
public final class l0 implements Runnable {

    public final com.google.android.exoplayer2.f2 a;
    public l0(com.google.android.exoplayer2.f2 f2) {
        super();
        this.a = f2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        f2.c.a(this.a);
    }
}
