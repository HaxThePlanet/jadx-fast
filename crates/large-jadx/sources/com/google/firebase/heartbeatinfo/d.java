package com.google.firebase.heartbeatinfo;

import java.util.concurrent.Callable;

/* loaded from: classes2.dex */
public final class d implements Callable {

    public final com.google.firebase.heartbeatinfo.DefaultHeartBeatInfo a;
    public final String b;
    public d(com.google.firebase.heartbeatinfo.DefaultHeartBeatInfo defaultHeartBeatInfo, String string2) {
        super();
        this.a = defaultHeartBeatInfo;
        this.b = string2;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        return this.a.g(this.b);
    }
}
