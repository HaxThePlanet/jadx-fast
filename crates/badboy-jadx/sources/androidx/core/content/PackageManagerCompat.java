package androidx.core.content;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build.VERSION;
import android.util.Log;
import androidx.concurrent.futures.ResolvableFuture;
import androidx.core.os.UserManagerCompat;
import com.google.common.util.concurrent.ListenableFuture;
import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.Executors;

/* loaded from: classes5.dex */
public final class PackageManagerCompat {

    public static final String ACTION_PERMISSION_REVOCATION_SETTINGS = "android.intent.action.AUTO_REVOKE_PERMISSIONS";
    public static final String LOG_TAG = "PackageManagerCompat";

    private static class Api30Impl {
        static boolean areUnusedAppRestrictionsEnabled(Context context) {
            return autoRevokeWhitelisted ^= 1;
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface UnusedAppRestrictionsStatus {
    }
    public static boolean areUnusedAppRestrictionsAvailable(PackageManager packageManager) {
        int i2;
        int i;
        int i3;
        int i4;
        i = 1;
        final int i5 = 0;
        int i6 = 30;
        i2 = Build.VERSION.SDK_INT >= i6 ? i : i5;
        i3 = Build.VERSION.SDK_INT < i6 ? i : i5;
        i4 = PackageManagerCompat.getPermissionRevocationVerifierApp(packageManager) != null ? i : i5;
        if (i2 == 0) {
            if (i3 != 0 && i4 != 0) {
                if (i4 != 0) {
                } else {
                    i = i5;
                }
            } else {
            }
        }
        return i;
    }

    public static String getPermissionRevocationVerifierApp(PackageManager packageManager) {
        int verifierPackageName;
        Object next;
        String packageName;
        int checkPermission;
        Intent intent = new Intent("android.intent.action.AUTO_REVOKE_PERMISSIONS");
        verifierPackageName = 0;
        Iterator iterator = packageManager.queryIntentActivities(intent.setData(Uri.fromParts("package", "com.example", 0)), 0).iterator();
        for (ResolveInfo next : iterator) {
            packageName = activityInfo.packageName;
            verifierPackageName = packageName;
        }
        return verifierPackageName;
    }

    public static ListenableFuture<Integer> getUnusedAppRestrictionsStatus(Context context) {
        Integer valueOf;
        int i;
        final ResolvableFuture create = ResolvableFuture.create();
        String str2 = "PackageManagerCompat";
        Integer valueOf4 = 0;
        if (!UserManagerCompat.isUserUnlocked(context)) {
            create.set(valueOf4);
            Log.e(str2, "User is in locked direct boot mode");
            return create;
        }
        if (!PackageManagerCompat.areUnusedAppRestrictionsAvailable(context.getPackageManager())) {
            create.set(1);
            return create;
        }
        int targetSdkVersion = applicationInfo.targetSdkVersion;
        int i4 = 30;
        if (targetSdkVersion < i4) {
            create.set(valueOf4);
            Log.e(str2, "Target SDK version below API 30");
            return create;
        }
        i = 4;
        final int i5 = 2;
        final int i6 = 31;
        if (Build.VERSION.SDK_INT >= i6) {
            if (PackageManagerCompat.Api30Impl.areUnusedAppRestrictionsEnabled(context)) {
                if (targetSdkVersion >= i6) {
                    i = 5;
                }
                create.set(Integer.valueOf(i));
            } else {
                create.set(Integer.valueOf(i5));
            }
            return create;
        }
        if (Build.VERSION.SDK_INT == i4) {
            if (PackageManagerCompat.Api30Impl.areUnusedAppRestrictionsEnabled(context)) {
            } else {
                i = i5;
            }
            create.set(Integer.valueOf(i));
            return create;
        }
        UnusedAppRestrictionsBackportServiceConnection unusedAppRestrictionsBackportServiceConnection = new UnusedAppRestrictionsBackportServiceConnection(context);
        Objects.requireNonNull(unusedAppRestrictionsBackportServiceConnection);
        PackageManagerCompat$$ExternalSyntheticLambda0 externalSyntheticLambda0 = new PackageManagerCompat$$ExternalSyntheticLambda0(unusedAppRestrictionsBackportServiceConnection);
        create.addListener(externalSyntheticLambda0, Executors.newSingleThreadExecutor());
        unusedAppRestrictionsBackportServiceConnection.connectAndFetchResult(create);
        return create;
    }
}
