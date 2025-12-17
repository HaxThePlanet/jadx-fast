package com.google.android.exoplayer2.audio;

import com.google.android.exoplayer2.decoder.e;
import com.google.android.exoplayer2.i1;

/* loaded from: classes2.dex */
public final class f implements Runnable {

    public final com.google.android.exoplayer2.audio.s.a a;
    public final i1 b;
    public final e c;
    public f(com.google.android.exoplayer2.audio.s.a s$a, i1 i12, e e3) {
        super();
        this.a = a;
        this.b = i12;
        this.c = e3;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.a.u(this.b, this.c);
    }
}
