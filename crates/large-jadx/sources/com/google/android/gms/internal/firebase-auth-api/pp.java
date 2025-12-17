package com.google.android.gms.internal.firebase-auth-api;

import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class pp implements com.google.android.gms.internal.firebase-auth-api.mm<com.google.android.gms.internal.firebase-auth-api.pp> {

    private static final String b = "pp";
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
            optJSONObject = jSONObject.optJSONObject("phoneSessionInfo");
            if (optJSONObject != null) {
            }
            this.a = t1.a(optJSONObject.optString("sessionInfo"));
            return this;
            string = hq.a(th, pp.b, string);
            throw string;
        }
    }
}
