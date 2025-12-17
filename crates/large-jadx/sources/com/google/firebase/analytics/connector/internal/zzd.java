package com.google.firebase.analytics.connector.internal;

import android.os.Bundle;
import com.google.android.gms.measurement.a.a.a;
import com.google.firebase.analytics.connector.AnalyticsConnector.AnalyticsConnectorListener;
import java.util.Set;

/* loaded from: classes2.dex */
final class zzd implements a.a {

    final com.google.firebase.analytics.connector.internal.zze zza;
    public zzd(com.google.firebase.analytics.connector.internal.zze zze) {
        this.zza = zze;
        super();
    }

    @Override // com.google.android.gms.measurement.a.a$a
    public final void onEvent(String string, String string2, Bundle bundle3, long l4) {
        if (!obj1.zza.contains(string2)) {
        }
        Bundle obj1 = new Bundle();
        obj1.putString("events", zzc.zzc(string2));
        zze.zzd(this.zza).onMessageTriggered(2, obj1);
    }
}
