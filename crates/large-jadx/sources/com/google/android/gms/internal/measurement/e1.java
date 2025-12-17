package com.google.android.gms.internal.measurement;

import android.accounts.Account;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.dynamic.a.a;

/* loaded from: classes2.dex */
public abstract class e1 extends com.google.android.gms.internal.measurement.p0 implements com.google.android.gms.internal.measurement.f1 {
    public e1() {
        super("com.google.android.gms.measurement.api.internal.IAppMeasurementDynamiteService");
    }

    public static com.google.android.gms.internal.measurement.f1 asInterface(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        android.os.IInterface localInterface = iBinder.queryLocalInterface("com.google.android.gms.measurement.api.internal.IAppMeasurementDynamiteService");
        if (localInterface instanceof f1) {
            return (f1)localInterface;
        }
        d1 d1Var = new d1(iBinder);
        return d1Var;
    }

    @Override // com.google.android.gms.internal.measurement.p0
    protected final boolean j(int i, Parcel parcel2, Parcel parcel3, int i4) {
        boolean strongBinder;
        boolean z;
        android.os.Parcelable localInterface2;
        int i3;
        long localInterface;
        int i2;
        int cREATOR;
        boolean string;
        boolean long;
        long long3;
        long long2;
        localInterface2 = "com.google.android.gms.measurement.api.internal.IEventHandlerProxy";
        localInterface = "com.google.android.gms.measurement.api.internal.IBundleReceiver";
        cREATOR = 0;
        switch (i) {
            case 1:
                initialize(a.a.m(parcel2.readStrongBinder()), (o1)q0.a(parcel2, o1.CREATOR), parcel2.readLong());
                break;
            case 2:
                this.logEvent(parcel2.readString(), parcel2.readString(), (Bundle)q0.a(parcel2, Bundle.CREATOR), q0.f(parcel2), q0.f(parcel2), parcel2.readLong());
                break;
            case 3:
                IBinder strongBinder17 = parcel2.readStrongBinder();
                long3 = cREATOR;
                localInterface = new g1(strongBinder17);
                long3 = localInterface;
                this.logEventAndBundle(parcel2.readString(), parcel2.readString(), (Bundle)q0.a(parcel2, Bundle.CREATOR), long3, parcel2.readLong());
                break;
            case 4:
                this.setUserProperty(parcel2.readString(), parcel2.readString(), a.a.m(parcel2.readStrongBinder()), q0.f(parcel2), parcel2.readLong());
                break;
            case 5:
                strongBinder = parcel2.readStrongBinder();
                localInterface = strongBinder.queryLocalInterface(localInterface);
                cREATOR = localInterface;
                cREATOR = new g1(strongBinder);
                getUserProperties(parcel2.readString(), parcel2.readString(), q0.f(parcel2), cREATOR);
                break;
            case 6:
                strongBinder = parcel2.readStrongBinder();
                localInterface = strongBinder.queryLocalInterface(localInterface);
                cREATOR = localInterface;
                cREATOR = new g1(strongBinder);
                getMaxUserProperties(parcel2.readString(), cREATOR);
                break;
            case 7:
                setUserId(parcel2.readString(), parcel2.readLong());
                break;
            case 8:
                setConditionalUserProperty((Bundle)q0.a(parcel2, Bundle.CREATOR), parcel2.readLong());
                break;
            case 9:
                clearConditionalUserProperty(parcel2.readString(), parcel2.readString(), (Bundle)q0.a(parcel2, Bundle.CREATOR));
                break;
            case 10:
                strongBinder = parcel2.readStrongBinder();
                localInterface = strongBinder.queryLocalInterface(localInterface);
                cREATOR = localInterface;
                cREATOR = new g1(strongBinder);
                getConditionalUserProperties(parcel2.readString(), parcel2.readString(), cREATOR);
                break;
            case 11:
                setMeasurementEnabled(q0.f(parcel2), parcel2.readLong());
                break;
            case 12:
                resetAnalyticsData(parcel2.readLong());
                break;
            case 13:
                setMinimumSessionDuration(parcel2.readLong());
                break;
            case 14:
                setSessionTimeoutDuration(parcel2.readLong());
                break;
            case 15:
                this.setCurrentScreen(a.a.m(parcel2.readStrongBinder()), parcel2.readString(), parcel2.readString(), parcel2.readLong());
                break;
            case 16:
                strongBinder = parcel2.readStrongBinder();
                localInterface2 = strongBinder.queryLocalInterface(localInterface);
                cREATOR = localInterface2;
                cREATOR = new g1(strongBinder);
                getCurrentScreenName(cREATOR);
                break;
            case 17:
                strongBinder = parcel2.readStrongBinder();
                localInterface2 = strongBinder.queryLocalInterface(localInterface);
                cREATOR = localInterface2;
                cREATOR = new g1(strongBinder);
                getCurrentScreenClass(cREATOR);
                break;
            case 18:
                strongBinder = parcel2.readStrongBinder();
                localInterface2 = strongBinder.queryLocalInterface("com.google.android.gms.measurement.api.internal.IStringProvider");
                cREATOR = localInterface2;
                cREATOR = new m1(strongBinder);
                setInstanceIdProvider(cREATOR);
                break;
            case 19:
                strongBinder = parcel2.readStrongBinder();
                localInterface2 = strongBinder.queryLocalInterface(localInterface);
                cREATOR = localInterface2;
                cREATOR = new g1(strongBinder);
                getCachedAppInstanceId(cREATOR);
                break;
            case 20:
                strongBinder = parcel2.readStrongBinder();
                localInterface2 = strongBinder.queryLocalInterface(localInterface);
                cREATOR = localInterface2;
                cREATOR = new g1(strongBinder);
                getAppInstanceId(cREATOR);
                break;
            case 21:
                strongBinder = parcel2.readStrongBinder();
                localInterface2 = strongBinder.queryLocalInterface(localInterface);
                cREATOR = localInterface2;
                cREATOR = new g1(strongBinder);
                getGmpAppId(cREATOR);
                break;
            case 22:
                strongBinder = parcel2.readStrongBinder();
                localInterface2 = strongBinder.queryLocalInterface(localInterface);
                cREATOR = localInterface2;
                cREATOR = new g1(strongBinder);
                generateEventId(cREATOR);
                break;
            case 23:
                beginAdUnitExposure(parcel2.readString(), parcel2.readLong());
                break;
            case 24:
                endAdUnitExposure(parcel2.readString(), parcel2.readLong());
                break;
            case 25:
                onActivityStarted(a.a.m(parcel2.readStrongBinder()), parcel2.readLong());
                break;
            case 26:
                onActivityStopped(a.a.m(parcel2.readStrongBinder()), parcel2.readLong());
                break;
            case 27:
                onActivityCreated(a.a.m(parcel2.readStrongBinder()), (Bundle)q0.a(parcel2, Bundle.CREATOR), parcel2.readLong());
                break;
            case 28:
                onActivityDestroyed(a.a.m(parcel2.readStrongBinder()), parcel2.readLong());
                break;
            case 29:
                onActivityPaused(a.a.m(parcel2.readStrongBinder()), parcel2.readLong());
                break;
            case 30:
                onActivityResumed(a.a.m(parcel2.readStrongBinder()), parcel2.readLong());
                break;
            case 31:
                IBinder strongBinder14 = parcel2.readStrongBinder();
                localInterface = strongBinder14.queryLocalInterface(localInterface);
                cREATOR = localInterface;
                cREATOR = new g1(strongBinder14);
                onActivitySaveInstanceState(a.a.m(parcel2.readStrongBinder()), cREATOR, parcel2.readLong());
                break;
            case 32:
                IBinder strongBinder15 = parcel2.readStrongBinder();
                localInterface = strongBinder15.queryLocalInterface(localInterface);
                cREATOR = localInterface;
                cREATOR = new g1(strongBinder15);
                performAction((Bundle)q0.a(parcel2, Bundle.CREATOR), cREATOR, parcel2.readLong());
                break;
            case 33:
                this.logHealthData(parcel2.readInt(), parcel2.readString(), a.a.m(parcel2.readStrongBinder()), a.a.m(parcel2.readStrongBinder()), a.a.m(parcel2.readStrongBinder()));
                break;
            case 34:
                strongBinder = parcel2.readStrongBinder();
                localInterface2 = strongBinder.queryLocalInterface(localInterface2);
                cREATOR = localInterface2;
                cREATOR = new j1(strongBinder);
                setEventInterceptor(cREATOR);
                break;
            case 35:
                strongBinder = parcel2.readStrongBinder();
                localInterface2 = strongBinder.queryLocalInterface(localInterface2);
                cREATOR = localInterface2;
                cREATOR = new j1(strongBinder);
                registerOnMeasurementEventListener(cREATOR);
                break;
            case 36:
                strongBinder = parcel2.readStrongBinder();
                localInterface2 = strongBinder.queryLocalInterface(localInterface2);
                cREATOR = localInterface2;
                cREATOR = new j1(strongBinder);
                unregisterOnMeasurementEventListener(cREATOR);
                break;
            case 37:
                initForTests(q0.b(parcel2));
                break;
            case 38:
                localInterface2 = parcel2.readStrongBinder();
                localInterface = localInterface2.queryLocalInterface(localInterface);
                cREATOR = localInterface;
                cREATOR = new g1(localInterface2);
                getTestFlag(cREATOR, parcel2.readInt());
                break;
            case 39:
                setDataCollectionEnabled(q0.f(parcel2));
                break;
            case 40:
                strongBinder = parcel2.readStrongBinder();
                localInterface2 = strongBinder.queryLocalInterface(localInterface);
                cREATOR = localInterface2;
                cREATOR = new g1(strongBinder);
                isDataCollectionEnabled(cREATOR);
                break;
            case 41:
                return 0;
            case 42:
                setDefaultEventParameters((Bundle)q0.a(parcel2, Bundle.CREATOR));
                break;
            case 43:
                clearMeasurementEnabled(parcel2.readLong());
                break;
            case 44:
                setConsent((Bundle)q0.a(parcel2, Bundle.CREATOR), parcel2.readLong());
                break;
            default:
                setConsentThirdParty((Bundle)q0.a(parcel2, Bundle.CREATOR), parcel2.readLong());
        }
        parcel3.writeNoException();
        return 1;
    }
}
