package io.grpc;

import com.google.common.base.j;
import com.google.common.base.j.b;
import com.google.common.base.n;

/* loaded from: classes2.dex */
public abstract class l extends io.grpc.e1 {

    public static abstract class a {
        public io.grpc.l a(io.grpc.l.c l$c, io.grpc.t0 t02) {
            UnsupportedOperationException obj1 = new UnsupportedOperationException("Not implemented");
            throw obj1;
        }
    }

    public static final class c {

        private final io.grpc.a a;
        private final io.grpc.d b;
        private final int c;
        private final boolean d;
        c(io.grpc.a a, io.grpc.d d2, int i3, boolean z4) {
            super();
            n.p(a, "transportAttrs");
            this.a = (a)a;
            n.p(d2, "callOptions");
            this.b = (d)d2;
            this.c = i3;
            this.d = z4;
        }

        public static io.grpc.l.c.a a() {
            l.c.a aVar = new l.c.a();
            return aVar;
        }

        public io.grpc.l.c.a b() {
            l.c.a aVar = new l.c.a();
            aVar.b(this.b);
            aVar.e(this.a);
            aVar.d(this.c);
            aVar.c(this.d);
            return aVar;
        }

        public String toString() {
            j.b bVar = j.c(this);
            bVar.d("transportAttrs", this.a);
            bVar.d("callOptions", this.b);
            bVar.b("previousAttempts", this.c);
            bVar.e("isTransparentRetry", this.d);
            return bVar.toString();
        }
    }

    public static abstract class b extends io.grpc.l.a {
    }
    @Override // io.grpc.e1
    public void j() {
    }

    @Override // io.grpc.e1
    public void k(io.grpc.t0 t0) {
    }

    @Override // io.grpc.e1
    public void l() {
    }

    @Override // io.grpc.e1
    public void m(io.grpc.a a, io.grpc.t0 t02) {
    }
}
