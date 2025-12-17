package kotlin.i0.z.e.m0.d.a.j0;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.d0.c.l;
import kotlin.d0.d.n;
import kotlin.i0.z.e.m0.d.a.g0.c;
import kotlin.i0.z.e.m0.d.a.g0.m.f;
import kotlin.i0.z.e.m0.l.b0;
import kotlin.i0.z.e.m0.l.c0;
import kotlin.i0.z.e.m0.l.c1;
import kotlin.i0.z.e.m0.l.d0;
import kotlin.i0.z.e.m0.l.e1;
import kotlin.i0.z.e.m0.l.g1;
import kotlin.i0.z.e.m0.l.i0;
import kotlin.i0.z.e.m0.l.l0;
import kotlin.i0.z.e.m0.l.m1.a;
import kotlin.i0.z.e.m0.l.t0;
import kotlin.i0.z.e.m0.l.v;
import kotlin.i0.z.e.m0.l.v0;
import kotlin.i0.z.e.m0.l.y;
import kotlin.reflect.jvm.internal.impl.descriptors.h;
import kotlin.reflect.jvm.internal.impl.descriptors.h1.a;
import kotlin.y.p;

/* loaded from: classes3.dex */
public final class d {

    private final c a;

    private static class a {

        private final b0 a;
        private final int b;
        private final boolean c;
        public a(b0 b0, int i2, boolean z3) {
            n.f(b0, "type");
            super();
            this.a = b0;
            this.b = i2;
            this.c = z3;
        }

        public final int a() {
            return this.b;
        }

        public b0 b() {
            return this.a;
        }

        public final b0 c() {
            b0 b0Var;
            b0Var = b();
            if (d()) {
            } else {
                b0Var = 0;
            }
            return b0Var;
        }

        public final boolean d() {
            return this.c;
        }
    }

    private static final class b extends kotlin.i0.z.e.m0.d.a.j0.d.a {

        private final i0 d;
        public b(i0 i0, int i2, boolean z3) {
            n.f(i0, "type");
            super(i0, i2, z3);
            this.d = i0;
        }

        @Override // kotlin.i0.z.e.m0.d.a.j0.d$a
        public b0 b() {
            return e();
        }

        @Override // kotlin.i0.z.e.m0.d.a.j0.d$a
        public i0 e() {
            return this.d;
        }
    }
    public d(c c) {
        n.f(c, "javaResolverSettings");
        super();
        this.a = c;
    }

    private final b0 a(b0 b0, b0 b02) {
        b0 obj2;
        b0 obj3 = e1.a(b02);
        if (e1.a(b0) == null && obj3 == null) {
            if (obj3 == null) {
                return null;
            }
            obj2 = obj3;
        }
        if (obj3 == null) {
            return obj2;
        }
        final c0 c0Var = c0.a;
        return c0.d(y.c(obj2), y.d(obj3));
    }

    private final kotlin.i0.z.e.m0.d.a.j0.d.b c(i0 i0, l<? super Integer, kotlin.i0.z.e.m0.d.a.j0.e> l2, int i3, kotlin.i0.z.e.m0.d.a.j0.p p4, boolean z5) {
        kotlin.reflect.jvm.internal.impl.descriptors.h1.g gVar;
        int i10;
        int i;
        boolean empty;
        i0 i0Var;
        int i4;
        v0 v0Var;
        int i2;
        Object str;
        int i5;
        Enum nOT_NULL;
        int i6;
        int i7;
        Object next;
        int i9;
        boolean z;
        int i8;
        final Object obj = this;
        i0 i0Var2 = i0;
        l lVar = l2;
        kotlin.i0.z.e.m0.d.a.j0.p pVar = p4;
        i4 = 0;
        i2 = 1;
        if (!q.a(p4) && i0.K0().isEmpty()) {
            if (i0.K0().isEmpty()) {
                d.b bVar4 = new d.b(i0Var2, i2, i4);
                return bVar4;
            }
        }
        h hVar = i0.L0().c();
        if (hVar == null) {
            d.b bVar3 = new d.b(i0Var2, i2, i4);
            return bVar3;
        }
        Object invoke2 = lVar.invoke(Integer.valueOf(i3));
        kotlin.i0.z.e.m0.d.a.j0.c cVar2 = t.b(hVar, (e)invoke2, pVar);
        Object obj4 = cVar2.a();
        kotlin.reflect.jvm.internal.impl.descriptors.h1.g gVar2 = cVar2.b();
        final t0 t0Var3 = (h)obj4.g();
        n.e(t0Var3, "enhancedClassifier.typeConstructor");
        i5 = i3 + 1;
        i6 = gVar2 != null ? i2 : i4;
        List list4 = i0.K0();
        ArrayList arrayList = new ArrayList(p.r(list4, 10));
        Iterator iterator = list4.iterator();
        i7 = i4;
        for (Object next : iterator) {
            String str2 = "arg.projectionKind";
            if ((v0)next.c()) {
            } else {
            }
            kotlin.i0.z.e.m0.d.a.j0.d.a aVar = obj.e(next.getType().O0(), lVar, i5);
            if (i6 == 0) {
            } else {
            }
            i6 = 1;
            i5 += i8;
            next = next.a();
            n.e(next, str2);
            v0Var = a.d(aVar.b(), next, (z0)t0Var3.getParameters().get(i7));
            arrayList.add(v0Var);
            i7 = i9;
            i4 = 0;
            i2 = 1;
            if (aVar.d()) {
            } else {
            }
            i6 = 0;
            if ((e)lVar.invoke(Integer.valueOf(i5)).c() == h.NOT_NULL && !z5) {
            } else {
            }
            n.e(c1.s((z0)obj4.g().getParameters().get(i7)), "{\n                    TypeUtils.makeStarProjection(enhancedClassifier.typeConstructor.parameters[localArgIndex])\n                }");
            i5 = i8;
            if (!z5) {
            } else {
            }
            nOT_NULL = next.a();
            n.e(nOT_NULL, str2);
            v0Var = a.d(a.j(next.getType().O0()), nOT_NULL, (z0)t0Var3.getParameters().get(i7));
        }
        kotlin.i0.z.e.m0.d.a.j0.c cVar = t.c(i0Var2, invoke2, pVar);
        gVar = cVar.b();
        if (i6 == 0) {
            if (gVar != null) {
                i10 = 1;
            } else {
                i10 = 0;
            }
        } else {
        }
        int i16 = i5 - i3;
        if (i10 == 0) {
            d.b bVar2 = new d.b(i0Var2, i16, 0);
            return bVar2;
        }
        kotlin.reflect.jvm.internal.impl.descriptors.h1.g[] arr = new g[3];
        c0 c0Var = c0.a;
        if (invoke2.d()) {
            i0Var = obj.f(c0.i(t.a(p.l(i0.getAnnotations(), gVar2, gVar)), t0Var3, arrayList, (Boolean)cVar.a().booleanValue(), 0, 16, 0));
        }
        if (gVar != null && invoke2.e()) {
            if (invoke2.e()) {
                i = 1;
            }
        }
        if (i != 0) {
            i0Var = e1.d(i0Var2, i0Var);
        }
        d.b bVar = new d.b((i0)i0Var, i16, 1);
        return bVar;
    }

    static kotlin.i0.z.e.m0.d.a.j0.d.b d(kotlin.i0.z.e.m0.d.a.j0.d d, i0 i02, l l3, int i4, kotlin.i0.z.e.m0.d.a.j0.p p5, boolean z6, int i7, Object object8) {
        int obj11;
        if (i7 &= 8 != 0) {
            obj11 = 0;
        }
        return d.c(i02, l3, i4, p5, obj11);
    }

    private final kotlin.i0.z.e.m0.d.a.j0.d.a e(g1 g1, l<? super Integer, kotlin.i0.z.e.m0.d.a.j0.e> l2, int i3) {
        i0 i0Var;
        int i4;
        int i2;
        l lVar;
        i0 i0Var2;
        Object iNFLEXIBLE;
        int i;
        kotlin.i0.z.e.m0.d.a.j0.p fLEXIBLE_UPPER;
        boolean z;
        b0 b0Var;
        kotlin.i0.z.e.m0.d.a.j0.d.b bVar;
        b0 obj12;
        Object obj13;
        boolean obj14;
        i2 = 1;
        if (d0.a(g1)) {
            obj13 = new d.a(g1, i2, 0);
            return obj13;
        }
        if (g1 instanceof v) {
            b0Var = g1;
            lVar = this;
            iNFLEXIBLE = l2;
            i = i3;
            z = z4;
            bVar = lVar.c((v)b0Var.T0(), iNFLEXIBLE, i, p.FLEXIBLE_LOWER, z);
            obj13 = lVar.c(b0Var.U0(), iNFLEXIBLE, i, p.FLEXIBLE_UPPER, z);
            obj14 = bVar.a();
            int i5 = obj13.a();
            if (!bVar.d()) {
                if (obj13.d()) {
                    i4 = i2;
                }
            } else {
            }
            if (i4 != 0) {
                if (g1 instanceof f) {
                    obj12 = new f(bVar.e(), obj13.e());
                } else {
                    obj12 = c0.a;
                    obj12 = c0.d(bVar.e(), obj13.e());
                }
                obj12 = e1.d(obj12, a(bVar.e(), obj13.e()));
            }
            obj13 = new d.a(obj12, bVar.a(), i4);
            return obj13;
        } else {
            if (!g1 instanceof i0) {
            } else {
                obj13 = d.d(this, (i0)g1, l2, i3, p.INFLEXIBLE, false, 8, 0);
            }
        }
        obj12 = new NoWhenBranchMatchedException();
        throw obj12;
    }

    private final i0 f(i0 i0) {
        int gVar;
        i0 obj2;
        if (this.a.a()) {
            obj2 = l0.h(i0, true);
        } else {
            gVar = new g(i0);
            obj2 = gVar;
        }
        return obj2;
    }

    public final b0 b(b0 b0, l<? super Integer, kotlin.i0.z.e.m0.d.a.j0.e> l2) {
        n.f(b0, "<this>");
        n.f(l2, "qualifiers");
        return e(b0.O0(), l2, 0).c();
    }
}
