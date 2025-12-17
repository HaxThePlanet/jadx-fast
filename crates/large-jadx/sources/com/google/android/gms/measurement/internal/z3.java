package com.google.android.gms.measurement.internal;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.google.android.gms.common.internal.r;

/* loaded from: classes2.dex */
public final class z3 {

    private final String a;
    private final boolean b;
    private boolean c;
    private boolean d;
    final com.google.android.gms.measurement.internal.g4 e;
    public z3(com.google.android.gms.measurement.internal.g4 g4, String string2, boolean z3) {
        this.e = g4;
        super();
        r.f(string2);
        this.a = string2;
        this.b = z3;
    }

    public final void a(boolean z) {
        SharedPreferences.Editor edit = this.e.o().edit();
        edit.putBoolean(this.a, z);
        edit.apply();
        this.d = z;
    }

    public final boolean b() {
        boolean boolean;
        String str;
        boolean z;
        if (!this.c) {
            this.c = true;
            this.d = this.e.o().getBoolean(this.a, this.b);
        }
        return this.d;
    }
}
