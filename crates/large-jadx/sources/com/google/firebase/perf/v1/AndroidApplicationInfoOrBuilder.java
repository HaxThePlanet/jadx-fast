package com.google.firebase.perf.v1;

import com.google.protobuf.j;
import com.google.protobuf.t0;
import com.google.protobuf.u0;

/* loaded from: classes2.dex */
public interface AndroidApplicationInfoOrBuilder extends u0 {
    @Override // com.google.protobuf.u0
    public abstract t0 getDefaultInstanceForType();

    @Override // com.google.protobuf.u0
    public abstract String getPackageName();

    @Override // com.google.protobuf.u0
    public abstract j getPackageNameBytes();

    @Override // com.google.protobuf.u0
    public abstract String getSdkVersion();

    @Override // com.google.protobuf.u0
    public abstract j getSdkVersionBytes();

    @Override // com.google.protobuf.u0
    public abstract String getVersionName();

    @Override // com.google.protobuf.u0
    public abstract j getVersionNameBytes();

    @Override // com.google.protobuf.u0
    public abstract boolean hasPackageName();

    @Override // com.google.protobuf.u0
    public abstract boolean hasSdkVersion();

    @Override // com.google.protobuf.u0
    public abstract boolean hasVersionName();

    @Override // com.google.protobuf.u0
    public abstract boolean isInitialized();
}
