package com.google.android.gms.common.api.internal;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.ComponentCallbacks2;
import android.content.res.Configuration;
import android.os.Bundle;
import androidx.annotation.RecentlyNonNull;
import com.google.android.gms.common.util.l;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes2.dex */
public final class d implements Application.ActivityLifecycleCallbacks, ComponentCallbacks2 {

    private static final com.google.android.gms.common.api.internal.d w;
    private final AtomicBoolean a;
    private final AtomicBoolean b;
    private final ArrayList<com.google.android.gms.common.api.internal.d.a> c;
    private boolean v = false;

    public interface a {
        public abstract void onBackgroundStateChanged(boolean z);
    }
    static {
        d dVar = new d();
        d.w = dVar;
    }

    private d() {
        super();
        AtomicBoolean atomicBoolean = new AtomicBoolean();
        this.a = atomicBoolean;
        AtomicBoolean atomicBoolean2 = new AtomicBoolean();
        this.b = atomicBoolean2;
        ArrayList arrayList = new ArrayList();
        this.c = arrayList;
        int i = 0;
    }

    public static com.google.android.gms.common.api.internal.d b() {
        return d.w;
    }

    public static void c(Application application) {
        int obj2;
        final com.google.android.gms.common.api.internal.d dVar = d.w;
        synchronized (dVar) {
            application.registerActivityLifecycleCallbacks(dVar);
            application.registerComponentCallbacks(dVar);
            dVar.v = true;
        }
    }

    private final void f(boolean z) {
        Object next;
        final com.google.android.gms.common.api.internal.d dVar = d.w;
        Iterator iterator = this.c.iterator();
        synchronized (dVar) {
            for (d.a next : iterator) {
                next.onBackgroundStateChanged(z);
            }
            try {
                throw z;
            }
        }
    }

    @Override // android.app.Application$ActivityLifecycleCallbacks
    public void a(com.google.android.gms.common.api.internal.d.a d$a) {
        final com.google.android.gms.common.api.internal.d dVar = d.w;
        this.c.add(a);
        return;
        synchronized (dVar) {
            dVar = d.w;
            this.c.add(a);
        }
    }

    @Override // android.app.Application$ActivityLifecycleCallbacks
    public boolean d() {
        return this.a.get();
    }

    @Override // android.app.Application$ActivityLifecycleCallbacks
    public boolean e(boolean z) {
        boolean andSet;
        int i;
        ActivityManager.RunningAppProcessInfo obj3;
        obj3 = new ActivityManager.RunningAppProcessInfo();
        ActivityManager.getMyMemoryState(obj3);
        i = 1;
        if (!this.b.get() && l.b() && !this.b.getAndSet(i) && obj3.importance > 100) {
            if (l.b()) {
                obj3 = new ActivityManager.RunningAppProcessInfo();
                ActivityManager.getMyMemoryState(obj3);
                i = 1;
                if (!this.b.getAndSet(i)) {
                    if (obj3.importance > 100) {
                        this.a.set(i);
                    }
                }
            }
            return z;
        }
        return d();
    }

    @Override // android.app.Application$ActivityLifecycleCallbacks
    public final void onActivityCreated(Activity activity, Bundle bundle2) {
        final int obj4 = 1;
        final int i = 0;
        this.b.set(obj4);
        if (this.a.compareAndSet(obj4, i)) {
            f(i);
        }
    }

    @Override // android.app.Application$ActivityLifecycleCallbacks
    public final void onActivityDestroyed(Activity activity) {
    }

    @Override // android.app.Application$ActivityLifecycleCallbacks
    public final void onActivityPaused(Activity activity) {
    }

    @Override // android.app.Application$ActivityLifecycleCallbacks
    public final void onActivityResumed(Activity activity) {
        final int i = 1;
        final int i2 = 0;
        this.b.set(i);
        if (this.a.compareAndSet(i, i2)) {
            f(i2);
        }
    }

    @Override // android.app.Application$ActivityLifecycleCallbacks
    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle2) {
    }

    @Override // android.app.Application$ActivityLifecycleCallbacks
    public final void onActivityStarted(Activity activity) {
    }

    @Override // android.app.Application$ActivityLifecycleCallbacks
    public final void onActivityStopped(Activity activity) {
    }

    @Override // android.app.Application$ActivityLifecycleCallbacks
    public final void onConfigurationChanged(Configuration configuration) {
    }

    @Override // android.app.Application$ActivityLifecycleCallbacks
    public final void onLowMemory() {
    }

    @Override // android.app.Application$ActivityLifecycleCallbacks
    public final void onTrimMemory(int i) {
        int i2;
        int i3;
        int obj3;
        i3 = 1;
        if (i == 20 && this.a.compareAndSet(false, i3)) {
            i3 = 1;
            if (this.a.compareAndSet(false, i3)) {
                this.b.set(i3);
                f(i3);
            }
        }
    }
}
