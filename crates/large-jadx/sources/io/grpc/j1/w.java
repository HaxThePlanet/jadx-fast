package io.grpc.j1;

import com.google.common.base.n;
import io.grpc.q;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.Executor;

/* compiled from: ConnectivityStateManager.java */
/* loaded from: classes3.dex */
final class w {

    private ArrayList<w.a> a = new ArrayList<>();
    private volatile q b;

    private static final class a {

        final Runnable a;
        final Executor b;
        a(Runnable runnable, Executor executor) {
            super();
            this.a = runnable;
            this.b = executor;
        }

        void a() {
            this.b.execute(this.a);
        }
    }
    w() {
        super();
        ArrayList arrayList = new ArrayList();
        this.b = q.IDLE;
    }

    q a() {
        if (this.b == null) {
            throw new UnsupportedOperationException("Channel state API is not implemented");
        } else {
            return this.b;
        }
    }

    void b(q qVar) {
        n.p(qVar, "newState");
        if (this.b != qVar) {
            if (this.b != q.SHUTDOWN) {
                this.b = qVar;
                if (this.a.isEmpty()) {
                    return;
                }
                this.a = new ArrayList();
                Iterator it = this.a.iterator();
                while (it.hasNext()) {
                    (w.a)it.next().a();
                }
            }
        }
    }

    void c(Runnable runnable, Executor executor, q qVar) {
        n.p(runnable, "callback");
        n.p(executor, "executor");
        n.p(qVar, "source");
        io.grpc.j1.w.a aVar = new w.a(runnable, executor);
        if (this.b != qVar) {
            aVar.a();
        } else {
            this.a.add(aVar);
        }
    }
}
