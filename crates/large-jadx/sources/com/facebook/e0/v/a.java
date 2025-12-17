package com.facebook.e0.v;

import android.app.Activity;
import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import com.facebook.e0.g;
import com.facebook.e0.g.a;
import com.facebook.e0.q.a;
import com.facebook.e0.r.b;
import com.facebook.e0.t.f;
import com.facebook.e0.z.d;
import com.facebook.internal.b0;
import com.facebook.internal.g0.i.a;
import com.facebook.internal.l;
import com.facebook.internal.l.a;
import com.facebook.internal.l.b;
import com.facebook.internal.p;
import com.facebook.internal.q;
import com.facebook.internal.v;
import com.facebook.internal.v.a;
import com.facebook.o;
import com.facebook.v;
import java.lang.ref.WeakReference;
import java.util.UUID;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.d0.d.n;
import kotlin.w;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0008\n\u0002\u0018\u0002\n\u0000\u0008Æ\u0002\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J\u0008\u0010\u001e\u001a\u00020\u001fH\u0002J\n\u0010 \u001a\u0004\u0018\u00010\rH\u0007J\n\u0010!\u001a\u0004\u0018\u00010\"H\u0007J\u0008\u0010#\u001a\u00020$H\u0007J\u0008\u0010%\u001a\u00020$H\u0007J\u0012\u0010&\u001a\u00020\u001f2\u0008\u0010'\u001a\u0004\u0018\u00010\rH\u0007J\u0010\u0010(\u001a\u00020\u001f2\u0006\u0010'\u001a\u00020\rH\u0002J\u0010\u0010)\u001a\u00020\u001f2\u0006\u0010'\u001a\u00020\rH\u0002J\u0010\u0010*\u001a\u00020\u001f2\u0006\u0010'\u001a\u00020\rH\u0007J\u001a\u0010+\u001a\u00020\u001f2\u0006\u0010,\u001a\u00020-2\u0008\u0010\n\u001a\u0004\u0018\u00010\u0004H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0008\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\u000cX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\u0008\u0012\u0002\u0008\u0003\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0016\u001a\u00020\t8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\u0008\u0017\u0010\u0018R\u0016\u0010\u0019\u001a\n \u001b*\u0004\u0018\u00010\u001a0\u001aX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006.", d2 = {"Lcom/facebook/appevents/internal/ActivityLifecycleTracker;", "", "()V", "INCORRECT_IMPL_WARNING", "", "INTERRUPTION_THRESHOLD_MILLISECONDS", "", "TAG", "activityReferences", "", "appId", "currActivity", "Ljava/lang/ref/WeakReference;", "Landroid/app/Activity;", "currentActivityAppearTime", "currentFuture", "Ljava/util/concurrent/ScheduledFuture;", "currentFutureLock", "currentSession", "Lcom/facebook/appevents/internal/SessionInfo;", "foregroundActivityCount", "Ljava/util/concurrent/atomic/AtomicInteger;", "sessionTimeoutInSeconds", "getSessionTimeoutInSeconds", "()I", "singleThreadExecutor", "Ljava/util/concurrent/ScheduledExecutorService;", "kotlin.jvm.PlatformType", "tracking", "Ljava/util/concurrent/atomic/AtomicBoolean;", "cancelCurrentTask", "", "getCurrentActivity", "getCurrentSessionGuid", "Ljava/util/UUID;", "isInBackground", "", "isTracking", "onActivityCreated", "activity", "onActivityDestroyed", "onActivityPaused", "onActivityResumed", "startTracking", "application", "Landroid/app/Application;", "facebook-core_release"}, k = 1, mv = {1, 5, 1})
public final class a {

    private static final String a;
    private static final ScheduledExecutorService b;
    private static volatile ScheduledFuture<?> c;
    private static final Object d;
    private static final AtomicInteger e;
    private static volatile com.facebook.e0.v.h f;
    private static final AtomicBoolean g;
    private static String h;
    private static long i;
    private static int j;
    private static WeakReference<Activity> k;
    public static final com.facebook.e0.v.a l;

    @Metadata(d1 = "\u0000\u0008\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\u0008\u0002", d2 = {"<anonymous>", "", "run"}, k = 3, mv = {1, 5, 1})
    static final class a implements Runnable {

        public static final com.facebook.e0.v.a.a a;
        static {
            a.a aVar = new a.a();
            a.a.a = aVar;
        }

        @Override // java.lang.Runnable
        public final void run() {
            com.facebook.e0.v.h hVar;
            if (a.d(this)) {
            }
            com.facebook.e0.v.a aVar = a.l;
            if (a.e(aVar) == null) {
                a.n(aVar, h.g.b());
            }
        }
    }

    @Metadata(d1 = "\u0000\u0008\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\u0008\u0002", d2 = {"<anonymous>", "", "run"}, k = 3, mv = {1, 5, 1})
    static final class b implements Runnable {

        final long a;
        final String b;
        b(long l, String string2) {
            this.a = l;
            this.b = obj3;
            super();
        }

        @Override // java.lang.Runnable
        public final void run() {
            com.facebook.e0.v.h hVar;
            int i5;
            long l;
            com.facebook.e0.v.h valueOf2;
            long valueOf;
            int i3;
            int i4;
            int i;
            int sECONDS;
            int i2;
            if (a.d(this)) {
            }
            com.facebook.e0.v.a aVar = a.l;
            if (a.e(aVar) == null) {
                super(Long.valueOf(this.a), 0, 0, 4, 0);
                a.n(aVar, hVar);
            }
            com.facebook.e0.v.h hVar3 = a.e(aVar);
            if (hVar3 != null) {
                hVar3.k(Long.valueOf(this.a));
            }
            if (a.f(aVar).get() <= 0) {
                a.b.a aVar2 = new a.b.a(this);
                valueOf2 = a.d(aVar);
                a.m(aVar, a.h(aVar).schedule(aVar2, (long)i8, i));
                i5 = w.a;
                synchronized (valueOf2) {
                    aVar2 = new a.b.a(this);
                    valueOf2 = a.d(aVar);
                    a.m(aVar, a.h(aVar).schedule(aVar2, (long)i8, i));
                    i5 = w.a;
                }
            }
            l = a.c(aVar);
            if (Long.compare(l, i3) > 0) {
                i7 /= l;
            }
            d.e(this.b, i3);
            com.facebook.e0.v.h hVar2 = a.e(aVar);
            if (hVar2 != null) {
                hVar2.m();
            }
        }
    }

    @Metadata(d1 = "\u0000\u0008\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\u0008\u0002", d2 = {"<anonymous>", "", "run"}, k = 3, mv = {1, 5, 1})
    static final class c implements Runnable {

        final long a;
        final String b;
        final Context c;
        c(long l, String string2, Context context3) {
            this.a = l;
            this.b = context3;
            this.c = obj4;
            super();
        }

        @Override // java.lang.Runnable
        public final void run() {
            Long hVar2;
            int valueOf;
            Object hVar;
            Context context;
            Long valueOf2;
            int valueOf3;
            int i4;
            int i;
            int i2;
            int i3;
            if (a.d(this)) {
            }
            com.facebook.e0.v.a aVar = a.l;
            com.facebook.e0.v.h hVar4 = a.e(aVar);
            valueOf = 0;
            if (hVar4 != null) {
                hVar2 = hVar4.e();
            } else {
                hVar2 = valueOf;
            }
            final String str3 = "appContext";
            if (a.e(aVar) == null) {
                super(Long.valueOf(this.a), 0, 0, 4, 0);
                a.n(aVar, hVar5);
                context = this.c;
                n.e(context, str3);
                i.c(this.b, valueOf, a.b(aVar), context);
            } else {
                try {
                    if (hVar2 != null) {
                    }
                    l3 -= longValue;
                    if (Long.compare(context, valueOf3) > 0) {
                    } else {
                    }
                    i.e(this.b, a.e(aVar), a.b(aVar));
                    hVar = a.b(aVar);
                    context = this.c;
                    n.e(context, str3);
                    i.c(this.b, valueOf, hVar, context);
                    super(Long.valueOf(this.a), 0, 0, 4, 0);
                    a.n(aVar, hVar2);
                    hVar2 = a.e(aVar);
                    if (Long.compare(context, i7) > 0 && hVar2 != null) {
                    }
                    hVar2 = a.e(aVar);
                    if (hVar2 != null) {
                    }
                    hVar2.h();
                    com.facebook.e0.v.h hVar6 = a.e(aVar);
                    if (hVar6 != null) {
                    }
                    hVar6.k(Long.valueOf(this.a));
                    com.facebook.e0.v.h hVar3 = a.e(aVar);
                    if (hVar3 != null) {
                    }
                    hVar3.m();
                    a.b(th, this);
                }
            }
        }
    }

    @Metadata(d1 = "\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0008*\u0001\u0000\u0008\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0008\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\u0010\u0010\u0008\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0018\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u000c\u001a\u00020\u0007H\u0016J\u0010\u0010\r\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u000f", d2 = {"com/facebook/appevents/internal/ActivityLifecycleTracker$startTracking$2", "Landroid/app/Application$ActivityLifecycleCallbacks;", "onActivityCreated", "", "activity", "Landroid/app/Activity;", "savedInstanceState", "Landroid/os/Bundle;", "onActivityDestroyed", "onActivityPaused", "onActivityResumed", "onActivitySaveInstanceState", "outState", "onActivityStarted", "onActivityStopped", "facebook-core_release"}, k = 1, mv = {1, 5, 1})
    public static final class e implements Application.ActivityLifecycleCallbacks {
        @Override // android.app.Application$ActivityLifecycleCallbacks
        public void onActivityCreated(Activity activity, Bundle bundle2) {
            n.f(activity, "activity");
            v.f.b(v.APP_EVENTS, a.i(a.l), "onActivityCreated");
            b.a();
            a.t(activity);
        }

        @Override // android.app.Application$ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity activity) {
            n.f(activity, "activity");
            final com.facebook.e0.v.a aVar2 = a.l;
            v.f.b(v.APP_EVENTS, a.i(aVar2), "onActivityDestroyed");
            a.j(aVar2, activity);
        }

        @Override // android.app.Application$ActivityLifecycleCallbacks
        public void onActivityPaused(Activity activity) {
            n.f(activity, "activity");
            final com.facebook.e0.v.a aVar2 = a.l;
            v.f.b(v.APP_EVENTS, a.i(aVar2), "onActivityPaused");
            b.a();
            a.k(aVar2, activity);
        }

        @Override // android.app.Application$ActivityLifecycleCallbacks
        public void onActivityResumed(Activity activity) {
            n.f(activity, "activity");
            v.f.b(v.APP_EVENTS, a.i(a.l), "onActivityResumed");
            b.a();
            a.w(activity);
        }

        @Override // android.app.Application$ActivityLifecycleCallbacks
        public void onActivitySaveInstanceState(Activity activity, Bundle bundle2) {
            n.f(activity, "activity");
            n.f(bundle2, "outState");
            v.f.b(v.APP_EVENTS, a.i(a.l), "onActivitySaveInstanceState");
        }

        @Override // android.app.Application$ActivityLifecycleCallbacks
        public void onActivityStarted(Activity activity) {
            n.f(activity, "activity");
            com.facebook.e0.v.a obj4 = a.l;
            a.l(obj4, i++);
            v.f.b(v.APP_EVENTS, a.i(obj4), "onActivityStarted");
        }

        @Override // android.app.Application$ActivityLifecycleCallbacks
        public void onActivityStopped(Activity activity) {
            n.f(activity, "activity");
            final com.facebook.e0.v.a aVar = a.l;
            v.f.b(v.APP_EVENTS, a.i(aVar), "onActivityStopped");
            g.b.g();
            a.l(aVar, obj5--);
        }
    }

    @Metadata(d1 = "\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\u0008\u0004", d2 = {"<anonymous>", "", "enabled", "", "onCompleted"}, k = 3, mv = {1, 5, 1})
    static final class d implements l.a {

        public static final com.facebook.e0.v.a.d a;
        static {
            a.d dVar = new a.d();
            a.d.a = dVar;
        }

        @Override // com.facebook.internal.l$a
        public final void a(boolean z) {
            if (z) {
                b.g();
            } else {
                b.f();
            }
        }
    }
    static {
        String canonicalName;
        a aVar = new a();
        a.l = aVar;
        if (a.class.getCanonicalName() != null) {
        } else {
            canonicalName = "com.facebook.appevents.internal.ActivityLifecycleTracker";
        }
        a.a = canonicalName;
        a.b = Executors.newSingleThreadScheduledExecutor();
        Object object = new Object();
        a.d = object;
        final int i = 0;
        AtomicInteger atomicInteger = new AtomicInteger(i);
        a.e = atomicInteger;
        AtomicBoolean atomicBoolean = new AtomicBoolean(i);
        a.g = atomicBoolean;
    }

    public static final int a(com.facebook.e0.v.a a) {
        return a.j;
    }

    public static final String b(com.facebook.e0.v.a a) {
        return a.h;
    }

    public static final long c(com.facebook.e0.v.a a) {
        return a.i;
    }

    public static final Object d(com.facebook.e0.v.a a) {
        return a.d;
    }

    public static final com.facebook.e0.v.h e(com.facebook.e0.v.a a) {
        return a.f;
    }

    public static final AtomicInteger f(com.facebook.e0.v.a a) {
        return a.e;
    }

    public static final int g(com.facebook.e0.v.a a) {
        return a.r();
    }

    public static final ScheduledExecutorService h(com.facebook.e0.v.a a) {
        return a.b;
    }

    public static final String i(com.facebook.e0.v.a a) {
        return a.a;
    }

    public static final void j(com.facebook.e0.v.a a, Activity activity2) {
        a.u(activity2);
    }

    public static final void k(com.facebook.e0.v.a a, Activity activity2) {
        a.v(activity2);
    }

    public static final void l(com.facebook.e0.v.a a, int i2) {
        a.j = i2;
    }

    public static final void m(com.facebook.e0.v.a a, ScheduledFuture scheduledFuture2) {
        a.c = scheduledFuture2;
    }

    public static final void n(com.facebook.e0.v.a a, com.facebook.e0.v.h h2) {
        a.f = h2;
    }

    private final void o() {
        ScheduledFuture future;
        int i;
        final Object obj = a.d;
        synchronized (obj) {
            future = a.c;
            if (future != null) {
                future.cancel(false);
            }
            try {
                a.c = 0;
                w wVar = w.a;
                throw th;
            }
        }
    }

    public static final Activity p() {
        Object weakReference;
        int i;
        weakReference = a.k;
        i = 0;
        if (weakReference != null && weakReference != null) {
            if (weakReference != null) {
                i = weakReference;
            }
        }
        return i;
    }

    public static final UUID q() {
        com.facebook.e0.v.h hVar;
        int i;
        i = 0;
        hVar = a.f;
        if (a.f != null && hVar != null) {
            hVar = a.f;
            if (hVar != null) {
                i = hVar.d();
            }
        }
        return i;
    }

    private final int r() {
        p pVar = q.j(o.g());
        if (pVar != null) {
            return pVar.i();
        }
        return e.a();
    }

    public static final boolean s() {
        int i;
        i = a.j == 0 ? 1 : 0;
        return i;
    }

    public static final void t(Activity activity) {
        a.b.execute(a.a.a);
    }

    private final void u(Activity activity) {
        b.k(activity);
    }

    private final void v(Activity activity) {
        Object num;
        int decrementAndGet;
        num = a.e;
        if (num.decrementAndGet() < 0) {
            num.set(0);
            Log.w(a.a, "Unexpected activity pause without a matching activity resume. Logging data may be incorrect. Make sure you call activateApp from your Application's onCreate method");
        }
        o();
        b.l(activity);
        a.b obj4 = new a.b(System.currentTimeMillis(), decrementAndGet, b0.s(activity));
        a.b.execute(obj4);
    }

    public static final void w(Activity activity) {
        n.f(activity, "activity");
        WeakReference weakReference = new WeakReference(activity);
        a.k = weakReference;
        a.e.incrementAndGet();
        a.l.o();
        long currentTimeMillis = System.currentTimeMillis();
        a.i = currentTimeMillis;
        b.m(activity);
        a.d(activity);
        d.h(activity);
        f.b();
        a.c cVar = new a.c(currentTimeMillis, obj1, b0.s(activity), activity.getApplicationContext());
        a.b.execute(cVar);
    }

    public static final void x(Application application, String string2) {
        n.f(application, "application");
        if (!a.g.compareAndSet(false, true)) {
        }
        l.a(l.b.CodelessEvents, a.d.a);
        a.h = string2;
        a.e obj4 = new a.e();
        application.registerActivityLifecycleCallbacks(obj4);
    }
}
