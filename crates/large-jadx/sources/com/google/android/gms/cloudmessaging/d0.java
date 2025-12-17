package com.google.android.gms.cloudmessaging;

import java.util.concurrent.Executor;

/* loaded from: classes2.dex */
public final class d0 implements Executor {

    public static final com.google.android.gms.cloudmessaging.d0 a;
    static {
        d0 d0Var = new d0();
        d0.a = d0Var;
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        runnable.run();
    }
}
