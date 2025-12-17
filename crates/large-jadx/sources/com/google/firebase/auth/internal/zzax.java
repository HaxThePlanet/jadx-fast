package com.google.firebase.auth.internal;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.google.android.gms.common.internal.r;
import com.google.android.gms.common.internal.safeparcel.d;
import com.google.android.gms.internal.firebase-auth-api.up;
import com.google.android.gms.tasks.j;
import com.google.android.gms.tasks.k;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.zze;
import d.q.a.a;

/* loaded from: classes2.dex */
public final class zzax {

    private static com.google.firebase.auth.internal.zzax zza;
    private boolean zzb = false;
    private BroadcastReceiver zzc;
    private zzax() {
        super();
        final int i = 0;
    }

    public static com.google.firebase.auth.internal.zzax zza() {
        com.google.firebase.auth.internal.zzax zzax;
        if (zzax.zza == null) {
            zzax = new zzax();
            zzax.zza = zzax;
        }
        return zzax.zza;
    }

    static void zzb(com.google.firebase.auth.internal.zzax zzax, Intent intent2, k k3, FirebaseAuth firebaseAuth4, Context context5) {
        zzaq obj3 = new zzaq(zzax, k3, context5);
        obj3 = new zzap(zzax, k3, context5);
        firebaseAuth4.signInWithCredential(zzax.zzi(intent2)).addOnSuccessListener(obj3).addOnFailureListener(obj3);
    }

    static void zzc(com.google.firebase.auth.internal.zzax zzax, Intent intent2, k k3, FirebaseUser firebaseUser4, Context context5) {
        zzas obj3 = new zzas(zzax, k3, context5);
        obj3 = new zzar(zzax, k3, context5);
        firebaseUser4.linkWithCredential(zzax.zzi(intent2)).addOnSuccessListener(obj3).addOnFailureListener(obj3);
    }

    static void zzd(com.google.firebase.auth.internal.zzax zzax, Intent intent2, k k3, FirebaseUser firebaseUser4, Context context5) {
        zzau obj3 = new zzau(zzax, k3, context5);
        obj3 = new zzat(zzax, k3, context5);
        firebaseUser4.reauthenticateAndRetrieveData(zzax.zzi(intent2)).addOnSuccessListener(obj3).addOnFailureListener(obj3);
    }

    static void zze(Context context) {
        BroadcastReceiver zzc;
        Object obj2;
        com.google.firebase.auth.internal.zzax zza = zzax.zza;
        zza.zzb = false;
        if (zza.zzc != null) {
            a.b(context).e(zza2.zzc);
        }
        obj2.zzc = 0;
    }

    private final void zzh(Activity activity, BroadcastReceiver broadcastReceiver2) {
        this.zzc = broadcastReceiver2;
        IntentFilter intentFilter = new IntentFilter("com.google.firebase.auth.ACTION_RECEIVE_FIREBASE_AUTH_INTENT");
        a.b(activity).c(broadcastReceiver2, intentFilter);
    }

    private static final AuthCredential zzi(Intent intent) {
        r.j(intent);
        com.google.android.gms.common.internal.safeparcel.c obj2 = d.b(intent, "com.google.firebase.auth.internal.VERIFY_ASSERTION_REQUEST", up.CREATOR);
        (up)obj2.m2(true);
        return zze.zzb(obj2);
    }

    public final boolean zzf(Activity activity, k<AuthResult> k2, FirebaseAuth firebaseAuth3, FirebaseUser firebaseUser4) {
        if (!this.zzb) {
            super(this, activity, k2, firebaseAuth3, firebaseUser4);
            zzh(activity, zzav);
            int obj8 = 1;
            this.zzb = obj8;
            return obj8;
        }
        return 0;
    }

    public final boolean zzg(Activity activity, k<String> k2) {
        if (!this.zzb) {
            zzaw zzaw = new zzaw(this, activity, k2);
            zzh(activity, zzaw);
            int obj2 = 1;
            this.zzb = obj2;
            return obj2;
        }
        return 0;
    }
}
