package androidx.core.content.pm;

import android.content.pm.PermissionInfo;
import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* loaded from: classes5.dex */
public final class PermissionInfoCompat {

    static class Api28Impl {
        static int getProtection(PermissionInfo permissionInfo) {
            return permissionInfo.getProtection();
        }

        static int getProtectionFlags(PermissionInfo permissionInfo) {
            return permissionInfo.getProtectionFlags();
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface Protection {
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface ProtectionFlags {
    }
    public static int getProtection(PermissionInfo permissionInfo) {
        return PermissionInfoCompat.Api28Impl.getProtection(permissionInfo);
    }

    public static int getProtectionFlags(PermissionInfo permissionInfo) {
        return PermissionInfoCompat.Api28Impl.getProtectionFlags(permissionInfo);
    }
}
