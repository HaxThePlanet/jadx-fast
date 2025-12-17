package kotlin.i0.z.e.m0.c;

import kotlin.d0.d.n;
import kotlin.i0.z.e.m0.c.b.a;
import kotlin.i0.z.e.m0.c.b.b;
import kotlin.i0.z.e.m0.c.b.c;
import kotlin.i0.z.e.m0.c.b.c.a;
import kotlin.i0.z.e.m0.c.b.e;
import kotlin.i0.z.e.m0.c.b.e.a;
import kotlin.i0.z.e.m0.c.b.f;
import kotlin.i0.z.e.m0.f.b;
import kotlin.i0.z.e.m0.f.c;
import kotlin.i0.z.e.m0.f.e;
import kotlin.i0.z.e.m0.i.d;
import kotlin.reflect.jvm.internal.impl.descriptors.e;
import kotlin.reflect.jvm.internal.impl.descriptors.f0;

/* loaded from: classes3.dex */
public final class a {
    public static final void a(c c, b b2, e e3, e e4) {
        e position;
        n.f(c, "<this>");
        n.f(b2, "from");
        n.f(e3, "scopeOwner");
        n.f(e4, "name");
        if (c == c.a.a) {
        }
        a obj8 = b2.getLocation();
        if (obj8 == null) {
        }
        if (c.a()) {
            position = obj8.getPosition();
        } else {
            position = e.a.a();
        }
        final String str6 = d.m(e3).b();
        n.e(str6, "getFqName(scopeOwner).asString()");
        final String str7 = e4.c();
        n.e(str7, "name.asString()");
        c.b(obj8.a(), position, str6, f.CLASSIFIER, str7);
    }

    public static final void b(c c, b b2, f0 f03, e e4) {
        n.f(c, "<this>");
        n.f(b2, "from");
        n.f(f03, "scopeOwner");
        n.f(e4, "name");
        String obj3 = f03.d().b();
        n.e(obj3, "scopeOwner.fqName.asString()");
        final String obj4 = e4.c();
        n.e(obj4, "name.asString()");
        a.c(c, b2, obj3, obj4);
    }

    public static final void c(c c, b b2, String string3, String string4) {
        e position;
        n.f(c, "<this>");
        n.f(b2, "from");
        n.f(string3, "packageFqName");
        n.f(string4, "name");
        if (c == c.a.a) {
        }
        final a obj8 = b2.getLocation();
        if (obj8 == null) {
        }
        if (c.a()) {
            position = obj8.getPosition();
        } else {
            position = e.a.a();
        }
        c.b(obj8.a(), position, string3, f.PACKAGE, string4);
    }
}
