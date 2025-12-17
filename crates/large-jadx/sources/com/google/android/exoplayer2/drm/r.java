package com.google.android.exoplayer2.drm;

import com.google.android.exoplayer2.util.p0;
import com.google.android.exoplayer2.util.v;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes2.dex */
final class r {
    public static byte[] a(byte[] bArr) {
        if (p0.a >= 27) {
            return bArr;
        }
        return p0.d0(r.c(p0.A(bArr)));
    }

    public static byte[] b(byte[] bArr) {
        String str3;
        String str2;
        int i;
        int length;
        int length2;
        String str;
        if (p0.a >= 27) {
            return bArr;
        }
        JSONObject jSONObject = new JSONObject(p0.A(bArr));
        StringBuilder stringBuilder = new StringBuilder("{\"keys\":[");
        JSONArray jSONArray = jSONObject.getJSONArray("keys");
        i = 0;
        while (i < jSONArray.length()) {
            if (i != 0) {
            }
            JSONObject jSONObject2 = jSONArray.getJSONObject(i);
            stringBuilder.append("{\"k\":\"");
            stringBuilder.append(r.d(jSONObject2.getString("k")));
            stringBuilder.append("\",\"kid\":\"");
            stringBuilder.append(r.d(jSONObject2.getString("kid")));
            stringBuilder.append("\",\"kty\":\"");
            stringBuilder.append(jSONObject2.getString("kty"));
            stringBuilder.append("\"}");
            i++;
            stringBuilder.append(",");
        }
        try {
            stringBuilder.append("]}");
            return p0.d0(stringBuilder.toString());
            str3 = "Failed to adjust response data: ";
            str2 = p0.A(bArr);
            str2 = String.valueOf(str2);
            if (str2.length() != 0) {
            } else {
            }
            str3 = str3.concat(str2);
            str2 = new String(str3);
            str3 = str2;
            str2 = "ClearKeyUtil";
            v.d(str2, str3, th);
            return bArr;
        }
    }

    private static String c(String string) {
        return string.replace('+', '-').replace('/', '_');
    }

    private static String d(String string) {
        return string.replace('-', '+').replace('_', '/');
    }
}
