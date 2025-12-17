package kotlin.i0.z.e.m0.j.b.d0;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import kotlin.d0.c.a;
import kotlin.d0.c.l;
import kotlin.d0.d.c0;
import kotlin.d0.d.n;
import kotlin.d0.d.p;
import kotlin.d0.d.x;
import kotlin.i0.l;
import kotlin.i0.z.e.m0.c.b.b;
import kotlin.i0.z.e.m0.e.i;
import kotlin.i0.z.e.m0.e.n;
import kotlin.i0.z.e.m0.e.r;
import kotlin.i0.z.e.m0.f.a;
import kotlin.i0.z.e.m0.f.e;
import kotlin.i0.z.e.m0.i.g;
import kotlin.i0.z.e.m0.i.v.d;
import kotlin.i0.z.e.m0.i.v.d.a;
import kotlin.i0.z.e.m0.i.v.i;
import kotlin.i0.z.e.m0.j.b.j;
import kotlin.i0.z.e.m0.j.b.k;
import kotlin.i0.z.e.m0.j.b.l;
import kotlin.i0.z.e.m0.j.b.u;
import kotlin.i0.z.e.m0.j.b.v;
import kotlin.i0.z.e.m0.k.g;
import kotlin.i0.z.e.m0.k.h;
import kotlin.i0.z.e.m0.k.i;
import kotlin.i0.z.e.m0.k.j;
import kotlin.i0.z.e.m0.k.m;
import kotlin.i0.z.e.m0.k.n;
import kotlin.j0.i;
import kotlin.reflect.jvm.internal.impl.descriptors.d0;
import kotlin.reflect.jvm.internal.impl.descriptors.e;
import kotlin.reflect.jvm.internal.impl.descriptors.h;
import kotlin.reflect.jvm.internal.impl.descriptors.m;
import kotlin.reflect.jvm.internal.impl.descriptors.o0;
import kotlin.reflect.jvm.internal.impl.descriptors.t0;
import kotlin.reflect.jvm.internal.impl.descriptors.y0;
import kotlin.reflect.jvm.internal.impl.protobuf.a;
import kotlin.reflect.jvm.internal.impl.utils.a;
import kotlin.w;
import kotlin.y.j0;
import kotlin.y.p;
import kotlin.y.q0;

/* loaded from: classes3.dex */
public abstract class h extends i {

    static final l<Object>[] f;
    private final l b;
    private final kotlin.i0.z.e.m0.j.b.d0.h.a c;
    private final i d;
    private final j e;

    private interface a {
        public abstract Collection<t0> a(e e, b b2);

        public abstract Set<e> b();

        public abstract Collection<o0> c(e e, b b2);

        public abstract Set<e> d();

        public abstract Set<e> e();

        public abstract void f(Collection<m> collection, d d2, l<? super e, Boolean> l3, b b4);

        public abstract y0 g(e e);
    }

    private final class b implements kotlin.i0.z.e.m0.j.b.d0.h.a {

        static final l<Object>[] o;
        private final List<i> a;
        private final List<n> b;
        private final List<r> c;
        private final i d;
        private final i e;
        private final i f;
        private final i g;
        private final i h;
        private final i i;
        private final i j;
        private final i k;
        private final i l;
        private final i m;
        final kotlin.i0.z.e.m0.j.b.d0.h n;
        static {
            Class<kotlin.i0.z.e.m0.j.b.d0.h.b> obj = h.b.class;
            l[] arr = new l[10];
            x xVar = new x(c0.b(obj), "declaredFunctions", "getDeclaredFunctions()Ljava/util/List;");
            x xVar2 = new x(c0.b(obj), "declaredProperties", "getDeclaredProperties()Ljava/util/List;");
            x xVar3 = new x(c0.b(obj), "allTypeAliases", "getAllTypeAliases()Ljava/util/List;");
            x xVar4 = new x(c0.b(obj), "allFunctions", "getAllFunctions()Ljava/util/List;");
            x xVar5 = new x(c0.b(obj), "allProperties", "getAllProperties()Ljava/util/List;");
            x xVar6 = new x(c0.b(obj), "typeAliasesByName", "getTypeAliasesByName()Ljava/util/Map;");
            x xVar7 = new x(c0.b(obj), "functionsByName", "getFunctionsByName()Ljava/util/Map;");
            x xVar8 = new x(c0.b(obj), "propertiesByName", "getPropertiesByName()Ljava/util/Map;");
            x xVar9 = new x(c0.b(obj), "functionNames", "getFunctionNames()Ljava/util/Set;");
            x xVar10 = new x(c0.b(obj), "variableNames", "getVariableNames()Ljava/util/Set;");
            h.b.o = arr;
        }

        public b(kotlin.i0.z.e.m0.j.b.d0.h h, List list2, List list3, List list4) {
            Object obj5;
            n.f(h, "this$0");
            n.f(list2, "functionList");
            n.f(list3, "propertyList");
            n.f(list4, "typeAliasList");
            this.n = h;
            super();
            this.a = list2;
            this.b = list3;
            if (h.q().c().g().f()) {
            } else {
                obj5 = p.g();
            }
            this.c = obj5;
            h.b.d obj4 = new h.b.d(this);
            this.d = h.q().h().d(obj4);
            obj4 = new h.b.e(this);
            this.e = h.q().h().d(obj4);
            obj4 = new h.b.c(this);
            this.f = h.q().h().d(obj4);
            obj4 = new h.b.a(this);
            this.g = h.q().h().d(obj4);
            obj4 = new h.b.b(this);
            this.h = h.q().h().d(obj4);
            obj4 = new h.b.i(this);
            this.i = h.q().h().d(obj4);
            obj4 = new h.b.g(this);
            this.j = h.q().h().d(obj4);
            obj4 = new h.b.h(this);
            this.k = h.q().h().d(obj4);
            obj4 = new h.b.f(this, h);
            this.l = h.q().h().d(obj4);
            obj4 = new h.b.j(this, h);
            this.m = h.q().h().d(obj4);
        }

        private final List<t0> A() {
            return (List)m.a(this.g, this, h.b.o[3]);
        }

        private final List<o0> B() {
            return (List)m.a(this.h, this, h.b.o[4]);
        }

        private final List<y0> C() {
            return (List)m.a(this.f, this, h.b.o[2]);
        }

        private final List<t0> D() {
            return (List)m.a(this.d, this, h.b.o[0]);
        }

        private final List<o0> E() {
            return (List)m.a(this.e, this, h.b.o[1]);
        }

        private final Map<e, Collection<t0>> F() {
            return (Map)m.a(this.j, this, h.b.o[6]);
        }

        private final Map<e, Collection<o0>> G() {
            return (Map)m.a(this.k, this, h.b.o[7]);
        }

        private final Map<e, y0> H() {
            return (Map)m.a(this.i, this, h.b.o[5]);
        }

        public static final List h(kotlin.i0.z.e.m0.j.b.d0.h.b h$b) {
            return b.t();
        }

        public static final List i(kotlin.i0.z.e.m0.j.b.d0.h.b h$b) {
            return b.u();
        }

        public static final List j(kotlin.i0.z.e.m0.j.b.d0.h.b h$b) {
            return b.v();
        }

        public static final List k(kotlin.i0.z.e.m0.j.b.d0.h.b h$b) {
            return b.y();
        }

        public static final List l(kotlin.i0.z.e.m0.j.b.d0.h.b h$b) {
            return b.z();
        }

        public static final List m(kotlin.i0.z.e.m0.j.b.d0.h.b h$b) {
            return b.A();
        }

        public static final List n(kotlin.i0.z.e.m0.j.b.d0.h.b h$b) {
            return b.B();
        }

        public static final List o(kotlin.i0.z.e.m0.j.b.d0.h.b h$b) {
            return b.C();
        }

        public static final List p(kotlin.i0.z.e.m0.j.b.d0.h.b h$b) {
            return b.D();
        }

        public static final List q(kotlin.i0.z.e.m0.j.b.d0.h.b h$b) {
            return b.E();
        }

        public static final List r(kotlin.i0.z.e.m0.j.b.d0.h.b h$b) {
            return b.a;
        }

        public static final List s(kotlin.i0.z.e.m0.j.b.d0.h.b h$b) {
            return b.b;
        }

        private final List<t0> t() {
            List list;
            ArrayList arrayList = new ArrayList();
            Iterator iterator = this.n.u().iterator();
            for (e next2 : iterator) {
                p.y(arrayList, w(next2));
            }
            return arrayList;
        }

        private final List<o0> u() {
            List list;
            ArrayList arrayList = new ArrayList();
            Iterator iterator = this.n.v().iterator();
            for (e next2 : iterator) {
                p.y(arrayList, x(next2));
            }
            return arrayList;
        }

        private final List<t0> v() {
            t0 t0Var;
            boolean z;
            final kotlin.i0.z.e.m0.j.b.d0.h hVar = this.n;
            ArrayList arrayList = new ArrayList();
            Iterator iterator = this.a.iterator();
            while (iterator.hasNext()) {
                if (hVar.y(h.h(hVar).f().n((i)(o)iterator.next()))) {
                } else {
                }
                t0Var = 0;
                if (t0Var != null) {
                }
                arrayList.add(t0Var);
            }
            return arrayList;
        }

        private final List<t0> w(e e) {
            Object next;
            boolean z;
            ArrayList arrayList = new ArrayList();
            Iterator iterator = D().iterator();
            while (iterator.hasNext()) {
                next = iterator.next();
                if (n.b((m)next.getName(), e)) {
                }
                arrayList.add(next);
            }
            this.n.l(e, arrayList);
            return arrayList.subList(arrayList.size(), arrayList.size());
        }

        private final List<o0> x(e e) {
            Object next;
            boolean z;
            ArrayList arrayList = new ArrayList();
            Iterator iterator = E().iterator();
            while (iterator.hasNext()) {
                next = iterator.next();
                if (n.b((m)next.getName(), e)) {
                }
                arrayList.add(next);
            }
            this.n.m(e, arrayList);
            return arrayList.subList(arrayList.size(), arrayList.size());
        }

        private final List<o0> y() {
            o0 o0Var;
            u uVar;
            ArrayList arrayList = new ArrayList();
            Iterator iterator = this.b.iterator();
            while (iterator.hasNext()) {
                o0Var = h.h(this.n).f().p((n)(o)iterator.next());
                if (o0Var != null) {
                }
                arrayList.add(o0Var);
            }
            return arrayList;
        }

        private final List<y0> z() {
            y0 y0Var;
            u uVar;
            ArrayList arrayList = new ArrayList();
            Iterator iterator = this.c.iterator();
            while (iterator.hasNext()) {
                y0Var = h.h(this.n).f().q((r)(o)iterator.next());
                if (y0Var != null) {
                }
                arrayList.add(y0Var);
            }
            return arrayList;
        }

        public Collection<t0> a(e e, b b2) {
            Object obj2;
            n.f(e, "name");
            n.f(b2, "location");
            if (!b().contains(e)) {
                return p.g();
            }
            if ((Collection)F().get(e) != null) {
            } else {
                obj2 = p.g();
            }
            return obj2;
        }

        public Set<e> b() {
            return (Set)m.a(this.l, this, h.b.o[8]);
        }

        public Collection<o0> c(e e, b b2) {
            Object obj2;
            n.f(e, "name");
            n.f(b2, "location");
            if (!d().contains(e)) {
                return p.g();
            }
            if ((Collection)G().get(e) != null) {
            } else {
                obj2 = p.g();
            }
            return obj2;
        }

        public Set<e> d() {
            return (Set)m.a(this.m, this, h.b.o[9]);
        }

        public Set<e> e() {
            e eVar;
            kotlin.i0.z.e.m0.e.z.c cVar;
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            Iterator iterator = this.c.iterator();
            for (o next2 : iterator) {
                linkedHashSet.add(v.b(h.h(this.n).g(), (r)next2.Q()));
            }
            return linkedHashSet;
        }

        public void f(Collection<m> collection, d d2, l<? super e, Boolean> l3, b b4) {
            boolean booleanValue;
            boolean booleanValue2;
            boolean obj5;
            boolean obj7;
            n.f(collection, "result");
            n.f(d2, "kindFilter");
            n.f(l3, "nameFilter");
            n.f(b4, "location");
            String str5 = "it.name";
            if (d2.a(d.c.k())) {
                obj7 = B().iterator();
                while (obj7.hasNext()) {
                    booleanValue = obj7.next();
                    e name2 = (o0)booleanValue.getName();
                    n.e(name2, str5);
                    if ((Boolean)l3.invoke(name2).booleanValue()) {
                    }
                    collection.add(booleanValue);
                }
            }
            if (d2.a(d.c.e())) {
                obj5 = A().iterator();
                while (obj5.hasNext()) {
                    obj7 = obj5.next();
                    e name = (t0)obj7.getName();
                    n.e(name, str5);
                    if ((Boolean)l3.invoke(name).booleanValue()) {
                    }
                    collection.add(obj7);
                }
            }
        }

        @Override // kotlin.i0.z.e.m0.j.b.d0.h$a
        public y0 g(e e) {
            n.f(e, "name");
            return (y0)H().get(e);
        }
    }

    private final class c implements kotlin.i0.z.e.m0.j.b.d0.h.a {

        static final l<Object>[] j;
        private final Map<e, byte[]> a;
        private final Map<e, byte[]> b;
        private final Map<e, byte[]> c;
        private final g<e, Collection<t0>> d;
        private final g<e, Collection<o0>> e;
        private final h<e, y0> f;
        private final i g;
        private final i h;
        final kotlin.i0.z.e.m0.j.b.d0.h i;
        static {
            Class<kotlin.i0.z.e.m0.j.b.d0.h.c> obj = h.c.class;
            l[] arr = new l[2];
            x xVar = new x(c0.b(obj), "functionNames", "getFunctionNames()Ljava/util/Set;");
            x xVar2 = new x(c0.b(obj), "variableNames", "getVariableNames()Ljava/util/Set;");
            h.c.j = arr;
        }

        public c(kotlin.i0.z.e.m0.j.b.d0.h h, List list2, List list3, List list4) {
            LinkedHashMap linkedHashMap;
            boolean next;
            Object next2;
            boolean arrayList2;
            e arrayList3;
            Object arrayList;
            Map obj5;
            LinkedHashMap obj6;
            Iterator obj7;
            Object obj8;
            n.f(h, "this$0");
            n.f(list2, "functionList");
            n.f(list3, "propertyList");
            n.f(list4, "typeAliasList");
            this.i = h;
            super();
            linkedHashMap = new LinkedHashMap();
            obj6 = list2.iterator();
            while (obj6.hasNext()) {
                next2 = obj6.next();
                arrayList3 = v.b(h.h(h).g(), (i)(o)next2.P());
                if (linkedHashMap.get(arrayList3) == null) {
                }
                (List)arrayList.add(next2);
                arrayList = new ArrayList();
                linkedHashMap.put(arrayList3, arrayList);
            }
            this.a = p(linkedHashMap);
            obj6 = new LinkedHashMap();
            obj7 = list3.iterator();
            while (obj7.hasNext()) {
                linkedHashMap = obj7.next();
                arrayList2 = v.b(h.h(this.i).g(), (n)(o)linkedHashMap.O());
                if (obj6.get(arrayList2) == null) {
                }
                (List)arrayList3.add(linkedHashMap);
                arrayList3 = new ArrayList();
                obj6.put(arrayList2, arrayList3);
            }
            this.b = p(obj6);
            if (this.i.q().c().g().f()) {
                obj6 = new LinkedHashMap();
                obj7 = list4.iterator();
                while (obj7.hasNext()) {
                    obj8 = obj7.next();
                    next = v.b(h.h(this.i).g(), (r)(o)obj8.Q());
                    if (obj6.get(next) == null) {
                    }
                    (List)arrayList2.add(obj8);
                    arrayList2 = new ArrayList();
                    obj6.put(next, arrayList2);
                }
                obj5 = p(obj6);
            } else {
                obj5 = j0.h();
            }
            this.c = obj5;
            obj6 = new h.c.c(this);
            this.d = this.i.q().h().h(obj6);
            obj6 = new h.c.d(this);
            this.e = this.i.q().h().h(obj6);
            obj6 = new h.c.e(this);
            this.f = this.i.q().h().i(obj6);
            obj6 = new h.c.b(this, this.i);
            this.g = this.i.q().h().d(obj6);
            obj6 = new h.c.f(this, this.i);
            this.h = this.i.q().h().d(obj6);
        }

        public static final Collection h(kotlin.i0.z.e.m0.j.b.d0.h.c h$c, e e2) {
            return c.m(e2);
        }

        public static final Collection i(kotlin.i0.z.e.m0.j.b.d0.h.c h$c, e e2) {
            return c.n(e2);
        }

        public static final y0 j(kotlin.i0.z.e.m0.j.b.d0.h.c h$c, e e2) {
            return c.o(e2);
        }

        public static final Map k(kotlin.i0.z.e.m0.j.b.d0.h.c h$c) {
            return c.a;
        }

        public static final Map l(kotlin.i0.z.e.m0.j.b.d0.h.c h$c) {
            return c.b;
        }

        private final Collection<t0> m(e e) {
            List list;
            kotlin.i0.z.e.m0.j.b.d0.h hVar;
            int size;
            ByteArrayInputStream byteArrayInputStream;
            String str;
            kotlin.reflect.jvm.internal.impl.protobuf.q qVar = i.b;
            n.e(qVar, "PARSER");
            kotlin.i0.z.e.m0.j.b.d0.h hVar3 = this.i;
            Object obj = this.a.get(e);
            final int i = 0;
            if ((byte[])obj == null) {
                list = i;
            } else {
                byteArrayInputStream = new ByteArrayInputStream((byte[])obj);
                h.c.a aVar = new h.c.a(qVar, byteArrayInputStream, this.i);
                list = i.A(i.g(aVar));
            }
            if (list == null) {
                list = p.g();
            }
            ArrayList arrayList = new ArrayList(list.size());
            Iterator iterator = list.iterator();
            while (iterator.hasNext()) {
                Object next2 = iterator.next();
                n.e((i)next2, "it");
                if (hVar3.y(hVar3.q().f().n(next2)) != null) {
                } else {
                }
                size = i;
                if (size != 0) {
                }
                arrayList.add(size);
            }
            hVar3.l(e, arrayList);
            return a.c(arrayList);
        }

        private final Collection<o0> n(e e) {
            List list;
            kotlin.i0.z.e.m0.j.b.d0.h hVar;
            int size;
            ByteArrayInputStream byteArrayInputStream;
            String str;
            kotlin.reflect.jvm.internal.impl.protobuf.q qVar = n.b;
            n.e(qVar, "PARSER");
            kotlin.i0.z.e.m0.j.b.d0.h hVar3 = this.i;
            Object obj = this.b.get(e);
            if ((byte[])obj == null) {
                list = 0;
            } else {
                byteArrayInputStream = new ByteArrayInputStream((byte[])obj);
                h.c.a aVar = new h.c.a(qVar, byteArrayInputStream, this.i);
                list = i.A(i.g(aVar));
            }
            if (list == null) {
                list = p.g();
            }
            ArrayList arrayList = new ArrayList(list.size());
            Iterator iterator = list.iterator();
            while (iterator.hasNext()) {
                Object next2 = iterator.next();
                n.e((n)next2, "it");
                size = hVar3.q().f().p(next2);
                if (size != 0) {
                }
                arrayList.add(size);
            }
            hVar3.m(e, arrayList);
            return a.c(arrayList);
        }

        private final y0 o(e e) {
            Object obj3 = this.c.get(e);
            int i = 0;
            if ((byte[])obj3 == null) {
                return i;
            }
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream((byte[])obj3);
            obj3 = r.h0(byteArrayInputStream, this.i.q().c().j());
            if (obj3 == null) {
                return i;
            }
            return this.i.q().f().q(obj3);
        }

        private final Map<e, byte[]> p(Map<e, ? extends Collection<? extends a>> map) {
            int byteArray;
            Object key;
            ByteArrayOutputStream byteArrayOutputStream;
            ArrayList arrayList;
            boolean next;
            int i;
            LinkedHashMap linkedHashMap = new LinkedHashMap(j0.d(map.size()));
            Iterator obj7 = map.entrySet().iterator();
            for (Map.Entry next3 : obj7) {
                byteArrayOutputStream = new ByteArrayOutputStream();
                Object value = next3.getValue();
                arrayList = new ArrayList(p.r((Iterable)value, 10));
                Iterator iterator = value.iterator();
                for (a next4 : iterator) {
                    next4.c(byteArrayOutputStream);
                    arrayList.add(w.a);
                }
                linkedHashMap.put(next3.getKey(), byteArrayOutputStream.toByteArray());
                (a)iterator.next().c(byteArrayOutputStream);
                arrayList.add(w.a);
            }
            return linkedHashMap;
        }

        public Collection<t0> a(e e, b b2) {
            n.f(e, "name");
            n.f(b2, "location");
            if (!b().contains(e)) {
                return p.g();
            }
            return (Collection)this.d.invoke(e);
        }

        public Set<e> b() {
            return (Set)m.a(this.g, this, h.c.j[0]);
        }

        public Collection<o0> c(e e, b b2) {
            n.f(e, "name");
            n.f(b2, "location");
            if (!d().contains(e)) {
                return p.g();
            }
            return (Collection)this.e.invoke(e);
        }

        public Set<e> d() {
            return (Set)m.a(this.h, this, h.c.j[1]);
        }

        public Set<e> e() {
            return this.c.keySet();
        }

        public void f(Collection<m> collection, d d2, l<? super e, Boolean> l3, b b4) {
            boolean z;
            int arrayList;
            ArrayList arrayList2;
            boolean booleanValue2;
            boolean booleanValue;
            boolean obj7;
            n.f(collection, "result");
            n.f(d2, "kindFilter");
            n.f(l3, "nameFilter");
            n.f(b4, "location");
            final String str5 = "INSTANCE";
            if (d2.a(d.c.k())) {
                arrayList2 = new ArrayList();
                Iterator iterator = d().iterator();
                while (iterator.hasNext()) {
                    booleanValue2 = iterator.next();
                    if ((Boolean)l3.invoke((e)booleanValue2).booleanValue()) {
                    }
                    arrayList2.addAll(c(booleanValue2, b4));
                }
                z = g.a;
                n.e(z, str5);
                p.x(arrayList2, z);
                collection.addAll(arrayList2);
            }
            if (d2.a(d.c.e())) {
                arrayList = new ArrayList();
                obj7 = b().iterator();
                while (obj7.hasNext()) {
                    arrayList2 = obj7.next();
                    if ((Boolean)l3.invoke((e)arrayList2).booleanValue()) {
                    }
                    arrayList.addAll(a(arrayList2, b4));
                }
                obj7 = g.a;
                n.e(obj7, str5);
                p.x(arrayList, obj7);
                collection.addAll(arrayList);
            }
        }

        @Override // kotlin.i0.z.e.m0.j.b.d0.h$a
        public y0 g(e e) {
            n.f(e, "name");
            return (y0)this.f.invoke(e);
        }
    }

    static final class d extends p implements a<Set<? extends e>> {

        final a<Collection<e>> $classNames;
        d(a<? extends Collection<e>> a) {
            this.$classNames = a;
            super(0);
        }

        @Override // kotlin.d0.d.p
        public Object invoke() {
            return invoke();
        }

        public final Set<e> invoke() {
            return p.P0((Iterable)this.$classNames.invoke());
        }
    }

    static final class e extends p implements a<Set<? extends e>> {

        final kotlin.i0.z.e.m0.j.b.d0.h this$0;
        e(kotlin.i0.z.e.m0.j.b.d0.h h) {
            this.this$0 = h;
            super(0);
        }

        @Override // kotlin.d0.d.p
        public Object invoke() {
            return invoke();
        }

        public final Set<e> invoke() {
            Set set = this.this$0.t();
            if (set == null) {
                return 0;
            }
            return q0.i(q0.i(this.this$0.r(), h.i(this.this$0).e()), set);
        }
    }
    static {
        Class<kotlin.i0.z.e.m0.j.b.d0.h> obj = h.class;
        l[] arr = new l[2];
        x xVar = new x(c0.b(obj), "classNames", "getClassNames$deserialization()Ljava/util/Set;");
        x xVar2 = new x(c0.b(obj), "classifierNamesLazy", "getClassifierNamesLazy()Ljava/util/Set;");
        h.f = arr;
    }

    protected h(l l, List<i> list2, List<n> list3, List<r> list4, a<? extends Collection<e>> a5) {
        n.f(l, "c");
        n.f(list2, "functionList");
        n.f(list3, "propertyList");
        n.f(list4, "typeAliasList");
        n.f(a5, "classNames");
        super();
        this.b = l;
        this.c = o(list2, list3, list4);
        h.d obj4 = new h.d(a5);
        this.d = l.h().d(obj4);
        h.e obj3 = new h.e(this);
        this.e = l.h().f(obj3);
    }

    public static final l h(kotlin.i0.z.e.m0.j.b.d0.h h) {
        return h.b;
    }

    public static final kotlin.i0.z.e.m0.j.b.d0.h.a i(kotlin.i0.z.e.m0.j.b.d0.h h) {
        return h.c;
    }

    private final kotlin.i0.z.e.m0.j.b.d0.h.a o(List<i> list, List<n> list2, List<r> list3) {
        Object bVar;
        if (this.b.c().g().a()) {
            bVar = new h.b(this, list, list2, list3);
        } else {
            bVar = new h.c(this, list, list2, list3);
        }
        return bVar;
    }

    private final e p(e e) {
        return this.b.c().b(n(e));
    }

    private final Set<e> s() {
        return (Set)m.b(this.e, this, h.f[1]);
    }

    private final y0 w(e e) {
        return this.c.g(e);
    }

    public Collection<t0> a(e e, b b2) {
        n.f(e, "name");
        n.f(b2, "location");
        return this.c.a(e, b2);
    }

    public Set<e> b() {
        return this.c.b();
    }

    public Collection<o0> c(e e, b b2) {
        n.f(e, "name");
        n.f(b2, "location");
        return this.c.c(e, b2);
    }

    public Set<e> d() {
        return this.c.d();
    }

    public Set<e> e() {
        return s();
    }

    @Override // kotlin.i0.z.e.m0.i.v.i
    public h f(e e, b b2) {
        e obj2;
        boolean obj3;
        n.f(e, "name");
        n.f(b2, "location");
        if (x(e)) {
            obj2 = p(e);
        } else {
            if (this.c.e().contains(e)) {
                obj2 = w(e);
            } else {
                obj2 = 0;
            }
        }
        return obj2;
    }

    protected abstract void j(Collection<m> collection, l<? super e, Boolean> l2);

    protected final Collection<m> k(d d, l<? super e, Boolean> l2, b b3) {
        d.a booleanValue;
        kotlin.i0.z.e.m0.j.b.d0.h.a booleanValue2;
        boolean obj4;
        boolean obj6;
        n.f(d, "kindFilter");
        n.f(l2, "nameFilter");
        n.f(b3, "location");
        ArrayList arrayList = new ArrayList(0);
        booleanValue = d.c;
        if (d.a(booleanValue.h())) {
            j(arrayList, l2);
        }
        this.c.f(arrayList, d, l2, b3);
        if (d.a(booleanValue.d())) {
            obj6 = r().iterator();
            while (obj6.hasNext()) {
                booleanValue = obj6.next();
                if ((Boolean)l2.invoke((e)booleanValue).booleanValue() != null) {
                }
                a.a(arrayList, p(booleanValue));
            }
        }
        if (d.a(d.c.i())) {
            obj4 = this.c.e().iterator();
            while (obj4.hasNext()) {
                obj6 = obj4.next();
                if ((Boolean)l2.invoke((e)obj6).booleanValue() != null) {
                }
                a.a(arrayList, this.c.g(obj6));
            }
        }
        return a.c(arrayList);
    }

    protected void l(e e, List<t0> list2) {
        n.f(e, "name");
        n.f(list2, "functions");
    }

    protected void m(e e, List<o0> list2) {
        n.f(e, "name");
        n.f(list2, "descriptors");
    }

    @Override // kotlin.i0.z.e.m0.i.v.i
    protected abstract a n(e e);

    @Override // kotlin.i0.z.e.m0.i.v.i
    protected final l q() {
        return this.b;
    }

    public final Set<e> r() {
        return (Set)m.a(this.d, this, h.f[0]);
    }

    protected abstract Set<e> t();

    protected abstract Set<e> u();

    protected abstract Set<e> v();

    @Override // kotlin.i0.z.e.m0.i.v.i
    protected boolean x(e e) {
        n.f(e, "name");
        return r().contains(e);
    }

    @Override // kotlin.i0.z.e.m0.i.v.i
    protected boolean y(t0 t0) {
        n.f(t0, "function");
        return 1;
    }
}
