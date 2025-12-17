package com.google.android.exoplayer2.mediacodec;

/* loaded from: classes2.dex */
public final class d implements Runnable {

    public final com.google.android.exoplayer2.mediacodec.n a;
    public final Runnable b;
    public d(com.google.android.exoplayer2.mediacodec.n n, Runnable runnable2) {
        super();
        this.a = n;
        this.b = runnable2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.a.j(this.b);
    }
}
