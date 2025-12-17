package com.google.firebase.remoteconfig.internal;

import java.util.concurrent.Executor;

/* loaded from: classes2.dex */
public final class i implements Executor {

    public static final com.google.firebase.remoteconfig.internal.i a;
    static {
        i iVar = new i();
        i.a = iVar;
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        runnable.run();
    }
}
