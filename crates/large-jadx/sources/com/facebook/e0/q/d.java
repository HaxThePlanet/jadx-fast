package com.facebook.e0.q;

import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalFocusChangeListener;
import android.widget.EditText;
import com.facebook.e0.m;
import com.facebook.e0.m.a;
import com.facebook.e0.v.b;
import com.facebook.internal.g0.i.a;
import java.lang.ref.WeakReference;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.d0.d.g;
import kotlin.d0.d.n;
import kotlin.k0.h;
import kotlin.k0.l;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010#\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u0008\u0001\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bB\u000f\u0008\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u001c\u0010\u000e\u001a\u00020\u000f2\u0008\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0008\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0016J\u0010\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u0011H\u0002J\u0010\u0010\u0015\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u0011H\u0002J\u0010\u0010\u0016\u001a\u00020\u000f2\u0006\u0010\u0017\u001a\u00020\u0018H\u0002J\u0008\u0010\u0019\u001a\u00020\u000fH\u0002J\u0008\u0010\u001a\u001a\u00020\u000fH\u0002R\u0014\u0010\u0005\u001a\u0008\u0012\u0004\u0012\u00020\u00030\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0008X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\u0008\u0012\u0004\u0012\u00020\u000b0\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000c\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001c", d2 = {"Lcom/facebook/appevents/aam/MetadataViewObserver;", "Landroid/view/ViewTreeObserver$OnGlobalFocusChangeListener;", "activity", "Landroid/app/Activity;", "(Landroid/app/Activity;)V", "activityWeakReference", "Ljava/lang/ref/WeakReference;", "isTracking", "Ljava/util/concurrent/atomic/AtomicBoolean;", "processedText", "", "", "uiThreadHandler", "Landroid/os/Handler;", "onGlobalFocusChanged", "", "oldView", "Landroid/view/View;", "newView", "process", "view", "processEditText", "runOnUIThread", "runnable", "Ljava/lang/Runnable;", "startTracking", "stopTracking", "Companion", "facebook-core_release"}, k = 1, mv = {1, 5, 1})
public final class d implements ViewTreeObserver.OnGlobalFocusChangeListener {

    private static final Map<Integer, com.facebook.e0.q.d> w;
    public static final com.facebook.e0.q.d.a x;
    private final Set<String> a;
    private final Handler b;
    private final WeakReference<Activity> c;
    private final AtomicBoolean v;

    @Metadata(d1 = "\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0008\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\tH\u0002J,\u0010\u000c\u001a\u00020\r2\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\u00062\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\tH\u0002J\u0010\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u0011H\u0007J\u0010\u0010\u0012\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u0011H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013", d2 = {"Lcom/facebook/appevents/aam/MetadataViewObserver$Companion;", "", "()V", "MAX_TEXT_LENGTH", "", "observers", "", "Lcom/facebook/appevents/aam/MetadataViewObserver;", "preNormalize", "", "key", "value", "putUserData", "", "userData", "startTrackingActivity", "activity", "Landroid/app/Activity;", "stopTrackingActivity", "facebook-core_release"}, k = 1, mv = {1, 5, 1})
    public static final class a {
        public a(g g) {
            super();
        }

        public static final String a(com.facebook.e0.q.d.a d$a, String string2, String string3) {
            return a.c(string2, string3);
        }

        public static final void b(com.facebook.e0.q.d.a d$a, Map map2, String string3, String string4) {
            a.d(map2, string3, string4);
        }

        private final String c(String string, String string2) {
            String str;
            boolean obj2;
            Object obj3;
            if (n.b("r2", string)) {
                obj2 = new h("[^\\d.]");
                obj3 = obj2.e(string2, "");
            }
            return obj3;
        }

        private final void d(Map<String, String> map, String string2, String string3) {
            boolean hVar2;
            int hVar;
            boolean str;
            java.lang.CharSequence obj8;
            hVar = 0;
            final int i2 = 2;
            final int i3 = 0;
            switch (string2) {
                case "r3":
                    hVar2 = "m";
                    obj8 = "f";
                    obj8 = hVar2;
                    break;
                case "r4":
                    hVar2 = new h("[^a-z]+");
                    obj8 = hVar2.e(string3, "");
                    break;
                case "r5":
                    hVar2 = new h("[^a-z]+");
                    obj8 = hVar2.e(string3, "");
                    break;
                case "r6":
                    hVar2 = "-";
                    hVar = new h(hVar2);
                    obj8 = hVar.f(string3, i3).toArray(new String[i3]);
                    Objects.requireNonNull(obj8, "null cannot be cast to non-null type kotlin.Array<T>");
                    obj8 = (String[])obj8[i3];
                    break;
                default:
            }
            map.put(string2, obj8);
        }

        public final void e(Activity activity) {
            Object dVar;
            int i;
            n.f(activity, "activity");
            final Map map = d.a();
            Integer valueOf = Integer.valueOf(activity.hashCode());
            if (map.get(valueOf) == null) {
                dVar = new d(activity, 0);
                map.put(valueOf, dVar);
            }
            d.c((d)dVar);
        }
    }

    @Metadata(d1 = "\u0000\u0008\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\u0008\u0002", d2 = {"<anonymous>", "", "run"}, k = 3, mv = {1, 5, 1})
    static final class b implements Runnable {

        final com.facebook.e0.q.d a;
        final View b;
        b(com.facebook.e0.q.d d, View view2) {
            this.a = d;
            this.b = view2;
            super();
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (a.d(this)) {
            }
            View view = this.b;
            if (!view instanceof EditText) {
            }
            d.b(this.a, view);
        }
    }
    static {
        d.a aVar = new d.a(0);
        d.x = aVar;
        HashMap hashMap = new HashMap();
        d.w = hashMap;
    }

    private d(Activity activity) {
        super();
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        this.a = linkedHashSet;
        Handler handler = new Handler(Looper.getMainLooper());
        this.b = handler;
        WeakReference weakReference = new WeakReference(activity);
        this.c = weakReference;
        AtomicBoolean obj3 = new AtomicBoolean(0);
        this.v = obj3;
    }

    public d(Activity activity, g g2) {
        super(activity);
    }

    public static final Map a() {
        if (a.d(d.class)) {
            return null;
        }
        return d.w;
    }

    public static final void b(com.facebook.e0.q.d d, View view2) {
        if (a.d(d.class)) {
        }
        d.e(view2);
    }

    public static final void c(com.facebook.e0.q.d d) {
        if (a.d(d.class)) {
        }
        d.g();
    }

    private final void d(View view) {
        if (a.d(this)) {
        }
        d.b bVar = new d.b(this, view);
        f(bVar);
    }

    private final void e(View view) {
        int hashMap;
        java.util.List i;
        int i2;
        Iterator iterator;
        boolean next;
        com.facebook.e0.q.d.a aVar;
        String str;
        boolean z;
        Object obj12;
        if (a.d(this)) {
        }
        if (view == null) {
        } else {
            String string = (EditText)view.getText().toString();
            if (string == null) {
            } else {
                String string2 = l.a1(string).toString();
                if (string2 == null) {
                } else {
                    String lowerCase = string2.toLowerCase();
                    n.e(lowerCase, "(this as java.lang.String).toLowerCase()");
                    final int i3 = 1;
                    final int i4 = 0;
                    hashMap = lowerCase.length() == 0 ? i3 : i4;
                    if (hashMap == null && !this.a.contains(lowerCase)) {
                        try {
                            if (!this.a.contains(lowerCase)) {
                            }
                            if (lowerCase.length() > 100) {
                            } else {
                            }
                            this.a.add(lowerCase);
                            hashMap = new HashMap();
                            i2 = 0;
                            iterator = c.e.c().iterator();
                            while (iterator.hasNext()) {
                                next = iterator.next();
                                aVar = d.x;
                                str = d.a.a(aVar, (c)next.c(), lowerCase);
                                if (next.d().length() > 0) {
                                } else {
                                }
                                z = i4;
                                if (z != 0 && !b.f(str, next.d())) {
                                } else {
                                }
                                if (b.e(b.b(view), next.b())) {
                                } else {
                                }
                                if (i2 == 0) {
                                }
                                if (b.e(i2, next.b())) {
                                }
                                d.a.b(aVar, hashMap, next.c(), str);
                                i2 = b.a(view);
                                d.a.b(aVar, hashMap, next.c(), str);
                                if (!b.f(str, next.d())) {
                                } else {
                                }
                                z = i3;
                            }
                            next = iterator.next();
                            aVar = d.x;
                            str = d.a.a(aVar, (c)next.c(), lowerCase);
                            if (next.d().length() > 0) {
                            } else {
                            }
                            z = i3;
                            z = i4;
                            if (z != 0 && !b.f(str, next.d())) {
                            } else {
                            }
                            if (!b.f(str, next.d())) {
                            } else {
                            }
                            if (b.e(i, next.b())) {
                            } else {
                            }
                            d.a.b(aVar, hashMap, next.c(), str);
                            if (i2 == 0) {
                            }
                            i2 = b.a(view);
                            if (b.e(i2, next.b())) {
                            }
                            d.a.b(aVar, hashMap, next.c(), str);
                            m.b.d(hashMap);
                            obj12 = new NullPointerException("null cannot be cast to non-null type java.lang.String");
                            throw obj12;
                            obj12 = new NullPointerException("null cannot be cast to non-null type kotlin.CharSequence");
                            throw obj12;
                            obj12 = new NullPointerException("null cannot be cast to non-null type android.widget.EditText");
                            throw obj12;
                            a.b(view, this);
                        }
                    }
                }
            }
        }
    }

    private final void f(Runnable runnable) {
        Object currentThread;
        if (a.d(this)) {
        }
        Looper mainLooper = Looper.getMainLooper();
        n.e(mainLooper, "Looper.getMainLooper()");
        if (Thread.currentThread() == mainLooper.getThread()) {
            runnable.run();
        } else {
            this.b.post(runnable);
        }
    }

    private final void g() {
        Object viewTreeObserver;
        int alive;
        if (a.d(this)) {
        }
        if (this.v.getAndSet(true)) {
        }
        viewTreeObserver = b.e((Activity)this.c.get());
        viewTreeObserver = viewTreeObserver.getViewTreeObserver();
        n.e(viewTreeObserver, "observer");
        if (viewTreeObserver != null && viewTreeObserver.isAlive()) {
            viewTreeObserver = viewTreeObserver.getViewTreeObserver();
            n.e(viewTreeObserver, "observer");
            if (viewTreeObserver.isAlive()) {
                viewTreeObserver.addOnGlobalFocusChangeListener(this);
            }
        }
        try {
            a.b(th, this);
        }
    }

    @Override // android.view.ViewTreeObserver$OnGlobalFocusChangeListener
    public void onGlobalFocusChanged(View view, View view2) {
        if (a.d(this)) {
        }
        if (view != null) {
            d(view);
        }
        if (view2 != null) {
            d(view2);
        }
    }
}
