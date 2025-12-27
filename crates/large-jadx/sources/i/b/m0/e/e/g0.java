package i.b.m0.e.e;

import i.b.j0.b;
import i.b.m0.a.g;
import i.b.p0.a;
import i.b.r;
import i.b.w;
import i.b.y;

/* compiled from: ObservableDelaySubscriptionOther.java */
/* loaded from: classes3.dex */
public final class g0<T, U> extends r<T> {

    final w<? extends T> a;
    final w<U> b;

    final class a implements y<U> {

        final g a;
        final y<? super T> b;
        boolean c;
        final /* synthetic */ g0 v;
        a(g gVar, y yVar) {
            this.v = g0Var;
            super();
            this.a = gVar;
            this.b = yVar;
        }

        public void onComplete() {
            if (this.c) {
                return;
            }
            this.c = true;
            this.v.a.subscribe(new g0.a.a(this));
        }

        public void onError(Throwable th) {
            if (this.c) {
                a.t(th);
                return;
            }
            this.c = true;
            this.b.onError(th);
        }

        public void onNext(U u) {
            onComplete();
        }

        public void onSubscribe(b bVar) {
            this.a.b(bVar);
        }
    }
    public g0(w<? extends T> wVar, w<U> wVar2) {
        super();
        this.a = wVar;
        this.b = wVar2;
    }

    @Override // i.b.r
    public void subscribeActual(y<? super T> yVar) {
        final g gVar = new g();
        yVar.onSubscribe(gVar);
        this.b.subscribe(new g0.a(this, gVar, yVar));
    }
}
