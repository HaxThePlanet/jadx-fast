package kotlin.i0.z.e.m0.i.v;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
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
import kotlin.i0.z.e.m0.f.e;
import kotlin.i0.z.e.m0.i.h;
import kotlin.i0.z.e.m0.i.j;
import kotlin.i0.z.e.m0.k.i;
import kotlin.i0.z.e.m0.k.m;
import kotlin.i0.z.e.m0.k.n;
import kotlin.i0.z.e.m0.l.b0;
import kotlin.i0.z.e.m0.l.t0;
import kotlin.reflect.jvm.internal.impl.descriptors.b;
import kotlin.reflect.jvm.internal.impl.descriptors.d0;
import kotlin.reflect.jvm.internal.impl.descriptors.e;
import kotlin.reflect.jvm.internal.impl.descriptors.h;
import kotlin.reflect.jvm.internal.impl.descriptors.m;
import kotlin.reflect.jvm.internal.impl.descriptors.o0;
import kotlin.reflect.jvm.internal.impl.descriptors.t0;
import kotlin.reflect.jvm.internal.impl.descriptors.x;
import kotlin.reflect.jvm.internal.impl.utils.a;
import kotlin.reflect.jvm.internal.impl.utils.i;
import kotlin.y.p;

/* loaded from: classes3.dex */
public abstract class e extends kotlin.i0.z.e.m0.i.v.i {

    static final l<Object>[] d;
    private final e b;
    private final i c;

    public static final class b extends h {

        final ArrayList<m> a;
        final kotlin.i0.z.e.m0.i.v.e b;
        b(ArrayList<m> arrayList, kotlin.i0.z.e.m0.i.v.e e2) {
            this.a = arrayList;
            this.b = e2;
            super();
        }

        @Override // kotlin.i0.z.e.m0.i.h
        public void a(b b) {
            n.f(b, "fakeOverride");
            j.N(b, 0);
            this.a.add(b);
        }

        @Override // kotlin.i0.z.e.m0.i.h
        protected void e(b b, b b2) {
            n.f(b, "fromSuper");
            n.f(b2, "fromCurrent");
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Conflict in scope of ");
            stringBuilder.append(this.b.l());
            stringBuilder.append(": ");
            stringBuilder.append(b);
            stringBuilder.append(" vs ");
            stringBuilder.append(b2);
            IllegalStateException obj4 = new IllegalStateException(stringBuilder.toString().toString());
            throw obj4;
        }
    }

    static final class a extends p implements a<List<? extends m>> {

        final kotlin.i0.z.e.m0.i.v.e this$0;
        a(kotlin.i0.z.e.m0.i.v.e e) {
            this.this$0 = e;
            super(0);
        }

        @Override // kotlin.d0.d.p
        public Object invoke() {
            return invoke();
        }

        public final List<m> invoke() {
            List list = this.this$0.i();
            return p.t0(list, e.h(this.this$0, list));
        }
    }
    static {
        l[] arr = new l[1];
        x xVar = new x(c0.b(e.class), "allDescriptors", "getAllDescriptors()Ljava/util/List;");
        e.d = arr;
    }

    public e(n n, e e2) {
        n.f(n, "storageManager");
        n.f(e2, "containingClass");
        super();
        this.b = e2;
        e.a obj3 = new e.a(this);
        this.c = n.d(obj3);
    }

    public static final List h(kotlin.i0.z.e.m0.i.v.e e, List list2) {
        return e.j(list2);
    }

    private final List<m> j(List<? extends x> list) {
        LinkedHashMap linkedHashMap2;
        ArrayList arrayList4;
        boolean next2;
        boolean next3;
        Collection collection;
        boolean next4;
        LinkedHashMap linkedHashMap;
        int arrayList2;
        Object arrayList3;
        Boolean valueOf;
        Iterator arrayList;
        boolean next;
        kotlin.i0.z.e.m0.i.v.e.b bVar;
        int i = 3;
        ArrayList arrayList5 = new ArrayList(i);
        Collection collection2 = this.b.g().a();
        n.e(collection2, "containingClass.typeConstructor.supertypes");
        arrayList4 = new ArrayList();
        Iterator iterator3 = collection2.iterator();
        for (b0 next8 : iterator3) {
            arrayList2 = 0;
            p.y(arrayList4, k.a.a(next8.o(), arrayList2, arrayList2, i, arrayList2));
        }
        ArrayList arrayList6 = new ArrayList();
        Iterator iterator4 = arrayList4.iterator();
        while (iterator4.hasNext()) {
            arrayList4 = iterator4.next();
            if (arrayList4 instanceof b) {
            }
            arrayList6.add(arrayList4);
        }
        linkedHashMap2 = new LinkedHashMap();
        Iterator iterator = arrayList6.iterator();
        while (iterator.hasNext()) {
            next2 = iterator.next();
            next4 = (b)next2.getName();
            if (linkedHashMap2.get(next4) == null) {
            }
            (List)arrayList2.add(next2);
            arrayList2 = new ArrayList();
            linkedHashMap2.put(next4, arrayList2);
        }
        Iterator iterator2 = linkedHashMap2.entrySet().iterator();
        for (Map.Entry next6 : iterator2) {
            next3 = next6.getKey();
            linkedHashMap = new LinkedHashMap();
            Iterator iterator5 = (List)next6.getValue().iterator();
            while (iterator5.hasNext()) {
                arrayList2 = iterator5.next();
                valueOf = Boolean.valueOf(obj instanceof x);
                if (linkedHashMap.get(valueOf) == null) {
                }
                (List)arrayList.add(arrayList2);
                arrayList = new ArrayList();
                linkedHashMap.put(valueOf, arrayList);
            }
            linkedHashMap2 = linkedHashMap.entrySet().iterator();
            while (linkedHashMap2.hasNext()) {
                Object next7 = linkedHashMap2.next();
                if ((Boolean)(Map.Entry)next7.getKey().booleanValue()) {
                } else {
                }
                arrayList3 = p.g();
                bVar = new e.b(arrayList5, this);
                j.d.y((e)next3, (List)next7.getValue(), arrayList3, this.b, bVar);
                arrayList3 = new ArrayList();
                arrayList = list.iterator();
                while (arrayList.hasNext()) {
                    next = arrayList.next();
                    if (n.b((x)next.getName(), next3)) {
                    }
                    arrayList3.add(next);
                }
                next = arrayList.next();
                if (n.b((x)next.getName(), next3)) {
                }
                arrayList3.add(next);
            }
            next7 = linkedHashMap2.next();
            if ((Boolean)(Map.Entry)next7.getKey().booleanValue()) {
            } else {
            }
            arrayList3 = p.g();
            bVar = new e.b(arrayList5, this);
            j.d.y(next3, (List)next7.getValue(), arrayList3, this.b, bVar);
            arrayList3 = new ArrayList();
            arrayList = list.iterator();
            while (arrayList.hasNext()) {
                next = arrayList.next();
                if (n.b((x)next.getName(), next3)) {
                }
                arrayList3.add(next);
            }
            next = arrayList.next();
            if (n.b((x)next.getName(), next3)) {
            }
            arrayList3.add(next);
            arrayList2 = iterator5.next();
            valueOf = Boolean.valueOf(obj instanceof x);
            if (linkedHashMap.get(valueOf) == null) {
            }
            (List)arrayList.add(arrayList2);
            arrayList = new ArrayList();
            linkedHashMap.put(valueOf, arrayList);
        }
        return a.c(arrayList5);
    }

    private final List<m> k() {
        return (List)m.a(this.c, this, e.d[0]);
    }

    public Collection<t0> a(e e, b b2) {
        Object next;
        boolean z;
        n.f(e, "name");
        n.f(b2, "location");
        i iVar = new i();
        Iterator obj5 = k().iterator();
        while (obj5.hasNext()) {
            next = obj5.next();
            if (next instanceof t0 && n.b((t0)next.getName(), e)) {
            }
            if (n.b((t0)next.getName(), e)) {
            }
            iVar.add(next);
        }
        return iVar;
    }

    public Collection<o0> c(e e, b b2) {
        Object next;
        boolean z;
        n.f(e, "name");
        n.f(b2, "location");
        i iVar = new i();
        Iterator obj5 = k().iterator();
        while (obj5.hasNext()) {
            next = obj5.next();
            if (next instanceof o0 && n.b((o0)next.getName(), e)) {
            }
            if (n.b((o0)next.getName(), e)) {
            }
            iVar.add(next);
        }
        return iVar;
    }

    public Collection<m> g(kotlin.i0.z.e.m0.i.v.d d, l<? super e, Boolean> l2) {
        n.f(d, "kindFilter");
        n.f(l2, "nameFilter");
        if (!d.a(d.p.o())) {
            return p.g();
        }
        return k();
    }

    protected abstract List<x> i();

    @Override // kotlin.i0.z.e.m0.i.v.i
    protected final e l() {
        return this.b;
    }
}
