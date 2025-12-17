package com.google.android.gms.internal.firebase-auth-api;

import com.google.android.gms.common.util.n;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class gq implements com.google.android.gms.internal.firebase-auth-api.mm<com.google.android.gms.internal.firebase-auth-api.gq> {

    private static final String c = "gq";
    private String a;
    private String b;
    static {
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.mm
    public final String a() {
        return this.a;
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.mm
    public final String b() {
        return this.b;
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.mm
    public final com.google.android.gms.internal.firebase-auth-api.mm zza(String string) {
        try {
            JSONObject jSONObject = new JSONObject(string);
            final int i = 0;
            this.a = n.a(jSONObject.optString("idToken", i));
            this.b = n.a(jSONObject.optString("refreshToken", i));
            return this;
            string = hq.a(th, gq.c, string);
            throw string;
        }
    }
}
