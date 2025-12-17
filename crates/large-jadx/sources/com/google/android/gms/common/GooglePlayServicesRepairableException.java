package com.google.android.gms.common;

import android.content.Intent;

/* loaded from: classes2.dex */
public class GooglePlayServicesRepairableException extends com.google.android.gms.common.UserRecoverableException {

    private final int zza;
    public GooglePlayServicesRepairableException(int i, String string2, Intent intent3) {
        super(string2, intent3);
        this.zza = i;
    }

    @Override // com.google.android.gms.common.UserRecoverableException
    public int a() {
        return this.zza;
    }
}
