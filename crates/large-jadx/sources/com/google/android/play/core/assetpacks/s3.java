package com.google.android.play.core.assetpacks;

import java.util.concurrent.ThreadFactory;

/* loaded from: classes2.dex */
public final class s3 implements ThreadFactory {

    public static final com.google.android.play.core.assetpacks.s3 a;
    static {
        s3 s3Var = new s3();
        s3.a = s3Var;
    }

    @Override // java.util.concurrent.ThreadFactory
    public final Thread newThread(Runnable runnable) {
        Thread thread = new Thread(runnable, "AssetPackBackgroundExecutor");
        return thread;
    }
}
