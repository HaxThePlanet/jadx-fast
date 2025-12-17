package com.google.android.exoplayer2.upstream;

import com.google.android.exoplayer2.util.g;
import com.google.android.exoplayer2.util.p0;
import java.util.ArrayList;

/* loaded from: classes2.dex */
public abstract class h implements com.google.android.exoplayer2.upstream.l {

    private final boolean a;
    private final ArrayList<com.google.android.exoplayer2.upstream.b0> b;
    private int c;
    private com.google.android.exoplayer2.upstream.n d;
    protected h(boolean z) {
        super();
        this.a = z;
        ArrayList obj2 = new ArrayList(1);
        this.b = obj2;
    }

    @Override // com.google.android.exoplayer2.upstream.l
    public final void d(com.google.android.exoplayer2.upstream.b0 b0) {
        boolean contains;
        Object obj2;
        g.e(b0);
        if (!this.b.contains(b0)) {
            this.b.add(b0);
            this.c = obj2++;
        }
    }

    @Override // com.google.android.exoplayer2.upstream.l
    protected final void n(int i) {
        int i2;
        Object obj;
        boolean z;
        final com.google.android.exoplayer2.upstream.n nVar = this.d;
        p0.i(nVar);
        i2 = 0;
        while (i2 < this.c) {
            (b0)this.b.get(i2).g(this, (n)nVar, this.a, i);
            i2++;
        }
    }

    @Override // com.google.android.exoplayer2.upstream.l
    protected final void o() {
        int i;
        Object obj;
        boolean z;
        com.google.android.exoplayer2.upstream.n nVar = this.d;
        p0.i(nVar);
        i = 0;
        while (i < this.c) {
            (b0)this.b.get(i).b(this, (n)nVar, this.a);
            i++;
        }
        this.d = 0;
    }

    @Override // com.google.android.exoplayer2.upstream.l
    protected final void p(com.google.android.exoplayer2.upstream.n n) {
        int i;
        Object obj;
        boolean z;
        i = 0;
        while (i < this.c) {
            (b0)this.b.get(i).i(this, n, this.a);
            i++;
        }
    }

    @Override // com.google.android.exoplayer2.upstream.l
    protected final void q(com.google.android.exoplayer2.upstream.n n) {
        int i;
        Object obj;
        boolean z;
        this.d = n;
        i = 0;
        while (i < this.c) {
            (b0)this.b.get(i).c(this, n, this.a);
            i++;
        }
    }
}
