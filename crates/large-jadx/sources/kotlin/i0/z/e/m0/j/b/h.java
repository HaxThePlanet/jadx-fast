package kotlin.i0.z.e.m0.j.b;

import java.util.Iterator;
import java.util.Set;
import kotlin.d0.c.l;
import kotlin.d0.d.g;
import kotlin.d0.d.n;
import kotlin.d0.d.p;
import kotlin.i0.z.e.m0.b.k.a;
import kotlin.i0.z.e.m0.e.c;
import kotlin.i0.z.e.m0.e.z.g;
import kotlin.i0.z.e.m0.e.z.i;
import kotlin.i0.z.e.m0.e.z.i.a;
import kotlin.i0.z.e.m0.f.a;
import kotlin.i0.z.e.m0.f.c;
import kotlin.i0.z.e.m0.j.b.d0.d;
import kotlin.i0.z.e.m0.k.n;
import kotlin.reflect.jvm.internal.impl.descriptors.e;
import kotlin.reflect.jvm.internal.impl.descriptors.i0;
import kotlin.reflect.jvm.internal.impl.descriptors.i1.b;
import kotlin.y.q0;

/* loaded from: classes3.dex */
public final class h {

    public static final kotlin.i0.z.e.m0.j.b.h.b c;
    private static final Set<a> d;
    private final kotlin.i0.z.e.m0.j.b.j a;
    private final l<kotlin.i0.z.e.m0.j.b.h.a, e> b;

    private static final class a {

        private final a a;
        private final kotlin.i0.z.e.m0.j.b.f b;
        public a(a a, kotlin.i0.z.e.m0.j.b.f f2) {
            n.f(a, "classId");
            super();
            this.a = a;
            this.b = f2;
        }

        public final kotlin.i0.z.e.m0.j.b.f a() {
            return this.b;
        }

        public final a b() {
            return this.a;
        }

        public boolean equals(Object object) {
            boolean z;
            Object obj2;
            if (object instanceof h.a && n.b(this.a, object.a)) {
                obj2 = n.b(this.a, object.a) ? 1 : 0;
            } else {
            }
            return obj2;
        }

        public int hashCode() {
            return this.a.hashCode();
        }
    }

    public static final class b {
        public b(g g) {
            super();
        }

        public final Set<a> a() {
            return h.b();
        }
    }

    static final class c extends p implements l<kotlin.i0.z.e.m0.j.b.h.a, e> {

        final kotlin.i0.z.e.m0.j.b.h this$0;
        c(kotlin.i0.z.e.m0.j.b.h h) {
            this.this$0 = h;
            super(1);
        }

        @Override // kotlin.d0.d.p
        public final e a(kotlin.i0.z.e.m0.j.b.h.a h$a) {
            n.f(a, "key");
            return h.a(this.this$0, a);
        }

        @Override // kotlin.d0.d.p
        public Object invoke(Object object) {
            return a((h.a)object);
        }
    }
    static {
        h.b bVar = new h.b(0);
        h.c = bVar;
        h.d = q0.a(a.m(k.a.d.l()));
    }

    public h(kotlin.i0.z.e.m0.j.b.j j) {
        n.f(j, "components");
        super();
        this.a = j;
        h.c cVar = new h.c(this);
        this.b = j.u().i(cVar);
    }

    public static final e a(kotlin.i0.z.e.m0.j.b.h h, kotlin.i0.z.e.m0.j.b.h.a h$a2) {
        return h.c(a2);
    }

    public static final Set b() {
        return h.d;
    }

    private final e c(kotlin.i0.z.e.m0.j.b.h.a h$a) {
        kotlin.i0.z.e.m0.j.b.l lVar;
        e eVar2;
        int i;
        e eVar;
        String str;
        boolean z;
        kotlin.i0.z.e.m0.f.b next;
        g gVar;
        String str2;
        kotlin.i0.z.e.m0.f.b bVar;
        i iVar;
        kotlin.i0.z.e.m0.e.z.a aVar;
        int i2;
        kotlin.i0.z.e.m0.j.b.f obj13;
        a aVar2 = a.b();
        Iterator iterator = this.a.k().iterator();
        for (b next3 : iterator) {
            eVar2 = next3.c(aVar2);
        }
        i = 0;
        if (h.c.a().contains(aVar2)) {
            return i;
        }
        if (a.a() == null && this.a.e().a(aVar2) == null) {
            if (this.a.e().a(aVar2) == null) {
                return i;
            }
        }
        kotlin.i0.z.e.m0.e.z.c cVar = obj13.a();
        final c cVar4 = obj13.b();
        final kotlin.i0.z.e.m0.e.z.a aVar6 = obj13.c();
        a aVar4 = aVar2.g();
        str = "classId.shortClassName";
        if (aVar4 != null) {
            if (eVar instanceof d) {
            } else {
                eVar = i;
            }
            if (eVar == null) {
                return i;
            }
            kotlin.i0.z.e.m0.f.e eVar3 = aVar2.j();
            n.e(eVar3, str);
            if (!eVar.b1(eVar3)) {
                return i;
            }
            lVar = eVar.V0();
        } else {
            next = aVar2.h();
            n.e(next, "classId.packageFqName");
            Iterator iterator2 = i0.b(this.a.r(), next).iterator();
            while (iterator2.hasNext()) {
                bVar = next;
                if (bVar instanceof n) {
                } else {
                }
                str2 = 1;
                iVar = aVar2.j();
                n.e(iVar, str);
                if ((n)(f0)bVar.J0(iVar)) {
                } else {
                }
                str2 = 0;
            }
            next = i;
            str = next;
            if ((f0)str == 0) {
                return i;
            }
            kotlin.i0.z.e.m0.e.t tVar = cVar4.B0();
            n.e(tVar, "classProto.typeTable");
            gVar = new g(tVar);
            i = cVar4.D0();
            n.e(i, "classProto.versionRequirementTable");
            lVar = this.a.a((f0)str, cVar, gVar, i.b.a(i), aVar6, 0);
        }
        super(lVar, cVar4, cVar, aVar6, obj13.d());
        return dVar;
    }

    public static e e(kotlin.i0.z.e.m0.j.b.h h, a a2, kotlin.i0.z.e.m0.j.b.f f3, int i4, Object object5) {
        int obj2;
        if (i4 &= 2 != 0) {
            obj2 = 0;
        }
        return h.d(a2, obj2);
    }

    public final e d(a a, kotlin.i0.z.e.m0.j.b.f f2) {
        n.f(a, "classId");
        h.a aVar = new h.a(a, f2);
        return (e)this.b.invoke(aVar);
    }
}
