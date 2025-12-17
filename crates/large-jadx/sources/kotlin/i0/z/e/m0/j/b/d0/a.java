package kotlin.i0.z.e.m0.j.b.d0;

import java.util.Iterator;
import java.util.List;
import kotlin.d0.c.a;
import kotlin.d0.d.c0;
import kotlin.d0.d.n;
import kotlin.d0.d.x;
import kotlin.i0.l;
import kotlin.i0.z.e.m0.f.b;
import kotlin.i0.z.e.m0.k.i;
import kotlin.i0.z.e.m0.k.m;
import kotlin.i0.z.e.m0.k.n;
import kotlin.reflect.jvm.internal.impl.descriptors.h1.c;
import kotlin.reflect.jvm.internal.impl.descriptors.h1.g;
import kotlin.reflect.jvm.internal.impl.descriptors.h1.g.b;

/* loaded from: classes3.dex */
public class a implements g {

    static final l<Object>[] b;
    private final i a;
    static {
        l[] arr = new l[1];
        x xVar = new x(c0.b(a.class), "annotations", "getAnnotations()Ljava/util/List;");
        a.b = arr;
    }

    public a(n n, a<? extends List<? extends c>> a2) {
        n.f(n, "storageManager");
        n.f(a2, "compute");
        super();
        this.a = n.d(a2);
    }

    private final List<c> d() {
        return (List)m.a(this.a, this, a.b[0]);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.h1.g
    public boolean isEmpty() {
        return d().isEmpty();
    }

    public Iterator<c> iterator() {
        return d().iterator();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.h1.g
    public c o(b b) {
        return g.b.a(this, b);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.h1.g
    public boolean u1(b b) {
        return g.b.b(this, b);
    }
}
