package com.google.firebase.firestore.util;

import java.util.Objects;

/* loaded from: classes2.dex */
public class Preconditions {
    public static void checkArgument(boolean z, String string2, Object... object3Arr3) {
        if (!z) {
        } else {
        }
        IllegalArgumentException obj0 = new IllegalArgumentException(String.format(string2, object3Arr3));
        throw obj0;
    }

    public static <T> T checkNotNull(T t) {
        Objects.requireNonNull(t);
        return t;
    }

    public static <T> T checkNotNull(T t, Object object2) {
        if (t == 0) {
        } else {
            return t;
        }
        NullPointerException obj0 = new NullPointerException(String.valueOf(object2));
        throw obj0;
    }

    public static void checkState(boolean z) {
        if (!z) {
        } else {
        }
        IllegalStateException obj0 = new IllegalStateException();
        throw obj0;
    }

    public static void checkState(boolean z, String string2) {
        if (!z) {
        } else {
        }
        IllegalStateException obj0 = new IllegalStateException(string2);
        throw obj0;
    }
}
