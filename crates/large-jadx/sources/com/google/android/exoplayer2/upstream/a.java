package com.google.android.exoplayer2.upstream;

/* loaded from: classes2.dex */
public final class a implements Runnable {

    public final com.google.android.exoplayer2.upstream.g.a.a.a a;
    public final int b;
    public final long c;
    public final long v;
    public a(com.google.android.exoplayer2.upstream.g.a.a.a g$a$a$a, int i2, long l3, long l4) {
        super();
        this.a = a;
        this.b = i2;
        this.c = l3;
        this.v = obj5;
    }

    @Override // java.lang.Runnable
    public final void run() {
        g.a.a.c(this.a, this.b, this.c, obj3);
    }
}
