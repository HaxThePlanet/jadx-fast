package com.android.billingclient.api;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: com.android.billingclient:billing@@4.0.0 */
/* loaded from: classes.dex */
final class p implements ThreadFactory {

    private final ThreadFactory a;
    private final AtomicInteger b = new AtomicInteger(1);
    p(d dVar) {
        super();
        this.a = Executors.defaultThreadFactory();
        AtomicInteger atomicInteger = new AtomicInteger(1);
    }

    @Override // java.util.concurrent.ThreadFactory
    public final Thread newThread(Runnable runnable) {
        final Thread thread = this.a.newThread(runnable);
        int andIncrement = this.b.getAndIncrement();
        final StringBuilder stringBuilder = new StringBuilder(30);
        String str2 = "PlayBillingLibrary-";
        str = 30 + str2 + andIncrement;
        thread.setName(str);
        return thread;
    }
}
