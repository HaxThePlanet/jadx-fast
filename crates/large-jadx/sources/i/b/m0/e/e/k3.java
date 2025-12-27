package i.b.m0.e.e;

import i.b.j0.b;
import i.b.l0.o;
import i.b.m0.a.c;
import i.b.w;
import i.b.y;
import io.reactivex.exceptions.a;

/* compiled from: ObservableSkipWhile.java */
/* loaded from: classes3.dex */
public final class k3<T> extends a<T, T> {

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
            this.a.onComplete();
        }

        public void onError(Throwable th) {
            this.a.onError(th);
        }

        public void onNext(T t) {
            if (this.v) {
                this.a.onNext(t);
            } else {
                try {
                } catch (Throwable th) {
                    a.b(th);
                    this.c.dispose();
                    this.c.onError(th);
                    return;
                }
                if (!this.b.test(t)) {
                    this.v = true;
                    this.a.onNext(th);
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
    public k3(w<T> wVar, o<? super T> oVar) {
        super(wVar);
        this.b = oVar;
    }

    @Override // i.b.m0.e.e.a
    public void subscribeActual(y<? super T> yVar) {
        this.a.subscribe(new k3.a(yVar, this.b));
    }
}
