package com.google.android.exoplayer2.audio;

/* loaded from: classes2.dex */
public final class i implements Runnable {

    public final com.google.android.exoplayer2.audio.s.a a;
    public final long b;
    public i(com.google.android.exoplayer2.audio.s.a s$a, long l2) {
        super();
        this.a = a;
        this.b = l2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.a.w(this.b);
    }
}
