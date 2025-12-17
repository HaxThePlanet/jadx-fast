package com.google.android.gms.common.api.internal;

import com.google.android.gms.tasks.e;
import com.google.android.gms.tasks.j;
import com.google.android.gms.tasks.k;
import java.util.Map;

/* loaded from: classes2.dex */
final class t1 implements e {

    final k a;
    final com.google.android.gms.common.api.internal.x b;
    t1(com.google.android.gms.common.api.internal.x x, k k2) {
        this.b = x;
        this.a = k2;
        super();
    }

    @Override // com.google.android.gms.tasks.e
    public final void onComplete(j j) {
        x.g(this.b).remove(this.a);
    }
}
