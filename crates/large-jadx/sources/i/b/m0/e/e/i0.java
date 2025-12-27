package i.b.m0.e.e;

import i.b.j0.b;
import i.b.m0.a.c;
import i.b.m0.j.h;
import i.b.w;
import i.b.y;

/* compiled from: ObservableDetach.java */
/* loaded from: classes3.dex */
public final class i0<T> extends a<T, T> {

    static final class a<T> implements y<T>, b {

        y<? super T> a;
        b b;
        a(y<? super T> yVar) {
            super();
            this.a = yVar;
        }

        public void dispose() {
            this.b = h.INSTANCE;
            this.a = h.asObserver();
            this.b.dispose();
        }

        public boolean isDisposed() {
            return this.b.isDisposed();
        }

        public void onComplete() {
            this.b = h.INSTANCE;
            this.a = h.asObserver();
            this.a.onComplete();
        }

        public void onError(Throwable th) {
            this.b = h.INSTANCE;
            this.a = h.asObserver();
            this.a.onError(th);
        }

        public void onNext(T t) {
            this.a.onNext(t);
        }

        public void onSubscribe(b bVar) {
            if (c.validate(this.b, bVar)) {
                this.b = bVar;
                this.a.onSubscribe(this);
            }
        }
    }
    public i0(w<T> wVar) {
        super(wVar);
    }

    @Override // i.b.m0.e.e.a
    protected void subscribeActual(y<? super T> yVar) {
        this.a.subscribe(new i0.a(yVar));
    }
}
