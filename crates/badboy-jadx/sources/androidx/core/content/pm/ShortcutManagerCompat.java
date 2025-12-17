package androidx.core.content.pm;

import android.app.ActivityManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.content.IntentSender.SendIntentException;
import android.content.pm.PackageManager;
import android.content.pm.ShortcutInfo;
import android.content.pm.ShortcutManager;
import android.content.res.Resources;
import android.graphics.BitmapFactory;
import android.os.Build.VERSION;
import android.os.Bundle;
import androidx.core.graphics.drawable.IconCompat;
import androidx.core.util.Preconditions;
import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

/* loaded from: classes5.dex */
public class ShortcutManagerCompat {

    static final String ACTION_INSTALL_SHORTCUT = "com.android.launcher.action.INSTALL_SHORTCUT";
    private static final int DEFAULT_MAX_ICON_DIMENSION_DP = 96;
    private static final int DEFAULT_MAX_ICON_DIMENSION_LOWRAM_DP = 48;
    public static final String EXTRA_SHORTCUT_ID = "android.intent.extra.shortcut.ID";
    public static final int FLAG_MATCH_CACHED = 8;
    public static final int FLAG_MATCH_DYNAMIC = 2;
    public static final int FLAG_MATCH_MANIFEST = 1;
    public static final int FLAG_MATCH_PINNED = 4;
    static final String INSTALL_SHORTCUT_PERMISSION = "com.android.launcher.permission.INSTALL_SHORTCUT";
    private static final String SHORTCUT_LISTENER_INTENT_FILTER_ACTION = "androidx.core.content.pm.SHORTCUT_LISTENER";
    private static final String SHORTCUT_LISTENER_META_DATA_KEY = "androidx.core.content.pm.shortcut_listener_impl";
    private static volatile List<androidx.core.content.pm.ShortcutInfoChangeListener> sShortcutInfoChangeListeners;
    private static volatile androidx.core.content.pm.ShortcutInfoCompatSaver<?> sShortcutInfoCompatSaver;

    private static class Api25Impl {
        static String getShortcutInfoWithLowestRank(List<ShortcutInfo> list) {
            int rank2;
            int target;
            Object next;
            int rank;
            rank2 = -1;
            target = 0;
            final Iterator iterator = list.iterator();
            while (iterator.hasNext()) {
                next = iterator.next();
                if ((ShortcutInfo)next.getRank() > rank2) {
                }
                target = next.getId();
                rank2 = next.getRank();
            }
            return target;
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface ShortcutMatchFlags {
    }
    static {
        final int i = 0;
        ShortcutManagerCompat.sShortcutInfoCompatSaver = i;
        ShortcutManagerCompat.sShortcutInfoChangeListeners = i;
    }

    public static boolean addDynamicShortcuts(Context context, List<androidx.core.content.pm.ShortcutInfoCompat> list2) {
        boolean dynamicShortcuts;
        Object next;
        ShortcutInfo shortcutInfo;
        int i = 1;
        final List shortcutsExcludedFromSurface = ShortcutManagerCompat.removeShortcutsExcludedFromSurface(list2, i);
        if (Build.VERSION.SDK_INT <= 29) {
            ShortcutManagerCompat.convertUriIconsToBitmapIcons(context, shortcutsExcludedFromSurface);
        }
        ArrayList arrayList = new ArrayList();
        Iterator iterator2 = shortcutsExcludedFromSurface.iterator();
        for (ShortcutInfoCompat next : iterator2) {
            arrayList.add(next.toShortcutInfo());
        }
        if (!(ShortcutManager)context.getSystemService(ShortcutManager.class).addDynamicShortcuts(arrayList)) {
            return 0;
        }
        ShortcutManagerCompat.getShortcutInfoSaverInstance(context).addShortcuts(shortcutsExcludedFromSurface);
        Iterator iterator = ShortcutManagerCompat.getShortcutInfoListeners(context).iterator();
        for (ShortcutInfoChangeListener dynamicShortcuts : iterator) {
            dynamicShortcuts.onShortcutAdded(list2);
        }
        return i;
    }

    static boolean convertUriIconToBitmapIcon(Context context, androidx.core.content.pm.ShortcutInfoCompat info) {
        IconCompat withAdaptiveBitmap;
        int i;
        int i2 = 0;
        if (info.mIcon == null) {
            return i2;
        }
        int mType = mIcon2.mType;
        final int i3 = 1;
        final int i4 = 6;
        if (mType != i4 && mType != 4) {
            if (mType != 4) {
                return i3;
            }
        }
        java.io.InputStream uriInputStream = info.mIcon.getUriInputStream(context);
        if (uriInputStream == null) {
            return i2;
        }
        final android.graphics.Bitmap decodeStream = BitmapFactory.decodeStream(uriInputStream);
        if (decodeStream == null) {
            return i2;
        }
        if (mType == i4) {
            withAdaptiveBitmap = IconCompat.createWithAdaptiveBitmap(decodeStream);
        } else {
            withAdaptiveBitmap = IconCompat.createWithBitmap(decodeStream);
        }
        info.mIcon = withAdaptiveBitmap;
        return i3;
    }

    static void convertUriIconsToBitmapIcons(Context context, List<androidx.core.content.pm.ShortcutInfoCompat> list2) {
        Object next;
        boolean convertUriIconToBitmapIcon;
        ArrayList arrayList = new ArrayList(list2);
        final Iterator iterator = arrayList.iterator();
        while (iterator.hasNext()) {
            next = iterator.next();
            if (!ShortcutManagerCompat.convertUriIconToBitmapIcon(context, (ShortcutInfoCompat)next)) {
            }
            list2.remove(next);
        }
    }

    public static Intent createShortcutResultIntent(Context context, androidx.core.content.pm.ShortcutInfoCompat shortcut) {
        Intent result;
        Object systemService;
        int i = 0;
        if ((ShortcutManager)context.getSystemService(ShortcutManager.class).createShortcutResultIntent(shortcut.toShortcutInfo()) == null) {
            systemService = new Intent();
            result = systemService;
        }
        return shortcut.addToIntent(result);
    }

    public static void disableShortcuts(Context context, List<String> list2, java.lang.CharSequence disabledMessage) {
        Object next;
        (ShortcutManager)context.getSystemService(ShortcutManager.class).disableShortcuts(list2, disabledMessage);
        ShortcutManagerCompat.getShortcutInfoSaverInstance(context).removeShortcuts(list2);
        Iterator iterator = ShortcutManagerCompat.getShortcutInfoListeners(context).iterator();
        for (ShortcutInfoChangeListener next : iterator) {
            next.onShortcutRemoved(list2);
        }
    }

    public static void enableShortcuts(Context context, List<androidx.core.content.pm.ShortcutInfoCompat> list2) {
        Object systemService;
        Object next;
        String mId;
        List shortcutsExcludedFromSurface = ShortcutManagerCompat.removeShortcutsExcludedFromSurface(list2, 1);
        ArrayList arrayList = new ArrayList(list2.size());
        Iterator iterator2 = shortcutsExcludedFromSurface.iterator();
        for (ShortcutInfoCompat next : iterator2) {
            arrayList.add(next.mId);
        }
        (ShortcutManager)context.getSystemService(ShortcutManager.class).enableShortcuts(arrayList);
        ShortcutManagerCompat.getShortcutInfoSaverInstance(context).addShortcuts(shortcutsExcludedFromSurface);
        Iterator iterator = ShortcutManagerCompat.getShortcutInfoListeners(context).iterator();
        for (ShortcutInfoChangeListener systemService : iterator) {
            systemService.onShortcutAdded(list2);
        }
    }

    public static List<androidx.core.content.pm.ShortcutInfoCompat> getDynamicShortcuts(Context context) {
        Object next;
        androidx.core.content.pm.ShortcutInfoCompat build;
        List dynamicShortcuts = (ShortcutManager)context.getSystemService(ShortcutManager.class).getDynamicShortcuts();
        ArrayList arrayList = new ArrayList(dynamicShortcuts.size());
        Iterator iterator = dynamicShortcuts.iterator();
        for (ShortcutInfo next : iterator) {
            ShortcutInfoCompat.Builder builder = new ShortcutInfoCompat.Builder(context, next);
            arrayList.add(builder.build());
        }
        return arrayList;
    }

    private static int getIconDimensionInternal(Context context, boolean isHorizontal) {
        int i2;
        boolean lowRamDevice;
        int i;
        float ydpi;
        Object systemService = context.getSystemService("activity");
        int i3 = 1;
        if ((ActivityManager)systemService != null) {
            if ((ActivityManager)systemService.isLowRamDevice()) {
                i2 = i3;
            } else {
                i2 = 0;
            }
        } else {
        }
        i = i2 != 0 ? 48 : 96;
        android.util.DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        ydpi = isHorizontal ? displayMetrics.xdpi : displayMetrics.ydpi;
        return (int)i7;
    }

    public static int getIconMaxHeight(Context context) {
        Preconditions.checkNotNull(context);
        return (ShortcutManager)context.getSystemService(ShortcutManager.class).getIconMaxHeight();
    }

    public static int getIconMaxWidth(Context context) {
        Preconditions.checkNotNull(context);
        return (ShortcutManager)context.getSystemService(ShortcutManager.class).getIconMaxWidth();
    }

    public static int getMaxShortcutCountPerActivity(Context context) {
        Preconditions.checkNotNull(context);
        return (ShortcutManager)context.getSystemService(ShortcutManager.class).getMaxShortcutCountPerActivity();
    }

    static List<androidx.core.content.pm.ShortcutInfoChangeListener> getShortcutInfoChangeListeners() {
        return ShortcutManagerCompat.sShortcutInfoChangeListeners;
    }

    private static String getShortcutInfoCompatWithLowestRank(List<androidx.core.content.pm.ShortcutInfoCompat> list) {
        int rank2;
        int target;
        Object next;
        int rank;
        rank2 = -1;
        target = 0;
        final Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            next = iterator.next();
            if ((ShortcutInfoCompat)next.getRank() > rank2) {
            }
            target = next.getId();
            rank2 = next.getRank();
        }
        return target;
    }

    private static List<androidx.core.content.pm.ShortcutInfoChangeListener> getShortcutInfoListeners(Context context) {
        Object sShortcutInfoChangeListeners;
        List packageManager;
        Intent intent;
        List intentActivities;
        Iterator iterator;
        boolean next;
        android.content.pm.ActivityInfo activityInfo;
        Bundle metaData;
        String string;
        Object classLoader;
        Method method;
        Class forName;
        Object invoke;
        int i;
        Class<Context> obj;
        if (ShortcutManagerCompat.sShortcutInfoChangeListeners == null) {
            sShortcutInfoChangeListeners = new ArrayList();
            intent = new Intent("androidx.core.content.pm.SHORTCUT_LISTENER");
            intent.setPackage(context.getPackageName());
            iterator = context.getPackageManager().queryIntentActivities(intent, 128).iterator();
            while (iterator.hasNext()) {
                activityInfo = next.activityInfo;
                if (activityInfo == null) {
                } else {
                }
                metaData = activityInfo.metaData;
                if (metaData == null) {
                } else {
                }
                string = metaData.getString("androidx.core.content.pm.shortcut_listener_impl");
                if (string == null) {
                } else {
                }
                int i3 = 0;
                Class[] arr2 = new Class[1];
                arr2[i3] = Context.class;
                sShortcutInfoChangeListeners.add((ShortcutInfoChangeListener)Class.forName(string, i3, ShortcutManagerCompat.class.getClassLoader()).getMethod("getInstance", arr2).invoke(0, /* result */));
            }
            if (ShortcutManagerCompat.sShortcutInfoChangeListeners == null) {
                ShortcutManagerCompat.sShortcutInfoChangeListeners = sShortcutInfoChangeListeners;
            }
        }
        return ShortcutManagerCompat.sShortcutInfoChangeListeners;
    }

    private static androidx.core.content.pm.ShortcutInfoCompatSaver<?> getShortcutInfoSaverInstance(Context context) {
        java.lang.ClassLoader classLoader;
        androidx.core.content.pm.ShortcutInfoCompatSaver sShortcutInfoCompatSaver;
        Class forName;
        Method method;
        Object invoke;
        int i;
        Class<Context> obj;
        if (ShortcutManagerCompat.sShortcutInfoCompatSaver == null) {
            int i2 = 0;
            Class[] arr2 = new Class[1];
            arr2[i2] = Context.class;
            ShortcutManagerCompat.sShortcutInfoCompatSaver = (ShortcutInfoCompatSaver)Class.forName("androidx.sharetarget.ShortcutInfoCompatSaverImpl", i2, ShortcutManagerCompat.class.getClassLoader()).getMethod("getInstance", arr2).invoke(0, /* result */);
            if (ShortcutManagerCompat.sShortcutInfoCompatSaver == null) {
                sShortcutInfoCompatSaver = new ShortcutInfoCompatSaver.NoopImpl();
                ShortcutManagerCompat.sShortcutInfoCompatSaver = sShortcutInfoCompatSaver;
            }
        }
        try {
            return ShortcutManagerCompat.sShortcutInfoCompatSaver;
        }
    }

    public static List<androidx.core.content.pm.ShortcutInfoCompat> getShortcuts(Context context, int matchFlags) {
        int manifestShortcuts;
        int dynamicShortcuts;
        int pinnedShortcuts;
        if (Build.VERSION.SDK_INT >= 30) {
            return ShortcutInfoCompat.fromShortcuts(context, (ShortcutManager)context.getSystemService(ShortcutManager.class).getShortcuts(matchFlags));
        }
        Object systemService = context.getSystemService(ShortcutManager.class);
        ArrayList arrayList = new ArrayList();
        if (matchFlags & 1 != 0) {
            arrayList.addAll((ShortcutManager)systemService.getManifestShortcuts());
        }
        if (matchFlags & 2 != 0) {
            arrayList.addAll(systemService.getDynamicShortcuts());
        }
        if (matchFlags & 4 != 0) {
            arrayList.addAll(systemService.getPinnedShortcuts());
        }
        return ShortcutInfoCompat.fromShortcuts(context, arrayList);
    }

    public static boolean isRateLimitingActive(Context context) {
        Preconditions.checkNotNull(context);
        return (ShortcutManager)context.getSystemService(ShortcutManager.class).isRateLimitingActive();
    }

    public static boolean isRequestPinShortcutSupported(Context context) {
        return (ShortcutManager)context.getSystemService(ShortcutManager.class).isRequestPinShortcutSupported();
    }

    public static boolean pushDynamicShortcut(Context context, androidx.core.content.pm.ShortcutInfoCompat shortcut) {
        int excludedFromSurfaces;
        Throwable th;
        int next2;
        List id;
        Object systemService;
        List singletonList;
        boolean next;
        Object dynamicShortcuts;
        List singletonList2;
        int size;
        List list;
        int size2;
        Object shortcutInfoCompatWithLowestRank;
        Preconditions.checkNotNull(context);
        Preconditions.checkNotNull(shortcut);
        final int i2 = 1;
        if (Build.VERSION.SDK_INT <= 32 && shortcut.isExcludedFromSurfaces(i2)) {
            if (shortcut.isExcludedFromSurfaces(i2)) {
                Iterator iterator = ShortcutManagerCompat.getShortcutInfoListeners(context).iterator();
                for (ShortcutInfoChangeListener next2 : iterator) {
                    next2.onShortcutAdded(Collections.singletonList(shortcut));
                }
                return i2;
            }
        }
        int maxShortcutCountPerActivity = ShortcutManagerCompat.getMaxShortcutCountPerActivity(context);
        int i = 0;
        if (maxShortcutCountPerActivity == null) {
            return i;
        }
        if (Build.VERSION.SDK_INT <= 29) {
            ShortcutManagerCompat.convertUriIconToBitmapIcon(context, shortcut);
        }
        if (Build.VERSION.SDK_INT >= 30) {
            (ShortcutManager)context.getSystemService(ShortcutManager.class).pushDynamicShortcut(shortcut.toShortcutInfo());
        } else {
            systemService = context.getSystemService(ShortcutManager.class);
            if ((ShortcutManager)systemService.isRateLimitingActive()) {
                return i;
            }
            dynamicShortcuts = systemService.getDynamicShortcuts();
            if (dynamicShortcuts.size() >= maxShortcutCountPerActivity) {
                String[] strArr2 = new String[i2];
                strArr2[i] = ShortcutManagerCompat.Api25Impl.getShortcutInfoWithLowestRank(dynamicShortcuts);
                systemService.removeDynamicShortcuts(Arrays.asList(strArr2));
            }
            ShortcutInfo[] arr2 = new ShortcutInfo[i2];
            arr2[i] = shortcut.toShortcutInfo();
            systemService.addDynamicShortcuts(Arrays.asList(arr2));
        }
        androidx.core.content.pm.ShortcutInfoCompatSaver shortcutInfoSaverInstance = ShortcutManagerCompat.getShortcutInfoSaverInstance(context);
        List shortcuts = shortcutInfoSaverInstance.getShortcuts();
        if (shortcuts.size() >= maxShortcutCountPerActivity) {
            String[] strArr = new String[i2];
            strArr[i] = ShortcutManagerCompat.getShortcutInfoCompatWithLowestRank(shortcuts);
            shortcutInfoSaverInstance.removeShortcuts(Arrays.asList(strArr));
        }
        androidx.core.content.pm.ShortcutInfoCompat[] arr = new ShortcutInfoCompat[i2];
        arr[i] = shortcut;
        shortcutInfoSaverInstance.addShortcuts(Arrays.asList(arr));
        Iterator iterator2 = ShortcutManagerCompat.getShortcutInfoListeners(context).iterator();
        for (ShortcutInfoChangeListener list : iterator2) {
            list.onShortcutAdded(Collections.singletonList(shortcut));
        }
        ShortcutManagerCompat.reportShortcutUsed(context, shortcut.getId());
        return i2;
    }

    public static void removeAllDynamicShortcuts(Context context) {
        Object next;
        (ShortcutManager)context.getSystemService(ShortcutManager.class).removeAllDynamicShortcuts();
        ShortcutManagerCompat.getShortcutInfoSaverInstance(context).removeAllShortcuts();
        Iterator iterator = ShortcutManagerCompat.getShortcutInfoListeners(context).iterator();
        for (ShortcutInfoChangeListener next : iterator) {
            next.onAllShortcutsRemoved();
        }
    }

    public static void removeDynamicShortcuts(Context context, List<String> list2) {
        Object next;
        (ShortcutManager)context.getSystemService(ShortcutManager.class).removeDynamicShortcuts(list2);
        ShortcutManagerCompat.getShortcutInfoSaverInstance(context).removeShortcuts(list2);
        Iterator iterator = ShortcutManagerCompat.getShortcutInfoListeners(context).iterator();
        for (ShortcutInfoChangeListener next : iterator) {
            next.onShortcutRemoved(list2);
        }
    }

    public static void removeLongLivedShortcuts(Context context, List<String> list2) {
        int next;
        if (Build.VERSION.SDK_INT < 30) {
            ShortcutManagerCompat.removeDynamicShortcuts(context, list2);
        }
        (ShortcutManager)context.getSystemService(ShortcutManager.class).removeLongLivedShortcuts(list2);
        ShortcutManagerCompat.getShortcutInfoSaverInstance(context).removeShortcuts(list2);
        Iterator iterator = ShortcutManagerCompat.getShortcutInfoListeners(context).iterator();
        for (ShortcutInfoChangeListener next : iterator) {
            next.onShortcutRemoved(list2);
        }
    }

    private static List<androidx.core.content.pm.ShortcutInfoCompat> removeShortcutsExcludedFromSurface(List<androidx.core.content.pm.ShortcutInfoCompat> list, int surfaces) {
        Object next;
        boolean excludedFromSurfaces;
        Objects.requireNonNull(list);
        if (Build.VERSION.SDK_INT > 32) {
            return list;
        }
        ArrayList arrayList = new ArrayList(list);
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            next = iterator.next();
            if ((ShortcutInfoCompat)next.isExcludedFromSurfaces(surfaces)) {
            }
            arrayList.remove(next);
        }
        return arrayList;
    }

    public static void reportShortcutUsed(Context context, String shortcutId) {
        Object next;
        List singletonList;
        Preconditions.checkNotNull(context);
        Preconditions.checkNotNull(shortcutId);
        (ShortcutManager)context.getSystemService(ShortcutManager.class).reportShortcutUsed(shortcutId);
        Iterator iterator = ShortcutManagerCompat.getShortcutInfoListeners(context).iterator();
        for (ShortcutInfoChangeListener next : iterator) {
            next.onShortcutUsageReported(Collections.singletonList(shortcutId));
        }
    }

    public static boolean requestPinShortcut(Context context, androidx.core.content.pm.ShortcutInfoCompat shortcut, IntentSender callback) {
        int excludedFromSurfaces;
        if (Build.VERSION.SDK_INT <= 32 && shortcut.isExcludedFromSurfaces(1)) {
            if (shortcut.isExcludedFromSurfaces(1)) {
                return 0;
            }
        }
        return (ShortcutManager)context.getSystemService(ShortcutManager.class).requestPinShortcut(shortcut.toShortcutInfo(), callback);
    }

    public static boolean setDynamicShortcuts(Context context, List<androidx.core.content.pm.ShortcutInfoCompat> list2) {
        boolean dynamicShortcuts;
        Object next;
        ShortcutInfo shortcutInfo;
        Preconditions.checkNotNull(context);
        Preconditions.checkNotNull(list2);
        int i = 1;
        final List shortcutsExcludedFromSurface = ShortcutManagerCompat.removeShortcutsExcludedFromSurface(list2, i);
        ArrayList arrayList = new ArrayList(shortcutsExcludedFromSurface.size());
        Iterator iterator2 = shortcutsExcludedFromSurface.iterator();
        for (ShortcutInfoCompat next : iterator2) {
            arrayList.add(next.toShortcutInfo());
        }
        if (!(ShortcutManager)context.getSystemService(ShortcutManager.class).setDynamicShortcuts(arrayList)) {
            return 0;
        }
        ShortcutManagerCompat.getShortcutInfoSaverInstance(context).removeAllShortcuts();
        ShortcutManagerCompat.getShortcutInfoSaverInstance(context).addShortcuts(shortcutsExcludedFromSurface);
        Iterator iterator = ShortcutManagerCompat.getShortcutInfoListeners(context).iterator();
        for (ShortcutInfoChangeListener dynamicShortcuts : iterator) {
            dynamicShortcuts.onAllShortcutsRemoved();
            dynamicShortcuts.onShortcutAdded(list2);
        }
        return i;
    }

    static void setShortcutInfoChangeListeners(List<androidx.core.content.pm.ShortcutInfoChangeListener> list) {
        ShortcutManagerCompat.sShortcutInfoChangeListeners = list;
    }

    static void setShortcutInfoCompatSaver(androidx.core.content.pm.ShortcutInfoCompatSaver<Void> shortcutInfoCompatSaver) {
        ShortcutManagerCompat.sShortcutInfoCompatSaver = shortcutInfoCompatSaver;
    }

    public static boolean updateShortcuts(Context context, List<androidx.core.content.pm.ShortcutInfoCompat> list2) {
        boolean shortcuts;
        Object next;
        ShortcutInfo shortcutInfo;
        int i = 1;
        final List shortcutsExcludedFromSurface = ShortcutManagerCompat.removeShortcutsExcludedFromSurface(list2, i);
        if (Build.VERSION.SDK_INT <= 29) {
            ShortcutManagerCompat.convertUriIconsToBitmapIcons(context, shortcutsExcludedFromSurface);
        }
        ArrayList arrayList = new ArrayList();
        Iterator iterator2 = shortcutsExcludedFromSurface.iterator();
        for (ShortcutInfoCompat next : iterator2) {
            arrayList.add(next.toShortcutInfo());
        }
        if (!(ShortcutManager)context.getSystemService(ShortcutManager.class).updateShortcuts(arrayList)) {
            return 0;
        }
        ShortcutManagerCompat.getShortcutInfoSaverInstance(context).addShortcuts(shortcutsExcludedFromSurface);
        Iterator iterator = ShortcutManagerCompat.getShortcutInfoListeners(context).iterator();
        for (ShortcutInfoChangeListener shortcuts : iterator) {
            shortcuts.onShortcutUpdated(list2);
        }
        return i;
    }
}
