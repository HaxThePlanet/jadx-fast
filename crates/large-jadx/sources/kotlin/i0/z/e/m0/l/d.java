package kotlin.i0.z.e.m0.l;

import kotlin.d0.d.n;
import kotlin.i0.z.e.m0.l.l1.h;
import kotlin.i0.z.e.m0.l.l1.i;
import kotlin.i0.z.e.m0.l.l1.n;
import kotlin.i0.z.e.m0.l.l1.q;

/* loaded from: classes3.dex */
public final class d {

    public static final kotlin.i0.z.e.m0.l.d a;
    static {
        d dVar = new d();
        d.a = dVar;
    }

    private final boolean a(n n, i i2, i i3) {
        int i4;
        int i6;
        int i;
        int i7;
        int i5;
        kotlin.i0.z.e.m0.l.l1.k kVar;
        boolean z;
        boolean z2;
        final int i9 = 0;
        if (n.h(i2) == n.h(i3) && n.I(i2) == n.I(i3)) {
            if (n.I(i2) == n.I(i3)) {
                i6 = 1;
                i4 = n.a0(i2) == null ? i6 : i9;
                i = n.a0(i3) == null ? i6 : i9;
                if (i4 == i) {
                    if (!n.f0(n.b(i2), n.b(i3))) {
                    } else {
                        if (n.b0(i2, i3)) {
                            return i6;
                        }
                        int i8 = n.h(i2);
                        if (i8 > 0) {
                            i7 = i9;
                            i5 = i7 + 1;
                            kVar = n.P(i2, i7);
                            i = n.P(i3, i7);
                            while (n.y(kVar) != n.y(i)) {
                                i7 = i5;
                                i5 = i7 + 1;
                                kVar = n.P(i2, i7);
                                i = n.P(i3, i7);
                            }
                            return i9;
                        }
                    }
                    return i6;
                }
            }
        }
        return i9;
    }

    private final boolean c(n n, h h2, h h3) {
        int i;
        n obj5;
        Object obj6;
        Object obj7;
        if (h2 == h3) {
            return 1;
        }
        i iVar = n.a(h2);
        i iVar2 = n.a(h3);
        if (iVar != null && iVar2 != null) {
            if (iVar2 != null) {
                return a(n, iVar, iVar2);
            }
        }
        obj6 = n.z(h2);
        obj7 = n.z(h3);
        int i2 = 0;
        if (obj6 != null && obj7 != null) {
            if (obj7 != null) {
                if (a(n, n.e(obj6), n.e(obj7)) && a(n, n.d(obj6), n.d(obj7))) {
                    if (a(n, n.d(obj6), n.d(obj7))) {
                    } else {
                        i = i2;
                    }
                } else {
                }
                return i;
            }
        }
        return i2;
    }

    public final boolean b(n n, h h2, h h3) {
        n.f(n, "context");
        n.f(h2, "a");
        n.f(h3, "b");
        return c(n, h2, h3);
    }
}
