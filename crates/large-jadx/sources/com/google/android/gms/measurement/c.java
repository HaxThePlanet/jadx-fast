package com.google.android.gms.measurement;

import android.os.Bundle;
import com.google.android.gms.common.internal.r;
import com.google.android.gms.measurement.internal.j7;
import java.util.List;
import java.util.Map;

/* loaded from: classes2.dex */
final class c extends com.google.android.gms.measurement.e {

    private final j7 a;
    public c(j7 j7) {
        super(0);
        r.j(j7);
        this.a = j7;
    }

    @Override // com.google.android.gms.measurement.e
    public final int zza(String string) {
        return this.a.zza(string);
    }

    @Override // com.google.android.gms.measurement.e
    public final long zzb() {
        return this.a.zzb();
    }

    @Override // com.google.android.gms.measurement.e
    public final String zzh() {
        return this.a.zzh();
    }

    @Override // com.google.android.gms.measurement.e
    public final String zzi() {
        return this.a.zzi();
    }

    @Override // com.google.android.gms.measurement.e
    public final String zzj() {
        return this.a.zzj();
    }

    @Override // com.google.android.gms.measurement.e
    public final String zzk() {
        return this.a.zzk();
    }

    public final List<Bundle> zzm(String string, String string2) {
        return this.a.zzm(string, string2);
    }

    public final Map<String, Object> zzo(String string, String string2, boolean z3) {
        return this.a.zzo(string, string2, z3);
    }

    @Override // com.google.android.gms.measurement.e
    public final void zzp(String string) {
        this.a.zzp(string);
    }

    @Override // com.google.android.gms.measurement.e
    public final void zzq(String string, String string2, Bundle bundle3) {
        this.a.zzq(string, string2, bundle3);
    }

    @Override // com.google.android.gms.measurement.e
    public final void zzr(String string) {
        this.a.zzr(string);
    }

    @Override // com.google.android.gms.measurement.e
    public final void zzs(String string, String string2, Bundle bundle3) {
        this.a.zzs(string, string2, bundle3);
    }

    @Override // com.google.android.gms.measurement.e
    public final void zzv(Bundle bundle) {
        this.a.zzv(bundle);
    }
}
