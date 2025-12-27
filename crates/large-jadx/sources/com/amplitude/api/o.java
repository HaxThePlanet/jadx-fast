package com.amplitude.api;

import android.os.Handler;
import android.os.HandlerThread;

/* compiled from: WorkerThread.java */
/* loaded from: classes.dex */
public class o extends HandlerThread {

    private Handler a;
    public o(String str) {
        super(str, 10);
    }

    private synchronized void c() {
        if (this.a == null) {
            this.a = new Handler(getLooper());
        }
    }

    @Override // android.os.HandlerThread
    void a(Runnable runnable) {
        c();
        this.a.post(runnable);
    }

    @Override // android.os.HandlerThread
    void b(Runnable runnable, long j) {
        c();
        this.a.postDelayed(runnable, j);
    }
}
