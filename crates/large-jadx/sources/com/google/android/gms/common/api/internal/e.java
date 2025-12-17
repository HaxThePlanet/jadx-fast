package com.google.android.gms.common.api.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.api.d;
import com.google.android.gms.common.internal.r;

/* loaded from: classes2.dex */
public abstract class e<R extends com.google.android.gms.common.api.i, A extends com.google.android.gms.common.api.a.b>  extends com.google.android.gms.common.api.internal.BasePendingResult<R> {
    protected e(a<?> a, d d2) {
        r.k(d2, "GoogleApiClient must not be null");
        super((d)d2);
        r.k(a, "Api must not be null");
        a.b();
    }

    private void o(RemoteException remoteException) {
        Status status = new Status(8, remoteException.getLocalizedMessage(), 0);
        p(status);
    }

    protected abstract void l(A a);

    protected void m(R r) {
    }

    public final void n(A a) {
        try {
            l(a);
            o(a);
            o(a);
            throw a;
        }
    }

    @Override // com.google.android.gms.common.api.internal.BasePendingResult
    public final void p(Status status) {
        r.b(z ^= 1, "Failed result must not be success");
        final com.google.android.gms.common.api.i obj3 = c(status);
        f(obj3);
        m(obj3);
    }
}
