package kotlin.i0.z.e.m0.j.b;

import kotlin.d0.d.n;
import kotlin.i0.z.e.m0.e.j;
import kotlin.i0.z.e.m0.e.x;
import kotlin.reflect.jvm.internal.impl.descriptors.b.a;
import kotlin.reflect.jvm.internal.impl.descriptors.t;
import kotlin.reflect.jvm.internal.impl.descriptors.u;

/* loaded from: classes3.dex */
public final class z {

    public class a {

        public static final int[] a;
        public static final int[] b;
        static {
            int[] iArr = new int[values.length];
            int i = 1;
            iArr[j.DECLARATION.ordinal()] = i;
            final int i4 = 2;
            iArr[j.FAKE_OVERRIDE.ordinal()] = i4;
            final int i5 = 3;
            iArr[j.DELEGATION.ordinal()] = i5;
            final int i6 = 4;
            iArr[j.SYNTHESIZED.ordinal()] = i6;
            z.a.a = iArr;
            int[] iArr2 = new int[values2.length];
            iArr2[b.a.DECLARATION.ordinal()] = i;
            iArr2[b.a.FAKE_OVERRIDE.ordinal()] = i4;
            iArr2[b.a.DELEGATION.ordinal()] = i5;
            iArr2[b.a.SYNTHESIZED.ordinal()] = i6;
            int[] iArr3 = new int[values3.length];
            iArr3[x.INTERNAL.ordinal()] = i;
            iArr3[x.PRIVATE.ordinal()] = i4;
            iArr3[x.PRIVATE_TO_THIS.ordinal()] = i5;
            iArr3[x.PROTECTED.ordinal()] = i6;
            iArr3[x.PUBLIC.ordinal()] = 5;
            iArr3[x.LOCAL.ordinal()] = 6;
            z.a.b = iArr3;
        }
    }
    public static final u a(kotlin.i0.z.e.m0.j.b.y y, x x2) {
        int obj1;
        int obj2;
        n.f(y, "<this>");
        if (x2 == 0) {
            obj1 = -1;
        } else {
            obj1 = z.a.b[x2.ordinal()];
        }
        obj2 = "PRIVATE";
        switch (obj1) {
            case 1:
                n.e(t.d, "INTERNAL");
                break;
            case 2:
                n.e(t.a, obj2);
                break;
            case 3:
                n.e(t.b, "PRIVATE_TO_THIS");
                break;
            case 4:
                n.e(t.c, "PROTECTED");
                break;
            case 5:
                n.e(t.e, "PUBLIC");
                break;
            case 6:
                n.e(t.f, "LOCAL");
                break;
            default:
                n.e(t.a, obj2);
        }
        return obj1;
    }

    public static final b.a b(kotlin.i0.z.e.m0.j.b.y y, j j2) {
        int obj1;
        int obj2;
        n.f(y, "<this>");
        if (j2 == 0) {
            obj1 = -1;
        } else {
            obj1 = z.a.a[j2.ordinal()];
        }
        if (obj1 != 1) {
            if (obj1 != 2) {
                if (obj1 != 3) {
                    obj1 = obj1 != 4 ? b.a.DECLARATION : b.a.SYNTHESIZED;
                } else {
                    obj1 = b.a.DELEGATION;
                }
            } else {
                obj1 = b.a.FAKE_OVERRIDE;
            }
        } else {
            obj1 = b.a.DECLARATION;
        }
        return obj1;
    }
}
