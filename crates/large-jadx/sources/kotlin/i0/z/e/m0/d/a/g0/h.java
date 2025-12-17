package kotlin.i0.z.e.m0.d.a.g0;

import java.util.Map;
import kotlin.d0.c.l;
import kotlin.d0.d.n;
import kotlin.d0.d.p;
import kotlin.i0.z.e.m0.d.a.g0.l.m;
import kotlin.i0.z.e.m0.d.a.i0.y;
import kotlin.i0.z.e.m0.d.a.i0.z;
import kotlin.i0.z.e.m0.k.h;
import kotlin.i0.z.e.m0.k.n;
import kotlin.reflect.jvm.internal.impl.descriptors.h1.a;
import kotlin.reflect.jvm.internal.impl.descriptors.m;
import kotlin.reflect.jvm.internal.impl.descriptors.z0;
import kotlin.reflect.jvm.internal.impl.utils.a;

/* loaded from: classes3.dex */
public final class h implements kotlin.i0.z.e.m0.d.a.g0.k {

    private final kotlin.i0.z.e.m0.d.a.g0.g a;
    private final m b;
    private final int c;
    private final Map<y, Integer> d;
    private final h<y, m> e;

    static final class a extends p implements l<y, m> {

        final kotlin.i0.z.e.m0.d.a.g0.h this$0;
        a(kotlin.i0.z.e.m0.d.a.g0.h h) {
            this.this$0 = h;
            super(1);
        }

        @Override // kotlin.d0.d.p
        public final m a(y y) {
            Object obj;
            kotlin.i0.z.e.m0.d.a.g0.h this$0;
            m mVar;
            kotlin.i0.z.e.m0.d.a.g0.g gVar;
            int i;
            int obj6;
            n.f(y, "typeParameter");
            obj = h.d(this.this$0).get(y);
            if ((Integer)obj == null) {
                obj6 = 0;
            } else {
                this$0 = this.this$0;
                mVar = new m(a.h(a.b(h.b(this$0), this$0), h.c(this$0).getAnnotations()), y, i2 += intValue, h.c(this$0));
                obj6 = mVar;
            }
            return obj6;
        }

        @Override // kotlin.d0.d.p
        public Object invoke(Object object) {
            return a((y)object);
        }
    }
    public h(kotlin.i0.z.e.m0.d.a.g0.g g, m m2, z z3, int i4) {
        n.f(g, "c");
        n.f(m2, "containingDeclaration");
        n.f(z3, "typeParameterOwner");
        super();
        this.a = g;
        this.b = m2;
        this.c = i4;
        this.d = a.d(z3.getTypeParameters());
        h.a obj3 = new h.a(this);
        this.e = g.e().i(obj3);
    }

    public static final kotlin.i0.z.e.m0.d.a.g0.g b(kotlin.i0.z.e.m0.d.a.g0.h h) {
        return h.a;
    }

    public static final m c(kotlin.i0.z.e.m0.d.a.g0.h h) {
        return h.b;
    }

    public static final Map d(kotlin.i0.z.e.m0.d.a.g0.h h) {
        return h.d;
    }

    public static final int e(kotlin.i0.z.e.m0.d.a.g0.h h) {
        return h.c;
    }

    @Override // kotlin.i0.z.e.m0.d.a.g0.k
    public z0 a(y y) {
        Object invoke;
        n.f(y, "javaTypeParameter");
        if ((m)this.e.invoke(y) == null) {
            invoke = this.a.f().a(y);
        }
        return invoke;
    }
}
