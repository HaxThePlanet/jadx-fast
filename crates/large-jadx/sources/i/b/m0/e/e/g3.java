package i.b.m0.e.e;

import i.b.j0.b;
import i.b.m0.a.c;
import i.b.w;
import i.b.y;

/* compiled from: ObservableSkip.java */
/* loaded from: classes3.dex */
public final class g3<T> extends a<T, T> {

    final long b;

    static final class a<T> implements y<T>, b {

        final y<? super T> a;
        long b;
        b c;
        a(y<? super T> yVar, long j) {
            super();
            this.a = yVar;
            this.b = j;
        }

        public void dispose() {
            this.c.dispose();
        }

        public boolean isDisposed() {
            return this.c.isDisposed();
        }

        public void onComplete() {
            this.a.onComplete();
        }

        public void onError(Throwable th) {
            this.a.onError(th);
        }

        public void onNext(T t) {
            if (this.b != 0) {
                long l2 = 1L;
                this.b -= l2;
            } else {
                this.a.onNext(t);
            }
        }

        public void onSubscribe(b bVar) {
            if (c.validate(this.c, bVar)) {
                this.c = bVar;
                this.a.onSubscribe(this);
            }
        }
    }
    public g3(w<T> wVar, long j) {
        super(wVar);
        this.b = j;
    }

    @Override // i.b.m0.e.e.a
    public void subscribeActual(y<? super T> yVar) {
        this.a.subscribe(new g3.a(yVar, this.b, r3));
    }
}
