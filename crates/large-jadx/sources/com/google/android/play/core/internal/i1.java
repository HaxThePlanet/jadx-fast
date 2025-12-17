package com.google.android.play.core.internal;

/* loaded from: classes2.dex */
public final class i1 {
    public static <T> T a(T t, Object object2) {
        if (t == 0) {
        } else {
            return t;
        }
        NullPointerException obj0 = new NullPointerException((String)object2);
        throw obj0;
    }

    public static void b(boolean z, Object object2) {
        if (!z) {
        } else {
        }
        IllegalStateException obj0 = new IllegalStateException(String.valueOf(object2));
        throw obj0;
    }
}
