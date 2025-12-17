package com.google.android.gms.auth.api.signin.internal;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.a.b;
import com.google.android.gms.common.api.d;
import com.google.android.gms.common.api.i;
import com.google.android.gms.common.internal.c;

/* loaded from: classes2.dex */
final class l extends com.google.android.gms.auth.api.signin.internal.m<Status> {
    l(d d) {
        super(d);
    }

    @Override // com.google.android.gms.auth.api.signin.internal.m
    protected final i c(Status status) {
        return status;
    }

    @Override // com.google.android.gms.auth.api.signin.internal.m
    protected final void l(a.b a$b) {
        k kVar = new k(this);
        (t)(h)b.getService().n(kVar, b.c());
    }
}
