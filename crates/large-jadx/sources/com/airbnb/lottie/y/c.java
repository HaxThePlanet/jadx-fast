package com.airbnb.lottie.y;

import android.util.Log;
import com.airbnb.lottie.c;
import com.airbnb.lottie.i;
import java.util.HashSet;
import java.util.Set;

/* loaded from: classes.dex */
public class c implements i {

    private static final Set<String> a;
    static {
        HashSet hashSet = new HashSet();
        c.a = hashSet;
    }

    @Override // com.airbnb.lottie.i
    public void a(String string, Throwable throwable2) {
        boolean str;
        if (c.a) {
            Log.d("LOTTIE", string, throwable2);
        }
    }

    @Override // com.airbnb.lottie.i
    public void b(String string) {
        e(string, 0);
    }

    @Override // com.airbnb.lottie.i
    public void c(String string, Throwable throwable2) {
        final Set set = c.a;
        if (set.contains(string)) {
        }
        Log.w("LOTTIE", string, throwable2);
        set.add(string);
    }

    @Override // com.airbnb.lottie.i
    public void d(String string) {
        c(string, 0);
    }

    @Override // com.airbnb.lottie.i
    public void e(String string, Throwable throwable2) {
        boolean str;
        if (c.a) {
            Log.d("LOTTIE", string, throwable2);
        }
    }
}
