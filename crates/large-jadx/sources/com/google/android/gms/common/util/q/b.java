package com.google.android.gms.common.util.q;

import android.os.Process;

/* loaded from: classes2.dex */
final class b implements Runnable {

    private final Runnable a;
    public b(Runnable runnable, int i2) {
        super();
        this.a = runnable;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Process.setThreadPriority(0);
        this.a.run();
    }
}
