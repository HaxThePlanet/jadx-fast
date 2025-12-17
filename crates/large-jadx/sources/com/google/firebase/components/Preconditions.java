package com.google.firebase.components;

import java.util.Objects;

/* loaded from: classes2.dex */
public final class Preconditions {
    public static void checkArgument(boolean z, String string2) {
        if (!z) {
        } else {
        }
        IllegalArgumentException obj0 = new IllegalArgumentException(string2);
        throw obj0;
    }

    public static <T> T checkNotNull(T t) {
        Objects.requireNonNull(t);
        return t;
    }

    public static <T> T checkNotNull(T t, String string2) {
        Objects.requireNonNull(t, string2);
        return t;
    }

    public static void checkState(boolean z, String string2) {
        if (!z) {
        } else {
        }
        IllegalStateException obj0 = new IllegalStateException(string2);
        throw obj0;
    }
}
