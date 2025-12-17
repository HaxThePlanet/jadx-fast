package com.google.firebase.firestore.proto;

import com.google.protobuf.j;
import com.google.protobuf.r1;
import com.google.protobuf.t0;
import com.google.protobuf.u0;
import f.c.e.c.u.c;
import f.c.e.c.u.d;

/* loaded from: classes2.dex */
public interface TargetOrBuilder extends u0 {
    @Override // com.google.protobuf.u0
    public abstract t0 getDefaultInstanceForType();

    @Override // com.google.protobuf.u0
    public abstract u.c getDocuments();

    @Override // com.google.protobuf.u0
    public abstract r1 getLastLimboFreeSnapshotVersion();

    @Override // com.google.protobuf.u0
    public abstract long getLastListenSequenceNumber();

    @Override // com.google.protobuf.u0
    public abstract u.d getQuery();

    @Override // com.google.protobuf.u0
    public abstract j getResumeToken();

    @Override // com.google.protobuf.u0
    public abstract r1 getSnapshotVersion();

    @Override // com.google.protobuf.u0
    public abstract int getTargetId();

    @Override // com.google.protobuf.u0
    public abstract com.google.firebase.firestore.proto.Target.TargetTypeCase getTargetTypeCase();

    @Override // com.google.protobuf.u0
    public abstract boolean hasDocuments();

    @Override // com.google.protobuf.u0
    public abstract boolean hasLastLimboFreeSnapshotVersion();

    @Override // com.google.protobuf.u0
    public abstract boolean hasQuery();

    @Override // com.google.protobuf.u0
    public abstract boolean hasSnapshotVersion();

    @Override // com.google.protobuf.u0
    public abstract boolean isInitialized();
}
