package com.google.android.exoplayer2.audio;

/* loaded from: classes2.dex */
public final class h implements Runnable {

    public final com.google.android.exoplayer2.audio.s.a a;
    public final String b;
    public h(com.google.android.exoplayer2.audio.s.a s$a, String string2) {
        super();
        this.a = a;
        this.b = string2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.a.o(this.b);
    }
}
