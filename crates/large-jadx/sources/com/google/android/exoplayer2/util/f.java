package com.google.android.exoplayer2.util;

import java.util.concurrent.ThreadFactory;

/* loaded from: classes2.dex */
public final class f implements ThreadFactory {

    public final String a;
    public f(String string) {
        super();
        this.a = string;
    }

    @Override // java.util.concurrent.ThreadFactory
    public final Thread newThread(Runnable runnable) {
        return p0.k0(this.a, runnable);
    }
}
