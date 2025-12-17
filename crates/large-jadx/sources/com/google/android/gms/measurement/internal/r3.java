package com.google.android.gms.measurement.internal;

import android.os.Bundle;

/* loaded from: classes2.dex */
public final class r3 {

    public final String a;
    public final String b;
    public final long c;
    public final Bundle d;
    public r3(String string, String string2, Bundle bundle3, long l4) {
        super();
        this.a = string;
        this.b = string2;
        this.d = bundle3;
        this.c = l4;
    }

    public static com.google.android.gms.measurement.internal.r3 b(com.google.android.gms.measurement.internal.u u) {
        super(u.a, u.c, u.b.k2(), u.v, obj5);
        return r3Var2;
    }

    public final com.google.android.gms.measurement.internal.u a() {
        Bundle bundle = new Bundle(this.d);
        s sVar = new s(bundle);
        super(this.a, sVar, this.b, this.c, obj5);
        return uVar2;
    }

    public final String toString() {
        String str = this.b;
        final String str4 = this.a;
        String string2 = this.d.toString();
        StringBuilder stringBuilder = new StringBuilder(i2 += length3);
        stringBuilder.append("origin=");
        stringBuilder.append(str);
        stringBuilder.append(",name=");
        stringBuilder.append(str4);
        stringBuilder.append(",params=");
        stringBuilder.append(string2);
        return stringBuilder.toString();
    }
}
