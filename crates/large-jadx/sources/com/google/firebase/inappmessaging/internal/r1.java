package com.google.firebase.inappmessaging.internal;

import com.google.protobuf.a;
import java.util.concurrent.Callable;

/* loaded from: classes2.dex */
public final class r1 implements Callable {

    public final com.google.firebase.inappmessaging.internal.ProtoStorageClient a;
    public final a b;
    public r1(com.google.firebase.inappmessaging.internal.ProtoStorageClient protoStorageClient, a a2) {
        super();
        this.a = protoStorageClient;
        this.b = a2;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        final a aVar = this.b;
        this.a.d(aVar);
        return aVar;
    }
}
