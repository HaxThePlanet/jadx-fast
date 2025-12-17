package com.google.android.gms.common.api.internal;

import android.os.Handler;

/* loaded from: classes2.dex */
final class d0 implements com.google.android.gms.common.api.internal.d.a {

    final com.google.android.gms.common.api.internal.g a;
    d0(com.google.android.gms.common.api.internal.g g) {
        this.a = g;
        super();
    }

    @Override // com.google.android.gms.common.api.internal.d$a
    public final void onBackgroundStateChanged(boolean z) {
        g.D(this.a).sendMessage(g.D(this.a).obtainMessage(1, Boolean.valueOf(z)));
    }
}
