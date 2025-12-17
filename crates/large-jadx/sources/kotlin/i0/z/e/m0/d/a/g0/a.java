package kotlin.i0.z.e.m0.d.a.g0;

import java.util.ArrayList;
import java.util.Collection;
import java.util.EnumMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.d0.c.a;
import kotlin.d0.d.n;
import kotlin.d0.d.p;
import kotlin.h;
import kotlin.i0.z.e.m0.d.a.c;
import kotlin.i0.z.e.m0.d.a.c.a;
import kotlin.i0.z.e.m0.d.a.i0.z;
import kotlin.i0.z.e.m0.d.a.j0.i;
import kotlin.i0.z.e.m0.d.a.j0.l;
import kotlin.i0.z.e.m0.d.a.s;
import kotlin.i0.z.e.m0.d.a.w;
import kotlin.j;
import kotlin.m;
import kotlin.reflect.jvm.internal.impl.descriptors.g;
import kotlin.reflect.jvm.internal.impl.descriptors.h1.a;
import kotlin.reflect.jvm.internal.impl.descriptors.h1.c;
import kotlin.reflect.jvm.internal.impl.descriptors.h1.g;
import kotlin.reflect.jvm.internal.impl.descriptors.m;
import kotlin.reflect.jvm.internal.impl.utils.e;
import kotlin.reflect.jvm.internal.impl.utils.h;

/* loaded from: classes3.dex */
public final class a {

    static final class a extends p implements a<w> {

        final g $containingDeclaration;
        final kotlin.i0.z.e.m0.d.a.g0.g $this_childForClassOrPackage;
        a(kotlin.i0.z.e.m0.d.a.g0.g g, g g2) {
            this.$this_childForClassOrPackage = g;
            this.$containingDeclaration = g2;
            super(0);
        }

        @Override // kotlin.d0.d.p
        public final w a() {
            return a.g(this.$this_childForClassOrPackage, this.$containingDeclaration.getAnnotations());
        }

        @Override // kotlin.d0.d.p
        public Object invoke() {
            return a();
        }
    }

    static final class b extends p implements a<w> {

        final g $additionalAnnotations;
        final kotlin.i0.z.e.m0.d.a.g0.g $this_copyWithNewDefaultTypeQualifiers;
        b(kotlin.i0.z.e.m0.d.a.g0.g g, g g2) {
            this.$this_copyWithNewDefaultTypeQualifiers = g;
            this.$additionalAnnotations = g2;
            super(0);
        }

        @Override // kotlin.d0.d.p
        public final w a() {
            return a.g(this.$this_copyWithNewDefaultTypeQualifiers, this.$additionalAnnotations);
        }

        @Override // kotlin.d0.d.p
        public Object invoke() {
            return a();
        }
    }
    private static final kotlin.i0.z.e.m0.d.a.g0.g a(kotlin.i0.z.e.m0.d.a.g0.g g, m m2, z z3, int i4, h<w> h5) {
        kotlin.i0.z.e.m0.d.a.g0.h hVar;
        int obj3;
        if (z3 == null) {
            obj3 = 0;
        } else {
            hVar = new h(g, m2, z3, i4);
            obj3 = hVar;
        }
        if (obj3 == null) {
            obj3 = g.f();
        }
        g obj2 = new g(g.a(), obj3, h5);
        return obj2;
    }

    public static final kotlin.i0.z.e.m0.d.a.g0.g b(kotlin.i0.z.e.m0.d.a.g0.g g, kotlin.i0.z.e.m0.d.a.g0.k k2) {
        n.f(g, "<this>");
        n.f(k2, "typeParameterResolver");
        g gVar = new g(g.a(), k2, g.c());
        return gVar;
    }

    public static final kotlin.i0.z.e.m0.d.a.g0.g c(kotlin.i0.z.e.m0.d.a.g0.g g, g g2, z z3, int i4) {
        n.f(g, "<this>");
        n.f(g2, "containingDeclaration");
        a.a aVar = new a.a(g, g2);
        return a.a(g, g2, z3, i4, j.a(m.NONE, aVar));
    }

    public static kotlin.i0.z.e.m0.d.a.g0.g d(kotlin.i0.z.e.m0.d.a.g0.g g, g g2, z z3, int i4, int i5, Object object6) {
        int obj2;
        int obj3;
        if (i5 & 2 != 0) {
            obj2 = 0;
        }
        if (i5 &= 4 != 0) {
            obj3 = 0;
        }
        return a.c(g, g2, obj2, obj3);
    }

    public static final kotlin.i0.z.e.m0.d.a.g0.g e(kotlin.i0.z.e.m0.d.a.g0.g g, m m2, z z3, int i4) {
        n.f(g, "<this>");
        n.f(m2, "containingDeclaration");
        n.f(z3, "typeParameterOwner");
        return a.a(g, m2, z3, i4, g.c());
    }

    public static kotlin.i0.z.e.m0.d.a.g0.g f(kotlin.i0.z.e.m0.d.a.g0.g g, m m2, z z3, int i4, int i5, Object object6) {
        int obj3;
        if (i5 &= 4 != 0) {
            obj3 = 0;
        }
        return a.e(g, m2, z3, obj3);
    }

    public static final w g(kotlin.i0.z.e.m0.d.a.g0.g g, g g2) {
        s sVar;
        int enumMap;
        Object next2;
        Iterator iterator;
        boolean next;
        w obj5;
        Object obj6;
        n.f(g, "<this>");
        n.f(g2, "additionalAnnotations");
        if (g.a().h().a()) {
            return g.b();
        }
        ArrayList arrayList = new ArrayList();
        obj6 = g2.iterator();
        while (obj6.hasNext()) {
            sVar = a.i(g, (c)obj6.next());
            if (sVar != null) {
            }
            arrayList.add(sVar);
        }
        if (arrayList.isEmpty()) {
            return g.b();
        }
        obj6 = g.b();
        enumMap = 0;
        if (obj6 == null) {
        } else {
            obj6 = obj6.b();
            if (obj6 == null) {
            } else {
                enumMap = new EnumMap(obj6);
            }
        }
        if (enumMap == null) {
            enumMap = new EnumMap(a.class);
        }
        obj6 = 0;
        Iterator iterator2 = arrayList.iterator();
        for (s next2 : iterator2) {
            iterator = next2.f().iterator();
            for (a obj6 : iterator) {
                enumMap.put(obj6, next2);
                obj6 = 1;
            }
            enumMap.put((a)iterator.next(), next2);
            obj6 = 1;
        }
        if (obj6 == null) {
            obj5 = g.b();
        } else {
            obj5 = new w(enumMap);
        }
        return obj5;
    }

    public static final kotlin.i0.z.e.m0.d.a.g0.g h(kotlin.i0.z.e.m0.d.a.g0.g g, g g2) {
        boolean gVar;
        kotlin.i0.z.e.m0.d.a.g0.b bVar;
        kotlin.i0.z.e.m0.d.a.g0.k kVar;
        m nONE;
        kotlin.i0.z.e.m0.d.a.g0.a.b bVar2;
        Object obj5;
        n.f(g, "<this>");
        n.f(g2, "additionalAnnotations");
        if (g2.isEmpty()) {
        } else {
            bVar2 = new a.b(g, g2);
            gVar = new g(g.a(), g.f(), j.a(m.NONE, bVar2));
            obj5 = gVar;
        }
        return obj5;
    }

    private static final s i(kotlin.i0.z.e.m0.d.a.g0.g g, c c2) {
        int z;
        i iVar;
        i obj10;
        h obj11;
        c cVar = g.a().a();
        s sVar = cVar.l(c2);
        c.a aVar = cVar.n(c2);
        final int i2 = 0;
        if (sVar == null && aVar == null) {
            aVar = cVar.n(c2);
            i2 = 0;
            if (aVar == null) {
                return i2;
            }
            final c cVar3 = aVar.a();
            if (cVar.k(c2) == null) {
                obj11 = cVar.j(cVar3);
            }
            if (obj11.isIgnore()) {
                return i2;
            }
            obj10 = g.a().q().h(cVar3, g.a().p().b(), false);
            if (obj10 == null) {
                iVar = i2;
            } else {
                iVar = obj10;
            }
            if (iVar == null) {
                return i2;
            }
            super(iVar, aVar.b(), 0, 4, 0);
            return obj10;
        }
        return sVar;
    }

    public static final kotlin.i0.z.e.m0.d.a.g0.g j(kotlin.i0.z.e.m0.d.a.g0.g g, kotlin.i0.z.e.m0.d.a.g0.b b2) {
        n.f(g, "<this>");
        n.f(b2, "components");
        g gVar = new g(b2, g.f(), g.c());
        return gVar;
    }
}
