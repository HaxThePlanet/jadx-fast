package kotlin.i0.z.e.m0.m;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.d0.c.l;
import kotlin.d0.d.n;
import kotlin.d0.d.p;
import kotlin.i0.z.e.m0.b.h;
import kotlin.i0.z.e.m0.i.s.a;
import kotlin.i0.z.e.m0.l.m1.a;
import kotlin.reflect.jvm.internal.impl.descriptors.a;
import kotlin.reflect.jvm.internal.impl.descriptors.b1;
import kotlin.reflect.jvm.internal.impl.descriptors.c1;
import kotlin.reflect.jvm.internal.impl.descriptors.m;
import kotlin.reflect.jvm.internal.impl.descriptors.x;
import kotlin.y.p;

/* loaded from: classes3.dex */
public final class i extends kotlin.i0.z.e.m0.m.a {

    public static final kotlin.i0.z.e.m0.m.i a;
    private static final List<kotlin.i0.z.e.m0.m.d> b;

    static final class a extends p implements l<x, String> {

        public static final kotlin.i0.z.e.m0.m.i.a a;
        static {
            i.a aVar = new i.a();
            i.a.a = aVar;
        }

        a() {
            super(1);
        }

        @Override // kotlin.d0.d.p
        public final String a(x x) {
            int str;
            boolean z;
            Boolean obj3;
            n.f(x, "<this>");
            obj3 = x.h();
            n.e(obj3, "valueParameters");
            obj3 = p.l0(obj3);
            if ((c1)obj3 == null) {
                obj3 = str;
            } else {
                if (!a.a((c1)obj3) && obj3.l0() == null) {
                    obj3 = obj3.l0() == null ? 1 : 0;
                } else {
                }
                obj3 = Boolean.valueOf(obj3);
            }
            kotlin.i0.z.e.m0.m.i iVar = i.a;
            if (!n.b(obj3, Boolean.TRUE)) {
                str = "last parameter should not have a default value or be a vararg";
            }
            return str;
        }

        @Override // kotlin.d0.d.p
        public Object invoke(Object object) {
            return a((x)object);
        }
    }

    static final class b extends p implements l<x, String> {

        public static final kotlin.i0.z.e.m0.m.i.b a;
        static {
            i.b bVar = new i.b();
            i.b.a = bVar;
        }

        b() {
            super(1);
        }

        private static final boolean b(m m) {
            Object obj1;
            if (m instanceof e && h.Z((e)m)) {
                obj1 = h.Z((e)m) ? 1 : 0;
            } else {
            }
            return obj1;
        }

        @Override // kotlin.d0.d.p
        public final String a(x x) {
            boolean empty;
            int i;
            String str;
            Object obj5;
            n.f(x, "<this>");
            kotlin.i0.z.e.m0.m.i iVar = i.a;
            m mVar = x.b();
            n.e(mVar, "containingDeclaration");
            final int i2 = 0;
            if (!i.b.b(mVar)) {
                obj5 = x.e();
                n.e(obj5, "overriddenDescriptors");
                if (obj5.isEmpty()) {
                    obj5 = i2;
                } else {
                    obj5 = obj5.iterator();
                    for (x next : obj5) {
                        m mVar2 = next.b();
                        n.e(mVar2, "it.containingDeclaration");
                    }
                }
                if (obj5 != null) {
                } else {
                    i = i2;
                }
            }
            obj5 = i == 0 ? "must override ''equals()'' in Any" : 0;
            return obj5;
        }

        @Override // kotlin.d0.d.p
        public Object invoke(Object object) {
            return a((x)object);
        }
    }

    static final class c extends p implements l<x, String> {

        public static final kotlin.i0.z.e.m0.m.i.c a;
        static {
            i.c cVar = new i.c();
            i.c.a = cVar;
        }

        c() {
            super(1);
        }

        @Override // kotlin.d0.d.p
        public final String a(x x) {
            kotlin.reflect.jvm.internal.impl.descriptors.r0 type;
            int i;
            String str;
            boolean obj4;
            n.f(x, "<this>");
            if (x.f0() == null) {
                type = x.m0();
            }
            kotlin.i0.z.e.m0.m.i iVar = i.a;
            if (type != null) {
                obj4 = x.getReturnType();
                if (obj4 == null) {
                    obj4 = i;
                } else {
                    type = type.getType();
                    n.e(type, "receiver.type");
                    obj4 = a.g(obj4, type);
                }
                if (obj4 != null) {
                    i = 1;
                }
            }
            obj4 = i == 0 ? "receiver must be a supertype of the return type" : 0;
            return obj4;
        }

        @Override // kotlin.d0.d.p
        public Object invoke(Object object) {
            return a((x)object);
        }
    }
    static {
        i iVar = new i();
        i.a = iVar;
        kotlin.i0.z.e.m0.m.d[] arr = new d[18];
        final int i18 = 2;
        kotlin.i0.z.e.m0.m.b[] arr2 = new b[i18];
        final kotlin.i0.z.e.m0.m.f.b bVar3 = f.b.b;
        final int i19 = 0;
        arr2[i19] = bVar3;
        final int i20 = 1;
        l.a aVar = new l.a(i20);
        arr2[i20] = aVar;
        super(j.i, arr2, 0, 4, 0);
        arr[i19] = dVar20;
        kotlin.i0.z.e.m0.m.b[] arr3 = new b[i18];
        arr3[i19] = bVar3;
        l.a aVar2 = new l.a(i18);
        arr3[i20] = aVar2;
        d dVar2 = new d(j.j, arr3, i.a.a);
        arr[i20] = dVar2;
        int i2 = 4;
        kotlin.i0.z.e.m0.m.b[] arr9 = new b[i2];
        arr9[i19] = bVar3;
        kotlin.i0.z.e.m0.m.h hVar = h.a;
        arr9[i20] = hVar;
        l.a aVar4 = new l.a(i18);
        arr9[i18] = aVar4;
        kotlin.i0.z.e.m0.m.e eVar3 = e.a;
        int i8 = 3;
        arr9[i8] = eVar3;
        int i23 = 0;
        int i25 = 4;
        int i28 = 0;
        super(j.a, arr9, i23, i25, i28);
        arr[i18] = dVar3;
        kotlin.i0.z.e.m0.m.b[] arr5 = new b[i2];
        arr5[i19] = bVar3;
        arr5[i20] = hVar;
        l.a aVar6 = new l.a(i8);
        arr5[i18] = aVar6;
        arr5[i8] = eVar3;
        final int i32 = 0;
        final int i33 = 4;
        final int i34 = 0;
        super(j.b, arr5, i32, i33, i34);
        arr[i8] = dVar4;
        kotlin.i0.z.e.m0.m.b[] arr10 = new b[i2];
        arr10[i19] = bVar3;
        arr10[i20] = hVar;
        l.b bVar = new l.b(i18);
        arr10[i18] = bVar;
        arr10[i8] = eVar3;
        super(j.c, arr10, i23, i25, i28);
        arr[i2] = dVar5;
        kotlin.i0.z.e.m0.m.b[] arr4 = new b[i20];
        arr4[i19] = bVar3;
        super(j.g, arr4, i32, i33, i34);
        arr[5] = dVar6;
        kotlin.i0.z.e.m0.m.b[] arr11 = new b[i2];
        arr11[i19] = bVar3;
        kotlin.i0.z.e.m0.m.l.d dVar19 = l.d.b;
        arr11[i20] = dVar19;
        arr11[i18] = hVar;
        kotlin.i0.z.e.m0.m.k.a aVar5 = k.a.d;
        arr11[i8] = aVar5;
        super(j.f, arr11, i23, i25, i28);
        arr[6] = dVar7;
        kotlin.i0.z.e.m0.m.b[] arr12 = new b[i18];
        arr12[i19] = bVar3;
        kotlin.i0.z.e.m0.m.l.c cVar2 = l.c.b;
        arr12[i20] = cVar2;
        super(j.h, arr12, i23, i25, i28);
        arr[7] = dVar8;
        kotlin.i0.z.e.m0.m.b[] arr19 = new b[i18];
        arr19[i19] = bVar3;
        arr19[i20] = cVar2;
        int i26 = 0;
        int i29 = 4;
        int i31 = 0;
        super(j.k, arr19, i26, i29, i31);
        arr[8] = dVar9;
        kotlin.i0.z.e.m0.m.b[] arr20 = new b[i8];
        arr20[i19] = bVar3;
        arr20[i20] = cVar2;
        arr20[i18] = aVar5;
        super(j.l, arr20, i26, i29, i31);
        arr[9] = dVar10;
        kotlin.i0.z.e.m0.m.b[] arr13 = new b[i8];
        arr13[i19] = bVar3;
        arr13[i20] = dVar19;
        arr13[i18] = hVar;
        int i24 = 0;
        int i27 = 4;
        int i30 = 0;
        super(j.y, arr13, i24, i27, i30);
        arr[10] = dVar11;
        kotlin.i0.z.e.m0.m.b[] arr7 = new b[i20];
        arr7[i19] = f.a.b;
        d dVar12 = new d(j.d, arr7, i.b.a);
        arr[11] = dVar12;
        kotlin.i0.z.e.m0.m.b[] arr14 = new b[i2];
        arr14[i19] = bVar3;
        arr14[i20] = k.b.d;
        arr14[i18] = dVar19;
        arr14[i8] = hVar;
        super(j.e, arr14, i24, i27, i30);
        arr[12] = dVar13;
        kotlin.i0.z.e.m0.m.b[] arr15 = new b[i8];
        arr15[i19] = bVar3;
        arr15[i20] = dVar19;
        arr15[i18] = hVar;
        super(j.G, arr15, i24, i27, i30);
        arr[13] = dVar14;
        kotlin.i0.z.e.m0.m.b[] arr16 = new b[i18];
        arr16[i19] = bVar3;
        arr16[i20] = cVar2;
        super(j.F, arr16, i24, i27, i30);
        arr[14] = dVar15;
        kotlin.i0.z.e.m0.f.e[] arr6 = new e[i18];
        arr6[i19] = j.n;
        arr6[i20] = j.o;
        kotlin.i0.z.e.m0.m.b[] arr8 = new b[i20];
        arr8[i19] = bVar3;
        d dVar16 = new d(p.j(arr6), arr8, i.c.a);
        arr[15] = dVar16;
        kotlin.i0.z.e.m0.m.b[] arr17 = new b[i2];
        arr17[i19] = bVar3;
        arr17[i20] = k.c.d;
        arr17[i18] = dVar19;
        arr17[i8] = hVar;
        super(j.H, arr17, i24, i27, i30);
        arr[16] = dVar17;
        kotlin.i0.z.e.m0.m.b[] arr18 = new b[i18];
        arr18[i19] = bVar3;
        arr18[i20] = cVar2;
        super(j.m, arr18, i24, i27, i30);
        arr[17] = dVar18;
        i.b = p.j(arr);
    }

    public List<kotlin.i0.z.e.m0.m.d> b() {
        return i.b;
    }
}
