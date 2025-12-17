package kotlin.reflect.jvm.internal.impl.descriptors.l1.b;

import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Type;
import java.util.Collection;
import kotlin.d0.d.n;
import kotlin.i0.z.e.m0.d.a.i0.a;
import kotlin.i0.z.e.m0.d.a.i0.f;
import kotlin.i0.z.e.m0.d.a.i0.x;
import kotlin.y.p;

/* loaded from: classes3.dex */
public final class i extends kotlin.reflect.jvm.internal.impl.descriptors.l1.b.w implements f {

    private final Type b;
    private final kotlin.reflect.jvm.internal.impl.descriptors.l1.b.w c;
    private final Collection<a> d;
    private final boolean e;
    public i(Type type) {
        kotlin.reflect.jvm.internal.impl.descriptors.l1.b.w.a aVar;
        boolean array;
        String str;
        kotlin.reflect.jvm.internal.impl.descriptors.l1.b.w obj3;
        n.f(type, "reflectType");
        super();
        this.b = type;
        obj3 = Q();
        if (obj3 instanceof GenericArrayType) {
            obj3 = (GenericArrayType)obj3.getGenericComponentType();
            n.e(obj3, "genericComponentType");
            obj3 = w.a.a(obj3);
            this.c = obj3;
            this.d = p.g();
        } else {
            if (!obj3 instanceof Class) {
            } else {
                if (!(Class)obj3.isArray()) {
                } else {
                    obj3 = obj3.getComponentType();
                    n.e(obj3, "getComponentType()");
                    obj3 = w.a.a(obj3);
                }
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Not an array type (");
        stringBuilder.append(Q().getClass());
        stringBuilder.append("): ");
        stringBuilder.append(Q());
        obj3 = new IllegalArgumentException(stringBuilder.toString());
        throw obj3;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.l1.b.w
    protected Type Q() {
        return this.b;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.l1.b.w
    public kotlin.reflect.jvm.internal.impl.descriptors.l1.b.w R() {
        return this.c;
    }

    public Collection<a> getAnnotations() {
        return this.d;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.l1.b.w
    public boolean n() {
        return this.e;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.l1.b.w
    public x p() {
        return R();
    }
}
