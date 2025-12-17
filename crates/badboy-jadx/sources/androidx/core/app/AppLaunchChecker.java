package androidx.core.app;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

/* loaded from: classes5.dex */
public class AppLaunchChecker {

    private static final String KEY_STARTED_FROM_LAUNCHER = "startedFromLauncher";
    private static final String SHARED_PREFS_NAME = "android.support.AppLaunchChecker";
    public static boolean hasStartedFromLauncher(Context context) {
        final int i = 0;
        return context.getSharedPreferences("android.support.AppLaunchChecker", i).getBoolean("startedFromLauncher", i);
    }

    public static void onActivityCreate(Activity activity) {
        Object boolean;
        boolean category;
        String action;
        int i = 0;
        SharedPreferences sharedPreferences = activity.getSharedPreferences("android.support.AppLaunchChecker", i);
        boolean = "startedFromLauncher";
        if (sharedPreferences.getBoolean(boolean, i)) {
        }
        Intent intent = activity.getIntent();
        if (intent == null) {
        }
        if ("android.intent.action.MAIN".equals(intent.getAction())) {
            if (!intent.hasCategory("android.intent.category.LAUNCHER")) {
                if (intent.hasCategory("android.intent.category.LEANBACK_LAUNCHER")) {
                    sharedPreferences.edit().putBoolean(boolean, true).apply();
                }
            } else {
            }
        }
    }
}
