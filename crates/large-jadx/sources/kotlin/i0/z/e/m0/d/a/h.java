package kotlin.i0.z.e.m0.d.a;

import kotlin.d0.d.n;
import kotlin.i0.z.e.m0.f.b;
import kotlin.i0.z.e.m0.f.c;
import kotlin.i0.z.e.m0.f.e;

/* loaded from: classes3.dex */
public final class h {
    public static final b a(b b, String string2) {
        return h.c(b, string2);
    }

    public static final b b(c c, String string2) {
        return h.d(c, string2);
    }

    private static final b c(b b, String string2) {
        final b obj0 = b.c(e.j(string2));
        n.e(obj0, "child(Name.identifier(name))");
        return obj0;
    }

    private static final b d(c c, String string2) {
        b obj0 = c.c(e.j(string2)).l();
        n.e(obj0, "child(Name.identifier(name)).toSafe()");
        return obj0;
    }
}
