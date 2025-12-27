package io.grpc;

/* compiled from: ForwardingClientCall.java */
/* loaded from: classes2.dex */
public abstract class a0<ReqT, RespT> extends y0<ReqT, RespT> {

    public static abstract class a<ReqT, RespT> extends a0<ReqT, RespT> {

        private final h<ReqT, RespT> a;
        protected a(h<ReqT, RespT> hVar) {
            super();
            this.a = hVar;
        }

        @Override // io.grpc.a0
        protected h<ReqT, RespT> delegate() {
            return this.a;
        }
    }
    @Override // io.grpc.y0
    public void sendMessage(ReqT reqt) {
        delegate().sendMessage(reqt);
    }

    @Override // io.grpc.y0
    public void start(h.a<RespT> aVar, t0 t0Var) {
        delegate().start(aVar, t0Var);
    }

    @Override // io.grpc.y0
    protected abstract h<ReqT, RespT> delegate();
}
