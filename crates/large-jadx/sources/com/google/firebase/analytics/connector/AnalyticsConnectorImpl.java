package com.google.firebase.analytics.connector;

import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.common.internal.r;
import com.google.android.gms.internal.measurement.g3;
import com.google.android.gms.measurement.a.a;
import com.google.firebase.FirebaseApp;
import com.google.firebase.analytics.connector.internal.zza;
import com.google.firebase.analytics.connector.internal.zzc;
import com.google.firebase.analytics.connector.internal.zze;
import com.google.firebase.analytics.connector.internal.zzg;
import com.google.firebase.events.Event;
import com.google.firebase.events.Subscriber;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes2.dex */
public class AnalyticsConnectorImpl implements com.google.firebase.analytics.connector.AnalyticsConnector {

    private static volatile com.google.firebase.analytics.connector.AnalyticsConnector zzc;
    final a zza;
    final Map<String, zza> zzb;
    AnalyticsConnectorImpl(a a) {
        super();
        r.j(a);
        this.zza = a;
        ConcurrentHashMap obj1 = new ConcurrentHashMap();
        this.zzb = obj1;
    }

    public static com.google.firebase.analytics.connector.AnalyticsConnector getInstance() {
        return AnalyticsConnectorImpl.getInstance(FirebaseApp.getInstance());
    }

    public static com.google.firebase.analytics.connector.AnalyticsConnector getInstance(FirebaseApp firebaseApp) {
        return (AnalyticsConnector)firebaseApp.get(AnalyticsConnector.class);
    }

    public static com.google.firebase.analytics.connector.AnalyticsConnector getInstance(FirebaseApp firebaseApp, Context context2, Subscriber subscriber3) {
        com.google.firebase.analytics.connector.AnalyticsConnector zzc;
        Object bundle;
        boolean defaultApp;
        com.google.firebase.analytics.connector.zzb zza;
        com.google.firebase.analytics.connector.zza zza2;
        Object obj5;
        Object obj6;
        Object obj7;
        r.j(firebaseApp);
        r.j(context2);
        r.j(subscriber3);
        r.j(context2.getApplicationContext());
        zzc = AnalyticsConnectorImpl.class;
        bundle = new Bundle(1);
        if (AnalyticsConnectorImpl.zzc == null && AnalyticsConnectorImpl.zzc == null && firebaseApp.isDefaultApp()) {
            zzc = AnalyticsConnectorImpl.class;
            synchronized (zzc) {
                bundle = new Bundle(1);
                if (firebaseApp.isDefaultApp()) {
                    subscriber3.subscribe(DataCollectionDefaultChange.class, zzb.zza, zza.zza);
                    bundle.putBoolean("dataCollectionDefaultEnabled", firebaseApp.isDataCollectionDefaultEnabled());
                }
                obj7 = 0;
                obj5 = new AnalyticsConnectorImpl(g3.A(context2, obj7, obj7, obj7, bundle).x());
                AnalyticsConnectorImpl.zzc = obj5;
            }
        }
        return AnalyticsConnectorImpl.zzc;
    }

    static void zza(Event event) {
        final Class<com.google.firebase.analytics.connector.AnalyticsConnectorImpl> obj = AnalyticsConnectorImpl.class;
        com.google.firebase.analytics.connector.AnalyticsConnector zzc = AnalyticsConnectorImpl.zzc;
        r.j(zzc);
        zzc.zza.i(obj2.enabled);
        return;
        synchronized (obj) {
            obj = AnalyticsConnectorImpl.class;
            zzc = AnalyticsConnectorImpl.zzc;
            r.j((AnalyticsConnectorImpl)zzc);
            zzc.zza.i(obj2.enabled);
        }
    }

    static boolean zzb(com.google.firebase.analytics.connector.AnalyticsConnectorImpl analyticsConnectorImpl, String string2) {
        return analyticsConnectorImpl.zzc(string2);
    }

    private final boolean zzc(String string) {
        boolean empty;
        Object obj2;
        if (!string.isEmpty() && this.zzb.containsKey(string) && this.zzb.get(string) != null) {
            if (this.zzb.containsKey(string)) {
                if (this.zzb.get(string) != null) {
                    return 1;
                }
            }
        }
        return 0;
    }

    @Override // com.google.firebase.analytics.connector.AnalyticsConnector
    public void clearConditionalUserProperty(String string, String string2, Bundle bundle3) {
        boolean z;
        if (string2 != null && !zzc.zzj(string2, bundle3)) {
            if (!zzc.zzj(string2, bundle3)) {
            }
        }
        this.zza.a(string, string2, bundle3);
    }

    public List<com.google.firebase.analytics.connector.AnalyticsConnector.ConditionalUserProperty> getConditionalUserProperties(String string, String string2) {
        String obj4;
        ArrayList arrayList = new ArrayList();
        Iterator obj3 = this.zza.b(string, string2).iterator();
        for (Bundle obj4 : obj3) {
            arrayList.add(zzc.zzb(obj4));
        }
        return arrayList;
    }

    @Override // com.google.firebase.analytics.connector.AnalyticsConnector
    public int getMaxUserProperties(String string) {
        return this.zza.c(string);
    }

    public Map<String, Object> getUserProperties(boolean z) {
        final int i = 0;
        return this.zza.d(i, i, z);
    }

    @Override // com.google.firebase.analytics.connector.AnalyticsConnector
    public void logEvent(String string, String string2, Bundle bundle3) {
        Bundle obj4;
        if (bundle3 == null) {
            obj4 = new Bundle();
        }
        if (!zzc.zzl(string)) {
        }
        if (!zzc.zzj(string2, obj4)) {
        }
        if (!zzc.zzh(string, string2, obj4)) {
        }
        zzc.zze(string, string2, obj4);
        this.zza.e(string, string2, obj4);
    }

    @Override // com.google.firebase.analytics.connector.AnalyticsConnector
    public com.google.firebase.analytics.connector.AnalyticsConnector.AnalyticsConnectorHandle registerAnalyticsConnectorListener(String string, com.google.firebase.analytics.connector.AnalyticsConnector.AnalyticsConnectorListener analyticsConnector$AnalyticsConnectorListener2) {
        int zzg;
        boolean equals;
        r.j(analyticsConnectorListener2);
        final int i = 0;
        if (!zzc.zzl(string)) {
            return i;
        }
        if (zzc(string)) {
            return i;
        }
        a zza = this.zza;
        if ("fiam".equals(string)) {
            zzg = new zze(zza, analyticsConnectorListener2);
        } else {
            if (!"crash".equals(string)) {
                if ("clx".equals(string)) {
                    zzg = new zzg(zza, analyticsConnectorListener2);
                } else {
                    zzg = i;
                }
            } else {
            }
        }
        if (zzg != 0) {
            this.zzb.put(string, zzg);
            AnalyticsConnectorImpl.1 obj5 = new AnalyticsConnectorImpl.1(this, string);
            return obj5;
        }
        return i;
    }

    @Override // com.google.firebase.analytics.connector.AnalyticsConnector
    public void setConditionalUserProperty(com.google.firebase.analytics.connector.AnalyticsConnector.ConditionalUserProperty analyticsConnector$ConditionalUserProperty) {
        if (!zzc.zzi(conditionalUserProperty)) {
        }
        this.zza.g(zzc.zza(conditionalUserProperty));
    }

    @Override // com.google.firebase.analytics.connector.AnalyticsConnector
    public void setUserProperty(String string, String string2, Object object3) {
        if (!zzc.zzl(string)) {
        }
        if (!zzc.zzm(string, string2)) {
        }
        this.zza.h(string, string2, object3);
    }
}
