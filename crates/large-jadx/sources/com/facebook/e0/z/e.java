package com.facebook.e0.z;

import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import com.facebook.e0.r.g.d;
import com.facebook.e0.v.b;
import com.facebook.internal.g0.i.a;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.d0.d.g;
import kotlin.d0.d.n;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0008\u0005\u0008\u0001\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B\u000f\u0008\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0008\u0010\u000b\u001a\u00020\u000cH\u0016J\u0008\u0010\r\u001a\u00020\u000cH\u0002J\u0008\u0010\u000e\u001a\u00020\u000cH\u0002J\u0008\u0010\u000f\u001a\u00020\u000cH\u0002R\u0014\u0010\u0005\u001a\u0008\u0012\u0004\u0012\u00020\u00030\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0008X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011", d2 = {"Lcom/facebook/appevents/suggestedevents/ViewObserver;", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "activity", "Landroid/app/Activity;", "(Landroid/app/Activity;)V", "activityWeakReference", "Ljava/lang/ref/WeakReference;", "isTracking", "Ljava/util/concurrent/atomic/AtomicBoolean;", "uiThreadHandler", "Landroid/os/Handler;", "onGlobalLayout", "", "process", "startTracking", "stopTracking", "Companion", "facebook-core_release"}, k = 1, mv = {1, 5, 1})
public final class e implements ViewTreeObserver.OnGlobalLayoutListener {

    private static final Map<Integer, com.facebook.e0.z.e> v;
    public static final com.facebook.e0.z.e.a w;
    private final WeakReference<Activity> a;
    private final Handler b;
    private final AtomicBoolean c;

    @Metadata(d1 = "\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0008\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0007J\u0010\u0010\u000c\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r", d2 = {"Lcom/facebook/appevents/suggestedevents/ViewObserver$Companion;", "", "()V", "MAX_TEXT_LENGTH", "", "observers", "", "Lcom/facebook/appevents/suggestedevents/ViewObserver;", "startTrackingActivity", "", "activity", "Landroid/app/Activity;", "stopTrackingActivity", "facebook-core_release"}, k = 1, mv = {1, 5, 1})
    public static final class a {
        public a(g g) {
            super();
        }

        public final void a(Activity activity) {
            Object eVar;
            int i;
            n.f(activity, "activity");
            final Map map = e.b();
            Integer valueOf = Integer.valueOf(activity.hashCode());
            if (map.get(valueOf) == null) {
                eVar = new e(activity, 0);
                map.put(valueOf, eVar);
            }
            e.c((e)eVar);
        }

        public final void b(Activity activity) {
            Object valueOf;
            int obj3;
            n.f(activity, "activity");
            obj3 = activity.hashCode();
            Object obj = e.b().get(Integer.valueOf(obj3));
            if ((e)obj != null) {
                e.b().remove(Integer.valueOf(obj3));
                e.d((e)obj);
            }
        }
    }

    @Metadata(d1 = "\u0000\u0008\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\u0008\u0002", d2 = {"<anonymous>", "", "run"}, k = 3, mv = {1, 5, 1})
    static final class b implements Runnable {

        final com.facebook.e0.z.e a;
        b(com.facebook.e0.z.e e) {
            this.a = e;
            super();
        }

        @Override // java.lang.Runnable
        public final void run() {
            View view;
            Object next;
            String length;
            int localClassName;
            String str;
            if (a.d(this)) {
            }
            view = b.e((Activity)e.a(this.a).get());
            Object obj2 = e.a(this.a).get();
            if (view != null && (Activity)obj2 == null) {
                if ((Activity)obj2 == null) {
                }
                Iterator iterator = c.a(view).iterator();
                while (iterator.hasNext()) {
                    next = iterator.next();
                    if (d.g((View)next)) {
                    } else {
                    }
                    length = c.d(next);
                    if (length.length() > 0) {
                    } else {
                    }
                    localClassName = 0;
                    if (localClassName != 0 && length.length() <= 300) {
                    }
                    if (length.length() <= 300) {
                    }
                    localClassName = (Activity)obj2.getLocalClassName();
                    n.e(localClassName, "activity.localClassName");
                    f.x.c(next, view, localClassName);
                    localClassName = 1;
                }
            }
        }
    }
    static {
        e.a aVar = new e.a(0);
        e.w = aVar;
        HashMap hashMap = new HashMap();
        e.v = hashMap;
    }

    private e(Activity activity) {
        super();
        WeakReference weakReference = new WeakReference(activity);
        this.a = weakReference;
        Handler obj2 = new Handler(Looper.getMainLooper());
        this.b = obj2;
        obj2 = new AtomicBoolean(0);
        this.c = obj2;
    }

    public e(Activity activity, g g2) {
        super(activity);
    }

    public static final WeakReference a(com.facebook.e0.z.e e) {
        if (a.d(e.class)) {
            return null;
        }
        return e.a;
    }

    public static final Map b() {
        if (a.d(e.class)) {
            return null;
        }
        return e.v;
    }

    public static final void c(com.facebook.e0.z.e e) {
        if (a.d(e.class)) {
        }
        e.f();
    }

    public static final void d(com.facebook.e0.z.e e) {
        if (a.d(e.class)) {
        }
        e.g();
    }

    private final void e() {
        Object currentThread;
        if (a.d(this)) {
        }
        e.b bVar = new e.b(this);
        Looper mainLooper = Looper.getMainLooper();
        n.e(mainLooper, "Looper.getMainLooper()");
        if (Thread.currentThread() == mainLooper.getThread()) {
            bVar.run();
        } else {
            this.b.post(bVar);
        }
    }

    private final void f() {
        Object viewTreeObserver;
        int alive;
        if (a.d(this)) {
        }
        if (this.c.getAndSet(true)) {
        }
        viewTreeObserver = b.e((Activity)this.a.get());
        viewTreeObserver = viewTreeObserver.getViewTreeObserver();
        n.e(viewTreeObserver, "observer");
        if (viewTreeObserver != null && viewTreeObserver.isAlive()) {
            viewTreeObserver = viewTreeObserver.getViewTreeObserver();
            n.e(viewTreeObserver, "observer");
            if (viewTreeObserver.isAlive()) {
                viewTreeObserver.addOnGlobalLayoutListener(this);
                e();
            }
        }
        try {
            a.b(th, this);
        }
    }

    private final void g() {
        Object viewTreeObserver;
        int alive;
        if (a.d(this)) {
        }
        if (!this.c.getAndSet(false)) {
        }
        viewTreeObserver = b.e((Activity)this.a.get());
        viewTreeObserver = viewTreeObserver.getViewTreeObserver();
        n.e(viewTreeObserver, "observer");
        if (viewTreeObserver != null && !viewTreeObserver.isAlive()) {
            viewTreeObserver = viewTreeObserver.getViewTreeObserver();
            n.e(viewTreeObserver, "observer");
            if (!viewTreeObserver.isAlive()) {
            }
            try {
                viewTreeObserver.removeOnGlobalLayoutListener(this);
                a.b(th, this);
            }
        }
    }

    @Override // android.view.ViewTreeObserver$OnGlobalLayoutListener
    public void onGlobalLayout() {
        if (a.d(this)) {
        }
        e();
    }
}
