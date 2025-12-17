package i.b.m0.e.d;

import i.b.d;
import i.b.f;
import i.b.g0;
import i.b.l0.n;
import i.b.m0.a.d;
import i.b.m0.b.b;
import i.b.m0.e.c.v;
import i.b.m0.e.f.v0;
import i.b.p;
import i.b.y;
import io.reactivex.exceptions.a;
import java.util.concurrent.Callable;

/* loaded from: classes3.dex */
final class i {
    static <T> boolean a(Object object, n<? super T, ? extends f> n2, d d3) {
        int i;
        Object obj2;
        String obj3;
        i = 0;
        obj2 = (Callable)object.call();
        if (object instanceof Callable && obj2 != null) {
            i = 0;
            obj2 = (Callable)object.call();
            if (obj2 != null) {
                obj2 = n2.apply(obj2);
                b.e(obj2, "The mapper returned a null CompletableSource");
                i = obj2;
            }
            if (i == 0) {
                d.complete(d3);
            } else {
                i.b(d3);
            }
            return 1;
        }
        try {
            return 0;
        }
    }

    static <T, R> boolean b(Object object, n<? super T, ? extends p<? extends R>> n2, y<? super R> y3) {
        int i;
        Object obj2;
        String obj3;
        i = 0;
        obj2 = (Callable)object.call();
        if (object instanceof Callable && obj2 != null) {
            i = 0;
            obj2 = (Callable)object.call();
            if (obj2 != null) {
                obj2 = n2.apply(obj2);
                b.e(obj2, "The mapper returned a null MaybeSource");
                i = obj2;
            }
            if (i == 0) {
                d.complete(y3);
            } else {
                i.b(v.c(y3));
            }
            return 1;
        }
        try {
            return 0;
        }
    }

    static <T, R> boolean c(Object object, n<? super T, ? extends g0<? extends R>> n2, y<? super R> y3) {
        int i;
        Object obj2;
        String obj3;
        i = 0;
        obj2 = (Callable)object.call();
        if (object instanceof Callable && obj2 != null) {
            i = 0;
            obj2 = (Callable)object.call();
            if (obj2 != null) {
                obj2 = n2.apply(obj2);
                b.e(obj2, "The mapper returned a null SingleSource");
                i = obj2;
            }
            if (i == 0) {
                d.complete(y3);
            } else {
                i.subscribe(v0.c(y3));
            }
            return 1;
        }
        try {
            return 0;
        }
    }
}
