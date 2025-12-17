package com.google.firebase.database.core;

import java.util.concurrent.ScheduledFuture;

/* loaded from: classes2.dex */
public interface RunLoop {
    public abstract void restart();

    public abstract ScheduledFuture schedule(Runnable runnable, long l2);

    public abstract void scheduleNow(Runnable runnable);

    public abstract void shutdown();
}
