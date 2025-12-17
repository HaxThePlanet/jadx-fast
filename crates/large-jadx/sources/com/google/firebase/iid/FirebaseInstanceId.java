package com.google.firebase.iid;

import android.os.Build.VERSION;
import android.os.Looper;
import android.util.Log;
import androidx.annotation.Keep;
import com.google.android.gms.common.internal.r;
import com.google.android.gms.common.util.q.a;
import com.google.android.gms.tasks.j;
import com.google.android.gms.tasks.m;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.heartbeatinfo.HeartBeatInfo;
import com.google.firebase.iid.internal.FirebaseInstanceIdInternal.NewTokenListener;
import com.google.firebase.inject.Provider;
import com.google.firebase.installations.FirebaseInstallationsApi;
import com.google.firebase.platforminfo.UserAgentPublisher;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CancellationException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: classes2.dex */
@Deprecated
public class FirebaseInstanceId {

    private static final Pattern API_KEY_FORMAT;
    private static final long MAX_DELAY_SEC;
    private static com.google.firebase.iid.Store store;
    static ScheduledExecutorService syncExecutor;
    private final FirebaseApp app;
    final Executor fileIoExecutor;
    private final FirebaseInstallationsApi firebaseInstallations;
    private final com.google.firebase.iid.Metadata metadata;
    private final List<FirebaseInstanceIdInternal.NewTokenListener> newTokenListeners;
    private final com.google.firebase.iid.RequestDeduplicator requestDeduplicator;
    private final com.google.firebase.iid.GmsRpc rpc;
    private boolean syncScheduledOrRunning;
    static {
        FirebaseInstanceId.MAX_DELAY_SEC = TimeUnit.HOURS.toSeconds(8);
        FirebaseInstanceId.API_KEY_FORMAT = Pattern.compile("\\AA[\\w-]{38}\\z");
    }

    FirebaseInstanceId(FirebaseApp firebaseApp, com.google.firebase.iid.Metadata metadata2, Executor executor3, Executor executor4, Provider<UserAgentPublisher> provider5, Provider<HeartBeatInfo> provider6, FirebaseInstallationsApi firebaseInstallationsApi7) {
        com.google.firebase.iid.Store store;
        android.content.Context applicationContext;
        super();
        this.syncScheduledOrRunning = false;
        ArrayList arrayList = new ArrayList();
        this.newTokenListeners = arrayList;
        if (Metadata.getDefaultSenderId(firebaseApp) == null) {
        } else {
            Class<com.google.firebase.iid.FirebaseInstanceId> obj = FirebaseInstanceId.class;
            synchronized (obj) {
                store = new Store(firebaseApp.getApplicationContext());
                FirebaseInstanceId.store = store;
                this.app = firebaseApp;
                this.metadata = metadata2;
                super(firebaseApp, metadata2, provider5, provider6, firebaseInstallationsApi7);
                this.rpc = gmsRpc;
                this.fileIoExecutor = executor4;
                RequestDeduplicator obj8 = new RequestDeduplicator(executor3);
                this.requestDeduplicator = obj8;
                this.firebaseInstallations = firebaseInstallationsApi7;
            }
        }
        obj8 = new IllegalStateException("FirebaseInstanceId failed to initialize, FirebaseApp is missing project ID");
        throw obj8;
    }

    FirebaseInstanceId(FirebaseApp firebaseApp, Provider<UserAgentPublisher> provider2, Provider<HeartBeatInfo> provider3, FirebaseInstallationsApi firebaseInstallationsApi4) {
        Metadata metadata = new Metadata(firebaseApp.getApplicationContext());
        super(firebaseApp, metadata, FirebaseIidExecutors.newCachedSingleThreadExecutor(), FirebaseIidExecutors.newCachedSingleThreadExecutor(), provider2, provider3, firebaseInstallationsApi4);
    }

    private <T> T awaitTask(j<T> j) {
        boolean z;
        try {
            return m.b(j, 30000, obj2);
            String iOException = "SERVICE_NOT_AVAILABLE";
            j = new IOException(iOException);
            throw j;
            iOException = j.getCause();
            z = iOException instanceof IOException;
            if (z) {
            }
            j = iOException.getMessage();
            z = "INSTANCE_ID_RESET";
            j = z.equals(j);
            if (j == null) {
            } else {
            }
            resetStorage();
            throw (IOException)iOException;
            z = iOException instanceof RuntimeException;
            if (z) {
            }
            throw (RuntimeException)iOException;
        }
        iOException = new IOException(j);
        throw iOException;
    }

    private static <T> T awaitTaskAllowOnMainThread(j<T> j) {
        r.k(j, "Task must not be null");
        CountDownLatch countDownLatch = new CountDownLatch(1);
        FirebaseInstanceId$$Lambda.2 anon = new FirebaseInstanceId$$Lambda.2(countDownLatch);
        j.addOnCompleteListener(FirebaseInstanceId$$Lambda.1.$instance, anon);
        countDownLatch.await(30000, obj3);
        return FirebaseInstanceId.getResultOrThrowException(j);
    }

    private static void checkRequiredFirebaseOptions(FirebaseApp firebaseApp) {
        r.g(firebaseApp.getOptions().getProjectId(), "Please set your project ID. A valid Firebase project ID is required to communicate with Firebase server APIs: It identifies your project with Google.");
        r.g(firebaseApp.getOptions().getApplicationId(), "Please set your Application ID. A valid Firebase App ID is required to communicate with Firebase server APIs: It identifies your application with Firebase.");
        r.g(firebaseApp.getOptions().getApiKey(), "Please set a valid API key. A Firebase API key is required to communicate with Firebase server APIs: It authenticates your project with Google.");
        r.b(FirebaseInstanceId.isValidAppIdFormat(firebaseApp.getOptions().getApplicationId()), "Please set your Application ID. A valid Firebase App ID is required to communicate with Firebase server APIs: It identifies your application with Firebase.Please refer to https://firebase.google.com/support/privacy/init-options.");
        r.b(FirebaseInstanceId.isValidApiKeyFormat(firebaseApp.getOptions().getApiKey()), "Please set a valid API key. A Firebase API key is required to communicate with Firebase server APIs: It authenticates your project with Google.Please refer to https://firebase.google.com/support/privacy/init-options.");
    }

    public static void clearInstancesForTest() {
        final Class<com.google.firebase.iid.FirebaseInstanceId> obj = FirebaseInstanceId.class;
        ScheduledExecutorService syncExecutor = FirebaseInstanceId.syncExecutor;
        synchronized (obj) {
            syncExecutor.shutdownNow();
            int i = 0;
            FirebaseInstanceId.syncExecutor = i;
            FirebaseInstanceId.store = i;
        }
    }

    public static com.google.firebase.iid.FirebaseInstanceId getInstance() {
        return FirebaseInstanceId.getInstance(FirebaseApp.getInstance());
    }

    public static com.google.firebase.iid.FirebaseInstanceId getInstance(FirebaseApp firebaseApp) {
        FirebaseInstanceId.checkRequiredFirebaseOptions(firebaseApp);
        final Object obj1 = firebaseApp.get(FirebaseInstanceId.class);
        r.k((FirebaseInstanceId)obj1, "Firebase Instance ID component is not present");
        return obj1;
    }

    private j<com.google.firebase.iid.InstanceIdResult> getInstanceId(String string, String string2) {
        FirebaseInstanceId$$Lambda.0 anon = new FirebaseInstanceId$$Lambda.0(this, string, FirebaseInstanceId.rationaliseScope(string2));
        return m.e(0).continueWithTask(this.fileIoExecutor, anon);
    }

    private static <T> T getResultOrThrowException(j<T> j) {
        if (j.isSuccessful()) {
            return j.getResult();
        }
        if (j.isCanceled()) {
        } else {
            if (j.isComplete()) {
                IllegalStateException illegalStateException = new IllegalStateException(j.getException());
                throw illegalStateException;
            }
            IllegalThreadStateException obj1 = new IllegalThreadStateException("Firebase Installations getId Task has timed out.");
            throw obj1;
        }
        obj1 = new CancellationException("Task is already canceled");
        throw obj1;
    }

    private String getSubtype() {
        String persistenceKey;
        if ("[DEFAULT]".equals(this.app.getName())) {
            persistenceKey = "";
        } else {
            persistenceKey = this.app.getPersistenceKey();
        }
        return persistenceKey;
    }

    static boolean isDebugLogEnabled() {
        String loggable;
        boolean sDK_INT;
        int i2;
        int i;
        loggable = "FirebaseInstanceId";
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

    static boolean isValidApiKeyFormat(String string) {
        return FirebaseInstanceId.API_KEY_FORMAT.matcher(string).matches();
    }

    static boolean isValidAppIdFormat(String string) {
        return string.contains(":");
    }

    static final void lambda$awaitTaskAllowOnMainThread$4$FirebaseInstanceId(CountDownLatch countDownLatch, j j2) {
        countDownLatch.countDown();
    }

    private static String rationaliseScope(String string) {
        boolean equalsIgnoreCase;
        if (!string.isEmpty() && !string.equalsIgnoreCase("fcm") && string.equalsIgnoreCase("gcm")) {
            if (!string.equalsIgnoreCase("fcm")) {
                if (string.equalsIgnoreCase("gcm")) {
                }
                return string;
            }
        }
        return "*";
    }

    private void startSyncIfNecessary() {
        if (tokenNeedsRefresh(getTokenWithoutTriggeringSync())) {
            startSync();
        }
    }

    void addNewTokenListener(FirebaseInstanceIdInternal.NewTokenListener firebaseInstanceIdInternal$NewTokenListener) {
        this.newTokenListeners.add(newTokenListener);
    }

    String blockingGetMasterToken() {
        return getToken(Metadata.getDefaultSenderId(this.app), "*");
    }

    @Deprecated
    public void deleteInstanceId() {
        FirebaseInstanceId.checkRequiredFirebaseOptions(this.app);
        if (Looper.getMainLooper() == Looper.myLooper()) {
        } else {
            awaitTask(this.firebaseInstallations.delete());
            resetStorage();
        }
        IOException iOException = new IOException("MAIN_THREAD");
        throw iOException;
    }

    @Deprecated
    public void deleteToken(String string, String string2) {
        FirebaseInstanceId.checkRequiredFirebaseOptions(this.app);
        if (Looper.getMainLooper() == Looper.myLooper()) {
        } else {
            String obj4 = FirebaseInstanceId.rationaliseScope(string2);
            awaitTask(this.rpc.deleteToken(getIdWithoutTriggeringSync(), string, obj4));
            FirebaseInstanceId.store.deleteToken(getSubtype(), string, obj4);
        }
        IOException obj3 = new IOException("MAIN_THREAD");
        throw obj3;
    }

    void enqueueTaskWithDelaySeconds(Runnable runnable, long l2) {
        Object scheduledThreadPoolExecutor;
        a aVar;
        int i;
        final Class<com.google.firebase.iid.FirebaseInstanceId> obj = FirebaseInstanceId.class;
        synchronized (obj) {
            aVar = new a("FirebaseInstanceId");
            scheduledThreadPoolExecutor = new ScheduledThreadPoolExecutor(1, aVar);
            FirebaseInstanceId.syncExecutor = scheduledThreadPoolExecutor;
            FirebaseInstanceId.syncExecutor.schedule(runnable, l2, obj7);
        }
    }

    FirebaseApp getApp() {
        return this.app;
    }

    public long getCreationTime() {
        return FirebaseInstanceId.store.getCreationTime(this.app.getPersistenceKey());
    }

    @Deprecated
    public String getId() {
        FirebaseInstanceId.checkRequiredFirebaseOptions(this.app);
        startSyncIfNecessary();
        return getIdWithoutTriggeringSync();
    }

    String getIdWithoutTriggeringSync() {
        try {
            FirebaseInstanceId.store.setCreationTime(this.app.getPersistenceKey());
            return (String)FirebaseInstanceId.awaitTaskAllowOnMainThread(this.firebaseInstallations.getId());
            IllegalStateException illegalStateException = new IllegalStateException(th);
            throw illegalStateException;
        }
    }

    @Deprecated
    public j<com.google.firebase.iid.InstanceIdResult> getInstanceId() {
        FirebaseInstanceId.checkRequiredFirebaseOptions(this.app);
        return getInstanceId(Metadata.getDefaultSenderId(this.app), "*");
    }

    @Deprecated
    public String getToken() {
        FirebaseInstanceId.checkRequiredFirebaseOptions(this.app);
        com.google.firebase.iid.Store.Token tokenWithoutTriggeringSync = getTokenWithoutTriggeringSync();
        if (tokenNeedsRefresh(tokenWithoutTriggeringSync)) {
            startSync();
        }
        return Store.Token.getTokenOrNull(tokenWithoutTriggeringSync);
    }

    @Deprecated
    public String getToken(String string, String string2) {
        FirebaseInstanceId.checkRequiredFirebaseOptions(this.app);
        if (Looper.getMainLooper() == Looper.myLooper()) {
        } else {
            return (InstanceIdResult)awaitTask(getInstanceId(string, string2)).getToken();
        }
        IOException obj3 = new IOException("MAIN_THREAD");
        throw obj3;
    }

    com.google.firebase.iid.Store.Token getTokenWithoutTriggeringSync() {
        return getTokenWithoutTriggeringSync(Metadata.getDefaultSenderId(this.app), "*");
    }

    com.google.firebase.iid.Store.Token getTokenWithoutTriggeringSync(String string, String string2) {
        return FirebaseInstanceId.store.getToken(getSubtype(), string, string2);
    }

    public boolean isFcmAutoInitEnabled() {
        IllegalStateException illegalStateException = new IllegalStateException("FirebaseMessaging version not supported. Update to latest version.");
        throw illegalStateException;
    }

    public boolean isGmsCorePresent() {
        return this.metadata.isGmscorePresent();
    }

    final j lambda$getInstanceId$0$FirebaseInstanceId(String string, String string2, String string3, String string4) {
        FirebaseInstanceId.store.saveToken(getSubtype(), string, string2, string4, this.metadata.getAppVersionCode());
        InstanceIdResultImpl obj7 = new InstanceIdResultImpl(string3, string4);
        return m.e(obj7);
    }

    final void lambda$getInstanceId$1$FirebaseInstanceId(com.google.firebase.iid.Store.Token store$Token, com.google.firebase.iid.InstanceIdResult instanceIdResult2) {
        boolean next;
        boolean obj2;
        final String obj3 = instanceIdResult2.getToken();
        if (token != null) {
            if (!obj3.equals(token.token)) {
                obj2 = this.newTokenListeners.iterator();
                for (FirebaseInstanceIdInternal.NewTokenListener next : obj2) {
                    next.onNewToken(obj3);
                }
            }
        } else {
        }
    }

    final j lambda$getInstanceId$2$FirebaseInstanceId(String string, String string2, String string3, com.google.firebase.iid.Store.Token store$Token4) {
        FirebaseInstanceId$$Lambda.4 anon = new FirebaseInstanceId$$Lambda.4(this, string2, string3, string);
        FirebaseInstanceId$$Lambda.6 obj6 = new FirebaseInstanceId$$Lambda.6(this, token4);
        return this.rpc.getToken(string, string2, string3).onSuccessTask(this.fileIoExecutor, anon).addOnSuccessListener(FirebaseInstanceId$$Lambda.5.$instance, obj6);
    }

    final j lambda$getInstanceId$3$FirebaseInstanceId(String string, String string2, j j3) {
        final String idWithoutTriggeringSync = getIdWithoutTriggeringSync();
        final com.google.firebase.iid.Store.Token tokenWithoutTriggeringSync = getTokenWithoutTriggeringSync(string, string2);
        if (!tokenNeedsRefresh(tokenWithoutTriggeringSync)) {
            InstanceIdResultImpl obj8 = new InstanceIdResultImpl(idWithoutTriggeringSync, tokenWithoutTriggeringSync.token);
            return m.e(obj8);
        }
        super(this, idWithoutTriggeringSync, string, string2, tokenWithoutTriggeringSync);
        return this.requestDeduplicator.getOrStartGetTokenRequest(string, string2, anon2);
    }

    void resetStorage() {
        FirebaseInstanceId.store.deleteAll();
        return;
        synchronized (this) {
            FirebaseInstanceId.store.deleteAll();
        }
    }

    public void setFcmAutoInitEnabled(boolean z) {
        IllegalStateException obj2 = new IllegalStateException("FirebaseMessaging version not supported. Update to latest version.");
        throw obj2;
    }

    void setSyncScheduledOrRunning(boolean z) {
        this.syncScheduledOrRunning = z;
        return;
        synchronized (this) {
            this.syncScheduledOrRunning = z;
        }
    }

    void startSync() {
        synchronized (this) {
            try {
                syncWithDelaySecondsInternal(0);
                throw th;
            }
        }
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

    boolean tokenNeedsRefresh(com.google.firebase.iid.Store.Token store$Token) {
        String appVersionCode;
        boolean obj2;
        if (token != null && token.needsRefresh(this.metadata.getAppVersionCode())) {
            if (token.needsRefresh(this.metadata.getAppVersionCode())) {
            }
            return 0;
        }
        return 1;
    }
}
