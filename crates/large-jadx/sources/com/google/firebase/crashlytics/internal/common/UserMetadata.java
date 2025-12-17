package com.google.firebase.crashlytics.internal.common;

import java.util.Map;

/* loaded from: classes2.dex */
public class UserMetadata {

    static final int MAX_ATTRIBUTES = 64;
    static final int MAX_ATTRIBUTE_SIZE = 1024;
    static final int MAX_INTERNAL_KEY_SIZE = 8192;
    private final com.google.firebase.crashlytics.internal.common.KeysMap customKeys;
    private final com.google.firebase.crashlytics.internal.common.KeysMap internalKeys;
    private String userId = null;
    public UserMetadata() {
        super();
        int i = 0;
        final int i2 = 64;
        KeysMap keysMap = new KeysMap(i2, 1024);
        this.customKeys = keysMap;
        KeysMap keysMap2 = new KeysMap(i2, 8192);
        this.internalKeys = keysMap2;
    }

    public Map<String, String> getCustomKeys() {
        return this.customKeys.getKeys();
    }

    public Map<String, String> getInternalKeys() {
        return this.internalKeys.getKeys();
    }

    public String getUserId() {
        return this.userId;
    }

    public void setCustomKey(String string, String string2) {
        this.customKeys.setKey(string, string2);
    }

    public void setCustomKeys(Map<String, String> map) {
        this.customKeys.setKeys(map);
    }

    public void setInternalKey(String string, String string2) {
        this.internalKeys.setKey(string, string2);
    }

    public void setUserId(String string) {
        this.userId = this.customKeys.sanitizeAttribute(string);
    }
}
