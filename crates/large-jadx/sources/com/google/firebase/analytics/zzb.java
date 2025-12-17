package com.google.firebase.analytics;

import com.google.android.gms.internal.measurement.g3;
import java.util.concurrent.Callable;

/* loaded from: classes2.dex */
final class zzb implements Callable<String> {

    final com.google.firebase.analytics.FirebaseAnalytics zza;
    zzb(com.google.firebase.analytics.FirebaseAnalytics firebaseAnalytics) {
        this.zza = firebaseAnalytics;
        super();
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        return FirebaseAnalytics.zza(this.zza).D();
    }
}
