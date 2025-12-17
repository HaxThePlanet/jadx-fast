package com.android.billingclient.api;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes.dex */
final class p implements ThreadFactory {

    private final ThreadFactory a;
    private final AtomicInteger b;
    p(com.android.billingclient.api.d d) {
        super();
        this.a = Executors.defaultThreadFactory();
        AtomicInteger obj2 = new AtomicInteger(1);
        this.b = obj2;
    }

    @Override // java.util.concurrent.ThreadFactory
    public final Thread newThread(Runnable runnable) {
        final Thread obj4 = this.a.newThread(runnable);
        StringBuilder stringBuilder = new StringBuilder(30);
        stringBuilder.append("PlayBillingLibrary-");
        stringBuilder.append(this.b.getAndIncrement());
        obj4.setName(stringBuilder.toString());
        return obj4;
    }
}
