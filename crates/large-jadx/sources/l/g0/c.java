package l.g0;

import kotlin.d0.d.n;
import l.a0;

/* loaded from: classes3.dex */
public final class c {
    public static final int a(int[] iArr, int i2, int i3, int i4) {
        String str;
        int i;
        int obj4;
        int obj5;
        n.f(iArr, "$this$binarySearch");
        i4--;
        while (obj4 <= obj5) {
            i5 >>>= 1;
            i = iArr[i6];
            obj5 = str;
            obj4 = str;
        }
        return obj2--;
    }

    public static final int b(a0 a0, int i2) {
        int obj2;
        n.f(a0, "$this$segment");
        obj2 = c.a(a0.G(), i2++, 0, obj2.length);
        if (obj2 >= 0) {
        } else {
            obj2 = ~obj2;
        }
        return obj2;
    }
}
