package io.grpc.j1;

import com.google.common.base.n;
import io.grpc.c.a;
import io.grpc.d;
import io.grpc.d1;
import io.grpc.l;
import io.grpc.s;
import io.grpc.t0;
import io.grpc.u0;

/* loaded from: classes3.dex */
final class n1 extends c.a {

    private final io.grpc.j1.s a;
    private final u0<?, ?> b;
    private final t0 c;
    private final d d;
    private final s e;
    private final io.grpc.j1.n1.a f;
    private final l[] g;
    private final Object h;
    private io.grpc.j1.q i;
    boolean j;
    io.grpc.j1.b0 k;

    public interface a {
        public abstract void onComplete();
    }
    n1(io.grpc.j1.s s, u0<?, ?> u02, t0 t03, d d4, io.grpc.j1.n1.a n1$a5, l[] l6Arr6) {
        super();
        Object object = new Object();
        this.h = object;
        this.a = s;
        this.b = u02;
        this.c = t03;
        this.d = d4;
        this.e = s.i();
        this.f = a5;
        this.g = l6Arr6;
    }

    private void c(io.grpc.j1.q q) {
        int i2;
        int i;
        i2 = 1;
        n.v(z ^= i2, "already finalized");
        this.j = i2;
        Object obj = this.h;
        final int i4 = 0;
        synchronized (obj) {
            this.i = q;
            i = i2;
            if (i != 0) {
            }
            if (this.k != null) {
            } else {
                i2 = i4;
            }
            n.v(i2, "delayedStream is null");
            Runnable obj5 = this.k.x(q);
            if (obj5 != null) {
                obj5.run();
            }
            this.f.onComplete();
        }
        this.f.onComplete();
    }

    @Override // io.grpc.c$a
    public void a(t0 t0) {
        n.v(z ^= 1, "apply() or fail() already called");
        n.p(t0, "headers");
        this.c.l(t0);
        this.e.j(this.e.c());
        c(this.a.b(this.b, this.c, this.d, this.g));
    }

    @Override // io.grpc.c$a
    public void b(d1 d1) {
        n.e(z ^= 1, "Cannot fail with OK status");
        n.v(z2 ^= 1, "apply() or fail() already called");
        f0 f0Var = new f0(d1, this.g);
        c(f0Var);
    }

    @Override // io.grpc.c$a
    io.grpc.j1.q d() {
        final Object obj = this.h;
        io.grpc.j1.q qVar = this.i;
        synchronized (obj) {
            b0 b0Var = new b0();
            this.k = b0Var;
            this.i = b0Var;
            return b0Var;
        }
    }
}
