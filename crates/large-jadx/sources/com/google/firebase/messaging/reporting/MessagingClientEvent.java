package com.google.firebase.messaging.reporting;

import f.c.a.d.b.h.q;
import f.c.a.d.b.h.s;

/* loaded from: classes2.dex */
public final class MessagingClientEvent {

    private static final com.google.firebase.messaging.reporting.MessagingClientEvent DEFAULT_INSTANCE;
    private final String analytics_label_;
    private final long bulk_id_;
    private final long campaign_id_;
    private final String collapse_key_;
    private final String composer_label_;
    private final com.google.firebase.messaging.reporting.MessagingClientEvent.Event event_;
    private final String instance_id_;
    private final String message_id_;
    private final com.google.firebase.messaging.reporting.MessagingClientEvent.MessageType message_type_;
    private final String package_name_;
    private final int priority_;
    private final long project_number_;
    private final com.google.firebase.messaging.reporting.MessagingClientEvent.SDKPlatform sdk_platform_;
    private final String topic_;
    private final int ttl_;

    public static final class Builder {

        private String analytics_label_;
        private long bulk_id_ = 0;
        private long campaign_id_ = 0;
        private String collapse_key_;
        private String composer_label_;
        private com.google.firebase.messaging.reporting.MessagingClientEvent.Event event_ = null;
        private String instance_id_;
        private String message_id_;
        private com.google.firebase.messaging.reporting.MessagingClientEvent.MessageType message_type_;
        private String package_name_;
        private int priority_ = 0;
        private long project_number_ = 0;
        private com.google.firebase.messaging.reporting.MessagingClientEvent.SDKPlatform sdk_platform_;
        private String topic_;
        private int ttl_ = 0;
        Builder() {
            super();
            final int i = 0;
            final String str = "";
            this.message_id_ = str;
            this.instance_id_ = str;
            this.message_type_ = MessagingClientEvent.MessageType.UNKNOWN;
            this.sdk_platform_ = MessagingClientEvent.SDKPlatform.UNKNOWN_OS;
            this.package_name_ = str;
            this.collapse_key_ = str;
            int i2 = 0;
            this.topic_ = str;
            com.google.firebase.messaging.reporting.MessagingClientEvent.Event uNKNOWN_EVENT = MessagingClientEvent.Event.UNKNOWN_EVENT;
            this.analytics_label_ = str;
            this.composer_label_ = str;
        }

        public com.google.firebase.messaging.reporting.MessagingClientEvent build() {
            final Object obj = this;
            super(obj.project_number_, obj3, obj.message_id_, obj.instance_id_, obj.message_type_, obj.sdk_platform_, obj.package_name_, obj.collapse_key_, obj.priority_, obj.ttl_, obj.topic_, obj.bulk_id_, obj14, obj.event_, obj.analytics_label_, obj.campaign_id_, obj18, obj.composer_label_);
            return messagingClientEvent;
        }

        public com.google.firebase.messaging.reporting.MessagingClientEvent.Builder setAnalyticsLabel(String string) {
            this.analytics_label_ = string;
            return this;
        }

        public com.google.firebase.messaging.reporting.MessagingClientEvent.Builder setBulkId(long l) {
            this.bulk_id_ = l;
            return this;
        }

        public com.google.firebase.messaging.reporting.MessagingClientEvent.Builder setCampaignId(long l) {
            this.campaign_id_ = l;
            return this;
        }

        public com.google.firebase.messaging.reporting.MessagingClientEvent.Builder setCollapseKey(String string) {
            this.collapse_key_ = string;
            return this;
        }

        public com.google.firebase.messaging.reporting.MessagingClientEvent.Builder setComposerLabel(String string) {
            this.composer_label_ = string;
            return this;
        }

        public com.google.firebase.messaging.reporting.MessagingClientEvent.Builder setEvent(com.google.firebase.messaging.reporting.MessagingClientEvent.Event messagingClientEvent$Event) {
            this.event_ = event;
            return this;
        }

        public com.google.firebase.messaging.reporting.MessagingClientEvent.Builder setInstanceId(String string) {
            this.instance_id_ = string;
            return this;
        }

        public com.google.firebase.messaging.reporting.MessagingClientEvent.Builder setMessageId(String string) {
            this.message_id_ = string;
            return this;
        }

        public com.google.firebase.messaging.reporting.MessagingClientEvent.Builder setMessageType(com.google.firebase.messaging.reporting.MessagingClientEvent.MessageType messagingClientEvent$MessageType) {
            this.message_type_ = messageType;
            return this;
        }

        public com.google.firebase.messaging.reporting.MessagingClientEvent.Builder setPackageName(String string) {
            this.package_name_ = string;
            return this;
        }

        public com.google.firebase.messaging.reporting.MessagingClientEvent.Builder setPriority(int i) {
            this.priority_ = i;
            return this;
        }

        public com.google.firebase.messaging.reporting.MessagingClientEvent.Builder setProjectNumber(long l) {
            this.project_number_ = l;
            return this;
        }

        public com.google.firebase.messaging.reporting.MessagingClientEvent.Builder setSdkPlatform(com.google.firebase.messaging.reporting.MessagingClientEvent.SDKPlatform messagingClientEvent$SDKPlatform) {
            this.sdk_platform_ = sDKPlatform;
            return this;
        }

        public com.google.firebase.messaging.reporting.MessagingClientEvent.Builder setTopic(String string) {
            this.topic_ = string;
            return this;
        }

        public com.google.firebase.messaging.reporting.MessagingClientEvent.Builder setTtl(int i) {
            this.ttl_ = i;
            return this;
        }
    }

    public static enum Event implements q {

        UNKNOWN_EVENT(false),
        MESSAGE_DELIVERED(false),
        MESSAGE_OPEN(false);

        private final int number_;
        private static com.google.firebase.messaging.reporting.MessagingClientEvent.Event[] $values() {
            com.google.firebase.messaging.reporting.MessagingClientEvent.Event[] arr = new MessagingClientEvent.Event[3];
            return arr;
        }

        @Override // java.lang.Enum
        public int getNumber() {
            return this.number_;
        }
    }

    public static enum MessageType implements q {

        UNKNOWN(false),
        DATA_MESSAGE(false),
        TOPIC(false),
        DISPLAY_NOTIFICATION(false);

        private final int number_;
        private static com.google.firebase.messaging.reporting.MessagingClientEvent.MessageType[] $values() {
            com.google.firebase.messaging.reporting.MessagingClientEvent.MessageType[] arr = new MessagingClientEvent.MessageType[4];
            return arr;
        }

        @Override // java.lang.Enum
        public int getNumber() {
            return this.number_;
        }
    }

    public static enum SDKPlatform implements q {

        UNKNOWN_OS(false),
        ANDROID(false),
        IOS(false),
        WEB(false);

        private final int number_;
        private static com.google.firebase.messaging.reporting.MessagingClientEvent.SDKPlatform[] $values() {
            com.google.firebase.messaging.reporting.MessagingClientEvent.SDKPlatform[] arr = new MessagingClientEvent.SDKPlatform[4];
            return arr;
        }

        @Override // java.lang.Enum
        public int getNumber() {
            return this.number_;
        }
    }
    static {
        MessagingClientEvent.Builder builder = new MessagingClientEvent.Builder();
        MessagingClientEvent.DEFAULT_INSTANCE = builder.build();
    }

    MessagingClientEvent(long l, String string2, String string3, com.google.firebase.messaging.reporting.MessagingClientEvent.MessageType messagingClientEvent$MessageType4, com.google.firebase.messaging.reporting.MessagingClientEvent.SDKPlatform messagingClientEvent$SDKPlatform5, String string6, String string7, int i8, int i9, String string10, long l11, com.google.firebase.messaging.reporting.MessagingClientEvent.Event messagingClientEvent$Event12, String string13, long l14, String string15) {
        final Object obj = this;
        super();
        obj.project_number_ = l;
        obj.message_id_ = string3;
        obj.instance_id_ = messageType4;
        obj.message_type_ = sDKPlatform5;
        obj.sdk_platform_ = string6;
        obj.package_name_ = string7;
        obj.collapse_key_ = i8;
        obj.priority_ = i9;
        obj.ttl_ = string10;
        obj.topic_ = l11;
        obj.bulk_id_ = event12;
        obj.event_ = l14;
        obj.analytics_label_ = string15;
        obj.campaign_id_ = obj19;
        obj.composer_label_ = obj21;
    }

    public static com.google.firebase.messaging.reporting.MessagingClientEvent getDefaultInstance() {
        return MessagingClientEvent.DEFAULT_INSTANCE;
    }

    public static com.google.firebase.messaging.reporting.MessagingClientEvent.Builder newBuilder() {
        MessagingClientEvent.Builder builder = new MessagingClientEvent.Builder();
        return builder;
    }

    public String getAnalyticsLabel() {
        return this.analytics_label_;
    }

    public long getBulkId() {
        return this.bulk_id_;
    }

    public long getCampaignId() {
        return this.campaign_id_;
    }

    public String getCollapseKey() {
        return this.collapse_key_;
    }

    public String getComposerLabel() {
        return this.composer_label_;
    }

    public com.google.firebase.messaging.reporting.MessagingClientEvent.Event getEvent() {
        return this.event_;
    }

    public String getInstanceId() {
        return this.instance_id_;
    }

    public String getMessageId() {
        return this.message_id_;
    }

    public com.google.firebase.messaging.reporting.MessagingClientEvent.MessageType getMessageType() {
        return this.message_type_;
    }

    public String getPackageName() {
        return this.package_name_;
    }

    public int getPriority() {
        return this.priority_;
    }

    public long getProjectNumber() {
        return this.project_number_;
    }

    public com.google.firebase.messaging.reporting.MessagingClientEvent.SDKPlatform getSdkPlatform() {
        return this.sdk_platform_;
    }

    public String getTopic() {
        return this.topic_;
    }

    public int getTtl() {
        return this.ttl_;
    }
}
