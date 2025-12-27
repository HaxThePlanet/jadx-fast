package com.skydoves.balloon;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import kotlin.d0.d.g;
import kotlin.d0.d.n;

/* compiled from: BalloonPersistence.kt */
/* loaded from: classes2.dex */
public final class k {

    private static volatile k a;
    private static SharedPreferences b;
    public static final k.a c = new k$a(0);

    public static final class a {
        private a() {
            super();
        }

        public final k a(Context context) {
            com.skydoves.balloon.k kVar;
            String str;
            int i = 0;
            SharedPreferences sharedPreferences;
            n.f(context, "context");
            if (k.a == null) {
                synchronized (this) {
                    if (k.a == null) {
                        k.a = new k();
                        i = 0;
                        sharedPreferences = context.getSharedPreferences("com.skydoves.balloon", i);
                        str = "context.getSharedPrefere…n\", Context.MODE_PRIVATE)";
                        n.e(sharedPreferences, str);
                        k.b = sharedPreferences;
                    }
                }
            }
            return kVar;
        }

        public final String b(String str) {
            n.f(str, "name");
            StringBuilder stringBuilder = new StringBuilder();
            final String str3 = "SHOWED_UP";
            str4 = str3 + str;
            return str4;
        }

        public /* synthetic */ a(g gVar) {
            this();
        }
    }
    public static final /* synthetic */ k a() {
        return k.a;
    }

    public static final /* synthetic */ void b(k kVar) {
        k.a = kVar;
    }

    public static final /* synthetic */ void c(SharedPreferences sharedPreferences) {
        k.b = sharedPreferences;
    }

    private final int d(String str) {
        final SharedPreferences sharedPreferences = k.b;
        if (k.b == null) {
            n.w("sharedPreferenceManager");
            /* Dexterity WARN: Type inference failed for thrown value */
            throw (Throwable) 0;
        } else {
            return k.b.getInt(k.c.b(str), 0);
        }
    }

    private final void e(String str, int i) {
        SharedPreferences sharedPreferences = k.b;
        if (k.b == null) {
            n.w("sharedPreferenceManager");
            /* Dexterity WARN: Type inference failed for thrown value */
            throw (Throwable) 0;
        } else {
            k.b.edit().putInt(k.c.b(str), i).apply();
            return;
        }
    }

    public final void f(String str) {
        n.f(str, "name");
        e(str, d(str) + 1);
    }

    public final boolean g(String str, int i) {
        boolean z = true;
        n.f(str, "name");
        str = d(str) < i ? 1 : 0;
        return (d(str) < i ? 1 : 0);
    }

}
