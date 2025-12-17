package com.google.firebase.auth.internal;

import android.os.Handler;
import android.os.HandlerThread;
import com.google.android.gms.common.internal.r;
import com.google.android.gms.common.l.a;
import com.google.android.gms.common.util.e;
import com.google.android.gms.common.util.h;
import com.google.android.gms.internal.firebase-auth-api.v9;
import com.google.firebase.FirebaseApp;

/* loaded from: classes2.dex */
public final class zzam {

    private static final a zzg;
    volatile long zza;
    volatile long zzb;
    final long zzc = 300000;
    final HandlerThread zzd;
    final Handler zze;
    final Runnable zzf;
    private final FirebaseApp zzh;
    static {
        a aVar = new a("TokenRefresher", /* result */);
        zzam.zzg = aVar;
    }

    public zzam(FirebaseApp firebaseApp) {
        super();
        zzam.zzg.g("Initializing TokenRefresher", new Object[0]);
        r.j(firebaseApp);
        this.zzh = (FirebaseApp)firebaseApp;
        HandlerThread handlerThread = new HandlerThread("TokenRefresher", 10);
        this.zzd = handlerThread;
        handlerThread.start();
        v9 v9Var = new v9(handlerThread.getLooper());
        this.zze = v9Var;
        zzal zzal = new zzal(this, firebaseApp.getName());
        this.zzf = zzal;
        int i = 300000;
    }

    static a zza() {
        return zzam.zzg;
    }

    public final void zzb() {
        this.zze.removeCallbacks(this.zzf);
    }

    public final void zzc() {
        final long zzc2 = this.zzc;
        StringBuilder stringBuilder = new StringBuilder(43);
        stringBuilder.append("Scheduling refresh for ");
        stringBuilder.append(zza -= zzc2);
        String string = stringBuilder.toString();
        zzam.zzg.g(string, new Object[0]);
        zzb();
        int i7 = 1000;
        this.zzb = l /= i7;
        this.zze.postDelayed(this.zzf, zzb *= i7);
    }

    final void zzd() {
        int i;
        int i2;
        int i3 = (int)zzb;
        if (i3 != 30 && i3 != 60 && i3 != 120 && i3 != 240 && i3 != 480) {
            if (i3 != 60) {
                if (i3 != 120) {
                    if (i3 != 240) {
                        if (i3 != 480) {
                            i = i3 != 960 ? 30 : 960;
                        } else {
                            long zzb2 = this.zzb;
                            zzb2 += zzb2;
                        }
                    } else {
                    }
                } else {
                }
            } else {
            }
        } else {
        }
        this.zzb = i;
        final int i8 = 1000;
        zzb3 *= i8;
        this.zza = currentTimeMillis += i5;
        StringBuilder stringBuilder = new StringBuilder(43);
        stringBuilder.append("Scheduling refresh for ");
        stringBuilder.append(this.zza);
        zzam.zzg.g(stringBuilder.toString(), new Object[0]);
        this.zze.postDelayed(this.zzf, zzb4 *= i8);
    }
}
