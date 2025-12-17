package com.google.android.play.core.splitinstall.g;

import java.util.Collections;
import java.util.Map;

/* loaded from: classes2.dex */
abstract class q {
    abstract com.google.android.play.core.splitinstall.g.q a(int i);

    abstract com.google.android.play.core.splitinstall.g.q b(Map<String, Integer> map);

    abstract com.google.android.play.core.splitinstall.g.r c();

    abstract Map<String, Integer> d();

    final com.google.android.play.core.splitinstall.g.r e() {
        b(Collections.unmodifiableMap(d()));
        return c();
    }
}
