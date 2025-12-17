package androidx.core.app;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.util.Log;

/* loaded from: classes.dex */
public final class h {
    public static Intent a(Activity activity) {
        int parentActivityIntent;
        Intent obj3;
        parentActivityIntent = activity.getParentActivityIntent();
        if (Build.VERSION.SDK_INT >= 16 && parentActivityIntent != null) {
            parentActivityIntent = activity.getParentActivityIntent();
            if (parentActivityIntent != null) {
                return parentActivityIntent;
            }
        }
        String str2 = h.c(activity);
        if (str2 == null) {
            return null;
        }
        ComponentName componentName = new ComponentName(activity, str2);
        if (h.d(activity, componentName) == null) {
            obj3 = Intent.makeMainActivity(componentName);
        } else {
            obj3 = new Intent();
            obj3 = obj3.setComponent(componentName);
        }
        return obj3;
    }

    public static Intent b(Context context, ComponentName componentName2) {
        Intent obj2;
        final String str = h.d(context, componentName2);
        if (str == null) {
            return null;
        }
        ComponentName componentName = new ComponentName(componentName2.getPackageName(), str);
        if (h.d(context, componentName) == null) {
            obj2 = Intent.makeMainActivity(componentName);
        } else {
            obj2 = new Intent();
            obj2 = obj2.setComponent(componentName);
        }
        return obj2;
    }

    public static String c(Activity activity) {
        try {
            return h.d(activity, activity.getComponentName());
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException(activity);
            throw illegalArgumentException;
        }
    }

    public static String d(Context context, ComponentName componentName2) {
        int parentActivityName;
        char stringBuilder;
        int i;
        String obj5;
        String obj6;
        int sDK_INT = Build.VERSION.SDK_INT;
        i = 640;
        if (sDK_INT >= 29) {
            i = 269222528;
        } else {
            if (sDK_INT >= 24) {
                i = 787072;
            }
        }
        obj6 = context.getPackageManager().getActivityInfo(componentName2, i);
        parentActivityName = obj6.parentActivityName;
        if (sDK_INT >= 16 && parentActivityName != null) {
            parentActivityName = obj6.parentActivityName;
            if (parentActivityName != null) {
                return parentActivityName;
            }
        }
        obj6 = obj6.metaData;
        int i2 = 0;
        if (obj6 == null) {
            return i2;
        }
        obj6 = obj6.getString("android.support.PARENT_ACTIVITY");
        if (obj6 == null) {
            return i2;
        }
        if (obj6.charAt(0) == 46) {
            stringBuilder = new StringBuilder();
            stringBuilder.append(context.getPackageName());
            stringBuilder.append(obj6);
            obj6 = stringBuilder.toString();
        }
        return obj6;
    }

    public static void e(Activity activity, Intent intent2) {
        int sDK_INT;
        if (Build.VERSION.SDK_INT >= 16) {
            activity.navigateUpTo(intent2);
        } else {
            intent2.addFlags(67108864);
            activity.startActivity(intent2);
            activity.finish();
        }
    }

    public static boolean f(Activity activity, Intent intent2) {
        String obj2;
        Object obj3;
        if (Build.VERSION.SDK_INT >= 16) {
            return activity.shouldUpRecreateTask(intent2);
        }
        obj2 = activity.getIntent().getAction();
        if (obj2 != null && !obj2.equals("android.intent.action.MAIN")) {
            obj2 = !obj2.equals("android.intent.action.MAIN") ? 1 : 0;
        } else {
        }
        return obj2;
    }
}
