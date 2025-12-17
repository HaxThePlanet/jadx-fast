package kotlin.reflect.jvm.internal.impl.descriptors.l1.a;

import kotlin.d0.d.n;
import kotlin.i0.z.e.m0.f.a;
import kotlin.i0.z.e.m0.f.b;
import kotlin.k0.l;

/* loaded from: classes3.dex */
public final class h {
    public static final String a(a a) {
        return h.b(a);
    }

    private static final String b(a a) {
        String string;
        boolean stringBuilder;
        int obj7;
        String str2 = a.i().b();
        n.e(str2, "relativeClassName.asString()");
        if (a.h().d()) {
        } else {
            stringBuilder = new StringBuilder();
            stringBuilder.append(a.h());
            stringBuilder.append('.');
            stringBuilder.append(l.F(str2, '.', '$', false, 4, 0));
            string = stringBuilder.toString();
        }
        return string;
    }
}
