package com.google.android.play.core.splitinstall.g;

import java.util.Map;
import java.util.Objects;

/* loaded from: classes2.dex */
final class b extends com.google.android.play.core.splitinstall.g.q {

    private Integer a;
    private Map<String, Integer> b;
    @Override // com.google.android.play.core.splitinstall.g.q
    final com.google.android.play.core.splitinstall.g.q a(int i) {
        this.a = Integer.valueOf(i);
        return this;
    }

    final com.google.android.play.core.splitinstall.g.q b(Map<String, Integer> map) {
        Objects.requireNonNull(map, "Null splitInstallErrorCodeByModule");
        this.b = map;
        return this;
    }

    @Override // com.google.android.play.core.splitinstall.g.q
    final com.google.android.play.core.splitinstall.g.r c() {
        Map map = this.b;
        if (map == null) {
        } else {
            d dVar = new d(this.a, map, 0);
            return dVar;
        }
        IllegalStateException illegalStateException = new IllegalStateException("Missing required properties: splitInstallErrorCodeByModule");
        throw illegalStateException;
    }

    final Map<String, Integer> d() {
        Map map = this.b;
        if (map == null) {
        } else {
            return map;
        }
        IllegalStateException illegalStateException = new IllegalStateException("Property \"splitInstallErrorCodeByModule\" has not been set");
        throw illegalStateException;
    }
}
