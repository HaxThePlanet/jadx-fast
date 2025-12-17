package androidx.core.app;

import android.app.Activity;
import android.app.Application;
import android.app.SharedElementCallback;
import android.app.SharedElementCallback.OnSharedElementsReadyListener;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.IntentSender;
import android.content.IntentSender.SendIntentException;
import android.content.pm.PackageManager;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import android.view.Display;
import android.view.DragEvent;
import android.view.View;
import android.view.WindowManager;
import androidx.core.content.ContextCompat;
import androidx.core.content.LocusIdCompat;
import androidx.core.view.DragAndDropPermissionsCompat;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* loaded from: classes5.dex */
public class ActivityCompat extends ContextCompat {

    private static androidx.core.app.ActivityCompat.PermissionCompatDelegate sDelegate;

    static class Api21Impl {
        static void finishAfterTransition(Activity activity) {
            activity.finishAfterTransition();
        }

        static void postponeEnterTransition(Activity activity) {
            activity.postponeEnterTransition();
        }

        static void setEnterSharedElementCallback(Activity activity, SharedElementCallback callback) {
            activity.setEnterSharedElementCallback(callback);
        }

        static void setExitSharedElementCallback(Activity activity, SharedElementCallback callback) {
            activity.setExitSharedElementCallback(callback);
        }

        static void startPostponedEnterTransition(Activity activity) {
            activity.startPostponedEnterTransition();
        }
    }

    static class Api22Impl {
        static Uri getReferrer(Activity activity) {
            return activity.getReferrer();
        }
    }

    static class Api23Impl {
        static void onSharedElementsReady(Object onSharedElementsReadyListener) {
            (SharedElementCallback.OnSharedElementsReadyListener)onSharedElementsReadyListener.onSharedElementsReady();
        }

        static void requestPermissions(Activity activity, String[] permissions, int requestCode) {
            activity.requestPermissions(permissions, requestCode);
        }

        static boolean shouldShowRequestPermissionRationale(Activity activity, String permission) {
            return activity.shouldShowRequestPermissionRationale(permission);
        }
    }

    static class Api28Impl {
        static <T> T requireViewById(Activity activity, int id) {
            return activity.requireViewById(id);
        }
    }

    static class Api30Impl {
        static Display getDisplay(ContextWrapper contextWrapper) {
            return contextWrapper.getDisplay();
        }

        static void setLocusContext(Activity activity, LocusIdCompat locusId, Bundle bundle) {
            int locusId2;
            if (locusId == null) {
                locusId2 = 0;
            } else {
                locusId2 = locusId.toLocusId();
            }
            activity.setLocusContext(locusId2, bundle);
        }
    }

    static class Api31Impl {
        static boolean isLaunchedFromBubble(Activity activity) {
            return activity.isLaunchedFromBubble();
        }

        static boolean shouldShowRequestPermissionRationale(Activity activity, String permission) {
            try {
                Class[] arr2 = new Class[1];
                return (Boolean)PackageManager.class.getMethod("shouldShowRequestPermissionRationale", String.class).invoke(activity.getApplication().getPackageManager(), /* result */).booleanValue();
                return activity.shouldShowRequestPermissionRationale(permission);
            }
        }
    }

    static class Api32Impl {
        static boolean shouldShowRequestPermissionRationale(Activity activity, String permission) {
            return activity.shouldShowRequestPermissionRationale(permission);
        }
    }

    public interface OnRequestPermissionsResultCallback {
        public abstract void onRequestPermissionsResult(int i, String[] string2Arr2, int[] i3Arr3);
    }

    public interface PermissionCompatDelegate {
        public abstract boolean onActivityResult(Activity activity, int i2, int i3, Intent intent4);

        public abstract boolean requestPermissions(Activity activity, String[] string2Arr2, int i3);
    }

    public interface RequestPermissionsRequestCodeValidator {
        public abstract void validateRequestPermissionsRequestCode(int i);
    }

    static class SharedElementCallback21Impl extends SharedElementCallback {

        private final androidx.core.app.SharedElementCallback mCallback;
        SharedElementCallback21Impl(androidx.core.app.SharedElementCallback callback) {
            super();
            this.mCallback = callback;
        }

        static void lambda$onSharedElementsArrived$0(SharedElementCallback.OnSharedElementsReadyListener listener) {
            ActivityCompat.Api23Impl.onSharedElementsReady(listener);
        }

        @Override // android.app.SharedElementCallback
        public Parcelable onCaptureSharedElementSnapshot(View sharedElement, Matrix viewToGlobalMatrix, RectF screenBounds) {
            return this.mCallback.onCaptureSharedElementSnapshot(sharedElement, viewToGlobalMatrix, screenBounds);
        }

        @Override // android.app.SharedElementCallback
        public View onCreateSnapshotView(Context context, Parcelable snapshot) {
            return this.mCallback.onCreateSnapshotView(context, snapshot);
        }

        public void onMapSharedElements(List<String> list, Map<String, View> map2) {
            this.mCallback.onMapSharedElements(list, map2);
        }

        public void onRejectSharedElements(List<View> list) {
            this.mCallback.onRejectSharedElements(list);
        }

        public void onSharedElementEnd(List<String> list, List<View> list2, List<View> list3) {
            this.mCallback.onSharedElementEnd(list, list2, list3);
        }

        public void onSharedElementStart(List<String> list, List<View> list2, List<View> list3) {
            this.mCallback.onSharedElementStart(list, list2, list3);
        }

        public void onSharedElementsArrived(List<String> list, List<View> list2, SharedElementCallback.OnSharedElementsReadyListener listener) {
            ActivityCompat.SharedElementCallback21Impl$$ExternalSyntheticLambda0 externalSyntheticLambda0 = new ActivityCompat.SharedElementCallback21Impl$$ExternalSyntheticLambda0(listener);
            this.mCallback.onSharedElementsArrived(list, list2, externalSyntheticLambda0);
        }
    }
    public static void finishAffinity(Activity activity) {
        activity.finishAffinity();
    }

    public static void finishAfterTransition(Activity activity) {
        ActivityCompat.Api21Impl.finishAfterTransition(activity);
    }

    public static androidx.core.app.ActivityCompat.PermissionCompatDelegate getPermissionCompatDelegate() {
        return ActivityCompat.sDelegate;
    }

    public static Uri getReferrer(Activity activity) {
        return ActivityCompat.Api22Impl.getReferrer(activity);
    }

    @Deprecated
    public static boolean invalidateOptionsMenu(Activity activity) {
        activity.invalidateOptionsMenu();
        return 1;
    }

    public static boolean isLaunchedFromBubble(Activity activity) {
        Display displayId;
        Display defaultDisplay;
        int i;
        if (Build.VERSION.SDK_INT >= 31) {
            return ActivityCompat.Api31Impl.isLaunchedFromBubble(activity);
        }
        i = 1;
        final int i5 = 0;
        if (Build.VERSION.SDK_INT == 30) {
            if (ActivityCompat.Api30Impl.getDisplay(activity) != null && ActivityCompat.Api30Impl.getDisplay(activity).getDisplayId() != 0) {
                if (ActivityCompat.Api30Impl.getDisplay(activity).getDisplayId() != 0) {
                } else {
                    i = i5;
                }
            } else {
            }
            return i;
        }
        if (Build.VERSION.SDK_INT == 29) {
            if (activity.getWindowManager().getDefaultDisplay() != null && activity.getWindowManager().getDefaultDisplay().getDisplayId() != 0) {
                if (activity.getWindowManager().getDefaultDisplay().getDisplayId() != 0) {
                } else {
                    i = i5;
                }
            } else {
            }
            return i;
        }
        return i5;
    }

    static void lambda$recreate$0(Activity activity) {
        boolean finishing;
        if (!activity.isFinishing() && !ActivityRecreator.recreate(activity)) {
            if (!ActivityRecreator.recreate(activity)) {
                activity.recreate();
            }
        }
    }

    public static void postponeEnterTransition(Activity activity) {
        ActivityCompat.Api21Impl.postponeEnterTransition(activity);
    }

    public static void recreate(Activity activity) {
        activity.recreate();
    }

    public static DragAndDropPermissionsCompat requestDragAndDropPermissions(Activity activity, DragEvent dragEvent) {
        return DragAndDropPermissionsCompat.request(activity, dragEvent);
    }

    public static void requestPermissions(Activity activity, String[] permissions, int requestCode) {
        androidx.core.app.ActivityCompat.PermissionCompatDelegate requestPermissions;
        int i2;
        int sDK_INT;
        String[] strArr;
        int i;
        boolean activity2;
        int i3;
        int contains;
        String str;
        if (ActivityCompat.sDelegate != null && ActivityCompat.sDelegate.requestPermissions(activity, permissions, requestCode)) {
            if (ActivityCompat.sDelegate.requestPermissions(activity, permissions, requestCode)) {
            }
        }
        HashSet hashSet = new HashSet();
        i2 = 0;
        for (Object str2 : permissions) {
            if (Build.VERSION.SDK_INT < 33 && TextUtils.equals(permissions[i2], "android.permission.POST_NOTIFICATIONS")) {
            }
            if (TextUtils.equals(permissions[i2], "android.permission.POST_NOTIFICATIONS")) {
            }
            hashSet.add(Integer.valueOf(i2));
        }
        int size = hashSet.size();
        if (size > 0) {
            strArr = new String[length2 -= size];
        } else {
            strArr = permissions;
        }
        if (size > 0 && size == permissions.length) {
            if (size == permissions.length) {
            }
            i = 0;
            i3 = 0;
            for (Object str : permissions) {
                if (!hashSet.contains(Integer.valueOf(i))) {
                }
                strArr[i3] = str;
                i3 = contains;
            }
        }
        if (activity instanceof ActivityCompat.RequestPermissionsRequestCodeValidator) {
            (ActivityCompat.RequestPermissionsRequestCodeValidator)activity.validateRequestPermissionsRequestCode(requestCode);
        }
        ActivityCompat.Api23Impl.requestPermissions(activity, permissions, requestCode);
    }

    public static <T extends View> T requireViewById(Activity activity, int id) {
        return (View)ActivityCompat.Api28Impl.requireViewById(activity, id);
    }

    public static void setEnterSharedElementCallback(Activity activity, androidx.core.app.SharedElementCallback callback) {
        androidx.core.app.ActivityCompat.SharedElementCallback21Impl sharedElementCallback21Impl;
        if (callback != null) {
            sharedElementCallback21Impl = new ActivityCompat.SharedElementCallback21Impl(callback);
        } else {
            sharedElementCallback21Impl = 0;
        }
        ActivityCompat.Api21Impl.setEnterSharedElementCallback(activity, sharedElementCallback21Impl);
    }

    public static void setExitSharedElementCallback(Activity activity, androidx.core.app.SharedElementCallback callback) {
        androidx.core.app.ActivityCompat.SharedElementCallback21Impl sharedElementCallback21Impl;
        if (callback != null) {
            sharedElementCallback21Impl = new ActivityCompat.SharedElementCallback21Impl(callback);
        } else {
            sharedElementCallback21Impl = 0;
        }
        ActivityCompat.Api21Impl.setExitSharedElementCallback(activity, sharedElementCallback21Impl);
    }

    public static void setLocusContext(Activity activity, LocusIdCompat locusId, Bundle bundle) {
        if (Build.VERSION.SDK_INT >= 30) {
            ActivityCompat.Api30Impl.setLocusContext(activity, locusId, bundle);
        }
    }

    public static void setPermissionCompatDelegate(androidx.core.app.ActivityCompat.PermissionCompatDelegate delegate) {
        ActivityCompat.sDelegate = delegate;
    }

    public static boolean shouldShowRequestPermissionRationale(Activity activity, String permission) {
        int sDK_INT;
        if (Build.VERSION.SDK_INT < 33 && TextUtils.equals("android.permission.POST_NOTIFICATIONS", permission)) {
            if (TextUtils.equals("android.permission.POST_NOTIFICATIONS", permission)) {
                return 0;
            }
        }
        if (Build.VERSION.SDK_INT >= 32) {
            return ActivityCompat.Api32Impl.shouldShowRequestPermissionRationale(activity, permission);
        }
        if (Build.VERSION.SDK_INT == 31) {
            return ActivityCompat.Api31Impl.shouldShowRequestPermissionRationale(activity, permission);
        }
        return ActivityCompat.Api23Impl.shouldShowRequestPermissionRationale(activity, permission);
    }

    public static void startActivityForResult(Activity activity, Intent intent, int requestCode, Bundle options) {
        activity.startActivityForResult(intent, requestCode, options);
    }

    public static void startIntentSenderForResult(Activity activity, IntentSender intent, int requestCode, Intent fillInIntent, int flagsMask, int flagsValues, int extraFlags, Bundle options) throws IntentSender.SendIntentException {
        activity.startIntentSenderForResult(intent, requestCode, fillInIntent, flagsMask, flagsValues, extraFlags, options);
    }

    public static void startPostponedEnterTransition(Activity activity) {
        ActivityCompat.Api21Impl.startPostponedEnterTransition(activity);
    }
}
