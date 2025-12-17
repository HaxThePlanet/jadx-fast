package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.tasks.k;

/* loaded from: classes2.dex */
abstract class g1<T>  extends com.google.android.gms.common.api.internal.t0 {

    protected final k<T> b;
    public g1(int i, k<T> k2) {
        super(i);
        this.b = k2;
    }

    @Override // com.google.android.gms.common.api.internal.t0
    public final void a(Status status) {
        ApiException apiException = new ApiException(status);
        this.b.d(apiException);
    }

    @Override // com.google.android.gms.common.api.internal.t0
    public final void b(Exception exception) {
        this.b.d(exception);
    }

    public final void d(com.google.android.gms.common.api.internal.i0<?> i0) {
        try {
            h(i0);
            k kVar = this.b;
            kVar.d(i0);
            i0 = k1.e(i0);
            a(i0);
        }
    }

    protected abstract void h(com.google.android.gms.common.api.internal.i0<?> i0);
}
