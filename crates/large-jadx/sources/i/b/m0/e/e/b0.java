package i.b.m0.e.e;

import i.b.j0.b;
import i.b.m0.a.c;
import i.b.r;
import i.b.t;
import i.b.u;
import i.b.y;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: ObservableCreate.java */
/* loaded from: classes3.dex */
public final class b0<T> extends r<T> {

    final u<T> a;

    static final class a<T> extends AtomicReference<b> implements t<T>, b {

        private static final long serialVersionUID = -3434801548987643227L;
        final y<? super T> observer;
        a(y<? super T> yVar) {
            super();
            this.observer = yVar;
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        public void a(Throwable th) {
            if (!b(th)) {
                a.t(th);
            }
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        public boolean b(Throwable th) {
            Object obj;
            if (th == null) {
                str = "onError called with null. Null values are generally not allowed in 2.x operators and sources.";
                java.lang.NullPointerException nullPointerException = new NullPointerException(str);
            }
            if (!isDisposed()) {
                try {
                    this.observer.onError(obj);
                } finally {
                    dispose();
                    throw th;
                }
                dispose();
                return true;
            }
            return false;
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
        public String toString() {
            Object[] arr = new Object[2];
            return String.format("%s{%s}", new Object[] { b0.a.class.getSimpleName(), super.toString() });
        }
    }
    public b0(u<T> uVar) {
        super();
        this.a = uVar;
    }

    @Override // i.b.r
    protected void subscribeActual(y<? super T> yVar) {
        final i.b.m0.e.e.b0.a aVar = new b0.a(yVar);
        yVar.onSubscribe(aVar);
        try {
            this.a.a(aVar);
        } catch (Throwable th) {
            a.b(th);
            obj.a(th);
        }
    }
}
