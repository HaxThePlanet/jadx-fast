package com.google.android.gms.internal.firebase-auth-api;

import android.text.TextUtils;
import android.util.Log;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class wn implements com.google.android.gms.internal.firebase-auth-api.mm<com.google.android.gms.internal.firebase-auth-api.wn> {

    private static final String b = "com.google.android.gms.internal.firebase-auth-api.wn";
    private String a;
    static {
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.mm
    public final com.google.android.gms.internal.firebase-auth-api.wn a(String string) {
        try {
            JSONObject jSONObject = new JSONObject(string);
            JSONObject jSONObject2 = new JSONObject(jSONObject.getString("error"));
            jSONObject2.getInt("code");
            this.a = jSONObject2.getString("message");
            return this;
            String zzpz = wn.b;
            String str4 = th.getMessage();
            String str5 = String.valueOf(string);
            str5 = str5.length();
            String stringBuilder = String.valueOf(str4);
            stringBuilder = stringBuilder.length();
            str5 += 52;
            str5 += stringBuilder;
            StringBuilder stringBuilder2 = new StringBuilder(str5);
            str5 = "Failed to parse error for string [";
            stringBuilder2.append(str5);
            stringBuilder2.append(string);
            stringBuilder = "] with exception: ";
            stringBuilder2.append(stringBuilder);
            stringBuilder2.append(str4);
            str4 = stringBuilder2.toString();
            Log.e(zzpz, str4);
            str4 = String.valueOf(string);
            str4 = str4.length();
            str4 += 35;
            stringBuilder = new StringBuilder(str4);
            stringBuilder.append(str5);
            stringBuilder.append(string);
            string = "]";
            stringBuilder.append(string);
            string = stringBuilder.toString();
            zzpz = new zzpz(string, th);
            throw zzpz;
        }
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.mm
    public final String b() {
        return this.a;
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.mm
    public final boolean c() {
        if (!TextUtils.isEmpty(this.a)) {
            return 1;
        }
        return 0;
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.mm
    public final com.google.android.gms.internal.firebase-auth-api.mm zza(String string) {
        a(string);
        return this;
    }
}
