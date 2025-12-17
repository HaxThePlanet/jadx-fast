package kotlin.reflect.jvm.internal.impl.descriptors.l1.b;

import kotlin.d0.d.n;
import kotlin.i0.z.e.m0.d.a.i0.o;
import kotlin.i0.z.e.m0.f.e;

/* loaded from: classes3.dex */
public final class q extends kotlin.reflect.jvm.internal.impl.descriptors.l1.b.d implements o {

    private final Object c;
    public q(e e, Object object2) {
        n.f(object2, "value");
        super(e);
        this.c = object2;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.l1.b.d
    public Object getValue() {
        return this.c;
    }
}
