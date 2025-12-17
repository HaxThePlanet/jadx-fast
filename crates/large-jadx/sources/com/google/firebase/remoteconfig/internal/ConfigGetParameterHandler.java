package com.google.firebase.remoteconfig.internal;

import android.util.Log;
import com.google.android.gms.common.util.d;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.google.firebase.remoteconfig.FirebaseRemoteConfigValue;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.Executor;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class ConfigGetParameterHandler {

    static final Pattern FALSE_REGEX;
    public static final Charset FRC_BYTE_ARRAY_ENCODING;
    static final Pattern TRUE_REGEX;
    private final com.google.firebase.remoteconfig.internal.ConfigCacheClient activatedConfigsCache;
    private final com.google.firebase.remoteconfig.internal.ConfigCacheClient defaultConfigsCache;
    private final Executor executor;
    private final Set<d<String, com.google.firebase.remoteconfig.internal.ConfigContainer>> listeners;
    static {
        ConfigGetParameterHandler.FRC_BYTE_ARRAY_ENCODING = Charset.forName("UTF-8");
        final int i = 2;
        ConfigGetParameterHandler.TRUE_REGEX = Pattern.compile("^(1|true|t|yes|y|on)$", i);
        ConfigGetParameterHandler.FALSE_REGEX = Pattern.compile("^(0|false|f|no|n|off|)$", i);
    }

    public ConfigGetParameterHandler(Executor executor, com.google.firebase.remoteconfig.internal.ConfigCacheClient configCacheClient2, com.google.firebase.remoteconfig.internal.ConfigCacheClient configCacheClient3) {
        super();
        HashSet hashSet = new HashSet();
        this.listeners = hashSet;
        this.executor = executor;
        this.activatedConfigsCache = configCacheClient2;
        this.defaultConfigsCache = configCacheClient3;
    }

    static void a(d d, String string2, com.google.firebase.remoteconfig.internal.ConfigContainer configContainer3) {
        d.a(string2, configContainer3);
    }

    private void callListeners(String string, com.google.firebase.remoteconfig.internal.ConfigContainer configContainer2) {
        Object next;
        Executor executor;
        com.google.firebase.remoteconfig.internal.g gVar;
        if (configContainer2 == null) {
        }
        final Set listeners = this.listeners;
        Iterator iterator = this.listeners.iterator();
        synchronized (listeners) {
            for (d next : iterator) {
                gVar = new g(next, string, configContainer2);
                this.executor.execute(gVar);
            }
        }
    }

    private static com.google.firebase.remoteconfig.internal.ConfigContainer getConfigsFromCache(com.google.firebase.remoteconfig.internal.ConfigCacheClient configCacheClient) {
        return configCacheClient.getBlocking();
    }

    private static Double getDoubleFromCache(com.google.firebase.remoteconfig.internal.ConfigCacheClient configCacheClient, String string2) {
        com.google.firebase.remoteconfig.internal.ConfigContainer obj1 = ConfigGetParameterHandler.getConfigsFromCache(configCacheClient);
        if (obj1 == null) {
            return null;
        }
        return Double.valueOf(obj1.getConfigs().getDouble(string2));
    }

    private static Set<String> getKeySetFromCache(com.google.firebase.remoteconfig.internal.ConfigCacheClient configCacheClient) {
        Object next;
        HashSet hashSet = new HashSet();
        com.google.firebase.remoteconfig.internal.ConfigContainer obj2 = ConfigGetParameterHandler.getConfigsFromCache(configCacheClient);
        if (obj2 == null) {
            return hashSet;
        }
        obj2 = obj2.getConfigs().keys();
        for (String next : obj2) {
            hashSet.add(next);
        }
        return hashSet;
    }

    private static TreeSet<String> getKeysByPrefix(String string, com.google.firebase.remoteconfig.internal.ConfigContainer configContainer2) {
        Object next;
        boolean startsWith;
        TreeSet treeSet = new TreeSet();
        Iterator obj4 = configContainer2.getConfigs().keys();
        while (obj4.hasNext()) {
            next = obj4.next();
            if ((String)next.startsWith(string)) {
            }
            treeSet.add(next);
        }
        return treeSet;
    }

    private static Long getLongFromCache(com.google.firebase.remoteconfig.internal.ConfigCacheClient configCacheClient, String string2) {
        com.google.firebase.remoteconfig.internal.ConfigContainer obj1 = ConfigGetParameterHandler.getConfigsFromCache(configCacheClient);
        if (obj1 == null) {
            return null;
        }
        return Long.valueOf(obj1.getConfigs().getLong(string2));
    }

    private static String getStringFromCache(com.google.firebase.remoteconfig.internal.ConfigCacheClient configCacheClient, String string2) {
        com.google.firebase.remoteconfig.internal.ConfigContainer obj1 = ConfigGetParameterHandler.getConfigsFromCache(configCacheClient);
        if (obj1 == null) {
            return null;
        }
        return obj1.getConfigs().getString(string2);
    }

    private static void logParameterValueDoesNotExist(String string, String string2) {
        Object[] arr = new Object[2];
        Log.w("FirebaseRemoteConfig", String.format("No value of type '%s' exists for parameter key '%s'.", string2, string));
    }

    public void addListener(d<String, com.google.firebase.remoteconfig.internal.ConfigContainer> d) {
        final Set listeners = this.listeners;
        this.listeners.add(d);
        return;
        synchronized (listeners) {
            listeners = this.listeners;
            this.listeners.add(d);
        }
    }

    public Map<String, FirebaseRemoteConfigValue> getAll() {
        Object next;
        FirebaseRemoteConfigValue value;
        HashSet hashSet = new HashSet();
        hashSet.addAll(ConfigGetParameterHandler.getKeySetFromCache(this.activatedConfigsCache));
        hashSet.addAll(ConfigGetParameterHandler.getKeySetFromCache(this.defaultConfigsCache));
        HashMap hashMap = new HashMap();
        Iterator iterator = hashSet.iterator();
        for (String next : iterator) {
            hashMap.put(next, getValue(next));
        }
        return hashMap;
    }

    public boolean getBoolean(String string) {
        String stringFromCache;
        String stringFromCache2;
        int fALSE_REGEX;
        Pattern fALSE_REGEX2;
        stringFromCache = ConfigGetParameterHandler.getStringFromCache(this.activatedConfigsCache, string);
        fALSE_REGEX = 1;
        final int i = 0;
        if (stringFromCache != null && ConfigGetParameterHandler.TRUE_REGEX.matcher(stringFromCache).matches()) {
            if (ConfigGetParameterHandler.TRUE_REGEX.matcher(stringFromCache).matches()) {
                callListeners(string, ConfigGetParameterHandler.getConfigsFromCache(this.activatedConfigsCache));
                return fALSE_REGEX;
            }
            if (ConfigGetParameterHandler.FALSE_REGEX.matcher(stringFromCache).matches()) {
                callListeners(string, ConfigGetParameterHandler.getConfigsFromCache(this.activatedConfigsCache));
                return i;
            }
        }
        stringFromCache2 = ConfigGetParameterHandler.getStringFromCache(this.defaultConfigsCache, string);
        if (stringFromCache2 != null && ConfigGetParameterHandler.TRUE_REGEX.matcher(stringFromCache2).matches()) {
            if (ConfigGetParameterHandler.TRUE_REGEX.matcher(stringFromCache2).matches()) {
                return fALSE_REGEX;
            }
            if (ConfigGetParameterHandler.FALSE_REGEX.matcher(stringFromCache2).matches()) {
                return i;
            }
        }
        ConfigGetParameterHandler.logParameterValueDoesNotExist(string, "Boolean");
        return i;
    }

    public byte[] getByteArray(String string) {
        String stringFromCache = ConfigGetParameterHandler.getStringFromCache(this.activatedConfigsCache, string);
        if (stringFromCache != null) {
            callListeners(string, ConfigGetParameterHandler.getConfigsFromCache(this.activatedConfigsCache));
            return stringFromCache.getBytes(ConfigGetParameterHandler.FRC_BYTE_ARRAY_ENCODING);
        }
        String stringFromCache2 = ConfigGetParameterHandler.getStringFromCache(this.defaultConfigsCache, string);
        if (stringFromCache2 != null) {
            return stringFromCache2.getBytes(ConfigGetParameterHandler.FRC_BYTE_ARRAY_ENCODING);
        }
        ConfigGetParameterHandler.logParameterValueDoesNotExist(string, "ByteArray");
        return FirebaseRemoteConfig.DEFAULT_VALUE_FOR_BYTE_ARRAY;
    }

    public double getDouble(String string) {
        Double doubleFromCache = ConfigGetParameterHandler.getDoubleFromCache(this.activatedConfigsCache, string);
        if (doubleFromCache != null) {
            callListeners(string, ConfigGetParameterHandler.getConfigsFromCache(this.activatedConfigsCache));
            return doubleFromCache.doubleValue();
        }
        Double doubleFromCache2 = ConfigGetParameterHandler.getDoubleFromCache(this.defaultConfigsCache, string);
        if (doubleFromCache2 != null) {
            return doubleFromCache2.doubleValue();
        }
        ConfigGetParameterHandler.logParameterValueDoesNotExist(string, "Double");
        return 0;
    }

    public Set<String> getKeysByPrefix(String string) {
        Object configsFromCache;
        String obj3;
        if (string == null) {
            obj3 = "";
        }
        TreeSet treeSet = new TreeSet();
        configsFromCache = ConfigGetParameterHandler.getConfigsFromCache(this.activatedConfigsCache);
        if (configsFromCache != null) {
            treeSet.addAll(ConfigGetParameterHandler.getKeysByPrefix(obj3, configsFromCache));
        }
        com.google.firebase.remoteconfig.internal.ConfigContainer configsFromCache2 = ConfigGetParameterHandler.getConfigsFromCache(this.defaultConfigsCache);
        if (configsFromCache2 != null) {
            treeSet.addAll(ConfigGetParameterHandler.getKeysByPrefix(obj3, configsFromCache2));
        }
        return treeSet;
    }

    public long getLong(String string) {
        Long longFromCache = ConfigGetParameterHandler.getLongFromCache(this.activatedConfigsCache, string);
        if (longFromCache != null) {
            callListeners(string, ConfigGetParameterHandler.getConfigsFromCache(this.activatedConfigsCache));
            return longFromCache.longValue();
        }
        Long longFromCache2 = ConfigGetParameterHandler.getLongFromCache(this.defaultConfigsCache, string);
        if (longFromCache2 != null) {
            return longFromCache2.longValue();
        }
        ConfigGetParameterHandler.logParameterValueDoesNotExist(string, "Long");
        return 0;
    }

    public String getString(String string) {
        String stringFromCache = ConfigGetParameterHandler.getStringFromCache(this.activatedConfigsCache, string);
        if (stringFromCache != null) {
            callListeners(string, ConfigGetParameterHandler.getConfigsFromCache(this.activatedConfigsCache));
            return stringFromCache;
        }
        String stringFromCache2 = ConfigGetParameterHandler.getStringFromCache(this.defaultConfigsCache, string);
        if (stringFromCache2 != null) {
            return stringFromCache2;
        }
        ConfigGetParameterHandler.logParameterValueDoesNotExist(string, "String");
        return "";
    }

    public FirebaseRemoteConfigValue getValue(String string) {
        String stringFromCache = ConfigGetParameterHandler.getStringFromCache(this.activatedConfigsCache, string);
        if (stringFromCache != null) {
            callListeners(string, ConfigGetParameterHandler.getConfigsFromCache(this.activatedConfigsCache));
            FirebaseRemoteConfigValueImpl obj3 = new FirebaseRemoteConfigValueImpl(stringFromCache, 2);
            return obj3;
        }
        String stringFromCache2 = ConfigGetParameterHandler.getStringFromCache(this.defaultConfigsCache, string);
        if (stringFromCache2 != null) {
            obj3 = new FirebaseRemoteConfigValueImpl(stringFromCache2, 1);
            return obj3;
        }
        ConfigGetParameterHandler.logParameterValueDoesNotExist(string, "FirebaseRemoteConfigValue");
        obj3 = new FirebaseRemoteConfigValueImpl("", 0);
        return obj3;
    }
}
