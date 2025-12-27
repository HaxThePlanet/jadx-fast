package f.c.a.b.i;

import android.content.Context;
import com.google.android.datatransport.runtime.backends.j;
import com.google.android.datatransport.runtime.backends.l;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.s;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.t;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.u;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.v;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.w;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.x;
import f.c.a.b.i.a0.g;
import f.c.a.b.i.a0.i;
import f.c.a.b.i.a0.j.i0;
import f.c.a.b.i.a0.j.l0;
import f.c.a.b.i.a0.j.m0;
import f.c.a.b.i.a0.j.n0;
import f.c.a.b.i.a0.j.o0;
import f.c.a.b.i.a0.j.q0;
import f.c.a.b.i.a0.j.r0;
import f.c.a.b.i.a0.j.t0;
import java.util.concurrent.Executor;

/* compiled from: DaggerTransportRuntimeComponent.java */
/* loaded from: classes.dex */
final class f extends u {

    private j.a.a<x> A;
    private j.a.a<f.c.a.b.i.a0.c> B;
    private j.a.a<t> C;
    private j.a.a<v> D;
    private j.a.a<t> E;
    private j.a.a<Executor> a;
    private j.a.a<Context> b;
    private j.a.a c;
    private j.a.a v;
    private j.a.a w;
    private j.a.a<String> x;
    private j.a.a<q0> y;
    private j.a.a<s> z;

    static class a {
    }

    private static final class b implements u.a {

        private Context a;
        private b() {
            super();
        }

        public f.b b(Context context) {
            d.b(context);
            this.a = context;
            return this;
        }

        public u build() {
            d.a(this.a, Context.class);
            return new f(this.a, null);
        }

        /* synthetic */ b(f.a aVar) {
            this();
        }
    }
    /* synthetic */ f(Context context, f.a aVar) {
        this(context);
    }

    public static u.a e() {
        return new f.b(null);
    }

    private void f(Context context) {
        this.a = a.b(l.a());
        f.c.a.b.i.w.b.b bVar = c.a(context);
        this.b = bVar;
        j jVar = j.a(bVar, c.a(), d.a());
        this.c = jVar;
        this.v = a.b(l.a(this.b, jVar));
        this.w = t0.a(this.b, l0.a(), n0.a());
        this.x = m0.a(this.b);
        this.y = a.b(r0.a(c.a(), d.a(), o0.a(), this.w, this.x));
        g gVar = g.b(c.a());
        this.z = gVar;
        i iVar = i.a(this.b, this.y, gVar, d.a());
        this.A = iVar;
        this.B = d.a(this.a, this.v, iVar, this.y, this.y);
        this.C = u.a(this.b, this.v, aVar, this.A, this.a, this.y, c.a(), d.a(), this.y);
        this.D = w.a(this.a, this.y, this.A, this.y);
        this.E = a.b(v.a(c.a(), d.a(), this.B, this.C, this.D));
    }

    @Override // f.c.a.b.i.u
    i0 a() {
        return (i0)this.y.get();
    }

    @Override // f.c.a.b.i.u
    t c() {
        return (t)this.E.get();
    }

    private f(Context context) {
        super();
        f(context);
    }
}
