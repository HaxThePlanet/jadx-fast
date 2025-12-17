package kotlin.i0.z.e.m0.h;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.Set;
import kotlin.NoWhenBranchMatchedException;
import kotlin.d0.c.a;
import kotlin.d0.c.l;
import kotlin.d0.d.n;
import kotlin.d0.d.p;
import kotlin.h;
import kotlin.i0.z.e.m0.b.g;
import kotlin.i0.z.e.m0.b.h;
import kotlin.i0.z.e.m0.b.k.a;
import kotlin.i0.z.e.m0.f.a;
import kotlin.i0.z.e.m0.f.b;
import kotlin.i0.z.e.m0.f.c;
import kotlin.i0.z.e.m0.f.e;
import kotlin.i0.z.e.m0.f.g;
import kotlin.i0.z.e.m0.i.d;
import kotlin.i0.z.e.m0.i.q.g;
import kotlin.i0.z.e.m0.i.q.q.b.a;
import kotlin.i0.z.e.m0.i.q.q.b.b;
import kotlin.i0.z.e.m0.i.s.a;
import kotlin.i0.z.e.m0.l.a;
import kotlin.i0.z.e.m0.l.b0;
import kotlin.i0.z.e.m0.l.c1;
import kotlin.i0.z.e.m0.l.d0;
import kotlin.i0.z.e.m0.l.f1;
import kotlin.i0.z.e.m0.l.h1;
import kotlin.i0.z.e.m0.l.i0;
import kotlin.i0.z.e.m0.l.i1;
import kotlin.i0.z.e.m0.l.l0;
import kotlin.i0.z.e.m0.l.s;
import kotlin.i0.z.e.m0.l.t;
import kotlin.i0.z.e.m0.l.t.f;
import kotlin.i0.z.e.m0.l.t0;
import kotlin.i0.z.e.m0.l.v;
import kotlin.i0.z.e.m0.l.v0;
import kotlin.j;
import kotlin.k0.l;
import kotlin.reflect.jvm.internal.impl.descriptors.a;
import kotlin.reflect.jvm.internal.impl.descriptors.a1;
import kotlin.reflect.jvm.internal.impl.descriptors.b;
import kotlin.reflect.jvm.internal.impl.descriptors.b.a;
import kotlin.reflect.jvm.internal.impl.descriptors.b1;
import kotlin.reflect.jvm.internal.impl.descriptors.c0;
import kotlin.reflect.jvm.internal.impl.descriptors.c1;
import kotlin.reflect.jvm.internal.impl.descriptors.d0;
import kotlin.reflect.jvm.internal.impl.descriptors.d1;
import kotlin.reflect.jvm.internal.impl.descriptors.e;
import kotlin.reflect.jvm.internal.impl.descriptors.f;
import kotlin.reflect.jvm.internal.impl.descriptors.f0;
import kotlin.reflect.jvm.internal.impl.descriptors.h;
import kotlin.reflect.jvm.internal.impl.descriptors.h1.a;
import kotlin.reflect.jvm.internal.impl.descriptors.h1.c;
import kotlin.reflect.jvm.internal.impl.descriptors.h1.e;
import kotlin.reflect.jvm.internal.impl.descriptors.h1.g;
import kotlin.reflect.jvm.internal.impl.descriptors.i;
import kotlin.reflect.jvm.internal.impl.descriptors.k0;
import kotlin.reflect.jvm.internal.impl.descriptors.l;
import kotlin.reflect.jvm.internal.impl.descriptors.m;
import kotlin.reflect.jvm.internal.impl.descriptors.m0;
import kotlin.reflect.jvm.internal.impl.descriptors.n;
import kotlin.reflect.jvm.internal.impl.descriptors.n0;
import kotlin.reflect.jvm.internal.impl.descriptors.o;
import kotlin.reflect.jvm.internal.impl.descriptors.o0;
import kotlin.reflect.jvm.internal.impl.descriptors.p;
import kotlin.reflect.jvm.internal.impl.descriptors.p0;
import kotlin.reflect.jvm.internal.impl.descriptors.q0;
import kotlin.reflect.jvm.internal.impl.descriptors.r0;
import kotlin.reflect.jvm.internal.impl.descriptors.t;
import kotlin.reflect.jvm.internal.impl.descriptors.u;
import kotlin.reflect.jvm.internal.impl.descriptors.u0;
import kotlin.reflect.jvm.internal.impl.descriptors.v0;
import kotlin.reflect.jvm.internal.impl.descriptors.x;
import kotlin.reflect.jvm.internal.impl.descriptors.y;
import kotlin.reflect.jvm.internal.impl.descriptors.y0;
import kotlin.reflect.jvm.internal.impl.descriptors.z;
import kotlin.reflect.jvm.internal.impl.descriptors.z0;
import kotlin.w;
import kotlin.y.p;

/* loaded from: classes3.dex */
public final class d extends kotlin.i0.z.e.m0.h.c implements kotlin.i0.z.e.m0.h.f {

    private final kotlin.i0.z.e.m0.h.g d;
    private final h e;

    public class b {

        public static final int[] a;
        public static final int[] b;
        static {
            int[] iArr = new int[values.length];
            int i = 1;
            iArr[m.PLAIN.ordinal()] = i;
            final int i3 = 2;
            iArr[m.HTML.ordinal()] = i3;
            d.b.a = iArr;
            int[] iArr2 = new int[values2.length];
            iArr2[k.ALL.ordinal()] = i;
            iArr2[k.ONLY_NON_SYNTHESIZED.ordinal()] = i3;
            iArr2[k.NONE.ordinal()] = 3;
            d.b.b = iArr2;
        }
    }

    private final class a implements o<w, StringBuilder> {

        final kotlin.i0.z.e.m0.h.d a;
        public a(kotlin.i0.z.e.m0.h.d d) {
            n.f(d, "this$0");
            this.a = d;
            super();
        }

        private final void t(n0 n0, StringBuilder stringBuilder2, String string3) {
            int str;
            Object obj3;
            int obj5;
            str = d.a.a.a[this.a.n0().ordinal()];
            if (str != 1) {
                if (str != 2) {
                } else {
                    p(n0, stringBuilder2);
                }
            } else {
                d.A(this.a, n0, stringBuilder2);
                stringBuilder2.append(n.o(string3, " for "));
                obj3 = n0.y0();
                n.e(obj3, "descriptor.correspondingProperty");
                d.I(this.a, obj3, stringBuilder2);
            }
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.o
        public void A(c1 c1, StringBuilder stringBuilder2) {
            n.f(c1, "descriptor");
            n.f(stringBuilder2, "builder");
            final int i = 1;
            d.L(this.a, c1, i, stringBuilder2, i);
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.o
        public Object a(e e, Object object2) {
            n(e, (StringBuilder)object2);
            return w.a;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.o
        public Object b(p0 p0, Object object2) {
            v(p0, (StringBuilder)object2);
            return w.a;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.o
        public Object c(k0 k0, Object object2) {
            s(k0, (StringBuilder)object2);
            return w.a;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.o
        public Object d(o0 o0, Object object2) {
            u(o0, (StringBuilder)object2);
            return w.a;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.o
        public Object e(y0 y0, Object object2) {
            y(y0, (StringBuilder)object2);
            return w.a;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.o
        public Object f(f0 f0, Object object2) {
            r(f0, (StringBuilder)object2);
            return w.a;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.o
        public Object g(x x, Object object2) {
            p(x, (StringBuilder)object2);
            return w.a;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.o
        public Object h(l l, Object object2) {
            o(l, (StringBuilder)object2);
            return w.a;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.o
        public Object i(q0 q0, Object object2) {
            w(q0, (StringBuilder)object2);
            return w.a;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.o
        public Object j(c0 c0, Object object2) {
            q(c0, (StringBuilder)object2);
            return w.a;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.o
        public Object k(c1 c1, Object object2) {
            A(c1, (StringBuilder)object2);
            return w.a;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.o
        public Object l(r0 r0, Object object2) {
            x(r0, (StringBuilder)object2);
            return w.a;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.o
        public Object m(z0 z0, Object object2) {
            z(z0, (StringBuilder)object2);
            return w.a;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.o
        public void n(e e, StringBuilder stringBuilder2) {
            n.f(e, "descriptor");
            n.f(stringBuilder2, "builder");
            d.B(this.a, e, stringBuilder2);
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.o
        public void o(l l, StringBuilder stringBuilder2) {
            n.f(l, "constructorDescriptor");
            n.f(stringBuilder2, "builder");
            d.D(this.a, l, stringBuilder2);
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.o
        public void p(x x, StringBuilder stringBuilder2) {
            n.f(x, "descriptor");
            n.f(stringBuilder2, "builder");
            d.E(this.a, x, stringBuilder2);
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.o
        public void q(c0 c0, StringBuilder stringBuilder2) {
            n.f(c0, "descriptor");
            n.f(stringBuilder2, "builder");
            d.F(this.a, c0, stringBuilder2, true);
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.o
        public void r(f0 f0, StringBuilder stringBuilder2) {
            n.f(f0, "descriptor");
            n.f(stringBuilder2, "builder");
            d.G(this.a, f0, stringBuilder2);
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.o
        public void s(k0 k0, StringBuilder stringBuilder2) {
            n.f(k0, "descriptor");
            n.f(stringBuilder2, "builder");
            d.H(this.a, k0, stringBuilder2);
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.o
        public void u(o0 o0, StringBuilder stringBuilder2) {
            n.f(o0, "descriptor");
            n.f(stringBuilder2, "builder");
            d.I(this.a, o0, stringBuilder2);
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.o
        public void v(p0 p0, StringBuilder stringBuilder2) {
            n.f(p0, "descriptor");
            n.f(stringBuilder2, "builder");
            t(p0, stringBuilder2, "getter");
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.o
        public void w(q0 q0, StringBuilder stringBuilder2) {
            n.f(q0, "descriptor");
            n.f(stringBuilder2, "builder");
            t(q0, stringBuilder2, "setter");
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.o
        public void x(r0 r0, StringBuilder stringBuilder2) {
            n.f(r0, "descriptor");
            n.f(stringBuilder2, "builder");
            stringBuilder2.append(r0.getName());
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.o
        public void y(y0 y0, StringBuilder stringBuilder2) {
            n.f(y0, "descriptor");
            n.f(stringBuilder2, "builder");
            d.J(this.a, y0, stringBuilder2);
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.o
        public void z(z0 z0, StringBuilder stringBuilder2) {
            n.f(z0, "descriptor");
            n.f(stringBuilder2, "builder");
            d.K(this.a, z0, stringBuilder2, true);
        }
    }

    static final class c extends p implements l<v0, java.lang.CharSequence> {

        final kotlin.i0.z.e.m0.h.d this$0;
        c(kotlin.i0.z.e.m0.h.d d) {
            this.this$0 = d;
            super(1);
        }

        @Override // kotlin.d0.d.p
        public final java.lang.CharSequence a(v0 v0) {
            boolean z;
            Object stringBuilder;
            h1 iNVARIANT;
            String obj4;
            n.f(v0, "it");
            if (v0.c()) {
                obj4 = "*";
            } else {
                b0 type = v0.getType();
                n.e(type, "it.type");
                z = this.this$0.x(type);
                if (v0.a() == h1.INVARIANT) {
                    obj4 = z;
                } else {
                    stringBuilder = new StringBuilder();
                    stringBuilder.append(v0.a());
                    stringBuilder.append(' ');
                    stringBuilder.append(z);
                    obj4 = stringBuilder.toString();
                }
            }
            return obj4;
        }

        @Override // kotlin.d0.d.p
        public Object invoke(Object object) {
            return a((v0)object);
        }
    }

    static final class d extends p implements a<kotlin.i0.z.e.m0.h.d> {

        final kotlin.i0.z.e.m0.h.d this$0;
        d(kotlin.i0.z.e.m0.h.d d) {
            this.this$0 = d;
            super(0);
        }

        @Override // kotlin.d0.d.p
        public final kotlin.i0.z.e.m0.h.d a() {
            return (d)this.this$0.z(d.d.a.a);
        }

        @Override // kotlin.d0.d.p
        public Object invoke() {
            return a();
        }
    }

    static final class e extends p implements l<g<?>, java.lang.CharSequence> {

        final kotlin.i0.z.e.m0.h.d this$0;
        e(kotlin.i0.z.e.m0.h.d d) {
            this.this$0 = d;
            super(1);
        }

        public final java.lang.CharSequence a(g<?> g) {
            n.f(g, "it");
            return d.C(this.this$0, g);
        }

        @Override // kotlin.d0.d.p
        public Object invoke(Object object) {
            return a((g)object);
        }
    }

    static final class f extends p implements l<c1, java.lang.CharSequence> {

        public static final kotlin.i0.z.e.m0.h.d.f a;
        static {
            d.f fVar = new d.f();
            d.f.a = fVar;
        }

        f() {
            super(1);
        }

        @Override // kotlin.d0.d.p
        public final java.lang.CharSequence a(c1 c1) {
            return "";
        }

        @Override // kotlin.d0.d.p
        public Object invoke(Object object) {
            return a((c1)object);
        }
    }

    static final class g extends p implements l<b0, java.lang.CharSequence> {

        final kotlin.i0.z.e.m0.h.d this$0;
        g(kotlin.i0.z.e.m0.h.d d) {
            this.this$0 = d;
            super(1);
        }

        @Override // kotlin.d0.d.p
        public final java.lang.CharSequence a(b0 b0) {
            n.e(b0, "it");
            return this.this$0.x(b0);
        }

        @Override // kotlin.d0.d.p
        public Object invoke(Object object) {
            return a((b0)object);
        }
    }
    public d(kotlin.i0.z.e.m0.h.g g) {
        n.f(g, "options");
        super();
        this.d = g;
        g.l0();
        d.d obj2 = new d.d(this);
        this.e = j.b(obj2);
    }

    public static final void A(kotlin.i0.z.e.m0.h.d d, n0 n02, StringBuilder stringBuilder3) {
        d.T0(n02, stringBuilder3);
    }

    private final void A1(o0 o0, StringBuilder stringBuilder2) {
        boolean typeParameters;
        boolean str;
        int i5;
        boolean contains;
        boolean contains2;
        int i;
        Object lATEINIT;
        o0 o0Var;
        StringBuilder sb;
        int i2;
        int i3;
        int i4;
        final String str4 = "property.typeParameters";
        int i6 = 1;
        if (!A0() && !z0()) {
            if (!z0()) {
                B1(o0, stringBuilder2);
                u visibility = o0.getVisibility();
                n.e(visibility, "property.visibility");
                V1(visibility, stringBuilder2);
                if (g0().contains(e.CONST) && o0.isConst()) {
                    i5 = o0.isConst() ? i6 : i;
                } else {
                }
                r1(stringBuilder2, i5, "const");
                n1(o0, stringBuilder2);
                q1(o0, stringBuilder2);
                v1(o0, stringBuilder2);
                if (g0().contains(e.LATEINIT) && o0.r0()) {
                    if (o0.r0()) {
                        i = i6;
                    }
                }
                r1(stringBuilder2, i, "lateinit");
                m1(o0, stringBuilder2);
            }
            d.R1(this, o0, stringBuilder2, false, 4, 0);
            typeParameters = o0.getTypeParameters();
            n.e(typeParameters, str4);
            P1(typeParameters, stringBuilder2, i6);
            C1(o0, stringBuilder2);
        }
        s1(o0, stringBuilder2, i6);
        stringBuilder2.append(": ");
        b0 type = o0.getType();
        n.e(type, "property.type");
        stringBuilder2.append(x(type));
        D1(o0, stringBuilder2);
        k1(o0, stringBuilder2);
        final List obj11 = o0.getTypeParameters();
        n.e(obj11, str4);
        W1(obj11, stringBuilder2);
    }

    public static final void B(kotlin.i0.z.e.m0.h.d d, e e2, StringBuilder stringBuilder3) {
        d.Z0(e2, stringBuilder3);
    }

    private final void B1(o0 o0, StringBuilder stringBuilder2) {
        Object sETTER_PARAMETER;
        Object pROPERTY_DELEGATE_FIELD;
        Enum pROPERTY_GETTER;
        Object obj8;
        if (!g0().contains(e.ANNOTATIONS)) {
        }
        d.X0(this, stringBuilder2, o0, 0, 2, 0);
        kotlin.reflect.jvm.internal.impl.descriptors.v vVar = o0.q0();
        if (vVar == null) {
        } else {
            W0(stringBuilder2, vVar, e.FIELD);
        }
        kotlin.reflect.jvm.internal.impl.descriptors.v vVar2 = o0.n0();
        if (vVar2 == null) {
        } else {
            W0(stringBuilder2, vVar2, e.PROPERTY_DELEGATE_FIELD);
        }
        if (n0() == l.NONE) {
            sETTER_PARAMETER = o0.getGetter();
            if (sETTER_PARAMETER == null) {
            } else {
                W0(stringBuilder2, sETTER_PARAMETER, e.PROPERTY_GETTER);
            }
            obj8 = o0.getSetter();
            if (obj8 == null) {
            } else {
                W0(stringBuilder2, obj8, e.PROPERTY_SETTER);
                obj8 = obj8.h();
                n.e(obj8, "setter.valueParameters");
                obj8 = p.z0(obj8);
                n.e((c1)obj8, "it");
                W0(stringBuilder2, obj8, e.SETTER_PARAMETER);
            }
        }
    }

    public static final String C(kotlin.i0.z.e.m0.h.d d, g g2) {
        return d.d1(g2);
    }

    private final void C1(a a, StringBuilder stringBuilder2) {
        String string;
        boolean z;
        b0 obj3;
        obj3 = a.m0();
        W0(stringBuilder2, obj3, e.RECEIVER);
        obj3 = obj3.getType();
        n.e(obj3, "receiver.type");
        if (obj3 != null && Y1(obj3) && !c1.l(obj3)) {
            W0(stringBuilder2, obj3, e.RECEIVER);
            obj3 = obj3.getType();
            n.e(obj3, "receiver.type");
            if (Y1(obj3)) {
                if (!c1.l(obj3)) {
                    obj3 = new StringBuilder();
                    obj3.append('(');
                    obj3.append(x(obj3));
                    obj3.append(')');
                    string = obj3.toString();
                }
            }
            stringBuilder2.append(string);
            stringBuilder2.append(".");
        }
    }

    public static final void D(kotlin.i0.z.e.m0.h.d d, l l2, StringBuilder stringBuilder3) {
        d.e1(l2, stringBuilder3);
    }

    private final void D1(a a, StringBuilder stringBuilder2) {
        boolean str;
        Object obj2;
        if (!o0()) {
        }
        obj2 = a.m0();
        if (obj2 != null) {
            stringBuilder2.append(" on ");
            obj2 = obj2.getType();
            n.e(obj2, "receiver.type");
            stringBuilder2.append(x(obj2));
        }
    }

    public static final void E(kotlin.i0.z.e.m0.h.d d, x x2, StringBuilder stringBuilder3) {
        d.i1(x2, stringBuilder3);
    }

    private final void E1(StringBuilder stringBuilder, i0 i02) {
        boolean z;
        boolean str;
        Object obj4;
        final String str2 = "???";
        if (!n.b(i02, c1.b)) {
            if (c1.k(i02)) {
            } else {
                if (t.t(i02)) {
                    if (D0()) {
                        obj4 = (t.f)i02.L0().g().getName().toString();
                        n.e(obj4, "type.constructor as UninferredParameterTypeConstructor).typeParameterDescriptor.name.toString()");
                        stringBuilder.append(g1(obj4));
                    } else {
                        stringBuilder.append(str2);
                    }
                }
                if (d0.a(i02)) {
                    f1(stringBuilder, i02);
                }
                if (Y1(i02)) {
                    j1(stringBuilder, i02);
                } else {
                    f1(stringBuilder, i02);
                }
            }
        }
        stringBuilder.append(str2);
    }

    public static final void F(kotlin.i0.z.e.m0.h.d d, m m2, StringBuilder stringBuilder3, boolean z4) {
        d.s1(m2, stringBuilder3, z4);
    }

    private final void F1(StringBuilder stringBuilder) {
        char charAt;
        charAt = stringBuilder.length();
        final int i2 = 32;
        if (charAt != 0) {
            if (stringBuilder.charAt(charAt--) != i2) {
                stringBuilder.append(i2);
            }
        } else {
        }
    }

    public static final void G(kotlin.i0.z.e.m0.h.d d, f0 f02, StringBuilder stringBuilder3) {
        d.w1(f02, stringBuilder3);
    }

    private final void G1(e e, StringBuilder stringBuilder2) {
        int i2;
        String str;
        int i6;
        int i4;
        int i7;
        int i5;
        kotlin.i0.z.e.m0.h.d.g gVar;
        int i;
        int i3;
        boolean obj11;
        if (K0()) {
        }
        if (h.t0(e.q())) {
        }
        Collection collection = e.g().a();
        n.e(collection, "klass.typeConstructor.supertypes");
        if (!collection.isEmpty()) {
            if (collection.size() == 1 && h.a0((b0)collection.iterator().next())) {
                if (h.a0((b0)collection.iterator().next())) {
                } else {
                    F1(stringBuilder2);
                    stringBuilder2.append(": ");
                    gVar = new d.g(this);
                    p.f0(collection, stringBuilder2, ", ", 0, 0, 0, 0, gVar, 60, 0);
                }
            } else {
            }
        }
    }

    public static final void H(kotlin.i0.z.e.m0.h.d d, k0 k02, StringBuilder stringBuilder3) {
        d.y1(k02, stringBuilder3);
    }

    private final void H1(x x, StringBuilder stringBuilder2) {
        r1(stringBuilder2, x.isSuspend(), "suspend");
    }

    public static final void I(kotlin.i0.z.e.m0.h.d d, o0 o02, StringBuilder stringBuilder3) {
        d.A1(o02, stringBuilder3);
    }

    private final void I1(y0 y0, StringBuilder stringBuilder2) {
        d.X0(this, stringBuilder2, y0, 0, 2, 0);
        u visibility = y0.getVisibility();
        n.e(visibility, "typeAlias.visibility");
        V1(visibility, stringBuilder2);
        n1(y0, stringBuilder2);
        stringBuilder2.append(l1("typealias"));
        stringBuilder2.append(" ");
        s1(y0, stringBuilder2, true);
        List list = y0.t();
        n.e(list, "typeAlias.declaredTypeParameters");
        P1(list, stringBuilder2, false);
        Y0(y0, stringBuilder2);
        stringBuilder2.append(" = ");
        stringBuilder2.append(x(y0.g0()));
    }

    public static final void J(kotlin.i0.z.e.m0.h.d d, y0 y02, StringBuilder stringBuilder3) {
        d.I1(y02, stringBuilder3);
    }

    public static final void K(kotlin.i0.z.e.m0.h.d d, z0 z02, StringBuilder stringBuilder3, boolean z4) {
        d.N1(z02, stringBuilder3, z4);
    }

    public static final void L(kotlin.i0.z.e.m0.h.d d, c1 c12, boolean z3, StringBuilder stringBuilder4, boolean z5) {
        d.S1(c12, z3, stringBuilder4, z5);
    }

    private final void L1(StringBuilder stringBuilder, b0 b02, t0 t03) {
        final m0 m0Var = a1.a(b02);
        if (m0Var == null) {
            stringBuilder.append(K1(t03));
            stringBuilder.append(J1(b02.K0()));
        }
        z1(stringBuilder, m0Var);
    }

    private final void M(StringBuilder stringBuilder, m m2) {
        boolean mVar;
        boolean str;
        String str2;
        boolean z;
        boolean z2;
        Object obj6;
        if (!m2 instanceof f0) {
            if (m2 instanceof k0) {
            } else {
                if (m2 instanceof c0) {
                    stringBuilder.append(" is a module");
                }
                mVar = m2.b();
                if (mVar != null && !mVar instanceof c0) {
                    if (!mVar instanceof c0) {
                        str = " ";
                        stringBuilder.append(str);
                        stringBuilder.append(o1("defined in"));
                        stringBuilder.append(str);
                        c cVar = d.m(mVar);
                        n.e(cVar, "getFqName(containingDeclaration)");
                        if (cVar.e()) {
                            str2 = "root package";
                        } else {
                            str2 = v(cVar);
                        }
                        stringBuilder.append(str2);
                        if (I0() && mVar instanceof f0 && m2 instanceof p) {
                            if (mVar instanceof f0) {
                                if (m2 instanceof p) {
                                    obj6 = (p)m2.getSource().a().getName();
                                    if (obj6 == null) {
                                    } else {
                                        stringBuilder.append(str);
                                        stringBuilder.append(o1("in file"));
                                        stringBuilder.append(str);
                                        stringBuilder.append(obj6);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    private final String M0() {
        return Q(">");
    }

    static void M1(kotlin.i0.z.e.m0.h.d d, StringBuilder stringBuilder2, b0 b03, t0 t04, int i5, Object object6) {
        t0 obj3;
        if (i5 &= 2 != 0) {
            obj3 = b03.L0();
        }
        d.L1(stringBuilder2, b03, obj3);
    }

    private final void N(StringBuilder stringBuilder, List<? extends v0> list2) {
        d.c cVar = new d.c(this);
        p.f0(list2, stringBuilder, ", ", 0, 0, 0, 0, cVar, 60, 0);
    }

    private final boolean N0(b0 b0) {
        int obj2;
        if (!g.o(b0)) {
            if (!b0.getAnnotations().isEmpty()) {
                obj2 = 1;
            } else {
                obj2 = 0;
            }
        } else {
        }
        return obj2;
    }

    private final void N1(z0 z0, StringBuilder stringBuilder2, boolean z3) {
        String str;
        boolean str3;
        int size;
        int i;
        int str2;
        StringBuilder sb;
        Object obj11;
        if (z3) {
            stringBuilder2.append(Q0());
        }
        if (G0()) {
            stringBuilder2.append("/*");
            stringBuilder2.append(z0.getIndex());
            stringBuilder2.append("*/ ");
        }
        r1(stringBuilder2, z0.C(), "reified");
        String label = z0.l().getLabel();
        final int i2 = 0;
        str2 = 1;
        i = label.length() > 0 ? str2 : i2;
        r1(stringBuilder2, i, label);
        d.X0(this, stringBuilder2, z0, 0, 2, 0);
        s1(z0, stringBuilder2, z3);
        size = z0.getUpperBounds().size();
        String str6 = "upperBound";
        String str7 = " : ";
        if (size > str2) {
            if (z3) {
                if (size == str2) {
                    obj11 = z0.getUpperBounds().iterator().next();
                    if (!h.j0((b0)obj11)) {
                        stringBuilder2.append(str7);
                        n.e(obj11, str6);
                        stringBuilder2.append(x(obj11));
                    }
                } else {
                    if (z3) {
                        obj11 = z0.getUpperBounds().iterator();
                        while (obj11.hasNext()) {
                            size = obj11.next();
                            if (h.j0((b0)size) != null) {
                            } else {
                            }
                            if (str2 != null) {
                            } else {
                            }
                            stringBuilder2.append(" & ");
                            n.e(size, str6);
                            stringBuilder2.append(x(size));
                            str2 = i2;
                            stringBuilder2.append(str7);
                        }
                    }
                }
            } else {
            }
        } else {
        }
        if (z3) {
            stringBuilder2.append(M0());
        }
    }

    private final String O() {
        String str;
        int i;
        int i2 = d.b.a[B0().ordinal()];
        if (i2 != 1) {
            if (i2 != 2) {
            } else {
                str = "&rarr;";
                return str;
            }
            NoWhenBranchMatchedException noWhenBranchMatchedException = new NoWhenBranchMatchedException();
            throw noWhenBranchMatchedException;
        }
        str = Q("->");
    }

    private final z O0(y y) {
        m mVar;
        f fVar;
        z aBSTRACT;
        int i;
        Object iNTERFACE;
        Object fINAL;
        z obj4;
        if (y instanceof e) {
            obj4 = (e)y.f() == f.INTERFACE ? z.ABSTRACT : z.FINAL;
            return obj4;
        }
        if (mVar instanceof e) {
        } else {
            mVar = 0;
        }
        if (mVar == null) {
            return z.FINAL;
        }
        if (!y instanceof b) {
            return z.FINAL;
        }
        Collection collection = (b)y.e();
        n.e(collection, "this.overriddenDescriptors");
        if (empty ^= 1 != 0 && mVar.i() != z.FINAL) {
            if (mVar.i() != z.FINAL) {
                return z.OPEN;
            }
        }
        if (mVar.f() == f.INTERFACE && !n.b(y.getVisibility(), t.a)) {
            if (!n.b(y.getVisibility(), t.a)) {
                if (y.i() == z.ABSTRACT) {
                } else {
                    aBSTRACT = z.OPEN;
                }
            } else {
                aBSTRACT = z.FINAL;
            }
        } else {
        }
        return aBSTRACT;
    }

    private final void O1(StringBuilder stringBuilder, List<? extends z0> list2) {
        boolean next;
        int i;
        final Iterator obj4 = list2.iterator();
        while (obj4.hasNext()) {
            N1((z0)obj4.next(), stringBuilder, false);
            if (obj4.hasNext()) {
            }
            stringBuilder.append(", ");
        }
    }

    private final boolean P(String string, String string2) {
        boolean stringBuilder;
        int i;
        int str2;
        String str;
        boolean obj7;
        if (!n.b(string, l.G(string2, "?", "", false, 4, 0))) {
            str = "?";
            if (l.w(string2, str, false, 2, 0)) {
                if (!n.b(n.o(string, str), string2)) {
                    stringBuilder = new StringBuilder();
                    stringBuilder.append('(');
                    stringBuilder.append(string);
                    stringBuilder.append(")?");
                    if (n.b(stringBuilder.toString(), string2)) {
                        i = 1;
                    }
                } else {
                }
            } else {
            }
        } else {
        }
        return i;
    }

    private final boolean P0(c c) {
        return n.b(c.d(), k.a.y);
    }

    private final void P1(List<? extends z0> list, StringBuilder stringBuilder2, boolean z3) {
        int i;
        Object obj2;
        if (L0()) {
        }
        stringBuilder2.append(Q0());
        O1(stringBuilder2, list);
        stringBuilder2.append(M0());
        if (empty ^= 1 != 0 && z3) {
            stringBuilder2.append(Q0());
            O1(stringBuilder2, list);
            stringBuilder2.append(M0());
            if (z3) {
                stringBuilder2.append(" ");
            }
        }
    }

    private final String Q(String string) {
        return B0().escape(string);
    }

    private final String Q0() {
        return Q("<");
    }

    private final void Q1(d1 d1, StringBuilder stringBuilder2, boolean z3) {
        Object obj1;
        boolean obj3;
        if (!z3) {
            if (!d1 instanceof c1) {
                obj1 = d1.j0() ? "var" : "val";
                stringBuilder2.append(l1(obj1));
                stringBuilder2.append(" ");
            }
        } else {
        }
    }

    private final boolean R0(b b) {
        return obj1 ^= 1;
    }

    static void R1(kotlin.i0.z.e.m0.h.d d, d1 d12, StringBuilder stringBuilder3, boolean z4, int i5, Object object6) {
        int obj3;
        if (i5 &= 4 != 0) {
            obj3 = 0;
        }
        d.Q1(d12, stringBuilder3, obj3);
    }

    private final void S0(StringBuilder stringBuilder, a a2) {
        Object str;
        Object obj4;
        final kotlin.i0.z.e.m0.h.m hTML = m.HTML;
        if (B0() == hTML) {
            stringBuilder.append("<font color=\"808080\"><i>");
        }
        stringBuilder.append(" /* = ");
        u1(stringBuilder, a2.V());
        stringBuilder.append(" */");
        if (B0() == hTML) {
            stringBuilder.append("</i></font>");
        }
    }

    private final void S1(c1 c1, boolean z2, StringBuilder stringBuilder3, boolean z4) {
        String str3;
        boolean str;
        boolean z;
        a aVar;
        int i2;
        a str2;
        int valueOf;
        int i;
        Object obj10;
        l obj11;
        if (z4) {
            stringBuilder3.append(l1("value-parameter"));
            stringBuilder3.append(" ");
        }
        if (G0()) {
            stringBuilder3.append("/*");
            stringBuilder3.append(c1.getIndex());
            stringBuilder3.append("*/ ");
        }
        d.X0(this, stringBuilder3, c1, 0, 2, 0);
        r1(stringBuilder3, c1.b0(), "crossinline");
        r1(stringBuilder3, c1.X(), "noinline");
        int i3 = 0;
        if (v0()) {
            if (aVar instanceof d) {
            } else {
                aVar = valueOf;
            }
            if (aVar == null) {
            } else {
                valueOf = Boolean.valueOf(aVar.y());
            }
            i = n.b(valueOf, Boolean.TRUE) ? i2 : i3;
        } else {
        }
        if (i != 0) {
            r1(stringBuilder3, R(), "actual");
        }
        this.U1(c1, z2, stringBuilder3, z4, i);
        if (X() != null) {
            if (o()) {
                obj11 = c1.t0();
            } else {
                obj11 = a.a(c1);
            }
            if (obj11 != null) {
            } else {
                i2 = i3;
            }
        } else {
        }
        if (i2 != 0) {
            obj11 = X();
            n.d(obj11);
            stringBuilder3.append(n.o(" = ", obj11.invoke(c1)));
        }
    }

    private final void T0(n0 n0, StringBuilder stringBuilder2) {
        n1(n0, stringBuilder2);
    }

    private final void T1(Collection<? extends c1> collection, boolean z2, StringBuilder stringBuilder3) {
        int i;
        int i2;
        Object next;
        kotlin.i0.z.e.m0.h.c.l lVar;
        final int size = collection.size();
        F0().b(size, stringBuilder3);
        Iterator obj7 = collection.iterator();
        int i3 = 0;
        i = i3;
        for (c1 next : obj7) {
            F0().a(next, i, size, stringBuilder3);
            S1(next, Z1(z2), stringBuilder3, i3);
            F0().d(next, i, size, stringBuilder3);
            i = i2;
        }
        F0().c(size, stringBuilder3);
    }

    private final void U0(x x, StringBuilder stringBuilder2) {
        int i2;
        int z;
        Collection iterator2;
        int str;
        boolean iterator;
        int i;
        boolean empty;
        Collection next;
        str = "functionDescriptor.overriddenDescriptors";
        i = 0;
        int i3 = 1;
        if (x.P()) {
            iterator2 = x.e();
            n.e(iterator2, str);
            if (iterator2.isEmpty()) {
                z = i3;
            } else {
                iterator2 = iterator2.iterator();
                for (x next3 : iterator2) {
                }
            }
            if (z == 0) {
                i2 = S() ? i3 : i;
            } else {
            }
        } else {
        }
        if (x.E0()) {
            next = x.e();
            n.e(next, str);
            if (next.isEmpty()) {
                str = i3;
            } else {
                iterator = next.iterator();
                for (x next2 : iterator) {
                }
            }
            if (str == null) {
                if (S()) {
                    i = i3;
                }
            } else {
            }
        }
        r1(stringBuilder2, x.O(), "tailrec");
        H1(x, stringBuilder2);
        r1(stringBuilder2, x.r(), "inline");
        r1(stringBuilder2, i, "infix");
        r1(stringBuilder2, i2, "operator");
    }

    private final void U1(d1 d1, boolean z2, StringBuilder stringBuilder3, boolean z4, boolean z5) {
        Object obj;
        b0 b0Var;
        int i2;
        int i;
        boolean obj6;
        String obj7;
        final b0 type = d1.getType();
        n.e(type, "variable.type");
        if (d1 instanceof c1) {
            obj = d1;
        } else {
            obj = i2;
        }
        if (obj == null) {
        } else {
            i2 = obj.l0();
        }
        b0Var = i2 == 0 ? type : i2;
        i = i2 != 0 ? 1 : 0;
        r1(stringBuilder3, i, "vararg");
        if (!z5) {
            if (z4 && !A0()) {
                if (!A0()) {
                    Q1(d1, stringBuilder3, z5);
                }
            }
        } else {
        }
        if (z2 != null) {
            s1(d1, stringBuilder3, z4);
            stringBuilder3.append(": ");
        }
        stringBuilder3.append(x(b0Var));
        k1(d1, stringBuilder3);
        if (G0() && i2 != 0) {
            if (i2 != 0) {
                stringBuilder3.append(" /*");
                stringBuilder3.append(x(type));
                stringBuilder3.append("*/");
            }
        }
    }

    private final List<String> V0(c c) {
        int string;
        String str2;
        int i;
        boolean next2;
        int name;
        boolean next;
        int i2;
        boolean contains;
        int stringBuilder;
        String str;
        int obj8;
        Map map = c.a();
        i = 0;
        if (s0()) {
            obj8 = a.f(c);
        } else {
            obj8 = i;
        }
        if (obj8 == null) {
            obj8 = i;
        } else {
        }
        int i3 = 10;
        if (obj8 == null) {
        } else {
            ArrayList arrayList2 = new ArrayList();
            obj8 = obj8.iterator();
            while (obj8.hasNext()) {
                next2 = obj8.next();
                if ((c1)next2.t0()) {
                }
                arrayList2.add(next2);
            }
            obj8 = new ArrayList(p.r(arrayList2, i3));
            Iterator iterator = arrayList2.iterator();
            for (c1 next6 : iterator) {
                obj8.add(next6.getName());
            }
            i = obj8;
        }
        if (i != 0) {
        } else {
            i = p.g();
        }
        obj8 = new ArrayList();
        Iterator iterator2 = i.iterator();
        while (iterator2.hasNext()) {
            next = iterator2.next();
            Object obj2 = next;
            n.e((e)obj2, "it");
            if (key2 ^= 1 != 0) {
            }
            obj8.add(next);
        }
        ArrayList arrayList3 = new ArrayList(p.r(obj8, i3));
        obj8 = obj8.iterator();
        for (e next8 : obj8) {
            arrayList3.add(n.o(next8.c(), " = ..."));
        }
        obj8 = map.entrySet();
        ArrayList arrayList = new ArrayList(p.r(obj8, i3));
        obj8 = obj8.iterator();
        while (obj8.hasNext()) {
            Object next4 = obj8.next();
            Object key = (Map.Entry)next4.getKey();
            stringBuilder = new StringBuilder();
            stringBuilder.append((e)key.c());
            stringBuilder.append(" = ");
            if (!i.contains(key)) {
            } else {
            }
            str2 = "...";
            stringBuilder.append(str2);
            arrayList.add(stringBuilder.toString());
            str2 = d1((g)next4.getValue());
        }
        return p.C0(p.t0(arrayList3, arrayList));
    }

    private final boolean V1(u u, StringBuilder stringBuilder2) {
        boolean z;
        u obj3;
        int i = 0;
        if (!g0().contains(e.VISIBILITY)) {
            return i;
        }
        if (h0()) {
            obj3 = u.f();
        }
        if (!u0() && n.b(obj3, t.k)) {
            if (n.b(obj3, t.k)) {
                return i;
            }
        }
        stringBuilder2.append(l1(obj3.c()));
        stringBuilder2.append(" ");
        return 1;
    }

    private final void W0(StringBuilder stringBuilder, a a2, e e3) {
        Set set;
        Object next;
        boolean booleanValue;
        if (!g0().contains(e.ANNOTATIONS)) {
        }
        if (a2 instanceof b0) {
            set = n();
        } else {
            set = Z();
        }
        l lVar = T();
        Iterator obj6 = a2.getAnnotations().iterator();
        while (obj6.hasNext()) {
            next = obj6.next();
            if (!p.N(set, (c)next.d()) && !P0(next)) {
            }
            if (!P0(next)) {
            }
            if (lVar != null) {
            } else {
            }
            stringBuilder.append(s(next, e3));
            if (Y()) {
            } else {
            }
            stringBuilder.append(" ");
            stringBuilder.append('\n');
            n.e(stringBuilder, "append('\\n')");
            if ((Boolean)lVar.invoke(next).booleanValue()) {
            }
        }
    }

    private final void W1(List<? extends z0> list, StringBuilder stringBuilder2) {
        int i;
        Object next2;
        boolean next;
        Iterator iterator;
        int str3;
        boolean next3;
        List upperBounds;
        String stringBuilder;
        int str2;
        int str;
        int i4;
        int i3;
        int i2;
        int obj12;
        if (L0()) {
        }
        i = 0;
        ArrayList arrayList = new ArrayList(i);
        obj12 = list.iterator();
        str3 = 1;
        for (z0 next2 : obj12) {
            upperBounds = next2.getUpperBounds();
            n.e(upperBounds, "typeParameter.upperBounds");
            iterator = p.P(upperBounds, str3).iterator();
            for (b0 next4 : iterator) {
                stringBuilder = new StringBuilder();
                e name = next2.getName();
                n.e(name, "typeParameter.name");
                stringBuilder.append(w(name, i));
                stringBuilder.append(" : ");
                n.e(next4, "it");
                stringBuilder.append(x(next4));
                arrayList.add(stringBuilder.toString());
            }
            str3 = 1;
            Object next4 = iterator.next();
            stringBuilder = new StringBuilder();
            name = next2.getName();
            n.e(name, "typeParameter.name");
            stringBuilder.append(w(name, i));
            stringBuilder.append(" : ");
            n.e((b0)next4, "it");
            stringBuilder.append(x(next4));
            arrayList.add(stringBuilder.toString());
        }
        if (obj12 ^= str3 != 0) {
            obj12 = " ";
            stringBuilder2.append(obj12);
            stringBuilder2.append(l1("where"));
            stringBuilder2.append(obj12);
            p.f0(arrayList, stringBuilder2, ", ", 0, 0, 0, 0, 0, 124, 0);
        }
    }

    static void X0(kotlin.i0.z.e.m0.h.d d, StringBuilder stringBuilder2, a a3, e e4, int i5, Object object6) {
        int obj3;
        if (i5 &= 2 != 0) {
            obj3 = 0;
        }
        d.W0(stringBuilder2, a3, obj3);
    }

    private final String X1(String string, String string2, String string3, String string4, String string5) {
        int str;
        String obj5;
        String obj6;
        String obj7;
        String obj8;
        str = 0;
        final int i = 2;
        final int i2 = 0;
        str = "null cannot be cast to non-null type java.lang.String";
        Objects.requireNonNull(string, str);
        obj5 = string.substring(string2.length());
        obj6 = "(this as java.lang.String).substring(startIndex)";
        n.e(obj5, obj6);
        Objects.requireNonNull(string3, str);
        obj7 = string3.substring(string4.length());
        n.e(obj7, obj6);
        obj6 = n.o(string5, obj5);
        if (l.M(string, string2, str, i, i2) && l.M(string3, string4, str, i, i2) && n.b(obj5, obj7)) {
            if (l.M(string3, string4, str, i, i2)) {
                str = "null cannot be cast to non-null type java.lang.String";
                Objects.requireNonNull(string, str);
                obj5 = string.substring(string2.length());
                obj6 = "(this as java.lang.String).substring(startIndex)";
                n.e(obj5, obj6);
                Objects.requireNonNull(string3, str);
                obj7 = string3.substring(string4.length());
                n.e(obj7, obj6);
                obj6 = n.o(string5, obj5);
                if (n.b(obj5, obj7)) {
                    return obj6;
                }
                if (P(obj5, obj7)) {
                    return n.o(obj6, "!");
                }
            }
        }
        return i2;
    }

    private final void Y0(i i, StringBuilder stringBuilder2) {
        List size2;
        boolean size;
        boolean obj4;
        size2 = i.t();
        n.e(size2, "classifier.declaredTypeParameters");
        List parameters = i.g().getParameters();
        n.e(parameters, "classifier.typeConstructor.parameters");
        if (G0() && i.k() && parameters.size() > size2.size()) {
            if (i.k()) {
                if (parameters.size() > size2.size()) {
                    stringBuilder2.append(" /*captured type parameters: ");
                    O1(stringBuilder2, parameters.subList(size2.size(), parameters.size()));
                    stringBuilder2.append("*/");
                }
            }
        }
    }

    private final boolean Y1(b0 b0) {
        boolean empty;
        int i;
        b0 obj4;
        final int i2 = 1;
        if (g.m(b0)) {
            obj4 = b0.K0();
            if (obj4 instanceof Collection != null && obj4.isEmpty()) {
                if (obj4.isEmpty()) {
                    obj4 = i2;
                } else {
                    obj4 = obj4.iterator();
                    for (v0 next : obj4) {
                    }
                }
            } else {
            }
            if (obj4 != null) {
                i = i2;
            }
        }
        return i;
    }

    private final void Z0(e e, StringBuilder stringBuilder2) {
        int i3;
        boolean visibility;
        Enum singleton2;
        int i;
        boolean contains5;
        int i8;
        boolean contains;
        int i2;
        int i7;
        boolean contains4;
        boolean contains3;
        boolean contains2;
        boolean z;
        boolean singleton;
        int i4;
        int str;
        Object str2;
        Enum iNTERFACE;
        String str3;
        StringBuilder sb;
        a aVar;
        int i5;
        int i6;
        int i9;
        i4 = 1;
        str = 0;
        i3 = e.f() == f.ENUM_ENTRY ? i4 : str;
        d.X0(this, stringBuilder2, e, 0, 2, 0);
        if (!A0() && i3 == 0) {
            d.X0(this, stringBuilder2, e, 0, 2, 0);
            if (i3 == 0) {
                visibility = e.getVisibility();
                n.e(visibility, "klass.visibility");
                V1(visibility, stringBuilder2);
            }
            if (e.f() == f.INTERFACE) {
                if (e.i() != z.ABSTRACT) {
                    if (e.f().isSingleton()) {
                        if (e.i() != z.FINAL) {
                            singleton2 = e.i();
                            n.e(singleton2, "klass.modality");
                            p1(singleton2, stringBuilder2, O0(e));
                        }
                    } else {
                    }
                }
            } else {
            }
            n1(e, stringBuilder2);
            if (g0().contains(e.INNER) && e.k()) {
                i = e.k() ? i4 : str;
            } else {
            }
            r1(stringBuilder2, i, "inner");
            if (g0().contains(e.DATA) && e.G0()) {
                i8 = e.G0() ? i4 : str;
            } else {
            }
            r1(stringBuilder2, i8, "data");
            if (g0().contains(e.INLINE) && e.r()) {
                i2 = e.r() ? i4 : str;
            } else {
            }
            r1(stringBuilder2, i2, "inline");
            if (g0().contains(e.VALUE) && e.I()) {
                i7 = e.I() ? i4 : str;
            } else {
            }
            r1(stringBuilder2, i7, "value");
            if (g0().contains(e.FUN) && e.A()) {
                visibility = e.A() ? i4 : str;
            } else {
            }
            r1(stringBuilder2, visibility, "fun");
            a1(e, stringBuilder2);
        }
        if (!d.x(e)) {
            if (!A0()) {
                F1(stringBuilder2);
            }
            s1(e, stringBuilder2, i4);
        } else {
            c1(e, stringBuilder2);
        }
        if (i3 != 0) {
        }
        List list = e.t();
        n.e(list, "klass.declaredTypeParameters");
        P1(list, stringBuilder2, str);
        Y0(e, stringBuilder2);
        singleton = e.Q();
        if (!e.f().isSingleton() && V() && singleton != null) {
            if (V()) {
                singleton = e.Q();
                if (singleton != null) {
                    stringBuilder2.append(" ");
                    d.X0(this, stringBuilder2, singleton, 0, 2, 0);
                    u visibility2 = singleton.getVisibility();
                    n.e(visibility2, "primaryConstructor.visibility");
                    V1(visibility2, stringBuilder2);
                    stringBuilder2.append(l1("constructor"));
                    i4 = singleton.h();
                    n.e(i4, "primaryConstructor.valueParameters");
                    T1(i4, singleton.D(), stringBuilder2);
                }
            }
        }
        G1(e, stringBuilder2);
        W1(list, stringBuilder2);
    }

    private final boolean Z1(boolean z) {
        int i;
        int i2;
        int obj5;
        int i3 = d.b.b[k0().ordinal()];
        i = 0;
        final int i4 = 1;
        if (i3 != i4) {
            if (i3 != 2) {
                if (i3 != 3) {
                } else {
                }
                obj5 = new NoWhenBranchMatchedException();
                throw obj5;
            }
            if (z == 0) {
                i = i4;
            }
        } else {
        }
        return i;
    }

    private final kotlin.i0.z.e.m0.h.d a0() {
        return (d)this.e.getValue();
    }

    private final void a1(e e, StringBuilder stringBuilder2) {
        stringBuilder2.append(l1(c.a.a(e)));
    }

    private final void c1(m m, StringBuilder stringBuilder2) {
        boolean z2;
        boolean z;
        boolean str;
        int i;
        String obj3;
        if (p0() && A0()) {
            if (A0()) {
                stringBuilder2.append("companion object");
            }
            F1(stringBuilder2);
            z2 = m.b();
            if (z2 != null) {
                stringBuilder2.append("of ");
                e name2 = z2.getName();
                n.e(name2, "containingDeclaration.name");
                stringBuilder2.append(w(name2, false));
            }
        }
        if (!G0()) {
            if (!n.b(m.getName(), g.b) && !A0()) {
                if (!A0()) {
                    F1(stringBuilder2);
                }
                obj3 = m.getName();
                n.e(obj3, "descriptor.name");
                stringBuilder2.append(w(obj3, true));
            }
        } else {
        }
    }

    private final String d1(g<?> g) {
        Object stringBuilder;
        String str3;
        String str2;
        Object stringBuilder2;
        int str;
        int i2;
        kotlin.i0.z.e.m0.h.d.e eVar;
        int i3;
        int i;
        String obj10;
        if (g instanceof b) {
            eVar = new d.e(this);
            obj10 = p.h0((Iterable)(b)g.b(), ", ", "{", "}", 0, 0, eVar, 24, 0);
        } else {
            if (g instanceof a) {
                str3 = 0;
                obj10 = l.u0(c.t(this, (c)(a)g.b(), str3, 2, str3), "@");
            } else {
                if (g instanceof q) {
                    obj10 = (q)g.b();
                    str3 = "::class";
                    if (obj10 instanceof q.b.a) {
                        stringBuilder = new StringBuilder();
                        stringBuilder.append((q.b.a)(q.b)obj10.a());
                        stringBuilder.append(str3);
                        obj10 = stringBuilder.toString();
                    } else {
                        if (!obj10 instanceof q.b.b) {
                        } else {
                            n.e((q.b.b)obj10.b().b().b(), "classValue.classId.asSingleFqName().asString()");
                            str2 = 0;
                            while (str2 < obj10.a()) {
                                stringBuilder2 = new StringBuilder();
                                stringBuilder2.append("kotlin.Array<");
                                stringBuilder2.append(stringBuilder);
                                stringBuilder2.append('>');
                                stringBuilder = stringBuilder2.toString();
                                str2++;
                            }
                            obj10 = n.o(stringBuilder, str3);
                        }
                    }
                    obj10 = new NoWhenBranchMatchedException();
                    throw obj10;
                }
                obj10 = g.toString();
            }
        }
        return obj10;
    }

    private final void e1(l l, StringBuilder stringBuilder2) {
        boolean z3;
        int i;
        int typeParameters;
        boolean z4;
        boolean typeParameters2;
        int sEALED;
        boolean z2;
        i next2;
        String next;
        boolean z;
        Object str4;
        ArrayList arrayList;
        String str;
        String str3;
        String str2;
        int i2;
        int i4;
        kotlin.i0.z.e.m0.h.d.f fVar;
        int i5;
        int i3;
        final Object obj = this;
        final StringBuilder sb2 = stringBuilder2;
        d.X0(this, stringBuilder2, l, 0, 2, 0);
        int i6 = 0;
        int i7 = 1;
        if (!obj.d.T()) {
            u visibility = l.getVisibility();
            n.e(visibility, "constructor.visibility");
            if (l.z().i() != z.SEALED && obj.V1(visibility, sb2)) {
                visibility = l.getVisibility();
                n.e(visibility, "constructor.visibility");
                i = obj.V1(visibility, sb2) ? i7 : i6;
            } else {
            }
        } else {
        }
        m1(l, stringBuilder2);
        if (!r0() && l.y()) {
            if (l.y()) {
                if (i != 0) {
                    typeParameters = i7;
                } else {
                    typeParameters = i6;
                }
            } else {
            }
        } else {
        }
        if (typeParameters != 0) {
            sb2.append(obj.l1("constructor"));
        }
        next2 = l.b();
        n.e(next2, "constructor.containingDeclaration");
        String str11 = "constructor.typeParameters";
        if (y0() && typeParameters != 0) {
            if (typeParameters != 0) {
                sb2.append(" ");
            }
            obj.s1(next2, sb2, i7);
            typeParameters = l.getTypeParameters();
            n.e(typeParameters, str11);
            obj.P1(typeParameters, sb2, i6);
        }
        List list = l.h();
        n.e(list, "constructor.valueParameters");
        obj.T1(list, l.D(), sb2);
        z4 = (e)next2.Q();
        if (q0() && !l.y() && next2 instanceof e && z4 != null) {
            if (!l.y()) {
                if (next2 instanceof e) {
                    z4 = (e)next2.Q();
                    if (z4 != null) {
                        List list2 = z4.h();
                        n.e(list2, "primaryConstructor.valueParameters");
                        arrayList = new ArrayList();
                        Iterator iterator = list2.iterator();
                        while (iterator.hasNext()) {
                            next = iterator.next();
                            str4 = next;
                            if (!(c1)str4.t0() && str4.l0() == null) {
                            } else {
                            }
                            z = i6;
                            if (z) {
                            }
                            arrayList.add(next);
                            if (str4.l0() == null) {
                            } else {
                            }
                            z = i7;
                        }
                        if (empty ^= i7 != 0) {
                            sb2.append(" : ");
                            sb2.append(obj.l1("this"));
                            sb2.append(p.h0(arrayList, ", ", "(", ")", 0, 0, d.f.a, 24, 0));
                        }
                    }
                }
            }
        }
        if (y0()) {
            typeParameters2 = l.getTypeParameters();
            n.e(typeParameters2, str11);
            obj.W1(typeParameters2, sb2);
        }
    }

    private final void f1(StringBuilder stringBuilder, b0 b02) {
        boolean z3;
        boolean z;
        String string;
        boolean z2;
        boolean str;
        Object sb;
        Object aVar;
        b0 i4;
        int i2;
        int i3;
        int i;
        boolean obj9;
        d.X0(this, stringBuilder, b02, 0, 2, 0);
        if (d0.a(b02)) {
            if (b02 instanceof f1 && m0()) {
                if (m0()) {
                    stringBuilder.append((f1)b02.U0());
                } else {
                    if (b02 instanceof s && !f0()) {
                        if (!f0()) {
                            stringBuilder.append((s)b02.U0());
                        } else {
                            stringBuilder.append(b02.L0().toString());
                        }
                    } else {
                    }
                }
            } else {
            }
            stringBuilder.append(J1(b02.K0()));
        } else {
            d.M1(this, stringBuilder, b02, 0, 2, 0);
        }
        if (b02.M0()) {
            stringBuilder.append("?");
        }
        if (l0.c(b02)) {
            stringBuilder.append("!!");
        }
    }

    private final String g1(String string) {
        int stringBuilder;
        int str;
        String obj3;
        stringBuilder = d.b.a[B0().ordinal()];
        if (stringBuilder != 1) {
            if (stringBuilder != 2) {
            } else {
                stringBuilder = new StringBuilder();
                stringBuilder.append("<font color=red><b>");
                stringBuilder.append(string);
                stringBuilder.append("</b></font>");
                obj3 = stringBuilder.toString();
            }
            obj3 = new NoWhenBranchMatchedException();
            throw obj3;
        }
        return obj3;
    }

    private final String h1(List<e> list) {
        return Q(n.c(list));
    }

    private final void i1(x x, StringBuilder stringBuilder2) {
        boolean str3;
        boolean str;
        boolean typeParameters;
        String returnType;
        boolean str2;
        String str4;
        StringBuilder sb;
        a aVar;
        int i2;
        int i;
        int i3;
        final String str8 = "function.typeParameters";
        int i4 = 1;
        d.X0(this, stringBuilder2, x, 0, 2, 0);
        u visibility = x.getVisibility();
        n.e(visibility, "function.visibility");
        V1(visibility, stringBuilder2);
        q1(x, stringBuilder2);
        if (!A0() && !z0() && b0()) {
            if (!z0()) {
                d.X0(this, stringBuilder2, x, 0, 2, 0);
                visibility = x.getVisibility();
                n.e(visibility, "function.visibility");
                V1(visibility, stringBuilder2);
                q1(x, stringBuilder2);
                if (b0()) {
                    n1(x, stringBuilder2);
                }
                v1(x, stringBuilder2);
                if (b0()) {
                    U0(x, stringBuilder2);
                } else {
                    H1(x, stringBuilder2);
                }
                m1(x, stringBuilder2);
                if (G0() && x.v0()) {
                    if (x.v0()) {
                        stringBuilder2.append("/*isHiddenToOvercomeSignatureClash*/ ");
                    }
                    if (x.z0()) {
                        stringBuilder2.append("/*isHiddenForResolutionEverywhereBesideSupercalls*/ ");
                    }
                }
            }
            stringBuilder2.append(l1("fun"));
            stringBuilder2.append(" ");
            typeParameters = x.getTypeParameters();
            n.e(typeParameters, str8);
            P1(typeParameters, stringBuilder2, i4);
            C1(x, stringBuilder2);
        }
        s1(x, stringBuilder2, i4);
        List list = x.h();
        n.e(list, "function.valueParameters");
        T1(list, x.D(), stringBuilder2);
        D1(x, stringBuilder2);
        returnType = x.getReturnType();
        if (!J0()) {
            if (!E0() && returnType != null) {
                if (returnType != null) {
                    if (!h.J0(returnType)) {
                        stringBuilder2.append(": ");
                        if (returnType == null) {
                            returnType = "[NULL]";
                        } else {
                            returnType = x(returnType);
                        }
                        stringBuilder2.append(returnType);
                    }
                } else {
                }
            } else {
            }
        }
        final List obj10 = x.getTypeParameters();
        n.e(obj10, str8);
        W1(obj10, stringBuilder2);
    }

    private final void j1(StringBuilder stringBuilder, b0 b02) {
        int charAt;
        int str3;
        boolean z;
        int i;
        int str;
        int str2;
        boolean z2;
        b0 next;
        int i2;
        String str4;
        Object obj11;
        charAt = stringBuilder.length();
        d.X0(a0(), stringBuilder, b02, 0, 2, 0);
        i = 1;
        int i6 = 0;
        str3 = stringBuilder.length() != charAt ? i : i6;
        z2 = g.o(b02);
        boolean z4 = b02.M0();
        next = g.h(b02);
        if (!z4) {
            if (str3 != null && next != null) {
                if (next != null) {
                    i2 = i;
                } else {
                    i2 = i6;
                }
            } else {
            }
        } else {
        }
        str4 = "(";
        if (i2 != 0) {
            if (z2) {
                stringBuilder.insert(charAt, '(');
            } else {
                char c = l.d1(stringBuilder);
                int i5 = 32;
                if (str3 != null && stringBuilder.charAt(i3 -= i) != 41) {
                    c = l.d1(stringBuilder);
                    i5 = 32;
                    if (stringBuilder.charAt(i3 -= i) != 41) {
                        stringBuilder.insert(l.Y(stringBuilder), "()");
                    }
                }
                stringBuilder.append(str4);
            }
        }
        r1(stringBuilder, z2, "suspend");
        String str6 = ")";
        if (next != null) {
            if (Y1(next)) {
                if (next.M0()) {
                    if (N0(next)) {
                    } else {
                        i = i6;
                    }
                }
            } else {
            }
            if (i != 0) {
                stringBuilder.append(str4);
            }
            t1(stringBuilder, next);
            if (i != 0) {
                stringBuilder.append(str6);
            }
            stringBuilder.append(".");
        }
        stringBuilder.append(str4);
        Iterator iterator = g.j(b02).iterator();
        str = i6;
        while (iterator.hasNext()) {
            next = iterator.next();
            if (str > 0) {
            }
            if (l0()) {
            } else {
            }
            str2 = 0;
            if (str2 != null) {
            }
            stringBuilder.append(y((v0)next));
            str = z2;
            stringBuilder.append(w(str2, i6));
            stringBuilder.append(": ");
            b0 type = next.getType();
            n.e(type, "typeProjection.type");
            str2 = g.c(type);
            stringBuilder.append(", ");
        }
        stringBuilder.append(") ");
        stringBuilder.append(O());
        stringBuilder.append(" ");
        t1(stringBuilder, g.i(b02));
        if (i2 != 0) {
            stringBuilder.append(str6);
        }
        if (z4) {
            stringBuilder.append("?");
        }
    }

    private final void k1(d1 d1, StringBuilder stringBuilder2) {
        boolean str;
        Object obj2;
        if (e0()) {
            obj2 = d1.W();
            if (obj2 == null) {
            } else {
                stringBuilder2.append(" = ");
                stringBuilder2.append(Q(d1(obj2)));
            }
        }
    }

    private final String l1(String string) {
        int stringBuilder;
        int str;
        String obj3;
        stringBuilder = d.b.a[B0().ordinal()];
        if (stringBuilder != 1) {
            if (stringBuilder != 2) {
            } else {
                if (U()) {
                } else {
                    stringBuilder = new StringBuilder();
                    stringBuilder.append("<b>");
                    stringBuilder.append(string);
                    stringBuilder.append("</b>");
                    obj3 = stringBuilder.toString();
                }
            }
            obj3 = new NoWhenBranchMatchedException();
            throw obj3;
        }
        return obj3;
    }

    private final void m1(b b, StringBuilder stringBuilder2) {
        boolean str;
        Enum mEMBER_KIND;
        String obj3;
        if (!g0().contains(e.MEMBER_KIND)) {
        }
        if (G0() && b.f() != b.a.DECLARATION) {
            if (b.f() != b.a.DECLARATION) {
                stringBuilder2.append("/*");
                obj3 = b.f().name();
                Objects.requireNonNull(obj3, "null cannot be cast to non-null type java.lang.String");
                obj3 = obj3.toLowerCase();
                n.e(obj3, "(this as java.lang.String).toLowerCase()");
                stringBuilder2.append(obj3);
                stringBuilder2.append("*/ ");
            }
        }
    }

    private final void n1(y y, StringBuilder stringBuilder2) {
        boolean contains;
        int i2;
        int i;
        boolean obj5;
        r1(stringBuilder2, y.w(), "external");
        final int i3 = 0;
        if (g0().contains(e.EXPECT) && y.L()) {
            i2 = y.L() ? i : i3;
        } else {
        }
        r1(stringBuilder2, i2, "expect");
        if (g0().contains(e.ACTUAL) && y.B0()) {
            if (y.B0()) {
            } else {
                i = i3;
            }
        } else {
        }
        r1(stringBuilder2, i, "actual");
    }

    private final void p1(z z, StringBuilder stringBuilder2, z z3) {
        if (!t0() && z == z3) {
            if (z == z3) {
            }
        }
        String obj2 = z.name();
        Objects.requireNonNull(obj2, "null cannot be cast to non-null type java.lang.String");
        obj2 = obj2.toLowerCase();
        n.e(obj2, "(this as java.lang.String).toLowerCase()");
        r1(stringBuilder2, g0().contains(e.MODALITY), obj2);
    }

    private final void q1(b b, StringBuilder stringBuilder2) {
        z z;
        kotlin.i0.z.e.m0.h.j jVar;
        Object fINAL;
        Enum rENDER_OVERRIDE;
        Object obj3;
        if (d.J(b)) {
            if (b.i() != z.FINAL && j0() == j.RENDER_OVERRIDE && b.i() == z.OPEN && R0(b)) {
                if (j0() == j.RENDER_OVERRIDE) {
                    if (b.i() == z.OPEN) {
                        if (R0(b)) {
                        }
                    }
                }
                z = b.i();
                n.e(z, "callable.modality");
                p1(z, stringBuilder2, O0(b));
            }
        } else {
        }
    }

    private final void r1(StringBuilder stringBuilder, boolean z2, String string3) {
        String obj2;
        if (z2 != null) {
            stringBuilder.append(l1(string3));
            stringBuilder.append(" ");
        }
    }

    private final void s1(m m, StringBuilder stringBuilder2, boolean z3) {
        e obj2 = m.getName();
        n.e(obj2, "descriptor.name");
        stringBuilder2.append(w(obj2, z3));
    }

    private final void t1(StringBuilder stringBuilder, b0 b02) {
        int g1Var;
        boolean obj4;
        if (g1Var instanceof a) {
        } else {
            g1Var = 0;
        }
        if (g1Var != 0) {
            if (w0()) {
                u1(stringBuilder, g1Var.V());
            } else {
                u1(stringBuilder, g1Var.X0());
                if (x0()) {
                    S0(stringBuilder, g1Var);
                }
            }
        }
        u1(stringBuilder, b02);
    }

    private final void u1(StringBuilder stringBuilder, b0 b02) {
        boolean z;
        boolean z2;
        Object obj3;
        if (b02 instanceof i1 && o() && !(i1)b02.Q0()) {
            if (o()) {
                if (!(i1)b02.Q0()) {
                    stringBuilder.append("<Not computed yet>");
                }
            }
        }
        obj3 = b02.O0();
        if (obj3 instanceof v) {
            stringBuilder.append((v)obj3.V0(this, this));
        } else {
            if (obj3 instanceof i0) {
                E1(stringBuilder, (i0)obj3);
            }
        }
    }

    private final void v1(b b, StringBuilder stringBuilder2) {
        boolean str;
        Object rENDER_OPEN;
        Object obj3;
        if (!g0().contains(e.OVERRIDE)) {
        }
        r1(stringBuilder2, true, "override");
        if (R0(b) && j0() != j.RENDER_OPEN && G0()) {
            if (j0() != j.RENDER_OPEN) {
                r1(stringBuilder2, true, "override");
                if (G0()) {
                    stringBuilder2.append("/*");
                    stringBuilder2.append(b.e().size());
                    stringBuilder2.append("*/ ");
                }
            }
        }
    }

    private final void w1(f0 f0, StringBuilder stringBuilder2) {
        boolean z;
        c0 obj3;
        x1(f0.d(), "package-fragment", stringBuilder2);
        if (o()) {
            stringBuilder2.append(" in ");
            s1(f0.b(), stringBuilder2, false);
        }
    }

    private final void x1(b b, String string2, StringBuilder stringBuilder3) {
        int obj2;
        stringBuilder3.append(l1(string2));
        c obj1 = b.j();
        n.e(obj1, "fqName.toUnsafe()");
        obj1 = v(obj1);
        obj2 = obj1.length() > 0 ? 1 : 0;
        if (obj2 != null) {
            stringBuilder3.append(" ");
            stringBuilder3.append(obj1);
        }
    }

    private final void y1(k0 k0, StringBuilder stringBuilder2) {
        boolean z;
        c0 obj3;
        x1(k0.d(), "package", stringBuilder2);
        if (o()) {
            stringBuilder2.append(" in context of ");
            s1(k0.u0(), stringBuilder2, false);
        }
    }

    private final void z1(StringBuilder stringBuilder, m0 m02) {
        int i;
        int str;
        m0 m0Var = m02.c();
        if (m0Var == null) {
            i = 0;
        } else {
            z1(stringBuilder, m0Var);
            stringBuilder.append('.');
            e name = m02.b().getName();
            n.e(name, "possiblyInnerType.classifierDescriptor.name");
            stringBuilder.append(w(name, false));
            i = stringBuilder;
        }
        if (i == 0) {
            t0 t0Var = m02.b().g();
            n.e(t0Var, "possiblyInnerType.classifierDescriptor.typeConstructor");
            stringBuilder.append(K1(t0Var));
        }
        stringBuilder.append(J1(m02.a()));
    }

    @Override // kotlin.i0.z.e.m0.h.c
    public boolean A0() {
        return this.d.Z();
    }

    @Override // kotlin.i0.z.e.m0.h.c
    public kotlin.i0.z.e.m0.h.m B0() {
        return this.d.a0();
    }

    public l<b0, b0> C0() {
        return this.d.b0();
    }

    @Override // kotlin.i0.z.e.m0.h.c
    public boolean D0() {
        return this.d.c0();
    }

    @Override // kotlin.i0.z.e.m0.h.c
    public boolean E0() {
        return this.d.d0();
    }

    @Override // kotlin.i0.z.e.m0.h.c
    public kotlin.i0.z.e.m0.h.c.l F0() {
        return this.d.e0();
    }

    @Override // kotlin.i0.z.e.m0.h.c
    public boolean G0() {
        return this.d.f0();
    }

    @Override // kotlin.i0.z.e.m0.h.c
    public boolean H0() {
        return this.d.g0();
    }

    @Override // kotlin.i0.z.e.m0.h.c
    public boolean I0() {
        return this.d.h0();
    }

    @Override // kotlin.i0.z.e.m0.h.c
    public boolean J0() {
        return this.d.i0();
    }

    public String J1(List<? extends v0> list) {
        boolean empty;
        String str;
        String obj3;
        n.f(list, "typeArguments");
        if (list.isEmpty()) {
            obj3 = "";
        } else {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(Q0());
            N(stringBuilder, list);
            stringBuilder.append(M0());
            n.e(stringBuilder.toString(), "StringBuilder().apply(builderAction).toString()");
        }
        return obj3;
    }

    @Override // kotlin.i0.z.e.m0.h.c
    public boolean K0() {
        return this.d.j0();
    }

    @Override // kotlin.i0.z.e.m0.h.c
    public String K1(t0 t0) {
        boolean z;
        boolean i;
        String obj4;
        n.f(t0, "typeConstructor");
        h hVar = t0.c();
        z = hVar instanceof z0 ? i : hVar instanceof e;
        if (z) {
        } else {
            i = hVar instanceof y0;
        }
        if (i) {
            obj4 = b1(hVar);
            return obj4;
        } else {
            if (hVar != null) {
            } else {
                obj4 = t0.toString();
            }
        }
        IllegalStateException illegalStateException = new IllegalStateException(n.o("Unexpected classifier: ", hVar.getClass()).toString());
        throw illegalStateException;
    }

    @Override // kotlin.i0.z.e.m0.h.c
    public boolean L0() {
        return this.d.k0();
    }

    @Override // kotlin.i0.z.e.m0.h.c
    public boolean R() {
        return this.d.s();
    }

    @Override // kotlin.i0.z.e.m0.h.c
    public boolean S() {
        return this.d.t();
    }

    public l<c, Boolean> T() {
        return this.d.u();
    }

    @Override // kotlin.i0.z.e.m0.h.c
    public boolean U() {
        return this.d.v();
    }

    @Override // kotlin.i0.z.e.m0.h.c
    public boolean V() {
        return this.d.w();
    }

    @Override // kotlin.i0.z.e.m0.h.c
    public kotlin.i0.z.e.m0.h.b W() {
        return this.d.x();
    }

    public l<c1, String> X() {
        return this.d.y();
    }

    @Override // kotlin.i0.z.e.m0.h.c
    public boolean Y() {
        return this.d.z();
    }

    public Set<b> Z() {
        return this.d.A();
    }

    public void a(Set<b> set) {
        n.f(set, "<set-?>");
        this.d.a(set);
    }

    @Override // kotlin.i0.z.e.m0.h.c
    public void b(boolean z) {
        this.d.b(z);
    }

    @Override // kotlin.i0.z.e.m0.h.c
    public boolean b0() {
        return this.d.B();
    }

    @Override // kotlin.i0.z.e.m0.h.c
    public String b1(h h) {
        boolean z;
        String obj2;
        n.f(h, "klass");
        if (t.r(h)) {
            obj2 = h.g().toString();
        } else {
            obj2 = W().a(h, this);
        }
        return obj2;
    }

    public void c(Set<? extends kotlin.i0.z.e.m0.h.e> set) {
        n.f(set, "<set-?>");
        this.d.c(set);
    }

    @Override // kotlin.i0.z.e.m0.h.c
    public boolean c0() {
        return this.d.C();
    }

    @Override // kotlin.i0.z.e.m0.h.c
    public void d(kotlin.i0.z.e.m0.h.k k) {
        n.f(k, "<set-?>");
        this.d.d(k);
    }

    @Override // kotlin.i0.z.e.m0.h.c
    public boolean d0() {
        return this.d.D();
    }

    @Override // kotlin.i0.z.e.m0.h.c
    public void e(boolean z) {
        this.d.e(z);
    }

    @Override // kotlin.i0.z.e.m0.h.c
    public boolean e0() {
        return this.d.E();
    }

    @Override // kotlin.i0.z.e.m0.h.c
    public boolean f() {
        return this.d.f();
    }

    @Override // kotlin.i0.z.e.m0.h.c
    public boolean f0() {
        return this.d.F();
    }

    @Override // kotlin.i0.z.e.m0.h.c
    public void g(kotlin.i0.z.e.m0.h.b b) {
        n.f(b, "<set-?>");
        this.d.g(b);
    }

    public Set<kotlin.i0.z.e.m0.h.e> g0() {
        return this.d.G();
    }

    @Override // kotlin.i0.z.e.m0.h.c
    public void h(boolean z) {
        this.d.h(z);
    }

    @Override // kotlin.i0.z.e.m0.h.c
    public boolean h0() {
        return this.d.H();
    }

    @Override // kotlin.i0.z.e.m0.h.c
    public void i(boolean z) {
        this.d.i(z);
    }

    @Override // kotlin.i0.z.e.m0.h.c
    public final kotlin.i0.z.e.m0.h.g i0() {
        return this.d;
    }

    @Override // kotlin.i0.z.e.m0.h.c
    public void j(boolean z) {
        this.d.j(z);
    }

    @Override // kotlin.i0.z.e.m0.h.c
    public kotlin.i0.z.e.m0.h.j j0() {
        return this.d.I();
    }

    @Override // kotlin.i0.z.e.m0.h.c
    public void k(boolean z) {
        this.d.k(z);
    }

    @Override // kotlin.i0.z.e.m0.h.c
    public kotlin.i0.z.e.m0.h.k k0() {
        return this.d.J();
    }

    @Override // kotlin.i0.z.e.m0.h.c
    public void l(kotlin.i0.z.e.m0.h.m m) {
        n.f(m, "<set-?>");
        this.d.l(m);
    }

    @Override // kotlin.i0.z.e.m0.h.c
    public boolean l0() {
        return this.d.K();
    }

    @Override // kotlin.i0.z.e.m0.h.c
    public void m(kotlin.i0.z.e.m0.h.a a) {
        n.f(a, "<set-?>");
        this.d.m(a);
    }

    @Override // kotlin.i0.z.e.m0.h.c
    public boolean m0() {
        return this.d.L();
    }

    public Set<b> n() {
        return this.d.n();
    }

    @Override // kotlin.i0.z.e.m0.h.c
    public kotlin.i0.z.e.m0.h.l n0() {
        return this.d.M();
    }

    @Override // kotlin.i0.z.e.m0.h.c
    public boolean o() {
        return this.d.o();
    }

    @Override // kotlin.i0.z.e.m0.h.c
    public boolean o0() {
        return this.d.N();
    }

    @Override // kotlin.i0.z.e.m0.h.c
    public String o1(String string) {
        int stringBuilder;
        int str;
        Object obj3;
        n.f(string, "message");
        stringBuilder = d.b.a[B0().ordinal()];
        if (stringBuilder != 1) {
            if (stringBuilder != 2) {
            } else {
                stringBuilder = new StringBuilder();
                stringBuilder.append("<i>");
                stringBuilder.append(string);
                stringBuilder.append("</i>");
                obj3 = stringBuilder.toString();
            }
            obj3 = new NoWhenBranchMatchedException();
            throw obj3;
        }
        return obj3;
    }

    @Override // kotlin.i0.z.e.m0.h.c
    public kotlin.i0.z.e.m0.h.a p() {
        return this.d.p();
    }

    @Override // kotlin.i0.z.e.m0.h.c
    public boolean p0() {
        return this.d.O();
    }

    @Override // kotlin.i0.z.e.m0.h.c
    public void q(boolean z) {
        this.d.q(z);
    }

    @Override // kotlin.i0.z.e.m0.h.c
    public boolean q0() {
        return this.d.P();
    }

    @Override // kotlin.i0.z.e.m0.h.c
    public String r(m m) {
        n.f(m, "declarationDescriptor");
        StringBuilder stringBuilder = new StringBuilder();
        d.a aVar = new d.a(this);
        m.K(aVar, stringBuilder);
        if (H0()) {
            M(stringBuilder, m);
        }
        final String obj3 = stringBuilder.toString();
        n.e(obj3, "StringBuilder().apply(builderAction).toString()");
        return obj3;
    }

    @Override // kotlin.i0.z.e.m0.h.c
    public boolean r0() {
        return this.d.Q();
    }

    @Override // kotlin.i0.z.e.m0.h.c
    public String s(c c, e e2) {
        int str;
        boolean z;
        StringBuilder sb;
        String str4;
        String str2;
        String str3;
        int i;
        int i2;
        int i4;
        int i3;
        int i5;
        boolean obj12;
        String obj13;
        n.f(c, "annotation");
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append('@');
        if (e2 != null) {
            stringBuilder.append(n.o(e2.getRenderName(), ":"));
        }
        obj13 = c.getType();
        stringBuilder.append(x(obj13));
        if (c0()) {
            z = V0(c);
            if (!d0()) {
                if (obj12 ^= 1 != 0) {
                    p.f0(z, stringBuilder, ", ", "(", ")", 0, 0, 0, 112, 0);
                }
            } else {
            }
        }
        if (G0()) {
            if (!d0.a(obj13)) {
                if (obj12 instanceof e0.b) {
                    stringBuilder.append(" /* annotation class not found */");
                }
            } else {
            }
        }
        obj12 = stringBuilder.toString();
        n.e(obj12, "StringBuilder().apply(builderAction).toString()");
        return obj12;
    }

    @Override // kotlin.i0.z.e.m0.h.c
    public boolean s0() {
        return this.d.R();
    }

    @Override // kotlin.i0.z.e.m0.h.c
    public boolean t0() {
        return this.d.S();
    }

    @Override // kotlin.i0.z.e.m0.h.c
    public String u(String string, String string2, h h3) {
        n.f(string, "lowerRendered");
        n.f(string2, "upperRendered");
        n.f(h3, "builtIns");
        final int i = 40;
        final int i2 = 2;
        final int i3 = 0;
        if (P(string, string2) && l.M(string2, "(", false, i2, i3)) {
            if (l.M(string2, "(", false, i2, i3)) {
                StringBuilder obj14 = new StringBuilder();
                obj14.append(i);
                obj14.append(string);
                obj14.append(")!");
                return obj14.toString();
            }
            return n.o(string, "!");
        }
        e eVar = h3.w();
        n.e(eVar, "builtIns.collection");
        String str6 = l.X0(W().a(eVar, this), "Collection", i3, i2, i3);
        String str16 = "Mutable";
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str6);
        stringBuilder.append(i);
        stringBuilder.append(str16);
        int i4 = 41;
        stringBuilder.append(i4);
        String str18 = this.X1(string, n.o(str6, str16), string2, str6, stringBuilder.toString());
        if (str18 != null) {
            return str18;
        }
        String str7 = this.X1(string, n.o(str6, "MutableMap.MutableEntry"), string2, n.o(str6, "Map.Entry"), n.o(str6, "(Mutable)Map.(Mutable)Entry"));
        if (str7 != null) {
            return str7;
        }
        e obj15 = h3.j();
        n.e(obj15, "builtIns.array");
        obj15 = l.X0(W().a(obj15, this), "Array", i3, i2, i3);
        obj15 = this.X1(string, n.o(obj15, Q("Array<")), string2, n.o(obj15, Q("Array<out ")), n.o(obj15, Q("Array<(out) ")));
        if (obj15 != null) {
            return obj15;
        }
        obj15 = new StringBuilder();
        obj15.append(i);
        obj15.append(string);
        obj15.append("..");
        obj15.append(string2);
        obj15.append(i4);
        return obj15.toString();
    }

    @Override // kotlin.i0.z.e.m0.h.c
    public boolean u0() {
        return this.d.T();
    }

    @Override // kotlin.i0.z.e.m0.h.c
    public String v(c c) {
        n.f(c, "fqName");
        List obj2 = c.h();
        n.e(obj2, "fqName.pathSegments()");
        return h1(obj2);
    }

    @Override // kotlin.i0.z.e.m0.h.c
    public boolean v0() {
        return this.d.U();
    }

    @Override // kotlin.i0.z.e.m0.h.c
    public String w(e e, boolean z2) {
        boolean str;
        kotlin.i0.z.e.m0.h.m hTML;
        String obj3;
        StringBuilder obj4;
        n.f(e, "name");
        if (U() && B0() == m.HTML && z2 != null) {
            if (B0() == m.HTML) {
                if (z2 != null) {
                    obj4 = new StringBuilder();
                    obj4.append("<b>");
                    obj4.append(Q(n.b(e)));
                    obj4.append("</b>");
                    obj3 = obj4.toString();
                }
            }
        }
        return obj3;
    }

    @Override // kotlin.i0.z.e.m0.h.c
    public boolean w0() {
        return this.d.V();
    }

    @Override // kotlin.i0.z.e.m0.h.c
    public String x(b0 b0) {
        n.f(b0, "type");
        StringBuilder stringBuilder = new StringBuilder();
        t1(stringBuilder, (b0)C0().invoke(b0));
        String obj3 = stringBuilder.toString();
        n.e(obj3, "StringBuilder().apply(builderAction).toString()");
        return obj3;
    }

    @Override // kotlin.i0.z.e.m0.h.c
    public boolean x0() {
        return this.d.W();
    }

    @Override // kotlin.i0.z.e.m0.h.c
    public String y(v0 v0) {
        n.f(v0, "typeProjection");
        StringBuilder stringBuilder = new StringBuilder();
        N(stringBuilder, p.b(v0));
        String obj2 = stringBuilder.toString();
        n.e(obj2, "StringBuilder().apply(builderAction).toString()");
        return obj2;
    }

    @Override // kotlin.i0.z.e.m0.h.c
    public boolean y0() {
        return this.d.X();
    }

    @Override // kotlin.i0.z.e.m0.h.c
    public boolean z0() {
        return this.d.Y();
    }
}
