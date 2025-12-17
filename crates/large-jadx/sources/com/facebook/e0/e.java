package com.facebook.e0;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import com.facebook.internal.g0.i.a;
import com.facebook.internal.p;
import com.facebook.internal.q;
import com.facebook.internal.v;
import com.facebook.internal.v.a;
import com.facebook.n;
import com.facebook.o;
import com.facebook.p;
import com.facebook.p.b;
import com.facebook.p.c;
import com.facebook.s;
import com.facebook.v;
import d.q.a.a;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.d0.d.f0;
import kotlin.d0.d.n;
import org.json.JSONArray;
import org.json.JSONException;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000~\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\"\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0008Á\u0002\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0007J*\u0010\u0018\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001fH\u0007J\u001e\u0010 \u001a\u0008\u0012\u0004\u0012\u00020\u00190!2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\"\u001a\u00020\u001fH\u0007J\u0010\u0010#\u001a\u00020\u00132\u0006\u0010$\u001a\u00020%H\u0007J\u0010\u0010&\u001a\u00020\u00132\u0006\u0010$\u001a\u00020%H\u0007J\u000e\u0010'\u001a\u0008\u0012\u0004\u0012\u00020\u00150(H\u0007J0\u0010)\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010*\u001a\u00020\u00192\u0006\u0010+\u001a\u00020,2\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001e\u001a\u00020\u001fH\u0007J\u0008\u0010-\u001a\u00020\u0013H\u0007J\u001a\u0010.\u001a\u0004\u0018\u00010\u001f2\u0006\u0010$\u001a\u00020%2\u0006\u0010\t\u001a\u00020\nH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0008X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u000cX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\u0008\u0012\u0002\u0008\u0003\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u000f\u001a\n \u0011*\u0004\u0018\u00010\u00100\u0010X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006/", d2 = {"Lcom/facebook/appevents/AppEventQueue;", "", "()V", "FLUSH_PERIOD_IN_SECONDS", "", "NO_CONNECTIVITY_ERROR_CODE", "NUM_LOG_EVENTS_TO_TRY_TO_FLUSH_AFTER", "TAG", "", "appEventCollection", "Lcom/facebook/appevents/AppEventCollection;", "flushRunnable", "Ljava/lang/Runnable;", "scheduledFuture", "Ljava/util/concurrent/ScheduledFuture;", "singleThreadExecutor", "Ljava/util/concurrent/ScheduledExecutorService;", "kotlin.jvm.PlatformType", "add", "", "accessTokenAppId", "Lcom/facebook/appevents/AccessTokenAppIdPair;", "appEvent", "Lcom/facebook/appevents/AppEvent;", "buildRequestForSession", "Lcom/facebook/GraphRequest;", "appEvents", "Lcom/facebook/appevents/SessionEventsState;", "limitEventUsage", "", "flushState", "Lcom/facebook/appevents/FlushStatistics;", "buildRequests", "", "flushResults", "flush", "reason", "Lcom/facebook/appevents/FlushReason;", "flushAndWait", "getKeySet", "", "handleResponse", "request", "response", "Lcom/facebook/GraphResponse;", "persistToDisk", "sendEventsToServer", "facebook-core_release"}, k = 1, mv = {1, 5, 1})
public final class e {

    private static final String a;
    private static final int b = 100;
    private static volatile com.facebook.e0.d c;
    private static final ScheduledExecutorService d;
    private static ScheduledFuture<?> e;
    private static final Runnable f;
    public static final com.facebook.e0.e g;

    @Metadata(d1 = "\u0000\u0008\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\u0008\u0002", d2 = {"<anonymous>", "", "run"}, k = 3, mv = {1, 5, 1})
    static final class a implements Runnable {

        final com.facebook.e0.a a;
        final com.facebook.e0.c b;
        a(com.facebook.e0.a a, com.facebook.e0.c c2) {
            this.a = a;
            this.b = c2;
            super();
        }

        @Override // java.lang.Runnable
        public final void run() {
            Object eVENT_THRESHOLD;
            int schedule;
            int eXPLICIT_ONLY;
            com.facebook.e0.c cVar;
            TimeUnit sECONDS;
            if (a.d(this)) {
            }
            eVENT_THRESHOLD = e.g;
            e.a(eVENT_THRESHOLD).a(this.a, this.b);
            if (g.b.c() != g.b.EXPLICIT_ONLY && e.a(eVENT_THRESHOLD).d() > e.c(eVENT_THRESHOLD)) {
                if (e.a(eVENT_THRESHOLD).d() > e.c(eVENT_THRESHOLD)) {
                    e.l(j.EVENT_THRESHOLD);
                } else {
                    if (e.d(eVENT_THRESHOLD) == null) {
                        e.g(eVENT_THRESHOLD, e.e(eVENT_THRESHOLD).schedule(e.b(eVENT_THRESHOLD), (long)i, obj4));
                    }
                }
            } else {
            }
            try {
                a.b(th, this);
            }
        }
    }

    @Metadata(d1 = "\u0000\u0008\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\u0008\u0002", d2 = {"<anonymous>", "", "run"}, k = 3, mv = {1, 5, 1})
    static final class c implements Runnable {

        final com.facebook.e0.j a;
        c(com.facebook.e0.j j) {
            this.a = j;
            super();
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (a.d(this)) {
            }
            e.l(this.a);
        }
    }

    @Metadata(d1 = "\u0000\u0008\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\u0008\u0002", d2 = {"<anonymous>", "", "run"}, k = 3, mv = {1, 5, 1})
    static final class d implements Runnable {

        public static final com.facebook.e0.e.d a;
        static {
            e.d dVar = new e.d();
            e.d.a = dVar;
        }

        @Override // java.lang.Runnable
        public final void run() {
            Enum tIMER;
            if (a.d(this)) {
            }
            e.g(e.g, 0);
            if (g.b.c() != g.b.EXPLICIT_ONLY) {
                e.l(j.TIMER);
            }
        }
    }

    @Metadata(d1 = "\u0000\u0008\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\u0008\u0002", d2 = {"<anonymous>", "", "run"}, k = 3, mv = {1, 5, 1})
    static final class e implements Runnable {

        final com.facebook.e0.a a;
        final com.facebook.e0.o b;
        e(com.facebook.e0.a a, com.facebook.e0.o o2) {
            this.a = a;
            this.b = o2;
            super();
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (a.d(this)) {
            }
            f.a(this.a, this.b);
        }
    }

    @Metadata(d1 = "\u0000\u0008\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\u0008\u0002", d2 = {"<anonymous>", "", "run"}, k = 3, mv = {1, 5, 1})
    static final class f implements Runnable {

        public static final com.facebook.e0.e.f a;
        static {
            e.f fVar = new e.f();
            e.f.a = fVar;
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (a.d(this)) {
            }
            com.facebook.e0.e eVar = e.g;
            f.b(e.a(eVar));
            d dVar2 = new d();
            e.f(eVar, dVar2);
        }
    }

    @Metadata(d1 = "\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\u0008\u0004", d2 = {"<anonymous>", "", "response", "Lcom/facebook/GraphResponse;", "onCompleted"}, k = 3, mv = {1, 5, 1})
    static final class b implements p.b {

        final com.facebook.e0.a a;
        final p b;
        final com.facebook.e0.o c;
        final com.facebook.e0.l d;
        b(com.facebook.e0.a a, p p2, com.facebook.e0.o o3, com.facebook.e0.l l4) {
            this.a = a;
            this.b = p2;
            this.c = o3;
            this.d = l4;
            super();
        }

        @Override // com.facebook.p$b
        public final void b(s s) {
            n.f(s, "response");
            e.n(this.a, this.b, s, this.c, this.d);
        }
    }
    static {
        e eVar = new e();
        e.g = eVar;
        String name = e.class.getName();
        n.e(name, "AppEventQueue::class.java.name");
        e.a = name;
        int i = 100;
        d dVar = new d();
        e.c = dVar;
        e.d = Executors.newSingleThreadScheduledExecutor();
        e.f = e.d.a;
    }

    public static final com.facebook.e0.d a(com.facebook.e0.e e) {
        if (a.d(e.class)) {
            return null;
        }
        return e.c;
    }

    public static final Runnable b(com.facebook.e0.e e) {
        if (a.d(e.class)) {
            return null;
        }
        return e.f;
    }

    public static final int c(com.facebook.e0.e e) {
        if (a.d(e.class)) {
            return 0;
        }
        return e.b;
    }

    public static final ScheduledFuture d(com.facebook.e0.e e) {
        if (a.d(e.class)) {
            return null;
        }
        return e.e;
    }

    public static final ScheduledExecutorService e(com.facebook.e0.e e) {
        if (a.d(e.class)) {
            return null;
        }
        return e.d;
    }

    public static final void f(com.facebook.e0.e e, com.facebook.e0.d d2) {
        if (a.d(e.class)) {
        }
        e.c = d2;
    }

    public static final void g(com.facebook.e0.e e, ScheduledFuture scheduledFuture2) {
        if (a.d(e.class)) {
        }
        e.e = scheduledFuture2;
    }

    public static final void h(com.facebook.e0.a a, com.facebook.e0.c c2) {
        if (a.d(e.class)) {
        }
        n.f(a, "accessTokenAppId");
        n.f(c2, "appEvent");
        e.a aVar = new e.a(a, c2);
        e.d.execute(aVar);
    }

    public static final p i(com.facebook.e0.a a, com.facebook.e0.o o2, boolean z3, com.facebook.e0.l l4) {
        int i;
        Bundle bundle;
        String str;
        final int i2 = 0;
        if (a.d(e.class)) {
            return i2;
        }
        n.f(a, "accessTokenAppId");
        n.f(o2, "appEvents");
        n.f(l4, "flushState");
        String str5 = a.b();
        i = 0;
        p pVar2 = q.o(str5, i);
        f0 f0Var = f0.a;
        int i5 = 1;
        final Object[] arr = new Object[i5];
        arr[i] = str5;
        String format = String.format("%s/activities", Arrays.copyOf(arr, i5));
        n.e(format, "java.lang.String.format(format, *args)");
        p pVar = p.t.x(i2, format, i2, i2);
        pVar.C(i5);
        if (pVar.s() == null) {
            bundle = new Bundle();
        }
        bundle.putString("access_token", a.a());
        String str9 = m.b.c();
        if (str9 != null) {
            bundle.putString("device_token", str9);
        }
        String str10 = h.j.i();
        if (str10 != null) {
            bundle.putString("install_referrer", str10);
        }
        pVar.F(bundle);
        if (pVar2 != null) {
            i = pVar2.l();
        }
        try {
            int obj11 = o2.e(pVar, o.f(), i, z3);
            if (obj11 == null) {
            }
            return i2;
            l4.c(i3 += obj11);
            obj11 = new e.b(a, pVar, o2, l4);
            pVar.B(obj11);
            return pVar;
            a.b(a, obj0);
            return obj2;
        }
    }

    public static final List<p> j(com.facebook.e0.d d, com.facebook.e0.l l2) {
        p pVar;
        com.facebook.e0.o oVar;
        if (a.d(e.class)) {
            return 0;
        }
        n.f(d, "appEventCollection");
        n.f(l2, "flushResults");
        ArrayList arrayList = new ArrayList();
        Iterator iterator = d.f().iterator();
        for (a next2 : iterator) {
            oVar = d.c(next2);
            pVar = e.i(next2, oVar, o.s(o.f()), l2);
            if (pVar != null) {
            }
            arrayList.add(pVar);
        }
        return arrayList;
    }

    public static final void k(com.facebook.e0.j j) {
        if (a.d(e.class)) {
        }
        n.f(j, "reason");
        e.c cVar = new e.c(j);
        e.d.execute(cVar);
    }

    public static final void l(com.facebook.e0.j j) {
        Object intent;
        Object str;
        int i;
        Object obj4;
        if (a.d(e.class)) {
        }
        n.f(j, "reason");
        e.c.b(f.c());
        obj4 = e.p(j, e.c);
        if (obj4 != null) {
            intent = new Intent("com.facebook.sdk.APP_EVENTS_FLUSHED");
            intent.putExtra("com.facebook.sdk.APP_EVENTS_NUM_EVENTS_FLUSHED", obj4.a());
            intent.putExtra("com.facebook.sdk.APP_EVENTS_FLUSH_RESULT", obj4.b());
            a.b(o.f()).d(intent);
        }
    }

    public static final Set<com.facebook.e0.a> m() {
        if (a.d(e.class)) {
            return 0;
        }
        return e.c.f();
    }

    public static final void n(com.facebook.e0.a a, p p2, s s3, com.facebook.e0.o o4, com.facebook.e0.l l5) {
        com.facebook.e0.k sUCCESS;
        Object obj;
        Object str3;
        String eVar;
        String format;
        com.facebook.e0.k nO_CONNECTIVITY;
        int arr;
        int i;
        v.a aVar;
        v aPP_EVENTS;
        String str;
        String str2;
        Object obj2 = a;
        final Object obj3 = o4;
        final Object obj4 = l5;
        if (a.d(e.class)) {
        }
        n.f(obj2, "accessTokenAppId");
        n.f(p2, "request");
        n.f(s3, "response");
        n.f(obj3, "appEvents");
        n.f(obj4, "flushState");
        n nVar = s3.b();
        format = "Success";
        nO_CONNECTIVITY = k.SUCCESS;
        arr = 2;
        i = 1;
        final int i5 = 0;
        if (nVar != null) {
            if (nVar.b() == -1) {
                format = "Failed: No Connectivity";
                nO_CONNECTIVITY = k.NO_CONNECTIVITY;
            } else {
                f0 f0Var = f0.a;
                Object[] arr2 = new Object[arr];
                arr2[i5] = s3.toString();
                arr2[i] = nVar.toString();
                n.e(String.format("Failed:\n  Response: %s\n  Error %s", Arrays.copyOf(arr2, arr)), "java.lang.String.format(format, *args)");
                nO_CONNECTIVITY = k.SERVER_ERROR;
            }
        }
        if (o.A(v.APP_EVENTS)) {
            JSONArray jSONArray = new JSONArray((String)p2.u());
            n.e(jSONArray.toString(arr), "jsonArray.toString(2)");
            arr = new Object[3];
            arr[i5] = String.valueOf(p2.o());
            arr[i] = format;
            arr[2] = eVar;
            v.f.c(v.APP_EVENTS, e.a, "Flush completed\nParams: %s\n  Result: %s\n  Events JSON: %s", arr);
        }
        if (nVar != null) {
        } else {
            i = i5;
        }
        obj3.b(i);
        com.facebook.e0.k nO_CONNECTIVITY2 = k.NO_CONNECTIVITY;
        if (nO_CONNECTIVITY == nO_CONNECTIVITY2) {
            eVar = new e.e(obj2, obj3);
            o.n().execute(eVar);
        }
        try {
            if (nO_CONNECTIVITY != k.SUCCESS && l5.b() != nO_CONNECTIVITY2) {
            }
            if (l5.b() != nO_CONNECTIVITY2) {
            }
            obj4.d(nO_CONNECTIVITY);
            a.b(th, obj3);
        } catch (org.json.JSONException jSON) {
        } catch (Throwable th1) {
        }
    }

    public static final void o() {
        if (a.d(e.class)) {
        }
        e.d.execute(e.f.a);
    }

    public static final com.facebook.e0.l p(com.facebook.e0.j j, com.facebook.e0.d d2) {
        List obj12;
        final int i = 0;
        if (a.d(e.class)) {
            return i;
        }
        n.f(j, "reason");
        n.f(d2, "appEventCollection");
        l lVar = new l();
        obj12 = e.j(d2, lVar);
        final int i3 = 1;
        if (empty ^= i3 != 0) {
            Object[] arr = new Object[2];
            arr[i3] = j.toString();
            v.f.c(v.APP_EVENTS, e.a, "Flushing %d events due to %s.", arr);
            Iterator obj11 = obj12.iterator();
            for (p obj12 : obj11) {
                obj12.i();
            }
            return lVar;
        }
        return i;
    }
}
