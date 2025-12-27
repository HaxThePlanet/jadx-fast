package i.b.m0.e.e;

import i.b.a0;
import i.b.d0;
import i.b.j0.b;
import i.b.m0.a.c;
import i.b.p0.a;
import i.b.w;
import i.b.y;
import java.util.NoSuchElementException;

/* compiled from: ObservableSingleSingle.java */
/* loaded from: classes3.dex */
public final class f3<T> extends a0<T> {

    final w<? extends T> a;
    final T b;

    static final class a<T> implements y<T>, b {

        final d0<? super T> a;
        final T b;
        b c;
        T v;
        boolean w;
        a(d0<? super T> d0Var, T t) {
            super();
            this.a = d0Var;
            this.b = t;
        }

        public void dispose() {
            this.c.dispose();
        }

        public boolean isDisposed() {
            return this.c.isDisposed();
        }

        public void onComplete() {
            Object obj;
            if (this.w) {
                return;
            }
            this.w = true;
            this.v = null;
            if (this.v == null) {
            }
            if (this.b != null) {
                this.a.onSuccess(obj);
            } else {
                this.a.onError(new NoSuchElementException());
            }
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
            if (this.v != null) {
                this.w = true;
                this.c.dispose();
                this.a.onError(new IllegalArgumentException("Sequence contains more than one element!"));
                return;
            }
            this.v = t;
        }

        public void onSubscribe(b bVar) {
            if (c.validate(this.c, bVar)) {
                this.c = bVar;
                this.a.onSubscribe(this);
            }
        }
    }
    public f3(w<? extends T> wVar, T t) {
        super();
        this.a = wVar;
        this.b = t;
    }

    @Override // i.b.a0
    public void subscribeActual(d0<? super T> d0Var) {
        this.a.subscribe(new f3.a(d0Var, this.b));
    }
}
