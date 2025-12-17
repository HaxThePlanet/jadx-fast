package kotlin.i0.z.e.m0.d.a.e0;

import java.util.Map;
import kotlin.d0.c.a;
import kotlin.d0.d.c0;
import kotlin.d0.d.n;
import kotlin.d0.d.p;
import kotlin.d0.d.x;
import kotlin.i0.l;
import kotlin.i0.z.e.m0.b.h;
import kotlin.i0.z.e.m0.d.a.f0.i;
import kotlin.i0.z.e.m0.d.a.g0.b;
import kotlin.i0.z.e.m0.d.a.g0.g;
import kotlin.i0.z.e.m0.d.a.h0.b;
import kotlin.i0.z.e.m0.d.a.i0.a;
import kotlin.i0.z.e.m0.d.a.i0.b;
import kotlin.i0.z.e.m0.f.b;
import kotlin.i0.z.e.m0.f.e;
import kotlin.i0.z.e.m0.i.q.g;
import kotlin.i0.z.e.m0.k.i;
import kotlin.i0.z.e.m0.k.m;
import kotlin.i0.z.e.m0.k.n;
import kotlin.i0.z.e.m0.l.b0;
import kotlin.i0.z.e.m0.l.i0;
import kotlin.reflect.jvm.internal.impl.descriptors.c0;
import kotlin.reflect.jvm.internal.impl.descriptors.e;
import kotlin.reflect.jvm.internal.impl.descriptors.h1.c;
import kotlin.reflect.jvm.internal.impl.descriptors.u0;
import kotlin.y.j0;
import kotlin.y.p;

/* loaded from: classes3.dex */
public class b implements c, i {

    static final l<Object>[] f;
    private final b a;
    private final u0 b;
    private final i c;
    private final b d;
    private final boolean e;

    static final class a extends p implements a<i0> {

        final g $c;
        final kotlin.i0.z.e.m0.d.a.e0.b this$0;
        a(g g, kotlin.i0.z.e.m0.d.a.e0.b b2) {
            this.$c = g;
            this.this$0 = b2;
            super(0);
        }

        @Override // kotlin.d0.d.p
        public final i0 a() {
            i0 i0Var = this.$c.d().m().o(this.this$0.d()).q();
            n.e(i0Var, "c.module.builtIns.getBuiltInClassByFqName(fqName).defaultType");
            return i0Var;
        }

        @Override // kotlin.d0.d.p
        public Object invoke() {
            return a();
        }
    }
    static {
        l[] arr = new l[1];
        x xVar = new x(c0.b(b.class), "type", "getType()Lorg/jetbrains/kotlin/types/SimpleType;");
        b.f = arr;
    }

    public b(g g, a a2, b b3) {
        kotlin.i0.z.e.m0.d.a.h0.a aVar;
        String str;
        Object obj3;
        int obj5;
        n.f(g, "c");
        n.f(b3, "fqName");
        super();
        this.a = b3;
        obj5 = 0;
        if (a2 == null) {
            aVar = obj5;
        } else {
            aVar = g.a().s().a(a2);
        }
        if (aVar == null) {
            n.e(u0.a, "NO_SOURCE");
        }
        this.b = aVar;
        b.a aVar2 = new b.a(g, this);
        this.c = g.e().d(aVar2);
        if (a2 == null) {
            obj3 = obj5;
        } else {
        }
        this.d = obj3;
        if (a2 == null) {
        } else {
            obj5 = Boolean.valueOf(a2.f());
        }
        this.e = n.b(obj5, Boolean.TRUE);
    }

    public Map<e, g<?>> a() {
        return j0.h();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.h1.c
    protected final b b() {
        return this.d;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.h1.c
    public i0 c() {
        return (i0)m.a(this.c, this, b.f[0]);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.h1.c
    public b d() {
        return this.a;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.h1.c
    public boolean f() {
        return this.e;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.h1.c
    public u0 getSource() {
        return this.b;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.h1.c
    public b0 getType() {
        return c();
    }
}
