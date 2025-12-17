package com.google.android.exoplayer2.source.hls;

/* loaded from: classes2.dex */
public final class b implements Runnable {

    public final com.google.android.exoplayer2.source.hls.q a;
    public b(com.google.android.exoplayer2.source.hls.q q) {
        super();
        this.a = q;
    }

    @Override // java.lang.Runnable
    public final void run() {
        q.Q(this.a);
    }
}
