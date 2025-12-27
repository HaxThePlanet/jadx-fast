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
import android.content.res.Resources.NotFoundException;
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

/* compiled from: IterableNotificationHelper.java */
/* loaded from: classes2.dex */
class n0 {

    static n0.a a;

    static class a {
        a() {
            super();
        }

        private NotificationChannel b(String str, String str2, String str3) {
            NotificationChannel notificationChannel = null;
            int i = 26;
            if (Build.VERSION.SDK_INT >= 26) {
                i = 4;
                notificationChannel = new NotificationChannel(str, str2, i);
                notificationChannel.setDescription(str3);
                boolean z = true;
                notificationChannel.enableLights(z);
            } else {
                int i2 = 0;
            }
            return notificationChannel;
        }

        private String c(Context context) throws PackageManager.NameNotFoundException {
            int i = 0;
            String string = null;
            boolean z;
            i = 0;
            try {
                Object obj = metaData2.get("iterable_notification_channel_name");
                z = obj instanceof String;
                if (obj instanceof String) {
                } else {
                    z = obj instanceof Integer;
                    if (obj instanceof Integer && value != 0) {
                        string = context.getString(value);
                    }
                }
                StringBuilder stringBuilder = new StringBuilder();
                String str5 = "channel name: ";
                str = str5 + string;
                j0.a("IterableNotification", str);
            } catch (Exception e) {
                j0.d(str2, "Error while retrieving channel name", e);
            }
            if (i != 0) {
                return i;
            }
            return "iterable channel";
        }

        private int d(Context context) {
            String str;
            int identifier = 0;
            ApplicationInfo applicationInfo;
            Bundle metaData2;
            str = "iterable_notification_icon";
            final String str3 = "IterableNotification";
            identifier = 0;
            try {
                int i = 128;
                applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), i);
                identifier = applicationInfo.metaData.getInt(str, identifier);
                StringBuilder stringBuilder = new StringBuilder();
                String str6 = "iconID: ";
                Object obj = applicationInfo.metaData.get(str);
                str = str6 + obj;
                j0.a(str3, str);
            } catch (android.content.pm.PackageManager.NameNotFoundException nameNotFound) {
                nameNotFound.printStackTrace();
            }
            if (identifier == 0) {
                identifier = context.getResources().getIdentifier(j.u(context), "drawable", context.getPackageName());
            }
            if (identifier == 0) {
                if (context.getApplicationInfo().icon != 0) {
                    str = "No Notification Icon defined - defaulting to app icon";
                    j0.a(str3, str);
                } else {
                    str2 = "No Notification Icon defined - push notifications will not be displayed";
                    j0.i(str3, str2);
                }
            }
            return identifier;
        }

        private void j(Context context, String str, String str2, String str3) {
            Object systemService = context.getApplicationContext().getSystemService("notification");
            int i = 26;
            if (Build.VERSION.SDK_INT >= 26 && systemService != null && notificationChannel != null) {
                if (!notificationChannel.getName().equals(str2)) {
                    StringBuilder stringBuilder = new StringBuilder();
                    String str6 = "Creating notification: channelId = ";
                    String str7 = " channelName = ";
                    String str8 = " channelDescription = ";
                    str5 = str6 + str + str7 + str2 + str8 + str3;
                    j0.a("IterableNotification", str5);
                    systemService.createNotificationChannel(b(str, str2, str3));
                }
            }
        }

        public l0 a(Context context, Bundle bundle) throws JSONException {
            int i = 0;
            String string = null;
            string = "attachment-url";
            String charSequence = context.getApplicationInfo().loadLabel(context.getPackageManager()).toString();
            String str9 = "itbl";
            int i9 = 0;
            final String str18 = "IterableNotification";
            if (!bundle.containsKey(str9)) {
                j0.i(str18, "Notification doesn't have an Iterable payload. Skipping.");
                return null;
            }
            if (g(bundle)) {
                j0.i(str18, "Received a ghost push notification. Skipping.");
                return i9;
            }
            j(context, context.getPackageName(), c(context), "");
            com.iterable.iterableapi.l0 l0Var = new l0(context, context.getPackageName());
            String string4 = bundle.getString("body");
            String string5 = bundle.getString("sound");
            String string3 = bundle.getString(str9);
            try {
                JSONObject jSONObject = new JSONObject(string3);
            } catch (android.content.pm.PackageManager.NameNotFoundException nameNotFound) {
                nameNotFound.printStackTrace();
            }
            com.iterable.iterableapi.m0 m0Var = new m0(string3);
            l0Var.b0 = m0Var;
            String str = m0Var.f();
            Notification notification = new Notification();
            notification.defaults |= 4;
            l0Var.y(d(context));
            l0Var.B(charSequence);
            boolean z = true;
            l0Var.g(z);
            l0Var.m(bundle.getString("title", charSequence));
            l0Var.v(z);
            l0Var.l(string4);
            int i3 = 17;
            if (Build.VERSION.SDK_INT >= 17) {
                l0Var.x(z);
            }
            l0Var.J(string);
            l0Var.I(string4);
            String str8 = "default";
            i = 0;
            if (string5 == null) {
                notification.defaults |= z;
            } else {
                String str13 = string5.split("\\.")[0];
                if (!str13.equalsIgnoreCase(str8)) {
                    str3 = "raw";
                    int identifier = context.getResources().getIdentifier(str13, str3, context.getPackageName());
                    StringBuilder stringBuilder3 = new StringBuilder();
                    String str21 = "android.resource://";
                    String packageName5 = context.getPackageName();
                    String str22 = "/";
                    str14 = str21 + packageName5 + str22 + identifier;
                    l0Var.z(Uri.parse(str14));
                } else {
                    notification.defaults |= z;
                }
            }
            l0Var.a0 = Math.abs((int)System.currentTimeMillis());
            StringBuilder stringBuilder2 = new StringBuilder();
            String str20 = "Request code = ";
            str2 = str20 + l0Var.a0;
            j0.a(str18, str2);
            if (str != null) {
                l0Var.a0 = Math.abs(str.hashCode());
                StringBuilder stringBuilder = new StringBuilder();
                str = str20 + l0Var.a0;
                j0.a(str18, str);
            }
            Intent intent = new Intent("com.iterable.push.ACTION_PUSH_ACTION");
            intent.setClass(context, IterableTrampolineActivity.class);
            intent.putExtras(nameNotFound);
            intent.putExtra("actionIdentifier", str8);
            intent.setFlags(268435456);
            if (m0Var.b() != null) {
                Iterator it = m0Var.b().iterator();
                while (it.hasNext()) {
                    l0Var.F(context, (m0.a)it.next(), nameNotFound);
                    i = i + z;
                    List list = 3;
                }
            }
            l0Var.k(PendingIntent.getActivity(context, l0Var.a0, intent, 201326592));
            l0Var.K(g(nameNotFound));
            try {
            } catch (android.content.pm.PackageManager.NameNotFoundException nameNotFound) {
                nameNotFound.printStackTrace();
            }
            if (context.getPackageManager().checkPermission("android.permission.VIBRATE", context.getPackageName()) == 0) {
                notification.defaults |= 2;
            }
            l0Var.n(notification.defaults);
            return l0Var;
        }

        public Intent e(Context context) {
            Intent launchIntentForPackage;
            Context applicationContext = context.getApplicationContext();
            if (applicationContext.getPackageManager().getLaunchIntentForPackage(applicationContext.getPackageName()) == null) {
                str = "android.intent.action.MAIN";
                launchIntentForPackage = new Intent(str, null);
                packageName = "android.intent.category.LAUNCHER";
                launchIntentForPackage.addCategory(packageName);
                launchIntentForPackage.setPackage(applicationContext.getPackageName());
            }
            return launchIntentForPackage;
        }

        boolean f(Bundle bundle) {
            String string;
            string = "";
            if (bundle.containsKey("itbl")) {
                string = bundle.getString("body", "");
            }
            return string.isEmpty();
        }

        boolean g(Bundle bundle) {
            boolean z = false;
            String str = "itbl";
            if (bundle.containsKey(str)) {
                z = new m0(bundle.getString(str)).e();
            } else {
                int i = 0;
            }
            return z;
        }

        boolean h(Bundle bundle) {
            String str;
            boolean z = false;
            if (bundle != null) {
                str = "itbl";
                bundle = bundle.containsKey(str) ? 1 : 0;
            }
            return (bundle.containsKey(str) ? 1 : 0);
        }

        public void i(Context context, l0 l0Var) {
            if (!l0Var.H()) {
                (NotificationManager)context.getSystemService("notification").notify(l0Var.a0, l0Var.c());
            }
        }
    }
    static {
        n0.a = new n0.a();
    }

    public static l0 a(Context context, Bundle bundle) {
        return n0.a.a(context, bundle);
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
        final Bundle bundle = new Bundle();
        Iterator it = map.entrySet().iterator();
        while (it.hasNext()) {
            Object item = it.next();
            bundle.putString((String)item.getKey(), (String)item.getValue());
        }
        return bundle;
    }

    public static void g(Context context, l0 l0Var) {
        n0.a.i(context, l0Var);
    }
}
