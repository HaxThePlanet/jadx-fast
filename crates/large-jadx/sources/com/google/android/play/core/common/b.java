package com.google.android.play.core.common;

import android.os.Bundle;
import com.google.android.play.core.internal.h;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/* loaded from: classes2.dex */
public class b {

    private static final Map<String, Map<String, Integer>> a;
    static {
        HashSet hashSet = new HashSet(Arrays.asList(/* result */));
        HashSet hashSet2 = new HashSet(Arrays.asList(/* result */));
        HashMap hashMap = new HashMap();
        b.a = hashMap;
        h hVar = new h("PlayCoreVersion");
    }

    public static Bundle a(String string) {
        String intValue;
        String str;
        boolean key;
        Map obj3;
        Bundle bundle = new Bundle();
        obj3 = b.b(string);
        bundle.putInt("playcore_version_code", (Integer)obj3.get("java").intValue());
        intValue = "native";
        if (obj3.containsKey(intValue)) {
            bundle.putInt("playcore_native_version", (Integer)obj3.get(intValue).intValue());
        }
        str = "unity";
        if (obj3.containsKey(str)) {
            bundle.putInt("playcore_unity_version", (Integer)obj3.get(str).intValue());
        }
        return bundle;
    }

    public static Map<String, Integer> b(String string) {
        boolean hashMap;
        String str;
        Integer valueOf;
        final Class<com.google.android.play.core.common.b> obj = b.class;
        final Map map = b.a;
        synchronized (obj) {
            hashMap = new HashMap();
            hashMap.put("java", 11002);
            map.put(string, hashMap);
            return (Map)map.get(string);
        }
    }
}
