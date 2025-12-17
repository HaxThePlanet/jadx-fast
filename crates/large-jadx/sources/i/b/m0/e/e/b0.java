package i.b.m0.e.e;

import i.b.j0.b;
import i.b.m0.a.c;
import i.b.p0.a;
import i.b.r;
import i.b.t;
import i.b.u;
import i.b.y;
import io.reactivex.exceptions.a;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes3.dex */
public final class b0<T>  extends r<T> {

    final u<T> a;

    static final class a extends AtomicReference<b> implements t<T>, b {

        private static final long serialVersionUID = -3434801548987643227L;
        final y<? super T> observer;
        a(y<? super T> y) {
            super();
            this.observer = y;
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        public void a(Throwable throwable) {
            if (!b(throwable)) {
                a.t(throwable);
            }
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        public boolean b(Throwable throwable) {
            String str;
            Object obj2;
            if (throwable == null) {
                obj2 = new NullPointerException("onError called with null. Null values are generally not allowed in 2.x operators and sources.");
            }
            if (!isDisposed()) {
                this.observer.onError(obj2);
                dispose();
                return 1;
            }
            return 0;
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
            return String.format("%s{%s}", b0.a.class.getSimpleName(), super.toString());
        }
    }
    public b0(u<T> u) {
        super();
        this.a = u;
    }

    protected void subscribeActual(y<? super T> y) {
        u obj2;
        b0.a aVar = new b0.a(y);
        y.onSubscribe(aVar);
        this.a.a(aVar);
    }
}
