package com.skydoves.balloon;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import kotlin.d0.d.g;
import kotlin.d0.d.n;

/* loaded from: classes2.dex */
public final class k {

    private static volatile com.skydoves.balloon.k a;
    private static SharedPreferences b;
    public static final com.skydoves.balloon.k.a c;

    public static final class a {
        public a(g g) {
            super();
        }

        public final com.skydoves.balloon.k a(Context context) {
            com.skydoves.balloon.k kVar;
            String str;
            int i;
            Object obj4;
            n.f(context, "context");
            if (k.a() != null) {
            } else {
                synchronized (this) {
                }
            }
            return kVar;
        }

        public final String b(String string) {
            n.f(string, "name");
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("SHOWED_UP");
            stringBuilder.append(string);
            return stringBuilder.toString();
        }
    }
    static {
        k.a aVar = new k.a(0);
        k.c = aVar;
    }

    public static final com.skydoves.balloon.k a() {
        return k.a;
    }

    public static final void b(com.skydoves.balloon.k k) {
        k.a = k;
    }

    public static final void c(SharedPreferences sharedPreferences) {
        k.b = sharedPreferences;
    }

    private final int d(String string) {
        final SharedPreferences sharedPreferences = k.b;
        if (sharedPreferences == null) {
        } else {
            return sharedPreferences.getInt(k.c.b(string), 0);
        }
        n.w("sharedPreferenceManager");
        throw 0;
    }

    private final void e(String string, int i2) {
        SharedPreferences sharedPreferences = k.b;
        if (sharedPreferences == null) {
        } else {
            sharedPreferences.edit().putInt(k.c.b(string), i2).apply();
        }
        n.w("sharedPreferenceManager");
        throw 0;
    }

    public final void f(String string) {
        n.f(string, "name");
        e(string, i++);
    }

    public final boolean g(String string, int i2) {
        int obj2;
        n.f(string, "name");
        obj2 = d(string) < i2 ? 1 : 0;
        return obj2;
    }
}
