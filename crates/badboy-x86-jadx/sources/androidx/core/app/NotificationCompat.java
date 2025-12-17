package androidx.core.app;

import android.app.Notification;
import android.app.Notification.Action;
import android.app.Notification.BigPictureStyle;
import android.app.Notification.BigTextStyle;
import android.app.Notification.BubbleMetadata;
import android.app.Notification.Builder;
import android.app.Notification.CallStyle;
import android.app.Notification.InboxStyle;
import android.app.Notification.Style;
import android.app.PendingIntent;
import android.app.RemoteInput;
import android.content.Context;
import android.content.LocusId;
import android.content.pm.PackageManager;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Icon;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Parcelable;
import android.os.SystemClock;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.text.style.TextAppearanceSpan;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RemoteViews;
import android.widget.TextView;
import androidx.annotation.ReplaceWith;
import androidx.core.R.color;
import androidx.core.R.dimen;
import androidx.core.R.drawable;
import androidx.core.R.id;
import androidx.core.R.integer;
import androidx.core.R.layout;
import androidx.core.R.string;
import androidx.core.content.ContextCompat;
import androidx.core.content.LocusIdCompat;
import androidx.core.content.pm.ShortcutInfoCompat;
import androidx.core.graphics.drawable.IconCompat;
import androidx.core.text.BidiFormatter;
import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

/* loaded from: classes5.dex */
public class NotificationCompat {

    public static final int BADGE_ICON_LARGE = 2;
    public static final int BADGE_ICON_NONE = 0;
    public static final int BADGE_ICON_SMALL = 1;
    public static final String CATEGORY_ALARM = "alarm";
    public static final String CATEGORY_CALL = "call";
    public static final String CATEGORY_EMAIL = "email";
    public static final String CATEGORY_ERROR = "err";
    public static final String CATEGORY_EVENT = "event";
    public static final String CATEGORY_LOCATION_SHARING = "location_sharing";
    public static final String CATEGORY_MESSAGE = "msg";
    public static final String CATEGORY_MISSED_CALL = "missed_call";
    public static final String CATEGORY_NAVIGATION = "navigation";
    public static final String CATEGORY_PROGRESS = "progress";
    public static final String CATEGORY_PROMO = "promo";
    public static final String CATEGORY_RECOMMENDATION = "recommendation";
    public static final String CATEGORY_REMINDER = "reminder";
    public static final String CATEGORY_SERVICE = "service";
    public static final String CATEGORY_SOCIAL = "social";
    public static final String CATEGORY_STATUS = "status";
    public static final String CATEGORY_STOPWATCH = "stopwatch";
    public static final String CATEGORY_SYSTEM = "sys";
    public static final String CATEGORY_TRANSPORT = "transport";
    public static final String CATEGORY_VOICEMAIL = "voicemail";
    public static final String CATEGORY_WORKOUT = "workout";
    public static final int COLOR_DEFAULT = 0;
    public static final int DEFAULT_ALL = -1;
    public static final int DEFAULT_LIGHTS = 4;
    public static final int DEFAULT_SOUND = 1;
    public static final int DEFAULT_VIBRATE = 2;
    public static final String EXTRA_ANSWER_COLOR = "android.answerColor";
    public static final String EXTRA_ANSWER_INTENT = "android.answerIntent";
    public static final String EXTRA_AUDIO_CONTENTS_URI = "android.audioContents";
    public static final String EXTRA_BACKGROUND_IMAGE_URI = "android.backgroundImageUri";
    public static final String EXTRA_BIG_TEXT = "android.bigText";
    public static final String EXTRA_CALL_IS_VIDEO = "android.callIsVideo";
    public static final String EXTRA_CALL_PERSON = "android.callPerson";
    public static final String EXTRA_CALL_PERSON_COMPAT = "android.callPersonCompat";
    public static final String EXTRA_CALL_TYPE = "android.callType";
    public static final String EXTRA_CHANNEL_GROUP_ID = "android.intent.extra.CHANNEL_GROUP_ID";
    public static final String EXTRA_CHANNEL_ID = "android.intent.extra.CHANNEL_ID";
    public static final String EXTRA_CHRONOMETER_COUNT_DOWN = "android.chronometerCountDown";
    public static final String EXTRA_COLORIZED = "android.colorized";
    public static final String EXTRA_COMPACT_ACTIONS = "android.compactActions";
    public static final String EXTRA_COMPAT_TEMPLATE = "androidx.core.app.extra.COMPAT_TEMPLATE";
    public static final String EXTRA_CONVERSATION_TITLE = "android.conversationTitle";
    public static final String EXTRA_DECLINE_COLOR = "android.declineColor";
    public static final String EXTRA_DECLINE_INTENT = "android.declineIntent";
    public static final String EXTRA_HANG_UP_INTENT = "android.hangUpIntent";
    public static final String EXTRA_HIDDEN_CONVERSATION_TITLE = "android.hiddenConversationTitle";
    public static final String EXTRA_HISTORIC_MESSAGES = "android.messages.historic";
    public static final String EXTRA_INFO_TEXT = "android.infoText";
    public static final String EXTRA_IS_GROUP_CONVERSATION = "android.isGroupConversation";
    public static final String EXTRA_LARGE_ICON = "android.largeIcon";
    public static final String EXTRA_LARGE_ICON_BIG = "android.largeIcon.big";
    public static final String EXTRA_MEDIA_SESSION = "android.mediaSession";
    public static final String EXTRA_MESSAGES = "android.messages";
    public static final String EXTRA_MESSAGING_STYLE_USER = "android.messagingStyleUser";
    public static final String EXTRA_NOTIFICATION_ID = "android.intent.extra.NOTIFICATION_ID";
    public static final String EXTRA_NOTIFICATION_TAG = "android.intent.extra.NOTIFICATION_TAG";
    @Deprecated
    public static final String EXTRA_PEOPLE = "android.people";
    public static final String EXTRA_PEOPLE_LIST = "android.people.list";
    public static final String EXTRA_PICTURE = "android.picture";
    public static final String EXTRA_PICTURE_CONTENT_DESCRIPTION = "android.pictureContentDescription";
    public static final String EXTRA_PICTURE_ICON = "android.pictureIcon";
    public static final String EXTRA_PROGRESS = "android.progress";
    public static final String EXTRA_PROGRESS_INDETERMINATE = "android.progressIndeterminate";
    public static final String EXTRA_PROGRESS_MAX = "android.progressMax";
    public static final String EXTRA_REMOTE_INPUT_HISTORY = "android.remoteInputHistory";
    public static final String EXTRA_SELF_DISPLAY_NAME = "android.selfDisplayName";
    public static final String EXTRA_SHOW_BIG_PICTURE_WHEN_COLLAPSED = "android.showBigPictureWhenCollapsed";
    public static final String EXTRA_SHOW_CHRONOMETER = "android.showChronometer";
    public static final String EXTRA_SHOW_WHEN = "android.showWhen";
    public static final String EXTRA_SMALL_ICON = "android.icon";
    public static final String EXTRA_SUB_TEXT = "android.subText";
    public static final String EXTRA_SUMMARY_TEXT = "android.summaryText";
    public static final String EXTRA_TEMPLATE = "android.template";
    public static final String EXTRA_TEXT = "android.text";
    public static final String EXTRA_TEXT_LINES = "android.textLines";
    public static final String EXTRA_TITLE = "android.title";
    public static final String EXTRA_TITLE_BIG = "android.title.big";
    public static final String EXTRA_VERIFICATION_ICON = "android.verificationIcon";
    public static final String EXTRA_VERIFICATION_ICON_COMPAT = "android.verificationIconCompat";
    public static final String EXTRA_VERIFICATION_TEXT = "android.verificationText";
    public static final int FLAG_AUTO_CANCEL = 16;
    public static final int FLAG_BUBBLE = 4096;
    public static final int FLAG_FOREGROUND_SERVICE = 64;
    public static final int FLAG_GROUP_SUMMARY = 512;
    @Deprecated
    public static final int FLAG_HIGH_PRIORITY = 128;
    public static final int FLAG_INSISTENT = 4;
    public static final int FLAG_LOCAL_ONLY = 256;
    public static final int FLAG_NO_CLEAR = 32;
    public static final int FLAG_ONGOING_EVENT = 2;
    public static final int FLAG_ONLY_ALERT_ONCE = 8;
    public static final int FLAG_SHOW_LIGHTS = 1;
    public static final int FOREGROUND_SERVICE_DEFAULT = 0;
    public static final int FOREGROUND_SERVICE_DEFERRED = 2;
    public static final int FOREGROUND_SERVICE_IMMEDIATE = 1;
    public static final int GROUP_ALERT_ALL = 0;
    public static final int GROUP_ALERT_CHILDREN = 2;
    public static final int GROUP_ALERT_SUMMARY = 1;
    public static final String GROUP_KEY_SILENT = "silent";
    public static final String INTENT_CATEGORY_NOTIFICATION_PREFERENCES = "android.intent.category.NOTIFICATION_PREFERENCES";
    public static final int MAX_ACTION_BUTTONS = 3;
    public static final int PRIORITY_DEFAULT = 0;
    public static final int PRIORITY_HIGH = 1;
    public static final int PRIORITY_LOW = -1;
    public static final int PRIORITY_MAX = 2;
    public static final int PRIORITY_MIN = -2;
    public static final int STREAM_DEFAULT = -1;
    private static final String TAG = "NotifCompat";
    public static final int VISIBILITY_PRIVATE = 0;
    public static final int VISIBILITY_PUBLIC = 1;
    public static final int VISIBILITY_SECRET = -1;

    public static class Action {

        static final String EXTRA_SEMANTIC_ACTION = "android.support.action.semanticAction";
        static final String EXTRA_SHOWS_USER_INTERFACE = "android.support.action.showsUserInterface";
        public static final int SEMANTIC_ACTION_ARCHIVE = 5;
        public static final int SEMANTIC_ACTION_CALL = 10;
        public static final int SEMANTIC_ACTION_DELETE = 4;
        public static final int SEMANTIC_ACTION_MARK_AS_READ = 2;
        public static final int SEMANTIC_ACTION_MARK_AS_UNREAD = 3;
        public static final int SEMANTIC_ACTION_MUTE = 6;
        public static final int SEMANTIC_ACTION_NONE = 0;
        public static final int SEMANTIC_ACTION_REPLY = 1;
        public static final int SEMANTIC_ACTION_THUMBS_DOWN = 9;
        public static final int SEMANTIC_ACTION_THUMBS_UP = 8;
        public static final int SEMANTIC_ACTION_UNMUTE = 7;
        public PendingIntent actionIntent;
        @Deprecated
        public int icon;
        private boolean mAllowGeneratedReplies;
        private boolean mAuthenticationRequired;
        private final androidx.core.app.RemoteInput[] mDataOnlyRemoteInputs;
        final Bundle mExtras;
        private IconCompat mIcon;
        private final boolean mIsContextual;
        private final androidx.core.app.RemoteInput[] mRemoteInputs;
        private final int mSemanticAction;
        boolean mShowsUserInterface;
        public java.lang.CharSequence title;
        public Action(int icon, java.lang.CharSequence title, PendingIntent intent) {
            int withResource;
            String str;
            if (icon == 0) {
            } else {
                withResource = IconCompat.createWithResource(0, "", icon);
            }
            super(withResource, title, intent);
        }

        Action(int icon, java.lang.CharSequence title, PendingIntent intent, Bundle extras, androidx.core.app.RemoteInput[] remoteInputs, androidx.core.app.RemoteInput[] dataOnlyRemoteInputs, boolean allowGeneratedReplies, int semanticAction, boolean showsUserInterface, boolean isContextual, boolean requireAuth) {
            int withResource;
            String str;
            if (icon == 0) {
            } else {
                withResource = IconCompat.createWithResource(0, "", icon);
            }
            super(withResource, title, intent, extras, remoteInputs, dataOnlyRemoteInputs, allowGeneratedReplies, semanticAction, showsUserInterface, isContextual, requireAuth);
        }

        public Action(IconCompat icon, java.lang.CharSequence title, PendingIntent intent) {
            Bundle bundle = new Bundle();
            super(icon, title, intent, bundle, 0, 0, 1, 0, 1, 0, 0);
        }

        Action(IconCompat icon, java.lang.CharSequence title, PendingIntent intent, Bundle extras, androidx.core.app.RemoteInput[] remoteInputs, androidx.core.app.RemoteInput[] dataOnlyRemoteInputs, boolean allowGeneratedReplies, int semanticAction, boolean showsUserInterface, boolean isContextual, boolean requireAuth) {
            int resId;
            Bundle bundle;
            int i;
            super();
            this.mShowsUserInterface = true;
            this.mIcon = icon;
            if (icon != null && icon.getType() == 2) {
                if (icon.getType() == 2) {
                    this.icon = icon.getResId();
                }
            }
            this.title = NotificationCompat.Builder.limitCharSequenceLength(title);
            this.actionIntent = intent;
            if (extras != null) {
                bundle = extras;
            } else {
                bundle = new Bundle();
            }
            this.mExtras = bundle;
            this.mRemoteInputs = remoteInputs;
            this.mDataOnlyRemoteInputs = dataOnlyRemoteInputs;
            this.mAllowGeneratedReplies = allowGeneratedReplies;
            this.mSemanticAction = semanticAction;
            this.mShowsUserInterface = showsUserInterface;
            this.mIsContextual = isContextual;
            this.mAuthenticationRequired = requireAuth;
        }

        public PendingIntent getActionIntent() {
            return this.actionIntent;
        }

        public boolean getAllowGeneratedReplies() {
            return this.mAllowGeneratedReplies;
        }

        public androidx.core.app.RemoteInput[] getDataOnlyRemoteInputs() {
            return this.mDataOnlyRemoteInputs;
        }

        public Bundle getExtras() {
            return this.mExtras;
        }

        @Deprecated
        public int getIcon() {
            return this.icon;
        }

        public IconCompat getIconCompat() {
            IconCompat withResource;
            int icon;
            int i;
            if (this.mIcon == null && this.icon != 0) {
                if (this.icon != 0) {
                    this.mIcon = IconCompat.createWithResource(0, "", this.icon);
                }
            }
            return this.mIcon;
        }

        public androidx.core.app.RemoteInput[] getRemoteInputs() {
            return this.mRemoteInputs;
        }

        public int getSemanticAction() {
            return this.mSemanticAction;
        }

        public boolean getShowsUserInterface() {
            return this.mShowsUserInterface;
        }

        public java.lang.CharSequence getTitle() {
            return this.title;
        }

        public boolean isAuthenticationRequired() {
            return this.mAuthenticationRequired;
        }

        public boolean isContextual() {
            return this.mIsContextual;
        }
    }

    static class Api20Impl {
        static boolean getAllowFreeFormInput(RemoteInput remoteInput) {
            return remoteInput.getAllowFreeFormInput();
        }

        static java.lang.CharSequence[] getChoices(RemoteInput remoteInput) {
            return remoteInput.getChoices();
        }

        static Bundle getExtras(Notification.Action action) {
            return action.getExtras();
        }

        static Bundle getExtras(RemoteInput remoteInput) {
            return remoteInput.getExtras();
        }

        static String getGroup(Notification notification) {
            return notification.getGroup();
        }

        static java.lang.CharSequence getLabel(RemoteInput remoteInput) {
            return remoteInput.getLabel();
        }

        static RemoteInput[] getRemoteInputs(Notification.Action action) {
            return action.getRemoteInputs();
        }

        static String getResultKey(RemoteInput remoteInput) {
            return remoteInput.getResultKey();
        }

        static String getSortKey(Notification notification) {
            return notification.getSortKey();
        }
    }

    static class Api23Impl {
        static Icon getIcon(Notification.Action action) {
            return action.getIcon();
        }
    }

    static class Api24Impl {
        static boolean getAllowGeneratedReplies(Notification.Action action) {
            return action.getAllowGeneratedReplies();
        }
    }

    static class Api26Impl {
        static int getBadgeIconType(Notification notification) {
            return notification.getBadgeIconType();
        }

        static String getChannelId(Notification notification) {
            return notification.getChannelId();
        }

        static int getGroupAlertBehavior(Notification notification) {
            return notification.getGroupAlertBehavior();
        }

        static java.lang.CharSequence getSettingsText(Notification notification) {
            return notification.getSettingsText();
        }

        static String getShortcutId(Notification notification) {
            return notification.getShortcutId();
        }

        static long getTimeoutAfter(Notification notification) {
            return notification.getTimeoutAfter();
        }
    }

    static class Api28Impl {
        static int getSemanticAction(Notification.Action action) {
            return action.getSemanticAction();
        }
    }

    static class Api29Impl {
        static boolean getAllowSystemGeneratedContextualActions(Notification notification) {
            return notification.getAllowSystemGeneratedContextualActions();
        }

        static Notification.BubbleMetadata getBubbleMetadata(Notification notification) {
            return notification.getBubbleMetadata();
        }

        static int getEditChoicesBeforeSending(RemoteInput remoteInput) {
            return remoteInput.getEditChoicesBeforeSending();
        }

        static LocusId getLocusId(Notification notification) {
            return notification.getLocusId();
        }

        static boolean isContextual(Notification.Action action) {
            return action.isContextual();
        }
    }

    static class Api31Impl {
        static boolean isAuthenticationRequired(Notification.Action action) {
            return action.isAuthenticationRequired();
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface BadgeIconType {
    }

    public static abstract class Style {

        java.lang.CharSequence mBigContentTitle;
        protected androidx.core.app.NotificationCompat.Builder mBuilder;
        java.lang.CharSequence mSummaryText;
        boolean mSummaryTextSet = false;
        public Style() {
            super();
            final int i = 0;
        }

        private int calculateTopPadding() {
            Resources resources = mBuilder.mContext.getResources();
            int i4 = 1065353216;
            i2 /= i8;
            return Math.round(i6 += i9);
        }

        private static float constrain(float amount, float low, float high) {
            float f;
            f = Float.compare(amount, low) < 0 ? low : cmp2 > 0 ? high : amount;
            return f;
        }

        static androidx.core.app.NotificationCompat.Style constructCompatStyleByName(String templateClass) {
            int equals;
            int i;
            if (templateClass != 0) {
                switch (templateClass) {
                    case "androidx.core.app.NotificationCompat$DecoratedCustomViewStyle":
                        i = 3;
                        i = -1;
                        break;
                    case "androidx.core.app.NotificationCompat$BigPictureStyle":
                        i = 1;
                        i = -1;
                        break;
                    case "androidx.core.app.NotificationCompat$CallStyle":
                        i = 5;
                        i = -1;
                        break;
                    case "androidx.core.app.NotificationCompat$InboxStyle":
                        i = 2;
                        i = -1;
                        break;
                    case "androidx.core.app.NotificationCompat$BigTextStyle":
                        i = 0;
                        i = -1;
                        break;
                    case "androidx.core.app.NotificationCompat$MessagingStyle":
                        i = 4;
                        i = -1;
                        break;
                    default:
                        i = -1;
                }
                switch (i) {
                    case 0:
                        NotificationCompat.BigTextStyle bigTextStyle = new NotificationCompat.BigTextStyle();
                        return bigTextStyle;
                    case 1:
                        NotificationCompat.BigPictureStyle bigPictureStyle = new NotificationCompat.BigPictureStyle();
                        return bigPictureStyle;
                    case 2:
                        NotificationCompat.InboxStyle inboxStyle = new NotificationCompat.InboxStyle();
                        return inboxStyle;
                    case 3:
                        NotificationCompat.DecoratedCustomViewStyle decoratedCustomViewStyle = new NotificationCompat.DecoratedCustomViewStyle();
                        return decoratedCustomViewStyle;
                    case 4:
                        NotificationCompat.MessagingStyle messagingStyle = new NotificationCompat.MessagingStyle();
                        return messagingStyle;
                    case 5:
                        NotificationCompat.CallStyle callStyle = new NotificationCompat.CallStyle();
                        return callStyle;
                    default:
                }
            }
            return null;
        }

        private static androidx.core.app.NotificationCompat.Style constructCompatStyleByPlatformName(String platformTemplateClass) {
            int i = 0;
            if (platformTemplateClass == null) {
                return i;
            }
            if (platformTemplateClass.equals(Notification.BigPictureStyle.class.getName())) {
                NotificationCompat.BigPictureStyle bigPictureStyle = new NotificationCompat.BigPictureStyle();
                return bigPictureStyle;
            }
            if (platformTemplateClass.equals(Notification.BigTextStyle.class.getName())) {
                NotificationCompat.BigTextStyle bigTextStyle = new NotificationCompat.BigTextStyle();
                return bigTextStyle;
            }
            if (platformTemplateClass.equals(Notification.InboxStyle.class.getName())) {
                NotificationCompat.InboxStyle inboxStyle = new NotificationCompat.InboxStyle();
                return inboxStyle;
            }
            if (platformTemplateClass.equals(Notification.MessagingStyle.class.getName())) {
                NotificationCompat.MessagingStyle messagingStyle = new NotificationCompat.MessagingStyle();
                return messagingStyle;
            }
            if (platformTemplateClass.equals(Notification.DecoratedCustomViewStyle.class.getName())) {
                NotificationCompat.DecoratedCustomViewStyle decoratedCustomViewStyle = new NotificationCompat.DecoratedCustomViewStyle();
                return decoratedCustomViewStyle;
            }
            return i;
        }

        static androidx.core.app.NotificationCompat.Style constructCompatStyleForBundle(Bundle extras) {
            boolean key;
            boolean key2;
            androidx.core.app.NotificationCompat.Style constructCompatStyleByName = NotificationCompat.Style.constructCompatStyleByName(extras.getString("androidx.core.app.extra.COMPAT_TEMPLATE"));
            if (constructCompatStyleByName != null) {
                return constructCompatStyleByName;
            }
            if (!extras.containsKey("android.selfDisplayName")) {
                if (extras.containsKey("android.messagingStyleUser")) {
                } else {
                    if (!extras.containsKey("android.picture")) {
                        if (extras.containsKey("android.pictureIcon")) {
                        } else {
                            if (extras.containsKey("android.bigText")) {
                                NotificationCompat.BigTextStyle bigTextStyle = new NotificationCompat.BigTextStyle();
                                return bigTextStyle;
                            }
                            if (extras.containsKey("android.textLines")) {
                                NotificationCompat.InboxStyle inboxStyle = new NotificationCompat.InboxStyle();
                                return inboxStyle;
                            }
                            if (extras.containsKey("android.callType")) {
                                NotificationCompat.CallStyle callStyle = new NotificationCompat.CallStyle();
                                return callStyle;
                            }
                        }
                        return NotificationCompat.Style.constructCompatStyleByPlatformName(extras.getString("android.template"));
                    }
                }
                NotificationCompat.BigPictureStyle bigPictureStyle = new NotificationCompat.BigPictureStyle();
                return bigPictureStyle;
            }
            NotificationCompat.MessagingStyle messagingStyle = new NotificationCompat.MessagingStyle();
            return messagingStyle;
        }

        static androidx.core.app.NotificationCompat.Style constructStyleForExtras(Bundle extras) {
            final androidx.core.app.NotificationCompat.Style constructCompatStyleForBundle = NotificationCompat.Style.constructCompatStyleForBundle(extras);
            if (constructCompatStyleForBundle == null) {
                return null;
            }
            constructCompatStyleForBundle.restoreFromCompatExtras(extras);
            return constructCompatStyleForBundle;
        }

        private Bitmap createColoredBitmap(int iconId, int color, int size) {
            return createColoredBitmap(IconCompat.createWithResource(mBuilder.mContext, iconId), color, size);
        }

        private Bitmap createColoredBitmap(IconCompat icon, int color, int size) {
            int intrinsicWidth;
            int intrinsicHeight;
            int mutate;
            PorterDuffColorFilter porterDuffColorFilter;
            PorterDuff.Mode sRC_IN;
            Drawable drawable = icon.loadDrawable(mBuilder.mContext);
            if (size == 0) {
                intrinsicWidth = drawable.getIntrinsicWidth();
            } else {
                intrinsicWidth = size;
            }
            if (size == 0) {
                intrinsicHeight = drawable.getIntrinsicHeight();
            } else {
                intrinsicHeight = size;
            }
            Bitmap bitmap = Bitmap.createBitmap(intrinsicWidth, intrinsicHeight, Bitmap.Config.ARGB_8888);
            mutate = 0;
            drawable.setBounds(mutate, mutate, intrinsicWidth, intrinsicHeight);
            if (color != 0) {
                porterDuffColorFilter = new PorterDuffColorFilter(color, PorterDuff.Mode.SRC_IN);
                drawable.mutate().setColorFilter(porterDuffColorFilter);
            }
            Canvas canvas = new Canvas(bitmap);
            drawable.draw(canvas);
            return bitmap;
        }

        private Bitmap createIconWithBackground(int iconId, int size, int iconSize, int color) {
            int i;
            i = color == 0 ? 0 : color;
            Bitmap coloredBitmap = createColoredBitmap(R.drawable.notification_icon_background, i, size);
            Canvas canvas = new Canvas(coloredBitmap);
            Drawable mutate = mBuilder.mContext.getResources().getDrawable(iconId).mutate();
            mutate.setFilterBitmap(true);
            i3 /= 2;
            mutate.setBounds(i4, i4, iconSize + i4, iconSize + i4);
            PorterDuffColorFilter porterDuffColorFilter = new PorterDuffColorFilter(-1, PorterDuff.Mode.SRC_ATOP);
            mutate.setColorFilter(porterDuffColorFilter);
            mutate.draw(canvas);
            return coloredBitmap;
        }

        public static androidx.core.app.NotificationCompat.Style extractStyleFromNotification(Notification notification) {
            final Bundle extras = NotificationCompat.getExtras(notification);
            if (extras == null) {
                return null;
            }
            return NotificationCompat.Style.constructStyleForExtras(extras);
        }

        private void hideNormalContent(RemoteViews outerView) {
            final int i = 8;
            outerView.setViewVisibility(R.id.title, i);
            outerView.setViewVisibility(R.id.text2, i);
            outerView.setViewVisibility(R.id.text, i);
        }

        public void addCompatExtras(Bundle extras) {
            boolean mSummaryTextSet;
            Object mBigContentTitle2;
            java.lang.CharSequence mBigContentTitle;
            if (this.mSummaryTextSet != null) {
                extras.putCharSequence("android.summaryText", this.mSummaryText);
            }
            if (this.mBigContentTitle != null) {
                extras.putCharSequence("android.title.big", this.mBigContentTitle);
            }
            String className = getClassName();
            if (className != null) {
                extras.putString("androidx.core.app.extra.COMPAT_TEMPLATE", className);
            }
        }

        public void apply(androidx.core.app.NotificationBuilderWithBuilderAccessor builder) {
        }

        public RemoteViews applyStandardTemplate(boolean showSmallIcon, int resId, boolean fitIn1U) {
            int showLine3;
            int showLine2;
            int i2;
            int dimensionPixelSize;
            java.lang.CharSequence mContentTitle;
            java.lang.CharSequence mContentText;
            int hasRightSide;
            int subTextSize;
            int mChronometerCountDown;
            Bitmap dimensionPixelSize2;
            int mChronometerCountDown2;
            int iconWithBackground;
            java.lang.CharSequence f;
            int i3;
            int integerInstance;
            int right_icon;
            String format;
            int i4;
            int hasRightSide2;
            long l;
            int i;
            long currentTimeMillis;
            final Object obj = this;
            Resources resources = mBuilder.mContext.getResources();
            RemoteViews remoteViews = new RemoteViews(mBuilder2.mContext.getPackageName(), resId);
            final RemoteViews view = remoteViews;
            showLine3 = 0;
            showLine2 = 0;
            final int i10 = 1;
            i4 = 0;
            i2 = obj.mBuilder.getPriority() < -1 ? i10 : i4;
            final int i11 = i2;
            if (mBuilder4.mLargeIcon != null) {
                view.setViewVisibility(R.id.icon, i4);
                view.setImageViewBitmap(R.id.icon, obj.createColoredBitmap(mBuilder13.mLargeIcon, i4));
                if (showSmallIcon && mNotification.icon != 0) {
                    if (mNotification.icon != 0) {
                        dimensionPixelSize = resources.getDimensionPixelSize(R.dimen.notification_right_icon_size);
                        view.setImageViewBitmap(R.id.right_icon, obj.createIconWithBackground(mNotification3.icon, dimensionPixelSize, dimensionPixelSize - i6, obj.mBuilder.getColor()));
                        view.setViewVisibility(R.id.right_icon, i4);
                    }
                }
            } else {
                if (showSmallIcon && mNotification2.icon != 0) {
                    if (mNotification2.icon != 0) {
                        view.setViewVisibility(R.id.icon, i4);
                        view.setImageViewBitmap(R.id.icon, obj.createIconWithBackground(mNotification4.icon, dimensionPixelSize3 -= dimensionPixelSize6, resources.getDimensionPixelSize(R.dimen.notification_small_icon_size_as_large), obj.mBuilder.getColor()));
                    }
                }
            }
            if (mBuilder7.mContentTitle != null) {
                view.setTextViewText(R.id.title, mBuilder22.mContentTitle);
            }
            if (mBuilder8.mContentText != null) {
                view.setTextViewText(R.id.text, mBuilder21.mContentText);
                showLine3 = 1;
            }
            if (mBuilder14.mContentInfo != null) {
                view.setTextViewText(R.id.info, mBuilder25.mContentInfo);
                view.setViewVisibility(R.id.info, i4);
                showLine3 = 1;
                hasRightSide2 = hasRightSide;
            } else {
                if (mBuilder20.mNumber > 0) {
                    if (mBuilder26.mNumber > resources.getInteger(R.integer.status_bar_notification_info_maxnum)) {
                        view.setTextViewText(R.id.info, resources.getString(R.string.status_bar_notification_info_overflow));
                    } else {
                        view.setTextViewText(R.id.info, NumberFormat.getIntegerInstance().format((long)mNumber3));
                    }
                    view.setViewVisibility(R.id.info, i4);
                    showLine3 = 1;
                    hasRightSide2 = hasRightSide;
                } else {
                    view.setViewVisibility(R.id.info, 8);
                    hasRightSide2 = hasRightSide;
                }
            }
            if (hasRightSide3.mSubText != null) {
                view.setTextViewText(R.id.text, mBuilder18.mSubText);
                if (mBuilder12.mContentText != null) {
                    view.setTextViewText(R.id.text2, mBuilder19.mContentText);
                    view.setViewVisibility(R.id.text2, i4);
                    showLine2 = 1;
                    i = 8;
                } else {
                    view.setViewVisibility(R.id.text2, 8);
                }
            } else {
                i = 8;
            }
            if (showLine2 != 0 && fitIn1U) {
                if (fitIn1U) {
                    view.setTextViewTextSize(R.id.text, i4, (float)dimensionPixelSize4);
                }
                view.setViewPadding(R.id.line1, 0, 0, 0, 0);
            }
            int i8 = 0;
            if (Long.compare(whenIfShowing, i8) != 0) {
                if (mBuilder10.mUseChronometer) {
                    view.setViewVisibility(R.id.chronometer, i4);
                    view.setLong(R.id.chronometer, "setBase", whenIfShowing2 += i9);
                    view.setBoolean(R.id.chronometer, "setStarted", i10);
                    if (mBuilder11.mChronometerCountDown) {
                        NotificationCompat.Style.Api24Impl.setChronometerCountDown(view, R.id.chronometer, mBuilder16.mChronometerCountDown);
                    }
                } else {
                    view.setViewVisibility(R.id.time, i4);
                    view.setLong(R.id.time, "setTime", obj.mBuilder.getWhenIfShowing());
                }
                hasRightSide2 = 1;
            }
            i3 = hasRightSide2 != 0 ? i4 : i;
            view.setViewVisibility(R.id.right_side, i3);
            if (showLine3 != 0) {
            } else {
                i4 = i;
            }
            view.setViewVisibility(R.id.line3, i4);
            return view;
        }

        public Notification build() {
            int notification;
            androidx.core.app.NotificationCompat.Builder mBuilder;
            notification = 0;
            if (this.mBuilder != null) {
                notification = this.mBuilder.build();
            }
            return notification;
        }

        public void buildIntoRemoteViews(RemoteViews outerView, RemoteViews innerView) {
            hideNormalContent(outerView);
            outerView.removeAllViews(R.id.notification_main_column);
            outerView.addView(R.id.notification_main_column, innerView.clone());
            outerView.setViewVisibility(R.id.notification_main_column, 0);
            outerView.setViewPadding(R.id.notification_main_column_container, 0, calculateTopPadding(), 0, 0);
        }

        protected void clearCompatExtraKeys(Bundle extras) {
            extras.remove("android.summaryText");
            extras.remove("android.title.big");
            extras.remove("androidx.core.app.extra.COMPAT_TEMPLATE");
        }

        public Bitmap createColoredBitmap(int iconId, int color) {
            return createColoredBitmap(iconId, color, 0);
        }

        Bitmap createColoredBitmap(IconCompat icon, int color) {
            return createColoredBitmap(icon, color, 0);
        }

        public boolean displayCustomViewInline() {
            return 0;
        }

        protected String getClassName() {
            return null;
        }

        public RemoteViews makeBigContentView(androidx.core.app.NotificationBuilderWithBuilderAccessor builder) {
            return null;
        }

        public RemoteViews makeContentView(androidx.core.app.NotificationBuilderWithBuilderAccessor builder) {
            return null;
        }

        public RemoteViews makeHeadsUpContentView(androidx.core.app.NotificationBuilderWithBuilderAccessor builder) {
            return null;
        }

        protected void restoreFromCompatExtras(Bundle extras) {
            String str;
            str = "android.summaryText";
            if (extras.containsKey(str)) {
                this.mSummaryText = extras.getCharSequence(str);
                this.mSummaryTextSet = true;
            }
            this.mBigContentTitle = extras.getCharSequence("android.title.big");
        }

        public void setBuilder(androidx.core.app.NotificationCompat.Builder builder) {
            androidx.core.app.NotificationCompat.Builder mBuilder;
            this.mBuilder = builder;
            if (this.mBuilder != builder && this.mBuilder != null) {
                this.mBuilder = builder;
                if (this.mBuilder != null) {
                    this.mBuilder.setStyle(this);
                }
            }
        }
    }

    public static class BigPictureStyle extends androidx.core.app.NotificationCompat.Style {

        private static final String TEMPLATE_CLASS_NAME = "androidx.core.app.NotificationCompat$BigPictureStyle";
        private IconCompat mBigLargeIcon;
        private boolean mBigLargeIconSet;
        private java.lang.CharSequence mPictureContentDescription;
        private IconCompat mPictureIcon;
        private boolean mShowBigPictureWhenCollapsed;
        public BigPictureStyle(androidx.core.app.NotificationCompat.Builder builder) {
            super();
            setBuilder(builder);
        }

        private static IconCompat asIconCompat(Parcelable bitmapOrIcon) {
            boolean z;
            if (bitmapOrIcon != null && bitmapOrIcon instanceof Icon) {
                if (bitmapOrIcon instanceof Icon) {
                    return IconCompat.createFromIcon((Icon)bitmapOrIcon);
                }
                if (bitmapOrIcon instanceof Bitmap != null) {
                    return IconCompat.createWithBitmap((Bitmap)bitmapOrIcon);
                }
            }
            return null;
        }

        public static IconCompat getPictureIcon(Bundle extras) {
            if (extras == null) {
                return null;
            }
            Parcelable parcelable = extras.getParcelable("android.picture");
            if (parcelable != null) {
                return NotificationCompat.BigPictureStyle.asIconCompat(parcelable);
            }
            return NotificationCompat.BigPictureStyle.asIconCompat(extras.getParcelable("android.pictureIcon"));
        }

        @Override // androidx.core.app.NotificationCompat$Style
        public void apply(androidx.core.app.NotificationBuilderWithBuilderAccessor builder) {
            Notification.BigPictureStyle style;
            int context2;
            boolean context;
            boolean mSummaryTextSet;
            int mPictureContentDescription;
            Icon icon;
            boolean obj;
            boolean obj2;
            Notification.BigPictureStyle bigPictureStyle = new Notification.BigPictureStyle(builder.getBuilder());
            style = bigPictureStyle.setBigContentTitle(this.mBigContentTitle);
            final int i = 31;
            if (this.mPictureIcon != null) {
                if (Build.VERSION.SDK_INT >= i) {
                    context2 = 0;
                    if (builder instanceof NotificationCompatBuilder != null) {
                        context2 = (NotificationCompatBuilder)builder.getContext();
                    }
                    NotificationCompat.BigPictureStyle.Api31Impl.setBigPicture(style, this.mPictureIcon.toIcon(context2));
                } else {
                    if (this.mPictureIcon.getType() == 1) {
                        style = style.bigPicture(this.mPictureIcon.getBitmap());
                    } else {
                    }
                }
            }
            if (this.mBigLargeIconSet != null) {
                if (this.mBigLargeIcon == null) {
                    context = 0;
                    icon = context;
                    style.bigLargeIcon(context);
                } else {
                    context = 0;
                    if (builder instanceof NotificationCompatBuilder != null) {
                        context = (NotificationCompatBuilder)builder.getContext();
                    }
                    NotificationCompat.BigPictureStyle.Api23Impl.setBigLargeIcon(style, this.mBigLargeIcon.toIcon(context));
                }
            }
            if (this.mSummaryTextSet != null) {
                style.setSummaryText(this.mSummaryText);
            }
            if (Build.VERSION.SDK_INT >= i) {
                NotificationCompat.BigPictureStyle.Api31Impl.showBigPictureWhenCollapsed(style, this.mShowBigPictureWhenCollapsed);
                NotificationCompat.BigPictureStyle.Api31Impl.setContentDescription(style, this.mPictureContentDescription);
            }
        }

        @Override // androidx.core.app.NotificationCompat$Style
        public androidx.core.app.NotificationCompat.BigPictureStyle bigLargeIcon(Bitmap b) {
            int withBitmap;
            if (b == null) {
                withBitmap = 0;
            } else {
                withBitmap = IconCompat.createWithBitmap(b);
            }
            this.mBigLargeIcon = withBitmap;
            this.mBigLargeIconSet = true;
            return this;
        }

        @Override // androidx.core.app.NotificationCompat$Style
        public androidx.core.app.NotificationCompat.BigPictureStyle bigLargeIcon(Icon i) {
            int fromIcon;
            if (i == null) {
                fromIcon = 0;
            } else {
                fromIcon = IconCompat.createFromIcon(i);
            }
            this.mBigLargeIcon = fromIcon;
            this.mBigLargeIconSet = true;
            return this;
        }

        @Override // androidx.core.app.NotificationCompat$Style
        public androidx.core.app.NotificationCompat.BigPictureStyle bigPicture(Bitmap b) {
            int withBitmap;
            if (b == null) {
                withBitmap = 0;
            } else {
                withBitmap = IconCompat.createWithBitmap(b);
            }
            this.mPictureIcon = withBitmap;
            return this;
        }

        @Override // androidx.core.app.NotificationCompat$Style
        public androidx.core.app.NotificationCompat.BigPictureStyle bigPicture(Icon i) {
            this.mPictureIcon = IconCompat.createFromIcon(i);
            return this;
        }

        @Override // androidx.core.app.NotificationCompat$Style
        protected void clearCompatExtraKeys(Bundle extras) {
            super.clearCompatExtraKeys(extras);
            extras.remove("android.largeIcon.big");
            extras.remove("android.picture");
            extras.remove("android.pictureIcon");
            extras.remove("android.showBigPictureWhenCollapsed");
        }

        @Override // androidx.core.app.NotificationCompat$Style
        protected String getClassName() {
            return "androidx.core.app.NotificationCompat$BigPictureStyle";
        }

        @Override // androidx.core.app.NotificationCompat$Style
        protected void restoreFromCompatExtras(Bundle extras) {
            String str;
            super.restoreFromCompatExtras(extras);
            str = "android.largeIcon.big";
            if (extras.containsKey(str)) {
                this.mBigLargeIcon = NotificationCompat.BigPictureStyle.asIconCompat(extras.getParcelable(str));
                this.mBigLargeIconSet = true;
            }
            this.mPictureIcon = NotificationCompat.BigPictureStyle.getPictureIcon(extras);
            this.mShowBigPictureWhenCollapsed = extras.getBoolean("android.showBigPictureWhenCollapsed");
        }

        @Override // androidx.core.app.NotificationCompat$Style
        public androidx.core.app.NotificationCompat.BigPictureStyle setBigContentTitle(java.lang.CharSequence title) {
            this.mBigContentTitle = NotificationCompat.Builder.limitCharSequenceLength(title);
            return this;
        }

        @Override // androidx.core.app.NotificationCompat$Style
        public androidx.core.app.NotificationCompat.BigPictureStyle setContentDescription(java.lang.CharSequence contentDescription) {
            this.mPictureContentDescription = contentDescription;
            return this;
        }

        @Override // androidx.core.app.NotificationCompat$Style
        public androidx.core.app.NotificationCompat.BigPictureStyle setSummaryText(java.lang.CharSequence cs) {
            this.mSummaryText = NotificationCompat.Builder.limitCharSequenceLength(cs);
            this.mSummaryTextSet = true;
            return this;
        }

        @Override // androidx.core.app.NotificationCompat$Style
        public androidx.core.app.NotificationCompat.BigPictureStyle showBigPictureWhenCollapsed(boolean show) {
            this.mShowBigPictureWhenCollapsed = show;
            return this;
        }
    }

    public static class BigTextStyle extends androidx.core.app.NotificationCompat.Style {

        private static final String TEMPLATE_CLASS_NAME = "androidx.core.app.NotificationCompat$BigTextStyle";
        private java.lang.CharSequence mBigText;
        public BigTextStyle(androidx.core.app.NotificationCompat.Builder builder) {
            super();
            setBuilder(builder);
        }

        @Override // androidx.core.app.NotificationCompat$Style
        public void addCompatExtras(Bundle extras) {
            super.addCompatExtras(extras);
        }

        @Override // androidx.core.app.NotificationCompat$Style
        public void apply(androidx.core.app.NotificationBuilderWithBuilderAccessor builder) {
            boolean mSummaryTextSet;
            Notification.BigTextStyle bigTextStyle = new Notification.BigTextStyle(builder.getBuilder());
            if (this.mSummaryTextSet != null) {
                bigTextStyle.setBigContentTitle(this.mBigContentTitle).bigText(this.mBigText).setSummaryText(this.mSummaryText);
            }
        }

        @Override // androidx.core.app.NotificationCompat$Style
        public androidx.core.app.NotificationCompat.BigTextStyle bigText(java.lang.CharSequence cs) {
            this.mBigText = NotificationCompat.Builder.limitCharSequenceLength(cs);
            return this;
        }

        @Override // androidx.core.app.NotificationCompat$Style
        protected void clearCompatExtraKeys(Bundle extras) {
            super.clearCompatExtraKeys(extras);
            extras.remove("android.bigText");
        }

        @Override // androidx.core.app.NotificationCompat$Style
        protected String getClassName() {
            return "androidx.core.app.NotificationCompat$BigTextStyle";
        }

        @Override // androidx.core.app.NotificationCompat$Style
        protected void restoreFromCompatExtras(Bundle extras) {
            super.restoreFromCompatExtras(extras);
            this.mBigText = extras.getCharSequence("android.bigText");
        }

        @Override // androidx.core.app.NotificationCompat$Style
        public androidx.core.app.NotificationCompat.BigTextStyle setBigContentTitle(java.lang.CharSequence title) {
            this.mBigContentTitle = NotificationCompat.Builder.limitCharSequenceLength(title);
            return this;
        }

        @Override // androidx.core.app.NotificationCompat$Style
        public androidx.core.app.NotificationCompat.BigTextStyle setSummaryText(java.lang.CharSequence cs) {
            this.mSummaryText = NotificationCompat.Builder.limitCharSequenceLength(cs);
            this.mSummaryTextSet = true;
            return this;
        }
    }

    public static final class BubbleMetadata {

        private static final int FLAG_AUTO_EXPAND_BUBBLE = 1;
        private static final int FLAG_SUPPRESS_NOTIFICATION = 2;
        private PendingIntent mDeleteIntent;
        private int mDesiredHeight;
        private int mDesiredHeightResId;
        private int mFlags;
        private IconCompat mIcon;
        private PendingIntent mPendingIntent;
        private String mShortcutId;
        private BubbleMetadata(PendingIntent expandIntent, PendingIntent deleteIntent, IconCompat icon, int height, int heightResId, int flags, String shortcutId) {
            super();
            this.mPendingIntent = expandIntent;
            this.mIcon = icon;
            this.mDesiredHeight = height;
            this.mDesiredHeightResId = heightResId;
            this.mDeleteIntent = deleteIntent;
            this.mFlags = flags;
            this.mShortcutId = shortcutId;
        }

        BubbleMetadata(PendingIntent x0, PendingIntent x1, IconCompat x2, int x3, int x4, int x5, String x6, androidx.core.app.NotificationCompat.1 x7) {
            super(x0, x1, x2, x3, x4, x5, x6);
        }

        public static androidx.core.app.NotificationCompat.BubbleMetadata fromPlatform(Notification.BubbleMetadata platformMetadata) {
            int i = 0;
            if (platformMetadata == null) {
                return i;
            }
            if (Build.VERSION.SDK_INT >= 30) {
                return NotificationCompat.BubbleMetadata.Api30Impl.fromPlatform(platformMetadata);
            }
            if (Build.VERSION.SDK_INT == 29) {
                return NotificationCompat.BubbleMetadata.Api29Impl.fromPlatform(platformMetadata);
            }
            return i;
        }

        public static Notification.BubbleMetadata toPlatform(androidx.core.app.NotificationCompat.BubbleMetadata compatMetadata) {
            int i = 0;
            if (compatMetadata == null) {
                return i;
            }
            if (Build.VERSION.SDK_INT >= 30) {
                return NotificationCompat.BubbleMetadata.Api30Impl.toPlatform(compatMetadata);
            }
            if (Build.VERSION.SDK_INT == 29) {
                return NotificationCompat.BubbleMetadata.Api29Impl.toPlatform(compatMetadata);
            }
            return i;
        }

        public boolean getAutoExpandBubble() {
            int i;
            if (mFlags &= i != 0) {
            } else {
                i = 0;
            }
            return i;
        }

        public PendingIntent getDeleteIntent() {
            return this.mDeleteIntent;
        }

        public int getDesiredHeight() {
            return this.mDesiredHeight;
        }

        public int getDesiredHeightResId() {
            return this.mDesiredHeightResId;
        }

        public IconCompat getIcon() {
            return this.mIcon;
        }

        public PendingIntent getIntent() {
            return this.mPendingIntent;
        }

        public String getShortcutId() {
            return this.mShortcutId;
        }

        public boolean isNotificationSuppressed() {
            int i;
            i = mFlags &= 2 != 0 ? 1 : 0;
            return i;
        }

        public void setFlags(int flags) {
            this.mFlags = flags;
        }
    }

    public static class Builder {

        private static final int MAX_CHARSEQUENCE_LENGTH = 5120;
        public ArrayList<androidx.core.app.NotificationCompat.Action> mActions;
        boolean mAllowSystemGeneratedContextualActions;
        int mBadgeIcon;
        RemoteViews mBigContentView;
        androidx.core.app.NotificationCompat.BubbleMetadata mBubbleMetadata;
        String mCategory;
        String mChannelId;
        boolean mChronometerCountDown;
        int mColor;
        boolean mColorized;
        boolean mColorizedSet;
        java.lang.CharSequence mContentInfo;
        PendingIntent mContentIntent;
        java.lang.CharSequence mContentText;
        java.lang.CharSequence mContentTitle;
        RemoteViews mContentView;
        public Context mContext;
        Bundle mExtras;
        int mFgsDeferBehavior;
        PendingIntent mFullScreenIntent;
        int mGroupAlertBehavior;
        String mGroupKey;
        boolean mGroupSummary;
        RemoteViews mHeadsUpContentView;
        ArrayList<androidx.core.app.NotificationCompat.Action> mInvisibleActions;
        IconCompat mLargeIcon;
        boolean mLocalOnly;
        LocusIdCompat mLocusId;
        Notification mNotification;
        int mNumber;
        @Deprecated
        public ArrayList<String> mPeople;
        public ArrayList<androidx.core.app.Person> mPersonList;
        int mPriority;
        int mProgress;
        boolean mProgressIndeterminate;
        int mProgressMax;
        Notification mPublicVersion;
        java.lang.CharSequence[] mRemoteInputHistory;
        java.lang.CharSequence mSettingsText;
        String mShortcutId;
        boolean mShowWhen;
        boolean mSilent;
        Object mSmallIcon;
        String mSortKey;
        androidx.core.app.NotificationCompat.Style mStyle;
        java.lang.CharSequence mSubText;
        RemoteViews mTickerView;
        long mTimeout;
        boolean mUseChronometer;
        int mVisibility;
        @Deprecated
        public Builder(Context context) {
            final int i = 0;
            final int i2 = i;
            super(context, i);
        }

        public Builder(Context context, Notification notification) {
            Notification.Action[] largeIcon;
            Object extrasWithoutDuplicateData;
            int i;
            String boolean3;
            String boolean2;
            int iconLevel;
            boolean iterator2;
            String length;
            String iterator;
            int boolean;
            Notification.Action androidPerson;
            androidx.core.app.NotificationCompat.Action build;
            super(context, NotificationCompat.getChannelId(notification));
            Bundle extras = notification.extras;
            final androidx.core.app.NotificationCompat.Style styleFromNotification = NotificationCompat.Style.extractStyleFromNotification(notification);
            int ledOnMS = notification.ledOnMS;
            setContentTitle(NotificationCompat.getContentTitle(notification)).setContentText(NotificationCompat.getContentText(notification)).setContentInfo(NotificationCompat.getContentInfo(notification)).setSubText(NotificationCompat.getSubText(notification)).setSettingsText(NotificationCompat.getSettingsText(notification)).setStyle(styleFromNotification).setGroup(NotificationCompat.getGroup(notification)).setGroupSummary(NotificationCompat.isGroupSummary(notification)).setLocusId(NotificationCompat.getLocusId(notification)).setWhen(notification.when).setShowWhen(NotificationCompat.getShowWhen(notification)).setUsesChronometer(NotificationCompat.getUsesChronometer(notification)).setAutoCancel(NotificationCompat.getAutoCancel(notification)).setOnlyAlertOnce(NotificationCompat.getOnlyAlertOnce(notification)).setOngoing(NotificationCompat.getOngoing(notification)).setLocalOnly(NotificationCompat.getLocalOnly(notification)).setLargeIcon(notification.largeIcon).setBadgeIconType(NotificationCompat.getBadgeIconType(notification)).setCategory(NotificationCompat.getCategory(notification)).setBubbleMetadata(NotificationCompat.getBubbleMetadata(notification)).setNumber(notification.number).setTicker(notification.tickerText).setContentIntent(notification.contentIntent).setDeleteIntent(notification.deleteIntent).setFullScreenIntent(notification.fullScreenIntent, NotificationCompat.getHighPriority(notification)).setSound(notification.sound, notification.audioStreamType).setVibrate(notification.vibrate).setLights(notification.ledARGB, ledOnMS, notification.ledOffMS).setDefaults(notification.defaults).setPriority(notification.priority).setColor(NotificationCompat.getColor(notification)).setVisibility(NotificationCompat.getVisibility(notification)).setPublicVersion(NotificationCompat.getPublicVersion(notification)).setSortKey(NotificationCompat.getSortKey(notification)).setTimeoutAfter(NotificationCompat.getTimeoutAfter(notification)).setShortcutId(NotificationCompat.getShortcutId(notification)).setProgress(extras.getInt("android.progressMax"), extras.getInt("android.progress"), extras.getBoolean("android.progressIndeterminate")).setAllowSystemGeneratedContextualActions(NotificationCompat.getAllowSystemGeneratedContextualActions(notification)).setSmallIcon(notification.icon, notification.iconLevel).addExtras(NotificationCompat.Builder.getExtrasWithoutDuplicateData(notification, styleFromNotification));
            this.mSmallIcon = NotificationCompat.Builder.Api23Impl.getSmallIcon(notification);
            Icon largeIcon3 = NotificationCompat.Builder.Api23Impl.getLargeIcon(notification);
            if (largeIcon3 != null) {
                this.mLargeIcon = IconCompat.createFromIcon(largeIcon3);
            }
            if (notification.actions != null && actions.length != 0) {
                if (actions.length != 0) {
                    largeIcon = notification.actions;
                    boolean = i;
                    while (boolean < largeIcon.length) {
                        addAction(NotificationCompat.Action.Builder.fromAndroidAction(largeIcon[boolean]).build());
                        boolean++;
                    }
                }
            }
            List invisibleActions = NotificationCompat.getInvisibleActions(notification);
            if (!invisibleActions.isEmpty()) {
                iterator2 = invisibleActions.iterator();
                for (NotificationCompat.Action boolean : iterator2) {
                    addInvisibleAction(boolean);
                }
            }
            String[] stringArray = notification.extras.getStringArray("android.people");
            if (stringArray != null && stringArray.length != 0) {
                if (stringArray.length != 0) {
                    while (i < stringArray.length) {
                        addPerson(stringArray[i]);
                        i++;
                    }
                }
            }
            ArrayList parcelableArrayList = notification.extras.getParcelableArrayList("android.people.list");
            if (parcelableArrayList != null && !parcelableArrayList.isEmpty()) {
                if (!parcelableArrayList.isEmpty()) {
                    iterator = parcelableArrayList.iterator();
                    for (Person boolean : iterator) {
                        addPerson(Person.fromAndroidPerson(boolean));
                    }
                }
            }
            boolean3 = "android.chronometerCountDown";
            if (extras.containsKey(boolean3)) {
                setChronometerCountDown(extras.getBoolean(boolean3));
            }
            boolean2 = "android.colorized";
            if (extras.containsKey(boolean2)) {
                setColorized(extras.getBoolean(boolean2));
            }
        }

        public Builder(Context context, String channelId) {
            super();
            ArrayList arrayList = new ArrayList();
            this.mActions = arrayList;
            ArrayList arrayList2 = new ArrayList();
            this.mPersonList = arrayList2;
            ArrayList arrayList3 = new ArrayList();
            this.mInvisibleActions = arrayList3;
            int i = 1;
            this.mShowWhen = i;
            int i2 = 0;
            this.mLocalOnly = i2;
            this.mColor = i2;
            this.mVisibility = i2;
            this.mBadgeIcon = i2;
            this.mGroupAlertBehavior = i2;
            this.mFgsDeferBehavior = i2;
            Notification notification = new Notification();
            this.mNotification = notification;
            this.mContext = context;
            this.mChannelId = channelId;
            mNotification.when = System.currentTimeMillis();
            mNotification2.audioStreamType = -1;
            this.mPriority = i2;
            ArrayList arrayList4 = new ArrayList();
            this.mPeople = arrayList4;
            this.mAllowSystemGeneratedContextualActions = i;
        }

        private static Bundle getExtrasWithoutDuplicateData(Notification notification, androidx.core.app.NotificationCompat.Style style) {
            Bundle carExtenderExtras;
            String str;
            if (notification.extras == null) {
                return null;
            }
            Bundle bundle = new Bundle(notification.extras);
            bundle.remove("android.title");
            bundle.remove("android.text");
            bundle.remove("android.infoText");
            bundle.remove("android.subText");
            bundle.remove("android.intent.extra.CHANNEL_ID");
            bundle.remove("android.intent.extra.CHANNEL_GROUP_ID");
            bundle.remove("android.showWhen");
            bundle.remove("android.progress");
            bundle.remove("android.progressMax");
            bundle.remove("android.progressIndeterminate");
            bundle.remove("android.chronometerCountDown");
            bundle.remove("android.colorized");
            bundle.remove("android.people.list");
            bundle.remove("android.people");
            bundle.remove("android.support.sortKey");
            bundle.remove("android.support.groupKey");
            bundle.remove("android.support.isGroupSummary");
            bundle.remove("android.support.localOnly");
            bundle.remove("android.support.actionExtras");
            String str21 = "android.car.EXTENSIONS";
            carExtenderExtras = bundle.getBundle(str21);
            if (carExtenderExtras != null) {
                Bundle bundle2 = new Bundle(carExtenderExtras);
                carExtenderExtras = bundle2;
                carExtenderExtras.remove("invisible_actions");
                bundle.putBundle(str21, carExtenderExtras);
            }
            if (style != null) {
                style.clearCompatExtraKeys(bundle);
            }
            return bundle;
        }

        protected static java.lang.CharSequence limitCharSequenceLength(java.lang.CharSequence cs) {
            int length;
            java.lang.CharSequence obj2;
            if (cs == null) {
                return cs;
            }
            final int i = 5120;
            if (cs.length() > i) {
                obj2 = cs.subSequence(0, i);
            }
            return obj2;
        }

        private void setFlag(int mask, boolean value) {
            Notification mNotification;
            int i;
            int i2;
            if (value != null) {
                mNotification = this.mNotification;
                mNotification.flags = flags |= mask;
            } else {
                mNotification = this.mNotification;
                mNotification.flags = flags2 &= i2;
            }
        }

        private boolean useExistingRemoteView() {
            int i;
            androidx.core.app.NotificationCompat.Style displayCustomViewInline;
            if (this.mStyle != null) {
                if (!this.mStyle.displayCustomViewInline()) {
                    i = 1;
                } else {
                    i = 0;
                }
            } else {
            }
            return i;
        }

        public androidx.core.app.NotificationCompat.Builder addAction(int icon, java.lang.CharSequence title, PendingIntent intent) {
            NotificationCompat.Action action = new NotificationCompat.Action(icon, title, intent);
            this.mActions.add(action);
            return this;
        }

        public androidx.core.app.NotificationCompat.Builder addAction(androidx.core.app.NotificationCompat.Action action) {
            ArrayList mActions;
            if (action != null) {
                this.mActions.add(action);
            }
            return this;
        }

        public androidx.core.app.NotificationCompat.Builder addExtras(Bundle extras) {
            Bundle mExtras;
            if (extras != null) {
                if (this.mExtras == null) {
                    mExtras = new Bundle(extras);
                    this.mExtras = mExtras;
                } else {
                    this.mExtras.putAll(extras);
                }
            }
            return this;
        }

        public androidx.core.app.NotificationCompat.Builder addInvisibleAction(int icon, java.lang.CharSequence title, PendingIntent intent) {
            NotificationCompat.Action action = new NotificationCompat.Action(icon, title, intent);
            this.mInvisibleActions.add(action);
            return this;
        }

        public androidx.core.app.NotificationCompat.Builder addInvisibleAction(androidx.core.app.NotificationCompat.Action action) {
            ArrayList mInvisibleActions;
            if (action != null) {
                this.mInvisibleActions.add(action);
            }
            return this;
        }

        public androidx.core.app.NotificationCompat.Builder addPerson(androidx.core.app.Person person) {
            ArrayList mPersonList;
            if (person != null) {
                this.mPersonList.add(person);
            }
            return this;
        }

        @Deprecated
        public androidx.core.app.NotificationCompat.Builder addPerson(String uri) {
            boolean mPeople;
            if (uri != null && !uri.isEmpty()) {
                if (!uri.isEmpty()) {
                    this.mPeople.add(uri);
                }
            }
            return this;
        }

        public Notification build() {
            NotificationCompatBuilder notificationCompatBuilder = new NotificationCompatBuilder(this);
            return notificationCompatBuilder.build();
        }

        public androidx.core.app.NotificationCompat.Builder clearActions() {
            this.mActions.clear();
            return this;
        }

        public androidx.core.app.NotificationCompat.Builder clearInvisibleActions() {
            Bundle carExtenderBundle;
            Bundle mExtras;
            this.mInvisibleActions.clear();
            final String str = "android.car.EXTENSIONS";
            carExtenderBundle = this.mExtras.getBundle(str);
            if (carExtenderBundle != null) {
                Bundle bundle = new Bundle(carExtenderBundle);
                carExtenderBundle = bundle;
                carExtenderBundle.remove("invisible_actions");
                this.mExtras.putBundle(str, carExtenderBundle);
            }
            return this;
        }

        public androidx.core.app.NotificationCompat.Builder clearPeople() {
            this.mPersonList.clear();
            this.mPeople.clear();
            return this;
        }

        public RemoteViews createBigContentView() {
            RemoteViews useExistingRemoteView;
            Object bigContentView;
            if (this.mBigContentView != null && useExistingRemoteView()) {
                if (useExistingRemoteView()) {
                    return this.mBigContentView;
                }
            }
            NotificationCompatBuilder notificationCompatBuilder = new NotificationCompatBuilder(this);
            bigContentView = this.mStyle.makeBigContentView(notificationCompatBuilder);
            if (this.mStyle != null && bigContentView != null) {
                bigContentView = this.mStyle.makeBigContentView(notificationCompatBuilder);
                if (bigContentView != null) {
                    return bigContentView;
                }
            }
            return NotificationCompat.Builder.Api24Impl.createBigContentView(NotificationCompat.Builder.Api24Impl.recoverBuilder(this.mContext, notificationCompatBuilder.build()));
        }

        public RemoteViews createContentView() {
            RemoteViews useExistingRemoteView;
            Object contentView;
            if (this.mContentView != null && useExistingRemoteView()) {
                if (useExistingRemoteView()) {
                    return this.mContentView;
                }
            }
            NotificationCompatBuilder notificationCompatBuilder = new NotificationCompatBuilder(this);
            contentView = this.mStyle.makeContentView(notificationCompatBuilder);
            if (this.mStyle != null && contentView != null) {
                contentView = this.mStyle.makeContentView(notificationCompatBuilder);
                if (contentView != null) {
                    return contentView;
                }
            }
            return NotificationCompat.Builder.Api24Impl.createContentView(NotificationCompat.Builder.Api24Impl.recoverBuilder(this.mContext, notificationCompatBuilder.build()));
        }

        public RemoteViews createHeadsUpContentView() {
            RemoteViews useExistingRemoteView;
            Object headsUpContentView;
            if (this.mHeadsUpContentView != null && useExistingRemoteView()) {
                if (useExistingRemoteView()) {
                    return this.mHeadsUpContentView;
                }
            }
            NotificationCompatBuilder notificationCompatBuilder = new NotificationCompatBuilder(this);
            headsUpContentView = this.mStyle.makeHeadsUpContentView(notificationCompatBuilder);
            if (this.mStyle != null && headsUpContentView != null) {
                headsUpContentView = this.mStyle.makeHeadsUpContentView(notificationCompatBuilder);
                if (headsUpContentView != null) {
                    return headsUpContentView;
                }
            }
            return NotificationCompat.Builder.Api24Impl.createHeadsUpContentView(NotificationCompat.Builder.Api24Impl.recoverBuilder(this.mContext, notificationCompatBuilder.build()));
        }

        public androidx.core.app.NotificationCompat.Builder extend(androidx.core.app.NotificationCompat.Extender extender) {
            extender.extend(this);
            return this;
        }

        public RemoteViews getBigContentView() {
            return this.mBigContentView;
        }

        public androidx.core.app.NotificationCompat.BubbleMetadata getBubbleMetadata() {
            return this.mBubbleMetadata;
        }

        public int getColor() {
            return this.mColor;
        }

        public RemoteViews getContentView() {
            return this.mContentView;
        }

        public Bundle getExtras() {
            Bundle mExtras;
            if (this.mExtras == null) {
                mExtras = new Bundle();
                this.mExtras = mExtras;
            }
            return this.mExtras;
        }

        public int getForegroundServiceBehavior() {
            return this.mFgsDeferBehavior;
        }

        public RemoteViews getHeadsUpContentView() {
            return this.mHeadsUpContentView;
        }

        @Deprecated
        public Notification getNotification() {
            return build();
        }

        public int getPriority() {
            return this.mPriority;
        }

        public long getWhenIfShowing() {
            long when;
            when = this.mShowWhen ? mNotification.when : 0;
            return when;
        }

        public androidx.core.app.NotificationCompat.Builder setAllowSystemGeneratedContextualActions(boolean allowed) {
            this.mAllowSystemGeneratedContextualActions = allowed;
            return this;
        }

        public androidx.core.app.NotificationCompat.Builder setAutoCancel(boolean autoCancel) {
            setFlag(16, autoCancel);
            return this;
        }

        public androidx.core.app.NotificationCompat.Builder setBadgeIconType(int icon) {
            this.mBadgeIcon = icon;
            return this;
        }

        public androidx.core.app.NotificationCompat.Builder setBubbleMetadata(androidx.core.app.NotificationCompat.BubbleMetadata data) {
            this.mBubbleMetadata = data;
            return this;
        }

        public androidx.core.app.NotificationCompat.Builder setCategory(String category) {
            this.mCategory = category;
            return this;
        }

        public androidx.core.app.NotificationCompat.Builder setChannelId(String channelId) {
            this.mChannelId = channelId;
            return this;
        }

        public androidx.core.app.NotificationCompat.Builder setChronometerCountDown(boolean countsDown) {
            this.mChronometerCountDown = countsDown;
            getExtras().putBoolean("android.chronometerCountDown", countsDown);
            return this;
        }

        public androidx.core.app.NotificationCompat.Builder setColor(int argb) {
            this.mColor = argb;
            return this;
        }

        public androidx.core.app.NotificationCompat.Builder setColorized(boolean colorize) {
            this.mColorized = colorize;
            this.mColorizedSet = true;
            return this;
        }

        public androidx.core.app.NotificationCompat.Builder setContent(RemoteViews views) {
            mNotification.contentView = views;
            return this;
        }

        public androidx.core.app.NotificationCompat.Builder setContentInfo(java.lang.CharSequence info) {
            this.mContentInfo = NotificationCompat.Builder.limitCharSequenceLength(info);
            return this;
        }

        public androidx.core.app.NotificationCompat.Builder setContentIntent(PendingIntent intent) {
            this.mContentIntent = intent;
            return this;
        }

        public androidx.core.app.NotificationCompat.Builder setContentText(java.lang.CharSequence text) {
            this.mContentText = NotificationCompat.Builder.limitCharSequenceLength(text);
            return this;
        }

        public androidx.core.app.NotificationCompat.Builder setContentTitle(java.lang.CharSequence title) {
            this.mContentTitle = NotificationCompat.Builder.limitCharSequenceLength(title);
            return this;
        }

        public androidx.core.app.NotificationCompat.Builder setCustomBigContentView(RemoteViews contentView) {
            this.mBigContentView = contentView;
            return this;
        }

        public androidx.core.app.NotificationCompat.Builder setCustomContentView(RemoteViews contentView) {
            this.mContentView = contentView;
            return this;
        }

        public androidx.core.app.NotificationCompat.Builder setCustomHeadsUpContentView(RemoteViews contentView) {
            this.mHeadsUpContentView = contentView;
            return this;
        }

        public androidx.core.app.NotificationCompat.Builder setDefaults(int defaults) {
            int mNotification;
            int i;
            mNotification2.defaults = defaults;
            if (defaults & 4 != 0) {
                mNotification = this.mNotification;
                mNotification.flags = flags |= 1;
            }
            return this;
        }

        public androidx.core.app.NotificationCompat.Builder setDeleteIntent(PendingIntent intent) {
            mNotification.deleteIntent = intent;
            return this;
        }

        public androidx.core.app.NotificationCompat.Builder setExtras(Bundle extras) {
            this.mExtras = extras;
            return this;
        }

        public androidx.core.app.NotificationCompat.Builder setForegroundServiceBehavior(int behavior) {
            this.mFgsDeferBehavior = behavior;
            return this;
        }

        public androidx.core.app.NotificationCompat.Builder setFullScreenIntent(PendingIntent intent, boolean highPriority) {
            this.mFullScreenIntent = intent;
            setFlag(128, highPriority);
            return this;
        }

        public androidx.core.app.NotificationCompat.Builder setGroup(String groupKey) {
            this.mGroupKey = groupKey;
            return this;
        }

        public androidx.core.app.NotificationCompat.Builder setGroupAlertBehavior(int groupAlertBehavior) {
            this.mGroupAlertBehavior = groupAlertBehavior;
            return this;
        }

        public androidx.core.app.NotificationCompat.Builder setGroupSummary(boolean isGroupSummary) {
            this.mGroupSummary = isGroupSummary;
            return this;
        }

        public androidx.core.app.NotificationCompat.Builder setLargeIcon(Bitmap icon) {
            int withBitmap;
            if (icon == null) {
                withBitmap = 0;
            } else {
                withBitmap = IconCompat.createWithBitmap(NotificationCompat.reduceLargeIconSize(this.mContext, icon));
            }
            this.mLargeIcon = withBitmap;
            return this;
        }

        public androidx.core.app.NotificationCompat.Builder setLargeIcon(Icon icon) {
            int fromIcon;
            if (icon == null) {
                fromIcon = 0;
            } else {
                fromIcon = IconCompat.createFromIcon(icon);
            }
            this.mLargeIcon = fromIcon;
            return this;
        }

        public androidx.core.app.NotificationCompat.Builder setLights(int argb, int onMs, int offMs) {
            int ledOffMS;
            int i2;
            int i;
            mNotification.ledARGB = argb;
            mNotification2.ledOnMS = onMs;
            mNotification3.ledOffMS = offMs;
            final int i4 = 0;
            if (mNotification4.ledOnMS != 0 && mNotification5.ledOffMS != 0) {
                i2 = mNotification5.ledOffMS != 0 ? i : i4;
            } else {
            }
            if (i2 != 0) {
            } else {
                i = i4;
            }
            mNotification6.flags = i |= i5;
            return this;
        }

        public androidx.core.app.NotificationCompat.Builder setLocalOnly(boolean b) {
            this.mLocalOnly = b;
            return this;
        }

        public androidx.core.app.NotificationCompat.Builder setLocusId(LocusIdCompat locusId) {
            this.mLocusId = locusId;
            return this;
        }

        @Deprecated
        public androidx.core.app.NotificationCompat.Builder setNotificationSilent() {
            this.mSilent = true;
            return this;
        }

        public androidx.core.app.NotificationCompat.Builder setNumber(int number) {
            this.mNumber = number;
            return this;
        }

        public androidx.core.app.NotificationCompat.Builder setOngoing(boolean ongoing) {
            setFlag(2, ongoing);
            return this;
        }

        public androidx.core.app.NotificationCompat.Builder setOnlyAlertOnce(boolean onlyAlertOnce) {
            setFlag(8, onlyAlertOnce);
            return this;
        }

        public androidx.core.app.NotificationCompat.Builder setPriority(int pri) {
            this.mPriority = pri;
            return this;
        }

        public androidx.core.app.NotificationCompat.Builder setProgress(int max, int progress, boolean indeterminate) {
            this.mProgressMax = max;
            this.mProgress = progress;
            this.mProgressIndeterminate = indeterminate;
            return this;
        }

        public androidx.core.app.NotificationCompat.Builder setPublicVersion(Notification n) {
            this.mPublicVersion = n;
            return this;
        }

        public androidx.core.app.NotificationCompat.Builder setRemoteInputHistory(java.lang.CharSequence[] text) {
            this.mRemoteInputHistory = text;
            return this;
        }

        public androidx.core.app.NotificationCompat.Builder setSettingsText(java.lang.CharSequence text) {
            this.mSettingsText = NotificationCompat.Builder.limitCharSequenceLength(text);
            return this;
        }

        public androidx.core.app.NotificationCompat.Builder setShortcutId(String shortcutId) {
            this.mShortcutId = shortcutId;
            return this;
        }

        public androidx.core.app.NotificationCompat.Builder setShortcutInfo(ShortcutInfoCompat shortcutInfo) {
            Object locusIdCompat;
            java.lang.CharSequence mContentTitle;
            String str;
            if (shortcutInfo == null) {
                return this;
            }
            this.mShortcutId = shortcutInfo.getId();
            if (this.mLocusId == null) {
                if (shortcutInfo.getLocusId() != null) {
                    this.mLocusId = shortcutInfo.getLocusId();
                } else {
                    if (shortcutInfo.getId() != null) {
                        locusIdCompat = new LocusIdCompat(shortcutInfo.getId());
                        this.mLocusId = locusIdCompat;
                    }
                }
            }
            if (this.mContentTitle == null) {
                setContentTitle(shortcutInfo.getShortLabel());
            }
            return this;
        }

        public androidx.core.app.NotificationCompat.Builder setShowWhen(boolean show) {
            this.mShowWhen = show;
            return this;
        }

        public androidx.core.app.NotificationCompat.Builder setSilent(boolean silent) {
            this.mSilent = silent;
            return this;
        }

        public androidx.core.app.NotificationCompat.Builder setSmallIcon(int icon) {
            mNotification.icon = icon;
            return this;
        }

        public androidx.core.app.NotificationCompat.Builder setSmallIcon(int icon, int level) {
            mNotification.icon = icon;
            mNotification2.iconLevel = level;
            return this;
        }

        public androidx.core.app.NotificationCompat.Builder setSmallIcon(IconCompat icon) {
            this.mSmallIcon = icon.toIcon(this.mContext);
            return this;
        }

        public androidx.core.app.NotificationCompat.Builder setSortKey(String sortKey) {
            this.mSortKey = sortKey;
            return this;
        }

        public androidx.core.app.NotificationCompat.Builder setSound(Uri sound) {
            mNotification.sound = sound;
            mNotification2.audioStreamType = -1;
            mNotification3.audioAttributes = NotificationCompat.Builder.Api21Impl.build(NotificationCompat.Builder.Api21Impl.setUsage(NotificationCompat.Builder.Api21Impl.setContentType(NotificationCompat.Builder.Api21Impl.createBuilder(), 4), 5));
            return this;
        }

        public androidx.core.app.NotificationCompat.Builder setSound(Uri sound, int streamType) {
            mNotification.sound = sound;
            mNotification2.audioStreamType = streamType;
            mNotification3.audioAttributes = NotificationCompat.Builder.Api21Impl.build(NotificationCompat.Builder.Api21Impl.setLegacyStreamType(NotificationCompat.Builder.Api21Impl.setContentType(NotificationCompat.Builder.Api21Impl.createBuilder(), 4), streamType));
            return this;
        }

        public androidx.core.app.NotificationCompat.Builder setStyle(androidx.core.app.NotificationCompat.Style style) {
            androidx.core.app.NotificationCompat.Style mStyle;
            this.mStyle = style;
            if (this.mStyle != style && this.mStyle != null) {
                this.mStyle = style;
                if (this.mStyle != null) {
                    this.mStyle.setBuilder(this);
                }
            }
            return this;
        }

        public androidx.core.app.NotificationCompat.Builder setSubText(java.lang.CharSequence text) {
            this.mSubText = NotificationCompat.Builder.limitCharSequenceLength(text);
            return this;
        }

        public androidx.core.app.NotificationCompat.Builder setTicker(java.lang.CharSequence tickerText) {
            mNotification.tickerText = NotificationCompat.Builder.limitCharSequenceLength(tickerText);
            return this;
        }

        @Deprecated
        public androidx.core.app.NotificationCompat.Builder setTicker(java.lang.CharSequence tickerText, RemoteViews views) {
            mNotification.tickerText = NotificationCompat.Builder.limitCharSequenceLength(tickerText);
            this.mTickerView = views;
            return this;
        }

        public androidx.core.app.NotificationCompat.Builder setTimeoutAfter(long durationMs) {
            this.mTimeout = durationMs;
            return this;
        }

        public androidx.core.app.NotificationCompat.Builder setUsesChronometer(boolean b) {
            this.mUseChronometer = b;
            return this;
        }

        public androidx.core.app.NotificationCompat.Builder setVibrate(long[] pattern) {
            mNotification.vibrate = pattern;
            return this;
        }

        public androidx.core.app.NotificationCompat.Builder setVisibility(int visibility) {
            this.mVisibility = visibility;
            return this;
        }

        public androidx.core.app.NotificationCompat.Builder setWhen(long when) {
            mNotification.when = when;
            return this;
        }
    }

    public static class CallStyle extends androidx.core.app.NotificationCompat.Style {

        public static final int CALL_TYPE_INCOMING = 1;
        public static final int CALL_TYPE_ONGOING = 2;
        public static final int CALL_TYPE_SCREENING = 3;
        public static final int CALL_TYPE_UNKNOWN = 0;
        private static final String KEY_ACTION_PRIORITY = "key_action_priority";
        private static final String TEMPLATE_CLASS_NAME = "androidx.core.app.NotificationCompat$CallStyle";
        private Integer mAnswerButtonColor;
        private PendingIntent mAnswerIntent;
        private int mCallType;
        private Integer mDeclineButtonColor;
        private PendingIntent mDeclineIntent;
        private PendingIntent mHangUpIntent;
        private boolean mIsVideo;
        private androidx.core.app.Person mPerson;
        private IconCompat mVerificationIcon;
        private java.lang.CharSequence mVerificationText;
        private CallStyle(int callType, androidx.core.app.Person person, PendingIntent hangUpIntent, PendingIntent declineIntent, PendingIntent answerIntent) {
            boolean empty;
            super();
            if (person == null) {
            } else {
                if (TextUtils.isEmpty(person.getName())) {
                } else {
                    this.mCallType = callType;
                    this.mPerson = person;
                    this.mAnswerIntent = answerIntent;
                    this.mDeclineIntent = declineIntent;
                    this.mHangUpIntent = hangUpIntent;
                }
            }
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("person must have a non-empty a name");
            throw illegalArgumentException;
        }

        public CallStyle(androidx.core.app.NotificationCompat.Builder builder) {
            super();
            setBuilder(builder);
        }

        public static androidx.core.app.NotificationCompat.CallStyle forIncomingCall(androidx.core.app.Person person, PendingIntent declineIntent, PendingIntent answerIntent) {
            NotificationCompat.CallStyle callStyle = new NotificationCompat.CallStyle(1, person, 0, (PendingIntent)Objects.requireNonNull(declineIntent, "declineIntent is required"), (PendingIntent)Objects.requireNonNull(answerIntent, "answerIntent is required"));
            return callStyle;
        }

        public static androidx.core.app.NotificationCompat.CallStyle forOngoingCall(androidx.core.app.Person person, PendingIntent hangUpIntent) {
            NotificationCompat.CallStyle callStyle = new NotificationCompat.CallStyle(2, person, (PendingIntent)Objects.requireNonNull(hangUpIntent, "hangUpIntent is required"), 0, 0);
            return callStyle;
        }

        public static androidx.core.app.NotificationCompat.CallStyle forScreeningCall(androidx.core.app.Person person, PendingIntent hangUpIntent, PendingIntent answerIntent) {
            NotificationCompat.CallStyle callStyle = new NotificationCompat.CallStyle(3, person, (PendingIntent)Objects.requireNonNull(hangUpIntent, "hangUpIntent is required"), 0, (PendingIntent)Objects.requireNonNull(answerIntent, "answerIntent is required"));
            return callStyle;
        }

        private String getDefaultText() {
            switch (mCallType) {
                case 1:
                    return mBuilder2.mContext.getResources().getString(R.string.call_notification_incoming_text);
                case 2:
                    return mBuilder.mContext.getResources().getString(R.string.call_notification_ongoing_text);
                case 3:
                    return mBuilder3.mContext.getResources().getString(R.string.call_notification_screening_text);
                default:
                    return null;
            }
        }

        private boolean isActionAddedByCallStyle(androidx.core.app.NotificationCompat.Action action) {
            boolean boolean;
            int i;
            String str;
            if (action != null && action.getExtras().getBoolean("key_action_priority")) {
                i = action.getExtras().getBoolean("key_action_priority") ? 1 : 0;
            } else {
            }
            return i;
        }

        private androidx.core.app.NotificationCompat.Action makeAction(int icon, int title, Integer colorInt, int defaultColorRes, PendingIntent intent) {
            int color;
            Integer obj8;
            if (colorInt == null) {
                obj8 = Integer.valueOf(ContextCompat.getColor(mBuilder.mContext, defaultColorRes));
            }
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            spannableStringBuilder.append(mBuilder2.mContext.getResources().getString(title));
            ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(obj8.intValue());
            spannableStringBuilder.setSpan(foregroundColorSpan, 0, spannableStringBuilder.length(), 18);
            NotificationCompat.Action.Builder builder = new NotificationCompat.Action.Builder(IconCompat.createWithResource(mBuilder3.mContext, icon), spannableStringBuilder, intent);
            androidx.core.app.NotificationCompat.Action build = builder.build();
            build.getExtras().putBoolean("key_action_priority", true);
            return build;
        }

        private androidx.core.app.NotificationCompat.Action makeAnswerAction() {
            int call_notification_answer_action;
            androidx.core.app.NotificationCompat.Action action;
            Object obj;
            int i2;
            int i;
            Integer mAnswerButtonColor;
            int call_notification_answer_color;
            PendingIntent mAnswerIntent;
            int ic_call_answer_video_low = R.drawable.ic_call_answer_video_low;
            int ic_call_answer_low = R.drawable.ic_call_answer_low;
            if (this.mAnswerIntent == null) {
                action = 0;
            } else {
                i2 = this.mIsVideo ? videoIcon : icon;
                i = this.mIsVideo ? call_notification_answer_action : call_notification_answer_action;
                action = this.makeAction(i2, i, this.mAnswerButtonColor, R.color.call_notification_answer_color, this.mAnswerIntent);
            }
            return action;
        }

        private androidx.core.app.NotificationCompat.Action makeNegativeAction() {
            int ic_call_decline_low = R.drawable.ic_call_decline_low;
            final int ic_call_decline = R.drawable.ic_call_decline;
            if (this.mDeclineIntent == null) {
                return this.makeAction(ic_call_decline, R.string.call_notification_hang_up_action, this.mDeclineButtonColor, R.color.call_notification_decline_color, this.mHangUpIntent);
            }
            Object obj2 = this;
            return obj2.makeAction(ic_call_decline, R.string.call_notification_decline_action, obj2.mDeclineButtonColor, R.color.call_notification_decline_color, obj2.mDeclineIntent);
        }

        @Override // androidx.core.app.NotificationCompat$Style
        public void addCompatExtras(Bundle extras) {
            Object castToParcelable;
            Object mVerificationIcon;
            Integer mAnswerButtonColor;
            Integer mDeclineButtonColor;
            boolean mIsVideo;
            Object mHangUpIntent;
            super.addCompatExtras(extras);
            extras.putInt("android.callType", this.mCallType);
            extras.putBoolean("android.callIsVideo", this.mIsVideo);
            if (this.mPerson != null) {
                extras.putParcelable("android.callPerson", NotificationCompat.CallStyle.Api28Impl.castToParcelable(this.mPerson.toAndroidPerson()));
            }
            if (this.mVerificationIcon != null) {
                extras.putParcelable("android.verificationIcon", NotificationCompat.CallStyle.Api23Impl.castToParcelable(this.mVerificationIcon.toIcon(mBuilder.mContext)));
            }
            extras.putCharSequence("android.verificationText", this.mVerificationText);
            extras.putParcelable("android.answerIntent", this.mAnswerIntent);
            extras.putParcelable("android.declineIntent", this.mDeclineIntent);
            extras.putParcelable("android.hangUpIntent", this.mHangUpIntent);
            if (this.mAnswerButtonColor != null) {
                extras.putInt("android.answerColor", this.mAnswerButtonColor.intValue());
            }
            if (this.mDeclineButtonColor != null) {
                extras.putInt("android.declineColor", this.mDeclineButtonColor.intValue());
            }
        }

        @Override // androidx.core.app.NotificationCompat$Style
        public void apply(androidx.core.app.NotificationBuilderWithBuilderAccessor builderAccessor) {
            Object style;
            int i2;
            android.app.Person androidPerson;
            Integer mAnswerButtonColor;
            Integer mDeclineButtonColor;
            Object mVerificationIcon;
            PendingIntent text;
            Object mAnswerIntent;
            Bundle mExtras;
            Object icon;
            Object androidPerson2;
            Object mContext;
            if (Build.VERSION.SDK_INT >= 31) {
                style = 0;
                switch (mCallType) {
                    case 1:
                        style = NotificationCompat.CallStyle.Api31Impl.forIncomingCall(this.mPerson.toAndroidPerson(), this.mDeclineIntent, this.mAnswerIntent);
                        break;
                    case 2:
                        style = NotificationCompat.CallStyle.Api31Impl.forOngoingCall(this.mPerson.toAndroidPerson(), this.mHangUpIntent);
                        break;
                    case 3:
                        style = NotificationCompat.CallStyle.Api31Impl.forScreeningCall(this.mPerson.toAndroidPerson(), this.mHangUpIntent, this.mAnswerIntent);
                        break;
                    default:
                        text = "NotifCompat";
                        StringBuilder stringBuilder = new StringBuilder();
                        Log.d(text, stringBuilder.append("Unrecognized call type in CallStyle: ").append(String.valueOf(this.mCallType)).toString());
                }
                style.setBuilder(builderAccessor.getBuilder());
                if (style != null && this.mAnswerButtonColor != null) {
                    style.setBuilder(builderAccessor.getBuilder());
                    if (this.mAnswerButtonColor != null) {
                        NotificationCompat.CallStyle.Api31Impl.setAnswerButtonColorHint(style, this.mAnswerButtonColor.intValue());
                    }
                    if (this.mDeclineButtonColor != null) {
                        NotificationCompat.CallStyle.Api31Impl.setDeclineButtonColorHint(style, this.mDeclineButtonColor.intValue());
                    }
                    NotificationCompat.CallStyle.Api31Impl.setVerificationText(style, this.mVerificationText);
                    if (this.mVerificationIcon != null) {
                        NotificationCompat.CallStyle.Api31Impl.setVerificationIcon(style, this.mVerificationIcon.toIcon(mBuilder.mContext));
                    }
                    NotificationCompat.CallStyle.Api31Impl.setIsVideo(style, this.mIsVideo);
                }
            } else {
                style = builderAccessor.getBuilder();
                if (this.mPerson != null) {
                    androidPerson = this.mPerson.getName();
                } else {
                    androidPerson = text;
                }
                style.setContentTitle(androidPerson);
                mContext = "android.text";
                if (mBuilder3.mExtras != null && mBuilder4.mExtras.containsKey(mContext)) {
                    mContext = "android.text";
                    if (mBuilder4.mExtras.containsKey(mContext)) {
                        text = mBuilder2.mExtras.getCharSequence(mContext);
                    } else {
                    }
                } else {
                }
                if (text == null) {
                    text = getDefaultText();
                }
                style.setContentText(text);
                if (this.mPerson != null && this.mPerson.getIcon() != null) {
                    if (this.mPerson.getIcon() != null) {
                        NotificationCompat.CallStyle.Api23Impl.setLargeIcon(style, this.mPerson.getIcon().toIcon(mBuilder5.mContext));
                    }
                    NotificationCompat.CallStyle.Api28Impl.addPerson(style, this.mPerson.toAndroidPerson());
                }
                NotificationCompat.CallStyle.Api21Impl.setCategory(style, "call");
            }
        }

        @Override // androidx.core.app.NotificationCompat$Style
        public boolean displayCustomViewInline() {
            return 1;
        }

        public ArrayList<androidx.core.app.NotificationCompat.Action> getActionsListWithSystemActions() {
            int nonContextualActionSlotsRemaining;
            Iterator iterator;
            Object next;
            boolean actionAddedByCallStyle;
            final androidx.core.app.NotificationCompat.Action answerAction = makeAnswerAction();
            nonContextualActionSlotsRemaining = 3;
            ArrayList arrayList = new ArrayList(3);
            if (nonContextualActionSlotsRemaining > 0) {
                arrayList.add(makeNegativeAction());
                nonContextualActionSlotsRemaining--;
            }
            ArrayList mActions = mBuilder.mActions;
            final int i2 = 1;
            if (mActions != null) {
                iterator = mActions.iterator();
                while (iterator.hasNext()) {
                    next = iterator.next();
                    if ((NotificationCompat.Action)next.isContextual()) {
                    } else {
                    }
                    if (isActionAddedByCallStyle(next)) {
                    } else {
                    }
                    if (nonContextualActionSlotsRemaining > i2) {
                    }
                    if (answerAction != null && nonContextualActionSlotsRemaining == i2) {
                    }
                    if (nonContextualActionSlotsRemaining == i2) {
                    }
                    arrayList.add(answerAction);
                    nonContextualActionSlotsRemaining--;
                    arrayList.add(next);
                    nonContextualActionSlotsRemaining--;
                    arrayList.add(next);
                }
            }
            if (answerAction != null && nonContextualActionSlotsRemaining >= i2) {
                if (nonContextualActionSlotsRemaining >= i2) {
                    arrayList.add(answerAction);
                }
            }
            return arrayList;
        }

        @Override // androidx.core.app.NotificationCompat$Style
        protected String getClassName() {
            return "androidx.core.app.NotificationCompat$CallStyle";
        }

        @Override // androidx.core.app.NotificationCompat$Style
        protected void restoreFromCompatExtras(Bundle extras) {
            Object androidPerson;
            Object fromBundle;
            Integer valueOf;
            int str;
            boolean key2;
            boolean key;
            Integer valueOf2;
            super.restoreFromCompatExtras(extras);
            this.mCallType = extras.getInt("android.callType");
            this.mIsVideo = extras.getBoolean("android.callIsVideo");
            String str4 = "android.callPerson";
            if (extras.containsKey(str4)) {
                this.mPerson = Person.fromAndroidPerson((Person)extras.getParcelable(str4));
            } else {
                androidPerson = "android.callPersonCompat";
                if (extras.containsKey(androidPerson)) {
                    this.mPerson = Person.fromBundle(extras.getBundle(androidPerson));
                }
            }
            String str5 = "android.verificationIcon";
            if (extras.containsKey(str5)) {
                this.mVerificationIcon = IconCompat.createFromIcon((Icon)extras.getParcelable(str5));
            } else {
                fromBundle = "android.verificationIconCompat";
                if (extras.containsKey(fromBundle)) {
                    this.mVerificationIcon = IconCompat.createFromBundle(extras.getBundle(fromBundle));
                }
            }
            this.mVerificationText = extras.getCharSequence("android.verificationText");
            this.mAnswerIntent = (PendingIntent)extras.getParcelable("android.answerIntent");
            this.mDeclineIntent = (PendingIntent)extras.getParcelable("android.declineIntent");
            this.mHangUpIntent = (PendingIntent)extras.getParcelable("android.hangUpIntent");
            String str10 = "android.answerColor";
            if (extras.containsKey(str10)) {
                valueOf = Integer.valueOf(extras.getInt(str10));
            } else {
                valueOf = valueOf2;
            }
            this.mAnswerButtonColor = valueOf;
            str = "android.declineColor";
            if (extras.containsKey(str)) {
                valueOf2 = Integer.valueOf(extras.getInt(str));
            } else {
            }
            this.mDeclineButtonColor = valueOf2;
        }

        @Override // androidx.core.app.NotificationCompat$Style
        public androidx.core.app.NotificationCompat.CallStyle setAnswerButtonColorHint(int color) {
            this.mAnswerButtonColor = Integer.valueOf(color);
            return this;
        }

        @Override // androidx.core.app.NotificationCompat$Style
        public androidx.core.app.NotificationCompat.CallStyle setDeclineButtonColorHint(int color) {
            this.mDeclineButtonColor = Integer.valueOf(color);
            return this;
        }

        @Override // androidx.core.app.NotificationCompat$Style
        public androidx.core.app.NotificationCompat.CallStyle setIsVideo(boolean isVideo) {
            this.mIsVideo = isVideo;
            return this;
        }

        @Override // androidx.core.app.NotificationCompat$Style
        public androidx.core.app.NotificationCompat.CallStyle setVerificationIcon(Bitmap verificationIcon) {
            this.mVerificationIcon = IconCompat.createWithBitmap(verificationIcon);
            return this;
        }

        @Override // androidx.core.app.NotificationCompat$Style
        public androidx.core.app.NotificationCompat.CallStyle setVerificationIcon(Icon verificationIcon) {
            int fromIcon;
            if (verificationIcon == null) {
                fromIcon = 0;
            } else {
                fromIcon = IconCompat.createFromIcon(verificationIcon);
            }
            this.mVerificationIcon = fromIcon;
            return this;
        }

        @Override // androidx.core.app.NotificationCompat$Style
        public androidx.core.app.NotificationCompat.CallStyle setVerificationText(java.lang.CharSequence verificationText) {
            this.mVerificationText = verificationText;
            return this;
        }
    }

    public interface Extender {
        public abstract androidx.core.app.NotificationCompat.Builder extend(androidx.core.app.NotificationCompat.Builder notificationCompat$Builder);
    }

    public static final class CarExtender implements androidx.core.app.NotificationCompat.Extender {

        static final String EXTRA_CAR_EXTENDER = "android.car.EXTENSIONS";
        private static final String EXTRA_COLOR = "app_color";
        private static final String EXTRA_CONVERSATION = "car_conversation";
        static final String EXTRA_INVISIBLE_ACTIONS = "invisible_actions";
        private static final String EXTRA_LARGE_ICON = "large_icon";
        private static final String KEY_AUTHOR = "author";
        private static final String KEY_MESSAGES = "messages";
        private static final String KEY_ON_READ = "on_read";
        private static final String KEY_ON_REPLY = "on_reply";
        private static final String KEY_PARTICIPANTS = "participants";
        private static final String KEY_REMOTE_INPUT = "remote_input";
        private static final String KEY_TEXT = "text";
        private static final String KEY_TIMESTAMP = "timestamp";
        private int mColor = 0;
        private Bitmap mLargeIcon;
        private androidx.core.app.NotificationCompat.CarExtender.UnreadConversation mUnreadConversation;
        public CarExtender() {
            super();
            final int i = 0;
        }

        public CarExtender(Notification notification) {
            int bundle2;
            int bundle;
            String unreadConversationFromBundle;
            super();
            if (NotificationCompat.getExtras(notification) == null) {
                bundle = 0;
            } else {
                bundle = NotificationCompat.getExtras(notification).getBundle("android.car.EXTENSIONS");
            }
            if (bundle != null) {
                this.mLargeIcon = (Bitmap)bundle.getParcelable("large_icon");
                this.mColor = bundle.getInt("app_color", 0);
                this.mUnreadConversation = NotificationCompat.CarExtender.getUnreadConversationFromBundle(bundle.getBundle("car_conversation"));
            }
        }

        private static Bundle getBundleForUnreadConversation(androidx.core.app.NotificationCompat.CarExtender.UnreadConversation uc) {
            int author;
            String[] participants;
            int i;
            int i2;
            Bundle bundle;
            int builder;
            String build;
            String str;
            Parcelable castToParcelable;
            Bundle bundle2 = new Bundle();
            author = 0;
            if (uc.getParticipants() != null && participants2.length > 1) {
                if (participants2.length > 1) {
                    author = uc.getParticipants()[0];
                }
            }
            Parcelable[] arr = new Parcelable[messages.length];
            i2 = 0;
            while (i2 < arr.length) {
                bundle = new Bundle();
                bundle.putString("text", uc.getMessages()[i2]);
                bundle.putString("author", author);
                arr[i2] = bundle;
                i2++;
            }
            bundle2.putParcelableArray("messages", arr);
            androidx.core.app.RemoteInput remoteInput = uc.getRemoteInput();
            if (remoteInput != null) {
                builder = NotificationCompat.CarExtender.Api20Impl.createBuilder(remoteInput.getResultKey());
                NotificationCompat.CarExtender.Api20Impl.setLabel(builder, remoteInput.getLabel());
                NotificationCompat.CarExtender.Api20Impl.setChoices(builder, remoteInput.getChoices());
                NotificationCompat.CarExtender.Api20Impl.setAllowFreeFormInput(builder, remoteInput.getAllowFreeFormInput());
                NotificationCompat.CarExtender.Api20Impl.addExtras(builder, remoteInput.getExtras());
                bundle2.putParcelable("remote_input", NotificationCompat.CarExtender.Api20Impl.castToParcelable(NotificationCompat.CarExtender.Api20Impl.build(builder)));
            }
            bundle2.putParcelable("on_reply", uc.getReplyPendingIntent());
            bundle2.putParcelable("on_read", uc.getReadPendingIntent());
            bundle2.putStringArray("participants", uc.getParticipants());
            bundle2.putLong("timestamp", uc.getLatestTimestamp());
            return bundle2;
        }

        private static androidx.core.app.NotificationCompat.CarExtender.UnreadConversation getUnreadConversationFromBundle(Bundle b) {
            String[] messages;
            String[] strArr2;
            String length2;
            int success;
            int i2;
            String length;
            String[] strArr;
            String str;
            androidx.core.app.RemoteInput remoteInput;
            androidx.core.app.RemoteInput remoteInput2;
            String resultKey;
            java.lang.CharSequence label;
            java.lang.CharSequence[] choices;
            boolean allowFreeFormInput;
            int editChoicesBeforeSending;
            Bundle extras;
            int i;
            final Object obj = b;
            int i3 = 0;
            if (obj == null) {
                return i3;
            }
            Parcelable[] parcelableArray = obj.getParcelableArray("messages");
            if (parcelableArray != null) {
                strArr2 = new String[parcelableArray.length];
                success = 1;
                i2 = 0;
                for (Object length : obj4) {
                    strArr2[i2] = (Bundle)parcelableArray[i2].getString("text");
                }
                if (success != 0) {
                    strArr = messages;
                    Parcelable parcelable3 = obj.getParcelable("remote_input");
                    final String[] stringArray = obj.getStringArray("participants");
                    if (stringArray != null) {
                        if (stringArray.length != 1) {
                        } else {
                            if ((RemoteInput)parcelable3 != null) {
                                remoteInput2 = new RemoteInput(NotificationCompat.CarExtender.Api20Impl.getResultKey((RemoteInput)parcelable3), NotificationCompat.CarExtender.Api20Impl.getLabel(parcelable3), NotificationCompat.CarExtender.Api20Impl.getChoices(parcelable3), NotificationCompat.CarExtender.Api20Impl.getAllowFreeFormInput(parcelable3), NotificationCompat.CarExtender.Api29Impl.getEditChoicesBeforeSending(parcelable3), NotificationCompat.CarExtender.Api20Impl.getExtras(parcelable3), 0);
                                remoteInput = remoteInput2;
                            } else {
                                remoteInput = i3;
                            }
                        }
                        NotificationCompat.CarExtender.UnreadConversation unreadConversation = new NotificationCompat.CarExtender.UnreadConversation(strArr, remoteInput, (PendingIntent)obj.getParcelable("on_reply"), (PendingIntent)obj.getParcelable("on_read"), stringArray, obj.getLong("timestamp"), resultKey);
                        return unreadConversation;
                    }
                    return i3;
                }
                return i3;
            }
            strArr = messages;
        }

        @Override // androidx.core.app.NotificationCompat$Extender
        public androidx.core.app.NotificationCompat.Builder extend(androidx.core.app.NotificationCompat.Builder builder) {
            Object mLargeIcon;
            int mColor;
            Object bundleForUnreadConversation;
            Bitmap mLargeIcon2;
            Bundle bundle = new Bundle();
            if (this.mLargeIcon != null) {
                bundle.putParcelable("large_icon", this.mLargeIcon);
            }
            if (this.mColor != 0) {
                bundle.putInt("app_color", this.mColor);
            }
            if (this.mUnreadConversation != null) {
                bundle.putBundle("car_conversation", NotificationCompat.CarExtender.getBundleForUnreadConversation(this.mUnreadConversation));
            }
            builder.getExtras().putBundle("android.car.EXTENSIONS", bundle);
            return builder;
        }

        @Override // androidx.core.app.NotificationCompat$Extender
        public int getColor() {
            return this.mColor;
        }

        @Override // androidx.core.app.NotificationCompat$Extender
        public Bitmap getLargeIcon() {
            return this.mLargeIcon;
        }

        @Deprecated
        public androidx.core.app.NotificationCompat.CarExtender.UnreadConversation getUnreadConversation() {
            return this.mUnreadConversation;
        }

        @Override // androidx.core.app.NotificationCompat$Extender
        public androidx.core.app.NotificationCompat.CarExtender setColor(int color) {
            this.mColor = color;
            return this;
        }

        @Override // androidx.core.app.NotificationCompat$Extender
        public androidx.core.app.NotificationCompat.CarExtender setLargeIcon(Bitmap largeIcon) {
            this.mLargeIcon = largeIcon;
            return this;
        }

        @Deprecated
        public androidx.core.app.NotificationCompat.CarExtender setUnreadConversation(androidx.core.app.NotificationCompat.CarExtender.UnreadConversation unreadConversation) {
            this.mUnreadConversation = unreadConversation;
            return this;
        }
    }

    public static class DecoratedCustomViewStyle extends androidx.core.app.NotificationCompat.Style {

        private static final int MAX_ACTION_BUTTONS = 3;
        private static final String TEMPLATE_CLASS_NAME = "androidx.core.app.NotificationCompat$DecoratedCustomViewStyle";
        private RemoteViews createRemoteViews(RemoteViews innerView, boolean showActions) {
            int actionsVisible;
            int i2;
            int i;
            int i3;
            RemoteViews actionButton;
            int actions;
            RemoteViews standardTemplate = applyStandardTemplate(true, R.layout.notification_template_custom_big, false);
            standardTemplate.removeAllViews(R.id.actions);
            actionsVisible = 0;
            List nonContextualActions = NotificationCompat.DecoratedCustomViewStyle.getNonContextualActions(mBuilder.mActions);
            i = Math.min(nonContextualActions.size(), 3);
            if (showActions && nonContextualActions != null && i > 0) {
                if (nonContextualActions != null) {
                    i = Math.min(nonContextualActions.size(), 3);
                    if (i > 0) {
                        actionsVisible = 1;
                        i3 = 0;
                        while (i3 < i) {
                            standardTemplate.addView(R.id.actions, generateActionButton((NotificationCompat.Action)nonContextualActions.get(i3)));
                            i3++;
                        }
                    }
                }
            }
            if (actionsVisible != 0) {
            } else {
                i2 = 8;
            }
            standardTemplate.setViewVisibility(R.id.actions, i2);
            standardTemplate.setViewVisibility(R.id.action_divider, i2);
            buildIntoRemoteViews(standardTemplate, innerView);
            return standardTemplate;
        }

        private RemoteViews generateActionButton(androidx.core.app.NotificationCompat.Action action) {
            int i;
            int notification_action_tombstone;
            int action_container;
            Bitmap coloredBitmap;
            Object actionIntent;
            i = action.actionIntent == null ? 1 : 0;
            notification_action_tombstone = i != 0 ? R.layout.notification_action_tombstone : R.layout.notification_action;
            RemoteViews remoteViews = new RemoteViews(mBuilder.mContext.getPackageName(), notification_action_tombstone);
            IconCompat iconCompat = action.getIconCompat();
            if (iconCompat != null) {
                remoteViews.setImageViewBitmap(R.id.action_image, createColoredBitmap(iconCompat, R.color.notification_action_color_filter));
            }
            remoteViews.setTextViewText(R.id.action_text, action.title);
            if (i == 0) {
                remoteViews.setOnClickPendingIntent(R.id.action_container, action.actionIntent);
            }
            remoteViews.setContentDescription(R.id.action_container, action.title);
            return remoteViews;
        }

        private static List<androidx.core.app.NotificationCompat.Action> getNonContextualActions(List<androidx.core.app.NotificationCompat.Action> list) {
            Object next;
            boolean contextual;
            if (list == null) {
                return 0;
            }
            ArrayList arrayList = new ArrayList();
            final Iterator iterator = list.iterator();
            while (iterator.hasNext()) {
                next = iterator.next();
                if (!(NotificationCompat.Action)next.isContextual()) {
                }
                arrayList.add(next);
            }
            return arrayList;
        }

        public static List<java.lang.CharSequence> getTextsFromContentView(Context context, Notification notification) {
            RemoteViews headsUpContentView2;
            RemoteViews headsUpContentView;
            if (!Notification.DecoratedCustomViewStyle.class.getName().equals(notification.extras.getString("android.template"))) {
                return Collections.emptyList();
            }
            if (notification.contentView == null && notification.bigContentView == null && notification.headsUpContentView == null) {
                if (notification.bigContentView == null) {
                    if (notification.headsUpContentView == null) {
                        return Collections.emptyList();
                    }
                }
            }
            headsUpContentView = notification.bigContentView != null ? notification.bigContentView : contentView != null ? notification.contentView : notification.headsUpContentView;
            final String package = headsUpContentView.getPackage();
            int i = 0;
            final Context packageContext = context.createPackageContext(package, i);
            packageContext.setTheme(applicationInfo2.theme);
            ArrayList arrayList = new ArrayList();
            NotificationCompat.DecoratedCustomViewStyle.getTextsFromViewTraversal(headsUpContentView.apply(packageContext, 0), arrayList);
            return arrayList;
        }

        private static void getTextsFromViewTraversal(View v, ArrayList<java.lang.CharSequence> arrayList2) {
            int i;
            View childAt;
            boolean text2;
            boolean text;
            int length;
            if (!v instanceof ViewGroup) {
            }
            i = 0;
            while (i < (ViewGroup)v.getChildCount()) {
                childAt = (ViewGroup)v.getChildAt(i);
                text = (TextView)childAt.getText();
                if (childAt instanceof TextView != null && text != null && text.length() > 0) {
                }
                if (childAt instanceof ViewGroup) {
                }
                i++;
                NotificationCompat.DecoratedCustomViewStyle.getTextsFromViewTraversal(childAt, arrayList2);
                text = (TextView)childAt.getText();
                if (text != null) {
                }
                if (text.length() > 0) {
                }
                arrayList2.add(text);
            }
        }

        @Override // androidx.core.app.NotificationCompat$Style
        public void apply(androidx.core.app.NotificationBuilderWithBuilderAccessor builder) {
            builder.getBuilder().setStyle(NotificationCompat.DecoratedCustomViewStyle.Api24Impl.createDecoratedCustomViewStyle());
        }

        @Override // androidx.core.app.NotificationCompat$Style
        public boolean displayCustomViewInline() {
            return 1;
        }

        @Override // androidx.core.app.NotificationCompat$Style
        protected String getClassName() {
            return "androidx.core.app.NotificationCompat$DecoratedCustomViewStyle";
        }

        @Override // androidx.core.app.NotificationCompat$Style
        public RemoteViews makeBigContentView(androidx.core.app.NotificationBuilderWithBuilderAccessor builder) {
            return null;
        }

        @Override // androidx.core.app.NotificationCompat$Style
        public RemoteViews makeContentView(androidx.core.app.NotificationBuilderWithBuilderAccessor builder) {
            return null;
        }

        @Override // androidx.core.app.NotificationCompat$Style
        public RemoteViews makeHeadsUpContentView(androidx.core.app.NotificationBuilderWithBuilderAccessor builder) {
            return null;
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface GroupAlertBehavior {
    }

    public static class InboxStyle extends androidx.core.app.NotificationCompat.Style {

        private static final String TEMPLATE_CLASS_NAME = "androidx.core.app.NotificationCompat$InboxStyle";
        private ArrayList<java.lang.CharSequence> mTexts;
        public InboxStyle() {
            super();
            ArrayList arrayList = new ArrayList();
            this.mTexts = arrayList;
        }

        public InboxStyle(androidx.core.app.NotificationCompat.Builder builder) {
            super();
            ArrayList arrayList = new ArrayList();
            this.mTexts = arrayList;
            setBuilder(builder);
        }

        @Override // androidx.core.app.NotificationCompat$Style
        public androidx.core.app.NotificationCompat.InboxStyle addLine(java.lang.CharSequence cs) {
            ArrayList mTexts;
            java.lang.CharSequence limitCharSequenceLength;
            if (cs != null) {
                this.mTexts.add(NotificationCompat.Builder.limitCharSequenceLength(cs));
            }
            return this;
        }

        @Override // androidx.core.app.NotificationCompat$Style
        public void apply(androidx.core.app.NotificationBuilderWithBuilderAccessor builder) {
            boolean mSummaryTextSet;
            Object next;
            Notification.InboxStyle inboxStyle = new Notification.InboxStyle(builder.getBuilder());
            Notification.InboxStyle style = inboxStyle.setBigContentTitle(this.mBigContentTitle);
            if (this.mSummaryTextSet != null) {
                style.setSummaryText(this.mSummaryText);
            }
            Iterator iterator = this.mTexts.iterator();
            for (CharSequence next : iterator) {
                style.addLine(next);
            }
        }

        @Override // androidx.core.app.NotificationCompat$Style
        protected void clearCompatExtraKeys(Bundle extras) {
            super.clearCompatExtraKeys(extras);
            extras.remove("android.textLines");
        }

        @Override // androidx.core.app.NotificationCompat$Style
        protected String getClassName() {
            return "androidx.core.app.NotificationCompat$InboxStyle";
        }

        @Override // androidx.core.app.NotificationCompat$Style
        protected void restoreFromCompatExtras(Bundle extras) {
            String charSequenceArray;
            boolean mTexts;
            super.restoreFromCompatExtras(extras);
            this.mTexts.clear();
            charSequenceArray = "android.textLines";
            if (extras.containsKey(charSequenceArray)) {
                Collections.addAll(this.mTexts, extras.getCharSequenceArray(charSequenceArray));
            }
        }

        @Override // androidx.core.app.NotificationCompat$Style
        public androidx.core.app.NotificationCompat.InboxStyle setBigContentTitle(java.lang.CharSequence title) {
            this.mBigContentTitle = NotificationCompat.Builder.limitCharSequenceLength(title);
            return this;
        }

        @Override // androidx.core.app.NotificationCompat$Style
        public androidx.core.app.NotificationCompat.InboxStyle setSummaryText(java.lang.CharSequence cs) {
            this.mSummaryText = NotificationCompat.Builder.limitCharSequenceLength(cs);
            this.mSummaryTextSet = true;
            return this;
        }
    }

    public static class MessagingStyle extends androidx.core.app.NotificationCompat.Style {

        public static final int MAXIMUM_RETAINED_MESSAGES = 25;
        private static final String TEMPLATE_CLASS_NAME = "androidx.core.app.NotificationCompat$MessagingStyle";
        private java.lang.CharSequence mConversationTitle;
        private final List<androidx.core.app.NotificationCompat.MessagingStyle.Message> mHistoricMessages;
        private Boolean mIsGroupConversation;
        private final List<androidx.core.app.NotificationCompat.MessagingStyle.Message> mMessages;
        private androidx.core.app.Person mUser;
        MessagingStyle() {
            super();
            ArrayList arrayList = new ArrayList();
            this.mMessages = arrayList;
            ArrayList arrayList2 = new ArrayList();
            this.mHistoricMessages = arrayList2;
        }

        public MessagingStyle(androidx.core.app.Person user) {
            super();
            ArrayList arrayList = new ArrayList();
            this.mMessages = arrayList;
            ArrayList arrayList2 = new ArrayList();
            this.mHistoricMessages = arrayList2;
            if (TextUtils.isEmpty(user.getName())) {
            } else {
                this.mUser = user;
            }
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("User's name must not be empty.");
            throw illegalArgumentException;
        }

        @Deprecated
        public MessagingStyle(java.lang.CharSequence userDisplayName) {
            super();
            ArrayList arrayList = new ArrayList();
            this.mMessages = arrayList;
            ArrayList arrayList2 = new ArrayList();
            this.mHistoricMessages = arrayList2;
            Person.Builder builder = new Person.Builder();
            this.mUser = builder.setName(userDisplayName).build();
        }

        public static androidx.core.app.NotificationCompat.MessagingStyle extractMessagingStyleFromNotification(Notification notification) {
            final androidx.core.app.NotificationCompat.Style styleFromNotification = NotificationCompat.Style.extractStyleFromNotification(notification);
            if (styleFromNotification instanceof NotificationCompat.MessagingStyle) {
                return (NotificationCompat.MessagingStyle)styleFromNotification;
            }
            return null;
        }

        private androidx.core.app.NotificationCompat.MessagingStyle.Message findLatestIncomingMessage() {
            int i;
            Object obj;
            androidx.core.app.Person person;
            size--;
            while (i >= 0) {
                obj = this.mMessages.get(i);
                i--;
            }
            if (!this.mMessages.isEmpty()) {
                return (NotificationCompat.MessagingStyle.Message)this.mMessages.get(size2--);
            }
            return null;
        }

        private boolean hasMessagesWithoutSender() {
            int i;
            Object obj;
            androidx.core.app.Person person;
            final int i3 = 1;
            size -= i3;
            while (i >= 0) {
                obj = this.mMessages.get(i);
                i--;
            }
            return 0;
        }

        private TextAppearanceSpan makeFontColorSpan(int color) {
            TextAppearanceSpan textAppearanceSpan = new TextAppearanceSpan(0, 0, 0, ColorStateList.valueOf(color), 0);
            return textAppearanceSpan;
        }

        private java.lang.CharSequence makeMessageLine(androidx.core.app.NotificationCompat.MessagingStyle.Message message) {
            int color;
            Object replyName;
            Object text;
            boolean empty;
            androidx.core.app.Person mUser;
            final BidiFormatter instance = BidiFormatter.getInstance();
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            final int i = 1;
            color = i != 0 ? -16777216 : -1;
            if (message.getPerson() == null) {
                replyName = text;
            } else {
                replyName = message.getPerson().getName();
            }
            if (TextUtils.isEmpty(replyName)) {
                replyName = this.mUser.getName();
                if (i != 0 && this.mBuilder.getColor() != 0) {
                    if (this.mBuilder.getColor() != 0) {
                        empty = this.mBuilder.getColor();
                    } else {
                        empty = color;
                    }
                } else {
                }
                color = empty;
            }
            java.lang.CharSequence unicodeWrap = instance.unicodeWrap(replyName);
            spannableStringBuilder.append(unicodeWrap);
            spannableStringBuilder.setSpan(makeFontColorSpan(color), length -= length2, spannableStringBuilder.length(), 33);
            if (message.getText() == null) {
            } else {
                text = message.getText();
            }
            spannableStringBuilder.append("  ").append(instance.unicodeWrap(text));
            return spannableStringBuilder;
        }

        @Override // androidx.core.app.NotificationCompat$Style
        public void addCompatExtras(Bundle extras) {
            java.lang.CharSequence mConversationTitle;
            boolean bundleArrayForMessages2;
            boolean bundleArrayForMessages;
            Boolean mIsGroupConversation;
            java.lang.CharSequence mConversationTitle2;
            super.addCompatExtras(extras);
            extras.putCharSequence("android.selfDisplayName", this.mUser.getName());
            extras.putBundle("android.messagingStyleUser", this.mUser.toBundle());
            extras.putCharSequence("android.hiddenConversationTitle", this.mConversationTitle);
            if (this.mConversationTitle != null && this.mIsGroupConversation.booleanValue()) {
                if (this.mIsGroupConversation.booleanValue()) {
                    extras.putCharSequence("android.conversationTitle", this.mConversationTitle);
                }
            }
            if (!this.mMessages.isEmpty()) {
                extras.putParcelableArray("android.messages", NotificationCompat.MessagingStyle.Message.getBundleArrayForMessages(this.mMessages));
            }
            if (!this.mHistoricMessages.isEmpty()) {
                extras.putParcelableArray("android.messages.historic", NotificationCompat.MessagingStyle.Message.getBundleArrayForMessages(this.mHistoricMessages));
            }
            if (this.mIsGroupConversation != null) {
                extras.putBoolean("android.isGroupConversation", this.mIsGroupConversation.booleanValue());
            }
        }

        @Override // androidx.core.app.NotificationCompat$Style
        public androidx.core.app.NotificationCompat.MessagingStyle addHistoricMessage(androidx.core.app.NotificationCompat.MessagingStyle.Message message) {
            int mHistoricMessages;
            int i;
            this.mHistoricMessages.add(message);
            if (message != null && this.mHistoricMessages.size() > 25) {
                this.mHistoricMessages.add(message);
                if (this.mHistoricMessages.size() > 25) {
                    this.mHistoricMessages.remove(0);
                }
            }
            return this;
        }

        @Override // androidx.core.app.NotificationCompat$Style
        public androidx.core.app.NotificationCompat.MessagingStyle addMessage(androidx.core.app.NotificationCompat.MessagingStyle.Message message) {
            int mMessages;
            int i;
            this.mMessages.add(message);
            if (message != null && this.mMessages.size() > 25) {
                this.mMessages.add(message);
                if (this.mMessages.size() > 25) {
                    this.mMessages.remove(0);
                }
            }
            return this;
        }

        @Override // androidx.core.app.NotificationCompat$Style
        public androidx.core.app.NotificationCompat.MessagingStyle addMessage(java.lang.CharSequence text, long timestamp, androidx.core.app.Person person) {
            NotificationCompat.MessagingStyle.Message message = new NotificationCompat.MessagingStyle.Message(text, timestamp, person, obj5);
            addMessage(message);
            return this;
        }

        @Deprecated
        public androidx.core.app.NotificationCompat.MessagingStyle addMessage(java.lang.CharSequence text, long timestamp, java.lang.CharSequence sender) {
            int mMessages;
            int i;
            Person.Builder builder = new Person.Builder();
            NotificationCompat.MessagingStyle.Message message = new NotificationCompat.MessagingStyle.Message(text, timestamp, sender, builder.setName(obj7).build());
            this.mMessages.add(message);
            if (this.mMessages.size() > 25) {
                this.mMessages.remove(0);
            }
            return this;
        }

        @Override // androidx.core.app.NotificationCompat$Style
        public void apply(androidx.core.app.NotificationBuilderWithBuilderAccessor builder) {
            Object next;
            boolean next2;
            android.app.Notification.MessagingStyle messagingStyle;
            android.app.Notification.MessagingStyle.Message androidMessage;
            setGroupConversation(isGroupConversation());
            android.app.Notification.MessagingStyle messagingStyle2 = NotificationCompat.MessagingStyle.Api28Impl.createMessagingStyle(this.mUser.toAndroidPerson());
            Iterator iterator = this.mMessages.iterator();
            for (NotificationCompat.MessagingStyle.Message next : iterator) {
                NotificationCompat.MessagingStyle.Api24Impl.addMessage((Notification.MessagingStyle)messagingStyle2, next.toAndroidMessage());
            }
            Iterator iterator2 = this.mHistoricMessages.iterator();
            for (NotificationCompat.MessagingStyle.Message next2 : iterator2) {
                NotificationCompat.MessagingStyle.Api26Impl.addHistoricMessage((Notification.MessagingStyle)messagingStyle2, next2.toAndroidMessage());
            }
            boolean booleanValue = this.mIsGroupConversation.booleanValue();
            NotificationCompat.MessagingStyle.Api24Impl.setConversationTitle((Notification.MessagingStyle)messagingStyle2, this.mConversationTitle);
            NotificationCompat.MessagingStyle.Api28Impl.setGroupConversation((Notification.MessagingStyle)messagingStyle2, this.mIsGroupConversation.booleanValue());
            (Notification.Style)messagingStyle2.setBuilder(builder.getBuilder());
        }

        @Override // androidx.core.app.NotificationCompat$Style
        protected void clearCompatExtraKeys(Bundle extras) {
            super.clearCompatExtraKeys(extras);
            extras.remove("android.messagingStyleUser");
            extras.remove("android.selfDisplayName");
            extras.remove("android.conversationTitle");
            extras.remove("android.hiddenConversationTitle");
            extras.remove("android.messages");
            extras.remove("android.messages.historic");
            extras.remove("android.isGroupConversation");
        }

        @Override // androidx.core.app.NotificationCompat$Style
        protected String getClassName() {
            return "androidx.core.app.NotificationCompat$MessagingStyle";
        }

        @Override // androidx.core.app.NotificationCompat$Style
        public java.lang.CharSequence getConversationTitle() {
            return this.mConversationTitle;
        }

        public List<androidx.core.app.NotificationCompat.MessagingStyle.Message> getHistoricMessages() {
            return this.mHistoricMessages;
        }

        public List<androidx.core.app.NotificationCompat.MessagingStyle.Message> getMessages() {
            return this.mMessages;
        }

        @Override // androidx.core.app.NotificationCompat$Style
        public androidx.core.app.Person getUser() {
            return this.mUser;
        }

        @Deprecated
        public java.lang.CharSequence getUserDisplayName() {
            return this.mUser.getName();
        }

        @Override // androidx.core.app.NotificationCompat$Style
        public boolean isGroupConversation() {
            androidx.core.app.NotificationCompat.Builder mIsGroupConversation2;
            Boolean mIsGroupConversation;
            int booleanValue;
            int i;
            booleanValue = 0;
            if (this.mBuilder != null && applicationInfo.targetSdkVersion < 28 && this.mIsGroupConversation == null && this.mConversationTitle != null) {
                if (applicationInfo.targetSdkVersion < 28) {
                    if (this.mIsGroupConversation == null) {
                        if (this.mConversationTitle != null) {
                            booleanValue = 1;
                        }
                        return booleanValue;
                    }
                }
            }
            if (this.mIsGroupConversation != null) {
                booleanValue = this.mIsGroupConversation.booleanValue();
            }
            return booleanValue;
        }

        @Override // androidx.core.app.NotificationCompat$Style
        protected void restoreFromCompatExtras(Bundle extras) {
            androidx.core.app.Person bundle;
            java.lang.CharSequence mConversationTitle;
            String mMessages;
            List messagesFromBundleArray2;
            Object valueOf;
            List messagesFromBundleArray;
            super.restoreFromCompatExtras(extras);
            this.mMessages.clear();
            String str = "android.messagingStyleUser";
            if (extras.containsKey(str)) {
                this.mUser = Person.fromBundle(extras.getBundle(str));
            } else {
                Person.Builder builder = new Person.Builder();
                this.mUser = builder.setName(extras.getString("android.selfDisplayName")).build();
            }
            this.mConversationTitle = extras.getCharSequence("android.conversationTitle");
            if (this.mConversationTitle == null) {
                this.mConversationTitle = extras.getCharSequence("android.hiddenConversationTitle");
            }
            Parcelable[] parcelableArray = extras.getParcelableArray("android.messages");
            if (parcelableArray != null) {
                this.mMessages.addAll(NotificationCompat.MessagingStyle.Message.getMessagesFromBundleArray(parcelableArray));
            }
            Parcelable[] parcelableArray2 = extras.getParcelableArray("android.messages.historic");
            if (parcelableArray2 != null) {
                this.mHistoricMessages.addAll(NotificationCompat.MessagingStyle.Message.getMessagesFromBundleArray(parcelableArray2));
            }
            valueOf = "android.isGroupConversation";
            if (extras.containsKey(valueOf)) {
                this.mIsGroupConversation = Boolean.valueOf(extras.getBoolean(valueOf));
            }
        }

        @Override // androidx.core.app.NotificationCompat$Style
        public androidx.core.app.NotificationCompat.MessagingStyle setConversationTitle(java.lang.CharSequence conversationTitle) {
            this.mConversationTitle = conversationTitle;
            return this;
        }

        @Override // androidx.core.app.NotificationCompat$Style
        public androidx.core.app.NotificationCompat.MessagingStyle setGroupConversation(boolean isGroupConversation) {
            this.mIsGroupConversation = Boolean.valueOf(isGroupConversation);
            return this;
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface NotificationVisibility {
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface ServiceNotificationBehavior {
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface StreamType {
    }

    public static final class TvExtender implements androidx.core.app.NotificationCompat.Extender {

        static final String EXTRA_CHANNEL_ID = "channel_id";
        static final String EXTRA_CONTENT_INTENT = "content_intent";
        static final String EXTRA_DELETE_INTENT = "delete_intent";
        private static final String EXTRA_FLAGS = "flags";
        static final String EXTRA_SUPPRESS_SHOW_OVER_APPS = "suppressShowOverApps";
        static final String EXTRA_TV_EXTENDER = "android.tv.EXTENSIONS";
        private static final int FLAG_AVAILABLE_ON_TV = 1;
        private static final String TAG = "TvExtender";
        private String mChannelId;
        private PendingIntent mContentIntent;
        private PendingIntent mDeleteIntent;
        private int mFlags;
        private boolean mSuppressShowOverApps;
        public TvExtender() {
            super();
            this.mFlags = 1;
        }

        public TvExtender(Notification notif) {
            int bundle;
            String parcelable;
            super();
            if (notif.extras == null) {
                bundle = 0;
            } else {
                bundle = notif.extras.getBundle("android.tv.EXTENSIONS");
            }
            if (bundle != null) {
                this.mFlags = bundle.getInt("flags");
                this.mChannelId = bundle.getString("channel_id");
                this.mSuppressShowOverApps = bundle.getBoolean("suppressShowOverApps");
                this.mContentIntent = (PendingIntent)bundle.getParcelable("content_intent");
                this.mDeleteIntent = (PendingIntent)bundle.getParcelable("delete_intent");
            }
        }

        @Override // androidx.core.app.NotificationCompat$Extender
        public androidx.core.app.NotificationCompat.Builder extend(androidx.core.app.NotificationCompat.Builder builder) {
            Object mContentIntent;
            Object mDeleteIntent;
            boolean mSuppressShowOverApps;
            Bundle bundle = new Bundle();
            bundle.putInt("flags", this.mFlags);
            bundle.putString("channel_id", this.mChannelId);
            bundle.putBoolean("suppressShowOverApps", this.mSuppressShowOverApps);
            if (this.mContentIntent != null) {
                bundle.putParcelable("content_intent", this.mContentIntent);
            }
            if (this.mDeleteIntent != null) {
                bundle.putParcelable("delete_intent", this.mDeleteIntent);
            }
            builder.getExtras().putBundle("android.tv.EXTENSIONS", bundle);
            return builder;
        }

        @Override // androidx.core.app.NotificationCompat$Extender
        public String getChannelId() {
            return this.mChannelId;
        }

        @Override // androidx.core.app.NotificationCompat$Extender
        public PendingIntent getContentIntent() {
            return this.mContentIntent;
        }

        @Override // androidx.core.app.NotificationCompat$Extender
        public PendingIntent getDeleteIntent() {
            return this.mDeleteIntent;
        }

        @Override // androidx.core.app.NotificationCompat$Extender
        public boolean isAvailableOnTv() {
            int i;
            if (mFlags &= i != 0) {
            } else {
                i = 0;
            }
            return i;
        }

        @Override // androidx.core.app.NotificationCompat$Extender
        public boolean isSuppressShowOverApps() {
            return this.mSuppressShowOverApps;
        }

        @Override // androidx.core.app.NotificationCompat$Extender
        public androidx.core.app.NotificationCompat.TvExtender setChannelId(String channelId) {
            this.mChannelId = channelId;
            return this;
        }

        @Override // androidx.core.app.NotificationCompat$Extender
        public androidx.core.app.NotificationCompat.TvExtender setContentIntent(PendingIntent intent) {
            this.mContentIntent = intent;
            return this;
        }

        @Override // androidx.core.app.NotificationCompat$Extender
        public androidx.core.app.NotificationCompat.TvExtender setDeleteIntent(PendingIntent intent) {
            this.mDeleteIntent = intent;
            return this;
        }

        @Override // androidx.core.app.NotificationCompat$Extender
        public androidx.core.app.NotificationCompat.TvExtender setSuppressShowOverApps(boolean suppress) {
            this.mSuppressShowOverApps = suppress;
            return this;
        }
    }

    public static final class WearableExtender implements androidx.core.app.NotificationCompat.Extender {

        private static final int DEFAULT_CONTENT_ICON_GRAVITY = 8388613;
        private static final int DEFAULT_FLAGS = 1;
        private static final int DEFAULT_GRAVITY = 80;
        private static final String EXTRA_WEARABLE_EXTENSIONS = "android.wearable.EXTENSIONS";
        private static final int FLAG_BIG_PICTURE_AMBIENT = 32;
        private static final int FLAG_CONTENT_INTENT_AVAILABLE_OFFLINE = 1;
        private static final int FLAG_HINT_AVOID_BACKGROUND_CLIPPING = 16;
        private static final int FLAG_HINT_CONTENT_INTENT_LAUNCHES_ACTIVITY = 64;
        private static final int FLAG_HINT_HIDE_ICON = 2;
        private static final int FLAG_HINT_SHOW_BACKGROUND_ONLY = 4;
        private static final int FLAG_START_SCROLL_BOTTOM = 8;
        private static final String KEY_ACTIONS = "actions";
        private static final String KEY_BACKGROUND = "background";
        private static final String KEY_BRIDGE_TAG = "bridgeTag";
        private static final String KEY_CONTENT_ACTION_INDEX = "contentActionIndex";
        private static final String KEY_CONTENT_ICON = "contentIcon";
        private static final String KEY_CONTENT_ICON_GRAVITY = "contentIconGravity";
        private static final String KEY_CUSTOM_CONTENT_HEIGHT = "customContentHeight";
        private static final String KEY_CUSTOM_SIZE_PRESET = "customSizePreset";
        private static final String KEY_DISMISSAL_ID = "dismissalId";
        private static final String KEY_DISPLAY_INTENT = "displayIntent";
        private static final String KEY_FLAGS = "flags";
        private static final String KEY_GRAVITY = "gravity";
        private static final String KEY_HINT_SCREEN_TIMEOUT = "hintScreenTimeout";
        private static final String KEY_PAGES = "pages";
        @Deprecated
        public static final int SCREEN_TIMEOUT_LONG = -1;
        @Deprecated
        public static final int SCREEN_TIMEOUT_SHORT = 0;
        @Deprecated
        public static final int SIZE_DEFAULT = 0;
        @Deprecated
        public static final int SIZE_FULL_SCREEN = 5;
        @Deprecated
        public static final int SIZE_LARGE = 4;
        @Deprecated
        public static final int SIZE_MEDIUM = 3;
        @Deprecated
        public static final int SIZE_SMALL = 2;
        @Deprecated
        public static final int SIZE_XSMALL = 1;
        public static final int UNSET_ACTION_INDEX = -1;
        private ArrayList<androidx.core.app.NotificationCompat.Action> mActions;
        private Bitmap mBackground;
        private String mBridgeTag;
        private int mContentActionIndex = -1;
        private int mContentIcon;
        private int mContentIconGravity = 8388613;
        private int mCustomContentHeight;
        private int mCustomSizePreset = 0;
        private String mDismissalId;
        private PendingIntent mDisplayIntent;
        private int mFlags = 1;
        private int mGravity = 80;
        private int mHintScreenTimeout;
        private ArrayList<Notification> mPages;
        public WearableExtender() {
            super();
            ArrayList arrayList = new ArrayList();
            this.mActions = arrayList;
            int i = 1;
            ArrayList arrayList2 = new ArrayList();
            this.mPages = arrayList2;
            int i2 = 8388613;
            int i3 = -1;
            int i4 = 0;
            int i5 = 80;
        }

        public WearableExtender(Notification notification) {
            int notificationArrayFromBundle;
            int string;
            int bundle;
            ArrayList parcelableArrayList;
            String str;
            Object actions;
            ArrayList i2;
            int i;
            int actionCompatFromAction;
            super();
            ArrayList arrayList = new ArrayList();
            this.mActions = arrayList;
            ArrayList arrayList2 = new ArrayList();
            this.mPages = arrayList2;
            final Bundle extras = NotificationCompat.getExtras(notification);
            if (extras != null) {
                bundle = extras.getBundle("android.wearable.EXTENSIONS");
            } else {
                bundle = 0;
            }
            parcelableArrayList = bundle.getParcelableArrayList("actions");
            if (bundle != null && parcelableArrayList != null) {
                parcelableArrayList = bundle.getParcelableArrayList("actions");
                if (parcelableArrayList != null) {
                    str = new NotificationCompat.Action[parcelableArrayList.size()];
                    i = 0;
                    while (i < str.length) {
                        str[i] = NotificationCompat.WearableExtender.Api20Impl.getActionCompatFromAction(parcelableArrayList, i);
                        i++;
                    }
                    Collections.addAll(this.mActions, str);
                }
                this.mFlags = bundle.getInt("flags", 1);
                this.mDisplayIntent = (PendingIntent)bundle.getParcelable("displayIntent");
                notificationArrayFromBundle = NotificationCompat.getNotificationArrayFromBundle(bundle, "pages");
                if (notificationArrayFromBundle != null) {
                    Collections.addAll(this.mPages, notificationArrayFromBundle);
                }
                this.mBackground = (Bitmap)bundle.getParcelable("background");
                this.mContentIcon = bundle.getInt("contentIcon");
                this.mContentIconGravity = bundle.getInt("contentIconGravity", 8388613);
                this.mContentActionIndex = bundle.getInt("contentActionIndex", -1);
                this.mCustomSizePreset = bundle.getInt("customSizePreset", 0);
                this.mCustomContentHeight = bundle.getInt("customContentHeight");
                this.mGravity = bundle.getInt("gravity", 80);
                this.mHintScreenTimeout = bundle.getInt("hintScreenTimeout");
                this.mDismissalId = bundle.getString("dismissalId");
                this.mBridgeTag = bundle.getString("bridgeTag");
            }
        }

        private static Notification.Action getActionFromActionCompat(androidx.core.app.NotificationCompat.Action actionCompat) {
            Icon icon;
            Bundle actionExtras;
            Object extras;
            int authenticationRequired;
            int compat;
            int length;
            int i;
            RemoteInput remoteInput;
            IconCompat iconCompat = actionCompat.getIconCompat();
            if (iconCompat == null) {
                icon = 0;
            } else {
                icon = iconCompat.toIcon();
            }
            android.app.Notification.Action.Builder iconCompat2 = NotificationCompat.WearableExtender.Api23Impl.createBuilder(icon, actionCompat.getTitle(), actionCompat.getActionIntent());
            if (actionCompat.getExtras() != null) {
                actionExtras = new Bundle(actionCompat.getExtras());
            } else {
                actionExtras = new Bundle();
            }
            actionExtras.putBoolean("android.support.allowGeneratedReplies", actionCompat.getAllowGeneratedReplies());
            NotificationCompat.WearableExtender.Api24Impl.setAllowGeneratedReplies(iconCompat2, actionCompat.getAllowGeneratedReplies());
            if (Build.VERSION.SDK_INT >= 31) {
                NotificationCompat.WearableExtender.Api31Impl.setAuthenticationRequired(iconCompat2, actionCompat.isAuthenticationRequired());
            }
            NotificationCompat.WearableExtender.Api20Impl.addExtras(iconCompat2, actionExtras);
            androidx.core.app.RemoteInput[] remoteInputs = actionCompat.getRemoteInputs();
            if (remoteInputs != null) {
                compat = RemoteInput.fromCompat(remoteInputs);
                i = 0;
                while (i < compat.length) {
                    NotificationCompat.WearableExtender.Api20Impl.addRemoteInput(iconCompat2, compat[i]);
                    i++;
                }
            }
            return NotificationCompat.WearableExtender.Api20Impl.build(iconCompat2);
        }

        private void setFlag(int mask, boolean value) {
            int i;
            int i2;
            if (value != null) {
                this.mFlags = mFlags |= mask;
            } else {
                this.mFlags = mFlags2 &= i2;
            }
        }

        @Override // androidx.core.app.NotificationCompat$Extender
        public androidx.core.app.NotificationCompat.WearableExtender addAction(androidx.core.app.NotificationCompat.Action action) {
            this.mActions.add(action);
            return this;
        }

        public androidx.core.app.NotificationCompat.WearableExtender addActions(List<androidx.core.app.NotificationCompat.Action> list) {
            this.mActions.addAll(list);
            return this;
        }

        @Deprecated
        public androidx.core.app.NotificationCompat.WearableExtender addPage(Notification page) {
            this.mPages.add(page);
            return this;
        }

        @Deprecated
        public androidx.core.app.NotificationCompat.WearableExtender addPages(List<Notification> list) {
            this.mPages.addAll(list);
            return this;
        }

        @Override // androidx.core.app.NotificationCompat$Extender
        public androidx.core.app.NotificationCompat.WearableExtender clearActions() {
            this.mActions.clear();
            return this;
        }

        @Deprecated
        public androidx.core.app.NotificationCompat.WearableExtender clearPages() {
            this.mPages.clear();
            return this;
        }

        @Override // androidx.core.app.NotificationCompat$Extender
        public androidx.core.app.NotificationCompat.WearableExtender clone() {
            NotificationCompat.WearableExtender wearableExtender = new NotificationCompat.WearableExtender();
            ArrayList arrayList = new ArrayList(this.mActions);
            wearableExtender.mActions = arrayList;
            wearableExtender.mFlags = this.mFlags;
            wearableExtender.mDisplayIntent = this.mDisplayIntent;
            ArrayList arrayList2 = new ArrayList(this.mPages);
            wearableExtender.mPages = arrayList2;
            wearableExtender.mBackground = this.mBackground;
            wearableExtender.mContentIcon = this.mContentIcon;
            wearableExtender.mContentIconGravity = this.mContentIconGravity;
            wearableExtender.mContentActionIndex = this.mContentActionIndex;
            wearableExtender.mCustomSizePreset = this.mCustomSizePreset;
            wearableExtender.mCustomContentHeight = this.mCustomContentHeight;
            wearableExtender.mGravity = this.mGravity;
            wearableExtender.mHintScreenTimeout = this.mHintScreenTimeout;
            wearableExtender.mDismissalId = this.mDismissalId;
            wearableExtender.mBridgeTag = this.mBridgeTag;
            return wearableExtender;
        }

        public Object clone() throws java.lang.CloneNotSupportedException {
            return clone();
        }

        @Override // androidx.core.app.NotificationCompat$Extender
        public androidx.core.app.NotificationCompat.Builder extend(androidx.core.app.NotificationCompat.Builder builder) {
            boolean arrayList;
            int parcelables;
            Object mDisplayIntent2;
            boolean empty;
            Object mBackground;
            int mContentIcon;
            int mContentIconGravity2;
            int mContentActionIndex;
            int mCustomSizePreset;
            int mCustomContentHeight2;
            int mGravity;
            int mHintScreenTimeout;
            String mDismissalId;
            String mBridgeTag;
            String str;
            int mDisplayIntent;
            int mContentIconGravity;
            int mCustomContentHeight;
            int mHintScreenTimeout2;
            boolean next;
            Notification.Action actionFromActionCompat;
            Bundle bundle = new Bundle();
            if (!this.mActions.isEmpty()) {
                arrayList = new ArrayList(this.mActions.size());
                Iterator iterator = this.mActions.iterator();
                for (NotificationCompat.Action next : iterator) {
                    arrayList.add(NotificationCompat.WearableExtender.getActionFromActionCompat(next));
                }
                bundle.putParcelableArrayList("actions", arrayList);
            }
            if (this.mFlags != 1) {
                bundle.putInt("flags", this.mFlags);
            }
            if (this.mDisplayIntent != null) {
                bundle.putParcelable("displayIntent", this.mDisplayIntent);
            }
            if (!this.mPages.isEmpty()) {
                bundle.putParcelableArray("pages", (Parcelable[])this.mPages.toArray(new Notification[this.mPages.size()]));
            }
            if (this.mBackground != null) {
                bundle.putParcelable("background", this.mBackground);
            }
            if (this.mContentIcon != 0) {
                bundle.putInt("contentIcon", this.mContentIcon);
            }
            if (this.mContentIconGravity != 8388613) {
                bundle.putInt("contentIconGravity", this.mContentIconGravity);
            }
            if (this.mContentActionIndex != -1) {
                bundle.putInt("contentActionIndex", this.mContentActionIndex);
            }
            if (this.mCustomSizePreset != null) {
                bundle.putInt("customSizePreset", this.mCustomSizePreset);
            }
            if (this.mCustomContentHeight != 0) {
                bundle.putInt("customContentHeight", this.mCustomContentHeight);
            }
            if (this.mGravity != 80) {
                bundle.putInt("gravity", this.mGravity);
            }
            if (this.mHintScreenTimeout != 0) {
                bundle.putInt("hintScreenTimeout", this.mHintScreenTimeout);
            }
            if (this.mDismissalId != null) {
                bundle.putString("dismissalId", this.mDismissalId);
            }
            if (this.mBridgeTag != null) {
                bundle.putString("bridgeTag", this.mBridgeTag);
            }
            builder.getExtras().putBundle("android.wearable.EXTENSIONS", bundle);
            return builder;
        }

        public List<androidx.core.app.NotificationCompat.Action> getActions() {
            return this.mActions;
        }

        @Deprecated
        public Bitmap getBackground() {
            return this.mBackground;
        }

        @Override // androidx.core.app.NotificationCompat$Extender
        public String getBridgeTag() {
            return this.mBridgeTag;
        }

        @Override // androidx.core.app.NotificationCompat$Extender
        public int getContentAction() {
            return this.mContentActionIndex;
        }

        @Deprecated
        public int getContentIcon() {
            return this.mContentIcon;
        }

        @Deprecated
        public int getContentIconGravity() {
            return this.mContentIconGravity;
        }

        @Override // androidx.core.app.NotificationCompat$Extender
        public boolean getContentIntentAvailableOffline() {
            int i;
            if (mFlags &= i != 0) {
            } else {
                i = 0;
            }
            return i;
        }

        @Deprecated
        public int getCustomContentHeight() {
            return this.mCustomContentHeight;
        }

        @Deprecated
        public int getCustomSizePreset() {
            return this.mCustomSizePreset;
        }

        @Override // androidx.core.app.NotificationCompat$Extender
        public String getDismissalId() {
            return this.mDismissalId;
        }

        @Deprecated
        public PendingIntent getDisplayIntent() {
            return this.mDisplayIntent;
        }

        @Deprecated
        public int getGravity() {
            return this.mGravity;
        }

        @Deprecated
        public boolean getHintAmbientBigPicture() {
            int i;
            i = mFlags &= 32 != 0 ? 1 : 0;
            return i;
        }

        @Deprecated
        public boolean getHintAvoidBackgroundClipping() {
            int i;
            i = mFlags &= 16 != 0 ? 1 : 0;
            return i;
        }

        @Override // androidx.core.app.NotificationCompat$Extender
        public boolean getHintContentIntentLaunchesActivity() {
            int i;
            i = mFlags &= 64 != 0 ? 1 : 0;
            return i;
        }

        @Deprecated
        public boolean getHintHideIcon() {
            int i;
            i = mFlags &= 2 != 0 ? 1 : 0;
            return i;
        }

        @Deprecated
        public int getHintScreenTimeout() {
            return this.mHintScreenTimeout;
        }

        @Deprecated
        public boolean getHintShowBackgroundOnly() {
            int i;
            i = mFlags &= 4 != 0 ? 1 : 0;
            return i;
        }

        @Deprecated
        public List<Notification> getPages() {
            return this.mPages;
        }

        @Override // androidx.core.app.NotificationCompat$Extender
        public boolean getStartScrollBottom() {
            int i;
            i = mFlags &= 8 != 0 ? 1 : 0;
            return i;
        }

        @Deprecated
        public androidx.core.app.NotificationCompat.WearableExtender setBackground(Bitmap background) {
            this.mBackground = background;
            return this;
        }

        @Override // androidx.core.app.NotificationCompat$Extender
        public androidx.core.app.NotificationCompat.WearableExtender setBridgeTag(String bridgeTag) {
            this.mBridgeTag = bridgeTag;
            return this;
        }

        @Override // androidx.core.app.NotificationCompat$Extender
        public androidx.core.app.NotificationCompat.WearableExtender setContentAction(int actionIndex) {
            this.mContentActionIndex = actionIndex;
            return this;
        }

        @Deprecated
        public androidx.core.app.NotificationCompat.WearableExtender setContentIcon(int icon) {
            this.mContentIcon = icon;
            return this;
        }

        @Deprecated
        public androidx.core.app.NotificationCompat.WearableExtender setContentIconGravity(int contentIconGravity) {
            this.mContentIconGravity = contentIconGravity;
            return this;
        }

        @Override // androidx.core.app.NotificationCompat$Extender
        public androidx.core.app.NotificationCompat.WearableExtender setContentIntentAvailableOffline(boolean contentIntentAvailableOffline) {
            setFlag(1, contentIntentAvailableOffline);
            return this;
        }

        @Deprecated
        public androidx.core.app.NotificationCompat.WearableExtender setCustomContentHeight(int height) {
            this.mCustomContentHeight = height;
            return this;
        }

        @Deprecated
        public androidx.core.app.NotificationCompat.WearableExtender setCustomSizePreset(int sizePreset) {
            this.mCustomSizePreset = sizePreset;
            return this;
        }

        @Override // androidx.core.app.NotificationCompat$Extender
        public androidx.core.app.NotificationCompat.WearableExtender setDismissalId(String dismissalId) {
            this.mDismissalId = dismissalId;
            return this;
        }

        @Deprecated
        public androidx.core.app.NotificationCompat.WearableExtender setDisplayIntent(PendingIntent intent) {
            this.mDisplayIntent = intent;
            return this;
        }

        @Deprecated
        public androidx.core.app.NotificationCompat.WearableExtender setGravity(int gravity) {
            this.mGravity = gravity;
            return this;
        }

        @Deprecated
        public androidx.core.app.NotificationCompat.WearableExtender setHintAmbientBigPicture(boolean hintAmbientBigPicture) {
            setFlag(32, hintAmbientBigPicture);
            return this;
        }

        @Deprecated
        public androidx.core.app.NotificationCompat.WearableExtender setHintAvoidBackgroundClipping(boolean hintAvoidBackgroundClipping) {
            setFlag(16, hintAvoidBackgroundClipping);
            return this;
        }

        @Override // androidx.core.app.NotificationCompat$Extender
        public androidx.core.app.NotificationCompat.WearableExtender setHintContentIntentLaunchesActivity(boolean hintContentIntentLaunchesActivity) {
            setFlag(64, hintContentIntentLaunchesActivity);
            return this;
        }

        @Deprecated
        public androidx.core.app.NotificationCompat.WearableExtender setHintHideIcon(boolean hintHideIcon) {
            setFlag(2, hintHideIcon);
            return this;
        }

        @Deprecated
        public androidx.core.app.NotificationCompat.WearableExtender setHintScreenTimeout(int timeout) {
            this.mHintScreenTimeout = timeout;
            return this;
        }

        @Deprecated
        public androidx.core.app.NotificationCompat.WearableExtender setHintShowBackgroundOnly(boolean hintShowBackgroundOnly) {
            setFlag(4, hintShowBackgroundOnly);
            return this;
        }

        @Override // androidx.core.app.NotificationCompat$Extender
        public androidx.core.app.NotificationCompat.WearableExtender setStartScrollBottom(boolean startScrollBottom) {
            setFlag(8, startScrollBottom);
            return this;
        }
    }
    public static androidx.core.app.NotificationCompat.Action getAction(Notification notification, int actionIndex) {
        return NotificationCompat.getActionCompatFromAction(notification.actions[actionIndex]);
    }

    static androidx.core.app.NotificationCompat.Action getActionCompatFromAction(Notification.Action action) {
        int arr;
        boolean allowGeneratedReplies;
        Icon icon;
        int fromIconOrNullIfZeroResId;
        int i2;
        int authenticationRequired;
        int length;
        androidx.core.app.RemoteInput remoteInput;
        String resultKey;
        java.lang.CharSequence label;
        java.lang.CharSequence[] choices;
        int i3;
        boolean allowFreeFormInput;
        int editChoicesBeforeSending;
        Bundle extras;
        int i4;
        int i;
        final RemoteInput[] remoteInputs = NotificationCompat.Api20Impl.getRemoteInputs(action);
        if (remoteInputs == null) {
            i3 = arr;
        } else {
            arr = new RemoteInput[remoteInputs.length];
            i2 = 0;
            for (Object length : obj0) {
                remoteInput = new RemoteInput(NotificationCompat.Api20Impl.getResultKey(length), NotificationCompat.Api20Impl.getLabel(length), NotificationCompat.Api20Impl.getChoices(length), NotificationCompat.Api20Impl.getAllowFreeFormInput(length), NotificationCompat.Api29Impl.getEditChoicesBeforeSending(length), NotificationCompat.Api20Impl.getExtras(length), 0);
                arr[i2] = remoteInput;
            }
            i3 = arr;
        }
        int i5 = 1;
        if (!NotificationCompat.Api20Impl.getExtras(action).getBoolean("android.support.allowGeneratedReplies")) {
            if (NotificationCompat.Api24Impl.getAllowGeneratedReplies(action)) {
                i4 = i5;
            } else {
                i4 = authenticationRequired;
            }
        } else {
        }
        final boolean boolean = NotificationCompat.Api20Impl.getExtras(action).getBoolean("android.support.action.showsUserInterface", i5);
        int semanticAction = NotificationCompat.Api28Impl.getSemanticAction(action);
        final boolean contextual = NotificationCompat.Api29Impl.isContextual(action);
        if (Build.VERSION.SDK_INT >= 31) {
            authenticationRequired = NotificationCompat.Api31Impl.isAuthenticationRequired(action);
        }
        final int i10 = authenticationRequired;
        if (NotificationCompat.Api23Impl.getIcon(action) == null && action.icon != 0) {
            if (action.icon != 0) {
                NotificationCompat.Action action2 = new NotificationCompat.Action(action.icon, action.title, action.actionIntent, NotificationCompat.Api20Impl.getExtras(action), i3, 0, i4, semanticAction, boolean, contextual, i10);
                return action2;
            }
        }
        if (NotificationCompat.Api23Impl.getIcon(action) == null) {
            fromIconOrNullIfZeroResId = 0;
        } else {
            fromIconOrNullIfZeroResId = IconCompat.createFromIconOrNullIfZeroResId(NotificationCompat.Api23Impl.getIcon(action));
        }
        NotificationCompat.Action action3 = new NotificationCompat.Action(fromIconOrNullIfZeroResId, action.title, action.actionIntent, NotificationCompat.Api20Impl.getExtras(action), i3, 0, i4, semanticAction, boolean, contextual, i10);
        return action3;
    }

    public static int getActionCount(Notification notification) {
        int length;
        length = notification.actions != null ? actions2.length : 0;
        return length;
    }

    public static boolean getAllowSystemGeneratedContextualActions(Notification notification) {
        return NotificationCompat.Api29Impl.getAllowSystemGeneratedContextualActions(notification);
    }

    public static boolean getAutoCancel(Notification notification) {
        int i;
        i = flags &= 16 != 0 ? 1 : 0;
        return i;
    }

    public static int getBadgeIconType(Notification notification) {
        return NotificationCompat.Api26Impl.getBadgeIconType(notification);
    }

    public static androidx.core.app.NotificationCompat.BubbleMetadata getBubbleMetadata(Notification notification) {
        return NotificationCompat.BubbleMetadata.fromPlatform(NotificationCompat.Api29Impl.getBubbleMetadata(notification));
    }

    public static String getCategory(Notification notification) {
        return notification.category;
    }

    public static String getChannelId(Notification notification) {
        return NotificationCompat.Api26Impl.getChannelId(notification);
    }

    public static int getColor(Notification notification) {
        return notification.color;
    }

    public static java.lang.CharSequence getContentInfo(Notification notification) {
        return notification.extras.getCharSequence("android.infoText");
    }

    public static java.lang.CharSequence getContentText(Notification notification) {
        return notification.extras.getCharSequence("android.text");
    }

    public static java.lang.CharSequence getContentTitle(Notification notification) {
        return notification.extras.getCharSequence("android.title");
    }

    @ReplaceWith(expression = "notification.extras")
    @Deprecated
    public static Bundle getExtras(Notification notification) {
        return notification.extras;
    }

    public static String getGroup(Notification notification) {
        return NotificationCompat.Api20Impl.getGroup(notification);
    }

    public static int getGroupAlertBehavior(Notification notification) {
        return NotificationCompat.Api26Impl.getGroupAlertBehavior(notification);
    }

    static boolean getHighPriority(Notification notification) {
        int i;
        i = flags &= 128 != 0 ? 1 : 0;
        return i;
    }

    public static List<androidx.core.app.NotificationCompat.Action> getInvisibleActions(Notification notification) {
        int i;
        androidx.core.app.NotificationCompat.Action actionFromBundle;
        ArrayList arrayList = new ArrayList();
        Bundle bundle = notification.extras.getBundle("android.car.EXTENSIONS");
        if (bundle == null) {
            return arrayList;
        }
        Bundle bundle2 = bundle.getBundle("invisible_actions");
        if (bundle2 != null) {
            i = 0;
            while (i < bundle2.size()) {
                arrayList.add(NotificationCompatJellybean.getActionFromBundle(bundle2.getBundle(Integer.toString(i))));
                i++;
            }
        }
        return arrayList;
    }

    public static boolean getLocalOnly(Notification notification) {
        int i;
        i = flags &= 256 != 0 ? 1 : 0;
        return i;
    }

    public static LocusIdCompat getLocusId(Notification notification) {
        int locusIdCompat;
        final LocusId locusId = NotificationCompat.Api29Impl.getLocusId(notification);
        if (locusId == null) {
            locusIdCompat = 0;
        } else {
            locusIdCompat = LocusIdCompat.toLocusIdCompat(locusId);
        }
        return locusIdCompat;
    }

    static Notification[] getNotificationArrayFromBundle(Bundle bundle, String key) {
        int i;
        Parcelable parcelable;
        final Parcelable[] parcelableArray = bundle.getParcelableArray(key);
        if (!parcelableArray instanceof Notification[]) {
            if (parcelableArray == null) {
            } else {
                Notification[] arr = new Notification[parcelableArray.length];
                i = 0;
                for (Object parcelable : obj0) {
                    arr[i] = (Notification)parcelable;
                }
            }
            bundle.putParcelableArray(key, arr);
            return arr;
        }
        return (Notification[])parcelableArray;
    }

    public static boolean getOngoing(Notification notification) {
        int i;
        i = flags &= 2 != 0 ? 1 : 0;
        return i;
    }

    public static boolean getOnlyAlertOnce(Notification notification) {
        int i;
        i = flags &= 8 != 0 ? 1 : 0;
        return i;
    }

    public static List<androidx.core.app.Person> getPeople(Notification notification) {
        String iterator;
        Object next;
        androidx.core.app.Person androidPerson;
        ArrayList arrayList = new ArrayList();
        ArrayList parcelableArrayList = notification.extras.getParcelableArrayList("android.people.list");
        if (parcelableArrayList != null && !parcelableArrayList.isEmpty()) {
            if (!parcelableArrayList.isEmpty()) {
                iterator = parcelableArrayList.iterator();
                for (Person next : iterator) {
                    arrayList.add(Person.fromAndroidPerson(next));
                }
            }
        }
        return arrayList;
    }

    public static Notification getPublicVersion(Notification notification) {
        return notification.publicVersion;
    }

    public static java.lang.CharSequence getSettingsText(Notification notification) {
        return NotificationCompat.Api26Impl.getSettingsText(notification);
    }

    public static String getShortcutId(Notification notification) {
        return NotificationCompat.Api26Impl.getShortcutId(notification);
    }

    public static boolean getShowWhen(Notification notification) {
        return notification.extras.getBoolean("android.showWhen");
    }

    public static String getSortKey(Notification notification) {
        return NotificationCompat.Api20Impl.getSortKey(notification);
    }

    public static java.lang.CharSequence getSubText(Notification notification) {
        return notification.extras.getCharSequence("android.subText");
    }

    public static long getTimeoutAfter(Notification notification) {
        return NotificationCompat.Api26Impl.getTimeoutAfter(notification);
    }

    public static boolean getUsesChronometer(Notification notification) {
        return notification.extras.getBoolean("android.showChronometer");
    }

    public static int getVisibility(Notification notification) {
        return notification.visibility;
    }

    public static boolean isGroupSummary(Notification notification) {
        int i;
        i = flags &= 512 != 0 ? 1 : 0;
        return i;
    }

    public static Bitmap reduceLargeIconSize(Context context, Bitmap icon) {
        return icon;
    }
}
