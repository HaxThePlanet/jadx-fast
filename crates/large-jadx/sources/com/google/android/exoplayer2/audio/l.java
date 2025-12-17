package com.google.android.exoplayer2.audio;

import android.os.Handler;
import java.util.concurrent.Executor;

/* loaded from: classes2.dex */
public final class l implements Executor {

    public final Handler a;
    public l(Handler handler) {
        super();
        this.a = handler;
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        this.a.post(runnable);
    }
}
