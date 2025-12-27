package io.grpc;

/* compiled from: ClientCall.java */
/* loaded from: classes2.dex */
public abstract class h<ReqT, RespT> {

    public static abstract class a<T> {
        public void onClose(d1 d1Var, t0 t0Var) {
        }

        public void onHeaders(t0 t0Var) {
        }

        public void onMessage(T t) {
        }

        public void onReady() {
        }
    }
    public a getAttributes() {
        return a.b;
    }

    public abstract void cancel(String str, Throwable th);

    public abstract void halfClose();

    public boolean isReady() {
        return true;
    }

    public abstract void request(int i);

    public abstract void sendMessage(ReqT reqt);

    public void setMessageCompression(boolean z) {
    }

    public abstract void start(h.a<RespT> aVar, t0 t0Var);
}
