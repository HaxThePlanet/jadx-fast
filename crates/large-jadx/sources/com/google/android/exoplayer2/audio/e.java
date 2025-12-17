package com.google.android.exoplayer2.audio;

/* loaded from: classes2.dex */
public final class e implements Runnable {

    public final com.google.android.exoplayer2.audio.s.a a;
    public final Exception b;
    public e(com.google.android.exoplayer2.audio.s.a s$a, Exception exception2) {
        super();
        this.a = a;
        this.b = exception2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.a.k(this.b);
    }
}
