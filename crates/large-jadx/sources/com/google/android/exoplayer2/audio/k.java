package com.google.android.exoplayer2.audio;

import com.google.android.exoplayer2.decoder.d;

/* loaded from: classes2.dex */
public final class k implements Runnable {

    public final com.google.android.exoplayer2.audio.s.a a;
    public final d b;
    public k(com.google.android.exoplayer2.audio.s.a s$a, d d2) {
        super();
        this.a = a;
        this.b = d2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.a.s(this.b);
    }
}
