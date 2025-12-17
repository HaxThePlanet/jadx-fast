package com.google.android.play.core.assetpacks;

import com.google.android.play.core.internal.q1;
import com.google.android.play.core.internal.r1;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/* loaded from: classes2.dex */
public final class w3 implements r1<Executor> {
    @Override // com.google.android.play.core.internal.r1
    public final Object zza() {
        java.util.concurrent.ExecutorService singleThreadExecutor = Executors.newSingleThreadExecutor(s3.a);
        q1.a(singleThreadExecutor);
        return singleThreadExecutor;
    }
}
