package kotlin.i0.z.e.m0.b;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import kotlin.d0.d.n;
import kotlin.i0.z.e.m0.f.b;
import kotlin.i0.z.e.m0.f.e;
import kotlin.i0.z.e.m0.k.f;
import kotlin.i0.z.e.m0.l.b0;
import kotlin.i0.z.e.m0.l.c0;
import kotlin.i0.z.e.m0.l.h1;
import kotlin.i0.z.e.m0.l.i0;
import kotlin.i0.z.e.m0.l.m1.a;
import kotlin.i0.z.e.m0.l.t;
import kotlin.i0.z.e.m0.l.v0;
import kotlin.reflect.jvm.internal.impl.descriptors.f;
import kotlin.reflect.jvm.internal.impl.descriptors.h1.a;
import kotlin.reflect.jvm.internal.impl.descriptors.h1.g;
import kotlin.reflect.jvm.internal.impl.descriptors.h1.g.a;
import kotlin.reflect.jvm.internal.impl.descriptors.j1.j0;
import kotlin.reflect.jvm.internal.impl.descriptors.j1.m;
import kotlin.reflect.jvm.internal.impl.descriptors.j1.y;
import kotlin.reflect.jvm.internal.impl.descriptors.t;
import kotlin.reflect.jvm.internal.impl.descriptors.u0;
import kotlin.reflect.jvm.internal.impl.descriptors.z;
import kotlin.y.p;

/* loaded from: classes3.dex */
public final class l {

    private static final y a;
    private static final y b;
    static {
        kotlin.reflect.jvm.internal.impl.descriptors.c0 c0Var = t.q();
        final String str = "getErrorModule()";
        n.e(c0Var, str);
        m mVar = new m(c0Var, k.e);
        final f iNTERFACE = f.INTERFACE;
        final u0 u0Var2 = u0.a;
        final kotlin.i0.z.e.m0.k.n nVar4 = f.e;
        y yVar = yVar3;
        super(mVar, iNTERFACE, 0, 0, k.f.g(), u0Var2, nVar4);
        z aBSTRACT = z.ABSTRACT;
        yVar3.L0(aBSTRACT);
        kotlin.reflect.jvm.internal.impl.descriptors.u uVar2 = t.e;
        yVar3.N0(uVar2);
        g.a aVar = g.q;
        final h1 iN_VARIANCE = h1.IN_VARIANCE;
        String str2 = "T";
        yVar3.M0(p.b(j0.Q0(yVar, aVar.b(), false, iN_VARIANCE, e.j(str2), 0, nVar4)));
        yVar3.J0();
        l.a = yVar3;
        kotlin.reflect.jvm.internal.impl.descriptors.c0 c0Var2 = t.q();
        n.e(c0Var2, str);
        m mVar2 = new m(c0Var2, k.d);
        super(mVar2, iNTERFACE, 0, 0, k.g.g(), u0Var2, nVar4);
        yVar2.L0(aBSTRACT);
        yVar2.N0(uVar2);
        yVar2.M0(p.b(j0.Q0(yVar2, aVar.b(), false, iN_VARIANCE, e.j(str2), 0, nVar4)));
        yVar2.J0();
        l.b = yVar2;
    }

    public static final boolean a(b b, boolean z2) {
        boolean obj0;
        b obj1;
        if (z2) {
            obj0 = n.b(b, k.g);
        } else {
            obj0 = n.b(b, k.f);
        }
        return obj0;
    }

    public static final i0 b(b0 b0, boolean z2) {
        int type;
        kotlin.i0.z.e.m0.l.t0 obj13;
        n.f(b0, "suspendFunType");
        g.o(b0);
        java.util.List list = g.j(b0);
        ArrayList arrayList = new ArrayList(p.r(list, 10));
        Iterator iterator = list.iterator();
        for (v0 next2 : iterator) {
            arrayList.add(next2.getType());
        }
        c0 c0Var = c0.a;
        if (z2) {
            obj13 = l.b.g();
        } else {
            obj13 = l.a.g();
        }
        kotlin.i0.z.e.m0.l.t0 t0Var = obj13;
        n.e(t0Var, "if (isReleaseCoroutines) FAKE_CONTINUATION_CLASS_DESCRIPTOR_RELEASE.typeConstructor\n                    else FAKE_CONTINUATION_CLASS_DESCRIPTOR_EXPERIMENTAL.typeConstructor");
        final int i6 = 0;
        i0 i0Var = a.e(b0).I();
        n.e(i0Var, "suspendFunType.builtIns.nullableAnyType");
        return g.b(a.e(b0), b0.getAnnotations(), g.h(b0), p.u0(arrayList, c0.i(g.q.b(), t0Var, p.b(a.a(g.i(b0))), false, i6, 16, 0)), 0, i0Var, false, 64, i6).S0(b0.M0());
    }
}
