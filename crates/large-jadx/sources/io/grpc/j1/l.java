package io.grpc.j1;

import com.google.common.base.j;
import io.grpc.c;
import io.grpc.d;
import io.grpc.d1;
import io.grpc.g;
import io.grpc.l;
import io.grpc.t0;
import io.grpc.u0;
import java.net.SocketAddress;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: CallCredentialsApplyingTransportFactory.java */
/* loaded from: classes3.dex */
final class l implements t {

    private final t a;
    private final c b;
    private final Executor c;

    private class a extends k0 {

        private final v a;
        private final AtomicInteger b = new AtomicInteger(-2147483647);
        private volatile d1 c;
        private d1 d;
        private d1 e;
        private final n1.a f = new l$a$a();
        final /* synthetic */ l g;
        a(v vVar, String str) {
            this.g = lVar;
            super();
            AtomicInteger atomicInteger = new AtomicInteger(-2147483647);
            io.grpc.j1.l.a.a aVar = new l.a.a(this);
            n.p(vVar, "delegate");
            this.a = vVar;
            n.p(str, "authority");
        }

        static /* synthetic */ AtomicInteger h(l.a aVar) {
            return aVar.b;
        }

        static /* synthetic */ void i(l.a aVar) {
            aVar.j();
        }

        private void j() {
            synchronized (this) {
                try {
                    if (this.b.get() != 0) {
                        return;
                    }
                } catch (Throwable th) {
                }
            }
            if (this.b != null) {
                super.c(d1Var);
            }
            if (d1Var2 != null) {
                super.d(d1Var2);
            }
        }

        @Override // io.grpc.j1.k0
        protected v a() {
            return this.a;
        }

        @Override // io.grpc.j1.k0
        public q b(u0<?, ?> u0Var, t0 t0Var, d dVar, l[] lVarArr) {
            c cVar;
            cVar = dVar.c();
            if (cVar == null) {
                cVar = this.g.b;
            } else {
                if (this.g.b != null) {
                }
            }
            if (this.g != null) {
                n1 n1Var = new n1(this.a, u0Var, t0Var, dVar, this.f, lVarArr);
                if (this.b.incrementAndGet() > 0) {
                    this.f.onComplete();
                    return new f0(this.c, lVarArr);
                }
                try {
                    cVar.applyRequestMetadata(new l.a.b(this, u0Var, dVar), (Executor)j.a(dVar.e(), this.g.c), n1Var);
                } catch (Throwable th) {
                    t0Var = d1.k;
                    dVar = "Credentials should use fail() instead of throwing exceptions";
                    t0Var = t0Var.r(dVar);
                    th = t0Var.q(th);
                    obj2.b(th);
                }
                return n1Var.d();
            }
            if (this.b.get() >= 0) {
                return new f0(this.c, lVarArr);
            }
            return this.a.b(th, t0Var, dVar, lVarArr);
        }

        @Override // io.grpc.j1.k0
        public void c(d1 d1Var) {
            n.p(d1Var, "status");
            synchronized (this) {
                try {
                    this.c = d1Var;
                    this.b.addAndGet(Integer.MAX_VALUE);
                    if (this.b.get() != 0) {
                        this.d = d1Var;
                        return;
                    }
                } catch (Throwable unused) {
                }
                try {
                    return;
                } catch (Throwable th) {
                }
                /* Dexterity WARN: Type inference failed for thrown value */
                throw (Throwable) th;
            }
            super.c(th);
        }

        @Override // io.grpc.j1.k0
        public void d(d1 d1Var) {
            n.p(d1Var, "status");
            synchronized (this) {
                try {
                    if (this.b.get() >= 0) {
                        if (this.e != null) {
                            return;
                        }
                    } else {
                        this.c = d1Var;
                        int i = Integer.MAX_VALUE;
                        this.b.addAndGet(i);
                    }
                    if (this.b.get() != 0) {
                        this.e = d1Var;
                        return;
                    }
                } catch (Throwable th) {
                }
            }
            super.d(th);
        }
    }
    l(t tVar, c cVar, Executor executor) {
        super();
        n.p(tVar, "delegate");
        this.a = tVar;
        this.b = cVar;
        n.p(executor, "appExecutor");
        this.c = executor;
    }

    static /* synthetic */ c a(l lVar) {
        return lVar.b;
    }

    static /* synthetic */ Executor c(l lVar) {
        return lVar.c;
    }

    public ScheduledExecutorService K1() {
        return this.a.K1();
    }

    public v S0(SocketAddress socketAddress, t.a aVar, g gVar) {
        return new l.a(this, this.a.S0(socketAddress, aVar, gVar), aVar.a());
    }

    public void close() {
        this.a.close();
    }
}
