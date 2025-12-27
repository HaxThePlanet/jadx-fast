package i.b.m0.e.b;

import i.b.h;
import i.b.l0.n;
import i.b.m0.i.d;

/* compiled from: FlowableRetryWhen.java */
/* loaded from: classes3.dex */
public final class h0<T> extends a<T, T> {

    final n<? super h<Throwable>, ? extends m.c.a<?>> c;

    static final class a<T> extends e0.c<T, Throwable> {

        private static final long serialVersionUID = -2680129890138081029L;
        a(m.c.b<? super T> bVar, i.b.q0.a<Throwable> aVar, m.c.c cVar) {
            super(bVar, aVar, cVar);
        }

        @Override // i.b.m0.e.b.e0$c
        public void onComplete() {
            this.receiver.cancel();
            this.downstream.onComplete();
        }

        @Override // i.b.m0.e.b.e0$c
        public void onError(Throwable th) {
            h(th);
        }
    }
    public h0(h<T> hVar, n<? super h<Throwable>, ? extends m.c.a<?>> nVar) {
        super(hVar);
        this.c = nVar;
    }

    @Override // i.b.m0.e.b.a
    public void c0(m.c.b<? super T> bVar) {
        i.b.q0.a aVar2 = c.i0(8).g0();
        try {
            Object apply = this.c.apply(aVar2);
            b.e(apply, "handler returned a null Publisher");
        } catch (Throwable th) {
            a.b(th);
            d.error(th, bVar);
            return;
        }
        i.b.m0.e.b.e0.b bVar2 = new e0.b(this.b);
        i.b.m0.e.b.h0.a aVar3 = new h0.a(new a(bVar), aVar2, bVar2);
        bVar2.subscriber = aVar3;
        bVar.onSubscribe(aVar3);
        apply.a(bVar2);
        bVar2.onNext(null);
    }
}
