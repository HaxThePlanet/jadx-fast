package com.google.firebase.auth.internal;

import android.text.TextUtils;
import java.util.Map;

/* loaded from: classes2.dex */
public final class zzbe {

    private boolean zza;
    private String zzb;
    public static com.google.firebase.auth.internal.zzbe zza(String string) {
        Object booleanValue;
        int i;
        Object obj4;
        if (TextUtils.isEmpty(string)) {
            return null;
        }
        obj4 = zzaz.zzb(string);
        zzbe zzbe = new zzbe();
        booleanValue = obj4.get("basicIntegrity");
        i = 0;
        if (booleanValue != null && (Boolean)booleanValue.booleanValue()) {
            if ((Boolean)booleanValue.booleanValue()) {
                i = 1;
            }
        }
        zzbe.zza = i;
        if ((String)obj4.get("advice") == null) {
            obj4 = "";
        }
        zzbe.zzb = obj4;
        return zzbe;
    }

    public final String zzb() {
        return this.zzb;
    }

    public final boolean zzc() {
        return this.zza;
    }
}
