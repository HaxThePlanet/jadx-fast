package kotlin.i0.z.e.m0.d.a.g0.m;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.d0.c.l;
import kotlin.d0.d.n;
import kotlin.d0.d.p;
import kotlin.i0.z.e.m0.h.c;
import kotlin.i0.z.e.m0.h.f;
import kotlin.i0.z.e.m0.i.v.h;
import kotlin.i0.z.e.m0.l.b0;
import kotlin.i0.z.e.m0.l.g1;
import kotlin.i0.z.e.m0.l.h0;
import kotlin.i0.z.e.m0.l.i0;
import kotlin.i0.z.e.m0.l.j1.f;
import kotlin.i0.z.e.m0.l.j1.g;
import kotlin.i0.z.e.m0.l.m1.a;
import kotlin.i0.z.e.m0.l.t0;
import kotlin.i0.z.e.m0.l.v;
import kotlin.k0.l;
import kotlin.o;
import kotlin.reflect.jvm.internal.impl.descriptors.e;
import kotlin.reflect.jvm.internal.impl.descriptors.h1.g;
import kotlin.y.p;

/* loaded from: classes3.dex */
public final class f extends v implements h0 {

    static final class a extends p implements l<String, java.lang.CharSequence> {

        public static final kotlin.i0.z.e.m0.d.a.g0.m.f.a a;
        static {
            f.a aVar = new f.a();
            f.a.a = aVar;
        }

        a() {
            super(1);
        }

        @Override // kotlin.d0.d.p
        public final java.lang.CharSequence invoke(String string) {
            n.f(string, "it");
            return n.o("(raw) ", string);
        }

        @Override // kotlin.d0.d.p
        public Object invoke(Object object) {
            return invoke((String)object);
        }
    }
    public f(i0 i0, i0 i02) {
        n.f(i0, "lowerBound");
        n.f(i02, "upperBound");
        super(i0, i02, 0);
    }

    private f(i0 i0, i0 i02, boolean z3) {
        f obj3;
        super(i0, i02);
        if (z3 == null) {
            f.a.d(i0, i02);
        }
    }

    private static final boolean Y0(String string, String string2) {
        int obj1;
        if (!n.b(string, l.u0(string2, "out "))) {
            if (n.b(string2, "*")) {
                obj1 = 1;
            } else {
                obj1 = 0;
            }
        } else {
        }
        return obj1;
    }

    private static final List<String> Z0(c c, b0 b02) {
        int i;
        List obj3 = b02.K0();
        ArrayList arrayList = new ArrayList(p.r(obj3, 10));
        obj3 = obj3.iterator();
        for (v0 next2 : obj3) {
            arrayList.add(c.y(next2));
        }
        return arrayList;
    }

    private static final String a1(String string, String string2) {
        final int i = 60;
        final int i3 = 2;
        final int i4 = 0;
        if (!l.Q(string, i, false, i3, i4)) {
            return string;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(l.W0(string, i, i4, i3, i4));
        stringBuilder.append(i);
        stringBuilder.append(string2);
        final int obj6 = 62;
        stringBuilder.append(obj6);
        stringBuilder.append(l.S0(string, obj6, i4, i3, i4));
        return stringBuilder.toString();
    }

    @Override // kotlin.i0.z.e.m0.l.v
    public b0 N0(g g) {
        return X0(g);
    }

    @Override // kotlin.i0.z.e.m0.l.v
    public g1 P0(boolean z) {
        return W0(z);
    }

    @Override // kotlin.i0.z.e.m0.l.v
    public g1 Q0(g g) {
        return X0(g);
    }

    @Override // kotlin.i0.z.e.m0.l.v
    public g1 R0(g g) {
        return b1(g);
    }

    @Override // kotlin.i0.z.e.m0.l.v
    public i0 S0() {
        return T0();
    }

    @Override // kotlin.i0.z.e.m0.l.v
    public String V0(c c, f f2) {
        String str;
        boolean empty;
        int i2;
        int i;
        Object obj14;
        n.f(c, "renderer");
        n.f(f2, "options");
        String str4 = c.x(T0());
        str = c.x(U0());
        if (f2.o()) {
            StringBuilder obj13 = new StringBuilder();
            obj13.append("raw (");
            obj13.append(str4);
            obj13.append("..");
            obj13.append(str);
            obj13.append(')');
            return obj13.toString();
        }
        if (U0().K0().isEmpty()) {
            return c.u(str4, str, a.e(this));
        }
        obj14 = f.Z0(c, T0());
        String str5 = p.h0(obj14, ", ", 0, 0, 0, 0, f.a.a, 30, 0);
        obj14 = p.S0(obj14, f.Z0(c, U0()));
        i2 = 1;
        if (obj14 instanceof Collection != null && obj14.isEmpty()) {
            if (obj14.isEmpty()) {
            } else {
                obj14 = obj14.iterator();
                while (obj14.hasNext()) {
                    Object next = obj14.next();
                    if (!f.Y0((String)(o)next.c(), (String)next.d())) {
                        break;
                    } else {
                    }
                }
            }
        } else {
        }
        if (i2 != 0) {
            str = f.a1(str, str5);
        }
        obj14 = f.a1(str4, str5);
        if (n.b(obj14, str)) {
            return obj14;
        }
        return c.u(obj14, str, a.e(this));
    }

    @Override // kotlin.i0.z.e.m0.l.v
    public kotlin.i0.z.e.m0.d.a.g0.m.f W0(boolean z) {
        f fVar = new f(T0().S0(z), U0().S0(z));
        return fVar;
    }

    @Override // kotlin.i0.z.e.m0.l.v
    public v X0(g g) {
        n.f(g, "kotlinTypeRefiner");
        f fVar = new f((i0)g.g(T0()), (i0)g.g(U0()), 1);
        return fVar;
    }

    @Override // kotlin.i0.z.e.m0.l.v
    public kotlin.i0.z.e.m0.d.a.g0.m.f b1(g g) {
        n.f(g, "newAnnotations");
        f fVar = new f(T0().T0(g), U0().T0(g));
        return fVar;
    }

    @Override // kotlin.i0.z.e.m0.l.v
    public h o() {
        kotlin.reflect.jvm.internal.impl.descriptors.h hVar;
        if (hVar instanceof e) {
        } else {
            hVar = 0;
        }
        if (hVar == null) {
        } else {
            h hVar3 = hVar.a0(e.b);
            n.e(hVar3, "classDescriptor.getMemberScope(RawSubstitution)");
            return hVar3;
        }
        IllegalStateException illegalStateException = new IllegalStateException(n.o("Incorrect classifier: ", L0().c()).toString());
        throw illegalStateException;
    }
}
