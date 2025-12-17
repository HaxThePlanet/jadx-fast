package com.google.firebase.inappmessaging;

import com.google.protobuf.j;
import com.google.protobuf.t0;
import com.google.protobuf.u0;

/* loaded from: classes2.dex */
public interface ClientAppInfoOrBuilder extends u0 {
    @Override // com.google.protobuf.u0
    public abstract t0 getDefaultInstanceForType();

    @Override // com.google.protobuf.u0
    public abstract String getFirebaseInstanceId();

    @Override // com.google.protobuf.u0
    public abstract j getFirebaseInstanceIdBytes();

    @Override // com.google.protobuf.u0
    public abstract String getGoogleAppId();

    @Override // com.google.protobuf.u0
    public abstract j getGoogleAppIdBytes();

    @Override // com.google.protobuf.u0
    public abstract boolean hasFirebaseInstanceId();

    @Override // com.google.protobuf.u0
    public abstract boolean hasGoogleAppId();

    @Override // com.google.protobuf.u0
    public abstract boolean isInitialized();
}
