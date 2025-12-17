package io.grpc.j1;

import com.google.common.base.k;
import com.google.common.base.n;
import io.grpc.a;
import io.grpc.c0;
import io.grpc.g;
import java.io.Closeable;
import java.net.SocketAddress;
import java.util.concurrent.ScheduledExecutorService;

/* loaded from: classes3.dex */
public interface t extends Closeable {

    public static final class a {

        private String a;
        private a b;
        private String c;
        private c0 d;
        public a() {
            super();
            this.a = "unknown-authority";
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

        public io.grpc.j1.t.a e(String string) {
            n.p(string, "authority");
            this.a = (String)string;
            return this;
        }

        public boolean equals(Object object) {
            boolean equals;
            int i;
            Object str;
            Object obj4;
            if (!object instanceof t.a) {
                return 0;
            }
            if (this.a.equals(object.a) && this.b.equals(object.b) && k.a(this.c, object.c) && k.a(this.d, object.d)) {
                if (this.b.equals(object.b)) {
                    if (k.a(this.c, object.c)) {
                        if (k.a(this.d, object.d)) {
                            i = 1;
                        }
                    }
                }
            }
            return i;
        }

        public io.grpc.j1.t.a f(a a) {
            n.p(a, "eagAttributes");
            this.b = a;
            return this;
        }

        public io.grpc.j1.t.a g(c0 c0) {
            this.d = c0;
            return this;
        }

        public io.grpc.j1.t.a h(String string) {
            this.c = string;
            return this;
        }

        public int hashCode() {
            Object[] arr = new Object[4];
            return k.b(this.a, this.b, this.c, this.d);
        }
    }
    @Override // java.io.Closeable
    public abstract ScheduledExecutorService K1();

    @Override // java.io.Closeable
    public abstract io.grpc.j1.v S0(SocketAddress socketAddress, io.grpc.j1.t.a t$a2, g g3);

    @Override // java.io.Closeable
    public abstract void close();
}
