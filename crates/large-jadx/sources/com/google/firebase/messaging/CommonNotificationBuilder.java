package com.google.firebase.messaging;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.graphics.Color;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.app.j.c;
import androidx.core.app.j.e;
import androidx.core.content.a;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes2.dex */
public final class CommonNotificationBuilder {

    public static final String FCM_FALLBACK_NOTIFICATION_CHANNEL = "fcm_fallback_notification_channel";
    public static final String FCM_FALLBACK_NOTIFICATION_CHANNEL_LABEL = "fcm_fallback_notification_channel_label";
    public static final String METADATA_DEFAULT_CHANNEL_ID = "com.google.firebase.messaging.default_notification_channel_id";
    public static final String METADATA_DEFAULT_COLOR = "com.google.firebase.messaging.default_notification_color";
    public static final String METADATA_DEFAULT_ICON = "com.google.firebase.messaging.default_notification_icon";
    private static final AtomicInteger requestCodeProvider;

    public static class DisplayNotificationInfo {

        public final int id = 0;
        public final j.e notificationBuilder;
        public final String tag;
        DisplayNotificationInfo(j.e j$e, String string2, int i3) {
            super();
            this.notificationBuilder = e;
            this.tag = string2;
            final int obj1 = 0;
        }
    }
    static {
        AtomicInteger atomicInteger = new AtomicInteger((int)elapsedRealtime);
        CommonNotificationBuilder.requestCodeProvider = atomicInteger;
    }

    private static PendingIntent createContentIntent(Context context, com.google.firebase.messaging.NotificationParams notificationParams2, String string3, PackageManager packageManager4) {
        Object obj1;
        boolean obj3;
        final Intent obj2 = CommonNotificationBuilder.createTargetIntent(string3, notificationParams2, packageManager4);
        if (obj2 == null) {
            return null;
        }
        obj2.addFlags(67108864);
        obj2.putExtras(notificationParams2.paramsWithReservedKeysRemoved());
        if (CommonNotificationBuilder.shouldUploadMetrics(notificationParams2)) {
            obj2.putExtra("gcm.n.analytics_data", notificationParams2.paramsForAnalyticsIntent());
        }
        return PendingIntent.getActivity(context, CommonNotificationBuilder.generatePendingIntentRequestCode(), obj2, CommonNotificationBuilder.getPendingIntentFlags(1073741824));
    }

    private static PendingIntent createDeleteIntent(Context context, com.google.firebase.messaging.NotificationParams notificationParams2) {
        if (!CommonNotificationBuilder.shouldUploadMetrics(notificationParams2)) {
            return null;
        }
        Intent intent = new Intent("com.google.firebase.messaging.NOTIFICATION_DISMISS");
        return CommonNotificationBuilder.createMessagingPendingIntent(context, intent.putExtras(notificationParams2.paramsForAnalyticsIntent()));
    }

    private static PendingIntent createMessagingPendingIntent(Context context, Intent intent2) {
        Intent intent = new Intent("com.google.firebase.MESSAGING_EVENT");
        ComponentName componentName = new ComponentName(context, "com.google.firebase.iid.FirebaseInstanceIdReceiver");
        return PendingIntent.getBroadcast(context, CommonNotificationBuilder.generatePendingIntentRequestCode(), intent.setComponent(componentName).putExtra("wrapped_intent", intent2), CommonNotificationBuilder.getPendingIntentFlags(1073741824));
    }

    static com.google.firebase.messaging.CommonNotificationBuilder.DisplayNotificationInfo createNotificationInfo(Context context, com.google.firebase.messaging.NotificationParams notificationParams2) {
        final Bundle manifestMetadata = CommonNotificationBuilder.getManifestMetadata(context.getPackageManager(), context.getPackageName());
        return CommonNotificationBuilder.createNotificationInfo(context, context.getPackageName(), notificationParams2, CommonNotificationBuilder.getOrCreateChannel(context, notificationParams2.getNotificationChannelId(), manifestMetadata), context.getResources(), context.getPackageManager(), manifestMetadata);
    }

    public static com.google.firebase.messaging.CommonNotificationBuilder.DisplayNotificationInfo createNotificationInfo(Context context, String string2, com.google.firebase.messaging.NotificationParams notificationParams3, String string4, Resources resources5, PackageManager packageManager6, Bundle bundle7) {
        boolean cVar;
        Integer obj2;
        int obj3;
        Uri obj5;
        Resources obj6;
        PackageManager obj7;
        j.e eVar = new j.e(context, string4);
        obj5 = notificationParams3.getPossiblyLocalizedString(resources5, string2, "gcm.n.title");
        if (!TextUtils.isEmpty(obj5)) {
            eVar.m(obj5);
        }
        obj5 = notificationParams3.getPossiblyLocalizedString(resources5, string2, "gcm.n.body");
        if (!TextUtils.isEmpty(obj5)) {
            eVar.l(obj5);
            cVar = new j.c();
            cVar.h(obj5);
            eVar.A(cVar);
        }
        eVar.y(CommonNotificationBuilder.getSmallIcon(packageManager6, resources5, string2, notificationParams3.getString("gcm.n.icon"), bundle7));
        obj5 = CommonNotificationBuilder.getSound(string2, notificationParams3, resources5);
        if (obj5 != null) {
            eVar.z(obj5);
        }
        eVar.k(CommonNotificationBuilder.createContentIntent(context, notificationParams3, string2, packageManager6));
        obj3 = CommonNotificationBuilder.createDeleteIntent(context, notificationParams3);
        if (obj3 != null) {
            eVar.o(obj3);
        }
        obj2 = CommonNotificationBuilder.getColor(context, notificationParams3.getString("gcm.n.color"), bundle7);
        if (obj2 != null) {
            eVar.j(obj2.intValue());
        }
        obj3 = 1;
        eVar.g(obj2 ^= obj3);
        eVar.s(notificationParams3.getBoolean("gcm.n.local_only"));
        obj2 = notificationParams3.getString("gcm.n.ticker");
        if (obj2 != null) {
            eVar.B(obj2);
        }
        obj2 = notificationParams3.getNotificationPriority();
        if (obj2 != null) {
            eVar.v(obj2.intValue());
        }
        obj2 = notificationParams3.getVisibility();
        if (obj2 != null) {
            eVar.D(obj2.intValue());
        }
        obj2 = notificationParams3.getNotificationCount();
        if (obj2 != null) {
            eVar.t(obj2.intValue());
        }
        obj2 = notificationParams3.getLong("gcm.n.event_time");
        if (obj2 != null) {
            eVar.x(obj3);
            eVar.E(obj2.longValue());
        }
        obj2 = notificationParams3.getVibrateTimings();
        if (obj2 != null) {
            eVar.C(obj2);
        }
        obj2 = notificationParams3.getLightSettings();
        obj5 = 0;
        if (obj2 != null) {
            eVar.r(obj2[obj5], obj2[obj3], obj2[2]);
        }
        eVar.n(CommonNotificationBuilder.getConsolidatedDefaults(notificationParams3));
        obj2 = new CommonNotificationBuilder.DisplayNotificationInfo(eVar, CommonNotificationBuilder.getTag(notificationParams3), obj5);
        return obj2;
    }

    private static Intent createTargetIntent(String string, com.google.firebase.messaging.NotificationParams notificationParams2, PackageManager packageManager3) {
        Object obj3;
        String obj4;
        String string2 = notificationParams2.getString("gcm.n.click_action");
        if (!TextUtils.isEmpty(string2)) {
            obj3 = new Intent(string2);
            obj3.setPackage(string);
            obj3.setFlags(268435456);
            return obj3;
        }
        obj3 = notificationParams2.getLink();
        if (obj3 != null) {
            obj4 = new Intent("android.intent.action.VIEW");
            obj4.setPackage(string);
            obj4.setData(obj3);
            return obj4;
        }
        Intent obj2 = packageManager3.getLaunchIntentForPackage(string);
        if (obj2 == null) {
            Log.w("FirebaseMessaging", "No activity found to launch app");
        }
        return obj2;
    }

    private static int generatePendingIntentRequestCode() {
        return CommonNotificationBuilder.requestCodeProvider.incrementAndGet();
    }

    private static Integer getColor(Context context, String string2, Bundle bundle3) {
        boolean empty;
        StringBuilder stringBuilder;
        Context obj4;
        java.lang.CharSequence obj5;
        final int i = 0;
        if (Build.VERSION.SDK_INT < 21) {
            return i;
        }
        String str3 = "FirebaseMessaging";
        if (!TextUtils.isEmpty(string2)) {
            return Integer.valueOf(Color.parseColor(string2));
        }
        obj5 = bundle3.getInt("com.google.firebase.messaging.default_notification_color", 0);
        if (obj5 != null) {
            return Integer.valueOf(a.d(context, obj5));
        }
        return i;
    }

    private static int getConsolidatedDefaults(com.google.firebase.messaging.NotificationParams notificationParams) {
        boolean boolean;
        if (notificationParams.getBoolean("gcm.n.default_vibrate_timings")) {
            boolean |= 2;
        }
        if (notificationParams.getBoolean("gcm.n.default_light_settings")) {
            return boolean | 4;
        }
        return boolean;
    }

    private static Bundle getManifestMetadata(PackageManager packageManager, String string2) {
        Object obj1;
        String obj2;
        obj1 = packageManager.getApplicationInfo(string2, 128);
        obj1 = obj1.metaData;
        if (obj1 != null && obj1 != null) {
            obj1 = obj1.metaData;
            if (obj1 != null) {
                try {
                    return obj1;
                    packageManager = packageManager.toString();
                    string2 = "Couldn't get own application info: ";
                    packageManager = string2.concat(packageManager);
                    string2 = "FirebaseMessaging";
                    Log.w(string2, packageManager);
                    return Bundle.EMPTY;
                }
            }
        }
    }

    public static String getOrCreateChannel(Context context, String string2, Bundle bundle3) {
        boolean empty;
        Object stringBuilder;
        int str;
        String obj5;
        Object obj6;
        boolean obj7;
        int i = 26;
        int i3 = 0;
        if (Build.VERSION.SDK_INT < i) {
            return i3;
        }
        Object systemService = context.getSystemService(NotificationManager.class);
        String str2 = "FirebaseMessaging";
        if (applicationInfo.targetSdkVersion >= i && !TextUtils.isEmpty(string2) && (NotificationManager)systemService.getNotificationChannel(string2) != null) {
            systemService = context.getSystemService(NotificationManager.class);
            str2 = "FirebaseMessaging";
            if (!TextUtils.isEmpty(string2)) {
                if ((NotificationManager)systemService.getNotificationChannel(string2) != null) {
                    return string2;
                }
                stringBuilder = new StringBuilder(length += 122);
                stringBuilder.append("Notification Channel requested (");
                stringBuilder.append(string2);
                stringBuilder.append(") has not been created by the app. Manifest configuration, or default, value will be used.");
                Log.w(str2, stringBuilder.toString());
            }
            obj6 = bundle3.getString("com.google.firebase.messaging.default_notification_channel_id");
            if (!TextUtils.isEmpty(obj6)) {
                try {
                    if (systemService.getNotificationChannel(obj6) != null) {
                    }
                    return obj6;
                    Log.w(str2, "Notification Channel set in AndroidManifest.xml has not been created by the app. Default value will be used.");
                    Log.w(str2, "Missing Default Notification Channel metadata in AndroidManifest. Default value will be used.");
                    obj6 = "fcm_fallback_notification_channel";
                    if (systemService.getNotificationChannel(obj6) == null) {
                    }
                    obj7 = context.getResources().getIdentifier("fcm_fallback_notification_channel_label", "string", context.getPackageName());
                    if (obj7 == null) {
                    } else {
                    }
                    Log.e(str2, "String resource \"fcm_fallback_notification_channel_label\" is not found. Using default string channel name.");
                    obj5 = "Misc";
                    obj5 = context.getString(obj7);
                    obj7 = new NotificationChannel(obj6, obj5, 3);
                    systemService.createNotificationChannel(obj7);
                    return obj6;
                    return i3;
                }
            } else {
            }
        }
    }

    private static int getPendingIntentFlags(int i) {
        if (Build.VERSION.SDK_INT >= 23) {
            return 1140850688;
        }
        return 1073741824;
    }

    private static int getSmallIcon(PackageManager packageManager, Resources resources2, String string3, String string4, Bundle bundle5) {
        boolean empty;
        boolean stringBuilder;
        Object obj3;
        Resources obj4;
        String obj5;
        Object obj6;
        boolean obj7;
        int identifier = resources2.getIdentifier(string4, "drawable", string3);
        if (!TextUtils.isEmpty(string4) && identifier != 0 && !CommonNotificationBuilder.isValidIcon(resources2, identifier)) {
            identifier = resources2.getIdentifier(string4, "drawable", string3);
            if (identifier != 0) {
                if (!CommonNotificationBuilder.isValidIcon(resources2, identifier)) {
                }
                return identifier;
            }
            int identifier2 = resources2.getIdentifier(string4, "mipmap", string3);
            if (identifier2 != 0 && !CommonNotificationBuilder.isValidIcon(resources2, identifier2)) {
                if (!CommonNotificationBuilder.isValidIcon(resources2, identifier2)) {
                }
                return identifier2;
            }
            stringBuilder = new StringBuilder(length += 61);
            stringBuilder.append("Icon resource ");
            stringBuilder.append(string4);
            stringBuilder.append(" not found. Notification will use default icon.");
            Log.w("FirebaseMessaging", stringBuilder.toString());
        }
        int i2 = 0;
        obj6 = bundle5.getInt("com.google.firebase.messaging.default_notification_icon", i2);
        if (obj6 != null) {
            if (!CommonNotificationBuilder.isValidIcon(resources2, obj6)) {
                obj6 = obj3.icon;
            }
        } else {
        }
        obj3 = 17301651;
        if (obj6 != null) {
            if (!CommonNotificationBuilder.isValidIcon(resources2, obj6)) {
                return obj3;
            }
        } else {
            obj6 = obj3;
        }
        return obj6;
    }

    private static Uri getSound(String string, com.google.firebase.messaging.NotificationParams notificationParams2, Resources resources3) {
        boolean equals;
        int obj4;
        final String obj3 = notificationParams2.getSoundResourceName();
        if (TextUtils.isEmpty(obj3)) {
            return null;
        }
        if (!"default".equals(obj3) && resources3.getIdentifier(obj3, "raw", string) != 0) {
            if (resources3.getIdentifier(obj3, "raw", string) != 0) {
                StringBuilder stringBuilder = new StringBuilder(obj4 += length);
                stringBuilder.append("android.resource://");
                stringBuilder.append(string);
                stringBuilder.append("/raw/");
                stringBuilder.append(obj3);
                return Uri.parse(stringBuilder.toString());
            }
        }
        return RingtoneManager.getDefaultUri(2);
    }

    private static String getTag(com.google.firebase.messaging.NotificationParams notificationParams) {
        String obj3 = notificationParams.getString("gcm.n.tag");
        if (!TextUtils.isEmpty(obj3)) {
            return obj3;
        }
        obj3 = new StringBuilder(37);
        obj3.append("FCM-Notification:");
        obj3.append(SystemClock.uptimeMillis());
        return obj3.toString();
    }

    private static boolean isValidIcon(Resources resources, int i2) {
        final int i4 = 1;
        if (Build.VERSION.SDK_INT != 26) {
            return i4;
        }
        if (obj4 instanceof AdaptiveIconDrawable) {
            StringBuilder obj4 = new StringBuilder(77);
            obj4.append("Adaptive icons cannot be used in notifications. Ignoring icon id: ");
            obj4.append(i2);
            Log.e("FirebaseMessaging", obj4.toString());
            return 0;
        }
        return i4;
    }

    static boolean shouldUploadMetrics(com.google.firebase.messaging.NotificationParams notificationParams) {
        return notificationParams.getBoolean("google.c.a.e");
    }
}
