package com.google.android.gms.internal.firebase-auth-api;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: classes2.dex */
final class t7 implements com.google.android.gms.internal.firebase-auth-api.r5 {
    t7(com.google.android.gms.internal.firebase-auth-api.s6 s6) {
        super();
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.r5
    public final ExecutorService e(int i) {
        LinkedBlockingQueue linkedBlockingQueue = new LinkedBlockingQueue();
        super(1, 1, 60, obj4, TimeUnit.SECONDS, linkedBlockingQueue, Executors.defaultThreadFactory());
        obj9.allowCoreThreadTimeOut(true);
        return Executors.unconfigurableExecutorService(obj9);
    }
}
