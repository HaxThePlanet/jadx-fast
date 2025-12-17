package kotlin.i0.z.e.m0.i;

import kotlin.reflect.jvm.internal.impl.descriptors.a;
import kotlin.reflect.jvm.internal.impl.descriptors.e;

/* loaded from: classes3.dex */
public interface e {

    public static enum a {

        CONFLICTS_ONLY,
        SUCCESS_ONLY,
        BOTH;
    }

    public static enum b {

        OVERRIDABLE,
        CONFLICT,
        INCOMPATIBLE,
        UNKNOWN;
    }
    public abstract kotlin.i0.z.e.m0.i.e.a a();

    public abstract kotlin.i0.z.e.m0.i.e.b b(a a, a a2, e e3);
}
