package com.google.android.gms.internal.measurement;

import java.util.List;
import java.util.Map;

/* loaded from: classes2.dex */
public final class ef extends com.google.android.gms.internal.measurement.j {

    private final com.google.android.gms.internal.measurement.cf c;
    public ef(com.google.android.gms.internal.measurement.cf cf) {
        super("internal.logger");
        this.c = cf;
        final int i = 0;
        int i2 = 1;
        df dfVar = new df(this, i, i2);
        final String str3 = "log";
        this.b.put(str3, dfVar);
        final String str4 = "silent";
        yd ydVar = new yd(this, str4);
        this.b.put(str4, ydVar);
        df dfVar2 = new df(this, i2, i2);
        (j)this.b.get(str4).i(str3, dfVar2);
        String str2 = "unmonitored";
        ze zeVar = new ze(this, str2);
        this.b.put(str2, zeVar);
        df dfVar3 = new df(this, i, i);
        (j)this.b.get(str2).i(str3, dfVar3);
    }

    static com.google.android.gms.internal.measurement.cf e(com.google.android.gms.internal.measurement.ef ef) {
        return ef.c;
    }

    public final com.google.android.gms.internal.measurement.q a(com.google.android.gms.internal.measurement.b5 b5, List<com.google.android.gms.internal.measurement.q> list2) {
        return q.h;
    }
}
