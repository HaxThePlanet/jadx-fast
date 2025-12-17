package com.google.firebase.firestore.remote;

import io.grpc.d1;
import io.grpc.t0;

/* loaded from: classes2.dex */
interface IncomingStreamObserver<RespT>  {
    public abstract void onClose(d1 d1);

    public abstract void onHeaders(t0 t0);

    public abstract void onNext(RespT respt);

    public abstract void onOpen();
}
