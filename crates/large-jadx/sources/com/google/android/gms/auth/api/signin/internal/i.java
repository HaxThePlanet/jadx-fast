package com.google.android.gms.auth.api.signin.internal;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BasePendingResult;

/* loaded from: classes2.dex */
final class i extends com.google.android.gms.auth.api.signin.internal.e {

    final com.google.android.gms.auth.api.signin.internal.j a;
    i(com.google.android.gms.auth.api.signin.internal.j j) {
        this.a = j;
        super();
    }

    @Override // com.google.android.gms.auth.api.signin.internal.e
    public final void f1(Status status) {
        this.a.f(status);
    }
}
