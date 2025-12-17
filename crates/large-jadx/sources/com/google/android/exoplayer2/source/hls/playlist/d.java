package com.google.android.exoplayer2.source.hls.playlist;

import android.net.Uri;
import android.net.Uri.Builder;
import android.os.Handler;
import android.os.SystemClock;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.source.hls.j;
import com.google.android.exoplayer2.source.s;
import com.google.android.exoplayer2.source.v;
import com.google.android.exoplayer2.source.z.a;
import com.google.android.exoplayer2.upstream.Loader;
import com.google.android.exoplayer2.upstream.Loader.b;
import com.google.android.exoplayer2.upstream.Loader.c;
import com.google.android.exoplayer2.upstream.Loader.e;
import com.google.android.exoplayer2.upstream.l;
import com.google.android.exoplayer2.upstream.w;
import com.google.android.exoplayer2.upstream.w.a;
import com.google.android.exoplayer2.upstream.w.c;
import com.google.android.exoplayer2.upstream.x;
import com.google.android.exoplayer2.util.g;
import com.google.android.exoplayer2.util.p0;
import com.google.android.exoplayer2.w0;
import com.google.common.collect.a0;
import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: classes2.dex */
public final class d implements com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker, Loader.b<x<com.google.android.exoplayer2.source.hls.playlist.h>> {

    public static final com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker.a H;
    private Handler A;
    private com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker.c B;
    private com.google.android.exoplayer2.source.hls.playlist.f C;
    private Uri D;
    private com.google.android.exoplayer2.source.hls.playlist.g E;
    private boolean F;
    private long G;
    private final j a;
    private final com.google.android.exoplayer2.source.hls.playlist.i b;
    private final w c;
    private final HashMap<Uri, com.google.android.exoplayer2.source.hls.playlist.d.c> v;
    private final CopyOnWriteArrayList<com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker.b> w;
    private final double x;
    private z.a y;
    private Loader z;

    static class a {
    }

    private class b implements com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker.b {

        final com.google.android.exoplayer2.source.hls.playlist.d a;
        private b(com.google.android.exoplayer2.source.hls.playlist.d d) {
            this.a = d;
            super();
        }

        b(com.google.android.exoplayer2.source.hls.playlist.d d, com.google.android.exoplayer2.source.hls.playlist.d.a d$a2) {
            super(d);
        }

        @Override // com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker$b
        public void g() {
            d.y(this.a).remove(this);
        }

        @Override // com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker$b
        public boolean h(Uri uri, w.c w$c2, boolean z3) {
            w wVar;
            int i;
            int i2;
            int i3;
            int size;
            Uri uri2;
            Object obj8;
            w.c obj9;
            com.google.android.exoplayer2.source.hls.playlist.g obj10;
            final int i4 = 0;
            if (d.z(this.a) == null) {
                obj10 = d.q(this.a);
                p0.i(obj10);
                obj10 = obj10.e;
                i3 = i2;
                while (i2 < obj10.size()) {
                    size = d.A(this.a).get(obj.a);
                    if (size != null && Long.compare(elapsedRealtime, l) < 0) {
                    }
                    i2++;
                    if (Long.compare(elapsedRealtime, l) < 0) {
                    }
                    i3++;
                }
                obj10 = new w.a(1, i4, fVar.e.size(), i3);
                obj9 = d.D(this.a).b(obj10, c2);
                obj10 = d.A(this.a);
                obj8 = obj10.get(uri);
                if (obj9 != null && obj9.a == 2 && (d.c)obj8 != null) {
                    if (obj9.a == 2) {
                        obj10 = d.A(this.a);
                        obj8 = obj10.get(uri);
                        if ((d.c)(d.c)obj8 != null) {
                            d.c.a((d.c)(d.c)obj8, obj9.b);
                        }
                    }
                }
            }
            return i4;
        }
    }

    private final class c implements Loader.b<x<com.google.android.exoplayer2.source.hls.playlist.h>> {

        private boolean A;
        private IOException B;
        final com.google.android.exoplayer2.source.hls.playlist.d C;
        private final Uri a;
        private final Loader b;
        private final l c;
        private com.google.android.exoplayer2.source.hls.playlist.g v;
        private long w;
        private long x;
        private long y;
        private long z;
        public c(com.google.android.exoplayer2.source.hls.playlist.d d, Uri uri2) {
            this.C = d;
            super();
            this.a = uri2;
            Loader obj3 = new Loader("DefaultHlsPlaylistTracker:MediaPlaylist");
            this.b = obj3;
            this.c = d.B(d).a(4);
        }

        static boolean a(com.google.android.exoplayer2.source.hls.playlist.d.c d$c, long l2) {
            return c.g(l2);
        }

        static void b(com.google.android.exoplayer2.source.hls.playlist.d.c d$c, com.google.android.exoplayer2.source.hls.playlist.g g2, s s3) {
            c.w(g2, s3);
        }

        static long c(com.google.android.exoplayer2.source.hls.playlist.d.c d$c) {
            return c.z;
        }

        static Uri d(com.google.android.exoplayer2.source.hls.playlist.d.c d$c) {
            return c.a;
        }

        static void e(com.google.android.exoplayer2.source.hls.playlist.d.c d$c, Uri uri2) {
            c.q(uri2);
        }

        static com.google.android.exoplayer2.source.hls.playlist.g f(com.google.android.exoplayer2.source.hls.playlist.d.c d$c) {
            return c.v;
        }

        private boolean g(long l) {
            boolean obj3;
            this.z = elapsedRealtime += l;
            if (this.a.equals(d.w(this.C)) && !d.x(this.C)) {
                obj3 = !d.x(this.C) ? 1 : 0;
            } else {
            }
            return obj3;
        }

        private Uri i() {
            com.google.android.exoplayer2.source.hls.playlist.g.f gVar;
            Object valueOf;
            String str;
            List list;
            int cmp3;
            boolean cmp2;
            int cmp;
            int size;
            long l;
            long empty;
            gVar = this.v;
            if (gVar != null) {
                gVar = gVar.v;
                l = -9223372036854775807L;
                if (Long.compare(l2, l) == 0 && !gVar.e) {
                    if (!gVar.e) {
                    } else {
                        Uri.Builder upon = this.a.buildUpon();
                        valueOf = this.v;
                        upon.appendQueryParameter("_HLS_msn", String.valueOf(l5 += l3));
                        valueOf = this.v;
                        list = valueOf.s;
                        if (fVar.e && Long.compare(empty, l) != 0 && !list.isEmpty() && obj.E) {
                            upon.appendQueryParameter("_HLS_msn", String.valueOf(l5 += l3));
                            valueOf = this.v;
                            if (Long.compare(empty, l) != 0) {
                                list = valueOf.s;
                                if (!list.isEmpty()) {
                                    if (obj.E) {
                                        size--;
                                    }
                                }
                                upon.appendQueryParameter("_HLS_part", String.valueOf(size));
                            }
                        }
                        str = gVar2.v;
                        if (Long.compare(l4, l) != 0) {
                            str = str.b ? "v2" : "YES";
                            upon.appendQueryParameter("_HLS_skip", str);
                        }
                    }
                } else {
                }
                return upon.build();
            }
            return this.a;
        }

        private void m(Uri uri) {
            this.A = false;
            p(uri);
        }

        private void p(Uri uri) {
            x xVar = new x(this.c, uri, 4, d.r(this.C).a(d.q(this.C), this.v));
            super(xVar.a, obj4, xVar.b, this.b.n(xVar, this, d.D(this.C).d(xVar.c)), obj7);
            d.C(this.C).z(sVar, xVar.c);
        }

        private void q(Uri uri) {
            boolean elapsedRealtime;
            int cmp;
            com.google.android.exoplayer2.source.hls.playlist.a aVar;
            int i;
            this.z = 0;
            if (!this.A && !this.b.i()) {
                if (!this.b.i()) {
                    if (this.b.h()) {
                    } else {
                        elapsedRealtime = SystemClock.elapsedRealtime();
                        if (Long.compare(elapsedRealtime, l) < 0) {
                            this.A = true;
                            aVar = new a(this, uri);
                            d.p(this.C).postDelayed(aVar, l2 -= elapsedRealtime);
                        } else {
                            p(uri);
                        }
                    }
                }
            }
        }

        private void w(com.google.android.exoplayer2.source.hls.playlist.g g, s s2) {
            com.google.android.exoplayer2.source.hls.playlist.g cmp;
            int i2;
            int playlistResetException;
            int i;
            w.c cVar;
            long vVar;
            long l;
            double d;
            com.google.android.exoplayer2.source.hls.playlist.d obj14;
            Object obj15;
            com.google.android.exoplayer2.source.hls.playlist.g gVar = this.v;
            long elapsedRealtime = SystemClock.elapsedRealtime();
            this.w = elapsedRealtime;
            cmp = d.t(this.C, gVar, g);
            this.v = cmp;
            final int i4 = 1;
            if (cmp != gVar) {
                this.B = 0;
                this.x = elapsedRealtime;
                d.u(this.C, this.a, cmp);
            } else {
                if (!cmp.o) {
                    obj14 = this.v;
                    if (Long.compare(i, vVar) < 0) {
                        playlistResetException = new HlsPlaylistTracker.PlaylistResetException(this.a);
                        obj14 = i4;
                    } else {
                        if (Double.compare(i, vVar) > 0) {
                            playlistResetException = new HlsPlaylistTracker.PlaylistStuckException(this.a);
                        }
                        obj14 = i2;
                    }
                    if (playlistResetException != null) {
                        this.B = playlistResetException;
                        vVar = new v(4);
                        cVar = new w.c(s2, vVar, playlistResetException, i4);
                        d.o(this.C, this.a, cVar, obj14);
                    }
                }
            }
            obj14 = 0;
            com.google.android.exoplayer2.source.hls.playlist.g gVar2 = this.v;
            if (!fVar.e) {
                if (gVar2 != gVar) {
                    obj14 = gVar2.m;
                } else {
                    obj14 /= i;
                }
            }
            this.y = elapsedRealtime += obj14;
            if (Long.compare(obj14, l2) == 0) {
                if (this.a.equals(d.w(this.C))) {
                    i2 = i4;
                }
            } else {
            }
            if (i2 != 0 && !obj14.o) {
                if (!obj14.o) {
                    q(i());
                }
            }
        }

        @Override // com.google.android.exoplayer2.upstream.Loader$b
        public void h(Loader.e loader$e, long l2, long l3, boolean z4) {
            t((x)e, l2, l3, z4);
        }

        @Override // com.google.android.exoplayer2.upstream.Loader$b
        public void j(Loader.e loader$e, long l2, long l3) {
            u((x)e, l2, l3);
        }

        @Override // com.google.android.exoplayer2.upstream.Loader$b
        public com.google.android.exoplayer2.source.hls.playlist.g k() {
            return this.v;
        }

        @Override // com.google.android.exoplayer2.upstream.Loader$b
        public boolean l() {
            int cmp;
            int i;
            int z;
            int i2;
            if (this.v == null) {
                return 0;
            }
            cmp = this.v;
            final int i4 = 1;
            cmp = cmp.d;
            if (!cmp.o && cmp != 2 && cmp != i4) {
                cmp = cmp.d;
                if (cmp != 2) {
                    if (cmp != i4) {
                        if (Long.compare(i2, elapsedRealtime) > 0) {
                            i = i4;
                        }
                    } else {
                    }
                } else {
                }
            } else {
            }
            return i;
        }

        @Override // com.google.android.exoplayer2.upstream.Loader$b
        public void n(Uri uri) {
            m(uri);
        }

        @Override // com.google.android.exoplayer2.upstream.Loader$b
        public void o() {
            q(this.a);
        }

        @Override // com.google.android.exoplayer2.upstream.Loader$b
        public void r() {
            this.b.j();
            IOException exc = this.B;
            if (exc != null) {
            } else {
            }
            throw exc;
        }

        @Override // com.google.android.exoplayer2.upstream.Loader$b
        public Loader.c s(Loader.e loader$e, long l2, long l3, IOException iOException4, int i5) {
            return v((x)e, l2, l3, iOException4, i5);
        }

        public void t(x<com.google.android.exoplayer2.source.hls.playlist.h> x, long l2, long l3, boolean z4) {
            final Object obj = this;
            Object obj2 = x;
            super(obj2.a, obj4, obj2.b, x.f(), x.d(), l2, obj9, z4, obj11, x.c(), obj13);
            d.D(obj.C).c(obj2.a);
            d.C(obj.C).q(sVar2, 4);
        }

        public void u(x<com.google.android.exoplayer2.source.hls.playlist.h> x, long l2, long l3) {
            z.a aVar;
            boolean z;
            com.google.android.exoplayer2.upstream.n nVar;
            final Object obj = this;
            final Object obj2 = x;
            Object obj3 = x.e();
            super(obj2.a, obj5, obj2.b, x.f(), x.d(), l2, obj10, obj20, obj12, x.c(), obj14);
            int i2 = 4;
            if (obj3 instanceof g) {
                obj.w((g)(h)obj3, sVar2);
                d.C(obj.C).t(sVar2, i2);
            } else {
                obj.B = ParserException.c("Loaded playlist has unexpected type.", 0);
                d.C(obj.C).x(sVar2, i2, obj.B, true);
            }
            d.D(obj.C).c(obj2.a);
        }

        public Loader.c v(x<com.google.android.exoplayer2.source.hls.playlist.h> x, long l2, long l3, IOException iOException4, int i5) {
            Object obj;
            int responseCode;
            Loader.c cVar2;
            int i;
            boolean z;
            long cVar;
            Uri uri;
            long map;
            final Object obj2 = this;
            Object obj3 = x;
            obj = obj22;
            super(obj3.a, obj5, obj3.b, x.f(), x.d(), l2, obj10, iOException4, obj12, x.c(), obj14);
            int i3 = 1;
            int i4 = 0;
            responseCode = x.f().getQueryParameter("_HLS_msn") != null ? i3 : i4;
            z = obj instanceof HlsPlaylistParser.DeltaUpdateException;
            if (responseCode == 0) {
                if (z) {
                    responseCode = Integer.MAX_VALUE;
                    if (obj instanceof HttpDataSource.InvalidResponseCodeException != null) {
                        responseCode = obj4.responseCode;
                    }
                    if (!z && responseCode != 400) {
                        if (responseCode != 400) {
                            if (responseCode == 503) {
                            } else {
                                v vVar = new v(obj3.c);
                                cVar = new w.c(sVar2, vVar, obj, obj23);
                                Uri uri3 = obj2.a;
                                if (d.o(obj2.C, uri3, cVar, i4)) {
                                    cVar = d.D(obj2.C).a(cVar);
                                    if (Long.compare(cVar, map) != 0) {
                                        cVar2 = Loader.g(i4, cVar);
                                    } else {
                                        cVar2 = Loader.f;
                                    }
                                } else {
                                    cVar2 = Loader.e;
                                }
                                i3 ^= z3;
                                z.a aVar2 = d.C(obj2.C);
                                aVar2.x(sVar2, obj3.c, obj, i);
                                if (i != 0) {
                                    d.D(obj2.C).c(obj3.a);
                                }
                            }
                        }
                    }
                } else {
                }
                return cVar2;
            } else {
            }
            obj2.y = SystemClock.elapsedRealtime();
            o();
            z.a aVar = d.C(obj2.C);
            p0.i(aVar);
            aVar.x(sVar2, obj3.c, obj, i3);
            return Loader.e;
        }

        @Override // com.google.android.exoplayer2.upstream.Loader$b
        public void x() {
            this.b.l();
        }
    }
    static {
        d.H = b.a;
    }

    public d(j j, w w2, com.google.android.exoplayer2.source.hls.playlist.i i3) {
        super(j, w2, i3, 4615063718147915776L, obj5);
    }

    public d(j j, w w2, com.google.android.exoplayer2.source.hls.playlist.i i3, double d4) {
        super();
        this.a = j;
        this.b = i3;
        this.c = w2;
        this.x = d4;
        CopyOnWriteArrayList obj1 = new CopyOnWriteArrayList();
        this.w = obj1;
        obj1 = new HashMap();
        this.v = obj1;
        this.G = -9223372036854775807L;
    }

    static HashMap A(com.google.android.exoplayer2.source.hls.playlist.d d) {
        return d.v;
    }

    static j B(com.google.android.exoplayer2.source.hls.playlist.d d) {
        return d.a;
    }

    static z.a C(com.google.android.exoplayer2.source.hls.playlist.d d) {
        return d.y;
    }

    static w D(com.google.android.exoplayer2.source.hls.playlist.d d) {
        return d.c;
    }

    private void E(List<Uri> list) {
        int i;
        Object obj;
        com.google.android.exoplayer2.source.hls.playlist.d.c cVar;
        HashMap map;
        i = 0;
        while (i < list.size()) {
            obj = list.get(i);
            cVar = new d.c(this, (Uri)obj);
            this.v.put(obj, cVar);
            i++;
        }
    }

    private static com.google.android.exoplayer2.source.hls.playlist.g.d F(com.google.android.exoplayer2.source.hls.playlist.g g, com.google.android.exoplayer2.source.hls.playlist.g g2) {
        Object obj4;
        final int obj5 = (int)i;
        obj4 = g.r;
        if (obj5 < obj4.size()) {
            obj4 = obj4.get(obj5);
        } else {
            obj4 = 0;
        }
        return obj4;
    }

    private com.google.android.exoplayer2.source.hls.playlist.g G(com.google.android.exoplayer2.source.hls.playlist.g g, com.google.android.exoplayer2.source.hls.playlist.g g2) {
        com.google.android.exoplayer2.source.hls.playlist.g obj3;
        if (!g2.f(g) && g2.o) {
            if (g2.o) {
                obj3 = g.d();
            }
            return obj3;
        }
        return g2.c(I(g, g2), obj1);
    }

    private int H(com.google.android.exoplayer2.source.hls.playlist.g g, com.google.android.exoplayer2.source.hls.playlist.g g2) {
        int i;
        if (g2.i) {
            return g2.j;
        }
        com.google.android.exoplayer2.source.hls.playlist.g gVar = this.E;
        final int i3 = 0;
        i = gVar != null ? gVar.j : i3;
        if (g == null) {
            return i;
        }
        final com.google.android.exoplayer2.source.hls.playlist.g.d dVar = d.F(g, g2);
        if (dVar != null) {
            return obj4 -= obj5;
        }
        return i;
    }

    private long I(com.google.android.exoplayer2.source.hls.playlist.g g, com.google.android.exoplayer2.source.hls.playlist.g g2) {
        long l;
        if (g2.p) {
            return g2.h;
        }
        com.google.android.exoplayer2.source.hls.playlist.g gVar = this.E;
        l = gVar != null ? gVar.h : 0;
        if (g == null) {
            return l;
        }
        final com.google.android.exoplayer2.source.hls.playlist.g.d dVar = d.F(g, g2);
        if (dVar != null) {
            return obj9 += l2;
        }
        if (Long.compare(l3, i) == 0) {
            return g.e();
        }
        return l;
    }

    private Uri J(Uri uri) {
        int valueOf;
        int str2;
        long str;
        Object obj4;
        valueOf = this.E;
        valueOf = valueOf.t.get(uri);
        obj4 = uri.buildUpon();
        obj4.appendQueryParameter("_HLS_msn", String.valueOf(valueOf.a));
        valueOf = valueOf.b;
        if (valueOf != null && fVar.e && (g.c)valueOf != null && valueOf != -1) {
            if (fVar.e) {
                valueOf = valueOf.t.get(uri);
                if ((g.c)(g.c)valueOf != null) {
                    obj4 = uri.buildUpon();
                    obj4.appendQueryParameter("_HLS_msn", String.valueOf(valueOf.a));
                    valueOf = valueOf.b;
                    if (valueOf != -1) {
                        obj4.appendQueryParameter("_HLS_part", String.valueOf(valueOf));
                    }
                    obj4 = obj4.build();
                }
            }
        }
        return obj4;
    }

    private boolean K(Uri uri) {
        int i;
        boolean equals;
        List list = fVar.e;
        final int i2 = 0;
        i = i2;
        while (i < list.size()) {
            i++;
        }
        return i2;
    }

    private boolean L() {
        int i;
        Object obj;
        int cmp;
        List list = fVar.e;
        final int i3 = 0;
        i = i3;
        while (i < list.size()) {
            obj = this.v.get(obj2.a);
            g.e((d.c)obj);
            i++;
        }
        return i3;
    }

    private void M(Uri uri) {
        boolean equals;
        com.google.android.exoplayer2.source.hls.playlist.g gVar;
        boolean z;
        Object obj4;
        if (!uri.equals(this.D) && K(uri)) {
            if (K(uri)) {
                equals = this.E;
                if (equals != null && equals.o) {
                    if (equals.o) {
                    } else {
                        this.D = uri;
                        equals = this.v.get(uri);
                        gVar = d.c.f((d.c)equals);
                        if (gVar != null && gVar.o) {
                            if (gVar.o) {
                                this.E = gVar;
                                this.B.c(gVar);
                            } else {
                                d.c.e(equals, J(uri));
                            }
                        } else {
                        }
                    }
                } else {
                }
            }
        }
    }

    private boolean N(Uri uri, w.c w$c2, boolean z3) {
        int i2;
        int i;
        Iterator iterator = this.w.iterator();
        i2 = 0;
        for (HlsPlaylistTracker.b next2 : iterator) {
            i2 |= i;
        }
        return i2;
    }

    private void R(Uri uri, com.google.android.exoplayer2.source.hls.playlist.g g2) {
        Uri uri2;
        com.google.android.exoplayer2.source.hls.playlist.g obj3;
        Object obj4;
        if (uri.equals(this.D) && this.E == null) {
            if (this.E == null) {
                this.F = obj3 ^= 1;
                this.G = g2.h;
            }
            this.E = g2;
            this.B.c(g2);
        }
        obj3 = this.w.iterator();
        for (HlsPlaylistTracker.b obj4 : obj3) {
            obj4.g();
        }
    }

    static boolean o(com.google.android.exoplayer2.source.hls.playlist.d d, Uri uri2, w.c w$c3, boolean z4) {
        return d.N(uri2, c3, z4);
    }

    static Handler p(com.google.android.exoplayer2.source.hls.playlist.d d) {
        return d.A;
    }

    static com.google.android.exoplayer2.source.hls.playlist.f q(com.google.android.exoplayer2.source.hls.playlist.d d) {
        return d.C;
    }

    static com.google.android.exoplayer2.source.hls.playlist.i r(com.google.android.exoplayer2.source.hls.playlist.d d) {
        return d.b;
    }

    static com.google.android.exoplayer2.source.hls.playlist.g t(com.google.android.exoplayer2.source.hls.playlist.d d, com.google.android.exoplayer2.source.hls.playlist.g g2, com.google.android.exoplayer2.source.hls.playlist.g g3) {
        return d.G(g2, g3);
    }

    static void u(com.google.android.exoplayer2.source.hls.playlist.d d, Uri uri2, com.google.android.exoplayer2.source.hls.playlist.g g3) {
        d.R(uri2, g3);
    }

    static double v(com.google.android.exoplayer2.source.hls.playlist.d d) {
        return d.x;
    }

    static Uri w(com.google.android.exoplayer2.source.hls.playlist.d d) {
        return d.D;
    }

    static boolean x(com.google.android.exoplayer2.source.hls.playlist.d d) {
        return d.L();
    }

    static CopyOnWriteArrayList y(com.google.android.exoplayer2.source.hls.playlist.d d) {
        return d.w;
    }

    static com.google.android.exoplayer2.source.hls.playlist.g z(com.google.android.exoplayer2.source.hls.playlist.d d) {
        return d.E;
    }

    public void O(x<com.google.android.exoplayer2.source.hls.playlist.h> x, long l2, long l3, boolean z4) {
        final Object obj = this;
        Object obj2 = x;
        super(obj2.a, obj4, obj2.b, x.f(), x.d(), l2, obj9, z4, obj11, x.c(), obj13);
        obj.c.c(obj2.a);
        obj.y.q(sVar2, 4);
    }

    public void P(x<com.google.android.exoplayer2.source.hls.playlist.h> x, long l2, long l3) {
        Object obj;
        final Object obj2 = this;
        Object obj3 = x;
        Object obj4 = x.e();
        final boolean z = obj4 instanceof g;
        if (z) {
            obj = f.e(obj4.a);
        } else {
            obj = obj4;
        }
        obj2.C = obj;
        obj2.D = obj5.a;
        final int i3 = 0;
        d.b bVar = new d.b(obj2, i3);
        obj2.w.add(bVar);
        obj2.E(obj.d);
        super(obj3.a, i3, obj3.b, x.f(), x.d(), l2, obj12, obj21, obj14, x.c(), obj16);
        Uri uri2 = obj2.D;
        Object obj6 = obj2.v.get(uri2);
        if (z) {
            d.c.b((d.c)obj6, (g)(h)obj4, sVar);
        } else {
            obj6.o();
        }
        obj2.c.c(obj3.a);
        obj2.y.t(sVar, 4);
    }

    public Loader.c Q(x<com.google.android.exoplayer2.source.hls.playlist.h> x, long l2, long l3, IOException iOException4, int i5) {
        Loader.c cVar;
        Object exc;
        int i;
        z.a aVar;
        final Object obj = this;
        Object obj2 = x;
        exc = obj22;
        super(obj2.a, obj5, obj2.b, x.f(), x.d(), l2, obj10, iOException4, obj12, x.c(), obj14);
        v vVar = new v(obj2.c);
        w wVar = obj.c;
        w.c cVar2 = new w.c(sVar2, vVar, exc, obj23);
        long l = wVar.a(cVar2);
        int i4 = 0;
        i = Long.compare(l, l5) == 0 ? 1 : i4;
        int i6 = obj2.c;
        obj.y.x(sVar2, i6, exc, i);
        if (i != 0) {
            obj.c.c(obj2.a);
        }
        if (i != 0) {
            cVar = Loader.f;
        } else {
            cVar = Loader.g(i4, l);
        }
        return cVar;
    }

    @Override // com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker
    public boolean a(Uri uri) {
        return (d.c)this.v.get(uri).l();
    }

    @Override // com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker
    public void b(com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker.b hlsPlaylistTracker$b) {
        this.w.remove(b);
    }

    @Override // com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker
    public void c(Uri uri) {
        (d.c)this.v.get(uri).r();
    }

    @Override // com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker
    public long d() {
        return this.G;
    }

    @Override // com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker
    public boolean e() {
        return this.F;
    }

    @Override // com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker
    public boolean f(Uri uri, long l2) {
        Object obj2 = this.v.get(uri);
        if ((d.c)obj2 != null) {
            return obj2 ^= 1;
        }
        return 0;
    }

    @Override // com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker
    public com.google.android.exoplayer2.source.hls.playlist.f g() {
        return this.C;
    }

    @Override // com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker
    public void h(Loader.e loader$e, long l2, long l3, boolean z4) {
        O((x)e, l2, l3, z4);
    }

    @Override // com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker
    public void i(Uri uri, z.a z$a2, com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker.c hlsPlaylistTracker$c3) {
        int obj8;
        this.A = p0.u();
        this.y = a2;
        this.B = c3;
        int i2 = 4;
        x obj10 = new x(this.a.a(i2), uri, i2, this.b.b());
        obj8 = this.z == null ? 1 : 0;
        g.f(obj8);
        obj8 = new Loader("DefaultHlsPlaylistTracker:MasterPlaylist");
        this.z = obj8;
        super(obj10.a, obj3, obj10.b, obj8.n(obj10, this, this.c.d(obj10.c)), obj6);
        a2.z(obj8, obj10.c);
    }

    @Override // com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker
    public void j(Loader.e loader$e, long l2, long l3) {
        P((x)e, l2, l3);
    }

    @Override // com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker
    public void k() {
        Loader loader = this.z;
        if (loader != null) {
            loader.j();
        }
        Uri uri = this.D;
        if (uri != null) {
            c(uri);
        }
    }

    @Override // com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker
    public void l(Uri uri) {
        (d.c)this.v.get(uri).o();
    }

    @Override // com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker
    public void m(com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker.b hlsPlaylistTracker$b) {
        g.e(b);
        this.w.add(b);
    }

    @Override // com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker
    public com.google.android.exoplayer2.source.hls.playlist.g n(Uri uri, boolean z2) {
        com.google.android.exoplayer2.source.hls.playlist.g gVar = (d.c)this.v.get(uri).k();
        if (gVar != null && z2) {
            if (z2) {
                M(uri);
            }
        }
        return gVar;
    }

    @Override // com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker
    public Loader.c s(Loader.e loader$e, long l2, long l3, IOException iOException4, int i5) {
        return Q((x)e, l2, l3, iOException4, i5);
    }

    @Override // com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker
    public void stop() {
        Object next;
        int i = 0;
        this.D = i;
        this.E = i;
        this.C = i;
        this.G = -9223372036854775807L;
        this.z.l();
        this.z = i;
        Iterator iterator = this.v.values().iterator();
        for (d.c next : iterator) {
            next.x();
        }
        this.A.removeCallbacksAndMessages(i);
        this.A = i;
        this.v.clear();
    }
}
