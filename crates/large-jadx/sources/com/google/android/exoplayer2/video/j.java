package com.google.android.exoplayer2.video;

import com.google.android.exoplayer2.decoder.e;
import com.google.android.exoplayer2.i1;

/* loaded from: classes2.dex */
public final class j implements Runnable {

    public final com.google.android.exoplayer2.video.z.a a;
    public final i1 b;
    public final e c;
    public j(com.google.android.exoplayer2.video.z.a z$a, i1 i12, e e3) {
        super();
        this.a = a;
        this.b = i12;
        this.c = e3;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.a.r(this.b, this.c);
    }
}
