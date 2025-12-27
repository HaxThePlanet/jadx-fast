package com.squareup.picasso;

import android.net.NetworkInfo;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* compiled from: PicassoExecutorService.java */
/* loaded from: classes2.dex */
class v extends ThreadPoolExecutor {

    private static final class a extends FutureTask<c> implements Comparable<v.a> {

        private final c a;
        a(c cVar) {
            super(cVar, null);
            this.a = cVar;
        }

        @Override // java.util.concurrent.FutureTask
        public int a(v.a aVar) {
            int i;
            com.squareup.picasso.t.f fVar = this.a.r();
            com.squareup.picasso.t.f fVar2 = aVar.a.r();
            if (fVar == fVar2) {
                i = this.a.a - aVar.a.a;
            } else {
                i = fVar2.ordinal() - fVar.ordinal();
            }
            return i;
        }
    }
    v() {
        super(3, 3, 0L, timeUnit, TimeUnit.MILLISECONDS, new PriorityBlockingQueue(), new f0.c());
    }

    private void b(int i) {
        setCorePoolSize(i);
        setMaximumPoolSize(i);
    }

    @Override // java.util.concurrent.ThreadPoolExecutor
    void a(NetworkInfo networkInfo) {
        final int i2 = 3;
        b(i2);
    }

    @Override // java.util.concurrent.ThreadPoolExecutor
    public Future<?> submit(Runnable runnable) {
        final com.squareup.picasso.v.a aVar = new v.a(runnable);
        execute(aVar);
        return aVar;
    }
}
