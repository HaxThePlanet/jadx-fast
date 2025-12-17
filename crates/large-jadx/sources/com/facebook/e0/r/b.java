package com.facebook.e0.r;

import android.app.Activity;
import android.content.Context;
import android.hardware.SensorManager;
import android.os.Build;
import android.os.Bundle;
import com.facebook.e0.v.b;
import com.facebook.internal.a;
import com.facebook.internal.a.a;
import com.facebook.internal.b0;
import com.facebook.internal.g0.i.a;
import com.facebook.internal.p;
import com.facebook.internal.q;
import com.facebook.o;
import com.facebook.p;
import com.facebook.p.c;
import com.facebook.s;
import java.util.Arrays;
import java.util.Locale;
import java.util.UUID;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.d0.d.f0;
import kotlin.d0.d.n;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0008\u000c\n\u0002\u0018\u0002\n\u0002\u0008\u0006\u0008Ç\u0002\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J\u0017\u0010\u0010\u001a\u00020\u00112\u0008\u0010\u0012\u001a\u0004\u0018\u00010\u0004H\u0001¢\u0006\u0002\u0008\u0013J\u0008\u0010\u0014\u001a\u00020\u0011H\u0007J\u0008\u0010\u0015\u001a\u00020\u0011H\u0007J\r\u0010\u0016\u001a\u00020\u0004H\u0001¢\u0006\u0002\u0008\u0017J\r\u0010\u0018\u001a\u00020\u0008H\u0001¢\u0006\u0002\u0008\u0019J\r\u0010\u001a\u001a\u00020\u0008H\u0001¢\u0006\u0002\u0008\u001bJ\u0010\u0010\u001c\u001a\u00020\u00112\u0006\u0010\u001d\u001a\u00020\u001eH\u0007J\u0010\u0010\u001f\u001a\u00020\u00112\u0006\u0010\u001d\u001a\u00020\u001eH\u0007J\u0010\u0010 \u001a\u00020\u00112\u0006\u0010\u001d\u001a\u00020\u001eH\u0007J\u0015\u0010!\u001a\u00020\u00112\u0006\u0010\"\u001a\u00020\u0008H\u0001¢\u0006\u0002\u0008#R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0008X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000c\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006$", d2 = {"Lcom/facebook/appevents/codeless/CodelessManager;", "", "()V", "deviceSessionID", "", "isAppIndexingEnabled", "Ljava/util/concurrent/atomic/AtomicBoolean;", "isCheckingSession", "", "isCodelessEnabled", "sensorManager", "Landroid/hardware/SensorManager;", "viewIndexer", "Lcom/facebook/appevents/codeless/ViewIndexer;", "viewIndexingTrigger", "Lcom/facebook/appevents/codeless/ViewIndexingTrigger;", "checkCodelessSession", "", "applicationId", "checkCodelessSession$facebook_core_release", "disable", "enable", "getCurrentDeviceSessionID", "getCurrentDeviceSessionID$facebook_core_release", "getIsAppIndexingEnabled", "getIsAppIndexingEnabled$facebook_core_release", "isDebugOnEmulator", "isDebugOnEmulator$facebook_core_release", "onActivityDestroyed", "activity", "Landroid/app/Activity;", "onActivityPaused", "onActivityResumed", "updateAppIndexing", "appIndexingEnabled", "updateAppIndexing$facebook_core_release", "facebook-core_release"}, k = 1, mv = {1, 5, 1})
public final class b {

    private static final com.facebook.e0.r.f a;
    private static SensorManager b;
    private static com.facebook.e0.r.e c;
    private static String d;
    private static final AtomicBoolean e;
    private static final AtomicBoolean f;
    private static volatile boolean g;
    public static final com.facebook.e0.r.b h;

    @Metadata(d1 = "\u0000\u0008\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\u0008\u0002", d2 = {"<anonymous>", "", "run"}, k = 3, mv = {1, 5, 1})
    static final class a implements Runnable {

        final String a;
        a(String string) {
            this.a = string;
            super();
        }

        @Override // java.lang.Runnable
        public final void run() {
            String str;
            JSONObject optBoolean;
            boolean z;
            Bundle bundle;
            int i2;
            Object aVar;
            String str2;
            String mODEL;
            int i;
            if (a.d(this)) {
            }
            f0 f0Var = f0.a;
            i2 = 1;
            Object[] arr = new Object[i2];
            final int i4 = 0;
            arr[i4] = this.a;
            String format = String.format(Locale.US, "%s/app_indexing_session", Arrays.copyOf(arr, i2));
            n.e(format, "java.lang.String.format(locale, format, *args)");
            int i3 = 0;
            p pVar = p.t.x(i3, format, i3, i3);
            if (pVar.s() == null) {
                bundle = new Bundle();
            }
            aVar = a.h.e(o.f());
            JSONArray jSONArray = new JSONArray();
            final String str10 = "";
            if (Build.MODEL != null) {
            } else {
                mODEL = str10;
            }
            jSONArray.put(mODEL);
            if (aVar != null) {
                i = aVar.h();
            } else {
                try {
                    i = i3;
                    if (i != 0) {
                    } else {
                    }
                    jSONArray.put(aVar.h());
                    jSONArray.put(str10);
                    jSONArray.put("0");
                    if (b.f()) {
                    }
                    str = "1";
                    jSONArray.put(str);
                    Locale locale = b0.x();
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append(locale.getLanguage());
                    stringBuilder.append("_");
                    stringBuilder.append(locale.getCountry());
                    jSONArray.put(stringBuilder.toString());
                    String string2 = jSONArray.toString();
                    n.e(string2, "extInfoArray.toString()");
                    bundle.putString("device_session_id", b.h());
                    bundle.putString("extinfo", string2);
                    pVar.F(bundle);
                    optBoolean = pVar.i().c();
                    com.facebook.e0.r.b bVar = b.h;
                    if (optBoolean != null && optBoolean.optBoolean("is_app_indexing_enabled", i4)) {
                    } else {
                    }
                    if (optBoolean.optBoolean("is_app_indexing_enabled", i4)) {
                    } else {
                    }
                    i2 = i4;
                    b.b(bVar).set(i2);
                    if (!b.b(bVar).get()) {
                    } else {
                    }
                    b.d(bVar, i3);
                    z = b.a(bVar);
                    if (z != null) {
                    }
                    z.j();
                    b.c(bVar, i4);
                    a.b(th, this);
                }
            }
        }
    }

    @Metadata(d1 = "\u0000\u0008\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\u0008\u0002", d2 = {"<anonymous>", "", "onShake"}, k = 3, mv = {1, 5, 1})
    static final class b implements com.facebook.e0.r.f.a {

        final p a;
        final String b;
        b(p p, String string2) {
            this.a = p;
            this.b = string2;
            super();
        }

        @Override // com.facebook.e0.r.f$a
        public final void a() {
            p pVar;
            int i2;
            int i;
            pVar = this.a;
            final int i3 = 0;
            if (pVar != null && pVar.b()) {
                i2 = pVar.b() ? i : i3;
            } else {
            }
            if (!o.m()) {
                i = i3;
            }
            if (i2 != 0 && i != 0) {
                if (i != 0) {
                    b.e(this.b);
                }
            }
        }
    }
    static {
        b bVar = new b();
        b.h = bVar;
        f fVar = new f();
        b.a = fVar;
        AtomicBoolean atomicBoolean = new AtomicBoolean(1);
        b.e = atomicBoolean;
        AtomicBoolean atomicBoolean2 = new AtomicBoolean(0);
        b.f = atomicBoolean2;
    }

    public static final com.facebook.e0.r.e a(com.facebook.e0.r.b b) {
        if (a.d(b.class)) {
            return null;
        }
        return b.c;
    }

    public static final AtomicBoolean b(com.facebook.e0.r.b b) {
        if (a.d(b.class)) {
            return null;
        }
        return b.f;
    }

    public static final void c(com.facebook.e0.r.b b, boolean z2) {
        if (a.d(b.class)) {
        }
        b.g = z2;
    }

    public static final void d(com.facebook.e0.r.b b, String string2) {
        if (a.d(b.class)) {
        }
        b.d = string2;
    }

    public static final void e(String string) {
        if (a.d(b.class)) {
        }
        if (b.g) {
        }
        b.g = true;
        b.a aVar = new b.a(string);
        o.n().execute(aVar);
    }

    public static final void f() {
        if (a.d(b.class)) {
        }
        b.e.set(false);
    }

    public static final void g() {
        if (a.d(b.class)) {
        }
        b.e.set(true);
    }

    public static final String h() {
        String string;
        if (a.d(b.class)) {
            return null;
        }
        if (b.d == null) {
            b.d = UUID.randomUUID().toString();
        }
        String str = b.d;
        if (str == null) {
        } else {
            return str;
        }
        NullPointerException nullPointerException = new NullPointerException("null cannot be cast to non-null type kotlin.String");
        throw nullPointerException;
    }

    public static final boolean i() {
        if (a.d(b.class)) {
            return 0;
        }
        return b.f.get();
    }

    public static final boolean j() {
        return 0;
    }

    public static final void k(Activity activity) {
        if (a.d(b.class)) {
        }
        n.f(activity, "activity");
        c.h.a().f(activity);
    }

    public static final void l(Activity activity) {
        Object cVar;
        if (a.d(b.class)) {
        }
        n.f(activity, "activity");
        if (!b.e.get()) {
        }
        c.h.a().h(activity);
        com.facebook.e0.r.e obj2 = b.c;
        if (obj2 != null) {
            obj2.l();
        }
        obj2 = b.b;
        if (obj2 != null) {
            obj2.unregisterListener(b.a);
        }
    }

    public static final void m(Activity activity) {
        Object applicationContext;
        int i2;
        boolean str;
        int i;
        Object obj7;
        if (a.d(b.class)) {
        }
        n.f(activity, "activity");
        if (!b.e.get()) {
        }
        c.h.a().e(activity);
        final String str3 = o.g();
        final p pVar = q.j(str3);
        i2 = 1;
        if (pVar != null) {
            if (pVar.b() != i2) {
                Object systemService = activity.getApplicationContext().getSystemService("sensor");
                b.b = (SensorManager)systemService;
                if (b.j() && systemService == null) {
                    systemService = applicationContext.getSystemService("sensor");
                    b.b = (SensorManager)systemService;
                    if (systemService == null) {
                    }
                    try {
                        str = "Required value was null.";
                        if (systemService == null) {
                        } else {
                        }
                        e eVar = new e(activity);
                        b.c = eVar;
                        obj7 = b.a;
                        b.b bVar = new b.b(pVar, str3);
                        obj7.a(bVar);
                        i2 = b.b;
                        if (i2 == null) {
                        } else {
                        }
                        i2.registerListener(obj7, systemService.getDefaultSensor(i2), 2);
                        if (pVar != null && pVar.b()) {
                        }
                        if (pVar.b()) {
                        }
                        obj7 = b.c;
                        if (obj7 == null) {
                        } else {
                        }
                        obj7.j();
                        obj7 = new IllegalStateException(str.toString());
                        throw obj7;
                        obj7 = new IllegalStateException(str.toString());
                        throw obj7;
                        obj7 = new IllegalStateException(str.toString());
                        throw obj7;
                        if (b.j() && !b.f.get()) {
                        }
                        if (!b.f.get()) {
                        }
                        b.e(str3);
                        a.b(activity, obj0);
                    }
                }
            } else {
            }
        } else {
        }
    }

    public static final void n(boolean z) {
        if (a.d(b.class)) {
        }
        b.f.set(z);
    }
}
