package kotlin.i0.z.e.m0.l.l1;

import kotlin.NoWhenBranchMatchedException;
import kotlin.d0.d.n;
import kotlin.i0.z.e.m0.l.h1;

/* loaded from: classes3.dex */
public final class o {

    public class a {

        public static final int[] a;
        static {
            int[] iArr = new int[values.length];
            iArr[h1.INVARIANT.ordinal()] = 1;
            iArr[h1.IN_VARIANCE.ordinal()] = 2;
            iArr[h1.OUT_VARIANCE.ordinal()] = 3;
            o.a.a = iArr;
        }
    }
    public static final kotlin.i0.z.e.m0.l.l1.r a(h1 h1) {
        int i;
        kotlin.i0.z.e.m0.l.l1.r obj1;
        n.f(h1, "<this>");
        obj1 = o.a.a[h1.ordinal()];
        if (obj1 != 1) {
            if (obj1 != 2) {
                if (obj1 != 3) {
                } else {
                    obj1 = r.OUT;
                }
                obj1 = new NoWhenBranchMatchedException();
                throw obj1;
            }
            obj1 = r.IN;
        } else {
            obj1 = r.INV;
        }
        return obj1;
    }
}
