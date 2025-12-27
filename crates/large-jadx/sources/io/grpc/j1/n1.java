package io.grpc.j1;

import com.google.common.base.n;
import io.grpc.c.a;
import io.grpc.d;
import io.grpc.d1;
import io.grpc.l;
import io.grpc.s;
import io.grpc.t0;
import io.grpc.u0;

/* compiled from: MetadataApplierImpl.java */
/* loaded from: classes3.dex */
final class n1 extends c.a {

    private final s a;
    private final u0<?, ?> b;
    private final t0 c;
    private final d d;
    private final s e;
    private final n1.a f;
    private final l[] g;
    private final Object h = new Object();
    private q i;
    boolean j;
    b0 k;

    public interface a {
        void onComplete();
    }
    n1(s sVar, u0<?, ?> u0Var, t0 t0Var, d dVar, n1.a aVar, l[] lVarArr) {
        super();
        final Object object = new Object();
        this.a = sVar;
        this.b = u0Var;
        this.c = t0Var;
        this.d = dVar;
        this.e = s.i();
        this.f = aVar;
        this.g = lVarArr;
    }

    private void c(q qVar) {
        boolean z = true;
        int i;
        z = true;
        n.v(this.j ^ z, "already finalized");
        this.j = z;
        synchronized (obj2) {
            try {
                i = 0;
                z = this.i == null ? z : i;
            } catch (Throwable th) {
            }
        }
        if (this.i != 0) {
            this.f.onComplete();
            return;
        }
        if (this.k == null) {
        }
        n.v(z, "delayedStream is null");
        Runnable runnable = this.k.x(th);
        if (runnable != null) {
            runnable.run();
        }
        this.f.onComplete();
    }

    @Override // io.grpc.c$a
    public void a(t0 t0Var) {
        n.v(!this.j, "apply() or fail() already called");
        n.p(t0Var, "headers");
        this.c.l(t0Var);
        try {
        } finally {
            this.e.j(t0Var);
            throw th;
        }
        this.e.j(this.e.c());
        c(this.a.b(this.b, this.c, this.d, this.g));
    }

    @Override // io.grpc.c$a
    public void b(d1 d1Var) {
        n.e(!d1Var.p(), "Cannot fail with OK status");
        n.v(!this.j, "apply() or fail() already called");
        c(new f0(d1Var, this.g));
    }

    @Override // io.grpc.c$a
    q d() {
        synchronized (obj2) {
            try {
                if (this.i == null) {
                    io.grpc.j1.b0 b0Var = new b0();
                    this.k = b0Var;
                    this.i = b0Var;
                    return b0Var;
                }
            } catch (Throwable th) {
            }
            throw th;
        }
    }
}
