package kotlin.i0.z.e.m0.e.a0.b;

import kotlin.d0.d.n;
import kotlin.i0.z.e.m0.e.z.a;

/* loaded from: classes3.dex */
public final class c extends a {

    public static final kotlin.i0.z.e.m0.e.a0.b.c f;
    static {
        int[] iArr = new int[3];
        iArr = new int[]{1, 0, 3};
        c cVar = new c(iArr);
        c.f = cVar;
        c cVar2 = new c(new int[0]);
    }

    public c(int... iArr) {
        n.f(iArr, "numbers");
        int[] iArr2 = new int[iArr.length];
        final int i = 0;
        System.arraycopy(iArr, i, iArr2, i, iArr.length);
        super(iArr2);
    }
}
