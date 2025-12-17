package i.b.m0.e.f;

import i.b.a0;
import i.b.d0;
import i.b.g0;
import i.b.j0.b;
import i.b.m0.a.g;
import i.b.z;
import java.util.concurrent.TimeUnit;

/* loaded from: classes3.dex */
public final class f<T>  extends a0<T> {

    final g0<? extends T> a;
    final long b;
    final TimeUnit c;
    final z v;
    final boolean w;

    final class a implements d0<T> {

        private final g a;
        final d0<? super T> b;
        final i.b.m0.e.f.f c;
        a(i.b.m0.e.f.f f, g g2, d0 d03) {
            this.c = f;
            super();
            this.a = g2;
            this.b = d03;
        }

        @Override // i.b.d0
        public void onError(Throwable throwable) {
            long l;
            final i.b.m0.e.f.f fVar = this.c;
            f.a.a aVar = new f.a.a(this, throwable);
            l = fVar.w ? fVar.b : 0;
            this.a.a(fVar.v.d(aVar, l, obj5));
        }

        @Override // i.b.d0
        public void onSubscribe(b b) {
            this.a.a(b);
        }

        public void onSuccess(T t) {
            final i.b.m0.e.f.f fVar = this.c;
            f.a.b bVar = new f.a.b(this, t);
            this.a.a(fVar.v.d(bVar, fVar.b, obj5));
        }
    }
    public f(g0<? extends T> g0, long l2, TimeUnit timeUnit3, z z4, boolean z5) {
        super();
        this.a = g0;
        this.b = l2;
        this.c = z4;
        this.v = z5;
        this.w = obj6;
    }

    protected void subscribeActual(d0<? super T> d0) {
        g gVar = new g();
        d0.onSubscribe(gVar);
        f.a aVar = new f.a(this, gVar, d0);
        this.a.subscribe(aVar);
    }
}
