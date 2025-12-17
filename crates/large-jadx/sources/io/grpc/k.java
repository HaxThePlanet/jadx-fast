package io.grpc;

import com.google.common.base.n;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes2.dex */
public class k {

    class a extends io.grpc.h<Object, Object> {
        @Override // io.grpc.h
        public void cancel(String string, Throwable throwable2) {
        }

        @Override // io.grpc.h
        public void halfClose() {
        }

        @Override // io.grpc.h
        public boolean isReady() {
            return 0;
        }

        @Override // io.grpc.h
        public void request(int i) {
        }

        @Override // io.grpc.h
        public void sendMessage(Object object) {
        }

        public void start(io.grpc.h.a<Object> h$a, io.grpc.t0 t02) {
        }
    }

    private static class b extends io.grpc.e {

        private final io.grpc.e a;
        private final io.grpc.i b;
        private b(io.grpc.e e, io.grpc.i i2) {
            super();
            this.a = e;
            n.p(i2, "interceptor");
            this.b = (i)i2;
        }

        b(io.grpc.e e, io.grpc.i i2, io.grpc.j j3) {
            super(e, i2);
        }

        @Override // io.grpc.e
        public String a() {
            return this.a.a();
        }

        public <ReqT, RespT> io.grpc.h<ReqT, RespT> h(io.grpc.u0<ReqT, RespT> u0, io.grpc.d d2) {
            return this.b.a(u0, d2, this.a);
        }
    }
    static {
        k.a aVar = new k.a();
    }

    public static io.grpc.e a(io.grpc.e e, List<? extends io.grpc.i> list2) {
        String next;
        io.grpc.k.b bVar;
        int i;
        Object obj3;
        n.p(e, "channel");
        final Iterator obj4 = list2.iterator();
        for (i next : obj4) {
            bVar = new k.b(obj3, next, 0);
            obj3 = bVar;
        }
        return obj3;
    }

    public static io.grpc.e b(io.grpc.e e, io.grpc.i... i2Arr2) {
        return k.a(e, Arrays.asList(i2Arr2));
    }
}
