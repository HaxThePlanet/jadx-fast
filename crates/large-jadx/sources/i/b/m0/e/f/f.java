package i.b.m0.e.f;

import i.b.a0;
import i.b.d0;
import i.b.g0;
import i.b.j0.b;
import i.b.m0.a.g;
import i.b.z;
import java.util.concurrent.TimeUnit;

/* compiled from: SingleDelay.java */
/* loaded from: classes3.dex */
public final class f<T> extends a0<T> {

    final g0<? extends T> a;
    final long b;
    final TimeUnit c;
    final z v;
    final boolean w;

    final class a implements d0<T> {

        private final g a;
        final d0<? super T> b;
        final /* synthetic */ f c;
        a(g gVar, d0 d0Var) {
            this.c = fVar;
            super();
            this.a = gVar;
            this.b = d0Var;
        }

        public void onError(Throwable th) {
            long l = 0;
            long r4 = fVar.w ? fVar.b : 0;
            this.a.a(fVar.v.d(new f.a.a(this, th), (fVar.w ? fVar.b : 0), timeUnit, fVar.c));
        }

        public void onSubscribe(b bVar) {
            this.a.a(bVar);
        }

        public void onSuccess(T t) {
            this.a.a(fVar.v.d(new f.a.b(this, t), fVar.b, fVar.c));
        }
    }
    public f(g0<? extends T> g0Var, long j, TimeUnit timeUnit, z zVar, boolean z) {
        super();
        this.a = g0Var;
        this.b = j;
        this.c = timeUnit;
        this.v = zVar;
        this.w = z;
    }

    @Override // i.b.a0
    protected void subscribeActual(d0<? super T> d0Var) {
        final g gVar = new g();
        d0Var.onSubscribe(gVar);
        this.a.subscribe(new f.a(this, gVar, d0Var));
    }
}
