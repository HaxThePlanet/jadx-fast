package com.google.android.gms.internal.measurement;

/* loaded from: classes2.dex */
public final class ad implements com.google.android.gms.internal.measurement.zc {

    public static final com.google.android.gms.internal.measurement.w6<Boolean> a;
    public static final com.google.android.gms.internal.measurement.w6<Boolean> b;
    public static final com.google.android.gms.internal.measurement.w6<Boolean> c;
    static {
        t6 t6Var = new t6(m6.a("com.google.android.gms.measurement"));
        t6Var.e("measurement.service.audience.fix_skip_audience_with_failed_filters", true);
        int i2 = 0;
        ad.a = t6Var.e("measurement.audience.refresh_event_count_filters_timestamp", i2);
        ad.b = t6Var.e("measurement.audience.use_bundle_end_timestamp_for_non_sequence_property_filters", i2);
        ad.c = t6Var.e("measurement.audience.use_bundle_timestamp_for_event_count_filters", i2);
    }

    @Override // com.google.android.gms.internal.measurement.zc
    public final boolean b() {
        return (Boolean)ad.c.b().booleanValue();
    }

    @Override // com.google.android.gms.internal.measurement.zc
    public final boolean zza() {
        return 1;
    }

    @Override // com.google.android.gms.internal.measurement.zc
    public final boolean zzb() {
        return (Boolean)ad.a.b().booleanValue();
    }

    @Override // com.google.android.gms.internal.measurement.zc
    public final boolean zzc() {
        return (Boolean)ad.b.b().booleanValue();
    }
}
