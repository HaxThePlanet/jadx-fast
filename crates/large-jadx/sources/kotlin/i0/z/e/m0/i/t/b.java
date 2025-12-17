package kotlin.i0.z.e.m0.i.t;

import kotlin.d0.d.n;
import kotlin.i0.z.e.m0.c.b.d;
import kotlin.i0.z.e.m0.d.a.e0.g;
import kotlin.i0.z.e.m0.d.a.g0.f;
import kotlin.i0.z.e.m0.d.a.g0.l.h;
import kotlin.i0.z.e.m0.d.a.i0.c0;
import kotlin.i0.z.e.m0.d.a.i0.g;
import kotlin.i0.z.e.m0.d.a.i0.t;
import kotlin.i0.z.e.m0.f.b;
import kotlin.i0.z.e.m0.i.v.k;
import kotlin.reflect.jvm.internal.impl.descriptors.e;
import kotlin.y.p;

/* loaded from: classes3.dex */
public final class b {

    private final f a;
    private final g b;
    public b(f f, g g2) {
        n.f(f, "packageFragmentProvider");
        n.f(g2, "javaResolverCache");
        super();
        this.a = f;
        this.b = g2;
    }

    public final f a() {
        return this.a;
    }

    public final e b(g g) {
        int i;
        c0 c0Var;
        Object fROM_JAVA_LOADER;
        c0 sOURCE;
        int i2;
        int obj5;
        n.f(g, "javaClass");
        b bVar = g.d();
        if (bVar != null && g.I() == c0.SOURCE) {
            if (g.I() == c0.SOURCE) {
                return this.b.a(bVar);
            }
        }
        fROM_JAVA_LOADER = g.k();
        i2 = 0;
        if (fROM_JAVA_LOADER == null && bVar == null) {
            if (bVar == null) {
                return i2;
            }
            b bVar2 = bVar.e();
            n.e(bVar2, "fqName.parent()");
            Object obj = p.Z(this.a.a(bVar2));
            if ((h)obj == null) {
            } else {
                i2 = (h)obj.K0(g);
            }
            return i2;
        }
        e eVar = b(fROM_JAVA_LOADER);
        if (eVar == null) {
            i = i2;
        } else {
            i = eVar.x0();
        }
        if (i == 0) {
            obj5 = i2;
        } else {
            obj5 = i.f(g.getName(), d.FROM_JAVA_LOADER);
        }
        if (obj5 instanceof e) {
            i2 = obj5;
        }
        return i2;
    }
}
