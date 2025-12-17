package androidx.core.content;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.hardware.display.DisplayManager;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Process;
import android.text.TextUtils;
import android.util.Log;
import android.view.Display;
import android.view.WindowManager;
import androidx.annotation.ReplaceWith;
import androidx.core.app.LocaleManagerCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.os.ConfigurationCompat;
import androidx.core.os.LocaleListCompat;
import androidx.core.util.ObjectsCompat;
import java.io.File;
import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.HashMap;
import java.util.concurrent.Executor;

/* loaded from: classes5.dex */
public class ContextCompat {

    private static final String DYNAMIC_RECEIVER_NOT_EXPORTED_PERMISSION_SUFFIX = ".DYNAMIC_RECEIVER_NOT_EXPORTED_PERMISSION";
    public static final int RECEIVER_EXPORTED = 2;
    public static final int RECEIVER_NOT_EXPORTED = 4;
    public static final int RECEIVER_VISIBLE_TO_INSTANT_APPS = 1;
    private static final String TAG = "ContextCompat";
    private static final Object sSync;

    static class Api21Impl {
        static File getCodeCacheDir(Context obj) {
            return obj.getCodeCacheDir();
        }

        static Drawable getDrawable(Context obj, int id) {
            return obj.getDrawable(id);
        }

        static File getNoBackupFilesDir(Context obj) {
            return obj.getNoBackupFilesDir();
        }
    }

    static class Api23Impl {
        static int getColor(Context obj, int id) {
            return obj.getColor(id);
        }

        static <T> T getSystemService(Context obj, Class<T> class2) {
            return obj.getSystemService(class2);
        }

        static String getSystemServiceName(Context obj, Class<?> class2) {
            return obj.getSystemServiceName(class2);
        }
    }

    static class Api24Impl {
        static Context createDeviceProtectedStorageContext(Context obj) {
            return obj.createDeviceProtectedStorageContext();
        }

        static File getDataDir(Context obj) {
            return obj.getDataDir();
        }

        static boolean isDeviceProtectedStorage(Context obj) {
            return obj.isDeviceProtectedStorage();
        }
    }

    static class Api26Impl {
        static Intent registerReceiver(Context obj, BroadcastReceiver receiver, IntentFilter filter, String broadcastPermission, Handler scheduler, int flags) {
            if (flags & 4 != 0 && broadcastPermission == null) {
                if (broadcastPermission == null) {
                    return obj.registerReceiver(receiver, filter, ContextCompat.obtainAndCheckReceiverPermission(obj), scheduler);
                }
            }
            return obj.registerReceiver(receiver, filter, broadcastPermission, scheduler, flags &= 1);
        }

        static ComponentName startForegroundService(Context obj, Intent service) {
            return obj.startForegroundService(service);
        }
    }

    static class Api28Impl {
        static Executor getMainExecutor(Context obj) {
            return obj.getMainExecutor();
        }
    }

    static class Api30Impl {
        static Context createAttributionContext(Context context, String attributionTag) {
            return context.createAttributionContext(attributionTag);
        }

        static String getAttributionTag(Context obj) {
            return obj.getAttributionTag();
        }

        static Display getDisplayOrDefault(Context obj) {
            try {
                return obj.getDisplay();
                StringBuilder display2 = new StringBuilder();
                String str = "The context:";
                display2 = display2.append(str);
                display2 = display2.append(obj);
                str = " is not associated with any display. Return a fallback display instead.";
                display2 = display2.append(str);
                display2 = display2.toString();
                str = "ContextCompat";
                Log.w(str, display2);
                display2 = DisplayManager.class;
                display2 = obj.getSystemService(display2);
                str = null;
                display2 = (DisplayManager)display2.getDisplay(str);
                return display2;
            }
        }
    }

    static class Api33Impl {
        static Intent registerReceiver(Context obj, BroadcastReceiver receiver, IntentFilter filter, String broadcastPermission, Handler scheduler, int flags) {
            return obj.registerReceiver(receiver, filter, broadcastPermission, scheduler, flags);
        }
    }

    private static final class LegacyServiceMapHolder {

        static final HashMap<Class<?>, String> SERVICES;
        static {
            HashMap hashMap = new HashMap();
            ContextCompat.LegacyServiceMapHolder.SERVICES = hashMap;
            ContextCompat.LegacyServiceMapHolder.SERVICES.put(SubscriptionManager.class, "telephony_subscription_service");
            ContextCompat.LegacyServiceMapHolder.SERVICES.put(UsageStatsManager.class, "usagestats");
            ContextCompat.LegacyServiceMapHolder.SERVICES.put(AppWidgetManager.class, "appwidget");
            ContextCompat.LegacyServiceMapHolder.SERVICES.put(BatteryManager.class, "batterymanager");
            ContextCompat.LegacyServiceMapHolder.SERVICES.put(CameraManager.class, "camera");
            ContextCompat.LegacyServiceMapHolder.SERVICES.put(JobScheduler.class, "jobscheduler");
            ContextCompat.LegacyServiceMapHolder.SERVICES.put(LauncherApps.class, "launcherapps");
            ContextCompat.LegacyServiceMapHolder.SERVICES.put(MediaProjectionManager.class, "media_projection");
            ContextCompat.LegacyServiceMapHolder.SERVICES.put(MediaSessionManager.class, "media_session");
            ContextCompat.LegacyServiceMapHolder.SERVICES.put(RestrictionsManager.class, "restrictions");
            ContextCompat.LegacyServiceMapHolder.SERVICES.put(TelecomManager.class, "telecom");
            ContextCompat.LegacyServiceMapHolder.SERVICES.put(TvInputManager.class, "tv_input");
            ContextCompat.LegacyServiceMapHolder.SERVICES.put(AppOpsManager.class, "appops");
            ContextCompat.LegacyServiceMapHolder.SERVICES.put(CaptioningManager.class, "captioning");
            ContextCompat.LegacyServiceMapHolder.SERVICES.put(ConsumerIrManager.class, "consumer_ir");
            ContextCompat.LegacyServiceMapHolder.SERVICES.put(PrintManager.class, "print");
            ContextCompat.LegacyServiceMapHolder.SERVICES.put(BluetoothManager.class, "bluetooth");
            ContextCompat.LegacyServiceMapHolder.SERVICES.put(DisplayManager.class, "display");
            ContextCompat.LegacyServiceMapHolder.SERVICES.put(UserManager.class, "user");
            ContextCompat.LegacyServiceMapHolder.SERVICES.put(InputManager.class, "input");
            ContextCompat.LegacyServiceMapHolder.SERVICES.put(MediaRouter.class, "media_router");
            ContextCompat.LegacyServiceMapHolder.SERVICES.put(NsdManager.class, "servicediscovery");
            ContextCompat.LegacyServiceMapHolder.SERVICES.put(AccessibilityManager.class, "accessibility");
            ContextCompat.LegacyServiceMapHolder.SERVICES.put(AccountManager.class, "account");
            ContextCompat.LegacyServiceMapHolder.SERVICES.put(ActivityManager.class, "activity");
            ContextCompat.LegacyServiceMapHolder.SERVICES.put(AlarmManager.class, "alarm");
            ContextCompat.LegacyServiceMapHolder.SERVICES.put(AudioManager.class, "audio");
            ContextCompat.LegacyServiceMapHolder.SERVICES.put(ClipboardManager.class, "clipboard");
            ContextCompat.LegacyServiceMapHolder.SERVICES.put(ConnectivityManager.class, "connectivity");
            ContextCompat.LegacyServiceMapHolder.SERVICES.put(DevicePolicyManager.class, "device_policy");
            ContextCompat.LegacyServiceMapHolder.SERVICES.put(DownloadManager.class, "download");
            ContextCompat.LegacyServiceMapHolder.SERVICES.put(DropBoxManager.class, "dropbox");
            ContextCompat.LegacyServiceMapHolder.SERVICES.put(InputMethodManager.class, "input_method");
            ContextCompat.LegacyServiceMapHolder.SERVICES.put(KeyguardManager.class, "keyguard");
            ContextCompat.LegacyServiceMapHolder.SERVICES.put(LayoutInflater.class, "layout_inflater");
            ContextCompat.LegacyServiceMapHolder.SERVICES.put(LocationManager.class, "location");
            ContextCompat.LegacyServiceMapHolder.SERVICES.put(NfcManager.class, "nfc");
            ContextCompat.LegacyServiceMapHolder.SERVICES.put(NotificationManager.class, "notification");
            ContextCompat.LegacyServiceMapHolder.SERVICES.put(PowerManager.class, "power");
            ContextCompat.LegacyServiceMapHolder.SERVICES.put(SearchManager.class, "search");
            ContextCompat.LegacyServiceMapHolder.SERVICES.put(SensorManager.class, "sensor");
            ContextCompat.LegacyServiceMapHolder.SERVICES.put(StorageManager.class, "storage");
            ContextCompat.LegacyServiceMapHolder.SERVICES.put(TelephonyManager.class, "phone");
            ContextCompat.LegacyServiceMapHolder.SERVICES.put(TextServicesManager.class, "textservices");
            ContextCompat.LegacyServiceMapHolder.SERVICES.put(UiModeManager.class, "uimode");
            ContextCompat.LegacyServiceMapHolder.SERVICES.put(UsbManager.class, "usb");
            ContextCompat.LegacyServiceMapHolder.SERVICES.put(Vibrator.class, "vibrator");
            ContextCompat.LegacyServiceMapHolder.SERVICES.put(WallpaperManager.class, "wallpaper");
            ContextCompat.LegacyServiceMapHolder.SERVICES.put(WifiP2pManager.class, "wifip2p");
            ContextCompat.LegacyServiceMapHolder.SERVICES.put(WifiManager.class, "wifi");
            ContextCompat.LegacyServiceMapHolder.SERVICES.put(WindowManager.class, "window");
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface RegisterReceiverFlags {
    }
    static {
        Object object = new Object();
        ContextCompat.sSync = object;
    }

    public static int checkSelfPermission(Context context, String permission) {
        int i;
        int sDK_INT;
        ObjectsCompat.requireNonNull(permission, "permission must be non-null");
        if (Build.VERSION.SDK_INT < 33 && TextUtils.equals("android.permission.POST_NOTIFICATIONS", permission)) {
            if (TextUtils.equals("android.permission.POST_NOTIFICATIONS", permission)) {
                i = NotificationManagerCompat.from(context).areNotificationsEnabled() ? 0 : -1;
                return i;
            }
        }
        return context.checkPermission(permission, Process.myPid(), Process.myUid());
    }

    public static Context createAttributionContext(Context context, String attributionTag) {
        if (Build.VERSION.SDK_INT >= 30) {
            return ContextCompat.Api30Impl.createAttributionContext(context, attributionTag);
        }
        return context;
    }

    public static Context createDeviceProtectedStorageContext(Context context) {
        return ContextCompat.Api24Impl.createDeviceProtectedStorageContext(context);
    }

    private static File createFilesDir(File file) {
        boolean exists;
        String string;
        String path;
        final Object sSync = ContextCompat.sSync;
        synchronized (sSync) {
            if (file.mkdirs() != null) {
                return file;
            }
            try {
                StringBuilder stringBuilder = new StringBuilder();
                Log.w("ContextCompat", stringBuilder.append("Unable to create files subdir ").append(file.getPath()).toString());
                return file;
                throw th;
            }
        }
    }

    public static String getAttributionTag(Context context) {
        if (Build.VERSION.SDK_INT >= 30) {
            return ContextCompat.Api30Impl.getAttributionTag(context);
        }
        return null;
    }

    public static File getCodeCacheDir(Context context) {
        return ContextCompat.Api21Impl.getCodeCacheDir(context);
    }

    public static int getColor(Context context, int id) {
        return ContextCompat.Api23Impl.getColor(context, id);
    }

    public static ColorStateList getColorStateList(Context context, int id) {
        return ResourcesCompat.getColorStateList(context.getResources(), id, context.getTheme());
    }

    public static Context getContextForLanguage(Context context) {
        int sDK_INT;
        final LocaleListCompat applicationLocales = LocaleManagerCompat.getApplicationLocales(context);
        if (Build.VERSION.SDK_INT <= 32 && !applicationLocales.isEmpty()) {
            if (!applicationLocales.isEmpty()) {
                Configuration configuration = new Configuration(context.getResources().getConfiguration());
                ConfigurationCompat.setLocales(configuration, applicationLocales);
                return context.createConfigurationContext(configuration);
            }
        }
        return context;
    }

    public static File getDataDir(Context context) {
        return ContextCompat.Api24Impl.getDataDir(context);
    }

    public static Display getDisplayOrDefault(Context context) {
        if (Build.VERSION.SDK_INT >= 30) {
            return ContextCompat.Api30Impl.getDisplayOrDefault(context);
        }
        return (WindowManager)context.getSystemService("window").getDefaultDisplay();
    }

    public static Drawable getDrawable(Context context, int id) {
        return ContextCompat.Api21Impl.getDrawable(context, id);
    }

    @ReplaceWith(expression = "context.getExternalCacheDirs()")
    @Deprecated
    public static File[] getExternalCacheDirs(Context context) {
        return context.getExternalCacheDirs();
    }

    @ReplaceWith(expression = "context.getExternalFilesDirs(type)")
    @Deprecated
    public static File[] getExternalFilesDirs(Context context, String type) {
        return context.getExternalFilesDirs(type);
    }

    public static Executor getMainExecutor(Context context) {
        return ContextCompat.Api28Impl.getMainExecutor(context);
    }

    public static File getNoBackupFilesDir(Context context) {
        return ContextCompat.Api21Impl.getNoBackupFilesDir(context);
    }

    @ReplaceWith(expression = "context.getObbDirs()")
    @Deprecated
    public static File[] getObbDirs(Context context) {
        return context.getObbDirs();
    }

    public static String getString(Context context, int resId) {
        return ContextCompat.getContextForLanguage(context).getString(resId);
    }

    public static <T> T getSystemService(Context context, Class<T> class2) {
        return ContextCompat.Api23Impl.getSystemService(context, class2);
    }

    public static String getSystemServiceName(Context context, Class<?> class2) {
        return ContextCompat.Api23Impl.getSystemServiceName(context, class2);
    }

    public static boolean isDeviceProtectedStorage(Context context) {
        return ContextCompat.Api24Impl.isDeviceProtectedStorage(context);
    }

    static String obtainAndCheckReceiverPermission(Context obj) {
        StringBuilder stringBuilder = new StringBuilder();
        String str = ".DYNAMIC_RECEIVER_NOT_EXPORTED_PERMISSION";
        String string = stringBuilder.append(obj.getApplicationContext().getPackageName()).append(str).toString();
        if (PermissionChecker.checkSelfPermission(obj, string) != 0) {
            StringBuilder stringBuilder2 = new StringBuilder();
            String permission = stringBuilder2.append(obj.getOpPackageName()).append(str).toString();
            if (PermissionChecker.checkSelfPermission(obj, permission) != 0) {
            } else {
                return permission;
            }
            StringBuilder stringBuilder3 = new StringBuilder();
            RuntimeException runtimeException = new RuntimeException(stringBuilder3.append("Permission ").append(permission).append(" is required by your application to receive broadcasts, please add it to your manifest").toString());
            throw runtimeException;
        }
        return string;
    }

    public static Intent registerReceiver(Context context, BroadcastReceiver receiver, IntentFilter filter, int flags) {
        return ContextCompat.registerReceiver(context, receiver, filter, 0, 0, flags);
    }

    public static Intent registerReceiver(Context context, BroadcastReceiver receiver, IntentFilter filter, String broadcastPermission, Handler scheduler, int flags) {
        int i;
        int i2;
        int obj11;
        if (flags & 1 != 0) {
            if (flags & 4 != 0) {
            } else {
            }
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Cannot specify both RECEIVER_VISIBLE_TO_INSTANT_APPS and RECEIVER_NOT_EXPORTED");
            throw illegalArgumentException;
        }
        i2 = flags & 1 != 0 ? obj11 : flags;
        if (i2 & 2 == 0) {
            if (i2 & 4 == 0) {
            } else {
            }
            obj11 = new IllegalArgumentException("One of either RECEIVER_EXPORTED or RECEIVER_NOT_EXPORTED is required");
            throw obj11;
        }
        if (i2 & 2 != 0) {
            if (i2 & 4 != 0) {
            } else {
            }
            obj11 = new IllegalArgumentException("Cannot specify both RECEIVER_EXPORTED and RECEIVER_NOT_EXPORTED");
            throw obj11;
        }
        if (Build.VERSION.SDK_INT >= 33) {
            return ContextCompat.Api33Impl.registerReceiver(context, receiver, filter, broadcastPermission, scheduler, i2);
        }
        return ContextCompat.Api26Impl.registerReceiver(context, receiver, filter, broadcastPermission, scheduler, i2);
    }

    public static boolean startActivities(Context context, Intent[] intents) {
        return ContextCompat.startActivities(context, intents, 0);
    }

    public static boolean startActivities(Context context, Intent[] intents, Bundle options) {
        context.startActivities(intents, options);
        return 1;
    }

    @ReplaceWith(expression = "context.startActivity(intent, options)")
    @Deprecated
    public static void startActivity(Context context, Intent intent, Bundle options) {
        context.startActivity(intent, options);
    }

    public static void startForegroundService(Context context, Intent intent) {
        ContextCompat.Api26Impl.startForegroundService(context, intent);
    }
}
