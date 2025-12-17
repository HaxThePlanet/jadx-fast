package kotlin.i0.z.e.m0.i.v;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import kotlin.d0.d.g;
import kotlin.d0.d.n;
import kotlin.y.p;

/* loaded from: classes3.dex */
public final class d {

    public static final kotlin.i0.z.e.m0.i.v.d.a c = null;
    private static int d = 1;
    private static final int e;
    private static final int f;
    private static final int g;
    private static final int h;
    private static final int i;
    private static final int j;
    private static final int k;
    private static final int l;
    private static final int m;
    private static final int n;
    public static final kotlin.i0.z.e.m0.i.v.d o;
    public static final kotlin.i0.z.e.m0.i.v.d p;
    public static final kotlin.i0.z.e.m0.i.v.d q;
    public static final kotlin.i0.z.e.m0.i.v.d r;
    public static final kotlin.i0.z.e.m0.i.v.d s;
    private static final List<kotlin.i0.z.e.m0.i.v.d.a.a> t;
    private static final List<kotlin.i0.z.e.m0.i.v.d.a.a> u;
    private final List<kotlin.i0.z.e.m0.i.v.c> a;
    private final int b;

    public static final class a {
        public a(g g) {
            super();
        }

        public static final int a(kotlin.i0.z.e.m0.i.v.d.a d$a) {
            return a.l();
        }

        private final int l() {
            d.m(i2 <<= 1);
            return d.g();
        }

        public final int b() {
            return d.b();
        }

        public final int c() {
            return d.c();
        }

        public final int d() {
            return d.d();
        }

        public final int e() {
            return d.e();
        }

        public final int f() {
            return d.f();
        }

        public final int g() {
            return d.h();
        }

        public final int h() {
            return d.i();
        }

        public final int i() {
            return d.j();
        }

        public final int j() {
            return d.k();
        }

        public final int k() {
            return d.l();
        }
    }
    static {
        int length2;
        boolean next;
        int intValue;
        int length;
        boolean tYPE;
        int i;
        int str;
        Field static;
        boolean aVar;
        Class<kotlin.i0.z.e.m0.i.v.d> obj = d.class;
        final int i3 = 0;
        d.a aVar2 = new d.a(i3);
        d.c = aVar2;
        d.e = d.a.a(aVar2);
        d.f = d.a.a(aVar2);
        d.g = d.a.a(aVar2);
        d.h = d.a.a(aVar2);
        d.i = d.a.a(aVar2);
        d.j = d.a.a(aVar2);
        final int i20 = 1;
        d.k = i10 -= i20;
        d.l = i13 |= i22;
        d.m = i16 |= i24;
        d.n = i18 |= i25;
        int i36 = 2;
        d dVar = new d(aVar2.b(), i3, i36, i3);
        d.o = dVar;
        d dVar2 = new d(aVar2.c(), i3, i36, i3);
        d.p = dVar2;
        d dVar3 = new d(aVar2.f(), i3, i36, i3);
        d dVar4 = new d(aVar2.h(), i3, i36, i3);
        d dVar5 = new d(aVar2.i(), i3, i36, i3);
        d dVar6 = new d(aVar2.d(), i3, i36, i3);
        d.q = dVar6;
        d dVar7 = new d(aVar2.g(), i3, i36, i3);
        d dVar8 = new d(aVar2.e(), i3, i36, i3);
        d.r = dVar8;
        d dVar9 = new d(aVar2.k(), i3, i36, i3);
        d.s = dVar9;
        d dVar10 = new d(aVar2.j(), i3, i36, i3);
        Field[] fields2 = obj.getFields();
        String str2 = "T::class.java.fields";
        n.e(fields2, str2);
        ArrayList arrayList5 = new ArrayList();
        final int i39 = 0;
        str = i39;
        while (str < fields2.length) {
            static = fields2[str];
            if (Modifier.isStatic(static.getModifiers())) {
            }
            str++;
            arrayList5.add(static);
        }
        ArrayList arrayList2 = new ArrayList();
        Iterator iterator3 = arrayList5.iterator();
        str = "field.name";
        while (iterator3.hasNext()) {
            length = iterator3.next();
            if (static instanceof d) {
            } else {
            }
            static = i3;
            if (static != 0) {
            } else {
            }
            aVar = i3;
            if (aVar != 0) {
            }
            str = "field.name";
            arrayList2.add(aVar);
            length = length.getName();
            n.e(length, str);
            aVar = new d.a.a(static.o(), length);
        }
        d.t = arrayList2;
        Field[] fields = obj.getFields();
        n.e(fields, str2);
        ArrayList arrayList3 = new ArrayList();
        intValue = i39;
        while (intValue < fields.length) {
            tYPE = fields[intValue];
            if (Modifier.isStatic(tYPE.getModifiers())) {
            }
            intValue++;
            arrayList3.add(tYPE);
        }
        ArrayList arrayList = new ArrayList();
        Iterator iterator2 = arrayList3.iterator();
        while (iterator2.hasNext()) {
            length2 = iterator2.next();
            if (n.b((Field)length2.getType(), Integer.TYPE) != 0) {
            }
            arrayList.add(length2);
        }
        ArrayList arrayList4 = new ArrayList();
        Iterator iterator = arrayList.iterator();
        while (iterator.hasNext()) {
            next = iterator.next();
            Object obj2 = (Field)next.get(i3);
            Objects.requireNonNull(obj2, "null cannot be cast to non-null type kotlin.Int");
            intValue = (Integer)obj2.intValue();
            if (intValue == i37 &= intValue) {
            } else {
            }
            i = i39;
            if (i != 0) {
            } else {
            }
            tYPE = i3;
            if (tYPE != null) {
            }
            arrayList4.add(tYPE);
            next = next.getName();
            n.e(next, str);
            tYPE = new d.a.a(intValue, next);
            i = i20;
        }
        d.u = arrayList4;
    }

    public d(int i, List<? extends kotlin.i0.z.e.m0.i.v.c> list2) {
        String str;
        int obj2;
        n.f(list2, "excludes");
        super();
        this.a = list2;
        final Iterator obj3 = list2.iterator();
        for (c next2 : obj3) {
            obj2 &= str;
        }
        this.b = obj2;
    }

    public d(int i, List list2, int i3, g g4) {
        List obj2;
        if (i3 &= 2 != 0) {
            obj2 = p.g();
        }
        super(i, obj2);
    }

    public static final int b() {
        return d.k;
    }

    public static final int c() {
        return d.n;
    }

    public static final int d() {
        return d.l;
    }

    public static final int e() {
        return d.i;
    }

    public static final int f() {
        return d.e;
    }

    public static final int g() {
        return d.d;
    }

    public static final int h() {
        return d.h;
    }

    public static final int i() {
        return d.f;
    }

    public static final int j() {
        return d.g;
    }

    public static final int k() {
        return d.m;
    }

    public static final int l() {
        return d.j;
    }

    public static final void m(int i) {
        d.d = i;
    }

    public final boolean a(int i) {
        int obj2;
        obj2 = i &= i2 != 0 ? 1 : 0;
        return obj2;
    }

    public final List<kotlin.i0.z.e.m0.i.v.c> n() {
        return this.a;
    }

    public final int o() {
        return this.b;
    }

    public final kotlin.i0.z.e.m0.i.v.d p(int i) {
        i &= i2;
        if (obj3 == null) {
            return null;
        }
        d dVar = new d(obj3, this.a);
        return dVar;
    }

    public String toString() {
        int i2;
        Object next;
        int i8;
        int arrayList;
        int str;
        int i3;
        int i;
        int i9;
        int i4;
        int i5;
        int i6;
        int i7;
        Iterator iterator = d.t.iterator();
        i8 = 0;
        while (iterator.hasNext()) {
            if ((d.a.a)iterator.next().a() == o()) {
            } else {
            }
            arrayList = 0;
            i8 = 0;
            arrayList = 1;
        }
        next = i8;
        if ((d.a.a)next == 0) {
            i2 = i8;
        } else {
            i2 = (d.a.a)next.b();
        }
        if (i2 == 0) {
            arrayList = new ArrayList();
            Iterator iterator2 = d.u.iterator();
            while (iterator2.hasNext()) {
                Object next3 = iterator2.next();
                if (a((d.a.a)next3.a()) != 0) {
                } else {
                }
                next = i8;
                if (next != 0) {
                }
                arrayList.add(next);
                next = next3.b();
            }
            i2 = p.h0(arrayList, " | ", 0, 0, 0, 0, 0, 62, 0);
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("DescriptorKindFilter(");
        stringBuilder.append(i2);
        stringBuilder.append(", ");
        stringBuilder.append(this.a);
        stringBuilder.append(')');
        return stringBuilder.toString();
    }
}
