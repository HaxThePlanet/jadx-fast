package com.google.android.exoplayer2.n2;

import com.google.android.exoplayer2.a2;
import com.google.android.exoplayer2.g2;
import com.google.android.exoplayer2.source.l0;
import com.google.android.exoplayer2.source.y.a;
import com.google.android.exoplayer2.upstream.g;
import com.google.android.exoplayer2.util.g;

/* loaded from: classes2.dex */
public abstract class n {

    private g a;

    public interface a {
    }
    protected final g a() {
        final g gVar = this.a;
        g.e(gVar);
        return (g)gVar;
    }

    public final void b(com.google.android.exoplayer2.n2.n.a n$a, g g2) {
        this.a = g2;
    }

    public abstract void c(Object object);

    public abstract com.google.android.exoplayer2.n2.o d(a2[] a2Arr, l0 l02, y.a y$a3, g2 g24);
}
