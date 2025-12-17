package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.r;
import com.google.android.gms.common.util.e;

/* loaded from: classes2.dex */
final class n9 {

    private final e a;
    private long b;
    public n9(e e) {
        super();
        r.j(e);
        this.a = e;
    }

    public final void a() {
        this.b = 0;
    }

    public final void b() {
        this.b = this.a.a();
    }

    public final boolean c(long l) {
        final int obj6 = 1;
        if (Long.compare(obj5, i) == 0) {
            return obj6;
        }
        if (Long.compare(i2, i3) >= 0) {
            return obj6;
        }
        return 0;
    }
}
