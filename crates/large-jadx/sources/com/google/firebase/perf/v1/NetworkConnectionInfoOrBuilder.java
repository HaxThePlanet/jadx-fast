package com.google.firebase.perf.v1;

import com.google.protobuf.t0;
import com.google.protobuf.u0;

/* loaded from: classes2.dex */
public interface NetworkConnectionInfoOrBuilder extends u0 {
    @Override // com.google.protobuf.u0
    public abstract t0 getDefaultInstanceForType();

    @Override // com.google.protobuf.u0
    public abstract com.google.firebase.perf.v1.NetworkConnectionInfo.MobileSubtype getMobileSubtype();

    @Override // com.google.protobuf.u0
    public abstract com.google.firebase.perf.v1.NetworkConnectionInfo.NetworkType getNetworkType();

    @Override // com.google.protobuf.u0
    public abstract boolean hasMobileSubtype();

    @Override // com.google.protobuf.u0
    public abstract boolean hasNetworkType();

    @Override // com.google.protobuf.u0
    public abstract boolean isInitialized();
}
