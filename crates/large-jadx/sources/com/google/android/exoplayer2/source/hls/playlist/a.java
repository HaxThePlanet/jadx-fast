package com.google.android.exoplayer2.source.hls.playlist;

import android.net.Uri;

/* loaded from: classes2.dex */
public final class a implements Runnable {

    public final com.google.android.exoplayer2.source.hls.playlist.d.c a;
    public final Uri b;
    public a(com.google.android.exoplayer2.source.hls.playlist.d.c d$c, Uri uri2) {
        super();
        this.a = c;
        this.b = uri2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.a.n(this.b);
    }
}
