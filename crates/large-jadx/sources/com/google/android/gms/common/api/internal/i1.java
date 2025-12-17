package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.a.b;
import com.google.android.gms.common.d;
import com.google.android.gms.tasks.k;

/* loaded from: classes2.dex */
public final class i1<ResultT>  extends com.google.android.gms.common.api.internal.t0 {

    private final com.google.android.gms.common.api.internal.t<a.b, ResultT> b;
    private final k<ResultT> c;
    private final com.google.android.gms.common.api.internal.r d;
    public i1(int i, com.google.android.gms.common.api.internal.t<a.b, ResultT> t2, k<ResultT> k3, com.google.android.gms.common.api.internal.r r4) {
        int obj1;
        super(i);
        this.c = k3;
        this.b = t2;
        this.d = r4;
        if (i == 2) {
            if (t2.shouldAutoResolveMissingFeatures()) {
            } else {
            }
            obj1 = new IllegalArgumentException("Best-effort write calls cannot pass methods that should auto-resolve missing features.");
            throw obj1;
        }
    }

    @Override // com.google.android.gms.common.api.internal.t0
    public final void a(Status status) {
        this.c.d(this.d.getException(status));
    }

    @Override // com.google.android.gms.common.api.internal.t0
    public final void b(Exception exception) {
        this.c.d(exception);
    }

    @Override // com.google.android.gms.common.api.internal.t0
    public final void c(com.google.android.gms.common.api.internal.x x, boolean z2) {
        x.b(this.c, z2);
    }

    public final void d(com.google.android.gms.common.api.internal.i0<?> i0) {
        try {
            this.b.doExecute(i0.v(), this.c);
            this.c.d(i0);
            i0 = k1.e(i0);
            a(i0);
            throw i0;
        }
    }

    public final d[] f(com.google.android.gms.common.api.internal.i0<?> i0) {
        return this.b.zaa();
    }

    public final boolean g(com.google.android.gms.common.api.internal.i0<?> i0) {
        return this.b.shouldAutoResolveMissingFeatures();
    }
}
