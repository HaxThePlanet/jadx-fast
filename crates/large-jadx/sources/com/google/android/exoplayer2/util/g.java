package com.google.android.exoplayer2.util;

import android.text.TextUtils;
import java.util.Objects;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull;
import org.checkerframework.dataflow.qual.Pure;

/* loaded from: classes2.dex */
public final class g {
    @Pure
    public static void a(boolean z) {
        if (!z) {
        } else {
        }
        IllegalArgumentException obj0 = new IllegalArgumentException();
        throw obj0;
    }

    @Pure
    public static void b(boolean z, Object object2) {
        if (!z) {
        } else {
        }
        IllegalArgumentException obj0 = new IllegalArgumentException(String.valueOf(object2));
        throw obj0;
    }

    @Pure
    public static int c(int i, int i2, int i3) {
        if (i < i2) {
        } else {
            if (i >= i3) {
            } else {
                return i;
            }
        }
        IndexOutOfBoundsException obj0 = new IndexOutOfBoundsException();
        throw obj0;
    }

    @EnsuresNonNull("#1")
    @Pure
    public static String d(String string) {
        if (TextUtils.isEmpty(string)) {
        } else {
            return string;
        }
        IllegalArgumentException obj1 = new IllegalArgumentException();
        throw obj1;
    }

    @EnsuresNonNull("#1")
    @Pure
    public static <T> T e(T t) {
        Objects.requireNonNull(t);
        return t;
    }

    @Pure
    public static void f(boolean z) {
        if (!z) {
        } else {
        }
        IllegalStateException obj0 = new IllegalStateException();
        throw obj0;
    }

    @Pure
    public static void g(boolean z, Object object2) {
        if (!z) {
        } else {
        }
        IllegalStateException obj0 = new IllegalStateException(String.valueOf(object2));
        throw obj0;
    }

    @EnsuresNonNull("#1")
    @Pure
    public static <T> T h(T t) {
        if (t == 0) {
        } else {
            return t;
        }
        IllegalStateException obj0 = new IllegalStateException();
        throw obj0;
    }

    @EnsuresNonNull("#1")
    @Pure
    public static <T> T i(T t, Object object2) {
        if (t == 0) {
        } else {
            return t;
        }
        IllegalStateException obj0 = new IllegalStateException(String.valueOf(object2));
        throw obj0;
    }
}
