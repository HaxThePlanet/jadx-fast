package com.google.android.exoplayer2.video;

/* loaded from: classes2.dex */
public final class h implements Runnable {

    public final com.google.android.exoplayer2.video.z.a a;
    public final String b;
    public final long c;
    public final long v;
    public h(com.google.android.exoplayer2.video.z.a z$a, String string2, long l3, long l4) {
        super();
        this.a = a;
        this.b = string2;
        this.c = l3;
        this.v = obj5;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.a.h(this.b, this.c, obj3);
    }
}
