package com.squareup.moshi;

import java.lang.reflect.Type;
import kotlin.d0.d.n;

/* loaded from: classes2.dex */
public final class u {
    public static final Class<?> a(Type type) {
        n.f(type, "$this$rawType");
        final Class obj1 = t.g(type);
        n.e(obj1, "Types.getRawType(this)");
        return obj1;
    }
}
