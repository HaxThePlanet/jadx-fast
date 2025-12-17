package kotlin.i0.z.e.m0.b.p;

import java.util.List;
import kotlin.d0.d.n;
import kotlin.i0.z.e.m0.i.v.e;
import kotlin.i0.z.e.m0.k.n;
import kotlin.reflect.jvm.internal.impl.descriptors.x;
import kotlin.y.p;

/* loaded from: classes3.dex */
public final class d extends e {

    public class a {

        public static final int[] a;
        static {
            int[] iArr = new int[values.length];
            iArr[c.Function.ordinal()] = 1;
            iArr[c.SuspendFunction.ordinal()] = 2;
            d.a.a = iArr;
        }
    }
    public d(n n, kotlin.i0.z.e.m0.b.p.b b2) {
        n.f(n, "storageManager");
        n.f(b2, "containingClass");
        super(n, b2);
    }

    protected List<x> i() {
        List list;
        int i;
        kotlin.reflect.jvm.internal.impl.descriptors.e i2;
        int i3 = d.a.a[(b)l().T0().ordinal()];
        i = 1;
        if (i3 != i) {
            if (i3 != 2) {
                list = p.g();
            } else {
                list = p.b(e.V.a((b)l(), i));
            }
        } else {
            list = p.b(e.V.a((b)l(), false));
        }
        return list;
    }
}
