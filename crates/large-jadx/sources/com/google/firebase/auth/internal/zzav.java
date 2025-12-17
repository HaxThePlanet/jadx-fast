package com.google.firebase.auth.internal;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.firebase-auth-api.ql;
import com.google.android.gms.tasks.k;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import java.lang.ref.WeakReference;

/* loaded from: classes2.dex */
final class zzav extends BroadcastReceiver {

    final com.google.firebase.auth.internal.zzax zza;
    private final WeakReference<Activity> zzb;
    private final k<AuthResult> zzc;
    private final FirebaseAuth zzd;
    private final FirebaseUser zze;
    zzav(com.google.firebase.auth.internal.zzax zzax, Activity activity2, k k3, FirebaseAuth firebaseAuth4, FirebaseUser firebaseUser5) {
        this.zza = zzax;
        super();
        WeakReference obj1 = new WeakReference(activity2);
        this.zzb = obj1;
        this.zzc = k3;
        this.zzd = firebaseAuth4;
        this.zze = firebaseUser5;
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent2) {
        Object str;
        boolean obj5;
        if ((Activity)this.zzb.get() == null) {
            Log.e("FederatedAuthReceiver", "Failed to unregister BroadcastReceiver because the Activity that launched this flow has been garbage collected; please do not finish() your Activity while performing a FederatedAuthProvider operation.");
            Status status = new Status(17499, "Activity that started the web operation is no longer alive; see logcat for details");
            this.zzc.b(ql.a(status));
            zzax.zze(context);
        }
        String str3 = "com.google.firebase.auth.internal.OPERATION";
        String stringExtra = intent2.getStringExtra(str3);
        if (intent2.hasExtra(str3) && "com.google.firebase.auth.internal.NONGMSCORE_SIGN_IN".equals(stringExtra)) {
            stringExtra = intent2.getStringExtra(str3);
            if ("com.google.firebase.auth.internal.NONGMSCORE_SIGN_IN".equals(stringExtra)) {
                zzax.zzb(this.zza, intent2, this.zzc, this.zzd, context);
            }
            if ("com.google.firebase.auth.internal.NONGMSCORE_LINK".equals(stringExtra)) {
                zzax.zzc(this.zza, intent2, this.zzc, this.zze, context);
            }
            if ("com.google.firebase.auth.internal.NONGMSCORE_REAUTHENTICATE".equals(stringExtra)) {
                zzax.zzd(this.zza, intent2, this.zzc, this.zze, context);
            }
            StringBuilder stringBuilder = new StringBuilder(obj5 += 50);
            stringBuilder.append("WEB_CONTEXT_CANCELED:Unknown operation received (");
            stringBuilder.append(stringExtra);
            stringBuilder.append(")");
            this.zzc.b(ql.a(zzai.zza(stringBuilder.toString())));
        }
        if (zzbl.zzd(intent2)) {
            this.zzc.b(ql.a(zzbl.zza(intent2)));
            zzax.zze(context);
        }
        if (intent2.hasExtra("com.google.firebase.auth.internal.EXTRA_CANCELED")) {
            this.zzc.b(ql.a(zzai.zza("WEB_CONTEXT_CANCELED")));
            zzax.zze(context);
        }
    }
}
