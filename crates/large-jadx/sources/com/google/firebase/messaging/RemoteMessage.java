package com.google.firebase.messaging;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.internal.safeparcel.a;
import d.e.a;
import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/* loaded from: classes2.dex */
public final class RemoteMessage extends a {

    public static final Parcelable.Creator<com.google.firebase.messaging.RemoteMessage> CREATOR = null;
    public static final int PRIORITY_HIGH = 1;
    public static final int PRIORITY_NORMAL = 2;
    public static final int PRIORITY_UNKNOWN;
    Bundle bundle;
    private Map<String, String> data;
    private com.google.firebase.messaging.RemoteMessage.Notification notification;

    public static class Builder {

        private final Bundle bundle;
        private final Map<String, String> data;
        public Builder(String string) {
            String obj4;
            super();
            Bundle bundle = new Bundle();
            this.bundle = bundle;
            a aVar = new a();
            this.data = aVar;
            if (TextUtils.isEmpty(string)) {
                obj4 = String.valueOf(string);
                String str2 = "Invalid to: ";
                if (obj4.length() != 0) {
                    obj4 = str2.concat(obj4);
                } else {
                    obj4 = new String(str2);
                }
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException(obj4);
                throw illegalArgumentException;
            }
            bundle.putString("google.to", string);
        }

        public com.google.firebase.messaging.RemoteMessage.Builder addData(String string, String string2) {
            this.data.put(string, string2);
            return this;
        }

        public com.google.firebase.messaging.RemoteMessage build() {
            Object value;
            Object key;
            Bundle bundle = new Bundle();
            Iterator iterator = this.data.entrySet().iterator();
            for (Map.Entry next2 : iterator) {
                bundle.putString((String)next2.getKey(), (String)next2.getValue());
            }
            bundle.putAll(this.bundle);
            this.bundle.remove("from");
            RemoteMessage remoteMessage = new RemoteMessage(bundle);
            return remoteMessage;
        }

        public com.google.firebase.messaging.RemoteMessage.Builder clearData() {
            this.data.clear();
            return this;
        }

        public com.google.firebase.messaging.RemoteMessage.Builder setCollapseKey(String string) {
            this.bundle.putString("collapse_key", string);
            return this;
        }

        public com.google.firebase.messaging.RemoteMessage.Builder setData(Map<String, String> map) {
            this.data.clear();
            this.data.putAll(map);
            return this;
        }

        public com.google.firebase.messaging.RemoteMessage.Builder setMessageId(String string) {
            this.bundle.putString("google.message_id", string);
            return this;
        }

        public com.google.firebase.messaging.RemoteMessage.Builder setMessageType(String string) {
            this.bundle.putString("message_type", string);
            return this;
        }

        public com.google.firebase.messaging.RemoteMessage.Builder setRawData(byte[] bArr) {
            this.bundle.putByteArray("rawData", bArr);
            return this;
        }

        public com.google.firebase.messaging.RemoteMessage.Builder setTtl(int i) {
            this.bundle.putString("google.ttl", String.valueOf(i));
            return this;
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface MessagePriority {
    }

    public final class Notification-IA {
    }

    public static class Notification {

        private final String body;
        private final String[] bodyLocArgs;
        private final String bodyLocKey;
        private final String channelId;
        private final String clickAction;
        private final String color;
        private final boolean defaultLightSettings;
        private final boolean defaultSound;
        private final boolean defaultVibrateTimings;
        private final Long eventTime;
        private final String icon;
        private final String imageUrl;
        private final int[] lightSettings;
        private final Uri link;
        private final boolean localOnly;
        private final Integer notificationCount;
        private final Integer notificationPriority;
        private final String sound;
        private final boolean sticky;
        private final String tag;
        private final String ticker;
        private final String title;
        private final String[] titleLocArgs;
        private final String titleLocKey;
        private final long[] vibrateTimings;
        private final Integer visibility;
        private Notification(com.google.firebase.messaging.NotificationParams notificationParams) {
            super();
            String str = "gcm.n.title";
            this.title = notificationParams.getString(str);
            this.titleLocKey = notificationParams.getLocalizationResourceForKey(str);
            this.titleLocArgs = RemoteMessage.Notification.getLocalizationArgs(notificationParams, str);
            String str2 = "gcm.n.body";
            this.body = notificationParams.getString(str2);
            this.bodyLocKey = notificationParams.getLocalizationResourceForKey(str2);
            this.bodyLocArgs = RemoteMessage.Notification.getLocalizationArgs(notificationParams, str2);
            this.icon = notificationParams.getString("gcm.n.icon");
            this.sound = notificationParams.getSoundResourceName();
            this.tag = notificationParams.getString("gcm.n.tag");
            this.color = notificationParams.getString("gcm.n.color");
            this.clickAction = notificationParams.getString("gcm.n.click_action");
            this.channelId = notificationParams.getString("gcm.n.android_channel_id");
            this.link = notificationParams.getLink();
            this.imageUrl = notificationParams.getString("gcm.n.image");
            this.ticker = notificationParams.getString("gcm.n.ticker");
            this.notificationPriority = notificationParams.getInteger("gcm.n.notification_priority");
            this.visibility = notificationParams.getInteger("gcm.n.visibility");
            this.notificationCount = notificationParams.getInteger("gcm.n.notification_count");
            this.sticky = notificationParams.getBoolean("gcm.n.sticky");
            this.localOnly = notificationParams.getBoolean("gcm.n.local_only");
            this.defaultSound = notificationParams.getBoolean("gcm.n.default_sound");
            this.defaultVibrateTimings = notificationParams.getBoolean("gcm.n.default_vibrate_timings");
            this.defaultLightSettings = notificationParams.getBoolean("gcm.n.default_light_settings");
            this.eventTime = notificationParams.getLong("gcm.n.event_time");
            this.lightSettings = notificationParams.getLightSettings();
            this.vibrateTimings = notificationParams.getVibrateTimings();
        }

        Notification(com.google.firebase.messaging.NotificationParams notificationParams, com.google.firebase.messaging.RemoteMessage.Notification-IA remoteMessage$Notification-IA2) {
            super(notificationParams);
        }

        private static String[] getLocalizationArgs(com.google.firebase.messaging.NotificationParams notificationParams, String string2) {
            int i;
            String valueOf;
            Object[] obj2 = notificationParams.getLocalizationArgsForKey(string2);
            if (obj2 == null) {
                return null;
            }
            String[] obj3 = new String[obj2.length];
            i = 0;
            for (Object obj : notificationParams) {
                obj3[i] = String.valueOf(obj);
            }
            return obj3;
        }

        public String getBody() {
            return this.body;
        }

        public String[] getBodyLocalizationArgs() {
            return this.bodyLocArgs;
        }

        public String getBodyLocalizationKey() {
            return this.bodyLocKey;
        }

        public String getChannelId() {
            return this.channelId;
        }

        public String getClickAction() {
            return this.clickAction;
        }

        public String getColor() {
            return this.color;
        }

        public boolean getDefaultLightSettings() {
            return this.defaultLightSettings;
        }

        public boolean getDefaultSound() {
            return this.defaultSound;
        }

        public boolean getDefaultVibrateSettings() {
            return this.defaultVibrateTimings;
        }

        public Long getEventTime() {
            return this.eventTime;
        }

        public String getIcon() {
            return this.icon;
        }

        public Uri getImageUrl() {
            String imageUrl = this.imageUrl;
            if (imageUrl != null) {
                return Uri.parse(imageUrl);
            }
            return null;
        }

        public int[] getLightSettings() {
            return this.lightSettings;
        }

        public Uri getLink() {
            return this.link;
        }

        public boolean getLocalOnly() {
            return this.localOnly;
        }

        public Integer getNotificationCount() {
            return this.notificationCount;
        }

        public Integer getNotificationPriority() {
            return this.notificationPriority;
        }

        public String getSound() {
            return this.sound;
        }

        public boolean getSticky() {
            return this.sticky;
        }

        public String getTag() {
            return this.tag;
        }

        public String getTicker() {
            return this.ticker;
        }

        public String getTitle() {
            return this.title;
        }

        public String[] getTitleLocalizationArgs() {
            return this.titleLocArgs;
        }

        public String getTitleLocalizationKey() {
            return this.titleLocKey;
        }

        public long[] getVibrateTimings() {
            return this.vibrateTimings;
        }

        public Integer getVisibility() {
            return this.visibility;
        }
    }
    static {
        RemoteMessageCreator remoteMessageCreator = new RemoteMessageCreator();
        RemoteMessage.CREATOR = remoteMessageCreator;
    }

    public RemoteMessage(Bundle bundle) {
        super();
        this.bundle = bundle;
    }

    private int getMessagePriority(String string) {
        if ("high".equals(string)) {
            return 1;
        }
        if ("normal".equals(string)) {
            return 2;
        }
        return 0;
    }

    @Override // com.google.android.gms.common.internal.safeparcel.a
    public String getCollapseKey() {
        return this.bundle.getString("collapse_key");
    }

    public Map<String, String> getData() {
        Object developerDefinedPayload;
        if (this.data == null) {
            this.data = Constants.MessagePayloadKeys.extractDeveloperDefinedPayload(this.bundle);
        }
        return this.data;
    }

    @Override // com.google.android.gms.common.internal.safeparcel.a
    public String getFrom() {
        return this.bundle.getString("from");
    }

    @Override // com.google.android.gms.common.internal.safeparcel.a
    public String getMessageId() {
        String string;
        String str;
        if (this.bundle.getString("google.message_id") == null) {
            string = this.bundle.getString("message_id");
        }
        return string;
    }

    @Override // com.google.android.gms.common.internal.safeparcel.a
    public String getMessageType() {
        return this.bundle.getString("message_type");
    }

    @Override // com.google.android.gms.common.internal.safeparcel.a
    public com.google.firebase.messaging.RemoteMessage.Notification getNotification() {
        com.google.firebase.messaging.RemoteMessage.Notification notification;
        com.google.firebase.messaging.NotificationParams notificationParams;
        int i;
        if (this.notification == null && NotificationParams.isNotification(this.bundle)) {
            if (NotificationParams.isNotification(this.bundle)) {
                notificationParams = new NotificationParams(this.bundle);
                notification = new RemoteMessage.Notification(notificationParams, 0);
                this.notification = notification;
            }
        }
        return this.notification;
    }

    @Override // com.google.android.gms.common.internal.safeparcel.a
    public int getOriginalPriority() {
        String string;
        String str;
        if (this.bundle.getString("google.original_priority") == null) {
            string = this.bundle.getString("google.priority");
        }
        return getMessagePriority(string);
    }

    @Override // com.google.android.gms.common.internal.safeparcel.a
    public int getPriority() {
        String string;
        String str;
        if (this.bundle.getString("google.delivered_priority") == null && "1".equals(this.bundle.getString("google.priority_reduced"))) {
            if ("1".equals(this.bundle.getString("google.priority_reduced"))) {
                return 2;
            }
            string = this.bundle.getString("google.priority");
        }
        return getMessagePriority(string);
    }

    @Override // com.google.android.gms.common.internal.safeparcel.a
    public byte[] getRawData() {
        return this.bundle.getByteArray("rawData");
    }

    @Override // com.google.android.gms.common.internal.safeparcel.a
    public String getSenderId() {
        return this.bundle.getString("google.c.sender.id");
    }

    @Override // com.google.android.gms.common.internal.safeparcel.a
    public long getSentTime() {
        Object obj;
        boolean z;
        obj = this.bundle.get("google.sent_time");
        if (obj instanceof Long) {
            return (Long)obj.longValue();
        }
        if (obj instanceof String != null) {
            return Long.parseLong((String)obj);
        }
        return 0;
    }

    @Override // com.google.android.gms.common.internal.safeparcel.a
    public String getTo() {
        return this.bundle.getString("google.to");
    }

    @Override // com.google.android.gms.common.internal.safeparcel.a
    public int getTtl() {
        Object obj;
        boolean z;
        obj = this.bundle.get("google.ttl");
        if (obj instanceof Integer) {
            return (Integer)obj.intValue();
        }
        if (obj instanceof String != null) {
            return Integer.parseInt((String)obj);
        }
        return 0;
    }

    @Override // com.google.android.gms.common.internal.safeparcel.a
    void populateSendMessageIntent(Intent intent) {
        intent.putExtras(this.bundle);
    }

    @Override // com.google.android.gms.common.internal.safeparcel.a
    public Intent toIntent() {
        Intent intent = new Intent();
        intent.putExtras(this.bundle);
        return intent;
    }

    @Override // com.google.android.gms.common.internal.safeparcel.a
    public void writeToParcel(Parcel parcel, int i2) {
        RemoteMessageCreator.writeToParcel(this, parcel, i2);
    }
}
