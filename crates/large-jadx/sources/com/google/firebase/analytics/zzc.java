package com.google.firebase.analytics;

import android.os.Bundle;
import com.google.android.gms.internal.measurement.g3;
import com.google.android.gms.measurement.internal.c6;
import com.google.android.gms.measurement.internal.d6;
import com.google.android.gms.measurement.internal.j7;
import java.util.List;
import java.util.Map;

/* loaded from: classes2.dex */
final class zzc implements j7 {

    final g3 zza;
    zzc(g3 g3) {
        this.zza = g3;
        super();
    }

    @Override // com.google.android.gms.measurement.internal.j7
    public final int zza(String string) {
        return this.zza.v(string);
    }

    @Override // com.google.android.gms.measurement.internal.j7
    public final long zzb() {
        return this.zza.w();
    }

    @Override // com.google.android.gms.measurement.internal.j7
    public final Object zzg(int i) {
        return this.zza.B(i);
    }

    @Override // com.google.android.gms.measurement.internal.j7
    public final String zzh() {
        return this.zza.E();
    }

    @Override // com.google.android.gms.measurement.internal.j7
    public final String zzi() {
        return this.zza.F();
    }

    @Override // com.google.android.gms.measurement.internal.j7
    public final String zzj() {
        return this.zza.G();
    }

    @Override // com.google.android.gms.measurement.internal.j7
    public final String zzk() {
        return this.zza.H();
    }

    public final List<Bundle> zzm(String string, String string2) {
        return this.zza.I(string, string2);
    }

    public final Map<String, Object> zzo(String string, String string2, boolean z3) {
        return this.zza.J(string, string2, z3);
    }

    @Override // com.google.android.gms.measurement.internal.j7
    public final void zzp(String string) {
        this.zza.N(string);
    }

    @Override // com.google.android.gms.measurement.internal.j7
    public final void zzq(String string, String string2, Bundle bundle3) {
        this.zza.O(string, string2, bundle3);
    }

    @Override // com.google.android.gms.measurement.internal.j7
    public final void zzr(String string) {
        this.zza.P(string);
    }

    @Override // com.google.android.gms.measurement.internal.j7
    public final void zzs(String string, String string2, Bundle bundle3) {
        this.zza.R(string, string2, bundle3);
    }

    @Override // com.google.android.gms.measurement.internal.j7
    public final void zzt(String string, String string2, Bundle bundle3, long l4) {
        this.zza.S(string, string2, bundle3, l4);
    }

    @Override // com.google.android.gms.measurement.internal.j7
    public final void zzu(d6 d6) {
        this.zza.b(d6);
    }

    @Override // com.google.android.gms.measurement.internal.j7
    public final void zzv(Bundle bundle) {
        this.zza.d(bundle);
    }

    @Override // com.google.android.gms.measurement.internal.j7
    public final void zzw(c6 c6) {
        this.zza.i(c6);
    }

    @Override // com.google.android.gms.measurement.internal.j7
    public final void zzx(d6 d6) {
        this.zza.n(d6);
    }
}
