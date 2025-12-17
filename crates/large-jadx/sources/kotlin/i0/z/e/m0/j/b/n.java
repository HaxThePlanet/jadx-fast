package kotlin.i0.z.e.m0.j.b;

import java.util.Set;
import kotlin.d0.d.n;
import kotlin.i0.z.e.m0.f.b;
import kotlin.i0.z.e.m0.f.e;
import kotlin.i0.z.e.m0.j.b.d0.h;
import kotlin.i0.z.e.m0.k.n;
import kotlin.reflect.jvm.internal.impl.descriptors.c0;
import kotlin.reflect.jvm.internal.impl.descriptors.f0;
import kotlin.reflect.jvm.internal.impl.descriptors.j1.z;

/* loaded from: classes3.dex */
public abstract class n extends z {

    private final n x;
    public n(b b, n n2, c0 c03) {
        n.f(b, "fqName");
        n.f(n2, "storageManager");
        n.f(c03, "module");
        super(c03, b);
        this.x = n2;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.z
    public abstract kotlin.i0.z.e.m0.j.b.g C0();

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.z
    public boolean J0(e e) {
        Object hVar;
        Object obj3;
        n.f(e, "name");
        hVar = o();
        if (hVar instanceof h && (h)hVar.r().contains(e)) {
            obj3 = (h)hVar.r().contains(e) ? 1 : 0;
        } else {
        }
        return obj3;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.z
    public abstract void K0(kotlin.i0.z.e.m0.j.b.j j);
}
