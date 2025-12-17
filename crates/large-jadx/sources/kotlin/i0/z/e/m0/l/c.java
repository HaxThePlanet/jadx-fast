package kotlin.i0.z.e.m0.l;

import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import kotlin.d0.d.n;
import kotlin.i0.z.e.m0.l.l1.i;
import kotlin.i0.z.e.m0.l.l1.l;
import kotlin.i0.z.e.m0.l.l1.n;
import kotlin.y.p;

/* loaded from: classes3.dex */
public final class c {

    public static final kotlin.i0.z.e.m0.l.c a;
    static {
        c cVar = new c();
        c.a = cVar;
    }

    private final boolean c(kotlin.i0.z.e.m0.l.f f, i i2, l l3) {
        boolean z;
        final int i = 1;
        if (f.B0(i2)) {
            return i;
        }
        if (f.I(i2)) {
            return 0;
        }
        if (f.C0() && f.V(i2)) {
            if (f.V(i2)) {
                return i;
            }
        }
        return f.f0(f.b(i2), l3);
    }

    private final boolean e(kotlin.i0.z.e.m0.l.f f, i i2, i i3) {
        boolean z3;
        boolean z2;
        boolean z;
        if (e.b && !f.C(i2) && !f.K(f.b(i2))) {
            if (!f.C(i2)) {
                if (!f.K(f.b(i2))) {
                    z = f.v0(i2);
                }
            }
            if (!f.C(i3)) {
                z3 = f.v0(i3);
            }
        }
        int i = 1;
        if (f.I(i3)) {
            return i;
        }
        if (f.x0(i2)) {
            return i;
        }
        if (i2 instanceof c && f.i((c)i2)) {
            if (f.i((c)i2)) {
                return i;
            }
        }
        if (a(f, i2, f.b.b.a)) {
            return i;
        }
        int i4 = 0;
        if (f.x0(i3)) {
            return i4;
        }
        if (a(f, i3, f.b.d.a)) {
            return i4;
        }
        if (f.w0(i2)) {
            return i4;
        }
        return b(f, i2, f.b(i3));
    }

    public final boolean a(kotlin.i0.z.e.m0.l.f f, i i2, kotlin.i0.z.e.m0.l.f.b f$b3) {
        boolean z;
        int i3;
        int i;
        Set set;
        Iterator iterator;
        int i5;
        int next;
        int i4;
        boolean z2;
        n.f(f, "<this>");
        n.f(i2, "type");
        n.f(b3, "supertypesPolicy");
        i = 0;
        final int i6 = 1;
        if (f.w0(i2)) {
            if (f.I(i2)) {
                i3 = f.x0(i2) ? i6 : i;
            } else {
            }
        } else {
        }
        if (i3 != 0) {
            i = i6;
        } else {
            f.u0();
            i3 = f.r0();
            n.d(i3);
            set = f.s0();
            n.d(set);
            i3.push(i2);
            while (empty ^= i6 != 0) {
                iterator = i3.pop();
                n.e((i)iterator, "current");
                if (f.I(iterator)) {
                } else {
                }
                i5 = b3;
                if (z4 ^= i6 != 0) {
                } else {
                }
                i5 = 0;
                iterator = f.n(f.b(iterator)).iterator();
                while (iterator.hasNext()) {
                    next = i5.a(f, (h)iterator.next());
                    if (f.w0(next)) {
                    } else {
                    }
                    if (f.x0(next)) {
                    } else {
                    }
                    i4 = i;
                    i3.add(next);
                    i4 = i6;
                    if (f.I(next)) {
                    } else {
                    }
                }
                next = i5.a(f, (h)iterator.next());
                if (f.w0(next)) {
                } else {
                }
                if (f.x0(next)) {
                } else {
                }
                i4 = i;
                i3.add(next);
                i4 = i6;
                if (f.I(next)) {
                } else {
                }
                i5 = f.b.c.a;
            }
            f.m0();
        }
        return i;
    }

    public final boolean b(kotlin.i0.z.e.m0.l.f f, i i2, l l3) {
        boolean z;
        int i;
        Set set;
        Iterator iterator;
        kotlin.i0.z.e.m0.l.f.b.b bVar;
        int next;
        boolean z2;
        n.f(f, "<this>");
        n.f(i2, "start");
        n.f(l3, "end");
        i = 1;
        if (c(f, i2, l3)) {
        } else {
            f.u0();
            z = f.r0();
            n.d(z);
            set = f.s0();
            n.d(set);
            z.push(i2);
            while (empty ^= i != 0) {
                iterator = z.pop();
                n.e((i)iterator, "current");
                if (f.I(iterator)) {
                } else {
                }
                bVar = f.b.b.a;
                if (z4 ^= i != 0) {
                } else {
                }
                bVar = 0;
                iterator = f.n(f.b(iterator)).iterator();
                for (h next2 : iterator) {
                    next = bVar.a(f, next2);
                    z.add(next);
                }
                next = bVar.a(f, (h)iterator.next());
                z.add(next);
                bVar = f.b.c.a;
            }
            f.m0();
            i = 0;
        }
        return i;
    }

    public final boolean d(kotlin.i0.z.e.m0.l.f f, i i2, i i3) {
        n.f(f, "context");
        n.f(i2, "subType");
        n.f(i3, "superType");
        return e(f, i2, i3);
    }
}
