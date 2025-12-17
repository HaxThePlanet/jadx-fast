package kotlin.i0.z.e.m0.e.a0.b;

import kotlin.d0.d.n;
import kotlin.i0.z.e.m0.e.z.a;

/* loaded from: classes3.dex */
public final class f extends a {

    public static final kotlin.i0.z.e.m0.e.a0.b.f g;
    private final boolean f;
    static {
        int[] iArr = new int[3];
        iArr = new int[]{1, 4, 2};
        f fVar = new f(iArr);
        f.g = fVar;
        f fVar2 = new f(new int[0]);
    }

    public f(int... iArr) {
        n.f(iArr, "numbers");
        super(iArr, 0);
    }

    public f(int[] iArr, boolean z2) {
        n.f(iArr, "versionArray");
        int[] iArr2 = new int[iArr.length];
        final int i = 0;
        System.arraycopy(iArr, i, iArr2, i, iArr.length);
        super(iArr2);
        this.f = z2;
    }

    @Override // kotlin.i0.z.e.m0.e.z.a
    public boolean h() {
        boolean i3;
        int i4;
        int i;
        kotlin.i0.z.e.m0.e.a0.b.f fVar;
        int i2;
        final int i5 = 1;
        if (a() == i5) {
            if (b() != 0) {
                if (this.f) {
                    i3 = f(f.g);
                } else {
                    fVar = f.g;
                    if (a() == fVar.a() && b() <= i6 += i5) {
                        i3 = b() <= i6 += i5 ? i5 : i;
                    } else {
                    }
                }
                if (i3) {
                    i = i5;
                }
            }
        } else {
        }
        return i;
    }
}
