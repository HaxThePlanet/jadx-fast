package com.google.android.gms.common.internal;

import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.ResolvableApiException;
import com.google.android.gms.common.api.Status;

/* loaded from: classes2.dex */
public class b {
    public static ApiException a(Status status) {
        if (status.m2()) {
            ResolvableApiException resolvableApiException = new ResolvableApiException(status);
            return resolvableApiException;
        }
        ApiException apiException = new ApiException(status);
        return apiException;
    }
}
