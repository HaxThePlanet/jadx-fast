package androidx.core.content;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Binder;
import android.os.Process;
import androidx.core.app.AppOpsManagerCompat;
import androidx.core.util.ObjectsCompat;
import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* loaded from: classes5.dex */
public final class PermissionChecker {

    public static final int PERMISSION_DENIED = -1;
    public static final int PERMISSION_DENIED_APP_OP = -2;
    public static final int PERMISSION_GRANTED;

    @Retention(RetentionPolicy.SOURCE)
    public @interface PermissionResult {
    }
    public static int checkCallingOrSelfPermission(Context context, String permission) {
        String packageName;
        if (Binder.getCallingPid() == Process.myPid()) {
            packageName = context.getPackageName();
        } else {
            packageName = 0;
        }
        return PermissionChecker.checkPermission(context, permission, Binder.getCallingPid(), Binder.getCallingUid(), packageName);
    }

    public static int checkCallingPermission(Context context, String permission, String packageName) {
        if (Binder.getCallingPid() == Process.myPid()) {
            return -1;
        }
        return PermissionChecker.checkPermission(context, permission, Binder.getCallingPid(), Binder.getCallingUid(), packageName);
    }

    public static int checkPermission(Context context, String permission, int pid, int uid, String packageName) {
        int i;
        String[] packagesForUid;
        int equals;
        int i2;
        int checkOrNoteProxyOp;
        String obj10;
        int i3 = -1;
        if (context.checkPermission(permission, pid, uid) == i3) {
            return i3;
        }
        String permissionToOp = AppOpsManagerCompat.permissionToOp(permission);
        i = 0;
        if (permissionToOp == null) {
            return i;
        }
        packagesForUid = context.getPackageManager().getPackagesForUid(uid);
        if (packageName == null && packagesForUid != null && packagesForUid.length <= 0) {
            packagesForUid = context.getPackageManager().getPackagesForUid(uid);
            if (packagesForUid != null) {
                if (packagesForUid.length <= 0) {
                }
                obj10 = packagesForUid[i];
            }
            return i3;
        }
        if (Process.myUid() == uid && ObjectsCompat.equals(context.getPackageName(), obj10)) {
            i2 = ObjectsCompat.equals(packageName2, obj10) ? 1 : i;
        } else {
        }
        if (i2 != 0) {
            checkOrNoteProxyOp = AppOpsManagerCompat.checkOrNoteProxyOp(context, uid, permissionToOp, obj10);
        } else {
            checkOrNoteProxyOp = AppOpsManagerCompat.noteProxyOpNoThrow(context, permissionToOp, obj10);
        }
        if (checkOrNoteProxyOp == 0) {
        } else {
            i = -2;
        }
        return i;
    }

    public static int checkSelfPermission(Context context, String permission) {
        return PermissionChecker.checkPermission(context, permission, Process.myPid(), Process.myUid(), context.getPackageName());
    }
}
