package com.google.firebase.messaging;

import android.content.Context;
import android.content.Intent;
import android.util.Base64;
import android.util.Log;
import com.google.android.gms.common.util.l;
import com.google.android.gms.tasks.j;
import com.google.android.gms.tasks.m;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;

/* loaded from: classes2.dex */
public class FcmBroadcastProcessor {

    private static com.google.firebase.messaging.WithinAppServiceConnection fcmServiceConn;
    private static final Object lock;
    private final Context context;
    private final Executor executor;
    static {
        Object object = new Object();
        FcmBroadcastProcessor.lock = object;
    }

    public FcmBroadcastProcessor(Context context) {
        super();
        this.context = context;
        this.executor = FcmBroadcastProcessor$$ExternalSyntheticLambda4.INSTANCE;
    }

    public FcmBroadcastProcessor(Context context, ExecutorService executorService2) {
        super();
        this.context = context;
        this.executor = executorService2;
    }

    private static j<Integer> bindToMessagingService(Context context, Intent intent2) {
        boolean loggable;
        String str = "FirebaseMessaging";
        if (Log.isLoggable(str, 3)) {
            Log.d(str, "Binding to service");
        }
        return FcmBroadcastProcessor.getServiceConnection(context, "com.google.firebase.MESSAGING_EVENT").sendIntent(intent2).continueWith(FcmBroadcastProcessor$$ExternalSyntheticLambda4.INSTANCE, FcmBroadcastProcessor$$ExternalSyntheticLambda1.INSTANCE);
    }

    private static com.google.firebase.messaging.WithinAppServiceConnection getServiceConnection(Context context, String string2) {
        com.google.firebase.messaging.WithinAppServiceConnection withinAppServiceConnection;
        final Object lock = FcmBroadcastProcessor.lock;
        synchronized (lock) {
            withinAppServiceConnection = new WithinAppServiceConnection(context, "com.google.firebase.MESSAGING_EVENT");
            FcmBroadcastProcessor.fcmServiceConn = withinAppServiceConnection;
            return FcmBroadcastProcessor.fcmServiceConn;
        }
    }

    static Integer lambda$bindToMessagingService$3(j j) {
        return -1;
    }

    static Integer lambda$startMessagingService$0(Context context, Intent intent2) {
        return Integer.valueOf(ServiceStarter.getInstance().startMessagingService(context, intent2));
    }

    static Integer lambda$startMessagingService$1(j j) {
        return 403;
    }

    static j lambda$startMessagingService$2(Context context, Intent intent2, j j3) {
        boolean intValue;
        int i;
        if (l.h() && (Integer)j3.getResult().intValue() != 402) {
            if ((Integer)j3.getResult().intValue() != 402) {
            }
            return FcmBroadcastProcessor.bindToMessagingService(context, intent2).continueWith(FcmBroadcastProcessor$$ExternalSyntheticLambda4.INSTANCE, FcmBroadcastProcessor$$ExternalSyntheticLambda2.INSTANCE);
        }
        return j3;
    }

    public static void reset() {
        final Object lock = FcmBroadcastProcessor.lock;
        FcmBroadcastProcessor.fcmServiceConn = 0;
        return;
        synchronized (lock) {
            lock = FcmBroadcastProcessor.lock;
            FcmBroadcastProcessor.fcmServiceConn = 0;
        }
    }

    public j<Integer> process(Intent intent) {
        String stringExtra;
        String str;
        String str2 = "gcm.rawData64";
        stringExtra = intent.getStringExtra(str2);
        if (stringExtra != null) {
            intent.putExtra("rawData", Base64.decode(stringExtra, 0));
            intent.removeExtra(str2);
        }
        return startMessagingService(this.context, intent);
    }

    public j<Integer> startMessagingService(Context context, Intent intent2) {
        boolean targetSdkVersion;
        int i;
        int i2;
        i = 0;
        if (l.h() && applicationInfo.targetSdkVersion >= 26) {
            if (applicationInfo.targetSdkVersion >= 26) {
                i = 1;
            }
        }
        if (i != 0 && flags &= i4 == 0) {
            if (flags &= i4 == 0) {
                return FcmBroadcastProcessor.bindToMessagingService(context, intent2);
            }
        }
        FcmBroadcastProcessor$$ExternalSyntheticLambda3 externalSyntheticLambda3 = new FcmBroadcastProcessor$$ExternalSyntheticLambda3(context, intent2);
        FcmBroadcastProcessor$$ExternalSyntheticLambda0 externalSyntheticLambda0 = new FcmBroadcastProcessor$$ExternalSyntheticLambda0(context, intent2);
        return m.c(this.executor, externalSyntheticLambda3).continueWithTask(this.executor, externalSyntheticLambda0);
    }
}
