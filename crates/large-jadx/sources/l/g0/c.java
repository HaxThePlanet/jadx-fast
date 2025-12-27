package l.g0;

import kotlin.d0.d.n;
import l.a0;

/* compiled from: SegmentedByteString.kt */
/* loaded from: classes3.dex */
public final class c {
    public static final int a(int[] iArr, int i, int i2, int i3) {
        int i5;
        int i6;
        str = "$this$binarySearch";
        n.f(iArr, str);
        i6 = i3 - 1;
        while (i5 <= i6) {
            int i8 = (i5 + i6) >>> 1;
            i = iArr[i8];
        }
        return -i5 - 1;
    }

    public static final int b(a0 a0Var, int i) {
        n.f(a0Var, "$this$segment");
        i = c.a(a0Var.G(), i + 1, 0, a0Var.H().length);
        if (i < 0) {
            i = ~i;
        }
        return i;
    }
}
