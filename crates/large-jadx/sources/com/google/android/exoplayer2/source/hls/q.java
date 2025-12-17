package com.google.android.exoplayer2.source.hls;

import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.util.SparseIntArray;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2.drm.t;
import com.google.android.exoplayer2.drm.u.a;
import com.google.android.exoplayer2.drm.v;
import com.google.android.exoplayer2.i1;
import com.google.android.exoplayer2.i1.b;
import com.google.android.exoplayer2.j1;
import com.google.android.exoplayer2.l2.h;
import com.google.android.exoplayer2.l2.k;
import com.google.android.exoplayer2.l2.q;
import com.google.android.exoplayer2.l2.s;
import com.google.android.exoplayer2.l2.s.a;
import com.google.android.exoplayer2.m2.a;
import com.google.android.exoplayer2.m2.i.a;
import com.google.android.exoplayer2.m2.i.b;
import com.google.android.exoplayer2.n2.g;
import com.google.android.exoplayer2.n2.j;
import com.google.android.exoplayer2.n2.m;
import com.google.android.exoplayer2.source.e0;
import com.google.android.exoplayer2.source.e0.d;
import com.google.android.exoplayer2.source.f0;
import com.google.android.exoplayer2.source.g0;
import com.google.android.exoplayer2.source.g0.a;
import com.google.android.exoplayer2.source.k0;
import com.google.android.exoplayer2.source.l0;
import com.google.android.exoplayer2.source.m0.b;
import com.google.android.exoplayer2.source.s;
import com.google.android.exoplayer2.source.v;
import com.google.android.exoplayer2.source.z.a;
import com.google.android.exoplayer2.upstream.Loader;
import com.google.android.exoplayer2.upstream.Loader.b;
import com.google.android.exoplayer2.upstream.Loader.c;
import com.google.android.exoplayer2.upstream.Loader.e;
import com.google.android.exoplayer2.upstream.Loader.f;
import com.google.android.exoplayer2.upstream.f;
import com.google.android.exoplayer2.upstream.i;
import com.google.android.exoplayer2.upstream.w;
import com.google.android.exoplayer2.upstream.w.c;
import com.google.android.exoplayer2.util.d0;
import com.google.android.exoplayer2.util.g;
import com.google.android.exoplayer2.util.p0;
import com.google.android.exoplayer2.util.v;
import com.google.android.exoplayer2.util.z;
import com.google.android.exoplayer2.w0;
import com.google.common.collect.a0;
import com.google.common.collect.v;
import com.google.common.collect.v.a;
import java.io.EOFException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

/* loaded from: classes2.dex */
final class q implements Loader.b<b>, Loader.f, g0, k, e0.d {

    private static final Set<Integer> p0;
    private final Loader A;
    private final z.a B;
    private final int C;
    private final com.google.android.exoplayer2.source.hls.i.b D;
    private final ArrayList<com.google.android.exoplayer2.source.hls.m> E;
    private final List<com.google.android.exoplayer2.source.hls.m> F;
    private final Runnable G;
    private final Runnable H;
    private final Handler I;
    private final ArrayList<com.google.android.exoplayer2.source.hls.p> J;
    private final Map<String, t> K;
    private b L;
    private com.google.android.exoplayer2.source.hls.q.d[] M;
    private int[] N;
    private Set<Integer> O;
    private SparseIntArray P;
    private s Q;
    private int R;
    private int S;
    private boolean T;
    private boolean U;
    private int V;
    private i1 W;
    private i1 X;
    private boolean Y;
    private l0 Z;
    private final int a;
    private Set<k0> a0;
    private final com.google.android.exoplayer2.source.hls.q.b b;
    private int[] b0;
    private final com.google.android.exoplayer2.source.hls.i c;
    private int c0;
    private boolean d0;
    private boolean[] e0;
    private boolean[] f0;
    private long g0;
    private long h0;
    private boolean i0;
    private boolean j0;
    private boolean k0;
    private boolean l0;
    private long m0;
    private t n0;
    private com.google.android.exoplayer2.source.hls.m o0;
    private final f v;
    private final i1 w;
    private final v x;
    private final u.a y;
    private final w z;

    static class a {
    }

    public interface b extends g0.a<com.google.android.exoplayer2.source.hls.q> {
        @Override // com.google.android.exoplayer2.source.g0$a
        public abstract void d();

        @Override // com.google.android.exoplayer2.source.g0$a
        public abstract void j(Uri uri);
    }

    private static class c implements s {

        private static final i1 g;
        private static final i1 h;
        private final b a;
        private final s b;
        private final i1 c = 3;
        private i1 d;
        private byte[] e;
        private int f = 0;
        static {
            i1.b bVar = new i1.b();
            bVar.e0("application/id3");
            q.c.g = bVar.E();
            i1.b bVar2 = new i1.b();
            bVar2.e0("application/x-emsg");
            q.c.h = bVar2.E();
        }

        public c(s s, int i2) {
            i1 obj3;
            super();
            b bVar = new b();
            this.a = bVar;
            this.b = s;
            if (i2 != 1) {
                if (i2 != 3) {
                } else {
                    obj3 = q.c.h;
                    this.e = new byte[0];
                }
                StringBuilder stringBuilder = new StringBuilder(33);
                stringBuilder.append("Unknown metadataType: ");
                stringBuilder.append(i2);
                obj3 = new IllegalArgumentException(stringBuilder.toString());
                throw obj3;
            }
            this.c = q.c.g;
        }

        private boolean g(a a) {
            String str;
            i1 obj2;
            obj2 = a.g0();
            if (obj2 != null && p0.b(i1Var.D, obj2.D)) {
                obj2 = p0.b(i1Var.D, obj2.D) ? 1 : 0;
            } else {
            }
            return obj2;
        }

        private void h(int i) {
            int length;
            int obj3;
            final byte[] bArr = this.e;
            if (bArr.length < i) {
                this.e = Arrays.copyOf(bArr, i += length);
            }
        }

        private d0 i(int i, int i2) {
            i3 -= i2;
            d0 d0Var = new d0(Arrays.copyOfRange(this.e, i4 - i, i4));
            byte[] obj4 = this.e;
            System.arraycopy(obj4, i4, obj4, 0, i2);
            this.f = i2;
            return d0Var;
        }

        @Override // com.google.android.exoplayer2.l2.s
        public int a(i i, int i2, boolean z3, int i4) {
            h(obj5 += i2);
            int obj2 = i.read(this.e, this.f, i2);
            int obj3 = -1;
            if (obj2 == obj3) {
                if (!z3) {
                } else {
                    return obj3;
                }
                obj2 = new EOFException();
                throw obj2;
            }
            this.f = obj3 += obj2;
            return obj2;
        }

        @Override // com.google.android.exoplayer2.l2.s
        public void d(long l, int i2, int i3, int i4, s.a s$a5) {
            d0 d0Var;
            String str;
            String obj8;
            String obj9;
            d0 obj11;
            g.e(this.d);
            if (p0.b(i1Var2.D, i1Var4.D)) {
                final int i5 = obj11.a();
                this.b.c(obj11, i5);
                this.b.d(l, obj2, i3, i5, a5);
            } else {
                str = "EmsgUnwrappingTrackOutput";
                obj11 = this.a.c(i(i4, a5));
                if ("application/x-emsg".equals(i1Var3.D) && !g(obj11)) {
                    obj11 = this.a.c(obj11);
                    if (!g(obj11)) {
                        obj8 = new Object[2];
                        v.h(str, String.format("Ignoring EMSG. Expected it to contain wrapped %s but actual wrapped format: %s", obj10.D, obj11.g0()));
                    }
                    obj11 = obj11.S1();
                    g.e(obj11);
                    d0Var = new d0((byte[])obj11);
                    obj11 = d0Var;
                }
            }
            obj8 = "Ignoring sample for unsupported format: ";
            obj9 = String.valueOf(obj9.D);
            if (obj9.length() != 0) {
                obj8 = obj8.concat(obj9);
            } else {
                obj9 = new String(obj8);
                obj8 = obj9;
            }
            v.h(str, obj8);
        }

        @Override // com.google.android.exoplayer2.l2.s
        public void e(i1 i1) {
            this.d = i1;
            this.b.e(this.c);
        }

        @Override // com.google.android.exoplayer2.l2.s
        public void f(d0 d0, int i2, int i3) {
            h(obj4 += i2);
            d0.j(this.e, this.f, i2);
            this.f = obj2 += i2;
        }
    }

    private static final class d extends e0 {

        private final Map<String, t> I;
        private t J;
        private d(f f, Looper looper2, v v3, u.a u$a4, Map<String, t> map5) {
            super(f, looper2, v3, a4);
            this.I = map5;
        }

        d(f f, Looper looper2, v v3, u.a u$a4, Map map5, com.google.android.exoplayer2.source.hls.q.a q$a6) {
            super(f, looper2, v3, a4, map5);
        }

        private a X(a a) {
            int i;
            int i3;
            int i2;
            int i4;
            boolean equals;
            String str;
            int i5 = 0;
            if (a == null) {
                return i5;
            }
            final int i7 = a.d();
            i3 = i;
            i2 = -1;
            while (i3 < i7) {
                equals = a.c(i3);
                i3++;
                i2 = -1;
            }
            i3 = i2;
            if (i3 == i2) {
                return a;
            }
            if (i7 == 1) {
                return i5;
            }
            com.google.android.exoplayer2.m2.a.b[] arr = new a.b[i7 + -1];
            while (i < i7) {
                if (i != i3) {
                }
                i++;
                if (i < i3) {
                } else {
                }
                i4 = i + -1;
                arr[i4] = a.c(i);
                i4 = i;
            }
            a obj8 = new a(arr);
            return obj8;
        }

        @Override // com.google.android.exoplayer2.source.e0
        public void Y(t t) {
            this.J = t;
            B();
        }

        @Override // com.google.android.exoplayer2.source.e0
        public void Z(com.google.android.exoplayer2.source.hls.m m) {
            V(m.k);
        }

        @Override // com.google.android.exoplayer2.source.e0
        public void d(long l, int i2, int i3, int i4, s.a s$a5) {
            super.d(l, i2, i3, i4, a5);
        }

        @Override // com.google.android.exoplayer2.source.e0
        public i1 r(i1 i1) {
            t tVar;
            Object obj;
            String str;
            Object tVar2;
            Object obj4;
            if (this.J != null) {
            } else {
                tVar = i1.G;
            }
            obj = this.I.get(tVar.c);
            if (tVar != null && (t)obj != null) {
                obj = this.I.get(tVar.c);
                if ((t)(t)obj != null) {
                    tVar = obj;
                }
            }
            a aVar2 = X(i1.B);
            if (tVar == i1.G) {
                if (aVar2 != i1.B) {
                    obj4 = i1.a();
                    obj4.L(tVar);
                    obj4.X(aVar2);
                    obj4 = obj4.E();
                }
            } else {
            }
            return super.r(obj4);
        }
    }
    static {
        Integer[] arr = new Integer[3];
        int i2 = 1;
        int i4 = 2;
        arr[i2] = Integer.valueOf(i4);
        arr[i4] = 5;
        HashSet hashSet = new HashSet(Arrays.asList(arr));
        q.p0 = Collections.unmodifiableSet(hashSet);
    }

    public q(int i, com.google.android.exoplayer2.source.hls.q.b q$b2, com.google.android.exoplayer2.source.hls.i i3, Map<String, t> map4, f f5, long l6, i1 i17, v v8, u.a u$a9, w w10, z.a z$a11, int i12) {
        super();
        this.a = i;
        this.b = b2;
        this.c = i3;
        this.K = map4;
        this.v = f5;
        this.w = v8;
        this.x = a9;
        this.y = w10;
        this.z = a11;
        this.B = i12;
        this.C = obj13;
        Loader obj1 = new Loader("Loader:HlsSampleStreamWrapper");
        this.A = obj1;
        obj1 = new i.b();
        this.D = obj1;
        obj1 = 0;
        this.N = new int[obj1];
        Set obj3 = q.p0;
        HashSet obj2 = new HashSet(obj3.size());
        this.O = obj2;
        obj2 = new SparseIntArray(obj3.size());
        this.P = obj2;
        this.M = new q.d[obj1];
        this.f0 = new boolean[obj1];
        this.e0 = new boolean[obj1];
        obj1 = new ArrayList();
        this.E = obj1;
        this.F = Collections.unmodifiableList(obj1);
        obj1 = new ArrayList();
        this.J = obj1;
        obj1 = new b(this);
        this.G = obj1;
        obj1 = new a(this);
        this.H = obj1;
        this.I = p0.u();
        this.g0 = l6;
        this.h0 = l6;
    }

    private static h A(int i, int i2) {
        StringBuilder stringBuilder = new StringBuilder(54);
        stringBuilder.append("Unmapped track with id ");
        stringBuilder.append(i);
        stringBuilder.append(" of type ");
        stringBuilder.append(i2);
        v.h("HlsSampleStreamWrapper", stringBuilder.toString());
        h obj2 = new h();
        return obj2;
    }

    private e0 B(int i, int i2) {
        int i4;
        int i3;
        long l;
        int length = objArr.length;
        if (i2 != 1) {
            if (i2 == 2) {
            } else {
                i4 = 0;
            }
        }
        f fVar = this.v;
        super(fVar, this.I.getLooper(), this.x, this.y, this.K, 0);
        dVar2.R(this.g0);
        if (i4 != 0) {
            dVar2.Y(this.n0);
        }
        dVar2.Q(this.m0);
        com.google.android.exoplayer2.source.hls.m mVar = this.o0;
        if (mVar != null) {
            dVar2.Z(mVar);
        }
        dVar2.T(this);
        int i7 = length + 1;
        int[] copyOf = Arrays.copyOf(this.N, i7);
        this.N = copyOf;
        copyOf[length] = i;
        this.M = (q.d[])p0.q0(this.M, dVar2);
        boolean[] obj11 = Arrays.copyOf(this.f0, i7);
        this.f0 = obj11;
        obj11[length] = i4;
        this.d0 = obj11 |= z;
        this.O.add(Integer.valueOf(i2));
        this.P.append(i2, length);
        if (q.K(i2) > q.K(this.R)) {
            this.S = length;
            this.R = i2;
        }
        this.e0 = Arrays.copyOf(this.e0, i7);
        return dVar2;
    }

    private l0 C(k0[] k0Arr) {
        int i;
        k0 k0Var;
        i1[] arr;
        int i2;
        int i3;
        Class cls;
        int i4 = 0;
        i = i4;
        for (Object obj : k0Arr) {
            arr = new i1[obj.a];
            i2 = i4;
            while (i2 < obj.a) {
                i1 i1Var = obj.a(i2);
                arr[i2] = i1Var.b(this.x.d(i1Var));
                i2++;
            }
            k0Var = new k0(arr);
            k0Arr[i] = k0Var;
            i1Var = obj.a(i2);
            arr[i2] = i1Var.b(this.x.d(i1Var));
            i2++;
        }
        l0 l0Var = new l0(k0Arr);
        return l0Var;
    }

    private static i1 D(i1 i1, i1 i12, boolean z3) {
        String str;
        String str2;
        int i;
        a obj7;
        Object obj8;
        int obj9;
        if (i1 == null) {
            return i12;
        }
        int i2 = z.k(i12.D);
        final int i4 = 1;
        if (p0.E(i1.A, i2) == i4) {
            str2 = z.g(p0.F(i1.A, i2));
        } else {
            str = z.d(i1.A, i12.D);
            str2 = i12.D;
        }
        final i1.b bVar = i12.a();
        bVar.S(i1.a);
        bVar.U(i1.b);
        bVar.V(i1.c);
        bVar.g0(i1.v);
        bVar.c0(i1.w);
        int i7 = -1;
        i = z3 ? i1.x : i7;
        bVar.G(i);
        obj9 = z3 ? i1.y : i7;
        bVar.Z(obj9);
        bVar.I(str);
        if (i2 == 2) {
            bVar.j0(i1.I);
            bVar.Q(i1.J);
            bVar.P(i1.K);
        }
        if (str2 != null) {
            bVar.e0(str2);
        }
        obj9 = i1.Q;
        if (obj9 != i7 && i2 == i4) {
            if (i2 == i4) {
                bVar.H(obj9);
            }
        }
        obj7 = i1.B;
        obj8 = i12.B;
        if (obj7 != null && obj8 != null) {
            obj8 = i12.B;
            if (obj8 != null) {
                obj7 = obj8.b(obj7);
            }
            bVar.X(obj7);
        }
        return bVar.E();
    }

    private void E(int i) {
        int size;
        Object obj;
        int i2;
        int obj8;
        g.f(z ^= 1);
        i2 = -1;
        while (obj8 < this.E.size()) {
            obj8++;
            i2 = -1;
        }
        obj8 = i2;
        if (obj8 == i2) {
        }
        if (this.E.isEmpty()) {
            this.h0 = this.g0;
        } else {
            (m)a0.c(this.E).n();
        }
        this.k0 = false;
        this.B.D(this.R, obj8.g, obj4);
    }

    private com.google.android.exoplayer2.source.hls.m F(int i) {
        ArrayList list;
        int size;
        int obj4;
        Object obj = this.E.get(i);
        list = this.E;
        p0.x0(list, i, list.size());
        obj4 = 0;
        while (obj4 < objArr.length) {
            this.M[obj4].p((m)obj.l(obj4));
            obj4++;
        }
        return obj;
    }

    private boolean G(com.google.android.exoplayer2.source.hls.m m) {
        int i;
        boolean z;
        final int i2 = 0;
        i = i2;
        while (i < objArr.length) {
            i++;
        }
        return 1;
    }

    private static boolean H(i1 i1, i1 i12) {
        String equals;
        boolean equals2;
        int i;
        equals = i1.D;
        String str = i12.D;
        final int i2 = z.k(equals);
        final int i3 = 0;
        if (i2 != 3) {
            if (i2 == z.k(str)) {
            } else {
                i = i3;
            }
            return i;
        }
        if (!p0.b(equals, str)) {
            return i3;
        }
        if (!"application/cea-608".equals(equals) && "application/cea-708".equals(equals)) {
            if ("application/cea-708".equals(equals)) {
            }
            return 1;
        }
        if (i1.V == i12.V) {
        } else {
            i = i3;
        }
        return i;
    }

    private com.google.android.exoplayer2.source.hls.m I() {
        ArrayList list = this.E;
        return (m)list.get(size--);
    }

    private s J(int i, int i2) {
        boolean z;
        Object obj4;
        g.a(q.p0.contains(Integer.valueOf(i2)));
        int i4 = -1;
        int i3 = this.P.get(i2, i4);
        if (i3 == i4) {
            return null;
        }
        if (this.O.add(Integer.valueOf(i2))) {
            this.N[i3] = i;
        }
        if (this.N[i3] == i) {
            obj4 = this.M[i3];
        } else {
            obj4 = q.A(i, i2);
        }
        return obj4;
    }

    private static int K(int i) {
        final int i2 = 2;
        final int i3 = 1;
        final int i4 = 3;
        if (i != i3 && i != i2 && i != i4) {
            i4 = 3;
            if (i != i2) {
                if (i != i4) {
                    return 0;
                }
                return i3;
            }
            return i4;
        }
        return i2;
    }

    private void L(com.google.android.exoplayer2.source.hls.m m) {
        int length;
        int i2;
        int i;
        Integer valueOf;
        this.o0 = m;
        this.W = m.d;
        this.h0 = -9223372036854775807L;
        this.E.add(m);
        v.a aVar = v.s();
        com.google.android.exoplayer2.source.hls.q.d[] objArr2 = this.M;
        i = i2;
        while (i < objArr2.length) {
            aVar.d(Integer.valueOf(objArr2[i].z()));
            i++;
        }
        m.m(this, aVar.e());
        com.google.android.exoplayer2.source.hls.q.d[] objArr = this.M;
        while (i2 < objArr.length) {
            length = objArr[i2];
            length.Z(m);
            if (m.n != 0) {
            }
            i2++;
            length.W();
        }
    }

    private static boolean M(b b) {
        return b instanceof m;
    }

    private boolean N() {
        int i;
        i = Long.compare(l, l2) != 0 ? 1 : 0;
        return i;
    }

    public static void P(com.google.android.exoplayer2.source.hls.q q) {
        q.b0();
    }

    public static void Q(com.google.android.exoplayer2.source.hls.q q) {
        q.S();
    }

    @EnsuresNonNull("trackGroupToSampleQueueIndex")
    @RequiresNonNull("trackGroups")
    private void R() {
        int next;
        int i;
        int i2;
        com.google.android.exoplayer2.source.hls.q.d[] objArr;
        int length;
        int i3 = l0Var.a;
        int[] iArr = new int[i3];
        this.b0 = iArr;
        Arrays.fill(iArr, -1);
        next = 0;
        i = next;
        while (i < i3) {
            i2 = next;
            objArr = this.M;
            while (i2 < objArr.length) {
                i1 i1Var = objArr[i2].y();
                g.h(i1Var);
                if (q.H((i1)i1Var, this.Z.a(i).a(next))) {
                    break loop_3;
                } else {
                }
                i2++;
                objArr = this.M;
            }
            i++;
            i1Var = objArr[i2].y();
            g.h(i1Var);
            if (q.H((i1)i1Var, this.Z.a(i).a(next))) {
            } else {
            }
            i2++;
            this.b0[i] = i2;
        }
        Iterator iterator = this.J.iterator();
        for (p next : iterator) {
            next.e();
        }
    }

    private void S() {
        boolean z;
        int length;
        int i;
        i1 i1Var;
        if (!this.Y && this.b0 == null) {
            if (this.b0 == null) {
                if (!this.T) {
                } else {
                    com.google.android.exoplayer2.source.hls.q.d[] objArr = this.M;
                    i = 0;
                    while (i < objArr.length) {
                        i++;
                    }
                    if (this.Z != null) {
                        R();
                    } else {
                        x();
                        k0();
                        this.b.d();
                    }
                }
            }
        }
    }

    private void b0() {
        this.T = true;
        S();
    }

    private void f0() {
        int i;
        com.google.android.exoplayer2.source.hls.q.d dVar;
        boolean z;
        final com.google.android.exoplayer2.source.hls.q.d[] objArr = this.M;
        final int i2 = 0;
        i = i2;
        while (i < objArr.length) {
            objArr[i].N(this.i0);
            i++;
        }
        this.i0 = i2;
    }

    private boolean g0(long l) {
        int i;
        boolean z;
        final int i2 = 0;
        i = i2;
        while (i < objArr.length) {
            i++;
        }
        return 1;
    }

    @RequiresNonNull({"trackGroups", "optionalTrackGroups"})
    private void k0() {
        this.U = true;
    }

    private void p0(f0[] f0Arr) {
        int i;
        Object obj;
        ArrayList list;
        this.J.clear();
        i = 0;
        while (i < f0Arr.length) {
            obj = f0Arr[i];
            if (obj != null) {
            }
            i++;
            this.J.add((p)obj);
        }
    }

    @EnsuresNonNull({"trackGroups", "optionalTrackGroups"})
    private void v() {
        g.f(this.U);
        g.e(this.Z);
        g.e(this.a0);
    }

    @EnsuresNonNull({"trackGroups", "optionalTrackGroups", "trackGroupToSampleQueueIndex"})
    private void x() {
        int i3;
        int i4;
        int i7;
        int i9;
        int i5;
        int i8;
        int i2;
        int i;
        int i6;
        boolean k0Var2;
        i1 i1Var;
        i1[] arr;
        i1 k0Var;
        i1[] arr2;
        int length = objArr.length;
        int i10 = 7;
        int i11 = -1;
        i4 = 0;
        i9 = i10;
        i5 = i11;
        i7 = i4;
        int i13 = 1;
        while (i7 < length) {
            i1 i1Var2 = this.M[i7].y();
            g.h(i1Var2);
            String str = i1Var2.D;
            if (z.q(str)) {
            } else {
            }
            if (z.o(str)) {
            } else {
            }
            if (z.p(str)) {
            } else {
            }
            i8 = i10;
            if (q.K(i8) > q.K(i9)) {
            } else {
            }
            if (i8 == i9 && i5 != i11) {
            }
            i7++;
            i13 = 1;
            if (i5 != i11) {
            }
            i5 = i11;
            i5 = i7;
            i9 = i8;
            i8 = 3;
            i8 = i13;
        }
        k0 k0Var3 = this.c.i();
        int i12 = k0Var3.a;
        this.c0 = i11;
        this.b0 = new int[length];
        i3 = i4;
        while (i3 < length) {
            this.b0[i3] = i3;
            i3++;
        }
        k0[] arr3 = new k0[length];
        i6 = i4;
        while (i6 < length) {
            i1Var = this.M[i6].y();
            g.h(i1Var);
            if (i6 == i5) {
            } else {
            }
            if (i9 == 2 && z.o(i1Var.D)) {
            } else {
            }
            arr = 0;
            arr2 = new i1[i13];
            arr2[i4] = q.D(arr, (i1)i1Var, i4);
            k0Var = new k0(arr2);
            arr3[i6] = k0Var;
            i6++;
            if (z.o(i1Var.D)) {
            } else {
            }
            arr = this.w;
            arr = new i1[i12];
            if (i12 == i13) {
            } else {
            }
            k0Var = i4;
            while (k0Var < i12) {
                arr[k0Var] = q.D(k0Var3.a(k0Var), i1Var, i13);
                k0Var++;
            }
            k0Var2 = new k0(arr);
            arr3[i6] = k0Var2;
            this.c0 = i6;
            arr[k0Var] = q.D(k0Var3.a(k0Var), i1Var, i13);
            k0Var++;
            arr[i4] = i1Var.e(k0Var3.a(i4));
        }
        this.Z = C(arr3);
        if (this.a0 == null) {
            i4 = i13;
        }
        g.f(i4);
        this.a0 = Collections.emptySet();
    }

    private boolean y(int i) {
        int i3;
        int i2;
        boolean z;
        int size;
        int i4;
        int i5;
        i3 = i;
        i4 = 0;
        while (i3 < this.E.size()) {
            i3++;
            i4 = 0;
        }
        i2 = i4;
        while (i2 < objArr.length) {
            i2++;
        }
        return 1;
    }

    @Override // com.google.android.exoplayer2.upstream.Loader$b
    public boolean O(int i) {
        boolean z;
        int obj2;
        if (!N() && this.M[i].C(this.k0)) {
            obj2 = this.M[i].C(this.k0) ? 1 : 0;
        } else {
        }
        return obj2;
    }

    @Override // com.google.android.exoplayer2.upstream.Loader$b
    public void T() {
        this.A.j();
        this.c.m();
    }

    @Override // com.google.android.exoplayer2.upstream.Loader$b
    public void U(int i) {
        T();
        this.M[i].F();
    }

    @Override // com.google.android.exoplayer2.upstream.Loader$b
    public void V(b b, long l2, long l3, boolean z4) {
        boolean z;
        Object obj;
        final Object obj2 = this;
        obj = b;
        obj2.L = 0;
        final long l9 = b.c();
        final long l7 = z4;
        super(obj.a, obj5, obj.b, b.f(), b.e(), l2, obj10, l7, obj12, l9, obj14);
        obj2.z.c(obj.a);
        obj2.B.r(sVar, obj.c, obj2.a, obj.d, obj.e, obj.f, obj.g, l7);
        if (obj21 == null) {
            if (!N()) {
                if (obj2.V == 0) {
                    f0();
                }
            } else {
            }
            if (obj2.V > 0) {
                obj2.b.i(this);
            }
        }
    }

    @Override // com.google.android.exoplayer2.upstream.Loader$b
    public void W(b b, long l2, long l3) {
        long l;
        final Object obj = this;
        b bVar = b;
        obj.L = 0;
        obj.c.o(bVar);
        final long l10 = b.c();
        final long l8 = obj19;
        super(bVar.a, obj5, bVar.b, b.f(), b.e(), l2, obj10, l8, obj12, l10, obj14);
        obj.z.c(bVar.a);
        obj.B.u(sVar, bVar.c, obj.a, bVar.d, bVar.e, bVar.f, bVar.g, l8);
        if (!obj.U) {
            b(obj.g0);
        } else {
            obj.b.i(this);
        }
    }

    @Override // com.google.android.exoplayer2.upstream.Loader$b
    public Loader.c X(b b, long l2, long l3, IOException iOException4, int i5) {
        Object obj;
        boolean cmp2;
        Loader.c cVar;
        Object aVar;
        boolean responseCode;
        long l;
        s sVar;
        int cmp;
        com.google.android.exoplayer2.upstream.w.b bVar;
        int i;
        i1 i1Var;
        int i2;
        int i3;
        final Object obj2 = this;
        obj = b;
        Object obj8 = obj36;
        cmp2 = q.M(b);
        responseCode = obj4.responseCode;
        if (cmp2 && !(m)obj.q() && obj8 instanceof HttpDataSource.InvalidResponseCodeException != null && responseCode != 410 && responseCode == 404) {
            if (!(m)obj.q()) {
                if (obj8 instanceof HttpDataSource.InvalidResponseCodeException != null) {
                    responseCode = obj4.responseCode;
                    if (responseCode != 410) {
                        if (responseCode == 404) {
                        }
                    }
                    return Loader.d;
                }
            }
        }
        l = b.c();
        long l12 = l5;
        super(l12, obj16, obj.b, b.f(), b.e(), l2, obj21, iOException4, obj23, l, obj25);
        Object obj7 = obj.f;
        super(obj.c, obj2.a, obj.d, obj.e, obj7, w0.e(obj.g), obj27, w0.e(obj.h), obj29);
        w.c cVar3 = new w.c(sVar2, vVar, obj8, obj37);
        bVar = obj2.z.b(m.a(obj2.c.j()), cVar3);
        i = 0;
        if (bVar != null && bVar.a == 2) {
            if (bVar.a == 2) {
                i3 = bVar;
            } else {
                i3 = i;
            }
        } else {
        }
        int i8 = 1;
        if (i3 != 0) {
            ArrayList list = obj2.E;
            if (cmp2 && Long.compare(l, i1Var) == 0 && (m)list.remove(size -= i8) == obj) {
                if (Long.compare(l, i1Var) == 0) {
                    list = obj2.E;
                    if ((m)list.remove(size -= i8) == obj) {
                        i = i8;
                    }
                    g.f(i);
                    if (obj2.E.isEmpty()) {
                        obj2.h0 = obj2.g0;
                    } else {
                        (m)a0.c(obj2.E).n();
                    }
                }
            }
            cVar = Loader.e;
        } else {
            long l4 = obj2.z.a(cVar3);
            if (Long.compare(l4, i1Var) != 0) {
                cVar = Loader.g(i, l4);
            } else {
                cVar = Loader.f;
            }
        }
        final Loader.c cVar4 = cVar;
        int i16 = z2 ^ 1;
        int i6 = obj.c;
        long l7 = obj.g;
        final long l9 = obj.h;
        obj2.B.w(sVar2, i6, obj2.a, obj.d, obj.e, obj.f, l7, l7, l9, l9);
        if (i16 != 0) {
            obj2.L = 0;
            obj2.z.c(obj.a);
        }
        if (i3 != 0) {
            if (!obj2.U) {
                obj2.b(obj2.g0);
            } else {
                obj2.b.i(obj2);
            }
        }
        return cVar4;
    }

    @Override // com.google.android.exoplayer2.upstream.Loader$b
    public void Y() {
        this.O.clear();
    }

    @Override // com.google.android.exoplayer2.upstream.Loader$b
    public boolean Z(Uri uri, w.c w$c2, boolean z3) {
        int z;
        int i;
        boolean obj5;
        long obj6;
        int obj7;
        if (!this.c.n(uri)) {
            return 1;
        }
        final long l = -9223372036854775807L;
        obj6 = this.z.b(m.a(this.c.j()), c2);
        if (z3 == null && obj6 != null && obj6.a == 2) {
            obj6 = this.z.b(m.a(this.c.j()), c2);
            if (obj6 != null) {
                obj6 = obj6.a == 2 ? obj6.b : l;
            } else {
            }
        } else {
        }
        if (this.c.p(uri, obj6) && Long.compare(obj6, l) != 0) {
            if (Long.compare(obj6, l) != 0) {
            } else {
                i = 0;
            }
        } else {
        }
        return i;
    }

    @Override // com.google.android.exoplayer2.upstream.Loader$b
    public long a() {
        long l;
        if (N()) {
            return this.h0;
        }
        if (this.k0) {
            l = Long.MIN_VALUE;
        } else {
            l = mVar.h;
        }
        return l;
    }

    @Override // com.google.android.exoplayer2.upstream.Loader$b
    public void a0() {
        Object obj;
        if (this.E.isEmpty()) {
        }
        obj = a0.c(this.E);
        int i = this.c.b((m)obj);
        if (i == 1) {
            obj.v();
        } else {
            if (i == 2 && !this.k0 && this.A.i()) {
                if (!this.k0) {
                    if (this.A.i()) {
                        this.A.e();
                    }
                }
            }
        }
    }

    @Override // com.google.android.exoplayer2.upstream.Loader$b
    public boolean b(long l) {
        boolean z;
        List emptyList;
        boolean empty;
        boolean z2;
        long l2;
        int i;
        boolean z3;
        com.google.android.exoplayer2.source.hls.q.d[] objArr;
        int length;
        int i3;
        com.google.android.exoplayer2.source.hls.q.d dVar;
        boolean z4;
        int i2;
        final Object obj = this;
        int i4 = 0;
        if (!obj.k0 && !obj.A.i()) {
            if (!obj.A.i()) {
                if (obj.A.h()) {
                } else {
                    if (N()) {
                        emptyList = Collections.emptyList();
                        l2 = obj.h0;
                        objArr = obj.M;
                        i3 = i4;
                        while (i3 < objArr.length) {
                            objArr[i3].R(obj.h0);
                            i3++;
                        }
                    } else {
                        emptyList = obj.F;
                        com.google.android.exoplayer2.source.hls.m mVar = I();
                        if (mVar.p()) {
                            l2 = mVar.h;
                        } else {
                            l2 = Math.max(obj.g0, obj5);
                        }
                    }
                    List list = emptyList;
                    long l7 = l2;
                    obj.D.a();
                    i = 1;
                    if (!obj.U) {
                        if (!list.isEmpty()) {
                            i2 = i;
                        } else {
                            i2 = i4;
                        }
                    } else {
                    }
                    obj.c.d(l, i3, l7, z4, list);
                    com.google.android.exoplayer2.source.hls.i.b bVar2 = obj.D;
                    b bVar3 = bVar2.a;
                    Uri uri = bVar2.c;
                    if (bVar2.b) {
                        obj.h0 = -9223372036854775807L;
                        obj.k0 = i;
                        return i;
                    }
                    if (bVar3 == null && uri != null) {
                        if (uri != null) {
                            obj.b.j(uri);
                        }
                        return i4;
                    }
                    if (q.M(bVar3)) {
                        obj.L((m)bVar3);
                    }
                }
                obj.L = bVar3;
                super(bVar3.a, l7, bVar3.b, obj.A.n(bVar3, obj, obj.z.d(bVar3.c)), i2);
                obj.B.A(sVar2, bVar3.c, obj.a, bVar3.d, bVar3.e, bVar3.f, bVar3.g, obj20);
                return i;
            }
        }
        return i4;
    }

    @Override // com.google.android.exoplayer2.upstream.Loader$b
    public boolean c() {
        return this.A.i();
    }

    @Override // com.google.android.exoplayer2.upstream.Loader$b
    public void c0(k0[] k0Arr, int i2, int... i3Arr3) {
        int i;
        k0 k0Var;
        Set set;
        l0 l0Var;
        this.Z = C(k0Arr);
        HashSet obj5 = new HashSet();
        this.a0 = obj5;
        i = 0;
        while (i < i3Arr3.length) {
            this.a0.add(this.Z.a(i3Arr3[i]));
            i++;
        }
        this.c0 = i2;
        final com.google.android.exoplayer2.source.hls.q.b obj6 = this.b;
        Objects.requireNonNull(obj6);
        c obj7 = new c(obj6);
        this.I.post(obj7);
        k0();
    }

    @Override // com.google.android.exoplayer2.upstream.Loader$b
    public void d(q q) {
    }

    @Override // com.google.android.exoplayer2.upstream.Loader$b
    public int d0(int i, j1 j12, DecoderInputBuffer decoderInputBuffer3, int i4) {
        int i5;
        boolean empty;
        boolean empty2;
        int size;
        int i3;
        boolean equals;
        int i6;
        i1 i1Var;
        int i2;
        Object obj;
        long l;
        i1 i1Var2;
        int obj12;
        i1 obj15;
        int i7 = -3;
        if (N()) {
            return i7;
        }
        i3 = 0;
        if (!this.E.isEmpty()) {
            i5 = i3;
            while (i5 < size2--) {
                if (G((m)this.E.get(i5))) {
                }
                i5++;
            }
            p0.x0(this.E, i3, i5);
            empty = this.E.get(i3);
            i1Var2 = empty.d;
            if (!i1Var2.equals(this.X)) {
                this.B.c(this.a, i1Var2, empty.e, empty.f, empty.g);
            }
            this.X = i1Var2;
        }
        if (!this.E.isEmpty() && !(m)this.E.get(i3).q()) {
            if (!(m)this.E.get(i3).q()) {
                return i7;
            }
        }
        final int obj14 = this.M[i].K(j12, decoderInputBuffer3, i4, this.k0);
        obj15 = j12.b;
        g.e(obj15);
        if (obj14 == -5 && i == this.S) {
            obj15 = j12.b;
            g.e((i1)obj15);
            if (i == this.S) {
                while (i3 < this.E.size()) {
                    if (obj3.k != this.M[i].I()) {
                    }
                    i3++;
                }
                if (i3 < this.E.size()) {
                    obj12 = obj12.d;
                } else {
                    g.e(this.W);
                }
                obj15 = (i1)obj15.e(obj12);
            }
            j12.b = obj15;
        }
        return obj14;
    }

    @Override // com.google.android.exoplayer2.upstream.Loader$b
    public long e() {
        long l;
        Object mVar;
        boolean z;
        int length;
        int i;
        long l2;
        if (this.k0) {
            return Long.MIN_VALUE;
        }
        if (N()) {
            return this.h0;
        }
        if (I().p()) {
        } else {
            if (this.E.size() > 1) {
                ArrayList list2 = this.E;
                mVar = list2.get(size2 += -2);
            } else {
                mVar = 0;
            }
        }
        if (mVar != null) {
            l = Math.max(this.g0, obj1);
        }
        if (this.T) {
            z = this.M;
            i = 0;
            while (i < z.length) {
                l = Math.max(l, obj1);
                i++;
            }
        }
        return l;
    }

    @Override // com.google.android.exoplayer2.upstream.Loader$b
    public void e0() {
        boolean z;
        int length;
        int i;
        com.google.android.exoplayer2.source.hls.q.d dVar;
        if (this.U) {
            z = this.M;
            i = 0;
            while (i < z.length) {
                z[i].J();
                i++;
            }
        }
        this.A.m(this);
        this.I.removeCallbacksAndMessages(0);
        this.Y = true;
        this.J.clear();
    }

    @Override // com.google.android.exoplayer2.upstream.Loader$b
    public void f(long l) {
        int size;
        boolean z;
        List list;
        int i2;
        int i;
        boolean obj5;
        b obj6;
        if (!this.A.h()) {
            if (N()) {
            } else {
                g.e(this.L);
                if (this.A.i() && this.c.u(l, obj6, this.L)) {
                    g.e(this.L);
                    if (this.c.u(l, obj6, this.L)) {
                        this.A.e();
                    }
                }
                size = this.F.size();
                while (size > 0) {
                    if (this.c.b((m)this.F.get(size + -1)) == 2) {
                    }
                    size--;
                }
                if (size < this.F.size()) {
                    E(size);
                }
                obj5 = this.c.g(l, obj6);
                if (obj5 < this.E.size()) {
                    E(obj5);
                }
            }
        }
    }

    @Override // com.google.android.exoplayer2.upstream.Loader$b
    public void g() {
        int i;
        com.google.android.exoplayer2.source.hls.q.d dVar;
        final com.google.android.exoplayer2.source.hls.q.d[] objArr = this.M;
        i = 0;
        while (i < objArr.length) {
            objArr[i].L();
            i++;
        }
    }

    @Override // com.google.android.exoplayer2.upstream.Loader$b
    public void h(Loader.e loader$e, long l2, long l3, boolean z4) {
        V((b)e, l2, l3, z4);
    }

    @Override // com.google.android.exoplayer2.upstream.Loader$b
    public boolean h0(long l, boolean z2) {
        int i;
        boolean obj4;
        int obj5;
        boolean obj6;
        this.g0 = l;
        final int i2 = 1;
        if (N()) {
            this.h0 = l;
            return i2;
        }
        i = 0;
        if (this.T && obj6 == null && g0(l)) {
            if (obj6 == null) {
                if (g0(l)) {
                    return i;
                }
            }
        }
        this.h0 = l;
        this.k0 = i;
        this.E.clear();
        if (this.A.i()) {
            if (this.T) {
                obj4 = this.M;
                while (i < obj4.length) {
                    obj4[i].n();
                    i++;
                }
            }
            this.A.e();
        } else {
            this.A.f();
            f0();
        }
        return i2;
    }

    @Override // com.google.android.exoplayer2.upstream.Loader$b
    public void i(i1 i1) {
        this.I.post(this.G);
    }

    @Override // com.google.android.exoplayer2.upstream.Loader$b
    public boolean i0(g[] gArr, boolean[] z2Arr2, f0[] f03Arr3, boolean[] z4Arr4, long l5, boolean z6) {
        boolean z2;
        boolean length3;
        boolean empty;
        boolean z;
        int i3;
        int length2;
        int i;
        int cmp;
        int i9;
        g gVar3;
        Object obj;
        int length;
        com.google.android.exoplayer2.source.hls.q.d dVar;
        int i5;
        int i4;
        int i6;
        List list;
        g gVar;
        int i7;
        int i2;
        int i8;
        com.google.android.exoplayer2.source.m0.e[] objArr;
        g gVar2;
        final Object obj2 = this;
        Object[] objArr2 = gArr;
        final int[] iArr = f03Arr3;
        final long l2 = l5;
        v();
        i7 = 0;
        i9 = i7;
        i5 = 0;
        i2 = 1;
        while (i9 < objArr2.length) {
            obj = iArr[i9];
            if ((p)obj != null) {
            }
            i9++;
            i5 = 0;
            i2 = 1;
            if (objArr2[i9] != null) {
            } else {
            }
            obj2.V = i13 -= i2;
            (p)obj.g();
            iArr[i9] = i5;
            if (!z2Arr2[i9]) {
            }
        }
        if (obj26 == null) {
            if (obj2.j0) {
                if (obj2.V == 0) {
                    i3 = i2;
                } else {
                    i3 = i7;
                }
            } else {
                if (Long.compare(l2, l) != 0) {
                } else {
                }
            }
        } else {
        }
        gVar3 = obj2.c.j();
        i8 = i3;
        gVar = gVar3;
        length2 = i7;
        int length4 = objArr2.length;
        while (length2 < length4) {
            length = objArr2[length2];
            if (length == null) {
            } else {
            }
            i4 = obj2.Z.b(length.a());
            if (i4 == obj2.c0) {
            }
            obj2.V = i11 += i2;
            p pVar = new p(obj2, i4);
            iArr[length2] = pVar;
            z4Arr4[length2] = i2;
            (p)iArr[length2].e();
            if (iArr[length2] == 0 && obj2.b0 != null && i8 == 0) {
            }
            length2++;
            length4 = objArr2.length;
            obj2.V = i11 += i2;
            pVar = new p(obj2, i4);
            iArr[length2] = pVar;
            z4Arr4[length2] = i2;
            if (obj2.b0 != null) {
            }
            (p)iArr[length2].e();
            if (i8 == 0) {
            }
            dVar = obj2.M[obj2.b0[i4]];
            if (!dVar.P(l2, obj13) && dVar.v() != 0) {
            } else {
            }
            length = i7;
            i8 = length;
            if (dVar.v() != 0) {
            } else {
            }
            length = i2;
            obj2.c.t(length);
            gVar = length;
        }
        if (obj2.V == 0) {
            obj2.c.q();
            obj2.X = i5;
            obj2.i0 = i2;
            obj2.E.clear();
            if (obj2.A.i()) {
                if (obj2.T) {
                    z2 = obj2.M;
                    while (i7 < z2.length) {
                        z2[i7].n();
                        i7++;
                    }
                }
                obj2.A.e();
            } else {
                f0();
            }
        } else {
            if (!obj2.E.isEmpty() && !p0.b(gVar, gVar3)) {
                if (!p0.b(gVar, gVar3)) {
                    if (!obj2.j0) {
                        if (Long.compare(l2, i) < 0) {
                            i = -l2;
                        }
                        com.google.android.exoplayer2.source.hls.m mVar = I();
                        gVar.l(l5, length4, i, i4, -9223372036854775807L);
                        if (gVar.m() != obj2.c.i().b(mVar.d)) {
                            empty = i2;
                        } else {
                            empty = i7;
                        }
                    } else {
                    }
                    if (empty != 0) {
                        obj2.i0 = i2;
                        i8 = length3;
                    } else {
                        length3 = obj26;
                    }
                } else {
                }
            } else {
            }
            if (i8 != 0) {
                obj2.h0(l2, obj13);
                while (i7 < iArr.length) {
                    if (iArr[i7] != 0) {
                    }
                    i7++;
                    z4Arr4[i7] = i2;
                }
            }
        }
        obj2.p0(iArr);
        obj2.j0 = i2;
        return i8;
    }

    @Override // com.google.android.exoplayer2.upstream.Loader$b
    public void j(Loader.e loader$e, long l2, long l3) {
        W((b)e, l2, l3);
    }

    @Override // com.google.android.exoplayer2.upstream.Loader$b
    public void j0(t t) {
        int z;
        com.google.android.exoplayer2.source.hls.q.d[] objArr;
        boolean length;
        if (!p0.b(this.n0, t)) {
            this.n0 = t;
            z = 0;
            objArr = this.M;
            for (Object objArr : obj1) {
                if (this.f0[z]) {
                }
                objArr = this.M;
                objArr.Y(t);
            }
        }
    }

    @Override // com.google.android.exoplayer2.upstream.Loader$b
    public void k() {
        boolean z;
        T();
        if (this.k0) {
            if (!this.U) {
            } else {
            }
            throw ParserException.a("Loading finished before preparation is complete.", 0);
        }
    }

    @Override // com.google.android.exoplayer2.upstream.Loader$b
    public void l0(boolean z) {
        this.c.s(z);
    }

    @Override // com.google.android.exoplayer2.upstream.Loader$b
    public void m0(long l) {
        int cmp;
        int length;
        int i;
        com.google.android.exoplayer2.source.hls.q.d dVar;
        if (Long.compare(l2, l) != 0) {
            this.m0 = l;
            cmp = this.M;
            i = 0;
            while (i < cmp.length) {
                cmp[i].Q(l);
                i++;
            }
        }
    }

    @Override // com.google.android.exoplayer2.upstream.Loader$b
    public void n() {
        this.l0 = true;
        this.I.post(this.H);
    }

    @Override // com.google.android.exoplayer2.upstream.Loader$b
    public int n0(int i, long l2) {
        int i2;
        int obj3;
        int obj4;
        if (N()) {
            return 0;
        }
        com.google.android.exoplayer2.source.hls.q.d dVar = this.M[i];
        Object obj5 = a0.d(this.E, 0);
        if (obj5 != null && !(m)obj5.q()) {
            if (!obj5.q()) {
                obj4 = Math.min(dVar.x(l2, obj5), obj3 -= i2);
            }
        }
        dVar.U(obj4);
        return obj4;
    }

    @Override // com.google.android.exoplayer2.upstream.Loader$b
    public void o0(int i) {
        v();
        g.e(this.b0);
        final int obj3 = this.b0[i];
        g.f(this.e0[obj3]);
        this.e0[obj3] = 0;
    }

    @Override // com.google.android.exoplayer2.upstream.Loader$b
    public l0 r() {
        v();
        return this.Z;
    }

    @Override // com.google.android.exoplayer2.upstream.Loader$b
    public Loader.c s(Loader.e loader$e, long l2, long l3, IOException iOException4, int i5) {
        return X((b)e, l2, l3, iOException4, i5);
    }

    @Override // com.google.android.exoplayer2.upstream.Loader$b
    public s t(int i, int i2) {
        int i3;
        s sVar;
        Integer valueOf;
        int length;
        s obj4;
        int obj5;
        if (q.p0.contains(Integer.valueOf(i2))) {
            sVar = J(i, i2);
        } else {
            i3 = 0;
            valueOf = this.M;
            while (i3 < valueOf.length) {
                i3++;
                valueOf = this.M;
            }
            sVar = 0;
        }
        if (sVar == null && this.l0) {
            if (this.l0) {
                return q.A(i, i2);
            }
            sVar = B(i, i2);
        }
        if (i2 == 5 && this.Q == null) {
            if (this.Q == null) {
                obj4 = new q.c(sVar, this.C);
                this.Q = obj4;
            }
            return this.Q;
        }
        return sVar;
    }

    @Override // com.google.android.exoplayer2.upstream.Loader$b
    public void u(long l, boolean z2) {
        boolean length;
        int i;
        com.google.android.exoplayer2.source.hls.q.d dVar;
        boolean z;
        if (this.T) {
            if (N()) {
            } else {
                i = 0;
                while (i < objArr.length) {
                    this.M[i].m(l, z2, obj7);
                    i++;
                }
            }
        }
    }

    @Override // com.google.android.exoplayer2.upstream.Loader$b
    public int w(int i) {
        int i2;
        v();
        g.e(this.b0);
        int i3 = this.b0[i];
        if (i3 == -1 && this.a0.contains(this.Z.a(i))) {
            if (this.a0.contains(this.Z.a(i))) {
                i2 = -3;
            }
            return i2;
        }
        boolean[] obj4 = this.e0;
        if (obj4[i3]) {
            return -2;
        }
        obj4[i3] = 1;
        return i3;
    }

    @Override // com.google.android.exoplayer2.upstream.Loader$b
    public void z() {
        boolean z;
        if (!this.U) {
            b(this.g0);
        }
    }
}
