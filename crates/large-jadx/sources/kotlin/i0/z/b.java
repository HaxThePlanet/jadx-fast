package kotlin.i0.z;

import java.util.Iterator;
import java.util.Objects;
import kotlin.d0.d.c0;
import kotlin.d0.d.n;
import kotlin.i0.d;
import kotlin.i0.e;
import kotlin.i0.o;
import kotlin.i0.p;
import kotlin.i0.z.e.a0;
import kotlin.i0.z.e.m0.l.b0;
import kotlin.i0.z.e.m0.l.t0;
import kotlin.i0.z.e.w;
import kotlin.reflect.jvm.internal.impl.descriptors.e;
import kotlin.reflect.jvm.internal.impl.descriptors.f;
import kotlin.y.p;

/* loaded from: classes3.dex */
public final class b {
    public static final d<?> a(e e) {
        boolean iterator;
        boolean next;
        Object obj;
        Object aNNOTATION_CLASS;
        f iNTERFACE;
        Object obj5;
        n.f(e, "$this$jvmErasure");
        if (e instanceof d) {
            return obj5;
        } else {
            if (!e instanceof p) {
            } else {
                obj5 = (p)(d)e.getUpperBounds();
                iterator = obj5.iterator();
                obj = 0;
                while (iterator.hasNext()) {
                    next = iterator.next();
                    Object obj2 = next;
                    Objects.requireNonNull((o)obj2, "null cannot be cast to non-null type kotlin.reflect.jvm.internal.KTypeImpl");
                    aNNOTATION_CLASS = (w)obj2.l().L0().c();
                    if (!aNNOTATION_CLASS instanceof e) {
                    } else {
                    }
                    obj = aNNOTATION_CLASS;
                    if (obj != null && (e)obj.f() != f.INTERFACE && obj.f() != f.ANNOTATION_CLASS) {
                    } else {
                    }
                    obj = 0;
                    if (obj != null) {
                        break;
                    } else {
                    }
                    obj = 0;
                    if (obj.f() != f.INTERFACE) {
                    } else {
                    }
                    if (obj.f() != f.ANNOTATION_CLASS) {
                    } else {
                    }
                    obj = 1;
                }
                if ((o)obj != 0) {
                } else {
                    obj = obj5;
                }
                if (obj != null && b.b(obj) != null) {
                    if (b.b(obj) != null) {
                    } else {
                        obj5 = c0.b(Object.class);
                    }
                } else {
                }
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Cannot calculate JVM erasure for type: ");
        stringBuilder.append(e);
        a0 a0Var = new a0(stringBuilder.toString());
        throw a0Var;
    }

    public static final d<?> b(o o) {
        e eVar;
        n.f(o, "$this$jvmErasure");
        eVar = o.c();
        if (eVar == null) {
        } else {
            eVar = b.a(eVar);
            if (eVar == null) {
            } else {
                return eVar;
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Cannot calculate JVM erasure for type: ");
        stringBuilder.append(o);
        a0 a0Var = new a0(stringBuilder.toString());
        throw a0Var;
    }
}
