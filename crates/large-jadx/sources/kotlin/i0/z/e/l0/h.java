package kotlin.i0.z.e.l0;

import java.lang.reflect.Method;
import java.util.Collection;
import java.util.Iterator;
import kotlin.d0.d.n;
import kotlin.i0.z.e.a0;
import kotlin.i0.z.e.j0;
import kotlin.i0.z.e.m0.i.f;
import kotlin.i0.z.e.m0.i.s.a;
import kotlin.i0.z.e.m0.l.b0;
import kotlin.i0.z.e.m0.l.t0;
import kotlin.reflect.jvm.internal.impl.descriptors.a;
import kotlin.reflect.jvm.internal.impl.descriptors.b;
import kotlin.reflect.jvm.internal.impl.descriptors.b1;
import kotlin.reflect.jvm.internal.impl.descriptors.d0;
import kotlin.reflect.jvm.internal.impl.descriptors.e;
import kotlin.reflect.jvm.internal.impl.descriptors.m;
import kotlin.reflect.jvm.internal.impl.descriptors.n;

/* loaded from: classes3.dex */
public final class h {
    public static final Object a(Object object, b b2) {
        boolean z;
        Object arr;
        Object obj1;
        Object obj2;
        n.f(b2, "descriptor");
        if (b2 instanceof o0 && f.d((d1)b2)) {
            if (f.d((d1)b2)) {
                return object;
            }
        }
        arr = h.e(b2);
        arr = h.i(arr);
        obj2 = h.f(arr, b2);
        if (arr != null && arr != null && obj2 != null) {
            arr = h.i(arr);
            if (arr != null) {
                obj2 = h.f(arr, b2);
                if (obj2 != null) {
                    obj1 = obj2.invoke(object, new Object[0]);
                }
            }
        }
        return obj1;
    }

    public static final <M extends java.lang.reflect.Member> kotlin.i0.z.e.l0.d<M> b(kotlin.i0.z.e.l0.d<? extends M> d, b b2, boolean z3) {
        boolean returnType;
        Object iterator;
        int i;
        boolean empty;
        String str;
        Object obj5;
        n.f(d, "$this$createInlineClassAwareCallerIfNeeded");
        n.f(b2, "descriptor");
        final int i2 = 1;
        if (!f.a(b2)) {
            iterator = b2.h();
            n.e(iterator, "descriptor.valueParameters");
            if (iterator instanceof Collection != null && iterator.isEmpty()) {
                if (iterator.isEmpty()) {
                    returnType = i;
                } else {
                    iterator = iterator.iterator();
                    for (c1 next : iterator) {
                        n.e(next, "it");
                        b0 type = next.getType();
                        n.e(type, "it.type");
                    }
                }
            } else {
            }
            if (returnType == 0) {
                returnType = b2.getReturnType();
                if (returnType != null) {
                    if (f.c(returnType) != i2) {
                        if (!d instanceof c && h.g(b2)) {
                            if (h.g(b2)) {
                                i = i2;
                            }
                        }
                    } else {
                    }
                } else {
                }
            } else {
            }
        } else {
        }
        if (i != 0) {
            returnType = new g(b2, d, z3);
            obj5 = returnType;
        }
        return obj5;
    }

    public static kotlin.i0.z.e.l0.d c(kotlin.i0.z.e.l0.d d, b b2, boolean z3, int i4, Object object5) {
        int obj2;
        if (i4 &= 2 != 0) {
            obj2 = 0;
        }
        return h.b(d, b2, obj2);
    }

    public static final Method d(Class<?> class, b b2) {
        n.f(class, "$this$getBoxMethod");
        n.f(b2, "descriptor");
        Class[] arr = new Class[1];
        Method declaredMethod = class.getDeclaredMethod("box-impl", h.f(class, b2).getReturnType());
        n.e(declaredMethod, "getDeclaredMethod(\"box\" …d(descriptor).returnType)");
        return declaredMethod;
    }

    private static final b0 e(b b) {
        kotlin.reflect.jvm.internal.impl.descriptors.r0 r0Var;
        int type;
        Object obj3;
        r0Var = b.m0();
        final kotlin.reflect.jvm.internal.impl.descriptors.r0 r0Var2 = b.f0();
        if (r0Var != null) {
            type = r0Var.getType();
        } else {
            if (r0Var2 == null) {
            } else {
                if (b instanceof l) {
                    type = r0Var2.getType();
                } else {
                    if (!obj3 instanceof e) {
                        obj3 = type;
                    }
                    if ((e)obj3 != null) {
                        type = obj3;
                    }
                }
            }
        }
        return type;
    }

    public static final Method f(Class<?> class, b b2) {
        n.f(class, "$this$getUnboxMethod");
        n.f(b2, "descriptor");
        Method declaredMethod = class.getDeclaredMethod("unbox-impl", new Class[0]);
        n.e(declaredMethod, "getDeclaredMethod(\"unbox…FOR_INLINE_CLASS_MEMBERS)");
        return declaredMethod;
    }

    private static final boolean g(b b) {
        int i;
        b0 obj1;
        obj1 = h.e(b);
        if (obj1 != null && f.c(obj1) == 1) {
            if (f.c(obj1) == 1) {
            } else {
                i = 0;
            }
        } else {
        }
        return i;
    }

    public static final Class<?> h(m m) {
        boolean z;
        int i;
        if (m instanceof e && f.b(m)) {
            if (f.b(m)) {
                z = m;
                if (j0.n((e)z) == null) {
                } else {
                    return i;
                }
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Class object for the class ");
                stringBuilder.append(z.getName());
                stringBuilder.append(" cannot be found (classId=");
                stringBuilder.append(a.h((h)m));
                stringBuilder.append(')');
                a0 a0Var = new a0(stringBuilder.toString());
                throw a0Var;
            }
        }
        i = 0;
    }

    public static final Class<?> i(b0 b0) {
        n.f(b0, "$this$toInlineClass");
        return h.h(b0.L0().c());
    }
}
