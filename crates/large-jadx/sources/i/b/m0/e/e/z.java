package i.b.m0.e.e;

import i.b.j0.b;
import i.b.m0.a.c;
import i.b.w;
import i.b.y;

/* compiled from: ObservableCount.java */
/* loaded from: classes3.dex */
public final class z<T> extends a<T, Long> {

    static final class a implements y<Object>, b {

        final y<? super Long> a;
        b b;
        long c;
        a(y<? super Long> yVar) {
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
            this.a.onNext(Long.valueOf(this.c));
            this.a.onComplete();
        }

        public void onError(Throwable th) {
            this.a.onError(th);
        }

        public void onNext(Object object) {
            this.c++;
        }

        public void onSubscribe(b bVar) {
            if (c.validate(this.b, bVar)) {
                this.b = bVar;
                this.a.onSubscribe(this);
            }
        }
    }
    public z(w<T> wVar) {
        super(wVar);
    }

    @Override // i.b.m0.e.e.a
    public void subscribeActual(y<? super Long> yVar) {
        this.a.subscribe(new z.a(yVar));
    }
}
