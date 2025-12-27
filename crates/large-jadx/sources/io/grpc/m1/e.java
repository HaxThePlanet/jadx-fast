package io.grpc.m1;

import com.google.common.base.n;
import io.grpc.d;
import io.grpc.e;
import io.grpc.h;
import io.grpc.i;
import io.grpc.t0;
import io.grpc.u0;

/* compiled from: MetadataUtils.java */
/* loaded from: classes3.dex */
public final class e {

    private static final class a implements i {

        private final t0 a;
        a(t0 t0Var) {
            super();
            n.p(t0Var, "extraHeaders");
            this.a = t0Var;
        }

        static /* synthetic */ t0 b(e.a aVar) {
            return aVar.a;
        }

        public <ReqT, RespT> h<ReqT, RespT> a(u0<ReqT, RespT> u0Var, d dVar, e eVar) {
            return new e.a.a(this, eVar.h(u0Var, dVar));
        }
    }
    public static i a(t0 t0Var) {
        return new e.a(t0Var);
    }
}
