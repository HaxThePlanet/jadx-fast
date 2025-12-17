package com.google.android.gms.cloudmessaging;

import android.os.Bundle;

/* loaded from: classes2.dex */
final class t extends com.google.android.gms.cloudmessaging.u<Void> {
    t(int i, int i2, Bundle bundle3) {
        super(i, 2, bundle3);
    }

    @Override // com.google.android.gms.cloudmessaging.u
    final void a(Bundle bundle) {
        int i = 0;
        if (bundle.getBoolean("ack", false)) {
            d(i);
        }
        zzq obj4 = new zzq(4, "Invalid response to one way request", i);
        c(obj4);
    }

    @Override // com.google.android.gms.cloudmessaging.u
    final boolean b() {
        return 1;
    }
}
