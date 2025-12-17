package com.google.firebase.auth.internal;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.r;
import com.google.android.gms.common.util.e;
import com.google.android.gms.common.util.h;
import com.google.android.gms.tasks.j;
import com.google.android.gms.tasks.k;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

/* loaded from: classes2.dex */
public final class zzbm {

    private static final com.google.firebase.auth.internal.zzbm zza;
    private final com.google.firebase.auth.internal.zzbd zzb;
    private final com.google.firebase.auth.internal.zzax zzc;
    static {
        zzbm zzbm = new zzbm();
        zzbm.zza = zzbm;
    }

    private zzbm() {
        super();
        this.zzb = zzbd.zzc();
        this.zzc = zzax.zza();
    }

    public static com.google.firebase.auth.internal.zzbm zzc() {
        return zzbm.zza;
    }

    public final j<AuthResult> zza() {
        return this.zzb.zza();
    }

    public final j<String> zzb() {
        return this.zzb.zzb();
    }

    public final void zzd(Context context) {
        this.zzb.zzd(context);
    }

    public final void zze(FirebaseAuth firebaseAuth) {
        this.zzb.zze(firebaseAuth);
    }

    public final void zzf(Context context, Status status2) {
        SharedPreferences.Editor obj3 = context.getSharedPreferences("com.google.firebase.auth.internal.ProcessDeathHelper", 0).edit();
        String str3 = "statusCode";
        obj3.putInt(str3, status2.k2());
        obj3.putString("statusMessage", status2.l2());
        obj3.putLong("timestamp", h.b().currentTimeMillis());
        obj3.commit();
    }

    public final void zzg(Context context, FirebaseAuth firebaseAuth2) {
        r.j(context);
        r.j(firebaseAuth2);
        SharedPreferences.Editor obj3 = context.getSharedPreferences("com.google.firebase.auth.internal.ProcessDeathHelper", 0).edit();
        obj3.putString("firebaseAppName", firebaseAuth2.getApp().getName());
        obj3.commit();
    }

    public final void zzh(Context context, FirebaseAuth firebaseAuth2, FirebaseUser firebaseUser3) {
        r.j(context);
        r.j(firebaseAuth2);
        r.j(firebaseUser3);
        SharedPreferences.Editor obj3 = context.getSharedPreferences("com.google.firebase.auth.internal.ProcessDeathHelper", 0).edit();
        obj3.putString("firebaseAppName", firebaseAuth2.getApp().getName());
        obj3.putString("firebaseUserUid", firebaseUser3.getUid());
        obj3.commit();
    }

    public final boolean zzi(Activity activity, k<AuthResult> k2, FirebaseAuth firebaseAuth3) {
        return this.zzc.zzf(activity, k2, firebaseAuth3, 0);
    }

    public final boolean zzj(Activity activity, k<AuthResult> k2, FirebaseAuth firebaseAuth3, FirebaseUser firebaseUser4) {
        return this.zzc.zzf(activity, k2, firebaseAuth3, firebaseUser4);
    }
}
