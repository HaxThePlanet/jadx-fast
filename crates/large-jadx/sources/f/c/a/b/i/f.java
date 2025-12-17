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
import f.c.a.b.i.a0.c;
import f.c.a.b.i.a0.d;
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
import f.c.a.b.i.b0.c;
import f.c.a.b.i.b0.d;
import f.c.a.b.i.w.b.a;
import f.c.a.b.i.w.b.c;
import f.c.a.b.i.w.b.d;
import j.a.a;
import java.util.concurrent.Executor;

/* loaded from: classes.dex */
final class f extends f.c.a.b.i.u {

    private a<x> A;
    private a<c> B;
    private a<t> C;
    private a<v> D;
    private a<f.c.a.b.i.t> E;
    private a<Executor> a;
    private a<Context> b;
    private a c;
    private a v;
    private a w;
    private a<String> x;
    private a<q0> y;
    private a<s> z;

    static class a {
    }

    private static final class b implements f.c.a.b.i.u.a {

        private Context a;
        b(f.c.a.b.i.f.a f$a) {
            super();
        }

        @Override // f.c.a.b.i.u$a
        public f.c.a.b.i.u.a a(Context context) {
            b(context);
            return this;
        }

        @Override // f.c.a.b.i.u$a
        public f.c.a.b.i.f.b b(Context context) {
            d.b(context);
            this.a = (Context)context;
            return this;
        }

        @Override // f.c.a.b.i.u$a
        public f.c.a.b.i.u build() {
            d.a(this.a, Context.class);
            f fVar = new f(this.a, 0);
            return fVar;
        }
    }
    private f(Context context) {
        super();
        f(context);
    }

    f(Context context, f.c.a.b.i.f.a f$a2) {
        super(context);
    }

    public static f.c.a.b.i.u.a e() {
        f.b bVar = new f.b(0);
        return bVar;
    }

    private void f(Context context) {
        this.a = a.b(l.a());
        f.c.a.b.i.w.b.b obj10 = c.a(context);
        this.b = obj10;
        obj10 = j.a(obj10, c.a(), d.a());
        this.c = obj10;
        this.v = a.b(l.a(this.b, obj10));
        this.w = t0.a(this.b, l0.a(), n0.a());
        this.x = m0.a(this.b);
        this.y = a.b(r0.a(c.a(), d.a(), o0.a(), this.w, this.x));
        obj10 = g.b(c.a());
        this.z = obj10;
        obj10 = i.a(this.b, this.y, obj10, d.a());
        this.A = obj10;
        a aVar13 = this.y;
        this.B = d.a(this.a, this.v, obj10, aVar13, aVar13);
        final a aVar20 = this.y;
        this.C = u.a(this.b, this.v, aVar20, this.A, this.a, aVar20, c.a(), d.a(), this.y);
        a aVar6 = this.y;
        this.D = w.a(this.a, aVar6, this.A, aVar6);
        this.E = a.b(v.a(c.a(), d.a(), this.B, this.C, this.D));
    }

    @Override // f.c.a.b.i.u
    i0 a() {
        return (i0)this.y.get();
    }

    @Override // f.c.a.b.i.u
    f.c.a.b.i.t c() {
        return (t)this.E.get();
    }
}
