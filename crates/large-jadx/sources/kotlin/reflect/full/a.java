package kotlin.reflect.full;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Objects;
import kotlin.d0.d.n;
import kotlin.i0.d;
import kotlin.i0.g;
import kotlin.i0.n;
import kotlin.i0.z.e.c0.b;
import kotlin.i0.z.e.f;
import kotlin.i0.z.e.h;
import kotlin.i0.z.e.h.a;
import kotlin.i0.z.e.k;
import kotlin.reflect.jvm.internal.impl.descriptors.a;
import kotlin.reflect.jvm.internal.impl.descriptors.l;

/* loaded from: classes3.dex */
public final class a {
    public static final <T> Collection<n<T, ?>> a(d<T> d) {
        Object next;
        int i;
        Object obj;
        boolean z;
        n.f(d, "$this$memberProperties");
        ArrayList arrayList = new ArrayList();
        Iterator obj4 = (h.a)(h)d.O().invoke().g().iterator();
        while (obj4.hasNext()) {
            next = obj4.next();
            obj = next;
            if (a.d((f)obj) && obj instanceof n) {
            } else {
            }
            i = 0;
            if (i != 0) {
            }
            arrayList.add(next);
            if (obj instanceof n) {
            } else {
            }
            i = 1;
        }
        return arrayList;
    }

    public static final <T> g<T> b(d<T> d) {
        String next;
        boolean z;
        String str;
        n.f(d, "$this$primaryConstructor");
        Iterator obj3 = (h)d.N().iterator();
        for (Object next : obj3) {
            String str2 = next;
            Objects.requireNonNull((g)str2, "null cannot be cast to non-null type kotlin.reflect.jvm.internal.KFunctionImpl");
            kotlin.reflect.jvm.internal.impl.descriptors.x xVar = (k)str2.L();
            Objects.requireNonNull(xVar, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ConstructorDescriptor");
        }
        next = 0;
        return (g)next;
    }

    private static final boolean c(f<?> f) {
        int obj0;
        obj0 = f.y().m0() != null ? 1 : 0;
        return obj0;
    }

    private static final boolean d(f<?> f) {
        return obj0 ^= 1;
    }
}
