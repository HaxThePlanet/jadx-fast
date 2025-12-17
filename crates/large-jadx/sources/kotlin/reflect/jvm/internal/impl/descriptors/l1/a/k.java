package kotlin.reflect.jvm.internal.impl.descriptors.l1.a;

import kotlin.d0.d.g;
import kotlin.d0.d.n;
import kotlin.i0.z.e.m0.b.h;
import kotlin.i0.z.e.m0.b.q.f;
import kotlin.i0.z.e.m0.b.q.f.a;
import kotlin.i0.z.e.m0.b.q.h;
import kotlin.i0.z.e.m0.d.a.e0.g;
import kotlin.i0.z.e.m0.d.a.g0.j;
import kotlin.i0.z.e.m0.d.b.d;
import kotlin.i0.z.e.m0.d.b.e;
import kotlin.i0.z.e.m0.f.e;
import kotlin.i0.z.e.m0.i.t.b;
import kotlin.i0.z.e.m0.i.u.b;
import kotlin.i0.z.e.m0.j.b.j;
import kotlin.i0.z.e.m0.j.b.k.a;
import kotlin.i0.z.e.m0.k.f;
import kotlin.i0.z.e.m0.l.j1.l;
import kotlin.i0.z.e.m0.l.j1.l.a;
import kotlin.reflect.jvm.internal.impl.descriptors.c0;
import kotlin.reflect.jvm.internal.impl.descriptors.e0;
import kotlin.reflect.jvm.internal.impl.descriptors.j1.i;
import kotlin.reflect.jvm.internal.impl.descriptors.j1.x;
import kotlin.y.p;

/* loaded from: classes3.dex */
public final class k {

    public static final kotlin.reflect.jvm.internal.impl.descriptors.l1.a.k.a c;
    private final j a;
    private final kotlin.reflect.jvm.internal.impl.descriptors.l1.a.a b;

    public static final class a {
        public a(g g) {
            super();
        }

        public final kotlin.reflect.jvm.internal.impl.descriptors.l1.a.k a(java.lang.ClassLoader classLoader) {
            Object obj = classLoader;
            n.f(obj, "classLoader");
            f fVar9 = new f("RuntimeModuleData");
            f fVar10 = new f(fVar9, f.a.FROM_DEPENDENCIES);
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("<runtime module for ");
            stringBuilder.append(obj);
            stringBuilder.append('>');
            e eVar2 = e.n(stringBuilder.toString());
            n.e(eVar2, "special(\"<runtime module for $classLoader>\")");
            int i7 = 0;
            super(eVar2, fVar9, fVar10, 0, i7, 0, 56, 0);
            fVar10.L0(xVar5);
            fVar10.Q0(xVar5, true);
            g gVar7 = new g(obj);
            e eVar5 = new e();
            j jVar3 = new j();
            e0 e0Var4 = new e0(fVar9, xVar5);
            final e0 e0Var5 = e0Var4;
            kotlin.i0.z.e.m0.d.a.g0.f fVar = l.c(obj, xVar5, fVar9, e0Var4, gVar7, eVar5, jVar3, i7, 128, 0);
            d dVar = l.a(xVar5, fVar9, e0Var5, fVar, gVar7, eVar5);
            eVar5.n(dVar);
            g gVar = g.a;
            n.e(gVar, "EMPTY");
            b bVar2 = new b(fVar, gVar);
            jVar3.c(bVar2);
            java.lang.ClassLoader classLoader2 = w.class.getClassLoader();
            n.e(classLoader2, "stdlibClassLoader");
            g gVar3 = new g(classLoader2);
            b bVar = new b(fVar9, p.g());
            super(fVar9, gVar3, xVar5, e0Var5, fVar10.P0(), fVar10.P0(), k.a.a, l.b.a(), bVar);
            int i3 = 1;
            x[] arr = new x[i3];
            int i4 = 0;
            arr[i4] = xVar5;
            xVar5.W0(arr);
            kotlin.reflect.jvm.internal.impl.descriptors.j0[] arr2 = new j0[2];
            arr2[i4] = bVar2.a();
            arr2[i3] = hVar2;
            i iVar = new i(p.j(arr2));
            xVar5.Q0(iVar);
            a aVar3 = new a(eVar5, gVar7);
            k kVar = new k(dVar.a(), aVar3, 0);
            return kVar;
        }
    }
    static {
        k.a aVar = new k.a(0);
        k.c = aVar;
    }

    private k(j j, kotlin.reflect.jvm.internal.impl.descriptors.l1.a.a a2) {
        super();
        this.a = j;
        this.b = a2;
    }

    public k(j j, kotlin.reflect.jvm.internal.impl.descriptors.l1.a.a a2, g g3) {
        super(j, a2);
    }

    public final j a() {
        return this.a;
    }

    public final c0 b() {
        return this.a.p();
    }

    public final kotlin.reflect.jvm.internal.impl.descriptors.l1.a.a c() {
        return this.b;
    }
}
