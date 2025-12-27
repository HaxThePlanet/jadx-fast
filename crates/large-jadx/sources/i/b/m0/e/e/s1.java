package i.b.m0.e.e;

import i.b.j0.b;
import i.b.l;
import i.b.m0.a.c;
import i.b.n;
import i.b.w;
import i.b.y;

/* compiled from: ObservableLastMaybe.java */
/* loaded from: classes3.dex */
public final class s1<T> extends l<T> {

    final w<T> a;

    static final class a<T> implements y<T>, b {

        final n<? super T> a;
        b b;
        T c;
        a(n<? super T> nVar) {
            super();
            this.a = nVar;
        }

        public void dispose() {
            this.b.dispose();
            this.b = c.DISPOSED;
        }

        public boolean isDisposed() {
            boolean z = true;
            int r0 = this.b == c.DISPOSED ? 1 : 0;
            return (this.b == c.DISPOSED ? 1 : 0);
        }

        public void onComplete() {
            this.b = c.DISPOSED;
            if (this.c != null) {
                this.c = null;
                this.a.onSuccess(this.c);
            } else {
                this.a.onComplete();
            }
        }

        public void onError(Throwable th) {
            this.b = c.DISPOSED;
            this.c = null;
            this.a.onError(th);
        }

        public void onNext(T t) {
            this.c = t;
        }

        public void onSubscribe(b bVar) {
            if (c.validate(this.b, bVar)) {
                this.b = bVar;
                this.a.onSubscribe(this);
            }
        }
    }
    public s1(w<T> wVar) {
        super();
        this.a = wVar;
    }

    @Override // i.b.l
    protected void w(n<? super T> nVar) {
        this.a.subscribe(new s1.a(nVar));
    }
}
