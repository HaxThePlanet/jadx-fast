package com.google.android.gms.auth.api.signin.internal;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.a.b;
import com.google.android.gms.common.api.d;
import com.google.android.gms.common.api.i;
import com.google.android.gms.common.internal.c;

/* loaded from: classes2.dex */
final class j extends com.google.android.gms.auth.api.signin.internal.m<Status> {
    j(d d) {
        super(d);
    }

    @Override // com.google.android.gms.auth.api.signin.internal.m
    protected final i c(Status status) {
        return status;
    }

    @Override // com.google.android.gms.auth.api.signin.internal.m
    protected final void l(a.b a$b) {
        i iVar = new i(this);
        (t)(h)b.getService().p2(iVar, b.c());
    }
}
