package com.google.firebase.perf.v1;

import com.google.protobuf.j;
import com.google.protobuf.t0;
import com.google.protobuf.u0;
import java.util.Map;

/* loaded from: classes2.dex */
public interface ApplicationInfoOrBuilder extends u0 {
    @Override // com.google.protobuf.u0
    public abstract boolean containsCustomAttributes(String string);

    @Override // com.google.protobuf.u0
    public abstract com.google.firebase.perf.v1.AndroidApplicationInfo getAndroidAppInfo();

    @Override // com.google.protobuf.u0
    public abstract String getAppInstanceId();

    @Override // com.google.protobuf.u0
    public abstract j getAppInstanceIdBytes();

    @Override // com.google.protobuf.u0
    public abstract com.google.firebase.perf.v1.ApplicationProcessState getApplicationProcessState();

    @Deprecated
    public abstract Map<String, String> getCustomAttributes();

    @Override // com.google.protobuf.u0
    public abstract int getCustomAttributesCount();

    public abstract Map<String, String> getCustomAttributesMap();

    @Override // com.google.protobuf.u0
    public abstract String getCustomAttributesOrDefault(String string, String string2);

    @Override // com.google.protobuf.u0
    public abstract String getCustomAttributesOrThrow(String string);

    @Override // com.google.protobuf.u0
    public abstract t0 getDefaultInstanceForType();

    @Override // com.google.protobuf.u0
    public abstract String getGoogleAppId();

    @Override // com.google.protobuf.u0
    public abstract j getGoogleAppIdBytes();

    @Override // com.google.protobuf.u0
    public abstract boolean hasAndroidAppInfo();

    @Override // com.google.protobuf.u0
    public abstract boolean hasAppInstanceId();

    @Override // com.google.protobuf.u0
    public abstract boolean hasApplicationProcessState();

    @Override // com.google.protobuf.u0
    public abstract boolean hasGoogleAppId();

    @Override // com.google.protobuf.u0
    public abstract boolean isInitialized();
}
