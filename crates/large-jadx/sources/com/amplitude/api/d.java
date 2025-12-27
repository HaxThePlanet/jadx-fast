package com.amplitude.api;

import java.util.Map;

/* compiled from: Amplitude.java */
/* loaded from: classes.dex */
public class d {

    static final Map<String, f> a = new HashMap<>();

    public static synchronized f a(String str) {
        Object value;
        final Class<com.amplitude.api.d> obj2 = d.class;
        final String str2 = n.e(str);
        final Map map = d.a;
        if ((f)map.get(str2) == null) {
            d.a.put(str2, new f(str2));
        }
        return value;
    }
}
