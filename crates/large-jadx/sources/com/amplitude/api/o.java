package com.amplitude.api;

import android.os.Handler;
import android.os.HandlerThread;

/* loaded from: classes.dex */
public class o extends HandlerThread {

    private Handler a;
    public o(String string) {
        super(string, 10);
    }

    private void c() {
        Handler handler;
        android.os.Looper looper;
        synchronized (this) {
            try {
                handler = new Handler(getLooper());
                this.a = handler;
                throw th;
            }
        }
    }

    @Override // android.os.HandlerThread
    void a(Runnable runnable) {
        c();
        this.a.post(runnable);
    }

    @Override // android.os.HandlerThread
    void b(Runnable runnable, long l2) {
        c();
        this.a.postDelayed(runnable, l2);
    }
}
