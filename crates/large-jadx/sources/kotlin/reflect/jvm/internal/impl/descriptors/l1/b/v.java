package kotlin.reflect.jvm.internal.impl.descriptors.l1.b;

import java.lang.reflect.Type;
import java.util.Collection;
import kotlin.d0.d.n;
import kotlin.i0.z.e.m0.b.i;
import kotlin.i0.z.e.m0.d.a.i0.a;
import kotlin.i0.z.e.m0.d.a.i0.v;
import kotlin.i0.z.e.m0.i.t.d;
import kotlin.y.p;

/* loaded from: classes3.dex */
public final class v extends kotlin.reflect.jvm.internal.impl.descriptors.l1.b.w implements v {

    private final Class<?> b;
    private final Collection<a> c;
    private final boolean d;
    public v(Class<?> class) {
        n.f(class, "reflectType");
        super();
        this.b = class;
        this.c = p.g();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.l1.b.w
    protected Type Q() {
        return R();
    }

    protected Class<?> R() {
        return this.b;
    }

    public Collection<a> getAnnotations() {
        return this.c;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.l1.b.w
    public i getType() {
        int primitiveType;
        if (n.b(R(), Void.TYPE)) {
            primitiveType = 0;
        } else {
            primitiveType = d.get(R().getName()).getPrimitiveType();
        }
        return primitiveType;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.l1.b.w
    public boolean n() {
        return this.d;
    }
}
