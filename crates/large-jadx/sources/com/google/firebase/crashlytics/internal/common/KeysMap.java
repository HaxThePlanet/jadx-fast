package com.google.firebase.crashlytics.internal.common;

import com.google.firebase.crashlytics.internal.Logger;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/* loaded from: classes2.dex */
public class KeysMap {

    private final Map<String, String> keys;
    private final int maxEntries;
    private final int maxEntryLength;
    public KeysMap(int i, int i2) {
        super();
        HashMap hashMap = new HashMap();
        this.keys = hashMap;
        this.maxEntries = i;
        this.maxEntryLength = i2;
    }

    private String sanitizeKey(String string) {
        if (string == null) {
        } else {
            return sanitizeAttribute(string);
        }
        IllegalArgumentException obj2 = new IllegalArgumentException("Custom attribute key must not be null.");
        throw obj2;
    }

    public Map<String, String> getKeys() {
        HashMap hashMap = new HashMap(this.keys);
        return Collections.unmodifiableMap(hashMap);
        synchronized (this) {
            hashMap = new HashMap(this.keys);
            return Collections.unmodifiableMap(hashMap);
        }
    }

    public String sanitizeAttribute(String string) {
        int length;
        int maxEntryLength;
        String obj3;
        obj3 = string.trim();
        maxEntryLength = this.maxEntryLength;
        if (string != null && obj3.length() > maxEntryLength) {
            obj3 = string.trim();
            maxEntryLength = this.maxEntryLength;
            if (obj3.length() > maxEntryLength) {
                obj3 = obj3.substring(0, maxEntryLength);
            }
        }
        return obj3;
    }

    public void setKey(String string, String string2) {
        Object stringBuilder;
        String size;
        Object obj4;
        Object obj5;
        stringBuilder = sanitizeKey(string);
        synchronized (this) {
            try {
                if (this.keys.containsKey(stringBuilder)) {
                } else {
                }
                stringBuilder = new StringBuilder();
                stringBuilder.append("Ignored entry \"");
                stringBuilder.append(string);
                stringBuilder.append("\" when adding custom keys. Maximum allowable: ");
                stringBuilder.append(this.maxEntries);
                Logger.getLogger().w(stringBuilder.toString());
                if (string2 == null) {
                } else {
                }
                obj5 = "";
                obj5 = sanitizeAttribute(string2);
                this.keys.put(stringBuilder, obj5);
                throw string;
            }
        }
    }

    public void setKeys(Map<String, String> map) {
        int string;
        Object sanitizeAttribute;
        boolean stringBuilder;
        String sanitizeKey;
        boolean size;
        int maxEntries;
        Object obj6;
        string = 0;
        obj6 = map.entrySet().iterator();
        synchronized (this) {
            while (obj6.hasNext()) {
                sanitizeAttribute = obj6.next();
                sanitizeKey = sanitizeKey((String)(Map.Entry)sanitizeAttribute.getKey());
                if (this.keys.size() >= this.maxEntries) {
                } else {
                }
                Object value = sanitizeAttribute.getValue();
                if ((String)value == null) {
                } else {
                }
                sanitizeAttribute = sanitizeAttribute((String)value);
                this.keys.put(sanitizeKey, sanitizeAttribute);
                sanitizeAttribute = "";
                if (this.keys.containsKey(sanitizeKey)) {
                } else {
                }
                string++;
            }
            if (string > 0) {
                stringBuilder = new StringBuilder();
                stringBuilder.append("Ignored ");
                stringBuilder.append(string);
                stringBuilder.append(" entries when adding custom keys. Maximum allowable: ");
                stringBuilder.append(this.maxEntries);
                Logger.getLogger().w(stringBuilder.toString());
            }
        }
    }
}
