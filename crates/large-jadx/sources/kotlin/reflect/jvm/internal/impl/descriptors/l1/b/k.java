package kotlin.reflect.jvm.internal.impl.descriptors.l1.b;

import kotlin.d0.d.n;
import kotlin.i0.z.e.m0.d.a.i0.h;
import kotlin.i0.z.e.m0.d.a.i0.x;
import kotlin.i0.z.e.m0.f.e;

/* loaded from: classes3.dex */
public final class k extends kotlin.reflect.jvm.internal.impl.descriptors.l1.b.d implements h {

    private final Class<?> c;
    public k(e e, Class<?> class2) {
        n.f(class2, "klass");
        super(e);
        this.c = class2;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.l1.b.d
    public x c() {
        return w.a.a(this.c);
    }
}
