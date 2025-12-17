package com.google.firebase.inappmessaging;

import com.google.protobuf.d1;
import com.google.protobuf.j;
import com.google.protobuf.k;
import com.google.protobuf.q;
import com.google.protobuf.z;
import com.google.protobuf.z.a;
import com.google.protobuf.z.b;
import com.google.protobuf.z.f;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes2.dex */
public final class CampaignAnalytics extends z<com.google.firebase.inappmessaging.CampaignAnalytics, com.google.firebase.inappmessaging.CampaignAnalytics.Builder> implements com.google.firebase.inappmessaging.CampaignAnalyticsOrBuilder {

    public static final int CAMPAIGN_ID_FIELD_NUMBER = 2;
    public static final int CLIENT_APP_FIELD_NUMBER = 3;
    public static final int CLIENT_TIMESTAMP_MILLIS_FIELD_NUMBER = 4;
    private static final com.google.firebase.inappmessaging.CampaignAnalytics DEFAULT_INSTANCE = null;
    public static final int DISMISS_TYPE_FIELD_NUMBER = 6;
    public static final int ENGAGEMENTMETRICS_DELIVERY_RETRY_COUNT_FIELD_NUMBER = 10;
    public static final int EVENT_TYPE_FIELD_NUMBER = 5;
    public static final int FETCH_ERROR_REASON_FIELD_NUMBER = 8;
    public static final int FIAM_SDK_VERSION_FIELD_NUMBER = 9;
    private static volatile d1<com.google.firebase.inappmessaging.CampaignAnalytics> PARSER = null;
    public static final int PROJECT_NUMBER_FIELD_NUMBER = 1;
    public static final int RENDER_ERROR_REASON_FIELD_NUMBER = 7;
    private int bitField0_;
    private String campaignId_;
    private com.google.firebase.inappmessaging.ClientAppInfo clientApp_;
    private long clientTimestampMillis_;
    private int engagementMetricsDeliveryRetryCount_;
    private int eventCase_ = 0;
    private Object event_;
    private String fiamSdkVersion_;
    private String projectNumber_;

    public static enum EventCase {

        EVENT_TYPE(5),
        DISMISS_TYPE(6),
        RENDER_ERROR_REASON(7),
        FETCH_ERROR_REASON(8),
        EVENT_NOT_SET(false);

        private final int value;
        public static com.google.firebase.inappmessaging.CampaignAnalytics.EventCase forNumber(int i) {
            if (i != 0 && i != 5 && i != 6 && i != 7 && i != 8) {
                if (i != 5) {
                    if (i != 6) {
                        if (i != 7) {
                            if (i != 8) {
                                return null;
                            }
                            return CampaignAnalytics.EventCase.FETCH_ERROR_REASON;
                        }
                        return CampaignAnalytics.EventCase.RENDER_ERROR_REASON;
                    }
                    return CampaignAnalytics.EventCase.DISMISS_TYPE;
                }
                return CampaignAnalytics.EventCase.EVENT_TYPE;
            }
            return CampaignAnalytics.EventCase.EVENT_NOT_SET;
        }

        @Deprecated
        public static com.google.firebase.inappmessaging.CampaignAnalytics.EventCase valueOf(int i) {
            return CampaignAnalytics.EventCase.forNumber(i);
        }

        @Override // java.lang.Enum
        public int getNumber() {
            return this.value;
        }
    }

    public static final class Builder extends z.a<com.google.firebase.inappmessaging.CampaignAnalytics, com.google.firebase.inappmessaging.CampaignAnalytics.Builder> implements com.google.firebase.inappmessaging.CampaignAnalyticsOrBuilder {
        private Builder() {
            super(CampaignAnalytics.access$000());
        }

        Builder(com.google.firebase.inappmessaging.CampaignAnalytics.1 campaignAnalytics$1) {
            super();
        }

        @Override // com.google.protobuf.z$a
        public com.google.firebase.inappmessaging.CampaignAnalytics.Builder clearCampaignId() {
            copyOnWrite();
            CampaignAnalytics.access$600((CampaignAnalytics)this.instance);
            return this;
        }

        @Override // com.google.protobuf.z$a
        public com.google.firebase.inappmessaging.CampaignAnalytics.Builder clearClientApp() {
            copyOnWrite();
            CampaignAnalytics.access$1000((CampaignAnalytics)this.instance);
            return this;
        }

        @Override // com.google.protobuf.z$a
        public com.google.firebase.inappmessaging.CampaignAnalytics.Builder clearClientTimestampMillis() {
            copyOnWrite();
            CampaignAnalytics.access$1200((CampaignAnalytics)this.instance);
            return this;
        }

        @Override // com.google.protobuf.z$a
        public com.google.firebase.inappmessaging.CampaignAnalytics.Builder clearDismissType() {
            copyOnWrite();
            CampaignAnalytics.access$1600((CampaignAnalytics)this.instance);
            return this;
        }

        @Override // com.google.protobuf.z$a
        public com.google.firebase.inappmessaging.CampaignAnalytics.Builder clearEngagementMetricsDeliveryRetryCount() {
            copyOnWrite();
            CampaignAnalytics.access$2500((CampaignAnalytics)this.instance);
            return this;
        }

        @Override // com.google.protobuf.z$a
        public com.google.firebase.inappmessaging.CampaignAnalytics.Builder clearEvent() {
            copyOnWrite();
            CampaignAnalytics.access$100((CampaignAnalytics)this.instance);
            return this;
        }

        @Override // com.google.protobuf.z$a
        public com.google.firebase.inappmessaging.CampaignAnalytics.Builder clearEventType() {
            copyOnWrite();
            CampaignAnalytics.access$1400((CampaignAnalytics)this.instance);
            return this;
        }

        @Override // com.google.protobuf.z$a
        public com.google.firebase.inappmessaging.CampaignAnalytics.Builder clearFetchErrorReason() {
            copyOnWrite();
            CampaignAnalytics.access$2000((CampaignAnalytics)this.instance);
            return this;
        }

        @Override // com.google.protobuf.z$a
        public com.google.firebase.inappmessaging.CampaignAnalytics.Builder clearFiamSdkVersion() {
            copyOnWrite();
            CampaignAnalytics.access$2200((CampaignAnalytics)this.instance);
            return this;
        }

        @Override // com.google.protobuf.z$a
        public com.google.firebase.inappmessaging.CampaignAnalytics.Builder clearProjectNumber() {
            copyOnWrite();
            CampaignAnalytics.access$300((CampaignAnalytics)this.instance);
            return this;
        }

        @Override // com.google.protobuf.z$a
        public com.google.firebase.inappmessaging.CampaignAnalytics.Builder clearRenderErrorReason() {
            copyOnWrite();
            CampaignAnalytics.access$1800((CampaignAnalytics)this.instance);
            return this;
        }

        @Override // com.google.protobuf.z$a
        public String getCampaignId() {
            return (CampaignAnalytics)this.instance.getCampaignId();
        }

        @Override // com.google.protobuf.z$a
        public j getCampaignIdBytes() {
            return (CampaignAnalytics)this.instance.getCampaignIdBytes();
        }

        @Override // com.google.protobuf.z$a
        public com.google.firebase.inappmessaging.ClientAppInfo getClientApp() {
            return (CampaignAnalytics)this.instance.getClientApp();
        }

        @Override // com.google.protobuf.z$a
        public long getClientTimestampMillis() {
            return (CampaignAnalytics)this.instance.getClientTimestampMillis();
        }

        @Override // com.google.protobuf.z$a
        public com.google.firebase.inappmessaging.DismissType getDismissType() {
            return (CampaignAnalytics)this.instance.getDismissType();
        }

        @Override // com.google.protobuf.z$a
        public int getEngagementMetricsDeliveryRetryCount() {
            return (CampaignAnalytics)this.instance.getEngagementMetricsDeliveryRetryCount();
        }

        @Override // com.google.protobuf.z$a
        public com.google.firebase.inappmessaging.CampaignAnalytics.EventCase getEventCase() {
            return (CampaignAnalytics)this.instance.getEventCase();
        }

        @Override // com.google.protobuf.z$a
        public com.google.firebase.inappmessaging.EventType getEventType() {
            return (CampaignAnalytics)this.instance.getEventType();
        }

        @Override // com.google.protobuf.z$a
        public com.google.firebase.inappmessaging.FetchErrorReason getFetchErrorReason() {
            return (CampaignAnalytics)this.instance.getFetchErrorReason();
        }

        @Override // com.google.protobuf.z$a
        public String getFiamSdkVersion() {
            return (CampaignAnalytics)this.instance.getFiamSdkVersion();
        }

        @Override // com.google.protobuf.z$a
        public j getFiamSdkVersionBytes() {
            return (CampaignAnalytics)this.instance.getFiamSdkVersionBytes();
        }

        @Override // com.google.protobuf.z$a
        public String getProjectNumber() {
            return (CampaignAnalytics)this.instance.getProjectNumber();
        }

        @Override // com.google.protobuf.z$a
        public j getProjectNumberBytes() {
            return (CampaignAnalytics)this.instance.getProjectNumberBytes();
        }

        @Override // com.google.protobuf.z$a
        public com.google.firebase.inappmessaging.RenderErrorReason getRenderErrorReason() {
            return (CampaignAnalytics)this.instance.getRenderErrorReason();
        }

        @Override // com.google.protobuf.z$a
        public boolean hasCampaignId() {
            return (CampaignAnalytics)this.instance.hasCampaignId();
        }

        @Override // com.google.protobuf.z$a
        public boolean hasClientApp() {
            return (CampaignAnalytics)this.instance.hasClientApp();
        }

        @Override // com.google.protobuf.z$a
        public boolean hasClientTimestampMillis() {
            return (CampaignAnalytics)this.instance.hasClientTimestampMillis();
        }

        @Override // com.google.protobuf.z$a
        public boolean hasDismissType() {
            return (CampaignAnalytics)this.instance.hasDismissType();
        }

        @Override // com.google.protobuf.z$a
        public boolean hasEngagementMetricsDeliveryRetryCount() {
            return (CampaignAnalytics)this.instance.hasEngagementMetricsDeliveryRetryCount();
        }

        @Override // com.google.protobuf.z$a
        public boolean hasEventType() {
            return (CampaignAnalytics)this.instance.hasEventType();
        }

        @Override // com.google.protobuf.z$a
        public boolean hasFetchErrorReason() {
            return (CampaignAnalytics)this.instance.hasFetchErrorReason();
        }

        @Override // com.google.protobuf.z$a
        public boolean hasFiamSdkVersion() {
            return (CampaignAnalytics)this.instance.hasFiamSdkVersion();
        }

        @Override // com.google.protobuf.z$a
        public boolean hasProjectNumber() {
            return (CampaignAnalytics)this.instance.hasProjectNumber();
        }

        @Override // com.google.protobuf.z$a
        public boolean hasRenderErrorReason() {
            return (CampaignAnalytics)this.instance.hasRenderErrorReason();
        }

        @Override // com.google.protobuf.z$a
        public com.google.firebase.inappmessaging.CampaignAnalytics.Builder mergeClientApp(com.google.firebase.inappmessaging.ClientAppInfo clientAppInfo) {
            copyOnWrite();
            CampaignAnalytics.access$900((CampaignAnalytics)this.instance, clientAppInfo);
            return this;
        }

        @Override // com.google.protobuf.z$a
        public com.google.firebase.inappmessaging.CampaignAnalytics.Builder setCampaignId(String string) {
            copyOnWrite();
            CampaignAnalytics.access$500((CampaignAnalytics)this.instance, string);
            return this;
        }

        @Override // com.google.protobuf.z$a
        public com.google.firebase.inappmessaging.CampaignAnalytics.Builder setCampaignIdBytes(j j) {
            copyOnWrite();
            CampaignAnalytics.access$700((CampaignAnalytics)this.instance, j);
            return this;
        }

        @Override // com.google.protobuf.z$a
        public com.google.firebase.inappmessaging.CampaignAnalytics.Builder setClientApp(com.google.firebase.inappmessaging.ClientAppInfo.Builder clientAppInfo$Builder) {
            copyOnWrite();
            CampaignAnalytics.access$800((CampaignAnalytics)this.instance, (ClientAppInfo)builder.build());
            return this;
        }

        @Override // com.google.protobuf.z$a
        public com.google.firebase.inappmessaging.CampaignAnalytics.Builder setClientApp(com.google.firebase.inappmessaging.ClientAppInfo clientAppInfo) {
            copyOnWrite();
            CampaignAnalytics.access$800((CampaignAnalytics)this.instance, clientAppInfo);
            return this;
        }

        @Override // com.google.protobuf.z$a
        public com.google.firebase.inappmessaging.CampaignAnalytics.Builder setClientTimestampMillis(long l) {
            copyOnWrite();
            CampaignAnalytics.access$1100((CampaignAnalytics)this.instance, l);
            return this;
        }

        @Override // com.google.protobuf.z$a
        public com.google.firebase.inappmessaging.CampaignAnalytics.Builder setDismissType(com.google.firebase.inappmessaging.DismissType dismissType) {
            copyOnWrite();
            CampaignAnalytics.access$1500((CampaignAnalytics)this.instance, dismissType);
            return this;
        }

        @Override // com.google.protobuf.z$a
        public com.google.firebase.inappmessaging.CampaignAnalytics.Builder setEngagementMetricsDeliveryRetryCount(int i) {
            copyOnWrite();
            CampaignAnalytics.access$2400((CampaignAnalytics)this.instance, i);
            return this;
        }

        @Override // com.google.protobuf.z$a
        public com.google.firebase.inappmessaging.CampaignAnalytics.Builder setEventType(com.google.firebase.inappmessaging.EventType eventType) {
            copyOnWrite();
            CampaignAnalytics.access$1300((CampaignAnalytics)this.instance, eventType);
            return this;
        }

        @Override // com.google.protobuf.z$a
        public com.google.firebase.inappmessaging.CampaignAnalytics.Builder setFetchErrorReason(com.google.firebase.inappmessaging.FetchErrorReason fetchErrorReason) {
            copyOnWrite();
            CampaignAnalytics.access$1900((CampaignAnalytics)this.instance, fetchErrorReason);
            return this;
        }

        @Override // com.google.protobuf.z$a
        public com.google.firebase.inappmessaging.CampaignAnalytics.Builder setFiamSdkVersion(String string) {
            copyOnWrite();
            CampaignAnalytics.access$2100((CampaignAnalytics)this.instance, string);
            return this;
        }

        @Override // com.google.protobuf.z$a
        public com.google.firebase.inappmessaging.CampaignAnalytics.Builder setFiamSdkVersionBytes(j j) {
            copyOnWrite();
            CampaignAnalytics.access$2300((CampaignAnalytics)this.instance, j);
            return this;
        }

        @Override // com.google.protobuf.z$a
        public com.google.firebase.inappmessaging.CampaignAnalytics.Builder setProjectNumber(String string) {
            copyOnWrite();
            CampaignAnalytics.access$200((CampaignAnalytics)this.instance, string);
            return this;
        }

        @Override // com.google.protobuf.z$a
        public com.google.firebase.inappmessaging.CampaignAnalytics.Builder setProjectNumberBytes(j j) {
            copyOnWrite();
            CampaignAnalytics.access$400((CampaignAnalytics)this.instance, j);
            return this;
        }

        @Override // com.google.protobuf.z$a
        public com.google.firebase.inappmessaging.CampaignAnalytics.Builder setRenderErrorReason(com.google.firebase.inappmessaging.RenderErrorReason renderErrorReason) {
            copyOnWrite();
            CampaignAnalytics.access$1700((CampaignAnalytics)this.instance, renderErrorReason);
            return this;
        }
    }
    static {
        CampaignAnalytics campaignAnalytics = new CampaignAnalytics();
        CampaignAnalytics.DEFAULT_INSTANCE = campaignAnalytics;
        z.registerDefaultInstance(CampaignAnalytics.class, campaignAnalytics);
    }

    private CampaignAnalytics() {
        super();
        int i = 0;
        String str = "";
        this.projectNumber_ = str;
        this.campaignId_ = str;
        this.fiamSdkVersion_ = str;
    }

    static com.google.firebase.inappmessaging.CampaignAnalytics access$000() {
        return CampaignAnalytics.DEFAULT_INSTANCE;
    }

    static void access$100(com.google.firebase.inappmessaging.CampaignAnalytics campaignAnalytics) {
        campaignAnalytics.clearEvent();
    }

    static void access$1000(com.google.firebase.inappmessaging.CampaignAnalytics campaignAnalytics) {
        campaignAnalytics.clearClientApp();
    }

    static void access$1100(com.google.firebase.inappmessaging.CampaignAnalytics campaignAnalytics, long l2) {
        campaignAnalytics.setClientTimestampMillis(l2);
    }

    static void access$1200(com.google.firebase.inappmessaging.CampaignAnalytics campaignAnalytics) {
        campaignAnalytics.clearClientTimestampMillis();
    }

    static void access$1300(com.google.firebase.inappmessaging.CampaignAnalytics campaignAnalytics, com.google.firebase.inappmessaging.EventType eventType2) {
        campaignAnalytics.setEventType(eventType2);
    }

    static void access$1400(com.google.firebase.inappmessaging.CampaignAnalytics campaignAnalytics) {
        campaignAnalytics.clearEventType();
    }

    static void access$1500(com.google.firebase.inappmessaging.CampaignAnalytics campaignAnalytics, com.google.firebase.inappmessaging.DismissType dismissType2) {
        campaignAnalytics.setDismissType(dismissType2);
    }

    static void access$1600(com.google.firebase.inappmessaging.CampaignAnalytics campaignAnalytics) {
        campaignAnalytics.clearDismissType();
    }

    static void access$1700(com.google.firebase.inappmessaging.CampaignAnalytics campaignAnalytics, com.google.firebase.inappmessaging.RenderErrorReason renderErrorReason2) {
        campaignAnalytics.setRenderErrorReason(renderErrorReason2);
    }

    static void access$1800(com.google.firebase.inappmessaging.CampaignAnalytics campaignAnalytics) {
        campaignAnalytics.clearRenderErrorReason();
    }

    static void access$1900(com.google.firebase.inappmessaging.CampaignAnalytics campaignAnalytics, com.google.firebase.inappmessaging.FetchErrorReason fetchErrorReason2) {
        campaignAnalytics.setFetchErrorReason(fetchErrorReason2);
    }

    static void access$200(com.google.firebase.inappmessaging.CampaignAnalytics campaignAnalytics, String string2) {
        campaignAnalytics.setProjectNumber(string2);
    }

    static void access$2000(com.google.firebase.inappmessaging.CampaignAnalytics campaignAnalytics) {
        campaignAnalytics.clearFetchErrorReason();
    }

    static void access$2100(com.google.firebase.inappmessaging.CampaignAnalytics campaignAnalytics, String string2) {
        campaignAnalytics.setFiamSdkVersion(string2);
    }

    static void access$2200(com.google.firebase.inappmessaging.CampaignAnalytics campaignAnalytics) {
        campaignAnalytics.clearFiamSdkVersion();
    }

    static void access$2300(com.google.firebase.inappmessaging.CampaignAnalytics campaignAnalytics, j j2) {
        campaignAnalytics.setFiamSdkVersionBytes(j2);
    }

    static void access$2400(com.google.firebase.inappmessaging.CampaignAnalytics campaignAnalytics, int i2) {
        campaignAnalytics.setEngagementMetricsDeliveryRetryCount(i2);
    }

    static void access$2500(com.google.firebase.inappmessaging.CampaignAnalytics campaignAnalytics) {
        campaignAnalytics.clearEngagementMetricsDeliveryRetryCount();
    }

    static void access$300(com.google.firebase.inappmessaging.CampaignAnalytics campaignAnalytics) {
        campaignAnalytics.clearProjectNumber();
    }

    static void access$400(com.google.firebase.inappmessaging.CampaignAnalytics campaignAnalytics, j j2) {
        campaignAnalytics.setProjectNumberBytes(j2);
    }

    static void access$500(com.google.firebase.inappmessaging.CampaignAnalytics campaignAnalytics, String string2) {
        campaignAnalytics.setCampaignId(string2);
    }

    static void access$600(com.google.firebase.inappmessaging.CampaignAnalytics campaignAnalytics) {
        campaignAnalytics.clearCampaignId();
    }

    static void access$700(com.google.firebase.inappmessaging.CampaignAnalytics campaignAnalytics, j j2) {
        campaignAnalytics.setCampaignIdBytes(j2);
    }

    static void access$800(com.google.firebase.inappmessaging.CampaignAnalytics campaignAnalytics, com.google.firebase.inappmessaging.ClientAppInfo clientAppInfo2) {
        campaignAnalytics.setClientApp(clientAppInfo2);
    }

    static void access$900(com.google.firebase.inappmessaging.CampaignAnalytics campaignAnalytics, com.google.firebase.inappmessaging.ClientAppInfo clientAppInfo2) {
        campaignAnalytics.mergeClientApp(clientAppInfo2);
    }

    private void clearCampaignId() {
        this.bitField0_ = bitField0_ &= -3;
        this.campaignId_ = CampaignAnalytics.getDefaultInstance().getCampaignId();
    }

    private void clearClientApp() {
        this.clientApp_ = 0;
        this.bitField0_ = bitField0_ &= -5;
    }

    private void clearClientTimestampMillis() {
        this.bitField0_ = bitField0_ &= -9;
        this.clientTimestampMillis_ = 0;
    }

    private void clearDismissType() {
        int eventCase_;
        if (this.eventCase_ == 6) {
            this.eventCase_ = 0;
            this.event_ = 0;
        }
    }

    private void clearEngagementMetricsDeliveryRetryCount() {
        this.bitField0_ = bitField0_ &= -513;
        this.engagementMetricsDeliveryRetryCount_ = 0;
    }

    private void clearEvent() {
        this.eventCase_ = 0;
        this.event_ = 0;
    }

    private void clearEventType() {
        int eventCase_;
        if (this.eventCase_ == 5) {
            this.eventCase_ = 0;
            this.event_ = 0;
        }
    }

    private void clearFetchErrorReason() {
        int eventCase_;
        if (this.eventCase_ == 8) {
            this.eventCase_ = 0;
            this.event_ = 0;
        }
    }

    private void clearFiamSdkVersion() {
        this.bitField0_ = bitField0_ &= -257;
        this.fiamSdkVersion_ = CampaignAnalytics.getDefaultInstance().getFiamSdkVersion();
    }

    private void clearProjectNumber() {
        this.bitField0_ = bitField0_ &= -2;
        this.projectNumber_ = CampaignAnalytics.getDefaultInstance().getProjectNumber();
    }

    private void clearRenderErrorReason() {
        int eventCase_;
        if (this.eventCase_ == 7) {
            this.eventCase_ = 0;
            this.event_ = 0;
        }
    }

    public static com.google.firebase.inappmessaging.CampaignAnalytics getDefaultInstance() {
        return CampaignAnalytics.DEFAULT_INSTANCE;
    }

    private void mergeClientApp(com.google.firebase.inappmessaging.ClientAppInfo clientAppInfo) {
        Object clientApp_;
        com.google.firebase.inappmessaging.ClientAppInfo defaultInstance;
        z obj3;
        clientAppInfo.getClass();
        clientApp_ = this.clientApp_;
        if (clientApp_ != null && clientApp_ != ClientAppInfo.getDefaultInstance()) {
            if (clientApp_ != ClientAppInfo.getDefaultInstance()) {
                this.clientApp_ = (ClientAppInfo)(ClientAppInfo.Builder)ClientAppInfo.newBuilder(this.clientApp_).mergeFrom(clientAppInfo).buildPartial();
            } else {
                this.clientApp_ = clientAppInfo;
            }
        } else {
        }
        this.bitField0_ = obj3 |= 4;
    }

    public static com.google.firebase.inappmessaging.CampaignAnalytics.Builder newBuilder() {
        return (CampaignAnalytics.Builder)CampaignAnalytics.DEFAULT_INSTANCE.createBuilder();
    }

    public static com.google.firebase.inappmessaging.CampaignAnalytics.Builder newBuilder(com.google.firebase.inappmessaging.CampaignAnalytics campaignAnalytics) {
        return (CampaignAnalytics.Builder)CampaignAnalytics.DEFAULT_INSTANCE.createBuilder(campaignAnalytics);
    }

    public static com.google.firebase.inappmessaging.CampaignAnalytics parseDelimitedFrom(InputStream inputStream) {
        return (CampaignAnalytics)z.parseDelimitedFrom(CampaignAnalytics.DEFAULT_INSTANCE, inputStream);
    }

    public static com.google.firebase.inappmessaging.CampaignAnalytics parseDelimitedFrom(InputStream inputStream, q q2) {
        return (CampaignAnalytics)z.parseDelimitedFrom(CampaignAnalytics.DEFAULT_INSTANCE, inputStream, q2);
    }

    public static com.google.firebase.inappmessaging.CampaignAnalytics parseFrom(j j) {
        return (CampaignAnalytics)z.parseFrom(CampaignAnalytics.DEFAULT_INSTANCE, j);
    }

    public static com.google.firebase.inappmessaging.CampaignAnalytics parseFrom(j j, q q2) {
        return (CampaignAnalytics)z.parseFrom(CampaignAnalytics.DEFAULT_INSTANCE, j, q2);
    }

    public static com.google.firebase.inappmessaging.CampaignAnalytics parseFrom(k k) {
        return (CampaignAnalytics)z.parseFrom(CampaignAnalytics.DEFAULT_INSTANCE, k);
    }

    public static com.google.firebase.inappmessaging.CampaignAnalytics parseFrom(k k, q q2) {
        return (CampaignAnalytics)z.parseFrom(CampaignAnalytics.DEFAULT_INSTANCE, k, q2);
    }

    public static com.google.firebase.inappmessaging.CampaignAnalytics parseFrom(InputStream inputStream) {
        return (CampaignAnalytics)z.parseFrom(CampaignAnalytics.DEFAULT_INSTANCE, inputStream);
    }

    public static com.google.firebase.inappmessaging.CampaignAnalytics parseFrom(InputStream inputStream, q q2) {
        return (CampaignAnalytics)z.parseFrom(CampaignAnalytics.DEFAULT_INSTANCE, inputStream, q2);
    }

    public static com.google.firebase.inappmessaging.CampaignAnalytics parseFrom(ByteBuffer byteBuffer) {
        return (CampaignAnalytics)z.parseFrom(CampaignAnalytics.DEFAULT_INSTANCE, byteBuffer);
    }

    public static com.google.firebase.inappmessaging.CampaignAnalytics parseFrom(ByteBuffer byteBuffer, q q2) {
        return (CampaignAnalytics)z.parseFrom(CampaignAnalytics.DEFAULT_INSTANCE, byteBuffer, q2);
    }

    public static com.google.firebase.inappmessaging.CampaignAnalytics parseFrom(byte[] bArr) {
        return (CampaignAnalytics)z.parseFrom(CampaignAnalytics.DEFAULT_INSTANCE, bArr);
    }

    public static com.google.firebase.inappmessaging.CampaignAnalytics parseFrom(byte[] bArr, q q2) {
        return (CampaignAnalytics)z.parseFrom(CampaignAnalytics.DEFAULT_INSTANCE, bArr, q2);
    }

    public static d1<com.google.firebase.inappmessaging.CampaignAnalytics> parser() {
        return CampaignAnalytics.DEFAULT_INSTANCE.getParserForType();
    }

    private void setCampaignId(String string) {
        string.getClass();
        this.bitField0_ = bitField0_ |= 2;
        this.campaignId_ = string;
    }

    private void setCampaignIdBytes(j j) {
        this.campaignId_ = j.R();
        this.bitField0_ = obj1 |= 2;
    }

    private void setClientApp(com.google.firebase.inappmessaging.ClientAppInfo clientAppInfo) {
        clientAppInfo.getClass();
        this.clientApp_ = clientAppInfo;
        this.bitField0_ = obj1 |= 4;
    }

    private void setClientTimestampMillis(long l) {
        this.bitField0_ = bitField0_ |= 8;
        this.clientTimestampMillis_ = l;
    }

    private void setDismissType(com.google.firebase.inappmessaging.DismissType dismissType) {
        this.event_ = Integer.valueOf(dismissType.getNumber());
        this.eventCase_ = 6;
    }

    private void setEngagementMetricsDeliveryRetryCount(int i) {
        this.bitField0_ = bitField0_ |= 512;
        this.engagementMetricsDeliveryRetryCount_ = i;
    }

    private void setEventType(com.google.firebase.inappmessaging.EventType eventType) {
        this.event_ = Integer.valueOf(eventType.getNumber());
        this.eventCase_ = 5;
    }

    private void setFetchErrorReason(com.google.firebase.inappmessaging.FetchErrorReason fetchErrorReason) {
        this.event_ = Integer.valueOf(fetchErrorReason.getNumber());
        this.eventCase_ = 8;
    }

    private void setFiamSdkVersion(String string) {
        string.getClass();
        this.bitField0_ = bitField0_ |= 256;
        this.fiamSdkVersion_ = string;
    }

    private void setFiamSdkVersionBytes(j j) {
        this.fiamSdkVersion_ = j.R();
        this.bitField0_ = obj1 |= 256;
    }

    private void setProjectNumber(String string) {
        string.getClass();
        this.bitField0_ = bitField0_ |= 1;
        this.projectNumber_ = string;
    }

    private void setProjectNumberBytes(j j) {
        this.projectNumber_ = j.R();
        this.bitField0_ = obj1 |= 1;
    }

    private void setRenderErrorReason(com.google.firebase.inappmessaging.RenderErrorReason renderErrorReason) {
        this.event_ = Integer.valueOf(renderErrorReason.getNumber());
        this.eventCase_ = 7;
    }

    @Override // com.google.protobuf.z
    protected final Object dynamicMethod(z.f z$f, Object object2, Object object3) {
        d1 obj2;
        int obj3;
        int obj4;
        obj3 = 1;
        obj4 = 0;
        switch (obj2) {
            case 1:
                obj2 = new CampaignAnalytics();
                return obj2;
            case 2:
                obj2 = new CampaignAnalytics.Builder(obj4);
                return obj2;
            case 3:
                obj2 = new Object[13];
                obj2[obj3] = "eventCase_";
                obj2[2] = "bitField0_";
                obj2[3] = "projectNumber_";
                obj2[4] = "campaignId_";
                obj2[5] = "clientApp_";
                obj2[6] = "clientTimestampMillis_";
                obj2[7] = EventType.internalGetVerifier();
                obj2[8] = DismissType.internalGetVerifier();
                obj2[9] = RenderErrorReason.internalGetVerifier();
                obj2[10] = FetchErrorReason.internalGetVerifier();
                obj2[11] = "fiamSdkVersion_";
                obj2[12] = "engagementMetricsDeliveryRetryCount_";
                return z.newMessageInfo(CampaignAnalytics.DEFAULT_INSTANCE, "\u0001\n\u0001\u0001\u0001\n\n\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဈ\u0001\u0003ဉ\u0002\u0004ဂ\u0003\u0005ဿ\u0000\u0006ဿ\u0000\u0007ဿ\u0000\u0008ဿ\u0000\tဈ\u0008\nင\t", obj2);
            case 4:
                return CampaignAnalytics.DEFAULT_INSTANCE;
            case 5:
                return obj2;
            case 6:
                return Byte.valueOf(obj3);
            case 7:
                return obj4;
            default:
                obj2 = new UnsupportedOperationException();
                throw obj2;
        }
        obj3 = CampaignAnalytics.class;
        synchronized (obj3) {
            obj2 = new z.b(CampaignAnalytics.DEFAULT_INSTANCE);
            CampaignAnalytics.PARSER = obj2;
        }
    }

    @Override // com.google.protobuf.z
    public String getCampaignId() {
        return this.campaignId_;
    }

    @Override // com.google.protobuf.z
    public j getCampaignIdBytes() {
        return j.u(this.campaignId_);
    }

    @Override // com.google.protobuf.z
    public com.google.firebase.inappmessaging.ClientAppInfo getClientApp() {
        com.google.firebase.inappmessaging.ClientAppInfo defaultInstance;
        if (this.clientApp_ == null) {
            defaultInstance = ClientAppInfo.getDefaultInstance();
        }
        return defaultInstance;
    }

    @Override // com.google.protobuf.z
    public long getClientTimestampMillis() {
        return this.clientTimestampMillis_;
    }

    @Override // com.google.protobuf.z
    public com.google.firebase.inappmessaging.DismissType getDismissType() {
        com.google.firebase.inappmessaging.DismissType uNKNOWN_DISMISS_TYPE;
        if (this.eventCase_ == 6 && DismissType.forNumber((Integer)this.event_.intValue()) == null) {
            if (DismissType.forNumber((Integer)this.event_.intValue()) == null) {
                uNKNOWN_DISMISS_TYPE = DismissType.UNKNOWN_DISMISS_TYPE;
            }
            return uNKNOWN_DISMISS_TYPE;
        }
        return DismissType.UNKNOWN_DISMISS_TYPE;
    }

    @Override // com.google.protobuf.z
    public int getEngagementMetricsDeliveryRetryCount() {
        return this.engagementMetricsDeliveryRetryCount_;
    }

    @Override // com.google.protobuf.z
    public com.google.firebase.inappmessaging.CampaignAnalytics.EventCase getEventCase() {
        return CampaignAnalytics.EventCase.forNumber(this.eventCase_);
    }

    @Override // com.google.protobuf.z
    public com.google.firebase.inappmessaging.EventType getEventType() {
        com.google.firebase.inappmessaging.EventType uNKNOWN_EVENT_TYPE;
        if (this.eventCase_ == 5 && EventType.forNumber((Integer)this.event_.intValue()) == null) {
            if (EventType.forNumber((Integer)this.event_.intValue()) == null) {
                uNKNOWN_EVENT_TYPE = EventType.UNKNOWN_EVENT_TYPE;
            }
            return uNKNOWN_EVENT_TYPE;
        }
        return EventType.UNKNOWN_EVENT_TYPE;
    }

    @Override // com.google.protobuf.z
    public com.google.firebase.inappmessaging.FetchErrorReason getFetchErrorReason() {
        com.google.firebase.inappmessaging.FetchErrorReason uNSPECIFIED_FETCH_ERROR;
        if (this.eventCase_ == 8 && FetchErrorReason.forNumber((Integer)this.event_.intValue()) == null) {
            if (FetchErrorReason.forNumber((Integer)this.event_.intValue()) == null) {
                uNSPECIFIED_FETCH_ERROR = FetchErrorReason.UNSPECIFIED_FETCH_ERROR;
            }
            return uNSPECIFIED_FETCH_ERROR;
        }
        return FetchErrorReason.UNSPECIFIED_FETCH_ERROR;
    }

    @Override // com.google.protobuf.z
    public String getFiamSdkVersion() {
        return this.fiamSdkVersion_;
    }

    @Override // com.google.protobuf.z
    public j getFiamSdkVersionBytes() {
        return j.u(this.fiamSdkVersion_);
    }

    @Override // com.google.protobuf.z
    public String getProjectNumber() {
        return this.projectNumber_;
    }

    @Override // com.google.protobuf.z
    public j getProjectNumberBytes() {
        return j.u(this.projectNumber_);
    }

    @Override // com.google.protobuf.z
    public com.google.firebase.inappmessaging.RenderErrorReason getRenderErrorReason() {
        com.google.firebase.inappmessaging.RenderErrorReason uNSPECIFIED_RENDER_ERROR;
        if (this.eventCase_ == 7 && RenderErrorReason.forNumber((Integer)this.event_.intValue()) == null) {
            if (RenderErrorReason.forNumber((Integer)this.event_.intValue()) == null) {
                uNSPECIFIED_RENDER_ERROR = RenderErrorReason.UNSPECIFIED_RENDER_ERROR;
            }
            return uNSPECIFIED_RENDER_ERROR;
        }
        return RenderErrorReason.UNSPECIFIED_RENDER_ERROR;
    }

    @Override // com.google.protobuf.z
    public boolean hasCampaignId() {
        int i;
        i = bitField0_ &= 2 != 0 ? 1 : 0;
        return i;
    }

    @Override // com.google.protobuf.z
    public boolean hasClientApp() {
        int i;
        i = bitField0_ &= 4 != 0 ? 1 : 0;
        return i;
    }

    @Override // com.google.protobuf.z
    public boolean hasClientTimestampMillis() {
        int i;
        i = bitField0_ &= 8 != 0 ? 1 : 0;
        return i;
    }

    @Override // com.google.protobuf.z
    public boolean hasDismissType() {
        int i;
        i = this.eventCase_ == 6 ? 1 : 0;
        return i;
    }

    @Override // com.google.protobuf.z
    public boolean hasEngagementMetricsDeliveryRetryCount() {
        int i;
        i = bitField0_ &= 512 != 0 ? 1 : 0;
        return i;
    }

    @Override // com.google.protobuf.z
    public boolean hasEventType() {
        int i;
        i = this.eventCase_ == 5 ? 1 : 0;
        return i;
    }

    @Override // com.google.protobuf.z
    public boolean hasFetchErrorReason() {
        int i;
        i = this.eventCase_ == 8 ? 1 : 0;
        return i;
    }

    @Override // com.google.protobuf.z
    public boolean hasFiamSdkVersion() {
        int i;
        i = bitField0_ &= 256 != 0 ? 1 : 0;
        return i;
    }

    @Override // com.google.protobuf.z
    public boolean hasProjectNumber() {
        int i;
        if (bitField0_ &= i != 0) {
        } else {
            i = 0;
        }
        return i;
    }

    @Override // com.google.protobuf.z
    public boolean hasRenderErrorReason() {
        int i;
        i = this.eventCase_ == 7 ? 1 : 0;
        return i;
    }
}
