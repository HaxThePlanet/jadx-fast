package kotlin.reflect.jvm.internal.impl.descriptors.h1;

import java.util.Map;
import kotlin.d0.d.n;
import kotlin.i0.z.e.m0.f.b;
import kotlin.i0.z.e.m0.f.e;
import kotlin.i0.z.e.m0.i.q.g;
import kotlin.i0.z.e.m0.i.s.a;
import kotlin.i0.z.e.m0.l.b0;
import kotlin.i0.z.e.m0.l.t;
import kotlin.reflect.jvm.internal.impl.descriptors.u0;

/* loaded from: classes3.dex */
public interface c {

    public static final class a {
        public static b a(kotlin.reflect.jvm.internal.impl.descriptors.h1.c c) {
            b i;
            boolean z;
            kotlin.reflect.jvm.internal.impl.descriptors.e obj2;
            n.f(c, "this");
            obj2 = a.f(c);
            if (obj2 == null) {
            } else {
                if (!t.r(obj2)) {
                } else {
                    obj2 = i;
                }
                if (obj2 == null) {
                } else {
                    i = a.e(obj2);
                }
            }
            return i;
        }
    }
    public abstract Map<e, g<?>> a();

    public abstract b d();

    public abstract u0 getSource();

    public abstract b0 getType();
}
