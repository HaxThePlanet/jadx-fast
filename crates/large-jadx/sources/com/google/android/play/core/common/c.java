package com.google.android.play.core.common;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes2.dex */
public final class c {

    private final Map<String, Object> a;
    private final AtomicBoolean b;
    public c() {
        super();
        HashMap hashMap = new HashMap();
        this.a = hashMap;
        AtomicBoolean atomicBoolean = new AtomicBoolean(0);
        this.b = atomicBoolean;
    }

    private final void b() {
        this.a.put("assetOnlyUpdates", Boolean.FALSE);
        return;
        synchronized (this) {
            this.a.put("assetOnlyUpdates", Boolean.FALSE);
        }
    }

    public final boolean a(String string) {
        synchronized (this) {
            try {
                b();
                Object obj2 = this.a.get("assetOnlyUpdates");
                if (!obj2 instanceof Boolean) {
                }
                return 0;
                return (Boolean)obj2.booleanValue();
                throw string;
            }
        }
    }
}
