package i.b.m0.e.f;

import i.b.a0;
import i.b.d0;
import i.b.j0.b;
import i.b.k;
import i.b.m0.i.g;
import java.util.NoSuchElementException;
import m.c.c;

/* compiled from: SingleFromPublisher.java */
/* loaded from: classes3.dex */
public final class e0<T> extends a0<T> {

    final m.c.a<? extends T> a;

    static final class a<T> implements k<T>, b {

        final d0<? super T> a;
        c b;
        T c;
        boolean v;
        volatile boolean w;
        a(d0<? super T> d0Var) {
            super();
            this.a = d0Var;
        }

        public void dispose() {
            this.w = true;
            this.b.cancel();
        }

        public boolean isDisposed() {
            return this.w;
        }

        public void onComplete() {
            if (this.v) {
                return;
            }
            this.v = true;
            this.c = null;
            if (this.c == null) {
                str = "The source Publisher is empty";
                this.a.onError(new NoSuchElementException(str));
            } else {
                this.a.onSuccess(this.c);
            }
        }

        public void onError(Throwable th) {
            if (this.v) {
                a.t(th);
                return;
            }
            this.v = true;
            this.c = null;
            this.a.onError(th);
        }

        public void onNext(T t) {
            if (this.v) {
                return;
            }
            if (this.c != null) {
                this.b.cancel();
                this.v = true;
                this.c = null;
                str = "Too many elements in the Publisher";
                this.a.onError(new IndexOutOfBoundsException(str));
            } else {
                this.c = t;
            }
        }

        public void onSubscribe(c cVar) {
            if (g.validate(this.b, cVar)) {
                this.b = cVar;
                this.a.onSubscribe(this);
                cVar.request(Long.MAX_VALUE);
            }
        }
    }
    public e0(m.c.a<? extends T> aVar) {
        super();
        this.a = aVar;
    }

    @Override // i.b.a0
    protected void subscribeActual(d0<? super T> d0Var) {
        this.a.a(new e0.a(d0Var));
    }
}
