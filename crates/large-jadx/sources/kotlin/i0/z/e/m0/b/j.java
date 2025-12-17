package kotlin.i0.z.e.m0.b;

import kotlin.d0.c.a;
import kotlin.d0.d.c0;
import kotlin.d0.d.g;
import kotlin.d0.d.n;
import kotlin.d0.d.p;
import kotlin.d0.d.x;
import kotlin.h;
import kotlin.i0.c;
import kotlin.i0.l;
import kotlin.i0.z.e.m0.c.b.d;
import kotlin.i0.z.e.m0.f.a;
import kotlin.i0.z.e.m0.f.e;
import kotlin.i0.z.e.m0.i.v.h;
import kotlin.i0.z.e.m0.i.v.k;
import kotlin.i0.z.e.m0.l.b0;
import kotlin.i0.z.e.m0.l.c0;
import kotlin.i0.z.e.m0.l.n0;
import kotlin.i0.z.e.m0.l.t0;
import kotlin.j;
import kotlin.k0.l;
import kotlin.m;
import kotlin.reflect.jvm.internal.impl.descriptors.c0;
import kotlin.reflect.jvm.internal.impl.descriptors.e;
import kotlin.reflect.jvm.internal.impl.descriptors.e0;
import kotlin.reflect.jvm.internal.impl.descriptors.h;
import kotlin.reflect.jvm.internal.impl.descriptors.h1.g;
import kotlin.reflect.jvm.internal.impl.descriptors.h1.g.a;
import kotlin.reflect.jvm.internal.impl.descriptors.k0;
import kotlin.reflect.jvm.internal.impl.descriptors.w;
import kotlin.y.p;

/* loaded from: classes3.dex */
public final class j {

    public static final kotlin.i0.z.e.m0.b.j.b d;
    static final l<Object>[] e;
    private final e0 a;
    private final h b;
    private final kotlin.i0.z.e.m0.b.j.a c;

    private static final class a {

        private final int a;
        public a(int i) {
            super();
            this.a = i;
        }

        public final e a(kotlin.i0.z.e.m0.b.j j, l<?> l2) {
            n.f(j, "types");
            n.f(l2, "property");
            return j.a(j, l.r(l2.getName()), this.a);
        }
    }

    public static final class b {
        public b(g g) {
            super();
        }

        public final b0 a(c0 c0) {
            n.f(c0, "module");
            e obj5 = w.a(c0, k.a.Z);
            if (obj5 == null) {
                return null;
            }
            c0 c0Var = c0.a;
            java.util.List parameters = obj5.g().getParameters();
            n.e(parameters, "kPropertyClass.typeConstructor.parameters");
            Object obj = p.z0(parameters);
            n.e(obj, "kPropertyClass.typeConstructor.parameters.single()");
            n0 n0Var = new n0((z0)obj);
            return c0.g(g.q.b(), obj5, p.b(n0Var));
        }
    }

    static final class c extends p implements a<h> {

        final c0 $module;
        c(c0 c0) {
            this.$module = c0;
            super(0);
        }

        @Override // kotlin.d0.d.p
        public final h a() {
            return this.$module.M(k.i).o();
        }

        @Override // kotlin.d0.d.p
        public Object invoke() {
            return a();
        }
    }
    static {
        Class<kotlin.i0.z.e.m0.b.j> obj = j.class;
        j.b bVar = new j.b(0);
        j.d = bVar;
        l[] arr = new l[9];
        x xVar = new x(c0.b(obj), "kClass", "getKClass()Lorg/jetbrains/kotlin/descriptors/ClassDescriptor;");
        x xVar2 = new x(c0.b(obj), "kProperty", "getKProperty()Lorg/jetbrains/kotlin/descriptors/ClassDescriptor;");
        x xVar3 = new x(c0.b(obj), "kProperty0", "getKProperty0()Lorg/jetbrains/kotlin/descriptors/ClassDescriptor;");
        x xVar4 = new x(c0.b(obj), "kProperty1", "getKProperty1()Lorg/jetbrains/kotlin/descriptors/ClassDescriptor;");
        x xVar5 = new x(c0.b(obj), "kProperty2", "getKProperty2()Lorg/jetbrains/kotlin/descriptors/ClassDescriptor;");
        x xVar6 = new x(c0.b(obj), "kMutableProperty0", "getKMutableProperty0()Lorg/jetbrains/kotlin/descriptors/ClassDescriptor;");
        x xVar7 = new x(c0.b(obj), "kMutableProperty1", "getKMutableProperty1()Lorg/jetbrains/kotlin/descriptors/ClassDescriptor;");
        x xVar8 = new x(c0.b(obj), "kMutableProperty2", "getKMutableProperty2()Lorg/jetbrains/kotlin/descriptors/ClassDescriptor;");
        j.e = arr;
    }

    public j(c0 c0, e0 e02) {
        n.f(c0, "module");
        n.f(e02, "notFoundClasses");
        super();
        this.a = e02;
        j.c cVar = new j.c(c0);
        this.b = j.a(m.PUBLICATION, cVar);
        j.a obj2 = new j.a(1);
        this.c = obj2;
    }

    public static final e a(kotlin.i0.z.e.m0.b.j j, String string2, int i3) {
        return j.b(string2, i3);
    }

    private final e b(String string, int i2) {
        h hVar;
        boolean aVar;
        kotlin.i0.z.e.m0.f.b bVar;
        Object obj4;
        obj4 = e.j(string);
        n.e(obj4, "identifier(className)");
        if (hVar instanceof e) {
        } else {
            hVar = 0;
        }
        if (hVar == null) {
            aVar = new a(k.i, obj4);
            hVar = this.a.d(aVar, p.b(Integer.valueOf(i2)));
        }
        return hVar;
    }

    private final h d() {
        return (h)this.b.getValue();
    }

    public final e c() {
        return this.c.a(this, j.e[1]);
    }
}
