package i.b.m0.e.e;

import i.b.j0.b;
import i.b.l0.o;
import i.b.m0.a.c;
import i.b.w;
import i.b.y;

/* compiled from: ObservableAll.java */
/* loaded from: classes3.dex */
public final class f<T> extends a<T, Boolean> {

    final o<? super T> b;

    static final class a<T> implements y<T>, b {

        final y<? super Boolean> a;
        final o<? super T> b;
        b c;
        boolean v;
        a(y<? super Boolean> yVar, o<? super T> oVar) {
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
            if (this.v) {
                return;
            }
            this.v = true;
            this.a.onNext(Boolean.TRUE);
            this.a.onComplete();
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
            try {
            } catch (Throwable th) {
                a.b(th);
                this.c.dispose();
                onError(th);
                return;
            }
            if (!this.b.test(t)) {
                this.v = true;
                this.c.dispose();
                this.a.onNext(Boolean.FALSE);
                this.a.onComplete();
            }
        }

        public void onSubscribe(b bVar) {
            if (c.validate(this.c, bVar)) {
                this.c = bVar;
                this.a.onSubscribe(this);
            }
        }
    }
    public f(w<T> wVar, o<? super T> oVar) {
        super(wVar);
        this.b = oVar;
    }

    @Override // i.b.m0.e.e.a
    protected void subscribeActual(y<? super Boolean> yVar) {
        this.a.subscribe(new f.a(yVar, this.b));
    }
}
