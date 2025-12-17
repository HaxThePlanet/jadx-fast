package com.google.android.play.core.assetpacks;

import java.util.HashMap;
import java.util.Map;

/* loaded from: classes2.dex */
final class k1 {

    private final Map<String, Double> a;
    k1() {
        super();
        HashMap hashMap = new HashMap();
        this.a = hashMap;
    }

    final double a(String string) {
        final Object obj3 = this.a.get(string);
        synchronized (this) {
            try {
                return 0;
                return (Double)obj3.doubleValue();
                throw string;
            }
        }
    }

    final double b(String string, com.google.android.play.core.assetpacks.b2 b22) {
        i2 /= d2;
        this.a.put(string, Double.valueOf(i3));
        return i3;
        synchronized (this) {
            i2 /= d2;
            this.a.put(string, Double.valueOf(i3));
            return i3;
        }
    }

    final void c(String string) {
        this.a.put(string, Double.valueOf(0));
        return;
        synchronized (this) {
            this.a.put(string, Double.valueOf(0));
        }
    }
}
