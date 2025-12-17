package com.google.firebase.perf.config;

import android.content.Context;
import android.content.pm.PackageManager;
import androidx.annotation.Keep;
import com.google.android.gms.tasks.j;
import com.google.firebase.inject.Provider;
import com.google.firebase.perf.logging.AndroidLogger;
import com.google.firebase.perf.provider.FirebasePerfProvider;
import com.google.firebase.perf.util.Optional;
import com.google.firebase.perf.util.Timer;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.google.firebase.remoteconfig.FirebaseRemoteConfigInfo;
import com.google.firebase.remoteconfig.FirebaseRemoteConfigValue;
import com.google.firebase.remoteconfig.RemoteConfigComponent;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: classes2.dex */
public class RemoteConfigManager {

    private static final long FETCH_NEVER_HAPPENED_TIMESTAMP_MS = 0L;
    private static final String FIREPERF_FRC_NAMESPACE_NAME = "fireperf";
    private static final long MIN_APP_START_CONFIG_FETCH_DELAY_MS = 5000L;
    private static final int RANDOM_APP_START_CONFIG_FETCH_DELAY_MS = 25000;
    private static final long TIME_AFTER_WHICH_A_FETCH_IS_CONSIDERED_STALE_MS;
    private static final com.google.firebase.perf.config.RemoteConfigManager instance;
    private static final AndroidLogger logger;
    private final ConcurrentHashMap<String, FirebaseRemoteConfigValue> allRcConfigMap;
    private final long appStartConfigFetchDelayInMs;
    private final long appStartTimeInMs;
    private final Executor executor;
    private FirebaseRemoteConfig firebaseRemoteConfig;
    private long firebaseRemoteConfigLastFetchTimestampMs;
    private Provider<RemoteConfigComponent> firebaseRemoteConfigProvider;
    static {
        RemoteConfigManager.logger = AndroidLogger.getInstance();
        RemoteConfigManager remoteConfigManager = new RemoteConfigManager();
        RemoteConfigManager.instance = remoteConfigManager;
        RemoteConfigManager.TIME_AFTER_WHICH_A_FETCH_IS_CONSIDERED_STALE_MS = TimeUnit.HOURS.toMillis(12);
    }

    private RemoteConfigManager() {
        LinkedBlockingQueue linkedBlockingQueue = new LinkedBlockingQueue();
        super(0, 1, 0, obj4, TimeUnit.SECONDS, linkedBlockingQueue);
        super(threadPoolExecutor2, 0);
    }

    RemoteConfigManager(Executor executor, FirebaseRemoteConfig firebaseRemoteConfig2) {
        Random random = new Random();
        final int i2 = 25000;
        super(executor, firebaseRemoteConfig2, l += i3, i2);
    }

    RemoteConfigManager(Executor executor, FirebaseRemoteConfig firebaseRemoteConfig2, long l3) {
        ConcurrentHashMap obj3;
        Object obj4;
        super();
        this.firebaseRemoteConfigLastFetchTimestampMs = 0;
        this.executor = executor;
        this.firebaseRemoteConfig = firebaseRemoteConfig2;
        if (firebaseRemoteConfig2 == null) {
            obj3 = new ConcurrentHashMap();
        } else {
            obj3 = new ConcurrentHashMap(firebaseRemoteConfig2.getAll());
        }
        this.allRcConfigMap = obj3;
        this.appStartTimeInMs = TimeUnit.MICROSECONDS.toMillis(FirebasePerfProvider.getAppStartTime().getMicros());
        this.appStartConfigFetchDelayInMs = l3;
    }

    private void a(Boolean boolean) {
        syncConfigValues(this.firebaseRemoteConfig.getAll());
    }

    private void c(Exception exception) {
        this.firebaseRemoteConfigLastFetchTimestampMs = 0;
    }

    public static com.google.firebase.perf.config.RemoteConfigManager getInstance() {
        return RemoteConfigManager.instance;
    }

    private FirebaseRemoteConfigValue getRemoteConfigValue(String string) {
        boolean firebaseRemoteConfigAvailable;
        int source;
        int i;
        triggerRemoteConfigFetchIfNecessary();
        firebaseRemoteConfigAvailable = this.allRcConfigMap.get(string);
        i = 2;
        if (isFirebaseRemoteConfigAvailable() && this.allRcConfigMap.containsKey(string) && (FirebaseRemoteConfigValue)firebaseRemoteConfigAvailable.getSource() == i) {
            if (this.allRcConfigMap.containsKey(string)) {
                firebaseRemoteConfigAvailable = this.allRcConfigMap.get(string);
                i = 2;
                if ((FirebaseRemoteConfigValue)firebaseRemoteConfigAvailable.getSource() == i) {
                    Object[] arr = new Object[i];
                    arr[0] = firebaseRemoteConfigAvailable.asString();
                    arr[1] = string;
                    RemoteConfigManager.logger.debug("Fetched value: '%s' for key: '%s' from Firebase Remote Config.", arr);
                    return firebaseRemoteConfigAvailable;
                }
            }
        }
        return null;
    }

    public static int getVersionCode(Context context) {
        return obj2.versionCode;
    }

    private boolean hasAppStartConfigFetchDelayElapsed(long l) {
        int obj3;
        obj3 = Long.compare(obj3, appStartConfigFetchDelayInMs) >= 0 ? 1 : 0;
        return obj3;
    }

    private boolean hasLastFetchBecomeStale(long l) {
        int obj3;
        obj3 = Long.compare(obj3, tIME_AFTER_WHICH_A_FETCH_IS_CONSIDERED_STALE_MS) > 0 ? 1 : 0;
        return obj3;
    }

    private boolean shouldFetchAndActivateRemoteConfigValues() {
        long currentSystemTimeMillis;
        int i;
        currentSystemTimeMillis = getCurrentSystemTimeMillis();
        if (hasAppStartConfigFetchDelayElapsed(currentSystemTimeMillis) && hasLastFetchBecomeStale(currentSystemTimeMillis)) {
            i = hasLastFetchBecomeStale(currentSystemTimeMillis) ? 1 : 0;
        } else {
        }
        return i;
    }

    private void triggerFirebaseRemoteConfigFetchAndActivateOnSuccessfulFetch() {
        this.firebaseRemoteConfigLastFetchTimestampMs = getCurrentSystemTimeMillis();
        b bVar = new b(this);
        c cVar = new c(this);
        this.firebaseRemoteConfig.fetchAndActivate().addOnSuccessListener(this.executor, bVar).addOnFailureListener(this.executor, cVar);
    }

    private void triggerRemoteConfigFetchIfNecessary() {
        boolean empty;
        if (!isFirebaseRemoteConfigAvailable()) {
        }
        if (this.allRcConfigMap.isEmpty()) {
            syncConfigValues(this.firebaseRemoteConfig.getAll());
        }
        if (shouldFetchAndActivateRemoteConfigValues()) {
            triggerFirebaseRemoteConfigFetchAndActivateOnSuccessfulFetch();
        }
    }

    public void b(Boolean boolean) {
        a(boolean);
    }

    public void d(Exception exception) {
        c(exception);
    }

    public Optional<Boolean> getBoolean(String string) {
        FirebaseRemoteConfigValue remoteConfigValue;
        String logger;
        int arr;
        int i;
        String obj5;
        if (string == null) {
            RemoteConfigManager.logger.debug("The key to get Remote Config boolean value is null.");
            return Optional.absent();
        }
        remoteConfigValue = getRemoteConfigValue(string);
        if (remoteConfigValue != null) {
            return Optional.of(Boolean.valueOf(remoteConfigValue.asBoolean()));
        }
        return Optional.absent();
    }

    protected long getCurrentSystemTimeMillis() {
        return System.currentTimeMillis();
    }

    public Optional<Float> getFloat(String string) {
        FirebaseRemoteConfigValue remoteConfigValue;
        String logger;
        double arr;
        int i;
        String obj5;
        if (string == null) {
            RemoteConfigManager.logger.debug("The key to get Remote Config float value is null.");
            return Optional.absent();
        }
        remoteConfigValue = getRemoteConfigValue(string);
        if (remoteConfigValue != null) {
            return Optional.of(Float.valueOf(Double.valueOf(remoteConfigValue.asDouble()).floatValue()));
        }
        return Optional.absent();
    }

    public Optional<Long> getLong(String string) {
        FirebaseRemoteConfigValue remoteConfigValue;
        String logger;
        long arr;
        int i;
        String obj5;
        if (string == null) {
            RemoteConfigManager.logger.debug("The key to get Remote Config long value is null.");
            return Optional.absent();
        }
        remoteConfigValue = getRemoteConfigValue(string);
        if (remoteConfigValue != null) {
            return Optional.of(Long.valueOf(remoteConfigValue.asLong()));
        }
        return Optional.absent();
    }

    public <T> T getRemoteConfigValueOrDefault(String string, T t2) {
        FirebaseRemoteConfigValue remoteConfigValue;
        int i2;
        int i;
        boolean floatValue;
        boolean z;
        double logger;
        String str;
        Object[] arr;
        Boolean obj8;
        Object obj9;
        remoteConfigValue = getRemoteConfigValue(string);
        if (remoteConfigValue != null) {
            if (t2 instanceof Boolean) {
                obj8 = Boolean.valueOf(remoteConfigValue.asBoolean());
                obj9 = obj8;
            } else {
            }
        }
        return obj9;
    }

    public Optional<String> getString(String string) {
        if (string == null) {
            RemoteConfigManager.logger.debug("The key to get Remote Config String value is null.");
            return Optional.absent();
        }
        FirebaseRemoteConfigValue obj2 = getRemoteConfigValue(string);
        if (obj2 != null) {
            return Optional.of(obj2.asString());
        }
        return Optional.absent();
    }

    public boolean isFirebaseRemoteConfigAvailable() {
        Object firebaseRemoteConfig;
        int i;
        String str;
        firebaseRemoteConfig = this.firebaseRemoteConfigProvider;
        firebaseRemoteConfig = firebaseRemoteConfig.get();
        if (this.firebaseRemoteConfig == null && firebaseRemoteConfig != null && (RemoteConfigComponent)firebaseRemoteConfig != null) {
            firebaseRemoteConfig = this.firebaseRemoteConfigProvider;
            if (firebaseRemoteConfig != null) {
                firebaseRemoteConfig = firebaseRemoteConfig.get();
                if ((RemoteConfigComponent)(RemoteConfigComponent)firebaseRemoteConfig != null) {
                    this.firebaseRemoteConfig = (RemoteConfigComponent)(RemoteConfigComponent)firebaseRemoteConfig.get("fireperf");
                }
            }
        }
        i = this.firebaseRemoteConfig != null ? 1 : 0;
        return i;
    }

    public boolean isLastFetchFailed() {
        FirebaseRemoteConfig firebaseRemoteConfig;
        int i;
        firebaseRemoteConfig = this.firebaseRemoteConfig;
        if (firebaseRemoteConfig != null) {
            if (firebaseRemoteConfig.getInfo().getLastFetchStatus() == 1) {
            } else {
                i = 0;
            }
        }
        return i;
    }

    public void setFirebaseRemoteConfigProvider(Provider<RemoteConfigComponent> provider) {
        this.firebaseRemoteConfigProvider = provider;
    }

    protected void syncConfigValues(Map<String, FirebaseRemoteConfigValue> map) {
        Object next;
        boolean allRcConfigMap;
        this.allRcConfigMap.putAll(map);
        Iterator iterator = this.allRcConfigMap.keySet().iterator();
        while (iterator.hasNext()) {
            next = iterator.next();
            if (!map.containsKey((String)next)) {
            }
            this.allRcConfigMap.remove(next);
        }
    }
}
