package com.google.android.gms.measurement.internal;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.util.Pair;
import com.google.android.gms.common.internal.r;
import com.google.android.gms.common.util.e;
import java.security.SecureRandom;

/* loaded from: classes2.dex */
public final class d4 {

    final String a;
    private final String b;
    private final String c;
    private final long d;
    final com.google.android.gms.measurement.internal.g4 e;
    d4(com.google.android.gms.measurement.internal.g4 g4, String string2, long l3, com.google.android.gms.measurement.internal.c4 c44) {
        int obj1;
        this.e = g4;
        super();
        r.f("health_monitor");
        obj1 = Long.compare(l3, obj1) > 0 ? 1 : 0;
        r.a(obj1);
        this.a = "health_monitor:start";
        this.b = "health_monitor:count";
        this.c = "health_monitor:value";
        this.d = l3;
    }

    private final long c() {
        return this.e.o().getLong(this.a, 0);
    }

    private final void d() {
        this.e.h();
        SharedPreferences.Editor edit = this.e.o().edit();
        edit.remove(this.b);
        edit.remove(this.c);
        edit.putLong(this.a, g4Var2.a.c().currentTimeMillis());
        edit.apply();
    }

    public final Pair<String, Long> a() {
        long l;
        SharedPreferences cmp;
        long currentTimeMillis;
        this.e.h();
        this.e.h();
        long l2 = c();
        int i2 = 0;
        if (Long.compare(l2, i2) == 0) {
            d();
            l = i2;
        } else {
            l = Math.abs(l2 -= currentTimeMillis);
        }
        long l3 = this.d;
        final int i4 = 0;
        if (Long.compare(l, l3) < 0) {
            return i4;
        }
        if (Long.compare(l, i3) > 0) {
            d();
            return i4;
        }
        String string = this.e.o().getString(this.c, i4);
        long long = this.e.o().getLong(this.b, i2);
        d();
        if (string != null && Long.compare(long, i2) <= 0) {
            if (Long.compare(long, i2) <= 0) {
            }
            Pair pair2 = new Pair(string, Long.valueOf(long));
            return pair2;
        }
        return g4.x;
    }

    public final void b(String string, long l2) {
        int cmp;
        String obj8;
        this.e.h();
        int i = 0;
        if (Long.compare(obj9, i) == 0) {
            d();
        }
        if (string == null) {
            obj8 = "";
        }
        String obj10 = this.b;
        long obj9 = this.e.o().getLong(obj10, i);
        final int i3 = 1;
        if (Long.compare(obj9, i) <= 0) {
            obj9 = this.e.o().edit();
            obj9.putString(this.c, obj8);
            obj9.putLong(this.b, i3);
            obj9.apply();
        }
        obj9 += i3;
        long l = Long.MAX_VALUE;
        SharedPreferences.Editor edit = this.e.o().edit();
        if (Long.compare(i2, i4) < 0) {
            edit.putString(this.c, obj8);
        }
        edit.putLong(this.b, obj9);
        edit.apply();
    }
}
