package com.google.firebase.analytics.connector.internal;

import com.google.android.gms.common.internal.r;
import com.google.android.gms.measurement.a.a;
import com.google.firebase.analytics.connector.AnalyticsConnector.AnalyticsConnectorListener;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* loaded from: classes2.dex */
public final class zze implements com.google.firebase.analytics.connector.internal.zza {

    final Set<String> zza;
    private final AnalyticsConnector.AnalyticsConnectorListener zzb;
    private final a zzc;
    private final com.google.firebase.analytics.connector.internal.zzd zzd;
    public zze(a a, AnalyticsConnector.AnalyticsConnectorListener analyticsConnector$AnalyticsConnectorListener2) {
        super();
        this.zzb = analyticsConnectorListener2;
        this.zzc = a;
        zzd obj2 = new zzd(this);
        this.zzd = obj2;
        a.f(obj2);
        HashSet obj1 = new HashSet();
        this.zza = obj1;
    }

    static AnalyticsConnector.AnalyticsConnectorListener zzd(com.google.firebase.analytics.connector.internal.zze zze) {
        return zze.zzb;
    }

    @Override // com.google.firebase.analytics.connector.internal.zza
    public final AnalyticsConnector.AnalyticsConnectorListener zza() {
        return this.zzb;
    }

    public final void zzb(Set<String> set) {
        Object next;
        boolean size;
        int i;
        this.zza.clear();
        HashSet hashSet = new HashSet();
        final Iterator obj6 = set.iterator();
        while (obj6.hasNext()) {
            next = obj6.next();
            if (hashSet.size() >= 50) {
                break;
            } else {
            }
            if (zzc.zzf((String)next) && zzc.zzg(next)) {
            }
            if (zzc.zzg(next)) {
            }
            next = zzc.zzd(next);
            r.j(next);
            hashSet.add(next);
        }
        this.zza.addAll(hashSet);
    }

    @Override // com.google.firebase.analytics.connector.internal.zza
    public final void zzc() {
        this.zza.clear();
    }
}
