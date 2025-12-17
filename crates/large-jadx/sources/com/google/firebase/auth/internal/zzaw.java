package com.google.firebase.auth.internal;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.firebase-auth-api.ql;
import com.google.android.gms.tasks.k;
import java.lang.ref.WeakReference;

/* loaded from: classes2.dex */
final class zzaw extends BroadcastReceiver {

    final com.google.firebase.auth.internal.zzax zza;
    private final WeakReference<Activity> zzb;
    private final k<String> zzc;
    zzaw(com.google.firebase.auth.internal.zzax zzax, Activity activity2, k k3) {
        this.zza = zzax;
        super();
        WeakReference obj1 = new WeakReference(activity2);
        this.zzb = obj1;
        this.zzc = k3;
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent2) {
        Object str;
        boolean obj5;
        if ((Activity)this.zzb.get() == null) {
            Log.e("FederatedAuthReceiver", "Failed to unregister BroadcastReceiver because the Activity that launched this flow has been garbage collected; please do not finish() your Activity while performing a FederatedAuthProvider operation.");
            Status status2 = new Status(17499, "Activity that started the web operation is no longer alive; see logcat for details");
            this.zzc.b(ql.a(status2));
            zzax.zze(context);
        }
        String str2 = "com.google.firebase.auth.internal.OPERATION";
        String stringExtra = intent2.getStringExtra(str2);
        if (intent2.hasExtra(str2) && "com.google.firebase.auth.internal.ACTION_SHOW_RECAPTCHA".equals(stringExtra)) {
            stringExtra = intent2.getStringExtra(str2);
            if ("com.google.firebase.auth.internal.ACTION_SHOW_RECAPTCHA".equals(stringExtra)) {
                this.zzc.c(intent2.getStringExtra("com.google.firebase.auth.internal.RECAPTCHA_TOKEN"));
                zzax.zze(context);
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
