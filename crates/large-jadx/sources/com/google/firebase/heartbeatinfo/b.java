package com.google.firebase.heartbeatinfo;

import java.util.concurrent.Callable;

/* loaded from: classes2.dex */
public final class b implements Callable {

    public final com.google.firebase.heartbeatinfo.DefaultHeartBeatInfo a;
    public b(com.google.firebase.heartbeatinfo.DefaultHeartBeatInfo defaultHeartBeatInfo) {
        super();
        this.a = defaultHeartBeatInfo;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        return this.a.c();
    }
}
