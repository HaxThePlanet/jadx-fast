package com.google.firebase.messaging;

import com.google.android.gms.common.util.q.a;
import f.c.a.d.b.h.i;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: classes2.dex */
class FcmExecutors {
    static ScheduledExecutorService newInitExecutor() {
        a aVar = new a("Firebase-Messaging-Init");
        ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = new ScheduledThreadPoolExecutor(1, aVar);
        return scheduledThreadPoolExecutor;
    }

    static ExecutorService newIntentHandleExecutor() {
        i.a();
        a aVar = new a("Firebase-Messaging-Intent-Handle");
        LinkedBlockingQueue linkedBlockingQueue = new LinkedBlockingQueue();
        super(1, 1, 60, obj4, TimeUnit.SECONDS, linkedBlockingQueue, aVar);
        threadPoolExecutor2.allowCoreThreadTimeOut(true);
        return Executors.unconfigurableExecutorService(threadPoolExecutor2);
    }

    static ExecutorService newNetworkIOExecutor() {
        a aVar = new a("Firebase-Messaging-Network-Io");
        return Executors.newSingleThreadExecutor(aVar);
    }

    static ExecutorService newTaskExecutor() {
        a aVar = new a("Firebase-Messaging-Task");
        return Executors.newSingleThreadExecutor(aVar);
    }

    static ScheduledExecutorService newTopicsSyncExecutor() {
        a aVar = new a("Firebase-Messaging-Topics-Io");
        ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = new ScheduledThreadPoolExecutor(1, aVar);
        return scheduledThreadPoolExecutor;
    }
}
