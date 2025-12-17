package com.google.firebase.heartbeatinfo;

import java.util.concurrent.ThreadFactory;

/* loaded from: classes2.dex */
public final class a implements ThreadFactory {

    public static final com.google.firebase.heartbeatinfo.a a;
    static {
        a aVar = new a();
        a.a = aVar;
    }

    @Override // java.util.concurrent.ThreadFactory
    public final Thread newThread(Runnable runnable) {
        return DefaultHeartBeatInfo.e(runnable);
    }
}
