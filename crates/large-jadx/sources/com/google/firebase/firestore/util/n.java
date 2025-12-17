package com.google.firebase.firestore.util;

import java.util.concurrent.Executor;

/* loaded from: classes2.dex */
public final class n implements Executor {

    public static final com.google.firebase.firestore.util.n a;
    static {
        n nVar = new n();
        n.a = nVar;
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        runnable.run();
    }
}
