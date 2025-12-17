package androidx.core.app;

import android.app.Activity;
import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* loaded from: classes.dex */
final class c {

    protected static final Class<?> a;
    protected static final Field b;
    protected static final Field c;
    protected static final Method d;
    protected static final Method e;
    protected static final Method f;
    private static final Handler g;

    class a implements Runnable {

        final androidx.core.app.c.d a;
        final Object b;
        a(androidx.core.app.c.d c$d, Object object2) {
            this.a = d;
            this.b = object2;
            super();
        }

        @Override // java.lang.Runnable
        public void run() {
            dVar.a = this.b;
        }
    }

    class b implements Runnable {

        final Application a;
        final androidx.core.app.c.d b;
        b(Application application, androidx.core.app.c.d c$d2) {
            this.a = application;
            this.b = d2;
            super();
        }

        @Override // java.lang.Runnable
        public void run() {
            this.a.unregisterActivityLifecycleCallbacks(this.b);
        }
    }

    class c implements Runnable {

        final Object a;
        final Object b;
        c(Object object, Object object2) {
            this.a = object;
            this.b = object2;
            super();
        }

        @Override // java.lang.Runnable
        public void run() {
            Method method;
            String str;
            Boolean fALSE;
            int arr2;
            Object obj;
            Object[] arr;
            Object obj2;
            try {
                method = c.d;
                str = 1;
                int i = 0;
                arr2 = 2;
                if (method != null) {
                } else {
                }
                arr = new Object[3];
                arr[i] = this.b;
                arr[str] = Boolean.FALSE;
                arr[arr2] = "AppCompat recreation";
                method.invoke(this.a, arr);
                arr2 = new Object[arr2];
                arr2[i] = this.b;
                arr2[str] = Boolean.FALSE;
                c.e.invoke(this.a, arr2);
                String startsWith = "ActivityRecreator";
                String str2 = "Exception while invoking performStopActivity";
                Log.e(startsWith, str2, th);
                startsWith = th.getClass();
                str2 = RuntimeException.class;
                startsWith = th.getMessage();
                if (startsWith == str2 && startsWith != null) {
                }
                startsWith = th.getMessage();
                if (startsWith != null) {
                }
                startsWith = th.getMessage();
                str2 = "Unable to stop";
                startsWith = startsWith.startsWith(str2);
                if (startsWith != null) {
                } else {
                }
                throw th;
            }
        }
    }

    private static final class d implements Application.ActivityLifecycleCallbacks {

        Object a;
        private Activity b;
        private final int c;
        private boolean v = false;
        private boolean w = false;
        private boolean x = false;
        d(Activity activity) {
            super();
            final int i = 0;
            this.b = activity;
            this.c = activity.hashCode();
        }

        @Override // android.app.Application$ActivityLifecycleCallbacks
        public void onActivityCreated(Activity activity, Bundle bundle2) {
        }

        @Override // android.app.Application$ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity activity) {
            Activity obj2;
            if (this.b == activity) {
                this.b = 0;
                this.w = true;
            }
        }

        @Override // android.app.Application$ActivityLifecycleCallbacks
        public void onActivityPaused(Activity activity) {
            boolean z;
            int i;
            Activity obj3;
            if (this.w && !this.x && !this.v && c.h(this.a, this.c, activity)) {
                if (!this.x) {
                    if (!this.v) {
                        if (c.h(this.a, this.c, activity)) {
                            this.x = true;
                            this.a = 0;
                        }
                    }
                }
            }
        }

        @Override // android.app.Application$ActivityLifecycleCallbacks
        public void onActivityResumed(Activity activity) {
        }

        @Override // android.app.Application$ActivityLifecycleCallbacks
        public void onActivitySaveInstanceState(Activity activity, Bundle bundle2) {
        }

        @Override // android.app.Application$ActivityLifecycleCallbacks
        public void onActivityStarted(Activity activity) {
            Activity obj2;
            if (this.b == activity) {
                this.v = true;
            }
        }

        @Override // android.app.Application$ActivityLifecycleCallbacks
        public void onActivityStopped(Activity activity) {
        }
    }
    static {
        Handler handler = new Handler(Looper.getMainLooper());
        c.g = handler;
        Class cls = c.a();
        c.a = cls;
        c.b = c.b();
        c.c = c.f();
        c.d = c.d(cls);
        c.e = c.c(cls);
        c.f = c.e(cls);
    }

    private static Class<?> a() {
        try {
            return Class.forName("android.app.ActivityThread");
            return 0;
        }
    }

    private static Field b() {
        try {
            Field declaredField = Activity.class.getDeclaredField("mMainThread");
            declaredField.setAccessible(true);
            return declaredField;
            return null;
        }
    }

    private static Method c(Class<?> class) {
        if (class == null) {
            return null;
        }
        Class[] arr = new Class[2];
        int i4 = 1;
        arr[i4] = Boolean.TYPE;
        final Method obj5 = class.getDeclaredMethod("performStopActivity", arr);
        obj5.setAccessible(i4);
        return obj5;
    }

    private static Method d(Class<?> class) {
        if (class == null) {
            return null;
        }
        Class[] arr = new Class[3];
        int i5 = 1;
        arr[i5] = Boolean.TYPE;
        arr[2] = String.class;
        final Method obj6 = class.getDeclaredMethod("performStopActivity", arr);
        obj6.setAccessible(i5);
        return obj6;
    }

    private static Method e(Class<?> class) {
        if (c.g() && class == null) {
            if (class == null) {
            }
            Class[] arr = new Class[9];
            int i11 = 1;
            arr[i11] = List.class;
            arr[2] = List.class;
            arr[3] = Integer.TYPE;
            Class tYPE2 = Boolean.TYPE;
            arr[4] = tYPE2;
            arr[5] = Configuration.class;
            arr[6] = Configuration.class;
            arr[7] = tYPE2;
            arr[8] = tYPE2;
            final Method obj7 = class.getDeclaredMethod("requestRelaunchActivity", arr);
            obj7.setAccessible(i11);
            return obj7;
        }
        return null;
    }

    private static Field f() {
        try {
            Field declaredField = Activity.class.getDeclaredField("mToken");
            declaredField.setAccessible(true);
            return declaredField;
            return null;
        }
    }

    private static boolean g() {
        int i2;
        int i;
        int sDK_INT = Build.VERSION.SDK_INT;
        if (sDK_INT != 26) {
            if (sDK_INT == 27) {
                i2 = 1;
            } else {
                i2 = 0;
            }
        } else {
        }
        return i2;
    }

    protected static boolean h(Object object, int i2, Activity activity3) {
        Object obj2;
        Object obj = c.c.get(activity3);
        if (obj == object && activity3.hashCode() != i2) {
            try {
                if (activity3.hashCode() != i2) {
                }
                c.c obj4 = new c.c(c.b.get(activity3), obj);
                c.g.postAtFrontOfQueue(obj4);
                return 1;
                return 0;
                i2 = "ActivityRecreator";
                activity3 = "Exception while fetching field values";
                Log.e(i2, activity3, object);
                return obj0;
            }
        }
    }

    static boolean i(Activity activity) {
        boolean z;
        Method method;
        Object obj;
        boolean arr;
        int i;
        Boolean fALSE;
        Object obj10;
        final int i4 = 1;
        if (Build.VERSION.SDK_INT >= 28) {
            activity.recreate();
            return i4;
        }
        int i6 = 0;
        if (c.g() && c.f == null) {
            if (c.f == null) {
                return i6;
            }
        }
        if (c.e == null && c.d == null) {
            if (c.d == null) {
                return i6;
            }
        }
        obj = c.c.get(activity);
        if (obj == null) {
            return i6;
        }
        Object obj2 = c.b.get(activity);
        if (obj2 == null) {
            return i6;
        }
        final Application application = activity.getApplication();
        c.d dVar = new c.d(activity);
        application.registerActivityLifecycleCallbacks(dVar);
        final Handler handler2 = c.g;
        c.a aVar = new c.a(dVar, obj);
        handler2.post(aVar);
        if (c.g()) {
            arr = new Object[9];
            arr[i6] = obj;
            int i2 = 0;
            arr[i4] = i2;
            arr[2] = i2;
            arr[3] = Integer.valueOf(i6);
            fALSE = Boolean.FALSE;
            arr[4] = fALSE;
            arr[5] = i2;
            arr[6] = i2;
            arr[7] = fALSE;
            arr[8] = fALSE;
            c.f.invoke(obj2, arr);
        } else {
            activity.recreate();
        }
        obj10 = new c.b(application, dVar);
        handler2.post(obj10);
        return i4;
    }
}
