package com.google.firebase.auth.internal;

import com.google.android.gms.common.internal.r;
import com.google.firebase.auth.ActionCodeEmailInfo;

/* loaded from: classes2.dex */
public final class zzl extends ActionCodeEmailInfo {

    private final String zza;
    public zzl(String string, String string2) {
        super();
        r.f(string);
        this.email = string;
        r.f(string2);
        this.zza = string2;
    }

    @Override // com.google.firebase.auth.ActionCodeEmailInfo
    public final String getPreviousEmail() {
        return this.zza;
    }
}
