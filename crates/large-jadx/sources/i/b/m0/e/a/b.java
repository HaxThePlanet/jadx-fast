package i.b.m0.e.a;

import i.b.d;
import i.b.e;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: CompletableCreate.java */
/* loaded from: classes3.dex */
public final class b extends i.b.b {

    final e a;

    static final class a extends AtomicReference<i.b.j0.b> implements i.b.c, i.b.j0.b {

        private static final long serialVersionUID = -2467358622224974244L;
        final d downstream;
        a(d dVar) {
            super();
            this.downstream = dVar;
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        public boolean a(Throwable th) {
            Object obj2;
            if (th == null) {
                str = "onError called with null. Null values are generally not allowed in 2.x operators and sources.";
                java.lang.NullPointerException nullPointerException = new NullPointerException(str);
            }
            i.b.m0.a.c dISPOSED2 = c.DISPOSED;
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
        public String toString() {
            Object[] arr = new Object[2];
            return String.format("%s{%s}", new Object[] { b.a.class.getSimpleName(), super.toString() });
        }
    }
    public b(e eVar) {
        super();
        this.a = eVar;
    }

    @Override // i.b.b
    protected void x(d dVar) {
        final i.b.m0.e.a.b.a aVar = new b.a(dVar);
        dVar.onSubscribe(aVar);
        try {
            this.a.a(aVar);
        } catch (Throwable th) {
            a.b(th);
            obj.onError(th);
        }
    }
}
