package kotlin.i0.z.e.m0.d.b;

import java.util.Collection;
import kotlin.d0.d.n;
import kotlin.i0.z.e.m0.l.b0;
import kotlin.reflect.jvm.internal.impl.descriptors.e;

/* loaded from: classes3.dex */
public interface w<T>  {

    public static final class a {
        public static <T> String a(kotlin.i0.z.e.m0.d.b.w<? extends T> w, e e2) {
            n.f(w, "this");
            n.f(e2, "classDescriptor");
            return null;
        }

        public static <T> b0 b(kotlin.i0.z.e.m0.d.b.w<? extends T> w, b0 b02) {
            n.f(w, "this");
            n.f(b02, "kotlinType");
            return null;
        }

        public static <T> boolean c(kotlin.i0.z.e.m0.d.b.w<? extends T> w) {
            n.f(w, "this");
            return 1;
        }
    }
    public abstract T a(e e);

    public abstract String b(e e);

    public abstract b0 c(Collection<b0> collection);

    public abstract String d(e e);

    public abstract b0 e(b0 b0);

    public abstract boolean f();

    public abstract void g(b0 b0, e e2);
}
