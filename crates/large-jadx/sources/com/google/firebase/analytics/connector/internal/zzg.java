package com.google.firebase.analytics.connector.internal;

import com.google.android.gms.measurement.a.a;
import com.google.firebase.analytics.connector.AnalyticsConnector.AnalyticsConnectorListener;
import java.util.Set;

/* loaded from: classes2.dex */
public final class zzg implements com.google.firebase.analytics.connector.internal.zza {

    private final AnalyticsConnector.AnalyticsConnectorListener zza;
    private final a zzb;
    private final com.google.firebase.analytics.connector.internal.zzf zzc;
    public zzg(a a, AnalyticsConnector.AnalyticsConnectorListener analyticsConnector$AnalyticsConnectorListener2) {
        super();
        this.zza = analyticsConnectorListener2;
        this.zzb = a;
        zzf obj2 = new zzf(this);
        this.zzc = obj2;
        a.f(obj2);
    }

    static AnalyticsConnector.AnalyticsConnectorListener zzd(com.google.firebase.analytics.connector.internal.zzg zzg) {
        return zzg.zza;
    }

    @Override // com.google.firebase.analytics.connector.internal.zza
    public final AnalyticsConnector.AnalyticsConnectorListener zza() {
        return this.zza;
    }

    public final void zzb(Set<String> set) {
    }

    @Override // com.google.firebase.analytics.connector.internal.zza
    public final void zzc() {
    }
}
