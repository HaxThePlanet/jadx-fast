package com.google.firebase.messaging;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.tasks.m;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.analytics.connector.AnalyticsConnector;
import com.google.firebase.installations.FirebaseInstallations;
import com.google.firebase.messaging.reporting.MessagingClientEvent;
import com.google.firebase.messaging.reporting.MessagingClientEvent.Builder;
import com.google.firebase.messaging.reporting.MessagingClientEvent.Event;
import com.google.firebase.messaging.reporting.MessagingClientEvent.MessageType;
import com.google.firebase.messaging.reporting.MessagingClientEvent.SDKPlatform;
import com.google.firebase.messaging.reporting.MessagingClientEventExtension;
import com.google.firebase.messaging.reporting.MessagingClientEventExtension.Builder;
import f.c.a.b.b;
import f.c.a.b.c;
import f.c.a.b.f;
import f.c.a.b.g;

/* loaded from: classes2.dex */
public class MessagingAnalytics {
    static boolean deliveryMetricsExportToBigQueryEnabled() {
        Object applicationContext;
        PackageManager packageManager;
        String str;
        String str3 = "delivery_metrics_exported_to_big_query_enabled";
        final int i = 0;
        FirebaseApp.getInstance();
        applicationContext = FirebaseApp.getInstance().getApplicationContext();
        SharedPreferences sharedPreferences = applicationContext.getSharedPreferences("com.google.firebase.messaging", i);
        str = "export_to_big_query";
        if (sharedPreferences.contains(str)) {
            return sharedPreferences.getBoolean(str, i);
        }
        packageManager = applicationContext.getPackageManager();
        applicationContext = packageManager.getApplicationInfo(applicationContext.getPackageName(), 128);
        packageManager = applicationContext.metaData;
        if (packageManager != null && applicationContext != null && packageManager != null && packageManager.containsKey(str3)) {
            try {
                applicationContext = packageManager.getApplicationInfo(applicationContext.getPackageName(), 128);
                packageManager = applicationContext.metaData;
            } catch (android.content.pm.PackageManager.NameNotFoundException nameNotFound) {
            }
        }
        return i;
    }

    static MessagingClientEvent eventToProto(MessagingClientEvent.Event messagingClientEvent$Event, Intent intent2) {
        Bundle obj4;
        if (intent2 == null) {
            return null;
        }
        if (intent2.getExtras() == null) {
            obj4 = Bundle.EMPTY;
        }
        final MessagingClientEvent.Builder builder = MessagingClientEvent.newBuilder();
        builder.setTtl(MessagingAnalytics.getTtl(obj4));
        builder.setEvent(event);
        builder.setInstanceId(MessagingAnalytics.getInstanceId(obj4));
        builder.setPackageName(MessagingAnalytics.getPackageName());
        builder.setSdkPlatform(MessagingClientEvent.SDKPlatform.ANDROID);
        builder.setMessageType(MessagingAnalytics.getMessageTypeForFirelog(obj4));
        String obj3 = MessagingAnalytics.getMessageId(obj4);
        if (obj3 != null) {
            builder.setMessageId(obj3);
        }
        obj3 = MessagingAnalytics.getTopic(obj4);
        if (obj3 != null) {
            builder.setTopic(obj3);
        }
        obj3 = MessagingAnalytics.getCollapseKey(obj4);
        if (obj3 != null) {
            builder.setCollapseKey(obj3);
        }
        obj3 = MessagingAnalytics.getMessageLabel(obj4);
        if (obj3 != null) {
            builder.setAnalyticsLabel(obj3);
        }
        obj3 = MessagingAnalytics.getComposerLabel(obj4);
        if (obj3 != null) {
            builder.setComposerLabel(obj3);
        }
        obj3 = MessagingAnalytics.getProjectNumber(obj4);
        if (Long.compare(obj3, i) > 0) {
            builder.setProjectNumber(obj3);
        }
        return builder.build();
    }

    static String getCollapseKey(Bundle bundle) {
        return bundle.getString("collapse_key");
    }

    static String getComposerId(Bundle bundle) {
        return bundle.getString("google.c.a.c_id");
    }

    static String getComposerLabel(Bundle bundle) {
        return bundle.getString("google.c.a.c_l");
    }

    static String getInstanceId(Bundle bundle) {
        String obj1 = bundle.getString("google.to");
        if (!TextUtils.isEmpty(obj1)) {
            return obj1;
        }
        return (String)m.a(FirebaseInstallations.getInstance(FirebaseApp.getInstance()).getId());
    }

    static String getMessageChannel(Bundle bundle) {
        return bundle.getString("google.c.a.m_c");
    }

    static String getMessageId(Bundle bundle) {
        String string = bundle.getString("google.message_id");
        if (string == null) {
            return bundle.getString("message_id");
        }
        return string;
    }

    static String getMessageLabel(Bundle bundle) {
        return bundle.getString("google.c.a.m_l");
    }

    static String getMessageTime(Bundle bundle) {
        return bundle.getString("google.c.a.ts");
    }

    static MessagingClientEvent.MessageType getMessageTypeForFirelog(Bundle bundle) {
        Bundle obj0;
        if (bundle != null && NotificationParams.isNotification(bundle)) {
            obj0 = NotificationParams.isNotification(bundle) ? MessagingClientEvent.MessageType.DISPLAY_NOTIFICATION : MessagingClientEvent.MessageType.DATA_MESSAGE;
        } else {
        }
        return obj0;
    }

    static String getMessageTypeForScion(Bundle bundle) {
        if (1 != NotificationParams.isNotification(bundle)) {
            return "data";
        }
        return "display";
    }

    static String getPackageName() {
        return FirebaseApp.getInstance().getApplicationContext().getPackageName();
    }

    static long getProjectNumber(Bundle bundle) {
        String str;
        String gcmSenderId;
        boolean key;
        Throwable obj6;
        str = "google.c.sender.id";
        final String str7 = "FirebaseMessaging";
        if (bundle.containsKey(str)) {
            return Long.parseLong(bundle.getString(str));
        }
        obj6 = FirebaseApp.getInstance();
        gcmSenderId = obj6.getOptions().getGcmSenderId();
        if (gcmSenderId != null) {
            return Long.parseLong(gcmSenderId);
        }
        obj6 = obj6.getOptions().getApplicationId();
        String str6 = "error parsing app ID";
        final int i2 = 0;
        if (!obj6.startsWith("1:")) {
            return Long.parseLong(obj6);
        }
        obj6 = obj6.split(":");
        if (obj6.length < 2) {
            try {
                return i2;
                obj6 = obj6[1];
                if (obj6.isEmpty()) {
                }
                return i2;
                return Long.parseLong(obj6);
                Log.w(obj2, str5, bundle);
                return obj3;
            } catch (java.lang.NumberFormatException numberFormat) {
            }
        }
    }

    static String getTopic(Bundle bundle) {
        String startsWith;
        String obj1 = bundle.getString("from");
        if (obj1 != null && obj1.startsWith("/topics/")) {
            if (obj1.startsWith("/topics/")) {
                return obj1;
            }
        }
        return null;
    }

    static int getTtl(Bundle bundle) {
        boolean z;
        Object obj1;
        obj1 = bundle.get("google.ttl");
        if (obj1 instanceof Integer) {
            return (Integer)obj1.intValue();
        }
        if (obj1 instanceof String != null) {
            return Integer.parseInt((String)obj1);
        }
        return 0;
    }

    static String getUseDeviceTime(Bundle bundle) {
        final String str = "google.c.a.udt";
        if (bundle.containsKey(str)) {
            return bundle.getString(str);
        }
        return null;
    }

    private static boolean isDirectBootMessage(Intent intent) {
        return "com.google.firebase.messaging.RECEIVE_DIRECT_BOOT".equals(intent.getAction());
    }

    public static void logNotificationDismiss(Intent intent) {
        MessagingAnalytics.logToScion("_nd", intent.getExtras());
    }

    public static void logNotificationForeground(Intent intent) {
        MessagingAnalytics.logToScion("_nf", intent.getExtras());
    }

    public static void logNotificationOpen(Bundle bundle) {
        MessagingAnalytics.setUserPropertyIfRequired(bundle);
        MessagingAnalytics.logToScion("_no", bundle);
    }

    public static void logNotificationReceived(Intent intent) {
        boolean uploadScionMetrics;
        boolean uploadFirelogAnalytics;
        String transportFactory;
        if (MessagingAnalytics.shouldUploadScionMetrics(intent)) {
            MessagingAnalytics.logToScion("_nr", intent.getExtras());
        }
        if (MessagingAnalytics.shouldUploadFirelogAnalytics(intent)) {
            MessagingAnalytics.logToFirelog(MessagingClientEvent.Event.MESSAGE_DELIVERED, intent, FirebaseMessaging.getTransportFactory());
        }
    }

    private static void logToFirelog(MessagingClientEvent.Event messagingClientEvent$Event, Intent intent2, g g3) {
        if (g3 == null) {
            Log.e("FirebaseMessaging", "TransportFactory is null. Skip exporting message delivery metrics to Big Query");
        }
        MessagingClientEvent obj4 = MessagingAnalytics.eventToProto(event, intent2);
        if (obj4 == null) {
        }
        final MessagingClientEventExtension.Builder obj6 = MessagingClientEventExtension.newBuilder();
        obj6.setMessagingClientEvent(obj4);
        g3.b("FCM_CLIENT_EVENT_LOGGING", MessagingClientEventExtension.class, b.b("proto"), MessagingAnalytics$$ExternalSyntheticLambda0.INSTANCE).a(c.e(obj6.build()));
    }

    static void logToScion(String string, Bundle bundle2) {
        String messageTime;
        String useDeviceTime;
        boolean stringBuilder;
        String str;
        boolean empty2;
        boolean empty;
        int length;
        Bundle obj6;
        String str2 = "FirebaseMessaging";
        FirebaseApp.getInstance();
        if (bundle2 == null) {
            obj6 = new Bundle();
        }
        try {
            Bundle bundle = new Bundle();
            String composerId = MessagingAnalytics.getComposerId(obj6);
            if (composerId != null) {
            }
            bundle.putString("_nmid", composerId);
            String composerLabel = MessagingAnalytics.getComposerLabel(obj6);
        } catch (java.lang.NumberFormatException numberFormat) {
        }
        bundle.putString("_nmn", composerLabel);
        String messageLabel = MessagingAnalytics.getMessageLabel(obj6);
        if (!TextUtils.isEmpty(messageLabel)) {
            bundle.putString("label", messageLabel);
        }
        String messageChannel = MessagingAnalytics.getMessageChannel(obj6);
        if (!TextUtils.isEmpty(messageChannel)) {
            bundle.putString("message_channel", messageChannel);
        }
        String topic = MessagingAnalytics.getTopic(obj6);
        if (topic != null) {
            bundle.putString("_nt", topic);
        }
        messageTime = MessagingAnalytics.getMessageTime(obj6);
        if (messageTime != null) {
            bundle.putInt("_nmt", Integer.parseInt(messageTime));
        }
        useDeviceTime = MessagingAnalytics.getUseDeviceTime(obj6);
        if (useDeviceTime != null) {
            bundle.putInt("_ndt", Integer.parseInt(useDeviceTime));
        }
        if (!"_nr".equals(string)) {
            if ("_nf".equals(string)) {
                bundle.putString("_nmc", MessagingAnalytics.getMessageTypeForScion(obj6));
            }
        } else {
        }
        if (Log.isLoggable(str2, 3)) {
            obj6 = bundle.toString();
            stringBuilder = new StringBuilder(i += length);
            stringBuilder.append("Logging to scion event=");
            stringBuilder.append(string);
            stringBuilder.append(" scionPayload=");
            stringBuilder.append(obj6);
            Log.d(str2, stringBuilder.toString());
        }
        obj6 = FirebaseApp.getInstance().get(AnalyticsConnector.class);
        if ((AnalyticsConnector)obj6 != null) {
            (AnalyticsConnector)obj6.logEvent("fcm", string, bundle);
        }
        Log.w(str2, "Unable to log event: analytics library is missing");
    }

    static void setDeliveryMetricsExportToBigQuery(boolean z) {
        FirebaseApp.getInstance().getApplicationContext().getSharedPreferences("com.google.firebase.messaging", 0).edit().putBoolean("export_to_big_query", z).apply();
    }

    private static void setUserPropertyIfRequired(Bundle bundle) {
        boolean loggable;
        boolean obj5;
        if (bundle == null) {
        }
        int i = 3;
        String str5 = "FirebaseMessaging";
        Object obj = FirebaseApp.getInstance().get(AnalyticsConnector.class);
        if ("1".equals(bundle.getString("google.c.a.tc")) && Log.isLoggable(str5, i)) {
            obj = FirebaseApp.getInstance().get(AnalyticsConnector.class);
            if (Log.isLoggable(str5, i)) {
                Log.d(str5, "Received event with track-conversion=true. Setting user property and reengagement event");
            }
            if ((AnalyticsConnector)(AnalyticsConnector)obj != null) {
                obj5 = bundle.getString("google.c.a.c_id");
                String str4 = "fcm";
                (AnalyticsConnector)(AnalyticsConnector)obj.setUserProperty(str4, "_ln", obj5);
                Bundle bundle2 = new Bundle();
                bundle2.putString("source", "Firebase");
                bundle2.putString("medium", "notification");
                bundle2.putString("campaign", obj5);
                obj.logEvent(str4, "_cmp", bundle2);
            }
            Log.w(str5, "Unable to set user property for conversion tracking:  analytics library is missing");
        }
        if (Log.isLoggable(str5, i)) {
            Log.d(str5, "Received event with track-conversion=false. Do not set user property");
        }
    }

    public static boolean shouldUploadFirelogAnalytics(Intent intent) {
        Intent obj0;
        if (intent != null && MessagingAnalytics.isDirectBootMessage(intent)) {
            if (MessagingAnalytics.isDirectBootMessage(intent)) {
            }
            return MessagingAnalytics.deliveryMetricsExportToBigQueryEnabled();
        }
        return 0;
    }

    public static boolean shouldUploadScionMetrics(Intent intent) {
        boolean directBootMessage;
        if (intent != null && MessagingAnalytics.isDirectBootMessage(intent)) {
            if (MessagingAnalytics.isDirectBootMessage(intent)) {
            }
            return MessagingAnalytics.shouldUploadScionMetrics(intent.getExtras());
        }
        return 0;
    }

    public static boolean shouldUploadScionMetrics(Bundle bundle) {
        if (bundle == null) {
            return 0;
        }
        return "1".equals(bundle.getString("google.c.a.e"));
    }
}
