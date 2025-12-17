package com.google.android.play.core.review.c;

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
        hashMap.put(valueOf, "The Play Store app is either not installed or not the official version.");
        Integer valueOf2 = -2;
        hashMap.put(valueOf2, "Call first requestReviewFlow to get the ReviewInfo.");
        hashMap2.put(valueOf, "PLAY_STORE_NOT_FOUND");
        hashMap2.put(valueOf2, "INVALID_REQUEST");
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
        stringBuilder.append(" (https://developer.android.com/reference/com/google/android/play/core/review/model/ReviewErrorCode.html#");
        stringBuilder.append(obj4);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }
}
