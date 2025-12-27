package com.bumptech.glide.load.engine;

import com.bumptech.glide.load.f;
import java.util.HashMap;
import java.util.Map;

/* compiled from: Jobs.java */
/* loaded from: classes.dex */
final class r {

    private final Map<f, l<?>> a = new HashMap<>();
    private final Map<f, l<?>> b = new HashMap<>();
    r() {
        super();
        HashMap hashMap = new HashMap();
        HashMap hashMap2 = new HashMap();
    }

    private Map<f, l<?>> b(boolean z) {
        Map map;
        z = z ? this.b : this.a;
        return (z ? this.b : this.a);
    }

    l<?> a(f fVar, boolean z) {
        return (l)b(z).get(fVar);
    }

    void c(f fVar, l<?> lVar) {
        b(lVar.p()).put(fVar, lVar);
    }

    void d(f fVar, l<?> lVar) {
        Map map = b(lVar.p());
        if (lVar.equals(map.get(fVar))) {
            map.remove(fVar);
        }
    }
}
