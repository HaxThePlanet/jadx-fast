package com.bumptech.glide;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* compiled from: GlideExperiments.java */
/* loaded from: classes.dex */
public class f {

    private final Map<Class<?>, Object> a;

    static final class a {

        private final Map<Class<?>, Object> a = new HashMap<>();
        a() {
            super();
            final HashMap hashMap = new HashMap();
        }

        static /* synthetic */ Map a(f.a aVar) {
            return aVar.a;
        }

        f b() {
            return new f(this);
        }
    }
    f(f.a aVar) {
        super();
        this.a = Collections.unmodifiableMap(new HashMap(aVar.a));
    }

    public boolean a(Class<? extends Object> cls) {
        return this.a.containsKey(cls);
    }
}
