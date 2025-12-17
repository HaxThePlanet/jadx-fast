package com.google.android.gms.common.internal;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import androidx.annotation.RecentlyNonNull;
import com.google.android.gms.common.util.s;
import java.util.Objects;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull;

/* loaded from: classes2.dex */
public final class r {
    public static void a(boolean z) {
        if (!z) {
        } else {
        }
        IllegalArgumentException obj0 = new IllegalArgumentException();
        throw obj0;
    }

    public static void b(boolean z, Object object2) {
        if (!z) {
        } else {
        }
        IllegalArgumentException obj0 = new IllegalArgumentException(String.valueOf(object2));
        throw obj0;
    }

    public static void c(boolean z, String string2, Object... object3Arr3) {
        if (!z) {
        } else {
        }
        IllegalArgumentException obj0 = new IllegalArgumentException(String.format(string2, object3Arr3));
        throw obj0;
    }

    public static void d(Handler handler) {
        String name;
        Looper myLooper = Looper.myLooper();
        if (myLooper != handler.getLooper()) {
            if (myLooper != null) {
                name = myLooper.getThread().getName();
            } else {
                name = "null current looper";
            }
            String obj5 = handler.getLooper().getThread().getName();
            StringBuilder stringBuilder = new StringBuilder(i += length2);
            stringBuilder.append("Must be called on ");
            stringBuilder.append(obj5);
            stringBuilder.append(" thread, but got ");
            stringBuilder.append(name);
            stringBuilder.append(".");
            IllegalStateException illegalStateException = new IllegalStateException(stringBuilder.toString());
            throw illegalStateException;
        }
    }

    public static void e(String string) {
        if (!s.a()) {
        } else {
        }
        IllegalStateException illegalStateException = new IllegalStateException(string);
        throw illegalStateException;
    }

    @EnsuresNonNull("#1")
    public static String f(String string) {
        if (TextUtils.isEmpty(string)) {
        } else {
            return string;
        }
        IllegalArgumentException obj1 = new IllegalArgumentException("Given String is empty or null");
        throw obj1;
    }

    @EnsuresNonNull("#1")
    public static String g(String string, Object object2) {
        if (TextUtils.isEmpty(string)) {
        } else {
            return string;
        }
        IllegalArgumentException obj1 = new IllegalArgumentException(String.valueOf(object2));
        throw obj1;
    }

    public static void h() {
        r.i("Must not be called on the main application thread");
    }

    public static void i(String string) {
        if (s.a()) {
        } else {
        }
        IllegalStateException illegalStateException = new IllegalStateException(string);
        throw illegalStateException;
    }

    @EnsuresNonNull("#1")
    public static <T> T j(T t) {
        Objects.requireNonNull(t, "null reference");
        return t;
    }

    @EnsuresNonNull("#1")
    public static <T> T k(T t, Object object2) {
        if (t == 0) {
        } else {
            return t;
        }
        NullPointerException obj0 = new NullPointerException(String.valueOf(object2));
        throw obj0;
    }

    public static int l(int i) {
        if (i == 0) {
        } else {
            return i;
        }
        IllegalArgumentException obj1 = new IllegalArgumentException("Given Integer is zero");
        throw obj1;
    }

    public static void m(boolean z) {
        if (!z) {
        } else {
        }
        IllegalStateException obj0 = new IllegalStateException();
        throw obj0;
    }

    public static void n(boolean z, Object object2) {
        if (!z) {
        } else {
        }
        IllegalStateException obj0 = new IllegalStateException(String.valueOf(object2));
        throw obj0;
    }
}
