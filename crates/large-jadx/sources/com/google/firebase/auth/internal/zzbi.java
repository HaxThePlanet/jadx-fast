package com.google.firebase.auth.internal;

import android.content.Context;
import com.google.android.gms.common.api.internal.d;
import com.google.android.gms.internal.firebase-auth-api.to;
import com.google.firebase.FirebaseApp;

/* loaded from: classes2.dex */
public final class zzbi {

    private volatile int zza = 0;
    private final com.google.firebase.auth.internal.zzam zzb;
    private volatile boolean zzc = false;
    public zzbi(FirebaseApp firebaseApp) {
        zzam zzam = new zzam(firebaseApp);
        super();
        int obj3 = 0;
        this.zzb = zzam;
        d.c((Application)firebaseApp.getApplicationContext().getApplicationContext());
        zzbh zzbh = new zzbh(this);
        d.b().a(zzbh);
    }

    static com.google.firebase.auth.internal.zzam zza(com.google.firebase.auth.internal.zzbi zzbi) {
        return zzbi.zzb;
    }

    static boolean zze(com.google.firebase.auth.internal.zzbi zzbi, boolean z2) {
        zzbi.zzc = z2;
        return z2;
    }

    static boolean zzf(com.google.firebase.auth.internal.zzbi zzbi) {
        return zzbi.zzg();
    }

    private final boolean zzg() {
        int zza;
        if (this.zza > 0 && !this.zzc) {
            if (!this.zzc) {
                return 1;
            }
        }
        return 0;
    }

    public final void zzb() {
        this.zzb.zzb();
    }

    public final void zzc(int i) {
        boolean zza;
        if (i > 0 && this.zza == 0) {
            if (this.zza == 0) {
                this.zza = i;
                if (zzg()) {
                    this.zzb.zzc();
                }
            } else {
                if (i == 0 && this.zza != 0) {
                    if (this.zza != 0) {
                        this.zzb.zzb();
                    }
                }
            }
        } else {
        }
        this.zza = i;
    }

    public final void zzd(to to) {
        long l;
        boolean obj7;
        if (to == null) {
        }
        if (Long.compare(l, i3) <= 0) {
            l = 3600;
        }
        obj7 = this.zzb;
        obj7.zza = l2 += i;
        obj7.zzb = -1;
        if (zzg()) {
            this.zzb.zzc();
        }
    }
}
