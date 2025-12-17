package com.google.android.gms.internal.firebase-auth-api;

import com.google.android.gms.common.util.n;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class jp implements com.google.android.gms.internal.firebase-auth-api.mm<com.google.android.gms.internal.firebase-auth-api.jp> {

    private static final String b = "jp";
    private String a;
    static {
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.mm
    public final String a() {
        return this.a;
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.mm
    public final com.google.android.gms.internal.firebase-auth-api.mm zza(String string) {
        try {
            JSONObject jSONObject = new JSONObject(string);
            this.a = n.a(jSONObject.optString("sessionInfo", 0));
            return this;
            string = hq.a(th, jp.b, string);
            throw string;
        }
    }
}
