package i.b.m0.e.e;

import i.b.j0.b;
import i.b.l0.o;
import i.b.m0.a.c;
import i.b.w;
import i.b.y;

/* compiled from: ObservableTakeUntilPredicate.java */
/* loaded from: classes3.dex */
public final class t3<T> extends a<T, T> {

    final o<? super T> b;

    static final class a<T> implements y<T>, b {

        final y<? super T> a;
        final o<? super T> b;
        b c;
        boolean v;
        a(y<? super T> yVar, o<? super T> oVar) {
            super();
            this.a = yVar;
            this.b = oVar;
        }

        public void dispose() {
            this.c.dispose();
        }

        public boolean isDisposed() {
            return this.c.isDisposed();
        }

        public void onComplete() {
            if (!this.v) {
                this.v = true;
                this.a.onComplete();
            }
        }

        public void onError(Throwable th) {
            if (!this.v) {
                this.v = true;
                this.a.onError(th);
            } else {
                a.t(th);
            }
        }

        public void onNext(T t) {
            if (!this.v) {
                this.a.onNext(t);
                try {
                } catch (Throwable th) {
                    a.b(th);
                    this.c.dispose();
                    onError(th);
                }
                if (this.b.test(t)) {
                    this.v = true;
                    this.c.dispose();
                    this.a.onComplete();
                }
            }
        }

        public void onSubscribe(b bVar) {
            if (c.validate(this.c, bVar)) {
                this.c = bVar;
                this.a.onSubscribe(this);
            }
        }
    }
    public t3(w<T> wVar, o<? super T> oVar) {
        super(wVar);
        this.b = oVar;
    }

    @Override // i.b.m0.e.e.a
    public void subscribeActual(y<? super T> yVar) {
        this.a.subscribe(new t3.a(yVar, this.b));
    }
}
