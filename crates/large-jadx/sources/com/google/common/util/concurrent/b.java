package com.google.common.util.concurrent;

import java.util.concurrent.Executor;

/* loaded from: classes2.dex */
enum b implements Executor {

    INSTANCE;
    private static com.google.common.util.concurrent.b[] $values() {
        com.google.common.util.concurrent.b[] arr = new b[1];
        return arr;
    }

    @Override // java.lang.Enum
    public void execute(Runnable runnable) {
        runnable.run();
    }

    @Override // java.lang.Enum
    public String toString() {
        return "MoreExecutors.directExecutor()";
    }
}
