package i.b.m0.e.e;

import i.b.l;
import i.b.n;
import i.b.w;
import i.b.y;

/* compiled from: ObservableReduceMaybe.java */
/* loaded from: classes3.dex */
public final class l2<T> extends l<T> {

    final w<T> a;
    final i.b.l0.c<T, T, T> b;

    static final class a<T> implements y<T>, i.b.j0.b {

        final n<? super T> a;
        final i.b.l0.c<T, T, T> b;
        boolean c;
        T v;
        i.b.j0.b w;
        a(n<? super T> nVar, i.b.l0.c<T, T, T> cVar) {
            super();
            this.a = nVar;
            this.b = cVar;
        }

        public void dispose() {
            this.w.dispose();
        }

        public boolean isDisposed() {
            return this.w.isDisposed();
        }

        public void onComplete() {
            if (this.c) {
                return;
            }
            this.c = true;
            this.v = null;
            if (this.v != null) {
                this.a.onSuccess(this.v);
            } else {
                this.a.onComplete();
            }
        }

        public void onError(Throwable th) {
            if (this.c) {
                a.t(th);
                return;
            }
            this.c = true;
            this.v = null;
            this.a.onError(th);
        }

        public void onNext(T t) {
            if (!this.c && this.v == null) {
                this.v = t;
            }
        }

        public void onSubscribe(i.b.j0.b bVar) {
            if (c.validate(this.w, bVar)) {
                this.w = bVar;
                this.a.onSubscribe(this);
            }
        }
    }
    public l2(w<T> wVar, i.b.l0.c<T, T, T> cVar) {
        super();
        this.a = wVar;
        this.b = cVar;
    }

    @Override // i.b.l
    protected void w(n<? super T> nVar) {
        this.a.subscribe(new l2.a(nVar, this.b));
    }
}
