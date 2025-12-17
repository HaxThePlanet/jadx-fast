package com.google.android.gms.common.api;

import androidx.annotation.RecentlyNonNull;

/* loaded from: classes2.dex */
public class ApiException extends Exception {

    @Deprecated
    protected final com.google.android.gms.common.api.Status mStatus;
    public ApiException(com.google.android.gms.common.api.Status status) {
        String str;
        if (status.l2() != null) {
            str = status.l2();
        } else {
            str = "";
        }
        StringBuilder stringBuilder = new StringBuilder(length += 13);
        stringBuilder.append(status.k2());
        stringBuilder.append(": ");
        stringBuilder.append(str);
        super(stringBuilder.toString());
        this.mStatus = status;
    }

    @Override // java.lang.Exception
    public com.google.android.gms.common.api.Status a() {
        return this.mStatus;
    }
}
