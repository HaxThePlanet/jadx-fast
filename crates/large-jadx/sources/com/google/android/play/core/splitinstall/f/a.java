package com.google.android.play.core.splitinstall.f;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/* loaded from: classes2.dex */
public final class a {

    private static final Map<Integer, String> a;
    private static final Map<Integer, String> b;
    private static final Map<String, Integer> c;
    static {
        HashMap hashMap;
        Integer num;
        Integer valueOf;
        HashMap hashMap2 = new HashMap();
        a.a = hashMap2;
        hashMap = new HashMap();
        a.b = hashMap;
        Integer valueOf2 = -1;
        hashMap2.put(valueOf2, "Too many sessions are running for current app, existing sessions must be resolved first.");
        valueOf = -2;
        hashMap2.put(valueOf, "A requested module is not available (to this user/device, for the installed apk).");
        Integer valueOf3 = -3;
        hashMap2.put(valueOf3, "Request is otherwise invalid.");
        Integer valueOf4 = -4;
        hashMap2.put(valueOf4, "Requested session is not found.");
        Integer valueOf5 = -5;
        hashMap2.put(valueOf5, "Split Install API is not available.");
        Integer valueOf6 = -6;
        hashMap2.put(valueOf6, "Network error: unable to obtain split details.");
        Integer valueOf7 = -7;
        hashMap2.put(valueOf7, "Download not permitted under current device circumstances (e.g. in background).");
        Integer valueOf8 = -8;
        hashMap2.put(valueOf8, "Requested session contains modules from an existing active session and also new modules.");
        Integer valueOf9 = -9;
        hashMap2.put(valueOf9, "Service handling split install has died.");
        Integer valueOf10 = -10;
        hashMap2.put(valueOf10, "Install failed due to insufficient storage.");
        Integer valueOf11 = -11;
        hashMap2.put(valueOf11, "Signature verification error when invoking SplitCompat.");
        Integer valueOf12 = -12;
        hashMap2.put(valueOf12, "Error in SplitCompat emulation.");
        Integer valueOf13 = -13;
        hashMap2.put(valueOf13, "Error in copying files for SplitCompat.");
        Integer valueOf15 = -14;
        hashMap2.put(valueOf15, "The Play Store app is either not installed or not the official version.");
        Integer valueOf14 = -15;
        hashMap2.put(valueOf14, "The app is not owned by any user on this device. An app is \"owned\" if it has been acquired from Play.");
        Integer valueOf16 = -100;
        hashMap2.put(valueOf16, "Unknown error processing split install.");
        hashMap.put(valueOf2, "ACTIVE_SESSIONS_LIMIT_EXCEEDED");
        hashMap.put(valueOf, "MODULE_UNAVAILABLE");
        hashMap.put(valueOf3, "INVALID_REQUEST");
        hashMap.put(valueOf4, "DOWNLOAD_NOT_FOUND");
        hashMap.put(valueOf5, "API_NOT_AVAILABLE");
        hashMap.put(valueOf6, "NETWORK_ERROR");
        hashMap.put(valueOf7, "ACCESS_DENIED");
        hashMap.put(valueOf8, "INCOMPATIBLE_WITH_EXISTING_SESSION");
        hashMap.put(valueOf9, "SERVICE_DIED");
        hashMap.put(valueOf10, "INSUFFICIENT_STORAGE");
        hashMap.put(valueOf11, "SPLITCOMPAT_VERIFICATION_ERROR");
        hashMap.put(valueOf12, "SPLITCOMPAT_EMULATION_ERROR");
        hashMap.put(valueOf13, "SPLITCOMPAT_COPY_ERROR");
        hashMap.put(valueOf15, "PLAY_STORE_NOT_FOUND");
        hashMap.put(valueOf14, "APP_NOT_OWNED");
        hashMap.put(valueOf16, "INTERNAL_ERROR");
        HashMap hashMap3 = new HashMap();
        a.c = hashMap3;
        Iterator iterator = hashMap.entrySet().iterator();
        for (Map.Entry next2 : iterator) {
            a.c.put((String)next2.getValue(), (Integer)next2.getKey());
        }
    }

    public static int a(String string) {
        Object obj = a.c.get(string);
        if ((Integer)obj == null) {
        } else {
            return (Integer)obj.intValue();
        }
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(String.valueOf(string).concat(" is unknown error."));
        throw illegalArgumentException;
    }

    public static String b(int i) {
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
            stringBuilder.append(" (https://developer.android.com/reference/com/google/android/play/core/splitinstall/model/SplitInstallErrorCode.html#");
            stringBuilder.append(obj4);
            stringBuilder.append(")");
            return stringBuilder.toString();
        }
        return "";
    }
}
