package com.google.android.gms.common.api;

import androidx.annotation.RecentlyNonNull;
import com.google.android.gms.common.api.internal.BasePendingResult;
import com.google.android.gms.common.api.internal.s;
import com.google.android.gms.common.internal.r;

/* loaded from: classes2.dex */
public final class f {
    public static <R extends com.google.android.gms.common.api.i> com.google.android.gms.common.api.e<R> a(R r, com.google.android.gms.common.api.d d2) {
        r.k(r, "Result must not be null");
        r.b(z ^= 1, "Status code must not be SUCCESS");
        o oVar = new o(d2, r);
        oVar.f(r);
        return oVar;
    }

    public static com.google.android.gms.common.api.e<com.google.android.gms.common.api.Status> b(com.google.android.gms.common.api.Status status, com.google.android.gms.common.api.d d2) {
        r.k(status, "Result must not be null");
        s sVar = new s(d2);
        sVar.f(status);
        return sVar;
    }
}
