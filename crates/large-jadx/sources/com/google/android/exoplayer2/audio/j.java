package com.google.android.exoplayer2.audio;

/* loaded from: classes2.dex */
public final class j implements Runnable {

    public final com.google.android.exoplayer2.audio.s.a a;
    public final int b;
    public final long c;
    public final long v;
    public j(com.google.android.exoplayer2.audio.s.a s$a, int i2, long l3, long l4) {
        super();
        this.a = a;
        this.b = i2;
        this.c = l3;
        this.v = obj5;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.a.A(this.b, this.c, obj3);
    }
}
