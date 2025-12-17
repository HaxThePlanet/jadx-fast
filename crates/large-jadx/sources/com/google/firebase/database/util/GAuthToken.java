package com.google.firebase.database.util;

import java.util.HashMap;
import java.util.Map;

/* loaded from: classes2.dex */
public class GAuthToken {

    private static final String AUTH_KEY = "auth";
    private static final String TOKEN_KEY = "token";
    private static final String TOKEN_PREFIX = "gauth|";
    private final Map<String, Object> auth;
    private final String token;
    public GAuthToken(String string, Map<String, Object> map2) {
        super();
        this.token = string;
        this.auth = map2;
    }

    public static com.google.firebase.database.util.GAuthToken tryParseFromString(String string) {
        if (!string.startsWith("gauth|")) {
            return null;
        }
        Map obj2 = JsonMapper.parseJson(string.substring(6));
        GAuthToken gAuthToken = new GAuthToken((String)obj2.get("token"), (Map)obj2.get("auth"));
        return gAuthToken;
    }

    public Map<String, Object> getAuth() {
        return this.auth;
    }

    public String getToken() {
        return this.token;
    }

    public String serializeToString() {
        HashMap hashMap = new HashMap();
        hashMap.put("token", this.token);
        hashMap.put("auth", this.auth);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("gauth|");
        stringBuilder.append(JsonMapper.serializeJson(hashMap));
        return stringBuilder.toString();
    }
}
