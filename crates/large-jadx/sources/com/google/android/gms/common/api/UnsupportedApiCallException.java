package com.google.android.gms.common.api;

import androidx.annotation.RecentlyNonNull;
import com.google.android.gms.common.d;

/* loaded from: classes2.dex */
public final class UnsupportedApiCallException extends java.lang.UnsupportedOperationException {

    private final d zza;
    public UnsupportedApiCallException(d d) {
        super();
        this.zza = d;
    }

    public String getMessage() {
        String valueOf = String.valueOf(this.zza);
        StringBuilder stringBuilder = new StringBuilder(length += 8);
        stringBuilder.append("Missing ");
        stringBuilder.append(valueOf);
        return stringBuilder.toString();
    }
}
