package com.google.android.gms.measurement.internal;

import android.os.Process;
import com.google.android.gms.common.internal.r;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.FutureTask;
import java.util.concurrent.Semaphore;

/* loaded from: classes2.dex */
final class x4 extends Thread {

    private final Object a;
    private final BlockingQueue<com.google.android.gms.measurement.internal.w4<?>> b;
    private boolean c = false;
    final com.google.android.gms.measurement.internal.y4 v;
    public x4(com.google.android.gms.measurement.internal.y4 y4, String string2, BlockingQueue blockingQueue3) {
        this.v = y4;
        super();
        int obj1 = 0;
        r.j(string2);
        r.j(blockingQueue3);
        obj1 = new Object();
        this.a = obj1;
        this.b = blockingQueue3;
        setName(string2);
    }

    private final void b() {
        boolean z;
        Object o3Var;
        String str;
        Object obj = y4.q(this.v);
        synchronized (obj) {
            y4.u(this.v).release();
            y4.q(this.v).notifyAll();
            str = 0;
            if (this == y4.p(this.v)) {
                y4.x(this.v, str);
            } else {
                if (this == y4.o(this.v)) {
                    y4.w(this.v, str);
                } else {
                    y4Var6.a.b().r().a("Current scheduler thread is neither worker nor network");
                }
            }
            this.c = true;
            try {
                throw th;
            }
        }
    }

    private final void c(java.lang.InterruptedException interruptedException) {
        y4Var.a.b().w().b(String.valueOf(getName()).concat(" was interrupted"), interruptedException);
    }

    @Override // java.lang.Thread
    public final void a() {
        final Object obj = this.a;
        this.a.notifyAll();
        return;
        synchronized (obj) {
            obj = this.a;
            this.a.notifyAll();
        }
    }

    @Override // java.lang.Thread
    public final void run() {
        int i;
        Object poll;
        Throwable peek2;
        Object peek;
        int i2;
        int i3 = 1;
        i = 0;
        while (i == 0) {
            y4.u(this.v).acquire();
            i = i3;
        }
        try {
            poll = this.b.poll();
            if (i3 != poll.b) {
            } else {
            }
            peek2 = 10;
            peek2 = threadPriority;
            Process.setThreadPriority(peek2);
            (w4)poll.run();
            Object obj = this.a;
            if (this.b.peek() == null) {
            }
            y4.B(this.v);
            this.a.wait(30000);
            c(peek2);
        } catch (Throwable th) {
        }
        poll = y4.q(this.v);
        synchronized (poll) {
            poll = y4.q(this.v);
        }
        if (y4Var.a.z().B(0, c3.k0)) {
            b();
        }
        b();
    }
}
