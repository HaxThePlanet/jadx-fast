package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.tasks.k;

/* loaded from: classes2.dex */
public class u {
    public static void a(Status status, k<Void> k2) {
        u.b(status, 0, k2);
    }

    public static <TResult> void b(Status status, TResult tresult2, k<TResult> k3) {
        if (status.n2()) {
            k3.c(tresult2);
        }
        ApiException obj2 = new ApiException(status);
        k3.b(obj2);
    }
}
