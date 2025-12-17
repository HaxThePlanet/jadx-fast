package com.google.android.exoplayer2.source.hls.playlist;

import android.net.Uri;
import com.google.android.exoplayer2.drm.t;
import com.google.android.exoplayer2.offline.c;
import com.google.common.collect.a0;
import com.google.common.collect.v;
import com.google.common.collect.x;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* loaded from: classes2.dex */
public final class g extends com.google.android.exoplayer2.source.hls.playlist.h {

    public final int d;
    public final long e;
    public final boolean f;
    public final boolean g;
    public final long h;
    public final boolean i;
    public final int j;
    public final long k;
    public final int l;
    public final long m;
    public final long n;
    public final boolean o;
    public final boolean p;
    public final t q;
    public final List<com.google.android.exoplayer2.source.hls.playlist.g.d> r;
    public final List<com.google.android.exoplayer2.source.hls.playlist.g.b> s;
    public final Map<Uri, com.google.android.exoplayer2.source.hls.playlist.g.c> t;
    public final long u;
    public final com.google.android.exoplayer2.source.hls.playlist.g.f v;

    static class a {
    }

    public static final class c {

        public final long a;
        public final int b;
        public c(Uri uri, long l2, int i3) {
            super();
            this.a = l2;
            this.b = obj4;
        }
    }

    public static class e implements Comparable<Long> {

        public final long A;
        public final long B;
        public final boolean C;
        public final String a;
        public final com.google.android.exoplayer2.source.hls.playlist.g.d b;
        public final long c;
        public final int v;
        public final long w;
        public final t x;
        public final String y;
        public final String z;
        private e(String string, com.google.android.exoplayer2.source.hls.playlist.g.d g$d2, long l3, int i4, long l5, t t6, String string7, String string8, long l9, long l10, boolean z11) {
            super();
            this.a = string;
            this.b = d2;
            this.c = l3;
            this.v = l5;
            this.w = t6;
            this.x = string8;
            this.y = l9;
            this.z = l10;
            this.A = z11;
            this.B = obj13;
            this.C = obj15;
        }

        e(String string, com.google.android.exoplayer2.source.hls.playlist.g.d g$d2, long l3, int i4, long l5, t t6, String string7, String string8, long l9, long l10, boolean z11, com.google.android.exoplayer2.source.hls.playlist.g.a g$a12) {
            super(string, d2, l3, i4, l5, t6, string7, string8, l9, l10, z11, a12, obj13, obj14, obj15);
        }

        @Override // java.lang.Comparable
        public int a(Long long) {
            int cmp;
            long longValue;
            int obj5;
            obj5 = Long.compare(l, longValue) > 0 ? 1 : obj5 < 0 ? -1 : 0;
            return obj5;
        }

        @Override // java.lang.Comparable
        public int compareTo(Object object) {
            return a((Long)object);
        }
    }

    public static final class f {

        public final long a;
        public final boolean b;
        public final long c;
        public final long d;
        public final boolean e;
        public f(long l, boolean z2, long l3, long l4, boolean z5) {
            super();
            this.a = l;
            this.b = l3;
            this.c = l4;
            this.d = obj6;
            this.e = obj8;
        }
    }

    public static final class b extends com.google.android.exoplayer2.source.hls.playlist.g.e {

        public final boolean D;
        public final boolean E;
        public b(String string, com.google.android.exoplayer2.source.hls.playlist.g.d g$d2, long l3, int i4, long l5, t t6, String string7, String string8, long l9, long l10, boolean z11, boolean z12, boolean z13) {
            Object obj3 = this;
            final Object obj = this;
            super(string, d2, l3, obj4, l5, t6, obj7, string8, l9, l10, z11, obj12, z13, obj14, obj32, 0);
            obj.D = obj33;
            obj.E = obj34;
        }

        @Override // com.google.android.exoplayer2.source.hls.playlist.g$e
        public com.google.android.exoplayer2.source.hls.playlist.g.b c(long l, int i2) {
            final Object obj = this;
            super(obj.a, obj.b, obj.c, obj5, obj23, l, obj8, obj.x, obj.y, obj.z, obj.A, obj13, obj.B, obj15, obj.C, obj.D, obj.E);
            return bVar3;
        }
    }

    public static final class d extends com.google.android.exoplayer2.source.hls.playlist.g.e {

        public final String D;
        public final List<com.google.android.exoplayer2.source.hls.playlist.g.b> E;
        public d(String string, long l2, long l3, String string4, String string5) {
            super(string, 0, "", 0, obj5, -1, -9223372036854775807L, obj8, 0, obj24, obj25, l2, obj13, string4, obj15, 0, v.z());
        }

        public d(String string, com.google.android.exoplayer2.source.hls.playlist.g.d g$d2, String string3, long l4, int i5, long l6, t t7, String string8, String string9, long l10, long l11, boolean z12, List<com.google.android.exoplayer2.source.hls.playlist.g.b> list13) {
            Object obj3 = this;
            final Object obj = this;
            super(string, d2, l4, obj4, l6, t7, obj7, string9, l10, l11, z12, obj12, obj31, obj14, obj33, 0);
            obj.D = string3;
            obj.E = v.u(obj34);
        }

        @Override // com.google.android.exoplayer2.source.hls.playlist.g$e
        public com.google.android.exoplayer2.source.hls.playlist.g.d c(long l, int i2) {
            int i;
            long l2;
            long l3;
            com.google.android.exoplayer2.source.hls.playlist.g.b bVar;
            long l4;
            final Object obj = this;
            ArrayList arrayList = new ArrayList();
            i = 0;
            l2 = l;
            while (i < obj.E.size()) {
                Object obj2 = obj.E.get(i);
                arrayList.add((g.b)obj2.c(l2, obj3));
                l2 += l3;
                i++;
            }
            long l6 = obj23;
            final ArrayList list3 = arrayList;
            super(obj.a, obj.b, obj.D, obj.c, obj6, obj23, l, list3, obj.x, obj.y, obj.z, obj.A, obj14, obj.B, obj16, obj.C, list3);
            return dVar3;
        }
    }
    public g(int i, String string2, List<String> list3, long l4, boolean z5, long l6, boolean z7, int i8, long l9, int i10, long l11, long l12, boolean z13, boolean z14, boolean z15, t t16, List<com.google.android.exoplayer2.source.hls.playlist.g.d> list17, List<com.google.android.exoplayer2.source.hls.playlist.g.b> list18, com.google.android.exoplayer2.source.hls.playlist.g.f g$f19, Map<Uri, com.google.android.exoplayer2.source.hls.playlist.g.c> map20) {
        int i2;
        Object empty;
        int cmp;
        int i3;
        long l2;
        long l;
        final Object obj = this;
        long l3 = l4;
        String str = string2;
        List list = list3;
        final boolean z6 = list18;
        super(string2, list3, z6);
        obj.d = i;
        obj.h = z7;
        obj.g = l6;
        obj.i = l9;
        obj.j = i10;
        obj.k = l11;
        obj.l = z13;
        obj.m = z14;
        obj.n = t16;
        obj.o = f19;
        obj.p = map20;
        obj.q = obj31;
        obj.r = v.u(obj32);
        obj.s = v.u(obj33);
        obj.t = x.d(obj35);
        int i7 = 0;
        if (!obj33.isEmpty()) {
            empty = a0.c(obj33);
            obj.u = l16 += l;
        } else {
            if (!obj32.isEmpty()) {
                empty = a0.c(obj32);
                obj.u = l13 += l;
            } else {
                obj.u = i7;
            }
        }
        if (Long.compare(l3, l2) == 0) {
        } else {
            if (Long.compare(l3, i7) >= 0) {
                l2 = Math.min(obj.u, obj7);
            } else {
                l2 = Math.max(i7, z6);
            }
        }
        obj.e = l2;
        i2 = Long.compare(l3, i7) >= 0 ? 1 : 0;
        obj.f = i2;
        obj.v = obj34;
    }

    @Override // com.google.android.exoplayer2.source.hls.playlist.h
    public Object a(List list) {
        b(list);
        return this;
    }

    public com.google.android.exoplayer2.source.hls.playlist.g b(List<c> list) {
        return this;
    }

    @Override // com.google.android.exoplayer2.source.hls.playlist.h
    public com.google.android.exoplayer2.source.hls.playlist.g c(long l, int i2) {
        final Object obj = this;
        super(obj.d, obj.a, obj.b, obj.e, obj6, obj.g, l, obj9, 1, obj31, obj.k, obj13, obj.l, obj.m, obj16, obj.n, obj18, obj.c, obj.o, obj.p, obj.q, obj.r, obj.s, obj.v, obj.t);
        return gVar3;
    }

    @Override // com.google.android.exoplayer2.source.hls.playlist.h
    public com.google.android.exoplayer2.source.hls.playlist.g d() {
        final Object obj = this;
        if (obj.o) {
            return obj;
        }
        super(obj.d, obj.a, obj.b, obj.e, obj7, obj.g, obj.h, obj10, obj.i, obj.j, obj.k, obj14, obj.l, obj.m, obj17, obj.n, obj19, obj.c, 1, obj.p, obj.q, obj.r, obj.s, obj.v, obj.t);
        return gVar;
    }

    @Override // com.google.android.exoplayer2.source.hls.playlist.h
    public long e() {
        return l += l2;
    }

    @Override // com.google.android.exoplayer2.source.hls.playlist.h
    public boolean f(com.google.android.exoplayer2.source.hls.playlist.g g) {
        int i2;
        int size2;
        int i;
        int size;
        int cmp;
        Object obj7;
        i2 = 1;
        if (g != null) {
            size2 = this.k;
            size = g.k;
            if (Long.compare(size2, size) > 0) {
            } else {
                i = 0;
                if (Long.compare(size2, size) < 0) {
                    return i;
                }
                size3 -= size4;
                if (i3 != 0) {
                    if (i3 > 0) {
                    } else {
                        i2 = i;
                    }
                    return i2;
                }
                size2 = this.s.size();
                size = g.s.size();
                if (size2 <= size) {
                    if (size2 == size && this.o && !g.o) {
                        if (this.o) {
                            if (!g.o) {
                            } else {
                                i2 = i;
                            }
                        } else {
                        }
                    } else {
                    }
                }
            }
        }
        return i2;
    }
}
