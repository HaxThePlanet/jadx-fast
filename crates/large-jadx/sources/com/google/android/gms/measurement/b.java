package com.google.android.gms.measurement;

import android.os.Bundle;
import com.google.android.gms.common.internal.r;
import com.google.android.gms.common.util.e;
import com.google.android.gms.measurement.internal.b5;
import com.google.android.gms.measurement.internal.d2;
import com.google.android.gms.measurement.internal.i7;
import com.google.android.gms.measurement.internal.ia;
import java.util.List;
import java.util.Map;

/* loaded from: classes2.dex */
final class b extends com.google.android.gms.measurement.e {

    private final b5 a;
    private final i7 b;
    public b(b5 b5) {
        super(0);
        r.j(b5);
        this.a = b5;
        this.b = b5.I();
    }

    @Override // com.google.android.gms.measurement.e
    public final int zza(String string) {
        this.b.S(string);
        return 25;
    }

    @Override // com.google.android.gms.measurement.e
    public final long zzb() {
        return this.a.N().r0();
    }

    @Override // com.google.android.gms.measurement.e
    public final String zzh() {
        return this.b.X();
    }

    @Override // com.google.android.gms.measurement.e
    public final String zzi() {
        return this.b.Y();
    }

    @Override // com.google.android.gms.measurement.e
    public final String zzj() {
        return this.b.Z();
    }

    @Override // com.google.android.gms.measurement.e
    public final String zzk() {
        return this.b.X();
    }

    public final List<Bundle> zzm(String string, String string2) {
        return this.b.b0(string, string2);
    }

    public final Map<String, Object> zzo(String string, String string2, boolean z3) {
        return this.b.c0(string, string2, z3);
    }

    @Override // com.google.android.gms.measurement.e
    public final void zzp(String string) {
        this.a.y().l(string, this.a.c().a());
    }

    @Override // com.google.android.gms.measurement.e
    public final void zzq(String string, String string2, Bundle bundle3) {
        this.a.I().h0(string, string2, bundle3);
    }

    @Override // com.google.android.gms.measurement.e
    public final void zzr(String string) {
        this.a.y().m(string, this.a.c().a());
    }

    @Override // com.google.android.gms.measurement.e
    public final void zzs(String string, String string2, Bundle bundle3) {
        this.b.r(string, string2, bundle3);
    }

    @Override // com.google.android.gms.measurement.e
    public final void zzv(Bundle bundle) {
        this.b.D(bundle);
    }
}
