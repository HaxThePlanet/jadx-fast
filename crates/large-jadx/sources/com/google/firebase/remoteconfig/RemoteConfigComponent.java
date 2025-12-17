package com.google.firebase.remoteconfig;

import android.content.Context;
import com.google.android.gms.common.util.e;
import com.google.android.gms.common.util.h;
import com.google.android.gms.tasks.m;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.abt.FirebaseABTesting;
import com.google.firebase.analytics.connector.AnalyticsConnector;
import com.google.firebase.inject.Provider;
import com.google.firebase.installations.FirebaseInstallationsApi;
import com.google.firebase.remoteconfig.internal.ConfigCacheClient;
import com.google.firebase.remoteconfig.internal.ConfigFetchHandler;
import com.google.firebase.remoteconfig.internal.ConfigFetchHttpClient;
import com.google.firebase.remoteconfig.internal.ConfigGetParameterHandler;
import com.google.firebase.remoteconfig.internal.ConfigMetadataClient;
import com.google.firebase.remoteconfig.internal.ConfigStorageClient;
import com.google.firebase.remoteconfig.internal.Personalization;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Random;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* loaded from: classes2.dex */
public class RemoteConfigComponent {

    public static final String ACTIVATE_FILE_NAME = "activate";
    public static final long CONNECTION_TIMEOUT_IN_SECONDS = 60L;
    public static final String DEFAULTS_FILE_NAME = "defaults";
    private static final e DEFAULT_CLOCK = null;
    public static final String DEFAULT_NAMESPACE = "firebase";
    private static final Random DEFAULT_RANDOM = null;
    public static final String FETCH_FILE_NAME = "fetch";
    private static final String FIREBASE_REMOTE_CONFIG_FILE_NAME_PREFIX = "frc";
    private static final String PREFERENCES_FILE_NAME = "settings";
    private final Provider<AnalyticsConnector> analyticsConnector;
    private final String appId;
    private final Context context;
    private Map<String, String> customHeaders;
    private final ExecutorService executorService;
    private final FirebaseABTesting firebaseAbt;
    private final FirebaseApp firebaseApp;
    private final FirebaseInstallationsApi firebaseInstallations;
    private final Map<String, com.google.firebase.remoteconfig.FirebaseRemoteConfig> frcNamespaceInstances;
    static {
        RemoteConfigComponent.DEFAULT_CLOCK = h.b();
        Random random = new Random();
        RemoteConfigComponent.DEFAULT_RANDOM = random;
    }

    RemoteConfigComponent(Context context, FirebaseApp firebaseApp2, FirebaseInstallationsApi firebaseInstallationsApi3, FirebaseABTesting firebaseABTesting4, Provider<AnalyticsConnector> provider5) {
        super(context, Executors.newCachedThreadPool(), firebaseApp2, firebaseInstallationsApi3, firebaseABTesting4, provider5, 1);
    }

    protected RemoteConfigComponent(Context context, ExecutorService executorService2, FirebaseApp firebaseApp3, FirebaseInstallationsApi firebaseInstallationsApi4, FirebaseABTesting firebaseABTesting5, Provider<AnalyticsConnector> provider6, boolean z7) {
        Object obj2;
        super();
        HashMap hashMap = new HashMap();
        this.frcNamespaceInstances = hashMap;
        HashMap hashMap2 = new HashMap();
        this.customHeaders = hashMap2;
        this.context = context;
        this.executorService = executorService2;
        this.firebaseApp = firebaseApp3;
        this.firebaseInstallations = firebaseInstallationsApi4;
        this.firebaseAbt = firebaseABTesting5;
        this.analyticsConnector = provider6;
        this.appId = firebaseApp3.getOptions().getApplicationId();
        if (z7) {
            obj2 = new j(this);
            m.c(executorService2, obj2);
        }
    }

    static AnalyticsConnector a() {
        return null;
    }

    private ConfigCacheClient getCacheClient(String string, String string2) {
        Object[] arr = new Object[4];
        return ConfigCacheClient.getInstance(Executors.newCachedThreadPool(), ConfigStorageClient.getInstance(this.context, String.format("%s_%s_%s_%s.json", "frc", this.appId, string, string2)));
    }

    private ConfigGetParameterHandler getGetHandler(ConfigCacheClient configCacheClient, ConfigCacheClient configCacheClient2) {
        ConfigGetParameterHandler configGetParameterHandler = new ConfigGetParameterHandler(this.executorService, configCacheClient, configCacheClient2);
        return configGetParameterHandler;
    }

    static ConfigMetadataClient getMetadataClient(Context context, String string2, String string3) {
        Object[] arr = new Object[4];
        final int i3 = 0;
        arr[i3] = "frc";
        arr[1] = string2;
        arr[2] = string3;
        arr[3] = "settings";
        ConfigMetadataClient obj4 = new ConfigMetadataClient(context.getSharedPreferences(String.format("%s_%s_%s_%s", arr), i3));
        return obj4;
    }

    private static Personalization getPersonalization(FirebaseApp firebaseApp, String string2, Provider<AnalyticsConnector> provider3) {
        boolean obj0;
        if (RemoteConfigComponent.isPrimaryApp(firebaseApp) && string2.equals("firebase")) {
            if (string2.equals("firebase")) {
                obj0 = new Personalization(provider3);
                return obj0;
            }
        }
        return null;
    }

    private static boolean isAbtSupported(FirebaseApp firebaseApp, String string2) {
        FirebaseApp obj1;
        if (string2.equals("firebase") && RemoteConfigComponent.isPrimaryApp(firebaseApp)) {
            obj1 = RemoteConfigComponent.isPrimaryApp(firebaseApp) ? 1 : 0;
        } else {
        }
        return obj1;
    }

    private static boolean isPrimaryApp(FirebaseApp firebaseApp) {
        return firebaseApp.getName().equals("[DEFAULT]");
    }

    com.google.firebase.remoteconfig.FirebaseRemoteConfig get(FirebaseApp firebaseApp, String string2, FirebaseInstallationsApi firebaseInstallationsApi3, FirebaseABTesting firebaseABTesting4, Executor executor5, ConfigCacheClient configCacheClient6, ConfigCacheClient configCacheClient7, ConfigCacheClient configCacheClient8, ConfigFetchHandler configFetchHandler9, ConfigGetParameterHandler configGetParameterHandler10, ConfigMetadataClient configMetadataClient11) {
        boolean firebaseRemoteConfig;
        int abtSupported;
        Map frcNamespaceInstances;
        Context context;
        FirebaseApp firebaseApp2;
        FirebaseInstallationsApi firebaseInstallationsApi;
        int i;
        Executor executor;
        ConfigCacheClient client3;
        ConfigCacheClient client2;
        ConfigCacheClient client;
        ConfigFetchHandler handler2;
        ConfigGetParameterHandler handler;
        ConfigMetadataClient client4;
        final Object obj3 = this;
        Object obj = string2;
        synchronized (this) {
            i = RemoteConfigComponent.isAbtSupported(firebaseApp, string2) ? firebaseABTesting4 : abtSupported;
            try {
                super(obj3.context, firebaseApp, firebaseInstallationsApi3, i, executor5, configCacheClient6, configCacheClient7, configCacheClient8, configFetchHandler9, configGetParameterHandler10, configMetadataClient11);
                firebaseRemoteConfig.startLoadingConfigsFromDisk();
                obj3.frcNamespaceInstances.put(obj, firebaseRemoteConfig);
                return (FirebaseRemoteConfig)obj3.frcNamespaceInstances.get(obj);
                throw th;
            }
        }
    }

    public com.google.firebase.remoteconfig.FirebaseRemoteConfig get(String string) {
        Object analyticsConnector;
        final ConfigCacheClient cacheClient = getCacheClient(string, "fetch");
        final ConfigCacheClient cacheClient2 = getCacheClient(string, "activate");
        final ConfigCacheClient cacheClient3 = getCacheClient(string, "defaults");
        final ConfigMetadataClient metadataClient = RemoteConfigComponent.getMetadataClient(this.context, this.appId, string);
        final ConfigGetParameterHandler getHandler = getGetHandler(cacheClient2, cacheClient3);
        Personalization personalization = RemoteConfigComponent.getPersonalization(this.firebaseApp, string, this.analyticsConnector);
        synchronized (this) {
            try {
                Objects.requireNonNull(personalization);
                analyticsConnector = new m(personalization);
                getHandler.addListener(analyticsConnector);
                return this.get(this.firebaseApp, string, this.firebaseInstallations, this.firebaseAbt, this.executorService, cacheClient, cacheClient2, cacheClient3, getFetchHandler(string, cacheClient, metadataClient), getHandler, metadataClient);
                throw string;
            }
        }
    }

    com.google.firebase.remoteconfig.FirebaseRemoteConfig getDefault() {
        return get("firebase");
    }

    ConfigFetchHandler getFetchHandler(String string, ConfigCacheClient configCacheClient2, ConfigMetadataClient configMetadataClient3) {
        Provider analyticsConnector;
        synchronized (this) {
            try {
                analyticsConnector = this.analyticsConnector;
                analyticsConnector = k.a;
                super(this.firebaseInstallations, analyticsConnector, this.executorService, RemoteConfigComponent.DEFAULT_CLOCK, RemoteConfigComponent.DEFAULT_RANDOM, configCacheClient2, getFrcBackendApiClient(this.firebaseApp.getOptions().getApiKey(), string, configMetadataClient3), configMetadataClient3, this.customHeaders);
                return configFetchHandler;
                throw string;
            }
        }
    }

    ConfigFetchHttpClient getFrcBackendApiClient(String string, String string2, ConfigMetadataClient configMetadataClient3) {
        super(this.context, this.firebaseApp.getOptions().getApplicationId(), string, string2, configMetadataClient3.getFetchTimeoutInSeconds(), obj7, configMetadataClient3.getFetchTimeoutInSeconds(), obj9);
        return configFetchHttpClient;
    }

    public void setCustomHeaders(Map<String, String> map) {
        this.customHeaders = map;
        return;
        synchronized (this) {
            this.customHeaders = map;
        }
    }
}
