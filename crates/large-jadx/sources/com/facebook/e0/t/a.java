package com.facebook.e0.t;

import android.app.Activity;
import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import com.facebook.e0.v.d;
import com.facebook.o;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.d0.d.n;
import org.json.JSONObject;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u0008Æ\u0002\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J\u0008\u0010\u0014\u001a\u00020\u0015H\u0002J0\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u00182\u0016\u0010\u0019\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u001aj\u0008\u0012\u0004\u0012\u00020\u0004`\u001b2\u0006\u0010\u001c\u001a\u00020\nH\u0002J\u0008\u0010\u001d\u001a\u00020\u0015H\u0007J\u0008\u0010\u001e\u001a\u00020\u0015H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0008X\u0082.¢\u0006\u0002\n\u0000R\u0012\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u000bR\u0012\u0010\u000c\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u000bR\u0010\u0010\r\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082.¢\u0006\u0002\n\u0000¨\u0006\u001f", d2 = {"Lcom/facebook/appevents/iap/InAppPurchaseActivityLifecycleTracker;", "", "()V", "BILLING_ACTIVITY_NAME", "", "SERVICE_INTERFACE_NAME", "TAG", "callbacks", "Landroid/app/Application$ActivityLifecycleCallbacks;", "hasBillingActivity", "", "Ljava/lang/Boolean;", "hasBillingService", "inAppBillingObj", "intent", "Landroid/content/Intent;", "isTracking", "Ljava/util/concurrent/atomic/AtomicBoolean;", "serviceConnection", "Landroid/content/ServiceConnection;", "initializeIfNotInitialized", "", "logPurchase", "context", "Landroid/content/Context;", "purchases", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "isSubscription", "startIapLogging", "startTracking", "facebook-core_release"}, k = 1, mv = {1, 5, 1})
public final class a {

    private static final String a = "com.facebook.e0.t.a";
    private static final AtomicBoolean b;
    private static Boolean c;
    private static Boolean d;
    private static ServiceConnection e;
    private static Application.ActivityLifecycleCallbacks f;
    private static Intent g;
    private static Object h;
    public static final com.facebook.e0.t.a i;

    @Metadata(d1 = "\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002*\u0001\u0000\u0008\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\u0008\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\t", d2 = {"com/facebook/appevents/iap/InAppPurchaseActivityLifecycleTracker$initializeIfNotInitialized$1", "Landroid/content/ServiceConnection;", "onServiceConnected", "", "name", "Landroid/content/ComponentName;", "service", "Landroid/os/IBinder;", "onServiceDisconnected", "facebook-core_release"}, k = 1, mv = {1, 5, 1})
    public static final class a implements ServiceConnection {
        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder2) {
            n.f(componentName, "name");
            n.f(iBinder2, "service");
            a.d(a.i, d.a(o.f(), iBinder2));
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            n.f(componentName, "name");
        }
    }

    @Metadata(d1 = "\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0008*\u0001\u0000\u0008\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0008\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\u0010\u0010\u0008\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0018\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u000c\u001a\u00020\u0007H\u0016J\u0010\u0010\r\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u000f", d2 = {"com/facebook/appevents/iap/InAppPurchaseActivityLifecycleTracker$initializeIfNotInitialized$2", "Landroid/app/Application$ActivityLifecycleCallbacks;", "onActivityCreated", "", "activity", "Landroid/app/Activity;", "savedInstanceState", "Landroid/os/Bundle;", "onActivityDestroyed", "onActivityPaused", "onActivityResumed", "onActivitySaveInstanceState", "outState", "onActivityStarted", "onActivityStopped", "facebook-core_release"}, k = 1, mv = {1, 5, 1})
    public static final class b implements Application.ActivityLifecycleCallbacks {
        @Override // android.app.Application$ActivityLifecycleCallbacks
        public void onActivityCreated(Activity activity, Bundle bundle2) {
            n.f(activity, "activity");
        }

        @Override // android.app.Application$ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity activity) {
            n.f(activity, "activity");
        }

        @Override // android.app.Application$ActivityLifecycleCallbacks
        public void onActivityPaused(Activity activity) {
            n.f(activity, "activity");
        }

        @Override // android.app.Application$ActivityLifecycleCallbacks
        public void onActivityResumed(Activity activity) {
            n.f(activity, "activity");
            o.n().execute(a.b.a.a);
        }

        @Override // android.app.Application$ActivityLifecycleCallbacks
        public void onActivitySaveInstanceState(Activity activity, Bundle bundle2) {
            n.f(activity, "activity");
            n.f(bundle2, "outState");
        }

        @Override // android.app.Application$ActivityLifecycleCallbacks
        public void onActivityStarted(Activity activity) {
            n.f(activity, "activity");
        }

        @Override // android.app.Application$ActivityLifecycleCallbacks
        public void onActivityStopped(Activity activity) {
            boolean str;
            Object obj3;
            n.f(activity, "activity");
            if (n.b(a.a(a.i), Boolean.TRUE) && n.b(activity.getLocalClassName(), "com.android.billingclient.api.ProxyBillingActivity")) {
                if (n.b(activity.getLocalClassName(), "com.android.billingclient.api.ProxyBillingActivity")) {
                    o.n().execute(a.b.b.a);
                }
            }
        }
    }
    static {
        a aVar = new a();
        a.i = aVar;
        AtomicBoolean atomicBoolean = new AtomicBoolean(0);
        a.b = atomicBoolean;
    }

    public static final Boolean a(com.facebook.e0.t.a a) {
        return a.d;
    }

    public static final Object b(com.facebook.e0.t.a a) {
        return a.h;
    }

    public static final void c(com.facebook.e0.t.a a, Context context2, ArrayList arrayList3, boolean z4) {
        a.f(context2, arrayList3, z4);
    }

    public static final void d(com.facebook.e0.t.a a, Object object2) {
        a.h = object2;
    }

    private final void e() {
        int i2;
        int i;
        if (a.c != null) {
        }
        final int i3 = 0;
        i2 = h.a("com.android.vending.billing.IInAppBillingService$Stub") != null ? i : i3;
        Boolean valueOf = Boolean.valueOf(i2);
        a.c = valueOf;
        if (n.b(valueOf, Boolean.FALSE)) {
        }
        if (h.a("com.android.billingclient.api.ProxyBillingActivity") != null) {
        } else {
            i = i3;
        }
        a.d = Boolean.valueOf(i);
        d.b();
        Intent intent = new Intent("com.android.vending.billing.InAppBillingService.BIND");
        Intent package = intent.setPackage("com.android.vending");
        n.e(package, "Intent(\"com.android.vend…ge(\"com.android.vending\")");
        a.g = package;
        a.a aVar = new a.a();
        a.e = aVar;
        a.b bVar = new a.b();
        a.f = bVar;
    }

    private final void f(Context context, ArrayList<String> arrayList2, boolean z3) {
        ArrayList arrayList;
        Object next;
        boolean next2;
        String string;
        String str;
        Object obj7;
        if (arrayList2.isEmpty()) {
        }
        HashMap hashMap = new HashMap();
        arrayList = new ArrayList();
        obj7 = arrayList2.iterator();
        for (String next : obj7) {
            JSONObject jSONObject = new JSONObject(next);
            string = jSONObject.getString("productId");
            n.e(string, "sku");
            n.e(next, "purchase");
            hashMap.put(string, next);
            arrayList.add(string);
        }
        Iterator obj6 = d.k(context, arrayList, a.h, z3).entrySet().iterator();
        while (obj6.hasNext()) {
            obj7 = obj6.next();
            arrayList = hashMap.get((String)(Map.Entry)obj7.getKey());
            if ((String)arrayList != null) {
            }
            n.e((String)arrayList, "it");
            d.f(arrayList, (String)obj7.getValue(), z3);
        }
    }

    public static final void g() {
        final com.facebook.e0.t.a aVar = a.i;
        aVar.e();
        if (n.b(a.c, Boolean.FALSE)) {
        }
        if (d.c()) {
            aVar.h();
        }
    }

    private final void h() {
        boolean intent;
        ServiceConnection service;
        int i;
        final int i3 = 1;
        if (!a.b.compareAndSet(false, i3)) {
        }
        Context context = o.f();
        if (context instanceof Application) {
            Application.ActivityLifecycleCallbacks activity = a.f;
            i = 0;
            if (activity == null) {
            } else {
                (Application)context.registerActivityLifecycleCallbacks(activity);
                intent = a.g;
                if (intent == null) {
                } else {
                    service = a.e;
                    if (service == null) {
                    } else {
                        context.bindService(intent, service, i3);
                    }
                    n.w("serviceConnection");
                    throw i;
                }
                n.w("intent");
                throw i;
            }
            n.w("callbacks");
            throw i;
        }
    }
}
