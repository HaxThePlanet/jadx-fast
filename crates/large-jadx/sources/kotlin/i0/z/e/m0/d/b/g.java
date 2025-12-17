package kotlin.i0.z.e.m0.d.b;

import kotlin.d0.d.n;
import kotlin.i0.z.e.m0.d.a.g0.m.f;
import kotlin.i0.z.e.m0.e.a0.a;
import kotlin.i0.z.e.m0.e.q;
import kotlin.i0.z.e.m0.j.b.q;
import kotlin.i0.z.e.m0.l.b0;
import kotlin.i0.z.e.m0.l.c0;
import kotlin.i0.z.e.m0.l.i0;
import kotlin.i0.z.e.m0.l.t;
import kotlin.reflect.jvm.internal.impl.protobuf.h.d;

/* loaded from: classes3.dex */
public final class g implements q {

    public static final kotlin.i0.z.e.m0.d.b.g a;
    static {
        g gVar = new g();
        g.a = gVar;
    }

    @Override // kotlin.i0.z.e.m0.j.b.q
    public b0 a(q q, String string2, i0 i03, i0 i04) {
        n.f(q, "proto");
        n.f(string2, "flexibleId");
        n.f(i03, "lowerBound");
        n.f(i04, "upperBound");
        if (!n.b(string2, "kotlin.jvm.PlatformType")) {
            StringBuilder obj2 = new StringBuilder();
            obj2.append("Error java flexible type with id: ");
            obj2.append(string2);
            obj2.append(". (");
            obj2.append(i03);
            obj2.append("..");
            obj2.append(i04);
            obj2.append(')');
            obj2 = t.j(obj2.toString());
            n.e(obj2, "createErrorType(\"Error java flexible type with id: $flexibleId. ($lowerBound..$upperBound)\")");
            return obj2;
        }
        if (q.r(a.g)) {
            obj2 = new f(i03, i04);
            return obj2;
        }
        obj2 = c0.a;
        return c0.d(i03, i04);
    }
}
