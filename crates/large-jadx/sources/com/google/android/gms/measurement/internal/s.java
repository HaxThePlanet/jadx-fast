package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import java.util.Iterator;

/* loaded from: classes2.dex */
public final class s extends a implements Iterable<String> {

    public static final Parcelable.Creator<com.google.android.gms.measurement.internal.s> CREATOR;
    private final Bundle a;
    static {
        t tVar = new t();
        s.CREATOR = tVar;
    }

    s(Bundle bundle) {
        super();
        this.a = bundle;
    }

    static Bundle j2(com.google.android.gms.measurement.internal.s s) {
        return s.a;
    }

    public final Iterator<String> iterator() {
        r rVar = new r(this);
        return rVar;
    }

    @Override // com.google.android.gms.common.internal.safeparcel.a
    public final Bundle k2() {
        Bundle bundle = new Bundle(this.a);
        return bundle;
    }

    @Override // com.google.android.gms.common.internal.safeparcel.a
    final Double l2(String string) {
        return Double.valueOf(this.a.getDouble("value"));
    }

    @Override // com.google.android.gms.common.internal.safeparcel.a
    final Long m2(String string) {
        return Long.valueOf(this.a.getLong("value"));
    }

    @Override // com.google.android.gms.common.internal.safeparcel.a
    final Object n2(String string) {
        return this.a.get(string);
    }

    @Override // com.google.android.gms.common.internal.safeparcel.a
    final String o2(String string) {
        return this.a.getString(string);
    }

    @Override // com.google.android.gms.common.internal.safeparcel.a
    public final String toString() {
        return this.a.toString();
    }

    @Override // com.google.android.gms.common.internal.safeparcel.a
    public final void writeToParcel(Parcel parcel, int i2) {
        b.e(parcel, 2, k2(), false);
        b.b(parcel, b.a(parcel));
    }

    @Override // com.google.android.gms.common.internal.safeparcel.a
    public final int zza() {
        return this.a.size();
    }
}
