package kotlin.i0.z.e.m0.d.a.i0;

import java.util.Iterator;
import kotlin.d0.d.n;
import kotlin.i0.z.e.m0.f.a;
import kotlin.i0.z.e.m0.f.b;

/* loaded from: classes3.dex */
public interface d0 extends kotlin.i0.z.e.m0.d.a.i0.d {

    public static final class a {
        public static kotlin.i0.z.e.m0.d.a.i0.a a(kotlin.i0.z.e.m0.d.a.i0.d0 d0, b b2) {
            String next;
            boolean z;
            int i;
            a aVar;
            n.f(d0, "this");
            n.f(b2, "fqName");
            Iterator obj3 = d0.getAnnotations().iterator();
            i = 0;
            while (obj3.hasNext()) {
                next = obj3.next();
                aVar = (a)next.e();
                if (aVar == null) {
                } else {
                }
                i = aVar.b();
                if (n.b(i, b2)) {
                    break;
                } else {
                }
                i = 0;
            }
            return (a)i;
        }
    }
}
