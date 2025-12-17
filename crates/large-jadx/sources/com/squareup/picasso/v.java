package com.squareup.picasso;

import android.net.NetworkInfo;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: classes2.dex */
class v extends ThreadPoolExecutor {

    private static final class a extends FutureTask<com.squareup.picasso.c> implements Comparable<com.squareup.picasso.v.a> {

        private final com.squareup.picasso.c a;
        a(com.squareup.picasso.c c) {
            super(c, 0);
            this.a = c;
        }

        @Override // java.util.concurrent.FutureTask
        public int a(com.squareup.picasso.v.a v$a) {
            int i;
            int obj3;
            com.squareup.picasso.t.f fVar = this.a.r();
            com.squareup.picasso.t.f fVar2 = a.a.r();
            if (fVar == fVar2) {
                i2 -= obj3;
            } else {
                i = obj3 - ordinal;
            }
            return i;
        }

        @Override // java.util.concurrent.FutureTask
        public int compareTo(Object object) {
            return a((v.a)object);
        }
    }
    v() {
        PriorityBlockingQueue priorityBlockingQueue = new PriorityBlockingQueue();
        f0.c cVar = new f0.c();
        super(3, 3, 0, obj4, TimeUnit.MILLISECONDS, priorityBlockingQueue, cVar);
    }

    private void b(int i) {
        setCorePoolSize(i);
        setMaximumPoolSize(i);
    }

    @Override // java.util.concurrent.ThreadPoolExecutor
    void a(NetworkInfo networkInfo) {
        boolean connectedOrConnecting;
        int obj4;
        final int i2 = 3;
        if (networkInfo != 0) {
            if (!networkInfo.isConnectedOrConnecting()) {
            } else {
                int type = networkInfo.getType();
                final int i3 = 1;
                if (type != null) {
                    if (type != i3 && type != 6 && type != 9) {
                        if (type != 6) {
                            if (type != 9) {
                                b(i2);
                            } else {
                                b(4);
                            }
                        } else {
                        }
                    } else {
                    }
                } else {
                    obj4 = networkInfo.getSubtype();
                    switch (obj4) {
                        case 1:
                            b(i3);
                            break;
                        case 2:
                            b(2);
                            break;
                        default:
                            b(i2);
                            b(i2);
                            b(2);
                    }
                }
            }
        }
        b(i2);
    }

    public Future<?> submit(Runnable runnable) {
        v.a aVar = new v.a((c)runnable);
        execute(aVar);
        return aVar;
    }
}
