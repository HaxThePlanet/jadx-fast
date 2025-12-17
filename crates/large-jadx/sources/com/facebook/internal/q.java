package com.facebook.internal;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import com.facebook.e0.r.g.e;
import com.facebook.e0.v.d;
import com.facebook.e0.v.e;
import com.facebook.internal.g0.i.a;
import com.facebook.o;
import com.facebook.p;
import com.facebook.p.c;
import com.facebook.s;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Metadata;
import kotlin.d0.d.f0;
import kotlin.d0.d.n;
import kotlin.y.p;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000l\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0002\u0008\t\n\u0002\u0010 \n\u0002\u0008\u0006\n\u0002\u0010\u0008\n\u0002\u0008\n\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0007\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0008\t\u0008Æ\u0002\u0018\u00002\u00020\u0001:\u0002BCB\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010.\u001a\u00020/2\u0006\u00100\u001a\u00020$H\u0007J\u0010\u00101\u001a\u0002022\u0006\u00103\u001a\u00020\u0004H\u0002J\u0014\u00104\u001a\u0004\u0018\u00010!2\u0008\u00103\u001a\u0004\u0018\u00010\u0004H\u0007J\u0008\u00105\u001a\u00020/H\u0007J\u001d\u00106\u001a\u00020!2\u0006\u00103\u001a\u00020\u00042\u0006\u00107\u001a\u000202H\u0000¢\u0006\u0002\u00088J*\u00109\u001a\u001a\u0012\u0004\u0012\u00020\u0004\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020;0 0:2\u0008\u0010<\u001a\u0004\u0018\u000102H\u0002J\u0008\u0010=\u001a\u00020/H\u0002J\u001a\u0010>\u001a\u0004\u0018\u00010!2\u0006\u00103\u001a\u00020\u00042\u0006\u0010?\u001a\u00020&H\u0007J\u0010\u0010@\u001a\u00020/2\u0006\u0010A\u001a\u00020&H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0008\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000c\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\u0008\u0012\u0004\u0012\u00020\u00040\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0015X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0015X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0015X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0015X\u0082T¢\u0006\u0002\n\u0000R\u001a\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020!0 X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\"\u001a\u0008\u0012\u0004\u0012\u00020$0#X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020&X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010'\u001a\u0010\u0012\u000c\u0012\n **\u0004\u0018\u00010)0)0(X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020&X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010,\u001a\u0004\u0018\u00010-X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006D", d2 = {"Lcom/facebook/internal/FetchedAppSettingsManager;", "", "()V", "APPLICATION_FIELDS", "", "APP_SETTINGS_PREFS_KEY_FORMAT", "APP_SETTINGS_PREFS_STORE", "APP_SETTING_ANDROID_SDK_ERROR_CATEGORIES", "APP_SETTING_APP_EVENTS_AAM_RULE", "APP_SETTING_APP_EVENTS_EVENT_BINDINGS", "APP_SETTING_APP_EVENTS_FEATURE_BITMASK", "APP_SETTING_APP_EVENTS_SESSION_TIMEOUT", "APP_SETTING_DIALOG_CONFIGS", "APP_SETTING_FIELDS", "", "APP_SETTING_NUX_CONTENT", "APP_SETTING_NUX_ENABLED", "APP_SETTING_RESTRICTIVE_EVENT_FILTER_FIELD", "APP_SETTING_SMART_LOGIN_OPTIONS", "APP_SETTING_SUPPORTS_IMPLICIT_SDK_LOGGING", "AUTOMATIC_LOGGING_ENABLED_BITMASK_FIELD", "", "CODELESS_EVENTS_ENABLED_BITMASK_FIELD", "IAP_AUTOMATIC_LOGGING_ENABLED_BITMASK_FIELD", "MONITOR_ENABLED_BITMASK_FIELD", "SDK_UPDATE_MESSAGE", "SMART_LOGIN_BOOKMARK_ICON_URL", "SMART_LOGIN_MENU_ICON_URL", "SUGGESTED_EVENTS_SETTING", "TAG", "TRACK_UNINSTALL_ENABLED_BITMASK_FIELD", "fetchedAppSettings", "", "Lcom/facebook/internal/FetchedAppSettings;", "fetchedAppSettingsCallbacks", "Ljava/util/concurrent/ConcurrentLinkedQueue;", "Lcom/facebook/internal/FetchedAppSettingsManager$FetchedAppSettingsCallback;", "isUnityInit", "", "loadingState", "Ljava/util/concurrent/atomic/AtomicReference;", "Lcom/facebook/internal/FetchedAppSettingsManager$FetchAppSettingState;", "kotlin.jvm.PlatformType", "printedSDKUpdatedMessage", "unityEventBindings", "Lorg/json/JSONArray;", "getAppSettingsAsync", "", "callback", "getAppSettingsQueryResponse", "Lorg/json/JSONObject;", "applicationId", "getAppSettingsWithoutQuery", "loadAppSettingsAsync", "parseAppSettingsFromJSON", "settingsJSON", "parseAppSettingsFromJSON$facebook_core_release", "parseDialogConfigurations", "", "Lcom/facebook/internal/FetchedAppSettings$DialogFeatureConfig;", "dialogConfigResponse", "pollCallbacks", "queryAppSettings", "forceRequery", "setIsUnityInit", "flag", "FetchAppSettingState", "FetchedAppSettingsCallback", "facebook-core_release"}, k = 1, mv = {1, 5, 1})
public final class q {

    private static final String a;
    private static final List<String> b;
    private static final Map<String, com.facebook.internal.p> c;
    private static final AtomicReference<com.facebook.internal.q.a> d;
    private static final ConcurrentLinkedQueue<com.facebook.internal.q.b> e;
    private static boolean f;
    private static JSONArray g;
    public static final com.facebook.internal.q h;

    @Metadata(d1 = "\u0000\u000c\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0008\u0006\u0008\u0080\u0001\u0018\u00002\u0008\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002j\u0002\u0008\u0003j\u0002\u0008\u0004j\u0002\u0008\u0005j\u0002\u0008\u0006¨\u0006\u0007", d2 = {"Lcom/facebook/internal/FetchedAppSettingsManager$FetchAppSettingState;", "", "(Ljava/lang/String;I)V", "NOT_LOADED", "LOADING", "SUCCESS", "ERROR", "facebook-core_release"}, k = 1, mv = {1, 5, 1})
    public static enum a {

        NOT_LOADED,
        LOADING,
        SUCCESS,
        ERROR;
    }

    @Metadata(d1 = "\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\u0008f\u0018\u00002\u00020\u0001J\u0008\u0010\u0002\u001a\u00020\u0003H&J\u0012\u0010\u0004\u001a\u00020\u00032\u0008\u0010\u0005\u001a\u0004\u0018\u00010\u0006H&¨\u0006\u0007", d2 = {"Lcom/facebook/internal/FetchedAppSettingsManager$FetchedAppSettingsCallback;", "", "onError", "", "onSuccess", "fetchedAppSettings", "Lcom/facebook/internal/FetchedAppSettings;", "facebook-core_release"}, k = 1, mv = {1, 5, 1})
    public interface b {
        public abstract void a();

        public abstract void b(com.facebook.internal.p p);
    }

    @Metadata(d1 = "\u0000\u0008\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\u0008\u0002", d2 = {"<anonymous>", "", "run"}, k = 3, mv = {1, 5, 1})
    static final class c implements Runnable {

        final Context a;
        final String b;
        final String c;
        c(Context context, String string2, String string3) {
            this.a = context;
            this.b = string2;
            this.c = string3;
            super();
        }

        @Override // java.lang.Runnable
        public final void run() {
            Object sharedPreferences;
            String string;
            int i;
            com.facebook.internal.q.a sUCCESS;
            JSONObject jSONObject;
            Object length;
            String str;
            if (a.d(this)) {
            }
            sharedPreferences = this.a.getSharedPreferences("com.facebook.internal.preferences.APP_SETTINGS", 0);
            string = sharedPreferences.getString(this.b, 0);
            if (!b0.W(string)) {
                if (string == null) {
                } else {
                    jSONObject = new JSONObject(string);
                    if (jSONObject != null) {
                        try {
                            i = q.h.l(this.c, jSONObject);
                            IllegalStateException illegalStateException = new IllegalStateException("Required value was null.".toString());
                            throw illegalStateException;
                            com.facebook.internal.q qVar = q.h;
                            length = q.a(qVar, this.c);
                            if (length != null) {
                            }
                            qVar.l(this.c, length);
                            sharedPreferences.edit().putString(this.b, length.toString()).apply();
                            int i2 = 1;
                            i = i.h();
                            if (i != 0 && !q.d(qVar) && i != null && i.length() > 0) {
                            }
                            i = i.h();
                            if (!q.d(qVar)) {
                            }
                            if (i != null) {
                            }
                            if (i.length() > 0) {
                            }
                            q.g(qVar, i2);
                            Log.w(q.e(qVar), i);
                            o.m(this.c, i2);
                            d.d();
                            if (q.b(qVar).containsKey(this.c)) {
                            } else {
                            }
                            sUCCESS = q.a.SUCCESS;
                            sUCCESS = q.a.ERROR;
                            q.c(qVar).set(sUCCESS);
                            q.f(qVar);
                            a.b(th, this);
                        } catch (org.json.JSONException jSON) {
                        } catch (Throwable th1) {
                        }
                    }
                }
            }
        }
    }

    @Metadata(d1 = "\u0000\u0008\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\u0008\u0002", d2 = {"<anonymous>", "", "run"}, k = 3, mv = {1, 5, 1})
    static final class d implements Runnable {

        final com.facebook.internal.q.b a;
        d(com.facebook.internal.q.b q$b) {
            this.a = b;
            super();
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (a.d(this)) {
            }
            this.a.a();
        }
    }

    @Metadata(d1 = "\u0000\u0008\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\u0008\u0002", d2 = {"<anonymous>", "", "run"}, k = 3, mv = {1, 5, 1})
    static final class e implements Runnable {

        final com.facebook.internal.q.b a;
        final com.facebook.internal.p b;
        e(com.facebook.internal.q.b q$b, com.facebook.internal.p p2) {
            this.a = b;
            this.b = p2;
            super();
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (a.d(this)) {
            }
            this.a.b(this.b);
        }
    }
    static {
        q qVar = new q();
        q.h = qVar;
        String simpleName = q.class.getSimpleName();
        n.e(simpleName, "FetchedAppSettingsManager::class.java.simpleName");
        q.a = simpleName;
        q.b = p.j(/* result */);
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        q.c = concurrentHashMap;
        AtomicReference atomicReference = new AtomicReference(q.a.NOT_LOADED);
        q.d = atomicReference;
        ConcurrentLinkedQueue concurrentLinkedQueue = new ConcurrentLinkedQueue();
        q.e = concurrentLinkedQueue;
    }

    public static final JSONObject a(com.facebook.internal.q q, String string2) {
        return q.i(string2);
    }

    public static final Map b(com.facebook.internal.q q) {
        return q.c;
    }

    public static final AtomicReference c(com.facebook.internal.q q) {
        return q.d;
    }

    public static final boolean d(com.facebook.internal.q q) {
        return q.f;
    }

    public static final String e(com.facebook.internal.q q) {
        return q.a;
    }

    public static final void f(com.facebook.internal.q q) {
        q.n();
    }

    public static final void g(com.facebook.internal.q q, boolean z2) {
        q.f = z2;
    }

    public static final void h(com.facebook.internal.q.b q$b) {
        n.f(b, "callback");
        q.e.add(b);
        q.k();
    }

    private final JSONObject i(String string) {
        Object str;
        p obj5;
        Bundle bundle = new Bundle();
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(q.b);
        bundle.putString("fields", TextUtils.join(",", arrayList));
        int i = 1;
        final int i2 = 0;
        if (b0.W(o.l())) {
            obj5 = p.t.v(i2, string, i2);
            obj5.C(i);
            obj5.G(i);
            obj5.F(bundle);
        } else {
            obj5 = p.t.v(i2, "app", i2);
            obj5.C(i);
            obj5.F(bundle);
        }
        if (obj5.i().d() != null) {
        } else {
            obj5 = new JSONObject();
        }
        return obj5;
    }

    public static final com.facebook.internal.p j(String string) {
        Map map;
        Object obj1;
        if (string != null) {
            obj1 = q.c.get(string);
        } else {
            obj1 = 0;
        }
        return obj1;
    }

    public static final void k() {
        int i;
        AtomicReference compareAndSet;
        com.facebook.internal.q.a compareAndSet2;
        String str = o.g();
        if (b0.W(str)) {
            q.d.set(q.a.ERROR);
            q.h.n();
        }
        if (q.c.containsKey(str)) {
            q.d.set(q.a.SUCCESS);
            q.h.n();
        }
        compareAndSet = q.d;
        com.facebook.internal.q.a lOADING = q.a.LOADING;
        final int i2 = 0;
        final int i3 = 1;
        if (!compareAndSet.compareAndSet(q.a.NOT_LOADED, lOADING)) {
            if (compareAndSet.compareAndSet(q.a.ERROR, lOADING)) {
                i = i3;
            } else {
                i = i2;
            }
        } else {
        }
        if (i == 0) {
            q.h.n();
        }
        f0 f0Var = f0.a;
        Object[] arr = new Object[i3];
        arr[i2] = str;
        String format = String.format("com.facebook.internal.APP_SETTINGS.%s", Arrays.copyOf(arr, i3));
        n.e(format, "java.lang.String.format(format, *args)");
        q.c cVar = new q.c(o.f(), format, str);
        o.n().execute(cVar);
    }

    private final Map<String, Map<String, com.facebook.internal.p.a>> m(JSONObject jSONObject) {
        String str;
        int length;
        com.facebook.internal.p.a aVar;
        JSONObject optJSONObject;
        String hashMap;
        JSONArray obj7;
        HashMap hashMap2 = new HashMap();
        obj7 = jSONObject.optJSONArray("data");
        if (jSONObject != null && obj7 != null) {
            obj7 = jSONObject.optJSONArray("data");
            if (obj7 != null) {
                str = 0;
                while (str < obj7.length()) {
                    optJSONObject = obj7.optJSONObject(str);
                    n.e(optJSONObject, "dialogConfigData.optJSONObject(i)");
                    aVar = p.a.c.a(optJSONObject);
                    String str2 = aVar.a();
                    if (aVar != null && (Map)hashMap2.get(str2) == null) {
                    }
                    str++;
                    str2 = aVar.a();
                    if ((Map)hashMap2.get(str2) == null) {
                    }
                    hashMap.put(aVar.b(), aVar);
                    hashMap = new HashMap();
                    hashMap2.put(str2, hashMap);
                }
            }
        }
        return hashMap2;
    }

    private final void n() {
        Object poll;
        com.facebook.internal.q.a nOT_LOADED;
        Object dVar;
        com.facebook.internal.q.a eRROR;
        poll = q.d.get();
        synchronized (this) {
            try {
                if (q.a.LOADING == (q.a)poll) {
                } else {
                }
                Handler handler = new Handler(Looper.getMainLooper());
                if (q.a.ERROR == (q.a)poll) {
                }
                ConcurrentLinkedQueue queue2 = q.e;
                while (!queue2.isEmpty()) {
                    dVar = new q.d((q.b)queue2.poll());
                    handler.post(dVar);
                    queue2 = q.e;
                }
                dVar = new q.d((q.b)queue2.poll());
                handler.post(dVar);
                ConcurrentLinkedQueue queue = q.e;
                while (!queue.isEmpty()) {
                    eRROR = new q.e((q.b)queue.poll(), (p)q.c.get(o.g()));
                    handler.post(eRROR);
                    queue = q.e;
                }
                eRROR = new q.e((q.b)queue.poll(), dVar);
                handler.post(eRROR);
                throw th;
            }
        }
    }

    public static final com.facebook.internal.p o(String string, boolean z2) {
        String str;
        Object sUCCESS;
        boolean obj2;
        Map obj3;
        n.f(string, "applicationId");
        obj3 = q.c;
        if (z2 == null && obj3.containsKey(string)) {
            obj3 = q.c;
            if (obj3.containsKey(string)) {
                return (p)obj3.get(string);
            }
        }
        obj3 = q.h;
        JSONObject jSONObject = obj3.i(string);
        if (jSONObject != null && n.b(string, o.g())) {
            if (n.b(string, o.g())) {
                q.d.set(q.a.SUCCESS);
                obj3.n();
            }
            return obj3.l(string, jSONObject);
        }
        return null;
    }

    public final com.facebook.internal.p l(String string, JSONObject jSONObject2) {
        com.facebook.internal.h hVar;
        String string2;
        int i5;
        int i;
        int i2;
        int i4;
        int i3;
        Object obj2 = jSONObject2;
        n.f(string, "applicationId");
        n.f(obj2, "settingsJSON");
        com.facebook.internal.h.a aVar = h.h;
        if (aVar.a(obj2.optJSONArray("android_sdk_error_categories")) != null) {
        } else {
            hVar = aVar.b();
        }
        int i12 = 0;
        int optInt = obj2.optInt("app_events_feature_bitmask", i12);
        int i11 = 1;
        i5 = optInt & 8 != 0 ? i11 : i12;
        i = optInt & 16 != 0 ? i11 : i12;
        i2 = optInt & 32 != 0 ? i11 : i12;
        i4 = optInt & 256 != 0 ? i11 : i12;
        i3 = optInt &= 16384 != 0 ? i11 : i12;
        final JSONArray optJSONArray2 = obj2.optJSONArray("auto_event_mapping_android");
        q.g = optJSONArray2;
        if (optJSONArray2 != null && t.b()) {
            if (t.b()) {
                if (optJSONArray2 != null) {
                    string2 = optJSONArray2.toString();
                } else {
                    string2 = 0;
                }
                e.c(string2);
            }
        }
        String optString3 = obj2.optString("gdpv4_nux_content", "");
        n.e(optString3, "settingsJSON.optString(A…_SETTING_NUX_CONTENT, \"\")");
        String optString4 = obj2.optString("smart_login_bookmark_icon_url");
        n.e(optString4, "settingsJSON.optString(S…_LOGIN_BOOKMARK_ICON_URL)");
        String optString = obj2.optString("smart_login_menu_icon_url");
        n.e(optString, "settingsJSON.optString(SMART_LOGIN_MENU_ICON_URL)");
        String optString2 = obj2.optString("sdk_update_message");
        n.e(optString2, "settingsJSON.optString(SDK_UPDATE_MESSAGE)");
        super(obj2.optBoolean("supports_implicit_sdk_logging", i12), optString3, obj2.optBoolean("gdpv4_nux_enabled", i12), obj2.optInt("app_events_session_timeout", e.a()), a0.Companion.a(obj2.optLong("seamless_login")), this.m(obj2.optJSONObject("android_dialog_configs")), i5, hVar, optString4, optString, i, i2, optJSONArray2, optString2, i4, i3, obj2.optString("aam_rules"), obj2.optString("suggested_events_setting"), obj2.optString("restrictive_data_filter_params"));
        com.facebook.internal.p pVar2 = pVar4;
        q.c.put(string, pVar2);
        return pVar2;
    }
}
