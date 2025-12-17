package com.google.android.exoplayer2.video;

/* loaded from: classes2.dex */
public final class c implements Runnable {

    public final com.google.android.exoplayer2.video.z.a a;
    public final String b;
    public c(com.google.android.exoplayer2.video.z.a z$a, String string2) {
        super();
        this.a = a;
        this.b = string2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.a.j(this.b);
    }
}
