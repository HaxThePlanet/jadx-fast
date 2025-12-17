package com.google.android.gms.cloudmessaging;

import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.BroadcastReceiver.PendingResult;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.util.q.a;
import com.google.android.gms.tasks.m;
import f.c.a.d.b.f.e;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: classes2.dex */
public abstract class b extends BroadcastReceiver {

    private final ExecutorService zza;
    public b() {
        super();
        e.a();
        a aVar = new a("firebase-iid-executor");
        LinkedBlockingQueue linkedBlockingQueue = new LinkedBlockingQueue();
        super(1, 1, 60, obj4, TimeUnit.SECONDS, linkedBlockingQueue, aVar);
        threadPoolExecutor2.allowCoreThreadTimeOut(true);
        this.zza = Executors.unconfigurableExecutorService(threadPoolExecutor2);
    }

    private final int zzb(Context context, Intent intent2) {
        com.google.android.gms.tasks.j jVar;
        String stringExtra;
        long millis;
        boolean bundle;
        TimeUnit obj5;
        if (intent2.getExtras() == null) {
            return 500;
        }
        String str2 = "google.message_id";
        stringExtra = intent2.getStringExtra(str2);
        if (TextUtils.isEmpty(stringExtra)) {
            jVar = m.e(0);
        } else {
            bundle = new Bundle();
            bundle.putString(str2, stringExtra);
            jVar = w.b(context).c(2, bundle);
        }
        a aVar = new a(intent2);
        m.b(jVar, TimeUnit.SECONDS.toMillis(1), bundle);
        return onMessageReceive(context, aVar);
    }

    private final int zzc(Context context, Intent intent2) {
        android.os.Parcelable parcelableExtra;
        Bundle extras;
        String str = "pending_intent";
        parcelableExtra = intent2.getParcelableExtra(str);
        if ((PendingIntent)parcelableExtra != null) {
            (PendingIntent)parcelableExtra.send();
        }
        extras = intent2.getExtras();
        if (extras != null) {
            extras.remove(str);
        } else {
            extras = new Bundle();
        }
        if ("com.google.firebase.messaging.NOTIFICATION_DISMISS".equals(intent2.getAction())) {
            onNotificationDismissed(context, extras);
            return -1;
        }
        Log.e("CloudMessagingReceiver", "Unknown notification action");
        return 500;
    }

    @Override // android.content.BroadcastReceiver
    protected Executor getBroadcastExecutor() {
        return this.zza;
    }

    @Override // android.content.BroadcastReceiver
    protected abstract int onMessageReceive(Context context, com.google.android.gms.cloudmessaging.a a2);

    @Override // android.content.BroadcastReceiver
    protected abstract void onNotificationDismissed(Context context, Bundle bundle2);

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent2) {
        if (intent2 == null) {
        }
        super(this, intent2, context, isOrderedBroadcast(), goAsync());
        getBroadcastExecutor().execute(jVar2);
    }

    @Override // android.content.BroadcastReceiver
    public final void zza(Intent intent, Context context2, boolean z3, BroadcastReceiver.PendingResult broadcastReceiver$PendingResult4) {
        int parcelableExtra;
        int obj3;
        try {
            if (parcelableExtra instanceof Intent != null) {
            } else {
            }
            parcelableExtra = 0;
            if (parcelableExtra != 0) {
            } else {
            }
            obj3 = zzc(context2, parcelableExtra);
            obj3 = zzb(context2, intent);
            if (z3) {
            }
            pendingResult4.setResultCode(obj3);
            pendingResult4.finish();
            pendingResult4.finish();
            throw intent;
        }
    }
}
