package i.b.m0.e.a;

import i.b.b;
import i.b.d;
import i.b.f;
import i.b.j0.b;
import i.b.m0.a.c;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes3.dex */
public final class a extends b {

    final f a;
    final f b;

    static final class a implements d {

        final AtomicReference<b> a;
        final d b;
        a(AtomicReference<b> atomicReference, d d2) {
            super();
            this.a = atomicReference;
            this.b = d2;
        }

        @Override // i.b.d
        public void onComplete() {
            this.b.onComplete();
        }

        @Override // i.b.d
        public void onError(Throwable throwable) {
            this.b.onError(throwable);
        }

        @Override // i.b.d
        public void onSubscribe(b b) {
            c.replace(this.a, b);
        }
    }

    static final class b extends AtomicReference<b> implements d, b {

        private static final long serialVersionUID = -4101678820158072998L;
        final d actualObserver;
        final f next;
        b(d d, f f2) {
            super();
            this.actualObserver = d;
            this.next = f2;
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
            a.a aVar = new a.a(this, this.actualObserver);
            this.next.b(aVar);
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        public void onError(Throwable throwable) {
            this.actualObserver.onError(throwable);
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        public void onSubscribe(b b) {
            boolean obj1;
            if (c.setOnce(this, b)) {
                this.actualObserver.onSubscribe(this);
            }
        }
    }
    public a(f f, f f2) {
        super();
        this.a = f;
        this.b = f2;
    }

    @Override // i.b.b
    protected void x(d d) {
        a.b bVar = new a.b(d, this.b);
        this.a.b(bVar);
    }
}
