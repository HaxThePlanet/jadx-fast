package i.b.m0.e.b;

import i.b.h;
import i.b.l0.n;
import i.b.m0.b.b;
import i.b.m0.i.d;
import i.b.q0.a;
import i.b.q0.c;
import i.b.u0.a;
import io.reactivex.exceptions.a;
import m.c.a;
import m.c.b;
import m.c.c;

/* loaded from: classes3.dex */
public final class h0<T>  extends i.b.m0.e.b.a<T, T> {

    final n<? super h<Throwable>, ? extends a<?>> c;

    static final class a extends i.b.m0.e.b.e0.c<T, Throwable> {

        private static final long serialVersionUID = -2680129890138081029L;
        a(b<? super T> b, a<Throwable> a2, c c3) {
            super(b, a2, c3);
        }

        @Override // i.b.m0.e.b.e0$c
        public void onComplete() {
            this.receiver.cancel();
            this.downstream.onComplete();
        }

        @Override // i.b.m0.e.b.e0$c
        public void onError(Throwable throwable) {
            h(throwable);
        }
    }
    public h0(h<T> h, n<? super h<Throwable>, ? extends a<?>> n2) {
        super(h);
        this.c = n2;
    }

    public void c0(b<? super T> b) {
        a aVar = new a(b);
        a aVar2 = c.i0(8).g0();
        Object apply = this.c.apply(aVar2);
        b.e(apply, "handler returned a null Publisher");
        e0.b bVar = new e0.b(this.b);
        h0.a aVar3 = new h0.a(aVar, aVar2, bVar);
        bVar.subscriber = aVar3;
        b.onSubscribe(aVar3);
        (a)apply.a(bVar);
        bVar.onNext(0);
    }
}
