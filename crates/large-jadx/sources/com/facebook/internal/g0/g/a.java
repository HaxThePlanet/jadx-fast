package com.facebook.internal.g0.g;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Looper;
import android.os.Process;
import com.facebook.internal.g0.b;
import com.facebook.internal.g0.b.a;
import com.facebook.internal.g0.f;
import com.facebook.internal.g0.i.a;
import com.facebook.o;
import java.util.Iterator;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.d0.d.n;

/* loaded from: classes.dex */
@Metadata(d1 = "\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008Ç\u0002\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\r\u001a\u00020\u000e2\u0008\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0007J\u0008\u0010\u0011\u001a\u00020\u000eH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0008\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\n\u001a\n \u000c*\u0004\u0018\u00010\u000b0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012", d2 = {"Lcom/facebook/internal/instrument/anrreport/ANRDetector;", "", "()V", "DETECTION_INTERVAL_IN_MS", "", "anrDetectorRunnable", "Ljava/lang/Runnable;", "myUid", "previousStackTrace", "", "scheduledExecutorService", "Ljava/util/concurrent/ScheduledExecutorService;", "kotlin.jvm.PlatformType", "checkProcessError", "", "am", "Landroid/app/ActivityManager;", "start", "facebook-core_release"}, k = 1, mv = {1, 5, 1})
public final class a {

    private static final int a;
    private static final ScheduledExecutorService b;
    private static String c;
    private static final Runnable d;

    @Metadata(d1 = "\u0000\u0008\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\u0008\u0002", d2 = {"<anonymous>", "", "run"}, k = 3, mv = {1, 5, 1})
    static final class a implements Runnable {

        public static final com.facebook.internal.g0.g.a.a a;
        static {
            a.a aVar = new a.a();
            a.a.a = aVar;
        }

        @Override // java.lang.Runnable
        public final void run() {
            Object systemService;
            if (a.d(this)) {
            }
            systemService = o.f().getSystemService("activity");
            if (systemService == null) {
            } else {
                a.a((ActivityManager)systemService);
            }
            NullPointerException nullPointerException = new NullPointerException("null cannot be cast to non-null type android.app.ActivityManager");
            throw nullPointerException;
        }
    }
    static {
        a.a = Process.myUid();
        a.b = Executors.newSingleThreadScheduledExecutor();
        a.c = "";
        a.d = a.a.a;
    }

    public static final void a(ActivityManager activityManager) {
        boolean next;
        int condition;
        int i;
        boolean z;
        Object obj5;
        if (a.d(a.class)) {
        }
        obj5 = activityManager.getProcessesInErrorState();
        if (activityManager != null && obj5 != null) {
            obj5 = activityManager.getProcessesInErrorState();
            if (obj5 != null) {
                obj5 = obj5.iterator();
                while (obj5.hasNext()) {
                    next = obj5.next();
                    Looper mainLooper = Looper.getMainLooper();
                    n.e(mainLooper, "Looper.getMainLooper()");
                    condition = mainLooper.getThread();
                    n.e(condition, "Looper.getMainLooper().thread");
                    i = f.d(condition);
                    if (next.condition == 2 && next.uid == a.a && !n.b(i, a.c)) {
                    }
                    if (next.uid == a.a) {
                    }
                    mainLooper = Looper.getMainLooper();
                    n.e(mainLooper, "Looper.getMainLooper()");
                    condition = mainLooper.getThread();
                    n.e(condition, "Looper.getMainLooper().thread");
                    i = f.d(condition);
                    if (!n.b(i, a.c)) {
                    }
                    if (!f.g(condition)) {
                    } else {
                    }
                    a.c = i;
                    b.a.a(next.shortMsg, i).g();
                }
            }
        }
    }

    public static final void b() {
        if (a.d(a.class)) {
        }
        a.b.scheduleAtFixedRate(a.d, 0, obj5, (long)i);
    }
}
