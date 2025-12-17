package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.a.b;
import com.google.android.gms.common.d;
import com.google.android.gms.tasks.k;

/* loaded from: classes2.dex */
final class c1 extends com.google.android.gms.common.api.internal.t {

    final com.google.android.gms.common.api.internal.t.a a;
    c1(com.google.android.gms.common.api.internal.t.a t$a, d[] d2Arr2, boolean z3, int i4) {
        this.a = a;
        super(d2Arr2, z3, i4);
    }

    @Override // com.google.android.gms.common.api.internal.t
    protected final void doExecute(a.b a$b, k k2) {
        t.a.e(this.a).a(b, k2);
    }
}
