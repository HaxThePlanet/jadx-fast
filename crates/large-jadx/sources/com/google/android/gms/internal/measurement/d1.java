package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.dynamic.a;

/* loaded from: classes2.dex */
public final class d1 extends com.google.android.gms.internal.measurement.o0 implements com.google.android.gms.internal.measurement.f1 {
    d1(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.measurement.api.internal.IAppMeasurementDynamiteService");
    }

    @Override // com.google.android.gms.internal.measurement.o0
    public final void beginAdUnitExposure(String string, long l2) {
        final Parcel parcel = j();
        parcel.writeString(string);
        parcel.writeLong(l2);
        n(23, parcel);
    }

    @Override // com.google.android.gms.internal.measurement.o0
    public final void clearConditionalUserProperty(String string, String string2, Bundle bundle3) {
        final Parcel parcel = j();
        parcel.writeString(string);
        parcel.writeString(string2);
        q0.d(parcel, bundle3);
        n(9, parcel);
    }

    @Override // com.google.android.gms.internal.measurement.o0
    public final void clearMeasurementEnabled(long l) {
        final Parcel parcel = j();
        parcel.writeLong(l);
        n(43, parcel);
    }

    @Override // com.google.android.gms.internal.measurement.o0
    public final void endAdUnitExposure(String string, long l2) {
        final Parcel parcel = j();
        parcel.writeString(string);
        parcel.writeLong(l2);
        n(24, parcel);
    }

    @Override // com.google.android.gms.internal.measurement.o0
    public final void generateEventId(com.google.android.gms.internal.measurement.i1 i1) {
        final Parcel parcel = j();
        q0.e(parcel, i1);
        n(22, parcel);
    }

    @Override // com.google.android.gms.internal.measurement.o0
    public final void getAppInstanceId(com.google.android.gms.internal.measurement.i1 i1) {
        final Parcel parcel = j();
        q0.e(parcel, i1);
        n(20, parcel);
    }

    @Override // com.google.android.gms.internal.measurement.o0
    public final void getCachedAppInstanceId(com.google.android.gms.internal.measurement.i1 i1) {
        final Parcel parcel = j();
        q0.e(parcel, i1);
        n(19, parcel);
    }

    @Override // com.google.android.gms.internal.measurement.o0
    public final void getConditionalUserProperties(String string, String string2, com.google.android.gms.internal.measurement.i1 i13) {
        final Parcel parcel = j();
        parcel.writeString(string);
        parcel.writeString(string2);
        q0.e(parcel, i13);
        n(10, parcel);
    }

    @Override // com.google.android.gms.internal.measurement.o0
    public final void getCurrentScreenClass(com.google.android.gms.internal.measurement.i1 i1) {
        final Parcel parcel = j();
        q0.e(parcel, i1);
        n(17, parcel);
    }

    @Override // com.google.android.gms.internal.measurement.o0
    public final void getCurrentScreenName(com.google.android.gms.internal.measurement.i1 i1) {
        final Parcel parcel = j();
        q0.e(parcel, i1);
        n(16, parcel);
    }

    @Override // com.google.android.gms.internal.measurement.o0
    public final void getGmpAppId(com.google.android.gms.internal.measurement.i1 i1) {
        final Parcel parcel = j();
        q0.e(parcel, i1);
        n(21, parcel);
    }

    @Override // com.google.android.gms.internal.measurement.o0
    public final void getMaxUserProperties(String string, com.google.android.gms.internal.measurement.i1 i12) {
        final Parcel parcel = j();
        parcel.writeString(string);
        q0.e(parcel, i12);
        n(6, parcel);
    }

    @Override // com.google.android.gms.internal.measurement.o0
    public final void getTestFlag(com.google.android.gms.internal.measurement.i1 i1, int i2) {
        final Parcel parcel = j();
        q0.e(parcel, i1);
        parcel.writeInt(i2);
        n(38, parcel);
    }

    @Override // com.google.android.gms.internal.measurement.o0
    public final void getUserProperties(String string, String string2, boolean z3, com.google.android.gms.internal.measurement.i1 i14) {
        final Parcel parcel = j();
        parcel.writeString(string);
        parcel.writeString(string2);
        q0.c(parcel, z3);
        q0.e(parcel, i14);
        n(5, parcel);
    }

    @Override // com.google.android.gms.internal.measurement.o0
    public final void initialize(a a, com.google.android.gms.internal.measurement.o1 o12, long l3) {
        final Parcel parcel = j();
        q0.e(parcel, a);
        q0.d(parcel, o12);
        parcel.writeLong(l3);
        n(1, parcel);
    }

    @Override // com.google.android.gms.internal.measurement.o0
    public final void logEvent(String string, String string2, Bundle bundle3, boolean z4, boolean z5, long l6) {
        final Parcel parcel = j();
        parcel.writeString(string);
        parcel.writeString(string2);
        q0.d(parcel, bundle3);
        q0.c(parcel, z4);
        q0.c(parcel, z5);
        parcel.writeLong(l6);
        n(2, parcel);
    }

    @Override // com.google.android.gms.internal.measurement.o0
    public final void logHealthData(int i, String string2, a a3, a a4, a a5) {
        final Parcel obj2 = j();
        obj2.writeInt(5);
        obj2.writeString(string2);
        q0.e(obj2, a3);
        q0.e(obj2, a4);
        q0.e(obj2, a5);
        n(33, obj2);
    }

    @Override // com.google.android.gms.internal.measurement.o0
    public final void onActivityCreated(a a, Bundle bundle2, long l3) {
        final Parcel parcel = j();
        q0.e(parcel, a);
        q0.d(parcel, bundle2);
        parcel.writeLong(l3);
        n(27, parcel);
    }

    @Override // com.google.android.gms.internal.measurement.o0
    public final void onActivityDestroyed(a a, long l2) {
        final Parcel parcel = j();
        q0.e(parcel, a);
        parcel.writeLong(l2);
        n(28, parcel);
    }

    @Override // com.google.android.gms.internal.measurement.o0
    public final void onActivityPaused(a a, long l2) {
        final Parcel parcel = j();
        q0.e(parcel, a);
        parcel.writeLong(l2);
        n(29, parcel);
    }

    @Override // com.google.android.gms.internal.measurement.o0
    public final void onActivityResumed(a a, long l2) {
        final Parcel parcel = j();
        q0.e(parcel, a);
        parcel.writeLong(l2);
        n(30, parcel);
    }

    @Override // com.google.android.gms.internal.measurement.o0
    public final void onActivitySaveInstanceState(a a, com.google.android.gms.internal.measurement.i1 i12, long l3) {
        final Parcel parcel = j();
        q0.e(parcel, a);
        q0.e(parcel, i12);
        parcel.writeLong(l3);
        n(31, parcel);
    }

    @Override // com.google.android.gms.internal.measurement.o0
    public final void onActivityStarted(a a, long l2) {
        final Parcel parcel = j();
        q0.e(parcel, a);
        parcel.writeLong(l2);
        n(25, parcel);
    }

    @Override // com.google.android.gms.internal.measurement.o0
    public final void onActivityStopped(a a, long l2) {
        final Parcel parcel = j();
        q0.e(parcel, a);
        parcel.writeLong(l2);
        n(26, parcel);
    }

    @Override // com.google.android.gms.internal.measurement.o0
    public final void registerOnMeasurementEventListener(com.google.android.gms.internal.measurement.l1 l1) {
        final Parcel parcel = j();
        q0.e(parcel, l1);
        n(35, parcel);
    }

    @Override // com.google.android.gms.internal.measurement.o0
    public final void resetAnalyticsData(long l) {
        final Parcel parcel = j();
        parcel.writeLong(l);
        n(12, parcel);
    }

    @Override // com.google.android.gms.internal.measurement.o0
    public final void setConditionalUserProperty(Bundle bundle, long l2) {
        final Parcel parcel = j();
        q0.d(parcel, bundle);
        parcel.writeLong(l2);
        n(8, parcel);
    }

    @Override // com.google.android.gms.internal.measurement.o0
    public final void setConsentThirdParty(Bundle bundle, long l2) {
        final Parcel parcel = j();
        q0.d(parcel, bundle);
        parcel.writeLong(l2);
        n(45, parcel);
    }

    @Override // com.google.android.gms.internal.measurement.o0
    public final void setCurrentScreen(a a, String string2, String string3, long l4) {
        final Parcel parcel = j();
        q0.e(parcel, a);
        parcel.writeString(string2);
        parcel.writeString(string3);
        parcel.writeLong(l4);
        n(15, parcel);
    }

    @Override // com.google.android.gms.internal.measurement.o0
    public final void setDataCollectionEnabled(boolean z) {
        final Parcel parcel = j();
        q0.c(parcel, z);
        n(39, parcel);
    }

    @Override // com.google.android.gms.internal.measurement.o0
    public final void setDefaultEventParameters(Bundle bundle) {
        final Parcel parcel = j();
        q0.d(parcel, bundle);
        n(42, parcel);
    }

    @Override // com.google.android.gms.internal.measurement.o0
    public final void setEventInterceptor(com.google.android.gms.internal.measurement.l1 l1) {
        final Parcel parcel = j();
        q0.e(parcel, l1);
        n(34, parcel);
    }

    @Override // com.google.android.gms.internal.measurement.o0
    public final void setMeasurementEnabled(boolean z, long l2) {
        final Parcel parcel = j();
        q0.c(parcel, z);
        parcel.writeLong(l2);
        n(11, parcel);
    }

    @Override // com.google.android.gms.internal.measurement.o0
    public final void setSessionTimeoutDuration(long l) {
        final Parcel parcel = j();
        parcel.writeLong(l);
        n(14, parcel);
    }

    @Override // com.google.android.gms.internal.measurement.o0
    public final void setUserId(String string, long l2) {
        final Parcel parcel = j();
        parcel.writeString(string);
        parcel.writeLong(l2);
        n(7, parcel);
    }

    @Override // com.google.android.gms.internal.measurement.o0
    public final void setUserProperty(String string, String string2, a a3, boolean z4, long l5) {
        final Parcel parcel = j();
        parcel.writeString(string);
        parcel.writeString(string2);
        q0.e(parcel, a3);
        q0.c(parcel, z4);
        parcel.writeLong(l5);
        n(4, parcel);
    }

    @Override // com.google.android.gms.internal.measurement.o0
    public final void unregisterOnMeasurementEventListener(com.google.android.gms.internal.measurement.l1 l1) {
        final Parcel parcel = j();
        q0.e(parcel, l1);
        n(36, parcel);
    }
}
