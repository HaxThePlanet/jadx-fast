package kotlin.i0.z.e.m0.k;

import kotlin.d0.c.l;
import kotlin.w;

/* loaded from: classes3.dex */
public interface k {

    public static final kotlin.i0.z.e.m0.k.k.a a;

    public static final class a {

        static final kotlin.i0.z.e.m0.k.k.a a;
        static {
            k.a aVar = new k.a();
            k.a.a = aVar;
        }

        public final kotlin.i0.z.e.m0.k.d a(Runnable runnable, l<? super java.lang.InterruptedException, w> l2) {
            kotlin.i0.z.e.m0.k.d dVar;
            int obj2;
            int obj3;
            if (runnable != null && l2 != null) {
                if (l2 != null) {
                    dVar = new c(runnable, l2);
                } else {
                    obj3 = 0;
                    dVar = new d(obj3, 1, obj3);
                }
            } else {
            }
            return dVar;
        }
    }
    static {
        k.a = k.a.a;
    }

    public abstract void lock();

    public abstract void unlock();
}
