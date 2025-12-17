package kotlin.i0.z.e.m0.d.b;

import java.util.Collection;
import java.util.Set;
import kotlin.d0.c.a;
import kotlin.d0.d.g;
import kotlin.d0.d.n;
import kotlin.d0.d.p;
import kotlin.i0.z.e.m0.d.b.a0.a;
import kotlin.i0.z.e.m0.d.b.a0.a.a;
import kotlin.i0.z.e.m0.e.a0.b.f;
import kotlin.i0.z.e.m0.e.a0.b.h;
import kotlin.i0.z.e.m0.f.e;
import kotlin.i0.z.e.m0.i.v.h;
import kotlin.i0.z.e.m0.j.b.d0.e;
import kotlin.i0.z.e.m0.j.b.d0.i;
import kotlin.i0.z.e.m0.j.b.f;
import kotlin.i0.z.e.m0.j.b.h;
import kotlin.i0.z.e.m0.j.b.j;
import kotlin.i0.z.e.m0.j.b.k;
import kotlin.i0.z.e.m0.j.b.r;
import kotlin.o;
import kotlin.reflect.jvm.internal.impl.descriptors.e;
import kotlin.reflect.jvm.internal.impl.descriptors.f0;
import kotlin.y.p;
import kotlin.y.q0;

/* loaded from: classes3.dex */
public final class e {

    public static final kotlin.i0.z.e.m0.d.b.e.a b;
    private static final Set<a.a> c;
    private static final Set<a.a> d;
    private static final f e;
    private static final f f;
    private static final f g;
    public j a;

    public static final class a {
        public a(g g) {
            super();
        }

        public final f a() {
            return e.a();
        }

        public final Set<a.a> b() {
            return e.b();
        }
    }

    static final class b extends p implements a<Collection<? extends e>> {

        public static final kotlin.i0.z.e.m0.d.b.e.b a;
        static {
            e.b bVar = new e.b();
            e.b.a = bVar;
        }

        b() {
            super(0);
        }

        public final Collection<e> a() {
            return p.g();
        }

        @Override // kotlin.d0.d.p
        public Object invoke() {
            return a();
        }
    }
    static {
        e.a aVar = new e.a(0);
        e.b = aVar;
        e.c = q0.a(a.a.CLASS);
        a.a[] arr = new a.a[2];
        e.d = q0.g(a.a.FILE_FACADE, a.a.MULTIFILE_CLASS_PART);
        int i3 = 3;
        int[] iArr2 = new int[i3];
        iArr2 = new int[]{1, 1, 2};
        f fVar = new f(iArr2);
        e.e = fVar;
        int[] iArr3 = new int[i3];
        iArr3 = new int[]{1, 1, 11};
        f fVar2 = new f(iArr3);
        e.f = fVar2;
        int[] iArr = new int[i3];
        iArr = new int[]{1, 1, 13};
        f fVar3 = new f(iArr);
        e.g = fVar3;
    }

    public static final f a() {
        return e.g;
    }

    public static final Set b() {
        return e.c;
    }

    public static final boolean c(kotlin.i0.z.e.m0.d.b.e e) {
        return e.h();
    }

    private final e e(kotlin.i0.z.e.m0.d.b.o o) {
        boolean z;
        e obj2;
        obj2 = f().g().b() ? e.STABLE : z ? e.FIR_UNSTABLE : obj2 != null ? e.IR_UNSTABLE : e.STABLE;
        return obj2;
    }

    private final r<f> g(kotlin.i0.z.e.m0.d.b.o o) {
        boolean z;
        if (!h() && o.a().d().h()) {
            if (o.a().d().h()) {
            }
            r rVar = new r(o.a().d(), f.g, o.getLocation(), o.e());
            return rVar;
        }
        return 0;
    }

    private final boolean h() {
        return f().g().d();
    }

    private final boolean i(kotlin.i0.z.e.m0.d.b.o o) {
        f z;
        int obj2;
        if (!f().g().c() && o.a().i() && n.b(o.a().d(), e.f)) {
            if (o.a().i()) {
                obj2 = n.b(o.a().d(), e.f) ? 1 : 0;
            } else {
            }
        } else {
        }
        return obj2;
    }

    private final boolean j(kotlin.i0.z.e.m0.d.b.o o) {
        boolean z;
        f fVar;
        int obj3;
        if (f().g().e()) {
            if (!o.a().i() && !n.b(o.a().d(), e.e)) {
                if (!n.b(o.a().d(), e.e)) {
                    obj3 = i(o) ? 1 : 0;
                } else {
                }
            } else {
            }
        } else {
        }
        return obj3;
    }

    private final String[] l(kotlin.i0.z.e.m0.d.b.o o, Set<? extends a.a> set2) {
        String[] strArr;
        a obj3;
        obj3 = o.a();
        if (obj3.a() == null) {
            strArr = obj3.b();
        }
        if (strArr == null) {
            strArr = i;
        } else {
        }
        return strArr;
    }

    public final h d(f0 f0, kotlin.i0.z.e.m0.d.b.o o2) {
        o oVar;
        java.lang.IllegalStateException exc;
        n.f(f0, "descriptor");
        n.f(o2, "kotlinClass");
        String[] strArr = l(o2, e.d);
        int i = 0;
        if (strArr == null) {
            return i;
        }
        String[] strArr2 = o2.a().g();
        if (strArr2 == null) {
            return i;
        }
        h hVar = h.a;
        oVar = h.m(strArr, strArr2);
        if (oVar == null) {
            return i;
        }
        final Object obj5 = obj;
        final Object obj6 = obj2;
        super(o2, obj5, obj6, g(o2), j(o2), e(o2));
        super(f0, obj5, obj6, o2.a().d(), iVar4, f(), e.b.a);
        return iVar5;
    }

    public final j f() {
        j jVar = this.a;
        if (jVar == null) {
        } else {
            return jVar;
        }
        n.w("components");
        throw 0;
    }

    public final f k(kotlin.i0.z.e.m0.d.b.o o) {
        o oVar;
        java.lang.IllegalStateException exc;
        n.f(o, "kotlinClass");
        String[] strArr = l(o, e.b.b());
        int i = 0;
        if (strArr == null) {
            return i;
        }
        String[] strArr2 = o.a().g();
        if (strArr2 == null) {
            return i;
        }
        h hVar = h.a;
        oVar = h.i(strArr, strArr2);
        if (oVar == null) {
            return i;
        }
        q qVar = new q(o, g(o), j(o), e(o));
        f fVar = new f((g)oVar.a(), (c)oVar.b(), o.a().d(), qVar);
        return fVar;
    }

    public final e m(kotlin.i0.z.e.m0.d.b.o o) {
        n.f(o, "kotlinClass");
        f fVar = k(o);
        if (fVar == null) {
            return null;
        }
        return f().f().d(o.e(), fVar);
    }

    public final void n(kotlin.i0.z.e.m0.d.b.d d) {
        n.f(d, "components");
        o(d.a());
    }

    public final void o(j j) {
        n.f(j, "<set-?>");
        this.a = j;
    }
}
