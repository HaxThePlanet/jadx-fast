package com.google.firebase.firestore.util;

import android.os.AsyncTask;
import com.google.android.gms.tasks.l;
import java.util.concurrent.Executor;

/* loaded from: classes2.dex */
public final class Executors {

    private static final int ASYNC_THREAD_POOL_MAXIMUM_CONCURRENCY = 4;
    public static final Executor BACKGROUND_EXECUTOR;
    public static final Executor DEFAULT_CALLBACK_EXECUTOR;
    public static final Executor DIRECT_EXECUTOR;
    static {
        Executors.DEFAULT_CALLBACK_EXECUTOR = l.a;
        Executors.DIRECT_EXECUTOR = n.a;
        ThrottledForwardingExecutor throttledForwardingExecutor = new ThrottledForwardingExecutor(4, AsyncTask.THREAD_POOL_EXECUTOR);
        Executors.BACKGROUND_EXECUTOR = throttledForwardingExecutor;
    }
}
