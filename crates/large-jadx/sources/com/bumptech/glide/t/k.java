package com.bumptech.glide.t;

import android.text.TextUtils;
import java.util.Collection;
import java.util.Objects;

/* loaded from: classes.dex */
public final class k {
    public static void a(boolean z, String string2) {
        if (!z) {
        } else {
        }
        IllegalArgumentException obj0 = new IllegalArgumentException(string2);
        throw obj0;
    }

    public static String b(String string) {
        if (TextUtils.isEmpty(string)) {
        } else {
            return string;
        }
        IllegalArgumentException obj1 = new IllegalArgumentException("Must not be null or empty");
        throw obj1;
    }

    public static <T extends Collection<Y>, Y> T c(T t) {
        if (t.isEmpty()) {
        } else {
            return t;
        }
        IllegalArgumentException obj1 = new IllegalArgumentException("Must not be empty.");
        throw obj1;
    }

    public static <T> T d(T t) {
        k.e(t, "Argument must not be null");
        return t;
    }

    public static <T> T e(T t, String string2) {
        Objects.requireNonNull(t, string2);
        return t;
    }
}
