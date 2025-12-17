package com.iterable.iterableapi;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import androidx.core.app.j.e;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes2.dex */
class n0 {

    static com.iterable.iterableapi.n0.a a;

    static class a {
        private NotificationChannel b(String string, String string2, String string3) {
            NotificationChannel notificationChannel;
            int i;
            int obj3;
            if (Build.VERSION.SDK_INT >= 26) {
                notificationChannel = new NotificationChannel(string, string2, 4);
                notificationChannel.setDescription(string3);
                notificationChannel.enableLights(true);
            } else {
                notificationChannel = 0;
            }
            return notificationChannel;
        }

        private String c(Context context) {
            int string;
            Object intValue;
            Object metaData;
            boolean packageName;
            Object obj6;
            string = 0;
            metaData = applicationInfo.metaData;
            if (metaData != null) {
                intValue = metaData.get("iterable_notification_channel_name");
                if (intValue instanceof String != null) {
                    string = intValue;
                } else {
                    try {
                        intValue = (Integer)(String)intValue.intValue();
                        if (intValue instanceof Integer && intValue != 0) {
                        }
                        intValue = (Integer)intValue.intValue();
                        if (intValue != 0) {
                        }
                        string = context.getString(intValue);
                        obj6 = new StringBuilder();
                        obj6.append("channel name: ");
                        obj6.append(string);
                        j0.a("IterableNotification", obj6.toString());
                        j0.d(obj0, "Error while retrieving channel name", context);
                        if (string != null) {
                        }
                        return string;
                        return "iterable channel";
                    }
                }
            }
        }

        private int d(Context context) {
            String resources;
            int identifier;
            Object applicationInfo;
            Object stringBuilder;
            int str;
            Object obj7;
            resources = "iterable_notification_icon";
            final String str2 = "IterableNotification";
            applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
            stringBuilder = applicationInfo.metaData;
            if (stringBuilder != null) {
                identifier = stringBuilder.getInt(resources, 0);
                stringBuilder = new StringBuilder();
                stringBuilder.append("iconID: ");
                stringBuilder.append(applicationInfo.metaData.get(resources));
                j0.a(str2, stringBuilder.toString());
            }
            if (identifier == 0) {
                identifier = context.getResources().getIdentifier(j.u(context), "drawable", context.getPackageName());
            }
            try {
                if (identifier == 0) {
                }
                if (applicationInfo2.icon != 0) {
                } else {
                }
                j0.a(str2, "No Notification Icon defined - defaulting to app icon");
                identifier = obj7.icon;
                j0.i(str2, "No Notification Icon defined - push notifications will not be displayed");
                return identifier;
            }
        }

        private void j(Context context, String string2, String string3, String string4) {
            NotificationChannel notificationChannel;
            int str;
            Object obj4;
            Object obj3 = context.getApplicationContext().getSystemService("notification");
            if (Build.VERSION.SDK_INT >= 26 && (NotificationManager)obj3 != null) {
                if ((NotificationManager)obj3 != null) {
                    notificationChannel = (NotificationManager)obj3.getNotificationChannel(string2);
                    if (notificationChannel != null) {
                        if (!notificationChannel.getName().equals(string3)) {
                            StringBuilder stringBuilder = new StringBuilder();
                            stringBuilder.append("Creating notification: channelId = ");
                            stringBuilder.append(string2);
                            stringBuilder.append(" channelName = ");
                            stringBuilder.append(string3);
                            stringBuilder.append(" channelDescription = ");
                            stringBuilder.append(string4);
                            j0.a("IterableNotification", stringBuilder.toString());
                            obj3.createNotificationChannel(b(string2, string3, string4));
                        }
                    } else {
                    }
                }
            }
        }

        public com.iterable.iterableapi.l0 a(Context context, Bundle bundle2) {
            String string2;
            Object m0Var;
            Object packageName;
            List next;
            String string;
            int i;
            int i2;
            Uri parse;
            String string3;
            StringBuilder equalsIgnoreCase;
            String str;
            String str2;
            int obj13;
            Bundle obj14;
            string2 = "attachment-url";
            String string5 = context.getApplicationInfo().loadLabel(context.getPackageManager()).toString();
            String str8 = "itbl";
            i2 = 0;
            final String str15 = "IterableNotification";
            if (!bundle2.containsKey(str8)) {
                j0.i(str15, "Notification doesn't have an Iterable payload. Skipping.");
                return i2;
            }
            if (g(bundle2)) {
                j0.i(str15, "Received a ghost push notification. Skipping.");
                return i2;
            }
            j(context, context.getPackageName(), c(context), "");
            l0 l0Var = new l0(context, context.getPackageName());
            String string8 = bundle2.getString("body");
            equalsIgnoreCase = bundle2.getString("sound");
            String string7 = bundle2.getString(str8);
            JSONObject jSONObject = new JSONObject(string7);
            if (jSONObject.has(string2)) {
                i2 = string2;
            }
            m0Var = new m0(string7);
            l0Var.b0 = m0Var;
            string = m0Var.f();
            Notification notification = new Notification();
            notification.defaults = defaults3 |= 4;
            l0Var.y(d(context));
            l0Var.B(string5);
            int i4 = 1;
            l0Var.g(i4);
            l0Var.m(bundle2.getString("title", string5));
            l0Var.v(i4);
            l0Var.l(string8);
            if (Build.VERSION.SDK_INT >= 17) {
                l0Var.x(i4);
            }
            l0Var.J(i2);
            l0Var.I(string8);
            String str7 = "default";
            if (equalsIgnoreCase != null) {
                String str14 = equalsIgnoreCase.split("\\.")[0];
                if (!str14.equalsIgnoreCase(str7)) {
                    equalsIgnoreCase = new StringBuilder();
                    equalsIgnoreCase.append("android.resource://");
                    equalsIgnoreCase.append(context.getPackageName());
                    equalsIgnoreCase.append("/");
                    equalsIgnoreCase.append(context.getResources().getIdentifier(str14, "raw", context.getPackageName()));
                    l0Var.z(Uri.parse(equalsIgnoreCase.toString()));
                } else {
                    notification.defaults = defaults |= i4;
                }
            } else {
                notification.defaults = defaults2 |= i4;
            }
            l0Var.a0 = Math.abs((int)currentTimeMillis);
            StringBuilder stringBuilder2 = new StringBuilder();
            String str17 = "Request code = ";
            stringBuilder2.append(str17);
            stringBuilder2.append(l0Var.a0);
            j0.a(str15, stringBuilder2.toString());
            if (string != null) {
                l0Var.a0 = Math.abs(string.hashCode());
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(str17);
                stringBuilder.append(l0Var.a0);
                j0.a(str15, stringBuilder.toString());
            }
            Intent intent = new Intent("com.iterable.push.ACTION_PUSH_ACTION");
            intent.setClass(context, IterableTrampolineActivity.class);
            intent.putExtras(bundle2);
            intent.putExtra("actionIdentifier", str7);
            intent.setFlags(268435456);
            if (m0Var.b() != null) {
                m0Var = m0Var.b().iterator();
                while (m0Var.hasNext()) {
                    l0Var.F(context, (m0.a)m0Var.next(), bundle2);
                    if (i += i4 != 3) {
                    }
                }
            }
            l0Var.k(PendingIntent.getActivity(context, l0Var.a0, intent, 201326592));
            l0Var.K(g(bundle2));
            obj14 = obj14.metaData;
            if (obj14 != null) {
                l0Var.j(context.getResources().getColor(obj14.getInt("iterable_notification_color")));
            }
            if (context.getPackageManager().checkPermission("android.permission.VIBRATE", context.getPackageName()) == 0) {
                notification.defaults = obj13 |= 2;
            }
            l0Var.n(notification.defaults);
            return l0Var;
        }

        public Intent e(Context context) {
            Intent launchIntentForPackage;
            String packageName;
            String str;
            Object obj4;
            obj4 = context.getApplicationContext();
            if (obj4.getPackageManager().getLaunchIntentForPackage(obj4.getPackageName()) == null) {
                launchIntentForPackage = new Intent("android.intent.action.MAIN", 0);
                launchIntentForPackage.addCategory("android.intent.category.LAUNCHER");
                launchIntentForPackage.setPackage(obj4.getPackageName());
            }
            return launchIntentForPackage;
        }

        boolean f(Bundle bundle) {
            boolean key;
            String string;
            if (bundle.containsKey("itbl")) {
                string = bundle.getString("body", "");
            }
            return string.isEmpty();
        }

        boolean g(Bundle bundle) {
            Object m0Var;
            boolean obj3;
            m0Var = "itbl";
            if (bundle.containsKey(m0Var)) {
                m0Var = new m0(bundle.getString(m0Var));
                obj3 = m0Var.e();
            } else {
                obj3 = 0;
            }
            return obj3;
        }

        boolean h(Bundle bundle) {
            String str;
            boolean obj2;
            if (bundle != null && bundle.containsKey("itbl")) {
                obj2 = bundle.containsKey("itbl") ? 1 : 0;
            } else {
            }
            return obj2;
        }

        public void i(Context context, com.iterable.iterableapi.l0 l02) {
            boolean z;
            Object obj2;
            Object obj3;
            if (!l02.H()) {
                (NotificationManager)context.getSystemService("notification").notify(l02.a0, l02.c());
            }
        }
    }
    static {
        n0.a aVar = new n0.a();
        n0.a = aVar;
    }

    public static com.iterable.iterableapi.l0 a(Context context, Bundle bundle2) {
        return n0.a.a(context, bundle2);
    }

    public static Intent b(Context context) {
        return n0.a.e(context);
    }

    static boolean c(Bundle bundle) {
        return n0.a.f(bundle);
    }

    static boolean d(Bundle bundle) {
        return n0.a.g(bundle);
    }

    static boolean e(Bundle bundle) {
        return n0.a.h(bundle);
    }

    static Bundle f(Map<String, String> map) {
        Object value;
        Object key;
        Bundle bundle = new Bundle();
        Iterator obj3 = map.entrySet().iterator();
        for (Map.Entry next2 : obj3) {
            bundle.putString((String)next2.getKey(), (String)next2.getValue());
        }
        return bundle;
    }

    public static void g(Context context, com.iterable.iterableapi.l0 l02) {
        n0.a.i(context, l02);
    }
}
