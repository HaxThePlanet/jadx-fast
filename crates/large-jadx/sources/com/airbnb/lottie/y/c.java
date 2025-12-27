package com.airbnb.lottie.y;

import android.util.Log;
import com.airbnb.lottie.c;
import com.airbnb.lottie.i;
import java.util.Set;

/* compiled from: LogcatLogger.java */
/* loaded from: classes.dex */
public class c implements i {

    private static final Set<String> a = new HashSet<>();

    public void a(String str, Throwable th) {
        if (c.a) {
            Log.d("LOTTIE", str, th);
        }
    }

    public void b(String str) {
        e(str, null);
    }

    public void c(String str, Throwable th) {
        final Set set = c.a;
        if (set.contains(str)) {
            return;
        }
        Log.w("LOTTIE", str, th);
        c.a.add(str);
    }

    public void d(String str) {
        c(str, null);
    }

    public void e(String str, Throwable th) {
        if (c.a) {
            Log.d("LOTTIE", str, th);
        }
    }
}
