package i.b.m0.e.e;

import i.b.w;
import i.b.y;

/* compiled from: ObservableScan.java */
/* loaded from: classes3.dex */
public final class z2<T> extends a<T, T> {

    final i.b.l0.c<T, T, T> b;

    static final class a<T> implements y<T>, i.b.j0.b {

        final y<? super T> a;
        final i.b.l0.c<T, T, T> b;
        i.b.j0.b c;
        T v;
        boolean w;
        a(y<? super T> yVar, i.b.l0.c<T, T, T> cVar) {
            super();
            this.a = yVar;
            this.b = cVar;
        }

        public void dispose() {
            this.c.dispose();
        }

        public boolean isDisposed() {
            return this.c.isDisposed();
        }

        public void onComplete() {
            if (this.w) {
                return;
            }
            this.w = true;
            this.a.onComplete();
        }

        public void onError(Throwable th) {
            if (this.w) {
                a.t(th);
                return;
            }
            this.w = true;
            this.a.onError(th);
        }

        public void onNext(T t) {
            if (this.w) {
                return;
            }
            if (this.v == null) {
                this.v = t;
                this.a.onNext(t);
            } else {
                try {
                    Object apply = this.b.apply(this.v, t);
                    b.e(apply, "The value returned by the accumulator is null");
                } catch (Throwable th) {
                    a.b(th);
                    this.c.dispose();
                    onError(th);
                    return;
                }
                this.v = apply;
                this.a.onNext(apply);
            }
        }

        public void onSubscribe(i.b.j0.b bVar) {
            if (c.validate(this.c, bVar)) {
                this.c = bVar;
                this.a.onSubscribe(this);
            }
        }
    }
    public z2(w<T> wVar, i.b.l0.c<T, T, T> cVar) {
        super(wVar);
        this.b = cVar;
    }

    @Override // i.b.m0.e.e.a
    public void subscribeActual(y<? super T> yVar) {
        this.a.subscribe(new z2.a(yVar, this.b));
    }
}
