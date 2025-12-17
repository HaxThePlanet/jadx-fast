package androidx.core.app;

import android.app.Notification;
import android.app.NotificationChannel;
import android.media.AudioAttributes;
import android.net.Uri;
import android.os.Build.VERSION;
import android.provider.Settings.System;
import androidx.core.util.Preconditions;

/* loaded from: classes5.dex */
public class NotificationChannelCompat {

    public static final String DEFAULT_CHANNEL_ID = "miscellaneous";
    private static final int DEFAULT_LIGHT_COLOR = 0;
    private static final boolean DEFAULT_SHOW_BADGE = true;
    AudioAttributes mAudioAttributes;
    private boolean mBypassDnd;
    private boolean mCanBubble;
    String mConversationId;
    String mDescription;
    String mGroupId;
    final String mId;
    int mImportance;
    private boolean mImportantConversation;
    int mLightColor;
    boolean mLights;
    private int mLockscreenVisibility;
    java.lang.CharSequence mName;
    String mParentId;
    boolean mShowBadge;
    Uri mSound;
    boolean mVibrationEnabled;
    long[] mVibrationPattern;

    static class Api26Impl {
        static boolean canBypassDnd(NotificationChannel notificationChannel) {
            return notificationChannel.canBypassDnd();
        }

        static boolean canShowBadge(NotificationChannel notificationChannel) {
            return notificationChannel.canShowBadge();
        }

        static NotificationChannel createNotificationChannel(String id, java.lang.CharSequence name, int importance) {
            NotificationChannel notificationChannel = new NotificationChannel(id, name, importance);
            return notificationChannel;
        }

        static void enableLights(NotificationChannel notificationChannel, boolean lights) {
            notificationChannel.enableLights(lights);
        }

        static void enableVibration(NotificationChannel notificationChannel, boolean vibration) {
            notificationChannel.enableVibration(vibration);
        }

        static AudioAttributes getAudioAttributes(NotificationChannel notificationChannel) {
            return notificationChannel.getAudioAttributes();
        }

        static String getDescription(NotificationChannel notificationChannel) {
            return notificationChannel.getDescription();
        }

        static String getGroup(NotificationChannel notificationChannel) {
            return notificationChannel.getGroup();
        }

        static String getId(NotificationChannel notificationChannel) {
            return notificationChannel.getId();
        }

        static int getImportance(NotificationChannel notificationChannel) {
            return notificationChannel.getImportance();
        }

        static int getLightColor(NotificationChannel notificationChannel) {
            return notificationChannel.getLightColor();
        }

        static int getLockscreenVisibility(NotificationChannel notificationChannel) {
            return notificationChannel.getLockscreenVisibility();
        }

        static java.lang.CharSequence getName(NotificationChannel notificationChannel) {
            return notificationChannel.getName();
        }

        static Uri getSound(NotificationChannel notificationChannel) {
            return notificationChannel.getSound();
        }

        static long[] getVibrationPattern(NotificationChannel notificationChannel) {
            return notificationChannel.getVibrationPattern();
        }

        static void setDescription(NotificationChannel notificationChannel, String description) {
            notificationChannel.setDescription(description);
        }

        static void setGroup(NotificationChannel notificationChannel, String groupId) {
            notificationChannel.setGroup(groupId);
        }

        static void setLightColor(NotificationChannel notificationChannel, int argb) {
            notificationChannel.setLightColor(argb);
        }

        static void setShowBadge(NotificationChannel notificationChannel, boolean showBadge) {
            notificationChannel.setShowBadge(showBadge);
        }

        static void setSound(NotificationChannel notificationChannel, Uri sound, AudioAttributes audioAttributes) {
            notificationChannel.setSound(sound, audioAttributes);
        }

        static void setVibrationPattern(NotificationChannel notificationChannel, long[] vibrationPattern) {
            notificationChannel.setVibrationPattern(vibrationPattern);
        }

        static boolean shouldShowLights(NotificationChannel notificationChannel) {
            return notificationChannel.shouldShowLights();
        }

        static boolean shouldVibrate(NotificationChannel notificationChannel) {
            return notificationChannel.shouldVibrate();
        }
    }

    static class Api29Impl {
        static boolean canBubble(NotificationChannel notificationChannel) {
            return notificationChannel.canBubble();
        }
    }

    static class Api30Impl {
        static String getConversationId(NotificationChannel notificationChannel) {
            return notificationChannel.getConversationId();
        }

        static String getParentChannelId(NotificationChannel notificationChannel) {
            return notificationChannel.getParentChannelId();
        }

        static boolean isImportantConversation(NotificationChannel notificationChannel) {
            return notificationChannel.isImportantConversation();
        }

        static void setConversationId(NotificationChannel notificationChannel, String parentChannelId, String conversationId) {
            notificationChannel.setConversationId(parentChannelId, conversationId);
        }
    }

    public static class Builder {

        private final androidx.core.app.NotificationChannelCompat mChannel;
        public Builder(String id, int importance) {
            super();
            NotificationChannelCompat notificationChannelCompat = new NotificationChannelCompat(id, importance);
            this.mChannel = notificationChannelCompat;
        }

        public androidx.core.app.NotificationChannelCompat build() {
            return this.mChannel;
        }

        public androidx.core.app.NotificationChannelCompat.Builder setConversationId(String parentChannelId, String conversationId) {
            int mChannel;
            if (Build.VERSION.SDK_INT >= 30) {
                mChannel2.mParentId = parentChannelId;
                mChannel.mConversationId = conversationId;
            }
            return this;
        }

        public androidx.core.app.NotificationChannelCompat.Builder setDescription(String description) {
            mChannel.mDescription = description;
            return this;
        }

        public androidx.core.app.NotificationChannelCompat.Builder setGroup(String groupId) {
            mChannel.mGroupId = groupId;
            return this;
        }

        public androidx.core.app.NotificationChannelCompat.Builder setImportance(int importance) {
            mChannel.mImportance = importance;
            return this;
        }

        public androidx.core.app.NotificationChannelCompat.Builder setLightColor(int argb) {
            mChannel.mLightColor = argb;
            return this;
        }

        public androidx.core.app.NotificationChannelCompat.Builder setLightsEnabled(boolean lights) {
            mChannel.mLights = lights;
            return this;
        }

        public androidx.core.app.NotificationChannelCompat.Builder setName(java.lang.CharSequence name) {
            mChannel.mName = name;
            return this;
        }

        public androidx.core.app.NotificationChannelCompat.Builder setShowBadge(boolean showBadge) {
            mChannel.mShowBadge = showBadge;
            return this;
        }

        public androidx.core.app.NotificationChannelCompat.Builder setSound(Uri sound, AudioAttributes audioAttributes) {
            mChannel.mSound = sound;
            mChannel2.mAudioAttributes = audioAttributes;
            return this;
        }

        public androidx.core.app.NotificationChannelCompat.Builder setVibrationEnabled(boolean vibration) {
            mChannel.mVibrationEnabled = vibration;
            return this;
        }

        public androidx.core.app.NotificationChannelCompat.Builder setVibrationPattern(long[] vibrationPattern) {
            int length;
            int i;
            if (vibrationPattern != null && vibrationPattern.length > 0) {
                i = vibrationPattern.length > 0 ? 1 : 0;
            } else {
            }
            mChannel.mVibrationEnabled = i;
            mChannel2.mVibrationPattern = vibrationPattern;
            return this;
        }
    }
    NotificationChannelCompat(NotificationChannel channel) {
        int conversationId;
        int importantConversation;
        super(NotificationChannelCompat.Api26Impl.getId(channel), NotificationChannelCompat.Api26Impl.getImportance(channel));
        this.mName = NotificationChannelCompat.Api26Impl.getName(channel);
        this.mDescription = NotificationChannelCompat.Api26Impl.getDescription(channel);
        this.mGroupId = NotificationChannelCompat.Api26Impl.getGroup(channel);
        this.mShowBadge = NotificationChannelCompat.Api26Impl.canShowBadge(channel);
        this.mSound = NotificationChannelCompat.Api26Impl.getSound(channel);
        this.mAudioAttributes = NotificationChannelCompat.Api26Impl.getAudioAttributes(channel);
        this.mLights = NotificationChannelCompat.Api26Impl.shouldShowLights(channel);
        this.mLightColor = NotificationChannelCompat.Api26Impl.getLightColor(channel);
        this.mVibrationEnabled = NotificationChannelCompat.Api26Impl.shouldVibrate(channel);
        this.mVibrationPattern = NotificationChannelCompat.Api26Impl.getVibrationPattern(channel);
        int i = 30;
        if (Build.VERSION.SDK_INT >= i) {
            this.mParentId = NotificationChannelCompat.Api30Impl.getParentChannelId(channel);
            this.mConversationId = NotificationChannelCompat.Api30Impl.getConversationId(channel);
        }
        this.mBypassDnd = NotificationChannelCompat.Api26Impl.canBypassDnd(channel);
        this.mLockscreenVisibility = NotificationChannelCompat.Api26Impl.getLockscreenVisibility(channel);
        this.mCanBubble = NotificationChannelCompat.Api29Impl.canBubble(channel);
        if (Build.VERSION.SDK_INT >= i) {
            this.mImportantConversation = NotificationChannelCompat.Api30Impl.isImportantConversation(channel);
        }
    }

    NotificationChannelCompat(String id, int importance) {
        super();
        this.mShowBadge = true;
        this.mSound = Settings.System.DEFAULT_NOTIFICATION_URI;
        this.mLightColor = 0;
        this.mId = (String)Preconditions.checkNotNull(id);
        this.mImportance = importance;
        this.mAudioAttributes = Notification.AUDIO_ATTRIBUTES_DEFAULT;
    }

    public boolean canBubble() {
        return this.mCanBubble;
    }

    public boolean canBypassDnd() {
        return this.mBypassDnd;
    }

    public boolean canShowBadge() {
        return this.mShowBadge;
    }

    public AudioAttributes getAudioAttributes() {
        return this.mAudioAttributes;
    }

    public String getConversationId() {
        return this.mConversationId;
    }

    public String getDescription() {
        return this.mDescription;
    }

    public String getGroup() {
        return this.mGroupId;
    }

    public String getId() {
        return this.mId;
    }

    public int getImportance() {
        return this.mImportance;
    }

    public int getLightColor() {
        return this.mLightColor;
    }

    public int getLockscreenVisibility() {
        return this.mLockscreenVisibility;
    }

    public java.lang.CharSequence getName() {
        return this.mName;
    }

    NotificationChannel getNotificationChannel() {
        int mConversationId2;
        int mConversationId;
        NotificationChannel notificationChannel = NotificationChannelCompat.Api26Impl.createNotificationChannel(this.mId, this.mName, this.mImportance);
        NotificationChannelCompat.Api26Impl.setDescription(notificationChannel, this.mDescription);
        NotificationChannelCompat.Api26Impl.setGroup(notificationChannel, this.mGroupId);
        NotificationChannelCompat.Api26Impl.setShowBadge(notificationChannel, this.mShowBadge);
        NotificationChannelCompat.Api26Impl.setSound(notificationChannel, this.mSound, this.mAudioAttributes);
        NotificationChannelCompat.Api26Impl.enableLights(notificationChannel, this.mLights);
        NotificationChannelCompat.Api26Impl.setLightColor(notificationChannel, this.mLightColor);
        NotificationChannelCompat.Api26Impl.setVibrationPattern(notificationChannel, this.mVibrationPattern);
        NotificationChannelCompat.Api26Impl.enableVibration(notificationChannel, this.mVibrationEnabled);
        if (Build.VERSION.SDK_INT >= 30 && this.mParentId != null && this.mConversationId != null) {
            if (this.mParentId != null) {
                if (this.mConversationId != null) {
                    NotificationChannelCompat.Api30Impl.setConversationId(notificationChannel, this.mParentId, this.mConversationId);
                }
            }
        }
        return notificationChannel;
    }

    public String getParentChannelId() {
        return this.mParentId;
    }

    public Uri getSound() {
        return this.mSound;
    }

    public long[] getVibrationPattern() {
        return this.mVibrationPattern;
    }

    public boolean isImportantConversation() {
        return this.mImportantConversation;
    }

    public boolean shouldShowLights() {
        return this.mLights;
    }

    public boolean shouldVibrate() {
        return this.mVibrationEnabled;
    }

    public androidx.core.app.NotificationChannelCompat.Builder toBuilder() {
        NotificationChannelCompat.Builder builder = new NotificationChannelCompat.Builder(this.mId, this.mImportance);
        return builder.setName(this.mName).setDescription(this.mDescription).setGroup(this.mGroupId).setShowBadge(this.mShowBadge).setSound(this.mSound, this.mAudioAttributes).setLightsEnabled(this.mLights).setLightColor(this.mLightColor).setVibrationEnabled(this.mVibrationEnabled).setVibrationPattern(this.mVibrationPattern).setConversationId(this.mParentId, this.mConversationId);
    }
}
