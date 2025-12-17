package com.bumptech.glide.load.engine;

import com.bumptech.glide.load.f;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
final class r {

    private final Map<f, com.bumptech.glide.load.engine.l<?>> a;
    private final Map<f, com.bumptech.glide.load.engine.l<?>> b;
    r() {
        super();
        HashMap hashMap = new HashMap();
        this.a = hashMap;
        HashMap hashMap2 = new HashMap();
        this.b = hashMap2;
    }

    private Map<f, com.bumptech.glide.load.engine.l<?>> b(boolean z) {
        Map obj1;
        obj1 = z ? this.b : this.a;
        return obj1;
    }

    com.bumptech.glide.load.engine.l<?> a(f f, boolean z2) {
        return (l)b(z2).get(f);
    }

    void c(f f, com.bumptech.glide.load.engine.l<?> l2) {
        b(l2.p()).put(f, l2);
    }

    void d(f f, com.bumptech.glide.load.engine.l<?> l2) {
        Map map = b(l2.p());
        if (l2.equals(map.get(f))) {
            map.remove(f);
        }
    }
}
