package i.b.m0.e.c;

import i.b.d;
import i.b.f;
import i.b.j0.b;
import i.b.l;
import i.b.m0.a.c;
import i.b.n;

/* compiled from: MaybeFromCompletable.java */
/* loaded from: classes3.dex */
public final class j<T> extends l<T> {

    final f a;

    static final class a<T> implements d, b {

        final n<? super T> a;
        b b;
        a(n<? super T> nVar) {
            super();
            this.a = nVar;
        }

        public void dispose() {
            this.b.dispose();
            this.b = c.DISPOSED;
        }

        public boolean isDisposed() {
            return this.b.isDisposed();
        }

        public void onComplete() {
            this.b = c.DISPOSED;
            this.a.onComplete();
        }

        public void onError(Throwable th) {
            this.b = c.DISPOSED;
            this.a.onError(th);
        }

        public void onSubscribe(b bVar) {
            if (c.validate(this.b, bVar)) {
                this.b = bVar;
                this.a.onSubscribe(this);
            }
        }
    }
    public j(f fVar) {
        super();
        this.a = fVar;
    }

    @Override // i.b.l
    protected void w(n<? super T> nVar) {
        this.a.b(new j.a(nVar));
    }
}
