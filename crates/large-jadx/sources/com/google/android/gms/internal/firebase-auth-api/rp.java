package com.google.android.gms.internal.firebase-auth-api;

import com.google.android.gms.common.util.n;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class rp implements com.google.android.gms.internal.firebase-auth-api.mm<com.google.android.gms.internal.firebase-auth-api.rp> {

    private static final String b = "rp";
    private String a;
    static {
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.mm
    public final String a() {
        return this.a;
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.mm
    public final com.google.android.gms.internal.firebase-auth-api.mm zza(String string) {
        Object optJSONObject;
        String str;
        try {
            JSONObject jSONObject = new JSONObject(string);
            optJSONObject = jSONObject.optJSONObject("phoneResponseInfo");
            if (optJSONObject != null) {
            }
            this.a = n.a(optJSONObject.optString("sessionInfo"));
            return this;
            string = hq.a(th, rp.b, string);
            throw string;
        }
    }
}
