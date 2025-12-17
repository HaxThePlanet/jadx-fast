package com.appsflyer.internal;

import com.appsflyer.AFLogger;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
public final class k {

    public static com.appsflyer.internal.k AFKeystoreWrapper;
    ScheduledExecutorService AFInAppEventParameterName;
    ScheduledExecutorService AFInAppEventType;
    Executor valueOf;
    final ThreadFactory values;
    public k() {
        super();
        k.4 anon = new k.4();
        this.values = anon;
    }

    static void AFInAppEventType(ExecutorService executorService) {
        Throwable terminated;
        TimeUnit terminated2;
        AFLogger.AFKeystoreWrapper("shut downing executor ...");
        executorService.shutdown();
        executorService.awaitTermination(10, terminated2);
        if (!executorService.isTerminated()) {
            AFLogger.AFKeystoreWrapper("killing non-finished tasks");
        }
        try {
            executorService.shutdownNow();
            terminated = "InterruptedException!!!";
            AFLogger.AFKeystoreWrapper(terminated);
            terminated = executorService.isTerminated();
            if (terminated == null) {
            }
            AFLogger.AFKeystoreWrapper(obj0);
            executorService.shutdownNow();
            terminated2 = executorService.isTerminated();
            if (terminated2 != null) {
            } else {
            }
            AFLogger.AFKeystoreWrapper(obj0);
            executorService.shutdownNow();
            throw terminated;
        } catch (Throwable th) {
        }
    }

    public final ScheduledThreadPoolExecutor AFInAppEventParameterName() {
        int scheduledThreadPool;
        ScheduledExecutorService aFInAppEventParameterName;
        ThreadFactory values;
        aFInAppEventParameterName = this.AFInAppEventParameterName;
        if (aFInAppEventParameterName != null && !aFInAppEventParameterName.isShutdown()) {
            if (!aFInAppEventParameterName.isShutdown()) {
                if (this.AFInAppEventParameterName.isTerminated()) {
                    scheduledThreadPool = 1;
                } else {
                    scheduledThreadPool = 0;
                }
            } else {
            }
        } else {
        }
        if (scheduledThreadPool != 0) {
            this.AFInAppEventParameterName = Executors.newScheduledThreadPool(2, this.values);
        }
        return (ScheduledThreadPoolExecutor)this.AFInAppEventParameterName;
    }

    public final Executor AFKeystoreWrapper() {
        Executor valueOf;
        int fixedThreadPool;
        boolean values;
        valueOf = this.valueOf;
        if (valueOf != null) {
            if (valueOf instanceof ThreadPoolExecutor) {
                if (!(ThreadPoolExecutor)valueOf.isShutdown() && !(ThreadPoolExecutor)this.valueOf.isTerminated()) {
                    if (!(ThreadPoolExecutor)this.valueOf.isTerminated()) {
                        if ((ThreadPoolExecutor)this.valueOf.isTerminating()) {
                            fixedThreadPool = 1;
                        } else {
                            fixedThreadPool = 0;
                        }
                    } else {
                    }
                } else {
                }
            } else {
            }
        } else {
        }
        if (fixedThreadPool != 0) {
            this.valueOf = Executors.newFixedThreadPool(2, this.values);
        }
        return this.valueOf;
    }
}
