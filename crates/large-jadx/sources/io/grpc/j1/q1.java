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

/* loaded from: classes3.dex */
final class q1 extends r0 implements h0<Object> {

    private io.grpc.j1.y0 a;
    private final i0 b;
    private final String c;
    private final io.grpc.j1.a0 d;
    private final Executor e;
    private final ScheduledExecutorService f;
    private final CountDownLatch g;
    private final io.grpc.j1.m h;
    private final io.grpc.j1.p.e i;
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

    public <RequestT, ResponseT> h<RequestT, ResponseT> h(u0<RequestT, ResponseT> u0, d d2) {
        Executor executor;
        if (d2.e() == null) {
            executor = this.e;
        } else {
            executor = d2.e();
        }
        super(u0, executor, d2, this.i, this.f, this.h, 0);
        return pVar2;
    }

    @Override // io.grpc.r0
    public boolean i(long l, TimeUnit timeUnit2) {
        return this.g.await(l, timeUnit2);
    }

    @Override // io.grpc.r0
    public q k(boolean z) {
        io.grpc.j1.y0 obj1 = this.a;
        if (obj1 == null) {
            return q.IDLE;
        }
        return obj1.M();
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
    io.grpc.j1.y0 o() {
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
