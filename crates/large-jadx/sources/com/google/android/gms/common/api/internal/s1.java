package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.e.a;
import java.util.Map;

/* loaded from: classes2.dex */
final class s1 implements e.a {

    final com.google.android.gms.common.api.internal.BasePendingResult a;
    final com.google.android.gms.common.api.internal.x b;
    s1(com.google.android.gms.common.api.internal.x x, com.google.android.gms.common.api.internal.BasePendingResult basePendingResult2) {
        this.b = x;
        this.a = basePendingResult2;
        super();
    }

    @Override // com.google.android.gms.common.api.e$a
    public final void a(Status status) {
        x.f(this.b).remove(this.a);
    }
}
