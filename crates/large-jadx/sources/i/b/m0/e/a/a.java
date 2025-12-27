package i.b.m0.e.a;

import i.b.d;
import i.b.f;
import i.b.m0.a.c;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: CompletableAndThenCompletable.java */
/* loaded from: classes3.dex */
public final class a extends i.b.b {

    final f a;
    final f b;

    static final class a implements d {

        final AtomicReference<i.b.j0.b> a;
        final d b;
        a(AtomicReference<i.b.j0.b> atomicReference, d dVar) {
            super();
            this.a = atomicReference;
            this.b = dVar;
        }

        public void onComplete() {
            this.b.onComplete();
        }

        public void onError(Throwable th) {
            this.b.onError(th);
        }

        public void onSubscribe(i.b.j0.b bVar) {
            c.replace(this.a, bVar);
        }
    }

    static final class b extends AtomicReference<i.b.j0.b> implements d, i.b.j0.b {

        private static final long serialVersionUID = -4101678820158072998L;
        final d actualObserver;
        final f next;
        b(d dVar, f fVar) {
            super();
            this.actualObserver = dVar;
            this.next = fVar;
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        public void dispose() {
            c.dispose(this);
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        public boolean isDisposed() {
            return c.isDisposed((b)get());
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        public void onComplete() {
            this.next.b(new a.a(this, this.actualObserver));
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        public void onError(Throwable th) {
            this.actualObserver.onError(th);
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        public void onSubscribe(i.b.j0.b bVar) {
            if (c.setOnce(this, bVar)) {
                this.actualObserver.onSubscribe(this);
            }
        }
    }
    public a(f fVar, f fVar2) {
        super();
        this.a = fVar;
        this.b = fVar2;
    }

    @Override // i.b.b
    protected void x(d dVar) {
        this.a.b(new a.b(dVar, this.b));
    }
}
