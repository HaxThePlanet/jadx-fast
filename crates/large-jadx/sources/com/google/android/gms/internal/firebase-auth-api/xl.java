package com.google.android.gms.internal.firebase-auth-api;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.common.api.Status;
import com.google.firebase.auth.PhoneAuthCredential;

/* loaded from: classes2.dex */
public final class xl extends com.google.android.gms.internal.firebase-auth-api.a implements com.google.android.gms.internal.firebase-auth-api.zl {
    xl(IBinder iBinder) {
        super(iBinder, "com.google.firebase.auth.api.internal.IFirebaseAuthCallbacks");
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.a
    public final void A(Status status, PhoneAuthCredential phoneAuthCredential2) {
        final Parcel parcel = n();
        p3.b(parcel, status);
        p3.b(parcel, phoneAuthCredential2);
        m(12, parcel);
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.a
    public final void M(com.google.android.gms.internal.firebase-auth-api.yn yn) {
        final Parcel parcel = n();
        p3.b(parcel, yn);
        m(3, parcel);
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.a
    public final void O1(com.google.android.gms.internal.firebase-auth-api.yf yf) {
        final Parcel parcel = n();
        p3.b(parcel, yf);
        m(15, parcel);
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.a
    public final void S1(Status status) {
        final Parcel parcel = n();
        p3.b(parcel, status);
        m(5, parcel);
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.a
    public final void V0(PhoneAuthCredential phoneAuthCredential) {
        final Parcel parcel = n();
        p3.b(parcel, phoneAuthCredential);
        m(10, parcel);
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.a
    public final void Y0(com.google.android.gms.internal.firebase-auth-api.to to, com.google.android.gms.internal.firebase-auth-api.mo mo2) {
        final Parcel parcel = n();
        p3.b(parcel, to);
        p3.b(parcel, mo2);
        m(2, parcel);
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.a
    public final void d() {
        m(6, n());
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.a
    public final void e() {
        m(13, n());
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.a
    public final void f() {
        m(7, n());
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.a
    public final void g0(String string) {
        final Parcel parcel = n();
        parcel.writeString(string);
        m(9, parcel);
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.a
    public final void m1(String string) {
        final Parcel parcel = n();
        parcel.writeString(string);
        m(8, parcel);
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.a
    public final void m2(com.google.android.gms.internal.firebase-auth-api.to to) {
        final Parcel parcel = n();
        p3.b(parcel, to);
        m(1, parcel);
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.a
    public final void r1(com.google.android.gms.internal.firebase-auth-api.vf vf) {
        final Parcel parcel = n();
        p3.b(parcel, vf);
        m(14, parcel);
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.a
    public final void v0(com.google.android.gms.internal.firebase-auth-api.fp fp) {
        final Parcel parcel = n();
        p3.b(parcel, fp);
        m(4, parcel);
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.a
    public final void x0(String string) {
        final Parcel parcel = n();
        parcel.writeString(string);
        m(11, parcel);
    }
}
