package kotlin.i0.z.e.m0.i.p.a;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Objects;
import kotlin.d0.c.a;
import kotlin.d0.d.n;
import kotlin.d0.d.p;
import kotlin.i0.z.e.m0.k.f;
import kotlin.i0.z.e.m0.l.b0;
import kotlin.i0.z.e.m0.l.e0;
import kotlin.i0.z.e.m0.l.h1;
import kotlin.i0.z.e.m0.l.l;
import kotlin.i0.z.e.m0.l.t0;
import kotlin.i0.z.e.m0.l.v0;
import kotlin.i0.z.e.m0.l.x0;
import kotlin.i0.z.e.m0.l.y0;
import kotlin.i0.z.e.m0.l.z;
import kotlin.o;
import kotlin.reflect.jvm.internal.impl.descriptors.z0;
import kotlin.y.i;
import kotlin.y.p;

/* loaded from: classes3.dex */
public final class d {

    public static final class b extends l {

        final boolean c;
        b(boolean z, y0 y02) {
            this.c = z;
            super(y02);
        }

        @Override // kotlin.i0.z.e.m0.l.l
        public boolean b() {
            return this.c;
        }

        @Override // kotlin.i0.z.e.m0.l.l
        public v0 e(b0 b0) {
            int i;
            boolean z;
            Object obj4;
            n.f(b0, "key");
            v0 v0Var = super.e(b0);
            i = 0;
            if (v0Var == null) {
            } else {
                obj4 = b0.L0().c();
                if (obj4 instanceof z0) {
                    i = obj4;
                }
                i = d.a(v0Var, i);
            }
            return i;
        }
    }

    static final class a extends p implements a<b0> {

        final v0 $this_createCapturedIfNeeded;
        a(v0 v0) {
            this.$this_createCapturedIfNeeded = v0;
            super(0);
        }

        @Override // kotlin.d0.d.p
        public final b0 a() {
            b0 type = this.$this_createCapturedIfNeeded.getType();
            n.e(type, "this@createCapturedIfNeeded.type");
            return type;
        }

        @Override // kotlin.d0.d.p
        public Object invoke() {
            return a();
        }
    }
    public static final v0 a(v0 v0, z0 z02) {
        return d.b(v0, z02);
    }

    private static final v0 b(v0 v0, z0 z02) {
        h1 h1Var;
        Object e0Var;
        h1 iNVARIANT;
        kotlin.i0.z.e.m0.i.p.a.d.a aVar;
        Object obj3;
        x0 obj4;
        if (z02 != null) {
            if (v0.a() == h1.INVARIANT) {
            } else {
                if (z02.l() == v0.a()) {
                    if (v0.c()) {
                        iNVARIANT = f.e;
                        n.e(iNVARIANT, "NO_LOCKS");
                        aVar = new d.a(v0);
                        e0Var = new e0(iNVARIANT, aVar);
                        obj4 = new x0(e0Var);
                    } else {
                        obj4 = new x0(v0.getType());
                    }
                    return obj4;
                }
            }
            obj4 = new x0(d.c(v0));
            return obj4;
        }
        return v0;
    }

    public static final b0 c(v0 v0) {
        n.f(v0, "typeProjection");
        super(v0, 0, 0, 0, 14, 0);
        return aVar;
    }

    public static final boolean d(b0 b0) {
        n.f(b0, "<this>");
        return obj1 instanceof b;
    }

    public static final y0 e(y0 y0, boolean z2) {
        boolean objArr;
        y0 bVar;
        int i;
        boolean next;
        Object obj;
        Object obj4;
        n.f(y0, "<this>");
        if (y0 instanceof z) {
            obj4 = i.o0(y0.h(), y0.i());
            ArrayList arrayList = new ArrayList(p.r(obj4, 10));
            obj4 = obj4.iterator();
            for (o next2 : obj4) {
                arrayList.add(d.b((v0)next2.c(), (z0)next2.d()));
            }
            obj4 = arrayList.toArray(new v0[0]);
            Objects.requireNonNull(obj4, "null cannot be cast to non-null type kotlin.Array<T>");
            bVar = new z((z)y0.i(), (v0[])obj4, z2);
        } else {
            bVar = new d.b(z2, y0);
        }
        return bVar;
    }

    public static y0 f(y0 y0, boolean z2, int i3, Object object4) {
        int obj1;
        final int obj3 = 1;
        if (i3 &= obj3 != 0) {
            obj1 = obj3;
        }
        return d.e(y0, obj1);
    }
}
