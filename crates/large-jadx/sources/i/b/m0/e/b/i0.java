package i.b.m0.e.b;

import i.b.h;
import i.b.l0.n;
import i.b.m0.i.d;
import i.b.m0.i.e;
import java.util.concurrent.Callable;

/* compiled from: FlowableScalarXMap.java */
/* loaded from: classes3.dex */
public final class i0 {

    static final class a<T, R> extends h<R> {

        final T b;
        final n<? super T, ? extends m.c.a<? extends R>> c;
        a(T t, n<? super T, ? extends m.c.a<? extends R>> nVar) {
            super();
            this.b = t;
            this.c = nVar;
        }

        @Override // i.b.h
        public void c0(m.c.b<? super R> bVar) {
            try {
                Object apply = this.c.apply(this.b);
                b.e(apply, "The mapper returned a null Publisher");
            } catch (Throwable th) {
                a.b(th);
                d.error(th, bVar);
                return;
            }
            z = apply instanceof Callable;
            if (apply instanceof Callable) {
                try {
                    apply = apply.call();
                } catch (Throwable th) {
                    a.b(th);
                    d.error(th, bVar);
                    return;
                }
                if (this.c == null) {
                    d.complete(bVar);
                    return;
                }
                bVar.onSubscribe(new e(bVar, apply));
            } else {
                apply.a(bVar);
            }
        }
    }
    public static <T, U> h<U> a(T t, n<? super T, ? extends m.c.a<? extends U>> nVar) {
        return a.l(new i0.a(t, nVar));
    }

    public static <T, R> boolean b(m.c.a<T> aVar, m.c.b<? super R> bVar, n<? super T, ? extends m.c.a<? extends R>> nVar) {
        if (aVar instanceof Callable) {
            boolean z3 = true;
            try {
                Object call = aVar.call();
            } catch (Throwable th) {
                a.b(th);
                d.error(th, bVar);
                return z;
            }
            if (call == null) {
                d.complete(bVar);
                return true;
            }
            try {
                Object apply = nVar.apply(call);
                b.e(apply, "The mapper returned a null Publisher");
            } catch (Throwable th) {
                a.b(th);
                d.error(th, bVar);
                return z;
            }
            if (apply instanceof Callable) {
                try {
                    apply = apply.call();
                } catch (Throwable th) {
                    a.b(th);
                    d.error(th, bVar);
                    return z;
                }
                if (apply == null) {
                    d.complete(bVar);
                    return true;
                }
                bVar.onSubscribe(new e(bVar, apply));
            } else {
                apply.a(bVar);
            }
            return true;
        }
        return false;
    }
}
