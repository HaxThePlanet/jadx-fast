package com.google.android.exoplayer2;

import android.net.Uri;
import com.google.android.exoplayer2.offline.c;
import com.google.android.exoplayer2.util.g;
import com.google.android.exoplayer2.util.p0;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/* loaded from: classes.dex */
public final class m1 {

    public static final com.google.android.exoplayer2.v0<com.google.android.exoplayer2.m1> f;
    public final String a;
    public final com.google.android.exoplayer2.m1.g b;
    public final com.google.android.exoplayer2.m1.f c;
    public final com.google.android.exoplayer2.n1 d;
    public final com.google.android.exoplayer2.m1.d e;

    static class a {
    }

    public static final class b {

        public final Uri a;
        public final Object b;
        private b(Uri uri, Object object2) {
            super();
            this.a = uri;
            this.b = object2;
        }

        b(Uri uri, Object object2, com.google.android.exoplayer2.m1.a m1$a3) {
            super(uri, object2);
        }

        public boolean equals(Object object) {
            int i;
            boolean equals;
            Object obj5;
            if (this == object) {
                return 1;
            }
            final int i2 = 0;
            if (!object instanceof m1.b) {
                return i2;
            }
            if (this.a.equals(object.a) && p0.b(this.b, object.b)) {
                if (p0.b(this.b, object.b)) {
                } else {
                    i = i2;
                }
            } else {
            }
            return i;
        }

        public int hashCode() {
            int i;
            Object obj = this.b;
            if (obj != null) {
                i = obj.hashCode();
            } else {
                i = 0;
            }
            return i3 += i;
        }
    }

    public static final class c {

        private float A;
        private float B;
        private String a;
        private Uri b;
        private String c;
        private long d;
        private long e;
        private boolean f;
        private boolean g;
        private boolean h;
        private Uri i;
        private Map<String, String> j;
        private UUID k;
        private boolean l;
        private boolean m;
        private boolean n;
        private List<Integer> o;
        private byte[] p;
        private List<c> q;
        private String r;
        private List<Object> s;
        private Uri t;
        private Object u;
        private Object v;
        private com.google.android.exoplayer2.n1 w;
        private long x;
        private long y;
        private long z;
        public c() {
            super();
            this.e = Long.MIN_VALUE;
            this.o = Collections.emptyList();
            this.j = Collections.emptyMap();
            this.q = Collections.emptyList();
            this.s = Collections.emptyList();
            long l2 = -9223372036854775807L;
            this.x = l2;
            this.y = l2;
            this.z = l2;
            int i = -8388609;
            this.A = i;
            this.B = i;
        }

        private c(com.google.android.exoplayer2.m1 m1) {
            com.google.android.exoplayer2.m1.e f2;
            float f;
            Object obj4;
            super();
            com.google.android.exoplayer2.m1.d dVar = m1.e;
            this.e = dVar.b;
            this.f = dVar.c;
            this.g = dVar.d;
            this.d = dVar.a;
            this.h = dVar.e;
            this.a = m1.a;
            this.w = m1.d;
            com.google.android.exoplayer2.m1.f fVar = m1.c;
            this.x = fVar.a;
            this.y = fVar.b;
            this.z = fVar.c;
            this.A = fVar.d;
            this.B = fVar.e;
            obj4 = m1.b;
            this.r = obj4.f;
            this.c = obj4.b;
            this.b = obj4.a;
            this.q = obj4.e;
            this.s = obj4.g;
            this.v = obj4.h;
            f2 = obj4.c;
            if (obj4 != null && f2 != null) {
                this.r = obj4.f;
                this.c = obj4.b;
                this.b = obj4.a;
                this.q = obj4.e;
                this.s = obj4.g;
                this.v = obj4.h;
                f2 = obj4.c;
                if (f2 != null) {
                    this.i = f2.b;
                    this.j = f2.c;
                    this.l = f2.d;
                    this.n = f2.f;
                    this.m = f2.e;
                    this.o = f2.g;
                    this.k = f2.a;
                    this.p = f2.a();
                }
                obj4 = obj4.d;
                if (obj4 != null) {
                    this.t = obj4.a;
                    this.u = obj4.b;
                }
            }
        }

        c(com.google.android.exoplayer2.m1 m1, com.google.android.exoplayer2.m1.a m1$a2) {
            super(m1);
        }

        public com.google.android.exoplayer2.m1 a() {
            Object uri;
            int i3;
            Object eVar3;
            String str2;
            com.google.android.exoplayer2.n1 n1Var;
            String str3;
            com.google.android.exoplayer2.m1.e eVar2;
            int bVar;
            List list2;
            String str;
            List list3;
            Object obj;
            int i2;
            com.google.android.exoplayer2.m1.g gVar;
            com.google.android.exoplayer2.m1.e eVar;
            UUID uuid;
            Uri uri2;
            com.google.android.exoplayer2.m1.g gVar2;
            Map map;
            boolean z2;
            boolean z;
            boolean z3;
            List list;
            byte[] bArr;
            int i;
            final Object obj2 = this;
            if (obj2.i != null) {
                if (obj2.k != null) {
                    i3 = 1;
                } else {
                    i3 = 0;
                }
            } else {
            }
            g.f(i3);
            Uri uri4 = obj2.b;
            int i4 = 0;
            if (uri4 != null) {
                uuid = obj2.k;
                if (uuid != null) {
                    super(uuid, obj2.i, obj2.j, obj2.l, obj2.n, obj2.m, obj2.o, obj2.p, 0);
                    eVar2 = eVar3;
                } else {
                    eVar2 = i4;
                }
                Uri uri3 = obj2.t;
                if (uri3 != null) {
                    bVar = new m1.b(uri3, obj2.u, i4);
                } else {
                    bVar = i4;
                }
                eVar3 = new m1.e(uri4, obj2.c, eVar2, bVar, obj2.q, obj2.r, obj2.s, obj2.v, 0);
                gVar2 = gVar;
            } else {
                gVar2 = i4;
            }
            if (obj2.a != null) {
            } else {
                str2 = "";
            }
            super(obj2.d, str3, obj2.e, bVar, obj2.f, obj2.g, obj2.h, 0);
            super(obj2.x, z3, obj2.y, bArr, obj2.z, obj23, obj2.A, obj2.B);
            if (obj2.w != null) {
            } else {
                n1Var = n1.F;
            }
            super(str2, dVar2, gVar2, fVar, n1Var, 0);
            return m1Var;
        }

        public com.google.android.exoplayer2.m1.c b(long l) {
            this.x = l;
            return this;
        }

        public com.google.android.exoplayer2.m1.c c(String string) {
            g.e(string);
            this.a = (String)string;
            return this;
        }

        public com.google.android.exoplayer2.m1.c d(List<c> list) {
            boolean arrayList;
            List obj2;
            if (list != null && !list.isEmpty()) {
                if (!list.isEmpty()) {
                    arrayList = new ArrayList(list);
                    obj2 = Collections.unmodifiableList(arrayList);
                } else {
                    obj2 = Collections.emptyList();
                }
            } else {
            }
            this.q = obj2;
            return this;
        }

        public com.google.android.exoplayer2.m1.c e(Object object) {
            this.v = object;
            return this;
        }

        public com.google.android.exoplayer2.m1.c f(Uri uri) {
            this.b = uri;
            return this;
        }

        public com.google.android.exoplayer2.m1.c g(String string) {
            int obj1;
            if (string == null) {
                obj1 = 0;
            } else {
                obj1 = Uri.parse(string);
            }
            f(obj1);
            return this;
        }
    }

    public static final class d {

        public static final com.google.android.exoplayer2.v0<com.google.android.exoplayer2.m1.d> f;
        public final long a;
        public final long b;
        public final boolean c;
        public final boolean d;
        public final boolean e;
        static {
            m1.d.f = c0.a;
        }

        private d(long l, long l2, boolean z3, boolean z4, boolean z5) {
            super();
            this.a = l;
            this.b = z3;
            this.c = z5;
            this.d = obj6;
            this.e = obj7;
        }

        d(long l, long l2, boolean z3, boolean z4, boolean z5, com.google.android.exoplayer2.m1.a m1$a6) {
            super(l, l2, z3, z4, z5, a6, obj7);
        }

        public boolean equals(Object object) {
            int i;
            int cmp;
            long l;
            long l2;
            Object obj8;
            if (this == object) {
                return 1;
            }
            final int i2 = 0;
            if (!object instanceof m1.d) {
                return i2;
            }
            if (Long.compare(l, l2) == 0 && Long.compare(l, l2) == 0 && this.c == object.c && this.d == object.d && this.e == object.e) {
                if (Long.compare(l, l2) == 0) {
                    if (this.c == object.c) {
                        if (this.d == object.d) {
                            if (this.e == object.e) {
                            } else {
                                i = i2;
                            }
                        } else {
                        }
                    } else {
                    }
                } else {
                }
            } else {
            }
            return i;
        }

        public int hashCode() {
            long l = this.a;
            final int i14 = 32;
            long l2 = this.b;
            return i9 += z3;
        }
    }

    public static final class e {

        public final UUID a;
        public final Uri b;
        public final Map<String, String> c;
        public final boolean d;
        public final boolean e;
        public final boolean f;
        public final List<Integer> g;
        private final byte[] h;
        private e(UUID uUID, Uri uri2, Map<String, String> map3, boolean z4, boolean z5, boolean z6, List<Integer> list7, byte[] b8Arr8) {
            int i;
            int obj2;
            super();
            if (z5) {
                if (uri2 != null) {
                    i = 1;
                } else {
                    i = 0;
                }
            } else {
            }
            g.a(i);
            this.a = uUID;
            this.b = uri2;
            this.c = map3;
            this.d = z4;
            this.f = z5;
            this.e = z6;
            this.g = list7;
            if (b8Arr8 != null) {
                obj2 = Arrays.copyOf(b8Arr8, b8Arr8.length);
            } else {
                obj2 = 0;
            }
            this.h = obj2;
        }

        e(UUID uUID, Uri uri2, Map map3, boolean z4, boolean z5, boolean z6, List list7, byte[] b8Arr8, com.google.android.exoplayer2.m1.a m1$a9) {
            super(uUID, uri2, map3, z4, z5, z6, list7, b8Arr8);
        }

        public byte[] a() {
            byte[] copyOf;
            int length;
            byte[] bArr = this.h;
            if (bArr != null) {
                copyOf = Arrays.copyOf(bArr, bArr.length);
            } else {
                copyOf = 0;
            }
            return copyOf;
        }

        public boolean equals(Object object) {
            int i;
            boolean equals;
            Object uuid;
            Object obj5;
            if (this == object) {
                return 1;
            }
            final int i2 = 0;
            if (!object instanceof m1.e) {
                return i2;
            }
            if (this.a.equals(object.a) && p0.b(this.b, object.b) && p0.b(this.c, object.c) && this.d == object.d && this.f == object.f && this.e == object.e && this.g.equals(object.g) && Arrays.equals(this.h, object.h)) {
                if (p0.b(this.b, object.b)) {
                    if (p0.b(this.c, object.c)) {
                        if (this.d == object.d) {
                            if (this.f == object.f) {
                                if (this.e == object.e) {
                                    if (this.g.equals(object.g)) {
                                        if (Arrays.equals(this.h, object.h)) {
                                        } else {
                                            i = i2;
                                        }
                                    } else {
                                    }
                                } else {
                                }
                            } else {
                            }
                        } else {
                        }
                    } else {
                    }
                } else {
                }
            } else {
            }
            return i;
        }

        public int hashCode() {
            int i;
            Uri uri = this.b;
            if (uri != null) {
                i = uri.hashCode();
            } else {
                i = 0;
            }
            return i15 += i19;
        }
    }

    public static final class f {

        public static final com.google.android.exoplayer2.m1.f f;
        public static final com.google.android.exoplayer2.v0<com.google.android.exoplayer2.m1.f> g;
        public final long a;
        public final long b;
        public final long c;
        public final float d;
        public final float e;
        static {
            super(-9223372036854775807L, obj2, -9223372036854775807L, obj4, -9223372036854775807L, obj6, -8388609, -8388609);
            m1.f.f = fVar2;
            m1.f.g = d0.a;
        }

        public f(long l, long l2, long l3, float f4, float f5) {
            super();
            this.a = l;
            this.b = l3;
            this.c = f5;
            this.d = obj7;
            this.e = obj8;
        }

        public boolean equals(Object object) {
            int i;
            int cmp;
            long l2;
            long l;
            Object obj8;
            if (this == object) {
                return 1;
            }
            final int i2 = 0;
            if (!object instanceof m1.f) {
                return i2;
            }
            if (Long.compare(l2, l) == 0 && Long.compare(l2, l) == 0 && Long.compare(l2, l) == 0 && Float.compare(f, l2) == 0 && Float.compare(cmp, obj8) == 0) {
                if (Long.compare(l2, l) == 0) {
                    if (Long.compare(l2, l) == 0) {
                        if (Float.compare(f, l2) == 0) {
                            if (Float.compare(cmp, obj8) == 0) {
                            } else {
                                i = i2;
                            }
                        } else {
                        }
                    } else {
                    }
                } else {
                }
            } else {
            }
            return i;
        }

        public int hashCode() {
            int floatToIntBits;
            int floatToIntBits2;
            long l = this.a;
            int i15 = 32;
            long l2 = this.b;
            long l3 = this.c;
            float f = this.d;
            int i16 = 0;
            if (Float.compare(f, i16) != 0) {
                floatToIntBits = Float.floatToIntBits(f);
            } else {
                floatToIntBits = floatToIntBits2;
            }
            float f2 = this.e;
            if (Float.compare(f2, i16) != 0) {
                floatToIntBits2 = Float.floatToIntBits(f2);
            }
            return i9 += floatToIntBits2;
        }
    }

    public static final class g {

        public final Uri a;
        public final String b;
        public final com.google.android.exoplayer2.m1.e c;
        public final com.google.android.exoplayer2.m1.b d;
        public final List<c> e;
        public final String f;
        public final List<Object> g;
        public final Object h;
        private g(Uri uri, String string2, com.google.android.exoplayer2.m1.e m1$e3, com.google.android.exoplayer2.m1.b m1$b4, List<c> list5, String string6, List<Object> list7, Object object8) {
            super();
            this.a = uri;
            this.b = string2;
            this.c = e3;
            this.d = b4;
            this.e = list5;
            this.f = string6;
            this.g = list7;
            this.h = object8;
        }

        g(Uri uri, String string2, com.google.android.exoplayer2.m1.e m1$e3, com.google.android.exoplayer2.m1.b m1$b4, List list5, String string6, List list7, Object object8, com.google.android.exoplayer2.m1.a m1$a9) {
            super(uri, string2, e3, b4, list5, string6, list7, object8);
        }

        public boolean equals(Object object) {
            int i;
            boolean equals;
            Object uri;
            Object obj5;
            if (this == object) {
                return 1;
            }
            final int i2 = 0;
            if (!object instanceof m1.g) {
                return i2;
            }
            if (this.a.equals(object.a) && p0.b(this.b, object.b) && p0.b(this.c, object.c) && p0.b(this.d, object.d) && this.e.equals(object.e) && p0.b(this.f, object.f) && this.g.equals(object.g) && p0.b(this.h, object.h)) {
                if (p0.b(this.b, object.b)) {
                    if (p0.b(this.c, object.c)) {
                        if (p0.b(this.d, object.d)) {
                            if (this.e.equals(object.e)) {
                                if (p0.b(this.f, object.f)) {
                                    if (this.g.equals(object.g)) {
                                        if (p0.b(this.h, object.h)) {
                                        } else {
                                            i = i2;
                                        }
                                    } else {
                                    }
                                } else {
                                }
                            } else {
                            }
                        } else {
                        }
                    } else {
                    }
                } else {
                }
            } else {
            }
            return i;
        }

        public int hashCode() {
            int i;
            int i2;
            int i5;
            int i3;
            int i4;
            String str = this.b;
            i4 = 0;
            if (str == null) {
                i = i4;
            } else {
                i = str.hashCode();
            }
            com.google.android.exoplayer2.m1.e eVar = this.c;
            if (eVar == null) {
                i2 = i4;
            } else {
                i2 = eVar.hashCode();
            }
            com.google.android.exoplayer2.m1.b bVar = this.d;
            if (bVar == null) {
                i5 = i4;
            } else {
                i5 = bVar.hashCode();
            }
            String str2 = this.f;
            if (str2 == null) {
                i3 = i4;
            } else {
                i3 = str2.hashCode();
            }
            Object obj = this.h;
            if (obj == null) {
            } else {
                i4 = obj.hashCode();
            }
            return i19 += i4;
        }
    }
    static {
        m1.c cVar = new m1.c();
        cVar.a();
        m1.f = e0.a;
    }

    private m1(String string, com.google.android.exoplayer2.m1.d m1$d2, com.google.android.exoplayer2.m1.g m1$g3, com.google.android.exoplayer2.m1.f m1$f4, com.google.android.exoplayer2.n1 n15) {
        super();
        this.a = string;
        this.b = g3;
        this.c = f4;
        this.d = n15;
        this.e = d2;
    }

    m1(String string, com.google.android.exoplayer2.m1.d m1$d2, com.google.android.exoplayer2.m1.g m1$g3, com.google.android.exoplayer2.m1.f m1$f4, com.google.android.exoplayer2.n1 n15, com.google.android.exoplayer2.m1.a m1$a6) {
        super(string, d2, g3, f4, n15);
    }

    public static com.google.android.exoplayer2.m1 b(String string) {
        m1.c cVar = new m1.c();
        cVar.g(string);
        return cVar.a();
    }

    public com.google.android.exoplayer2.m1.c a() {
        m1.c cVar = new m1.c(this, 0);
        return cVar;
    }

    public boolean equals(Object object) {
        int i;
        boolean equals;
        Object str;
        Object obj5;
        if (this == object) {
            return 1;
        }
        final int i2 = 0;
        if (!object instanceof m1) {
            return i2;
        }
        if (p0.b(this.a, object.a) && this.e.equals(object.e) && p0.b(this.b, object.b) && p0.b(this.c, object.c) && p0.b(this.d, object.d)) {
            if (this.e.equals(object.e)) {
                if (p0.b(this.b, object.b)) {
                    if (p0.b(this.c, object.c)) {
                        if (p0.b(this.d, object.d)) {
                        } else {
                            i = i2;
                        }
                    } else {
                    }
                } else {
                }
            } else {
            }
        } else {
        }
        return i;
    }

    public int hashCode() {
        int i;
        com.google.android.exoplayer2.m1.g gVar = this.b;
        if (gVar != null) {
            i = gVar.hashCode();
        } else {
            i = 0;
        }
        return i9 += i13;
    }
}
