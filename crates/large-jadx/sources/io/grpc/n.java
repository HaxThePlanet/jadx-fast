package io.grpc;

import com.google.common.base.n;
import java.util.concurrent.Executor;

/* loaded from: classes2.dex */
public final class n extends io.grpc.c {

    private final io.grpc.c a;
    private final io.grpc.c b;

    private static final class a extends io.grpc.c.a {

        private final io.grpc.c.a a;
        private final io.grpc.t0 b;
        public a(io.grpc.c.a c$a, io.grpc.t0 t02) {
            super();
            this.a = a;
            this.b = t02;
        }

        @Override // io.grpc.c$a
        public void a(io.grpc.t0 t0) {
            n.p(t0, "headers");
            t0 t0Var = new t0();
            t0Var.l(this.b);
            t0Var.l(t0);
            this.a.a(t0Var);
        }

        @Override // io.grpc.c$a
        public void b(io.grpc.d1 d1) {
            this.a.b(d1);
        }
    }

    private final class b extends io.grpc.c.a {

        private final io.grpc.c.b a;
        private final Executor b;
        private final io.grpc.c.a c;
        private final io.grpc.s d;
        final io.grpc.n e;
        public b(io.grpc.n n, io.grpc.c.b c$b2, Executor executor3, io.grpc.c.a c$a4, io.grpc.s s5) {
            this.e = n;
            super();
            this.a = b2;
            this.b = executor3;
            n.p(a4, "delegate");
            this.c = (c.a)a4;
            n.p(s5, "context");
            this.d = (s)s5;
        }

        @Override // io.grpc.c$a
        public void a(io.grpc.t0 t0) {
            n.p(t0, "headers");
            n.a aVar = new n.a(this.c, t0);
            n.a(this.e).applyRequestMetadata(this.a, this.b, aVar);
            this.d.j(this.d.c());
        }

        @Override // io.grpc.c$a
        public void b(io.grpc.d1 d1) {
            this.c.b(d1);
        }
    }
    public n(io.grpc.c c, io.grpc.c c2) {
        super();
        n.p(c, "creds1");
        this.a = (c)c;
        n.p(c2, "creds2");
        this.b = (c)c2;
    }

    static io.grpc.c a(io.grpc.n n) {
        return n.b;
    }

    @Override // io.grpc.c
    public void applyRequestMetadata(io.grpc.c.b c$b, Executor executor2, io.grpc.c.a c$a3) {
        super(this, b, executor2, a3, s.i());
        this.a.applyRequestMetadata(b, executor2, bVar3);
    }

    @Override // io.grpc.c
    public void thisUsesUnstableApi() {
    }
}
