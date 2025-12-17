package com.google.android.gms.common.api.internal;

import android.os.Handler;
import java.util.concurrent.Executor;

/* loaded from: classes2.dex */
final class c0 implements Executor {

    private final Handler a;
    private c0(Handler handler) {
        super();
        this.a = handler;
    }

    static Executor a(Handler handler) {
        c0 c0Var = new c0(handler);
        return c0Var;
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        this.a.post(runnable);
    }
}
