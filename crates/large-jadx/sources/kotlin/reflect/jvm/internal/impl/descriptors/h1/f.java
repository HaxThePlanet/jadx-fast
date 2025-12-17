package kotlin.reflect.jvm.internal.impl.descriptors.h1;

import kotlin.d0.c.l;
import kotlin.d0.d.n;
import kotlin.d0.d.p;
import kotlin.i0.z.e.m0.b.h;
import kotlin.i0.z.e.m0.b.k.a;
import kotlin.i0.z.e.m0.f.a;
import kotlin.i0.z.e.m0.f.e;
import kotlin.i0.z.e.m0.i.q.a;
import kotlin.i0.z.e.m0.i.q.b;
import kotlin.i0.z.e.m0.i.q.j;
import kotlin.i0.z.e.m0.i.q.v;
import kotlin.i0.z.e.m0.l.b0;
import kotlin.i0.z.e.m0.l.h1;
import kotlin.reflect.jvm.internal.impl.descriptors.c0;
import kotlin.u;
import kotlin.y.j0;
import kotlin.y.p;

/* loaded from: classes3.dex */
public final class f {

    private static final e a;
    private static final e b;
    private static final e c;
    private static final e d;
    private static final e e;

    static final class a extends p implements l<c0, b0> {

        final h $this_createDeprecatedAnnotation;
        a(h h) {
            this.$this_createDeprecatedAnnotation = h;
            super(1);
        }

        @Override // kotlin.d0.d.p
        public final b0 a(c0 c0) {
            n.f(c0, "module");
            kotlin.i0.z.e.m0.l.i0 obj3 = c0.m().l(h1.INVARIANT, this.$this_createDeprecatedAnnotation.V());
            n.e(obj3, "module.builtIns.getArrayType(Variance.INVARIANT, stringType)");
            return obj3;
        }

        @Override // kotlin.d0.d.p
        public Object invoke(Object object) {
            return a((c0)object);
        }
    }
    static {
        e eVar = e.j("message");
        n.e(eVar, "identifier(\"message\")");
        f.a = eVar;
        e eVar2 = e.j("replaceWith");
        n.e(eVar2, "identifier(\"replaceWith\")");
        f.b = eVar2;
        e eVar3 = e.j("level");
        n.e(eVar3, "identifier(\"level\")");
        f.c = eVar3;
        e eVar4 = e.j("expression");
        n.e(eVar4, "identifier(\"expression\")");
        f.d = eVar4;
        e eVar5 = e.j("imports");
        n.e(eVar5, "identifier(\"imports\")");
        f.e = eVar5;
    }

    public static final kotlin.reflect.jvm.internal.impl.descriptors.h1.c a(h h, String string2, String string3, String string4) {
        n.f(h, "<this>");
        n.f(string2, "message");
        n.f(string3, "replaceWith");
        n.f(string4, "level");
        final int i = 2;
        kotlin.o[] arr = new o[i];
        v vVar = new v(string3);
        int i3 = 0;
        arr[i3] = u.a(f.d, vVar);
        f.a aVar3 = new f.a(h);
        b bVar4 = new b(p.g(), aVar3);
        int i4 = 1;
        arr[i4] = u.a(f.e, bVar4);
        j jVar = new j(h, k.a.w, j0.k(arr));
        kotlin.o[] arr2 = new o[3];
        v vVar2 = new v(string2);
        arr2[i3] = u.a(f.a, vVar2);
        a aVar = new a(jVar);
        arr2[i4] = u.a(f.b, aVar);
        a aVar2 = a.m(k.a.v);
        n.e(aVar2, "topLevel(StandardNames.FqNames.deprecationLevel)");
        final e obj11 = e.j(string4);
        n.e(obj11, "identifier(level)");
        j jVar2 = new j(aVar2, obj11);
        arr2[i] = u.a(f.c, jVar2);
        j obj10 = new j(h, k.a.u, j0.k(arr2));
        return obj10;
    }

    public static kotlin.reflect.jvm.internal.impl.descriptors.h1.c b(h h, String string2, String string3, String string4, int i5, Object object6) {
        String obj2;
        String obj3;
        if (i5 & 2 != 0) {
            obj2 = "";
        }
        if (i5 &= 4 != 0) {
            obj3 = "WARNING";
        }
        return f.a(h, string2, obj2, obj3);
    }
}
