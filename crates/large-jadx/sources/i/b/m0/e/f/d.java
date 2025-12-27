package i.b.m0.e.f;

import i.b.a0;
import i.b.c0;
import i.b.d0;
import i.b.e0;
import i.b.j0.b;
import i.b.m0.a.c;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: SingleCreate.java */
/* loaded from: classes3.dex */
public final class d<T> extends a0<T> {

    final e0<T> a;

    static final class a<T> extends AtomicReference<b> implements c0<T>, b {

        private static final long serialVersionUID = -2467358622224974244L;
        final d0<? super T> downstream;
        a(d0<? super T> d0Var) {
            super();
            this.downstream = d0Var;
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        public boolean a(Throwable th) {
            Object obj2;
            if (th == null) {
                str = "onError called with null. Null values are generally not allowed in 2.x operators and sources.";
                java.lang.NullPointerException nullPointerException = new NullPointerException(str);
            }
            c dISPOSED2 = c.DISPOSED;
            if (get() != c.DISPOSED) {
                Object andSet = getAndSet(c.DISPOSED);
                if (andSet != c.DISPOSED) {
                    try {
                        this.downstream.onError(obj2);
                    } catch (Throwable th) {
                    }
                    if (andSet != null) {
                        andSet.dispose();
                    }
                    return true;
                }
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
        public void onError(Throwable th) {
            if (!a(th)) {
                a.t(th);
            }
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        public void onSuccess(T t) {
            java.lang.NullPointerException nullPointerException;
            String str;
            d0 downstream2;
            dISPOSED2 = c.DISPOSED;
            if (get() != c.DISPOSED) {
                Object andSet = getAndSet(c.DISPOSED);
                if (andSet != c.DISPOSED && t == null) {
                    try {
                        str = "onSuccess called with null. Null values are generally not allowed in 2.x operators and sources.";
                        this.downstream.onError(new NullPointerException(str));
                        this.downstream.onSuccess(t);
                    } catch (Throwable th) {
                    }
                    if (andSet != null) {
                        andSet.dispose();
                    }
                }
            }
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        public String toString() {
            Object[] arr = new Object[2];
            return String.format("%s{%s}", new Object[] { d.a.class.getSimpleName(), super.toString() });
        }
    }
    public d(e0<T> e0Var) {
        super();
        this.a = e0Var;
    }

    @Override // i.b.a0
    protected void subscribeActual(d0<? super T> d0Var) {
        final i.b.m0.e.f.d.a aVar = new d.a(d0Var);
        d0Var.onSubscribe(aVar);
        try {
            this.a.a(aVar);
        } catch (Throwable th) {
            a.b(th);
            obj.onError(th);
        }
    }
}
