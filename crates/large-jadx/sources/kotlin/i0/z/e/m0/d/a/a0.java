package kotlin.i0.z.e.m0.d.a;

import java.util.List;
import kotlin.d0.d.n;
import kotlin.i0.z.e.m0.f.e;
import kotlin.i0.z.e.m0.m.m.a;
import kotlin.k0.l;
import kotlin.y.p;

/* loaded from: classes3.dex */
public final class a0 {
    public static final List<e> a(e e) {
        n.f(e, "name");
        String str2 = e.c();
        n.e(str2, "name.asString()");
        kotlin.i0.z.e.m0.d.a.x xVar = x.a;
        if (x.b(str2)) {
            return p.k(a0.b(e));
        }
        if (x.c(str2)) {
            return a0.f(e);
        }
        return g.a.b(e);
    }

    public static final e b(e e) {
        e eVar;
        Object obj;
        String str;
        int i2;
        int i3;
        int i4;
        int i;
        n.f(e, "methodName");
        if (a0.e(e, "get", false, 0, 12, 0) == null) {
            eVar = a0.e(e, "is", false, 0, 8, 0);
        }
        return eVar;
    }

    public static final e c(e e, boolean z2) {
        String obj7;
        n.f(e, "methodName");
        obj7 = z2 ? "is" : 0;
        return a0.e(e, "set", false, obj7, 4, 0);
    }

    private static final e d(e e, String string2, boolean z3, String string4) {
        int i;
        int i2;
        final int i3 = 0;
        if (e.k()) {
            return i3;
        }
        String str = e.f();
        n.e(str, "methodName.identifier");
        if (!l.M(str, string2, false, 2, i3)) {
            return i3;
        }
        if (str.length() == string2.length()) {
            return i3;
        }
        char charAt = str.charAt(string2.length());
        final int i5 = 1;
        if (97 <= charAt && charAt <= 122) {
            if (charAt <= 122) {
                i = i5;
            }
        }
        if (i != 0) {
            return i3;
        }
        if (string4 != null) {
            return e.j(n.o(string4, l.u0(str, string2)));
        }
        if (!z3) {
            return e;
        }
        String obj6 = a.c(l.u0(str, string2), i5);
        if (!e.m(obj6)) {
            return i3;
        }
        return e.j(obj6);
    }

    static e e(e e, String string2, boolean z3, String string4, int i5, Object object6) {
        int obj2;
        int obj3;
        if (i5 & 4 != 0) {
            obj2 = 1;
        }
        if (i5 &= 8 != 0) {
            obj3 = 0;
        }
        return a0.d(e, string2, obj2, obj3);
    }

    public static final List<e> f(e e) {
        n.f(e, "methodName");
        e[] arr = new e[2];
        int i2 = 0;
        arr[i2] = a0.c(e, i2);
        int i3 = 1;
        arr[i3] = a0.c(e, i3);
        return p.l(arr);
    }
}
