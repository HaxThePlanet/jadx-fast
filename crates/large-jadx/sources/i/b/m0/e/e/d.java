package i.b.m0.e.e;

import i.b.m0.j.n;
import i.b.o0.b;
import i.b.w;
import java.util.Iterator;

/* loaded from: classes3.dex */
public final class d<T>  implements Iterable<T> {

    final w<T> a;
    final T b;

    static final class a extends b<T> {

        volatile Object b;
        a(T t) {
            super();
            this.b = n.next(t);
        }

        public i.b.m0.e.e.d.a.a<T> b() {
            d.a.a aVar = new d.a.a(this);
            return aVar;
        }

        @Override // i.b.o0.b
        public void onComplete() {
            this.b = n.complete();
        }

        @Override // i.b.o0.b
        public void onError(Throwable throwable) {
            this.b = n.error(throwable);
        }

        public void onNext(T t) {
            this.b = n.next(t);
        }
    }
    public d(w<T> w, T t2) {
        super();
        this.a = w;
        this.b = t2;
    }

    public Iterator<T> iterator() {
        d.a aVar = new d.a(this.b);
        this.a.subscribe(aVar);
        return aVar.b();
    }
}
