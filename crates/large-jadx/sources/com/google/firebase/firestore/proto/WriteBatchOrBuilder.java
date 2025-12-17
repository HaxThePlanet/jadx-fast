package com.google.firebase.firestore.proto;

import com.google.protobuf.r1;
import com.google.protobuf.t0;
import com.google.protobuf.u0;
import f.c.e.c.y;
import java.util.List;

/* loaded from: classes2.dex */
public interface WriteBatchOrBuilder extends u0 {
    @Override // com.google.protobuf.u0
    public abstract y getBaseWrites(int i);

    @Override // com.google.protobuf.u0
    public abstract int getBaseWritesCount();

    public abstract List<y> getBaseWritesList();

    @Override // com.google.protobuf.u0
    public abstract int getBatchId();

    @Override // com.google.protobuf.u0
    public abstract t0 getDefaultInstanceForType();

    @Override // com.google.protobuf.u0
    public abstract r1 getLocalWriteTime();

    @Override // com.google.protobuf.u0
    public abstract y getWrites(int i);

    @Override // com.google.protobuf.u0
    public abstract int getWritesCount();

    public abstract List<y> getWritesList();

    @Override // com.google.protobuf.u0
    public abstract boolean hasLocalWriteTime();

    @Override // com.google.protobuf.u0
    public abstract boolean isInitialized();
}
