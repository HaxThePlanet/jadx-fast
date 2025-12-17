package kotlin.i0.z.e.m0.d.a.e0;

import java.util.ArrayList;
import java.util.Collection;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.d0.c.l;
import kotlin.d0.d.n;
import kotlin.d0.d.p;
import kotlin.i0.z.e.m0.b.h;
import kotlin.i0.z.e.m0.b.k.a;
import kotlin.i0.z.e.m0.d.a.i0.b;
import kotlin.i0.z.e.m0.d.a.i0.m;
import kotlin.i0.z.e.m0.f.a;
import kotlin.i0.z.e.m0.f.e;
import kotlin.i0.z.e.m0.i.q.b;
import kotlin.i0.z.e.m0.i.q.g;
import kotlin.i0.z.e.m0.i.q.j;
import kotlin.i0.z.e.m0.l.b0;
import kotlin.i0.z.e.m0.l.t;
import kotlin.reflect.jvm.internal.impl.descriptors.b1;
import kotlin.reflect.jvm.internal.impl.descriptors.c0;
import kotlin.reflect.jvm.internal.impl.descriptors.h1.m;
import kotlin.reflect.jvm.internal.impl.descriptors.h1.n;
import kotlin.u;
import kotlin.y.j0;
import kotlin.y.p;
import kotlin.y.q0;

/* loaded from: classes3.dex */
public final class d {

    public static final kotlin.i0.z.e.m0.d.a.e0.d a;
    private static final Map<String, EnumSet<n>> b;
    private static final Map<String, m> c;

    static final class a extends p implements l<c0, b0> {

        public static final kotlin.i0.z.e.m0.d.a.e0.d.a a;
        static {
            d.a aVar = new d.a();
            d.a.a = aVar;
        }

        a() {
            super(1);
        }

        @Override // kotlin.d0.d.p
        public final b0 a(c0 c0) {
            Object str;
            int obj3;
            n.f(c0, "module");
            obj3 = a.b(c.a.d(), c0.m().o(k.a.A));
            if (obj3 == null) {
                obj3 = 0;
            } else {
                obj3 = obj3.getType();
            }
            if (obj3 == null) {
                n.e(t.j("Error: AnnotationTarget[]"), "createErrorType(\"Error: AnnotationTarget[]\")");
            }
            return obj3;
        }

        @Override // kotlin.d0.d.p
        public Object invoke(Object object) {
            return a((c0)object);
        }
    }
    static {
        d dVar = new d();
        d.a = dVar;
        kotlin.o[] arr = new o[10];
        int i2 = 0;
        arr[i2] = u.a("PACKAGE", EnumSet.noneOf(n.class));
        int i3 = 1;
        arr[i3] = u.a("TYPE", EnumSet.of(n.CLASS, n.FILE));
        int i4 = 2;
        arr[i4] = u.a("ANNOTATION_TYPE", EnumSet.of(n.ANNOTATION_CLASS));
        int i5 = 3;
        arr[i5] = u.a("TYPE_PARAMETER", EnumSet.of(n.TYPE_PARAMETER));
        arr[4] = u.a("FIELD", EnumSet.of(n.FIELD));
        arr[5] = u.a("LOCAL_VARIABLE", EnumSet.of(n.LOCAL_VARIABLE));
        arr[6] = u.a("PARAMETER", EnumSet.of(n.VALUE_PARAMETER));
        arr[7] = u.a("CONSTRUCTOR", EnumSet.of(n.CONSTRUCTOR));
        arr[8] = u.a("METHOD", EnumSet.of(n.FUNCTION, n.PROPERTY_GETTER, n.PROPERTY_SETTER));
        arr[9] = u.a("TYPE_USE", EnumSet.of(n.TYPE));
        d.b = j0.k(arr);
        kotlin.o[] arr2 = new o[i5];
        arr2[i2] = u.a("RUNTIME", m.RUNTIME);
        arr2[i3] = u.a("CLASS", m.BINARY);
        arr2[i4] = u.a("SOURCE", m.SOURCE);
        d.c = j0.k(arr2);
    }

    public final g<?> a(b b) {
        j jVar;
        j i;
        String str;
        int obj4;
        i = 0;
        if (b instanceof m) {
        } else {
            obj4 = i;
        }
        if (obj4 == null) {
        } else {
            obj4 = obj4.d();
            if (obj4 == null) {
                obj4 = i;
            } else {
                obj4 = obj4.c();
            }
            obj4 = d.c.get(obj4);
            if ((m)obj4 == null) {
            } else {
                a aVar = a.m(k.a.C);
                n.e(aVar, "topLevel(StandardNames.FqNames.annotationRetention)");
                obj4 = e.j((m)obj4.name());
                n.e(obj4, "identifier(retention.name)");
                jVar = new j(aVar, obj4);
                i = jVar;
            }
        }
        return i;
    }

    public final Set<n> b(String string) {
        Object obj2;
        if ((EnumSet)d.b.get(string) == null) {
            obj2 = q0.b();
        }
        return obj2;
    }

    public final g<?> c(List<? extends b> list) {
        Object next;
        boolean next2;
        int i;
        int i2;
        boolean jVar;
        a aVar;
        String str;
        n.f(list, "arguments");
        ArrayList arrayList = new ArrayList();
        Iterator obj6 = list.iterator();
        while (obj6.hasNext()) {
            next = obj6.next();
            if (next instanceof m) {
            }
            arrayList.add(next);
        }
        obj6 = new ArrayList();
        Iterator iterator = arrayList.iterator();
        while (iterator.hasNext()) {
            e eVar = (m)iterator.next().d();
            if (eVar == null) {
            } else {
            }
            i2 = eVar.c();
            p.y(obj6, b(i2));
            i2 = 0;
        }
        ArrayList arrayList2 = new ArrayList(p.r(obj6, 10));
        obj6 = obj6.iterator();
        for (n next5 : obj6) {
            aVar = a.m(k.a.B);
            n.e(aVar, "topLevel(StandardNames.FqNames.annotationTarget)");
            i = e.j(next5.name());
            n.e(i, "identifier(kotlinTarget.name)");
            jVar = new j(aVar, i);
            arrayList2.add(jVar);
        }
        obj6 = new b(arrayList2, d.a.a);
        return obj6;
    }
}
