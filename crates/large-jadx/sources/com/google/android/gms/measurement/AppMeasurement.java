package com.google.android.gms.measurement;

import android.content.Context;
import android.os.Bundle;
import androidx.annotation.Keep;
import com.google.android.gms.common.internal.r;
import com.google.android.gms.internal.measurement.o1;
import com.google.android.gms.measurement.internal.b5;
import com.google.android.gms.measurement.internal.j7;
import com.google.android.gms.measurement.internal.y5;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes2.dex */
@Deprecated
public class AppMeasurement {

    private static volatile com.google.android.gms.measurement.AppMeasurement b;
    private final com.google.android.gms.measurement.e a;

    public static class ConditionalUserProperty {

        public boolean mActive;
        public String mAppId;
        public long mCreationTimestamp;
        public String mExpiredEventName;
        public Bundle mExpiredEventParams;
        public String mName;
        public String mOrigin;
        public long mTimeToLive;
        public String mTimedOutEventName;
        public Bundle mTimedOutEventParams;
        public String mTriggerEventName;
        public long mTriggerTimeout;
        public String mTriggeredEventName;
        public Bundle mTriggeredEventParams;
        public long mTriggeredTimestamp;
        public Object mValue;
        ConditionalUserProperty(Bundle bundle) {
            Class<Long> obj = Long.class;
            Class<String> obj2 = String.class;
            super();
            r.j(bundle);
            int i = 0;
            this.mAppId = (String)y5.a(bundle, "app_id", obj2, i);
            this.mOrigin = (String)y5.a(bundle, "origin", obj2, i);
            this.mName = (String)y5.a(bundle, "name", obj2, i);
            this.mValue = y5.a(bundle, "value", Object.class, i);
            this.mTriggerEventName = (String)y5.a(bundle, "trigger_event_name", obj2, i);
            Long valueOf = Long.valueOf(0);
            this.mTriggerTimeout = (Long)y5.a(bundle, "trigger_timeout", obj, valueOf).longValue();
            this.mTimedOutEventName = (String)y5.a(bundle, "timed_out_event_name", obj2, i);
            this.mTimedOutEventParams = (Bundle)y5.a(bundle, "timed_out_event_params", Bundle.class, i);
            this.mTriggeredEventName = (String)y5.a(bundle, "triggered_event_name", obj2, i);
            this.mTriggeredEventParams = (Bundle)y5.a(bundle, "triggered_event_params", Bundle.class, i);
            this.mTimeToLive = (Long)y5.a(bundle, "time_to_live", obj, valueOf).longValue();
            this.mExpiredEventName = (String)y5.a(bundle, "expired_event_name", obj2, i);
            this.mExpiredEventParams = (Bundle)y5.a(bundle, "expired_event_params", Bundle.class, i);
            this.mActive = (Boolean)y5.a(bundle, "active", Boolean.class, Boolean.FALSE).booleanValue();
            this.mCreationTimestamp = (Long)y5.a(bundle, "creation_timestamp", obj, valueOf).longValue();
            this.mTriggeredTimestamp = (Long)y5.a(bundle, "triggered_timestamp", obj, valueOf).longValue();
        }
    }
    public AppMeasurement(b5 b5) {
        super();
        b bVar = new b(b5);
        this.a = bVar;
    }

    public AppMeasurement(j7 j7) {
        super();
        c cVar = new c(j7);
        this.a = cVar;
    }

    @Deprecated
    public static com.google.android.gms.measurement.AppMeasurement getInstance(Context context) {
        com.google.android.gms.measurement.AppMeasurement appMeasurement;
        com.google.android.gms.measurement.AppMeasurement appMeasurement2;
        Object invoke;
        int arr2;
        Class[] arr;
        int str;
        int i4;
        int i;
        int i5;
        int i6;
        int i2;
        int i7;
        int i3;
        o1 o1Var;
        Object obj14;
        appMeasurement = AppMeasurement.class;
        if (AppMeasurement.b == null && AppMeasurement.b == null) {
            appMeasurement = AppMeasurement.class;
            synchronized (appMeasurement) {
                appMeasurement2 = 0;
                int i8 = 2;
                arr = new Class[i8];
                i4 = 0;
                arr[i4] = Context.class;
                i = 1;
                arr[i] = Bundle.class;
                arr2 = new Object[i8];
                arr2[i4] = context;
                arr2[i] = appMeasurement2;
                invoke = Class.forName("com.google.firebase.analytics.FirebaseAnalytics").getDeclaredMethod("getScionFrontendApiImplementation", arr).invoke(appMeasurement2, arr2);
                if (invoke != null) {
                    obj14 = new AppMeasurement(invoke);
                    AppMeasurement.b = obj14;
                } else {
                    super(0, arr, 0, i4, 1, 0, 0, 0, 0, 0);
                    appMeasurement2 = new AppMeasurement(b5.H(context, o1Var, appMeasurement2));
                    AppMeasurement.b = appMeasurement2;
                }
                try {
                    throw context;
                } catch (java.lang.ClassNotFoundException classNotFound) {
                } catch (Throwable th1) {
                }
            }
        }
        return AppMeasurement.b;
    }

    public void beginAdUnitExposure(String string) {
        this.a.zzp(string);
    }

    public void clearConditionalUserProperty(String string, String string2, Bundle bundle3) {
        this.a.zzq(string, string2, bundle3);
    }

    public void endAdUnitExposure(String string) {
        this.a.zzr(string);
    }

    public long generateEventId() {
        return this.a.zzb();
    }

    public String getAppInstanceId() {
        return this.a.zzh();
    }

    public List<com.google.android.gms.measurement.AppMeasurement.ConditionalUserProperty> getConditionalUserProperties(String string, String string2) {
        int next;
        com.google.android.gms.measurement.AppMeasurement.ConditionalUserProperty conditionalUserProperty;
        List obj3 = this.a.zzm(string, string2);
        if (obj3 == null) {
            next = 0;
        } else {
            next = obj3.size();
        }
        ArrayList obj4 = new ArrayList(next);
        obj3 = obj3.iterator();
        for (Bundle next : obj3) {
            conditionalUserProperty = new AppMeasurement.ConditionalUserProperty(next);
            obj4.add(conditionalUserProperty);
        }
        return obj4;
    }

    public String getCurrentScreenClass() {
        return this.a.zzi();
    }

    public String getCurrentScreenName() {
        return this.a.zzj();
    }

    public String getGmpAppId() {
        return this.a.zzk();
    }

    public int getMaxUserProperties(String string) {
        return this.a.zza(string);
    }

    protected Map<String, Object> getUserProperties(String string, String string2, boolean z3) {
        return this.a.zzo(string, string2, z3);
    }

    public void logEventInternal(String string, String string2, Bundle bundle3) {
        this.a.zzs(string, string2, bundle3);
    }

    public void setConditionalUserProperty(com.google.android.gms.measurement.AppMeasurement.ConditionalUserProperty appMeasurement$ConditionalUserProperty) {
        String str;
        r.j(conditionalUserProperty);
        Bundle bundle = new Bundle();
        String mAppId = conditionalUserProperty.mAppId;
        if (mAppId != null) {
            bundle.putString("app_id", mAppId);
        }
        String mOrigin = conditionalUserProperty.mOrigin;
        if (mOrigin != null) {
            bundle.putString("origin", mOrigin);
        }
        String mName = conditionalUserProperty.mName;
        if (mName != null) {
            bundle.putString("name", mName);
        }
        Object mValue = conditionalUserProperty.mValue;
        if (mValue != null) {
            y5.b(bundle, mValue);
        }
        String mTriggerEventName = conditionalUserProperty.mTriggerEventName;
        if (mTriggerEventName != null) {
            bundle.putString("trigger_event_name", mTriggerEventName);
        }
        bundle.putLong("trigger_timeout", conditionalUserProperty.mTriggerTimeout);
        String mTimedOutEventName = conditionalUserProperty.mTimedOutEventName;
        if (mTimedOutEventName != null) {
            bundle.putString("timed_out_event_name", mTimedOutEventName);
        }
        Bundle mTimedOutEventParams = conditionalUserProperty.mTimedOutEventParams;
        if (mTimedOutEventParams != null) {
            bundle.putBundle("timed_out_event_params", mTimedOutEventParams);
        }
        String mTriggeredEventName = conditionalUserProperty.mTriggeredEventName;
        if (mTriggeredEventName != null) {
            bundle.putString("triggered_event_name", mTriggeredEventName);
        }
        Bundle mTriggeredEventParams = conditionalUserProperty.mTriggeredEventParams;
        if (mTriggeredEventParams != null) {
            bundle.putBundle("triggered_event_params", mTriggeredEventParams);
        }
        bundle.putLong("time_to_live", conditionalUserProperty.mTimeToLive);
        String mExpiredEventName = conditionalUserProperty.mExpiredEventName;
        if (mExpiredEventName != null) {
            bundle.putString("expired_event_name", mExpiredEventName);
        }
        Bundle mExpiredEventParams = conditionalUserProperty.mExpiredEventParams;
        if (mExpiredEventParams != null) {
            bundle.putBundle("expired_event_params", mExpiredEventParams);
        }
        bundle.putLong("creation_timestamp", conditionalUserProperty.mCreationTimestamp);
        String str2 = "active";
        bundle.putBoolean(str2, conditionalUserProperty.mActive);
        bundle.putLong("triggered_timestamp", conditionalUserProperty.mTriggeredTimestamp);
        this.a.zzv(bundle);
    }
}
