package com.google.android.exoplayer2.source.hls.playlist;

import com.google.android.exoplayer2.source.hls.j;
import com.google.android.exoplayer2.upstream.w;

/* loaded from: classes2.dex */
public final class b implements com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker.a {

    public static final com.google.android.exoplayer2.source.hls.playlist.b a;
    static {
        b bVar = new b();
        b.a = bVar;
    }

    @Override // com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker$a
    public final com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker a(j j, w w2, com.google.android.exoplayer2.source.hls.playlist.i i3) {
        d dVar = new d(j, w2, i3);
        return dVar;
    }
}
