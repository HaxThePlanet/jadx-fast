package androidx.core.app;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Bundle;
import android.util.Log;
import androidx.annotation.ReplaceWith;

/* loaded from: classes5.dex */
public final class NavUtils {

    public static final String PARENT_ACTIVITY = "android.support.PARENT_ACTIVITY";
    private static final String TAG = "NavUtils";
    public static Intent getParentActivityIntent(Activity sourceActivity) {
        Intent mainActivity;
        Intent string;
        final Intent parentActivityIntent = sourceActivity.getParentActivityIntent();
        if (parentActivityIntent != null) {
            return parentActivityIntent;
        }
        final String parentActivityName = NavUtils.getParentActivityName(sourceActivity);
        if (parentActivityName == null) {
            return null;
        }
        ComponentName componentName = new ComponentName(sourceActivity, parentActivityName);
        if (NavUtils.getParentActivityName(sourceActivity, componentName) == null) {
            mainActivity = Intent.makeMainActivity(componentName);
        } else {
            string = new Intent();
            mainActivity = string.setComponent(componentName);
        }
        return mainActivity;
    }

    public static Intent getParentActivityIntent(Context context, ComponentName componentName) throws PackageManager.NameNotFoundException {
        Intent mainActivity;
        final String parentActivityName = NavUtils.getParentActivityName(context, componentName);
        if (parentActivityName == null) {
            return null;
        }
        ComponentName componentName2 = new ComponentName(componentName.getPackageName(), parentActivityName);
        if (NavUtils.getParentActivityName(context, componentName2) == null) {
            mainActivity = Intent.makeMainActivity(componentName2);
        } else {
            Intent intent = new Intent();
            mainActivity = intent.setComponent(componentName2);
        }
        return mainActivity;
    }

    public static Intent getParentActivityIntent(Context context, Class<?> class2) throws PackageManager.NameNotFoundException {
        Intent mainActivity;
        ComponentName componentName = new ComponentName(context, class2);
        String parentActivityName = NavUtils.getParentActivityName(context, componentName);
        if (parentActivityName == null) {
            return null;
        }
        ComponentName componentName2 = new ComponentName(context, parentActivityName);
        if (NavUtils.getParentActivityName(context, componentName2) == null) {
            mainActivity = Intent.makeMainActivity(componentName2);
        } else {
            Intent intent = new Intent();
            mainActivity = intent.setComponent(componentName2);
        }
        return mainActivity;
    }

    public static String getParentActivityName(Activity sourceActivity) {
        try {
            return NavUtils.getParentActivityName(sourceActivity, sourceActivity.getComponentName());
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException(th);
            throw illegalArgumentException;
        }
    }

    public static String getParentActivityName(Context context, ComponentName componentName) throws PackageManager.NameNotFoundException {
        String parentActivity;
        char charAt;
        int packageName;
        android.content.pm.ActivityInfo activityInfo = context.getPackageManager().getActivityInfo(componentName, flags |= i2);
        final String parentActivityName = activityInfo.parentActivityName;
        if (parentActivityName != null) {
            return parentActivityName;
        }
        int i3 = 0;
        if (activityInfo.metaData == null) {
            return i3;
        }
        parentActivity = activityInfo.metaData.getString("android.support.PARENT_ACTIVITY");
        if (parentActivity == null) {
            return i3;
        }
        if (parentActivity.charAt(0) == 46) {
            StringBuilder stringBuilder = new StringBuilder();
            parentActivity = stringBuilder.append(context.getPackageName()).append(parentActivity).toString();
        }
        return parentActivity;
    }

    public static void navigateUpFromSameTask(Activity sourceActivity) {
        final Intent parentActivityIntent = NavUtils.getParentActivityIntent(sourceActivity);
        if (parentActivityIntent == null) {
        } else {
            NavUtils.navigateUpTo(sourceActivity, parentActivityIntent);
        }
        StringBuilder stringBuilder = new StringBuilder();
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(stringBuilder.append("Activity ").append(sourceActivity.getClass().getSimpleName()).append(" does not have a parent activity name specified. (Did you forget to add the android.support.PARENT_ACTIVITY <meta-data>  element in your manifest?)").toString());
        throw illegalArgumentException;
    }

    @ReplaceWith(expression = "sourceActivity.navigateUpTo(upIntent)")
    @Deprecated
    public static void navigateUpTo(Activity sourceActivity, Intent upIntent) {
        sourceActivity.navigateUpTo(upIntent);
    }

    @ReplaceWith(expression = "sourceActivity.shouldUpRecreateTask(targetIntent)")
    @Deprecated
    public static boolean shouldUpRecreateTask(Activity sourceActivity, Intent targetIntent) {
        return sourceActivity.shouldUpRecreateTask(targetIntent);
    }
}
