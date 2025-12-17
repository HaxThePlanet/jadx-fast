package io.grpc;

/* loaded from: classes2.dex */
public abstract class h<ReqT, RespT>  {

    public static abstract class a {
        public void onClose(io.grpc.d1 d1, io.grpc.t0 t02) {
        }

        public void onHeaders(io.grpc.t0 t0) {
        }

        public void onMessage(T t) {
        }

        public void onReady() {
        }
    }
    public abstract void cancel(String string, Throwable throwable2);

    public io.grpc.a getAttributes() {
        return a.b;
    }

    public abstract void halfClose();

    public boolean isReady() {
        return 1;
    }

    public abstract void request(int i);

    public abstract void sendMessage(ReqT reqt);

    public void setMessageCompression(boolean z) {
    }

    public abstract void start(io.grpc.h.a<RespT> h$a, io.grpc.t0 t02);
}
