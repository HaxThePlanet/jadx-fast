package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import com.google.android.gms.measurement.internal.c6;

/* loaded from: classes2.dex */
final class v2 extends com.google.android.gms.internal.measurement.k1 {

    private final c6 a;
    v2(c6 c6) {
        super();
        this.a = c6;
    }

    @Override // com.google.android.gms.internal.measurement.k1
    public final int b() {
        return System.identityHashCode(this.a);
    }

    @Override // com.google.android.gms.internal.measurement.k1
    public final void r(String string, String string2, Bundle bundle3, long l4) {
        this.a.a(string, string2, bundle3, l4);
    }
}
