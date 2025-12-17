package io.grpc.m1;

import com.google.common.base.n;
import io.grpc.d;
import io.grpc.e;
import io.grpc.h;
import io.grpc.i;
import io.grpc.t0;
import io.grpc.u0;

/* loaded from: classes3.dex */
public final class e {

    private static final class a implements i {

        private final t0 a;
        a(t0 t0) {
            super();
            n.p(t0, "extraHeaders");
            this.a = (t0)t0;
        }

        static t0 b(io.grpc.m1.e.a e$a) {
            return a.a;
        }

        public <ReqT, RespT> h<ReqT, RespT> a(u0<ReqT, RespT> u0, d d2, e e3) {
            e.a.a aVar = new e.a.a(this, e3.h(u0, d2));
            return aVar;
        }
    }
    public static i a(t0 t0) {
        e.a aVar = new e.a(t0);
        return aVar;
    }
}
