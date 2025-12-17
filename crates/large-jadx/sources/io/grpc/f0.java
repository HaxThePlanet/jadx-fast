package io.grpc;

import com.google.common.base.n;

/* loaded from: classes2.dex */
public abstract class f0 {

    public static final io.grpc.a.c<io.grpc.f0> a;

    static class a {
    }

    public static final class b {

        private final io.grpc.d1 a;
        private final Object b;
        public io.grpc.i c;
        private b(io.grpc.d1 d1, Object object2, io.grpc.i i3) {
            super();
            n.p(d1, "status");
            this.a = (d1)d1;
            this.b = object2;
            this.c = i3;
        }

        b(io.grpc.d1 d1, Object object2, io.grpc.i i3, io.grpc.f0.a f0$a4) {
            super(d1, object2, i3);
        }

        public static io.grpc.f0.b.a d() {
            f0.b.a aVar = new f0.b.a(0);
            return aVar;
        }

        public Object a() {
            return this.b;
        }

        public io.grpc.i b() {
            return this.c;
        }

        public io.grpc.d1 c() {
            return this.a;
        }
    }
    static {
        f0.a = a.c.a("io.grpc.config-selector");
    }

    public abstract io.grpc.f0.b a(io.grpc.o0.f o0$f);
}
