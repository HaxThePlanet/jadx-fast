package com.google.firebase.crashlytics.internal.common;

import android.os.Process;

/* loaded from: classes2.dex */
public abstract class BackgroundPriorityRunnable implements Runnable {
    @Override // java.lang.Runnable
    protected abstract void onRun();

    @Override // java.lang.Runnable
    public final void run() {
        Process.setThreadPriority(10);
        onRun();
    }
}
