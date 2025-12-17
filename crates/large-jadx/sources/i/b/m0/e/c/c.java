package i.b.m0.e.c;

import i.b.j0.b;
import i.b.l;
import i.b.m;
import i.b.m0.a.c;
import i.b.n;
import i.b.o;
import i.b.p0.a;
import io.reactivex.exceptions.a;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes3.dex */
public final class c<T>  extends l<T> {

    final o<T> a;

    static final class a extends AtomicReference<b> implements m<T>, b {

        private static final long serialVersionUID = -2467358622224974244L;
        final n<? super T> downstream;
        a(n<? super T> n) {
            super();
            this.downstream = n;
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
        public void onComplete() {
            Object andSet;
            Throwable th;
            Object dISPOSED;
            dISPOSED = c.DISPOSED;
            andSet = getAndSet(dISPOSED);
            this.downstream.onComplete();
            if (get() != dISPOSED && (b)andSet != dISPOSED && (b)andSet != null) {
                andSet = getAndSet(dISPOSED);
                if ((b)(b)andSet != dISPOSED) {
                    this.downstream.onComplete();
                    if ((b)(b)andSet != null) {
                        (b)(b)andSet.dispose();
                    }
                }
            }
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
            return String.format("%s{%s}", c.a.class.getSimpleName(), super.toString());
        }
    }
    public c(o<T> o) {
        super();
        this.a = o;
    }

    protected void w(n<? super T> n) {
        o obj2;
        c.a aVar = new c.a(n);
        n.onSubscribe(aVar);
        this.a.a(aVar);
    }
}
