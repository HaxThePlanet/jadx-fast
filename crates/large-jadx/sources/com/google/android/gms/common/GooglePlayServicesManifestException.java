package com.google.android.gms.common;

import com.google.android.gms.common.annotation.KeepName;

/* loaded from: classes2.dex */
public class GooglePlayServicesManifestException extends java.lang.IllegalStateException {

    private final int zza;
    public GooglePlayServicesManifestException(int i, String string2) {
        super(string2);
        this.zza = i;
    }
}
