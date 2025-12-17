package com.google.android.gms.internal.firebase-auth-api;

import com.google.android.gms.common.util.n;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class np implements com.google.android.gms.internal.firebase-auth-api.mm<com.google.android.gms.internal.firebase-auth-api.np> {

    private static final String v = "np";
    private String a;
    private String b;
    private long c;
    static {
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.mm
    public final long a() {
        return this.c;
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.mm
    public final String b() {
        return this.a;
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.mm
    public final String c() {
        return this.b;
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.mm
    public final com.google.android.gms.internal.firebase-auth-api.mm zza(String string) {
        try {
            JSONObject jSONObject = new JSONObject(string);
            int i = 0;
            this.a = n.a(jSONObject.optString("idToken", i));
            n.a(jSONObject.optString("displayName", i));
            n.a(jSONObject.optString("email", i));
            this.b = n.a(jSONObject.optString("refreshToken", i));
            this.c = jSONObject.optLong("expiresIn", 0);
            return this;
            string = hq.a(th, np.v, string);
            throw string;
        }
    }
}
