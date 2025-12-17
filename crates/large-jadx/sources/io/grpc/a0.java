package io.grpc;

/* loaded from: classes2.dex */
public abstract class a0<ReqT, RespT>  extends io.grpc.y0<ReqT, RespT> {

    public static abstract class a extends io.grpc.a0<ReqT, RespT> {

        private final io.grpc.h<ReqT, RespT> a;
        protected a(io.grpc.h<ReqT, RespT> h) {
            super();
            this.a = h;
        }

        protected io.grpc.h<ReqT, RespT> delegate() {
            return this.a;
        }
    }
    @Override // io.grpc.y0
    public void cancel(String string, Throwable throwable2) {
        super.cancel(string, throwable2);
    }

    protected abstract io.grpc.h<ReqT, RespT> delegate();

    @Override // io.grpc.y0
    public io.grpc.a getAttributes() {
        return super.getAttributes();
    }

    @Override // io.grpc.y0
    public void halfClose() {
        super.halfClose();
    }

    @Override // io.grpc.y0
    public boolean isReady() {
        return super.isReady();
    }

    @Override // io.grpc.y0
    public void request(int i) {
        super.request(i);
    }

    public void sendMessage(ReqT reqt) {
        delegate().sendMessage(reqt);
    }

    @Override // io.grpc.y0
    public void setMessageCompression(boolean z) {
        super.setMessageCompression(z);
    }

    public void start(io.grpc.h.a<RespT> h$a, io.grpc.t0 t02) {
        delegate().start(a, t02);
    }

    @Override // io.grpc.y0
    public String toString() {
        return super.toString();
    }
}
