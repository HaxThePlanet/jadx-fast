package io.grpc.j1;

import com.google.common.base.n;
import java.util.ArrayDeque;
import java.util.concurrent.Executor;
import java.util.logging.Level;
import java.util.logging.Logger;

/* loaded from: classes3.dex */
class c2 implements Executor {

    private static final Logger c;
    private boolean a;
    private ArrayDeque<Runnable> b;
    static {
        c2.c = Logger.getLogger(c2.class.getName());
    }

    private void a() {
        Object poll;
        Throwable obj;
        Logger obj2;
        Level obj3;
        StringBuilder obj4;
        String obj5;
        poll = this.b.poll();
        while ((Runnable)poll != null) {
            (Runnable)poll.run();
            poll = this.b.poll();
        }
    }

    private void b(Runnable runnable) {
        ArrayDeque arrayDeque;
        int i;
        if (this.b == null) {
            arrayDeque = new ArrayDeque(4);
            this.b = arrayDeque;
        }
        this.b.add(runnable);
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        boolean z;
        Throwable th;
        Logger logger;
        Level sEVERE;
        StringBuilder stringBuilder;
        String str;
        ArrayDeque obj7;
        n.p(runnable, "'task' must not be null.");
        if (!this.a) {
            this.a = true;
            runnable.run();
            if (this.b != null) {
                a();
            }
            this.a = false;
        } else {
            b(runnable);
        }
    }
}
