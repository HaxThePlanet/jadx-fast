package i.b.m0.e.e;

import i.b.m0.j.n;
import i.b.o0.b;
import i.b.w;
import java.util.Iterator;

/* compiled from: BlockingObservableMostRecent.java */
/* loaded from: classes3.dex */
public final class d<T> implements Iterable<T> {

    final w<T> a;
    final T b;

    static final class a<T> extends b<T> {

        volatile Object b;
        a(T t) {
            super();
            this.b = n.next(t);
        }

        @Override // i.b.o0.b
        public d.a.a<T> b() {
            return new d.a.a(this);
        }

        @Override // i.b.o0.b
        public void onComplete() {
            this.b = n.complete();
        }

        @Override // i.b.o0.b
        public void onError(Throwable th) {
            this.b = n.error(th);
        }

        @Override // i.b.o0.b
        public void onNext(T t) {
            this.b = n.next(t);
        }
    }
    public d(w<T> wVar, T t) {
        super();
        this.a = wVar;
        this.b = t;
    }

    @Override // java.lang.Iterable
    public Iterator<T> iterator() {
        i.b.m0.e.e.d.a aVar = new d.a(this.b);
        this.a.subscribe(aVar);
        return aVar.b();
    }
}
