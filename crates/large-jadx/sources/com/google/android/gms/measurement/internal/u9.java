package com.google.android.gms.measurement.internal;

import java.util.List;
import java.util.Map;

/* loaded from: classes2.dex */
final class u9 implements com.google.android.gms.measurement.internal.s3 {

    final String a;
    final com.google.android.gms.measurement.internal.ba b;
    u9(com.google.android.gms.measurement.internal.ba ba, String string2) {
        this.b = ba;
        this.a = string2;
        super();
    }

    public final void a(String string, int i2, Throwable throwable3, byte[] b4Arr4, Map<String, List<String>> map5) {
        this.b.o(i2, throwable3, b4Arr4, this.a);
    }
}
