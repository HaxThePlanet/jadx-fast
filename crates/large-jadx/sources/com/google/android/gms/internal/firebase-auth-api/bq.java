package com.google.android.gms.internal.firebase-auth-api;

import android.text.TextUtils;
import com.google.android.gms.common.util.n;
import java.util.List;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class bq implements com.google.android.gms.internal.firebase-auth-api.mm<com.google.android.gms.internal.firebase-auth-api.bq> {

    private static final String x = "bq";
    private String a;
    private String b;
    private long c;
    private List<com.google.android.gms.internal.firebase-auth-api.xo> v;
    private String w;
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
        return this.w;
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.mm
    public final String d() {
        return this.b;
    }

    public final List<com.google.android.gms.internal.firebase-auth-api.xo> e() {
        return this.v;
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.mm
    public final boolean f() {
        if (!TextUtils.isEmpty(this.w)) {
            return 1;
        }
        return 0;
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.mm
    public final com.google.android.gms.internal.firebase-auth-api.mm zza(String string) {
        try {
            JSONObject jSONObject = new JSONObject(string);
            final int i = 0;
            n.a(jSONObject.optString("localId", i));
            n.a(jSONObject.optString("email", i));
            n.a(jSONObject.optString("displayName", i));
            this.a = n.a(jSONObject.optString("idToken", i));
            n.a(jSONObject.optString("photoUrl", i));
            this.b = n.a(jSONObject.optString("refreshToken", i));
            this.c = jSONObject.optLong("expiresIn", 0);
            this.v = xo.l2(jSONObject.optJSONArray("mfaInfo"));
            this.w = jSONObject.optString("mfaPendingCredential", i);
            return this;
            string = hq.a(th, bq.x, string);
            throw string;
        }
    }
}
