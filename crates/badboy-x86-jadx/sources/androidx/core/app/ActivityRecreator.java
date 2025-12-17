package androidx.core.app;

import android.app.Activity;
import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* loaded from: classes5.dex */
final class ActivityRecreator {

    private static final String LOG_TAG = "ActivityRecreator";
    protected static final Class<?> activityThreadClass;
    private static final Handler mainHandler;
    protected static final Field mainThreadField;
    protected static final Method performStopActivity2ParamsMethod;
    protected static final Method performStopActivity3ParamsMethod;
    protected static final Method requestRelaunchActivityMethod;
    protected static final Field tokenField;

    private static final class LifecycleCheckCallbacks implements Application.ActivityLifecycleCallbacks {

        Object currentlyRecreatingToken;
        private Activity mActivity;
        private boolean mDestroyed = false;
        private final int mRecreatingHashCode;
        private boolean mStarted = false;
        private boolean mStopQueued = false;
        LifecycleCheckCallbacks(Activity aboutToRecreate) {
            super();
            int i = 0;
            this.mActivity = aboutToRecreate;
            this.mRecreatingHashCode = this.mActivity.hashCode();
        }

        @Override // android.app.Application$ActivityLifecycleCallbacks
        public void onActivityCreated(Activity activity, Bundle savedInstanceState) {
        }

        @Override // android.app.Application$ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity activity) {
            Activity mActivity;
            if (this.mActivity == activity) {
                this.mActivity = 0;
                this.mDestroyed = true;
            }
        }

        @Override // android.app.Application$ActivityLifecycleCallbacks
        public void onActivityPaused(Activity activity) {
            boolean queueOnStopIfNecessary;
            int mRecreatingHashCode;
            if (this.mDestroyed && !this.mStopQueued && !this.mStarted && ActivityRecreator.queueOnStopIfNecessary(this.currentlyRecreatingToken, this.mRecreatingHashCode, activity)) {
                if (!this.mStopQueued) {
                    if (!this.mStarted) {
                        if (ActivityRecreator.queueOnStopIfNecessary(this.currentlyRecreatingToken, this.mRecreatingHashCode, activity)) {
                            this.mStopQueued = true;
                            this.currentlyRecreatingToken = 0;
                        }
                    }
                }
            }
        }

        @Override // android.app.Application$ActivityLifecycleCallbacks
        public void onActivityResumed(Activity activity) {
        }

        @Override // android.app.Application$ActivityLifecycleCallbacks
        public void onActivitySaveInstanceState(Activity activity, Bundle outState) {
        }

        @Override // android.app.Application$ActivityLifecycleCallbacks
        public void onActivityStarted(Activity activity) {
            Activity mActivity;
            if (this.mActivity == activity) {
                this.mStarted = true;
            }
        }

        @Override // android.app.Application$ActivityLifecycleCallbacks
        public void onActivityStopped(Activity activity) {
        }
    }
    static {
        Handler handler = new Handler(Looper.getMainLooper());
        ActivityRecreator.mainHandler = handler;
        ActivityRecreator.activityThreadClass = ActivityRecreator.getActivityThreadClass();
        ActivityRecreator.mainThreadField = ActivityRecreator.getMainThreadField();
        ActivityRecreator.tokenField = ActivityRecreator.getTokenField();
        ActivityRecreator.performStopActivity3ParamsMethod = ActivityRecreator.getPerformStopActivity3Params(ActivityRecreator.activityThreadClass);
        ActivityRecreator.performStopActivity2ParamsMethod = ActivityRecreator.getPerformStopActivity2Params(ActivityRecreator.activityThreadClass);
        ActivityRecreator.requestRelaunchActivityMethod = ActivityRecreator.getRequestRelaunchActivityMethod(ActivityRecreator.activityThreadClass);
    }

    private static Class<?> getActivityThreadClass() {
        try {
            return Class.forName("android.app.ActivityThread");
            return 0;
        }
    }

    private static Field getMainThreadField() {
        try {
            Field declaredField = Activity.class.getDeclaredField("mMainThread");
            declaredField.setAccessible(true);
            return declaredField;
            return null;
        }
    }

    private static Method getPerformStopActivity2Params(Class<?> class) {
        if (class == null) {
            return null;
        }
        Class[] arr = new Class[2];
        int i4 = 1;
        arr[i4] = Boolean.TYPE;
        Method declaredMethod = class.getDeclaredMethod("performStopActivity", arr);
        declaredMethod.setAccessible(i4);
        return declaredMethod;
    }

    private static Method getPerformStopActivity3Params(Class<?> class) {
        if (class == null) {
            return null;
        }
        Class[] arr = new Class[3];
        int i4 = 1;
        arr[i4] = Boolean.TYPE;
        arr[2] = String.class;
        Method declaredMethod = class.getDeclaredMethod("performStopActivity", arr);
        declaredMethod.setAccessible(i4);
        return declaredMethod;
    }

    private static Method getRequestRelaunchActivityMethod(Class<?> class) {
        if (ActivityRecreator.needsRelaunchCall() && class == null) {
            if (class == null) {
            }
            Class[] arr = new Class[9];
            int i4 = 1;
            arr[i4] = List.class;
            arr[2] = List.class;
            arr[3] = Integer.TYPE;
            arr[4] = Boolean.TYPE;
            arr[5] = Configuration.class;
            arr[6] = Configuration.class;
            arr[7] = Boolean.TYPE;
            arr[8] = Boolean.TYPE;
            Method declaredMethod = class.getDeclaredMethod("requestRelaunchActivity", arr);
            declaredMethod.setAccessible(i4);
            return declaredMethod;
        }
        return null;
    }

    private static Field getTokenField() {
        try {
            Field declaredField = Activity.class.getDeclaredField("mToken");
            declaredField.setAccessible(true);
            return declaredField;
            return null;
        }
    }

    private static boolean needsRelaunchCall() {
        return 0;
    }

    protected static boolean queueOnStopIfNecessary(Object currentlyRecreatingToken, int currentlyRecreatingHashCode, Activity activity) {
        int str;
        Object obj = ActivityRecreator.tokenField.get(activity);
        if (obj == currentlyRecreatingToken && activity.hashCode() != currentlyRecreatingHashCode) {
            try {
                if (activity.hashCode() != currentlyRecreatingHashCode) {
                }
                ActivityRecreator.3 anon = new ActivityRecreator.3(ActivityRecreator.mainThreadField.get(activity), obj);
                ActivityRecreator.mainHandler.postAtFrontOfQueue(anon);
                return 1;
                return 0;
                Log.e("ActivityRecreator", "Exception while fetching field values", token);
                return obj0;
            }
        }
    }

    static boolean recreate(Activity activity) {
        activity.recreate();
        return 1;
    }
}
