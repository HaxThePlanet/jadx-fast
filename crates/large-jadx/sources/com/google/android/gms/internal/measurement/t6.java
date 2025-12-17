package com.google.android.gms.internal.measurement;

import android.content.Context;
import android.net.Uri;

/* loaded from: classes2.dex */
public final class t6 {

    final String a;
    final Uri b;
    final String c;
    final String d;
    final boolean e;
    final boolean f;
    final boolean g;
    final boolean h;
    final com.google.android.gms.internal.measurement.a7<Context, Boolean> i;
    public t6(Uri uri) {
        super(0, uri, "", "", 0, 0, 0, 0, 0);
    }

    private t6(String string, Uri uri2, String string3, String string4, boolean z5, boolean z6, boolean z7, boolean z8, com.google.android.gms.internal.measurement.a7<Context, Boolean> a79) {
        super();
        final int obj1 = 0;
        this.a = obj1;
        this.b = uri2;
        String obj2 = "";
        this.c = obj2;
        this.d = obj2;
        this.e = z5;
        obj2 = 0;
        this.f = obj2;
        this.g = obj2;
        this.h = obj2;
        this.i = obj1;
    }

    public final com.google.android.gms.internal.measurement.t6 a() {
        if (!this.c.isEmpty()) {
        } else {
            super(0, this.b, this.c, this.d, 1, 0, 0, 0, 0);
            return t6Var;
        }
        IllegalStateException illegalStateException = new IllegalStateException("Cannot set GServices prefix and skip GServices");
        throw illegalStateException;
    }

    public final com.google.android.gms.internal.measurement.w6<Double> b(String string, double d2) {
        r6 obj3 = new r6(this, "measurement.test.double_flag", Double.valueOf(-4609434218613702656L), 1);
        return obj3;
    }

    public final com.google.android.gms.internal.measurement.w6<Long> c(String string, long l2) {
        p6 obj4 = new p6(this, string, Long.valueOf(l2), 1);
        return obj4;
    }

    public final com.google.android.gms.internal.measurement.w6<String> d(String string, String string2) {
        s6 s6Var = new s6(this, string, string2, 1);
        return s6Var;
    }

    public final com.google.android.gms.internal.measurement.w6<Boolean> e(String string, boolean z2) {
        q6 q6Var = new q6(this, string, Boolean.valueOf(z2), 1);
        return q6Var;
    }
}
