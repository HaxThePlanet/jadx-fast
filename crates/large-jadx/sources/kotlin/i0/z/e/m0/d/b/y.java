package kotlin.i0.z.e.m0.d.b;

import kotlin.d0.d.g;
import kotlin.d0.d.n;
import kotlin.i0.z.e.m0.l.h1;

/* loaded from: classes3.dex */
public final class y {

    public static final kotlin.i0.z.e.m0.d.b.y k;
    public static final kotlin.i0.z.e.m0.d.b.y l;
    public static final kotlin.i0.z.e.m0.d.b.y m;
    private final boolean a;
    private final boolean b;
    private final boolean c;
    private final boolean d;
    private final boolean e;
    private final kotlin.i0.z.e.m0.d.b.y f;
    private final boolean g;
    private final kotlin.i0.z.e.m0.d.b.y h;
    private final kotlin.i0.z.e.m0.d.b.y i;
    private final boolean j;

    public class a {

        public static final int[] a;
        static {
            int[] iArr = new int[values.length];
            iArr[h1.IN_VARIANCE.ordinal()] = 1;
            iArr[h1.INVARIANT.ordinal()] = 2;
            y.a.a = iArr;
        }
    }
    static {
        final int i = 0;
        final int i2 = 0;
        final int i3 = 0;
        final int i4 = 0;
        final int i5 = 0;
        final int i7 = 0;
        final int i8 = 0;
        final int i9 = 0;
        final int i10 = 0;
        final int i13 = 0;
        super(i, i2, i3, i4, i5, 0, i7, i8, i9, i10, 1023, i13);
        y.k = yVar5;
        super(0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 511, 0);
        y.l = yVar2;
        y yVar3 = new y(i, i2, i3, i4, i5, yVar5, i7, i8, i9, i10, 988, i13);
        y.m = yVar7;
    }

    public y(boolean z, boolean z2, boolean z3, boolean z4, boolean z5, kotlin.i0.z.e.m0.d.b.y y6, boolean z7, kotlin.i0.z.e.m0.d.b.y y8, kotlin.i0.z.e.m0.d.b.y y9, boolean z10) {
        super();
        this.a = z;
        this.b = z2;
        this.c = z3;
        this.d = z4;
        this.e = z5;
        this.f = y6;
        this.g = z7;
        this.h = y8;
        this.i = y9;
        this.j = z10;
    }

    public y(boolean z, boolean z2, boolean z3, boolean z4, boolean z5, kotlin.i0.z.e.m0.d.b.y y6, boolean z7, kotlin.i0.z.e.m0.d.b.y y8, kotlin.i0.z.e.m0.d.b.y y9, boolean z10, int i11, g g12) {
        int i2;
        int i3;
        int i;
        int i4;
        int i7;
        int i6;
        int i8;
        int i5;
        int i9;
        int i10;
        int i12 = i11;
        i3 = 1;
        i2 = i12 & 1 != 0 ? i3 : z;
        i = i12 & 2 != 0 ? i3 : z2;
        i7 = 0;
        i4 = i12 & 4 != 0 ? i7 : z3;
        i6 = i12 & 8 != 0 ? i7 : z4;
        i8 = i12 & 16 != 0 ? i7 : z5;
        i5 = i12 & 32 != 0 ? 0 : y6;
        if (i12 & 64 != 0) {
        } else {
            i3 = z7;
        }
        i9 = i12 & 128 != 0 ? i5 : y8;
        i10 = i12 & 256 != 0 ? i5 : y9;
        if (i12 &= 512 != 0) {
        } else {
            i7 = z10;
        }
        super(i2, i, i4, i6, i8, i5, i3, i9, i10, i7);
    }

    public final boolean a() {
        return this.g;
    }

    public final boolean b() {
        return this.j;
    }

    public final boolean c() {
        return this.b;
    }

    public final boolean d() {
        return this.a;
    }

    public final boolean e() {
        return this.c;
    }

    public final kotlin.i0.z.e.m0.d.b.y f(h1 h1, boolean z2) {
        Object obj2;
        boolean obj3;
        n.f(h1, "effectiveVariance");
        if (z2 && this.c) {
            if (this.c) {
                obj2 = this;
            } else {
                obj2 = y.a.a[h1.ordinal()];
                if (obj2 != 1) {
                    if (obj2 != 2) {
                        if (this.f == null) {
                        }
                    } else {
                        if (this.i == null) {
                        }
                    }
                } else {
                    if (this.h == null) {
                    }
                }
            }
        } else {
        }
        return obj2;
    }

    public final kotlin.i0.z.e.m0.d.b.y g() {
        super(this.a, 1, this.c, this.d, this.e, this.f, this.g, this.h, this.i, 0, 512, 0);
        return yVar5;
    }
}
