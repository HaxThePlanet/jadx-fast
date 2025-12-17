package androidx.camera.core.impl;

import java.util.Set;

/* loaded from: classes.dex */
public interface g {

    public static abstract class a {
        public static <T> androidx.camera.core.impl.g.a<T> a(String string, Class<?> class2) {
            return g.a.b(string, class2, 0);
        }

        public static <T> androidx.camera.core.impl.g.a<T> b(String string, Class<?> class2, Object object3) {
            b bVar = new b(string, class2, object3);
            return bVar;
        }

        public abstract String c();

        public abstract Object d();

        public abstract Class<T> e();
    }

    public static enum b {

        ALWAYS_OVERRIDE,
        REQUIRED,
        OPTIONAL;
    }
    public static boolean g(androidx.camera.core.impl.g.b g$b, androidx.camera.core.impl.g.b g$b2) {
        androidx.camera.core.impl.g.b aLWAYS_OVERRIDE = g.b.ALWAYS_OVERRIDE;
        final int i = 1;
        if (b == aLWAYS_OVERRIDE && b2 == aLWAYS_OVERRIDE) {
            if (b2 == aLWAYS_OVERRIDE) {
                return i;
            }
        }
        androidx.camera.core.impl.g.b rEQUIRED = g.b.REQUIRED;
        if (b == rEQUIRED && b2 == rEQUIRED) {
            if (b2 == rEQUIRED) {
                return i;
            }
        }
        return 0;
    }

    public abstract <ValueT> ValueT a(androidx.camera.core.impl.g.a<ValueT> g$a, androidx.camera.core.impl.g.b g$b2);

    public abstract Set<androidx.camera.core.impl.g.a<?>> b();

    public abstract Set<androidx.camera.core.impl.g.b> c(androidx.camera.core.impl.g.a<?> g$a);

    public abstract <ValueT> ValueT f(androidx.camera.core.impl.g.a<ValueT> g$a, ValueT valuet2);
}
