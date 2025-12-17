package i.b.m0.e.a;

import i.b.b;
import i.b.c;
import i.b.d;
import i.b.e;
import i.b.j0.b;
import i.b.m0.a.c;
import i.b.p0.a;
import io.reactivex.exceptions.a;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes3.dex */
public final class b extends b {

    final e a;

    static final class a extends AtomicReference<b> implements c, b {

        private static final long serialVersionUID = -2467358622224974244L;
        final d downstream;
        a(d d) {
            super();
            this.downstream = d;
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

        @Override // java.util.concurrent.atomic.AtomicReference
        public String toString() {
            Object[] arr = new Object[2];
            return String.format("%s{%s}", b.a.class.getSimpleName(), super.toString());
        }
    }
    public b(e e) {
        super();
        this.a = e;
    }

    @Override // i.b.b
    protected void x(d d) {
        e obj2;
        b.a aVar = new b.a(d);
        d.onSubscribe(aVar);
        this.a.a(aVar);
    }
}
