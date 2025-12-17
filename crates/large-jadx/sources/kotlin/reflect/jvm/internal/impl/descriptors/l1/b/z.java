package kotlin.reflect.jvm.internal.impl.descriptors.l1.b;

import java.lang.reflect.Type;
import java.lang.reflect.WildcardType;
import java.util.Collection;
import kotlin.d0.d.n;
import kotlin.i0.z.e.m0.d.a.i0.a;
import kotlin.i0.z.e.m0.d.a.i0.b0;
import kotlin.i0.z.e.m0.d.a.i0.x;
import kotlin.y.i;
import kotlin.y.p;

/* loaded from: classes3.dex */
public final class z extends kotlin.reflect.jvm.internal.impl.descriptors.l1.b.w implements b0 {

    private final WildcardType b;
    private final Collection<a> c;
    private final boolean d;
    public z(WildcardType wildcardType) {
        n.f(wildcardType, "reflectType");
        super();
        this.b = wildcardType;
        this.c = p.g();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.l1.b.w
    public x C() {
        return R();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.l1.b.w
    public boolean J() {
        Type[] upperBounds = S().getUpperBounds();
        n.e(upperBounds, "reflectType.upperBounds");
        return z ^= 1;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.l1.b.w
    protected Type Q() {
        return S();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.l1.b.w
    public kotlin.reflect.jvm.internal.impl.descriptors.l1.b.w R() {
        Object upperBounds;
        Object length;
        String length2;
        int length3;
        kotlin.reflect.jvm.internal.impl.descriptors.l1.b.w i;
        upperBounds = S().getUpperBounds();
        Type[] lowerBounds = S().getLowerBounds();
        final int i2 = 1;
        if (upperBounds.length > i2) {
        } else {
            if (lowerBounds.length > i2) {
            } else {
                i = 0;
                if (lowerBounds.length == i2) {
                    n.e(lowerBounds, "lowerBounds");
                    length = i.N(lowerBounds);
                    n.e(length, "lowerBounds.single()");
                    i = w.a.a((Type)length);
                } else {
                    n.e(upperBounds, "upperBounds");
                    upperBounds = i.N(upperBounds);
                    if (upperBounds.length == i2 && !n.b((Type)upperBounds, Object.class)) {
                        n.e(upperBounds, "upperBounds");
                        upperBounds = i.N(upperBounds);
                        if (!n.b((Type)upperBounds, Object.class)) {
                            n.e(upperBounds, "ub");
                            i = upperBounds;
                        }
                    }
                }
                return i;
            }
        }
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException(n.o("Wildcard types with many bounds are not yet supported: ", S()));
        throw unsupportedOperationException;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.l1.b.w
    protected WildcardType S() {
        return this.b;
    }

    public Collection<a> getAnnotations() {
        return this.c;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.l1.b.w
    public boolean n() {
        return this.d;
    }
}
