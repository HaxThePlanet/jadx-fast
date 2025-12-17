package com.facebook.e0.r;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.ViewTreeObserver.OnScrollChangedListener;
import android.widget.AdapterView;
import com.facebook.FacebookException;
import com.facebook.e0.r.g.a;
import com.facebook.e0.r.g.a.b;
import com.facebook.e0.r.g.b;
import com.facebook.e0.r.g.f;
import com.facebook.e0.v.b;
import com.facebook.internal.b0;
import com.facebook.internal.g0.i.a;
import com.facebook.internal.p;
import com.facebook.internal.q;
import com.facebook.internal.t;
import com.facebook.o;
import java.lang.ref.WeakReference;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.WeakHashMap;
import kotlin.Metadata;
import kotlin.d0.d.g;
import kotlin.d0.d.n;
import kotlin.k0.l;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0008\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0008\t\u0008\u0001\u0018\u0000 \u00192\u00020\u0001:\u0003\u0019\u001a\u001bB\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0005H\u0007J\u0010\u0010\u0015\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0005H\u0007J\u0008\u0010\u0016\u001a\u00020\u0013H\u0002J\u0010\u0010\u0017\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0005H\u0007J\u0008\u0010\u0018\u001a\u00020\u0013H\u0002R\u0014\u0010\u0003\u001a\u0008\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R@\u0010\u0006\u001a4\u0012\u0004\u0012\u00020\u0008\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\n0\t0\u0007j\u001e\u0012\u0004\u0012\u00020\u0008\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\n0\tj\u0008\u0012\u0004\u0012\u00020\n`\u000c`\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\r\u001a\u0012\u0012\u0004\u0012\u00020\n0\tj\u0008\u0012\u0004\u0012\u00020\n`\u000cX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\u0008\u0012\u0004\u0012\u00020\u00110\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001c", d2 = {"Lcom/facebook/appevents/codeless/CodelessMatcher;", "", "()V", "activitiesSet", "", "Landroid/app/Activity;", "activityToListenerMap", "Ljava/util/HashMap;", "", "Ljava/util/HashSet;", "", "Lkotlin/collections/HashMap;", "Lkotlin/collections/HashSet;", "listenerSet", "uiThreadHandler", "Landroid/os/Handler;", "viewMatchers", "Lcom/facebook/appevents/codeless/CodelessMatcher$ViewMatcher;", "add", "", "activity", "destroy", "matchViews", "remove", "startTracking", "Companion", "MatchedView", "ViewMatcher", "facebook-core_release"}, k = 1, mv = {1, 5, 1})
public final class c {

    private static final String f = "com.facebook.e0.r.c";
    private static com.facebook.e0.r.c g;
    public static final com.facebook.e0.r.c.a h;
    private final Handler a;
    private final Set<Activity> b;
    private final Set<com.facebook.e0.r.c.c> c;
    private HashSet<String> d;
    private final HashMap<Integer, HashSet<String>> e;

    @Metadata(d1 = "\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J\u0008\u0010\t\u001a\u00020\u0008H\u0007J\"\u0010\n\u001a\u00020\u000b2\u0008\u0010\u000c\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000fH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\u0008X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0011", d2 = {"Lcom/facebook/appevents/codeless/CodelessMatcher$Companion;", "", "()V", "CURRENT_CLASS_NAME", "", "PARENT_CLASS_NAME", "TAG", "codelessMatcher", "Lcom/facebook/appevents/codeless/CodelessMatcher;", "getInstance", "getParameters", "Landroid/os/Bundle;", "mapping", "Lcom/facebook/appevents/codeless/internal/EventBinding;", "rootView", "Landroid/view/View;", "hostView", "facebook-core_release"}, k = 1, mv = {1, 5, 1})
    public static final class a {
        public a(g g) {
            super();
        }

        public final com.facebook.e0.r.c a() {
            com.facebook.e0.r.c cVar;
            int i;
            synchronized (this) {
                try {
                    cVar = new c(0);
                    c.d(cVar);
                    com.facebook.e0.r.c cVar2 = c.a();
                    if (cVar2 == null) {
                    } else {
                    }
                    return cVar2;
                    NullPointerException nullPointerException = new NullPointerException("null cannot be cast to non-null type com.facebook.appevents.codeless.CodelessMatcher");
                    throw nullPointerException;
                    throw th;
                }
            }
        }

        public final Bundle b(a a, View view2, View view3) {
            List iterator;
            String str;
            List list2;
            boolean next;
            View view;
            List list;
            int i2;
            int i4;
            String simpleName;
            Iterator iterator2;
            Object obj;
            int i;
            int i3;
            n.f(view2, "rootView");
            n.f(view3, "hostView");
            Bundle bundle = new Bundle();
            if (a == null) {
                return bundle;
            }
            iterator = a.c();
            if (iterator != null) {
                iterator2 = iterator.iterator();
                while (iterator2.hasNext()) {
                    obj = next2;
                    i = 1;
                    i3 = 0;
                    if ((b)obj.d() != null) {
                    } else {
                    }
                    if (obj.b().size() > 0) {
                    }
                    if (n.b(obj.c(), "relative")) {
                    } else {
                    }
                    simpleName = view2.getClass().getSimpleName();
                    n.e(simpleName, "rootView.javaClass.simpleName");
                    list2 = c.c.x.a(a, view2, obj.b(), 0, -1, simpleName);
                    iterator = list2.iterator();
                    while (iterator.hasNext()) {
                        next = iterator.next();
                        if ((c.b)next.a() != null) {
                            break loop_16;
                        } else {
                        }
                        next = f.k(next.a());
                        if (next.length() > 0) {
                        } else {
                        }
                        view = i3;
                        if (view != null) {
                            break loop_16;
                        } else {
                        }
                        view = i;
                    }
                    next = iterator.next();
                    if ((c.b)next.a() == null) {
                    } else {
                    }
                    next = f.k(next.a());
                    if (next.length() > 0) {
                    } else {
                    }
                    view = i3;
                    if (view != null) {
                    } else {
                    }
                    bundle.putString(obj.a(), next);
                    view = i;
                    simpleName = view3.getClass().getSimpleName();
                    n.e(simpleName, "hostView.javaClass.simpleName");
                    list2 = c.c.x.a(a, view3, obj.b(), 0, -1, simpleName);
                    if (obj.d().length() > 0) {
                    } else {
                    }
                    str = i3;
                    if (str != null) {
                    } else {
                    }
                    bundle.putString(obj.a(), obj.d());
                    str = i;
                }
            }
            return bundle;
        }
    }

    @Metadata(d1 = "\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0008\u0010\n\u001a\u0004\u0018\u00010\u0003R\u0016\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0008\u0010\t¨\u0006\u000b", d2 = {"Lcom/facebook/appevents/codeless/CodelessMatcher$MatchedView;", "", "view", "Landroid/view/View;", "viewMapKey", "", "(Landroid/view/View;Ljava/lang/String;)V", "Ljava/lang/ref/WeakReference;", "getViewMapKey", "()Ljava/lang/String;", "getView", "facebook-core_release"}, k = 1, mv = {1, 5, 1})
    public static final class b {

        private final WeakReference<View> a;
        private final String b;
        public b(View view, String string2) {
            n.f(view, "view");
            n.f(string2, "viewMapKey");
            super();
            WeakReference weakReference = new WeakReference(view);
            this.a = weakReference;
            this.b = string2;
        }

        public final View a() {
            Object obj;
            WeakReference weakReference = this.a;
            if (weakReference != null) {
                obj = weakReference.get();
            } else {
                obj = 0;
            }
            return obj;
        }

        public final String b() {
            return this.b;
        }
    }

    @Metadata(d1 = "\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u000b\u0008\u0007\u0018\u0000 \u001f2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001\u001fB7\u0012\u0008\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0016\u0010\u0008\u001a\u0012\u0012\u0004\u0012\u00020\n0\tj\u0008\u0012\u0004\u0012\u00020\n`\u000b\u0012\u0006\u0010\u000c\u001a\u00020\n¢\u0006\u0002\u0010\rJ\"\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0004\u001a\u00020\u00052\u0008\u0010\u0016\u001a\u0004\u0018\u00010\u0010H\u0002J \u0010\u0017\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u0010H\u0002J \u0010\u0018\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u0010H\u0002J \u0010\u0019\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u0010H\u0002J\u001c\u0010\u001a\u001a\u00020\u00132\u0008\u0010\u0016\u001a\u0004\u0018\u00010\u00102\u0008\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0002J\u0008\u0010\u001b\u001a\u00020\u0013H\u0016J\u0008\u0010\u001c\u001a\u00020\u0013H\u0016J\u0008\u0010\u001d\u001a\u00020\u0013H\u0016J\u0008\u0010\u001e\u001a\u00020\u0013H\u0002R\u000e\u0010\u000c\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u0008\u001a\u0012\u0012\u0004\u0012\u00020\n0\tj\u0008\u0012\u0004\u0012\u00020\n`\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0011X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006 ", d2 = {"Lcom/facebook/appevents/codeless/CodelessMatcher$ViewMatcher;", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "Landroid/view/ViewTreeObserver$OnScrollChangedListener;", "Ljava/lang/Runnable;", "rootView", "Landroid/view/View;", "handler", "Landroid/os/Handler;", "listenerSet", "Ljava/util/HashSet;", "", "Lkotlin/collections/HashSet;", "activityName", "(Landroid/view/View;Landroid/os/Handler;Ljava/util/HashSet;Ljava/lang/String;)V", "eventBindings", "", "Lcom/facebook/appevents/codeless/internal/EventBinding;", "Ljava/lang/ref/WeakReference;", "attachListener", "", "matchedView", "Lcom/facebook/appevents/codeless/CodelessMatcher$MatchedView;", "mapping", "attachOnClickListener", "attachOnItemClickListener", "attachRCTListener", "findView", "onGlobalLayout", "onScrollChanged", "run", "startMatch", "Companion", "facebook-core_release"}, k = 1, mv = {1, 5, 1})
    public static final class c implements ViewTreeObserver.OnGlobalLayoutListener, ViewTreeObserver.OnScrollChangedListener, Runnable {

        public static final com.facebook.e0.r.c.c.a x;
        private final WeakReference<View> a;
        private List<a> b;
        private final Handler c;
        private final HashSet<String> v;
        private final String w;
        static {
            c.c.a aVar = new c.c.a(0);
            c.c.x = aVar;
        }

        public c(View view, Handler handler2, HashSet<String> hashSet3, String string4) {
            n.f(handler2, "handler");
            n.f(hashSet3, "listenerSet");
            n.f(string4, "activityName");
            super();
            WeakReference weakReference = new WeakReference(view);
            this.a = weakReference;
            this.c = handler2;
            this.v = hashSet3;
            this.w = string4;
            handler2.postDelayed(this, 200);
        }

        private final void a(com.facebook.e0.r.c.b c$b, View view2, a a3) {
            boolean view3;
            View view;
            f fVar;
            com.facebook.e0.r.c.b obj7;
            View obj8;
            if (a3 == null) {
            }
            view3 = b.a();
            view = f.a(view3);
            if (view3 != null && view != null && f.d.p(view3, view)) {
                try {
                    view = f.a(view3);
                    if (view != null) {
                    }
                    if (f.d.p(view3, view)) {
                    }
                    d(b, view2, a3);
                    String name = view3.getClass().getName();
                    n.e(name, "view.javaClass.name");
                    if (l.M(name, "com.facebook.react", false, 2, 0)) {
                    }
                    if (view3 instanceof AdapterView == null) {
                    } else {
                    }
                    b(b, view2, a3);
                    if (view3 instanceof ListView != null) {
                    }
                    c(b, view2, a3);
                    view2 = c.b();
                    b0.c0(view2, b);
                }
            }
        }

        private final void b(com.facebook.e0.r.c.b c$b, View view2, a a3) {
            int i;
            android.view.View.OnClickListener list;
            String str;
            boolean contains;
            String obj4;
            Object obj5;
            final View view = b.a();
            if (view != null) {
                obj4 = b.b();
                list = f.g(view);
                Objects.requireNonNull(list, "null cannot be cast to non-null type com.facebook.appevents.codeless.CodelessLoggingEventListener.AutoLoggingOnClickListener");
                if (list instanceof a.a && (a.a)list.a()) {
                    Objects.requireNonNull(list, "null cannot be cast to non-null type com.facebook.appevents.codeless.CodelessLoggingEventListener.AutoLoggingOnClickListener");
                    i = (a.a)list.a() ? 1 : 0;
                } else {
                }
                if (!this.v.contains(obj4) && i == 0) {
                    if (i == 0) {
                        view.setOnClickListener(a.a(a3, view2, view));
                        this.v.add(obj4);
                    }
                }
            }
        }

        private final void c(com.facebook.e0.r.c.b c$b, View view2, a a3) {
            int i;
            android.widget.AdapterView.OnItemClickListener onItemClickListener;
            String str;
            boolean contains;
            String obj4;
            Object obj5;
            final View view = b.a();
            if ((AdapterView)view != null) {
                obj4 = b.b();
                onItemClickListener = (AdapterView)view.getOnItemClickListener();
                Objects.requireNonNull(onItemClickListener, "null cannot be cast to non-null type com.facebook.appevents.codeless.CodelessLoggingEventListener.AutoLoggingOnItemClickListener");
                if (onItemClickListener instanceof a.b && (a.b)onItemClickListener.a()) {
                    Objects.requireNonNull(onItemClickListener, "null cannot be cast to non-null type com.facebook.appevents.codeless.CodelessLoggingEventListener.AutoLoggingOnItemClickListener");
                    i = (a.b)onItemClickListener.a() ? 1 : 0;
                } else {
                }
                if (!this.v.contains(obj4) && i == 0) {
                    if (i == 0) {
                        view.setOnItemClickListener(a.b(a3, view2, view));
                        this.v.add(obj4);
                    }
                }
            }
        }

        private final void d(com.facebook.e0.r.c.b c$b, View view2, a a3) {
            int i;
            android.view.View.OnTouchListener list;
            String str;
            boolean contains;
            String obj4;
            Object obj5;
            final View view = b.a();
            if (view != null) {
                obj4 = b.b();
                list = f.h(view);
                Objects.requireNonNull(list, "null cannot be cast to non-null type com.facebook.appevents.codeless.RCTCodelessLoggingEventListener.AutoLoggingOnTouchListener");
                if (list instanceof d.a && (d.a)list.a()) {
                    Objects.requireNonNull(list, "null cannot be cast to non-null type com.facebook.appevents.codeless.RCTCodelessLoggingEventListener.AutoLoggingOnTouchListener");
                    i = (d.a)list.a() ? 1 : 0;
                } else {
                }
                if (!this.v.contains(obj4) && i == 0) {
                    if (i == 0) {
                        view.setOnTouchListener(d.a(a3, view2, view));
                        this.v.add(obj4);
                    }
                }
            }
        }

        private final void e(a a, View view2) {
            String length;
            int i;
            Iterator iterator;
            com.facebook.e0.r.c.c.a next;
            boolean next2;
            Object obj;
            View view;
            List list;
            int i2;
            int i3;
            String str;
            if (a != null) {
                if (view2 == null) {
                } else {
                    length = a.a();
                    int i4 = 1;
                    if (length != null) {
                        if (length.length() == 0) {
                            i = i4;
                        } else {
                            i = 0;
                        }
                    } else {
                    }
                    if (i == 0 && z ^= i4 != 0) {
                        if (z ^= i4 != 0) {
                        }
                    }
                    list = a.d();
                    if (list.size() > 25) {
                    }
                    iterator = c.c.x.a(a, view2, list, 0, -1, this.w).iterator();
                    for (c.b next : iterator) {
                        a(next, view2, a);
                    }
                }
            }
        }

        private final void f() {
            int obj2;
            int size;
            Object obj;
            Object obj3;
            final List list = this.b;
            if (list != null && this.a.get() != null) {
                if (this.a.get() != null) {
                    obj2 = 0;
                    while (obj2 < list.size()) {
                        e((a)list.get(obj2), (View)this.a.get());
                        obj2++;
                    }
                }
            }
        }

        @Override // android.view.ViewTreeObserver$OnGlobalLayoutListener
        public void onGlobalLayout() {
            f();
        }

        @Override // android.view.ViewTreeObserver$OnGlobalLayoutListener
        public void onScrollChanged() {
            f();
        }

        @Override // android.view.ViewTreeObserver$OnGlobalLayoutListener
        public void run() {
            Object viewTreeObserver;
            a.b alive;
            if (a.d(this)) {
            }
            viewTreeObserver = q.j(o.g());
            if (viewTreeObserver != null) {
                if (!viewTreeObserver.b()) {
                } else {
                    viewTreeObserver = a.e.b(viewTreeObserver.d());
                    this.b = viewTreeObserver;
                    viewTreeObserver = this.a.get();
                    n.e((View)viewTreeObserver, "rootView.get() ?: return");
                    viewTreeObserver = viewTreeObserver.getViewTreeObserver();
                    n.e(viewTreeObserver, "observer");
                    if (viewTreeObserver != null && viewTreeObserver != null && viewTreeObserver.isAlive()) {
                        viewTreeObserver = this.a.get();
                        if ((View)viewTreeObserver != null) {
                            try {
                                n.e((View)viewTreeObserver, "rootView.get() ?: return");
                                viewTreeObserver = viewTreeObserver.getViewTreeObserver();
                                n.e(viewTreeObserver, "observer");
                                if (viewTreeObserver.isAlive()) {
                                }
                                viewTreeObserver.addOnGlobalLayoutListener(this);
                                viewTreeObserver.addOnScrollChangedListener(this);
                                f();
                                a.b(th, this);
                            }
                        }
                    }
                }
            }
        }
    }

    @Metadata(d1 = "\u0000\u0008\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\u0008\u0002", d2 = {"<anonymous>", "", "run"}, k = 3, mv = {1, 5, 1})
    static final class d implements Runnable {

        final com.facebook.e0.r.c a;
        d(com.facebook.e0.r.c c) {
            this.a = c;
            super();
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (a.d(this)) {
            }
            c.c(this.a);
        }
    }
    static {
        c.a aVar = new c.a(0);
        c.h = aVar;
    }

    private c() {
        super();
        Handler handler = new Handler(Looper.getMainLooper());
        this.a = handler;
        WeakHashMap weakHashMap = new WeakHashMap();
        Set setFromMap = Collections.newSetFromMap(weakHashMap);
        n.e(setFromMap, "Collections.newSetFromMap(WeakHashMap())");
        this.b = setFromMap;
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        this.c = linkedHashSet;
        HashSet hashSet = new HashSet();
        this.d = hashSet;
        HashMap hashMap = new HashMap();
        this.e = hashMap;
    }

    public c(g g) {
        super();
    }

    public static final com.facebook.e0.r.c a() {
        if (a.d(c.class)) {
            return null;
        }
        return c.g;
    }

    public static final String b() {
        if (a.d(c.class)) {
            return null;
        }
        return c.f;
    }

    public static final void c(com.facebook.e0.r.c c) {
        if (a.d(c.class)) {
        }
        c.g();
    }

    public static final void d(com.facebook.e0.r.c c) {
        if (a.d(c.class)) {
        }
        c.g = c;
    }

    private final void g() {
        Object next;
        View view;
        com.facebook.e0.r.c.c cVar;
        Handler handler;
        HashSet set;
        if (a.d(this)) {
        }
        Iterator iterator = this.b.iterator();
        while (iterator.hasNext()) {
            next = iterator.next();
            if ((Activity)next != null) {
            }
            String simpleName = next.getClass().getSimpleName();
            n.e(simpleName, "activity.javaClass.simpleName");
            cVar = new c.c(b.e((Activity)next), this.a, this.d, simpleName);
            this.c.add(cVar);
        }
    }

    private final void i() {
        Object currentThread;
        Object dVar;
        if (a.d(this)) {
        }
        Looper mainLooper = Looper.getMainLooper();
        n.e(mainLooper, "Looper.getMainLooper()");
        if (Thread.currentThread() == mainLooper.getThread()) {
            g();
        } else {
            dVar = new c.d(this);
            this.a.post(dVar);
        }
    }

    public final void e(Activity activity) {
        Object str;
        if (a.d(this)) {
        }
        n.f(activity, "activity");
        if (t.b()) {
        }
        Looper mainLooper = Looper.getMainLooper();
        n.e(mainLooper, "Looper.getMainLooper()");
        if (Thread.currentThread() != mainLooper.getThread()) {
        } else {
            this.b.add(activity);
            this.d.clear();
            Object obj4 = this.e.get(Integer.valueOf(activity.hashCode()));
            if ((HashSet)obj4 != null) {
                n.e((HashSet)obj4, "it");
                this.d = obj4;
            }
            try {
                i();
                obj4 = new FacebookException("Can't add activity to CodelessMatcher on non-UI thread");
                throw obj4;
                a.b(activity, this);
            }
        }
    }

    public final void f(Activity activity) {
        if (a.d(this)) {
        }
        n.f(activity, "activity");
        this.e.remove(Integer.valueOf(activity.hashCode()));
    }

    public final void h(Activity activity) {
        if (a.d(this)) {
        }
        n.f(activity, "activity");
        if (t.b()) {
        }
        Looper mainLooper = Looper.getMainLooper();
        n.e(mainLooper, "Looper.getMainLooper()");
        if (Thread.currentThread() != mainLooper.getThread()) {
        } else {
            this.b.remove(activity);
            this.c.clear();
            Object clone = this.d.clone();
            if (clone == null) {
            } else {
                this.e.put(Integer.valueOf(activity.hashCode()), (HashSet)clone);
                this.d.clear();
            }
            try {
                NullPointerException obj4 = new NullPointerException("null cannot be cast to non-null type kotlin.collections.HashSet<kotlin.String> /* = java.util.HashSet<kotlin.String> */");
                throw obj4;
                obj4 = new FacebookException("Can't remove activity from CodelessMatcher on non-UI thread");
                throw obj4;
                a.b(activity, this);
            }
        }
    }
}
