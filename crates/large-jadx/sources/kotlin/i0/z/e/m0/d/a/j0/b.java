package kotlin.i0.z.e.m0.d.a.j0;

import java.util.Iterator;
import java.util.List;
import kotlin.d0.d.n;
import kotlin.i0.z.e.m0.f.b;
import kotlin.reflect.jvm.internal.impl.descriptors.h1.c;
import kotlin.reflect.jvm.internal.impl.descriptors.h1.g;
import kotlin.reflect.jvm.internal.impl.descriptors.h1.g.b;
import kotlin.y.p;

/* loaded from: classes3.dex */
final class b implements g {

    private final b a;
    public b(b b) {
        n.f(b, "fqNameToMatch");
        super();
        this.a = b;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.h1.g
    public kotlin.i0.z.e.m0.d.a.j0.a d(b b) {
        kotlin.i0.z.e.m0.d.a.j0.a obj2;
        n.f(b, "fqName");
        obj2 = n.b(b, this.a) ? a.a : 0;
        return obj2;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.h1.g
    public boolean isEmpty() {
        return 0;
    }

    public Iterator<c> iterator() {
        return p.g().iterator();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.h1.g
    public c o(b b) {
        return d(b);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.h1.g
    public boolean u1(b b) {
        return g.b.b(this, b);
    }
}
