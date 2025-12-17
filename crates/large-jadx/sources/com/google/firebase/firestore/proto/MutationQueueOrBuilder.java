package com.google.firebase.firestore.proto;

import com.google.protobuf.j;
import com.google.protobuf.t0;
import com.google.protobuf.u0;

/* loaded from: classes2.dex */
public interface MutationQueueOrBuilder extends u0 {
    @Override // com.google.protobuf.u0
    public abstract t0 getDefaultInstanceForType();

    @Override // com.google.protobuf.u0
    public abstract int getLastAcknowledgedBatchId();

    @Override // com.google.protobuf.u0
    public abstract j getLastStreamToken();

    @Override // com.google.protobuf.u0
    public abstract boolean isInitialized();
}
