package i.b.m0.e.c;

import i.b.d;
import i.b.f;
import i.b.j0.b;
import i.b.l;
import i.b.m0.a.c;
import i.b.n;

/* loaded from: classes3.dex */
public final class j<T>  extends l<T> {

    final f a;

    static final class a implements d, b {

        final n<? super T> a;
        b b;
        a(n<? super T> n) {
            super();
            this.a = n;
        }

        @Override // i.b.d
        public void dispose() {
            this.b.dispose();
            this.b = c.DISPOSED;
        }

        @Override // i.b.d
        public boolean isDisposed() {
            return this.b.isDisposed();
        }

        @Override // i.b.d
        public void onComplete() {
            this.b = c.DISPOSED;
            this.a.onComplete();
        }

        @Override // i.b.d
        public void onError(Throwable throwable) {
            this.b = c.DISPOSED;
            this.a.onError(throwable);
        }

        @Override // i.b.d
        public void onSubscribe(b b) {
            Object obj2;
            if (c.validate(this.b, b)) {
                this.b = b;
                this.a.onSubscribe(this);
            }
        }
    }
    public j(f f) {
        super();
        this.a = f;
    }

    protected void w(n<? super T> n) {
        j.a aVar = new j.a(n);
        this.a.b(aVar);
    }
}
