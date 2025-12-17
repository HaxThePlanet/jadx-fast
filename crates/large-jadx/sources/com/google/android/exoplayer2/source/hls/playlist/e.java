package com.google.android.exoplayer2.source.hls.playlist;

import com.google.android.exoplayer2.offline.b;
import com.google.android.exoplayer2.offline.c;
import com.google.android.exoplayer2.upstream.x.a;
import java.util.List;

/* loaded from: classes2.dex */
public final class e implements com.google.android.exoplayer2.source.hls.playlist.i {

    private final com.google.android.exoplayer2.source.hls.playlist.i a;
    private final List<c> b;
    public e(com.google.android.exoplayer2.source.hls.playlist.i i, List<c> list2) {
        super();
        this.a = i;
        this.b = list2;
    }

    public x.a<com.google.android.exoplayer2.source.hls.playlist.h> a(com.google.android.exoplayer2.source.hls.playlist.f f, com.google.android.exoplayer2.source.hls.playlist.g g2) {
        b bVar = new b(this.a.a(f, g2), this.b);
        return bVar;
    }

    public x.a<com.google.android.exoplayer2.source.hls.playlist.h> b() {
        b bVar = new b(this.a.b(), this.b);
        return bVar;
    }
}
