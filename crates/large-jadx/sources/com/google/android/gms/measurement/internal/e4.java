package com.google.android.gms.measurement.internal;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.google.android.gms.common.internal.r;

/* loaded from: classes2.dex */
public final class e4 {

    private final String a;
    private boolean b;
    private String c;
    final com.google.android.gms.measurement.internal.g4 d;
    public e4(com.google.android.gms.measurement.internal.g4 g4, String string2, String string3) {
        this.d = g4;
        super();
        r.f(string2);
        this.a = string2;
    }

    public final String a() {
        boolean string;
        String str;
        int i;
        if (!this.b) {
            this.b = true;
            this.c = this.d.o().getString(this.a, 0);
        }
        return this.c;
    }

    public final void b(String string) {
        SharedPreferences.Editor edit = this.d.o().edit();
        edit.putString(this.a, string);
        edit.apply();
        this.c = string;
    }
}
