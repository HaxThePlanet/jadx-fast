package com.google.android.exoplayer2.source.hls;

import android.net.Uri;
import android.os.SystemClock;
import android.util.Pair;
import com.google.android.exoplayer2.i1;
import com.google.android.exoplayer2.n2.e;
import com.google.android.exoplayer2.n2.g;
import com.google.android.exoplayer2.n2.j;
import com.google.android.exoplayer2.source.BehindLiveWindowException;
import com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker;
import com.google.android.exoplayer2.source.hls.playlist.g;
import com.google.android.exoplayer2.source.hls.playlist.g.e;
import com.google.android.exoplayer2.source.k0;
import com.google.android.exoplayer2.source.m0.a;
import com.google.android.exoplayer2.source.m0.b;
import com.google.android.exoplayer2.source.m0.c;
import com.google.android.exoplayer2.source.m0.d;
import com.google.android.exoplayer2.source.m0.e;
import com.google.android.exoplayer2.upstream.b0;
import com.google.android.exoplayer2.upstream.l;
import com.google.android.exoplayer2.upstream.n;
import com.google.android.exoplayer2.upstream.n.b;
import com.google.android.exoplayer2.util.g;
import com.google.android.exoplayer2.util.o0;
import com.google.android.exoplayer2.util.p0;
import com.google.common.collect.a0;
import com.google.common.collect.v;
import f.c.c.b.b;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* loaded from: classes2.dex */
class i {

    private final com.google.android.exoplayer2.source.hls.k a;
    private final l b;
    private final l c;
    private final com.google.android.exoplayer2.source.hls.s d;
    private final Uri[] e;
    private final i1[] f;
    private final HlsPlaylistTracker g;
    private final k0 h;
    private final List<i1> i;
    private final com.google.android.exoplayer2.source.hls.h j;
    private boolean k;
    private byte[] l;
    private IOException m;
    private Uri n;
    private boolean o;
    private g p;
    private long q = -9223372036854775807L;
    private boolean r;

    public static final class b {

        public b a;
        public boolean b;
        public Uri c;
        public b() {
            super();
            a();
        }

        public void a() {
            final int i = 0;
            this.a = i;
            this.b = false;
            this.c = i;
        }
    }

    static final class e {

        public final g.e a;
        public final long b;
        public final int c;
        public final boolean d = false;
        public e(g.e g$e, long l2, int i3) {
            g.e obj1;
            super();
            this.a = e;
            this.b = l2;
            this.c = obj4;
            if (e instanceof g.b && e.E) {
                obj1 = e.E ? 1 : obj1;
            }
            obj1 = 0;
        }
    }

    static final class c extends a {

        private final List<g.e> e;
        private final long f;
        public c(String string, long l2, List<g.e> list3) {
            super(0, obj3, (long)obj5, obj1);
            this.f = l2;
            this.e = obj8;
        }

        @Override // com.google.android.exoplayer2.source.m0.a
        public long a() {
            c();
            return l += l2;
        }

        @Override // com.google.android.exoplayer2.source.m0.a
        public long b() {
            c();
            Object obj = this.e.get((int)l);
            return i2 += l4;
        }
    }

    private static final class a extends c {

        private byte[] l;
        public a(l l, n n2, i1 i13, int i4, Object object5, byte[] b6Arr6) {
            super(l, n2, 3, i13, i4, object5, b6Arr6);
        }

        @Override // com.google.android.exoplayer2.source.m0.c
        protected void g(byte[] bArr, int i2) {
            this.l = Arrays.copyOf(bArr, i2);
        }

        @Override // com.google.android.exoplayer2.source.m0.c
        public byte[] j() {
            return this.l;
        }
    }

    private static final class d extends e {

        private int g;
        public d(k0 k0, int[] i2Arr2) {
            super(k0, i2Arr2);
            this.g = u(k0.a(i2Arr2[0]));
        }

        @Override // com.google.android.exoplayer2.n2.e
        public int b() {
            return this.g;
        }

        public void l(long l, long l2, long l3, List<? extends d> list4, e[] e5Arr5) {
            int obj3;
            boolean obj4;
            long obj1 = SystemClock.elapsedRealtime();
            if (!d(this.g, obj1)) {
            }
            obj3--;
            while (obj3 >= 0) {
                obj3--;
            }
            obj1 = new IllegalStateException();
            throw obj1;
        }

        @Override // com.google.android.exoplayer2.n2.e
        public int o() {
            return 0;
        }

        @Override // com.google.android.exoplayer2.n2.e
        public Object q() {
            return null;
        }
    }
    public i(com.google.android.exoplayer2.source.hls.k k, HlsPlaylistTracker hlsPlaylistTracker2, Uri[] uri3Arr3, i1[] i14Arr4, com.google.android.exoplayer2.source.hls.j j5, b0 b06, com.google.android.exoplayer2.source.hls.s s7, List<i1> list8) {
        int obj2;
        int obj5;
        super();
        this.a = k;
        this.g = hlsPlaylistTracker2;
        this.e = uri3Arr3;
        this.f = i14Arr4;
        this.d = s7;
        this.i = list8;
        h obj1 = new h(4);
        this.j = obj1;
        this.l = p0.f;
        obj1 = -9223372036854775807L;
        obj1 = j5.a(1);
        this.b = obj1;
        if (b06 != null) {
            obj1.d(b06);
        }
        this.c = j5.a(3);
        obj1 = new k0(i14Arr4);
        this.h = obj1;
        obj1 = new ArrayList();
        obj2 = 0;
        while (obj2 < uri3Arr3.length) {
            if (obj5 &= 16384 == 0) {
            }
            obj2++;
            obj1.add(Integer.valueOf(obj2));
        }
        obj2 = new i.d(this.h, b.k(obj1));
        this.p = obj2;
    }

    private static Uri c(g g, g.e g$e2) {
        Object obj1;
        obj1 = e2.y;
        if (e2 != null && obj1 == null) {
            obj1 = e2.y;
            if (obj1 == null) {
            }
            return o0.d(g.a, obj1);
        }
        return null;
    }

    private Pair<Long, Integer> e(com.google.android.exoplayer2.source.hls.m m, boolean z2, g g3, long l4, long l5) {
        int cmp;
        int i2;
        int i;
        long l2;
        long l;
        Integer obj8;
        Pair obj9;
        Long obj10;
        int obj11;
        long obj13;
        cmp = 1;
        i2 = -1;
        if (m != null) {
            if (z2) {
            } else {
                if (m.p()) {
                    if (m.o == i2) {
                        obj10 = m.g();
                    } else {
                        obj10 = m.j;
                    }
                    obj8 = m.o;
                    if (obj8 == i2) {
                    } else {
                        i2 = obj8 + 1;
                    }
                    obj9 = new Pair(Long.valueOf(obj10), Integer.valueOf(i2));
                } else {
                    obj9 = new Pair(Long.valueOf(m.j), Integer.valueOf(m.o));
                }
            }
            return obj9;
        }
        if (m != null) {
            if (this.o) {
            } else {
                obj13 = m.g;
            }
        }
        if (!g3.o && Long.compare(obj13, i3) >= 0) {
            if (Long.compare(obj13, i3) >= 0) {
                obj8 = new Pair(Long.valueOf(obj11 += obj9), Integer.valueOf(i2));
                return obj8;
            }
        }
        obj13 -= l4;
        boolean obj12 = this.g.e();
        if (obj12 != null) {
            if (m == null) {
                obj8 = cmp;
            } else {
                obj8 = i;
            }
        } else {
        }
        obj8 = p0.f(g3.r, Long.valueOf(obj13), cmp, obj8);
        if (obj8 >= 0) {
            obj8 = g3.r.get(obj8);
            obj8 = Long.compare(obj13, l2) < 0 ? obj8.E : g3.s;
            while (i < obj8.size()) {
                obj9 = obj8.get(i);
                if (Long.compare(obj13, l2) < 0) {
                    break;
                } else {
                }
                i++;
            }
        }
        obj8 = new Pair(Long.valueOf(obj11), Integer.valueOf(i2));
        return obj8;
    }

    private static com.google.android.exoplayer2.source.hls.i.e f(g g, long l2, int i3) {
        int eVar;
        Object obj7;
        int obj10;
        int i2 = (int)i;
        final int i5 = 0;
        final int i6 = -1;
        if (i2 == g.r.size()) {
            if (obj10 != i6) {
            } else {
                obj10 = i5;
            }
            if (obj10 < g.s.size()) {
                eVar = new i.e((g.e)g.s.get(obj10), l2, i3, obj10);
            }
            return eVar;
        }
        Object obj2 = g.r.get(i2);
        if (obj10 == i6) {
            obj7 = new i.e((g.d)obj2, l2, i3, i6);
            return obj7;
        }
        if (obj10 < obj2.E.size()) {
            obj7 = new i.e((g.e)obj2.E.get(obj10), l2, i3, obj10);
            return obj7;
        }
        i2++;
        int i7 = 1;
        if (i4 < g.r.size()) {
            obj10 = new i.e((g.e)g.r.get(i4), l2 += i7, i3, i6);
            return obj10;
        }
        if (!g.s.isEmpty()) {
            obj10 = new i.e((g.e)g.s.get(i5), l2 += i7, i3, i5);
            return obj10;
        }
        return null;
    }

    static List<g.e> h(g g, long l2, int i3) {
        int size2;
        int i;
        int size;
        Object obj7;
        int obj8;
        int obj9;
        int obj10;
        obj8 = (int)obj8;
        if (obj8 >= 0) {
            if (g.r.size() < obj8) {
            } else {
                obj9 = new ArrayList();
                final int i2 = -1;
                if (obj8 < g.r.size() && obj10 != i2) {
                    if (obj10 != i2) {
                        size2 = g.r.get(obj8);
                        if (obj10 == null) {
                            obj9.add((g.d)size2);
                        } else {
                            if (obj10 < size2.E.size()) {
                                size2 = size2.E;
                                obj9.addAll(size2.subList(obj10, size2.size()));
                            }
                        }
                        obj8++;
                    }
                    obj10 = g.r;
                    obj9.addAll(obj10.subList(obj8, obj10.size()));
                    obj10 = i;
                }
                if (Long.compare(l3, l4) != 0) {
                    if (obj10 == i2) {
                    } else {
                        i = obj10;
                    }
                    if (i < g.s.size()) {
                        obj7 = g.s;
                        obj9.addAll(obj7.subList(i, obj7.size()));
                    }
                }
            }
            return Collections.unmodifiableList(obj9);
        }
        return v.z();
    }

    private b k(Uri uri, int i2) {
        int i = 0;
        if (uri == null) {
            return i;
        }
        byte[] bArr = this.j.c(uri);
        if (bArr != null) {
            this.j.b(uri, bArr);
            return i;
        }
        n.b bVar = new n.b();
        bVar.i(uri);
        bVar.b(1);
        super(this.c, bVar.a(), this.f[i2], this.p.o(), this.p.q(), this.l);
        return obj9;
    }

    private long r(long l) {
        long l2;
        int i;
        final long l3 = this.q;
        i = Long.compare(l3, l2) != 0 ? 1 : 0;
        if (i != 0) {
            l2 = l3 - l;
        }
        return l2;
    }

    private void v(g g) {
        long l2;
        long l;
        Object obj5;
        if (g.o) {
            l2 = -9223372036854775807L;
        } else {
            l3 -= l;
        }
        this.q = l2;
    }

    public e[] a(com.google.android.exoplayer2.source.hls.m m, long l2) {
        int i6;
        g gVar2;
        int i2;
        i1 longValue;
        int i;
        com.google.android.exoplayer2.source.hls.i.c cVar;
        String str;
        Object obj2;
        int i3;
        int i5;
        g gVar;
        int i4;
        final Object obj3 = this;
        final Object obj4 = m;
        if (obj4 == null) {
            i6 = -1;
        } else {
            i6 = obj3.h.b(obj4.d);
        }
        final int length = obj3.p.length();
        final e[] arr = new e[length];
        i5 = i3;
        while (i5 < length) {
            i2 = obj3.p.j(i5);
            longValue = obj3.e[i2];
            if (!obj3.g.a(longValue)) {
            } else {
            }
            gVar = obj3.g.n(longValue, i3);
            g.e(gVar);
            int i8 = l - l3;
            if (i2 != i6) {
            } else {
            }
            i = i3;
            Pair pair = this.e(m, i, gVar, i8, obj5);
            cVar = new i.c(gVar.a, i8, i5, i.h(gVar, (Long)pair.first.longValue(), i));
            arr[i5] = cVar;
            i5 = i4 + 1;
            i3 = 0;
            i = i2;
            arr[i5] = e.a;
            i4 = i5;
        }
        return arr;
    }

    public int b(com.google.android.exoplayer2.source.hls.m m) {
        int i;
        List list;
        int size;
        i = 1;
        if (m.o == -1) {
            return i;
        }
        int i6 = 0;
        g gVar = this.g.n(this.e[this.h.b(m.d)], i6);
        g.e(gVar);
        int i5 = (int)i7;
        if (i5 < 0) {
            return i;
        }
        if (i5 < gVar.r.size()) {
            list = obj2.E;
        } else {
            list = gVar.s;
        }
        int i10 = 2;
        if (m.o >= list.size()) {
            return i10;
        }
        Object obj = list.get(m.o);
        if (obj.E) {
            return i6;
        }
        if (p0.b(Uri.parse(o0.c(gVar.a, obj.a)), obj9.a)) {
        } else {
            i = i10;
        }
        return i;
    }

    public void d(long l, long l2, List<com.google.android.exoplayer2.source.hls.m> list3, boolean z4, com.google.android.exoplayer2.source.hls.i.b i$b5) {
        Object empty2;
        int i9;
        int intValue;
        com.google.android.exoplayer2.source.hls.i.e eVar;
        boolean empty;
        i1 i1Var;
        long longValue;
        long l3;
        int size;
        int i3;
        boolean z;
        g gVar;
        Uri uri;
        int i8;
        int i7;
        int cmp;
        b bVar;
        g i;
        int i4;
        int i2;
        Object obj;
        int cmp2;
        int i5;
        int i6;
        Uri uri2;
        Object uri3;
        final Object obj6 = this;
        i4 = list3;
        final Object obj7 = obj37;
        if (b5.isEmpty()) {
            obj = 0;
        } else {
            obj = empty2;
        }
        int i22 = -1;
        if (obj == null) {
            i2 = i22;
        } else {
            i2 = empty2;
        }
        l3 = r(l);
        z = obj.d();
        i8 = 0;
        i9 = Math.max(i8, obj7);
        if (obj != null && !obj6.o && Long.compare(l3, l11) != 0) {
            if (!obj6.o) {
                z = obj.d();
                i8 = 0;
                i9 = Math.max(i8, obj7);
                if (Long.compare(l3, l11) != 0) {
                    l3 = Math.max(i8, obj7);
                }
            }
        }
        obj6.p.l(l, obj18, i9, obj20, l3);
        int i19 = obj6.p.m();
        i = 0;
        int i16 = 1;
        i5 = i2 != i19 ? i16 : i;
        Uri uri8 = obj6.e[i19];
        if (!obj6.g.a(uri8)) {
            obj7.c = uri8;
            obj6.r = z6 &= equals2;
            obj6.n = uri8;
        }
        g gVar4 = obj6.g.n(uri8, i16);
        g.e(gVar4);
        obj6.o = gVar4.c;
        obj6.v(gVar4);
        int i24 = l4 - l12;
        g obj31 = gVar4;
        int i21 = i16;
        Pair pair = this.e(obj, i5, gVar4, i24, uri8);
        intValue = (Integer)pair.second.intValue();
        if (Long.compare(longValue, l7) < 0 && obj != null && i5 != 0) {
            if (obj != null) {
                if (i5 != 0) {
                    Uri uri9 = obj6.e[i2];
                    i = obj6.g.n(uri9, i21);
                    g.e(i);
                    Pair pair2 = this.e(obj, false, i, l5 - l6, uri8);
                    longValue = (Long)pair2.first.longValue();
                    intValue = (Integer)pair2.second.intValue();
                    i3 = i2;
                    uri = uri2;
                    gVar = uri3;
                } else {
                    gVar = gVar4;
                    i6 = i24;
                    uri = uri3;
                    i3 = i26;
                }
            } else {
            }
        } else {
        }
        if (Long.compare(longValue, l8) < 0) {
            BehindLiveWindowException behindLiveWindowException = new BehindLiveWindowException();
            obj6.m = behindLiveWindowException;
        }
        if (i.f(gVar, longValue, size) == null && !gVar.o) {
            if (!gVar.o) {
                obj7.c = uri;
                obj6.r = z5 &= equals;
                obj6.n = uri;
            }
            if (obj36 == 0 && gVar.r.isEmpty()) {
                if (gVar.r.isEmpty()) {
                }
                eVar = new i.e((g.e)a0.c(gVar.r), i20 -= i4, i, i22);
            }
            obj7.b = i21;
        }
        obj6.r = false;
        obj6.n = 0;
        Uri uri4 = i.c(gVar, eVar2.b);
        b bVar2 = obj6.k(uri4, i3);
        obj7.a = bVar2;
        if (bVar2 != null) {
        }
        Uri uri7 = i.c(gVar, eVar.a);
        bVar = obj6.k(uri7, i3);
        obj7.a = bVar;
        if (bVar != null) {
        }
        final boolean z9 = m.w(obj, uri, gVar, eVar, i6);
        if (z9 && eVar.d) {
            if (eVar.d) {
            }
        }
        obj7.a = m.i(obj6.a, obj6.b, obj6.f[i3], i6, i24, gVar, eVar, uri, obj6.i, obj6.p.o(), obj6.p.q(), obj6.k, obj6.d, obj, obj6.j.a(uri7), obj6.j.a(uri4));
    }

    public int g(long l, List<? extends d> list2) {
        IOException length;
        int i;
        if (this.m == null && this.p.length() < 2) {
            if (this.p.length() < 2) {
            }
            return this.p.k(l, list2);
        }
        return obj5.size();
    }

    public k0 i() {
        return this.h;
    }

    public g j() {
        return this.p;
    }

    public boolean l(b b, long l2) {
        final g gVar = this.p;
        return gVar.c(gVar.t(this.h.b(b.d)), l2);
    }

    public void m() {
        boolean z;
        IOException exc = this.m;
        if (exc != null) {
        } else {
            Uri uri = this.n;
            if (uri != null && this.r) {
                if (this.r) {
                    this.g.c(uri);
                }
            }
        }
        throw exc;
    }

    public boolean n(Uri uri) {
        return p0.r(this.e, uri);
    }

    public void o(b b) {
        boolean z;
        Uri uri;
        Object obj3;
        if (b instanceof i.a) {
            this.l = (i.a)b.h();
            obj3 = b.j();
            g.e(obj3);
            this.j.b(nVar.a, (byte[])obj3);
        }
    }

    public boolean p(Uri uri, long l2) {
        int i;
        int i3;
        boolean i4;
        boolean equals;
        int length;
        g cmp;
        int i2;
        Object obj6;
        i3 = i;
        equals = this.e;
        i2 = -1;
        for (Object uri2 : obj2) {
            equals = this.e;
            i2 = -1;
        }
        i3 = i2;
        int i5 = 1;
        if (i3 == i2) {
            return i5;
        }
        i4 = this.p.t(i3);
        if (i4 == i2) {
            return i5;
        }
        this.r = z |= equals2;
        if (Long.compare(l2, l) != 0) {
            if (this.p.c(i4, l2) && this.g.f(uri, l2)) {
                if (this.g.f(uri, l2)) {
                    i = i5;
                }
            }
        } else {
        }
        return i;
    }

    public void q() {
        this.m = 0;
    }

    public void s(boolean z) {
        this.k = z;
    }

    public void t(g g) {
        this.p = g;
    }

    public boolean u(long l, b b2, List<? extends d> list3) {
        if (this.m != null) {
            return 0;
        }
        return this.p.e(l, b2, list3);
    }
}
