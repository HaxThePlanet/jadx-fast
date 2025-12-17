package kotlin.i0.z.e.m0.l;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import kotlin.d0.d.n;
import kotlin.i0.z.e.m0.b.h;
import kotlin.i0.z.e.m0.i.s.a;
import kotlin.reflect.jvm.internal.impl.descriptors.h;
import kotlin.reflect.jvm.internal.impl.descriptors.n;
import kotlin.reflect.jvm.internal.impl.descriptors.z0;
import kotlin.y.p;

/* loaded from: classes3.dex */
public final class o0 {

    public static final class a extends kotlin.i0.z.e.m0.l.u0 {

        final List<kotlin.i0.z.e.m0.l.t0> c;
        a(List<? extends kotlin.i0.z.e.m0.l.t0> list) {
            this.c = list;
            super();
        }

        @Override // kotlin.i0.z.e.m0.l.u0
        public kotlin.i0.z.e.m0.l.v0 j(kotlin.i0.z.e.m0.l.t0 t0) {
            String contains;
            kotlin.i0.z.e.m0.l.v0 obj2;
            n.f(t0, "key");
            if (this.c.contains(t0)) {
                obj2 = t0.c();
                Objects.requireNonNull(obj2, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.TypeParameterDescriptor");
                obj2 = c1.s((z0)obj2);
            } else {
                obj2 = 0;
            }
            return obj2;
        }
    }
    public static final kotlin.i0.z.e.m0.l.b0 a(z0 z0) {
        kotlin.i0.z.e.m0.l.b0 b0Var;
        int i;
        Object obj3;
        n.f(z0, "<this>");
        List parameters = (i)z0.b().g().getParameters();
        n.e(parameters, "classDescriptor.typeConstructor.parameters");
        ArrayList arrayList = new ArrayList(p.r(parameters, 10));
        Iterator iterator = parameters.iterator();
        for (z0 next2 : iterator) {
            arrayList.add(next2.g());
        }
        o0.a aVar = new o0.a(arrayList);
        List upperBounds = z0.getUpperBounds();
        n.e(upperBounds, "this.upperBounds");
        if (a1.g(aVar).p((b0)p.X(upperBounds), h1.OUT_VARIANCE) == null) {
            n.e(a.g(z0).y(), "builtIns.defaultBound");
        }
        return b0Var;
    }
}
