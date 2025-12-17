package io.grpc.j1;

import com.google.common.base.j;
import com.google.common.base.n;
import io.grpc.c;
import io.grpc.d;
import io.grpc.d1;
import io.grpc.g;
import io.grpc.l;
import io.grpc.n;
import io.grpc.t0;
import io.grpc.u0;
import java.net.SocketAddress;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes3.dex */
final class l implements io.grpc.j1.t {

    private final io.grpc.j1.t a;
    private final c b;
    private final Executor c;

    private class a extends io.grpc.j1.k0 {

        private final io.grpc.j1.v a;
        private final AtomicInteger b;
        private volatile d1 c;
        private d1 d;
        private d1 e;
        private final io.grpc.j1.n1.a f;
        final io.grpc.j1.l g;
        a(io.grpc.j1.l l, io.grpc.j1.v v2, String string3) {
            this.g = l;
            super();
            AtomicInteger obj2 = new AtomicInteger(-2147483647);
            this.b = obj2;
            obj2 = new l.a.a(this);
            this.f = obj2;
            n.p(v2, "delegate");
            this.a = (v)v2;
            n.p(string3, "authority");
        }

        static AtomicInteger h(io.grpc.j1.l.a l$a) {
            return a.b;
        }

        static void i(io.grpc.j1.l.a l$a) {
            a.j();
        }

        private void j() {
            synchronized (this) {
                try {
                    d1 d1Var = this.d;
                    final d1 d1Var2 = this.e;
                    final int i2 = 0;
                    this.d = i2;
                    this.e = i2;
                    if (d1Var != null) {
                    }
                    super.c(d1Var);
                    if (d1Var2 != null) {
                    }
                    super.d(d1Var2);
                    throw th;
                }
            }
        }

        @Override // io.grpc.j1.k0
        protected io.grpc.j1.v a() {
            return this.a;
        }

        public io.grpc.j1.q b(u0<?, ?> u0, t0 t02, d d3, l[] l4Arr4) {
            Object cVar2;
            Object nVar;
            c cVar;
            Object obj10;
            io.grpc.j1.l.a.b obj11;
            Executor obj12;
            cVar2 = d3.c();
            if (cVar2 == null) {
                cVar2 = l.a(this.g);
            } else {
                if (l.a(this.g) != null) {
                    nVar = new n(l.a(this.g), cVar2);
                    cVar2 = nVar;
                }
            }
            super(this.a, u0, t02, d3, this.f, l4Arr4);
            if (cVar2 != null && this.b.incrementAndGet() > 0) {
                super(this.a, u0, t02, d3, this.f, l4Arr4);
                if (this.b.incrementAndGet() > 0) {
                    this.f.onComplete();
                    obj10 = new f0(this.c, l4Arr4);
                    return obj10;
                }
                obj11 = new l.a.b(this, u0, d3);
                cVar2.applyRequestMetadata(obj11, (Executor)j.a(d3.e(), l.c(this.g)), n1Var2);
                return n1Var2.d();
            }
            if (this.b.get() >= 0) {
                obj10 = new f0(this.c, l4Arr4);
                return obj10;
            }
            return this.a.b(u0, t02, d3, l4Arr4);
        }

        @Override // io.grpc.j1.k0
        public void c(d1 d1) {
            n.p(d1, "status");
            synchronized (this) {
                this.c = d1;
                this.b.addAndGet(Integer.MAX_VALUE);
                if (this.b.get() != 0) {
                    this.d = d1;
                }
                super.c(d1);
            }
        }

        @Override // io.grpc.j1.k0
        public void d(d1 d1) {
            Object num;
            int i;
            n.p(d1, "status");
            synchronized (this) {
                this.c = d1;
                this.b.addAndGet(Integer.MAX_VALUE);
                if (this.b.get() != 0) {
                    this.e = d1;
                }
                try {
                    super.d(d1);
                    throw d1;
                }
            }
        }
    }
    l(io.grpc.j1.t t, c c2, Executor executor3) {
        super();
        n.p(t, "delegate");
        this.a = (t)t;
        this.b = c2;
        n.p(executor3, "appExecutor");
        this.c = (Executor)executor3;
    }

    static c a(io.grpc.j1.l l) {
        return l.b;
    }

    static Executor c(io.grpc.j1.l l) {
        return l.c;
    }

    @Override // io.grpc.j1.t
    public ScheduledExecutorService K1() {
        return this.a.K1();
    }

    @Override // io.grpc.j1.t
    public io.grpc.j1.v S0(SocketAddress socketAddress, io.grpc.j1.t.a t$a2, g g3) {
        l.a aVar = new l.a(this, this.a.S0(socketAddress, a2, g3), a2.a());
        return aVar;
    }

    @Override // io.grpc.j1.t
    public void close() {
        this.a.close();
    }
}
