package com.google.android.play.core.assetpacks;

import java.util.concurrent.ThreadFactory;

/* loaded from: classes2.dex */
public final class t3 implements ThreadFactory {

    public static final com.google.android.play.core.assetpacks.t3 a;
    static {
        t3 t3Var = new t3();
        t3.a = t3Var;
    }

    @Override // java.util.concurrent.ThreadFactory
    public final Thread newThread(Runnable runnable) {
        Thread thread = new Thread(runnable, "UpdateListenerExecutor");
        return thread;
    }
}
