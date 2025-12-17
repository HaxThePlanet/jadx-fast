package com.amplitude.api;

import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public class d {

    static final Map<String, com.amplitude.api.f> a;
    static {
        HashMap hashMap = new HashMap();
        d.a = hashMap;
    }

    public static com.amplitude.api.f a(String string) {
        Object fVar;
        final Class<com.amplitude.api.d> obj = d.class;
        final String obj3 = n.e(string);
        final Map map = d.a;
        synchronized (obj) {
            fVar = new f(obj3);
            map.put(obj3, fVar);
            return fVar;
        }
    }
}
