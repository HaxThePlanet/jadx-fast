package com.google.android.exoplayer2.source;

import android.os.Looper;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2.decoder.a;
import com.google.android.exoplayer2.drm.DrmSession;
import com.google.android.exoplayer2.drm.u.a;
import com.google.android.exoplayer2.drm.v;
import com.google.android.exoplayer2.drm.v.b;
import com.google.android.exoplayer2.i1;
import com.google.android.exoplayer2.i1.b;
import com.google.android.exoplayer2.j1;
import com.google.android.exoplayer2.l2.s;
import com.google.android.exoplayer2.l2.s.a;
import com.google.android.exoplayer2.upstream.f;
import com.google.android.exoplayer2.upstream.i;
import com.google.android.exoplayer2.util.d0;
import com.google.android.exoplayer2.util.g;
import com.google.android.exoplayer2.util.p0;
import com.google.android.exoplayer2.util.v;
import com.google.android.exoplayer2.util.z;

/* loaded from: classes2.dex */
public class e0 implements s {

    private boolean A;
    private i1 B;
    private i1 C;
    private int D;
    private boolean E;
    private boolean F;
    private long G;
    private boolean H;
    private final com.google.android.exoplayer2.source.d0 a;
    private final com.google.android.exoplayer2.source.e0.b b;
    private final com.google.android.exoplayer2.source.j0<com.google.android.exoplayer2.source.e0.c> c;
    private final v d;
    private final u.a e;
    private final Looper f;
    private com.google.android.exoplayer2.source.e0.d g;
    private i1 h;
    private DrmSession i;
    private int j = 1000;
    private int[] k;
    private long[] l;
    private int[] m;
    private int[] n;
    private long[] o;
    private s.a[] p;
    private int q;
    private int r;
    private int s;
    private int t;
    private long u = Long.MIN_VALUE;
    private long v = Long.MIN_VALUE;
    private long w = Long.MIN_VALUE;
    private boolean x;
    private boolean y = true;
    private boolean z = true;

    static class a {
    }

    static final class b {

        public int a;
        public long b;
        public s.a c;
    }

    private static final class c {

        public final i1 a;
        public final v.b b;
        private c(i1 i1, v.b v$b2) {
            super();
            this.a = i1;
            this.b = b2;
        }

        c(i1 i1, v.b v$b2, com.google.android.exoplayer2.source.e0.a e0$a3) {
            super(i1, b2);
        }
    }

    public interface d {
        public abstract void i(i1 i1);
    }
    protected e0(f f, Looper looper2, v v3, u.a u$a4) {
        super();
        this.f = looper2;
        this.d = v3;
        this.e = a4;
        d0 obj2 = new d0(f);
        this.a = obj2;
        e0.b obj1 = new e0.b();
        this.b = obj1;
        obj1 = 1000;
        this.k = new int[obj1];
        this.l = new long[obj1];
        this.o = new long[obj1];
        this.n = new int[obj1];
        this.m = new int[obj1];
        this.p = new s.a[obj1];
        obj1 = new j0(i.a);
        this.c = obj1;
        obj1 = Long.MIN_VALUE;
        obj1 = 1;
    }

    private boolean A() {
        int i;
        i = this.t != this.q ? 1 : 0;
        return i;
    }

    static void D(com.google.android.exoplayer2.source.e0.c e0$c) {
        c.b.a();
    }

    private boolean E(int i) {
        DrmSession state;
        int i2;
        int obj3;
        state = this.i;
        if (state != null && state.getState() != 4) {
            if (state.getState() != 4) {
                if (obj3 &= state == 0 && this.i.e()) {
                    if (this.i.e()) {
                        obj3 = 1;
                    } else {
                        obj3 = 0;
                    }
                } else {
                }
            } else {
            }
        } else {
        }
        return obj3;
    }

    private void G(i1 i1, j1 j12) {
        int i2;
        int i;
        i1 i1Var;
        Object obj5;
        i1 i1Var2 = this.h;
        i = i1Var2 == null ? 1 : 0;
        i2 = i != 0 ? 0 : i1Var2.G;
        this.h = i1;
        v vVar2 = this.d;
        if (vVar2 != null) {
            i1Var = i1.b(vVar2.d(i1));
        } else {
            i1Var = i1;
        }
        j12.b = i1Var;
        j12.a = this.i;
        if (this.d == null) {
        }
        if (i == 0 && p0.b(i2, i1.G)) {
            if (p0.b(i2, tVar)) {
            }
        }
        DrmSession drmSession = this.i;
        Looper looper = this.f;
        g.e(looper);
        obj5 = this.d.c((Looper)looper, this.e, i1);
        this.i = obj5;
        j12.a = obj5;
        if (drmSession != null) {
            drmSession.b(this.e);
        }
    }

    private int H(j1 j1, DecoderInputBuffer decoderInputBuffer2, boolean z3, boolean z4, com.google.android.exoplayer2.source.e0.b e0$b5) {
        i1 obj7;
        boolean obj8;
        decoderInputBuffer2.v = false;
        final int i3 = -5;
        final int i4 = -3;
        final int i5 = -4;
        synchronized (this) {
            if (!z4) {
                try {
                    if (this.x) {
                    } else {
                    }
                    i1 obj6 = this.C;
                    if (obj6 != null && z3 == null && obj6 != this.h) {
                    }
                    if (z3 == null) {
                    }
                    if (obj6 != this.h) {
                    }
                    g.e(obj6);
                    G((i1)obj6, j1);
                    return i3;
                    return i4;
                    decoderInputBuffer2.r(4);
                    return i5;
                    obj8 = obj8.a;
                    if (z3 == null) {
                    }
                    if (obj8 != this.h) {
                    } else {
                    }
                    int obj5 = w(this.t);
                    if (!E(obj5)) {
                    }
                    decoderInputBuffer2.v = true;
                    return i4;
                    decoderInputBuffer2.r(this.n[obj5]);
                    long l = this.o[obj5];
                    decoderInputBuffer2.w = l;
                    if (Long.compare(l, obj7) < 0) {
                    }
                    decoderInputBuffer2.i(Integer.MIN_VALUE);
                    b5.a = this.m[obj5];
                    b5.b = this.l[obj5];
                    b5.c = this.p[obj5];
                    return i5;
                    G(obj8, j1);
                    return i3;
                    throw j1;
                }
            }
        }
    }

    private void M() {
        DrmSession drmSession;
        u.a aVar;
        drmSession = this.i;
        if (drmSession != null) {
            drmSession.b(this.e);
            drmSession = 0;
            this.i = drmSession;
            this.h = drmSession;
        }
    }

    private void O() {
        this.t = 0;
        this.a.o();
        return;
        synchronized (this) {
            this.t = 0;
            this.a.o();
        }
    }

    private boolean S(i1 i1) {
        boolean equals;
        Object obj3;
        final int i = 0;
        this.z = i;
        synchronized (this) {
            return i;
        }
    }

    private boolean g(long l) {
        int i;
        final int i3 = 0;
        synchronized (this) {
            try {
                if (Long.compare(l, l3) > 0) {
                } else {
                }
                i = i3;
                return i;
                if (Long.compare(l2, l) >= 0) {
                }
                return i3;
                o(obj7 += obj6);
                return 1;
                throw l;
            }
        }
    }

    private void h(long l, int i2, long l3, int i4, s.a s$a5) {
        int i;
        int i6;
        int arr;
        int i5;
        int[] iArr;
        long[] lArr;
        int i3;
        long l2;
        boolean obj9;
        Object obj10;
        int obj11;
        int obj12;
        i1 obj13;
        int obj14;
        s.a obj15;
        i = this.q;
        i5 = 1;
        final int i14 = 0;
        synchronized (this) {
            try {
                int i8 = w(i -= i5);
                if (Long.compare(i3, i4) <= 0) {
                } else {
                }
                i = i5;
                i = i14;
                g.a(i);
                if (i10 &= l3 != 0) {
                } else {
                }
                i6 = i5;
                i6 = i14;
                this.x = i6;
                this.w = Math.max(this.w, i3);
                arr = w(this.q);
                this.o[arr] = l;
                this.l[arr] = i4;
                this.m[arr] = obj14;
                this.n[arr] = l3;
                this.p[arr] = obj15;
                this.k[arr] = this.D;
                if (!this.c.g()) {
                } else {
                }
                if (!obj9.a.equals(this.C)) {
                }
                obj9 = this.d;
                if (obj9 != null) {
                } else {
                }
                obj10 = this.f;
                g.e(obj10);
                obj9 = obj9.b((Looper)obj10, this.e, this.C);
                obj9 = v.b.a;
                obj13 = this.C;
                g.e(obj13);
                obj12 = new e0.c((i1)obj13, obj9, 0);
                this.c.a(z(), obj12);
                obj9 += i5;
                this.q = obj9;
                obj10 = this.j;
                if (obj9 == obj10) {
                }
                obj9 = obj10 + 1000;
                obj11 = new int[obj9];
                obj12 = new long[obj9];
                obj13 = new long[obj9];
                obj14 = new int[obj9];
                obj15 = new int[obj9];
                arr = new s.a[obj9];
                int i13 = this.s;
                obj10 -= i13;
                System.arraycopy(this.l, i13, obj12, i14, obj10);
                System.arraycopy(this.o, this.s, obj13, i14, obj10);
                System.arraycopy(this.n, this.s, obj14, i14, obj10);
                System.arraycopy(this.m, this.s, obj15, i14, obj10);
                System.arraycopy(this.p, this.s, arr, i14, obj10);
                System.arraycopy(this.k, this.s, obj11, i14, obj10);
                i5 = this.s;
                System.arraycopy(this.l, i14, obj12, obj10, i5);
                System.arraycopy(this.o, i14, obj13, obj10, i5);
                System.arraycopy(this.n, i14, obj14, obj10, i5);
                System.arraycopy(this.m, i14, obj15, obj10, i5);
                System.arraycopy(this.p, i14, arr, obj10, i5);
                System.arraycopy(this.k, i14, obj11, obj10, i5);
                this.l = obj12;
                this.o = obj13;
                this.n = obj14;
                this.m = obj15;
                this.p = arr;
                this.k = obj11;
                this.s = i14;
                this.j = obj9;
                throw l;
            }
        }
    }

    private int i(long l) {
        int i;
        int i2;
        int i3;
        int cmp;
        long l2;
        i2 = w(i + -1);
        while (i > this.t) {
            if (Long.compare(l2, l) >= 0) {
            }
            i--;
            if (i2-- == -1) {
            }
            i5--;
        }
        return i;
    }

    private long j(long l, boolean z2, boolean z3) {
        int i2;
        int cmp;
        int i;
        long l2;
        int obj14;
        i2 = this.q;
        final int i3 = -1;
        synchronized (this) {
            try {
                i = this.s;
                if (Long.compare(l, l2) < 0) {
                } else {
                }
                obj14 = this.t;
                if (obj14 != null && obj14 != i2) {
                }
                obj14 = this.t;
                if (obj14 != i2) {
                }
                i2 = obj14 + 1;
                int obj11 = this.q(i, i2, l, obj8);
                if (obj11 == -1) {
                }
                return i3;
                return l(obj11);
                return i3;
                throw l;
            }
        }
    }

    private long k() {
        int i = this.q;
        synchronized (this) {
            try {
                return -1;
                return l(i);
            }
        }
    }

    private long l(int i) {
        int i2;
        int obj6;
        this.v = Math.max(this.v, obj1);
        this.q = i3 -= i;
        i5 += i;
        this.r = i6;
        i8 += i;
        this.s = i2;
        int i12 = this.j;
        if (i2 >= i12) {
            this.s = i2 -= i12;
        }
        i9 -= i;
        this.t = i10;
        if (i10 < 0) {
            this.t = 0;
        }
        this.c.d(i6);
        if (this.q == 0 && this.s == 0) {
            if (this.s == 0) {
                obj6 = this.j;
            }
            obj6--;
            return l4 += l6;
        }
        return this.l[this.s];
    }

    private long o(int i) {
        int i2;
        int i3;
        int i6;
        int i4;
        int i5;
        i7 -= i;
        final int i10 = 1;
        if (i2 >= 0 && i2 <= i11 -= i5) {
            i4 = i2 <= i11 -= i5 ? i10 : i3;
        } else {
        }
        g.a(i4);
        i12 -= i2;
        this.q = i13;
        this.w = Math.max(this.v, obj5);
        if (i2 == 0 && this.x) {
            if (this.x) {
                i3 = i10;
            }
        }
        this.x = i3;
        this.c.c(i);
        int obj9 = this.q;
        if (obj9 != null) {
            obj9 = w(obj9 -= i10);
            return l += l3;
        }
        return 0;
    }

    private int q(int i, int i2, long l3, boolean z4) {
        int i3;
        int i4;
        int i5;
        long cmp;
        int obj7;
        final int i6 = 0;
        i3 = -1;
        i4 = i6;
        while (i4 < i2) {
            i5 = this.o;
            if (Long.compare(l, l3) <= 0) {
                break;
            }
            if (Long.compare(cmp, l3) == 0) {
                break;
            } else {
            }
            i3 = i4;
            if (obj7++ == this.j) {
            }
            i4++;
            obj7 = i6;
        }
        return i3;
    }

    private long u(int i) {
        long l;
        int i4;
        int i2;
        int i3;
        long l2;
        if (i == 0) {
            return Long.MIN_VALUE;
        }
        i4 = w(i + -1);
        i2 = 0;
        while (i2 < i) {
            l = Math.max(l, obj1);
            if (i7 &= 1 != 0) {
                break;
            } else {
            }
            if (i4-- == -1) {
            }
            i2++;
            i6--;
        }
        return l;
    }

    private int w(int i) {
        int i2;
        i3 += i;
        final int obj2 = this.j;
        if (i2 < obj2) {
        } else {
            i2 -= obj2;
        }
        return i2;
    }

    @Override // com.google.android.exoplayer2.l2.s
    protected final void B() {
        this.A = true;
    }

    @Override // com.google.android.exoplayer2.l2.s
    public boolean C(boolean z) {
        boolean z2;
        int i;
        boolean obj3;
        synchronized (this) {
            try {
                if (z == null) {
                }
                if (!this.x) {
                }
                obj3 = this.C;
                if (obj3 != null && obj3 != this.h) {
                } else {
                }
                if (obj3 != this.h) {
                } else {
                }
                i = 0;
                return i;
                if (obj3.a != this.h) {
                }
                return 1;
                return E(w(this.t));
                throw z;
            }
        }
    }

    @Override // com.google.android.exoplayer2.l2.s
    public void F() {
        DrmSession state;
        int i;
        state = this.i;
        if (state != null) {
            if (state.getState() == 1) {
            } else {
            }
            com.google.android.exoplayer2.drm.DrmSession.DrmSessionException error = this.i.getError();
            g.e(error);
            throw (DrmSession.DrmSessionException)error;
        }
    }

    @Override // com.google.android.exoplayer2.l2.s
    public final int I() {
        int i;
        int[] z;
        synchronized (this) {
            try {
                i = this.k[w(this.t)];
                i = this.D;
                return i;
                throw th;
            }
        }
    }

    @Override // com.google.android.exoplayer2.l2.s
    public void J() {
        n();
        M();
    }

    @Override // com.google.android.exoplayer2.l2.s
    public int K(j1 j1, DecoderInputBuffer decoderInputBuffer2, int i3, boolean z4) {
        int i;
        int i2;
        DecoderInputBuffer obj11;
        int obj12;
        int obj13;
        final int i5 = 1;
        i2 = i3 & 2 != 0 ? i5 : i;
        final int obj10 = this.H(j1, decoderInputBuffer2, i2, z4, this.b);
        if (obj10 == -4 && !decoderInputBuffer2.p() && i3 & 1 != 0) {
            if (!decoderInputBuffer2.p()) {
                if (i3 & 1 != 0) {
                    i = i5;
                }
                if (i3 &= 4 == 0) {
                    if (i != 0) {
                        this.a.f(decoderInputBuffer2, this.b);
                    } else {
                        this.a.m(decoderInputBuffer2, this.b);
                    }
                }
                if (i == 0) {
                    this.t = obj11 += i5;
                }
            }
        }
        return obj10;
    }

    @Override // com.google.android.exoplayer2.l2.s
    public void L() {
        N(true);
        M();
    }

    @Override // com.google.android.exoplayer2.l2.s
    public void N(boolean z) {
        int obj5;
        this.a.n();
        int i = 0;
        this.q = i;
        this.r = i;
        this.s = i;
        this.t = i;
        final int i2 = 1;
        this.y = i2;
        final long l = Long.MIN_VALUE;
        this.u = l;
        this.v = l;
        this.w = l;
        this.x = i;
        this.c.b();
        if (z != 0) {
            obj5 = 0;
            this.B = obj5;
            this.C = obj5;
            this.z = i2;
        }
    }

    @Override // com.google.android.exoplayer2.l2.s
    public final boolean P(long l, boolean z2) {
        boolean cmp;
        long l2;
        O();
        final int i4 = w(this.t);
        final int i7 = 0;
        synchronized (this) {
            try {
                if (Long.compare(l, l2) >= 0) {
                }
                if (Long.compare(l, l3) > 0 && obj11 == null) {
                } else {
                }
                if (obj11 == null) {
                } else {
                }
                int obj11 = this.q(i4, obj11 - i2, l, obj5);
                if (obj11 == -1) {
                }
                return i7;
                this.u = l;
                this.t = obj9 += obj11;
                return 1;
                return i7;
                throw l;
            }
        }
    }

    @Override // com.google.android.exoplayer2.l2.s
    public final void Q(long l) {
        if (Long.compare(l2, l) != 0) {
            this.G = l;
            B();
        }
    }

    @Override // com.google.android.exoplayer2.l2.s
    public final void R(long l) {
        this.u = l;
    }

    @Override // com.google.android.exoplayer2.l2.s
    public final void T(com.google.android.exoplayer2.source.e0.d e0$d) {
        this.g = d;
    }

    @Override // com.google.android.exoplayer2.l2.s
    public final void U(int i) {
        int i2;
        int i3;
        int i4;
        synchronized (this) {
            i2 = i7 += i <= this.q ? 1 : 0;
            g.a(i2);
            this.t = i5 += i;
        }
    }

    @Override // com.google.android.exoplayer2.l2.s
    public final void V(int i) {
        this.D = i;
    }

    @Override // com.google.android.exoplayer2.l2.s
    public final void W() {
        this.H = true;
    }

    @Override // com.google.android.exoplayer2.l2.s
    public final int a(i i, int i2, boolean z3, int i4) {
        return this.a.p(i, i2, z3);
    }

    @Override // com.google.android.exoplayer2.l2.s
    public void d(long l, int i2, int i3, int i4, s.a s$a5) {
        boolean z2;
        int i5;
        boolean z;
        boolean string;
        int i6;
        int i;
        int cmp;
        StringBuilder stringBuilder;
        final Object obj6 = this;
        if (obj6.A) {
            z2 = obj6.B;
            g.h(z2);
            e((i1)z2);
        }
        i5 = i3 & 1;
        int i8 = 0;
        int i10 = 1;
        i6 = i5 != 0 ? i10 : i8;
        if (obj6.y && i6 == 0) {
            if (i6 == 0) {
            }
            obj6.y = i8;
        }
        l5 += l;
        if (obj6.E) {
            if (Long.compare(i12, l6) < 0) {
            }
            if (i5 == 0) {
                if (!obj6.F) {
                    String valueOf = String.valueOf(obj6.C);
                    stringBuilder = new StringBuilder(length += 50);
                    stringBuilder.append("Overriding unexpected non-sync sample for format: ");
                    stringBuilder.append(valueOf);
                    v.h("SampleQueue", stringBuilder.toString());
                    obj6.F = i10;
                }
                i = i5;
            } else {
                i = i3;
            }
        } else {
        }
        if (obj6.H && i6 != 0 && !g(i12)) {
            if (i6 != 0) {
                if (!g(i12)) {
                }
                obj6.H = i8;
            }
        }
        long l4 = (long)obj2;
        this.h(i12, l4, i, i7 - l4, obj5);
    }

    @Override // com.google.android.exoplayer2.l2.s
    public final void e(i1 i1) {
        final i1 i1Var = r(i1);
        this.A = false;
        this.B = i1;
        com.google.android.exoplayer2.source.e0.d dVar = this.g;
        if (dVar != null && S(i1Var)) {
            if (S(i1Var)) {
                dVar.i(i1Var);
            }
        }
    }

    @Override // com.google.android.exoplayer2.l2.s
    public final void f(d0 d0, int i2, int i3) {
        this.a.q(d0, i2);
    }

    @Override // com.google.android.exoplayer2.l2.s
    public final void m(long l, boolean z2, boolean z3) {
        this.a.b(j(l, z2, z3));
    }

    @Override // com.google.android.exoplayer2.l2.s
    public final void n() {
        this.a.b(k());
    }

    @Override // com.google.android.exoplayer2.l2.s
    public final void p(int i) {
        this.a.c(o(i));
    }

    @Override // com.google.android.exoplayer2.l2.s
    protected i1 r(i1 i1) {
        int cmp;
        int i2;
        int i;
        long l;
        Object obj6;
        i = Long.MAX_VALUE;
        if (Long.compare(l2, i) != 0 && Long.compare(l3, i) != 0) {
            i = Long.MAX_VALUE;
            if (Long.compare(l3, i) != 0) {
                cmp = i1.a();
                cmp.i0(l4 += l);
                obj6 = cmp.E();
            }
        }
        return obj6;
    }

    @Override // com.google.android.exoplayer2.l2.s
    public final long s() {
        return this.w;
        synchronized (this) {
            return this.w;
        }
    }

    @Override // com.google.android.exoplayer2.l2.s
    public final long t() {
        return Math.max(this.v, obj1);
        synchronized (this) {
            return Math.max(this.v, obj1);
        }
    }

    @Override // com.google.android.exoplayer2.l2.s
    public final int v() {
        return i += i3;
    }

    @Override // com.google.android.exoplayer2.l2.s
    public final int x(long l, boolean z2) {
        boolean cmp;
        long l2;
        final int i3 = w(this.t);
        final int i6 = 0;
        synchronized (this) {
            try {
                if (Long.compare(l, l2) < 0) {
                } else {
                }
                if (Long.compare(l, l3) > 0 && obj11 != null) {
                }
                if (obj11 != null) {
                }
                return obj9 -= obj10;
                int obj9 = this.q(i3, obj11 - i2, l, obj5);
                if (obj9 == -1) {
                }
                return i6;
                return obj9;
                return i6;
                throw l;
            }
        }
    }

    @Override // com.google.android.exoplayer2.l2.s
    public final i1 y() {
        int i;
        synchronized (this) {
            try {
                i = 0;
                i = this.C;
                return i;
                throw th;
            }
        }
    }

    @Override // com.google.android.exoplayer2.l2.s
    public final int z() {
        return i += i3;
    }
}
