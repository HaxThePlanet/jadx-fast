package com.google.firebase.auth.internal;

import com.google.android.gms.common.l.a;
import com.google.firebase.auth.GetTokenResult;
import java.util.HashMap;

/* loaded from: classes2.dex */
public final class zzay {

    private static final a zza;
    static {
        a aVar = new a("GetTokenResultFactory", new String[0]);
        zzay.zza = aVar;
    }

    public static GetTokenResult zza(String string) {
        java.util.Map map;
        a zza;
        int arr;
        String str;
        try {
            map = zzaz.zzb(string);
            arr = 0;
            arr = new Object[arr];
            zzay.zza.b("Error parsing token claims", hashMap, arr);
            HashMap hashMap = new HashMap();
            GetTokenResult getTokenResult = new GetTokenResult(string, map);
            return getTokenResult;
        }
    }
}
