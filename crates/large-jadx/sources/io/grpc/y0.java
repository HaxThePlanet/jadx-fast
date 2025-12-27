package io.grpc;

import com.google.common.base.j;
import com.google.common.base.j.b;

/* compiled from: PartialForwardingClientCall.java */
/* loaded from: classes2.dex */
abstract class y0<ReqT, RespT> extends h<ReqT, RespT> {
    y0() {
        super();
    }

    @Override // io.grpc.h
    public void cancel(String str, Throwable th) {
        delegate().cancel(str, th);
    }

    @Override // io.grpc.h
    public a getAttributes() {
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

    @Override // io.grpc.h
    protected abstract h<?, ?> delegate();
}
