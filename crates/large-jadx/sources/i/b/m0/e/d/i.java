package i.b.m0.e.d;

import i.b.f;
import i.b.g0;
import i.b.l0.n;
import i.b.m0.b.b;
import i.b.m0.e.c.v;
import i.b.m0.e.f.v0;
import i.b.p;
import i.b.y;
import io.reactivex.exceptions.a;
import java.util.concurrent.Callable;

/* compiled from: ScalarXMapZHelper.java */
/* loaded from: classes3.dex */
final class i {
    static <T> boolean a(Object object, n<? super T, ? extends f> nVar, i.b.d dVar) {
        int i = 0;
        if (object instanceof Callable) {
            i = 0;
            try {
                Object object2 = object.call();
                if (object2 != null) {
                    object2 = nVar.apply(object2);
                    str = "The mapper returned a null CompletableSource";
                    b.e(object2, str);
                }
            } catch (Throwable th) {
                a.b(th);
                d.error(th, dVar);
                return z2;
            }
            if (i == 0) {
                d.complete(dVar);
            } else {
                i.b(dVar);
            }
            return true;
        }
        return false;
    }

    static <T, R> boolean b(Object object, n<? super T, ? extends p<? extends R>> nVar, y<? super R> yVar) {
        int i = 0;
        Object object2;
        if (object instanceof Callable) {
            i = 0;
            try {
                object2 = object.call();
                if (object2 != null) {
                    object2 = nVar.apply(object2);
                    str = "The mapper returned a null MaybeSource";
                    b.e(object2, str);
                }
            } catch (Throwable th) {
                a.b(th);
                d.error(th, yVar);
                return z2;
            }
            if (i == 0) {
                d.complete(yVar);
            } else {
                i.b(v.c(yVar));
            }
            return true;
        }
        return false;
    }

    static <T, R> boolean c(Object object, n<? super T, ? extends g0<? extends R>> nVar, y<? super R> yVar) {
        int i = 0;
        Object object2;
        if (object instanceof Callable) {
            i = 0;
            try {
                object2 = object.call();
                if (object2 != null) {
                    object2 = nVar.apply(object2);
                    str = "The mapper returned a null SingleSource";
                    b.e(object2, str);
                }
            } catch (Throwable th) {
                a.b(th);
                d.error(th, yVar);
                return z2;
            }
            if (i == 0) {
                d.complete(yVar);
            } else {
                i.subscribe(v0.c(yVar));
            }
            return true;
        }
        return false;
    }
}
