package com.google.firebase.messaging;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build.VERSION;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import android.util.Log;
import com.google.android.gms.common.util.q.a;
import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: classes2.dex */
class SyncTask implements Runnable {

    private final com.google.firebase.messaging.FirebaseMessaging firebaseMessaging;
    private final long nextDelaySeconds;
    ExecutorService processorExecutor;
    private final PowerManager.WakeLock syncWakeLock;

    static class ConnectivityChangeReceiver extends BroadcastReceiver {

        private com.google.firebase.messaging.SyncTask task;
        public ConnectivityChangeReceiver(com.google.firebase.messaging.SyncTask syncTask) {
            super();
            this.task = syncTask;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent2) {
            boolean obj3;
            String obj4;
            obj3 = this.task;
            if (obj3 == null) {
            }
            if (!obj3.isDeviceConnected()) {
            }
            if (SyncTask.isDebugLogEnabled()) {
                Log.d("FirebaseMessaging", "Connectivity changed. Starting background sync.");
            }
            SyncTask.-$$Nest$fgetfirebaseMessaging(this.task).enqueueTaskWithDelaySeconds(this.task, 0);
            this.task.getContext().unregisterReceiver(this);
            this.task = 0;
        }

        @Override // android.content.BroadcastReceiver
        public void registerReceiver() {
            boolean debugLogEnabled;
            String str;
            if (SyncTask.isDebugLogEnabled()) {
                Log.d("FirebaseMessaging", "Connectivity change received registered");
            }
            IntentFilter intentFilter = new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE");
            this.task.getContext().registerReceiver(this, intentFilter);
        }
    }
    static com.google.firebase.messaging.FirebaseMessaging -$$Nest$fgetfirebaseMessaging(com.google.firebase.messaging.SyncTask syncTask) {
        return syncTask.firebaseMessaging;
    }

    public SyncTask(com.google.firebase.messaging.FirebaseMessaging firebaseMessaging, long l2) {
        super();
        LinkedBlockingQueue linkedBlockingQueue = new LinkedBlockingQueue();
        a aVar = new a("firebase-iid-executor");
        super(0, 1, 30, obj4, TimeUnit.SECONDS, linkedBlockingQueue, aVar);
        this.processorExecutor = threadPoolExecutor2;
        this.firebaseMessaging = firebaseMessaging;
        this.nextDelaySeconds = l2;
        PowerManager.WakeLock obj10 = (PowerManager)getContext().getSystemService("power").newWakeLock(1, "fiid-sync");
        this.syncWakeLock = obj10;
        obj10.setReferenceCounted(false);
    }

    static boolean isDebugLogEnabled() {
        String loggable;
        boolean sDK_INT;
        int i;
        int i2;
        loggable = "FirebaseMessaging";
        final int i3 = 3;
        if (!Log.isLoggable(loggable, i3)) {
            if (Build.VERSION.SDK_INT == 23 && Log.isLoggable(loggable, i3)) {
                if (Log.isLoggable(loggable, i3)) {
                    i = i4;
                }
                return 0;
            }
        } else {
        }
        return i;
    }

    @Override // java.lang.Runnable
    Context getContext() {
        return this.firebaseMessaging.getApplicationContext();
    }

    @Override // java.lang.Runnable
    boolean isDeviceConnected() {
        NetworkInfo activeNetworkInfo;
        Object systemService = getContext().getSystemService("connectivity");
        if ((ConnectivityManager)systemService != null) {
            activeNetworkInfo = (ConnectivityManager)systemService.getActiveNetworkInfo();
        } else {
            activeNetworkInfo = 0;
        }
        if (activeNetworkInfo != null && activeNetworkInfo.isConnected()) {
            if (activeNetworkInfo.isConnected()) {
                return 1;
            }
        }
        return 0;
    }

    @Override // java.lang.Runnable
    boolean maybeRefreshToken() {
        boolean loggable;
        String str = "FirebaseMessaging";
        if (this.firebaseMessaging.blockingGetToken() == null) {
            Log.e(str, "Token retrieval failed: null");
            return 0;
        }
        if (Log.isLoggable(str, 3)) {
            try {
                Log.d(str, "Token successfully retrieved");
                return 1;
                String str2 = "Token retrieval failed with SecurityException. Will retry token retrieval";
                Log.w(obj0, str2);
                return obj1;
                String message = str2.getMessage();
                message = GmsRpc.isErrorMessageForRetryableError(message);
                if (message != null) {
                }
                str2 = str2.getMessage();
                message = String.valueOf(str2);
                message = message.length();
                message += 52;
                StringBuilder stringBuilder = new StringBuilder(message);
                message = "Token retrieval failed: ";
                stringBuilder.append(message);
                stringBuilder.append(str2);
                str2 = ". Will retry token retrieval";
                stringBuilder.append(str2);
                str2 = stringBuilder.toString();
                Log.w(obj0, str2);
                return obj1;
                message = str2.getMessage();
                if (message != null) {
                } else {
                }
                str2 = "Token retrieval failed without exception message. Will retry token retrieval";
                Log.w(obj0, str2);
                return obj1;
                throw str2;
            }
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        boolean wakeLockPermission2;
        boolean wakeLockPermission;
        Throwable syncWakeLock;
        boolean accessNetworkStatePermission;
        com.google.firebase.messaging.FirebaseMessaging firebaseMessaging;
        Context context;
        int nextDelaySeconds;
        String str;
        StringBuilder stringBuilder;
        if (ServiceStarter.getInstance().hasWakeLockPermission(getContext())) {
            this.syncWakeLock.acquire();
        }
        int i = 0;
        this.firebaseMessaging.setSyncScheduledOrRunning(true);
        if (!this.firebaseMessaging.isGmsCorePresent()) {
            this.firebaseMessaging.setSyncScheduledOrRunning(i);
            if (ServiceStarter.getInstance().hasWakeLockPermission(getContext())) {
                this.syncWakeLock.release();
            }
        } else {
        }
    }
}
