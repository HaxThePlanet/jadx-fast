package com.squareup.moshi;

import java.lang.reflect.Type;
import kotlin.d0.d.n;

/* compiled from: -MoshiKotlinTypesExtensions.kt */
/* loaded from: classes2.dex */
public final class u {
    public static final Class<?> a(Type type) {
        n.f(type, "$this$rawType");
        final Class cls = t.g(type);
        n.e(cls, "Types.getRawType(this)");
        return cls;
    }
}
