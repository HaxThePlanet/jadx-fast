package com.google.firebase.firestore.proto;

import com.google.protobuf.r1;
import com.google.protobuf.t0;
import com.google.protobuf.u0;

/* loaded from: classes2.dex */
public interface TargetGlobalOrBuilder extends u0 {
    @Override // com.google.protobuf.u0
    public abstract t0 getDefaultInstanceForType();

    @Override // com.google.protobuf.u0
    public abstract long getHighestListenSequenceNumber();

    @Override // com.google.protobuf.u0
    public abstract int getHighestTargetId();

    @Override // com.google.protobuf.u0
    public abstract r1 getLastRemoteSnapshotVersion();

    @Override // com.google.protobuf.u0
    public abstract int getTargetCount();

    @Override // com.google.protobuf.u0
    public abstract boolean hasLastRemoteSnapshotVersion();

    @Override // com.google.protobuf.u0
    public abstract boolean isInitialized();
}
