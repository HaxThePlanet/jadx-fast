package com.google.android.exoplayer2;

/* loaded from: classes.dex */
public final class x implements Runnable {

    public final com.google.android.exoplayer2.f1 a;
    public final com.google.android.exoplayer2.g1.e b;
    public x(com.google.android.exoplayer2.f1 f1, com.google.android.exoplayer2.g1.e g1$e2) {
        super();
        this.a = f1;
        this.b = e2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.a.H0(this.b);
    }
}
