package kotlin.reflect.jvm.internal.impl.descriptors.l1.a;

import java.util.Set;
import kotlin.y.q0;

/* loaded from: classes3.dex */
public final class i {

    private static final Set<Class<?>> a;
    static {
        Class[] arr = new Class[18];
        i.a = q0.g(Integer.class, Character.class, Byte.class, Long.class, Short.class, Boolean.class, Double.class, Float.class, int[].class, char[].class, byte[].class, long[].class, short[].class, boolean[].class, double[].class, float[].class, Class.class, String.class);
    }

    public static final Set a() {
        return i.a;
    }
}
