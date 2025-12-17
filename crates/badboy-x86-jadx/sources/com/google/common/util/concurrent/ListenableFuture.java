package com.google.common.util.concurrent;

import java.util.concurrent.Executor;
import java.util.concurrent.Future;

/* loaded from: classes5.dex */
public interface ListenableFuture<V>  extends Future<V> {
    @Override // java.util.concurrent.Future
    public abstract void addListener(Runnable runnable, Executor executor2);
}
