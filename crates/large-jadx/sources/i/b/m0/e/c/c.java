package i.b.m0.e.c;

import i.b.j0.b;
import i.b.l;
import i.b.m;
import i.b.m0.a.c;
import i.b.n;
import i.b.o;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: MaybeCreate.java */
/* loaded from: classes3.dex */
public final class c<T> extends l<T> {

    final o<T> a;

    static final class a<T> extends AtomicReference<b> implements m<T>, b {

        private static final long serialVersionUID = -2467358622224974244L;
        final n<? super T> downstream;
        a(n<? super T> nVar) {
            super();
            this.downstream = nVar;
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
        public void onComplete() {
            Throwable th;
            dISPOSED2 = c.DISPOSED;
            if (get() != c.DISPOSED) {
                Object andSet = getAndSet(c.DISPOSED);
                if (andSet != c.DISPOSED) {
                    try {
                        this.downstream.onComplete();
                    } catch (Throwable th) {
                    }
                    if (andSet != null) {
                        andSet.dispose();
                    }
                }
            }
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
            n downstream2;
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
            return String.format("%s{%s}", new Object[] { c.a.class.getSimpleName(), super.toString() });
        }
    }
    public c(o<T> oVar) {
        super();
        this.a = oVar;
    }

    @Override // i.b.l
    protected void w(n<? super T> nVar) {
        final i.b.m0.e.c.c.a aVar = new c.a(nVar);
        nVar.onSubscribe(aVar);
        try {
            this.a.a(aVar);
        } catch (Throwable th) {
            a.b(th);
            obj.onError(th);
        }
    }
}
