package com.google.firebase.messaging;

import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.PackageManager;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.Keep;
import com.google.android.gms.common.internal.r;
import com.google.android.gms.common.util.q.a;
import com.google.android.gms.tasks.j;
import com.google.android.gms.tasks.k;
import com.google.android.gms.tasks.m;
import com.google.firebase.DataCollectionDefaultChange;
import com.google.firebase.FirebaseApp;
import com.google.firebase.events.Event;
import com.google.firebase.events.EventHandler;
import com.google.firebase.events.Subscriber;
import com.google.firebase.heartbeatinfo.HeartBeatInfo;
import com.google.firebase.iid.internal.FirebaseInstanceIdInternal;
import com.google.firebase.inject.Provider;
import com.google.firebase.installations.FirebaseInstallationsApi;
import com.google.firebase.platforminfo.UserAgentPublisher;
import f.c.a.b.g;
import java.io.IOException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: classes2.dex */
public class FirebaseMessaging {

    @Deprecated
    public static final String INSTANCE_ID_SCOPE = "FCM";
    private static final long MAX_DELAY_SEC;
    private static com.google.firebase.messaging.Store store;
    static ScheduledExecutorService syncExecutor;
    static g transportFactory;
    private final com.google.firebase.messaging.FirebaseMessaging.AutoInit autoInit;
    private final Context context;
    private final Executor fileIoExecutor;
    private final FirebaseApp firebaseApp;
    private final FirebaseInstallationsApi fis;
    private final com.google.firebase.messaging.GmsRpc gmsRpc;
    private final FirebaseInstanceIdInternal iid;
    private final Application.ActivityLifecycleCallbacks lifecycleCallbacks;
    private final com.google.firebase.messaging.Metadata metadata;
    private final com.google.firebase.messaging.RequestDeduplicator requestDeduplicator;
    private boolean syncScheduledOrRunning;
    private final Executor taskExecutor;
    private final j<com.google.firebase.messaging.TopicsSubscriber> topicsSubscriberTask;

    private class AutoInit {

        private Boolean autoInitEnabled;
        private EventHandler<DataCollectionDefaultChange> dataCollectionDefaultChangeEventHandler;
        private boolean initialized;
        private final Subscriber subscriber;
        final com.google.firebase.messaging.FirebaseMessaging this$0;
        AutoInit(com.google.firebase.messaging.FirebaseMessaging firebaseMessaging, Subscriber subscriber2) {
            this.this$0 = firebaseMessaging;
            super();
            this.subscriber = subscriber2;
        }

        private Boolean readEnabled() {
            Object applicationContext;
            PackageManager packageManager;
            int i;
            String str = "firebase_messaging_auto_init_enabled";
            applicationContext = FirebaseMessaging.-$$Nest$fgetfirebaseApp(this.this$0).getApplicationContext();
            i = 0;
            SharedPreferences sharedPreferences = applicationContext.getSharedPreferences("com.google.firebase.messaging", i);
            final String str3 = "auto_init";
            if (sharedPreferences.contains(str3)) {
                return Boolean.valueOf(sharedPreferences.getBoolean(str3, i));
            }
            packageManager = applicationContext.getPackageManager();
            applicationContext = packageManager.getApplicationInfo(applicationContext.getPackageName(), 128);
            packageManager = applicationContext.metaData;
            if (packageManager != null && applicationContext != null && packageManager != null && packageManager.containsKey(str)) {
                applicationContext = packageManager.getApplicationInfo(applicationContext.getPackageName(), 128);
                if (applicationContext != null) {
                    packageManager = applicationContext.metaData;
                    if (packageManager != null) {
                        if (packageManager.containsKey(str)) {
                            return Boolean.valueOf(applicationContext.metaData.getBoolean(str));
                        }
                    }
                }
            }
            return null;
        }

        void initialize() {
            Object enabled;
            Subscriber subscriber;
            Class<DataCollectionDefaultChange> obj;
            synchronized (this) {
                try {
                    enabled = readEnabled();
                    this.autoInitEnabled = enabled;
                }
                enabled = new FirebaseMessaging.AutoInit$$ExternalSyntheticLambda0(this);
                this.dataCollectionDefaultChangeEventHandler = enabled;
                this.subscriber.subscribe(DataCollectionDefaultChange.class, enabled);
                this.initialized = true;
            }
        }

        boolean isEnabled() {
            boolean dataCollectionDefaultEnabled;
            initialize();
            Boolean autoInitEnabled = this.autoInitEnabled;
            synchronized (this) {
                try {
                    dataCollectionDefaultEnabled = autoInitEnabled.booleanValue();
                    dataCollectionDefaultEnabled = FirebaseMessaging.-$$Nest$fgetfirebaseApp(this.this$0).isDataCollectionDefaultEnabled();
                    return dataCollectionDefaultEnabled;
                    throw th;
                }
            }
        }

        void lambda$initialize$0$com-google-firebase-messaging-FirebaseMessaging$AutoInit(Event event) {
            boolean obj1;
            if (isEnabled()) {
                FirebaseMessaging.-$$Nest$mstartSyncIfNecessary(this.this$0);
            }
        }

        void setEnabled(boolean z) {
            EventHandler dataCollectionDefaultChangeEventHandler;
            Object edit;
            Subscriber subscriber;
            Class<DataCollectionDefaultChange> obj;
            initialize();
            dataCollectionDefaultChangeEventHandler = this.dataCollectionDefaultChangeEventHandler;
            synchronized (this) {
                try {
                    this.subscriber.unsubscribe(DataCollectionDefaultChange.class, dataCollectionDefaultChangeEventHandler);
                    this.dataCollectionDefaultChangeEventHandler = 0;
                    edit = FirebaseMessaging.-$$Nest$fgetfirebaseApp(this.this$0).getApplicationContext().getSharedPreferences("com.google.firebase.messaging", 0).edit();
                    edit.putBoolean("auto_init", z);
                    edit.apply();
                    if (z) {
                    }
                    FirebaseMessaging.-$$Nest$mstartSyncIfNecessary(this.this$0);
                    this.autoInitEnabled = Boolean.valueOf(z);
                    throw z;
                }
            }
        }
    }
    public static void $r8$lambda$iw3kunv9-hQO8R-88V1J4aIyLI8(com.google.firebase.messaging.FirebaseMessaging firebaseMessaging, String string2) {
        firebaseMessaging.invokeOnTokenRefresh(string2);
    }

    static FirebaseApp -$$Nest$fgetfirebaseApp(com.google.firebase.messaging.FirebaseMessaging firebaseMessaging) {
        return firebaseMessaging.firebaseApp;
    }

    static void -$$Nest$mstartSyncIfNecessary(com.google.firebase.messaging.FirebaseMessaging firebaseMessaging) {
        firebaseMessaging.startSyncIfNecessary();
    }

    static {
        FirebaseMessaging.MAX_DELAY_SEC = TimeUnit.HOURS.toSeconds(8);
    }

    FirebaseMessaging(FirebaseApp firebaseApp, FirebaseInstanceIdInternal firebaseInstanceIdInternal2, Provider<UserAgentPublisher> provider3, Provider<HeartBeatInfo> provider4, FirebaseInstallationsApi firebaseInstallationsApi5, g g6, Subscriber subscriber7) {
        Metadata metadata = new Metadata(firebaseApp.getApplicationContext());
        super(firebaseApp, firebaseInstanceIdInternal2, provider3, provider4, firebaseInstallationsApi5, g6, subscriber7, metadata);
    }

    FirebaseMessaging(FirebaseApp firebaseApp, FirebaseInstanceIdInternal firebaseInstanceIdInternal2, Provider<UserAgentPublisher> provider3, Provider<HeartBeatInfo> provider4, FirebaseInstallationsApi firebaseInstallationsApi5, g g6, Subscriber subscriber7, com.google.firebase.messaging.Metadata metadata8) {
        final FirebaseApp firebaseApp2 = firebaseApp;
        super(firebaseApp2, metadata8, provider3, provider4, firebaseInstallationsApi5);
        super(firebaseApp2, firebaseInstanceIdInternal2, firebaseInstallationsApi5, g6, subscriber7, metadata8, gmsRpc2, FcmExecutors.newTaskExecutor(), FcmExecutors.newInitExecutor());
    }

    FirebaseMessaging(FirebaseApp firebaseApp, FirebaseInstanceIdInternal firebaseInstanceIdInternal2, FirebaseInstallationsApi firebaseInstallationsApi3, g g4, Subscriber subscriber5, com.google.firebase.messaging.Metadata metadata6, com.google.firebase.messaging.GmsRpc gmsRpc7, Executor executor8, Executor executor9) {
        Object obj2;
        Object obj5;
        boolean obj6;
        super();
        this.syncScheduledOrRunning = false;
        FirebaseMessaging.transportFactory = g4;
        this.firebaseApp = firebaseApp;
        this.iid = firebaseInstanceIdInternal2;
        this.fis = firebaseInstallationsApi3;
        FirebaseMessaging.AutoInit obj4 = new FirebaseMessaging.AutoInit(this, subscriber5);
        this.autoInit = obj4;
        obj4 = firebaseApp.getApplicationContext();
        this.context = obj4;
        obj5 = new FcmLifecycleCallbacks();
        this.lifecycleCallbacks = obj5;
        this.metadata = metadata6;
        this.taskExecutor = executor8;
        this.gmsRpc = gmsRpc7;
        obj6 = new RequestDeduplicator(executor8);
        this.requestDeduplicator = obj6;
        this.fileIoExecutor = executor9;
        obj2 = firebaseApp.getApplicationContext();
        if (obj2 instanceof Application) {
            (Application)obj2.registerActivityLifecycleCallbacks(obj5);
        } else {
            obj2 = String.valueOf(obj2);
            obj6 = new StringBuilder(obj5 += 125);
            obj6.append("Context ");
            obj6.append(obj2);
            obj6.append(" was not an application, can't register for lifecycle callbacks. Some notification events may be dropped as a result.");
            Log.w("FirebaseMessaging", obj6.toString());
        }
        if (firebaseInstanceIdInternal2 != null) {
            obj2 = new FirebaseMessaging$$ExternalSyntheticLambda4(this);
            firebaseInstanceIdInternal2.addNewTokenListener(obj2);
        }
        obj2 = new FirebaseMessaging$$ExternalSyntheticLambda6(this);
        executor9.execute(obj2);
        obj2 = TopicsSubscriber.createInstance(this, metadata6, gmsRpc7, obj4, FcmExecutors.newTopicsSyncExecutor());
        this.topicsSubscriberTask = obj2;
        FirebaseMessaging$$ExternalSyntheticLambda0 obj3 = new FirebaseMessaging$$ExternalSyntheticLambda0(this);
        obj2.addOnSuccessListener(executor9, obj3);
        obj2 = new FirebaseMessaging$$ExternalSyntheticLambda7(this);
        executor9.execute(obj2);
    }

    public static com.google.firebase.messaging.FirebaseMessaging getInstance() {
        final Class<com.google.firebase.messaging.FirebaseMessaging> obj = FirebaseMessaging.class;
        return FirebaseMessaging.getInstance(FirebaseApp.getInstance());
        synchronized (obj) {
            obj = FirebaseMessaging.class;
            return FirebaseMessaging.getInstance(FirebaseApp.getInstance());
        }
    }

    static com.google.firebase.messaging.FirebaseMessaging getInstance(FirebaseApp firebaseApp) {
        final Class<com.google.firebase.messaging.FirebaseMessaging> obj = FirebaseMessaging.class;
        final Object obj2 = firebaseApp.get(obj);
        r.k((FirebaseMessaging)obj2, "Firebase Messaging component is not present");
        return obj2;
        synchronized (obj) {
            obj = FirebaseMessaging.class;
            obj2 = firebaseApp.get(obj);
            r.k((FirebaseMessaging)obj2, "Firebase Messaging component is not present");
            return obj2;
        }
    }

    private static com.google.firebase.messaging.Store getStore(Context context) {
        com.google.firebase.messaging.Store store;
        final Class<com.google.firebase.messaging.FirebaseMessaging> obj = FirebaseMessaging.class;
        synchronized (obj) {
            store = new Store(context);
            FirebaseMessaging.store = store;
            return FirebaseMessaging.store;
        }
    }

    private String getSubtype() {
        String persistenceKey;
        if ("[DEFAULT]".equals(this.firebaseApp.getName())) {
            persistenceKey = "";
        } else {
            persistenceKey = this.firebaseApp.getPersistenceKey();
        }
        return persistenceKey;
    }

    public static g getTransportFactory() {
        return FirebaseMessaging.transportFactory;
    }

    private void invokeOnTokenRefresh(String string) {
        boolean equals;
        boolean loggable;
        Object context;
        String str;
        int length;
        Object obj5;
        String str2 = "FirebaseMessaging";
        if ("[DEFAULT]".equals(this.firebaseApp.getName()) && Log.isLoggable(str2, 3)) {
            str2 = "FirebaseMessaging";
            if (Log.isLoggable(str2, 3)) {
                String valueOf = String.valueOf(this.firebaseApp.getName());
                str = "Invoking onNewToken for app: ";
                if (valueOf.length() != 0) {
                    loggable = str.concat(valueOf);
                } else {
                    loggable = new String(str);
                }
                Log.d(str2, loggable);
            }
            equals = new Intent("com.google.firebase.messaging.NEW_TOKEN");
            equals.putExtra("token", string);
            obj5 = new FcmBroadcastProcessor(this.context);
            obj5.process(equals);
        }
    }

    static j lambda$subscribeToTopic$6(String string, com.google.firebase.messaging.TopicsSubscriber topicsSubscriber2) {
        return topicsSubscriber2.subscribeToTopic(string);
    }

    static j lambda$unsubscribeFromTopic$7(String string, com.google.firebase.messaging.TopicsSubscriber topicsSubscriber2) {
        return topicsSubscriber2.unsubscribeFromTopic(string);
    }

    private void startSync() {
        synchronized (this) {
            try {
                syncWithDelaySecondsInternal(0);
                throw th;
            }
        }
    }

    private void startSyncIfNecessary() {
        FirebaseInstanceIdInternal iid = this.iid;
        if (iid != null) {
            iid.getToken();
        }
        if (tokenNeedsRefresh(getTokenWithoutTriggeringSync())) {
            startSync();
        }
    }

    String blockingGetToken() {
        FirebaseInstanceIdInternal iid = this.iid;
        if (iid != null) {
            return (String)m.a(iid.getTokenTask());
        }
        com.google.firebase.messaging.Store.Token tokenWithoutTriggeringSync = getTokenWithoutTriggeringSync();
        if (!tokenNeedsRefresh(tokenWithoutTriggeringSync)) {
            return tokenWithoutTriggeringSync.token;
        }
        String defaultSenderId = Metadata.getDefaultSenderId(this.firebaseApp);
        FirebaseMessaging$$ExternalSyntheticLambda5 externalSyntheticLambda5 = new FirebaseMessaging$$ExternalSyntheticLambda5(this, defaultSenderId, tokenWithoutTriggeringSync);
        return (String)m.a(this.requestDeduplicator.getOrStartGetTokenRequest(defaultSenderId, externalSyntheticLambda5));
    }

    public j<Void> deleteToken() {
        if (this.iid != null) {
            k kVar = new k();
            FirebaseMessaging$$ExternalSyntheticLambda8 externalSyntheticLambda8 = new FirebaseMessaging$$ExternalSyntheticLambda8(this, kVar);
            this.fileIoExecutor.execute(externalSyntheticLambda8);
            return kVar.a();
        }
        if (getTokenWithoutTriggeringSync() == null) {
            return m.e(0);
        }
        k kVar2 = new k();
        FirebaseMessaging$$ExternalSyntheticLambda9 externalSyntheticLambda9 = new FirebaseMessaging$$ExternalSyntheticLambda9(this, kVar2);
        FcmExecutors.newNetworkIOExecutor().execute(externalSyntheticLambda9);
        return kVar2.a();
    }

    public boolean deliveryMetricsExportToBigQueryEnabled() {
        return MessagingAnalytics.deliveryMetricsExportToBigQueryEnabled();
    }

    void enqueueTaskWithDelaySeconds(Runnable runnable, long l2) {
        Object scheduledThreadPoolExecutor;
        a aVar;
        int i;
        final Class<com.google.firebase.messaging.FirebaseMessaging> obj = FirebaseMessaging.class;
        synchronized (obj) {
            aVar = new a("TAG");
            scheduledThreadPoolExecutor = new ScheduledThreadPoolExecutor(1, aVar);
            FirebaseMessaging.syncExecutor = scheduledThreadPoolExecutor;
            FirebaseMessaging.syncExecutor.schedule(runnable, l2, obj7);
        }
    }

    Context getApplicationContext() {
        return this.context;
    }

    public j<String> getToken() {
        FirebaseInstanceIdInternal iid = this.iid;
        if (iid != null) {
            return iid.getTokenTask();
        }
        k kVar = new k();
        FirebaseMessaging$$ExternalSyntheticLambda10 externalSyntheticLambda10 = new FirebaseMessaging$$ExternalSyntheticLambda10(this, kVar);
        this.fileIoExecutor.execute(externalSyntheticLambda10);
        return kVar.a();
    }

    com.google.firebase.messaging.Store.Token getTokenWithoutTriggeringSync() {
        return FirebaseMessaging.getStore(this.context).getToken(getSubtype(), Metadata.getDefaultSenderId(this.firebaseApp));
    }

    public boolean isAutoInitEnabled() {
        return this.autoInit.isEnabled();
    }

    boolean isGmsCorePresent() {
        return this.metadata.isGmscorePresent();
    }

    public boolean isNotificationDelegationEnabled() {
        return ProxyNotificationInitializer.isProxyNotificationEnabled(this.context);
    }

    j lambda$blockingGetToken$8$com-google-firebase-messaging-FirebaseMessaging(String string, com.google.firebase.messaging.Store.Token store$Token2, String string3) {
        boolean obj4;
        FirebaseMessaging.getStore(this.context).saveToken(getSubtype(), string, string3, this.metadata.getAppVersionCode());
        if (token2 != null) {
            if (!string3.equals(token2.token)) {
                invokeOnTokenRefresh(string3);
            }
        } else {
        }
        return m.e(string3);
    }

    j lambda$blockingGetToken$9$com-google-firebase-messaging-FirebaseMessaging(String string, com.google.firebase.messaging.Store.Token store$Token2) {
        FirebaseMessaging$$ExternalSyntheticLambda1 externalSyntheticLambda1 = new FirebaseMessaging$$ExternalSyntheticLambda1(this, string, token2);
        return this.gmsRpc.getToken().onSuccessTask(FirebaseMessaging$$ExternalSyntheticLambda11.INSTANCE, externalSyntheticLambda1);
    }

    void lambda$deleteToken$4$com-google-firebase-messaging-FirebaseMessaging(k k) {
        try {
            this.iid.deleteToken(Metadata.getDefaultSenderId(this.firebaseApp), "FCM");
            k.c(0);
            k.b(th);
        }
    }

    void lambda$deleteToken$5$com-google-firebase-messaging-FirebaseMessaging(k k) {
        try {
            m.a(this.gmsRpc.deleteToken());
            FirebaseMessaging.getStore(this.context).deleteToken(getSubtype(), Metadata.getDefaultSenderId(this.firebaseApp));
            k.c(0);
            k.b(th);
        }
    }

    void lambda$getToken$3$com-google-firebase-messaging-FirebaseMessaging(k k) {
        try {
            k.c(blockingGetToken());
            k.b(th);
        }
    }

    void lambda$new$0$com-google-firebase-messaging-FirebaseMessaging() {
        if (isAutoInitEnabled()) {
            startSyncIfNecessary();
        }
    }

    void lambda$new$1$com-google-firebase-messaging-FirebaseMessaging(com.google.firebase.messaging.TopicsSubscriber topicsSubscriber) {
        if (isAutoInitEnabled()) {
            topicsSubscriber.startTopicsSyncIfNecessary();
        }
    }

    void lambda$new$2$com-google-firebase-messaging-FirebaseMessaging() {
        ProxyNotificationInitializer.initialize(this.context);
    }

    public void send(com.google.firebase.messaging.RemoteMessage remoteMessage) {
        int i;
        if (TextUtils.isEmpty(remoteMessage.getTo())) {
        } else {
            Intent intent = new Intent("com.google.android.gcm.intent.SEND");
            Intent intent2 = new Intent();
            intent2.setPackage("com.google.example.invalidpackage");
            final int i3 = 0;
            i = Build.VERSION.SDK_INT >= 23 ? 67108864 : i3;
            intent.putExtra("app", PendingIntent.getBroadcast(this.context, i3, intent2, i));
            intent.setPackage("com.google.android.gms");
            remoteMessage.populateSendMessageIntent(intent);
            this.context.sendOrderedBroadcast(intent, "com.google.android.gtalkservice.permission.GTALK_SERVICE");
        }
        IllegalArgumentException obj7 = new IllegalArgumentException("Missing 'to'");
        throw obj7;
    }

    public void setAutoInitEnabled(boolean z) {
        this.autoInit.setEnabled(z);
    }

    public void setDeliveryMetricsExportToBigQuery(boolean z) {
        MessagingAnalytics.setDeliveryMetricsExportToBigQuery(z);
    }

    public j<Void> setNotificationDelegationEnabled(boolean z) {
        return ProxyNotificationInitializer.setEnableProxyNotification(this.fileIoExecutor, this.context, z);
    }

    void setSyncScheduledOrRunning(boolean z) {
        this.syncScheduledOrRunning = z;
        return;
        synchronized (this) {
            this.syncScheduledOrRunning = z;
        }
    }

    public j<Void> subscribeToTopic(String string) {
        FirebaseMessaging$$ExternalSyntheticLambda2 externalSyntheticLambda2 = new FirebaseMessaging$$ExternalSyntheticLambda2(string);
        return this.topicsSubscriberTask.onSuccessTask(externalSyntheticLambda2);
    }

    void syncWithDelaySecondsInternal(long l) {
        SyncTask syncTask = new SyncTask(this, Math.min(Math.max(30, obj1), obj1), obj1);
        enqueueTaskWithDelaySeconds(syncTask, l);
        this.syncScheduledOrRunning = true;
        return;
        synchronized (this) {
            syncTask = new SyncTask(this, Math.min(Math.max(30, obj1), obj1), obj1);
            enqueueTaskWithDelaySeconds(syncTask, l);
            this.syncScheduledOrRunning = true;
        }
    }

    boolean tokenNeedsRefresh(com.google.firebase.messaging.Store.Token store$Token) {
        String appVersionCode;
        boolean obj2;
        if (token != null && token.needsRefresh(this.metadata.getAppVersionCode())) {
            if (token.needsRefresh(this.metadata.getAppVersionCode())) {
            }
            return 0;
        }
        return 1;
    }

    public j<Void> unsubscribeFromTopic(String string) {
        FirebaseMessaging$$ExternalSyntheticLambda3 externalSyntheticLambda3 = new FirebaseMessaging$$ExternalSyntheticLambda3(string);
        return this.topicsSubscriberTask.onSuccessTask(externalSyntheticLambda3);
    }
}
