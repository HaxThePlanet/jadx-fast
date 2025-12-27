package com.bumptech.glide.t;

import android.text.TextUtils;
import java.util.Collection;
import java.util.Objects;

/* compiled from: Preconditions.java */
/* loaded from: classes.dex */
public final class k {
    public static void a(boolean z, String str) {
        if (!z) {
            throw new IllegalArgumentException(str);
        }
    }

    public static String b(String str) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("Must not be null or empty");
        } else {
            return str;
        }
    }

    public static <T extends Collection<Y>, Y> T c(T t) {
        if (t.isEmpty()) {
            throw new IllegalArgumentException("Must not be empty.");
        } else {
            return t;
        }
    }

    public static <T> T d(T t) {
        k.e(t, "Argument must not be null");
        return t;
    }

    public static <T> T e(T t, String str) {
        Objects.requireNonNull(t, str);
        return t;
    }
}
