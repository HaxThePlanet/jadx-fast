package kotlin.i0.z.e.m0.j.b;

import java.util.Iterator;
import java.util.List;
import kotlin.d0.d.n;
import kotlin.i0.z.e.m0.f.a;
import kotlin.reflect.jvm.internal.impl.descriptors.g0;
import kotlin.reflect.jvm.internal.impl.descriptors.i0;

/* loaded from: classes3.dex */
public final class m implements kotlin.i0.z.e.m0.j.b.g {

    private final g0 a;
    public m(g0 g0) {
        n.f(g0, "packageFragmentProvider");
        super();
        this.a = g0;
    }

    @Override // kotlin.i0.z.e.m0.j.b.g
    public kotlin.i0.z.e.m0.j.b.f a(a a) {
        kotlin.i0.z.e.m0.f.b next;
        String str;
        n.f(a, "classId");
        next = a.h();
        n.e(next, "classId.packageFqName");
        Iterator iterator = i0.b(this.a, next).iterator();
        for (f0 next : iterator) {
            next = (n)next.C0().a(a);
        }
        return null;
    }
}
