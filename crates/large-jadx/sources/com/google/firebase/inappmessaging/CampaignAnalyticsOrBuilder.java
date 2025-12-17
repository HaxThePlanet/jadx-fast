package com.google.firebase.inappmessaging;

import com.google.protobuf.j;
import com.google.protobuf.t0;
import com.google.protobuf.u0;

/* loaded from: classes2.dex */
public interface CampaignAnalyticsOrBuilder extends u0 {
    @Override // com.google.protobuf.u0
    public abstract String getCampaignId();

    @Override // com.google.protobuf.u0
    public abstract j getCampaignIdBytes();

    @Override // com.google.protobuf.u0
    public abstract com.google.firebase.inappmessaging.ClientAppInfo getClientApp();

    @Override // com.google.protobuf.u0
    public abstract long getClientTimestampMillis();

    @Override // com.google.protobuf.u0
    public abstract t0 getDefaultInstanceForType();

    @Override // com.google.protobuf.u0
    public abstract com.google.firebase.inappmessaging.DismissType getDismissType();

    @Override // com.google.protobuf.u0
    public abstract int getEngagementMetricsDeliveryRetryCount();

    @Override // com.google.protobuf.u0
    public abstract com.google.firebase.inappmessaging.CampaignAnalytics.EventCase getEventCase();

    @Override // com.google.protobuf.u0
    public abstract com.google.firebase.inappmessaging.EventType getEventType();

    @Override // com.google.protobuf.u0
    public abstract com.google.firebase.inappmessaging.FetchErrorReason getFetchErrorReason();

    @Override // com.google.protobuf.u0
    public abstract String getFiamSdkVersion();

    @Override // com.google.protobuf.u0
    public abstract j getFiamSdkVersionBytes();

    @Override // com.google.protobuf.u0
    public abstract String getProjectNumber();

    @Override // com.google.protobuf.u0
    public abstract j getProjectNumberBytes();

    @Override // com.google.protobuf.u0
    public abstract com.google.firebase.inappmessaging.RenderErrorReason getRenderErrorReason();

    @Override // com.google.protobuf.u0
    public abstract boolean hasCampaignId();

    @Override // com.google.protobuf.u0
    public abstract boolean hasClientApp();

    @Override // com.google.protobuf.u0
    public abstract boolean hasClientTimestampMillis();

    @Override // com.google.protobuf.u0
    public abstract boolean hasDismissType();

    @Override // com.google.protobuf.u0
    public abstract boolean hasEngagementMetricsDeliveryRetryCount();

    @Override // com.google.protobuf.u0
    public abstract boolean hasEventType();

    @Override // com.google.protobuf.u0
    public abstract boolean hasFetchErrorReason();

    @Override // com.google.protobuf.u0
    public abstract boolean hasFiamSdkVersion();

    @Override // com.google.protobuf.u0
    public abstract boolean hasProjectNumber();

    @Override // com.google.protobuf.u0
    public abstract boolean hasRenderErrorReason();

    @Override // com.google.protobuf.u0
    public abstract boolean isInitialized();
}
