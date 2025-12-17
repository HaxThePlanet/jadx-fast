package com.facebook.e0.r;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import com.facebook.a;
import com.facebook.a.c;
import com.facebook.e0.r.g.e;
import com.facebook.e0.r.g.f;
import com.facebook.e0.v.b;
import com.facebook.internal.b0;
import com.facebook.internal.g0.i.a;
import com.facebook.internal.t;
import com.facebook.internal.v;
import com.facebook.internal.v.a;
import com.facebook.o;
import com.facebook.p;
import com.facebook.p.c;
import com.facebook.s;
import com.facebook.v;
import java.io.ByteArrayOutputStream;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import java.util.Locale;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.FutureTask;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.d0.d.f0;
import kotlin.d0.d.g;
import kotlin.d0.d.n;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
@Metadata(d1 = "\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0008\u0008\u0007\u0018\u0000 \u00162\u00020\u0001:\u0002\u0016\u0017B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u001a\u0010\r\u001a\u00020\u000e2\u0008\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0008\u0010\u0011\u001a\u0004\u0018\u00010\nJ\u0006\u0010\u0012\u001a\u00020\u000eJ\u0010\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00020\nH\u0002J\u0006\u0010\u0015\u001a\u00020\u000eR\u0014\u0010\u0005\u001a\u0008\u0012\u0004\u0012\u00020\u00030\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\u0008X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u000cX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018", d2 = {"Lcom/facebook/appevents/codeless/ViewIndexer;", "", "activity", "Landroid/app/Activity;", "(Landroid/app/Activity;)V", "activityReference", "Ljava/lang/ref/WeakReference;", "indexingTimer", "Ljava/util/Timer;", "previousDigest", "", "uiThreadHandler", "Landroid/os/Handler;", "processRequest", "", "request", "Lcom/facebook/GraphRequest;", "currentDigest", "schedule", "sendToServer", "tree", "unschedule", "Companion", "ScreenshotTaker", "facebook-core_release"}, k = 1, mv = {1, 5, 1})
public final class e {

    private static final String e;
    public static final com.facebook.e0.r.e.a f;
    private final Handler a;
    private final WeakReference<Activity> b;
    private Timer c;
    private String d = null;

    @Metadata(d1 = "\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0002\u0008\u0002\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J0\u0010\u000c\u001a\u0004\u0018\u00010\r2\u0008\u0010\u000e\u001a\u0004\u0018\u00010\u00042\u0008\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0008\u0010\u0011\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0012\u001a\u00020\u0004H\u0007J\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0004H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0008\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0016", d2 = {"Lcom/facebook/appevents/codeless/ViewIndexer$Companion;", "", "()V", "APP_VERSION_PARAM", "", "PLATFORM_PARAM", "REQUEST_TYPE", "SUCCESS", "TAG", "TREE_PARAM", "instance", "Lcom/facebook/appevents/codeless/ViewIndexer;", "buildAppIndexingRequest", "Lcom/facebook/GraphRequest;", "appIndex", "accessToken", "Lcom/facebook/AccessToken;", "appId", "requestType", "sendToServerUnityInstance", "", "tree", "facebook-core_release"}, k = 1, mv = {1, 5, 1})
    public static final class a {
        public a(g g) {
            super();
        }

        public final p a(String string, a a2, String string3, String string4) {
            boolean obj7;
            Bundle obj9;
            Object obj10;
            n.f(string4, "requestType");
            int i = 0;
            if (string == null) {
                return i;
            }
            f0 f0Var = f0.a;
            int i2 = 1;
            final Object[] arr = new Object[i2];
            arr[0] = string3;
            obj9 = String.format(Locale.US, "%s/app_indexing", Arrays.copyOf(arr, i2));
            n.e(obj9, "java.lang.String.format(locale, format, *args)");
            final p obj8 = p.t.x(a2, obj9, i, i);
            if (obj8.s() == null) {
                obj9 = new Bundle();
            }
            obj9.putString("tree", string);
            obj9.putString("app_version", b.d());
            obj9.putString("platform", "android");
            obj9.putString("request_type", string4);
            if (n.b(string4, "app_indexing")) {
                obj9.putString("device_session_id", b.h());
            }
            obj8.F(obj9);
            obj8.B(e.a.a.a);
            return obj8;
        }
    }

    @Metadata(d1 = "\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008\u0002\u0018\u00002\u0008\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0008\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0008\u0010\u0007\u001a\u00020\u0002H\u0016R\u0014\u0010\u0003\u001a\u0008\u0012\u0004\u0012\u00020\u00040\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0008", d2 = {"Lcom/facebook/appevents/codeless/ViewIndexer$ScreenshotTaker;", "Ljava/util/concurrent/Callable;", "", "rootView", "Landroid/view/View;", "(Landroid/view/View;)V", "Ljava/lang/ref/WeakReference;", "call", "facebook-core_release"}, k = 1, mv = {1, 5, 1})
    private static final class b implements Callable<String> {

        private final WeakReference<View> a;
        public b(View view) {
            n.f(view, "rootView");
            super();
            WeakReference weakReference = new WeakReference(view);
            this.a = weakReference;
        }

        @Override // java.util.concurrent.Callable
        public String a() {
            int height;
            Object obj = this.a.get();
            if (obj != null && (View)obj.getWidth() != 0 && obj.getHeight() == 0) {
                if (obj.getWidth() != 0) {
                    if (obj.getHeight() == 0) {
                    }
                    Bitmap bitmap = Bitmap.createBitmap(obj.getWidth(), obj.getHeight(), Bitmap.Config.RGB_565);
                    Canvas canvas = new Canvas(bitmap);
                    obj.draw(canvas);
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    bitmap.compress(Bitmap.CompressFormat.JPEG, 10, byteArrayOutputStream);
                    String encodeToString = Base64.encodeToString(byteArrayOutputStream.toByteArray(), 2);
                    n.e(encodeToString, "Base64.encodeToString(ou…eArray(), Base64.NO_WRAP)");
                    return encodeToString;
                }
            }
            return "";
        }

        @Override // java.util.concurrent.Callable
        public Object call() {
            return a();
        }
    }

    @Metadata(d1 = "\u0000\u0008\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\u0008\u0002", d2 = {"<anonymous>", "", "run"}, k = 3, mv = {1, 5, 1})
    static final class c implements Runnable {

        final com.facebook.e0.r.e a;
        final TimerTask b;
        c(com.facebook.e0.r.e e, TimerTask timerTask2) {
            this.a = e;
            this.b = timerTask2;
            super();
        }

        @Override // java.lang.Runnable
        public final void run() {
            Timer timer;
            com.facebook.e0.r.e eVar;
            Timer time;
            if (a.d(this)) {
            }
            Timer time2 = e.b(this.a);
            if (time2 != null) {
                time2.cancel();
            }
            e.h(this.a, 0);
            timer = new Timer();
            timer.scheduleAtFixedRate(this.b, 0, obj5);
            e.g(this.a, timer);
            try {
                a.b(th, this);
            } catch (Throwable th) {
            }
        }
    }

    @Metadata(d1 = "\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\u0008\n\u0018\u00002\u00020\u0001J\u0008\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004", d2 = {"com/facebook/appevents/codeless/ViewIndexer$schedule$indexingTask$1", "Ljava/util/TimerTask;", "run", "", "facebook-core_release"}, k = 1, mv = {1, 5, 1})
    public static final class d extends TimerTask {

        final com.facebook.e0.r.e a;
        d(com.facebook.e0.r.e e) {
            this.a = e;
            super();
        }

        @Override // java.util.TimerTask
        public void run() {
            JSONArray jSONArray;
            String string;
            String str;
            com.facebook.e0.r.e eVar;
            Object obj;
            JSONObject jSONObject;
            int i;
            TimeUnit str2;
            try {
                Object obj2 = e.a(this.a).get();
                View view = b.e((Activity)obj2);
                if (obj2 != null) {
                }
                if (view == null) {
                } else {
                }
                String simpleName = obj2.getClass().getSimpleName();
                n.e(simpleName, "activity.javaClass.simpleName");
                if (!b.i()) {
                }
                if (t.b()) {
                }
                e.a();
                e.b bVar = new e.b(view);
                FutureTask futureTask = new FutureTask(bVar);
                e.e(this.a).post(futureTask);
                String str9 = "";
                str2 = "Failed to take screenshot.";
                Log.e(e.d(), str2, str7);
                jSONObject = new JSONObject();
                jSONObject.put("screenname", simpleName);
                jSONObject.put("screenshot", (String)futureTask.get(1, str2));
                jSONArray = new JSONArray();
                jSONArray.put(f.d(view));
                jSONObject.put("view", jSONArray);
                String str3 = e.d();
                String str5 = "Failed to create JSONObject";
                Log.e(str3, str5);
                string = jSONObject.toString();
                n.e(string, "viewTree.toString()");
                e.f(this.a, string);
                str5 = e.d();
                Throwable str7 = "UI Component tree indexing failure!";
                Log.e(str5, str7, str3);
            } catch (Exception e) {
            }
        }
    }

    @Metadata(d1 = "\u0000\u0008\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\u0008\u0002", d2 = {"<anonymous>", "", "run"}, k = 3, mv = {1, 5, 1})
    static final class e implements Runnable {

        final com.facebook.e0.r.e a;
        final String b;
        e(com.facebook.e0.r.e e, String string2) {
            this.a = e;
            this.b = string2;
            super();
        }

        @Override // java.lang.Runnable
        public final void run() {
            boolean z;
            if (a.d(this)) {
            }
            String str2 = b0.g0(this.b);
            if (str2 != null && n.b(str2, e.c(this.a))) {
                if (n.b(str2, e.c(this.a))) {
                }
            }
            this.a.i(e.f.a(this.b, a.H.e(), o.g(), "app_indexing"), str2);
        }
    }
    static {
        String canonicalName;
        e.a aVar = new e.a(0);
        e.f = aVar;
        if (e.class.getCanonicalName() != null) {
        } else {
            canonicalName = "";
        }
        n.e(canonicalName, "ViewIndexer::class.java.canonicalName ?: \"\"");
        e.e = canonicalName;
    }

    public e(Activity activity) {
        n.f(activity, "activity");
        super();
        WeakReference weakReference = new WeakReference(activity);
        this.b = weakReference;
        int obj2 = 0;
        obj2 = new Handler(Looper.getMainLooper());
        this.a = obj2;
    }

    public static final WeakReference a(com.facebook.e0.r.e e) {
        if (a.d(e.class)) {
            return null;
        }
        return e.b;
    }

    public static final Timer b(com.facebook.e0.r.e e) {
        if (a.d(e.class)) {
            return null;
        }
        return e.c;
    }

    public static final String c(com.facebook.e0.r.e e) {
        if (a.d(e.class)) {
            return null;
        }
        return e.d;
    }

    public static final String d() {
        if (a.d(e.class)) {
            return null;
        }
        return e.e;
    }

    public static final Handler e(com.facebook.e0.r.e e) {
        if (a.d(e.class)) {
            return null;
        }
        return e.a;
    }

    public static final void f(com.facebook.e0.r.e e, String string2) {
        if (a.d(e.class)) {
        }
        e.k(string2);
    }

    public static final void g(com.facebook.e0.r.e e, Timer timer2) {
        if (a.d(e.class)) {
        }
        e.c = timer2;
    }

    public static final void h(com.facebook.e0.r.e e, String string2) {
        if (a.d(e.class)) {
        }
        e.d = string2;
    }

    private final void k(String string) {
        if (a.d(this)) {
        }
        e.e eVar = new e.e(this, string);
        o.n().execute(eVar);
    }

    public final void i(p p, String string2) {
        Object stringBuilder;
        Object str;
        Object aPP_EVENTS;
        String str3;
        String str2;
        String obj6;
        String obj7;
        stringBuilder = "is_app_indexing_enabled";
        if (a.d(this)) {
        }
        if (p == null) {
        }
        obj6 = p.i();
        str = obj6.c();
        if (str != null) {
            if (n.b("true", str.optString("success"))) {
                v.f.b(v.APP_EVENTS, e.e, "Successfully send UI component tree to server");
                this.d = string2;
            }
            if (str.has(stringBuilder)) {
                b.n(str.getBoolean(stringBuilder));
            }
        } else {
            stringBuilder = new StringBuilder();
            stringBuilder.append("Error sending UI component tree to Facebook: ");
            stringBuilder.append(obj6.b());
            Log.e(e.e, stringBuilder.toString());
        }
    }

    public final void j() {
        com.facebook.e0.r.e.d dVar;
        Executor executor;
        com.facebook.e0.r.e.c cVar;
        if (a.d(this)) {
        }
        dVar = new e.d(this);
        cVar = new e.c(this, dVar);
        o.n().execute(cVar);
    }

    public final void l() {
        Object obj;
        String str;
        String str2;
        if (a.d(this)) {
        }
        Timer time = this.c;
        if ((Activity)this.b.get() != null && time != null) {
            time = this.c;
            if (time != null) {
                time.cancel();
            }
            this.c = 0;
        }
        try {
            a.b(th, this);
        } catch (Exception e) {
        } catch (Throwable th1) {
        }
    }
}
