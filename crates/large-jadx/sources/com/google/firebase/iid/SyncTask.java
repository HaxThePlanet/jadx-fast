package com.google.firebase.iid;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import android.util.Log;
import com.google.firebase.FirebaseApp;
import java.io.IOException;
import java.util.concurrent.ExecutorService;

/* loaded from: classes2.dex */
class SyncTask implements Runnable {

    private final com.google.firebase.iid.FirebaseInstanceId iid;
    private final long nextDelaySeconds;
    ExecutorService processorExecutor;
    private final PowerManager.WakeLock syncWakeLock;

    static class ConnectivityChangeReceiver extends BroadcastReceiver {

        private com.google.firebase.iid.SyncTask task;
        public ConnectivityChangeReceiver(com.google.firebase.iid.SyncTask syncTask) {
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
            if (FirebaseInstanceId.isDebugLogEnabled()) {
                Log.d("FirebaseInstanceId", "Connectivity changed. Starting background sync.");
            }
            SyncTask.access$000(this.task).enqueueTaskWithDelaySeconds(this.task, 0);
            this.task.getContext().unregisterReceiver(this);
            this.task = 0;
        }

        @Override // android.content.BroadcastReceiver
        public void registerReceiver() {
            boolean debugLogEnabled;
            String str;
            if (FirebaseInstanceId.isDebugLogEnabled()) {
                Log.d("FirebaseInstanceId", "Connectivity change received registered");
            }
            IntentFilter intentFilter = new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE");
            this.task.getContext().registerReceiver(this, intentFilter);
        }
    }
    SyncTask(com.google.firebase.iid.FirebaseInstanceId firebaseInstanceId, long l2) {
        super();
        this.processorExecutor = FirebaseIidExecutors.newCachedSingleThreadExecutor();
        this.iid = firebaseInstanceId;
        this.nextDelaySeconds = l2;
        PowerManager.WakeLock obj2 = (PowerManager)getContext().getSystemService("power").newWakeLock(1, "fiid-sync");
        this.syncWakeLock = obj2;
        obj2.setReferenceCounted(false);
    }

    static com.google.firebase.iid.FirebaseInstanceId access$000(com.google.firebase.iid.SyncTask syncTask) {
        return syncTask.iid;
    }

    @Override // java.lang.Runnable
    Context getContext() {
        return this.iid.getApp().getApplicationContext();
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
        final String str = "FirebaseInstanceId";
        int i2 = 1;
        if (!this.iid.tokenNeedsRefresh(this.iid.getTokenWithoutTriggeringSync())) {
            return i2;
        }
        if (this.iid.blockingGetMasterToken() == null) {
            Log.e(str, "Token retrieval failed: null");
            return 0;
        }
        if (Log.isLoggable(str, 3)) {
            Log.d(str, "Token successfully retrieved");
        }
        return i2;
    }

    @Override // java.lang.Runnable
    public void run() {
        boolean wakeLockPermission2;
        boolean wakeLockPermission;
        Throwable syncWakeLock;
        boolean accessNetworkStatePermission;
        com.google.firebase.iid.FirebaseInstanceId iid;
        Context context;
        int nextDelaySeconds;
        String str;
        StringBuilder stringBuilder;
        if (ServiceStarter.getInstance().hasWakeLockPermission(getContext())) {
            this.syncWakeLock.acquire();
        }
        int i = 0;
        this.iid.setSyncScheduledOrRunning(true);
        if (!this.iid.isGmsCorePresent()) {
            this.iid.setSyncScheduledOrRunning(i);
            if (ServiceStarter.getInstance().hasWakeLockPermission(getContext())) {
                this.syncWakeLock.release();
            }
        } else {
        }
    }
}
