package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.internal.measurement.o0;
import com.google.android.gms.internal.measurement.q0;
import java.util.List;

/* loaded from: classes2.dex */
public final class d3 extends o0 implements com.google.android.gms.measurement.internal.g3 {
    d3(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.measurement.internal.IMeasurementService");
    }

    @Override // com.google.android.gms.internal.measurement.o0
    public final void A0(com.google.android.gms.measurement.internal.na na) {
        final Parcel parcel = j();
        q0.d(parcel, na);
        n(6, parcel);
    }

    public final List<com.google.android.gms.measurement.internal.ea> F(String string, String string2, String string3, boolean z4) {
        Parcel obj2 = j();
        obj2.writeString(0);
        obj2.writeString(string2);
        obj2.writeString(string3);
        q0.c(obj2, z4);
        obj2 = m(15, obj2);
        obj2.recycle();
        return obj2.createTypedArrayList(ea.CREATOR);
    }

    @Override // com.google.android.gms.internal.measurement.o0
    public final void J(com.google.android.gms.measurement.internal.na na) {
        final Parcel parcel = j();
        q0.d(parcel, na);
        n(18, parcel);
    }

    @Override // com.google.android.gms.internal.measurement.o0
    public final void J1(com.google.android.gms.measurement.internal.ea ea, com.google.android.gms.measurement.internal.na na2) {
        final Parcel parcel = j();
        q0.d(parcel, ea);
        q0.d(parcel, na2);
        n(2, parcel);
    }

    @Override // com.google.android.gms.internal.measurement.o0
    public final void M0(com.google.android.gms.measurement.internal.u u, com.google.android.gms.measurement.internal.na na2) {
        final Parcel parcel = j();
        q0.d(parcel, u);
        q0.d(parcel, na2);
        n(1, parcel);
    }

    @Override // com.google.android.gms.internal.measurement.o0
    public final String R(com.google.android.gms.measurement.internal.na na) {
        Parcel parcel = j();
        q0.d(parcel, na);
        Parcel obj2 = m(11, parcel);
        obj2.recycle();
        return obj2.readString();
    }

    @Override // com.google.android.gms.internal.measurement.o0
    public final void T0(com.google.android.gms.measurement.internal.na na) {
        final Parcel parcel = j();
        q0.d(parcel, na);
        n(20, parcel);
    }

    @Override // com.google.android.gms.internal.measurement.o0
    public final void U0(long l, String string2, String string3, String string4) {
        final Parcel parcel = j();
        parcel.writeLong(l);
        parcel.writeString(string3);
        parcel.writeString(string4);
        parcel.writeString(obj6);
        n(10, parcel);
    }

    public final List<com.google.android.gms.measurement.internal.ea> Z0(String string, String string2, boolean z3, com.google.android.gms.measurement.internal.na na4) {
        final Parcel parcel = j();
        parcel.writeString(string);
        parcel.writeString(string2);
        q0.c(parcel, z3);
        q0.d(parcel, na4);
        Parcel obj2 = m(14, parcel);
        obj2.recycle();
        return obj2.createTypedArrayList(ea.CREATOR);
    }

    public final List<com.google.android.gms.measurement.internal.c> b0(String string, String string2, String string3) {
        Parcel obj2 = j();
        obj2.writeString(0);
        obj2.writeString(string2);
        obj2.writeString(string3);
        obj2 = m(17, obj2);
        obj2.recycle();
        return obj2.createTypedArrayList(c.CREATOR);
    }

    @Override // com.google.android.gms.internal.measurement.o0
    public final byte[] f0(com.google.android.gms.measurement.internal.u u, String string2) {
        final Parcel parcel = j();
        q0.d(parcel, u);
        parcel.writeString(string2);
        Parcel obj2 = m(9, parcel);
        obj2.recycle();
        return obj2.createByteArray();
    }

    @Override // com.google.android.gms.internal.measurement.o0
    public final void q0(com.google.android.gms.measurement.internal.na na) {
        final Parcel parcel = j();
        q0.d(parcel, na);
        n(4, parcel);
    }

    public final List<com.google.android.gms.measurement.internal.c> s0(String string, String string2, com.google.android.gms.measurement.internal.na na3) {
        final Parcel parcel = j();
        parcel.writeString(string);
        parcel.writeString(string2);
        q0.d(parcel, na3);
        Parcel obj2 = m(16, parcel);
        obj2.recycle();
        return obj2.createTypedArrayList(c.CREATOR);
    }

    @Override // com.google.android.gms.internal.measurement.o0
    public final void t(Bundle bundle, com.google.android.gms.measurement.internal.na na2) {
        final Parcel parcel = j();
        q0.d(parcel, bundle);
        q0.d(parcel, na2);
        n(19, parcel);
    }

    @Override // com.google.android.gms.internal.measurement.o0
    public final void z(com.google.android.gms.measurement.internal.c c, com.google.android.gms.measurement.internal.na na2) {
        final Parcel parcel = j();
        q0.d(parcel, c);
        q0.d(parcel, na2);
        n(12, parcel);
    }
}
