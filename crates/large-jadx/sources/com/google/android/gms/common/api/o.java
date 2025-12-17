package com.google.android.gms.common.api;

import com.google.android.gms.common.api.internal.BasePendingResult;

/* loaded from: classes2.dex */
final class o<R extends com.google.android.gms.common.api.i>  extends BasePendingResult<R> {

    private final R p;
    public o(com.google.android.gms.common.api.d d, R r2) {
        super(d);
        this.p = r2;
    }

    protected final R c(com.google.android.gms.common.api.Status status) {
        return this.p;
    }
}
