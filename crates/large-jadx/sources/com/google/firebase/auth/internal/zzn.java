package com.google.firebase.auth.internal;

import com.google.android.gms.common.internal.r;
import com.google.firebase.auth.ActionCodeMultiFactorInfo;
import com.google.firebase.auth.MultiFactorInfo;

/* loaded from: classes2.dex */
public final class zzn extends ActionCodeMultiFactorInfo {

    private final MultiFactorInfo zza;
    public zzn(String string, MultiFactorInfo multiFactorInfo2) {
        super();
        r.f(string);
        this.email = string;
        r.j(multiFactorInfo2);
        this.zza = (MultiFactorInfo)multiFactorInfo2;
    }

    @Override // com.google.firebase.auth.ActionCodeMultiFactorInfo
    public final MultiFactorInfo getMultiFactorInfo() {
        return this.zza;
    }
}
