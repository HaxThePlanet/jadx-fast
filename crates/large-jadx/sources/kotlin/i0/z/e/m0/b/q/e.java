package kotlin.i0.z.e.m0.b.q;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import kotlin.d0.c.a;
import kotlin.d0.c.l;
import kotlin.d0.d.c0;
import kotlin.d0.d.g;
import kotlin.d0.d.n;
import kotlin.d0.d.p;
import kotlin.d0.d.x;
import kotlin.i0.l;
import kotlin.i0.z.e.m0.b.b;
import kotlin.i0.z.e.m0.b.h;
import kotlin.i0.z.e.m0.b.k;
import kotlin.i0.z.e.m0.b.k.a;
import kotlin.i0.z.e.m0.f.a;
import kotlin.i0.z.e.m0.f.b;
import kotlin.i0.z.e.m0.f.c;
import kotlin.i0.z.e.m0.f.e;
import kotlin.i0.z.e.m0.k.i;
import kotlin.i0.z.e.m0.k.m;
import kotlin.i0.z.e.m0.k.n;
import kotlin.reflect.jvm.internal.impl.descriptors.c0;
import kotlin.reflect.jvm.internal.impl.descriptors.e;
import kotlin.reflect.jvm.internal.impl.descriptors.f;
import kotlin.reflect.jvm.internal.impl.descriptors.i1.b;
import kotlin.reflect.jvm.internal.impl.descriptors.j1.h;
import kotlin.reflect.jvm.internal.impl.descriptors.k0;
import kotlin.reflect.jvm.internal.impl.descriptors.m;
import kotlin.reflect.jvm.internal.impl.descriptors.u0;
import kotlin.reflect.jvm.internal.impl.descriptors.z;
import kotlin.y.p;
import kotlin.y.q0;

/* loaded from: classes3.dex */
public final class e implements b {

    public static final kotlin.i0.z.e.m0.b.q.e.b d;
    static final l<Object>[] e;
    private static final b f;
    private static final e g;
    private static final a h;
    private final c0 a;
    private final l<c0, m> b;
    private final i c;

    public static final class b {
        public b(g g) {
            super();
        }

        public final a a() {
            return e.d();
        }
    }

    static final class a extends p implements l<c0, b> {

        public static final kotlin.i0.z.e.m0.b.q.e.a a;
        static {
            e.a aVar = new e.a();
            e.a.a = aVar;
        }

        a() {
            super(1);
        }

        @Override // kotlin.d0.d.p
        public final b a(c0 c0) {
            Object next;
            boolean z;
            n.f(c0, "module");
            ArrayList arrayList = new ArrayList();
            Iterator obj4 = c0.M(e.g()).G().iterator();
            while (obj4.hasNext()) {
                next = obj4.next();
                if (next instanceof b) {
                }
                arrayList.add(next);
            }
            return (b)p.X(arrayList);
        }

        @Override // kotlin.d0.d.p
        public Object invoke(Object object) {
            return a((c0)object);
        }
    }

    static final class c extends p implements a<h> {

        final n $storageManager;
        final kotlin.i0.z.e.m0.b.q.e this$0;
        c(kotlin.i0.z.e.m0.b.q.e e, n n2) {
            this.this$0 = e;
            this.$storageManager = n2;
            super(0);
        }

        @Override // kotlin.d0.d.p
        public final h a() {
            super((m)e.f(this.this$0).invoke(e.h(this.this$0)), e.e(), z.ABSTRACT, f.INTERFACE, p.b(e.h(this.this$0).m().i()), u0.a, 0, this.$storageManager);
            a aVar = new a(this.$storageManager, hVar3);
            hVar3.J0(aVar, q0.b(), 0);
            return hVar3;
        }

        @Override // kotlin.d0.d.p
        public Object invoke() {
            return a();
        }
    }
    static {
        e.b bVar = new e.b(0);
        e.d = bVar;
        l[] arr = new l[1];
        x xVar = new x(c0.b(e.class), "cloneable", "getCloneable()Lorg/jetbrains/kotlin/descriptors/impl/ClassDescriptorImpl;");
        e.e = arr;
        e.f = k.l;
        c cVar = k.a.d;
        e eVar = cVar.i();
        n.e(eVar, "cloneable.shortName()");
        e.g = eVar;
        a aVar = a.m(cVar.l());
        n.e(aVar, "topLevel(StandardNames.FqNames.cloneable.toSafe())");
        e.h = aVar;
    }

    public e(n n, c0 c02, l<? super c0, ? extends m> l3) {
        n.f(n, "storageManager");
        n.f(c02, "moduleDescriptor");
        n.f(l3, "computeContainingDeclaration");
        super();
        this.a = c02;
        this.b = l3;
        e.c obj3 = new e.c(this, n);
        this.c = n.d(obj3);
    }

    public e(n n, c0 c02, l l3, int i4, g g5) {
        kotlin.i0.z.e.m0.b.q.e.a obj3;
        obj3 = i4 &= 4 != 0 ? e.a.a : obj3;
        super(n, c02, obj3);
    }

    public static final a d() {
        return e.h;
    }

    public static final e e() {
        return e.g;
    }

    public static final l f(kotlin.i0.z.e.m0.b.q.e e) {
        return e.b;
    }

    public static final b g() {
        return e.f;
    }

    public static final c0 h(kotlin.i0.z.e.m0.b.q.e e) {
        return e.a;
    }

    private final h i() {
        return (h)m.a(this.c, this, e.e[0]);
    }

    public Collection<e> a(b b) {
        java.util.Set obj2;
        n.f(b, "packageFqName");
        if (n.b(b, e.f)) {
            obj2 = q0.a(i());
        } else {
            obj2 = q0.b();
        }
        return obj2;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.i1.b
    public boolean b(b b, e e2) {
        Object obj2;
        boolean obj3;
        n.f(b, "packageFqName");
        n.f(e2, "name");
        if (n.b(e2, e.g) && n.b(b, e.f)) {
            obj2 = n.b(b, e.f) ? 1 : 0;
        } else {
        }
        return obj2;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.i1.b
    public e c(a a) {
        h obj2;
        n.f(a, "classId");
        if (n.b(a, e.d.a())) {
            obj2 = i();
        } else {
            obj2 = 0;
        }
        return obj2;
    }
}
