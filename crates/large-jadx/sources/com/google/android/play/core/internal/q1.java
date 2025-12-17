package com.google.android.play.core.internal;

import java.util.Objects;

/* loaded from: classes2.dex */
public final class q1 {
    public static <T> T a(T t) {
        Objects.requireNonNull(t, "Cannot return null from a non-@Nullable @Provides method");
        return t;
    }

    public static <T> void b(T t, Class<T> class2) {
        if (t == 0) {
        } else {
        }
        IllegalStateException obj1 = new IllegalStateException(String.valueOf(class2.getCanonicalName()).concat(" must be set"));
        throw obj1;
    }
}
