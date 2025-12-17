package com.google.android.gms.cloudmessaging;

import android.os.Bundle;

/* loaded from: classes2.dex */
final class v extends com.google.android.gms.cloudmessaging.u<Bundle> {
    v(int i, int i2, Bundle bundle3) {
        super(i, 1, bundle3);
    }

    @Override // com.google.android.gms.cloudmessaging.u
    final void a(Bundle bundle) {
        Bundle obj2;
        if (bundle.getBundle("data") == null) {
            obj2 = Bundle.EMPTY;
        }
        d(obj2);
    }

    @Override // com.google.android.gms.cloudmessaging.u
    final boolean b() {
        return 0;
    }
}
