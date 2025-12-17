package com.google.firebase.auth.internal;

import android.text.TextUtils;
import android.util.Log;
import f.c.a.d.c.d;

/* loaded from: classes2.dex */
public final class zzbf {

    private static final String zza = "zzbf";
    static {
    }

    public static boolean zza(d d) {
        boolean empty;
        String obj4;
        final int i = 0;
        if (d != null) {
            if (TextUtils.isEmpty(d.c())) {
            } else {
                obj4 = zzbe.zza(d.c());
                if (obj4 == null) {
                    Log.e(zzbf.zza, "Unable to parse SafetyNet AttestationResponse");
                    return i;
                }
                if (!obj4.zzc()) {
                    Log.e(zzbf.zza, "SafetyNet Attestation fails basic integrity.");
                    return i;
                }
                if (!TextUtils.isEmpty(obj4.zzb())) {
                    obj4 = String.valueOf(obj4.zzb());
                    final String str6 = "SafetyNet Attestation has advice: \n";
                    if (obj4.length() != 0) {
                        obj4 = str6.concat(obj4);
                    } else {
                        obj4 = new String(str6);
                    }
                    Log.e(zzbf.zza, obj4);
                    return i;
                }
            }
            return 1;
        }
        Log.e(zzbf.zza, "No SafetyNet AttestationResponse passed.");
        return i;
    }
}
