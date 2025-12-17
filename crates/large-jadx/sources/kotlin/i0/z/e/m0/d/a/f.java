package kotlin.i0.z.e.m0.d.a;

import java.util.Set;
import kotlin.d0.c.l;
import kotlin.d0.d.n;
import kotlin.d0.d.p;
import kotlin.i0.z.e.m0.d.b.t;
import kotlin.i0.z.e.m0.f.e;
import kotlin.i0.z.e.m0.i.s.a;
import kotlin.reflect.jvm.internal.impl.descriptors.b;
import kotlin.reflect.jvm.internal.impl.descriptors.d0;
import kotlin.reflect.jvm.internal.impl.descriptors.x;
import kotlin.y.p;

/* loaded from: classes3.dex */
public final class f extends kotlin.i0.z.e.m0.d.a.c0 {

    public static final kotlin.i0.z.e.m0.d.a.f m;

    static final class a extends p implements l<b, Boolean> {

        final kotlin.i0.z.e.m0.d.a.f this$0;
        a(kotlin.i0.z.e.m0.d.a.f f) {
            this.this$0 = f;
            super(1);
        }

        @Override // kotlin.d0.d.p
        public final boolean a(b b) {
            n.f(b, "it");
            return f.i(this.this$0, b);
        }

        @Override // kotlin.d0.d.p
        public Object invoke(Object object) {
            return Boolean.valueOf(a((b)object));
        }
    }

    static final class b extends p implements l<b, Boolean> {

        final kotlin.i0.z.e.m0.d.a.f this$0;
        b(kotlin.i0.z.e.m0.d.a.f f) {
            this.this$0 = f;
            super(1);
        }

        @Override // kotlin.d0.d.p
        public final boolean a(b b) {
            boolean this$0;
            Object obj2;
            n.f(b, "it");
            if (b instanceof x && f.i(this.this$0, b)) {
                obj2 = f.i(this.this$0, b) ? 1 : 0;
            } else {
            }
            return obj2;
        }

        @Override // kotlin.d0.d.p
        public Object invoke(Object object) {
            return Boolean.valueOf(a((b)object));
        }
    }
    static {
        f fVar = new f();
        f.m = fVar;
    }

    public static final boolean i(kotlin.i0.z.e.m0.d.a.f f, b b2) {
        return f.j(b2);
    }

    private final boolean j(b b) {
        return p.N(c0.a.d(), t.d(b));
    }

    public static final x k(x x) {
        n.f(x, "functionDescriptor");
        kotlin.i0.z.e.m0.d.a.f fVar = f.m;
        e name = x.getName();
        n.e(name, "functionDescriptor.name");
        int i3 = 0;
        if (!fVar.l(name)) {
            return i3;
        }
        f.a aVar = new f.a(fVar);
        return (x)a.d(x, false, aVar, 1, i3);
    }

    public static final kotlin.i0.z.e.m0.d.a.c0.b m(b b) {
        int obj5;
        n.f(b, "<this>");
        kotlin.i0.z.e.m0.d.a.c0.a aVar = c0.a;
        int i2 = 0;
        if (!aVar.c().contains(b.getName())) {
            return i2;
        }
        f.b bVar = new f.b(f.m);
        obj5 = a.d(b, false, bVar, 1, i2);
        if (obj5 == null) {
            obj5 = i2;
        } else {
            obj5 = t.d(obj5);
        }
        if (obj5 == null) {
            return i2;
        }
        return aVar.j(obj5);
    }

    @Override // kotlin.i0.z.e.m0.d.a.c0
    public final boolean l(e e) {
        n.f(e, "<this>");
        return c0.a.c().contains(e);
    }
}
