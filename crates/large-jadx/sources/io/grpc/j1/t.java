package io.grpc.j1;

import com.google.common.base.k;
import com.google.common.base.n;
import io.grpc.a;
import io.grpc.c0;
import io.grpc.g;
import java.io.Closeable;
import java.net.SocketAddress;
import java.util.concurrent.ScheduledExecutorService;

/* compiled from: ClientTransportFactory.java */
/* loaded from: classes3.dex */
public interface t extends Closeable {

    public static final class a {

        private String a = "unknown-authority";
        private a b;
        private String c;
        private c0 d;
        public a() {
            super();
            this.b = a.b;
        }

        public String a() {
            return this.a;
        }

        public a b() {
            return this.b;
        }

        public c0 c() {
            return this.d;
        }

        public String d() {
            return this.c;
        }

        public t.a e(String str) {
            n.p(str, "authority");
            this.a = str;
            return this;
        }

        public boolean equals(Object object) {
            boolean z = false;
            z = false;
            if (!(object instanceof t.a)) {
                return false;
            }
            if (this.a.equals(object.a)) {
                if (this.b.equals(object.b)) {
                    if (k.a(this.c, object.c)) {
                        if (k.a(this.d, object.d)) {
                            int i = 1;
                        }
                    }
                }
            }
            return z;
        }

        public t.a f(a aVar) {
            n.p(aVar, "eagAttributes");
            this.b = aVar;
            return this;
        }

        public t.a g(c0 c0Var) {
            this.d = c0Var;
            return this;
        }

        public t.a h(String str) {
            this.c = str;
            return this;
        }

        public int hashCode() {
            Object[] arr = new Object[4];
            return k.b(new Object[] { this.a, this.b, this.c, this.d });
        }
    }
    ScheduledExecutorService K1();

    v S0(SocketAddress socketAddress, t.a aVar, g gVar);

    @Override // java.io.Closeable
    void close();
}
