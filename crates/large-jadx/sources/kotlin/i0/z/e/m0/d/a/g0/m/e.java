package kotlin.i0.z.e.m0.d.a.g0.m;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.d0.c.l;
import kotlin.d0.d.n;
import kotlin.d0.d.p;
import kotlin.i0.z.e.m0.b.h;
import kotlin.i0.z.e.m0.d.a.e0.k;
import kotlin.i0.z.e.m0.i.s.a;
import kotlin.i0.z.e.m0.l.b0;
import kotlin.i0.z.e.m0.l.c0;
import kotlin.i0.z.e.m0.l.d0;
import kotlin.i0.z.e.m0.l.h1;
import kotlin.i0.z.e.m0.l.i0;
import kotlin.i0.z.e.m0.l.j1.g;
import kotlin.i0.z.e.m0.l.t;
import kotlin.i0.z.e.m0.l.t0;
import kotlin.i0.z.e.m0.l.v0;
import kotlin.i0.z.e.m0.l.x0;
import kotlin.i0.z.e.m0.l.y;
import kotlin.i0.z.e.m0.l.y0;
import kotlin.o;
import kotlin.reflect.jvm.internal.impl.descriptors.e;
import kotlin.reflect.jvm.internal.impl.descriptors.h;
import kotlin.reflect.jvm.internal.impl.descriptors.h1.a;
import kotlin.reflect.jvm.internal.impl.descriptors.z0;
import kotlin.u;
import kotlin.y.p;

/* loaded from: classes3.dex */
public final class e extends y0 {

    public static final kotlin.i0.z.e.m0.d.a.g0.m.e b;
    private static final kotlin.i0.z.e.m0.d.a.g0.m.a c;
    private static final kotlin.i0.z.e.m0.d.a.g0.m.a d;

    public class a {

        public static final int[] a;
        static {
            int[] iArr = new int[values.length];
            iArr[b.FLEXIBLE_LOWER_BOUND.ordinal()] = 1;
            iArr[b.FLEXIBLE_UPPER_BOUND.ordinal()] = 2;
            iArr[b.INFLEXIBLE.ordinal()] = 3;
            e.a.a = iArr;
        }
    }

    static final class b extends p implements l<g, i0> {

        final kotlin.i0.z.e.m0.d.a.g0.m.a $attr;
        final e $declaration;
        final i0 $type;
        final kotlin.i0.z.e.m0.d.a.g0.m.e this$0;
        b(e e, kotlin.i0.z.e.m0.d.a.g0.m.e e2, i0 i03, kotlin.i0.z.e.m0.d.a.g0.m.a a4) {
            this.$declaration = e;
            this.this$0 = e2;
            this.$type = i03;
            this.$attr = a4;
            super(1);
        }

        @Override // kotlin.d0.d.p
        public final i0 a(g g) {
            int $declaration;
            kotlin.i0.z.e.m0.f.a aVar;
            n.f(g, "kotlinTypeRefiner");
            int i = 0;
            if ($declaration instanceof e) {
            } else {
                $declaration = i;
            }
            if ($declaration == 0) {
                aVar = i;
            } else {
                aVar = a.h($declaration);
            }
            if (aVar == null) {
                return i;
            }
            e obj4 = g.a(aVar);
            if (obj4 == null) {
                return i;
            }
            if (n.b(obj4, this.$declaration)) {
                return i;
            }
            return (i0)e.h(this.this$0, this.$type, obj4, this.$attr).c();
        }

        @Override // kotlin.d0.d.p
        public Object invoke(Object object) {
            return a((g)object);
        }
    }
    static {
        e eVar = new e();
        e.b = eVar;
        k cOMMON = k.COMMON;
        int i = 0;
        final int i2 = 0;
        final int i3 = 3;
        e.c = d.f(cOMMON, i, i2, i3, i2).g(b.FLEXIBLE_LOWER_BOUND);
        e.d = d.f(cOMMON, i, i2, i3, i2).g(b.FLEXIBLE_UPPER_BOUND);
    }

    public static final o h(kotlin.i0.z.e.m0.d.a.g0.m.e e, i0 i02, e e3, kotlin.i0.z.e.m0.d.a.g0.m.a a4) {
        return e.k(i02, e3, a4);
    }

    public static v0 j(kotlin.i0.z.e.m0.d.a.g0.m.e e, z0 z02, kotlin.i0.z.e.m0.d.a.g0.m.a a3, b0 b04, int i5, Object object6) {
        b0 obj3;
        int obj4;
        if (i5 &= 4 != 0) {
            obj4 = 0;
            obj3 = d.c(z02, obj4, obj4, 3, obj4);
        }
        return e.i(z02, a3, obj3);
    }

    private final o<i0, Boolean> k(i0 i0, e e2, kotlin.i0.z.e.m0.d.a.g0.m.a a3) {
        int i2;
        y0 y0Var;
        Object obj;
        kotlin.i0.z.e.m0.d.a.g0.m.a aVar;
        int i;
        int i3;
        int i4;
        if (i0.L0().getParameters().isEmpty()) {
            return u.a(i0, Boolean.FALSE);
        }
        if (h.b0(i0)) {
            Object obj14 = i0.K0().get(0);
            obj14 = obj14.getType();
            n.e(obj14, "componentTypeProjection.type");
            x0 obj15 = new x0((v0)obj14.a(), l(obj14));
            obj14 = c0.a;
            return u.a(c0.i(i0.getAnnotations(), i0.L0(), p.b(obj15), i0.M0(), 0, 16, 0), Boolean.FALSE);
        }
        if (d0.a(i0)) {
            i0 obj13 = t.j(n.o("Raw error type: ", i0.L0()));
            n.e(obj13, "createErrorType(\"Raw error type: ${type.constructor}\")");
            return u.a(obj13, Boolean.FALSE);
        }
        kotlin.i0.z.e.m0.i.v.h hVar = e2.a0(this);
        n.e(hVar, "declaration.getMemberScope(RawSubstitution)");
        c0 c0Var = c0.a;
        t0 t0Var2 = e2.g();
        n.e(t0Var2, "declaration.typeConstructor");
        List parameters2 = e2.g().getParameters();
        n.e(parameters2, "declaration.typeConstructor.parameters");
        ArrayList arrayList = new ArrayList(p.r(parameters2, 10));
        Iterator iterator = parameters2.iterator();
        for (Object next2 : iterator) {
            obj = next2;
            n.e((z0)obj, "parameter");
            arrayList.add(e.j(this, obj, a3, 0, 4, 0));
        }
        e.b bVar2 = new e.b(e2, this, i0, a3);
        return u.a(c0.k(i0.getAnnotations(), t0Var2, arrayList, i0.M0(), hVar, bVar2), Boolean.TRUE);
    }

    private final b0 l(b0 b0) {
        boolean booleanValue;
        Object obj;
        Object obj2;
        kotlin.i0.z.e.m0.d.a.g0.m.a aVar;
        b0 obj5;
        booleanValue = b0.L0().c();
        if (booleanValue instanceof z0) {
            obj = 0;
            obj5 = l(d.c((z0)booleanValue, obj, obj, 3, obj));
            return obj5;
        } else {
            if (!booleanValue instanceof e) {
            } else {
                h hVar = y.d(b0).L0().c();
                if (!hVar instanceof e) {
                } else {
                    o oVar = k(y.c(b0), (e)booleanValue, e.c);
                    obj2 = oVar.a();
                    obj5 = k(y.d(b0), (e)hVar, e.d);
                    obj = obj5.a();
                    if (!(Boolean)oVar.b().booleanValue()) {
                        if ((Boolean)obj5.b().booleanValue()) {
                            obj5 = new f((i0)obj2, (i0)obj);
                        } else {
                            obj5 = c0.a;
                            obj5 = c0.d(obj2, obj);
                        }
                    } else {
                    }
                }
                obj5 = new StringBuilder();
                obj5.append("For some reason declaration for upper bound is not a class but \"");
                obj5.append(hVar);
                obj5.append("\" while for lower it's \"");
                obj5.append(booleanValue);
                obj5.append('"');
                IllegalStateException illegalStateException2 = new IllegalStateException(obj5.toString().toString());
                throw illegalStateException2;
            }
        }
        IllegalStateException illegalStateException = new IllegalStateException(n.o("Unexpected declaration kind: ", booleanValue).toString());
        throw illegalStateException;
    }

    @Override // kotlin.i0.z.e.m0.l.y0
    public v0 e(b0 b0) {
        return m(b0);
    }

    @Override // kotlin.i0.z.e.m0.l.y0
    public boolean f() {
        return 0;
    }

    @Override // kotlin.i0.z.e.m0.l.y0
    public final v0 i(z0 z0, kotlin.i0.z.e.m0.d.a.g0.m.a a2, b0 b03) {
        int allowsOutPosition;
        String str;
        Object obj4;
        v0 obj5;
        Object obj6;
        n.f(z0, "parameter");
        n.f(a2, "attr");
        n.f(b03, "erasedUpperBound");
        allowsOutPosition = e.a.a[a2.c().ordinal()];
        int i = 1;
        if (allowsOutPosition != i) {
            if (allowsOutPosition != 2) {
                if (allowsOutPosition != 3) {
                } else {
                }
                obj4 = new NoWhenBranchMatchedException();
                throw obj4;
            }
            if (!z0.l().getAllowsOutPosition()) {
                obj5 = new x0(h1.INVARIANT, a.g(z0).H());
            } else {
                List parameters = b03.L0().getParameters();
                n.e(parameters, "erasedUpperBound.constructor.parameters");
                if (empty ^= i != 0) {
                    obj5 = new x0(h1.OUT_VARIANCE, b03);
                } else {
                    obj5 = d.d(z0, a2);
                }
            }
        } else {
            obj5 = new x0(h1.INVARIANT, b03);
        }
        return obj5;
    }

    @Override // kotlin.i0.z.e.m0.l.y0
    public x0 m(b0 b0) {
        n.f(b0, "key");
        x0 x0Var = new x0(l(b0));
        return x0Var;
    }
}
