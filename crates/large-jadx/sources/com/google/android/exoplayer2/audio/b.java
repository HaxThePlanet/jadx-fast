package com.google.android.exoplayer2.audio;

/* loaded from: classes2.dex */
public final class b implements Runnable {

    public final com.google.android.exoplayer2.audio.s.a a;
    public final boolean b;
    public b(com.google.android.exoplayer2.audio.s.a s$a, boolean z2) {
        super();
        this.a = a;
        this.b = z2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.a.y(this.b);
    }
}
