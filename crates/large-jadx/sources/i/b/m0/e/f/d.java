package i.b.m0.e.f;

import i.b.a0;
import i.b.c0;
import i.b.d0;
import i.b.e0;
import i.b.j0.b;
import i.b.m0.a.c;
import i.b.p0.a;
import io.reactivex.exceptions.a;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes3.dex */
public final class d<T>  extends a0<T> {

    final e0<T> a;

    static final class a extends AtomicReference<b> implements c0<T>, b {

        private static final long serialVersionUID = -2467358622224974244L;
        final d0<? super T> downstream;
        a(d0<? super T> d0) {
            super();
            this.downstream = d0;
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        public boolean a(Throwable throwable) {
            String str;
            Object andSet;
            Object obj3;
            if (throwable == null) {
                obj3 = new NullPointerException("onError called with null. Null values are generally not allowed in 2.x operators and sources.");
            }
            c dISPOSED = c.DISPOSED;
            andSet = getAndSet(dISPOSED);
            this.downstream.onError(obj3);
            if (get() != dISPOSED && (b)andSet != dISPOSED && (b)andSet != null) {
                andSet = getAndSet(dISPOSED);
                if ((b)(b)andSet != dISPOSED) {
                    this.downstream.onError(obj3);
                    if ((b)(b)andSet != null) {
                        (b)(b)andSet.dispose();
                    }
                    return 1;
                }
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
        public void onError(Throwable throwable) {
            if (!a(throwable)) {
                a.t(throwable);
            }
        }

        public void onSuccess(T t) {
            Object andSet;
            Object nullPointerException;
            String str;
            Object obj4;
            nullPointerException = c.DISPOSED;
            andSet = getAndSet(nullPointerException);
            if (get() != nullPointerException && (b)andSet != nullPointerException) {
                andSet = getAndSet(nullPointerException);
                if ((b)(b)andSet != nullPointerException) {
                    if (t == null) {
                        nullPointerException = new NullPointerException("onSuccess called with null. Null values are generally not allowed in 2.x operators and sources.");
                        this.downstream.onError(nullPointerException);
                    } else {
                        this.downstream.onSuccess(t);
                    }
                    if ((b)(b)andSet != null) {
                        (b)(b)andSet.dispose();
                    }
                }
            }
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        public String toString() {
            Object[] arr = new Object[2];
            return String.format("%s{%s}", d.a.class.getSimpleName(), super.toString());
        }
    }
    public d(e0<T> e0) {
        super();
        this.a = e0;
    }

    protected void subscribeActual(d0<? super T> d0) {
        e0 obj2;
        d.a aVar = new d.a(d0);
        d0.onSubscribe(aVar);
        this.a.a(aVar);
    }
}
