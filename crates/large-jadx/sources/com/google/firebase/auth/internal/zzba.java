package com.google.firebase.auth.internal;

import android.text.TextUtils;
import com.google.android.gms.common.internal.r;
import com.google.android.gms.internal.firebase-auth-api.xo;
import com.google.firebase.auth.MultiFactorInfo;
import com.google.firebase.auth.PhoneMultiFactorInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes2.dex */
public final class zzba {
    public static MultiFactorInfo zza(xo xo) {
        int phoneMultiFactorInfo;
        PhoneMultiFactorInfo phoneMultiFactorInfo2;
        String str3;
        String str;
        long l;
        String str2;
        if (xo == null) {
            return null;
        }
        if (!TextUtils.isEmpty(xo.zze())) {
            str2 = xo.zze();
            r.f(str2);
            super(xo.zzd(), xo.zzc(), xo.j2(), obj6, str2);
        }
        return phoneMultiFactorInfo;
    }

    public static List<MultiFactorInfo> zzb(List<xo> list) {
        boolean empty;
        MultiFactorInfo multiFactorInfo;
        if (list != null) {
            if (list.isEmpty()) {
            } else {
                ArrayList arrayList = new ArrayList();
                Iterator obj2 = list.iterator();
                while (obj2.hasNext()) {
                    multiFactorInfo = zzba.zza((xo)obj2.next());
                    if (multiFactorInfo != null) {
                    }
                    arrayList.add(multiFactorInfo);
                }
            }
            return arrayList;
        }
        obj2 = new ArrayList();
        return obj2;
    }
}
