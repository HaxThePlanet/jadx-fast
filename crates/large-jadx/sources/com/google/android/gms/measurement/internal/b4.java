package com.google.android.gms.measurement.internal;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.google.android.gms.common.internal.r;

/* loaded from: classes2.dex */
public final class b4 {

    private final String a;
    private final long b;
    private boolean c;
    private long d;
    final com.google.android.gms.measurement.internal.g4 e;
    public b4(com.google.android.gms.measurement.internal.g4 g4, String string2, long l3) {
        this.e = g4;
        super();
        r.f(string2);
        this.a = string2;
        this.b = l3;
    }

    public final long a() {
        boolean long;
        String str;
        long l;
        if (!this.c) {
            this.c = true;
            this.d = this.e.o().getLong(this.a, this.b);
        }
        return this.d;
    }

    public final void b(long l) {
        SharedPreferences.Editor edit = this.e.o().edit();
        edit.putLong(this.a, l);
        edit.apply();
        this.d = l;
    }
}
