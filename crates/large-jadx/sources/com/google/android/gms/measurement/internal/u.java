package com.google.android.gms.measurement.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.r;
import com.google.android.gms.common.internal.safeparcel.a;

/* loaded from: classes2.dex */
public final class u extends a {

    public static final Parcelable.Creator<com.google.android.gms.measurement.internal.u> CREATOR;
    public final String a;
    public final com.google.android.gms.measurement.internal.s b;
    public final String c;
    public final long v;
    static {
        v vVar = new v();
        u.CREATOR = vVar;
    }

    u(com.google.android.gms.measurement.internal.u u, long l2) {
        super();
        r.j(u);
        this.a = u.a;
        this.b = u.b;
        this.c = u.c;
        this.v = l2;
    }

    public u(String string, com.google.android.gms.measurement.internal.s s2, String string3, long l4) {
        super();
        this.a = string;
        this.b = s2;
        this.c = string3;
        this.v = l4;
    }

    @Override // com.google.android.gms.common.internal.safeparcel.a
    public final String toString() {
        String str = this.c;
        final String str4 = this.a;
        String valueOf = String.valueOf(this.b);
        StringBuilder stringBuilder = new StringBuilder(i2 += length3);
        stringBuilder.append("origin=");
        stringBuilder.append(str);
        stringBuilder.append(",name=");
        stringBuilder.append(str4);
        stringBuilder.append(",params=");
        stringBuilder.append(valueOf);
        return stringBuilder.toString();
    }

    @Override // com.google.android.gms.common.internal.safeparcel.a
    public final void writeToParcel(Parcel parcel, int i2) {
        v.a(this, parcel, i2);
    }
}
