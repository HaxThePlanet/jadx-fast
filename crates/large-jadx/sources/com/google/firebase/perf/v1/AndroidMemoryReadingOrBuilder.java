package com.google.firebase.perf.v1;

import com.google.protobuf.t0;
import com.google.protobuf.u0;

/* loaded from: classes2.dex */
public interface AndroidMemoryReadingOrBuilder extends u0 {
    @Override // com.google.protobuf.u0
    public abstract long getClientTimeUs();

    @Override // com.google.protobuf.u0
    public abstract t0 getDefaultInstanceForType();

    @Override // com.google.protobuf.u0
    public abstract int getUsedAppJavaHeapMemoryKb();

    @Override // com.google.protobuf.u0
    public abstract boolean hasClientTimeUs();

    @Override // com.google.protobuf.u0
    public abstract boolean hasUsedAppJavaHeapMemoryKb();

    @Override // com.google.protobuf.u0
    public abstract boolean isInitialized();
}
