package com.facebook.e0.w;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.text.TextUtils;
import com.facebook.e0.u.a;
import com.facebook.e0.z.d;
import com.facebook.internal.b0;
import com.facebook.internal.g0.i.a;
import com.facebook.internal.l;
import com.facebook.internal.l.b;
import com.facebook.o;
import com.facebook.p;
import com.facebook.p.c;
import com.facebook.s;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.d0.d.f0;
import kotlin.d0.d.n;
import kotlin.h0.g;
import kotlin.k0.l;
import kotlin.y.h0;
import kotlin.y.p;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000t\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0002\u0008\u0004\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010 \n\u0002\u0008\u0008\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0011\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0006\u0008Ç\u0002\u0018\u00002\u00020\u0001:\u000289B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cH\u0002J\u0008\u0010\u001d\u001a\u00020\u001aH\u0007J\u0008\u0010\u001e\u001a\u00020\u001aH\u0002J\n\u0010\u001f\u001a\u0004\u0018\u00010\u001cH\u0002J\u0012\u0010 \u001a\u0004\u0018\u00010!2\u0006\u0010\"\u001a\u00020#H\u0007J\u0010\u0010$\u001a\u00020\u00142\u0006\u0010%\u001a\u00020&H\u0002J\u0014\u0010'\u001a\u0004\u0018\u00010(2\u0008\u0010)\u001a\u0004\u0018\u00010*H\u0002J\u0010\u0010+\u001a\u00020\u001c2\u0006\u0010,\u001a\u00020\u001cH\u0002J9\u0010-\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010.2\u0006\u0010\"\u001a\u00020#2\u000c\u0010/\u001a\u0008\u0012\u0004\u0012\u00020(0.2\u000c\u00100\u001a\u0008\u0012\u0004\u0012\u00020\u00040.H\u0007¢\u0006\u0002\u00101J%\u00102\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010.2\u0006\u00103\u001a\u0002042\u0006\u00105\u001a\u00020(H\u0002¢\u0006\u0002\u00106J%\u00107\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010.2\u0006\u00103\u001a\u0002042\u0006\u00105\u001a\u00020(H\u0002¢\u0006\u0002\u00106R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0008\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\u0008\u0012\u0004\u0012\u00020\u00040\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000c\u001a\u0008\u0012\u0004\u0012\u00020\u00040\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u0014\u0010\u0013\u001a\u00020\u00148BX\u0082\u0004¢\u0006\u0006\u001a\u0004\u0008\u0013\u0010\u0015R\u001c\u0010\u0016\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0004\u0012\u00020\u00180\u0017X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006:", d2 = {"Lcom/facebook/appevents/ml/ModelManager;", "", "()V", "ASSET_URI_KEY", "", "CACHE_KEY_MODELS", "CACHE_KEY_REQUEST_TIMESTAMP", "MODEL_ASSERT_STORE", "MODEL_REQUEST_INTERVAL_MILLISECONDS", "", "MTML_INTEGRITY_DETECT_PREDICTION", "", "MTML_SUGGESTED_EVENTS_PREDICTION", "MTML_USE_CASE", "RULES_URI_KEY", "SDK_MODEL_ASSET", "THRESHOLD_KEY", "USE_CASE_KEY", "VERSION_ID_KEY", "isLocaleEnglish", "", "()Z", "taskHandlers", "", "Lcom/facebook/appevents/ml/ModelManager$TaskHandler;", "addModels", "", "models", "Lorg/json/JSONObject;", "enable", "enableMTML", "fetchModels", "getRuleFile", "Ljava/io/File;", "task", "Lcom/facebook/appevents/ml/ModelManager$Task;", "isValidTimestamp", "timestamp", "", "parseJsonArray", "", "jsonArray", "Lorg/json/JSONArray;", "parseRawJsonObject", "jsonObject", "predict", "", "denses", "texts", "(Lcom/facebook/appevents/ml/ModelManager$Task;[[F[Ljava/lang/String;)[Ljava/lang/String;", "processIntegrityDetectionResult", "res", "Lcom/facebook/appevents/ml/MTensor;", "thresholds", "(Lcom/facebook/appevents/ml/MTensor;[F)[Ljava/lang/String;", "processSuggestedEventResult", "Task", "TaskHandler", "facebook-core_release"}, k = 1, mv = {1, 5, 1})
public final class d {

    private static final Map<String, com.facebook.e0.w.d.b> a;
    private static final List<String> b;
    private static final List<String> c;
    public static final com.facebook.e0.w.d d;

    @Metadata(d1 = "\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0002\u0008\u0004\u0008\u0086\u0001\u0018\u00002\u0008\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004J\u0006\u0010\u0005\u001a\u00020\u0004j\u0002\u0008\u0006j\u0002\u0008\u0007¨\u0006\u0008", d2 = {"Lcom/facebook/appevents/ml/ModelManager$Task;", "", "(Ljava/lang/String;I)V", "toKey", "", "toUseCase", "MTML_INTEGRITY_DETECT", "MTML_APP_EVENT_PREDICTION", "facebook-core_release"}, k = 1, mv = {1, 5, 1})
    public static enum a {

        MTML_INTEGRITY_DETECT,
        MTML_APP_EVENT_PREDICTION;
        @Override // java.lang.Enum
        public final String toKey() {
            String str;
            int i;
            int i2 = c.a[ordinal()];
            if (i2 != 1) {
                if (i2 != 2) {
                } else {
                    str = "app_event_pred";
                    return str;
                }
                NoWhenBranchMatchedException noWhenBranchMatchedException = new NoWhenBranchMatchedException();
                throw noWhenBranchMatchedException;
            }
            str = "integrity_detect";
        }

        @Override // java.lang.Enum
        public final String toUseCase() {
            String str;
            int i;
            int i2 = c.b[ordinal()];
            if (i2 != 1) {
                if (i2 != 2) {
                } else {
                    str = "MTML_APP_EVENT_PRED";
                    return str;
                }
                NoWhenBranchMatchedException noWhenBranchMatchedException = new NoWhenBranchMatchedException();
                throw noWhenBranchMatchedException;
            }
            str = "MTML_INTEGRITY_DETECT";
        }
    }

    @Metadata(d1 = "\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0003\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u0014\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0013\u0008\u0002\u0018\u0000 *2\u00020\u0001:\u0001*B1\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0008\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0008\u0010\u0008\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\nJ\u0010\u0010)\u001a\u00020\u00002\u0008\u0010\u0015\u001a\u0004\u0018\u00010\u0016R\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u000b\u0010\u000c\"\u0004\u0008\r\u0010\u000eR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u0011\u0010\u0012\"\u0004\u0008\u0013\u0010\u0014R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u0019\u0010\u001a\"\u0004\u0008\u001b\u0010\u001cR\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u001d\u0010\u000c\"\u0004\u0008\u001e\u0010\u000eR\u001c\u0010\u0008\u001a\u0004\u0018\u00010\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u001f\u0010 \"\u0004\u0008!\u0010\"R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008#\u0010\u000c\"\u0004\u0008$\u0010\u000eR\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008%\u0010&\"\u0004\u0008'\u0010(¨\u0006+", d2 = {"Lcom/facebook/appevents/ml/ModelManager$TaskHandler;", "", "useCase", "", "assetUri", "ruleUri", "versionId", "", "thresholds", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I[F)V", "getAssetUri", "()Ljava/lang/String;", "setAssetUri", "(Ljava/lang/String;)V", "model", "Lcom/facebook/appevents/ml/Model;", "getModel", "()Lcom/facebook/appevents/ml/Model;", "setModel", "(Lcom/facebook/appevents/ml/Model;)V", "onPostExecute", "Ljava/lang/Runnable;", "ruleFile", "Ljava/io/File;", "getRuleFile", "()Ljava/io/File;", "setRuleFile", "(Ljava/io/File;)V", "getRuleUri", "setRuleUri", "getThresholds", "()[F", "setThresholds", "([F)V", "getUseCase", "setUseCase", "getVersionId", "()I", "setVersionId", "(I)V", "setOnPostExecute", "Companion", "facebook-core_release"}, k = 1, mv = {1, 5, 1})
    private static final class b {

        public static final com.facebook.e0.w.d.b.a i;
        private File a;
        private com.facebook.e0.w.b b;
        private Runnable c;
        private String d;
        private String e;
        private String f;
        private int g;
        private float[] h;
        static {
            d.b.a aVar = new d.b.a(0);
            d.b.i = aVar;
        }

        public b(String string, String string2, String string3, int i4, float[] f5Arr5) {
            n.f(string, "useCase");
            n.f(string2, "assetUri");
            super();
            this.d = string;
            this.e = string2;
            this.f = string3;
            this.g = i4;
            this.h = f5Arr5;
        }

        public static final Runnable a(com.facebook.e0.w.d.b d$b) {
            return b.c;
        }

        public final String b() {
            return this.e;
        }

        public final com.facebook.e0.w.b c() {
            return this.b;
        }

        public final File d() {
            return this.a;
        }

        public final String e() {
            return this.f;
        }

        public final float[] f() {
            return this.h;
        }

        public final String g() {
            return this.d;
        }

        public final int h() {
            return this.g;
        }

        public final void i(com.facebook.e0.w.b b) {
            this.b = b;
        }

        public final com.facebook.e0.w.d.b j(Runnable runnable) {
            this.c = runnable;
            return this;
        }

        public final void k(File file) {
            this.a = file;
        }
    }

    @Metadata(d1 = "\u0000\u0008\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\u0008\u0002", d2 = {"<anonymous>", "", "run"}, k = 3, mv = {1, 5, 1})
    static final class c implements Runnable {

        public static final com.facebook.e0.w.d.c a;
        static {
            d.c cVar = new d.c();
            d.c.a = cVar;
        }

        @Override // java.lang.Runnable
        public final void run() {
            Object long;
            com.facebook.e0.w.d dVar;
            Object string2;
            long sharedPreferences;
            String string;
            int i;
            JSONObject jSONObject;
            int length;
            long = "model_request_timestamp";
            string2 = "models";
            if (a.d(this)) {
            }
            sharedPreferences = o.f().getSharedPreferences("com.facebook.internal.MODEL_STORE", 0);
            String string3 = sharedPreferences.getString(string2, 0);
            if (string3 != null) {
                if (string3.length() == 0) {
                    i = 1;
                }
                if (i != 0) {
                    jSONObject = new JSONObject();
                } else {
                    jSONObject = new JSONObject(string3);
                }
            } else {
            }
            if (l.g(l.b.ModelRequest) && jSONObject.length() != 0) {
                if (jSONObject.length() != 0) {
                    try {
                        jSONObject = d.c(d.d);
                        if (!d.d(d.d, sharedPreferences.getLong(long, 0)) && jSONObject != null) {
                        }
                        jSONObject = d.c(d.d);
                        if (jSONObject != null) {
                        }
                        string = jSONObject.toString();
                        sharedPreferences.edit().putString(string2, string).putLong(long, System.currentTimeMillis()).apply();
                        dVar = d.d;
                        d.a(dVar, jSONObject);
                        d.b(dVar);
                        a.b(th, this);
                    }
                } else {
                }
            } else {
            }
        }
    }

    @Metadata(d1 = "\u0000\u0008\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\u0008\u0002", d2 = {"<anonymous>", "", "run"}, k = 3, mv = {1, 5, 1})
    static final class d implements Runnable {

        public static final com.facebook.e0.w.d.d a;
        static {
            d.d dVar = new d.d();
            d.d.a = dVar;
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (a.d(this)) {
            }
            d.c();
        }
    }

    @Metadata(d1 = "\u0000\u0008\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\u0008\u0002", d2 = {"<anonymous>", "", "run"}, k = 3, mv = {1, 5, 1})
    static final class e implements Runnable {

        public static final com.facebook.e0.w.d.e a;
        static {
            d.e eVar = new d.e();
            d.e.a = eVar;
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (a.d(this)) {
            }
            a.a();
        }
    }
    static {
        d dVar = new d();
        d.d = dVar;
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        d.a = concurrentHashMap;
        d.b = p.j(/* result */);
        d.c = p.j(/* result */);
    }

    public static final void a(com.facebook.e0.w.d d, JSONObject jSONObject2) {
        if (a.d(d.class)) {
        }
        d.f(jSONObject2);
    }

    public static final void b(com.facebook.e0.w.d d) {
        if (a.d(d.class)) {
        }
        d.h();
    }

    public static final JSONObject c(com.facebook.e0.w.d d) {
        if (a.d(d.class)) {
            return null;
        }
        return d.i();
    }

    public static final boolean d(com.facebook.e0.w.d d, long l2) {
        if (a.d(d.class)) {
            return 0;
        }
        return d.l(l2);
    }

    public static final float[] e(com.facebook.e0.w.d d, JSONArray jSONArray2) {
        if (a.d(d.class)) {
            return null;
        }
        return d.m(jSONArray2);
    }

    private final void f(JSONObject jSONObject) {
        com.facebook.e0.w.d.b bVar;
        Object obj;
        String str;
        if (a.d(this)) {
        }
        Iterator keys = jSONObject.keys();
        while (keys.hasNext()) {
            bVar = d.b.i.b(jSONObject.getJSONObject((String)keys.next()));
            if (bVar != null) {
            }
            d.a.put(bVar.g(), bVar);
        }
    }

    public static final void g() {
        if (a.d(d.class)) {
        }
        b0.u0(d.c.a);
    }

    private final void h() {
        int value;
        boolean bVar;
        int i5;
        String useCase;
        boolean z;
        boolean str;
        int i3;
        int i;
        int i2;
        int i4;
        if (a.d(this)) {
        }
        ArrayList arrayList = new ArrayList();
        Iterator iterator = d.a.entrySet().iterator();
        i3 = value;
        i2 = i5;
        while (iterator.hasNext()) {
            Object next = iterator.next();
            Object key = (Map.Entry)next.getKey();
            value = next.getValue();
            i3 = (d.b)value.b();
            i2 = Math.max(i2, value.h());
            if (n.b((String)key, d.a.MTML_APP_EVENT_PREDICTION.toUseCase()) && l.g(l.b.SuggestedEvents) && k()) {
            }
            if (n.b(key, d.a.MTML_INTEGRITY_DETECT.toUseCase()) != 0 && l.g(l.b.IntelligentIntegrity)) {
            }
            if (l.g(l.b.IntelligentIntegrity)) {
            }
            i3 = i5;
            i2 = useCase;
            value.j(d.e.a);
            arrayList.add(value);
            i3 = value.b();
            i2 = Math.max(i2, value.h());
            if (l.g(l.b.SuggestedEvents)) {
            }
            if (k()) {
            }
            value.j(d.d.a);
            arrayList.add(value);
        }
        if (i3 != 0 && i2 > 0 && !arrayList.isEmpty()) {
            if (i2 > 0) {
                if (!arrayList.isEmpty()) {
                    super("MTML", i3, 0, i2, 0);
                    d.b.i.e(bVar, arrayList);
                }
            }
        }
    }

    private final JSONObject i() {
        JSONObject jSONObject;
        String format;
        int str;
        String str2;
        int i;
        String str3;
        final int i2 = 0;
        if (a.d(this)) {
            return i2;
        }
        Bundle bundle = new Bundle();
        bundle.putString("fields", TextUtils.join(",", /* result */));
        f0 f0Var = f0.a;
        str = 1;
        Object[] arr = new Object[str];
        arr[0] = o.g();
        format = String.format("%s/model_asset", Arrays.copyOf(arr, str));
        n.e(format, "java.lang.String.format(format, *args)");
        p pVar = p.t.v(i2, format, i2);
        pVar.G(str);
        pVar.F(bundle);
        if (b0.W(o.l()) && pVar.i().c() != null) {
            f0Var = f0.a;
            str = 1;
            arr = new Object[str];
            arr[0] = o.g();
            format = String.format("%s/model_asset", Arrays.copyOf(arr, str));
            n.e(format, "java.lang.String.format(format, *args)");
            pVar = p.t.v(i2, format, i2);
            pVar.G(str);
            pVar.F(bundle);
            if (pVar.i().c() != null) {
                return n(jSONObject);
            }
            return i2;
        }
        p pVar2 = p.t.v(i2, "app/model_asset", i2);
        pVar2.F(bundle);
        if (pVar2.i().c() != null) {
        }
        try {
            return i2;
            a.b(th, this);
            return obj1;
        }
    }

    public static final File j(com.facebook.e0.w.d.a d$a) {
        final int i = 0;
        if (a.d(d.class)) {
            return i;
        }
        n.f(a, "task");
        Object obj3 = d.a.get(a.toUseCase());
        if ((d.b)obj3 != null) {
            return (d.b)obj3.d();
        }
        return i;
    }

    private final boolean k() {
        boolean locale;
        int i;
        String str;
        int i3;
        int i2;
        i = 0;
        if (a.d(this)) {
            return i;
        }
        locale = b0.H();
        if (locale != null) {
            String language = locale.getLanguage();
            n.e(language, "locale.language");
            if (l.R(language, "en", i, 2, 0)) {
                i = 1;
            }
        } else {
        }
        return i;
    }

    private final boolean l(long l) {
        int i;
        int i2;
        int obj5;
        if (a.d(this)) {
            return 0;
        }
        if (Long.compare(l, i2) == 0) {
        } else {
            if (Long.compare(i2, obj5) < 0) {
                i = 1;
            }
        }
        return i;
    }

    private final float[] m(JSONArray jSONArray) {
        int i;
        float float;
        String str;
        final int i2 = 0;
        if (a.d(this)) {
            return i2;
        }
        if (jSONArray == null) {
            return i2;
        }
        float[] fArr = new float[jSONArray.length()];
        i = 0;
        while (i < jSONArray.length()) {
            String string = jSONArray.getString(i);
            n.e(string, "jsonArray.getString(i)");
            fArr[i] = Float.parseFloat(string);
            i++;
        }
        return fArr;
    }

    private final JSONObject n(JSONObject jSONObject) {
        JSONObject jSONObject3;
        int i;
        String string2;
        JSONObject jSONObject2;
        boolean string;
        final String str = "asset_uri";
        final String str2 = "thresholds";
        final String str3 = "version_id";
        final String str4 = "rules_uri";
        final String str5 = "use_case";
        if (a.d(this)) {
            return null;
        }
        jSONObject3 = new JSONObject();
        final JSONArray obj13 = jSONObject.getJSONArray("data");
        i = 0;
        while (i < obj13.length()) {
            JSONObject jSONObject5 = obj13.getJSONObject(i);
            jSONObject2 = new JSONObject();
            jSONObject2.put(str3, jSONObject5.getString(str3));
            jSONObject2.put(str5, jSONObject5.getString(str5));
            jSONObject2.put(str2, jSONObject5.getJSONArray(str2));
            jSONObject2.put(str, jSONObject5.getString(str));
            if (jSONObject5.has(str4)) {
            }
            jSONObject3.put(jSONObject5.getString(str5), jSONObject2);
            i++;
            jSONObject2.put(str4, jSONObject5.getString(str4));
        }
        return jSONObject3;
    }

    public static final String[] o(com.facebook.e0.w.d.a d$a, float[][] f2Arr2Arr2, String[] string3Arr3) {
        Object length;
        int i3;
        int i4;
        Object useCase;
        int i2;
        int i;
        Object obj;
        float[] fArr;
        Object obj2 = f2Arr2Arr2;
        length = string3Arr3;
        i3 = 0;
        if (a.d(d.class)) {
            return i3;
        }
        n.f(a, "task");
        n.f(obj2, "denses");
        n.f(length, "texts");
        Object obj4 = d.a.get(a.toUseCase());
        useCase = (d.b)obj4.c();
        if (obj4 != null && useCase != null) {
            useCase = obj4.c();
            if (useCase != null) {
                float[] fArr3 = obj4.f();
                final int length3 = length.length;
                i2 = 0;
                int length4 = obj6.length;
                final int i9 = 2;
                int[] iArr2 = new int[i9];
                iArr2[i2] = length3;
                final int i10 = 1;
                iArr2[i10] = length4;
                a aVar2 = new a(iArr2);
                i = i2;
                while (i < length3) {
                    System.arraycopy(obj2[i], i2, aVar2.a(), i * length4, length4);
                    i++;
                    i3 = 0;
                }
                com.facebook.e0.w.a aVar = useCase.b(aVar2, length, a.toKey());
                if (aVar != null && fArr3 != null) {
                    if (fArr3 != null) {
                        length = fArr2.length == 0 ? i10 : i2;
                        if (length == 0) {
                            if (fArr3.length == 0) {
                                try {
                                    i2 = i10;
                                    if (i2 != 0) {
                                    } else {
                                    }
                                    int i6 = e.a[a.ordinal()];
                                    if (i6 != i10) {
                                    }
                                    if (i6 != i9) {
                                    } else {
                                    }
                                    i4 = d.d.p(aVar, fArr3);
                                    NoWhenBranchMatchedException noWhenBranchMatchedException = new NoWhenBranchMatchedException();
                                    throw noWhenBranchMatchedException;
                                    i4 = d.d.q(aVar, fArr3);
                                    i4 = 0;
                                    return i4;
                                    return i3;
                                    a.b(th, obj2);
                                    return null;
                                }
                            }
                        } else {
                        }
                    } else {
                    }
                } else {
                }
            }
        }
    }

    private final String[] p(com.facebook.e0.w.a a, float[] f2Arr2) {
        int i2;
        String str;
        int length;
        int i;
        int i3;
        int cmp;
        int i4;
        float f;
        final int i6 = 0;
        if (a.d(this)) {
            return i6;
        }
        int i5 = 0;
        int i9 = a.b(1);
        if (i9 != f2Arr2.length) {
            return i6;
        }
        kotlin.h0.f fVar = g.l(i5, a.b(i5));
        ArrayList arrayList = new ArrayList(p.r(fVar, 10));
        Iterator iterator = fVar.iterator();
        while (iterator.hasNext()) {
            str = "none";
            i3 = i;
            while (i < f2Arr2.length) {
                if (Float.compare(f, i11) >= 0) {
                }
                i++;
                i3 = i4;
                str = d.c.get(i3);
            }
            arrayList.add(str);
            if (Float.compare(f, i11) >= 0) {
            }
            i++;
            i3 = i4;
            str = d.c.get(i3);
        }
        Object[] obj14 = arrayList.toArray(new String[i5]);
        if (obj14 == null) {
        } else {
            return (String[])obj14;
        }
        obj14 = new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
        throw obj14;
    }

    private final String[] q(com.facebook.e0.w.a a, float[] f2Arr2) {
        int i4;
        String str;
        int length;
        int i2;
        int i3;
        int cmp;
        int i;
        float f;
        final int i6 = 0;
        if (a.d(this)) {
            return i6;
        }
        int i5 = 0;
        int i9 = a.b(1);
        if (i9 != f2Arr2.length) {
            return i6;
        }
        kotlin.h0.f fVar = g.l(i5, a.b(i5));
        ArrayList arrayList = new ArrayList(p.r(fVar, 10));
        Iterator iterator = fVar.iterator();
        while (iterator.hasNext()) {
            str = "other";
            i3 = i2;
            while (i2 < f2Arr2.length) {
                if (Float.compare(f, i11) >= 0) {
                }
                i2++;
                i3 = i;
                str = d.b.get(i3);
            }
            arrayList.add(str);
            if (Float.compare(f, i11) >= 0) {
            }
            i2++;
            i3 = i;
            str = d.b.get(i3);
        }
        Object[] obj14 = arrayList.toArray(new String[i5]);
        if (obj14 == null) {
        } else {
            return (String[])obj14;
        }
        obj14 = new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
        throw obj14;
    }
}
