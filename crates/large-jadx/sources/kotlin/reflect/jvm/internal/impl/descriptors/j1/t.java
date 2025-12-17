package kotlin.reflect.jvm.internal.impl.descriptors.j1;

import kotlin.d0.d.g;
import kotlin.d0.d.n;
import kotlin.i0.z.e.m0.i.v.h;
import kotlin.i0.z.e.m0.l.j1.g;
import kotlin.i0.z.e.m0.l.y0;
import kotlin.reflect.jvm.internal.impl.descriptors.e;
import kotlin.reflect.jvm.internal.impl.descriptors.h;
import kotlin.reflect.jvm.internal.impl.descriptors.m;

/* loaded from: classes3.dex */
public abstract class t implements e {

    public static final kotlin.reflect.jvm.internal.impl.descriptors.j1.t.a a;

    public static final class a {
        public a(g g) {
            super();
        }

        public final h a(e e, y0 y02, g g3) {
            Object obj;
            h obj2;
            Object obj3;
            n.f(e, "<this>");
            n.f(y02, "typeSubstitution");
            n.f(g3, "kotlinTypeRefiner");
            if (e instanceof t) {
                obj = e;
            } else {
                obj = 0;
            }
            if (obj == null) {
                n.e(e.a0(y02), "this.getMemberScope(\n                typeSubstitution\n            )");
            } else {
                obj2 = obj.E(y02, g3);
            }
            return obj2;
        }

        public final h b(e e, g g2) {
            Object obj;
            h obj2;
            Object obj3;
            n.f(e, "<this>");
            n.f(g2, "kotlinTypeRefiner");
            if (e instanceof t) {
                obj = e;
            } else {
                obj = 0;
            }
            if (obj == null) {
                n.e(e.A0(), "this.unsubstitutedMemberScope");
            } else {
                obj2 = obj.F(g2);
            }
            return obj2;
        }
    }
    static {
        t.a aVar = new t.a(0);
        t.a = aVar;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.e
    protected abstract h E(y0 y0, g g2);

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.e
    protected abstract h F(g g);

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.e
    public h a() {
        return a();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.e
    public m a() {
        return a();
    }
}
