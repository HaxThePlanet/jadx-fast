package io.grpc.j1;

import com.google.common.base.n;
import io.grpc.q;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.Executor;

/* loaded from: classes3.dex */
final class w {

    private ArrayList<io.grpc.j1.w.a> a;
    private volatile q b;

    private static final class a {

        final Runnable a;
        final Executor b;
        a(Runnable runnable, Executor executor2) {
            super();
            this.a = runnable;
            this.b = executor2;
        }

        void a() {
            this.b.execute(this.a);
        }
    }
    w() {
        super();
        ArrayList arrayList = new ArrayList();
        this.a = arrayList;
        this.b = q.IDLE;
    }

    q a() {
        q qVar = this.b;
        if (qVar == null) {
        } else {
            return qVar;
        }
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Channel state API is not implemented");
        throw unsupportedOperationException;
    }

    void b(q q) {
        q next;
        ArrayList arrayList;
        q sHUTDOWN;
        Object obj3;
        n.p(q, "newState");
        this.b = q;
        if (this.b != q && this.b != q.SHUTDOWN && this.a.isEmpty()) {
            if (this.b != q.SHUTDOWN) {
                this.b = q;
                if (this.a.isEmpty()) {
                }
                arrayList = new ArrayList();
                this.a = arrayList;
                obj3 = this.a.iterator();
                for (w.a arrayList : obj3) {
                    arrayList.a();
                }
            }
        }
    }

    void c(Runnable runnable, Executor executor2, q q3) {
        Object obj2;
        n.p(runnable, "callback");
        n.p(executor2, "executor");
        n.p(q3, "source");
        w.a aVar = new w.a(runnable, executor2);
        if (this.b != q3) {
            aVar.a();
        } else {
            this.a.add(aVar);
        }
    }
}
