package com.appsflyer.internal;

import android.app.Activity;
import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.Context;
import android.os.Bundle;
import java.util.concurrent.Executor;

/* loaded from: classes.dex */
public final class ai {

    public static long AFInAppEventType = 500L;
    public static com.appsflyer.internal.ai.c AFKeystoreWrapper;

    public interface c {
        public abstract void AFInAppEventType(Context context);

        public abstract void values(Activity activity);
    }
    static {
    }

    static void AFInAppEventType(Context context, com.appsflyer.internal.ai.c ai$c2, Executor executor3) {
        boolean obj2;
        ai.AFKeystoreWrapper = c2;
        ai.1 anon = new ai.1(executor3, c2);
        if (context instanceof Activity != null) {
            anon.onActivityResumed((Activity)context);
        }
        (Application)context.getApplicationContext().registerActivityLifecycleCallbacks(anon);
    }
}
