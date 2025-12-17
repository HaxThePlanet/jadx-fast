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
import java.io.IOException;

/* loaded from: classes2.dex */
class TopicsSyncTask implements Runnable {

    private static final Object TOPIC_SYNC_TASK_LOCK;
    private static Boolean hasAccessNetworkStatePermission;
    private static Boolean hasWakeLockPermission;
    private final Context context;
    private final com.google.firebase.messaging.Metadata metadata;
    private final long nextDelaySeconds;
    private final PowerManager.WakeLock syncWakeLock;
    private final com.google.firebase.messaging.TopicsSubscriber topicsSubscriber;

    class ConnectivityChangeReceiver extends BroadcastReceiver {

        private com.google.firebase.messaging.TopicsSyncTask task;
        final com.google.firebase.messaging.TopicsSyncTask this$0;
        public ConnectivityChangeReceiver(com.google.firebase.messaging.TopicsSyncTask topicsSyncTask, com.google.firebase.messaging.TopicsSyncTask topicsSyncTask2) {
            this.this$0 = topicsSyncTask;
            super();
            this.task = topicsSyncTask2;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent2) {
            String str;
            boolean obj5;
            obj5 = this.task;
            synchronized (this) {
                try {
                }
            }
        }

        @Override // android.content.BroadcastReceiver
        public void registerReceiver() {
            boolean str;
            String str2;
            if (TopicsSyncTask.-$$Nest$smisLoggable()) {
                Log.d("FirebaseMessaging", "Connectivity change received registered");
            }
            IntentFilter intentFilter = new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE");
            TopicsSyncTask.-$$Nest$fgetcontext(this.this$0).registerReceiver(this, intentFilter);
        }
    }
    static Context -$$Nest$fgetcontext(com.google.firebase.messaging.TopicsSyncTask topicsSyncTask) {
        return topicsSyncTask.context;
    }

    static com.google.firebase.messaging.TopicsSubscriber -$$Nest$fgettopicsSubscriber(com.google.firebase.messaging.TopicsSyncTask topicsSyncTask) {
        return topicsSyncTask.topicsSubscriber;
    }

    static boolean -$$Nest$misDeviceConnected(com.google.firebase.messaging.TopicsSyncTask topicsSyncTask) {
        return topicsSyncTask.isDeviceConnected();
    }

    static boolean -$$Nest$smisLoggable() {
        return TopicsSyncTask.isLoggable();
    }

    static {
        Object object = new Object();
        TopicsSyncTask.TOPIC_SYNC_TASK_LOCK = object;
    }

    TopicsSyncTask(com.google.firebase.messaging.TopicsSubscriber topicsSubscriber, Context context2, com.google.firebase.messaging.Metadata metadata3, long l4) {
        super();
        this.topicsSubscriber = topicsSubscriber;
        this.context = context2;
        this.nextDelaySeconds = l4;
        this.metadata = metadata3;
        this.syncWakeLock = (PowerManager)context2.getSystemService("power").newWakeLock(1, "wake:com.google.firebase.messaging");
    }

    private static String createPermissionMissingLog(String string) {
        StringBuilder stringBuilder = new StringBuilder(length += 142);
        stringBuilder.append("Missing Permission: ");
        stringBuilder.append(string);
        stringBuilder.append(". This permission should normally be included by the manifest merger, but may needed to be manually added to your manifest");
        return stringBuilder.toString();
    }

    private static boolean hasAccessNetworkStatePermission(Context context) {
        String str;
        boolean obj3;
        final Object tOPIC_SYNC_TASK_LOCK = TopicsSyncTask.TOPIC_SYNC_TASK_LOCK;
        final Boolean hasAccessNetworkStatePermission = TopicsSyncTask.hasAccessNetworkStatePermission;
        synchronized (tOPIC_SYNC_TASK_LOCK) {
            obj3 = TopicsSyncTask.hasPermission(context, "android.permission.ACCESS_NETWORK_STATE", hasAccessNetworkStatePermission);
            try {
                obj3 = Boolean.valueOf(obj3);
                TopicsSyncTask.hasAccessNetworkStatePermission = obj3;
                return obj3.booleanValue();
                throw context;
            }
        }
    }

    private static boolean hasPermission(Context context, String string2, Boolean boolean3) {
        boolean loggable;
        String str;
        int obj2;
        if (boolean3 != null) {
            return boolean3.booleanValue();
        }
        final int obj4 = 0;
        obj2 = context.checkCallingOrSelfPermission(string2) == 0 ? 1 : obj4;
        str = "FirebaseMessaging";
        if (obj2 == null && Log.isLoggable(str, 3)) {
            str = "FirebaseMessaging";
            if (Log.isLoggable(str, 3)) {
                Log.d(str, TopicsSyncTask.createPermissionMissingLog(string2));
                return obj4;
            }
        }
        return obj2;
    }

    private static boolean hasWakeLockPermission(Context context) {
        String str;
        boolean obj3;
        final Object tOPIC_SYNC_TASK_LOCK = TopicsSyncTask.TOPIC_SYNC_TASK_LOCK;
        final Boolean hasWakeLockPermission = TopicsSyncTask.hasWakeLockPermission;
        synchronized (tOPIC_SYNC_TASK_LOCK) {
            obj3 = TopicsSyncTask.hasPermission(context, "android.permission.WAKE_LOCK", hasWakeLockPermission);
            try {
                obj3 = Boolean.valueOf(obj3);
                TopicsSyncTask.hasWakeLockPermission = obj3;
                return obj3.booleanValue();
                throw context;
            }
        }
    }

    private boolean isDeviceConnected() {
        int activeNetworkInfo;
        int i;
        Object systemService = this.context.getSystemService("connectivity");
        synchronized (this) {
            try {
                activeNetworkInfo = (ConnectivityManager)systemService.getActiveNetworkInfo();
                activeNetworkInfo = 0;
                if (activeNetworkInfo != 0 && activeNetworkInfo.isConnected()) {
                } else {
                }
                if (activeNetworkInfo.isConnected()) {
                } else {
                }
                i = 1;
                return i;
                i = 0;
                throw th;
            }
        }
    }

    private static boolean isLoggable() {
        String loggable;
        boolean sDK_INT;
        int i2;
        int i;
        loggable = "FirebaseMessaging";
        final int i3 = 3;
        if (!Log.isLoggable(loggable, i3)) {
            if (Build.VERSION.SDK_INT == 23 && Log.isLoggable(loggable, i3)) {
                if (Log.isLoggable(loggable, i3)) {
                    i2 = i4;
                }
                return 0;
            }
        } else {
        }
        return i2;
    }

    @Override // java.lang.Runnable
    public void run() {
        boolean wakeLockPermission2;
        boolean wakeLockPermission;
        Throwable wAKE_LOCK_ACQUIRE_TIMEOUT_MILLIS;
        boolean accessNetworkStatePermission;
        com.google.firebase.messaging.TopicsSubscriber topicsSubscriber;
        int nextDelaySeconds;
        final String str = "TopicsSyncTask's wakelock was already released due to timeout.";
        final String str2 = "FirebaseMessaging";
        if (TopicsSyncTask.hasWakeLockPermission(this.context)) {
            this.syncWakeLock.acquire(Constants.WAKE_LOCK_ACQUIRE_TIMEOUT_MILLIS);
        }
        int i = 0;
        this.topicsSubscriber.setSyncScheduledOrRunning(true);
        this.topicsSubscriber.setSyncScheduledOrRunning(i);
        if (!this.metadata.isGmscorePresent() && TopicsSyncTask.hasWakeLockPermission(this.context)) {
            this.topicsSubscriber.setSyncScheduledOrRunning(i);
            if (TopicsSyncTask.hasWakeLockPermission(this.context)) {
                this.syncWakeLock.release();
            }
        }
        TopicsSyncTask.ConnectivityChangeReceiver connectivityChangeReceiver = new TopicsSyncTask.ConnectivityChangeReceiver(this, this);
        connectivityChangeReceiver.registerReceiver();
        if (TopicsSyncTask.hasAccessNetworkStatePermission(this.context) && !isDeviceConnected() && TopicsSyncTask.hasWakeLockPermission(this.context)) {
            if (!isDeviceConnected()) {
                connectivityChangeReceiver = new TopicsSyncTask.ConnectivityChangeReceiver(this, this);
                connectivityChangeReceiver.registerReceiver();
                if (TopicsSyncTask.hasWakeLockPermission(this.context)) {
                    this.syncWakeLock.release();
                }
            }
        }
        if (this.topicsSubscriber.syncTopics()) {
            this.topicsSubscriber.setSyncScheduledOrRunning(i);
        } else {
            this.topicsSubscriber.syncWithDelaySecondsInternal(this.nextDelaySeconds);
        }
        if (TopicsSyncTask.hasWakeLockPermission(this.context)) {
            this.syncWakeLock.release();
        }
    }
}
