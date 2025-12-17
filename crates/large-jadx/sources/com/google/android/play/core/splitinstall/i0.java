package com.google.android.play.core.splitinstall;

import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/* loaded from: classes2.dex */
public final class i0 {

    private final Map<String, Map<String, String>> a;
    public i0() {
        super();
        HashMap hashMap = new HashMap();
        this.a = hashMap;
    }

    public final com.google.android.play.core.splitinstall.i0 a(String string, String string2, String string3) {
        boolean key;
        HashMap hashMap;
        if (!this.a.containsKey(string2)) {
            hashMap = new HashMap();
            this.a.put(string2, hashMap);
        }
        (Map)this.a.get(string2).put(string, string3);
        return this;
    }

    public final com.google.android.play.core.splitinstall.k0 b() {
        Map unmodifiableMap;
        Object key;
        HashMap hashMap;
        HashMap hashMap2 = new HashMap();
        Iterator iterator = this.a.entrySet().iterator();
        for (Map.Entry next2 : iterator) {
            hashMap = new HashMap((Map)next2.getValue());
            hashMap2.put((String)next2.getKey(), Collections.unmodifiableMap(hashMap));
        }
        k0 k0Var = new k0(Collections.unmodifiableMap(hashMap2), 0);
        return k0Var;
    }
}
