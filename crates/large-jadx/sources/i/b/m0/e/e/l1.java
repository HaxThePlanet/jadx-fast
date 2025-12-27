package i.b.m0.e.e;

import i.b.j0.b;
import i.b.w;
import i.b.y;

/* compiled from: ObservableIgnoreElements.java */
/* loaded from: classes3.dex */
public final class l1<T> extends a<T, T> {

    static final class a<T> implements y<T>, b {

        final y<? super T> a;
        b b;
        a(y<? super T> yVar) {
            super();
            this.a = yVar;
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

        public void onSubscribe(b bVar) {
            this.b = bVar;
            this.a.onSubscribe(this);
        }

        public void onNext(T t) {
        }
    }
    public l1(w<T> wVar) {
        super(wVar);
    }

    @Override // i.b.m0.e.e.a
    public void subscribeActual(y<? super T> yVar) {
        this.a.subscribe(new l1.a(yVar));
    }
}
