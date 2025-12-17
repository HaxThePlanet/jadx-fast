package kotlin.i0.z.e.m0.b.p;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.d0.d.g;
import kotlin.d0.d.n;
import kotlin.i0.z.e.m0.b.g;
import kotlin.i0.z.e.m0.f.e;
import kotlin.i0.z.e.m0.l.a1;
import kotlin.i0.z.e.m0.l.h1;
import kotlin.i0.z.e.m0.m.j;
import kotlin.reflect.jvm.internal.impl.descriptors.b.a;
import kotlin.reflect.jvm.internal.impl.descriptors.b1;
import kotlin.reflect.jvm.internal.impl.descriptors.c1;
import kotlin.reflect.jvm.internal.impl.descriptors.d0;
import kotlin.reflect.jvm.internal.impl.descriptors.h;
import kotlin.reflect.jvm.internal.impl.descriptors.h1.g;
import kotlin.reflect.jvm.internal.impl.descriptors.h1.g.a;
import kotlin.reflect.jvm.internal.impl.descriptors.j1.a;
import kotlin.reflect.jvm.internal.impl.descriptors.j1.f0;
import kotlin.reflect.jvm.internal.impl.descriptors.j1.k0;
import kotlin.reflect.jvm.internal.impl.descriptors.j1.p;
import kotlin.reflect.jvm.internal.impl.descriptors.j1.p.c;
import kotlin.reflect.jvm.internal.impl.descriptors.m;
import kotlin.reflect.jvm.internal.impl.descriptors.t;
import kotlin.reflect.jvm.internal.impl.descriptors.u0;
import kotlin.reflect.jvm.internal.impl.descriptors.x;
import kotlin.reflect.jvm.internal.impl.descriptors.z;
import kotlin.reflect.jvm.internal.impl.descriptors.z0;
import kotlin.y.e0;
import kotlin.y.p;

/* loaded from: classes3.dex */
public final class e extends f0 {

    public static final kotlin.i0.z.e.m0.b.p.e.a V;

    public static final class a {
        public a(g g) {
            super();
        }

        private final c1 b(kotlin.i0.z.e.m0.b.p.e e, int i2, z0 z03) {
            String lowerCase;
            boolean str;
            String str2 = z03.getName().c();
            n.e(str2, "typeParameter.name.asString()");
            if (n.b(str2, "T")) {
                lowerCase = "instance";
            } else {
                if (n.b(str2, "E")) {
                    lowerCase = "receiver";
                } else {
                    n.e(str2.toLowerCase(), "(this as java.lang.String).toLowerCase()");
                }
            }
            final e eVar = e.j(lowerCase);
            n.e(eVar, "identifier(name)");
            final kotlin.i0.z.e.m0.l.i0 i0Var = z03.q();
            n.e(i0Var, "typeParameter.defaultType");
            final u0 u0Var = u0.a;
            n.e(u0Var, "NO_SOURCE");
            super(e, 0, i2, g.q.b(), eVar, i0Var, 0, 0, 0, 0, u0Var);
            return k0Var2;
        }

        public final kotlin.i0.z.e.m0.b.p.e a(kotlin.i0.z.e.m0.b.p.b b, boolean z2) {
            kotlin.i0.z.e.m0.b.p.e next;
            Object obj;
            boolean iN_VARIANCE;
            int i;
            int obj13;
            n.f(b, "functionClass");
            List list = b.t();
            super(b, 0, b.a.DECLARATION, z2, 0);
            ArrayList obj12 = new ArrayList();
            obj13 = list.iterator();
            i = 1;
            while (obj13.hasNext()) {
                next = obj13.next();
                if ((z0)next.l() == h1.IN_VARIANCE) {
                } else {
                }
                obj = 0;
                if (obj == null) {
                    break;
                } else {
                }
                obj12.add(next);
                i = 1;
                obj = i;
            }
            obj12 = p.R0(obj12);
            ArrayList arrayList = new ArrayList(p.r(obj12, 10));
            obj12 = obj12.iterator();
            for (e0 obj13 : obj12) {
                arrayList.add(b(eVar3, obj13.c(), (z0)obj13.d()));
            }
            eVar3.m1(0, b.I0(), p.g(), arrayList, (z0)p.j0(list).q(), z.ABSTRACT, t.e);
            eVar3.Y0(i);
            return eVar3;
        }
    }
    static {
        e.a aVar = new e.a(0);
        e.V = aVar;
    }

    private e(m m, kotlin.i0.z.e.m0.b.p.e e2, b.a b$a3, boolean z4) {
        super(m, e2, g.q.b(), j.g, a3, u0.a);
        e1(true);
        g1(z4);
        X0(false);
    }

    public e(m m, kotlin.i0.z.e.m0.b.p.e e2, b.a b$a3, boolean z4, g g5) {
        super(m, e2, a3, z4);
    }

    private final x o1(List<e> list) {
        int i3;
        boolean empty;
        int i;
        e name;
        int index;
        int i2;
        Object obj9;
        List list3 = h();
        n.e(list3, "valueParameters");
        ArrayList arrayList = new ArrayList(p.r(list3, 10));
        Iterator iterator = list3.iterator();
        while (iterator.hasNext()) {
            Object next3 = iterator.next();
            n.e((c1)next3.getName(), "it.name");
            index = next3.getIndex();
            i2 = index - i4;
            i2 = list.get(i2);
            if (i2 >= 0 && (e)i2 != null) {
            }
            arrayList.add(next3.D0(this, name, index));
            i2 = list.get(i2);
            if ((e)(e)i2 != null) {
            }
            name = i2;
        }
        p.c cVar = R0(a1.b);
        int i6 = 0;
        if (list instanceof Collection != null && list.isEmpty()) {
            if (list.isEmpty()) {
                i3 = i6;
            } else {
                obj9 = list.iterator();
                while (obj9.hasNext()) {
                    if ((e)obj9.next() == null) {
                    } else {
                    }
                    empty = i6;
                    if (!empty) {
                        break;
                    }
                    empty = i3;
                }
            }
        } else {
        }
        cVar.F(i3);
        cVar.T(arrayList);
        cVar.M(l1());
        n.e(cVar, "newCopyBuilder(TypeSubstitutor.EMPTY)\n                .setHasSynthesizedParameterNames(parameterNames.any { it == null })\n                .setValueParameters(newValueParameters)\n                .setOriginal(original)");
        obj9 = super.L0(cVar);
        n.d(obj9);
        return obj9;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.f0
    protected p K0(m m, x x2, b.a b$a3, e e4, g g5, u0 u06) {
        n.f(m, "newOwner");
        n.f(a3, "kind");
        n.f(g5, "annotations");
        n.f(u06, "source");
        e obj4 = new e(m, (e)x2, a3, isSuspend());
        return obj4;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.f0
    protected x L0(p.c p$c) {
        List iterator;
        boolean empty;
        int i2;
        int i;
        n.f(c, "configuration");
        x obj7 = super.L0(c);
        if ((e)obj7 == null) {
            return null;
        }
        iterator = (e)obj7.h();
        String str2 = "substituted.valueParameters";
        n.e(iterator, str2);
        final String str3 = "it.type";
        final int i4 = 1;
        if (iterator instanceof Collection != null && iterator.isEmpty()) {
            if (iterator.isEmpty()) {
                i = i4;
            } else {
                iterator = iterator.iterator();
                while (iterator.hasNext()) {
                    kotlin.i0.z.e.m0.l.b0 type2 = (c1)iterator.next().getType();
                    n.e(type2, str3);
                    if (g.c(type2) != null) {
                    } else {
                    }
                    empty = i;
                    if (!empty) {
                        break;
                    }
                    empty = i4;
                }
            }
        } else {
        }
        if (i != 0) {
            return obj7;
        }
        List list = obj7.h();
        n.e(list, str2);
        ArrayList arrayList = new ArrayList(p.r(list, 10));
        Iterator iterator2 = list.iterator();
        for (c1 next2 : iterator2) {
            kotlin.i0.z.e.m0.l.b0 type = next2.getType();
            n.e(type, str3);
            arrayList.add(g.c(type));
        }
        return obj7.o1(arrayList);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.f0
    public boolean O() {
        return 0;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.f0
    public boolean r() {
        return 0;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.f0
    public boolean w() {
        return 0;
    }
}
