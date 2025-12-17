package kotlin.i0.z.e.m0.l.j1;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.d0.c.a;
import kotlin.d0.c.p;
import kotlin.d0.d.c0;
import kotlin.d0.d.g;
import kotlin.d0.d.j;
import kotlin.d0.d.n;
import kotlin.d0.d.p;
import kotlin.i0.f;
import kotlin.i0.z.e.m0.i.q.n;
import kotlin.i0.z.e.m0.i.q.n.a;
import kotlin.i0.z.e.m0.l.a0;
import kotlin.i0.z.e.m0.l.b0;
import kotlin.i0.z.e.m0.l.g1;
import kotlin.i0.z.e.m0.l.i0;
import kotlin.i0.z.e.m0.l.l0;
import kotlin.i0.z.e.m0.l.t0;
import kotlin.i0.z.e.m0.l.y;
import kotlin.y.p;

/* loaded from: classes3.dex */
public final class v {

    public static final kotlin.i0.z.e.m0.l.j1.v a;

    private static enum a {

        START,
        ACCEPT_NULL,
        UNKNOWN,
        NOT_NULL;
        @Override // java.lang.Enum
        public abstract kotlin.i0.z.e.m0.l.j1.v.a combine(g1 g1);

        @Override // java.lang.Enum
        protected final kotlin.i0.z.e.m0.l.j1.v.a getResultNullability(g1 g1) {
            boolean z;
            kotlin.i0.z.e.m0.l.j1.v.a obj2;
            n.f(g1, "<this>");
            obj2 = g1.M0() ? v.a.ACCEPT_NULL : obj2 != null ? v.a.NOT_NULL : v.a.UNKNOWN;
            return obj2;
        }
    }

    static final class b extends p implements a<String> {

        final Set<i0> $inputTypes;
        b(Set<? extends i0> set) {
            this.$inputTypes = set;
            super(0);
        }

        @Override // kotlin.d0.d.p
        public Object invoke() {
            return invoke();
        }

        @Override // kotlin.d0.d.p
        public final String invoke() {
            return n.o("This collections cannot be empty! input types: ", p.h0(this.$inputTypes, 0, 0, 0, 0, 0, 0, 63, 0));
        }
    }

    class c extends j implements p<b0, b0, Boolean> {
        c(kotlin.i0.z.e.m0.l.j1.v v) {
            super(2, v);
        }

        @Override // kotlin.d0.d.j
        public final String getName() {
            return "isStrictSupertype";
        }

        @Override // kotlin.d0.d.j
        public final f getOwner() {
            return c0.b(v.class);
        }

        @Override // kotlin.d0.d.j
        public final String getSignature() {
            return "isStrictSupertype(Lorg/jetbrains/kotlin/types/KotlinType;Lorg/jetbrains/kotlin/types/KotlinType;)Z";
        }

        @Override // kotlin.d0.d.j
        public Object invoke(Object object, Object object2) {
            return Boolean.valueOf(l((b0)object, (b0)object2));
        }

        @Override // kotlin.d0.d.j
        public final boolean l(b0 b0, b0 b02) {
            n.f(b0, "p0");
            n.f(b02, "p1");
            return v.a((v)this.receiver, b0, b02);
        }
    }

    class d extends j implements p<b0, b0, Boolean> {
        d(kotlin.i0.z.e.m0.l.j1.m m) {
            super(2, m);
        }

        @Override // kotlin.d0.d.j
        public final String getName() {
            return "equalTypes";
        }

        @Override // kotlin.d0.d.j
        public final f getOwner() {
            return c0.b(m.class);
        }

        @Override // kotlin.d0.d.j
        public final String getSignature() {
            return "equalTypes(Lorg/jetbrains/kotlin/types/KotlinType;Lorg/jetbrains/kotlin/types/KotlinType;)Z";
        }

        @Override // kotlin.d0.d.j
        public Object invoke(Object object, Object object2) {
            return Boolean.valueOf(l((b0)object, (b0)object2));
        }

        @Override // kotlin.d0.d.j
        public final boolean l(b0 b0, b0 b02) {
            n.f(b0, "p0");
            n.f(b02, "p1");
            return (m)this.receiver.b(b0, b02);
        }
    }
    static {
        v vVar = new v();
        v.a = vVar;
    }

    public static final boolean a(kotlin.i0.z.e.m0.l.j1.v v, b0 b02, b0 b03) {
        return v.e(b02, b03);
    }

    private final Collection<i0> b(Collection<? extends i0> collection, p<? super i0, ? super i0, Boolean> p2) {
        String next;
        boolean iterator;
        int i;
        int i2;
        int next2;
        Object booleanValue;
        String str;
        ArrayList arrayList = new ArrayList(collection);
        final Iterator obj8 = arrayList.iterator();
        n.e(obj8, "filteredTypes.iterator()");
        while (obj8.hasNext()) {
            next = obj8.next();
            i2 = 0;
            if (arrayList.isEmpty()) {
            } else {
            }
            iterator = arrayList.iterator();
            while (iterator.hasNext()) {
                booleanValue = iterator.next();
                n.e((i0)booleanValue, "lower");
                n.e((i0)next, "upper");
                if (booleanValue != next && (Boolean)p2.invoke(booleanValue, next).booleanValue()) {
                } else {
                }
                next2 = i2;
                if (next2 == 0) {
                    break loop_5;
                }
                n.e(booleanValue, "lower");
                n.e(next, "upper");
                if ((Boolean)p2.invoke(booleanValue, next).booleanValue()) {
                } else {
                }
                next2 = i;
            }
            i = i2;
            if (i != 0) {
            }
            obj8.remove();
            booleanValue = iterator.next();
            n.e((i0)booleanValue, "lower");
            n.e(next, "upper");
            if (booleanValue != next && (Boolean)p2.invoke(booleanValue, next).booleanValue()) {
            } else {
            }
            next2 = i2;
            if (next2 == 0) {
            }
            n.e(booleanValue, "lower");
            n.e(next, "upper");
            if ((Boolean)p2.invoke(booleanValue, next).booleanValue()) {
            } else {
            }
            next2 = i;
        }
        return arrayList;
    }

    private final i0 d(Set<? extends i0> set) {
        if (set.size() == 1) {
            return (i0)p.y0(set);
        }
        v.b bVar = new v.b(set);
        v.c cVar = new v.c(this);
        Collection collection = b(set, cVar);
        collection.isEmpty();
        i0 i0Var = n.f.b(collection);
        v.d dVar = new v.d(l.b.a());
        Collection collection2 = b(collection, dVar);
        collection2.isEmpty();
        if (i0Var == null && collection2.size() < 2) {
            dVar = new v.d(l.b.a());
            collection2 = b(collection, dVar);
            collection2.isEmpty();
            if (collection2.size() < 2) {
                return (i0)p.y0(collection2);
            }
            a0 a0Var = new a0(set);
            return a0Var.g();
        }
        return i0Var;
    }

    private final boolean e(b0 b0, b0 b02) {
        b0 obj3;
        kotlin.i0.z.e.m0.l.j1.m mVar = l.b.a();
        if (mVar.d(b0, b02) && !mVar.d(b02, b0)) {
            obj3 = !mVar.d(b02, b0) ? 1 : 0;
        } else {
        }
        return obj3;
    }

    public final i0 c(List<? extends i0> list) {
        Object next;
        Iterator iterator;
        boolean next3;
        ArrayList arrayList;
        boolean next2;
        int i;
        boolean z;
        kotlin.i0.z.e.m0.l.j1.v.a obj8;
        n.f(list, "types");
        int size = list.size();
        final int i2 = 1;
        ArrayList arrayList2 = new ArrayList();
        obj8 = list.iterator();
        while (obj8.hasNext()) {
            next = obj8.next();
            if (t0Var instanceof a0) {
            } else {
            }
            arrayList2.add(next);
            Collection collection = next.L0().a();
            n.e(collection, "type.constructor.supertypes");
            arrayList = new ArrayList(p.r(collection, 10));
            iterator = collection.iterator();
            while (iterator.hasNext()) {
                Object next6 = iterator.next();
                n.e((b0)next6, "it");
                if (next.M0()) {
                }
                arrayList.add(i);
                i = y.d(next6).S0(i2);
            }
            arrayList2.addAll(arrayList);
            next6 = iterator.next();
            n.e((b0)next6, "it");
            if (next.M0()) {
            }
            arrayList.add(i);
            i = y.d(next6).S0(i2);
        }
        obj8 = v.a.START;
        Iterator iterator3 = arrayList2.iterator();
        for (g1 iterator : iterator3) {
            obj8 = obj8.combine(iterator);
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        Iterator iterator2 = arrayList2.iterator();
        while (iterator2.hasNext()) {
            next3 = iterator2.next();
            if (obj8 == v.a.NOT_NULL && next3 instanceof i) {
            }
            linkedHashSet.add(next3);
            if (next3 instanceof i) {
            }
            next3 = l0.i(next3, false, i2, 0);
            next3 = l0.k((i)(i0)next3);
        }
        return d(linkedHashSet);
    }
}
