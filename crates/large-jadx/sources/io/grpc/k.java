package io.grpc;

import com.google.common.base.n;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* compiled from: ClientInterceptors.java */
/* loaded from: classes2.dex */
public class k {

    class a extends h<Object, Object> {
        a() {
            super();
        }

        @Override // io.grpc.h
        public void cancel(String str, Throwable th) {
        }

        @Override // io.grpc.h
        public void halfClose() {
        }

        @Override // io.grpc.h
        public boolean isReady() {
            return false;
        }

        @Override // io.grpc.h
        public void request(int i) {
        }

        @Override // io.grpc.h
        public void sendMessage(Object object) {
        }

        @Override // io.grpc.h
        public void start(h.a<Object> aVar, t0 t0Var) {
        }
    }

    private static class b extends e {

        private final e a;
        private final i b;
        /* synthetic */ b(e eVar, i iVar, j jVar) {
            this(eVar, iVar);
        }

        @Override // io.grpc.e
        public String a() {
            return this.a.a();
        }

        @Override // io.grpc.e
        public <ReqT, RespT> h<ReqT, RespT> h(u0<ReqT, RespT> u0Var, d dVar) {
            return this.b.a(u0Var, dVar, this.a);
        }

        private b(e eVar, i iVar) {
            super();
            this.a = eVar;
            n.p(iVar, "interceptor");
            this.b = iVar;
        }
    }
    static {
        final io.grpc.k.a aVar = new k.a();
    }

    public static e a(e eVar, List<? extends i> list) {
        io.grpc.e eVar2;
        item = "channel";
        n.p(eVar, item);
        final Iterator it = list.iterator();
        while (it.hasNext()) {
            io.grpc.j jVar = null;
            eVar2 = new k.b(eVar2, (i)it.next(), jVar);
        }
        return eVar2;
    }

    public static e b(e eVar, i... iVarArr) {
        return k.a(eVar, Arrays.asList(iVarArr));
    }
}
