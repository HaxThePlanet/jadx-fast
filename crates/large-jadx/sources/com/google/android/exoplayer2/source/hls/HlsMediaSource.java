package com.google.android.exoplayer2.source.hls;

import com.google.android.exoplayer2.drm.s;
import com.google.android.exoplayer2.drm.v;
import com.google.android.exoplayer2.drm.w;
import com.google.android.exoplayer2.h1;
import com.google.android.exoplayer2.m1;
import com.google.android.exoplayer2.m1.c;
import com.google.android.exoplayer2.m1.f;
import com.google.android.exoplayer2.m1.g;
import com.google.android.exoplayer2.offline.c;
import com.google.android.exoplayer2.source.a0;
import com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker;
import com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker.a;
import com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker.c;
import com.google.android.exoplayer2.source.hls.playlist.c;
import com.google.android.exoplayer2.source.hls.playlist.d;
import com.google.android.exoplayer2.source.hls.playlist.e;
import com.google.android.exoplayer2.source.hls.playlist.g;
import com.google.android.exoplayer2.source.hls.playlist.g.b;
import com.google.android.exoplayer2.source.hls.playlist.g.d;
import com.google.android.exoplayer2.source.hls.playlist.i;
import com.google.android.exoplayer2.source.i0;
import com.google.android.exoplayer2.source.j;
import com.google.android.exoplayer2.source.n;
import com.google.android.exoplayer2.source.o;
import com.google.android.exoplayer2.source.w;
import com.google.android.exoplayer2.source.y.a;
import com.google.android.exoplayer2.upstream.b0;
import com.google.android.exoplayer2.upstream.f;
import com.google.android.exoplayer2.upstream.l.a;
import com.google.android.exoplayer2.upstream.t;
import com.google.android.exoplayer2.upstream.w;
import com.google.android.exoplayer2.util.g;
import com.google.android.exoplayer2.util.p0;
import com.google.android.exoplayer2.w0;
import java.util.Collections;
import java.util.List;

/* loaded from: classes2.dex */
public final class HlsMediaSource extends j implements HlsPlaylistTracker.c {

    private final com.google.android.exoplayer2.source.hls.k g;
    private final m1.g h;
    private final com.google.android.exoplayer2.source.hls.j i;
    private final n j;
    private final v k;
    private final w l;
    private final boolean m;
    private final int n;
    private final boolean o;
    private final HlsPlaylistTracker p;
    private final long q;
    private final m1 r;
    private m1.f s;
    private b0 t;

    static class a {
    }

    public static final class Factory implements a0 {

        private final com.google.android.exoplayer2.source.hls.j a;
        private com.google.android.exoplayer2.source.hls.k b;
        private i c;
        private HlsPlaylistTracker.a d;
        private n e;
        private w f;
        private w g;
        private boolean h;
        private int i;
        private boolean j;
        private List<c> k;
        private Object l;
        private long m;
        public Factory(com.google.android.exoplayer2.source.hls.j j) {
            super();
            g.e(j);
            this.a = (j)j;
            s obj3 = new s();
            this.f = obj3;
            obj3 = new c();
            this.c = obj3;
            this.d = d.H;
            this.b = k.a;
            obj3 = new t();
            this.g = obj3;
            obj3 = new o();
            this.e = obj3;
            this.i = 1;
            this.k = Collections.emptyList();
            this.m = -9223372036854775807L;
        }

        public Factory(l.a l$a) {
            f fVar = new f(a);
            super(fVar);
        }

        @Override // com.google.android.exoplayer2.source.a0
        public com.google.android.exoplayer2.source.hls.HlsMediaSource a(m1 m1) {
            Object obj;
            i iVar;
            List list;
            boolean eVar;
            boolean empty;
            int i2;
            Object obj2;
            int i;
            final Object obj3 = this;
            obj = m1;
            g.e(obj.b);
            list = gVar2.e.isEmpty() ? obj3.k : gVar3.e;
            if (!list.isEmpty()) {
                eVar = new e(obj3.c, list);
                iVar = eVar;
            }
            m1.g gVar4 = obj.b;
            int i3 = 0;
            if (gVar4.h == null && obj3.l != null) {
                i2 = obj3.l != null ? i : i3;
            } else {
            }
            if (gVar4.e.isEmpty() && !list.isEmpty()) {
                if (!list.isEmpty()) {
                } else {
                    i = i3;
                }
            } else {
            }
            if (i2 != 0 && i != 0) {
                if (i != 0) {
                    m1.c cVar = m1.a();
                    cVar.e(obj3.l);
                    cVar.d(list);
                    obj = cVar.a();
                } else {
                    if (i2 != 0) {
                        m1.c cVar2 = m1.a();
                        cVar2.e(obj3.l);
                        obj = cVar2.a();
                    } else {
                        if (i != 0) {
                            m1.c cVar3 = m1.a();
                            cVar3.d(list);
                            obj = cVar3.a();
                        }
                    }
                }
            } else {
            }
            m1 m1Var = obj;
            final w wVar2 = obj3.g;
            super(m1Var, obj3.a, obj3.b, obj3.e, obj3.f.a(m1Var), wVar2, obj3.d.a(obj3.a, wVar2, iVar), obj3.m, obj12, obj3.h, obj3.i, obj3.j, 0);
            return hlsMediaSource;
        }
    }
    static {
        h1.a("goog.exo.hls");
    }

    private HlsMediaSource(m1 m1, com.google.android.exoplayer2.source.hls.j j2, com.google.android.exoplayer2.source.hls.k k3, n n4, v v5, w w6, HlsPlaylistTracker hlsPlaylistTracker7, long l8, boolean z9, int i10, boolean z11) {
        super();
        final m1.g gVar = m1.b;
        g.e(gVar);
        this.h = (m1.g)gVar;
        this.r = m1;
        this.s = m1.c;
        this.i = j2;
        this.g = k3;
        this.j = n4;
        this.k = v5;
        this.l = w6;
        this.p = hlsPlaylistTracker7;
        this.q = l8;
        this.m = i10;
        this.n = z11;
        this.o = obj13;
    }

    HlsMediaSource(m1 m1, com.google.android.exoplayer2.source.hls.j j2, com.google.android.exoplayer2.source.hls.k k3, n n4, v v5, w w6, HlsPlaylistTracker hlsPlaylistTracker7, long l8, boolean z9, int i10, boolean z11, com.google.android.exoplayer2.source.hls.HlsMediaSource.a hlsMediaSource$a12) {
        super(m1, j2, k3, n4, v5, w6, hlsPlaylistTracker7, l8, z9, i10, z11, a12);
    }

    private i0 A(g g, long l2, long l3, com.google.android.exoplayer2.source.hls.l l4) {
        long l;
        boolean z;
        int empty;
        long cmp;
        Object obj = g;
        if (Long.compare(l5, cmp) != 0) {
            if (obj.r.isEmpty()) {
                l = 0;
            } else {
                if (!obj.g) {
                    z = obj.e;
                    if (Long.compare(z, l6) == 0) {
                        l = obj.e;
                    } else {
                        l = dVar.w;
                    }
                } else {
                }
            }
        } else {
        }
        final long l10 = obj.u;
        super(l2, obj5, l4, obj7, -9223372036854775807L, obj9, l10, obj11, l10, obj13, 0, obj15, l, obj17, 1, 0, 1, obj30, obj2.r, 0);
        return i0Var;
    }

    private static g.b B(List<g.b> list, long l2) {
        int i2;
        int i;
        Object size;
        long l;
        boolean cmp;
        i2 = 0;
        i = 0;
        while (i < list.size()) {
            size = list.get(i);
            l = size.w;
            if (Long.compare(l, l2) > 0) {
                break;
            } else {
            }
            i++;
            i2 = size;
        }
        return i2;
    }

    private static g.d C(List<g.d> list, long l2) {
        final int obj2 = 1;
        return (g.d)list.get(p0.f(list, Long.valueOf(l2), obj2, obj2));
    }

    private long D(g g) {
        int i;
        long l;
        if (g.p) {
            l4 -= l;
        } else {
            i = 0;
        }
        return i;
    }

    private long E(g g, long l2) {
        int l;
        long obj6;
        if (Long.compare(l, l4) != 0) {
        } else {
            i -= obj6;
        }
        if (g.g) {
            return l;
        }
        obj6 = HlsMediaSource.B(g.s, l);
        if (obj6 != null) {
            return obj6.w;
        }
        if (g.r.isEmpty()) {
            return 0;
        }
        g.d obj5 = HlsMediaSource.C(g.r, l);
        obj6 = HlsMediaSource.B(obj5.E, l);
        if (obj6 != null) {
            return obj6.w;
        }
        return obj5.w;
    }

    private static long F(g g, long l2) {
        com.google.android.exoplayer2.source.hls.playlist.g.f fVar;
        long l3;
        long cmp;
        long l;
        int cmp2;
        fVar = g.v;
        l3 = g.e;
        long l4 = -9223372036854775807L;
        if (Long.compare(l3, l4) != 0) {
            l5 -= l3;
        } else {
            l3 = fVar.d;
            if (Long.compare(l3, l4) != 0 && Long.compare(l6, l4) != 0) {
                if (Long.compare(l6, l4) != 0) {
                    l = l3;
                } else {
                    fVar = fVar.c;
                    if (Long.compare(fVar, l4) != 0) {
                        l = fVar;
                    } else {
                        l = cmp * fVar;
                    }
                }
            } else {
            }
        }
        return l += l2;
    }

    private void G(long l) {
        int cmp;
        long obj3;
        obj3 = w0.e(l);
        if (Long.compare(obj3, l2) != 0) {
            cmp = this.r.a();
            cmp.b(obj3);
            this.s = obj3.c;
        }
    }

    private i0 z(g g, long l2, long l3, com.google.android.exoplayer2.source.hls.l l4) {
        long l;
        boolean i;
        int i2;
        long l5;
        int i3;
        final Object obj = this;
        Object obj2 = g;
        final int i7 = l6 - l11;
        long l9 = -9223372036854775807L;
        if (obj2.o) {
            l5 = i2;
        } else {
            l5 = l9;
        }
        long l19 = D(g);
        long l12 = fVar2.a;
        if (Long.compare(l12, l9) != 0) {
            l = w0.d(l12);
        } else {
            l = HlsMediaSource.F(obj2, l19);
        }
        obj.G(p0.q(l, obj6, l19));
        if (obj2.d == 2 && obj2.f) {
            i3 = obj2.f ? i5 : i;
        } else {
        }
        super(l2, obj8, l4, obj10, -9223372036854775807L, obj12, l5, obj14, obj2.u, obj16, i7, obj18, obj.E(obj2, l19), obj20, 1, z ^ 1, i3, obj33, obj.r, obj.s);
        return i0Var;
    }

    @Override // com.google.android.exoplayer2.source.j
    public w a(y.a y$a, f f2, long l3) {
        final Object obj = this;
        super(obj.g, obj.p, obj.i, obj.t, obj.k, q(a), obj.l, s(a), f2, obj.j, obj.m, obj.n, obj.o);
        return oVar2;
    }

    @Override // com.google.android.exoplayer2.source.j
    public void c(g g) {
        long l3;
        int i;
        Object obj;
        Object obj2;
        long l;
        long l2;
        i0 obj13;
        final long l4 = -9223372036854775807L;
        if (g.p) {
            l2 = l3;
        } else {
            l2 = l4;
        }
        int i2 = g.d;
        if (i2 != 2) {
            if (i2 == 1) {
                l = l2;
            } else {
                l = l4;
            }
        } else {
        }
        com.google.android.exoplayer2.source.hls.playlist.f fVar = this.p.g();
        g.e(fVar);
        l lVar = new l((f)fVar, g);
        if (this.p.e()) {
            obj13 = this.z(g, l, obj8, l2);
        } else {
            obj13 = this.A(g, l, obj8, l2);
        }
        x(obj13);
    }

    @Override // com.google.android.exoplayer2.source.j
    public m1 g() {
        return this.r;
    }

    @Override // com.google.android.exoplayer2.source.j
    public void j() {
        this.p.k();
    }

    @Override // com.google.android.exoplayer2.source.j
    public void l(w w) {
        (o)w.B();
    }

    @Override // com.google.android.exoplayer2.source.j
    protected void w(b0 b0) {
        this.t = b0;
        this.k.f();
        this.p.i(gVar.a, s(0), this);
    }

    @Override // com.google.android.exoplayer2.source.j
    protected void y() {
        this.p.stop();
        this.k.a();
    }
}
