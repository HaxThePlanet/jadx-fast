package kotlin.i0.z.e.m0.d.a.g0.m;

import java.util.Objects;
import kotlin.d0.c.a;
import kotlin.d0.d.n;
import kotlin.d0.d.p;
import kotlin.i0.z.e.m0.d.a.e0.k;
import kotlin.i0.z.e.m0.f.b;
import kotlin.i0.z.e.m0.l.b0;
import kotlin.i0.z.e.m0.l.i0;
import kotlin.i0.z.e.m0.l.m1.a;
import kotlin.i0.z.e.m0.l.n0;
import kotlin.i0.z.e.m0.l.o0;
import kotlin.i0.z.e.m0.l.t;
import kotlin.i0.z.e.m0.l.t0;
import kotlin.i0.z.e.m0.l.v0;
import kotlin.i0.z.e.m0.l.x0;
import kotlin.reflect.jvm.internal.impl.descriptors.z0;
import kotlin.y.p;

/* loaded from: classes3.dex */
public final class d {

    private static final b a;

    static final class a extends p implements a<i0> {

        final z0 $this_getErasedUpperBound;
        a(z0 z0) {
            this.$this_getErasedUpperBound = z0;
            super(0);
        }

        @Override // kotlin.d0.d.p
        public final i0 a() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Can't compute erased upper bound of type parameter `");
            stringBuilder.append(this.$this_getErasedUpperBound);
            stringBuilder.append('`');
            i0 i0Var = t.j(stringBuilder.toString());
            n.e(i0Var, "createErrorType(\"Can't compute erased upper bound of type parameter `$this`\")");
            return i0Var;
        }

        @Override // kotlin.d0.d.p
        public Object invoke() {
            return a();
        }
    }
    static {
        b bVar = new b("java.lang.Class");
        d.a = bVar;
    }

    public static final b a() {
        return d.a;
    }

    public static final b0 b(z0 z0, z0 z02, a<? extends b0> a3) {
        boolean z;
        Object obj2;
        kotlin.reflect.jvm.internal.impl.descriptors.h obj3;
        n.f(z0, "<this>");
        n.f(a3, "defaultValue");
        if (z0 == z02) {
            return (b0)a3.invoke();
        }
        java.util.List upperBounds = z0.getUpperBounds();
        n.e(upperBounds, "upperBounds");
        Object obj = p.X(upperBounds);
        if (hVar instanceof e) {
            n.e(obj, "firstUpperBound");
            return a.m(obj);
        }
        if (z02 == null) {
        } else {
            obj2 = z02;
        }
        String str3 = "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.TypeParameterDescriptor";
        Objects.requireNonNull(obj.L0().c(), str3);
        while (!n.b(obj3, obj2)) {
            obj3 = obj3.getUpperBounds();
            n.e(obj3, "current.upperBounds");
            obj3 = p.X(obj3);
            Objects.requireNonNull(obj3.L0().c(), str3);
        }
        return (b0)a3.invoke();
    }

    public static b0 c(z0 z0, z0 z02, a a3, int i4, Object object5) {
        int obj1;
        kotlin.i0.z.e.m0.d.a.g0.m.d.a obj2;
        if (i4 & 1 != 0) {
            obj1 = 0;
        }
        if (i4 &= 2 != 0) {
            obj2 = new d.a(z0);
        }
        return d.b(z0, obj1, obj2);
    }

    public static final v0 d(z0 z0, kotlin.i0.z.e.m0.d.a.g0.m.a a2) {
        Object obj1;
        kotlin.i0.z.e.m0.l.w0 obj2;
        n.f(z0, "typeParameter");
        n.f(a2, "attr");
        if (a2.d() == k.SUPERTYPE) {
            obj2 = new x0(o0.a(z0));
        } else {
            obj2 = new n0(z0);
        }
        return obj2;
    }

    public static final kotlin.i0.z.e.m0.d.a.g0.m.a e(k k, boolean z2, z0 z03) {
        n.f(k, "<this>");
        super(k, 0, z2, z03, 2, 0);
        return aVar;
    }

    public static kotlin.i0.z.e.m0.d.a.g0.m.a f(k k, boolean z2, z0 z03, int i4, Object object5) {
        int obj1;
        int obj2;
        if (i4 & 1 != 0) {
            obj1 = 0;
        }
        if (i4 &= 2 != 0) {
            obj2 = 0;
        }
        return d.e(k, obj1, obj2);
    }
}
