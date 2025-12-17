package kotlin.i0.z;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import kotlin.d0.d.n;
import kotlin.i0.g;
import kotlin.i0.h;
import kotlin.i0.l;
import kotlin.i0.o;
import kotlin.i0.x;
import kotlin.i0.z.e.f;
import kotlin.i0.z.e.j0;
import kotlin.i0.z.e.l0.d;
import kotlin.i0.z.e.t;
import kotlin.i0.z.e.w;

/* loaded from: classes3.dex */
public final class c {
    public static final <T> Constructor<T> a(g<? extends T> g) {
        int i;
        Object obj2;
        n.f(g, "$this$javaConstructor");
        obj2 = j0.a(g);
        obj2 = obj2.v();
        if (obj2 != null && obj2 != null) {
            obj2 = obj2.v();
            if (obj2 != null) {
                obj2 = obj2.b();
            } else {
                obj2 = i;
            }
        } else {
        }
        if (!obj2 instanceof Constructor) {
        } else {
            i = obj2;
        }
        return (Constructor)i;
    }

    public static final Field b(l<?> l) {
        Field obj1;
        n.f(l, "$this$javaField");
        obj1 = j0.c(l);
        if (obj1 != null) {
            obj1 = obj1.G();
        } else {
            obj1 = 0;
        }
        return obj1;
    }

    public static final Method c(l<?> l) {
        n.f(l, "$this$javaGetter");
        return c.d(l.getGetter());
    }

    public static final Method d(g<?> g) {
        int i;
        Object obj2;
        n.f(g, "$this$javaMethod");
        obj2 = j0.a(g);
        obj2 = obj2.v();
        if (obj2 != null && obj2 != null) {
            obj2 = obj2.v();
            if (obj2 != null) {
                obj2 = obj2.b();
            } else {
                obj2 = i;
            }
        } else {
        }
        if (!obj2 instanceof Method) {
        } else {
            i = obj2;
        }
        return (Method)i;
    }

    public static final Method e(h<?> h) {
        n.f(h, "$this$javaSetter");
        return c.d(h.getSetter());
    }

    public static final Type f(o o) {
        Type type;
        n.f(o, "$this$javaType");
        if ((w)o.a() != null) {
        } else {
            type = x.f(o);
        }
        return type;
    }
}
