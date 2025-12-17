package kotlin.reflect.jvm.internal.impl.descriptors.l1.a;

import java.io.InputStream;
import kotlin.d0.d.n;
import kotlin.i0.z.e.m0.b.k;
import kotlin.i0.z.e.m0.d.a.i0.g;
import kotlin.i0.z.e.m0.d.b.m;
import kotlin.i0.z.e.m0.d.b.m.a;
import kotlin.i0.z.e.m0.d.b.m.a.b;
import kotlin.i0.z.e.m0.f.a;
import kotlin.i0.z.e.m0.f.b;
import kotlin.i0.z.e.m0.j.b.c0.a;
import kotlin.i0.z.e.m0.j.b.c0.d;

/* loaded from: classes3.dex */
public final class g implements m {

    private final java.lang.ClassLoader a;
    private final d b;
    public g(java.lang.ClassLoader classLoader) {
        n.f(classLoader, "classLoader");
        super();
        this.a = classLoader;
        d obj2 = new d();
        this.b = obj2;
    }

    private final m.a d(String string) {
        int i;
        Object bVar;
        int i2;
        Object obj4;
        obj4 = e.a(this.a, string);
        i = 0;
        if (obj4 == null) {
        } else {
            obj4 = f.c.a(obj4);
            if (obj4 == null) {
            } else {
                bVar = new m.a.b(obj4, i, 2, i);
                i = bVar;
            }
        }
        return i;
    }

    @Override // kotlin.i0.z.e.m0.d.b.m
    public m.a a(g g) {
        int obj2;
        n.f(g, "javaClass");
        obj2 = g.d();
        int i = 0;
        if (obj2 == null) {
            obj2 = i;
        } else {
            obj2 = obj2.b();
        }
        if (obj2 == null) {
            return i;
        }
        return d(obj2);
    }

    @Override // kotlin.i0.z.e.m0.d.b.m
    public InputStream b(b b) {
        n.f(b, "packageFqName");
        if (!b.i(k.k)) {
            return null;
        }
        return this.b.a(a.m.n(b));
    }

    @Override // kotlin.i0.z.e.m0.d.b.m
    public m.a c(a a) {
        n.f(a, "classId");
        return d(h.a(a));
    }
}
