package com.google.android.gms.internal.firebase-auth-api;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.preference.PreferenceManager;
import java.io.IOException;

/* loaded from: classes2.dex */
public final class q5 implements com.google.android.gms.internal.firebase-auth-api.m2 {

    private final SharedPreferences.Editor a;
    private final String b;
    public q5(Context context, String string2, String string3) {
        super();
        this.b = "GenericIdpKeyset";
        Context obj1 = context.getApplicationContext();
        if (string3 == null) {
            this.a = PreferenceManager.getDefaultSharedPreferences(obj1).edit();
        }
        this.a = obj1.getSharedPreferences(string3, 0).edit();
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.m2
    public final void a(com.google.android.gms.internal.firebase-auth-api.na na) {
        if (!this.a.putString(this.b, tc.a(na.k())).commit()) {
        } else {
        }
        IOException obj3 = new IOException("Failed to write to SharedPreferences");
        throw obj3;
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.m2
    public final void b(com.google.android.gms.internal.firebase-auth-api.j9 j9) {
        if (!this.a.putString(this.b, tc.a(j9.k())).commit()) {
        } else {
        }
        IOException obj3 = new IOException("Failed to write to SharedPreferences");
        throw obj3;
    }
}
