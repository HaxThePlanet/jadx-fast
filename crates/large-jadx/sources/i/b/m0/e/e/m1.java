package i.b.m0.e.e;

import i.b.p0.a;
import i.b.r;
import i.b.w;
import i.b.y;

/* compiled from: ObservableIgnoreElementsCompletable.java */
/* loaded from: classes3.dex */
public final class m1<T> extends i.b.b implements i.b.m0.c.d<T> {

    final w<T> a;

    static final class a<T> implements y<T>, i.b.j0.b {

        final i.b.d a;
        i.b.j0.b b;
        a(i.b.d dVar) {
            super();
            this.a = dVar;
        }

        public void dispose() {
            this.b.dispose();
        }

        public boolean isDisposed() {
            return this.b.isDisposed();
        }

        public void onComplete() {
            this.a.onComplete();
        }

        public void onError(Throwable th) {
            this.a.onError(th);
        }

        public void onSubscribe(i.b.j0.b bVar) {
            this.b = bVar;
            this.a.onSubscribe(this);
        }

        public void onNext(T t) {
        }
    }
    public m1(w<T> wVar) {
        super();
        this.a = wVar;
    }

    @Override // i.b.b
    public r<T> a() {
        return a.n(new l1(this.a));
    }

    @Override // i.b.b
    public void x(i.b.d dVar) {
        this.a.subscribe(new m1.a(dVar));
    }
}
