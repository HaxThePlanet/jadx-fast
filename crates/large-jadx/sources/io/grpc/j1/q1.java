package io.grpc.j1;

import com.google.common.base.j;
import com.google.common.base.j.b;
import io.grpc.d;
import io.grpc.d1;
import io.grpc.h;
import io.grpc.h0;
import io.grpc.i0;
import io.grpc.q;
import io.grpc.r0;
import io.grpc.u0;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

/* compiled from: OobChannel.java */
/* loaded from: classes3.dex */
final class q1 extends r0 implements h0<Object> {

    private y0 a;
    private final i0 b;
    private final String c;
    private final a0 d;
    private final Executor e;
    private final ScheduledExecutorService f;
    private final CountDownLatch g;
    private final m h;
    private final p.e i;
    static {
        Logger.getLogger(q1.class.getName());
    }

    @Override // io.grpc.r0
    public String a() {
        return this.c;
    }

    @Override // io.grpc.r0
    public i0 f() {
        return this.b;
    }

    @Override // io.grpc.r0
    public <RequestT, ResponseT> h<RequestT, ResponseT> h(u0<RequestT, ResponseT> u0Var, d dVar) {
        Executor executor;
        if (dVar.e() == null) {
        } else {
            executor = dVar.e();
        }
        p pVar = new p(u0Var, executor, dVar, this.i, this.f, this.h, null);
        return pVar;
    }

    @Override // io.grpc.r0
    public boolean i(long j, TimeUnit timeUnit) throws java.lang.InterruptedException {
        return this.g.await(j, timeUnit);
    }

    @Override // io.grpc.r0
    public q k(boolean z) {
        if (this.a == null) {
            return q.IDLE;
        }
        return this.a.M();
    }

    @Override // io.grpc.r0
    public r0 m() {
        this.d.c(d1.n.r("OobChannel.shutdown() called"));
        return this;
    }

    @Override // io.grpc.r0
    public r0 n() {
        this.d.d(d1.n.r("OobChannel.shutdownNow() called"));
        return this;
    }

    @Override // io.grpc.r0
    y0 o() {
        return this.a;
    }

    @Override // io.grpc.r0
    public String toString() {
        j.b bVar = j.c(this);
        bVar.c("logId", this.b.d());
        bVar.d("authority", this.c);
        return bVar.toString();
    }
}
