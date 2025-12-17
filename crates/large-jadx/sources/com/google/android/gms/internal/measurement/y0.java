package com.google.android.gms.internal.measurement;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: classes2.dex */
final class y0 implements com.google.android.gms.internal.measurement.w0 {
    y0(com.google.android.gms.internal.measurement.x0 x0) {
        super();
    }

    public static final ExecutorService b(int i, ThreadFactory threadFactory2, int i3) {
        LinkedBlockingQueue linkedBlockingQueue = new LinkedBlockingQueue();
        super(1, 1, 60, obj4, TimeUnit.SECONDS, linkedBlockingQueue, threadFactory2);
        obj8.allowCoreThreadTimeOut(true);
        return Executors.unconfigurableExecutorService(obj8);
    }

    @Override // com.google.android.gms.internal.measurement.w0
    public final ExecutorService a(ThreadFactory threadFactory, int i2) {
        final int obj2 = 1;
        return y0.b(obj2, threadFactory, obj2);
    }
}
