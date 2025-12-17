package com.bumptech.glide;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public class f {

    private final Map<Class<?>, Object> a;

    static final class a {

        private final Map<Class<?>, Object> a;
        a() {
            super();
            HashMap hashMap = new HashMap();
            this.a = hashMap;
        }

        static Map a(com.bumptech.glide.f.a f$a) {
            return a.a;
        }

        com.bumptech.glide.f b() {
            f fVar = new f(this);
            return fVar;
        }
    }
    f(com.bumptech.glide.f.a f$a) {
        super();
        HashMap hashMap = new HashMap(f.a.a(a));
        this.a = Collections.unmodifiableMap(hashMap);
    }

    public boolean a(Class<? extends Object> class) {
        return this.a.containsKey(class);
    }
}
