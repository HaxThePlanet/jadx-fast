package i.b.m0.e.b;

import i.b.h;
import i.b.l0.n;
import i.b.m0.b.b;
import i.b.m0.i.d;
import i.b.m0.i.e;
import i.b.p0.a;
import io.reactivex.exceptions.a;
import java.util.concurrent.Callable;
import m.c.a;
import m.c.b;

/* loaded from: classes3.dex */
public final class i0 {

    static final class a extends h<R> {

        final T b;
        final n<? super T, ? extends a<? extends R>> c;
        a(T t, n<? super T, ? extends a<? extends R>> n2) {
            super();
            this.b = t;
            this.c = n2;
        }

        public void c0(b<? super R> b) {
            Object apply;
            boolean eVar;
            try {
                apply = this.c.apply(this.b);
                b.e(apply, "The mapper returned a null Publisher");
                if (apply instanceof Callable) {
                } else {
                }
                apply = (Callable)(a)apply.call();
                if (apply == null) {
                }
                d.complete(b);
                eVar = new e(b, apply);
                b.onSubscribe(eVar);
                a.b(th);
                d.error(th, b);
                apply.a(b);
                d.error(th, b);
            } catch (Throwable th) {
            }
        }
    }
    public static <T, U> h<U> a(T t, n<? super T, ? extends a<? extends U>> n2) {
        i0.a aVar = new i0.a(t, n2);
        return a.l(aVar);
    }

    public static <T, R> boolean b(a<T> a, b<? super R> b2, n<? super T, ? extends a<? extends R>> n3) {
        Object obj1;
        boolean obj3;
        int i = 1;
        obj1 = (Callable)a.call();
        if (a instanceof Callable && obj1 == null) {
            i = 1;
            obj1 = (Callable)a.call();
            if (obj1 == null) {
                d.complete(b2);
                return i;
            }
            obj1 = n3.apply(obj1);
            b.e(obj1, "The mapper returned a null Publisher");
            if (obj1 instanceof Callable) {
                obj1 = (Callable)(a)obj1.call();
                if (obj1 == null) {
                    try {
                        d.complete(b2);
                        return i;
                        obj3 = new e(b2, obj1);
                        b2.onSubscribe(obj3);
                        a.b(a);
                        d.error(a, b2);
                        return obj0;
                        obj1.a(b2);
                        return i;
                        a.b(a);
                        d.error(a, b2);
                        return obj0;
                    } catch (Throwable th) {
                    }
                }
            } else {
            }
        }
        return 0;
    }
}
