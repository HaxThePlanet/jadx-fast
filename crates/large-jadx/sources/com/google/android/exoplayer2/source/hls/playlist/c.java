package com.google.android.exoplayer2.source.hls.playlist;

import com.google.android.exoplayer2.upstream.x.a;

/* loaded from: classes2.dex */
public final class c implements com.google.android.exoplayer2.source.hls.playlist.i {
    public x.a<com.google.android.exoplayer2.source.hls.playlist.h> a(com.google.android.exoplayer2.source.hls.playlist.f f, com.google.android.exoplayer2.source.hls.playlist.g g2) {
        HlsPlaylistParser hlsPlaylistParser = new HlsPlaylistParser(f, g2);
        return hlsPlaylistParser;
    }

    public x.a<com.google.android.exoplayer2.source.hls.playlist.h> b() {
        HlsPlaylistParser hlsPlaylistParser = new HlsPlaylistParser();
        return hlsPlaylistParser;
    }
}
