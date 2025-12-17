package com.google.android.exoplayer2.source;

import java.io.IOException;

/* loaded from: classes2.dex */
public final class c implements Runnable {

    public final com.google.android.exoplayer2.source.z.a a;
    public final com.google.android.exoplayer2.source.z b;
    public final com.google.android.exoplayer2.source.s c;
    public final com.google.android.exoplayer2.source.v v;
    public final IOException w;
    public final boolean x;
    public c(com.google.android.exoplayer2.source.z.a z$a, com.google.android.exoplayer2.source.z z2, com.google.android.exoplayer2.source.s s3, com.google.android.exoplayer2.source.v v4, IOException iOException5, boolean z6) {
        super();
        this.a = a;
        this.b = z2;
        this.c = s3;
        this.v = v4;
        this.w = iOException5;
        this.x = z6;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.a.l(this.b, this.c, this.v, this.w, this.x);
    }
}
