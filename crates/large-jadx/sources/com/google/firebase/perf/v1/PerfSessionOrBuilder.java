package com.google.firebase.perf.v1;

import com.google.protobuf.j;
import com.google.protobuf.t0;
import com.google.protobuf.u0;
import java.util.List;

/* loaded from: classes2.dex */
public interface PerfSessionOrBuilder extends u0 {
    @Override // com.google.protobuf.u0
    public abstract t0 getDefaultInstanceForType();

    @Override // com.google.protobuf.u0
    public abstract String getSessionId();

    @Override // com.google.protobuf.u0
    public abstract j getSessionIdBytes();

    @Override // com.google.protobuf.u0
    public abstract com.google.firebase.perf.v1.SessionVerbosity getSessionVerbosity(int i);

    @Override // com.google.protobuf.u0
    public abstract int getSessionVerbosityCount();

    public abstract List<com.google.firebase.perf.v1.SessionVerbosity> getSessionVerbosityList();

    @Override // com.google.protobuf.u0
    public abstract boolean hasSessionId();

    @Override // com.google.protobuf.u0
    public abstract boolean isInitialized();
}
