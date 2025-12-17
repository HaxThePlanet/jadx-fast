package kotlin.i0.z.e.m0.m;

import java.util.List;
import kotlin.d0.d.n;
import kotlin.i0.z.e.m0.b.j;
import kotlin.i0.z.e.m0.b.j.b;
import kotlin.i0.z.e.m0.i.s.a;
import kotlin.i0.z.e.m0.l.m1.a;
import kotlin.reflect.jvm.internal.impl.descriptors.a;
import kotlin.reflect.jvm.internal.impl.descriptors.b1;
import kotlin.reflect.jvm.internal.impl.descriptors.x;

/* loaded from: classes3.dex */
final class e implements kotlin.i0.z.e.m0.m.b {

    public static final kotlin.i0.z.e.m0.m.e a = null;
    private static final String b = "second parameter must be of type KProperty<*> or its supertype";
    static {
        e eVar = new e();
        e.a = eVar;
    }

    @Override // kotlin.i0.z.e.m0.m.b
    public String a(x x) {
        return b.a.a(this, x);
    }

    @Override // kotlin.i0.z.e.m0.m.b
    public String b() {
        return e.b;
    }

    @Override // kotlin.i0.z.e.m0.m.b
    public boolean c(x x) {
        Object str;
        int obj3;
        n.f(x, "functionDescriptor");
        obj3 = x.h().get(1);
        n.e((c1)obj3, "secondParameter");
        kotlin.i0.z.e.m0.l.b0 b0Var = j.d.a(a.l(obj3));
        if (b0Var == null) {
            obj3 = 0;
        } else {
            obj3 = obj3.getType();
            n.e(obj3, "secondParameter.type");
            obj3 = a.g(b0Var, a.j(obj3));
        }
        return obj3;
    }
}
