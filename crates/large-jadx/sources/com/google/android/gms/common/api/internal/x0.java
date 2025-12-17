package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.b;

/* loaded from: classes2.dex */
final class x0 implements Runnable {

    final com.google.android.gms.common.api.internal.a1 a;
    x0(com.google.android.gms.common.api.internal.a1 a1) {
        this.a = a1;
        super();
    }

    @Override // java.lang.Runnable
    public final void run() {
        b bVar = new b(4);
        a1.s2(this.a).c(bVar);
    }
}
