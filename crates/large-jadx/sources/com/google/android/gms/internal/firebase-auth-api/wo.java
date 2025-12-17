package com.google.android.gms.internal.firebase-auth-api;

import android.util.Log;
import java.io.UnsupportedEncodingException;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class wo {

    private Long a;
    private Long b;
    public static com.google.android.gms.internal.firebase-auth-api.wo a(String string) {
        long stringBuilder;
        StringBuilder stringBuilder2;
        try {
            wo woVar = new wo();
            JSONObject jSONObject = new JSONObject(string);
            jSONObject.optString("iss");
            jSONObject.optString("aud");
            jSONObject.optString("sub");
            woVar.a = Long.valueOf(jSONObject.optLong("iat"));
            woVar.b = Long.valueOf(jSONObject.optLong("exp"));
            jSONObject.optBoolean("is_anonymous");
            return woVar;
            int unsupportedEncodingException = 3;
            String str = "JwtToken";
            unsupportedEncodingException = Log.isLoggable(str, unsupportedEncodingException);
            String str2 = "Failed to read JwtToken from JSONObject. ";
            if (unsupportedEncodingException == null) {
            } else {
            }
            unsupportedEncodingException = String.valueOf(string);
            stringBuilder = String.valueOf(unsupportedEncodingException);
            stringBuilder = stringBuilder.length();
            stringBuilder += 41;
            stringBuilder2 = new StringBuilder(stringBuilder);
            stringBuilder2.append(str2);
            stringBuilder2.append(unsupportedEncodingException);
            unsupportedEncodingException = stringBuilder2.toString();
            Log.d(str, unsupportedEncodingException);
            string = String.valueOf(string);
            str = String.valueOf(string);
            str = str.length();
            str += 41;
            stringBuilder = new StringBuilder(str);
            stringBuilder.append(str2);
            stringBuilder.append(string);
            string = stringBuilder.toString();
            unsupportedEncodingException = new UnsupportedEncodingException(string);
            throw unsupportedEncodingException;
        }
    }

    public final Long b() {
        return this.b;
    }

    public final Long c() {
        return this.a;
    }
}
