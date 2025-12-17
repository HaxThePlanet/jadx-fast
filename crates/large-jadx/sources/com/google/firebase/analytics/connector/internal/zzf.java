package com.google.firebase.analytics.connector.internal;

import android.os.Bundle;
import com.google.android.gms.measurement.a.a.a;
import com.google.firebase.analytics.connector.AnalyticsConnector.AnalyticsConnectorListener;

/* loaded from: classes2.dex */
final class zzf implements a.a {

    final com.google.firebase.analytics.connector.internal.zzg zza;
    public zzf(com.google.firebase.analytics.connector.internal.zzg zzg) {
        this.zza = zzg;
        super();
    }

    @Override // com.google.android.gms.measurement.a.a$a
    public final void onEvent(String string, String string2, Bundle bundle3, long l4) {
        String str;
        boolean obj2;
        Object obj3;
        Bundle obj4;
        if (string != null && !string.equals("crash") && zzc.zzk(string2)) {
            if (!string.equals("crash")) {
                if (zzc.zzk(string2)) {
                    obj2 = new Bundle();
                    obj2.putString("name", string2);
                    obj2.putLong("timestampInMillis", l4);
                    obj2.putBundle("params", bundle3);
                    zzg.zzd(this.zza).onMessageTriggered(3, obj2);
                }
            }
        }
    }
}
