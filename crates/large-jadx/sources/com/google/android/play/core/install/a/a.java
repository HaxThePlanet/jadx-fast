package com.google.android.play.core.install.a;

import java.util.HashMap;
import java.util.Map;

/* loaded from: classes2.dex */
public final class a {

    private static final Map<Integer, String> a;
    private static final Map<Integer, String> b;
    static {
        HashMap hashMap = new HashMap();
        a.a = hashMap;
        HashMap hashMap2 = new HashMap();
        a.b = hashMap2;
        Integer valueOf = -2;
        hashMap.put(valueOf, "An unknown error occurred.");
        Integer valueOf2 = -3;
        hashMap.put(valueOf2, "The API is not available on this device.");
        Integer valueOf3 = -4;
        hashMap.put(valueOf3, "The request that was sent by the app is malformed.");
        Integer valueOf4 = -5;
        hashMap.put(valueOf4, "The install is unavailable to this user or device.");
        Integer valueOf5 = -6;
        hashMap.put(valueOf5, "The download/install is not allowed, due to the current device state (e.g. low battery, low disk space, ...).");
        Integer valueOf6 = -7;
        hashMap.put(valueOf6, "The install/update has not been (fully) downloaded yet.");
        Integer valueOf7 = -8;
        hashMap.put(valueOf7, "The install is already in progress and there is no UI flow to resume.");
        Integer valueOf8 = -9;
        hashMap.put(valueOf8, "The Play Store app is either not installed or not the official version.");
        Integer valueOf9 = -10;
        hashMap.put(valueOf9, "The app is not owned by any user on this device. An app is \"owned\" if it has been acquired from Play.");
        Integer valueOf10 = -100;
        hashMap.put(valueOf10, "An internal error happened in the Play Store.");
        hashMap2.put(valueOf, "ERROR_UNKNOWN");
        hashMap2.put(valueOf2, "ERROR_API_NOT_AVAILABLE");
        hashMap2.put(valueOf3, "ERROR_INVALID_REQUEST");
        hashMap2.put(valueOf4, "ERROR_INSTALL_UNAVAILABLE");
        hashMap2.put(valueOf5, "ERROR_INSTALL_NOT_ALLOWED");
        hashMap2.put(valueOf6, "ERROR_DOWNLOAD_NOT_PRESENT");
        hashMap2.put(valueOf7, "ERROR_INSTALL_IN_PROGRESS");
        String str8 = "ERROR_INTERNAL_ERROR";
        hashMap2.put(valueOf10, str8);
        hashMap2.put(valueOf8, "ERROR_PLAY_STORE_NOT_FOUND");
        hashMap2.put(valueOf9, "ERROR_APP_NOT_OWNED");
        hashMap2.put(valueOf10, str8);
    }

    public static String a(int i) {
        boolean key;
        boolean key2;
        Map map = a.a;
        Integer obj4 = Integer.valueOf(i);
        key = a.b;
        if (map.containsKey(obj4) && !key.containsKey(obj4)) {
            key = a.b;
            if (!key.containsKey(obj4)) {
            }
            Object obj = map.get(obj4);
            obj4 = key.get(obj4);
            StringBuilder stringBuilder = new StringBuilder(i2 += length2);
            stringBuilder.append(obj);
            stringBuilder.append(" (https://developer.android.com/reference/com/google/android/play/core/install/model/InstallErrorCode#");
            stringBuilder.append(obj4);
            stringBuilder.append(")");
            return stringBuilder.toString();
        }
        return "";
    }
}
