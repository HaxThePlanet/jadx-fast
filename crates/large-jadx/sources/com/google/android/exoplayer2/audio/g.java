package com.google.android.exoplayer2.audio;

/* loaded from: classes2.dex */
public final class g implements Runnable {

    public final com.google.android.exoplayer2.audio.s.a a;
    public final String b;
    public final long c;
    public final long v;
    public g(com.google.android.exoplayer2.audio.s.a s$a, String string2, long l3, long l4) {
        super();
        this.a = a;
        this.b = string2;
        this.c = l3;
        this.v = obj5;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.a.m(this.b, this.c, obj3);
    }
}
