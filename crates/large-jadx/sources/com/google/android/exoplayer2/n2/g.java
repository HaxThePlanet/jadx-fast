package com.google.android.exoplayer2.n2;

import com.google.android.exoplayer2.g2;
import com.google.android.exoplayer2.i1;
import com.google.android.exoplayer2.source.k0;
import com.google.android.exoplayer2.source.m0.b;
import com.google.android.exoplayer2.source.m0.d;
import com.google.android.exoplayer2.source.m0.e;
import com.google.android.exoplayer2.source.y.a;
import com.google.android.exoplayer2.upstream.g;
import java.util.List;

/* loaded from: classes2.dex */
public interface g extends com.google.android.exoplayer2.n2.j {

    public static final class a {

        public final k0 a;
        public final int[] b;
        public final int c;
        public a(k0 k0, int... i2Arr2) {
            super(k0, i2Arr2, 0);
        }

        public a(k0 k0, int[] i2Arr2, int i3) {
            super();
            this.a = k0;
            this.b = i2Arr2;
            this.c = i3;
        }
    }

    public interface b {
        public abstract com.google.android.exoplayer2.n2.g[] a(com.google.android.exoplayer2.n2.g.a[] g$aArr, g g2, y.a y$a3, g2 g24);
    }
    @Override // com.google.android.exoplayer2.n2.j
    public abstract int b();

    @Override // com.google.android.exoplayer2.n2.j
    public abstract boolean c(int i, long l2);

    @Override // com.google.android.exoplayer2.n2.j
    public abstract boolean d(int i, long l2);

    public boolean e(long l, b b2, List<? extends d> list3) {
        return 0;
    }

    @Override // com.google.android.exoplayer2.n2.j
    public void f(boolean z) {
    }

    @Override // com.google.android.exoplayer2.n2.j
    public abstract void g();

    @Override // com.google.android.exoplayer2.n2.j
    public abstract void i();

    public abstract int k(long l, List<? extends d> list2);

    public abstract void l(long l, long l2, long l3, List<? extends d> list4, e[] e5Arr5);

    @Override // com.google.android.exoplayer2.n2.j
    public abstract int m();

    @Override // com.google.android.exoplayer2.n2.j
    public abstract i1 n();

    @Override // com.google.android.exoplayer2.n2.j
    public abstract int o();

    @Override // com.google.android.exoplayer2.n2.j
    public abstract void p(float f);

    @Override // com.google.android.exoplayer2.n2.j
    public abstract Object q();

    @Override // com.google.android.exoplayer2.n2.j
    public void r() {
    }

    @Override // com.google.android.exoplayer2.n2.j
    public void s() {
    }
}
