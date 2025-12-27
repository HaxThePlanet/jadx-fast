package io.grpc;

import com.google.common.base.j;
import com.google.common.base.j.b;
import com.google.common.base.n;

/* compiled from: ClientStreamTracer.java */
/* loaded from: classes2.dex */
public abstract class l extends e1 {

    public static abstract class a {
        public l a(l.c cVar, t0 t0Var) {
            throw new UnsupportedOperationException("Not implemented");
        }
    }

    public static final class c {

        private final a a;
        private final d b;
        private final int c;
        private final boolean d;
        c(a aVar, d dVar, int i, boolean z) {
            super();
            n.p(aVar, "transportAttrs");
            this.a = aVar;
            n.p(dVar, "callOptions");
            this.b = dVar;
            this.c = i;
            this.d = z;
        }

        public static l.c.a a() {
            return new l.c.a();
        }

        public l.c.a b() {
            final io.grpc.l.c.a aVar = new l.c.a();
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

    public static abstract class b extends l.a {
    }
    @Override // io.grpc.e1
    public void j() {
    }

    @Override // io.grpc.e1
    public void k(t0 t0Var) {
    }

    @Override // io.grpc.e1
    public void l() {
    }

    @Override // io.grpc.e1
    public void m(a aVar, t0 t0Var) {
    }
}
