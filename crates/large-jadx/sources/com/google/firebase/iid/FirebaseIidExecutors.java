package com.google.firebase.iid;

import com.google.android.gms.common.util.q.a;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: classes2.dex */
class FirebaseIidExecutors {

    private static final Executor DIRECT_EXECUTOR;
    static {
        FirebaseIidExecutors.DIRECT_EXECUTOR = FirebaseIidExecutors$$Lambda.0.$instance;
    }

    static Executor directExecutor() {
        return FirebaseIidExecutors.DIRECT_EXECUTOR;
    }

    static ExecutorService newCachedSingleThreadExecutor() {
        LinkedBlockingQueue linkedBlockingQueue = new LinkedBlockingQueue();
        a aVar = new a("firebase-iid-executor");
        super(0, 1, 30, obj4, TimeUnit.SECONDS, linkedBlockingQueue, aVar);
        return threadPoolExecutor2;
    }
}
