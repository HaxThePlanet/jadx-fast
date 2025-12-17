package androidx.core.app;

import android.app.Notification;
import android.app.Notification.Action;
import android.app.Notification.Action.Builder;
import android.app.Notification.BubbleMetadata;
import android.app.Notification.Builder;
import android.app.PendingIntent;
import android.app.Person;
import android.app.RemoteInput;
import android.content.Context;
import android.graphics.drawable.Icon;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.RemoteViews;
import androidx.collection.ArraySet;
import androidx.core.content.LocusIdCompat;
import androidx.core.graphics.drawable.IconCompat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes5.dex */
class NotificationCompatBuilder implements androidx.core.app.NotificationBuilderWithBuilderAccessor {

    private final List<Bundle> mActionExtrasList;
    private RemoteViews mBigContentView;
    private final Notification.Builder mBuilder;
    private final androidx.core.app.NotificationCompat.Builder mBuilderCompat;
    private RemoteViews mContentView;
    private final Context mContext;
    private final Bundle mExtras;
    private int mGroupAlertBehavior;
    private RemoteViews mHeadsUpContentView;

    static class Api20Impl {
        static Notification.Builder addAction(Notification.Builder builder, Notification.Action action) {
            return builder.addAction(action);
        }

        static Notification.Action.Builder addExtras(Notification.Action.Builder builder, Bundle extras) {
            return builder.addExtras(extras);
        }

        static Notification.Action.Builder addRemoteInput(Notification.Action.Builder builder, RemoteInput remoteInput) {
            return builder.addRemoteInput(remoteInput);
        }

        static Notification.Action build(Notification.Action.Builder builder) {
            return builder.build();
        }

        static Notification.Action.Builder createBuilder(int icon, java.lang.CharSequence title, PendingIntent intent) {
            Notification.Action.Builder builder = new Notification.Action.Builder(icon, title, intent);
            return builder;
        }

        static String getGroup(Notification notification) {
            return notification.getGroup();
        }

        static Notification.Builder setGroup(Notification.Builder builder, String groupKey) {
            return builder.setGroup(groupKey);
        }

        static Notification.Builder setGroupSummary(Notification.Builder builder, boolean isGroupSummary) {
            return builder.setGroupSummary(isGroupSummary);
        }

        static Notification.Builder setLocalOnly(Notification.Builder builder, boolean localOnly) {
            return builder.setLocalOnly(localOnly);
        }

        static Notification.Builder setSortKey(Notification.Builder builder, String sortKey) {
            return builder.setSortKey(sortKey);
        }
    }

    static class Api21Impl {
        static Notification.Builder addPerson(Notification.Builder builder, String uri) {
            return builder.addPerson(uri);
        }

        static Notification.Builder setCategory(Notification.Builder builder, String category) {
            return builder.setCategory(category);
        }

        static Notification.Builder setColor(Notification.Builder builder, int argb) {
            return builder.setColor(argb);
        }

        static Notification.Builder setPublicVersion(Notification.Builder builder, Notification n) {
            return builder.setPublicVersion(n);
        }

        static Notification.Builder setSound(Notification.Builder builder, Uri sound, Object audioAttributes) {
            return builder.setSound(sound, (AudioAttributes)audioAttributes);
        }

        static Notification.Builder setVisibility(Notification.Builder builder, int visibility) {
            return builder.setVisibility(visibility);
        }
    }

    static class Api23Impl {
        static Notification.Action.Builder createBuilder(Icon icon, java.lang.CharSequence title, PendingIntent intent) {
            Notification.Action.Builder builder = new Notification.Action.Builder(icon, title, intent);
            return builder;
        }

        static Notification.Builder setLargeIcon(Notification.Builder builder, Icon icon) {
            return builder.setLargeIcon(icon);
        }

        static Notification.Builder setSmallIcon(Notification.Builder builder, Object icon) {
            return builder.setSmallIcon((Icon)icon);
        }
    }

    static class Api24Impl {
        static Notification.Action.Builder setAllowGeneratedReplies(Notification.Action.Builder builder, boolean allowGeneratedReplies) {
            return builder.setAllowGeneratedReplies(allowGeneratedReplies);
        }

        static Notification.Builder setCustomBigContentView(Notification.Builder builder, RemoteViews contentView) {
            return builder.setCustomBigContentView(contentView);
        }

        static Notification.Builder setCustomContentView(Notification.Builder builder, RemoteViews contentView) {
            return builder.setCustomContentView(contentView);
        }

        static Notification.Builder setCustomHeadsUpContentView(Notification.Builder builder, RemoteViews contentView) {
            return builder.setCustomHeadsUpContentView(contentView);
        }

        static Notification.Builder setRemoteInputHistory(Notification.Builder builder, java.lang.CharSequence[] text) {
            return builder.setRemoteInputHistory(text);
        }
    }

    static class Api26Impl {
        static Notification.Builder createBuilder(Context context, String channelId) {
            Notification.Builder builder = new Notification.Builder(context, channelId);
            return builder;
        }

        static Notification.Builder setBadgeIconType(Notification.Builder builder, int icon) {
            return builder.setBadgeIconType(icon);
        }

        static Notification.Builder setColorized(Notification.Builder builder, boolean colorize) {
            return builder.setColorized(colorize);
        }

        static Notification.Builder setGroupAlertBehavior(Notification.Builder builder, int groupAlertBehavior) {
            return builder.setGroupAlertBehavior(groupAlertBehavior);
        }

        static Notification.Builder setSettingsText(Notification.Builder builder, java.lang.CharSequence text) {
            return builder.setSettingsText(text);
        }

        static Notification.Builder setShortcutId(Notification.Builder builder, String shortcutId) {
            return builder.setShortcutId(shortcutId);
        }

        static Notification.Builder setTimeoutAfter(Notification.Builder builder, long durationMs) {
            return builder.setTimeoutAfter(durationMs);
        }
    }

    static class Api28Impl {
        static Notification.Builder addPerson(Notification.Builder builder, Person person) {
            return builder.addPerson(person);
        }

        static Notification.Action.Builder setSemanticAction(Notification.Action.Builder builder, int semanticAction) {
            return builder.setSemanticAction(semanticAction);
        }
    }

    static class Api29Impl {
        static Notification.Builder setAllowSystemGeneratedContextualActions(Notification.Builder builder, boolean allowed) {
            return builder.setAllowSystemGeneratedContextualActions(allowed);
        }

        static Notification.Builder setBubbleMetadata(Notification.Builder builder, Notification.BubbleMetadata data) {
            return builder.setBubbleMetadata(data);
        }

        static Notification.Action.Builder setContextual(Notification.Action.Builder builder, boolean isContextual) {
            return builder.setContextual(isContextual);
        }

        static Notification.Builder setLocusId(Notification.Builder builder, Object locusId) {
            return builder.setLocusId((LocusId)locusId);
        }
    }

    static class Api31Impl {
        static Notification.Action.Builder setAuthenticationRequired(Notification.Action.Builder builder, boolean authenticationRequired) {
            return builder.setAuthenticationRequired(authenticationRequired);
        }

        static Notification.Builder setForegroundServiceBehavior(Notification.Builder builder, int behavior) {
            return builder.setForegroundServiceBehavior(behavior);
        }
    }
    NotificationCompatBuilder(androidx.core.app.NotificationCompat.Builder b) {
        int i4;
        int i;
        int i2;
        Icon icon;
        int mBuilder3;
        boolean mBuilder;
        int bundleForAction;
        Object mSmallIcon;
        Object mContentView;
        Object mBigContentView;
        Object mHeadsUpContentView;
        boolean mColorizedSet;
        boolean lights;
        Object mLocusId;
        int mFgsDeferBehavior2;
        int defaults;
        boolean mGroupAlertBehavior;
        int next;
        Object locusId;
        int mFgsDeferBehavior;
        int i5;
        Context mProgressIndeterminate;
        Object actionsListWithSystemActions;
        Bundle mExtras;
        Object mSmallIcon2;
        java.lang.CharSequence[] mRemoteInputHistory;
        int mGroupAlertBehavior2;
        Iterator mExtras2;
        Uri iterator;
        Bundle carExtenderBundle;
        Object next3;
        boolean next2;
        android.media.AudioAttributes audioAttributes;
        Notification.Builder mBuilder2;
        Bundle bundle;
        int i3;
        String string;
        final Object obj = this;
        final androidx.core.app.NotificationCompat.Builder builder = b;
        super();
        ArrayList arrayList = new ArrayList();
        obj.mActionExtrasList = arrayList;
        Bundle bundle2 = new Bundle();
        obj.mExtras = bundle2;
        obj.mBuilderCompat = builder;
        obj.mContext = builder.mContext;
        obj.mBuilder = NotificationCompatBuilder.Api26Impl.createBuilder(builder.mContext, builder.mChannelId);
        Notification mNotification = builder.mNotification;
        mBuilder3 = 2;
        next = 0;
        i4 = flags &= mBuilder3 != 0 ? 1 : next;
        i = flags2 &= 8 != 0 ? 1 : next;
        i2 = flags3 &= 16 != 0 ? 1 : next;
        i5 = flags4 &= 128 != 0 ? 1 : next;
        obj.mBuilder.setWhen(mNotification.when).setSmallIcon(mNotification.icon, mNotification.iconLevel).setContent(mNotification.contentView).setTicker(mNotification.tickerText, builder.mTickerView).setVibrate(mNotification.vibrate).setLights(mNotification.ledARGB, mNotification.ledOnMS, mNotification.ledOffMS).setOngoing(i4).setOnlyAlertOnce(i).setAutoCancel(i2).setDefaults(mNotification.defaults).setContentTitle(builder.mContentTitle).setContentText(builder.mContentText).setContentInfo(builder.mContentInfo).setContentIntent(builder.mContentIntent).setDeleteIntent(mNotification.deleteIntent).setFullScreenIntent(builder.mFullScreenIntent, i5).setNumber(builder.mNumber).setProgress(builder.mProgressMax, builder.mProgress, builder.mProgressIndeterminate);
        int i12 = 0;
        if (builder.mLargeIcon == null) {
            icon = i12;
        } else {
            icon = builder.mLargeIcon.toIcon(obj.mContext);
        }
        NotificationCompatBuilder.Api23Impl.setLargeIcon(obj.mBuilder, icon);
        obj.mBuilder.setSubText(builder.mSubText).setUsesChronometer(builder.mUseChronometer).setPriority(builder.mPriority);
        if (mStyle instanceof NotificationCompat.CallStyle) {
            mExtras2 = (NotificationCompat.CallStyle)builder.mStyle.getActionsListWithSystemActions().iterator();
            for (NotificationCompat.Action next2 : mExtras2) {
                obj.addAction(next2);
            }
        } else {
            actionsListWithSystemActions = builder.mActions.iterator();
            for (NotificationCompat.Action next3 : actionsListWithSystemActions) {
                obj.addAction(next3);
            }
        }
        if (builder.mExtras != null) {
            obj.mExtras.putAll(builder.mExtras);
        }
        obj.mContentView = builder.mContentView;
        obj.mBigContentView = builder.mBigContentView;
        obj.mBuilder.setShowWhen(builder.mShowWhen);
        NotificationCompatBuilder.Api20Impl.setLocalOnly(obj.mBuilder, builder.mLocalOnly);
        NotificationCompatBuilder.Api20Impl.setGroup(obj.mBuilder, builder.mGroupKey);
        NotificationCompatBuilder.Api20Impl.setSortKey(obj.mBuilder, builder.mSortKey);
        NotificationCompatBuilder.Api20Impl.setGroupSummary(obj.mBuilder, builder.mGroupSummary);
        obj.mGroupAlertBehavior = builder.mGroupAlertBehavior;
        NotificationCompatBuilder.Api21Impl.setCategory(obj.mBuilder, builder.mCategory);
        NotificationCompatBuilder.Api21Impl.setColor(obj.mBuilder, builder.mColor);
        NotificationCompatBuilder.Api21Impl.setVisibility(obj.mBuilder, builder.mVisibility);
        NotificationCompatBuilder.Api21Impl.setPublicVersion(obj.mBuilder, builder.mPublicVersion);
        NotificationCompatBuilder.Api21Impl.setSound(obj.mBuilder, mNotification.sound, mNotification.audioAttributes);
        mSmallIcon2 = builder.mPeople;
        if (mSmallIcon2 != null && !mSmallIcon2.isEmpty()) {
            if (!mSmallIcon2.isEmpty()) {
                iterator = mSmallIcon2.iterator();
                for (String audioAttributes : iterator) {
                    NotificationCompatBuilder.Api21Impl.addPerson(obj.mBuilder, audioAttributes);
                }
            }
        }
        obj.mHeadsUpContentView = builder.mHeadsUpContentView;
        audioAttributes = "android.car.EXTENSIONS";
        if (builder.mInvisibleActions.size() > 0 && builder.getExtras().getBundle(audioAttributes) == null) {
            audioAttributes = "android.car.EXTENSIONS";
            if (builder.getExtras().getBundle(audioAttributes) == null) {
                mBuilder2 = new Bundle();
                carExtenderBundle = mBuilder2;
            }
            mBuilder2 = new Bundle(carExtenderBundle);
            bundle = new Bundle();
            i3 = 0;
            while (i3 < builder.mInvisibleActions.size()) {
                bundle.putBundle(Integer.toString(i3), NotificationCompatJellybean.getBundleForAction((NotificationCompat.Action)builder.mInvisibleActions.get(i3)));
                i3++;
            }
            String str = "invisible_actions";
            carExtenderBundle.putBundle(str, bundle);
            mBuilder2.putBundle(str, bundle);
            builder.getExtras().putBundle(audioAttributes, carExtenderBundle);
            obj.mExtras.putBundle(audioAttributes, mBuilder2);
        }
        if (builder.mSmallIcon != null) {
            NotificationCompatBuilder.Api23Impl.setSmallIcon(obj.mBuilder, builder.mSmallIcon);
        }
        obj.mBuilder.setExtras(builder.mExtras);
        NotificationCompatBuilder.Api24Impl.setRemoteInputHistory(obj.mBuilder, builder.mRemoteInputHistory);
        if (builder.mContentView != null) {
            NotificationCompatBuilder.Api24Impl.setCustomContentView(obj.mBuilder, builder.mContentView);
        }
        if (builder.mBigContentView != null) {
            NotificationCompatBuilder.Api24Impl.setCustomBigContentView(obj.mBuilder, builder.mBigContentView);
        }
        if (builder.mHeadsUpContentView != null) {
            NotificationCompatBuilder.Api24Impl.setCustomHeadsUpContentView(obj.mBuilder, builder.mHeadsUpContentView);
        }
        NotificationCompatBuilder.Api26Impl.setBadgeIconType(obj.mBuilder, builder.mBadgeIcon);
        NotificationCompatBuilder.Api26Impl.setSettingsText(obj.mBuilder, builder.mSettingsText);
        NotificationCompatBuilder.Api26Impl.setShortcutId(obj.mBuilder, builder.mShortcutId);
        NotificationCompatBuilder.Api26Impl.setTimeoutAfter(obj.mBuilder, builder.mTimeout);
        NotificationCompatBuilder.Api26Impl.setGroupAlertBehavior(obj.mBuilder, builder.mGroupAlertBehavior);
        if (builder.mColorizedSet != null) {
            NotificationCompatBuilder.Api26Impl.setColorized(obj.mBuilder, builder.mColorized);
        }
        if (!TextUtils.isEmpty(builder.mChannelId)) {
            obj.mBuilder.setSound(i12).setDefaults(next).setLights(next, next, next).setVibrate(i12);
        }
        Iterator iterator2 = builder.mPersonList.iterator();
        for (Person next : iterator2) {
            NotificationCompatBuilder.Api28Impl.addPerson(obj.mBuilder, next.toAndroidPerson());
        }
        NotificationCompatBuilder.Api29Impl.setAllowSystemGeneratedContextualActions(obj.mBuilder, builder.mAllowSystemGeneratedContextualActions);
        NotificationCompatBuilder.Api29Impl.setBubbleMetadata(obj.mBuilder, NotificationCompat.BubbleMetadata.toPlatform(builder.mBubbleMetadata));
        if (builder.mLocusId != null) {
            NotificationCompatBuilder.Api29Impl.setLocusId(obj.mBuilder, builder.mLocusId.toLocusId());
        }
        if (Build.VERSION.SDK_INT >= 31 && builder.mFgsDeferBehavior != 0) {
            if (builder.mFgsDeferBehavior != 0) {
                NotificationCompatBuilder.Api31Impl.setForegroundServiceBehavior(obj.mBuilder, builder.mFgsDeferBehavior);
            }
        }
        if (builder.mSilent) {
            if (mBuilderCompat2.mGroupSummary) {
                obj.mGroupAlertBehavior = mBuilder3;
            } else {
                obj.mGroupAlertBehavior = 1;
            }
            obj.mBuilder.setVibrate(i12);
            obj.mBuilder.setSound(i12);
            mNotification.defaults = defaults4 &= -2;
            mNotification.defaults = defaults5 &= -3;
            obj.mBuilder.setDefaults(mNotification.defaults);
            if (TextUtils.isEmpty(mBuilderCompat.mGroupKey)) {
                NotificationCompatBuilder.Api20Impl.setGroup(obj.mBuilder, "silent");
            }
            NotificationCompatBuilder.Api26Impl.setGroupAlertBehavior(obj.mBuilder, obj.mGroupAlertBehavior);
        }
    }

    private void addAction(androidx.core.app.NotificationCompat.Action action) {
        int icon;
        androidx.core.app.RemoteInput[] remoteInputs;
        Bundle actionExtras;
        PendingIntent actionIntent;
        int authenticationRequired;
        int i;
        RemoteInput remoteInput;
        final IconCompat iconCompat = action.getIconCompat();
        if (iconCompat != null) {
            icon = iconCompat.toIcon();
        } else {
            icon = 0;
        }
        Notification.Action.Builder builder = NotificationCompatBuilder.Api23Impl.createBuilder(icon, action.getTitle(), action.getActionIntent());
        if (action.getRemoteInputs() != null) {
            remoteInputs = RemoteInput.fromCompat(action.getRemoteInputs());
            i = 0;
            while (i < remoteInputs.length) {
                NotificationCompatBuilder.Api20Impl.addRemoteInput(builder, remoteInputs[i]);
                i++;
            }
        }
        if (action.getExtras() != null) {
            actionExtras = new Bundle(action.getExtras());
        } else {
            actionExtras = new Bundle();
        }
        actionExtras.putBoolean("android.support.allowGeneratedReplies", action.getAllowGeneratedReplies());
        NotificationCompatBuilder.Api24Impl.setAllowGeneratedReplies(builder, action.getAllowGeneratedReplies());
        actionExtras.putInt("android.support.action.semanticAction", action.getSemanticAction());
        NotificationCompatBuilder.Api28Impl.setSemanticAction(builder, action.getSemanticAction());
        NotificationCompatBuilder.Api29Impl.setContextual(builder, action.isContextual());
        if (Build.VERSION.SDK_INT >= 31) {
            NotificationCompatBuilder.Api31Impl.setAuthenticationRequired(builder, action.isAuthenticationRequired());
        }
        actionExtras.putBoolean("android.support.action.showsUserInterface", action.getShowsUserInterface());
        NotificationCompatBuilder.Api20Impl.addExtras(builder, actionExtras);
        NotificationCompatBuilder.Api20Impl.addAction(this.mBuilder, NotificationCompatBuilder.Api20Impl.build(builder));
    }

    private static List<String> combineLists(List<String> list, List<String> list2) {
        if (list == null) {
            return list2;
        }
        if (list2 == null) {
            return list;
        }
        ArraySet arraySet = new ArraySet(size += size2);
        arraySet.addAll(list);
        arraySet.addAll(list2);
        ArrayList arrayList = new ArrayList(arraySet);
        return arrayList;
    }

    private static List<String> getPeople(List<androidx.core.app.Person> list) {
        Object next;
        String resolveToLegacyUri;
        if (list == null) {
            return 0;
        }
        ArrayList arrayList = new ArrayList(list.size());
        Iterator iterator = list.iterator();
        for (Person next : iterator) {
            arrayList.add(next.resolveToLegacyUri());
        }
        return arrayList;
    }

    private void removeSoundAndVibration(Notification notification) {
        int i = 0;
        notification.sound = i;
        notification.vibrate = i;
        notification.defaults = defaults &= -2;
        notification.defaults = defaults2 &= -3;
    }

    @Override // androidx.core.app.NotificationBuilderWithBuilderAccessor
    public Notification build() {
        RemoteViews contentView;
        RemoteViews headsUpContentView;
        androidx.core.app.NotificationCompat.Style mStyle = mBuilderCompat.mStyle;
        if (mStyle != null) {
            mStyle.apply(this);
        }
        if (mStyle != null) {
            contentView = mStyle.makeContentView(this);
        } else {
            contentView = 0;
        }
        final Notification internal = buildInternal();
        if (contentView != null) {
            internal.contentView = contentView;
        } else {
            if (mBuilderCompat3.mContentView != null) {
                internal.contentView = mBuilderCompat4.mContentView;
            }
        }
        headsUpContentView = mStyle.makeBigContentView(this);
        if (mStyle != null && headsUpContentView != null) {
            headsUpContentView = mStyle.makeBigContentView(this);
            if (headsUpContentView != null) {
                internal.bigContentView = headsUpContentView;
            }
        }
        headsUpContentView = mBuilderCompat2.mStyle.makeHeadsUpContentView(this);
        if (mStyle != null && headsUpContentView != null) {
            headsUpContentView = mBuilderCompat2.mStyle.makeHeadsUpContentView(this);
            if (headsUpContentView != null) {
                internal.headsUpContentView = headsUpContentView;
            }
        }
        headsUpContentView = NotificationCompat.getExtras(internal);
        if (mStyle != null && headsUpContentView != null) {
            headsUpContentView = NotificationCompat.getExtras(internal);
            if (headsUpContentView != null) {
                mStyle.addCompatExtras(headsUpContentView);
            }
        }
        return internal;
    }

    @Override // androidx.core.app.NotificationBuilderWithBuilderAccessor
    protected Notification buildInternal() {
        return this.mBuilder.build();
    }

    @Override // androidx.core.app.NotificationBuilderWithBuilderAccessor
    public Notification.Builder getBuilder() {
        return this.mBuilder;
    }

    @Override // androidx.core.app.NotificationBuilderWithBuilderAccessor
    Context getContext() {
        return this.mContext;
    }
}
