package com.google.android.exoplayer2;

import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2.decoder.a;
import com.google.android.exoplayer2.source.f0;
import com.google.android.exoplayer2.util.g;
import com.google.android.exoplayer2.util.x;

/* loaded from: classes.dex */
public abstract class u0 implements com.google.android.exoplayer2.z1, com.google.android.exoplayer2.a2 {

    private long A = Long.MIN_VALUE;
    private boolean B;
    private boolean C;
    private final int a;
    private final com.google.android.exoplayer2.j1 b;
    private com.google.android.exoplayer2.b2 c;
    private int v;
    private int w;
    private f0 x;
    private com.google.android.exoplayer2.i1[] y;
    private long z;
    public u0(int i) {
        super();
        this.a = i;
        j1 obj3 = new j1();
        this.b = obj3;
        final long l = Long.MIN_VALUE;
    }

    @Override // com.google.android.exoplayer2.z1
    public x A() {
        return null;
    }

    @Override // com.google.android.exoplayer2.z1
    protected final com.google.android.exoplayer2.ExoPlaybackException C(Throwable throwable, com.google.android.exoplayer2.i1 i12, int i3) {
        return D(throwable, i12, false, i3);
    }

    @Override // com.google.android.exoplayer2.z1
    protected final com.google.android.exoplayer2.ExoPlaybackException D(Throwable throwable, com.google.android.exoplayer2.i1 i12, boolean z3, int i4) {
        boolean z;
        int i;
        if (i12 != null && !this.C) {
            if (!this.C) {
                this.C = true;
                i = a2.B(b(i12));
                this.C = false;
            } else {
                i = 4;
            }
        } else {
        }
        return ExoPlaybackException.b(throwable, getName(), G(), i12, i, z3, i4);
    }

    @Override // com.google.android.exoplayer2.z1
    protected final com.google.android.exoplayer2.b2 E() {
        final com.google.android.exoplayer2.b2 b2Var = this.c;
        g.e(b2Var);
        return (b2)b2Var;
    }

    @Override // com.google.android.exoplayer2.z1
    protected final com.google.android.exoplayer2.j1 F() {
        this.b.a();
        return this.b;
    }

    @Override // com.google.android.exoplayer2.z1
    protected final int G() {
        return this.v;
    }

    @Override // com.google.android.exoplayer2.z1
    protected final com.google.android.exoplayer2.i1[] H() {
        final com.google.android.exoplayer2.i1[] objArr = this.y;
        g.e(objArr);
        return (i1[])objArr;
    }

    @Override // com.google.android.exoplayer2.z1
    protected final boolean I() {
        boolean z;
        if (j()) {
            z = this.B;
        } else {
            f0 f0Var = this.x;
            g.e(f0Var);
            z = (f0)f0Var.a();
        }
        return z;
    }

    @Override // com.google.android.exoplayer2.z1
    protected abstract void J();

    @Override // com.google.android.exoplayer2.z1
    protected void K(boolean z, boolean z2) {
    }

    @Override // com.google.android.exoplayer2.z1
    protected abstract void L(long l, boolean z2);

    @Override // com.google.android.exoplayer2.z1
    protected void M() {
    }

    @Override // com.google.android.exoplayer2.z1
    protected void N() {
    }

    @Override // com.google.android.exoplayer2.z1
    protected void O() {
    }

    @Override // com.google.android.exoplayer2.z1
    protected abstract void P(com.google.android.exoplayer2.i1[] i1Arr, long l2, long l3);

    @Override // com.google.android.exoplayer2.z1
    protected final int Q(com.google.android.exoplayer2.j1 j1, DecoderInputBuffer decoderInputBuffer2, int i3) {
        int cmp;
        int i;
        long l2;
        long l;
        com.google.android.exoplayer2.j1 obj6;
        int obj7;
        f0 f0Var = this.x;
        g.e(f0Var);
        final int obj8 = (f0)f0Var.b(j1, decoderInputBuffer2, i3);
        if (obj8 == -4) {
            if (decoderInputBuffer2.p()) {
                this.A = Long.MIN_VALUE;
                if (this.B) {
                } else {
                    cmp = -3;
                }
                return cmp;
            }
            l4 += l2;
            decoderInputBuffer2.w = cmp;
            this.A = Math.max(this.A, decoderInputBuffer2);
        } else {
            obj7 = j1.b;
            g.e(obj7);
            l2 = Long.MAX_VALUE;
            if (obj8 == -5 && Long.compare(l3, l2) != 0) {
                obj7 = j1.b;
                g.e((i1)obj7);
                l2 = Long.MAX_VALUE;
                if (Long.compare(l3, l2) != 0) {
                    cmp = (i1)obj7.a();
                    cmp.i0(l5 += l);
                    j1.b = cmp.E();
                }
            }
        }
        return obj8;
    }

    @Override // com.google.android.exoplayer2.z1
    protected int R(long l) {
        final f0 f0Var = this.x;
        g.e(f0Var);
        return (f0)f0Var.d(l -= l2);
    }

    @Override // com.google.android.exoplayer2.z1
    public final void f(int i) {
        this.v = i;
    }

    @Override // com.google.android.exoplayer2.z1
    public final void g() {
        int i;
        final int i4 = 0;
        if (this.w == 1) {
        } else {
            i = i4;
        }
        g.f(i);
        this.b.a();
        this.w = i4;
        int i3 = 0;
        this.x = i3;
        this.y = i3;
        this.B = i4;
        J();
    }

    @Override // com.google.android.exoplayer2.z1
    public final int getState() {
        return this.w;
    }

    @Override // com.google.android.exoplayer2.z1
    public final f0 getStream() {
        return this.x;
    }

    @Override // com.google.android.exoplayer2.z1
    public final int i() {
        return this.a;
    }

    @Override // com.google.android.exoplayer2.z1
    public final boolean j() {
        int i;
        i = Long.compare(l, l2) == 0 ? 1 : 0;
        return i;
    }

    @Override // com.google.android.exoplayer2.z1
    public final void k(com.google.android.exoplayer2.i1[] i1Arr, f0 f02, long l3, long l4) {
        g.f(z ^= 1);
        this.x = f02;
        if (Long.compare(l, l2) == 0) {
            this.A = l3;
        }
        this.y = i1Arr;
        this.z = obj11;
        this.P(i1Arr, l3, obj3);
    }

    @Override // com.google.android.exoplayer2.z1
    public final void l() {
        this.B = true;
    }

    @Override // com.google.android.exoplayer2.z1
    public final com.google.android.exoplayer2.a2 m() {
        return this;
    }

    @Override // com.google.android.exoplayer2.z1
    public final void reset() {
        int i;
        i = this.w == 0 ? 1 : 0;
        g.f(i);
        this.b.a();
        M();
    }

    @Override // com.google.android.exoplayer2.z1
    public final void s(com.google.android.exoplayer2.b2 b2, com.google.android.exoplayer2.i1[] i12Arr2, f0 f03, long l4, boolean z5, boolean z6, long l7, long l8) {
        int i;
        final Object obj3 = this;
        final boolean z2 = z6;
        int i3 = 1;
        i = obj3.w == 0 ? i3 : 0;
        g.f(i);
        obj3.c = b2;
        obj3.w = i3;
        K(z6, l7);
        this.k(i12Arr2, f03, l8, obj4);
        long l = l4;
        L(l4, z5);
    }

    @Override // com.google.android.exoplayer2.z1
    public final void start() {
        int i;
        if (this.w == 1) {
        } else {
            i = 0;
        }
        g.f(i);
        this.w = 2;
        N();
    }

    @Override // com.google.android.exoplayer2.z1
    public final void stop() {
        int i;
        final int i3 = 1;
        i = this.w == 2 ? i3 : 0;
        g.f(i);
        this.w = i3;
        O();
    }

    @Override // com.google.android.exoplayer2.z1
    public int t() {
        return 0;
    }

    @Override // com.google.android.exoplayer2.z1
    public void v(int i, Object object2) {
    }

    @Override // com.google.android.exoplayer2.z1
    public final void w() {
        final f0 f0Var = this.x;
        g.e(f0Var);
        (f0)f0Var.c();
    }

    @Override // com.google.android.exoplayer2.z1
    public final long x() {
        return this.A;
    }

    @Override // com.google.android.exoplayer2.z1
    public final void y(long l) {
        final int i = 0;
        this.B = i;
        this.A = l;
        L(l, obj3);
    }

    @Override // com.google.android.exoplayer2.z1
    public final boolean z() {
        return this.B;
    }
}
