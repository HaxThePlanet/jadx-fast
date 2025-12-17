package com.google.android.gms.auth.api.signin.internal;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BasePendingResult;

/* loaded from: classes2.dex */
final class k extends com.google.android.gms.auth.api.signin.internal.e {

    final com.google.android.gms.auth.api.signin.internal.l a;
    k(com.google.android.gms.auth.api.signin.internal.l l) {
        this.a = l;
        super();
    }

    @Override // com.google.android.gms.auth.api.signin.internal.e
    public final void E0(Status status) {
        this.a.f(status);
    }
}
