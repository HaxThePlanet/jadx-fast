package com.iterable.iterableapi;

import android.app.Activity;
import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes2.dex */
public class i {

    private static boolean h = false;
    static com.iterable.iterableapi.i i;
    private final Handler a;
    private WeakReference<Activity> b;
    private int c = 0;
    private boolean d = false;
    private List<WeakReference<com.iterable.iterableapi.i.c>> e;
    private Runnable f;
    private Application.ActivityLifecycleCallbacks g;

    class a implements Runnable {

        final com.iterable.iterableapi.i a;
        a(com.iterable.iterableapi.i i) {
            this.a = i;
            super();
        }

        @Override // java.lang.Runnable
        public void run() {
            int next;
            Object obj;
            i.b(this.a, false);
            Iterator iterator = i.c(this.a).iterator();
            while (iterator.hasNext()) {
                next = iterator.next();
                if ((WeakReference)next.get() != null) {
                }
                (i.c)next.get().a();
            }
        }
    }

    class b implements Application.ActivityLifecycleCallbacks {

        final com.iterable.iterableapi.i a;
        b(com.iterable.iterableapi.i i) {
            this.a = i;
            super();
        }

        @Override // android.app.Application$ActivityLifecycleCallbacks
        public void onActivityCreated(Activity activity, Bundle bundle2) {
        }

        @Override // android.app.Application$ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity activity) {
        }

        @Override // android.app.Application$ActivityLifecycleCallbacks
        public void onActivityPaused(Activity activity) {
            Activity activity2;
            Object obj2;
            if (this.a.k() == activity) {
                i.i(this.a, 0);
            }
        }

        @Override // android.app.Application$ActivityLifecycleCallbacks
        public void onActivityResumed(Activity activity) {
            com.iterable.iterableapi.i next;
            int next2;
            WeakReference weakReference;
            boolean obj3;
            weakReference = new WeakReference(activity);
            i.i(this.a, weakReference);
            if (!i.a(this.a)) {
                i.b(this.a, true);
                obj3 = i.c(this.a).iterator();
                while (obj3.hasNext()) {
                    next2 = obj3.next();
                    if ((WeakReference)next2.get() != null) {
                    }
                    (i.c)next2.get().d();
                }
            }
        }

        @Override // android.app.Application$ActivityLifecycleCallbacks
        public void onActivitySaveInstanceState(Activity activity, Bundle bundle2) {
        }

        @Override // android.app.Application$ActivityLifecycleCallbacks
        public void onActivityStarted(Activity activity) {
            i.e(this.a).removeCallbacks(i.d(this.a));
            i.g(this.a);
        }

        @Override // android.app.Application$ActivityLifecycleCallbacks
        public void onActivityStopped(Activity activity) {
            Runnable runnable;
            int i;
            int obj4;
            if (i.f(this.a) > 0) {
                i.h(this.a);
            }
            if (i.f(this.a) == 0 && i.a(this.a)) {
                if (i.a(this.a)) {
                    i.e(this.a).postDelayed(i.d(this.a), 1000);
                }
            }
        }
    }

    public interface c {
        public abstract void a();

        public abstract void d();
    }
    static {
        i iVar = new i();
        i.i = iVar;
    }

    public i() {
        super();
        Handler handler = new Handler(Looper.getMainLooper());
        this.a = handler;
        int i = 0;
        ArrayList arrayList = new ArrayList();
        this.e = arrayList;
        i.a aVar = new i.a(this);
        this.f = aVar;
        i.b bVar = new i.b(this);
        this.g = bVar;
    }

    static boolean a(com.iterable.iterableapi.i i) {
        return i.d;
    }

    static boolean b(com.iterable.iterableapi.i i, boolean z2) {
        i.d = z2;
        return z2;
    }

    static List c(com.iterable.iterableapi.i i) {
        return i.e;
    }

    static Runnable d(com.iterable.iterableapi.i i) {
        return i.f;
    }

    static Handler e(com.iterable.iterableapi.i i) {
        return i.a;
    }

    static int f(com.iterable.iterableapi.i i) {
        return i.c;
    }

    static int g(com.iterable.iterableapi.i i) {
        final int i2 = i.c;
        i.c = i2 + 1;
        return i2;
    }

    static int h(com.iterable.iterableapi.i i) {
        final int i2 = i.c;
        i.c = i2 + -1;
        return i2;
    }

    static WeakReference i(com.iterable.iterableapi.i i, WeakReference weakReference2) {
        i.b = weakReference2;
        return weakReference2;
    }

    public static com.iterable.iterableapi.i l() {
        return i.i;
    }

    public void j(com.iterable.iterableapi.i.c i$c) {
        Object obj;
        Iterator iterator = this.e.iterator();
        for (WeakReference next2 : iterator) {
        }
        WeakReference weakReference = new WeakReference(c);
        this.e.add(weakReference);
    }

    public Activity k() {
        Object obj;
        WeakReference weakReference = this.b;
        if (weakReference != null) {
            obj = weakReference.get();
        } else {
            obj = 0;
        }
        return obj;
    }

    public boolean m() {
        int i;
        i = k() != null ? 1 : 0;
        return i;
    }

    public void n(Context context) {
        boolean z;
        Context obj2;
        if (!i.h) {
            i.h = true;
            (Application)context.getApplicationContext().registerActivityLifecycleCallbacks(this.g);
        }
    }

    public void o(com.iterable.iterableapi.i.c i$c) {
        Object obj;
        Iterator iterator = this.e.iterator();
        while (iterator.hasNext()) {
            if ((WeakReference)iterator.next().get() == c) {
            }
            iterator.remove();
        }
    }
}
