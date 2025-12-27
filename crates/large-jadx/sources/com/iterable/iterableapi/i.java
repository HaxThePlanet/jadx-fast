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

/* compiled from: IterableActivityMonitor.java */
/* loaded from: classes2.dex */
public class i {

    private static boolean h = false;
    static i i;
    private final Handler a = new Handler();
    private WeakReference<Activity> b;
    private int c = 0;
    private boolean d = false;
    private List<WeakReference<i.c>> e = new ArrayList<>();
    private Runnable f = new i$a();
    private Application.ActivityLifecycleCallbacks g = new i$b();

    class a implements Runnable {

        final /* synthetic */ i a;
        a() {
            this.a = iVar;
            super();
        }

        @Override // java.lang.Runnable
        public void run() {
            boolean z = false;
            this.a.d = z;
            Iterator it = this.a.e.iterator();
            while (it.hasNext()) {
                Object item = it.next();
            }
        }
    }

    class b implements Application.ActivityLifecycleCallbacks {

        final /* synthetic */ i a;
        b() {
            this.a = iVar;
            super();
        }

        public void onActivityPaused(Activity activity) {
            if (this.a.k() == activity) {
                this.a.b = null;
            }
        }

        public void onActivityResumed(Activity activity) {
            WeakReference weakReference;
            this.a.b = new WeakReference(activity);
            if (!this.a.d) {
                boolean z = true;
                this.a.d = z;
                Iterator it = this.a.e.iterator();
                while (it.hasNext()) {
                    Object item = it.next();
                }
            }
        }

        public void onActivityStarted(Activity activity) {
            this.a.a.removeCallbacks(this.a.f);
            i.g(this.a);
        }

        public void onActivityStopped(Activity activity) {
            if (this.a.c > 0) {
                i.h(this.a);
            }
            if (this.a.c == 0) {
                if (this.a.d) {
                    long l = 1000L;
                    this.a.a.postDelayed(this.a.f, l);
                }
            }
        }

        public void onActivityCreated(Activity activity, Bundle bundle) {
        }

        public void onActivityDestroyed(Activity activity) {
        }

        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }
    }

    public interface c {
        void a();

        void d();
    }
    static {
        i.i = new i();
    }

    public i() {
        super();
        Handler handler = new Handler(Looper.getMainLooper());
        ArrayList arrayList = new ArrayList();
        com.iterable.iterableapi.i.a aVar = new i.a(this);
        com.iterable.iterableapi.i.b bVar = new i.b(this);
    }

    static /* synthetic */ boolean a(i iVar) {
        return iVar.d;
    }

    static /* synthetic */ boolean b(i iVar, boolean z) {
        iVar.d = z;
        return z;
    }

    static /* synthetic */ List c(i iVar) {
        return iVar.e;
    }

    static /* synthetic */ Runnable d(i iVar) {
        return iVar.f;
    }

    static /* synthetic */ Handler e(i iVar) {
        return iVar.a;
    }

    static /* synthetic */ int f(i iVar) {
        return iVar.c;
    }

    static /* synthetic */ int g(i iVar) {
        iVar.c++;
        return iVar.c;
    }

    static /* synthetic */ int h(i iVar) {
        iVar.c--;
        return iVar.c;
    }

    static /* synthetic */ WeakReference i(i iVar, WeakReference weakReference) {
        iVar.b = weakReference;
        return weakReference;
    }

    public static i l() {
        return i.i;
    }

    public void j(i.c cVar) {
        Iterator it = this.e.iterator();
        while (it.hasNext()) {
            if ((WeakReference)it.next().get() == cVar) {
                return;
            }
        }
        this.e.add(new WeakReference(cVar));
    }

    public Activity k() {
        Object obj = null;
        obj = this.b != null ? (Activity)obj : 0;
        return obj;
    }

    public boolean m() {
        boolean z = true;
        int r0 = k() != null ? 1 : 0;
        return (k() != null ? 1 : 0);
    }

    public void n(Context context) {
        if (!i.h) {
            i.h = true;
            (Application)context.getApplicationContext().registerActivityLifecycleCallbacks(this.g);
        }
    }

    public void o(i.c cVar) {
        Iterator it = this.e.iterator();
        while (it.hasNext()) {
        }
    }
}
