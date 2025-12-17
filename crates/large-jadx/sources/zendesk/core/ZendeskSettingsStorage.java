package zendesk.core;

import com.google.gson.JsonElement;
import f.g.e.g;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/* loaded from: classes3.dex */
class ZendeskSettingsStorage implements zendesk.core.SettingsStorage {

    private static final String LAST_UPDATE = "last_settings_update";
    private static final String RAWSETTTINGS_KEYSET = "rawsettings_keyset";
    private final zendesk.core.BaseStorage settingsStorage;
    ZendeskSettingsStorage(zendesk.core.BaseStorage baseStorage) {
        super();
        this.settingsStorage = baseStorage;
    }

    @Override // zendesk.core.SettingsStorage
    public boolean areSettingsUpToDate(long l, TimeUnit timeUnit2) {
        int i;
        String str;
        long longValue;
        long obj7;
        zendesk.core.BaseStorage settingsStorage = this.settingsStorage;
        Object obj = this.settingsStorage.get("last_settings_update", Long.class);
        i = 0;
        synchronized (settingsStorage) {
            settingsStorage = this.settingsStorage;
            obj = this.settingsStorage.get("last_settings_update", Long.class);
            i = 0;
        }
        if (Long.compare(longValue2, longValue) == 0) {
        } else {
            try {
                if (Long.compare(str, obj7) < 0) {
                }
                i = 1;
                return i;
                throw l;
            }
        }
    }

    @Override // zendesk.core.SettingsStorage
    public void clear() {
        final zendesk.core.BaseStorage settingsStorage = this.settingsStorage;
        this.settingsStorage.clear();
        return;
        synchronized (settingsStorage) {
            settingsStorage = this.settingsStorage;
            this.settingsStorage.clear();
        }
    }

    public Map<String, JsonElement> getRawSettings() {
        Object iterator;
        String next;
        Class<Set> obj;
        Class<JsonElement> obj2;
        final zendesk.core.BaseStorage settingsStorage = this.settingsStorage;
        HashMap hashMap = new HashMap();
        iterator = this.settingsStorage.get("rawsettings_keyset", Set.class);
        synchronized (settingsStorage) {
            iterator = (Set)iterator.iterator();
            while (iterator.hasNext()) {
                next = iterator.next();
                if ((String)next != null) {
                }
                hashMap.put(next, this.settingsStorage.get((String)next, JsonElement.class));
            }
            return hashMap;
        }
    }

    public <E> E getSettings(String string, Class<E> class2) {
        final zendesk.core.BaseStorage settingsStorage = this.settingsStorage;
        return this.settingsStorage.get(string, class2);
        synchronized (settingsStorage) {
            settingsStorage = this.settingsStorage;
            return this.settingsStorage.get(string, class2);
        }
    }

    @Override // zendesk.core.SettingsStorage
    public boolean hasStoredSettings() {
        final zendesk.core.BaseStorage settingsStorage = this.settingsStorage;
        return g.c(this.settingsStorage.get("last_settings_update"));
        synchronized (settingsStorage) {
            settingsStorage = this.settingsStorage;
            return g.c(this.settingsStorage.get("last_settings_update"));
        }
    }

    public void storeRawSettings(Map<String, JsonElement> map) {
        String value;
        Long settingsStorage;
        long key;
        final zendesk.core.BaseStorage settingsStorage2 = this.settingsStorage;
        this.settingsStorage.put("last_settings_update", Long.valueOf(System.currentTimeMillis()));
        Iterator iterator = map.entrySet().iterator();
        synchronized (settingsStorage2) {
            for (Map.Entry next2 : iterator) {
                this.settingsStorage.put((String)next2.getKey(), next2.getValue());
            }
            try {
                this.settingsStorage.put("rawsettings_keyset", map.keySet());
                throw map;
            }
        }
    }
}
