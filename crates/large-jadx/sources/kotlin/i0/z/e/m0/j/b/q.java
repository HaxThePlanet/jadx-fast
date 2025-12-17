package kotlin.i0.z.e.m0.j.b;

import kotlin.d0.d.n;
import kotlin.i0.z.e.m0.e.q;
import kotlin.i0.z.e.m0.l.b0;
import kotlin.i0.z.e.m0.l.i0;

/* loaded from: classes3.dex */
public interface q {

    public static final class a implements kotlin.i0.z.e.m0.j.b.q {

        public static final kotlin.i0.z.e.m0.j.b.q.a a;
        static {
            q.a aVar = new q.a();
            q.a.a = aVar;
        }

        @Override // kotlin.i0.z.e.m0.j.b.q
        public b0 a(q q, String string2, i0 i03, i0 i04) {
            n.f(q, "proto");
            n.f(string2, "flexibleId");
            n.f(i03, "lowerBound");
            n.f(i04, "upperBound");
            IllegalArgumentException obj2 = new IllegalArgumentException("This method should not be used.");
            throw obj2;
        }
    }
    public abstract b0 a(q q, String string2, i0 i03, i0 i04);
}
