package androidx.core.app;

import android.app.AppOpsManager;
import android.content.Context;
import android.os.Binder;

/* loaded from: classes5.dex */
public final class AppOpsManagerCompat {

    public static final int MODE_ALLOWED = 0;
    public static final int MODE_DEFAULT = 3;
    public static final int MODE_ERRORED = 2;
    public static final int MODE_IGNORED = 1;

    static class Api23Impl {
        static <T> T getSystemService(Context context, Class<T> class2) {
            return context.getSystemService(class2);
        }

        static int noteProxyOp(AppOpsManager appOpsManager, String op, String proxiedPackageName) {
            return appOpsManager.noteProxyOp(op, proxiedPackageName);
        }

        static int noteProxyOpNoThrow(AppOpsManager appOpsManager, String op, String proxiedPackageName) {
            return appOpsManager.noteProxyOpNoThrow(op, proxiedPackageName);
        }

        static String permissionToOp(String permission) {
            return AppOpsManager.permissionToOp(permission);
        }
    }

    static class Api29Impl {
        static int checkOpNoThrow(AppOpsManager appOpsManager, String op, int uid, String packageName) {
            if (appOpsManager == null) {
                return 1;
            }
            return appOpsManager.checkOpNoThrow(op, uid, packageName);
        }

        static String getOpPackageName(Context context) {
            return context.getOpPackageName();
        }

        static AppOpsManager getSystemService(Context context) {
            return (AppOpsManager)context.getSystemService(AppOpsManager.class);
        }
    }
    public static int checkOrNoteProxyOp(Context context, int proxyUid, String op, String proxiedPackageName) {
        final AppOpsManager systemService = AppOpsManagerCompat.Api29Impl.getSystemService(context);
        final int checkOpNoThrow = AppOpsManagerCompat.Api29Impl.checkOpNoThrow(systemService, op, Binder.getCallingUid(), proxiedPackageName);
        if (checkOpNoThrow != 0) {
            return checkOpNoThrow;
        }
        return AppOpsManagerCompat.Api29Impl.checkOpNoThrow(systemService, op, proxyUid, AppOpsManagerCompat.Api29Impl.getOpPackageName(context));
    }

    public static int noteOp(Context context, String op, int uid, String packageName) {
        return (AppOpsManager)context.getSystemService("appops").noteOp(op, uid, packageName);
    }

    public static int noteOpNoThrow(Context context, String op, int uid, String packageName) {
        return (AppOpsManager)context.getSystemService("appops").noteOpNoThrow(op, uid, packageName);
    }

    public static int noteProxyOp(Context context, String op, String proxiedPackageName) {
        return AppOpsManagerCompat.Api23Impl.noteProxyOp((AppOpsManager)AppOpsManagerCompat.Api23Impl.getSystemService(context, AppOpsManager.class), op, proxiedPackageName);
    }

    public static int noteProxyOpNoThrow(Context context, String op, String proxiedPackageName) {
        return AppOpsManagerCompat.Api23Impl.noteProxyOpNoThrow((AppOpsManager)AppOpsManagerCompat.Api23Impl.getSystemService(context, AppOpsManager.class), op, proxiedPackageName);
    }

    public static String permissionToOp(String permission) {
        return AppOpsManagerCompat.Api23Impl.permissionToOp(permission);
    }
}
