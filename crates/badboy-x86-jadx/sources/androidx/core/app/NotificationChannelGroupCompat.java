package androidx.core.app;

import android.app.NotificationChannel;
import android.app.NotificationChannelGroup;
import androidx.core.util.Preconditions;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes5.dex */
public class NotificationChannelGroupCompat {

    private boolean mBlocked;
    private List<androidx.core.app.NotificationChannelCompat> mChannels;
    String mDescription;
    final String mId;
    java.lang.CharSequence mName;

    static class Api26Impl {
        static NotificationChannelGroup createNotificationChannelGroup(String id, java.lang.CharSequence name) {
            NotificationChannelGroup notificationChannelGroup = new NotificationChannelGroup(id, name);
            return notificationChannelGroup;
        }

        static List<NotificationChannel> getChannels(NotificationChannelGroup notificationChannelGroup) {
            return notificationChannelGroup.getChannels();
        }

        static String getGroup(NotificationChannel notificationChannel) {
            return notificationChannel.getGroup();
        }

        static String getId(NotificationChannelGroup notificationChannelGroup) {
            return notificationChannelGroup.getId();
        }

        static java.lang.CharSequence getName(NotificationChannelGroup notificationChannelGroup) {
            return notificationChannelGroup.getName();
        }
    }

    static class Api28Impl {
        static String getDescription(NotificationChannelGroup notificationChannelGroup) {
            return notificationChannelGroup.getDescription();
        }

        static boolean isBlocked(NotificationChannelGroup notificationChannelGroup) {
            return notificationChannelGroup.isBlocked();
        }

        static void setDescription(NotificationChannelGroup notificationChannelGroup, String description) {
            notificationChannelGroup.setDescription(description);
        }
    }

    public static class Builder {

        final androidx.core.app.NotificationChannelGroupCompat mGroup;
        public Builder(String id) {
            super();
            NotificationChannelGroupCompat notificationChannelGroupCompat = new NotificationChannelGroupCompat(id);
            this.mGroup = notificationChannelGroupCompat;
        }

        public androidx.core.app.NotificationChannelGroupCompat build() {
            return this.mGroup;
        }

        public androidx.core.app.NotificationChannelGroupCompat.Builder setDescription(String description) {
            mGroup.mDescription = description;
            return this;
        }

        public androidx.core.app.NotificationChannelGroupCompat.Builder setName(java.lang.CharSequence name) {
            mGroup.mName = name;
            return this;
        }
    }
    NotificationChannelGroupCompat(NotificationChannelGroup group) {
        super(group, Collections.emptyList());
    }

    NotificationChannelGroupCompat(NotificationChannelGroup group, List<NotificationChannel> list2) {
        super(NotificationChannelGroupCompat.Api26Impl.getId(group));
        this.mName = NotificationChannelGroupCompat.Api26Impl.getName(group);
        this.mDescription = NotificationChannelGroupCompat.Api28Impl.getDescription(group);
        this.mBlocked = NotificationChannelGroupCompat.Api28Impl.isBlocked(group);
        this.mChannels = getChannelsCompat(NotificationChannelGroupCompat.Api26Impl.getChannels(group));
    }

    NotificationChannelGroupCompat(String id) {
        super();
        this.mChannels = Collections.emptyList();
        this.mId = (String)Preconditions.checkNotNull(id);
    }

    private List<androidx.core.app.NotificationChannelCompat> getChannelsCompat(List<NotificationChannel> list) {
        Object next;
        boolean notificationChannelCompat;
        String group;
        ArrayList arrayList = new ArrayList();
        final Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            next = iterator.next();
            if (this.mId.equals(NotificationChannelGroupCompat.Api26Impl.getGroup((NotificationChannel)next))) {
            }
            notificationChannelCompat = new NotificationChannelCompat(next);
            arrayList.add(notificationChannelCompat);
        }
        return arrayList;
    }

    public List<androidx.core.app.NotificationChannelCompat> getChannels() {
        return this.mChannels;
    }

    public String getDescription() {
        return this.mDescription;
    }

    public String getId() {
        return this.mId;
    }

    public java.lang.CharSequence getName() {
        return this.mName;
    }

    NotificationChannelGroup getNotificationChannelGroup() {
        NotificationChannelGroup notificationChannelGroup = NotificationChannelGroupCompat.Api26Impl.createNotificationChannelGroup(this.mId, this.mName);
        NotificationChannelGroupCompat.Api28Impl.setDescription(notificationChannelGroup, this.mDescription);
        return notificationChannelGroup;
    }

    public boolean isBlocked() {
        return this.mBlocked;
    }

    public androidx.core.app.NotificationChannelGroupCompat.Builder toBuilder() {
        NotificationChannelGroupCompat.Builder builder = new NotificationChannelGroupCompat.Builder(this.mId);
        return builder.setName(this.mName).setDescription(this.mDescription);
    }
}
