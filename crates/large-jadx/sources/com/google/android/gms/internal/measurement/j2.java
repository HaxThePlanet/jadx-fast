package com.google.android.gms.internal.measurement;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

/* loaded from: classes2.dex */
final class j2 implements ThreadFactory {

    private final ThreadFactory a;
    j2(com.google.android.gms.internal.measurement.g3 g3) {
        super();
        this.a = Executors.defaultThreadFactory();
    }

    @Override // java.util.concurrent.ThreadFactory
    public final Thread newThread(Runnable runnable) {
        final Thread obj2 = this.a.newThread(runnable);
        obj2.setName("ScionFrontendApi");
        return obj2;
    }
}
