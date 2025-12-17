package androidx.core.content;

import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Process;
import android.util.Log;
import android.util.TypedValue;
import androidx.core.content.e.f;
import androidx.core.os.d;
import java.io.File;
import java.util.HashMap;
import java.util.concurrent.Executor;

/* loaded from: classes.dex */
public class a {

    private static final Object a;
    private static final Object b;
    private static TypedValue c;

    static class a {
        static void a(Context context, Intent[] intent2Arr2, Bundle bundle3) {
            context.startActivities(intent2Arr2, bundle3);
        }

        static void b(Context context, Intent intent2, Bundle bundle3) {
            context.startActivity(intent2, bundle3);
        }
    }

    static class b {
        static File[] a(Context context) {
            return context.getExternalCacheDirs();
        }

        static File[] b(Context context, String string2) {
            return context.getExternalFilesDirs(string2);
        }

        static File[] c(Context context) {
            return context.getObbDirs();
        }
    }

    static class c {
        static File a(Context context) {
            return context.getCodeCacheDir();
        }

        static Drawable b(Context context, int i2) {
            return context.getDrawable(i2);
        }

        static File c(Context context) {
            return context.getNoBackupFilesDir();
        }
    }

    static class d {
        static int a(Context context, int i2) {
            return context.getColor(i2);
        }

        static ColorStateList b(Context context, int i2) {
            return context.getColorStateList(i2);
        }

        static <T> T c(Context context, Class<T> class2) {
            return context.getSystemService(class2);
        }

        static String d(Context context, Class<?> class2) {
            return context.getSystemServiceName(class2);
        }
    }

    static class e {
        static Context a(Context context) {
            return context.createDeviceProtectedStorageContext();
        }

        static File b(Context context) {
            return context.getDataDir();
        }

        static boolean c(Context context) {
            return context.isDeviceProtectedStorage();
        }
    }

    static class f {
        static Executor a(Context context) {
            return context.getMainExecutor();
        }
    }

    private static final class g {

        static final HashMap<Class<?>, String> a;
        static {
            int sDK_INT;
            int i2;
            int i;
            int i3;
            int i5;
            int i4;
            int str;
            String str2;
            HashMap hashMap = new HashMap();
            a.g.a = hashMap;
            sDK_INT = Build.VERSION.SDK_INT;
            if (sDK_INT >= 22) {
                hashMap.put(SubscriptionManager.class, "telephony_subscription_service");
                hashMap.put(UsageStatsManager.class, "usagestats");
            }
            if (sDK_INT >= 21) {
                hashMap.put(AppWidgetManager.class, "appwidget");
                hashMap.put(BatteryManager.class, "batterymanager");
                hashMap.put(CameraManager.class, "camera");
                hashMap.put(JobScheduler.class, "jobscheduler");
                hashMap.put(LauncherApps.class, "launcherapps");
                hashMap.put(MediaProjectionManager.class, "media_projection");
                hashMap.put(MediaSessionManager.class, "media_session");
                hashMap.put(RestrictionsManager.class, "restrictions");
                hashMap.put(TelecomManager.class, "telecom");
                hashMap.put(TvInputManager.class, "tv_input");
            }
            if (sDK_INT >= 19) {
                hashMap.put(AppOpsManager.class, "appops");
                hashMap.put(CaptioningManager.class, "captioning");
                hashMap.put(ConsumerIrManager.class, "consumer_ir");
                hashMap.put(PrintManager.class, "print");
            }
            if (sDK_INT >= 18) {
                hashMap.put(BluetoothManager.class, "bluetooth");
            }
            if (sDK_INT >= 17) {
                hashMap.put(DisplayManager.class, "display");
                hashMap.put(UserManager.class, "user");
            }
            if (sDK_INT >= 16) {
                hashMap.put(InputManager.class, "input");
                hashMap.put(MediaRouter.class, "media_router");
                hashMap.put(NsdManager.class, "servicediscovery");
            }
            hashMap.put(AccessibilityManager.class, "accessibility");
            hashMap.put(AccountManager.class, "account");
            hashMap.put(ActivityManager.class, "activity");
            hashMap.put(AlarmManager.class, "alarm");
            hashMap.put(AudioManager.class, "audio");
            hashMap.put(ClipboardManager.class, "clipboard");
            hashMap.put(ConnectivityManager.class, "connectivity");
            hashMap.put(DevicePolicyManager.class, "device_policy");
            hashMap.put(DownloadManager.class, "download");
            hashMap.put(DropBoxManager.class, "dropbox");
            hashMap.put(InputMethodManager.class, "input_method");
            hashMap.put(KeyguardManager.class, "keyguard");
            hashMap.put(LayoutInflater.class, "layout_inflater");
            hashMap.put(LocationManager.class, "location");
            hashMap.put(NfcManager.class, "nfc");
            hashMap.put(NotificationManager.class, "notification");
            hashMap.put(PowerManager.class, "power");
            hashMap.put(SearchManager.class, "search");
            hashMap.put(SensorManager.class, "sensor");
            hashMap.put(StorageManager.class, "storage");
            hashMap.put(TelephonyManager.class, "phone");
            hashMap.put(TextServicesManager.class, "textservices");
            hashMap.put(UiModeManager.class, "uimode");
            hashMap.put(UsbManager.class, "usb");
            hashMap.put(Vibrator.class, "vibrator");
            hashMap.put(WallpaperManager.class, "wallpaper");
            hashMap.put(WifiP2pManager.class, "wifip2p");
            hashMap.put(WifiManager.class, "wifi");
            hashMap.put(WindowManager.class, "window");
        }
    }
    static {
        Object object = new Object();
        a.a = object;
        Object object2 = new Object();
        a.b = object2;
    }

    public static int a(Context context, String string2) {
        if (string2 == null) {
        } else {
            return context.checkPermission(string2, Process.myPid(), Process.myUid());
        }
        IllegalArgumentException obj2 = new IllegalArgumentException("permission is null");
        throw obj2;
    }

    public static Context b(Context context) {
        if (Build.VERSION.SDK_INT >= 24) {
            return a.e.a(context);
        }
        return null;
    }

    private static File c(File file) {
        boolean exists;
        String string;
        String path;
        final Object obj = a.b;
        synchronized (obj) {
            if (file.mkdirs() != null) {
                return file;
            }
            try {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Unable to create files subdir ");
                stringBuilder.append(file.getPath());
                Log.w("ContextCompat", stringBuilder.toString());
                return file;
                throw file;
            }
        }
    }

    public static int d(Context context, int i2) {
        if (Build.VERSION.SDK_INT >= 23) {
            return a.d.a(context, i2);
        }
        return context.getResources().getColor(i2);
    }

    public static ColorStateList e(Context context, int i2) {
        return f.e(context.getResources(), i2, context.getTheme());
    }

    public static Drawable f(Context context, int i2) {
        TypedValue typedValue;
        int sDK_INT = Build.VERSION.SDK_INT;
        if (sDK_INT >= 21) {
            return a.c.b(context, i2);
        }
        if (sDK_INT >= 16) {
            return context.getResources().getDrawable(i2);
        }
        Object obj = a.a;
        synchronized (obj) {
            typedValue = new TypedValue();
            a.c = typedValue;
            context.getResources().getValue(i2, a.c, true);
            return context.getResources().getDrawable(obj5.resourceId);
        }
    }

    public static File[] g(Context context) {
        if (Build.VERSION.SDK_INT >= 19) {
            return a.b.a(context);
        }
        File[] arr = new File[1];
        return arr;
    }

    public static File[] h(Context context, String string2) {
        if (Build.VERSION.SDK_INT >= 19) {
            return a.b.b(context, string2);
        }
        File[] arr = new File[1];
        return arr;
    }

    public static Executor i(Context context) {
        if (Build.VERSION.SDK_INT >= 28) {
            return a.f.a(context);
        }
        Handler handler = new Handler(context.getMainLooper());
        return d.a(handler);
    }

    public static File j(Context context) {
        if (Build.VERSION.SDK_INT >= 21) {
            return a.c.c(context);
        }
        File file = new File(obj2.dataDir, "no_backup");
        a.c(file);
        return file;
    }

    public static <T> T k(Context context, Class<T> class2) {
        Object obj2;
        if (Build.VERSION.SDK_INT >= 23) {
            return a.d.c(context, class2);
        }
        final String obj3 = a.l(context, class2);
        if (obj3 != null) {
            obj2 = context.getSystemService(obj3);
        } else {
            obj2 = 0;
        }
        return obj2;
    }

    public static String l(Context context, Class<?> class2) {
        if (Build.VERSION.SDK_INT >= 23) {
            return a.d.d(context, class2);
        }
        return (String)a.g.a.get(class2);
    }

    public static boolean m(Context context, Intent[] intent2Arr2, Bundle bundle3) {
        if (Build.VERSION.SDK_INT >= 16) {
            a.a.a(context, intent2Arr2, bundle3);
        } else {
            context.startActivities(intent2Arr2);
        }
        return 1;
    }

    public static void n(Context context, Intent intent2, Bundle bundle3) {
        if (Build.VERSION.SDK_INT >= 16) {
            a.a.b(context, intent2, bundle3);
        } else {
            context.startActivity(intent2);
        }
    }
}
