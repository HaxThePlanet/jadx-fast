package com.google.android.gms.measurement.internal;

import android.app.Application.ActivityLifecycleCallbacks;
import android.os.Bundle;
import com.google.android.gms.common.internal.r;
import com.google.android.gms.common.util.DynamiteApi;
import com.google.android.gms.dynamic.a;
import com.google.android.gms.dynamic.b;
import com.google.android.gms.internal.measurement.e1;
import com.google.android.gms.internal.measurement.i1;
import com.google.android.gms.internal.measurement.l1;
import com.google.android.gms.internal.measurement.n1;
import com.google.android.gms.internal.measurement.o1;
import d.e.a;
import java.util.Map;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull;

/* loaded from: classes2.dex */
public class AppMeasurementDynamiteService extends e1 {

    com.google.android.gms.measurement.internal.b5 a = null;
    private final Map<Integer, com.google.android.gms.measurement.internal.d6> b;
    public AppMeasurementDynamiteService() {
        super();
        int i = 0;
        a aVar = new a();
        this.b = aVar;
    }

    @EnsuresNonNull("scion")
    private final void m() {
        if (this.a == null) {
        } else {
        }
        IllegalStateException illegalStateException = new IllegalStateException("Attempting to perform action before initialize.");
        throw illegalStateException;
    }

    private final void n(i1 i1, String string2) {
        m();
        this.a.N().I(i1, string2);
    }

    @Override // com.google.android.gms.internal.measurement.e1
    public void beginAdUnitExposure(String string, long l2) {
        m();
        this.a.y().l(string, l2);
    }

    @Override // com.google.android.gms.internal.measurement.e1
    public void clearConditionalUserProperty(String string, String string2, Bundle bundle3) {
        m();
        this.a.I().h0(string, string2, bundle3);
    }

    @Override // com.google.android.gms.internal.measurement.e1
    public void clearMeasurementEnabled(long l) {
        m();
        this.a.I().J(0);
    }

    @Override // com.google.android.gms.internal.measurement.e1
    public void endAdUnitExposure(String string, long l2) {
        m();
        this.a.y().m(string, l2);
    }

    @Override // com.google.android.gms.internal.measurement.e1
    public void generateEventId(i1 i1) {
        m();
        m();
        this.a.N().H(i1, this.a.N().r0());
    }

    @Override // com.google.android.gms.internal.measurement.e1
    public void getAppInstanceId(i1 i1) {
        m();
        h6 h6Var = new h6(this, i1);
        this.a.a().z(h6Var);
    }

    @Override // com.google.android.gms.internal.measurement.e1
    public void getCachedAppInstanceId(i1 i1) {
        m();
        n(i1, this.a.I().X());
    }

    @Override // com.google.android.gms.internal.measurement.e1
    public void getConditionalUserProperties(String string, String string2, i1 i13) {
        m();
        ja jaVar = new ja(this, i13, string, string2);
        this.a.a().z(jaVar);
    }

    @Override // com.google.android.gms.internal.measurement.e1
    public void getCurrentScreenClass(i1 i1) {
        m();
        n(i1, this.a.I().Y());
    }

    @Override // com.google.android.gms.internal.measurement.e1
    public void getCurrentScreenName(i1 i1) {
        m();
        n(i1, this.a.I().Z());
    }

    @Override // com.google.android.gms.internal.measurement.e1
    public void getGmpAppId(i1 i1) {
        String str2;
        Object str;
        String str3;
        String str4;
        m();
        com.google.android.gms.measurement.internal.i7 i7Var = this.a.I();
        if (i7Var.a.O() != null) {
            str2 = i7Var.a.O();
        } else {
            str2 = o7.c(i7Var.a.f(), "google_app_id", i7Var.a.R());
        }
        n(i1, str2);
    }

    @Override // com.google.android.gms.internal.measurement.e1
    public void getMaxUserProperties(String string, i1 i12) {
        m();
        this.a.I().S(string);
        m();
        this.a.N().G(i12, 25);
    }

    @Override // com.google.android.gms.internal.measurement.e1
    public void getTestFlag(i1 i1, int i2) {
        m();
        if (i2 != 0 && i2 != 1 && i2 != 2 && i2 != 3 && i2 != 4) {
            if (i2 != 1) {
                if (i2 != 2) {
                    if (i2 != 3) {
                        if (i2 != 4) {
                        }
                        this.a.N().C(i1, this.a.I().T().booleanValue());
                    }
                    this.a.N().G(i1, this.a.I().V().intValue());
                }
                com.google.android.gms.measurement.internal.ia obj6 = this.a.N();
                Bundle bundle = new Bundle();
                bundle.putDouble("r", this.a.I().U().doubleValue());
                i1.c(bundle);
            }
            this.a.N().H(i1, this.a.I().W().longValue());
        }
        this.a.N().I(i1, this.a.I().a0());
    }

    @Override // com.google.android.gms.internal.measurement.e1
    public void getUserProperties(String string, String string2, boolean z3, i1 i14) {
        m();
        super(this, i14, string, string2, z3);
        this.a.a().z(h8Var2);
    }

    @Override // com.google.android.gms.internal.measurement.e1
    public void initForTests(Map map) {
        m();
    }

    @Override // com.google.android.gms.internal.measurement.e1
    public void initialize(a a, o1 o12, long l3) {
        final com.google.android.gms.measurement.internal.b5 b5Var = this.a;
        if (b5Var == null) {
            Object obj2 = b.n(a);
            r.j((Context)obj2);
            this.a = b5.H((Context)obj2, o12, Long.valueOf(l3));
        }
        b5Var.b().w().a("Attempting to initialize multiple times");
    }

    @Override // com.google.android.gms.internal.measurement.e1
    public void isDataCollectionEnabled(i1 i1) {
        m();
        ka kaVar = new ka(this, i1);
        this.a.a().z(kaVar);
    }

    @Override // com.google.android.gms.internal.measurement.e1
    public void logEvent(String string, String string2, Bundle bundle3, boolean z4, boolean z5, long l6) {
        m();
        obj.a.I().s(string, string2, bundle3, z4, z5, l6);
    }

    @Override // com.google.android.gms.internal.measurement.e1
    public void logEventAndBundle(String string, String string2, Bundle bundle3, i1 i14, long l5) {
        Bundle bundle;
        m();
        r.f(string2);
        if (bundle3 != null) {
            bundle = new Bundle(bundle3);
        } else {
            bundle = new Bundle();
        }
        final String str3 = "app";
        bundle.putString("_o", str3);
        s sVar = new s(bundle3);
        super(string2, sVar, str3, l5, obj6);
        h7 obj10 = new h7(this, i14, uVar, string);
        this.a.a().z(obj10);
    }

    @Override // com.google.android.gms.internal.measurement.e1
    public void logHealthData(int i, String string2, a a3, a a4, a a5) {
        int i2;
        Object obj2;
        Object obj;
        Object obj12;
        m();
        i2 = 0;
        if (a3 == null) {
            obj2 = i2;
        } else {
            obj2 = obj12;
        }
        if (a4 == null) {
            obj = i2;
        } else {
            obj = obj12;
        }
        if (a5 == null) {
        } else {
            i2 = b.n(a5);
        }
        this.a.b().F(i, true, false, string2, obj2, obj, i2);
    }

    @Override // com.google.android.gms.internal.measurement.e1
    public void onActivityCreated(a a, Bundle bundle2, long l3) {
        Object obj1;
        com.google.android.gms.measurement.internal.i7 obj4;
        m();
        com.google.android.gms.measurement.internal.g7 obj3 = obj3.c;
        if (obj3 != null) {
            this.a.I().o();
            obj3.onActivityCreated((Activity)b.n(a), bundle2);
        }
    }

    @Override // com.google.android.gms.internal.measurement.e1
    public void onActivityDestroyed(a a, long l2) {
        Object obj1;
        com.google.android.gms.measurement.internal.i7 obj3;
        m();
        com.google.android.gms.measurement.internal.g7 obj2 = obj2.c;
        if (obj2 != null) {
            this.a.I().o();
            obj2.onActivityDestroyed((Activity)b.n(a));
        }
    }

    @Override // com.google.android.gms.internal.measurement.e1
    public void onActivityPaused(a a, long l2) {
        Object obj1;
        com.google.android.gms.measurement.internal.i7 obj3;
        m();
        com.google.android.gms.measurement.internal.g7 obj2 = obj2.c;
        if (obj2 != null) {
            this.a.I().o();
            obj2.onActivityPaused((Activity)b.n(a));
        }
    }

    @Override // com.google.android.gms.internal.measurement.e1
    public void onActivityResumed(a a, long l2) {
        Object obj1;
        com.google.android.gms.measurement.internal.i7 obj3;
        m();
        com.google.android.gms.measurement.internal.g7 obj2 = obj2.c;
        if (obj2 != null) {
            this.a.I().o();
            obj2.onActivityResumed((Activity)b.n(a));
        }
    }

    @Override // com.google.android.gms.internal.measurement.e1
    public void onActivitySaveInstanceState(a a, i1 i12, long l3) {
        com.google.android.gms.measurement.internal.i7 i7Var;
        Object obj2;
        m();
        com.google.android.gms.measurement.internal.g7 obj4 = obj4.c;
        Bundle obj5 = new Bundle();
        if (obj4 != null) {
            this.a.I().o();
            obj4.onActivitySaveInstanceState((Activity)b.n(a), obj5);
        }
        i12.c(obj5);
    }

    @Override // com.google.android.gms.internal.measurement.e1
    public void onActivityStarted(a a, long l2) {
        Object obj1;
        Object obj2;
        m();
        if (obj2.c != null) {
            this.a.I().o();
            obj1 = b.n(a);
        }
    }

    @Override // com.google.android.gms.internal.measurement.e1
    public void onActivityStopped(a a, long l2) {
        Object obj1;
        Object obj2;
        m();
        if (obj2.c != null) {
            this.a.I().o();
            obj1 = b.n(a);
        }
    }

    @Override // com.google.android.gms.internal.measurement.e1
    public void performAction(Bundle bundle, i1 i12, long l3) {
        m();
        i12.c(0);
    }

    @Override // com.google.android.gms.internal.measurement.e1
    public void registerOnMeasurementEventListener(l1 l1) {
        Object maVar;
        Object valueOf;
        Object obj4;
        m();
        final Map map = this.b;
        synchronized (map) {
            maVar = new ma(this, l1);
            this.b.put(Integer.valueOf(l1.b()), maVar);
            this.a.I().x(maVar);
        }
    }

    @Override // com.google.android.gms.internal.measurement.e1
    public void resetAnalyticsData(long l) {
        m();
        this.a.I().y(l);
    }

    @Override // com.google.android.gms.internal.measurement.e1
    public void setConditionalUserProperty(Bundle bundle, long l2) {
        m();
        if (bundle == null) {
            this.a.b().r().a("Conditional user property must not be null");
        }
        this.a.I().E(bundle, l2);
    }

    @Override // com.google.android.gms.internal.measurement.e1
    public void setConsent(Bundle bundle, long l2) {
        m();
        this.a.I().H(bundle, l2);
    }

    @Override // com.google.android.gms.internal.measurement.e1
    public void setConsentThirdParty(Bundle bundle, long l2) {
        m();
        this.a.I().F(bundle, -20, l2);
    }

    @Override // com.google.android.gms.internal.measurement.e1
    public void setCurrentScreen(a a, String string2, String string3, long l4) {
        m();
        this.a.K().E((Activity)b.n(a), string2, string3);
    }

    @Override // com.google.android.gms.internal.measurement.e1
    public void setDataCollectionEnabled(boolean z) {
        m();
        com.google.android.gms.measurement.internal.i7 i7Var = this.a.I();
        i7Var.i();
        k6 k6Var = new k6(i7Var, z);
        i7Var.a.a().z(k6Var);
    }

    @Override // com.google.android.gms.internal.measurement.e1
    public void setDefaultEventParameters(Bundle bundle) {
        Bundle bundle2;
        int obj4;
        m();
        com.google.android.gms.measurement.internal.i7 i7Var = this.a.I();
        if (bundle == null) {
            obj4 = 0;
        } else {
            bundle2 = new Bundle(bundle);
            obj4 = bundle2;
        }
        i6 i6Var = new i6(i7Var, obj4);
        i7Var.a.a().z(i6Var);
    }

    @Override // com.google.android.gms.internal.measurement.e1
    public void setEventInterceptor(l1 l1) {
        m();
        la laVar = new la(this, l1);
        if (this.a.a().C()) {
            this.a.I().I(laVar);
        }
        i9 i9Var = new i9(this, laVar);
        this.a.a().z(i9Var);
    }

    @Override // com.google.android.gms.internal.measurement.e1
    public void setInstanceIdProvider(n1 n1) {
        m();
    }

    @Override // com.google.android.gms.internal.measurement.e1
    public void setMeasurementEnabled(boolean z, long l2) {
        m();
        this.a.I().J(Boolean.valueOf(z));
    }

    @Override // com.google.android.gms.internal.measurement.e1
    public void setMinimumSessionDuration(long l) {
        m();
    }

    @Override // com.google.android.gms.internal.measurement.e1
    public void setSessionTimeoutDuration(long l) {
        m();
        com.google.android.gms.measurement.internal.i7 i7Var = this.a.I();
        m6 m6Var = new m6(i7Var, l, obj5);
        i7Var.a.a().z(m6Var);
    }

    @Override // com.google.android.gms.internal.measurement.e1
    public void setUserId(String string, long l2) {
        int length;
        m();
        if (string != null && string.length() == 0) {
            if (string.length() == 0) {
                this.a.b().w().a("User ID must be non-empty");
            }
        }
        this.a.I().M(0, "_id", string, true, l2);
    }

    @Override // com.google.android.gms.internal.measurement.e1
    public void setUserProperty(String string, String string2, a a3, boolean z4, long l5) {
        m();
        this.a.I().M(string, string2, b.n(a3), z4, l5);
    }

    @Override // com.google.android.gms.internal.measurement.e1
    public void unregisterOnMeasurementEventListener(l1 l1) {
        Object maVar;
        m();
        final Map map = this.b;
        synchronized (map) {
            m();
            map = this.b;
        }
        maVar = new ma(this, l1);
        this.a.I().O(maVar);
    }
}
