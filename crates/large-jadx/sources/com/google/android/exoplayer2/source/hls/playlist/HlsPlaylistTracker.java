package com.google.android.exoplayer2.source.hls.playlist;

import android.net.Uri;
import com.google.android.exoplayer2.source.hls.j;
import com.google.android.exoplayer2.source.z.a;
import com.google.android.exoplayer2.upstream.w;
import com.google.android.exoplayer2.upstream.w.c;
import java.io.IOException;

/* loaded from: classes2.dex */
public interface HlsPlaylistTracker {

    public static final class PlaylistResetException extends IOException {

        public final Uri url;
        public PlaylistResetException(Uri uri) {
            super();
            this.url = uri;
        }
    }

    public static final class PlaylistStuckException extends IOException {

        public final Uri url;
        public PlaylistStuckException(Uri uri) {
            super();
            this.url = uri;
        }
    }

    public interface a {
        public abstract com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker a(j j, w w2, com.google.android.exoplayer2.source.hls.playlist.i i3);
    }

    public interface b {
        public abstract void g();

        public abstract boolean h(Uri uri, w.c w$c2, boolean z3);
    }

    public interface c {
        public abstract void c(com.google.android.exoplayer2.source.hls.playlist.g g);
    }
    public abstract boolean a(Uri uri);

    public abstract void b(com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker.b hlsPlaylistTracker$b);

    public abstract void c(Uri uri);

    public abstract long d();

    public abstract boolean e();

    public abstract boolean f(Uri uri, long l2);

    public abstract com.google.android.exoplayer2.source.hls.playlist.f g();

    public abstract void i(Uri uri, z.a z$a2, com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker.c hlsPlaylistTracker$c3);

    public abstract void k();

    public abstract void l(Uri uri);

    public abstract void m(com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker.b hlsPlaylistTracker$b);

    public abstract com.google.android.exoplayer2.source.hls.playlist.g n(Uri uri, boolean z2);

    public abstract void stop();
}
