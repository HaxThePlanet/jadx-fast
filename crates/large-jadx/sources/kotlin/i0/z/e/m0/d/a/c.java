package kotlin.i0.z.e.m0.d.a;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import kotlin.d0.c.l;
import kotlin.d0.c.p;
import kotlin.d0.d.c0;
import kotlin.d0.d.j;
import kotlin.d0.d.n;
import kotlin.d0.d.p;
import kotlin.i0.f;
import kotlin.i0.z.e.m0.d.a.e0.d;
import kotlin.i0.z.e.m0.d.a.j0.i;
import kotlin.i0.z.e.m0.f.b;
import kotlin.i0.z.e.m0.f.e;
import kotlin.i0.z.e.m0.i.q.g;
import kotlin.i0.z.e.m0.i.q.j;
import kotlin.i0.z.e.m0.i.s.a;
import kotlin.i0.z.e.m0.k.h;
import kotlin.i0.z.e.m0.k.n;
import kotlin.reflect.jvm.internal.impl.descriptors.e;
import kotlin.reflect.jvm.internal.impl.descriptors.f;
import kotlin.reflect.jvm.internal.impl.descriptors.h1.a;
import kotlin.reflect.jvm.internal.impl.descriptors.h1.c;
import kotlin.reflect.jvm.internal.impl.descriptors.h1.g;
import kotlin.reflect.jvm.internal.impl.utils.e;
import kotlin.reflect.jvm.internal.impl.utils.h;
import kotlin.y.p;

/* loaded from: classes3.dex */
public final class c {

    private final e a;
    private final h<e, c> b;

    public static final class a {

        private final c a;
        private final int b;
        public a(c c, int i2) {
            n.f(c, "typeQualifier");
            super();
            this.a = c;
            this.b = i2;
        }

        private final boolean c(kotlin.i0.z.e.m0.d.a.a a) {
            int i;
            if (obj3 &= i2 != 0) {
            } else {
                i = 0;
            }
            return i;
        }

        private final boolean d(kotlin.i0.z.e.m0.d.a.a a) {
            boolean tYPE_PARAMETER_BOUNDS;
            int i;
            if (c(a)) {
                return 1;
            }
            if (c(a.TYPE_USE) && a != a.TYPE_PARAMETER_BOUNDS) {
                if (a != a.TYPE_PARAMETER_BOUNDS) {
                } else {
                    i = 0;
                }
            } else {
            }
            return i;
        }

        public final c a() {
            return this.a;
        }

        public final List<kotlin.i0.z.e.m0.d.a.a> b() {
            int i;
            kotlin.i0.z.e.m0.d.a.a aVar;
            boolean z;
            final kotlin.i0.z.e.m0.d.a.a[] values = a.values();
            ArrayList arrayList = new ArrayList();
            i = 0;
            while (i < values.length) {
                aVar = values[i];
                if (d(aVar)) {
                }
                i++;
                arrayList.add(aVar);
            }
            return arrayList;
        }
    }

    static final class b extends p implements p<j, kotlin.i0.z.e.m0.d.a.a, Boolean> {

        public static final kotlin.i0.z.e.m0.d.a.c.b a;
        static {
            c.b bVar = new c.b();
            c.b.a = bVar;
        }

        b() {
            super(2);
        }

        @Override // kotlin.d0.d.p
        public final boolean a(j j, kotlin.i0.z.e.m0.d.a.a a2) {
            n.f(j, "<this>");
            n.f(a2, "it");
            return n.b(j.c().f(), a2.getJavaTarget());
        }

        @Override // kotlin.d0.d.p
        public Object invoke(Object object, Object object2) {
            return Boolean.valueOf(a((j)object, (a)object2));
        }
    }

    static final class c extends p implements p<j, kotlin.i0.z.e.m0.d.a.a, Boolean> {

        final kotlin.i0.z.e.m0.d.a.c this$0;
        c(kotlin.i0.z.e.m0.d.a.c c) {
            this.this$0 = c;
            super(2);
        }

        @Override // kotlin.d0.d.p
        public final boolean a(j j, kotlin.i0.z.e.m0.d.a.a a2) {
            n.f(j, "<this>");
            n.f(a2, "it");
            return c.b(this.this$0, a2.getJavaTarget()).contains(j.c().f());
        }

        @Override // kotlin.d0.d.p
        public Object invoke(Object object, Object object2) {
            return Boolean.valueOf(a((j)object, (a)object2));
        }
    }

    class d extends j implements l<e, c> {
        d(kotlin.i0.z.e.m0.d.a.c c) {
            super(1, c);
        }

        @Override // kotlin.d0.d.j
        public final String getName() {
            return "computeTypeQualifierNickname";
        }

        @Override // kotlin.d0.d.j
        public final f getOwner() {
            return c0.b(c.class);
        }

        @Override // kotlin.d0.d.j
        public final String getSignature() {
            return "computeTypeQualifierNickname(Lorg/jetbrains/kotlin/descriptors/ClassDescriptor;)Lorg/jetbrains/kotlin/descriptors/annotations/AnnotationDescriptor;";
        }

        @Override // kotlin.d0.d.j
        public Object invoke(Object object) {
            return l((e)object);
        }

        @Override // kotlin.d0.d.j
        public final c l(e e) {
            n.f(e, "p0");
            return c.a((c)this.receiver, e);
        }
    }
    public c(n n, e e2) {
        n.f(n, "storageManager");
        n.f(e2, "javaTypeEnhancementState");
        super();
        this.a = e2;
        c.d obj3 = new c.d(this);
        this.b = n.i(obj3);
    }

    public static final c a(kotlin.i0.z.e.m0.d.a.c c, e e2) {
        return c.c(e2);
    }

    public static final List b(kotlin.i0.z.e.m0.d.a.c c, String string2) {
        return c.p(string2);
    }

    private final c c(e e) {
        boolean next;
        int i;
        if (!e.getAnnotations().u1(b.g())) {
            return null;
        }
        Iterator obj3 = e.getAnnotations().iterator();
        while (obj3.hasNext()) {
            next = m((c)obj3.next());
            if (next) {
                break;
            } else {
            }
        }
        return i;
    }

    private final List<kotlin.i0.z.e.m0.d.a.a> d(g<?> g, p<? super j, ? super kotlin.i0.z.e.m0.d.a.a, Boolean> p2) {
        Object arrayList;
        boolean length;
        int i;
        kotlin.i0.z.e.m0.d.a.a aVar;
        boolean booleanValue;
        Object obj6;
        if (g instanceof b) {
            arrayList = new ArrayList();
            obj6 = (Iterable)(b)g.b().iterator();
            for (g next : obj6) {
                p.y(arrayList, d(next, p2));
            }
        } else {
            if (g instanceof j) {
                kotlin.i0.z.e.m0.d.a.a[] values = a.values();
                i = 0;
                while (i < values.length) {
                    i++;
                }
                aVar = 0;
                arrayList = p.k(aVar);
            } else {
                arrayList = p.g();
            }
        }
        return arrayList;
    }

    private final List<kotlin.i0.z.e.m0.d.a.a> e(g<?> g) {
        return d(g, c.b.a);
    }

    private final List<kotlin.i0.z.e.m0.d.a.a> f(g<?> g) {
        c.c cVar = new c.c(this);
        return d(g, cVar);
    }

    private final h g(e e) {
        int sTRICT;
        int str;
        int i;
        int obj4;
        obj4 = e.getAnnotations().o(b.d());
        sTRICT = 0;
        if (obj4 == null) {
            obj4 = sTRICT;
        } else {
            obj4 = a.b(obj4);
        }
        if (obj4 instanceof j) {
        } else {
            obj4 = sTRICT;
        }
        if (obj4 == null) {
            return sTRICT;
        }
        h hVar = this.a.f();
        if (hVar == null) {
            obj4 = obj4.c().c();
            str = obj4.hashCode();
            if (str != -2137067054) {
                if (str != -1838656823) {
                    if (str != 2656902) {
                    } else {
                        if (!obj4.equals("WARN")) {
                        } else {
                            sTRICT = h.WARN;
                        }
                    }
                } else {
                    if (!obj4.equals("STRICT")) {
                    } else {
                        sTRICT = h.STRICT;
                    }
                }
            } else {
                if (!obj4.equals("IGNORE")) {
                } else {
                    sTRICT = h.IGNORE;
                }
            }
            return sTRICT;
        }
        return hVar;
    }

    private final h i(c c) {
        if (b.c().containsKey(c.d())) {
            return this.a.e();
        }
        return j(c);
    }

    private final c o(e e) {
        if (e.f() != f.ANNOTATION_CLASS) {
            return null;
        }
        return (c)this.b.invoke(e);
    }

    private final List<String> p(String string) {
        int name;
        Set obj3 = d.a.b(string);
        ArrayList arrayList = new ArrayList(p.r(obj3, 10));
        obj3 = obj3.iterator();
        for (n next2 : obj3) {
            arrayList.add(next2.name());
        }
        return arrayList;
    }

    public final kotlin.i0.z.e.m0.d.a.c.a h(c c) {
        int i;
        b bVar;
        boolean next;
        String str;
        n.f(c, "annotationDescriptor");
        e eVar = a.f(c);
        int i2 = 0;
        if (eVar == null) {
            return i2;
        }
        bVar = y.c;
        n.e(bVar, "TARGET_ANNOTATION");
        c cVar = eVar.getAnnotations().o(bVar);
        if (cVar == null) {
            return i2;
        }
        ArrayList arrayList = new ArrayList();
        Iterator iterator = cVar.a().entrySet().iterator();
        for (Map.Entry next4 : iterator) {
            p.y(arrayList, f((g)next4.getValue()));
        }
        i = 0;
        Iterator iterator2 = arrayList.iterator();
        for (a next3 : iterator2) {
            i |= next;
        }
        c.a aVar = new c.a(c, i);
        return aVar;
    }

    public final h j(c c) {
        h obj2;
        n.f(c, "annotationDescriptor");
        if (k(c) == null) {
            obj2 = this.a.d();
        }
        return obj2;
    }

    public final h k(c c) {
        String str;
        h i;
        n.f(c, "annotationDescriptor");
        b bVar = c.d();
        if (bVar == null) {
            str = i;
        } else {
            str = bVar.b();
        }
        Object obj = this.a.g().get(str);
        if ((h)obj == null) {
            final e obj4 = a.f(c);
            if (obj4 == null) {
            } else {
                i = g(obj4);
            }
            return i;
        }
        return (h)obj;
    }

    public final kotlin.i0.z.e.m0.d.a.s l(c c) {
        Object obj;
        int i;
        int i3;
        i iVar;
        int i2;
        int i5;
        int i4;
        int i6;
        Object obj9;
        n.f(c, "annotationDescriptor");
        i3 = 0;
        if (this.a.a()) {
            return i3;
        }
        Object obj2 = obj;
        if ((s)obj2 == null) {
        } else {
            int i7 = 1;
            i = i(c) != h.IGNORE ? i7 : 0;
            if (i != 0) {
            } else {
                obj9 = i3;
            }
            if (obj9 == null) {
                return i3;
            }
            i3 = s.b(obj2, i.b((s)obj2.e(), i3, obj9.isWarning(), i7, i3), 0, false, 6, 0);
        }
        return i3;
    }

    public final c m(c c) {
        n.f(c, "annotationDescriptor");
        int i = 0;
        if (this.a.b()) {
            return i;
        }
        e eVar2 = a.f(c);
        if (eVar2 == null) {
            return i;
        }
        if (d.a(eVar2)) {
            return c;
        }
        return o(eVar2);
    }

    public final kotlin.i0.z.e.m0.d.a.c.a n(c c) {
        int next;
        boolean z2;
        b bVar;
        int i;
        boolean z;
        boolean next2;
        e eVar;
        n.f(c, "annotationDescriptor");
        final int i2 = 0;
        if (this.a.b()) {
            return i2;
        }
        next = a.f(c);
        if (next == null) {
            next = i2;
        } else {
        }
        if (next == 0) {
            return i2;
        }
        e obj7 = a.f(c);
        n.d(obj7);
        obj7 = obj7.getAnnotations().o(b.e());
        n.d(obj7);
        ArrayList arrayList = new ArrayList();
        obj7 = obj7.a().entrySet().iterator();
        while (obj7.hasNext()) {
            Object next5 = obj7.next();
            if (n.b((e)(Map.Entry)next5.getKey(), y.b)) {
            } else {
            }
            bVar = p.g();
            p.y(arrayList, bVar);
            bVar = e((g)next5.getValue());
        }
        obj7 = arrayList.iterator();
        int i3 = 0;
        i = i3;
        eVar = 1;
        for (a next6 : obj7) {
            i |= z;
            eVar = 1;
        }
        obj7 = next.getAnnotations().iterator();
        while (obj7.hasNext()) {
            if (m((c)obj7.next()) != null) {
            } else {
            }
            next2 = i3;
            next2 = eVar;
        }
        next = i2;
        if ((c)next == 0) {
            return i2;
        }
        obj7 = new c.a((c)next, i);
        return obj7;
    }
}
