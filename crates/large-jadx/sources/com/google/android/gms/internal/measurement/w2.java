package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import com.google.android.gms.measurement.internal.d6;

/* loaded from: classes2.dex */
final class w2 extends com.google.android.gms.internal.measurement.k1 {

    private final d6 a;
    w2(d6 d6) {
        super();
        this.a = d6;
    }

    @Override // com.google.android.gms.internal.measurement.k1
    public final int b() {
        return System.identityHashCode(this.a);
    }

    @Override // com.google.android.gms.internal.measurement.k1
    public final void r(String string, String string2, Bundle bundle3, long l4) {
        this.a.onEvent(string, string2, bundle3, l4);
    }
}
