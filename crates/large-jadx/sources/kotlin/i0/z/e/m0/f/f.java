package kotlin.i0.z.e.m0.f;

import kotlin.d0.d.n;
import kotlin.k0.h;

/* loaded from: classes3.dex */
public final class f {

    private static final h a;
    static {
        h hVar = new h("[^\\p{L}\\p{Digit}]");
        f.a = hVar;
    }

    public static final String a(String string) {
        n.f(string, "name");
        return f.a.e(string, "_");
    }
}
