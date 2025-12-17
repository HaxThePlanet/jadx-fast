package kotlin.i0.z.e.m0.j.b.c0;

import java.io.InputStream;
import kotlin.d0.d.g;
import kotlin.d0.d.n;
import kotlin.i0.z.e.m0.b.b;
import kotlin.i0.z.e.m0.e.m;
import kotlin.i0.z.e.m0.e.y.a;
import kotlin.i0.z.e.m0.e.y.a.a;
import kotlin.i0.z.e.m0.f.b;
import kotlin.i0.z.e.m0.j.a;
import kotlin.i0.z.e.m0.j.b.o;
import kotlin.i0.z.e.m0.k.n;
import kotlin.io.b;
import kotlin.reflect.jvm.internal.impl.descriptors.c0;

/* loaded from: classes3.dex */
public final class c extends o implements b {

    public static final kotlin.i0.z.e.m0.j.b.c0.c.a E;

    public static final class a {
        public a(g g) {
            super();
        }

        public final kotlin.i0.z.e.m0.j.b.c0.c a(b b, n n2, c0 c03, InputStream inputStream4, boolean z5) {
            n.f(b, "fqName");
            n.f(n2, "storageManager");
            n.f(c03, "module");
            n.f(inputStream4, "inputStream");
            final a aVar3 = a.f.a(inputStream4);
            int i = 0;
            if (aVar3 == null) {
            } else {
                if (!aVar3.h()) {
                } else {
                    final m mVar = m.Q(inputStream4, a.m.e());
                    b.a(inputStream4, i);
                    n.e(mVar, "proto");
                    super(b, n2, c03, mVar, aVar3, z5, 0);
                    return obj13;
                }
                StringBuilder obj11 = new StringBuilder();
                obj11.append("Kotlin built-in definition format version is not supported: expected ");
                obj11.append(a.g);
                obj11.append(", actual ");
                obj11.append(aVar3);
                obj11.append(". Please update Kotlin");
                UnsupportedOperationException obj10 = new UnsupportedOperationException(obj11.toString());
                throw obj10;
            }
            n.w("version");
            throw i;
        }
    }
    static {
        c.a aVar = new c.a(0);
        c.E = aVar;
    }

    private c(b b, n n2, c0 c03, m m4, a a5, boolean z6) {
        super(b, n2, c03, m4, a5, 0);
    }

    public c(b b, n n2, c0 c03, m m4, a a5, boolean z6, g g7) {
        super(b, n2, c03, m4, a5, z6);
    }
}
