package com.google.firebase.inappmessaging.internal;

import com.google.protobuf.d1;
import java.util.concurrent.Callable;

/* loaded from: classes2.dex */
public final class s1 implements Callable {

    public final com.google.firebase.inappmessaging.internal.ProtoStorageClient a;
    public final d1 b;
    public s1(com.google.firebase.inappmessaging.internal.ProtoStorageClient protoStorageClient, d1 d12) {
        super();
        this.a = protoStorageClient;
        this.b = d12;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        return this.a.b(this.b);
    }
}
