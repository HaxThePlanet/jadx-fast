package kotlin.i0.z.e.m0.m;

import java.util.Collection;
import java.util.Iterator;
import kotlin.d0.d.n;
import kotlin.i0.z.e.m0.i.s.a;
import kotlin.reflect.jvm.internal.impl.descriptors.a;
import kotlin.reflect.jvm.internal.impl.descriptors.c1;
import kotlin.reflect.jvm.internal.impl.descriptors.x;

/* loaded from: classes3.dex */
final class h implements kotlin.i0.z.e.m0.m.b {

    public static final kotlin.i0.z.e.m0.m.h a = null;
    private static final String b = "should not have varargs or parameters with default values";
    static {
        h hVar = new h();
        h.a = hVar;
    }

    @Override // kotlin.i0.z.e.m0.m.b
    public String a(x x) {
        return b.a.a(this, x);
    }

    @Override // kotlin.i0.z.e.m0.m.b
    public String b() {
        return h.b;
    }

    @Override // kotlin.i0.z.e.m0.m.b
    public boolean c(x x) {
        boolean empty;
        Object next;
        int i;
        boolean z;
        Object obj5;
        n.f(x, "functionDescriptor");
        obj5 = x.h();
        n.e(obj5, "functionDescriptor.valueParameters");
        final int i2 = 1;
        if (obj5 instanceof Collection != null && obj5.isEmpty()) {
            if (obj5.isEmpty()) {
                i = i2;
            } else {
                obj5 = obj5.iterator();
                while (obj5.hasNext()) {
                    next = obj5.next();
                    n.e((c1)next, "it");
                    if (!a.a(next) && next.l0() == null) {
                    } else {
                    }
                    empty = i;
                    if (empty) {
                        break;
                    }
                    if (next.l0() == null) {
                    } else {
                    }
                    empty = i2;
                }
            }
        } else {
        }
        return i;
    }
}
