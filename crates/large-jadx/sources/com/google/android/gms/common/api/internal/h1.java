package com.google.android.gms.common.api.internal;

import android.util.Log;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.r;

/* loaded from: classes2.dex */
public final class h1<A extends com.google.android.gms.common.api.internal.e<? extends com.google.android.gms.common.api.i, com.google.android.gms.common.api.a.b>>  extends com.google.android.gms.common.api.internal.k1 {

    protected final A b;
    public h1(int i, A a2) {
        super(i);
        r.k(a2, "Null methods are not runnable.");
        this.b = (e)a2;
    }

    @Override // com.google.android.gms.common.api.internal.k1
    public final void a(Status status) {
        try {
            this.b.p(status);
            Log.w("ApiCallRunner", "Exception reporting failure", status);
        }
    }

    @Override // com.google.android.gms.common.api.internal.k1
    public final void b(Exception exception) {
        String simpleName = exception.getClass().getSimpleName();
        String obj6 = exception.getLocalizedMessage();
        StringBuilder stringBuilder = new StringBuilder(i2 += length2);
        stringBuilder.append(simpleName);
        stringBuilder.append(": ");
        stringBuilder.append(obj6);
        Status status = new Status(10, stringBuilder.toString());
        this.b.p(status);
    }

    @Override // com.google.android.gms.common.api.internal.k1
    public final void c(com.google.android.gms.common.api.internal.x x, boolean z2) {
        x.a(this.b, z2);
    }

    public final void d(com.google.android.gms.common.api.internal.i0<?> i0) {
        try {
            this.b.n(i0.v());
            b(i0);
        }
    }
}
