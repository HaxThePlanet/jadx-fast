package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.os.IInterface;
import com.google.android.gms.dynamic.a;
import java.util.Map;

/* loaded from: classes2.dex */
public interface f1 extends IInterface {
    @Override // android.os.IInterface
    public abstract void beginAdUnitExposure(String string, long l2);

    @Override // android.os.IInterface
    public abstract void clearConditionalUserProperty(String string, String string2, Bundle bundle3);

    @Override // android.os.IInterface
    public abstract void clearMeasurementEnabled(long l);

    @Override // android.os.IInterface
    public abstract void endAdUnitExposure(String string, long l2);

    @Override // android.os.IInterface
    public abstract void generateEventId(com.google.android.gms.internal.measurement.i1 i1);

    @Override // android.os.IInterface
    public abstract void getAppInstanceId(com.google.android.gms.internal.measurement.i1 i1);

    @Override // android.os.IInterface
    public abstract void getCachedAppInstanceId(com.google.android.gms.internal.measurement.i1 i1);

    @Override // android.os.IInterface
    public abstract void getConditionalUserProperties(String string, String string2, com.google.android.gms.internal.measurement.i1 i13);

    @Override // android.os.IInterface
    public abstract void getCurrentScreenClass(com.google.android.gms.internal.measurement.i1 i1);

    @Override // android.os.IInterface
    public abstract void getCurrentScreenName(com.google.android.gms.internal.measurement.i1 i1);

    @Override // android.os.IInterface
    public abstract void getGmpAppId(com.google.android.gms.internal.measurement.i1 i1);

    @Override // android.os.IInterface
    public abstract void getMaxUserProperties(String string, com.google.android.gms.internal.measurement.i1 i12);

    @Override // android.os.IInterface
    public abstract void getTestFlag(com.google.android.gms.internal.measurement.i1 i1, int i2);

    @Override // android.os.IInterface
    public abstract void getUserProperties(String string, String string2, boolean z3, com.google.android.gms.internal.measurement.i1 i14);

    @Override // android.os.IInterface
    public abstract void initForTests(Map map);

    @Override // android.os.IInterface
    public abstract void initialize(a a, com.google.android.gms.internal.measurement.o1 o12, long l3);

    @Override // android.os.IInterface
    public abstract void isDataCollectionEnabled(com.google.android.gms.internal.measurement.i1 i1);

    @Override // android.os.IInterface
    public abstract void logEvent(String string, String string2, Bundle bundle3, boolean z4, boolean z5, long l6);

    @Override // android.os.IInterface
    public abstract void logEventAndBundle(String string, String string2, Bundle bundle3, com.google.android.gms.internal.measurement.i1 i14, long l5);

    @Override // android.os.IInterface
    public abstract void logHealthData(int i, String string2, a a3, a a4, a a5);

    @Override // android.os.IInterface
    public abstract void onActivityCreated(a a, Bundle bundle2, long l3);

    @Override // android.os.IInterface
    public abstract void onActivityDestroyed(a a, long l2);

    @Override // android.os.IInterface
    public abstract void onActivityPaused(a a, long l2);

    @Override // android.os.IInterface
    public abstract void onActivityResumed(a a, long l2);

    @Override // android.os.IInterface
    public abstract void onActivitySaveInstanceState(a a, com.google.android.gms.internal.measurement.i1 i12, long l3);

    @Override // android.os.IInterface
    public abstract void onActivityStarted(a a, long l2);

    @Override // android.os.IInterface
    public abstract void onActivityStopped(a a, long l2);

    @Override // android.os.IInterface
    public abstract void performAction(Bundle bundle, com.google.android.gms.internal.measurement.i1 i12, long l3);

    @Override // android.os.IInterface
    public abstract void registerOnMeasurementEventListener(com.google.android.gms.internal.measurement.l1 l1);

    @Override // android.os.IInterface
    public abstract void resetAnalyticsData(long l);

    @Override // android.os.IInterface
    public abstract void setConditionalUserProperty(Bundle bundle, long l2);

    @Override // android.os.IInterface
    public abstract void setConsent(Bundle bundle, long l2);

    @Override // android.os.IInterface
    public abstract void setConsentThirdParty(Bundle bundle, long l2);

    @Override // android.os.IInterface
    public abstract void setCurrentScreen(a a, String string2, String string3, long l4);

    @Override // android.os.IInterface
    public abstract void setDataCollectionEnabled(boolean z);

    @Override // android.os.IInterface
    public abstract void setDefaultEventParameters(Bundle bundle);

    @Override // android.os.IInterface
    public abstract void setEventInterceptor(com.google.android.gms.internal.measurement.l1 l1);

    @Override // android.os.IInterface
    public abstract void setInstanceIdProvider(com.google.android.gms.internal.measurement.n1 n1);

    @Override // android.os.IInterface
    public abstract void setMeasurementEnabled(boolean z, long l2);

    @Override // android.os.IInterface
    public abstract void setMinimumSessionDuration(long l);

    @Override // android.os.IInterface
    public abstract void setSessionTimeoutDuration(long l);

    @Override // android.os.IInterface
    public abstract void setUserId(String string, long l2);

    @Override // android.os.IInterface
    public abstract void setUserProperty(String string, String string2, a a3, boolean z4, long l5);

    @Override // android.os.IInterface
    public abstract void unregisterOnMeasurementEventListener(com.google.android.gms.internal.measurement.l1 l1);
}
