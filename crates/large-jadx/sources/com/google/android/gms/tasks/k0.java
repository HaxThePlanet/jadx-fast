package com.google.android.gms.tasks;

import android.os.Handler;
import android.os.Looper;
import f.c.a.d.b.k.a;
import java.util.concurrent.Executor;

/* loaded from: classes2.dex */
final class k0 implements Executor {

    private final Handler a;
    public k0() {
        super();
        a aVar = new a(Looper.getMainLooper());
        this.a = aVar;
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        this.a.post(runnable);
    }
}
