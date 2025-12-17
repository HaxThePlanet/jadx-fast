package kotlin.i0.z.e.m0.d.a.g0.l;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import kotlin.d0.c.a;
import kotlin.d0.d.c0;
import kotlin.d0.d.n;
import kotlin.d0.d.p;
import kotlin.d0.d.x;
import kotlin.i0.l;
import kotlin.i0.z.e.m0.d.a.g0.a;
import kotlin.i0.z.e.m0.d.a.g0.b;
import kotlin.i0.z.e.m0.d.a.g0.e;
import kotlin.i0.z.e.m0.d.a.g0.g;
import kotlin.i0.z.e.m0.d.a.i0.g;
import kotlin.i0.z.e.m0.d.a.i0.u;
import kotlin.i0.z.e.m0.d.b.a0.a;
import kotlin.i0.z.e.m0.d.b.n;
import kotlin.i0.z.e.m0.d.b.o;
import kotlin.i0.z.e.m0.d.b.p;
import kotlin.i0.z.e.m0.d.b.u;
import kotlin.i0.z.e.m0.f.a;
import kotlin.i0.z.e.m0.f.b;
import kotlin.i0.z.e.m0.i.t.c;
import kotlin.i0.z.e.m0.i.v.h;
import kotlin.i0.z.e.m0.k.i;
import kotlin.i0.z.e.m0.k.m;
import kotlin.i0.z.e.m0.k.n;
import kotlin.reflect.jvm.internal.impl.descriptors.e;
import kotlin.reflect.jvm.internal.impl.descriptors.h1.g;
import kotlin.reflect.jvm.internal.impl.descriptors.h1.g.a;
import kotlin.reflect.jvm.internal.impl.descriptors.j1.z;
import kotlin.reflect.jvm.internal.impl.descriptors.u0;
import kotlin.reflect.jvm.internal.impl.utils.e;
import kotlin.u;
import kotlin.y.j0;
import kotlin.y.p;

/* loaded from: classes3.dex */
public final class h extends z {

    static final l<Object>[] D;
    private final kotlin.i0.z.e.m0.d.a.g0.l.d A;
    private final i<List<b>> B;
    private final g C;
    private final u x;
    private final g y;
    private final i z;

    static final class a extends p implements a<Map<String, ? extends o>> {

        final kotlin.i0.z.e.m0.d.a.g0.l.h this$0;
        a(kotlin.i0.z.e.m0.d.a.g0.l.h h) {
            this.this$0 = h;
            super(0);
        }

        public final Map<String, o> a() {
            int i;
            o oVar;
            kotlin.i0.z.e.m0.d.b.m mVar;
            String str = this.this$0.d().b();
            n.e(str, "fqName.asString()");
            ArrayList arrayList = new ArrayList();
            Iterator iterator = h.C0(this.this$0).a().n().a(str).iterator();
            while (iterator.hasNext()) {
                Object next2 = iterator.next();
                a aVar = a.m(c.d((String)next2).e());
                n.e(aVar, "topLevel(JvmClassName.byInternalName(partName).fqNameForTopLevelClassMaybeWithDollars)");
                oVar = n.b(h.C0(this.this$0).a().i(), aVar);
                if (oVar == null) {
                } else {
                }
                i = u.a(next2, oVar);
                if (i != 0) {
                }
                arrayList.add(i);
                i = 0;
            }
            return j0.s(arrayList);
        }

        @Override // kotlin.d0.d.p
        public Object invoke() {
            return a();
        }
    }

    static final class b extends p implements a<HashMap<c, c>> {

        final kotlin.i0.z.e.m0.d.a.g0.l.h this$0;
        b(kotlin.i0.z.e.m0.d.a.g0.l.h h) {
            this.this$0 = h;
            super(0);
        }

        public final HashMap<c, c> a() {
            int i2;
            c cVar;
            int str;
            int i;
            HashMap hashMap = new HashMap();
            Iterator iterator = this.this$0.L0().entrySet().iterator();
            while (iterator.hasNext()) {
                Object next2 = iterator.next();
                cVar = c.d((String)(Map.Entry)next2.getKey());
                n.e(cVar, "byInternalName(partInternalName)");
                a aVar = (o)next2.getValue().a();
                str = h.b.a.a[aVar.c().ordinal()];
                if (str != 1) {
                } else {
                }
                i2 = aVar.e();
                if (i2 == null) {
                } else {
                }
                i2 = c.d(i2);
                n.e(i2, "byInternalName(header.multifileClassName ?: continue@kotlinClasses)");
                hashMap.put(cVar, i2);
                if (str != 2) {
                } else {
                }
                hashMap.put(cVar, cVar);
            }
            return hashMap;
        }

        @Override // kotlin.d0.d.p
        public Object invoke() {
            return a();
        }
    }

    static final class c extends p implements a<List<? extends b>> {

        final kotlin.i0.z.e.m0.d.a.g0.l.h this$0;
        c(kotlin.i0.z.e.m0.d.a.g0.l.h h) {
            this.this$0 = h;
            super(0);
        }

        @Override // kotlin.d0.d.p
        public Object invoke() {
            return invoke();
        }

        public final List<b> invoke() {
            int i;
            Collection collection = h.J0(this.this$0).A();
            ArrayList arrayList = new ArrayList(p.r(collection, 10));
            Iterator iterator = collection.iterator();
            for (u next2 : iterator) {
                arrayList.add(next2.d());
            }
            return arrayList;
        }
    }
    static {
        Class<kotlin.i0.z.e.m0.d.a.g0.l.h> obj = h.class;
        l[] arr = new l[2];
        x xVar = new x(c0.b(obj), "binaryClasses", "getBinaryClasses$descriptors_jvm()Ljava/util/Map;");
        x xVar2 = new x(c0.b(obj), "partToFacade", "getPartToFacade()Ljava/util/HashMap;");
        h.D = arr;
    }

    public h(g g, u u2) {
        g obj10;
        n.f(g, "outerContext");
        n.f(u2, "jPackage");
        super(g.d(), u2.d());
        this.x = u2;
        g obj9 = a.d(g, this, 0, 0, 6, 0);
        this.y = obj9;
        h.a aVar = new h.a(this);
        this.z = obj9.e().d(aVar);
        d dVar = new d(obj9, u2, this);
        this.A = dVar;
        h.c cVar = new h.c(this);
        this.B = obj9.e().c(cVar, p.g());
        if (obj9.a().h().a()) {
            obj10 = g.q.b();
        } else {
            obj10 = e.a(obj9, u2);
        }
        this.C = obj10;
        obj10 = new h.b(this);
        obj9.e().d(obj10);
    }

    public static final g C0(kotlin.i0.z.e.m0.d.a.g0.l.h h) {
        return h.y;
    }

    public static final u J0(kotlin.i0.z.e.m0.d.a.g0.l.h h) {
        return h.x;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.z
    public final e K0(g g) {
        n.f(g, "jClass");
        return this.A.j().O(g);
    }

    public final Map<String, o> L0() {
        return (Map)m.a(this.z, this, h.D[0]);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.z
    public kotlin.i0.z.e.m0.d.a.g0.l.d M0() {
        return this.A;
    }

    public final List<b> N0() {
        return (List)this.B.invoke();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.z
    public g getAnnotations() {
        return this.C;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.z
    public u0 getSource() {
        p pVar = new p(this);
        return pVar;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.z
    public h o() {
        return M0();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.z
    public String toString() {
        return n.o("Lazy Java package fragment: ", d());
    }
}
