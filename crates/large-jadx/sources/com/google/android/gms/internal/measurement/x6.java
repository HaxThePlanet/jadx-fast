package com.google.android.gms.internal.measurement;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.OnSharedPreferenceChangeListener;
import android.os.StrictMode;
import d.e.a;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

/* loaded from: classes2.dex */
public final class x6 implements com.google.android.gms.internal.measurement.g6 {

    private static final Map<String, com.google.android.gms.internal.measurement.x6> c;
    private final SharedPreferences a;
    private final SharedPreferences.OnSharedPreferenceChangeListener b;
    static {
        a aVar = new a();
        x6.c = aVar;
    }

    static com.google.android.gms.internal.measurement.x6 b(Context context, String string2) {
        final int obj2 = 0;
        if (x5.a()) {
        } else {
            Class<com.google.android.gms.internal.measurement.x6> obj1 = x6.class;
            Object obj = x6.c.get(obj2);
            synchronized (obj1) {
                return (x6)obj;
            }
        }
        throw obj2;
    }

    static void c() {
        final Class<com.google.android.gms.internal.measurement.x6> obj = x6.class;
        Map map = x6.c;
        Iterator iterator = map.values().iterator();
        synchronized (obj) {
            map.clear();
        }
    }

    @Override // com.google.android.gms.internal.measurement.g6
    public final Object a(String string) {
        throw 0;
    }
}
