package io.grpc;

import com.google.common.base.n;
import java.util.concurrent.Executor;

/* compiled from: CompositeCallCredentials.java */
/* loaded from: classes2.dex */
public final class n extends c {

    private final c a;
    private final c b;

    private static final class a extends c.a {

        private final c.a a;
        private final t0 b;
        public a(c.a aVar, t0 t0Var) {
            super();
            this.a = aVar;
            this.b = t0Var;
        }

        @Override // io.grpc.c$a
        public void a(t0 t0Var) {
            n.p(t0Var, "headers");
            io.grpc.t0 t0Var2 = new t0();
            t0Var2.l(this.b);
            t0Var2.l(t0Var);
            this.a.a(t0Var2);
        }

        @Override // io.grpc.c$a
        public void b(d1 d1Var) {
            this.a.b(d1Var);
        }
    }

    private final class b extends c.a {

        private final c.b a;
        private final Executor b;
        private final c.a c;
        private final s d;
        final /* synthetic */ n e;
        public b(c.b bVar, Executor executor, c.a aVar, s sVar) {
            this.e = nVar;
            super();
            this.a = bVar;
            this.b = executor;
            n.p(aVar, "delegate");
            this.c = aVar;
            n.p(sVar, "context");
            this.d = sVar;
        }

        @Override // io.grpc.c$a
        public void a(t0 t0Var) {
            n.p(t0Var, "headers");
            try {
                this.e.b.applyRequestMetadata(this.a, this.b, new n.a(this.c, t0Var));
            } finally {
                this.d.j(sVar);
                /* Dexterity WARN: Type inference failed for thrown value */
                throw (Throwable) t0Var;
            }
            this.d.j(this.d.c());
        }

        @Override // io.grpc.c$a
        public void b(d1 d1Var) {
            this.c.b(d1Var);
        }
    }
    public n(c cVar, c cVar2) {
        super();
        n.p(cVar, "creds1");
        this.a = cVar;
        n.p(cVar2, "creds2");
        this.b = cVar2;
    }

    static /* synthetic */ c a(n nVar) {
        return nVar.b;
    }

    @Override // io.grpc.c
    public void applyRequestMetadata(c.b bVar, Executor executor, c.a aVar) {
        n.b bVar2 = new n.b(this, bVar, executor, aVar, s.i());
        this.a.applyRequestMetadata(bVar, executor, bVar2);
    }

    @Override // io.grpc.c
    public void thisUsesUnstableApi() {
    }
}
