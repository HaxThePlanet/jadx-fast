package kotlin.reflect.jvm.internal.impl.descriptors.l1.a;

import java.util.Set;
import kotlin.d0.d.n;
import kotlin.i0.z.e.m0.d.a.i0.g;
import kotlin.i0.z.e.m0.d.a.i0.u;
import kotlin.i0.z.e.m0.d.a.q;
import kotlin.i0.z.e.m0.d.a.q.a;
import kotlin.i0.z.e.m0.f.a;
import kotlin.i0.z.e.m0.f.b;
import kotlin.k0.l;
import kotlin.reflect.jvm.internal.impl.descriptors.l1.b.j;
import kotlin.reflect.jvm.internal.impl.descriptors.l1.b.u;

/* loaded from: classes3.dex */
public final class d implements q {

    private final java.lang.ClassLoader a;
    public d(java.lang.ClassLoader classLoader) {
        n.f(classLoader, "classLoader");
        super();
        this.a = classLoader;
    }

    @Override // kotlin.i0.z.e.m0.d.a.q
    public g a(q.a q$a) {
        b bVar;
        int jVar;
        boolean stringBuilder;
        String obj8;
        n.f(a, "request");
        obj8 = a.a();
        bVar = obj8.h();
        n.e(bVar, "classId.packageFqName");
        String str4 = obj8.i().b();
        n.e(str4, "classId.relativeClassName.asString()");
        if (bVar.d()) {
        } else {
            stringBuilder = new StringBuilder();
            stringBuilder.append(bVar.b());
            stringBuilder.append('.');
            stringBuilder.append(l.F(str4, '.', '$', false, 4, 0));
            obj8 = stringBuilder.toString();
        }
        obj8 = e.a(this.a, obj8);
        if (obj8 != null) {
            jVar = new j(obj8);
        } else {
            jVar = 0;
        }
        return jVar;
    }

    @Override // kotlin.i0.z.e.m0.d.a.q
    public u b(b b) {
        n.f(b, "fqName");
        u uVar = new u(b);
        return uVar;
    }

    public Set<String> c(b b) {
        n.f(b, "packageFqName");
        return 0;
    }
}
