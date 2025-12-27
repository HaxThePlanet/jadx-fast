package i.b.m0.e.e;

import i.b.j0.b;
import i.b.m0.a.g;
import i.b.w;
import i.b.y;

/* compiled from: ObservableSwitchIfEmpty.java */
/* loaded from: classes3.dex */
public final class m3<T> extends a<T, T> {

    final w<? extends T> b;

    static final class a<T> implements y<T> {

        final y<? super T> a;
        final w<? extends T> b;
        final g c = new g();
        boolean v = true;
        a(y<? super T> yVar, w<? extends T> wVar) {
            super();
            this.a = yVar;
            this.b = wVar;
            g gVar = new g();
        }

        public void onComplete() {
            if (this.v) {
                this.v = false;
                this.b.subscribe(this);
            } else {
                this.a.onComplete();
            }
        }

        public void onError(Throwable th) {
            this.a.onError(th);
        }

        public void onNext(T t) {
            if (this.v) {
                boolean z = false;
                this.v = z;
            }
            this.a.onNext(t);
        }

        public void onSubscribe(b bVar) {
            this.c.b(bVar);
        }
    }
    public m3(w<T> wVar, w<? extends T> wVar2) {
        super(wVar);
        this.b = wVar2;
    }

    @Override // i.b.m0.e.e.a
    public void subscribeActual(y<? super T> yVar) {
        final i.b.m0.e.e.m3.a aVar = new m3.a(yVar, this.b);
        yVar.onSubscribe(aVar.c);
        this.a.subscribe(aVar);
    }
}
