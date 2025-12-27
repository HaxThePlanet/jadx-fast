package io.grpc.j1;

import com.google.common.base.n;
import java.util.ArrayDeque;
import java.util.concurrent.Executor;
import java.util.logging.Level;
import java.util.logging.Logger;

/* compiled from: SerializeReentrantCallsDirectExecutor.java */
/* loaded from: classes3.dex */
class c2 implements Executor {

    private static final Logger c;
    private boolean a;
    private ArrayDeque<Runnable> b;
    static {
        c2.c = Logger.getLogger(c2.class.getName());
    }

    c2() {
        super();
    }

    private void a() {
        Throwable obj;
        Logger obj2;
        Level obj3;
        StringBuilder obj4;
        String obj5;
        Object poll = this.b.poll();
        while (poll != null) {
            try {
                poll.run();
            } catch (Throwable th) {
                StringBuilder stringBuilder = new StringBuilder();
                String str2 = "Exception while executing runnable ";
                str = str2 + str;
                c2.c.log(Level.SEVERE, str, th);
            }
            poll = this.b.poll();
        }
    }

    private void b(Runnable runnable) {
        if (this.b == null) {
            int i = 4;
            this.b = new ArrayDeque(i);
        }
        this.b.add(runnable);
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        Throwable th;
        ArrayDeque arrayDeque;
        n.p(runnable, "'task' must not be null.");
        if (!this.a) {
            this.a = true;
            boolean z = false;
            try {
                runnable.run();
            } catch (Throwable th) {
            }
            if (this.b != null) {
                a();
            }
            this.a = z;
        } else {
            b(th);
        }
    }
}
