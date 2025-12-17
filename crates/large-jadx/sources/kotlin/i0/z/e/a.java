package kotlin.i0.z.e;

import kotlin.d0.d.n;
import kotlin.reflect.jvm.internal.impl.descriptors.a;
import kotlin.reflect.jvm.internal.impl.descriptors.d1;
import kotlin.reflect.jvm.internal.impl.descriptors.j1.l;
import kotlin.reflect.jvm.internal.impl.descriptors.o0;
import kotlin.reflect.jvm.internal.impl.descriptors.x;
import kotlin.w;

/* loaded from: classes3.dex */
public class a extends l<kotlin.i0.z.e.f<?>, w> {

    private final kotlin.i0.z.e.j a;
    public a(kotlin.i0.z.e.j j) {
        n.f(j, "container");
        super();
        this.a = j;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.l
    public Object d(o0 o0, Object object2) {
        return q(o0, (w)object2);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1.l
    public Object g(x x, Object object2) {
        return p(x, (w)object2);
    }

    public kotlin.i0.z.e.f<?> p(x x, w w2) {
        n.f(x, "descriptor");
        n.f(w2, "data");
        k obj3 = new k(this.a, x);
        return obj3;
    }

    public kotlin.i0.z.e.f<?> q(o0 o0, w w2) {
        int i;
        int obj5;
        n.f(o0, "descriptor");
        n.f(w2, "data");
        int i2 = 1;
        obj5 = o0.f0() != null ? i2 : i;
        if (o0.m0() != null) {
            i = i2;
        }
        obj5 += i;
        int i3 = 2;
        if (o0.j0() && obj5 != null && obj5 != i2) {
            if (obj5 != null) {
                if (obj5 != i2) {
                    if (obj5 != i3) {
                    } else {
                        obj5 = new n(this.a, o0);
                        return obj5;
                    }
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("Unsupported property: ");
                    stringBuilder.append(o0);
                    obj5 = new a0(stringBuilder.toString());
                    throw obj5;
                }
                obj5 = new m(this.a, o0);
                return obj5;
            }
            obj5 = new l(this.a, o0);
            return obj5;
        }
        if (obj5 != null && obj5 != i2) {
            if (obj5 != i2) {
                if (obj5 != i3) {
                } else {
                    obj5 = new s(this.a, o0);
                    return obj5;
                }
            }
            obj5 = new r(this.a, o0);
            return obj5;
        }
        obj5 = new q(this.a, o0);
        return obj5;
    }
}
