package com.google.android.exoplayer2.util;

/* loaded from: classes2.dex */
public final class c implements Runnable {

    public final com.google.android.exoplayer2.util.b0 a;
    public final com.google.android.exoplayer2.util.b0.c b;
    public c(com.google.android.exoplayer2.util.b0 b0, com.google.android.exoplayer2.util.b0.c b0$c2) {
        super();
        this.a = b0;
        this.b = c2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.a.h(this.b);
    }
}
