package com.google.firebase.auth.internal;

import android.content.Intent;
import android.text.TextUtils;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.r;
import com.google.android.gms.common.internal.safeparcel.d;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class zzbl {

    static final Map<String, String> zza;
    static {
        HashMap hashMap = new HashMap();
        zzbl.zza = hashMap;
        hashMap.put("auth/invalid-provider-id", "INVALID_PROVIDER_ID");
        hashMap.put("auth/invalid-cert-hash", "INVALID_CERT_HASH");
        hashMap.put("auth/network-request-failed", "WEB_NETWORK_REQUEST_FAILED");
        hashMap.put("auth/web-storage-unsupported", "WEB_STORAGE_UNSUPPORTED");
        hashMap.put("auth/operation-not-allowed", "OPERATION_NOT_ALLOWED");
    }

    public static Status zza(Intent intent) {
        r.j(intent);
        r.a(zzbl.zzd(intent));
        return (Status)d.b(intent, "com.google.firebase.auth.internal.STATUS", Status.CREATOR);
    }

    public static Status zzb(String string) {
        String string2;
        boolean empty;
        boolean stringBuilder;
        final String str = "WEB_INTERNAL_ERROR:";
        JSONObject jSONObject = new JSONObject(string);
        String string5 = jSONObject.getString("code");
        String string3 = jSONObject.getString("message");
        empty = zzbl.zza;
        if (!TextUtils.isEmpty(string5) && !TextUtils.isEmpty(string3) && empty.containsKey(string5)) {
            if (!TextUtils.isEmpty(string3)) {
                try {
                    empty = zzbl.zza;
                    if (empty.containsKey(string5)) {
                    }
                    Object obj = empty.get(string5);
                    StringBuilder stringBuilder2 = new StringBuilder(i += length4);
                    stringBuilder2.append(obj);
                    stringBuilder2.append(":");
                    stringBuilder2.append(string3);
                    return zzai.zza(stringBuilder2.toString());
                    String valueOf = String.valueOf(string);
                    if (valueOf.length() != 0) {
                    } else {
                    }
                    string2 = str.concat(valueOf);
                    string2 = new String(str);
                    return zzai.zza(string2);
                    Throwable localizedMessage = localizedMessage.getLocalizedMessage();
                    String str2 = String.valueOf(string);
                    str2 = str2.length();
                    String length2 = String.valueOf(localizedMessage);
                    length2 = length2.length();
                    str2 += 23;
                    str2 += length2;
                    stringBuilder = new StringBuilder(str2);
                    stringBuilder.append(obj0);
                    stringBuilder.append(string);
                    string = "[ ";
                    stringBuilder.append(string);
                    stringBuilder.append(localizedMessage);
                    string = " ]";
                    stringBuilder.append(string);
                    string = stringBuilder.toString();
                    string = zzai.zza(string);
                    return string;
                }
            }
        }
    }

    public static void zzc(Intent intent, Status status2) {
        d.e(status2, intent, "com.google.firebase.auth.internal.STATUS");
    }

    public static boolean zzd(Intent intent) {
        r.j(intent);
        return intent.hasExtra("com.google.firebase.auth.internal.STATUS");
    }
}
