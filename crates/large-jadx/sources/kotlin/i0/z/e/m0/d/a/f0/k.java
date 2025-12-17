package kotlin.i0.z.e.m0.d.a.f0;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.d0.d.n;
import kotlin.i0.z.e.m0.b.h;
import kotlin.i0.z.e.m0.d.a.g0.l.k;
import kotlin.i0.z.e.m0.d.a.y;
import kotlin.i0.z.e.m0.i.q.g;
import kotlin.i0.z.e.m0.i.s.a;
import kotlin.o;
import kotlin.reflect.jvm.internal.impl.descriptors.a;
import kotlin.reflect.jvm.internal.impl.descriptors.c0;
import kotlin.reflect.jvm.internal.impl.descriptors.c1;
import kotlin.reflect.jvm.internal.impl.descriptors.d0;
import kotlin.reflect.jvm.internal.impl.descriptors.e;
import kotlin.reflect.jvm.internal.impl.descriptors.h1.a;
import kotlin.reflect.jvm.internal.impl.descriptors.h1.g;
import kotlin.reflect.jvm.internal.impl.descriptors.j1.k0;
import kotlin.reflect.jvm.internal.impl.descriptors.p;
import kotlin.y.p;

/* loaded from: classes3.dex */
public final class k {
    public static final List<c1> a(Collection<kotlin.i0.z.e.m0.d.a.f0.l> collection, Collection<? extends c1> collection2, a a3) {
        int i;
        Object obj;
        kotlin.i0.z.e.m0.l.b0 b0Var2;
        int size;
        int index;
        g annotations;
        kotlin.i0.z.e.m0.f.e name;
        kotlin.i0.z.e.m0.l.b0 b0Var;
        boolean z;
        boolean z3;
        boolean z2;
        kotlin.i0.z.e.m0.l.b0 b0Var4;
        Object b0Var3;
        kotlin.reflect.jvm.internal.impl.descriptors.u0 source;
        k0 k0Var;
        n.f(collection, "newValueParametersTypes");
        n.f(collection2, "oldValueParameters");
        n.f(a3, "newOwner");
        int size2 = collection.size();
        size = collection2.size();
        List list = p.S0(collection, collection2);
        ArrayList arrayList = new ArrayList(p.r(list, 10));
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            Object next2 = iterator.next();
            Object obj4 = (o)next2.a();
            Object obj3 = next2.b();
            name = obj3.getName();
            n.e(name, "oldParameter.name");
            if (obj3.l0() != null) {
            } else {
            }
            b0Var2 = 0;
            source = obj3.getSource();
            n.e(source, "oldParameter.source");
            super(a3, 0, (c1)obj3.getIndex(), obj3.getAnnotations(), name, (l)obj4.b(), obj4.a(), obj3.b0(), obj3.X(), b0Var2, source);
            arrayList.add(k0Var);
            b0Var2 = a.l(a3).m().k(obj4.b());
        }
        return arrayList;
    }

    public static final kotlin.i0.z.e.m0.d.a.f0.a b(c1 c1) {
        kotlin.reflect.jvm.internal.impl.descriptors.h1.c cVar;
        boolean str;
        n.f(c1, "<this>");
        kotlin.i0.z.e.m0.f.b bVar2 = y.r;
        n.e(bVar2, "DEFAULT_VALUE_FQ_NAME");
        cVar = c1.getAnnotations().o(bVar2);
        int i = 0;
        if (cVar == null) {
            cVar = i;
        } else {
        }
        if (cVar == null) {
            kotlin.i0.z.e.m0.f.b bVar = y.s;
            n.e(bVar, "DEFAULT_NULL_FQ_NAME");
            if (c1.getAnnotations().u1(bVar)) {
                return h.a;
            }
            return i;
        } else {
            cVar = cVar.b();
            bVar = y.s;
            n.e(bVar, "DEFAULT_NULL_FQ_NAME");
            if ((String)cVar == null && c1.getAnnotations().u1(bVar)) {
            }
        }
        j obj3 = new j((String)cVar);
        return obj3;
    }

    public static final k c(e e) {
        int i;
        n.f(e, "<this>");
        final e obj3 = a.p(e);
        if (obj3 == null) {
            return null;
        }
        final kotlin.i0.z.e.m0.i.v.h hVar = obj3.R();
        if (hVar instanceof k) {
            i = hVar;
        }
        if (i == 0) {
            i = k.c(obj3);
        }
        return i;
    }
}
