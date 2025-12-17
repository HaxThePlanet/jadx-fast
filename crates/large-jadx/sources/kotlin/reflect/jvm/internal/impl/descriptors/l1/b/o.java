package kotlin.reflect.jvm.internal.impl.descriptors.l1.b;

import kotlin.d0.d.n;
import kotlin.i0.z.e.m0.d.a.i0.m;
import kotlin.i0.z.e.m0.f.a;
import kotlin.i0.z.e.m0.f.e;

/* loaded from: classes3.dex */
public final class o extends kotlin.reflect.jvm.internal.impl.descriptors.l1.b.d implements m {

    private final Enum<?> c;
    public o(e e, Enum<?> enum2) {
        n.f(enum2, "value");
        super(e);
        this.c = enum2;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.l1.b.d
    public a b() {
        Class enclosingClass;
        enclosingClass = this.c.getClass();
        if (enclosingClass.isEnum()) {
        } else {
            enclosingClass = enclosingClass.getEnclosingClass();
        }
        n.e(enclosingClass, "enumClass");
        return b.b(enclosingClass);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.l1.b.d
    public e d() {
        return e.j(this.c.name());
    }
}
