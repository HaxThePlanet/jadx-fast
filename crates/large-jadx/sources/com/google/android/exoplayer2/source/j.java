package com.google.android.exoplayer2.source;

import android.os.Handler;
import android.os.Looper;
import com.google.android.exoplayer2.drm.u;
import com.google.android.exoplayer2.drm.u.a;
import com.google.android.exoplayer2.g2;
import com.google.android.exoplayer2.upstream.b0;
import com.google.android.exoplayer2.util.g;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

/* loaded from: classes2.dex */
public abstract class j implements com.google.android.exoplayer2.source.y {

    private final ArrayList<com.google.android.exoplayer2.source.y.b> a;
    private final HashSet<com.google.android.exoplayer2.source.y.b> b;
    private final com.google.android.exoplayer2.source.z.a c;
    private final u.a d;
    private Looper e;
    private g2 f;
    public j() {
        super();
        final int i = 1;
        ArrayList arrayList = new ArrayList(i);
        this.a = arrayList;
        HashSet hashSet = new HashSet(i);
        this.b = hashSet;
        z.a aVar = new z.a();
        this.c = aVar;
        u.a aVar2 = new u.a();
        this.d = aVar2;
    }

    @Override // com.google.android.exoplayer2.source.y
    public final void b(com.google.android.exoplayer2.source.y.b y$b) {
        Object obj2;
        this.a.remove(b);
        if (this.a.isEmpty()) {
            obj2 = 0;
            this.e = obj2;
            this.f = obj2;
            this.b.clear();
            y();
        } else {
            f(b);
        }
    }

    @Override // com.google.android.exoplayer2.source.y
    public final void d(Handler handler, com.google.android.exoplayer2.source.z z2) {
        g.e(handler);
        g.e(z2);
        this.c.a(handler, z2);
    }

    @Override // com.google.android.exoplayer2.source.y
    public final void e(com.google.android.exoplayer2.source.z z) {
        this.c.C(z);
    }

    @Override // com.google.android.exoplayer2.source.y
    public final void f(com.google.android.exoplayer2.source.y.b y$b) {
        Object obj3;
        this.b.remove(b);
        if (empty ^= 1 != 0 && this.b.isEmpty()) {
            if (this.b.isEmpty()) {
                t();
            }
        }
    }

    @Override // com.google.android.exoplayer2.source.y
    public final void h(Handler handler, u u2) {
        g.e(handler);
        g.e(u2);
        this.d.a(handler, u2);
    }

    @Override // com.google.android.exoplayer2.source.y
    public final void i(u u) {
        this.d.t(u);
    }

    @Override // com.google.android.exoplayer2.source.y
    public final void n(com.google.android.exoplayer2.source.y.b y$b, b0 b02) {
        Object myLooper;
        int i;
        myLooper = Looper.myLooper();
        Looper looper = this.e;
        if (looper != null) {
            if (looper == myLooper) {
                i = 1;
            } else {
                i = 0;
            }
        } else {
        }
        g.a(i);
        g2 g2Var = this.f;
        this.a.add(b);
        if (this.e == null) {
            this.e = myLooper;
            this.b.add(b);
            w(b02);
        } else {
            if (g2Var != null) {
                o(b);
                b.a(this, g2Var);
            }
        }
    }

    @Override // com.google.android.exoplayer2.source.y
    public final void o(com.google.android.exoplayer2.source.y.b y$b) {
        g.e(this.e);
        this.b.add(b);
        if (this.b.isEmpty()) {
            u();
        }
    }

    @Override // com.google.android.exoplayer2.source.y
    protected final u.a p(int i, com.google.android.exoplayer2.source.y.a y$a2) {
        return this.d.u(i, a2);
    }

    @Override // com.google.android.exoplayer2.source.y
    protected final u.a q(com.google.android.exoplayer2.source.y.a y$a) {
        return this.d.u(0, a);
    }

    @Override // com.google.android.exoplayer2.source.y
    protected final com.google.android.exoplayer2.source.z.a r(int i, com.google.android.exoplayer2.source.y.a y$a2, long l3) {
        return this.c.F(i, a2, l3);
    }

    @Override // com.google.android.exoplayer2.source.y
    protected final com.google.android.exoplayer2.source.z.a s(com.google.android.exoplayer2.source.y.a y$a) {
        return this.c.F(0, a, 0);
    }

    @Override // com.google.android.exoplayer2.source.y
    protected void t() {
    }

    @Override // com.google.android.exoplayer2.source.y
    protected void u() {
    }

    @Override // com.google.android.exoplayer2.source.y
    protected final boolean v() {
        return empty ^= 1;
    }

    @Override // com.google.android.exoplayer2.source.y
    protected abstract void w(b0 b0);

    @Override // com.google.android.exoplayer2.source.y
    protected final void x(g2 g2) {
        Object next;
        this.f = g2;
        Iterator iterator = this.a.iterator();
        for (y.b next : iterator) {
            next.a(this, g2);
        }
    }

    @Override // com.google.android.exoplayer2.source.y
    protected abstract void y();
}
