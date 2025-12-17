package com.google.android.gms.cloudmessaging;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;

/* loaded from: classes2.dex */
public final class a extends a {

    public static final Parcelable.Creator<com.google.android.gms.cloudmessaging.a> CREATOR;
    Intent a;
    static {
        e eVar = new e();
        a.CREATOR = eVar;
    }

    public a(Intent intent) {
        super();
        this.a = intent;
    }

    @Override // com.google.android.gms.common.internal.safeparcel.a
    public Intent j2() {
        return this.a;
    }

    @Override // com.google.android.gms.common.internal.safeparcel.a
    public void writeToParcel(Parcel parcel, int i2) {
        b.n(parcel, 1, this.a, i2, false);
        b.b(parcel, b.a(parcel));
    }
}
