package i.b.m0.e.e;

import i.b.j0.b;
import i.b.l;
import i.b.m0.a.c;
import i.b.n;
import i.b.p0.a;
import i.b.w;
import i.b.y;

/* compiled from: ObservableSingleMaybe.java */
/* loaded from: classes3.dex */
public final class e3<T> extends l<T> {

    final w<T> a;

    static final class a<T> implements y<T>, b {

        final n<? super T> a;
        b b;
        T c;
        boolean v;
        a(n<? super T> nVar) {
            super();
            this.a = nVar;
        }

        public void dispose() {
            this.b.dispose();
        }

        public boolean isDisposed() {
            return this.b.isDisposed();
        }

        public void onComplete() {
            if (this.v) {
                return;
            }
            this.v = true;
            Object obj = null;
            this.c = obj;
            if (this.c == null) {
                this.a.onComplete();
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
            this.a.onError(th);
        }

        public void onNext(T t) {
            if (this.v) {
                return;
            }
            if (this.c != null) {
                this.v = true;
                this.b.dispose();
                this.a.onError(new IllegalArgumentException("Sequence contains more than one element!"));
                return;
            }
            this.c = t;
        }

        public void onSubscribe(b bVar) {
            if (c.validate(this.b, bVar)) {
                this.b = bVar;
                this.a.onSubscribe(this);
            }
        }
    }
    public e3(w<T> wVar) {
        super();
        this.a = wVar;
    }

    @Override // i.b.l
    public void w(n<? super T> nVar) {
        this.a.subscribe(new e3.a(nVar));
    }
}
