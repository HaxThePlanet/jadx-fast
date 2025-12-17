package io.grpc;

import com.google.common.base.j;
import com.google.common.base.j.b;

/* loaded from: classes2.dex */
abstract class y0<ReqT, RespT>  extends io.grpc.h<ReqT, RespT> {
    @Override // io.grpc.h
    public void cancel(String string, Throwable throwable2) {
        delegate().cancel(string, throwable2);
    }

    protected abstract io.grpc.h<?, ?> delegate();

    @Override // io.grpc.h
    public io.grpc.a getAttributes() {
        return delegate().getAttributes();
    }

    @Override // io.grpc.h
    public void halfClose() {
        delegate().halfClose();
    }

    @Override // io.grpc.h
    public boolean isReady() {
        return delegate().isReady();
    }

    @Override // io.grpc.h
    public void request(int i) {
        delegate().request(i);
    }

    @Override // io.grpc.h
    public void setMessageCompression(boolean z) {
        delegate().setMessageCompression(z);
    }

    @Override // io.grpc.h
    public String toString() {
        j.b bVar = j.c(this);
        bVar.d("delegate", delegate());
        return bVar.toString();
    }
}
