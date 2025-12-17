package com.google.firebase.remoteconfig.internal;

import java.util.concurrent.Callable;

/* loaded from: classes2.dex */
public final class h implements Callable {

    public final com.google.firebase.remoteconfig.internal.ConfigStorageClient a;
    public h(com.google.firebase.remoteconfig.internal.ConfigStorageClient configStorageClient) {
        super();
        this.a = configStorageClient;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        return this.a.read();
    }
}
