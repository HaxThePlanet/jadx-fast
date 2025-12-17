package com.google.firebase.remoteconfig;

import android.content.Context;
import android.util.Log;
import com.google.android.gms.tasks.j;
import com.google.android.gms.tasks.m;
import com.google.firebase.FirebaseApp;
import com.google.firebase.abt.FirebaseABTesting;
import com.google.firebase.installations.FirebaseInstallationsApi;
import com.google.firebase.remoteconfig.internal.ConfigCacheClient;
import com.google.firebase.remoteconfig.internal.ConfigContainer;
import com.google.firebase.remoteconfig.internal.ConfigContainer.Builder;
import com.google.firebase.remoteconfig.internal.ConfigFetchHandler;
import com.google.firebase.remoteconfig.internal.ConfigFetchHandler.FetchResponse;
import com.google.firebase.remoteconfig.internal.ConfigGetParameterHandler;
import com.google.firebase.remoteconfig.internal.ConfigMetadataClient;
import com.google.firebase.remoteconfig.internal.DefaultsXmlParser;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.Executor;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class FirebaseRemoteConfig {

    public static final boolean DEFAULT_VALUE_FOR_BOOLEAN = false;
    public static final byte[] DEFAULT_VALUE_FOR_BYTE_ARRAY = null;
    public static final double DEFAULT_VALUE_FOR_DOUBLE = 0d;
    public static final long DEFAULT_VALUE_FOR_LONG = 0L;
    public static final String DEFAULT_VALUE_FOR_STRING = "";
    public static final int LAST_FETCH_STATUS_FAILURE = 1;
    public static final int LAST_FETCH_STATUS_NO_FETCH_YET = 0;
    public static final int LAST_FETCH_STATUS_SUCCESS = -1;
    public static final int LAST_FETCH_STATUS_THROTTLED = 2;
    public static final String TAG = "FirebaseRemoteConfig";
    public static final int VALUE_SOURCE_DEFAULT = 1;
    public static final int VALUE_SOURCE_REMOTE = 2;
    public static final int VALUE_SOURCE_STATIC;
    private final ConfigCacheClient activatedConfigsCache;
    private final Context context;
    private final ConfigCacheClient defaultConfigsCache;
    private final Executor executor;
    private final ConfigFetchHandler fetchHandler;
    private final ConfigCacheClient fetchedConfigsCache;
    private final FirebaseABTesting firebaseAbt;
    private final FirebaseApp firebaseApp;
    private final FirebaseInstallationsApi firebaseInstallations;
    private final ConfigMetadataClient frcMetadata;
    private final ConfigGetParameterHandler getHandler;
    static {
        FirebaseRemoteConfig.DEFAULT_VALUE_FOR_BYTE_ARRAY = new byte[0];
    }

    FirebaseRemoteConfig(Context context, FirebaseApp firebaseApp2, FirebaseInstallationsApi firebaseInstallationsApi3, FirebaseABTesting firebaseABTesting4, Executor executor5, ConfigCacheClient configCacheClient6, ConfigCacheClient configCacheClient7, ConfigCacheClient configCacheClient8, ConfigFetchHandler configFetchHandler9, ConfigGetParameterHandler configGetParameterHandler10, ConfigMetadataClient configMetadataClient11) {
        super();
        this.context = context;
        this.firebaseApp = firebaseApp2;
        this.firebaseInstallations = firebaseInstallationsApi3;
        this.firebaseAbt = firebaseABTesting4;
        this.executor = executor5;
        this.fetchedConfigsCache = configCacheClient6;
        this.activatedConfigsCache = configCacheClient7;
        this.defaultConfigsCache = configCacheClient8;
        this.fetchHandler = configFetchHandler9;
        this.getHandler = configGetParameterHandler10;
        this.frcMetadata = configMetadataClient11;
    }

    private j a(j j, j j2, j j3) {
        boolean obj2;
        boolean obj3;
        if (j.isSuccessful()) {
            if (j.getResult() == null) {
            } else {
                Object obj1 = j.getResult();
                if (j2.isSuccessful() && !FirebaseRemoteConfig.isFetchedFresh((ConfigContainer)obj1, (ConfigContainer)j2.getResult())) {
                    if (!FirebaseRemoteConfig.isFetchedFresh(obj1, (ConfigContainer)j2.getResult())) {
                        return m.e(Boolean.FALSE);
                    }
                }
            }
            obj3 = new i(this);
            return this.activatedConfigsCache.put(obj1).continueWith(this.executor, obj3);
        }
        return m.e(Boolean.FALSE);
    }

    static com.google.firebase.remoteconfig.FirebaseRemoteConfigInfo c(j j, j j2) {
        return (FirebaseRemoteConfigInfo)j.getResult();
    }

    static j d(ConfigFetchHandler.FetchResponse configFetchHandler$FetchResponse) {
        return m.e(0);
    }

    static j e(ConfigFetchHandler.FetchResponse configFetchHandler$FetchResponse) {
        return m.e(0);
    }

    private j f(Void void) {
        return activate();
    }

    public static com.google.firebase.remoteconfig.FirebaseRemoteConfig getInstance() {
        return FirebaseRemoteConfig.getInstance(FirebaseApp.getInstance());
    }

    public static com.google.firebase.remoteconfig.FirebaseRemoteConfig getInstance(FirebaseApp firebaseApp) {
        return (RemoteConfigComponent)firebaseApp.get(RemoteConfigComponent.class).getDefault();
    }

    public static boolean h(com.google.firebase.remoteconfig.FirebaseRemoteConfig firebaseRemoteConfig, j j2) {
        return firebaseRemoteConfig.processActivatePutTask(j2);
    }

    private Void i() {
        this.activatedConfigsCache.clear();
        this.fetchedConfigsCache.clear();
        this.defaultConfigsCache.clear();
        this.frcMetadata.clear();
        return null;
    }

    private static boolean isFetchedFresh(ConfigContainer configContainer, ConfigContainer configContainer2) {
        int obj0;
        Date obj1;
        if (configContainer2 != null) {
            if (!configContainer.getFetchTime().equals(configContainer2.getFetchTime())) {
                obj0 = 1;
            } else {
                obj0 = 0;
            }
        } else {
        }
        return obj0;
    }

    private Void k(com.google.firebase.remoteconfig.FirebaseRemoteConfigSettings firebaseRemoteConfigSettings) {
        this.frcMetadata.setConfigSettings(firebaseRemoteConfigSettings);
        return null;
    }

    static j m(ConfigContainer configContainer) {
        return m.e(0);
    }

    private boolean processActivatePutTask(j<ConfigContainer> j) {
        Object result;
        Object obj2;
        if (j.isSuccessful()) {
            this.fetchedConfigsCache.clear();
            if (j.getResult() != null) {
                updateAbtWithActivatedExperiments((ConfigContainer)j.getResult().getAbtExperiments());
            } else {
                Log.e("FirebaseRemoteConfig", "Activated configs written to disk are null.");
            }
            return 1;
        }
        return 0;
    }

    private j<Void> setDefaultsWithStringsMapAsync(Map<String, String> map) {
        try {
            return this.defaultConfigsCache.put(ConfigContainer.newBuilder().replaceConfigsWith(map).build()).onSuccessTask(e.a);
            Log.e("FirebaseRemoteConfig", "The provided defaults map could not be processed.", map);
            map = null;
            map = m.e(map);
            return map;
        }
    }

    static List<Map<String, String>> toExperimentInfoMaps(JSONArray jSONArray) {
        int i;
        HashMap hashMap;
        JSONObject jSONObject;
        Iterator keys;
        boolean next;
        String string;
        ArrayList arrayList = new ArrayList();
        i = 0;
        while (i < jSONArray.length()) {
            hashMap = new HashMap();
            jSONObject = jSONArray.getJSONObject(i);
            keys = jSONObject.keys();
            for (String next : keys) {
                hashMap.put(next, jSONObject.getString(next));
            }
            arrayList.add(hashMap);
            i++;
            next = keys.next();
            hashMap.put(next, jSONObject.getString((String)next));
        }
        return arrayList;
    }

    public j<Boolean> activate() {
        j jVar = this.fetchedConfigsCache.get();
        j jVar2 = this.activatedConfigsCache.get();
        j[] arr = new j[2];
        g gVar = new g(this, jVar, jVar2);
        return m.i(jVar, jVar2).continueWithTask(this.executor, gVar);
    }

    public j b(j j, j j2, j j3) {
        return a(j, j2, j3);
    }

    public j<com.google.firebase.remoteconfig.FirebaseRemoteConfigInfo> ensureInitialized() {
        n nVar = new n(this);
        j jVar5 = m.c(this.executor, nVar);
        final int i6 = 0;
        j[] arr = new j[6];
        arr[i6] = this.activatedConfigsCache.get();
        arr[1] = this.defaultConfigsCache.get();
        arr[2] = this.fetchedConfigsCache.get();
        arr[3] = jVar5;
        arr[4] = this.firebaseInstallations.getId();
        arr[5] = this.firebaseInstallations.getToken(i6);
        h hVar = new h(jVar5);
        return m.i(arr).continueWith(this.executor, hVar);
    }

    public j<Void> fetch() {
        return this.fetchHandler.fetch().onSuccessTask(c.a);
    }

    public j<Void> fetch(long l) {
        return this.fetchHandler.fetch(l).onSuccessTask(a.a);
    }

    public j<Boolean> fetchAndActivate() {
        f fVar = new f(this);
        return fetch().onSuccessTask(this.executor, fVar);
    }

    public j g(Void void) {
        return f(void);
    }

    public Map<String, com.google.firebase.remoteconfig.FirebaseRemoteConfigValue> getAll() {
        return this.getHandler.getAll();
    }

    public boolean getBoolean(String string) {
        return this.getHandler.getBoolean(string);
    }

    public double getDouble(String string) {
        return this.getHandler.getDouble(string);
    }

    public com.google.firebase.remoteconfig.FirebaseRemoteConfigInfo getInfo() {
        return this.frcMetadata.getInfo();
    }

    public Set<String> getKeysByPrefix(String string) {
        return this.getHandler.getKeysByPrefix(string);
    }

    public long getLong(String string) {
        return this.getHandler.getLong(string);
    }

    public String getString(String string) {
        return this.getHandler.getString(string);
    }

    public com.google.firebase.remoteconfig.FirebaseRemoteConfigValue getValue(String string) {
        return this.getHandler.getValue(string);
    }

    public Void j() {
        return i();
    }

    public Void l(com.google.firebase.remoteconfig.FirebaseRemoteConfigSettings firebaseRemoteConfigSettings) {
        return k(firebaseRemoteConfigSettings);
    }

    public j<Void> reset() {
        d dVar = new d(this);
        return m.c(this.executor, dVar);
    }

    public j<Void> setConfigSettingsAsync(com.google.firebase.remoteconfig.FirebaseRemoteConfigSettings firebaseRemoteConfigSettings) {
        b bVar = new b(this, firebaseRemoteConfigSettings);
        return m.c(this.executor, bVar);
    }

    public j<Void> setDefaultsAsync(int i) {
        return setDefaultsWithStringsMapAsync(DefaultsXmlParser.getDefaultsFromXml(this.context, i));
    }

    public j<Void> setDefaultsAsync(Map<String, Object> map) {
        Object key;
        Object string;
        String string2;
        HashMap hashMap = new HashMap();
        Iterator obj5 = map.entrySet().iterator();
        while (obj5.hasNext()) {
            Object next2 = obj5.next();
            string = (Map.Entry)next2.getValue();
            if (string instanceof byte[]) {
            } else {
            }
            hashMap.put((String)next2.getKey(), string.toString());
            string2 = new String((byte[])string);
            hashMap.put((String)next2.getKey(), string2);
        }
        return setDefaultsWithStringsMapAsync(hashMap);
    }

    void startLoadingConfigsFromDisk() {
        this.activatedConfigsCache.get();
        this.defaultConfigsCache.get();
        this.fetchedConfigsCache.get();
    }

    void updateAbtWithActivatedExperiments(JSONArray jSONArray) {
        FirebaseABTesting firebaseAbt;
        List obj3;
        final String str = "FirebaseRemoteConfig";
        if (this.firebaseAbt == null) {
        }
        this.firebaseAbt.replaceAllExperiments(FirebaseRemoteConfig.toExperimentInfoMaps(jSONArray));
    }
}
