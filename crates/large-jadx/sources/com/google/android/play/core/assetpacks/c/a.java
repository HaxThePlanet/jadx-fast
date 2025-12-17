package com.google.android.play.core.assetpacks.c;

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
        Integer valueOf = -1;
        hashMap.put(valueOf, "The requesting app is unavailable (e.g. unpublished, nonexistent version code).");
        Integer valueOf2 = -2;
        hashMap.put(valueOf2, "The requested pack is not available.");
        Integer valueOf3 = -3;
        hashMap.put(valueOf3, "The request is invalid.");
        Integer valueOf4 = -4;
        hashMap.put(valueOf4, "The requested download is not found.");
        Integer valueOf5 = -5;
        hashMap.put(valueOf5, "The Asset Delivery API is not available.");
        Integer valueOf6 = -6;
        hashMap.put(valueOf6, "Network error. Unable to obtain the asset pack details.");
        Integer valueOf7 = -7;
        hashMap.put(valueOf7, "Download not permitted under current device circumstances (e.g. in background).");
        Integer valueOf8 = -10;
        hashMap.put(valueOf8, "Asset pack download failed due to insufficient storage.");
        Integer valueOf9 = -11;
        hashMap.put(valueOf9, "The Play Store app is either not installed or not the official version.");
        Integer valueOf10 = -12;
        hashMap.put(valueOf10, "Tried to show the cellular data confirmation but no asset packs are waiting for Wi-Fi.");
        Integer valueOf11 = -13;
        hashMap.put(valueOf11, "The app is not owned by any user on this device. An app is \"owned\" if it has been acquired from Play.");
        Integer valueOf12 = -100;
        hashMap.put(valueOf12, "Unknown error downloading an asset pack.");
        hashMap2.put(valueOf, "APP_UNAVAILABLE");
        hashMap2.put(valueOf2, "PACK_UNAVAILABLE");
        hashMap2.put(valueOf3, "INVALID_REQUEST");
        hashMap2.put(valueOf4, "DOWNLOAD_NOT_FOUND");
        hashMap2.put(valueOf5, "API_NOT_AVAILABLE");
        hashMap2.put(valueOf6, "NETWORK_ERROR");
        hashMap2.put(valueOf7, "ACCESS_DENIED");
        hashMap2.put(valueOf8, "INSUFFICIENT_STORAGE");
        hashMap2.put(valueOf9, "PLAY_STORE_NOT_FOUND");
        hashMap2.put(valueOf10, "NETWORK_UNRESTRICTED");
        hashMap2.put(valueOf11, "APP_NOT_OWNED");
        hashMap2.put(valueOf12, "INTERNAL_ERROR");
    }

    public static String a(int i) {
        Map map = a.a;
        Integer obj4 = Integer.valueOf(i);
        if (!map.containsKey(obj4)) {
            return "";
        }
        Object obj = map.get(obj4);
        obj4 = a.b.get(obj4);
        StringBuilder stringBuilder = new StringBuilder(i2 += length2);
        stringBuilder.append(obj);
        stringBuilder.append(" (https://developer.android.com/reference/com/google/android/play/core/assetpacks/model/AssetPackErrorCode.html#");
        stringBuilder.append(obj4);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }
}
