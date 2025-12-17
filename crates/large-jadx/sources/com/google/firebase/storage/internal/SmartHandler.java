package com.google.firebase.storage.internal;

import android.os.Handler;
import android.os.Looper;
import com.google.android.gms.common.internal.r;
import com.google.firebase.storage.StorageTaskScheduler;
import java.util.concurrent.Executor;

/* loaded from: classes2.dex */
public class SmartHandler {

    static boolean testMode = false;
    private final Executor executor;
    private final Handler handler;
    static {
    }

    public SmartHandler(Executor executor) {
        int mainLooper;
        boolean obj2;
        super();
        this.executor = executor;
        mainLooper = 0;
        if (executor == null) {
            if (!SmartHandler.testMode) {
                obj2 = new Handler(Looper.getMainLooper());
                this.handler = obj2;
            } else {
                this.handler = mainLooper;
            }
        } else {
            this.handler = mainLooper;
        }
    }

    public void callBack(Runnable runnable) {
        Object executor;
        r.j(runnable);
        executor = this.handler;
        if (executor == null) {
            executor = this.executor;
            if (executor != null) {
                executor.execute(runnable);
            } else {
                StorageTaskScheduler.getInstance().scheduleCallback(runnable);
            }
        } else {
            executor.post(runnable);
        }
    }
}
